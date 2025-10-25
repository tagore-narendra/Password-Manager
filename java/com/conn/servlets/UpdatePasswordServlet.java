package com.conn.servlets;

import java.io.IOException;
import java.sql.*;
import com.pm.utility.DBUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/UpdatePassword")
public class UpdatePasswordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user_id") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String id = request.getParameter("id");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String notes = request.getParameter("notes");
        int userId = (int) session.getAttribute("user_id");

        try (Connection conn = DBUtil.getConnection()) {
            String sql = "UPDATE passwords SET username=?, password=?, notes=? WHERE id=? AND user_id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, notes);
            ps.setInt(4, Integer.parseInt(id));
            ps.setInt(5, userId);
            ps.executeUpdate();
            response.sendRedirect("ViewPassword?id=" + id); // reload page
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Update failed.");
        }
    }
}

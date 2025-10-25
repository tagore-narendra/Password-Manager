package com.conn.servlets;

import java.io.IOException;
import java.sql.*;
import com.pm.utility.DBUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/DeletePassword")
public class DeletePasswordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user_id") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String id = request.getParameter("id");
        int userId = (int) session.getAttribute("user_id");

        try (Connection conn = DBUtil.getConnection()) {
            String sql = "DELETE FROM passwords WHERE id=? AND user_id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(id));
            ps.setInt(2, userId);
            ps.executeUpdate();
            response.sendRedirect("YourPasswords"); // go back to list
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Delete failed.");
        }
    }
}

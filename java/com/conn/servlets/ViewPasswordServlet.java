package com.conn.servlets;

import java.io.IOException;
import java.sql.*;
import com.pm.utility.DBUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/ViewPassword")
public class ViewPasswordServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user_id") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String id = request.getParameter("id");
        int userId = (int) session.getAttribute("user_id");

        try (Connection conn = DBUtil.getConnection()) {
            String sql = "SELECT * FROM passwords WHERE id = ? AND user_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(id));
            ps.setInt(2, userId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                request.setAttribute("accountName", rs.getString("account_name"));
                request.setAttribute("username", rs.getString("username"));
                request.setAttribute("password", rs.getString("password"));
                request.setAttribute("notes", rs.getString("notes"));
                request.getRequestDispatcher("view_password.jsp").forward(request, response);
            } else {
                response.getWriter().println("Password not found or access denied.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

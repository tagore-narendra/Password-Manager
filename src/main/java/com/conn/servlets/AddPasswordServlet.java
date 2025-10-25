package com.conn.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.pm.utility.DBUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/savePassword")
public class AddPasswordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        HttpSession session = request.getSession();
        Integer userId = (Integer) session.getAttribute("user_id");

        if (userId == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String account = request.getParameter("account_name");
        String accountUser = request.getParameter("account_user");
        String accountPass = request.getParameter("account_pass");
        String notes = request.getParameter("notes");

        try (Connection conn = DBUtil.getConnection()) {
            String sql = "INSERT INTO passwords (user_id, account_name, username, password, notes) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, userId);
            ps.setString(2, account);
            ps.setString(3, accountUser);
            ps.setString(4, accountPass);
            ps.setString(5, notes);
            ps.executeUpdate();

            response.getWriter().println("Password saved successfully.");
            response.sendRedirect("YourPasswords");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


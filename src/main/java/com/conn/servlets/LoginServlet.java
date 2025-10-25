package com.conn.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pm.utility.DBUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		try (Connection conn = DBUtil.getConnection()) {
			String sql = "SELECT * FROM users WHERE email = ? AND password_hash = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password); // TODO: Compare hashed password
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				
				HttpSession session = request.getSession();
				session.setAttribute("user_id", rs.getInt("user_id"));
				session.setAttribute("user", rs.getString("username"));
				response.sendRedirect("YourPasswords");

			} else {
				request.setAttribute("errorMessage", "Invalid login credentials");
				request.getRequestDispatcher("login.jsp").forward(request, response);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}



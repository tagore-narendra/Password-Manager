package com.conn.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.pm.utility.DBUtil;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterValidation extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		
		String username = req.getParameter("username");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String repassword = req.getParameter("repassword");
		PreparedStatement pstmt = null;
		if(password.equals(repassword) ) {
			
			try(Connection con = DBUtil.getConnection()) {
				String query = "insert into users(username,email,password_hash) values(?,?,?)";
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, username);
				pstmt.setString(2, email);
				pstmt.setString(3, password);
				if(pstmt.executeUpdate()==1) {
										RequestDispatcher rd = req.getRequestDispatcher("/sreg.jsp");
					rd.forward(req, resp);
				}
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		else {
			
			req.setAttribute("errorMessage", "❌ Password and Repeat Password do not match");
	        req.getRequestDispatcher("register.jsp").forward(req, resp);
			
			
			
		}
		
		
		
		
		
		
		
	}


}

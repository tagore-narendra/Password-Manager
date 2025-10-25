package com.conn.servlets;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/checkStrength")
public class PasswordStrengthServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {

	    String password = request.getParameter("password");
	    String strength = "Weak";

	    if (password != null && !password.isEmpty()) {
	        int score = 0;
	        if (password.length() >= 8) score++;
	        if (password.matches(".*[A-Z].*")) score++;
	        if (password.matches(".*[a-z].*")) score++;
	        if (password.matches(".*\\d.*")) score++;
	        if (password.matches(".*[^A-Za-z0-9].*")) score++;

	        if (score <= 2) {
	            strength = "Weak";
	        } else if (score <= 4) {
	            strength = "Medium";
	        } else {
	            strength = "Strong";
	        }
	    }
	    
	    request.setAttribute("strength", strength);
	    request.setAttribute("password", password);

	    RequestDispatcher dispatcher = request.getRequestDispatcher("passwordStrength.jsp");
	    dispatcher.forward(request, response);
	}

}


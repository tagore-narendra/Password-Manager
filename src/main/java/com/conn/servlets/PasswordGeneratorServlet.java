package com.conn.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Random;

@WebServlet("/generatePassword")
public class PasswordGeneratorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int length = Integer.parseInt(request.getParameter("length"));
        boolean includeUpper = request.getParameter("includeUpper") != null;
        boolean includeLower = request.getParameter("includeLower") != null;
        boolean includeNumbers = request.getParameter("includeNumbers") != null;
        boolean includeSymbols = request.getParameter("includeSymbols") != null;

        String chars = "";
        if (includeUpper) chars += "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        if (includeLower) chars += "abcdefghijklmnopqrstuvwxyz";
        if (includeNumbers) chars += "0123456789";
        if (includeSymbols) chars += "!@#$%^&*()_+[]{}|;:,.<>?";

        String password = "";
        if (!chars.isEmpty()) {
            Random rnd = new Random();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < length; i++) {
                sb.append(chars.charAt(rnd.nextInt(chars.length())));
            }
            password = sb.toString();
        } else {
            password = "Please select at least one character type.";
        }

        request.setAttribute("generatedPassword", password);
        request.getRequestDispatcher("password_generator.jsp").forward(request, response);
    }
}


package com.conn.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.pm.utility.DBUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/YourPasswords")
public class YourPasswordsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user_id") == null) {
            // user not logged in
            response.sendRedirect("login.jsp");
            return;
        }
        
        int userId = (int) session.getAttribute("user_id");
        List<String[]> passwordList = new ArrayList<>();
        
        try (Connection conn = DBUtil.getConnection()) {
            String sql = "SELECT * FROM passwords WHERE user_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                passwordList.add(new String[] {
                    rs.getString("id"),
                    rs.getString("account_name"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("notes")
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("passwordList", passwordList);
        request.getRequestDispatcher("your_passwords.jsp").forward(request, response);
    }
}

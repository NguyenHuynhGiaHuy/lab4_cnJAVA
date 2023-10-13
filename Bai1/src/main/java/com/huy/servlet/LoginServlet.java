package com.huy.servlet;

import java.io.IOException;
import java.util.HashMap;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    
    private HashMap<String, String> accounts;

    @Override
    public void init() throws ServletException {
        System.out.println("SERVLET STARTING->>>>>>>>>");
        this.accounts = new HashMap<String, String>();
        this.accounts.put("huy", "123456");        
        this.accounts.put("huy1", "654321");

    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            response.sendRedirect("index.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        response.setContentType("text/html");

        try {
            if(isValidAccount(username, password)) {
                response.getWriter().println("<h1>Name/Password match</h1>");
            } else {
                response.getWriter().println("<h1>Name/Password does not match</h1>");
            }
        } catch (Exception e) {
          
        }
    }

    private boolean isValidAccount(String username, String password) {
        if(this.accounts.containsKey(username)) {
            return this.accounts.get(username).equals(password);
        }

        return false;
    }
    
}

package com.example.servlet;

import com.example.util.EncryptDecryptUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/encrypt")
public class EncryptionServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = request.getParameter("message");
        try {
            String encryptedMessage = EncryptDecryptUtil.encrypt(message);
            response.setContentType("text/plain");
            response.getWriter().write("Encrypted Message: " + encryptedMessage);
        } catch (Exception e) {
            response.getWriter().write("Error: " + e.getMessage());
        }
    }
}

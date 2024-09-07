package com.example.servlet;

import com.example.util.EncryptDecryptUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/decrypt")
public class DecryptionServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String encryptedMessage = request.getParameter("encryptedMessage");
        try {
            String decryptedMessage = EncryptDecryptUtil.decrypt(encryptedMessage);
            response.setContentType("text/plain");
            response.getWriter().write("Decrypted Message: " + decryptedMessage);
        } catch (Exception e) {
            response.getWriter().write("Error: " + e.getMessage());
        }
    }
}

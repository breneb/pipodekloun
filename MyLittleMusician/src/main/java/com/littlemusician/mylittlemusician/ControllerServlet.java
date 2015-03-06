/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.littlemusician.mylittlemusician;

import com.littlemusician.database.Account;
import com.littlemusician.database.AccountManager;
import com.littlemusician.database.Login;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author tni20865
 */
@WebServlet(name = "ControllerServlet", loadOnStartup = 1, urlPatterns = {
    "/index",
    "/musician",
    "/login",
    "/registration",
    "/signup"
})
public class ControllerServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    HttpSession session;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userPath = request.getServletPath();

        if (userPath.equals("/index")) {
            userPath = "/index";
        }
        if (userPath.equals("/login")) {

            String username = request.getParameter("username");
            String password = request.getParameter("password");

            AccountManager manager = new AccountManager();
            if (manager.isValidLogin(username, password)) {

                Login login = manager.getId(username);
                session = request.getSession();
                session.setAttribute("username", login.getUsername());
                session.setAttribute("id", login.getId());

                Account musician = manager.getAccountData((int) session.getAttribute("id"));
                getServletContext().setAttribute("musician", musician);
                userPath = "/musician";
            } else {
                userPath = "/index";
            }
        }
        if (userPath.equals("/signup")) {
            userPath = "/signup";
        }
        if (userPath.equals("/registration")) {
            String username = request.getParameter("username");
            String password1 = request.getParameter("password1");
            String password2 = request.getParameter("password2");
            if (password1.equals(password2)) {
                AccountManager manager = new AccountManager();
                if (manager.isValidUsername(username)) {
                    manager.userInsert(username, password1);
                    HttpSession session = request.getSession();
                    session.setAttribute("username", username);
                    session.setAttribute("success", username + " successfully registered!");
                    userPath = "/createaccount";
                } else {
                    request.setAttribute("success", "Username already in use. Choose another one!");
                    userPath = "/index";
                }
            } else {
                request.setAttribute("success", "Retype password again!");
                request.setAttribute("usernamereg", username);
                request.setAttribute("password1", password1);
                userPath = "/index";
            }
        }
        if (userPath.equals("/accountinformation")) {
            HttpSession session = request.getSession();
            String username = session.getAttribute("username").toString();
            
            AccountManager manager = new AccountManager();
            manager.insertAccountInformation(manager.getId(username).getId(), request.getParameter("email"), request.getParameter("profile"));
            userPath = "/musician";
        }

        String url = "WEB-INF/view" + userPath + ".jsp";

        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

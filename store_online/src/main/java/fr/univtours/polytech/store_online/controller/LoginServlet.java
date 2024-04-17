package fr.univtours.polytech.store_online.controller;

import java.io.IOException;

import fr.univtours.polytech.store_online.business.UserBusiness;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    @Inject
    private UserBusiness userBusiness;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Récupére les données du formulaire
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (userBusiness.checkUser(username, password)) {

            request.getSession().setAttribute("currentUser", username);

            response.sendRedirect("articles");
        } else {

            request.setAttribute("errorMessage", "Le nom d'utilisateur ou le mot de passe saisi n'est pas valide.");

            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

}

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
        // Récupérer les données du formulaire
        String username = request.getParameter("username");
        String password = request.getParameter("password");
    
        if (userBusiness.checkUser(username, password)) {
            // Si bon mot de passe et nom d'utilisateur alors rediriger vers la page de la liste des articles
            response.sendRedirect("articles");
        } else {
            // Sinon afficher le message d'erreur en rouge "Le nom d'utilisateur ou le mot de passe saisi n'est pas valide."
            request.setAttribute("errorMessage", "Le nom d'utilisateur ou le mot de passe saisi n'est pas valide.");
            // Rediriger vers la page JSP pour afficher le message d'erreur
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
    
}

package fr.univtours.polytech.store_online.controller;

import java.io.IOException;

import fr.univtours.polytech.store_online.model.Userbean;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupérer les données du formulaire
        String username = request.getParameter("username");
        String password = request.getParameter("password");
    
        
        // Créer un bean de user
        Userbean userbean = new Userbean();
        userbean.setLogin(username);
        userbean.setLogin(password);
        
        
        
        // Si bon mot de passe et nom d'utilisateur alors rediriger vers la page de la lsite des articles
        response.sendRedirect("articles");

        //Sinon afficher le message d'erreur en rouge "Le nom d'utilisateur ou le mot de passe saisit n'est pas valide."

    }
}

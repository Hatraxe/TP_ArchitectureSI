package fr.univtours.polytech.store_online.controller;

import java.io.IOException;

import fr.univtours.polytech.store_online.business.ArticleBusiness;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "ShowArticlesListServlet", urlPatterns = "/articles")
public class ShowArticlesListServlet extends HttpServlet {
    @Inject
    private ArticleBusiness articleBusiness;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("ARTICLE_LIST", this.articleBusiness.getAllArticles());
        request.getRequestDispatcher("articlesList.jsp").forward(request, response);
    }
    

}

package fr.univtours.polytech.store_online.controller;

import java.io.IOException;

import fr.univtours.polytech.store_online.business.ArticleBusiness;
import fr.univtours.polytech.store_online.model.CartBean;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "ShowArticlesListServlet", urlPatterns = "/articles")
public class ShowArticlesListServlet extends HttpServlet {
    @Inject
    private ArticleBusiness articleBusiness;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        CartBean cart = (CartBean) session.getAttribute("cart");
        if (cart == null) {
            cart = new CartBean();
            session.setAttribute("cart", cart);
        }
        request.setAttribute("ARTICLE_LIST", articleBusiness.getAllArticles());
        request.setAttribute("cart", cart);
        request.getRequestDispatcher("articlesList.jsp").forward(request, response);
    }
    

}

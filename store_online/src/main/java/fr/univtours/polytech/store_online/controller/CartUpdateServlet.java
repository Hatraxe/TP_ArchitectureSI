package fr.univtours.polytech.store_online.controller;

import java.io.IOException;

import fr.univtours.polytech.store_online.business.ArticleBusiness;
import fr.univtours.polytech.store_online.model.ArticleBean;
import fr.univtours.polytech.store_online.model.CartBean;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "CartUpdateServlet", urlPatterns = "/updateCart")
public class CartUpdateServlet extends HttpServlet {
    @Inject
    private ArticleBusiness articleBusiness;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        CartBean cart = (CartBean) session.getAttribute("cart");
        if (cart == null) {
            cart = new CartBean();
            session.setAttribute("cart", cart);
        }

        int articleId = Integer.parseInt(request.getParameter("articleId"));
        String action = request.getParameter("action");
        ArticleBean article = articleBusiness.getArticleById(articleId);

        if (action != null && article != null) {
            switch (action) {
                case "add":
                    if (article.getNbRestant() > 0) {
                        cart.addItem(article, 1);
                        article.setNbRestant(article.getNbRestant() - 1);
                        articleBusiness.updateArticle(article);  // Assuming a method to update article in DB
                    }
                    break;
                case "remove":
                    if (cart.getItems().stream().anyMatch(item -> item.getArticle().getId().equals(article.getId()) && item.getQuantity() > 0)) {
                        cart.removeItem(article, 1);
                        article.setNbRestant(article.getNbRestant() + 1);
                        articleBusiness.updateArticle(article);  // Assuming a method to update article in DB
                    }
                    break;
            }
        }

        response.sendRedirect("articles");
    }
}

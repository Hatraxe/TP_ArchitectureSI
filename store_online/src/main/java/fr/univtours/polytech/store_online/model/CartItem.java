package fr.univtours.polytech.store_online.model;

import java.io.Serializable;

public class CartItem implements Serializable {
    private ArticleBean article;
    private int quantity;

    public CartItem(ArticleBean article, int quantity) {
        this.article = article;
        this.quantity = quantity;
    }

    public ArticleBean getArticle() {
        return article;
    }

    public void setArticle(ArticleBean article) {
        this.article = article;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

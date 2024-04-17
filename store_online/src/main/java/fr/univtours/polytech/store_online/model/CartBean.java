package fr.univtours.polytech.store_online.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CartBean implements Serializable {
    private List<CartItem> items;

    public CartBean() {
        this.items = new ArrayList<>();
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void addItem(ArticleBean article, int quantity) {
        for (CartItem item : items) {
            if (item.getArticle().getId().equals(article.getId())) {
                item.setQuantity(item.getQuantity() + quantity);
                return;
            }
        }
        items.add(new CartItem(article, quantity));
    }

    public void removeItem(ArticleBean article, int quantity) {
        for (CartItem item : items) {
            if (item.getArticle().getId().equals(article.getId())) {
                int newQuantity = item.getQuantity() - quantity;
                if (newQuantity > 0) {
                    item.setQuantity(newQuantity);
                } else {
                    items.remove(item);
                }
                return;
            }
        }
    }

    public static class CartItem implements Serializable {
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
}

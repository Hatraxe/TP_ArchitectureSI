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

    // Method to add an item to the cart
    public void addItem(ArticleBean article, int quantity) {
        for (CartItem item : items) {
            if (item.getArticle().getId().equals(article.getId())) {
                item.setQuantity(item.getQuantity() + quantity);
                return;
            }
        }
        items.add(new CartItem(article, quantity));
    }

    // Method to remove an item from the cart
    public void removeItem(ArticleBean article, int quantity) {
        items.removeIf(item -> item.getArticle().getId().equals(article.getId()) && (item.getQuantity() - quantity) <= 0);
        items.forEach(item -> {
            if (item.getArticle().getId().equals(article.getId())) {
                item.setQuantity(item.getQuantity() - quantity);
            }
        });
    }

    // Method to get the quantity of a specific article in the cart
    public int getItemQuantity(Integer articleId) {
        return items.stream()
                    .filter(item -> item.getArticle().getId().equals(articleId))
                    .findFirst()
                    .map(CartItem::getQuantity)
                    .orElse(0);
    }
}

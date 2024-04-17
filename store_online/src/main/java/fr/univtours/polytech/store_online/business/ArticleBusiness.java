package fr.univtours.polytech.store_online.business;

import java.util.List;

import fr.univtours.polytech.store_online.model.ArticleBean;

public interface ArticleBusiness {
    public List<ArticleBean> getAllArticles();

    public ArticleBean getArticleById(int articleId);

    public void updateArticle(ArticleBean article);
}

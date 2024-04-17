package fr.univtours.polytech.store_online.business;

import java.util.List;

import fr.univtours.polytech.store_online.dao.ArticleDAO;
import fr.univtours.polytech.store_online.model.ArticleBean;
import jakarta.inject.Inject;

public class ArticleBusinessImpl implements ArticleBusiness{

    @Inject
    private ArticleDAO articleDAO;

    @Override
    public List<ArticleBean> getAllArticles() {
        List<ArticleBean> articles = articleDAO.getAllArticles();
        return articles;
    }

    @Override
    public ArticleBean getArticleById(int articleId) {
        return articleDAO.findArticleById(articleId);
    }

    public void updateArticle(ArticleBean article) {
        articleDAO.update(article);
    }

}

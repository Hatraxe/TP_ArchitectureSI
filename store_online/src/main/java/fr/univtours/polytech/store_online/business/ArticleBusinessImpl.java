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
    public ArticleBean getArticlebyId(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ArticleBean getArticlebyName(String name) {
        // TODO Auto-generated method stub
        return null;
    }

}

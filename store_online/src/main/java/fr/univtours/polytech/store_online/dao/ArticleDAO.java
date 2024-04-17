package fr.univtours.polytech.store_online.dao;

import java.util.List;

import fr.univtours.polytech.store_online.model.ArticleBean;

public interface ArticleDAO {
    public List<ArticleBean> getAllArticles();

    public ArticleBean getArticlebyId(Integer id);
    public ArticleBean getArticlebyName(String name);
}

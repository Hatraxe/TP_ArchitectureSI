package fr.univtours.polytech.store_online.dao;

import java.util.List;

import fr.univtours.polytech.store_online.model.ArticleBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

@Stateless
public class ArticleDAOImplJPA implements ArticleDAO {

    // L'objet EntityManager qui va permettre d'effectuer les requêtes en BDD.
    @PersistenceContext(unitName = "StoreOnlinePU")
    private EntityManager em;

    @SuppressWarnings("unchecked") // Pour éviter les warnings de cast
    @Override
    public List<ArticleBean> getAllArticles() {
        TypedQuery<ArticleBean> query = em.createQuery("SELECT a FROM ArticleBean a", ArticleBean.class);
        return query.getResultList();
    }

    @Override
    public ArticleBean getArticlebyId(Integer id) {
        return em.find(ArticleBean.class, id);
    }

    @Override
    public ArticleBean getArticlebyName(String name) {
        Query requete = em.createNativeQuery("SELECT * FROM ARTICLE WHERE NAME = ?", ArticleBean.class);
        requete.setParameter(1, name);
        return (ArticleBean) requete.getSingleResult();
    }

    @Override
    public ArticleBean findArticleById(int articleId) {
        return em.find(ArticleBean.class, articleId);
    }

    @Override
    public void update(ArticleBean article) {
        em.merge(article);
    }

}

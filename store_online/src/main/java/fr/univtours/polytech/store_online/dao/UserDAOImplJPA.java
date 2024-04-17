package fr.univtours.polytech.store_online.dao;

import java.util.List;

import fr.univtours.polytech.store_online.model.Userbean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class UserDAOImplJPA implements UserDAO{

    // L'objet EntityManager qui va permettre d'effectuer les requêtes en BDD.
    @PersistenceContext(unitName = "StoreOnlinePU")
    private EntityManager em;

    @SuppressWarnings("unchecked") // Pour éviter les warnings de cast
    @Override
    public List<Userbean> getAllUsers() {
        Query requete = em.createNativeQuery("SELECT * FROM USER", Userbean.class);
        return requete.getResultList();
    }

    @Override
    public Userbean getUser(String login) {
        return em.find(Userbean.class, login);
    }
}

package fr.univtours.polytech.store_online.business;

import fr.univtours.polytech.store_online.dao.UserDAO;
import fr.univtours.polytech.store_online.model.Userbean;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class userBusinessImpl implements UserBusiness {
    @Inject
    private UserDAO userDAO;

    @Override
    public boolean checkUser(String login, String password) {
        // Récupérer l'utilisateur depuis la base de données en fonction du login
        Userbean user = userDAO.getUser(login);
        
        // Vérifier si l'utilisateur existe et si le mot de passe correspond
        if (user != null && user.getPassword().equals(password)) {
            return true; // Le nom d'utilisateur et le mot de passe de l'utilisateur sont corrects
        } else {
            return false; 
        }
    }
}

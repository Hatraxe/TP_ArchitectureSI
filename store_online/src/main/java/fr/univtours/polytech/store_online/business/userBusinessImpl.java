package fr.univtours.polytech.store_online.business;

import fr.univtours.polytech.store_online.dao.UserDAO;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class userBusinessImpl implements UserBusiness {
    @Inject
    private UserDAO userDAO;

    @Override
    public boolean checkUser(String username, String password) {
        return userDAO.checkUserCredentials(username, password);
    }
}

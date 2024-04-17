package fr.univtours.polytech.store_online.dao;

import java.util.List;

import fr.univtours.polytech.store_online.model.Userbean;

public interface UserDAO {
    public boolean checkUserCredentials(String username, String password);

    public List<Userbean> getAllUsers();

    public Userbean getUser(String login);

}

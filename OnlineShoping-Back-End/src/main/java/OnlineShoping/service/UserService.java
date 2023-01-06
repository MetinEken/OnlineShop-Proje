package OnlineShoping.service;

import OnlineShoping.dao.UserDAO;
import OnlineShoping.model.User;

import java.util.List;

public interface UserService {

    UserDAO getUserDAO(User user);
    UserDAO getUserDAOByName(String username);
    List<UserDAO> getAllUsers();



}

package OnlineShoping.service;

import OnlineShoping.dao.UserDAO;
import OnlineShoping.model.Products;
import OnlineShoping.model.User;

import java.util.List;

public interface ProductsService {



    UserDAO getUserDAO(User user);
    UserDAO getUserDAOByName(String username);
    List<UserDAO> getAllUsers();
}

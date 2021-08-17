package repositories.interfaces;

import entities.Book;
import entities.User;

import java.sql.Date;
import java.util.List;

public interface IUserRepository {
    boolean createUser(User user);
    User getUsername(String username);
    Book searchByName(int userId, String name);
    Book searchById(int userId, int id);
    boolean addBook(Book book);
    boolean removeBook(int userId, int id);
}

package controllers;

import entities.Book;
import entities.User;
import repositories.interfaces.IUserRepository;

public class UserController {
    private final IUserRepository repo;

    public UserController(IUserRepository repo) {
        this.repo = repo;
    }

    public String createUser(String username, String password) {
        User user = new User(username, password);

        boolean created = repo.createUser(user);

        return (created ? "User was created!" : "User creation was failed!");
    }

    public String getUserName(String username, String password) {
        User user = repo.getUsername(username);

        if (user == null) {
            return "User was not found!";
        }
        if (!password.equals(user.getPassword())) {
            return "Password is incorrect!";
        }
        return null;
    }

    public String searchByName(String username, String name){
        User user = repo.getUsername(username);
        Book book = repo.searchByName(user.getId(), name);
        return (book == null ? "Book was not found!" : book.toString());
    }

    public String searchById(String username, int id){
        User user = repo.getUsername(username);
        Book book = repo.searchById(user.getId(), id);
        return (book == null ? "Book was not found!" : book.toString());
    }

    public String addBook(String name, String author, String username){
        User user = repo.getUsername(username);
        Book book = new Book(name, author, user.getId());
        boolean added = repo.addBook(book);
        return (added ? "Book was added!" : "Book adding was failed!");
    }

    public String removeBook(String username, int id){
        User user = repo.getUsername(username);
        boolean removed = repo.removeBook(user.getId(), id);
        return (removed ? "Book was removed!" : "Book removing was failed!");
    }


}

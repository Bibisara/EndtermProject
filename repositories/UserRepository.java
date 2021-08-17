package repositories;

import data.interfaces.IDB;
import entities.Book;
import entities.User;
import repositories.interfaces.IUserRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository implements IUserRepository {
    private final IDB db;

    public UserRepository(IDB db) {
        this.db = db;
    }

    @Override
    public boolean createUser(User user) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO users(username, password) VALUES (?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, user.getUsername());
            st.setString(2, user.getPassword());

            st.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public User getUsername(String username) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,username,password FROM users WHERE username=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, username);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                User user = new User(rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"));
                return user;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public Book searchByName(int userId, String name){
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT book.id, book.name, book.author, book.user_id FROM book FULL OUTER JOIN users ON users.id = ? WHERE name = ?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, userId);
            st.setString(2, name);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Book book = new Book(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("author"),
                        rs.getInt("user_id"));
                return book;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public Book searchById(int userId, int id){
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT book.id, book.name, book.author, book.user_id FROM book FULL OUTER JOIN users ON users.id = ? WHERE book.id = ?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, userId);
            st.setInt(2, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Book book = new Book(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("author"),
                        rs.getInt("user_id"));
                return book;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public boolean addBook(Book book) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO book(name, author, user_id) VALUES (?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, book.getName());
            st.setString(2, book.getAuthor());
            st.setInt(3, book.getUserId());

            st.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean removeBook(int userId, int id){
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "DELETE FROM book WHERE id = ? AND user_id = ?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);
            st.setInt(2, userId);

            st.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }


}

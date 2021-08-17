package entities;

public class Book {
    private int id;
    private String name;
    private String author;
    private int userId;

    public Book(){

    }

    public Book(String name, String author, int userId){
        setName(name);
        setAuthor(author);
        setUserId(userId);
    }

    public Book(int id, String name, String author, int userId){
        setId(id);
        setName(name);
        setAuthor(author);
        setUserId(userId);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString(){
        return "Book{ id: " + id
                + "; name: " + name
                + "; author: " + author
                + "; user id: " + userId
                + " }";
    }
}

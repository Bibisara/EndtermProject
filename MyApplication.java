import controllers.UserController;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MyApplication {
    private final UserController controller;
    private final Scanner scanner;

    public MyApplication(UserController controller) {
        this.controller = controller;
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println();
            System.out.println("Welcome to My Application");
            System.out.println("Select option:");
            System.out.println("1. Log in");
            System.out.println("2. Sign in");
            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.print("Enter option (1-2): ");
                int option = scanner.nextInt();
                if (option == 1) {
                    LogIn();
                } else if (option == 2) {
                    createUserMenu();
                } else {
                    break;
                }
            } catch (InputMismatchException _) {
                System.out.println("Input must be integer");
                scanner.nextLine(); // to ignore incorrect input
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println("*************************");

        }
    }

    public void LogIn() {
        System.out.println("Please enter username");
        String username = scanner.next();
        System.out.println("Please enter password");
        String password = scanner.next();

        while(true){
            String response = controller.getUserName(username, password);
            if (response == "User was not found!") System.out.println(response);
            else if (response == "Password is incorrect!") System.out.println(response);
            else break;
        }
        while (true){
            System.out.println();
            System.out.println("Select option:");
            System.out.println("1. Search for any book by name");
            System.out.println("2. Get book by id");
            System.out.println("3. Add book to DB");
            System.out.println("4. Remove book by id");
            System.out.println("0. Log out");
            System.out.println();
            try {
                System.out.print("Enter option (1-4): ");
                int option = scanner.nextInt();
                if (option == 1) {
                    SearchBookByName(username);
                } else if (option == 2) {
                    getBookByIdMenu(username);
                } else if (option == 3) {
                    addBookToDB(username);
                } else if (option == 4) {
                    removeBookById(username);
                } else {
                    break;
                }
            } catch (InputMismatchException _) {
                System.out.println("Input must be integer");
                scanner.nextLine(); // to ignore incorrect input
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println("*************************");
        }
    }

    public void SearchBookByName(String username){
        System.out.println("Please enter name of book");
        String name = scanner.next();
        String response = controller.searchByName(username, name);
        System.out.println(response);
    }

    public void getBookByIdMenu(String username){
        System.out.println("Please enter id of book");
        int id = scanner.nextInt();
        String response = controller.searchById(username, id);
        System.out.println(response);
    }

    public void addBookToDB(String username) {
        System.out.println("Please enter name of book");
        String name = scanner.next();
        System.out.println("Please enter author of book");
        String author = scanner.next();
        String response = controller.addBook(name, author, username);
        System.out.println(response);
    }

    public void removeBookById(String username){
        System.out.println("Please enter id of book");
        int id = scanner.nextInt();
        String response = controller.removeBook(username, id);
        System.out.println(response);
    }

    public void createUserMenu() {
        System.out.println("Please enter username");
        String username = scanner.next();
        System.out.println("Please enter password");
        String password = scanner.next();

        String response = controller.createUser(username, password);
        System.out.println(response);
    }
}

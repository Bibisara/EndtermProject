import controllers.UserController;
import data.DBconnection;
import data.interfaces.IDB;
import repositories.UserRepository;
import repositories.interfaces.IUserRepository;

public class Main {

    public static void main(String[] args) {

        IDB db = new DBconnection();
        IUserRepository repo = new UserRepository(db);
        UserController controller = new UserController(repo);
        MyApplication app = new MyApplication(controller);
        app.start();

    }
}

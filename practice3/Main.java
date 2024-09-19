import java.util.ArrayList;

class User {
    String name;
    String email;
    String role;
    User(String name, String email, String role) {
        this.name = name;
        this.email = email;
        this.role = role;
    }
    void Info() {
        System.out.println("User's info:\n name " + this.name + "\n email " + this.email + "\n role " + this.role);
    }
}
class UserManager {
    ArrayList<User> users;
    UserManager() {
        users = new ArrayList<>();
    }
    String AddUser(User user) {
        users.add(user);
        return "User added succesfully";
    }
    String RemoveUser(User user) {
        users.remove(user);
        return "User removed successfully";
    }
    void UpdateUser(User user, User newUser) {
        if (!users.contains(user)) {
            System.out.println("Cannot found user");
            return;
        }
        users.set(users.indexOf(user), newUser);
        System.out.println("User updated");
    }
}

public class Main {
    public static void main(String[] args) {
        User user1 = new User("name1", "test1@mail.ru", "default");
        User user2 = new User("name2", "test2@mail.ru", "admin");
        User newUser = new User("new name", "newTest", "admin");
        UserManager userManager = new UserManager();
        userManager.AddUser(user1);
        for (int i = 0; i < userManager.users.size(); i++) {
            userManager.users.get(i).Info();
        }
        userManager.AddUser(user2);
        userManager.RemoveUser(user2);
        userManager.UpdateUser(user1, newUser);
    }
}
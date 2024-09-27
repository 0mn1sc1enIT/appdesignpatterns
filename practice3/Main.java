import model.*;
public class Main {
    public static void main(String[] args) {
        User user1 = new User("user", "test1@mail.ru", "default");
        User user2 = new User("admin", "test2@mail.ru", "admin");
        User newUser = new User("player", "newTest@gmail.com", "user");
        UserManager userManager = new UserManager();
        userManager.AddUser(user1);
        userManager.AddUser(user2);

        for (int i = 0; i < userManager.getUsers().size(); i++) {
            userManager.getUsers().get(i).Info();
        }
        if (userManager.RemoveUser(user2)) {
            System.out.println("User deleted successfully");
        } else {
            System.out.println("User not found");
        }
        for (int i = 0; i < userManager.getUsers().size(); i++) {
            userManager.getUsers().get(i).Info();
        }
        if (userManager.UpdateUser(user1, newUser)) {
            System.out.println("User updated successfully");
        } else {
            System.out.println("User not found");
        }
        for (int i = 0; i < userManager.getUsers().size(); i++) {
            userManager.getUsers().get(i).Info();
        }
    }
}
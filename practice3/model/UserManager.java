package model;

import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private List<User> users;

    public UserManager() {
        this.users = new ArrayList<>();
    }

    public void AddUser(User user) {
        users.add(user);
    }

    public boolean RemoveUser(User user) {
        return users.remove(user);
    }

    public boolean UpdateUser(User user, User newUser) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).equals(user)) {
                users.set(i, newUser);
                return true;
            }
        }
        return false;
    }


    public List<User> getUsers() {
        return users;
    }
}


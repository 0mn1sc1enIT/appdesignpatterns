package model;

public class User {
    private String name;
    private String email;
    private String role;
    public User(String name, String email, String role) {
        this.name = name;
        this.email = email;
        this.role = role;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void Info() {
        System.out.println("User's info:\n name " + this.name + "\n email " + this.email + "\n role " + this.role);
    }
}
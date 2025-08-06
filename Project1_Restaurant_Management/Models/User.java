package Project1_Restaurant_Management.Models;

import Project1_Restaurant_Management.Services.Interfaces.UserService;

public abstract class User implements UserService {
    private String username;
    private String password;
    private String userType;

    public boolean login(String username, String password){
        return (password.equals(this.password) && username.equals(this.password));
    }

    public boolean checkPassword(String password){
        return password.equals(this.password);
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getUserType() {
        return userType;
    }
}

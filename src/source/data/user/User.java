package source.data.user;

public class User {
    private String userID;
    private String username;
    private UserRole userRole;
    private boolean authenticated;

    public User(String userID, String username, UserRole userRole) {
        this.userID = userID;
        this.username = username;
        this.userRole = userRole;
        this.authenticated = false;
    }

    public String getUserID() {return userID;}
    public void setUserID(String userID) {this.userID = userID;}
    public String getUsername() {return username;}
    public void setUsername(String username) {this.username = username;}
    public UserRole getUserRole() {return userRole;}
    public void setUserRole(UserRole userRole) {this.userRole = userRole;}
    public boolean isAuthenticated() {return authenticated;}
    public void setAuthenticated(boolean authenticated) {this.authenticated = authenticated;}

    public void login(String userID, String username) {
        if (userID.equals(this.userID) && username.equals(this.username)) {
            setAuthenticated(true);
        } else {
            setAuthenticated(false);
        }
    }

    public void logout() {setAuthenticated(false);}

    @Override
    public String toString() {
        return "User [userID=" + userID
                + ", username=" + username
                + ", role=" + userRole
                + ", is auth=" + authenticated + "]";
    }
}

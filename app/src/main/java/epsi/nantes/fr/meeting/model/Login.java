package epsi.nantes.fr.meeting.model;

/**
 * Created by Thibault on 25/11/2015.
 */
public class Login {

    private String email;
    private String password;

    public Login() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
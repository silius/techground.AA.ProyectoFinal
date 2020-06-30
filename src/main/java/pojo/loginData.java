package pojo;

public class loginData {
    private String email;
    private String password;

    public loginData(String _email,String _password) {
        this.email = _email;
        this.password = _password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}

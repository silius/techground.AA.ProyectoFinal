package pojo;

import java.util.Random;

public class userRegister {
    private String first_name;
    private String last_name;
    private String password;
    private String telephone;

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getPassword() {
        return password;
    }

    public String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 5) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }


    public userRegister(String first_name, String last_name, String telephone, String password) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.telephone = telephone;
        this.password = password;
    }
}

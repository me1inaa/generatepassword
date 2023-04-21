package edu.guilford;


public class User {
    private String name;
    private String username;
    private String color;
    private String birthMonth;
    private String password = "";
    private String key = "";

    //create a constructor that takes in the user's name, username, favorite color, and birth month
    public User(String name, String username, String color, String birthMonth, String key) {
        this.name = name;
        this.username = username;
        this.color = color;
        this.birthMonth = birthMonth;
        this.key = key;
    }

    //create getters and setters for each of the fields
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(String birthMonth) {
        this.birthMonth = birthMonth;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }


    public static void main(String[] args) {
    }
    
    //generate password method
    public void generatePassword() {
    password += name.substring(0, 3).toUpperCase();
    password += birthMonth.substring(0, 2).toLowerCase();
    password += color.substring(1, 2);
    //add a random special character to the password
    String specialCharacters = "!@#$%^&*()_+";
    int randomIndex = (int) (Math.random() * specialCharacters.length());
    password += specialCharacters.substring(randomIndex, randomIndex + 1);
    password += username.substring(0, 2);
    }

    //encrypt the password using the AES class
    public String encryptPassword() {
        return AES.encrypt(this.password, this.key);
    }


   
}




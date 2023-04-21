package edu.guilford;

import java.util.Scanner;

public class Drive 
{
    public static void main( String[] args )
    {
        
    //create a user object using the constructor
    //User user1 = new User("Asmodeus Bumgarner", "asmodeus", "blue", "December", "1234");
    //create another user object
    //User user2= new User("Nikomachos Olusola", "nikomachos", "red", "October", "10987");

    //create 2 users
    User user1 = createUser();
    User user2 = createUser();

    //generate a password for each user
    user1.generatePassword();
    user2.generatePassword();

    System.out.println("User 1's password is: " + user1.getPassword());
    System.out.println("\tEncrypted Password:" + user1.encryptPassword());
    System.out.println("\tKey:" + user1.getKey());
    System.out.println("\tDecrypted Password:" + AES.decrypt(user1.encryptPassword(), user1.getKey()));

    System.out.println("User 2's password is: " + user2.getPassword());
    System.out.println("\tEncrypted Password:" + user2.encryptPassword());
    System.out.println("\tKey:" + user2.getKey());
    System.out.println("\tDecrypted Password:" + AES.decrypt(user2.encryptPassword(), user2.getKey()));

    }

    //Creates a method that prompts user for attributes and creates a user object
    public static User createUser() {
        //ask the user to enter their name
        System.out.println("Please enter your name: ");
        //import scanner
        Scanner keyboard = new Scanner(System.in);
        String name = keyboard.nextLine();

        //ask the user to enter their username
        System.out.println("Please enter your username: ");
        String username = keyboard.nextLine();

        //ask the user for their favorite color and store it in a variable
        System.out.println("Please enter your favorite color: ");
        String color = keyboard.nextLine();

        //ask the user for their birth month and store it in a variable
        System.out.println("Please enter your birth month: ");
        String birthMonth = keyboard.nextLine();

        //ask the user for their key and store it in a variable
        System.out.println("Please enter your key: ");
        String key = keyboard.nextLine();

        //create a user object using the constructor
        User user = new User(name, username, color, birthMonth, key);
        return user;
    }
}

package camerarentalapplication;

import java.util.Scanner;

public class LoginPage {
    private String username;

    public LoginPage() {
        this.username = "";
    }

    public void displayLoginPage() {
        // Displaying the login page
        System.out.println("+---------------------------------------------+");
        System.out.println("|         WELCOME TO CAMERA RENTAL APP        |");
        System.out.println("+---------------------------------------------+");
        System.out.println("PLEASE LOGIN TO CONTINUE");

        // Capturing the username input
        Scanner scanner = new Scanner(System.in);
        System.out.print("USERNAME: ");
        this.username = scanner.nextLine();
    }

    public String getUsername() {
        return this.username;
    }

    public static void main(String[] args) {
        LoginPage loginPage = new LoginPage();
        loginPage.displayLoginPage();
        System.out.println("Username entered: " + loginPage.getUsername());
    }
}

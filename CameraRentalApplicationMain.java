package camerarentalapplication;

public class CameraRentalApplicationMain {
    public static void main(String[] args) {
        LoginPage loginPage = new LoginPage();
        loginPage.displayLoginPage();
        String username = loginPage.getUsername();
        System.out.println("Welcome, " + username + "!");

        CameraRentalApp app = new CameraRentalApp();
        while (true) {
            app.displayMenu();
        }
    }
}

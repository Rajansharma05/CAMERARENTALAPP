package camerarentalapplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CameraRentalApp {
    private List<Camera> cameras;
    private Scanner scanner;
    private double myWallet;

    public CameraRentalApp() {
        cameras = new ArrayList<>();
        scanner = new Scanner(System.in);
        myWallet = 0.00;
        
        cameras.add(new Camera(1, "SAMSUNG", "DS123", 100.0, true));
        cameras.add(new Camera(2, "SONY", "DSLR", 112.5, true));
        cameras.add(new Camera(3, "Panasonic", "ANOTHER", 105.0, false));
        cameras.add(new Camera(4, "SAMSUNG", "SM12", 104.0, true));
        cameras.add(new Camera(5, "SONY", "CT", 120.5, true));
        cameras.add(new Camera(6, "Panasonic", "", 150.0, false));
        cameras.add(new Camera(7, "SAMSUNG", "ModelX", 100.0, true));
        cameras.add(new Camera(8, "SONY", "HD-012", 120.5, true));
        cameras.add(new Camera(9, "NIKON", "DIGITAL", 150.0, false));
        cameras.add(new Camera(10, "LG", "ModelX", 110.0, true));
        cameras.add(new Camera(11, "SONY", "ModelY", 120.5, true));
        cameras.add(new Camera(12, "CANON", "XPL", 115.0, false));
    }

    public void displayMenu() {
        System.out.println("1. My Cameras");
        System.out.println("2. Rent Camera");
        System.out.println("3. View All Cameras");
        System.out.println("4. My Wallet");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Clear the input buffer

        switch (choice) {
            case 1:
                displayMyCameraMenu();
                break;
            case 2:
                rentCamera();
                break;
            case 3:
                displayAllCameras();
                break;
            case 4:
                displayWalletMenu();
                break;
            case 5:
                System.out.println("Exiting the application...");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }

    public void displayMyCameraMenu() {
        System.out.println("1. Add Camera");
        System.out.println("2. Remove Camera");
        System.out.println("3. View My Cameras");
        System.out.println("4. Go to Previous Menu");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Clear the input buffer

        switch (choice) {
            case 1:
                addCamera();
                break;
            case 2:
                removeCamera();
                break;
            case 3:
                viewMyCameras();
                break;
            case 4:
                displayMenu();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }

    public void addCamera() {
        System.out.print("Enter camera brand: ");
        String brand = scanner.nextLine();

        System.out.print("Enter camera model: ");
        String model = scanner.nextLine();

        System.out.print("Enter per day price (INR): ");
        double pricePerDay = scanner.nextDouble();
        scanner.nextLine(); // Clear the input buffer

        System.out.println("Enter the cameraId: ");
        int cameraId = scanner.nextInt();
        scanner.nextLine(); // Clear the input buffer

        Camera camera = new Camera(cameraId, brand, model, pricePerDay, false);
        cameras.add(camera);
        System.out.println("Your camera has been successfully added to the list.");
        displayMyCameraMenu();
    }

    public void removeCamera() {
        if (cameras.isEmpty()) {
            System.out.println("No cameras available.");
        } else {
            System.out.print("Enter the camera ID you want to remove: ");
            int cameraId = scanner.nextInt();
            scanner.nextLine(); // Clear the input buffer

            Camera camera = findCameraById(cameraId);
            if (camera != null) {
                cameras.remove(camera);
                System.out.println("Camera removed successfully."+ cameraId);
            } else {
                System.out.println("Camera not found. Please try again.");
            }
        }
        displayMyCameraMenu();
    }

    public void viewMyCameras() {
        if (cameras.isEmpty()) {
            System.out.println("No cameras available.");
        } else {
            System.out.println("My Cameras:");
            System.out.println("----------------------------------");
            System.out.println(String.format("%-10s %-10s %-10s %-10s %-15s","cameraId", "Brand", "Model", "Price/Day","status"));
            System.out.println("----------------------------------");
            for (Camera camera : cameras) {
                System.out.println(camera);
            }
            System.out.println("----------------------------------");
        }
        displayMyCameraMenu();
    }
    
    public Camera rentCamera() {
        System.out.print("Enter the camera ID you want to rent: ");
        int cameraId = scanner.nextInt();
        //scanner.nextLine(); // Clear the input buffer

        Camera camera = findCameraById(cameraId);
        if (camera != null && camera.isAvailable()) {
            // Display camera details
            System.out.println("Camera Details:");
            System.out.println("----------------------------------");
            System.out.println("Camera ID: " + camera.getCameraId());
            System.out.println("Brand: " + camera.getBrand());
            System.out.println("Model: " + camera.getModel());
            System.out.println("Price/Day: " + camera.getPricePerDay());
            System.out.println("----------------------------------");

            // Calculate rental duration
            System.out.print("Enter the number of days you want to rent the camera for: ");
            int rentalDays = scanner.nextInt();
            scanner.nextLine(); // Clear the input buffer

            // Calculate total rental cost
            double totalCost = rentalDays * camera.getPricePerDay();
            if (totalCost > myWallet) {
                System.out.println("Insufficient balance in your wallet.");
                System.out.println("Please deposit more funds or choose a different camera.");
            } else {
                myWallet -= totalCost;
                camera.setAvailable(false);
                System.out.println("Camera rented successfully.");
                System.out.println("Total Rental Cost: INR " + totalCost);
            }
        } else if (camera != null && !camera.isAvailable()) {
            System.out.println("Camera is already rented. Please choose a different camera.");
        } else {
            System.out.println("Camera not found. Please try again.");
        }
        displayMenu();
		return camera;
    }


    public void displayAllCameras() {
        if (cameras.isEmpty()) {
            System.out.println("No cameras available.");
        } else {
            System.out.println("Available Cameras:");
            System.out.println("--------------------------------------------------------------");
            System.out.println(String.format("%-10s %-10s %-10s %-10s %-15s","CameraId","Brand", "Model", "Price/Day", "Availability"));
            System.out.println("--------------------------------------------------------------");
            for (Camera camera : cameras) {
                System.out.println(camera);
            }
            System.out.println("--------------------------------------------------------------");
        }
        displayMenu();
    }

    public void displayWalletMenu() {
        System.out.println("1. Show Wallet Balance");
        System.out.println("2. Deposit Amount");
        System.out.println("3. Go to Previous Menu");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Clear the input buffer

        switch (choice) {
            case 1:
                showWalletBalance();
                break;
            case 2:
                depositAmount();
                break;
            case 3:
                displayMenu();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }

    public void showWalletBalance() {
        System.out.println("Your current wallet balance is INR " + myWallet);
        displayWalletMenu();
    }

    public void depositAmount() {
        System.out.print("Enter the amount to deposit (INR): ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Clear the input buffer

        myWallet += amount;
        System.out.println("Your wallet is updated successfully. Your current balance is INR " + myWallet);
        displayWalletMenu();
    }

    
    public Camera findCameraById(int cameraId) {
        for (Camera camera : cameras) {
            if (camera.getCameraId() == cameraId) {
                return camera;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        CameraRentalApp app = new CameraRentalApp();
        System.out.println("Welcome to the Camera Rental Application!");
        app.displayMenu();
    }
}

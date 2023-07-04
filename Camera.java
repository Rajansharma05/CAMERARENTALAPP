package camerarentalapplication;

public class Camera {
	private int cameraId;
    private String brand;
    private String model;
    private double pricePerDay;
    private boolean available;

    public Camera(int cameraId, String brand, String model, double priceperday, boolean b) {
    	this.cameraId = cameraId;
        this.brand = brand;
        this.model = model;
        this.pricePerDay = priceperday;
        this.available = true;
    }
    
	public int cameraId() {
		return cameraId;
    	
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public boolean Status() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return String.format("%-10s %-10s %-10s %-10.2f %-10s",
                cameraId, brand, model, pricePerDay, available ? "Available" : "Not Available");
    }

	public int getCameraId() {
		// TODO Auto-generated method stub
		return cameraId;
	}

	public void setCameraId(int cameraId) {
		this.cameraId = cameraId;
	}
	public int isAvailable(int cameraId) {
		// TODO Auto-generated method stub
		return cameraId;
	}

	public boolean isAvailable() {
		// TODO Auto-generated method stub
		return false;
	}
}

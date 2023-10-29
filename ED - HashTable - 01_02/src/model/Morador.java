package model;

public class Morador {

	public int aptNumber;
	public String residentName;
	public String carType;
	public String carColor;
	public String carId;
	
	public Morador(int aptNumber, String residentName, String carType, String carColor, String carId) {
		this.aptNumber = aptNumber;
		this.residentName = residentName;
		this.carType = carType;
		this.carColor = carColor;
		this.carId = carId;
	}

	public int getAptNumber() {
		return aptNumber;
	}

	public String getResidentName() {
		return residentName;
	}

	public String getCarType() {
		return carType;
	}

	public String getCarColor() {
		return carColor;
	}

	public String getCarId() {
		return carId;
	}
	
	

}

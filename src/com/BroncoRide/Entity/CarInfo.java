package com.BroncoRide.Entity;

public class CarInfo {
	private int carID;
	private int year;
	private String model;
	private int numOfSeat;
	
	public CarInfo(){
		
	}

	public CarInfo(int year, String model, int numOfSeat) {
		super();
		this.year = year;
		this.model = model;
		this.numOfSeat = numOfSeat;
	}

	public int getCarID() {
		return carID;
	}

	public void setCarID(int carID) {
		this.carID = carID;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getNumOfSeat() {
		return numOfSeat;
	}

	public void setNumOfSeat(int numOfSeat) {
		this.numOfSeat = numOfSeat;
	}
	
	
}

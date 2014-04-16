package com.BroncoRide.Entity;

public class Place {
	private int placeID;
	private String address;
	private double latitude;
	private double longtitude;
	
	public Place(){
		
	}

	public Place(String address, double latitude, double longtitude) {
		super();
		this.address = address;
		this.latitude = latitude;
		this.longtitude = longtitude;
	}

	public int getPlaceID() {
		return placeID;
	}

	public void setPlaceID(int placeID) {
		this.placeID = placeID;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongtitude() {
		return longtitude;
	}

	public void setLongtitude(double longtitude) {
		this.longtitude = longtitude;
	}
	
	
	
}

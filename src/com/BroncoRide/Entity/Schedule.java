package com.BroncoRide.Entity;

import java.util.List;

public class Schedule {
	private int scheduleID;
	private Users driver;
	private String date;
	private Place start;
	private Place destination;
	private List<Users> passengers;

	public Schedule() {

	}

	public Schedule(int scheduleID, Users driver, String date, Place start,
			Place destination, List<Users> passengers) {
		super();
		this.scheduleID = scheduleID;
		this.driver = driver;
		this.date = date;
		this.start = start;
		this.destination = destination;
		this.passengers = passengers;
	}

	public int getScheduleID() {
		return scheduleID;
	}

	public void setScheduleID(int scheduleID) {
		this.scheduleID = scheduleID;
	}

	public Users getDriver() {
		return driver;
	}

	public void setDriver(Users driver) {
		this.driver = driver;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Place getStart() {
		return start;
	}

	public void setStart(Place start) {
		this.start = start;
	}

	public Place getDestination() {
		return destination;
	}

	public void setDestination(Place destination) {
		this.destination = destination;
	}

	public List<Users> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<Users> passengers) {
		this.passengers = passengers;
	}
	
	
}

package com.BroncoRide.Entity;

import java.util.List;

public class Users {
	private int userID;
	private String username;
	private String password;
	private String gender;
	private int age;
	private int yearOfDriving;
	private String photo;
	private String email;
	private CarInfo carInfo;
	private Place home;
	private Place school;
	private Rank rank;
	private List<Schedule> schedules;

	public Users() {

	}


	public Users(String username, String password, String gender,
			int age, int yearOfDriving, String photo, String email,
			CarInfo carInfo, Place home, Place school, Rank rank,
			List<Schedule> schedules) {
		super();
		this.username = username;
		this.password = password;
		this.gender = gender;
		this.age = age;
		this.yearOfDriving = yearOfDriving;
		this.photo = photo;
		this.email = email;
		this.carInfo = carInfo;
		this.home = home;
		this.school = school;
		this.rank = rank;
		this.schedules = schedules;
	}



	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getYearOfDriving() {
		return yearOfDriving;
	}

	public void setYearOfDriving(int yearOfDriving) {
		this.yearOfDriving = yearOfDriving;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public CarInfo getCarInfo() {
		return carInfo;
	}

	public void setCarInfo(CarInfo carInfo) {
		this.carInfo = carInfo;
	}

	public Place getHome() {
		return home;
	}

	public void setHome(Place home) {
		this.home = home;
	}

	public Place getSchool() {
		return school;
	}

	public void setSchool(Place school) {
		this.school = school;
	}

	public Rank getRank() {
		return rank;
	}

	public void setRank(Rank rank) {
		this.rank = rank;
	}


	public List<Schedule> getSchedules() {
		return schedules;
	}


	public void setSchedules(List<Schedule> schedules) {
		this.schedules = schedules;
	}
	
	

}

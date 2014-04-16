package com.BroncoRide.Entity;

public class Rank {
	private int rankID;
	private int drivePoint;
	private int passagePoint;
	
	public Rank(){
		
	}

	public Rank(int drivePoint, int passagePoint) {
		super();
		this.drivePoint = drivePoint;
		this.passagePoint = passagePoint;
	}

	public int getRankID() {
		return rankID;
	}

	public void setRankID(int rankID) {
		this.rankID = rankID;
	}

	public int getDrivePoint() {
		return drivePoint;
	}

	public void setDrivePoint(int drivePoint) {
		this.drivePoint = drivePoint;
	}

	public int getPassagePoint() {
		return passagePoint;
	}

	public void setPassagePoint(int passagePoint) {
		this.passagePoint = passagePoint;
	}
	
	
}

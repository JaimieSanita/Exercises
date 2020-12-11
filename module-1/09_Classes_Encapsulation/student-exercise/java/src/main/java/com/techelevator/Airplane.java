package com.techelevator;

public class Airplane {

	// instance variable

	private String planeNumber;
	private int totalFirstClassSeats;
	private int bookedFirstClassSeats;
	private int totalCoachSeats;
	private int bookedCoachSeats;

	// getters

	public String getPlaneNumber() {
		return planeNumber;
	}

	public int getTotalFirstClassSeats() {
		return totalFirstClassSeats;
	}

	public int getBookedFirstClassSeats() {
		return bookedFirstClassSeats;
	}

	public int getTotalCoachSeats() {
		return totalCoachSeats;
	}

	public int getBookedCoachSeats() {
		return bookedCoachSeats;
	}

	// derived getters

	public int getAvailableFirstClassSeats() {
		int firstClassSeats = 0;
		firstClassSeats = this.totalFirstClassSeats - this.bookedFirstClassSeats;
		return firstClassSeats;
	}

	public int getAvailableCoachSeats() {
		int coachClassSeats = 0;
		coachClassSeats = this.totalCoachSeats - this.bookedCoachSeats;
		return coachClassSeats;
	}

	// constructor
	public Airplane(String planeNumber, int totalFirstClassSeats, int totalCoachSeats) {
		this.planeNumber = planeNumber;
		this.totalFirstClassSeats = totalFirstClassSeats;
		this.totalCoachSeats = totalCoachSeats;
	}
	// method

	public boolean reserveSeats(boolean forFirstClass, int totalNumberOfSeats) {
		if (totalNumberOfSeats == 0) {
			return true;
		}
		if (forFirstClass) {
				if (totalNumberOfSeats <= getAvailableFirstClassSeats()) {
				this.bookedFirstClassSeats = totalNumberOfSeats + bookedFirstClassSeats;
				return true;
			}
		} else {
				if (totalNumberOfSeats <= getAvailableCoachSeats()) {
				this.bookedCoachSeats = totalNumberOfSeats + bookedCoachSeats;
				return true;
		}}
		return false;
	}
}

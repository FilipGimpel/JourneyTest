package com.gimpel.journeytest.boardingcards;


public class AirplaneBoardingCard extends AbstractBoardingCard {
	private String mSeatNumber;
	private String mGate;
	private String mBaggageDrop;
	private String mFlightNumber;
	
	public void setFlightNumber(String flightNumber) {
		mFlightNumber = flightNumber;
	}
	
	public String getFlightNumber() {
		return mFlightNumber;
	}
	
	public String getGate() {
		return mGate;
	}
	
	public void setGate(String gate) {
		mGate = gate;
	}
	
	public String getBaggageDrop() {
		return mBaggageDrop;
	}
	
	public void setBaggageDrop(String baggageDrop) {
		mBaggageDrop = baggageDrop;
	}
	
	public String getSeatNumber() {
		return mSeatNumber;
	}
	
	public void setSeatNumber(String seatNumber) {
		mSeatNumber = seatNumber;
	}

	@Override
	public Transport getType() {
		return Transport.AIRPLANE;
	}
	
}

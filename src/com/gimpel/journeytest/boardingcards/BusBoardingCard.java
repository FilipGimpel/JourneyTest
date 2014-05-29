package com.gimpel.journeytest.boardingcards;


public class BusBoardingCard extends AbstractBoardingCard {
	private String mSeatNumber;
	
	public String getSeatNumber() {
		return mSeatNumber;
	}
	
	public void setSeatNumber(String seatNumber) {
		mSeatNumber = seatNumber;
	}
	
	@Override
	public Transport getType() {
		return Transport.BUS;
	}

}

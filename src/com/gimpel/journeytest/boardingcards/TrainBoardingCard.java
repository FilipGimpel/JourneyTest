package com.gimpel.journeytest.boardingcards;

public class TrainBoardingCard extends AbstractBoardingCard {
	private String mSeatNumber;
	private String mTrainNumber;

	public String getTrainNumber() {
		return mTrainNumber;
	}
	
	public void setTrainNumber(String trainNumber) {
		mTrainNumber = trainNumber;
	}
	
	public String getSeatNumber() {
		return mSeatNumber;
	}
	
	public void setSeatNumber(String seatNumber) {
		mSeatNumber = seatNumber;
	}

	@Override
	public Transport getType() {
		return Transport.TRAIN;
	}

}

package com.gimpel.journeytest.boardingcards;

public abstract class AbstractBoardingCard {
	public enum Transport { 
		TRAIN(0),
		AIRPLANE(1),
		BUS(2);
		
		private int id;
		private Transport(int ID) {
			id = ID;
		}
		
		public int getId() {
			return id;
		}
	};
	
	private String mBegining;
	private String mDestination;
	
	// TODO move getSeatNumber/NumerPodrozy to abstractClass?

	abstract public Transport getType();
	
	public void setBeggining(String beggining) {
		mBegining = beggining;
	}
	
	public void setDestination(String destination) {
		mDestination = destination;
	}
	
	public String getBeginning() {
		return mBegining;
	}

	public String getDestination() {
		return mDestination;
	}
}

	

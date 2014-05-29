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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((mBegining == null) ? 0 : mBegining.hashCode());
		result = prime * result
				+ ((mDestination == null) ? 0 : mDestination.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractBoardingCard other = (AbstractBoardingCard) obj;
		if (mBegining == null) {
			if (other.mBegining != null)
				return false;
		} else if (!mBegining.equals(other.mBegining))
			return false;
		if (mDestination == null) {
			if (other.mDestination != null)
				return false;
		} else if (!mDestination.equals(other.mDestination))
			return false;
		return true;
	}
}

	

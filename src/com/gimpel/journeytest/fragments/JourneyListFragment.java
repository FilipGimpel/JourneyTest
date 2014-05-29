package com.gimpel.journeytest.fragments;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.gimpel.journeytest.R;
import com.gimpel.journeytest.R.id;
import com.gimpel.journeytest.R.layout;
import com.gimpel.journeytest.adapters.BoardingCardAdapter;
import com.gimpel.journeytest.boardingcards.AbstractBoardingCard;
import com.gimpel.journeytest.boardingcards.AirplaneBoardingCard;
import com.gimpel.journeytest.boardingcards.BusBoardingCard;
import com.gimpel.journeytest.boardingcards.TrainBoardingCard;

public class JourneyListFragment extends Fragment {
	private List<AbstractBoardingCard> mBoardingCards;
	private BoardingCardAdapter mAdapter;
	private ListView mListView;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_list, container,
				false);
		return rootView;
	}
	
	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);

		mBoardingCards = getBoardingCards();
		mAdapter = new BoardingCardAdapter(getActivity(), mBoardingCards);
		
        mListView = (ListView) view.findViewById(R.id.listview);
        mListView.setAdapter(mAdapter);
	}
	
	public List<AbstractBoardingCard> getBoardingCards() {
		List<AbstractBoardingCard> cardList = new ArrayList<AbstractBoardingCard>();
				
		TrainBoardingCard train1 = new TrainBoardingCard();
		train1.setBeggining("Madrit");
		train1.setDestination("Barcelona");
		train1.setSeatNumber("45B");
		train1.setTrainNumber("78A");
		
		BusBoardingCard airportBus = new BusBoardingCard();
		airportBus.setBeggining("Barcelona");
		airportBus.setDestination("Gerona Airport");
		airportBus.setSeatNumber("No seat assigment");
		
		AirplaneBoardingCard airplane = new AirplaneBoardingCard();
		airplane.setBeggining("Gerona Airport");
		airplane.setDestination("London");
		airplane.setFlightNumber("SK455");
		airplane.setGate("45B");
		airplane.setSeatNumber("3A");
		airplane.setBaggageDrop("344");
		
		AirplaneBoardingCard airplane2 = new AirplaneBoardingCard();
		airplane2.setBeggining("London");
		airplane2.setDestination("New York JFK");
		airplane2.setFlightNumber("SK22");
		airplane2.setGate("22");
		airplane2.setSeatNumber("7B");
		airplane2.setBaggageDrop("Automatically transfered");
		
		cardList.add(train1);
		cardList.add(airportBus);
		cardList.add(airplane);
		cardList.add(airplane2);
		
		return cardList;
	}
	
}

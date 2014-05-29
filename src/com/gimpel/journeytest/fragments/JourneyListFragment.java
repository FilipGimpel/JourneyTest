package com.gimpel.journeytest.fragments;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.gimpel.journeytest.R;
import com.gimpel.journeytest.adapters.BoardingCardAdapter;
import com.gimpel.journeytest.boardingcards.AbstractBoardingCard;
import com.gimpel.journeytest.boardingcards.AirplaneBoardingCard;
import com.gimpel.journeytest.boardingcards.BusBoardingCard;
import com.gimpel.journeytest.boardingcards.TrainBoardingCard;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

public class JourneyListFragment extends Fragment {
	private List<AbstractBoardingCard> mBoardingCards;
	private BoardingCardAdapter mAdapter;
	//private ListView mListView;
	PullToRefreshListView mListView;
	
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
		
        //mListView = (ListView) view.findViewById(R.id.listview);
		mListView = (PullToRefreshListView) getView().findViewById(R.id.listview);
        mListView.setAdapter(mAdapter);
        mListView.setOnRefreshListener(new OnRefreshListener<ListView>() {
            @Override
            public void onRefresh(PullToRefreshBase<ListView> refreshView) {
                new FakeWaitTask().execute();
            }
        });
	}

	private class FakeWaitTask extends AsyncTask<Void, Void, String[]> {
	    
	    @Override
	    protected void onPostExecute(String[] result) {
	        mListView.onRefreshComplete();
	        sort();
	        super.onPostExecute(result);
	    }

		@Override
		protected String[] doInBackground(Void... params) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			return null;
		}
	}
	
	/**
	 * Sorts data asociated with listview in a way described in task.
	 * This method works only for correnct data.
	 * Uses 3 loops, none of them nested so complexity is linear O(3n) ~ O(n)  
	 */
	private void sort() {
		// create mapping between destination/start location and BoardingCard 
		HashMap<String, AbstractBoardingCard> getCardByDestination =
				new HashMap<String, AbstractBoardingCard>();
		HashMap<String, AbstractBoardingCard> getCardByBegining =
				new HashMap<String, AbstractBoardingCard>();

		// first loop: just fill the data
		for (AbstractBoardingCard card : mBoardingCards) {
			getCardByBegining.put(card.getBeginning(), card);
			getCardByDestination.put(card.getDestination(), card);
		}
		
		List<AbstractBoardingCard> sortedList = new ArrayList<AbstractBoardingCard>();
		AbstractBoardingCard currentItem = null;
		
		// second loop (not always goes all way round)
		// lets find first location
		for (AbstractBoardingCard card : mBoardingCards) {
			// first item
			if (!getCardByDestination.keySet().contains(card.getBeginning())) {
				currentItem = card;
				break;
			}
		}
		
		// last loop - finds next location and adds it to sorted list
		// in a while loop.
		do {
			sortedList.add(currentItem);
			currentItem = getCardByBegining.get(currentItem.getDestination());
		} while ( currentItem != null);
		
		mAdapter.updateView(sortedList);
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
		
		// wrong order
		cardList.add(airplane);
		cardList.add(train1);
		cardList.add(airplane2);
		cardList.add(airportBus);
		
		return cardList;
	}
	
}

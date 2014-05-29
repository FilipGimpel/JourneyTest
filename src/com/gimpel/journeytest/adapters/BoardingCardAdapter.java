package com.gimpel.journeytest.adapters;

import java.util.List;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.gimpel.journeytest.R;
import com.gimpel.journeytest.boardingcards.AbstractBoardingCard;
import com.gimpel.journeytest.boardingcards.BusBoardingCard;
import com.gimpel.journeytest.boardingcards.AbstractBoardingCard.Transport;
import com.gimpel.journeytest.boardingcards.AirplaneBoardingCard;
import com.gimpel.journeytest.boardingcards.TrainBoardingCard;

public class BoardingCardAdapter extends BaseAdapter {
	private LayoutInflater mInflater;
	private List<AbstractBoardingCard> mDataSet;
	private static final int VIEW_TYPE_COUNT = AbstractBoardingCard.Transport.values().length;

	public BoardingCardAdapter(Context context, List<AbstractBoardingCard> dataSet) {
		mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		mDataSet = dataSet;
	}

	@Override
	public int getItemViewType(int position) {
		return mDataSet.get(position).getType().getId();
	}
	
	
	public void updateView(List<AbstractBoardingCard> newCardSet) {
		mDataSet = newCardSet;
		this.notifyDataSetChanged();
	}
	
	@Override
	public int getViewTypeCount() {
		//return super.getViewTypeCount();
		return VIEW_TYPE_COUNT;
	}

	@Override
	public int getCount() {
		return mDataSet.size();
	}

	@Override
	public Object getItem(int position) {
		return mDataSet.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// determine type using position.
		AbstractBoardingCard card = mDataSet.get(position); 
		Transport type = card.getType(); 
		
		TextView mStartAndDest;
		TextView mFlightNumber;
		TextView mGateNumber;
		TextView mBagageDrop;
		TextView mSeatNumber;
		
		switch (type) {
		case TRAIN: 
			convertView = mInflater.inflate(R.layout.train_row_layout, null);   

			TrainBoardingCard trainCard = (TrainBoardingCard) card;
			convertView = mInflater.inflate(R.layout.train_row_layout, null);
			
			mStartAndDest = (TextView) convertView.findViewById(R.id.textview_start_and_destination);
			mStartAndDest.setText(Html.fromHtml(
					String.format("<b>FROM:</b> %s <b>TO:</b> %s", trainCard.getBeginning(), trainCard.getDestination())));
			
			mSeatNumber = (TextView) convertView.findViewById(R.id.textview_seat);
			mSeatNumber.setText(Html.fromHtml(
					String.format("<b>SEAT:</b> %s", trainCard.getSeatNumber())));
	
			mFlightNumber = (TextView) convertView.findViewById(R.id.textview_train_number);
			mFlightNumber.setText(Html.fromHtml(
					String.format("<b>TRAIN NUMBER:</b> %s", trainCard.getTrainNumber())));
	
			
			
		break;
		case AIRPLANE:
			AirplaneBoardingCard airPlaneCard = (AirplaneBoardingCard) card;
			convertView = mInflater.inflate(R.layout.airplane_row_layout, null);
			
			mStartAndDest = (TextView) convertView.findViewById(R.id.textview_start_and_destination);
			mStartAndDest.setText(Html.fromHtml(
					String.format("<b>FROM:</b> %s <b>TO:</b> %s", card.getBeginning(), card.getDestination())));
			
			mFlightNumber = (TextView) convertView.findViewById(R.id.textview_flight_number);
			mFlightNumber.setText(Html.fromHtml(
					String.format("<b>FLIGHT NUMBER:</b> %s", airPlaneCard.getFlightNumber())));
			
			mGateNumber = (TextView) convertView.findViewById(R.id.textview_gate_number);
			mGateNumber.setText(Html.fromHtml(
					String.format("<b>GATE:</b> %s", airPlaneCard.getGate())));
			
			mSeatNumber = (TextView) convertView.findViewById(R.id.textview_seat);
			mSeatNumber.setText(Html.fromHtml(
					String.format("<b>SEAT:</b> %s", airPlaneCard.getSeatNumber())));
			
			mBagageDrop = (TextView) convertView.findViewById(R.id.textview_bagage_drop);
			mBagageDrop.setText(Html.fromHtml(
					String.format("<b>BAGAGE DROP:</b> %s", airPlaneCard.getBaggageDrop())));
			break;
		case BUS:
			BusBoardingCard busCard = (BusBoardingCard) card;
			convertView = mInflater.inflate(R.layout.bus_row_layoutl, null);
			
			mStartAndDest = (TextView) convertView.findViewById(R.id.textview_start_and_destination);
			mStartAndDest.setText(Html.fromHtml(
					String.format("<b>FROM:</b> %s <b>TO:</b> %s", busCard.getBeginning(), busCard.getDestination())));
			
			mSeatNumber = (TextView) convertView.findViewById(R.id.textview_seat);
			mSeatNumber.setText(Html.fromHtml(
					String.format("<b>SEAT:</b> %s", busCard.getSeatNumber())));
			
			break; 
		}

		return convertView;
	}
}

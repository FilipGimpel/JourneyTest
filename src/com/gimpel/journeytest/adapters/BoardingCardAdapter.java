package com.gimpel.journeytest.adapters;

import java.util.List;

import com.gimpel.journeytest.R;
import com.gimpel.journeytest.R.id;
import com.gimpel.journeytest.R.layout;
import com.gimpel.journeytest.boardingcards.AbstractBoardingCard;
import com.gimpel.journeytest.boardingcards.AbstractBoardingCard.Transport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

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
		
		TextView text;
		
		switch (type) {
		case TRAIN: 
			convertView = mInflater.inflate(R.layout.train_row_layout, null);   
			text = (TextView) convertView.findViewById(R.id.journey);
			text.setText(String.format("from %s to %s", card.getBeginning(), card.getDestination() ));
			break;
		case AIRPLANE:
			convertView = mInflater.inflate(R.layout.airplane_row_layout, null);
			text = (TextView) convertView.findViewById(R.id.journey);
			text.setText(String.format("from %s to %s", card.getBeginning(), card.getDestination() ));
			break;
		case BUS:
			convertView = mInflater.inflate(R.layout.bus_row_layoutl, null);
			text = (TextView) convertView.findViewById(R.id.journey);
			text.setText(String.format("from %s to %s", card.getBeginning(), card.getDestination() ));

			break; 
		}

		return convertView;
	}
}

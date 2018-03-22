package com.cs211d.holmes.trkr;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by root on 3/21/18.
 */

public class MoodAdapter extends RecyclerView.Adapter<MoodAdapter.ViewHolder> {
    private List<MoodData> moodList;


    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public CardView mCardView;
        public TextView beforetv;
        public TextView incidenttv;
        public TextView aftertv;
        public TextView timestamptv;
        public ViewHolder(CardView v) {
            super(v);
            mCardView = v;
            beforetv = mCardView.findViewById(R.id.beforetv);
            aftertv = mCardView.findViewById(R.id.aftertv);
            incidenttv = mCardView.findViewById(R.id.incidenttv);
            timestamptv = mCardView.findViewById(R.id.timestamptv);
            mCardView.setPreventCornerOverlap(false);
        }
    }

    //This is where the data is RECIEVED from display TRKR class
    // Provide a suitable constructor (depends on the kind of dataset)
    public MoodAdapter(List<MoodData> moodList) {
        this.moodList = moodList;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MoodAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        CardView v = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_layout, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that elemen

        holder.beforetv.setText(moodList.get(position).getBefore());
        holder.aftertv.setText(moodList.get(position).getAfter());
        holder.incidenttv.setText(moodList.get(position).getIncident());
        holder.timestamptv.setText(moodList.get(position).getTimeStamp());

    }

    // Return the size of your daetaset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return moodList.size();
    }
}
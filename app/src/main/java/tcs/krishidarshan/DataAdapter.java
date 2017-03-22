package tcs.krishidarshan;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import tcs.krishidarshan.dummy.DummyContent.DummyItem;

/**
 * Created by Abhishek on 19-03-2017.
 */

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private final List<DummyItem> mValues;


    public DataAdapter(List<DummyItem> items) {
        mValues = items;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setImageResource(holder.mItem.id);
        holder.mContentView.setText(holder.mItem.content);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final ImageView mIdView;
        public final TextView mContentView;
        public final Context mContext;
        public DummyItem mItem;

        public ViewHolder(final View view) {
            super(view);
            mView = view;
            mContext = view.getContext();
            mIdView = (ImageView) view.findViewById(R.id.id);
            mContentView = (TextView) view.findViewById(R.id.content);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    switch (position) {
                        case 0:
                            Intent i = new Intent(mContext, CropsActivity.class);
                            mContext.startActivity(i);
                            break;
                        case 1:
                            Intent i1 = new Intent(mContext, WeatherActivity.class);
                            mContext.startActivity(i1);
                    }
                }
            });

        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }

    }


}
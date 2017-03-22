package tcs.krishidarshan;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import tcs.krishidarshan.KhariffFragment.OnListFragmentInteractionListener;
import tcs.krishidarshan.dummy.DummyCrops.DummyItem;


/**
 * Created by Abhishek on 19-03-2017.
 */

public class CropsAdapter extends RecyclerView.Adapter<CropsAdapter.ViewHolder> {
    private final List<DummyItem> mValues;
    private final OnListFragmentInteractionListener mListener;


    public CropsAdapter(List<DummyItem> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.crops_item_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setImageResource(holder.mItem.id);
        holder.mContentView.setText(holder.mItem.content);
        holder.mContentViewDetail.setText(holder.mItem.content_detail);
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem,position);
                }
            }
        });
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
        public final TextView mContentViewDetail;
        public DummyItem mItem;

        public ViewHolder(final View view) {
            super(view);
            mView = view;
            mContext = view.getContext();
            mIdView = (ImageView) view.findViewById(R.id.crops_image);
            mContentView = (TextView) view.findViewById(R.id.crops_name);
            mContentViewDetail = (TextView) view.findViewById(R.id.crops_detail);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'" + mContentViewDetail.getText() + " ' ";
        }

    }


}
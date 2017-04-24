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

import tcs.krishidarshan.KhariffFragment.OnListFragmentInteractionListener;
import tcs.krishidarshan.RabiFragment.OnListRabiFragmentInteractionListener;
import tcs.krishidarshan.ZaidKhariffFragment.OnListZaidKhariffFragmentInteractionListener;
import tcs.krishidarshan.ZaidRabiFragment.OnListZaidRabiFragmentInteractionListener;
import tcs.krishidarshan.dummy.DummyContent.DummyItem;

/**
 * Created by Abhishek on 19-03-2017.
 */

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private final List<DummyItem> mValues;
    private final OnListFragmentInteractionListener mListener;
    private final OnListRabiFragmentInteractionListener mRabiListener;
    private final OnListZaidKhariffFragmentInteractionListener mZaidKhariffListener;
    private final OnListZaidRabiFragmentInteractionListener mZaidRabiListener;

    public DataAdapter(List<DummyItem> items) {
        mValues = items;
        mListener = null;
        mRabiListener = null;
        mZaidKhariffListener = null;
        mZaidRabiListener = null;
    }

    public DataAdapter(List<DummyItem> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
        mRabiListener = null;
        mZaidKhariffListener = null;
        mZaidRabiListener = null;
    }

    public DataAdapter(List<DummyItem> items, OnListRabiFragmentInteractionListener listener) {
        mValues = items;
        mListener = null;
        mRabiListener = listener;
        mZaidKhariffListener = null;
        mZaidRabiListener = null;
    }

    public DataAdapter(List<DummyItem> items, OnListZaidKhariffFragmentInteractionListener listener) {
        mValues = items;
        mListener = null;
        mRabiListener = null;
        mZaidKhariffListener = listener;
        mZaidRabiListener = null;
    }

    public DataAdapter(List<DummyItem> items, OnListZaidRabiFragmentInteractionListener listener) {
        mValues = items;
        mListener = null;
        mRabiListener = null;
        mZaidKhariffListener = null;
        mZaidRabiListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mListener == null && mRabiListener == null && mZaidKhariffListener == null && mZaidRabiListener == null) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.card_view, parent, false);
            return new ViewHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.crops_item_card, parent, false);
            return new ViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        if (mListener == null && mRabiListener == null && mZaidKhariffListener == null && mZaidRabiListener == null) {
            holder.mItem = mValues.get(position);
            holder.mIdView.setImageResource(holder.mItem.id);
            holder.mContentView.setText(holder.mItem.content);
        } else if (mListener != null) {
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
                        mListener.onListFragmentInteraction(holder.mItem, position);
                    }
                }
            });
        } else if (mRabiListener != null) {
            holder.mItem = mValues.get(position);
            holder.mIdView.setImageResource(holder.mItem.id);
            holder.mContentView.setText(holder.mItem.content);
            holder.mContentViewDetail.setText(holder.mItem.content_detail);
            holder.mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (null != mRabiListener) {
                        // Notify the active callbacks interface (the activity, if the
                        // fragment is attached to one) that an item has been selected.
                        mRabiListener.onListRabiFragmentInteraction(holder.mItem, position);
                    }
                }
            });
        } else if (mZaidKhariffListener != null) {
            holder.mItem = mValues.get(position);
            holder.mIdView.setImageResource(holder.mItem.id);
            holder.mContentView.setText(holder.mItem.content);
            holder.mContentViewDetail.setText(holder.mItem.content_detail);
            holder.mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (null != mZaidKhariffListener) {
                        // Notify the active callbacks interface (the activity, if the
                        // fragment is attached to one) that an item has been selected.
                        mZaidKhariffListener.onListZaidKhariffFragmentInteraction(holder.mItem, position);
                    }
                }
            });
        } else {
            holder.mItem = mValues.get(position);
            holder.mIdView.setImageResource(holder.mItem.id);
            holder.mContentView.setText(holder.mItem.content);
            holder.mContentViewDetail.setText(holder.mItem.content_detail);
            holder.mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (null != mZaidRabiListener) {
                        // Notify the active callbacks interface (the activity, if the
                        // fragment is attached to one) that an item has been selected.
                        mZaidRabiListener.onListZaidRabiFragmentInteraction(holder.mItem, position);
                    }
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final ImageView mIdView;
        public final TextView mContentView;
        public final TextView mContentViewDetail;
        public final Context mContext;
        public DummyItem mItem;

        public ViewHolder(final View view) {
            super(view);
            if (mListener == null && mRabiListener == null && mZaidKhariffListener == null && mZaidRabiListener == null) {
                mView = view;
                mContext = view.getContext();
                mIdView = (ImageView) view.findViewById(R.id.id);
                mContentView = (TextView) view.findViewById(R.id.content);
                mContentViewDetail = (TextView) null;
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
                                break;
                            case 2:
                                Intent i2 = new Intent(mContext, Market.class);
                                mContext.startActivity(i2);
                                break;
                            case 3:
                                Intent i3 = new Intent(mContext, SchemesActivity.class);
                                mContext.startActivity(i3);
                                break;
                        }
                    }
                });
            } else {
                mView = view;
                mContext = view.getContext();
                mIdView = (ImageView) view.findViewById(R.id.crops_image);
                mContentView = (TextView) view.findViewById(R.id.crops_name);
                mContentViewDetail = (TextView) view.findViewById(R.id.crops_detail);
            }
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'" + mContentViewDetail.getText() + "'";
        }
    }
}
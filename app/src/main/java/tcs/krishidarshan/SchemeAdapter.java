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

import static tcs.krishidarshan.MyApplication.context;

/**
 * Created by Abhishek on 24-03-2017.
 */

public class SchemeAdapter extends RecyclerView.Adapter<SchemeAdapter.ViewHolder> {
    private final List<DummyItem> mValues;

    public SchemeAdapter(List<DummyItem> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.schemes_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.mItem = mValues.get(position);
        holder.mContentView.setText(holder.mItem.content);
        holder.mContentViewDetail.setText(holder.mItem.content_detail);
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
            mView = view;
            mContext = view.getContext();
            mIdView = (ImageView) view.findViewById(R.id.crops_image);
            mContentView = (TextView) view.findViewById(R.id.crops_name);
            mContentViewDetail = (TextView) view.findViewById(R.id.crops_detail);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    String[] schemes_names = {context.getResources().getString(R.string.pmfby),
                            context.getResources().getString(R.string.rkvy),
                            context.getResources().getString(R.string.pay),
                            context.getResources().getString(R.string.pmjdy)
                    };
                    Intent intent = new Intent(mContext, DetailActivity.class);
                    intent.putExtra("title", schemes_names[position]);
                    switch (position) {
                        case 0:
                            intent.putExtra("url", "file:////android_res/raw/pradhanmantrifasalbimayojna.html");
                            mContext.startActivity(intent);
                            break;
                        case 1:
                            intent.putExtra("url", "file:////android_res/raw/rashtriya_krishi_vikas_yojna.html");
                            mContext.startActivity(intent);
                            break;
                        case 2:
                            intent.putExtra("url", "file:////android_res/raw/pradhanmantri_awas_yojana.html");
                            mContext.startActivity(intent);
                            break;
                        case 3:
                            intent.putExtra("url", "file:////android_res/raw/pradhanmantri_jan_dhan_yojana.html");
                            mContext.startActivity(intent);
                            break;
                    }
                }
            });
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'" + mContentViewDetail.getText() + "'";
        }
    }
}
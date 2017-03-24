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
                .inflate(R.layout.crops_item_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setImageResource(holder.mItem.id);
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
                    String[] schemes_names = {"Crops", "Weather", "Market Price", "ABC"};
                    Intent intent = new Intent(mContext, DetailActivity.class);
                    intent.putExtra("title", schemes_names[position]);
                    switch (position) {
                        case 0:
                            intent.putExtra("url", "<html><body><img style=\"width:100%;\" src=\"file:///android_res/drawable/bg.jpg\"/><p style=\"color:#646464;\">Har Ki Pauri is a famous ghat on the banks of the Ganges in Haridwar in Uttarakhand state in India. This revered place is the major landmark of the holy city of Haridwar.<br/>Har Ki Pauri is also the area where thousands of pilgrims converge and the festivities commence during the Kumbha Mela, which takes place every twelve years, and the Ardh Kumbh Mela, which takes place every six years and the Punjabi festival of Vaisakhi, a harvest festival occurring every year in the month of April .</p><h3 style=\"text-align:center; color:#03A9F4;\">The Ganga Aarti</h3><img style=\"width:100%;\" src=\"file:///android_res/drawable/bg.jpg\"/><p style=\"color:#646464;\">Each evening at sunset priests perform Ganga Aarti here, when lights are set on the water to drift downstream. A large number of people gather on both the banks of river Ganges to sing its praises. The priests hold large fire bowls in their hands, the gongs in the temples at the Ghat start ringing and the chants flowing out of lips fill the air. People float earthen Diyas, with burning flickers and flowers in them as a symbol of hope and wishes .The golden hues of floral diyas reflected in the river Ganges presents spectacular view.</p><strong><p style=\"color:#646464;\">Keep Ganga Clean.<br/>Take a pledge to protect your local water bodies and environment, and to inspire your friends, family and community to do the same.</br></br></br></br></p></strong></body></html>");
                            mContext.startActivity(intent);
                            break;
                        case 1:
                            intent.putExtra("url", "<html><body><img style=\"width:100%;\" src=\"file:///android_res/drawable/bg.jpg\"/><p style=\"color:#646464;\">Har Ki Pauri is a famous ghat on the banks of the Ganges in Haridwar in Uttarakhand state in India. This revered place is the major landmark of the holy city of Haridwar.<br/>Har Ki Pauri is also the area where thousands of pilgrims converge and the festivities commence during the Kumbha Mela, which takes place every twelve years, and the Ardh Kumbh Mela, which takes place every six years and the Punjabi festival of Vaisakhi, a harvest festival occurring every year in the month of April .</p><h3 style=\"text-align:center; color:#03A9F4;\">The Ganga Aarti</h3><img style=\"width:100%;\" src=\"file:///android_res/drawable/bg.jpg\"/><p style=\"color:#646464;\">Each evening at sunset priests perform Ganga Aarti here, when lights are set on the water to drift downstream. A large number of people gather on both the banks of river Ganges to sing its praises. The priests hold large fire bowls in their hands, the gongs in the temples at the Ghat start ringing and the chants flowing out of lips fill the air. People float earthen Diyas, with burning flickers and flowers in them as a symbol of hope and wishes .The golden hues of floral diyas reflected in the river Ganges presents spectacular view.</p><strong><p style=\"color:#646464;\">Keep Ganga Clean.<br/>Take a pledge to protect your local water bodies and environment, and to inspire your friends, family and community to do the same.</br></br></br></br></p></strong></body></html>");
                            mContext.startActivity(intent);
                            break;
                        case 3:
                            intent.putExtra("url", "<html><body><img style=\"width:100%;\" src=\"file:///android_res/drawable/bg.jpg\"/><p style=\"color:#646464;\">Har Ki Pauri is a famous ghat on the banks of the Ganges in Haridwar in Uttarakhand state in India. This revered place is the major landmark of the holy city of Haridwar.<br/>Har Ki Pauri is also the area where thousands of pilgrims converge and the festivities commence during the Kumbha Mela, which takes place every twelve years, and the Ardh Kumbh Mela, which takes place every six years and the Punjabi festival of Vaisakhi, a harvest festival occurring every year in the month of April .</p><h3 style=\"text-align:center; color:#03A9F4;\">The Ganga Aarti</h3><img style=\"width:100%;\" src=\"file:///android_res/drawable/bg.jpg\"/><p style=\"color:#646464;\">Each evening at sunset priests perform Ganga Aarti here, when lights are set on the water to drift downstream. A large number of people gather on both the banks of river Ganges to sing its praises. The priests hold large fire bowls in their hands, the gongs in the temples at the Ghat start ringing and the chants flowing out of lips fill the air. People float earthen Diyas, with burning flickers and flowers in them as a symbol of hope and wishes .The golden hues of floral diyas reflected in the river Ganges presents spectacular view.</p><strong><p style=\"color:#646464;\">Keep Ganga Clean.<br/>Take a pledge to protect your local water bodies and environment, and to inspire your friends, family and community to do the same.</br></br></br></br></p></strong></body></html>");
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


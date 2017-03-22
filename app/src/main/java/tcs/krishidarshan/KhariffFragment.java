package tcs.krishidarshan;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import tcs.krishidarshan.dummy.DummyCrops;

/**
 * Created by Abhishek on 21-03-2017.
 */

public class KhariffFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;

    public KhariffFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static KhariffFragment newInstance(int columnCount) {
        KhariffFragment fragment = new KhariffFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_crops, container, false);
        //Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
           RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.card_crop_list);
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(new CropsAdapter(DummyCrops.ITEMS));
        }
        return view;
    }
}
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

import tcs.krishidarshan.dummy.DummyContent;
import tcs.krishidarshan.dummy.DummyContent.DummyItem;

/**
 * Created by Abhishek on 23-03-2017.
 */

public class ZaidKhariffFragment extends Fragment {
    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListZaidKhariffFragmentInteractionListener mListener;

    public ZaidKhariffFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static ZaidKhariffFragment newInstance(int columnCount) {
        ZaidKhariffFragment fragment = new ZaidKhariffFragment();
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
            recyclerView.setAdapter(new DataAdapter(DummyContent.ZAID_KHARIFF_ITEMS, mListener));
        }
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListZaidKhariffFragmentInteractionListener) {
            mListener = (ZaidKhariffFragment.OnListZaidKhariffFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnListZaidKhariffFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListZaidKhariffFragmentInteraction(DummyItem item, int position);
    }
}
package com.demo.raj.listofitems;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by raj on 2/4/2016.
 */
public class ItemsFragment extends Fragment {

    // TAG for debugging
    private static final String LOG_TAG = ItemsFragment.class.getSimpleName();

    // Our items ListView
    private ListView mListView;

    // progress bar
    private ProgressBar mProgressBar;

    // empty list view
    private TextView mEmptyView;

    // default constructor
    public ItemsFragment(){}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_items, container, false);

        mListView = (ListView)rootView.findViewById(R.id.items_list);

        mProgressBar = (ProgressBar)rootView.findViewById(R.id.progress_bar);

        mEmptyView = (TextView)rootView.findViewById(R.id.empty);

        return rootView;
    }
}

package com.example.hanh.learningabstract;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hanh.learningabstract.adapter.RecyclerViewAdapter;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends Fragment {

    RecyclerView mRecyclerView;
    RecyclerViewAdapter mRcvAdapter;
    ArrayList<String> data;

    public Fragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_fragment1, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv1);
        data = new ArrayList<>();
        for (int i = 0; i < 100 ; i++) {
            data.add(String.valueOf(i));
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);

        mRcvAdapter = new RecyclerViewAdapter(this.getActivity(),data);
        mRecyclerView.setAdapter(mRcvAdapter);
        return view;
    }

}

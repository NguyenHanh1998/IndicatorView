package com.example.hanh.learningabstract;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment2 extends Fragment {

    ListView listView;

    public Fragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_fragment2, container, false);
        String[] items = new String[100];
        for (int i = 0; i < 100 ; i++) {
            items[i] = String.valueOf(i);
        }
        listView = (ListView) view.findViewById(R.id.list_view);
        DataAdapter dataAdapter = new DataAdapter(this.getActivity(),items);
        listView.setAdapter(dataAdapter);
        return view;
    }

}

package com.example.hanh.learningabstract;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.hanh.learningabstract.adapter.AnswersAdapter;
import com.example.hanh.learningabstract.data.model.Item;
import com.example.hanh.learningabstract.data.model.Product;
import com.example.hanh.learningabstract.data.model.Properties;
import com.example.hanh.learningabstract.data.model.SOAnswersResponse;
import com.example.hanh.learningabstract.data.remote.ApiUtils;
import com.example.hanh.learningabstract.data.remote.SOService;
import com.google.gson.JsonElement;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment3 extends Fragment {

    private RecyclerView recyclerView;
    private AnswersAdapter answersAdapter;
    private SOService soService;

    public Fragment3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment3, container, false);

        soService = ApiUtils.getSOService();
        recyclerView = (RecyclerView) view.findViewById(R.id.rvCallApi);
        answersAdapter = new AnswersAdapter(this.getActivity(), new ArrayList<Product>(0), new AnswersAdapter.PostItemListener() {
            @Override
            public void onPostClick(long id) {
                Toast.makeText(getActivity(), "Post id is: " + id, Toast.LENGTH_SHORT).show();
            }
        });

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(answersAdapter);
        recyclerView.setHasFixedSize(true);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);
        loadAnswers();
        return view;
    }


    public void loadAnswers() {
        soService.getAnswer().enqueue(new Callback<JsonElement>() {
            @Override
            public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
                JSONObject root = null;
                try {
                    root = new JSONObject(response.body().toString());
                    JSONArray array = root.getJSONArray("products");
                    for (int i = 0; i < array.length() ; i++) {
                        JSONObject object = array.getJSONObject(i);
                        Product product = new Product(object);
                        answersAdapter.addItem(product);
                        answersAdapter.notifyDataSetChanged();
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onFailure(Call<JsonElement> call, Throwable t) {

            }
        });
    }
}

package com.example.hanh.learningabstract;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.hanh.learningabstract.data.remote.ApiUtils;
import com.example.hanh.learningabstract.data.remote.Post;
import com.example.hanh.learningabstract.data.remote.PostService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment4 extends Fragment {

    private TextView tvResponse;
    private PostService postService;

    public Fragment4() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment4, container, false);
        final EditText edtTitle = (EditText) view.findViewById(R.id.et_title);
        final EditText edtBody = (EditText) view.findViewById(R.id.et_body);
        Button btnSubmit = (Button) view.findViewById(R.id.btn_submit);
        tvResponse = (TextView) view.findViewById(R.id.tv_response);

        postService = ApiUtils.getPostService();
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = edtTitle.getText().toString().trim();
                String body = edtBody.getText().toString().trim();
                sendPost(title, body);
            }

        });
        return view;
    }

    public void sendPost(String title, String body) {
        postService.savePost(title, body, 12, 15).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (response.isSuccessful()) {
                    showResponse(response.body().toString());
                    Log.i("Fragment4", "post submitted to API" + response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Log.e("Fragment5", "Unable to submit post to API");
            }
        });

    }

    public void showResponse(String response) {
        if (tvResponse.getVisibility() == View.GONE) {
            tvResponse.setVisibility(View.VISIBLE);
        }
        tvResponse.setText(response);
    }
}


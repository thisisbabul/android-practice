package com.example.post.service;

import android.util.Log;

import com.example.post.contract.PostContract;
import com.example.post.model.Post;
import com.example.post.network.ApiClient;
import com.example.post.network.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostModel implements PostContract.Model {
    public static final String TAG = "PostModel";

    @Override
    public void getPosts(OnFinishListener onFinishListener) {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call<List<Post>> call = apiService.getAllPost();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                List<Post> postList = response.body();
                Log.e(TAG, "Number of posts " + postList.size());
                onFinishListener.onFinished(response.body());
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Log.e(TAG, t.getMessage());
                onFinishListener.onFailure(t);
            }
        });
    }
}

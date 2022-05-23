package com.example.post.network;

import com.example.post.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("/posts")
    Call<List<Post>> getAllPost();
}

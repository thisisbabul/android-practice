package com.example.post;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.post.contract.PostContract;
import com.example.post.model.Post;
import com.example.post.presenter.PostPresenter;
import com.example.post.view.PostAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements PostContract.View {
    PostPresenter postPresenter;
    RecyclerView recyclerViewPost;
    List<Post> postList;
    PostAdapter postAdapter;
    LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewPost = findViewById(R.id.rvPost);

        postList = new ArrayList<>();
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerViewPost.setLayoutManager(linearLayoutManager);
        recyclerViewPost.setHasFixedSize(true);

        postPresenter = new PostPresenter(this);
        postPresenter.requestDataFromServer();
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void setDataToRecyclerview(List<Post> postList) {
        postList.addAll(postList);
        postAdapter = new PostAdapter(postList);
        recyclerViewPost.setAdapter(postAdapter);
    }

    @Override
    public void onResponseFailure(Throwable t) {

    }
}
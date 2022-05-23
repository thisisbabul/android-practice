package com.example.post.presenter;

import com.example.post.contract.PostContract;
import com.example.post.model.Post;
import com.example.post.service.PostModel;

import java.util.List;

public class PostPresenter implements PostContract.Presenter, PostContract.Model.OnFinishListener {
    private PostContract.View postView;
    private PostContract.Model postModel;

    public PostPresenter(PostContract.View postView) {
        this.postView = postView;
        this.postModel = new PostModel();
    }

    @Override
    public void onDestroy() {
        postView = null;
        postModel = null;
    }

    @Override
    public void getMoreData() {
        if (postView != null) {
            postView.showProgress();
        }
        postModel.getPosts(this);
    }

    @Override
    public void requestDataFromServer() {
        if (postView != null) {
            postView.showProgress();
        }
        postModel.getPosts(this);
    }

    @Override
    public void onFinished(List<Post> postList) {
        postView.setDataToRecyclerview(postList);
        if (postView != null) {
            postView.hideProgress();
        }
    }

    @Override
    public void onFailure(Throwable t) {
        postView.onResponseFailure(t);
        if (postView != null) {
            postView.hideProgress();
        }
    }
}

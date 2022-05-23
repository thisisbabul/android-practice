package com.example.post.contract;

import com.example.post.model.Post;

import java.util.List;

public interface PostContract {
    interface Model {
        interface OnFinishListener {
            void onFinished(List<Post> postList);
            void onFailure(Throwable t);
        }
        void getPosts(OnFinishListener onFinishListener);
    }

    interface View {
        void showProgress();
        void hideProgress();
        void setDataToRecyclerview(List<Post> postList);
        void onResponseFailure(Throwable t);
    }

    interface Presenter {
        void onDestroy();
        void getMoreData();
        void requestDataFromServer();
    }
}

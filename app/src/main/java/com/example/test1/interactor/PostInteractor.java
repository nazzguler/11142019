package com.example.test1.interactor;

import com.example.test1.model.PostModel;
import com.example.test1.network.PostApi;

import java.util.List;

import io.reactivex.Observable;

public class PostInteractor {

    private PostApi postApi;

    public PostInteractor(PostApi postApi) {
        this.postApi = postApi;
    }

    public Observable<List<PostModel>> getObservable(){
        return postApi.getPosts();
    }


}

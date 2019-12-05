package com.example.test1.network;

import com.example.test1.model.PostModel;

import java.util.List;
import io.reactivex.Observable;

import retrofit2.http.GET;

public interface PostApi {

    @GET("/posts")
    Observable<List<PostModel>> getPosts();
}

package com.example.test1.interfaces;

import com.example.test1.model.PostModel;

import java.util.List;

public interface MainViewInterface {

    void showErrorMessage(String message);
    void showTotalOfPosts(Integer total);
    void showItemsInRecyclerView(List<PostModel> posts);
}

package com.example.test1;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test1.adapters.PostAdapter;
import com.example.test1.interactor.PostInteractor;
import com.example.test1.interfaces.MainViewInterface;
import com.example.test1.model.PostModel;
import com.example.test1.network.PostApi;
import com.example.test1.network.RetrofitManager;
import com.example.test1.presenter.MainPresenter;

import java.util.List;


public class MainActivity extends AppCompatActivity implements MainViewInterface {

    private MainPresenter mainPresenter;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        mainPresenter = new MainPresenter(
                new PostInteractor(RetrofitManager.getInstance().getRetrofit().create(PostApi.class)),
                this);
        mainPresenter.getPosts();
    }

    @Override
    public void showErrorMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showTotalOfPosts(Integer total) {
        Toast.makeText(this, total.toString(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void showItemsInRecyclerView(List<PostModel> posts) {
        mAdapter =  new PostAdapter(posts);
        recyclerView.setAdapter(mAdapter);
    }


}

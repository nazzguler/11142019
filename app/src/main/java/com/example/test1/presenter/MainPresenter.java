package com.example.test1.presenter;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.test1.interactor.PostInteractor;
import com.example.test1.interfaces.MainPresenterInterface;
import com.example.test1.interfaces.MainViewInterface;
import com.example.test1.model.PostModel;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainPresenter implements MainPresenterInterface {

    private PostInteractor postInteractor;
    private MainViewInterface mainViewInterface;
    public MutableLiveData responseLiveData;
    private final String _TAG = "TAG";

    public MainPresenter(PostInteractor postInteractor, MainViewInterface mainViewInterface) {
        this.postInteractor = postInteractor;
        this.mainViewInterface = mainViewInterface;
        responseLiveData = new MutableLiveData();
    }

    @Override
    public void getPosts() {
        postInteractor
                .getObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<PostModel>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<PostModel> value) {
                        responseLiveData.postValue(value);
                        mainViewInterface.showTotalOfPosts(value.size());
                        syncData(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        mainViewInterface.showErrorMessage(e.getMessage());
                        Log.d(_TAG,e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

     void syncData(List<PostModel> posts){
        mainViewInterface.showItemsInRecyclerView(posts);
    }

}

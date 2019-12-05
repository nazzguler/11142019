package com.example.test1.presenter;

import com.example.test1.interactor.PostInteractor;
import com.example.test1.interfaces.MainViewInterface;
import com.example.test1.model.PostModel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MainPresenterTest {

    private MainPresenter mainPresenter;

    @Mock
    private PostInteractor postInteractor;
    @Mock
    private PostModel postModel;

    private List<PostModel> posts = Collections.singletonList(postModel);
    @Mock
    private MainViewInterface view;

    @Before
    public void setUp(){
        mainPresenter = new MainPresenter(postInteractor, view);
    }

    @After
    public void tearDown(){
        postInteractor = null;
        mainPresenter = null;
    }

    @Test
    public void dataShouldNotBeNull(){
        when(postModel.getTitle()).thenReturn("title");
        when(postModel.getBody()).thenReturn("body");
        mainPresenter.syncData(posts);
        verify(view).showItemsInRecyclerView(posts);
    }

}
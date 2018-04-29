package com.smoothspark.msgme.ui.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.smoothspark.msgme.R;
import com.smoothspark.msgme.ui.base.BaseActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by SmoothSpark on 2018. 04. 27.
 */
public class MainPageActivity extends BaseActivity implements MainPageMvpView {

    @Inject
    MainPageMvpPresenter<MainPageMvpView> presenter;

    @Inject
    MainMessageListAdapter messageListAdapter;

    @Inject
    LinearLayoutManager layoutManager;

    @BindView(R.id.messageRecyclerView)
    RecyclerView recyclerView;

    public static Intent getStartIntent(Context context) {
        return new Intent(context, MainPageActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getActivityComponent().inject(this);

        setUnbinder(ButterKnife.bind(this));

        presenter.onAttach(this);

        initLayout();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void updateMessagesList(String text) {
        messageListAdapter.addItems(text);
    }

    @Override
    protected void onDestroy() {
        presenter.onDetach();
        super.onDestroy();
    }

    private void initLayout() {
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(messageListAdapter);

        presenter.openWebSocket();
    }
}

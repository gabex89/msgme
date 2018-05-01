package com.smoothspark.msgme.ui.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.smoothspark.msgme.R;
import com.smoothspark.msgme.ui.base.BaseActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by SmoothSpark on 2018. 04. 27.
 */
public class MainPageActivity extends BaseActivity implements MainPageMvpView {

    private static final String EMPTY_TEXT = "";

    @Inject
    MainPageMvpPresenter<MainPageMvpView> presenter;

    @Inject
    MainMessageListAdapter messageListAdapter;

    @Inject
    LinearLayoutManager layoutManager;

    @BindView(R.id.messageRecyclerView)
    RecyclerView recyclerView;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @BindView(R.id.sendButton)
    Button sendButton;

    @BindView(R.id.messageEditText)
    EditText messageEditText;

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
        runOnUiThread(() -> progressBar.setVisibility(View.VISIBLE));
    }

    @Override
    public void hideLoading() {
        runOnUiThread(() -> progressBar.setVisibility(View.GONE));
    }

    @Override
    public void updateMessagesList(String text) {
        runOnUiThread(() -> messageListAdapter.addItem(text));
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

        messageEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                sendButton.setEnabled(s.length() > 0);
            }
        });
    }

    @OnClick(R.id.sendButton)
    void sendMessage() {
        String message = messageEditText.getText().toString();
        if (presenter.sendMessage(message)) {
            messageEditText.setText(EMPTY_TEXT);
            messageListAdapter.addItem(message);
        }
    }
}

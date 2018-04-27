package com.smoothspark.msgme.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.smoothspark.msgme.MsgMeApplication;
import com.smoothspark.msgme.di.component.ActivityComponent;
import com.smoothspark.msgme.di.component.DaggerActivityComponent;
import com.smoothspark.msgme.utils.NetworkUtil;

import butterknife.Unbinder;

/**
 * Created by SmoothSpark on 2018. 04. 27.
 */
public abstract class BaseActivity extends AppCompatActivity implements MvpView {

    private ActivityComponent activityComponent;

    private Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityComponent = DaggerActivityComponent.builder()
                .applicationComponent(((MsgMeApplication) getApplication()).getComponent())
                .build();
    }

    @Override
    protected void onDestroy() {
        if (unbinder != null) {
            unbinder.unbind();
        }
        super.onDestroy();
    }

    @Override
    public void onError(int stringId) {
        onError(getString(stringId));
    }

    @Override
    public void onError(String msg) {
        if (msg != null) {
            showSnackBar(msg);
        } else {
            showSnackBar("Some error occurred!");
        }
    }

    @Override
    public void showMessage(int stringId) {
        showMessage(getString(stringId));
    }

    @Override
    public void showMessage(String msg) {
        if (msg != null) {
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Some error occurred!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean isNetworkConnected() {
        return NetworkUtil.isNetworkConnected(getApplicationContext());
    }

    public ActivityComponent getActivityComponent() {
        return activityComponent;
    }

    public void setUnbinder(Unbinder unbinder) {
        this.unbinder = unbinder;
    }

    private void showSnackBar(String msg) {
        Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), msg, Snackbar.LENGTH_SHORT);
        TextView textView = snackbar.getView()
                .findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(ContextCompat.getColor(this, android.R.color.white));
        snackbar.show();
    }

}

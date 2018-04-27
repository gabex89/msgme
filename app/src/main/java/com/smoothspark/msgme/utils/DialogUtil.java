package com.smoothspark.msgme.utils;

import android.content.Context;
import android.widget.ProgressBar;

/**
 * Created by SmoothSpark on 2018. 04. 27.
 */
public final class DialogUtil {

    private DialogUtil() {
        //instantiate is forbidden
    }

    public static ProgressBar showProgressBar(Context context) {
        ProgressBar progressBar = new ProgressBar(context);
        return progressBar;
    }
}

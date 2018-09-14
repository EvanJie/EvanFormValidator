package com.hcb.formvalidate;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Evan (JieYu.Wang) on 2018/9/13.
 */

public class DefaultErrorWay implements ErrorHandler {
    public DefaultErrorWay(Context context) {
        mContext = context;
    }

    private Context mContext;

    @Override
    public void showErrorMessage(String message) {
        Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
    }
}

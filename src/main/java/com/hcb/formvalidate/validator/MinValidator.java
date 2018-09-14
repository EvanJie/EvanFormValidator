package com.hcb.formvalidate.validator;

import android.widget.TextView;

import com.hcb.formvalidate.Validator;

/**
 * Created by Evan (JieYu.Wang) on 2018/9/12.
 */

public class MinValidator extends Validator {
    private int mMin;
    private String mMinError = "字符长度不能小于";

    public MinValidator(TextView textView , int min) {
        super(textView);
        mMin = min;
        mErrorMessage = mMinError + " " + mMin;

    }

    @Override
    protected boolean validate(String s) {
        int length = s.length();
        if (length < mMin) {
            return false;
        }
        return true;
    }
}

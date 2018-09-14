package com.hcb.formvalidate.validator;

import android.text.TextUtils;
import android.widget.TextView;

import com.hcb.formvalidate.Validator;

/**
 * Created by Evan (JieYu.Wang) on 2018/9/13.
 */

public class RequiredValidator extends Validator {
    public RequiredValidator(TextView textView, String errorMessage) {
        super(textView);
        mErrorMessage = errorMessage;
    }

    @Override
    protected boolean validate(String s) {
        return !TextUtils.isEmpty(s);
    }
}

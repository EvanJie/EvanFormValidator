package com.hcb.formvalidate.validator;

import android.widget.TextView;

import com.hcb.formvalidate.Condition;
import com.hcb.formvalidate.Validator;

/**
 * Created by Evan (JieYu.Wang) on 2018/9/12.
 */

public class MaxValidator extends Validator {
    private int mMax;
    private String maxError ="字符长度不能大于" ;

    public MaxValidator(TextView textView, String maxErrorMessage, int max) {
        super(textView);
        this.mMax = max;
        if (maxErrorMessage != null) {
            this.maxError = maxErrorMessage;
        }
    }

    public MaxValidator(TextView textView, String maxErrorMessage, int max, Condition condition) {
        super(textView);
        this.mMax = max;
        if (maxErrorMessage != null) {
            this.maxError = maxErrorMessage;
        }
        mCondition = condition;
    }

    @Override
    protected boolean validate(String s) {
        int length = s.length();
        if (length > mMax) {
            mErrorMessage = maxError + " " + mMax;
            return false;
        }
        return true;
    }


}

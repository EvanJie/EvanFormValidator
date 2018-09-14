package com.hcb.formvalidate;

import android.widget.EditText;
import android.widget.TextView;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Evan (JieYu.Wang) on 2018/9/12.
 */

public abstract class Validator extends Observable {
    protected TextView mTextView;
    protected String mErrorMessage;
    protected boolean result = true;
    protected Condition mCondition;

    public Validator(TextView textView) {
        mTextView = textView;
    }

    protected abstract boolean validate(String s);

    protected void onError(ErrorHandler errorHandler) {
        if (mTextView == null) {
            errorHandler.showErrorMessage(mErrorMessage);
        } else {
            if (mTextView instanceof EditText) {
                mTextView.setError(mErrorMessage);
            } else {
                mTextView.setError(mErrorMessage);
                mTextView.requestFocus();
                errorHandler.showErrorMessage(mErrorMessage);
            }
        }
    }

    public Validator addValidateObserver(Observer observer) {
        addObserver(observer);
        return this;
    }

    public void upDateValidateStatus(boolean pass) {
        result = pass;
        setChanged();
        notifyObservers(result);
    }

    public Condition getCondition() {
        return mCondition;
    }

    public Validator setCondition(Condition condition) {
        mCondition = condition;
        return this;
    }
}

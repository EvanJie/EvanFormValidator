package com.hcb.formvalidate;

/**
 * Created by Evan (JieYu.Wang) on 2018/9/12.
 */

public class FormValidator extends ValidationManager {
    private boolean isAllValid = true;
    private ErrorHandler mErrorHandler;

    public ValidationManager initErrorHandle(ErrorHandler handler) {
        mErrorHandler = handler;
        return this;
    }

    @Override
    public ValidationManager add(Validator... validators) {
        for (Validator validator : validators) {
            mValidators.add(validator);
        }
        return this;
    }

    @Override
    public ValidationManager startValidation() {
        isAllValid = true;

        for (Validator item : mValidators) {
            //如果包含Condition，并且condition 不满足， 就不
            if (item.mCondition != null && !((Conditional) item).condition().call()) {
                continue;
            }

            boolean validate = item.validate(item.mTextView.getText().toString());
            item.upDateValidateStatus(validate);
            if (!validate) {

                isAllValid = false;
                item.onError(mErrorHandler);

            }
        }
        return this;
    }

    @Override
    public boolean isAnyHasText() {
        return false;
    }

    @Override
    public boolean isAllValid() {
        return isAllValid;
    }
}

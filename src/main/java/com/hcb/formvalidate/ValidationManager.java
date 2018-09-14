package com.hcb.formvalidate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Evan (JieYu.Wang) on 2018/9/12.
 */

public abstract class ValidationManager {
    List<Validator> mValidators = new ArrayList<>();

    /**
     * Add one or more {@link Validator} to validate a TextView
     *
     * @param validators instances of {@link Validator}
     * @return this
     */
    public abstract ValidationManager add(Validator... validators);

    /**
     * Call this method to start validation
     *
     * @return this
     */
    public abstract ValidationManager startValidation();

    /**
     * Call this method to check if any field has text.
     *
     * @return true if any has text.
     */
    public abstract boolean isAnyHasText();

    public abstract boolean isAllValid();
}

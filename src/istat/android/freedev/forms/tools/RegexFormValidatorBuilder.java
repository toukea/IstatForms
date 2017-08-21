package istat.android.freedev.forms.tools;


import java.util.ArrayList;
import java.util.List;

import istat.android.freedev.forms.FormValidator;
import istat.android.freedev.forms.FormValidator.FieldValidator;
import istat.android.freedev.forms.interfaces.FormValidatorBuilder;

class RegexFormValidatorBuilder implements FormValidatorBuilder {
    protected RegexFormConstraintBuilder conditionBuilder = new RegexFormConstraintBuilder();

    @Deprecated
    public final static RegexFormValidatorBuilder newInstance() {
        return new RegexFormValidatorBuilder();
    }

    public RegexFormValidatorBuilder appendFieldValidationParams(
            String fieldName, String regexCondition, String message) {
        conditionBuilder.appendFieldValidationParams(fieldName, regexCondition,
                message);
        return this;
    }

    public RegexFormValidatorBuilder applyFieldValidationParams(
            String fieldName, String regexCondition, String message) {
        conditionBuilder.applyFieldValidationParams(fieldName, regexCondition,
                message);
        return this;
    }

    public RegexFormValidatorBuilder applyFieldValidator(String fieldName,
                                                         RegexFieldValidator validator) {
        conditionBuilder.applyFieldValidator(fieldName, validator);
        return this;
    }

    public RegexFormValidatorBuilder appendFieldValidator(String fieldName,
                                                          RegexFieldValidator validator) {
        conditionBuilder.appendFieldValidator(fieldName, validator);
        return this;
    }

    public RegexFormValidatorBuilder appendAllFieldValidator(String fieldName,
                                                             List<RegexFieldValidator> validator) {
        conditionBuilder.appendAllFieldValidator(fieldName, validator);
        return this;
    }

    public RegexFormValidatorBuilder applyFieldValidators(String fieldName,
                                                          List<RegexFieldValidator> regexValidators) {
        List<FieldValidator> validators = new ArrayList<FieldValidator>();
        validators.addAll(regexValidators);
        conditionBuilder.applyFieldValidators(fieldName, validators);
        return this;
    }

    public FormValidator create() {
        FormValidator validator = new FormValidator();
        validator.setConstraints(conditionBuilder.create());
        return validator;
    }
}

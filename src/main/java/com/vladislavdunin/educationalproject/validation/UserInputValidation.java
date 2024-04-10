package com.vladislavdunin.educationalproject.validation;

import com.vladislavdunin.educationalproject.constants.Constants;

public class UserInputValidation{
    public boolean validateArguments(String[] arguments, boolean isExtendedMethod) {
        if (arguments.length <= 1 || arguments.length > 4) {
            return false;
        }

        if (!isExtendedMethod) {
            if (Integer.parseInt(arguments[3]) > Constants.ALL_SYMBOLS.size()) {
                return false;
            }
        }

        return true;
    }
}

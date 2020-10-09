package com.epam.triangle.logic.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExDataValidator implements DataValidator {

    private static final String ENTIRE_LINE_REQUIREMENT = "(\\D*\\d+\\.\\d+\\D*){6}\\D*";
    private static final Pattern PATTERN = Pattern.compile(ENTIRE_LINE_REQUIREMENT);

    @Override
    public boolean isValid(String data) {
        Matcher matcher = PATTERN.matcher(data);
        if (matcher.find()) {
            String result = matcher.group();
            return result.equals(data);
        }
        return false;
    }
}

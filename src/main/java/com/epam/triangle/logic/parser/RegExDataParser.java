package com.epam.triangle.logic.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExDataParser implements DataParser {

    private static final String DOUBLE_VALUE = "-?\\d+\\.\\d+";
    private static final Pattern PATTERN = Pattern.compile(DOUBLE_VALUE);

    @Override
    public List<Double> parse(String data) {
        List<Double> values = new ArrayList<Double>();
        Matcher matcher = PATTERN.matcher(data);
        while (matcher.find()) {
            String found = matcher.group();
            double value = Double.parseDouble(found);
            values.add(value);
        }
        return values;
    }
}

package com.epam.triangle.logic.parser;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class RegExDataParserTest {

    private static final String VALID_STRING = "-59.0 -35.4 -6.0 35.0 59.65 -18.0";
    private final RegExDataParser parser = new RegExDataParser();

    @Test
    public void testParseShouldReturnCorrectListOfDoubles() {
        //given
        //when
        List<Double> actual = parser.parse(VALID_STRING);
        //then
        List<Double> expected = Arrays.asList(-59.0, -35.4, -6.0, 35.0, 59.65, -18.0);
        Assert.assertEquals(actual, expected);
    }
}

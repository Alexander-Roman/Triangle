package com.epam.triangle.logic.validator;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RegExDataValidatorTest {

    private static final String VALID_STRING = "-59.0 -35.4 -6.0 35.0 59.65 -18.0";
    private static final String INVALID_VALUE_STRING = "-5z9.0 -35.0 -6.0 35.0 59.0 -18.0";
    private static final String NOT_ENOUGH_STRING = "-59.0 -35.0 -6.0 35.0 59.0";
    private static final String EXTRA_VALUE_STRING = "-59.0 -35.0 -6.0 35.0 59.0 -18.0 3.6";
    private final RegExDataValidator validator = new RegExDataValidator();

    @Test
    public void isValidTestShouldReturnTrueWhenThereAreSixDoubleValuesInString() {
        //given
        //when
        boolean actual = validator.isValid(VALID_STRING);
        //then
        Assert.assertTrue(actual);
    }

    @Test
    public void isValidTestShouldReturnFalseWhenDataStringIsCorrupted() {
        //given
        //when
        boolean actual = validator.isValid(INVALID_VALUE_STRING);
        //then
        Assert.assertFalse(actual);
    }

    @Test
    public void isValidTestShouldReturnFalseWhenLessThanSixDoubleValuesInString() {
        //given
        //when
        boolean actual = validator.isValid(NOT_ENOUGH_STRING);
        //then
        Assert.assertFalse(actual);
    }

    @Test
    public void isValidTestShouldReturnFalseWhenExtraValuesInString() {
        //given
        //when
        boolean actual = validator.isValid(EXTRA_VALUE_STRING);
        //then
        Assert.assertFalse(actual);
    }



}

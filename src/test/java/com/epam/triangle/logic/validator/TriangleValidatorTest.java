package com.epam.triangle.logic.validator;

import com.epam.triangle.entity.Point;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TriangleValidatorTest {

    private final TriangleValidator validator = new TriangleValidator();

    @Test
    public void isOneStraightLineTestShouldReturnTrueWhenPointsLieOnOneStraightLine() {
        //given
        Point a = new Point(-5.0, -5.0);
        Point b = new Point(0.0, 0.0);
        Point c = new Point(6.0, 6.0);
        //when
        boolean actual = validator.isOneStraightLine(a, b, c);
        //then
        Assert.assertTrue(actual);
    }

    @Test
    public void isOneStraightLineTestShouldReturnFalseWhenPointsDoNotLieOnOneStraightLine() {
        //given
        Point a = new Point(1.0, 2.0);
        Point b = new Point(0.0, 0.0);
        Point c = new Point(6.0, 6.0);
        //when
        boolean actual = validator.isOneStraightLine(a, b, c);
        //then
        Assert.assertFalse(actual);
    }
}

package com.epam.triangle.entity;

import com.epam.triangle.exception.TriangleException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TriangleTest {

    @Test
    public void ofTestShouldReturnTriangleWhenPointsAreNotOnOneStraightLine() throws TriangleException {
        //given
        Point a = new Point(1.0, 2.0);
        Point b = new Point(0.0, 0.0);
        Point c = new Point(6.0, 6.0);
        //when
        Triangle actual = Triangle.of(a, b, c);
        //then
        Assert.assertNotNull(actual);
    }

    @Test(expectedExceptions = TriangleException.class)
    public void ofTestShouldThrowExceptionWhenPointsOnOneStraightLine() throws TriangleException {
        //given
        Point a = new Point(-5.0, -5.0);
        Point b = new Point(0.0, 0.0);
        Point c = new Point(6.0, 6.0);
        //when
        Triangle.of(a, b, c);
        //then
    }
}

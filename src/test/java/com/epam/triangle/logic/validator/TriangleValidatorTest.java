package com.epam.triangle.logic.validator;

import com.epam.triangle.entity.Point;
import com.epam.triangle.entity.Triangle;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TriangleValidatorTest {

    private final TriangleValidator validator = new TriangleValidator();

    @Test
    public void testIsTriangleShouldReturnTrueWhenTopsDoNotLieOnOneStraightLine() {
        //given
        Point a = new Point(1.0, 2.0);
        Point b = new Point(0.0, 0.0);
        Point c = new Point(6.0, 6.0);
        Triangle triangle = new Triangle(a, b, c);
        //when
        boolean actual = validator.isTriangle(triangle);
        //then
        Assert.assertTrue(actual);
    }

    @Test
    public void testIsTriangleShouldReturnFalseWhenTopsLieOnOneStraightLine() {
        //given
        Point a = new Point(-5.0, -5.0);
        Point b = new Point(0.0, 0.0);
        Point c = new Point(6.0, 6.0);
        Triangle triangle = new Triangle(a, b, c);
        //when
        boolean actual = validator.isTriangle(triangle);
        //then
        Assert.assertFalse(actual);
    }
}

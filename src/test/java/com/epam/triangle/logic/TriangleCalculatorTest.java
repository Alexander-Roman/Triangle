package com.epam.triangle.logic;

import com.epam.triangle.entity.Point;
import com.epam.triangle.entity.Triangle;
import com.epam.triangle.exception.TriangleException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TriangleCalculatorTest {

    private final TriangleCalculator calculator = new TriangleCalculator();
    private Triangle regular;
    private Triangle rectangular;
    private Triangle obtuse;
    private Triangle isosceles;

    @BeforeClass
    public void setUp() throws TriangleException {
        {
            Point a = new Point(-10.0, -20.0);
            Point b = new Point(40.0, 66.603);
            Point c = new Point(90.0, -20.0);
            regular = Triangle.of(a, b, c);
        }
        {
            Point a = new Point(-17.355, 35.355);
            Point b = new Point(18.0, 0.0);
            Point c = new Point(-17.355, -35.355);
            rectangular = Triangle.of(a, b, c);
        }
        {
            Point a = new Point(16.0, -19.0);
            Point b = new Point(85.0, -29.0);
            Point c = new Point(120.0, -75.0);
            obtuse = Triangle.of(a, b, c);
        }
        {
            Point a = new Point(37.397, 62.418);
            Point b = new Point(53.56, -73.361);
            Point c = new Point(-95.835, 31.659);
            isosceles = Triangle.of(a, b, c);
        }
    }

    @AfterClass
    public void tearDown() {
        regular = null;
        rectangular = null;
        obtuse = null;
        isosceles = null;
    }

    @Test
    public void getPerimeterTestShouldReturnCorrectPerimeterValue() {
        //given
        //when
        double actual = calculator.getPerimeter(regular);
        //then
        double expected = 300.0;
        Assert.assertEquals(actual, expected, 0.1);
    }

    @Test
    public void getAreaTestShouldReturnCorrectAreaValue() {
        //given
        //when
        double actual = calculator.getArea(rectangular);
        //then
        double expected = 1250.0;
        Assert.assertEquals(actual, expected, 0.1);
    }

    @Test
    public void isRectangularTestShouldReturnTrueWhenRectangular() {
        //given
        //when
        boolean actual = calculator.isRectangular(rectangular);
        //then
        Assert.assertTrue(actual);
    }

    @Test
    public void isRectangularTestShouldReturnFalseWhenNotRectangular() {
        //given
        //when
        boolean actual = calculator.isRectangular(regular);
        //then
        Assert.assertFalse(actual);
    }

    @Test
    public void isAcuteAngledTestShouldReturnTrueWhenAcuteAngled() {
        //given
        //when
        boolean actual = calculator.isAcuteAngled(regular);
        //then
        Assert.assertTrue(actual);
    }

    @Test
    public void isAcuteAngledTestShouldReturnFalseWhenNotAcuteAngled() {
        //given
        //when
        boolean actual = calculator.isAcuteAngled(rectangular);
        //then
        Assert.assertFalse(actual);
    }

    @Test
    public void isObtuseTestShouldReturnTrueWhenObtuse() {
        //given
        //when
        boolean actual = calculator.isObtuse(obtuse);
        //then
        Assert.assertTrue(actual);
    }

    @Test
    public void isObtuseTestShouldReturnFalseWhenNotObtuse() {
        //given
        //when
        boolean actual = calculator.isObtuse(rectangular);
        //then
        Assert.assertFalse(actual);
    }

    @Test
    public void isIsoscelesTestShouldReturnTrueWhenIsosceles() {
        //given
        //when
        boolean actual = calculator.isIsosceles(isosceles);
        //then
        Assert.assertTrue(actual);
    }

    @Test
    public void isIsoscelesTestShouldReturnFalseWhenNotIsosceles() {
        //given
        //when
        boolean actual = calculator.isIsosceles(obtuse);
        //then
        Assert.assertFalse(actual);
    }

    @Test
    public void isRegularTestShouldReturnTrueWhenRegular() {
        //given
        //when
        boolean actual = calculator.isRegular(regular);
        //then
        Assert.assertTrue(actual);
    }

    @Test
    public void isRegularTestShouldReturnFalseWhenNotRegular() {
        //given
        //when
        boolean actual = calculator.isRegular(rectangular);
        //then
        Assert.assertFalse(actual);
    }

}

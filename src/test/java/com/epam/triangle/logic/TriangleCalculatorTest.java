package com.epam.triangle.logic;

import com.epam.triangle.entity.Point;
import com.epam.triangle.entity.Triangle;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TriangleCalculatorTest {

    private final TriangleCalculator calculator = new TriangleCalculator();
    private Triangle regular;
    private Triangle rectangular;
    private Triangle obtuse;
    private Triangle isosceles;

    @BeforeClass
    public void setUp() {
        {
            Point a = new Point(-10.0, -20.0);
            Point b = new Point(40.0, 66.603);
            Point c = new Point(90.0, -20.0);
            regular = new Triangle(a, b, c);
        }
        {
            Point a = new Point(-17.355, 35.355);
            Point b = new Point(18.0, 0.0);
            Point c = new Point(-17.355, -35.355);
            rectangular = new Triangle(a, b, c);
        }
        {
            Point a = new Point(16.0, -19.0);
            Point b = new Point(85.0, -29.0);
            Point c = new Point(120.0, -75.0);
            obtuse = new Triangle(a, b, c);
        }
        {
            Point a = new Point(37.397, 62.418);
            Point b = new Point(53.56, -73.361);
            Point c = new Point(-95.835, 31.659);
            isosceles = new Triangle(a, b, c);
        }
    }

    @Test
    public void testGetPerimeterShouldReturnCorrectPerimeterValue() {
        //given
        //when
        double actual = calculator.getPerimeter(regular);
        //then
        double expected = 300.0;
        Assert.assertEquals(actual, expected, 0.1);
    }

    @Test
    public void testGetAreaShouldReturnCorrectAreaValue() {
        //given
        //when
        double actual = calculator.getArea(rectangular);
        //then
        double expected = 1250.0;
        Assert.assertEquals(actual, expected, 0.1);
    }

    @Test
    public void testIsRectangularShouldReturnTrueWhenRectangular() {
        //given
        //when
        boolean actual = calculator.isRectangular(rectangular);
        //then
        Assert.assertTrue(actual);
    }

    @Test
    public void testIsRectangularShouldReturnFalseWhenNotRectangular() {
        //given
        //when
        boolean actual = calculator.isRectangular(regular);
        //then
        Assert.assertFalse(actual);
    }

    @Test
    public void testIsAcuteAngledShouldReturnTrueWhenAcuteAngled() {
        //given
        //when
        boolean actual = calculator.isAcuteAngled(regular);
        //then
        Assert.assertTrue(actual);
    }

    @Test
    public void testIsAcuteAngledShouldReturnFalseWhenNotAcuteAngled() {
        //given
        //when
        boolean actual = calculator.isAcuteAngled(rectangular);
        //then
        Assert.assertFalse(actual);
    }

    @Test
    public void testIsObtuseShouldReturnTrueWhenObtuse() {
        //given
        //when
        boolean actual = calculator.isObtuse(obtuse);
        //then
        Assert.assertTrue(actual);
    }

    @Test
    public void testIsObtuseShouldReturnFalseWhenNotObtuse() {
        //given
        //when
        boolean actual = calculator.isObtuse(rectangular);
        //then
        Assert.assertFalse(actual);
    }

    @Test
    public void testIsIsoscelesShouldReturnTrueWhenIsosceles() {
        //given
        //when
        boolean actual = calculator.isIsosceles(isosceles);
        //then
        Assert.assertTrue(actual);
    }

    @Test
    public void testIsIsoscelesShouldReturnFalseWhenNotIsosceles() {
        //given
        //when
        boolean actual = calculator.isIsosceles(obtuse);
        //then
        Assert.assertFalse(actual);
    }

    @Test
    public void testIsRegularShouldReturnTrueWhenRegular() {
        //given
        //when
        boolean actual = calculator.isRegular(regular);
        //then
        Assert.assertTrue(actual);
    }

    @Test
    public void testIsRegularShouldReturnFalseWhenNotRegular() {
        //given
        //when
        boolean actual = calculator.isRegular(rectangular);
        //then
        Assert.assertFalse(actual);
    }

}

package com.epam.triangle.logic;

import com.epam.triangle.entity.Point;
import com.epam.triangle.entity.Triangle;
import com.epam.triangle.exception.TriangleException;
import com.epam.triangle.logic.parser.DataParser;
import com.epam.triangle.logic.parser.RegExDataParser;
import com.epam.triangle.logic.validator.DataValidator;
import com.epam.triangle.logic.validator.RegExDataValidator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class TriangleCreatorTest {

    private static final String CORRECT_TRIANGLE = "Triangle{a=Point{x=-59.0, y=-35.0}, b=Point{x=-6.0, y=35.0}, c=Point{x=59.0, y=-18.0}}";
    private static final String NOT_A_TRIANGLE = "Triangle{a=Point{x=-5.0, y=-5.0}, b=Point{x=0.0, y=0.0}, c=Point{x=6.0, y=6.0}}";
    private static final String VALUE_CORRUPTED = "Triangle{a=Point{x=33.0, y=4z5.0}, b=Point{x=-76.0, y=-85.0}, c=Point{x=67.0, y=-6.0}}";
    private static final String VALUE_LOST = "Triangle{a=Point{x=33.0, y=45.0}, b=Point{x=-76.0, y=-85.0}, c=Point{x=67.0, y=}}";
    private static final String EXTRA_VALUES = "Quadrilateral{a=Point{x=33.0, y=45.0}, b=Point{x=-76.0, y=-85.0}, c=Point{x=67.0, y=-6.0}, d=Point{x=15.0, y=96.0}}";

    private TriangleCreator creator;
    private Triangle correct;

    @BeforeClass
    public void setUp() throws TriangleException {
        DataParser parser = new RegExDataParser();
        DataValidator validator = new RegExDataValidator();
        creator = new TriangleCreator(parser, validator);

        Point a = new Point(-59.0, -35.0);
        Point b = new Point(-6.0, 35.0);
        Point c = new Point(59.0, -18.0);
        correct = Triangle.of(a, b, c);
    }

    @AfterClass
    public void tearDown() {
        creator = null;
        correct = null;
    }

    @Test
    public void createTestShouldCreateTriangleWhenDataLineIsCorrect() {
        //given
        List<String> data = List.of(CORRECT_TRIANGLE, CORRECT_TRIANGLE);
        //when
        List<Triangle> actual = creator.create(data);
        //then
        List<Triangle> expected = List.of(correct, correct);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void createTestShouldNotCreateTriangleWhenDataLineIsCorrupted() {
        //given
        List<String> data = List.of(VALUE_CORRUPTED, VALUE_LOST);
        //when
        List<Triangle> actual = creator.create(data);
        //then
        List<Triangle> expected = List.of();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void createTestShouldNotCreateTriangleWhenDataLineHasExtraValues() {
        //given
        List<String> data = List.of(EXTRA_VALUES);
        //when
        List<Triangle> actual = creator.create(data);
        //then
        List<Triangle> expected = List.of();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void createTestShouldNotCreateNotATriangleObjects() {
        //given
        List<String> data = List.of(NOT_A_TRIANGLE);
        //when
        List<Triangle> actual = creator.create(data);
        //then
        List<Triangle> expected = List.of();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void createTestShouldReturnEmptyListIfDataListIsEmpty() {
        //given
        List<String> data = List.of();
        //when
        List<Triangle> actual = creator.create(data);
        //then
        List<Triangle> expected = List.of();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void createTestShouldReturnNotNull() {
        //given
        List<String> data = List.of();
        //when
        List<Triangle> actual = creator.create(data);
        //then
        Assert.assertNotNull(actual);
    }
}

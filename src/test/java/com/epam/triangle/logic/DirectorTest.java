package com.epam.triangle.logic;

import com.epam.triangle.entity.Point;
import com.epam.triangle.entity.Triangle;
import com.epam.triangle.logic.parser.DataParser;
import com.epam.triangle.logic.validator.DataValidator;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class DirectorTest {

    private static final String CORRECT_TRIANGLE = "Triangle{a=Point{x=-59.0, y=-35.0}, b=Point{x=-6.0, y=35.0}, c=Point{x=59.0, y=-18.0}}";
    private static final String VALUE_CORRUPTED = "Triangle{a=Point{x=33.0, y=4z5.0}, b=Point{x=-76.0, y=-85.0}, c=Point{x=67.0, y=-6.0}}";

    private final DataParser parser = Mockito.mock(DataParser.class);
    private final DataValidator validator = Mockito.mock(DataValidator.class);
    private final TriangleCreator creator = Mockito.mock(TriangleCreator.class);
    private final Director director = new Director(parser, validator, creator);

    private Triangle correct;
    private Triangle corrupted;

    @BeforeClass
    public void setUp() {
        Point a = new Point(-59.0, -35.0);
        Point b = new Point(-6.0, 35.0);
        Point c = new Point(59.0, -18.0);
        correct = new Triangle(a, b, c);

        a = new Point(33.0, 5.0);
        b = new Point(-76.0, -85.0);
        c = new Point(67.0, -6.0);
        corrupted = new Triangle(a, b, c);
    }

    @Test
    public void testCreateFromDataShouldCreateTriangleWhenDataLineIsCorrect() {
        //given
        List<String> data = Arrays.asList(CORRECT_TRIANGLE, CORRECT_TRIANGLE);
        //when
        Mockito.when(validator.isValid(Mockito.anyString())).thenReturn(true);
        Mockito.when(parser.parse(Mockito.anyString())).thenReturn(Arrays.asList(-59.0, -35.0, -6.0, 35.0, 59.0, -18.0));
        Mockito.when(creator.create(Mockito.anyList())).thenReturn(Optional.of(correct));
        List<Triangle> actual = director.createFromData(data);
        //then
        List<Triangle> expected = Arrays.asList(correct, correct);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testCreateFromDataShouldNotCreateTriangleWhenDataLineIsCorrupted() {
        //given
        List<String> data = Collections.singletonList(VALUE_CORRUPTED);
        //when
        Mockito.when(validator.isValid(Mockito.anyString())).thenReturn(false);
        Mockito.when(parser.parse(Mockito.anyString())).thenReturn(Arrays.asList(33.0, 5.0, -76.0, -85.0, 67.0, -6.0));
        Mockito.when(creator.create(Mockito.anyList())).thenReturn(Optional.of(corrupted));
        List<Triangle> actual = director.createFromData(data);
        //then
        List<Triangle> expected = Collections.emptyList();
        Assert.assertEquals(actual, expected);
    }
}

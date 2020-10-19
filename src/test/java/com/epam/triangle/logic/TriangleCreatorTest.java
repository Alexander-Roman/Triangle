package com.epam.triangle.logic;

import com.epam.triangle.entity.Point;
import com.epam.triangle.entity.Triangle;
import com.epam.triangle.logic.validator.TriangleValidator;
import org.junit.Test;
import org.mockito.Mockito;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class TriangleCreatorTest {

    private static final List<Double> CORRECT_DATA = Arrays.asList(-59.0, -35.0, -6.0, 35.0, 59.0, -18.0);
    private static final List<Double> NOT_A_TRIANGLE_DATA = Arrays.asList(-5.0, -5.0, 0.0, 0.0, 6.0, 6.0);
    private final TriangleValidator validator = Mockito.mock(TriangleValidator.class);
    private final TriangleCreator creator = new TriangleCreator(validator);
    private final Triangle correct;

    {
        Point a = new Point(-59.0, -35.0);
        Point b = new Point(-6.0, 35.0);
        Point c = new Point(59.0, -18.0);
        correct = new Triangle(a, b, c);
    }

    @Test
    public void testCreateShouldReturnOptionalWithCorrectTriangle() {
        //given
        //when
        Mockito.when(validator.isTriangle(Mockito.any())).thenReturn(true);
        Optional<Triangle> actual = creator.create(CORRECT_DATA);
        //then
        Optional<Triangle> expected = Optional.of(correct);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testCreateShouldReturnEmptyOptionalWhenTriangleIsNotValid() {
        //given
        //when
        Mockito.when(validator.isTriangle(Mockito.any())).thenReturn(false);
        Optional<Triangle> actual = creator.create(NOT_A_TRIANGLE_DATA);
        //then
        Optional<Triangle> expected = Optional.empty();
        Assert.assertEquals(actual, expected);
    }

}

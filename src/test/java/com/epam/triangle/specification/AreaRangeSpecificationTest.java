package com.epam.triangle.specification;

import com.epam.triangle.logic.TriangleCalculator;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AreaRangeSpecificationTest {

    private final TriangleCalculator calculator = Mockito.mock(TriangleCalculator.class);

    @Test
    public void testIsSpecifiedShouldReturnTrueWhenTriangleAreaWithinRange() {
        //given
        AreaRangeSpecification specification = new AreaRangeSpecification(calculator, 10.0, 25.0);
        //when
        Mockito.when(calculator.getArea(Mockito.any())).thenReturn(12.0);
        boolean actual = specification.isSpecified(Mockito.any());
        //then
        Assert.assertTrue(actual);
    }

    @Test
    public void testIsSpecifiedShouldReturnFalseWhenTriangleAreaNotWithinRange() {
        //given
        AreaRangeSpecification specification = new AreaRangeSpecification(calculator, 10.0, 25.0);
        //when
        Mockito.when(calculator.getArea(Mockito.any())).thenReturn(9.0);
        boolean actual = specification.isSpecified(Mockito.any());
        //then
        Assert.assertFalse(actual);
    }
}

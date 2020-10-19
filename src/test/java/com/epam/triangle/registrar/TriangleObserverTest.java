package com.epam.triangle.registrar;

import com.epam.triangle.entity.Point;
import com.epam.triangle.entity.TriangleParameters;
import com.epam.triangle.entity.TriangleType;
import com.epam.triangle.logic.TriangleCalculator;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class TriangleObserverTest {

    private final TriangleCalculator calculator = Mockito.mock(TriangleCalculator.class);
    private final TriangleObserver observer = new TriangleObserver(calculator);
    private final TriangleObservable triangleObservable;

    {
        Point a = new Point(0.0, 0.0);
        Point b = new Point(5.0, 0.0);
        Point c = new Point(0.0, 5.0);
        triangleObservable = new TriangleObservable(a, b, c, 10);
    }

    @DataProvider(name = "triangleParametersCreationArguments")
    public Object[][] getTriangleParametersCreationArguments() {
        double perimeter = 17.0;
        double area = 12.5;
        List<Double> angles = Arrays.asList(45.0, 90.0, 45.0);
        List<Double> sides = Arrays.asList(5.0, 5.0, 7.0);
        TriangleType triangleType = TriangleType.RECTANGULAR;
        return new Object[][]{{perimeter, area, angles, sides, triangleType}};
    }


    @Test(dataProvider = "triangleParametersCreationArguments")
    public void testHandleEventShouldUpdateParameters(double perimeter, double area, List<Double> angles, List<Double> sides, TriangleType triangleType) {
        //given
        //when
        Mockito.when(calculator.getPerimeter(Mockito.any())).thenReturn(perimeter);
        Mockito.when(calculator.getArea(Mockito.any())).thenReturn(area);
        Mockito.when(calculator.getAllAngles(Mockito.any())).thenReturn(angles);
        Mockito.when(calculator.getAllSides(Mockito.any())).thenReturn(sides);
        Mockito.when(calculator.getType(Mockito.any())).thenReturn(triangleType);
        observer.handleEvent(triangleObservable);
        TriangleParameters actual = observer.getParameters(triangleObservable);
        //then
        TriangleParameters expected = new TriangleParameters(perimeter, area, angles, sides, triangleType);
        Assert.assertEquals(actual, expected);
    }
}

package com.epam.triangle.comparator;

import com.epam.triangle.entity.Triangle;
import com.epam.triangle.logic.TriangleCalculator;

import java.util.Comparator;

public class XTriangleComparator implements Comparator<Triangle> {

    private final TriangleCalculator calculator = new TriangleCalculator();

    @Override
    public int compare(Triangle firstTriangle, Triangle secondTriangle) {
        double xMinFirst = calculator.minX(firstTriangle);
        double xMinSecond = calculator.minX(secondTriangle);
        return Double.compare(xMinFirst, xMinSecond);
    }
}

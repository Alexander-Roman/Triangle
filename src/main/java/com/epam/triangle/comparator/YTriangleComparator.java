package com.epam.triangle.comparator;

import com.epam.triangle.entity.Triangle;
import com.epam.triangle.logic.TriangleCalculator;

import java.util.Comparator;

public class YTriangleComparator implements Comparator<Triangle> {

    private final TriangleCalculator calculator = new TriangleCalculator();

    @Override
    public int compare(Triangle firstTriangle, Triangle secondTriangle) {
        double yMinFirst = calculator.minY(firstTriangle);
        double yMinSecond = calculator.minY(secondTriangle);
        return Double.compare(yMinFirst, yMinSecond);
    }
}
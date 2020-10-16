package com.epam.triangle.comparator;

import com.epam.triangle.comparator.point.xComparator;
import com.epam.triangle.entity.Point;
import com.epam.triangle.entity.Triangle;
import com.epam.triangle.logic.TriangleCalculator;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class xCoordinateComparator implements Comparator<Triangle> {

    private final TriangleCalculator calculator = new TriangleCalculator();
    private final Comparator<Point> comparator = new xComparator();

    @Override
    public int compare(Triangle firstTriangle, Triangle secondTriangle) {
        List<Point> firstTriangleTops = calculator.getAllTops(firstTriangle);
        List<Point> secondTriangleTops = calculator.getAllTops(secondTriangle);
        Point xMinFirst = Collections.min(firstTriangleTops, comparator);
        Point xMinSecond = Collections.min(secondTriangleTops, comparator);
        return comparator.compare(xMinFirst, xMinSecond);
    }
}

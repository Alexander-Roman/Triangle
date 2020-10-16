package com.epam.triangle.comparator.point;

import com.epam.triangle.entity.Point;

import java.util.Comparator;

public class xComparator implements Comparator<Point> {

    @Override
    public int compare(Point firstPoint, Point secondPoint) {
        double firstPointX = firstPoint.getX();
        double secondPointX = secondPoint.getX();

        return Double.compare(firstPointX, secondPointX);
    }
}

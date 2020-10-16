package com.epam.triangle.comparator.point;

import com.epam.triangle.entity.Point;

import java.util.Comparator;

public class yComparator implements Comparator<Point> {

    @Override
    public int compare(Point firstPoint, Point secondPoint) {
        double firstPointY = firstPoint.getY();
        double secondPointY = secondPoint.getY();

        return Double.compare(firstPointY, secondPointY);
    }
}
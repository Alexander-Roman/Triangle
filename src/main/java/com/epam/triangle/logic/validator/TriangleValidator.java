package com.epam.triangle.logic.validator;

import com.epam.triangle.entity.Point;

public class TriangleValidator {

    public boolean isOneStraightLine(Point a, Point b, Point c) {
        /*
         * Equation of a straight line passing through two points:
         * (x - x1) / (x2 - x1) == (y - y1) / (y2 - y1)
         */
        double x1 = a.getX();
        double y1 = a.getY();
        double x2 = b.getX();
        double y2 = b.getY();
        double x = c.getX();
        double y = c.getY();
        return ((x - x1) / (x2 - x1) == (y - y1) / (y2 - y1));
    }
}

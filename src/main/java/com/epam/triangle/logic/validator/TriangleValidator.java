package com.epam.triangle.logic.validator;

import com.epam.triangle.entity.Point;

public class TriangleValidator {

    public boolean isOneStraightLine(Point a, Point b, Point c) {
        return ((c.getX() - a.getX()) / (b.getX() - a.getX()) == (c.getY() - a.getY()) / (b.getY() - a.getY()));
    }
}

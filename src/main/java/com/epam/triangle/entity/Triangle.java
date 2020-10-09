package com.epam.triangle.entity;

import com.epam.triangle.exception.TriangleException;
import com.epam.triangle.logic.validator.TriangleValidator;

public class Triangle {

    private final Point a;
    private final Point b;
    private final Point c;

    private Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public static Triangle of(Point a, Point b, Point c) throws TriangleException {
        TriangleValidator validator = new TriangleValidator();
        if (validator.isOneStraightLine(a, b, c)) {
            throw new TriangleException("Not a triangle!");
        }
        return new Triangle(a, b, c);
    }

    public Point getA() {
        return a;
    }

    public Point getB() {
        return b;
    }

    public Point getC() {
        return c;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Triangle triangle = (Triangle) o;
        return a.equals(triangle.a) &&
                b.equals(triangle.b) &&
                c.equals(triangle.c);
    }

    @Override
    public int hashCode() {
        int result = a != null ? a.hashCode() : 0;
        result = 31 * result + (b != null ? b.hashCode() : 0);
        result = 31 * result + (c != null ? c.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }
}

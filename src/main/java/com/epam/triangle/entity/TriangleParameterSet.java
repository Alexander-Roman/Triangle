package com.epam.triangle.entity;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class TriangleParameterSet {

    private final double perimeter;
    private final double area;
    private final List<Double> angles;
    private final List<Double> sides;
    private final TriangleType triangleType;

    public TriangleParameterSet(double perimeter, double area, List<Double> angles, List<Double> sides, TriangleType triangleType) {
        this.perimeter = perimeter;
        this.area = area;
        this.angles = angles;
        this.sides = sides;
        this.triangleType = triangleType;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public double getArea() {
        return area;
    }

    public List<Double> getAngles() {
        return Collections.unmodifiableList(angles);
    }

    public List<Double> getSides() {
        return Collections.unmodifiableList(sides);
    }

    public TriangleType getTriangleType() {
        return triangleType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TriangleParameterSet that = (TriangleParameterSet) o;
        return Double.compare(that.perimeter, perimeter) == 0 &&
                Double.compare(that.area, area) == 0 &&
                Objects.equals(angles, that.angles) &&
                Objects.equals(sides, that.sides) &&
                triangleType == that.triangleType;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(perimeter);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(area);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (angles != null ? angles.hashCode() : 0);
        result = 31 * result + (sides != null ? sides.hashCode() : 0);
        result = 31 * result + (triangleType != null ? triangleType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "perimeter=" + perimeter +
                ", area=" + area +
                ", angles=" + angles +
                ", sides=" + sides +
                ", triangleType=" + triangleType +
                '}';
    }
}

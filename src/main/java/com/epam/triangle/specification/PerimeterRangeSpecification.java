package com.epam.triangle.specification;

import com.epam.triangle.entity.Triangle;
import com.epam.triangle.logic.TriangleCalculator;

public class PerimeterRangeSpecification implements TriangleSpecification {

    private final TriangleCalculator calculator = new TriangleCalculator();
    private final double minPerimeter;
    private final double maxPerimeter;

    public PerimeterRangeSpecification(double minPerimeter, double maxPerimeter) {
        this.minPerimeter = minPerimeter;
        this.maxPerimeter = maxPerimeter;
    }

    @Override
    public boolean isSpecified(Triangle triangle) {
        double actualPerimeter = calculator.getPerimeter(triangle);
        return minPerimeter <= actualPerimeter && actualPerimeter <= maxPerimeter;
    }
}

package com.epam.triangle.specification;

import com.epam.triangle.entity.Triangle;
import com.epam.triangle.logic.TriangleCalculator;

public class AreaRangeSpecification implements TriangleSpecification {

    private final TriangleCalculator calculator;
    private final double minArea;
    private final double maxArea;

    public AreaRangeSpecification(double minArea, double maxArea) {
        this.minArea = minArea;
        this.maxArea = maxArea;
        calculator = new TriangleCalculator();
    }

    /* package-private for testing */
    AreaRangeSpecification(TriangleCalculator calculator, double minArea, double maxArea) {
        this.calculator = calculator;
        this.minArea = minArea;
        this.maxArea = maxArea;
    }

    @Override
    public boolean isSpecified(Triangle triangle) {
        double actualArea = calculator.getArea(triangle);
        return minArea <= actualArea && actualArea <= maxArea;
    }
}

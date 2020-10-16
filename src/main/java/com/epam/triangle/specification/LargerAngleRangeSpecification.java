package com.epam.triangle.specification;

import com.epam.triangle.entity.Triangle;
import com.epam.triangle.logic.TriangleCalculator;

public class LargerAngleRangeSpecification implements TriangleSpecification {

    private final TriangleCalculator calculator = new TriangleCalculator();
    private final double minLargerAngle;
    private final double maxLargerAngle;

    public LargerAngleRangeSpecification(double minLargerAngle, double maxLargerAngle) {
        this.minLargerAngle = minLargerAngle;
        this.maxLargerAngle = maxLargerAngle;
    }

    @Override
    public boolean isSpecified(Triangle triangle) {
        double largerAngle = calculator.maxAngle(triangle);
        return minLargerAngle <= largerAngle && largerAngle <= maxLargerAngle;
    }
}

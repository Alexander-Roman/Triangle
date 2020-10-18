package com.epam.triangle.specification;

import com.epam.triangle.entity.Triangle;
import com.epam.triangle.logic.TriangleCalculator;

public class LargerAngleRangeSpecification implements TriangleSpecification {

    private final TriangleCalculator calculator;
    private final double minLargerAngle;
    private final double maxLargerAngle;

    public LargerAngleRangeSpecification(double minLargerAngle, double maxLargerAngle) {
        this.minLargerAngle = minLargerAngle;
        this.maxLargerAngle = maxLargerAngle;
        calculator = new TriangleCalculator();
    }

    /* package-private for testing */
    LargerAngleRangeSpecification(TriangleCalculator calculator, double minLargerAngle, double maxLargerAngle) {
        this.calculator = calculator;
        this.minLargerAngle = minLargerAngle;
        this.maxLargerAngle = maxLargerAngle;
    }

    @Override
    public boolean isSpecified(Triangle triangle) {
        double largerAngle = calculator.maxAngle(triangle);
        return minLargerAngle <= largerAngle && largerAngle <= maxLargerAngle;
    }
}

package com.epam.triangle.specification;

import com.epam.triangle.entity.Triangle;
import com.epam.triangle.logic.TriangleCalculator;

public class RectangularSpecification implements TriangleSpecification {

    private final TriangleCalculator calculator = new TriangleCalculator();

    @Override
    public boolean isSpecified(Triangle triangle) {
        return calculator.isRectangular(triangle);
    }
}

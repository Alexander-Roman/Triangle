package com.epam.triangle.logic;

import com.epam.triangle.entity.Point;
import com.epam.triangle.entity.Triangle;
import com.epam.triangle.logic.validator.TriangleValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;

public class TriangleCreator {

    private static final Logger LOGGER = LogManager.getLogger();
    private final static int X_OF_A_INDEX = 0;
    private final static int Y_OF_A_INDEX = 1;
    private final static int X_OF_B_INDEX = 2;
    private final static int Y_OF_B_INDEX = 3;
    private final static int X_OF_C_INDEX = 4;
    private final static int Y_OF_C_INDEX = 5;

    private final TriangleValidator validator;

    public TriangleCreator(TriangleValidator validator) {
        this.validator = validator;
    }

    public Optional<Triangle> create(List<Double> values) {

        double aPointX = values.get(X_OF_A_INDEX);
        double aPointY = values.get(Y_OF_A_INDEX);
        Point a = new Point(aPointX, aPointY);

        double bPointX = values.get(X_OF_B_INDEX);
        double bPointY = values.get(Y_OF_B_INDEX);
        Point b = new Point(bPointX, bPointY);

        double cPointX = values.get(X_OF_C_INDEX);
        double cPointY = values.get(Y_OF_C_INDEX);
        Point c = new Point(cPointX, cPointY);

        Triangle triangle = new Triangle(a, b, c);

        if (!validator.isTriangle(triangle)) {
            triangle = null;
            LOGGER.warn("Not a triangle values: " + values);
        }

        return Optional.ofNullable(triangle);
    }
}

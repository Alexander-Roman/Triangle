package com.epam.triangle.logic;

import com.epam.triangle.entity.Point;
import com.epam.triangle.entity.Triangle;
import com.epam.triangle.logic.parser.DataParser;
import com.epam.triangle.logic.validator.DataValidator;
import com.epam.triangle.logic.validator.TriangleValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
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

    private final DataParser parser;
    private final DataValidator dataValidator;
    private final TriangleValidator triangleValidator;

    public TriangleCreator(DataParser parser, DataValidator dataValidator, TriangleValidator triangleValidator) {
        this.parser = parser;
        this.dataValidator = dataValidator;
        this.triangleValidator = triangleValidator;
    }

    public List<Triangle> create(List<String> data) {
        List<String> validated = validateData(data);
        List<Triangle> triangles = new ArrayList<Triangle>();
        for (String line : validated) {
            Optional<Triangle> parsed = parseTriangle(line);
            if (parsed.isPresent()) {
                Triangle triangle = parsed.get();
                triangles.add(triangle);
            }
        }
        return triangles;
    }

    private List<String> validateData(List<String> data) {
        List<String> validated = new ArrayList<String>();
        for (String line : data) {
            if (dataValidator.isValid(line)) {
                validated.add(line);
            } else {
                LOGGER.log(Level.ERROR, "Data invalid line: " + line);
            }
        }
        return validated;
    }

    private Optional<Triangle> parseTriangle(String line) {
        Triangle triangle = null;
        List<Double> values = parser.parse(line);
        Point a = new Point(
                values.get(X_OF_A_INDEX),
                values.get(Y_OF_A_INDEX));
        Point b = new Point(
                values.get(X_OF_B_INDEX),
                values.get(Y_OF_B_INDEX));
        Point c = new Point(
                values.get(X_OF_C_INDEX),
                values.get(Y_OF_C_INDEX));

        if (triangleValidator.isOneStraightLine(a, b, c)) {
            LOGGER.log(Level.ERROR, "Not a triangle in data line: " + line);
        } else {
            triangle = new Triangle(a, b, c);
        }

        return Optional.ofNullable(triangle);
    }
}

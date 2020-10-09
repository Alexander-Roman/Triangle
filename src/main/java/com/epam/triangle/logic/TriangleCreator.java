package com.epam.triangle.logic;

import com.epam.triangle.entity.Point;
import com.epam.triangle.entity.Triangle;
import com.epam.triangle.exception.TriangleException;
import com.epam.triangle.logic.parser.DataParser;
import com.epam.triangle.logic.validator.DataValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TriangleCreator {

    private static final Logger LOGGER = LogManager.getLogger();
    private final DataParser parser;
    private final DataValidator validator;

    public TriangleCreator(DataParser parser, DataValidator validator) {
        this.parser = parser;
        this.validator = validator;
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
            if (validator.isValid(line)) {
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
        Point a = new Point(values.get(0), values.get(1));
        Point b = new Point(values.get(2), values.get(3));
        Point c = new Point(values.get(4), values.get(5));
        try {
            triangle = Triangle.of(a, b, c);
        } catch (TriangleException e) {
            LOGGER.log(Level.ERROR, "Can't create triangle from data line: " + line);
        }
        return Optional.ofNullable(triangle);
    }
}

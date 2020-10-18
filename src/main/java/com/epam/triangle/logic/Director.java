package com.epam.triangle.logic;

import com.epam.triangle.entity.Triangle;
import com.epam.triangle.logic.parser.DataParser;
import com.epam.triangle.logic.validator.DataValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Director {

    private static final Logger LOGGER = LogManager.getLogger();

    private final DataParser parser;
    private final DataValidator validator;
    private final TriangleCreator creator;

    public Director(DataParser parser, DataValidator validator, TriangleCreator creator) {
        this.parser = parser;
        this.validator = validator;
        this.creator = creator;
    }

    public List<Triangle> createFromData(List<String> data) {
        List<Triangle> triangles = new ArrayList<Triangle>();

        for (String line : data) {
            if (validator.isValid(line)) {
                List<Double> values = parser.parse(line);
                Optional<Triangle> created = creator.create(values);
                if (created.isPresent()) {
                    Triangle triangle = created.get();
                    triangles.add(triangle);
                }
            } else {
                LOGGER.warn("Data invalid line: " + line);
            }
        }
        return triangles;
    }
}

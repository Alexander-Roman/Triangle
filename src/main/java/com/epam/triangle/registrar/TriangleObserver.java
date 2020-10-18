package com.epam.triangle.registrar;

import com.epam.triangle.entity.TriangleParameters;
import com.epam.triangle.entity.TriangleType;
import com.epam.triangle.logic.TriangleCalculator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TriangleObserver implements Observer {

    private static final TriangleObserver INSTANCE = new TriangleObserver();

    private final Map<Long, TriangleParameters> parameters;
    private final TriangleCalculator calculator;

    private TriangleObserver() {
        parameters = new HashMap<Long, TriangleParameters>();
        calculator = new TriangleCalculator();
    }

    /* package-private for testing */
    TriangleObserver(TriangleCalculator calculator) {
        parameters = new HashMap<Long, TriangleParameters>();
        this.calculator = calculator;
    }

    public static TriangleObserver getInstance() {
        return INSTANCE;
    }

    public TriangleParameters getParameters(TriangleObservable triangleObservable) {
        Long id = triangleObservable.getId();
        return parameters.get(id);
    }

    @Override
    public void handleEvent(TriangleObservable triangleObservable) {
        double perimeter = calculator.getPerimeter(triangleObservable);
        double area = calculator.getArea(triangleObservable);
        List<Double> angles = calculator.getAllAngles(triangleObservable);
        List<Double> sides = calculator.getAllSides(triangleObservable);
        TriangleType triangleType = calculator.getType(triangleObservable);

        TriangleParameters parameterSet = new TriangleParameters(perimeter, area, angles, sides, triangleType);
        Long id = triangleObservable.getId();
        parameters.put(id, parameterSet);
    }
}

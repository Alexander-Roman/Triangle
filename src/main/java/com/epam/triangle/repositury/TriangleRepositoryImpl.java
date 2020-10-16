package com.epam.triangle.repositury;

import com.epam.triangle.entity.Triangle;
import com.epam.triangle.specification.TriangleSpecification;

import java.util.ArrayList;
import java.util.List;

public class TriangleRepositoryImpl implements TriangleRepository {

    private final List<Triangle> triangles = new ArrayList<Triangle>();

    public TriangleRepositoryImpl() {
    }

    @Override
    public void add(Triangle triangle) {
        triangles.add(triangle);
    }

    @Override
    public void remove(Triangle triangle) {
        triangles.remove(triangle);
    }

    @Override
    public List<Triangle> query(TriangleSpecification specification) {
        List<Triangle> specified = new ArrayList<Triangle>();
        for (Triangle triangle : triangles) {
            if (specification.isSpecified(triangle)) {
                specified.add(triangle);
            }
        }
        return specified;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "triangles=" + triangles +
                '}';
    }
}

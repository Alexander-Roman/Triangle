package com.epam.triangle.repositury;

import com.epam.triangle.entity.Triangle;
import com.epam.triangle.specification.TriangleSpecification;

import java.util.List;

public interface TriangleRepository {

    void add(Triangle triangle);

    void remove(Triangle triangle);

    List<Triangle> query(TriangleSpecification specification);
}

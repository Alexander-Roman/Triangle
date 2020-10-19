package com.epam.triangle.repositury;

import com.epam.triangle.entity.Point;
import com.epam.triangle.entity.Triangle;
import com.epam.triangle.specification.RectangularSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

public class TriangleRepositoryImplTest {

    private Triangle regular;
    private Triangle rectangular;

    @BeforeClass
    public void setUp() {
        Point a = new Point(-10.0, -20.0);
        Point b = new Point(40.0, 66.603);
        Point c = new Point(90.0, -20.0);
        regular = new Triangle(a, b, c);

        a = new Point(-17.355, 35.355);
        b = new Point(18.0, 0.0);
        c = new Point(-17.355, -35.355);
        rectangular = new Triangle(a, b, c);
    }

    @Test
    public void testQueryShouldReturnSpecifiedListFromPreviouslyAddedTriangles() {
        //given
        TriangleRepositoryImpl repository = new TriangleRepositoryImpl();
        //when
        repository.add(regular);
        repository.add(rectangular);
        List<Triangle> actual = repository.query(new RectangularSpecification());
        //then
        List<Triangle> expected = Collections.singletonList(rectangular);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testQueryShouldReturnSpecifiedListWithoutPreviouslyRemovedTriangles() {
        //given
        TriangleRepositoryImpl repository = new TriangleRepositoryImpl();
        repository.add(regular);
        repository.add(rectangular);
        //when
        repository.remove(rectangular);
        List<Triangle> actual = repository.query(new RectangularSpecification());
        //then
        List<Triangle> expected = Collections.emptyList();
        Assert.assertEquals(actual, expected);
    }
}

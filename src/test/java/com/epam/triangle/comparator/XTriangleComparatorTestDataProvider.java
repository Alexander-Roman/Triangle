package com.epam.triangle.comparator;

import com.epam.triangle.entity.Point;
import com.epam.triangle.entity.Triangle;
import org.testng.annotations.DataProvider;

public class XTriangleComparatorTestDataProvider {

    private static final Triangle TRIANGLE_LESS;
    private static final Triangle TRIANGLE_MORE;

    static {
        Point a = new Point(12.0, 4);
        Point b = new Point(15.0, 5);
        Point c = new Point(-4.0, 6);
        TRIANGLE_LESS = new Triangle(a, b, c);

        a = new Point(10.0, 4);
        b = new Point(-3.0, 7);
        c = new Point(15.0, 6);
        TRIANGLE_MORE = new Triangle(a, b, c);
    }

    @DataProvider(name = "firstTriangleLess")
    public static Object[][] firstTriangleLess() {
        return new Object[][]{{TRIANGLE_LESS, TRIANGLE_MORE}};
    }

    @DataProvider(name = "firstTriangleMore")
    public static Object[][] firstTriangleMore() {
        return new Object[][]{{TRIANGLE_MORE, TRIANGLE_LESS}};
    }

    @DataProvider(name = "trianglesAreEquals")
    public static Object[][] trianglesAreEquals() {
        return new Object[][]{{TRIANGLE_LESS, TRIANGLE_LESS}};
    }
}

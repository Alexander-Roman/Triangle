package com.epam.triangle.comparator;

import com.epam.triangle.entity.Triangle;
import org.testng.Assert;
import org.testng.annotations.Test;

public class XTriangleComparatorTest {

    private final XTriangleComparator comparator = new XTriangleComparator();

    @Test(dataProvider = "firstTriangleLess", dataProviderClass = XTriangleComparatorTestDataProvider.class)
    public void testCompareShouldReturnNegativeWhenFirstTriangleLess(Triangle firstTriangle, Triangle secondTriangle) {
        //given
        //when
        int actual = comparator.compare(firstTriangle, secondTriangle);
        //then
        Assert.assertTrue(actual < 0);
    }

    @Test(dataProvider = "firstTriangleMore", dataProviderClass = XTriangleComparatorTestDataProvider.class)
    public void testCompareShouldReturnPositiveWhenFirstTriangleMore(Triangle firstTriangle, Triangle secondTriangle) {
        //given
        //when
        int actual = comparator.compare(firstTriangle, secondTriangle);
        //then
        Assert.assertTrue(actual > 0);
    }

    @Test(dataProvider = "trianglesAreEquals", dataProviderClass = XTriangleComparatorTestDataProvider.class)
    public void testCompareShouldReturnZeroWhenTrianglesAreEquals(Triangle firstTriangle, Triangle secondTriangle) {
        //given
        //when
        int actual = comparator.compare(firstTriangle, secondTriangle);
        //then
        Assert.assertEquals(actual, 0);
    }


}

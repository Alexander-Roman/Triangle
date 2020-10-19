package com.epam.triangle.registrar;

import com.epam.triangle.entity.Point;
import org.mockito.Mockito;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TriangleObservableTest {

    private final TriangleObserver observer = Mockito.mock(TriangleObserver.class);

    @DataProvider(name = "triangleCreationArguments")
    public Object[][] getTriangleCreationArguments() {
        Point a = new Point(-59.0, -35.0);
        Point b = new Point(-6.0, 35.0);
        Point c = new Point(59.0, -18.0);
        long id = 10;
        return new Object[][]{{a, b, c, id}};
    }

    @Test(dataProvider = "triangleCreationArguments")
    public void testSetMethodShouldNotifyPreviouslyAddedObservers(Point a, Point b, Point c, long id) {
        //given
        TriangleObservable triangleObservable = new TriangleObservable(a, b, c, id);
        //when
        triangleObservable.addObserver(observer);
        triangleObservable.setA(a);
        triangleObservable.setB(b);
        //then
        Mockito.verify(observer, Mockito.times(3)).handleEvent(triangleObservable);
    }

    @Test(dataProvider = "triangleCreationArguments")
    public void testSetMethodShouldNotNotifyRemovedObservers(Point a, Point b, Point c, long id) {
        //given
        TriangleObservable triangleObservable = new TriangleObservable(a, b, c, id);
        //when
        triangleObservable.addObserver(observer);
        triangleObservable.removeObserver(observer);
        triangleObservable.setA(a);
        triangleObservable.setB(b);
        //then
        Mockito.verify(observer, Mockito.times(1)).handleEvent(triangleObservable);
    }
}

package com.epam.triangle.registrar;

import com.epam.triangle.entity.Triangle;

public interface Observer {

    void handleEvent(TriangleObservable triangleObservable);
}

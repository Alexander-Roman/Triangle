package com.epam.triangle.registrar;

import com.epam.triangle.entity.Point;
import com.epam.triangle.entity.Triangle;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class TriangleObservable extends Triangle implements Observable {

    private final long id;
    private final Set<Observer> observers = new HashSet<Observer>();

    public TriangleObservable(Point a, Point b, Point c, long id) {
        super(a, b, c);
        this.id = id;
        notifyObservers();
    }

    public long getId() {
        return id;
    }

    @Override
    public void setA(Point a) {
        super.setA(a);
        notifyObservers();
    }

    @Override
    public void setB(Point b) {
        super.setB(b);
        notifyObservers();
    }

    @Override
    public void setC(Point c) {
        super.setC(c);
        notifyObservers();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
        notifyObservers();
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.handleEvent(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        TriangleObservable that = (TriangleObservable) o;
        return id == that.id &&
                Objects.equals(observers, that.observers);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (int) (id ^ (id >>> 32));
        result = 31 * result + observers.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "a=" + getA() +
                ", b=" + getB() +
                ", c=" + getC() +
                ", id=" + id +
                ", observers=" + observers +
                '}';
    }
}

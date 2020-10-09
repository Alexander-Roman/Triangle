package com.epam.triangle.logic;

import com.epam.triangle.entity.Point;
import com.epam.triangle.entity.Triangle;

public class TriangleCalculator {

    private static final double RIGHT_ANGLE = 90.0;
    private static final double THRESHOLD = 0.01;

    public double getPerimeter(Triangle triangle) {
        Point topA = triangle.getA();
        Point topB = triangle.getB();
        Point topC = triangle.getC();
        return getSide(topA, topB) + getSide(topB, topC) + getSide(topC, topA);
    }

    public double getArea(Triangle triangle) {
        double halfPerimeter = getPerimeter(triangle) / 2;
        double[] sides = getAllSides(triangle);

        return Math.sqrt(halfPerimeter * (halfPerimeter - sides[0]) * (halfPerimeter - sides[1]) * (halfPerimeter - sides[2]));
    }

    public boolean isRectangular(Triangle triangle) {
        double[] angles = getAllAngles(triangle);
        for (Double angle : angles) {
            if (Math.abs(angle - RIGHT_ANGLE) < THRESHOLD) {
                return true;
            }
        }
        return false;
    }

    public boolean isAcuteAngled(Triangle triangle) {
        double[] angles = getAllAngles(triangle);
        for (Double angle : angles) {
            if (angle > RIGHT_ANGLE || Math.abs(angle - RIGHT_ANGLE) < THRESHOLD) {
                return false;
            }
        }
        return true;
    }

    public boolean isObtuse(Triangle triangle) {
        double[] angles = getAllAngles(triangle);
        for (Double angle : angles) {
            if (angle > RIGHT_ANGLE && Math.abs(angle - RIGHT_ANGLE) >= THRESHOLD) {
                return true;
            }
        }
        return false;
    }

    public boolean isIsosceles(Triangle triangle) {
        double[] sides = getAllSides(triangle);
        return Math.abs(sides[0] - sides[1]) < THRESHOLD ||
                Math.abs(sides[1] - sides[2]) < THRESHOLD ||
                Math.abs(sides[2] - sides[0]) < THRESHOLD;
    }

    public boolean isRegular(Triangle triangle) {
        double[] sides = getAllSides(triangle);
        return Math.abs(sides[0] - sides[1]) < THRESHOLD &&
                Math.abs(sides[1] - sides[2]) < THRESHOLD;
    }

    private double[] getAllSides(Triangle triangle) {
        Point a = triangle.getA();
        Point b = triangle.getB();
        Point c = triangle.getC();

        double sideAB = getSide(a, b);
        double sideBC = getSide(b, c);
        double sideCA = getSide(c, a);

        return new double[]{sideAB, sideBC, sideCA};
    }

    private double[] getAllAngles(Triangle triangle) {
        Point a = triangle.getA();
        Point b = triangle.getB();
        Point c = triangle.getC();

        double angleA = getAngleDegrees(c, a, b);
        double angleB = getAngleDegrees(a, b, c);
        double angleC = getAngleDegrees(b, c, a);

        return new double[]{angleA, angleB, angleC};
    }

    private double getSide(Point from, Point to) {
        double middleX = to.getX() - from.getX();
        double middleY = to.getY() - from.getY();
        return Math.hypot(middleX, middleY);
    }


    private double getAngleDegrees(Point from, Point top, Point to) {
        double sideFromTop = getSide(from, top);
        double sideTopTo = getSide(top, to);
        double sideToFrom = getSide(to, from);

        double squareFromTop = Math.pow(sideFromTop, 2);
        double squareTopTo = Math.pow(sideTopTo, 2);
        double squareToFrom = Math.pow(sideToFrom, 2);

        double angleRad = Math.acos((squareFromTop + squareTopTo - squareToFrom) / (2 * sideFromTop * sideTopTo));
        return Math.toDegrees(angleRad);
    }
}

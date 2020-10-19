package com.epam.triangle.logic;

import com.epam.triangle.entity.Point;
import com.epam.triangle.entity.Triangle;
import com.epam.triangle.entity.TriangleType;

import java.util.Arrays;
import java.util.List;

public class TriangleCalculator {

    private static final double RIGHT_ANGLE = 90.0;
    private static final double THRESHOLD = 0.01;
    private static final int SIDE_AB_INDEX = 0;
    private static final int SIDE_BC_INDEX = 1;
    private static final int SIDE_CA_INDEX = 2;

    public double getPerimeter(Triangle triangle) {
        Point topA = triangle.getA();
        Point topB = triangle.getB();
        Point topC = triangle.getC();
        return getSide(topA, topB) + getSide(topB, topC) + getSide(topC, topA);
    }

    public double getArea(Triangle triangle) {
        double halfPerimeter = getPerimeter(triangle) / 2;
        List<Double> sides = getAllSides(triangle);
        double sideAB = sides.get(SIDE_AB_INDEX);
        double sideBC = sides.get(SIDE_BC_INDEX);
        double sideCA = sides.get(SIDE_CA_INDEX);
        return Math.sqrt(halfPerimeter * (halfPerimeter - sideAB) * (halfPerimeter - sideBC) * (halfPerimeter - sideCA));
    }

    public boolean isRectangular(Triangle triangle) {
        double maxAngle = maxAngle(triangle);
        return Math.abs(maxAngle - RIGHT_ANGLE) < THRESHOLD;
    }

    public boolean isAcuteAngled(Triangle triangle) {
        double maxAngle = maxAngle(triangle);
        return maxAngle <= RIGHT_ANGLE - THRESHOLD;
    }

    public boolean isObtuse(Triangle triangle) {
        double maxAngle = maxAngle(triangle);
        return maxAngle >= RIGHT_ANGLE + THRESHOLD;
    }

    public boolean isIsosceles(Triangle triangle) {
        List<Double> sides = getAllSides(triangle);
        double sideAB = sides.get(SIDE_AB_INDEX);
        double sideBC = sides.get(SIDE_BC_INDEX);
        double sideCA = sides.get(SIDE_CA_INDEX);
        return Math.abs(sideAB - sideBC) < THRESHOLD ||
                Math.abs(sideBC - sideCA) < THRESHOLD ||
                Math.abs(sideCA - sideAB) < THRESHOLD;
    }

    public boolean isRegular(Triangle triangle) {
        List<Double> sides = getAllSides(triangle);
        double sideAB = sides.get(SIDE_AB_INDEX);
        double sideBC = sides.get(SIDE_BC_INDEX);
        double sideCA = sides.get(SIDE_CA_INDEX);
        return Math.abs(sideAB - sideBC) < THRESHOLD &&
                Math.abs(sideBC - sideCA) < THRESHOLD;
    }

    public double maxAngle(Triangle triangle) {
        List<Double> angles = getAllAngles(triangle);
        double maxAngle = 0;
        for (double angle : angles) {
            if (maxAngle < angle) {
                maxAngle = angle;
            }
        }
        return maxAngle;
    }

    public List<Double> getAllSides(Triangle triangle) {
        Point a = triangle.getA();
        Point b = triangle.getB();
        Point c = triangle.getC();

        double sideAB = getSide(a, b);
        double sideBC = getSide(b, c);
        double sideCA = getSide(c, a);

        return Arrays.asList(sideAB, sideBC, sideCA);
    }

    public List<Double> getAllAngles(Triangle triangle) {
        Point a = triangle.getA();
        Point b = triangle.getB();
        Point c = triangle.getC();

        double angleA = getAngleDegrees(c, a, b);
        double angleB = getAngleDegrees(a, b, c);
        double angleC = getAngleDegrees(b, c, a);

        return Arrays.asList(angleA, angleB, angleC);
    }

    public double minX(Triangle triangle) {
        Point a = triangle.getA();
        Point b = triangle.getB();
        Point c = triangle.getC();
        double aPointX = a.getX();
        double bPointX = b.getX();
        double cPointX = c.getX();
        double minX = Math.min(aPointX, bPointX);
        return Math.min(minX, cPointX);
    }

    public double minY(Triangle triangle) {
        Point a = triangle.getA();
        Point b = triangle.getB();
        Point c = triangle.getC();
        double aPointY = a.getY();
        double bPointY = b.getY();
        double cPointY = c.getY();
        double minY = Math.min(aPointY, bPointY);
        return Math.min(minY, cPointY);
    }

    public TriangleType getType(Triangle triangle) {
        if (isRectangular(triangle)) {
            return TriangleType.RECTANGULAR;
        } else if (isAcuteAngled(triangle)) {
            return TriangleType.ACUTE_ANGLED;
        } else {
            return TriangleType.OBTUSE;
        }
    }

    private double getSide(Point from, Point to) {
        double fromX = from.getX();
        double fromY = from.getY();
        double toX = to.getX();
        double toY = to.getY();
        double middleX = toX - fromX;
        double middleY = toY - fromY;
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

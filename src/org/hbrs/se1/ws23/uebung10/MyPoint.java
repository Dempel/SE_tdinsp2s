package org.hbrs.se1.ws23.uebung10;

import java.util.Objects;

public class MyPoint {
    private double x, y;

    public MyPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        MyPoint myPoint = (MyPoint) obj;
        return Double.compare(myPoint.x, x) == 0 &&
                Double.compare(myPoint.y, y) == 0;
    }

    // Überschreiben der hashCode-Methode
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

}
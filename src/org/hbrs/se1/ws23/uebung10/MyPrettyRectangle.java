package org.hbrs.se1.ws23.uebung10;

import java.util.Objects;

public class MyPrettyRectangle {

    private double x1, y1, x2, y2;

    public MyPrettyRectangle(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public double getX1() {
        return this.x1;
    }
    public double getY1() {
        return this.y1;
    }
    public double getX2() {
        return this.x2;
    }
    public double getY2() {
        return this.y2;
    }



    public boolean contains(MyPrettyRectangle o) {
        return this.x1 <= o.x1 && this.y1 <= o.y1 && this.x2 >= o.x2 && this.y2 >= o.y2;
    }

    public MyPoint getCenter() {
        double xMitte = (this.x2 + this.x1)/2;
        double yMitte = (this.y2 + this.y1)/2;
        return new MyPoint(xMitte, yMitte);
    }

    public double getArea() {
        return (this.x2 - this.x1)*(this.y2 - this.y1);
    }
    public double getPerimeter() {
        return 2* ((this.x2 - this.x1) + (this.y2 - this.y1));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        MyPrettyRectangle rectangle = (MyPrettyRectangle) obj;
        return Double.compare(rectangle.x1, x1) == 0 &&
                Double.compare(rectangle.y1, y1) == 0 &&
                Double.compare(rectangle.x2, x2) == 0 &&
                Double.compare(rectangle.y2, y2) == 0;
    }
}

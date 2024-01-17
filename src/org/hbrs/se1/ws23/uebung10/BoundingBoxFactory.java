package org.hbrs.se1.ws23.uebung10;

public class BoundingBoxFactory {

    public static MyPrettyRectangle createBoundingBox(MyPrettyRectangle[] objekte) {
        if (objekte == null || objekte.length == 0) {
            return new MyPrettyRectangle(0.0, 0.0, 0.0, 0.0);
        }
        //Werte maximal/minimal Setzen
        double minX = Double.MAX_VALUE;
        double minY = Double.MAX_VALUE;
        double maxX = Double.MIN_VALUE;
        double maxY = Double.MIN_VALUE;

        //Aktualisieren
        for (MyPrettyRectangle r : objekte) {
            minX = Math.min(minX, r.getX1());
            minY = Math.min(minY, r.getY1());
            maxX = Math.max(maxX, r.getX2());
            maxY = Math.max(maxY, r.getY2());
        }
        //Rückgabe BoundingBox
        return new MyPrettyRectangle(minX, minY, maxX, maxY);
    }
}

package org.opencv.core;

public class Point {
    public double x;
    public double y;

    public Point(double d, double d2) {
        this.x = d;
        this.y = d2;
    }

    public Point() {
        this(0.0d, 0.0d);
    }

    public Point(double[] dArr) {
        this();
        set(dArr);
    }

    public void set(double[] dArr) {
        double d = 0.0d;
        if (dArr != null) {
            this.x = dArr.length > 0 ? dArr[0] : 0.0d;
            if (dArr.length > 1) {
                d = dArr[1];
            }
            this.y = d;
            return;
        }
        this.x = 0.0d;
        this.y = 0.0d;
    }

    public Point clone() {
        return new Point(this.x, this.y);
    }

    public double dot(Point point) {
        return (this.x * point.x) + (this.y * point.y);
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.x);
        long doubleToLongBits2 = Double.doubleToLongBits(this.y);
        return ((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Point)) {
            return false;
        }
        Point point = (Point) obj;
        return this.x == point.x && this.y == point.y;
    }

    public boolean inside(Rect rect) {
        return rect.contains(this);
    }

    public String toString() {
        return "{" + this.x + ", " + this.y + "}";
    }
}

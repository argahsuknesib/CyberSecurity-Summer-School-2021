package org.opencv.core;

public class Rect2d {
    public double height;
    public double width;
    public double x;
    public double y;

    public Rect2d(double d, double d2, double d3, double d4) {
        this.x = d;
        this.y = d2;
        this.width = d3;
        this.height = d4;
    }

    public Rect2d() {
        this(0.0d, 0.0d, 0.0d, 0.0d);
    }

    public Rect2d(Point point, Point point2) {
        this.x = point.x < point2.x ? point.x : point2.x;
        this.y = point.y < point2.y ? point.y : point2.y;
        this.width = (point.x > point2.x ? point.x : point2.x) - this.x;
        this.height = (point.y > point2.y ? point.y : point2.y) - this.y;
    }

    public Rect2d(Point point, Size size) {
        this(point.x, point.y, size.width, size.height);
    }

    public Rect2d(double[] dArr) {
        set(dArr);
    }

    public void set(double[] dArr) {
        double d = 0.0d;
        if (dArr != null) {
            this.x = dArr.length > 0 ? dArr[0] : 0.0d;
            this.y = dArr.length > 1 ? dArr[1] : 0.0d;
            this.width = dArr.length > 2 ? dArr[2] : 0.0d;
            if (dArr.length > 3) {
                d = dArr[3];
            }
            this.height = d;
            return;
        }
        this.x = 0.0d;
        this.y = 0.0d;
        this.width = 0.0d;
        this.height = 0.0d;
    }

    public Rect2d clone() {
        return new Rect2d(this.x, this.y, this.width, this.height);
    }

    public Point tl() {
        return new Point(this.x, this.y);
    }

    public Point br() {
        return new Point(this.x + this.width, this.y + this.height);
    }

    public Size size() {
        return new Size(this.width, this.height);
    }

    public double area() {
        return this.width * this.height;
    }

    public boolean empty() {
        return this.width <= 0.0d || this.height <= 0.0d;
    }

    public boolean contains(Point point) {
        return this.x <= point.x && point.x < this.x + this.width && this.y <= point.y && point.y < this.y + this.height;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.height);
        long doubleToLongBits2 = Double.doubleToLongBits(this.width);
        long doubleToLongBits3 = Double.doubleToLongBits(this.x);
        long doubleToLongBits4 = Double.doubleToLongBits(this.y);
        return ((((((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31) + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)))) * 31) + ((int) (doubleToLongBits4 ^ (doubleToLongBits4 >>> 32)));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Rect2d)) {
            return false;
        }
        Rect2d rect2d = (Rect2d) obj;
        return this.x == rect2d.x && this.y == rect2d.y && this.width == rect2d.width && this.height == rect2d.height;
    }

    public String toString() {
        return "{" + this.x + ", " + this.y + ", " + this.width + "x" + this.height + "}";
    }
}

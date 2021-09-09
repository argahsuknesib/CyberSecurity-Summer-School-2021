package org.opencv.core;

public class Size {
    public double height;
    public double width;

    public Size(double d, double d2) {
        this.width = d;
        this.height = d2;
    }

    public Size() {
        this(0.0d, 0.0d);
    }

    public Size(Point point) {
        this.width = point.x;
        this.height = point.y;
    }

    public Size(double[] dArr) {
        set(dArr);
    }

    public void set(double[] dArr) {
        double d = 0.0d;
        if (dArr != null) {
            this.width = dArr.length > 0 ? dArr[0] : 0.0d;
            if (dArr.length > 1) {
                d = dArr[1];
            }
            this.height = d;
            return;
        }
        this.width = 0.0d;
        this.height = 0.0d;
    }

    public double area() {
        return this.width * this.height;
    }

    public boolean empty() {
        return this.width <= 0.0d || this.height <= 0.0d;
    }

    public Size clone() {
        return new Size(this.width, this.height);
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.height);
        long doubleToLongBits2 = Double.doubleToLongBits(this.width);
        return ((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Size)) {
            return false;
        }
        Size size = (Size) obj;
        return this.width == size.width && this.height == size.height;
    }

    public String toString() {
        return ((int) this.width) + "x" + ((int) this.height);
    }
}

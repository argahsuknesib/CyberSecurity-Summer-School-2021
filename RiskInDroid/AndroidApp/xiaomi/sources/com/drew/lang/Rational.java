package com.drew.lang;

import java.io.Serializable;

public class Rational extends Number implements Serializable, Comparable<Rational> {
    private static final long serialVersionUID = 510688928138848770L;
    public final long _denominator;
    public final long _numerator;

    public /* synthetic */ int compareTo(Object obj) {
        return Double.compare(doubleValue(), ((Rational) obj).doubleValue());
    }

    public Rational(long j, long j2) {
        this._numerator = j;
        this._denominator = j2;
    }

    public double doubleValue() {
        long j = this._numerator;
        if (j == 0) {
            return 0.0d;
        }
        double d = (double) j;
        double d2 = (double) this._denominator;
        Double.isNaN(d);
        Double.isNaN(d2);
        return d / d2;
    }

    public float floatValue() {
        long j = this._numerator;
        if (j == 0) {
            return 0.0f;
        }
        return ((float) j) / ((float) this._denominator);
    }

    public final byte byteValue() {
        return (byte) ((int) doubleValue());
    }

    public final int intValue() {
        return (int) doubleValue();
    }

    public final long longValue() {
        return (long) doubleValue();
    }

    public final short shortValue() {
        return (short) ((int) doubleValue());
    }

    public final Rational O000000o() {
        return new Rational(this._denominator, this._numerator);
    }

    public final boolean O00000Oo() {
        long j = this._denominator;
        if (j == 1) {
            return true;
        }
        if (j == 0 || this._numerator % j != 0) {
            return this._denominator == 0 && this._numerator == 0;
        }
        return true;
    }

    public final boolean O00000o0() {
        return this._numerator == 0 || this._denominator == 0;
    }

    public String toString() {
        return this._numerator + "/" + this._denominator;
    }

    public final String O000000o(boolean z) {
        Rational rational = this;
        while (true) {
            if (rational._denominator != 0 || rational._numerator == 0) {
                if (!rational.O00000Oo()) {
                    long j = rational._numerator;
                    if (j == 1) {
                        break;
                    }
                    long j2 = rational._denominator;
                    if (j2 % j != 0) {
                        break;
                    }
                    rational = new Rational(1, j2 / j);
                } else {
                    return Integer.toString(rational.intValue());
                }
            } else {
                return rational.toString();
            }
        }
        long j3 = rational._numerator;
        long j4 = rational._denominator;
        if (j3 < 0) {
            j3 = -j3;
        }
        if (j4 < 0) {
            j4 = -j4;
        }
        while (j3 != 0 && j4 != 0) {
            if (j3 > j4) {
                j3 %= j4;
            } else {
                j4 %= j3;
            }
        }
        if (j3 == 0) {
            j3 = j4;
        }
        Rational rational2 = new Rational(rational._numerator / j3, rational._denominator / j3);
        if (z) {
            String d = Double.toString(rational2.doubleValue());
            if (d.length() < 5) {
                return d;
            }
        }
        return rational2.toString();
    }

    public final boolean O000000o(Rational rational) {
        return rational.doubleValue() == doubleValue();
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Rational) || doubleValue() != ((Rational) obj).doubleValue()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((int) this._denominator) * 23) + ((int) this._numerator);
    }
}

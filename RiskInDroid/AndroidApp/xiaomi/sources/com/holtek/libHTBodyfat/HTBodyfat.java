package com.holtek.libHTBodyfat;

public class HTBodyfat {
    public static native double AA();

    public static native double BB();

    public static native double CC();

    public static native double DD();

    public static native double EE();

    public static native double FF();

    public static native double GG();

    public static native double HH();

    public static native double[] II();

    public static native double[] JJ();

    public static native double[] KK();

    public static native double[] LL();

    public static native double[] MM();

    public static native int NN(double d, double d2, int i, int i2, int i3);

    public static native double[] OO();

    public static native double[] PP();

    public static native double QQ();

    public static native double RR();

    static {
        System.loadLibrary("Bodyfat");
    }
}

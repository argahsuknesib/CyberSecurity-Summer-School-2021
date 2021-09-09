package com.hannto.opencv;

import android.graphics.Bitmap;
import android.graphics.Point;

public class SmartCropper {
    static {
        System.loadLibrary("smart_cropper");
    }

    private static double O000000o(int i, int i2, int i3, int i4) {
        return Math.sqrt(Math.pow((double) (i2 - i4), 2.0d) + Math.pow((double) (i - i3), 2.0d));
    }

    private static double O000000o(Point point, Point point2) {
        return O000000o(point.x, point.y, point2.x, point2.y);
    }

    public static Bitmap O000000o(Bitmap bitmap, Point[] pointArr) {
        System.currentTimeMillis();
        if (bitmap == null || pointArr == null) {
            throw new IllegalArgumentException("srcBmp and cropPoints cannot be null");
        } else if (pointArr.length == 4) {
            Point point = pointArr[0];
            Point point2 = pointArr[1];
            Point point3 = pointArr[2];
            Point point4 = pointArr[3];
            Bitmap createBitmap = Bitmap.createBitmap((int) ((O000000o(point4, point3) + O000000o(point, point2)) / 2.0d), (int) ((O000000o(point.x, point.y, point4.x, point4.y) + O000000o(point2.x, point2.y, point3.x, point3.y)) / 2.0d), Bitmap.Config.ARGB_8888);
            nativeCrop(bitmap, pointArr, createBitmap);
            System.currentTimeMillis();
            return createBitmap;
        } else {
            throw new IllegalArgumentException("The length of cropPoints must be 4 , and sort by leftTop, rightTop, rightBottom, leftBottom");
        }
    }

    public static Bitmap O000000o(Bitmap bitmap, Point[] pointArr, int i, int i2) {
        if (bitmap == null || pointArr == null) {
            throw new IllegalArgumentException("srcBmp and cropPoints cannot be null");
        } else if (pointArr.length == 4) {
            Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            nativeCrop(bitmap, pointArr, createBitmap);
            String.format("cropBitmap Size: %d %d", Integer.valueOf(createBitmap.getWidth()), Integer.valueOf(createBitmap.getHeight()));
            return createBitmap;
        } else {
            throw new IllegalArgumentException("The length of cropPoints must be 4 , and sort by leftTop, rightTop, rightBottom, leftBottom");
        }
    }

    public static void O000000o(Bitmap bitmap, Bitmap bitmap2) {
        long currentTimeMillis = System.currentTimeMillis();
        nativeICRemoveShadowTemplate(bitmap, bitmap2);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        StringBuilder sb = new StringBuilder("BitmapSize:");
        sb.append(bitmap.getWidth());
        sb.append(" * ");
        sb.append(bitmap.getHeight());
        sb.append("去阴影耗时:");
        sb.append(currentTimeMillis2);
    }

    public static boolean O000000o(Point[] pointArr) {
        return (pointArr == null || pointArr.length != 4 || pointArr[0] == null || pointArr[1] == null || pointArr[2] == null || pointArr[3] == null) ? false : true;
    }

    public static Point[] O000000o(int i, int i2, byte[] bArr) {
        Point[] pointArr = new Point[4];
        nativeFrame(i, i2, bArr, pointArr);
        new StringBuilder("frame:").append(pointArr);
        return pointArr;
    }

    public static Point[] O000000o(Bitmap bitmap) {
        if (bitmap != null) {
            Point[] pointArr = new Point[4];
            nativeScan(bitmap, pointArr);
            String.format("scan: %d, %d", Integer.valueOf(pointArr[0].x), Integer.valueOf(pointArr[0].y));
            String.format("scan: %d, %d", Integer.valueOf(pointArr[1].x), Integer.valueOf(pointArr[1].y));
            String.format("scan: %d, %d", Integer.valueOf(pointArr[2].x), Integer.valueOf(pointArr[2].y));
            String.format("scan: %d, %d", Integer.valueOf(pointArr[3].x), Integer.valueOf(pointArr[3].y));
            return pointArr;
        }
        throw new IllegalArgumentException("srcBmp cannot be null");
    }

    public static Point[] O00000Oo(Bitmap bitmap) {
        if (bitmap != null) {
            Point[] pointArr = new Point[4];
            nativeFlatbedScan(bitmap, pointArr);
            String.format("flatbed scan: Point %d, %d", Integer.valueOf(pointArr[0].x), Integer.valueOf(pointArr[0].y));
            String.format("flatbed scan: Point %d, %d", Integer.valueOf(pointArr[1].x), Integer.valueOf(pointArr[1].y));
            String.format("flatbed scan: Point %d, %d", Integer.valueOf(pointArr[2].x), Integer.valueOf(pointArr[2].y));
            String.format("flatbed scan: Point %d, %d", Integer.valueOf(pointArr[3].x), Integer.valueOf(pointArr[3].y));
            return pointArr;
        }
        throw new IllegalArgumentException("srcBmp cannot be null");
    }

    public static void O00000o0(Bitmap bitmap) {
        long currentTimeMillis = System.currentTimeMillis();
        nativeIncrease(bitmap);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        StringBuilder sb = new StringBuilder("BitmapSize:");
        sb.append(bitmap.getWidth());
        sb.append(" * ");
        sb.append(bitmap.getHeight());
        sb.append("增强耗时:");
        sb.append(currentTimeMillis2);
    }

    public static native void nativeCrop(Bitmap bitmap, Point[] pointArr, Bitmap bitmap2);

    public static native void nativeFlatbedScan(Bitmap bitmap, Point[] pointArr);

    public static native void nativeFrame(int i, int i2, byte[] bArr, Point[] pointArr);

    public static native void nativeICFlatbedScan(Bitmap bitmap, Bitmap bitmap2);

    public static native void nativeICRemoveShadowTemplate(Bitmap bitmap, Bitmap bitmap2);

    public static native void nativeIncrease(Bitmap bitmap);

    public static native void nativeRotate(Bitmap bitmap, Bitmap bitmap2);

    public static native void nativeScan(Bitmap bitmap, Point[] pointArr);
}

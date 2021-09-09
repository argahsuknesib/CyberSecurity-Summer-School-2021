package com.google.android.gms.vision.text;

import android.graphics.Point;
import android.graphics.Rect;
import android.util.SparseArray;
import com.google.android.gms.internal.vision.zzn;
import com.google.android.gms.internal.vision.zzt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TextBlock implements Text {
    private Point[] cornerPoints;
    private zzt[] zzcw;
    private List<Line> zzcx;
    private String zzcy;
    private Rect zzcz;

    TextBlock(SparseArray<zzt> sparseArray) {
        this.zzcw = new zzt[sparseArray.size()];
        int i = 0;
        while (true) {
            zzt[] zztArr = this.zzcw;
            if (i < zztArr.length) {
                zztArr[i] = sparseArray.valueAt(i);
                i++;
            } else {
                return;
            }
        }
    }

    public Rect getBoundingBox() {
        if (this.zzcz == null) {
            this.zzcz = zzc.zza(this);
        }
        return this.zzcz;
    }

    public List<? extends Text> getComponents() {
        zzt[] zztArr = this.zzcw;
        if (zztArr.length == 0) {
            return new ArrayList(0);
        }
        if (this.zzcx == null) {
            this.zzcx = new ArrayList(zztArr.length);
            for (zzt line : this.zzcw) {
                this.zzcx.add(new Line(line));
            }
        }
        return this.zzcx;
    }

    public Point[] getCornerPoints() {
        TextBlock textBlock;
        zzt[] zztArr;
        TextBlock textBlock2 = this;
        if (textBlock2.cornerPoints == null) {
            char c = 0;
            if (textBlock2.zzcw.length == 0) {
                textBlock2.cornerPoints = new Point[0];
            } else {
                int i = Integer.MAX_VALUE;
                int i2 = 0;
                int i3 = Integer.MAX_VALUE;
                int i4 = Integer.MIN_VALUE;
                int i5 = Integer.MIN_VALUE;
                while (true) {
                    zztArr = textBlock2.zzcw;
                    if (i2 >= zztArr.length) {
                        break;
                    }
                    zzn zzn = zztArr[i2].zzde;
                    zzn zzn2 = textBlock2.zzcw[c].zzde;
                    double sin = Math.sin(Math.toRadians((double) zzn2.zzdc));
                    double cos = Math.cos(Math.toRadians((double) zzn2.zzdc));
                    Point[] pointArr = new Point[4];
                    pointArr[c] = new Point(zzn.left, zzn.top);
                    pointArr[c].offset(-zzn2.left, -zzn2.top);
                    double d = (double) pointArr[c].x;
                    Double.isNaN(d);
                    int i6 = i;
                    double d2 = (double) pointArr[c].y;
                    Double.isNaN(d2);
                    int i7 = (int) ((d * cos) + (d2 * sin));
                    double d3 = (double) (-pointArr[0].x);
                    Double.isNaN(d3);
                    double d4 = d3 * sin;
                    double d5 = (double) pointArr[0].y;
                    Double.isNaN(d5);
                    int i8 = (int) (d4 + (d5 * cos));
                    pointArr[0].x = i7;
                    pointArr[0].y = i8;
                    pointArr[1] = new Point(zzn.width + i7, i8);
                    pointArr[2] = new Point(zzn.width + i7, zzn.height + i8);
                    pointArr[3] = new Point(i7, i8 + zzn.height);
                    i = i6;
                    for (int i9 = 0; i9 < 4; i9++) {
                        Point point = pointArr[i9];
                        i = Math.min(i, point.x);
                        i4 = Math.max(i4, point.x);
                        i3 = Math.min(i3, point.y);
                        i5 = Math.max(i5, point.y);
                    }
                    i2++;
                    c = 0;
                    textBlock2 = this;
                }
                zzn zzn3 = zztArr[0].zzde;
                int i10 = zzn3.left;
                int i11 = zzn3.top;
                double sin2 = Math.sin(Math.toRadians((double) zzn3.zzdc));
                double cos2 = Math.cos(Math.toRadians((double) zzn3.zzdc));
                int i12 = i;
                Point[] pointArr2 = {new Point(i12, i3), new Point(i4, i3), new Point(i4, i5), new Point(i12, i5)};
                for (int i13 = 0; i13 < 4; i13++) {
                    double d6 = (double) pointArr2[i13].x;
                    Double.isNaN(d6);
                    double d7 = (double) pointArr2[i13].y;
                    Double.isNaN(d7);
                    double d8 = (double) pointArr2[i13].x;
                    Double.isNaN(d8);
                    double d9 = (double) pointArr2[i13].y;
                    Double.isNaN(d9);
                    pointArr2[i13].x = (int) ((d6 * cos2) - (d7 * sin2));
                    pointArr2[i13].y = (int) ((d8 * sin2) + (d9 * cos2));
                    pointArr2[i13].offset(i10, i11);
                }
                textBlock = this;
                textBlock.cornerPoints = pointArr2;
                return textBlock.cornerPoints;
            }
        }
        textBlock = textBlock2;
        return textBlock.cornerPoints;
    }

    public String getLanguage() {
        String str = this.zzcy;
        if (str != null) {
            return str;
        }
        HashMap hashMap = new HashMap();
        for (zzt zzt : this.zzcw) {
            hashMap.put(zzt.zzcy, Integer.valueOf((hashMap.containsKey(zzt.zzcy) ? ((Integer) hashMap.get(zzt.zzcy)).intValue() : 0) + 1));
        }
        this.zzcy = (String) ((Map.Entry) Collections.max(hashMap.entrySet(), new zza(this))).getKey();
        String str2 = this.zzcy;
        if (str2 == null || str2.isEmpty()) {
            this.zzcy = "und";
        }
        return this.zzcy;
    }

    public String getValue() {
        zzt[] zztArr = this.zzcw;
        if (zztArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(zztArr[0].zzdh);
        for (int i = 1; i < this.zzcw.length; i++) {
            sb.append("\n");
            sb.append(this.zzcw[i].zzdh);
        }
        return sb.toString();
    }
}

package _m_j;

import android.content.Context;
import com.amap.api.location.CoordUtil;
import com.amap.api.location.DPoint;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class bwb {

    /* renamed from: O000000o  reason: collision with root package name */
    static double f13328O000000o = 3.141592653589793d;
    private static String O00000Oo = "Jni_wgs2gcj";
    private static final List<DPoint> O00000o0 = new ArrayList(Arrays.asList(new DPoint(23.379947d, 119.757001d), new DPoint(24.983296d, 120.474496d), new DPoint(25.518722d, 121.359866d), new DPoint(25.41329d, 122.443582d), new DPoint(24.862708d, 122.288354d), new DPoint(24.461292d, 122.188319d), new DPoint(21.584761d, 120.968923d), new DPoint(21.830837d, 120.654445d)));

    private static double O000000o(double d) {
        return Math.sin(d * 3000.0d * (f13328O000000o / 180.0d)) * 2.0E-5d;
    }

    private static double O000000o(double d, double d2) {
        return (Math.cos(d2 / 100000.0d) * (d / 18000.0d)) + (Math.sin(d / 100000.0d) * (d2 / 9000.0d));
    }

    public static DPoint O000000o(Context context, double d, double d2) {
        if (context == null) {
            return null;
        }
        return O000000o(context, new DPoint(d2, d));
    }

    public static DPoint O000000o(Context context, DPoint dPoint) {
        if (context == null) {
            return null;
        }
        if (!CoordUtil.isLoadedSo()) {
            System.loadLibrary(O00000Oo);
            CoordUtil.setLoadedSo(true);
        }
        return O00000Oo(dPoint);
    }

    public static DPoint O000000o(DPoint dPoint) {
        if (dPoint != null) {
            try {
                if (bvz.O000000o(dPoint.getLatitude(), dPoint.getLongitude())) {
                    return O00000o0(dPoint);
                }
                if (!bvz.O000000o(new DPoint(dPoint.getLatitude(), dPoint.getLongitude()), O00000o0)) {
                    return dPoint;
                }
                DPoint O00000o02 = O00000o0(dPoint);
                double latitude = O00000o02.getLatitude();
                double longitude = O00000o02.getLongitude();
                double d = longitude - 105.0d;
                double d2 = latitude - 35.0d;
                double d3 = d * 2.0d;
                double d4 = d * 0.1d;
                double d5 = d4 * d2;
                double d6 = 6.0d * d;
                double sqrt = -100.0d + d3 + (d2 * 3.0d) + (d2 * 0.2d * d2) + d5 + (Math.sqrt(Math.abs(d)) * 0.2d) + ((((Math.sin(f13328O000000o * d6) * 20.0d) + (Math.sin(f13328O000000o * d3) * 20.0d)) * 2.0d) / 3.0d) + ((((Math.sin(f13328O000000o * d2) * 20.0d) + (Math.sin((d2 / 3.0d) * f13328O000000o) * 40.0d)) * 2.0d) / 3.0d) + ((((Math.sin((d2 / 12.0d) * f13328O000000o) * 160.0d) + (Math.sin((f13328O000000o * d2) / 30.0d) * 320.0d)) * 2.0d) / 3.0d);
                double sqrt2 = d + 300.0d + (d2 * 2.0d) + (d4 * d) + d5 + (Math.sqrt(Math.abs(d)) * 0.1d) + ((((Math.sin(d6 * f13328O000000o) * 20.0d) + (Math.sin(d3 * f13328O000000o) * 20.0d)) * 2.0d) / 3.0d) + ((((Math.sin(f13328O000000o * d) * 20.0d) + (Math.sin((d / 3.0d) * f13328O000000o) * 40.0d)) * 2.0d) / 3.0d) + ((((Math.sin((d / 12.0d) * f13328O000000o) * 150.0d) + (Math.sin((d / 30.0d) * f13328O000000o) * 300.0d)) * 2.0d) / 3.0d);
                double d7 = (latitude / 180.0d) * f13328O000000o;
                double sin = Math.sin(d7);
                double d8 = 1.0d - ((0.006693421622965943d * sin) * sin);
                double sqrt3 = Math.sqrt(d8);
                DPoint dPoint2 = new DPoint(((sqrt * 180.0d) / ((6335552.717000426d / (d8 * sqrt3)) * f13328O000000o)) + latitude, longitude + ((sqrt2 * 180.0d) / (((6378245.0d / sqrt3) * Math.cos(d7)) * f13328O000000o)));
                return new DPoint((latitude * 2.0d) - dPoint2.getLatitude(), (longitude * 2.0d) - dPoint2.getLongitude());
            } catch (Throwable th) {
                bvz.O000000o(th, "OffsetUtil", "b2G");
            }
        }
        return dPoint;
    }

    private static double O00000Oo(double d) {
        return Math.cos(d * 3000.0d * (f13328O000000o / 180.0d)) * 3.0E-6d;
    }

    private static double O00000Oo(double d, double d2) {
        return (Math.sin(d2 / 100000.0d) * (d / 18000.0d)) + (Math.cos(d / 100000.0d) * (d2 / 9000.0d));
    }

    public static DPoint O00000Oo(Context context, DPoint dPoint) {
        try {
            if (!bvz.O000000o(dPoint.getLatitude(), dPoint.getLongitude())) {
                return dPoint;
            }
            double longitude = (double) (((long) (dPoint.getLongitude() * 100000.0d)) % 36000000);
            double latitude = (double) (((long) (dPoint.getLatitude() * 100000.0d)) % 36000000);
            double d = -O000000o(longitude, latitude);
            Double.isNaN(longitude);
            int i = (int) (d + longitude);
            double d2 = -O00000Oo(longitude, latitude);
            Double.isNaN(latitude);
            double d3 = (double) i;
            double d4 = (double) ((int) (d2 + latitude));
            double d5 = -O000000o(d3, d4);
            Double.isNaN(longitude);
            double d6 = d5 + longitude;
            int i2 = 1;
            double d7 = (double) (longitude > 0.0d ? 1 : -1);
            Double.isNaN(d7);
            double d8 = (double) ((int) (d6 + d7));
            double d9 = -O00000Oo(d8, d4);
            Double.isNaN(latitude);
            double d10 = d9 + latitude;
            if (latitude <= 0.0d) {
                i2 = -1;
            }
            double d11 = (double) i2;
            Double.isNaN(d11);
            Double.isNaN(d8);
            double d12 = d8 / 100000.0d;
            double d13 = (double) ((int) (d10 + d11));
            Double.isNaN(d13);
            DPoint dPoint2 = new DPoint(d13 / 100000.0d, d12);
            Context context2 = context;
            return O000000o(context, dPoint2);
        } catch (Throwable th) {
            bvz.O000000o(th, "OffsetUtil", "marbar2G");
            return dPoint;
        }
    }

    private static DPoint O00000Oo(DPoint dPoint) {
        double longitude;
        double latitude;
        try {
            if (!bvz.O000000o(dPoint.getLatitude(), dPoint.getLongitude())) {
                return dPoint;
            }
            double[] dArr = new double[2];
            try {
                if (CoordUtil.convertToGcj(new double[]{dPoint.getLongitude(), dPoint.getLatitude()}, dArr) != 0) {
                    longitude = dPoint.getLongitude();
                    latitude = dPoint.getLatitude();
                    dArr = bwj.O000000o(longitude, latitude);
                }
            } catch (Throwable th) {
                bvz.O000000o(th, "OffsetUtil", "cover part1");
                longitude = dPoint.getLongitude();
                latitude = dPoint.getLatitude();
            }
            return new DPoint(dArr[1], dArr[0]);
        } catch (Throwable th2) {
            bvz.O000000o(th2, "OffsetUtil", "cover part2");
            return dPoint;
        }
    }

    private static double O00000o0(double d) {
        return new BigDecimal(d).setScale(8, 4).doubleValue();
    }

    private static DPoint O00000o0(DPoint dPoint) {
        double d = 0.006401062d;
        double d2 = 0.0060424805d;
        DPoint dPoint2 = null;
        for (int i = 0; i < 2; i++) {
            double longitude = dPoint.getLongitude();
            double latitude = dPoint.getLatitude();
            dPoint2 = new DPoint();
            double d3 = longitude - d;
            double d4 = latitude - d2;
            DPoint dPoint3 = new DPoint();
            double d5 = (d3 * d3) + (d4 * d4);
            dPoint3.setLongitude(O00000o0((Math.cos(O00000Oo(d3) + Math.atan2(d4, d3)) * (O000000o(d4) + Math.sqrt(d5))) + 0.0065d));
            dPoint3.setLatitude(O00000o0((Math.sin(O00000Oo(d3) + Math.atan2(d4, d3)) * (O000000o(d4) + Math.sqrt(d5))) + 0.006d));
            dPoint2.setLongitude(O00000o0((longitude + d3) - dPoint3.getLongitude()));
            dPoint2.setLatitude(O00000o0((latitude + d4) - dPoint3.getLatitude()));
            d = dPoint.getLongitude() - dPoint2.getLongitude();
            d2 = dPoint.getLatitude() - dPoint2.getLatitude();
        }
        return dPoint2;
    }
}

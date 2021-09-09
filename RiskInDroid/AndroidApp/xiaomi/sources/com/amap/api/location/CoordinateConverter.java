package com.amap.api.location;

import _m_j.bvz;
import _m_j.bwb;
import _m_j.bwi;
import android.content.Context;

public class CoordinateConverter {

    /* renamed from: a  reason: collision with root package name */
    DPoint f3262a = null;
    private Context b;
    private CoordType c = null;
    private DPoint d = null;

    public enum CoordType {
        BAIDU,
        MAPBAR,
        MAPABC,
        SOSOMAP,
        ALIYUN,
        GOOGLE,
        GPS
    }

    public CoordinateConverter(Context context) {
        this.b = context;
    }

    public static float calculateLineDistance(DPoint dPoint, DPoint dPoint2) {
        try {
            return bwi.O000000o(dPoint, dPoint2);
        } catch (Throwable unused) {
            return 0.0f;
        }
    }

    public static boolean isAMapDataAvailable(double d2, double d3) {
        return bvz.O000000o(d2, d3);
    }

    public synchronized DPoint convert() throws Exception {
        DPoint O000000o2;
        if (this.c == null) {
            throw new IllegalArgumentException("转换坐标类型不能为空");
        } else if (this.d == null) {
            throw new IllegalArgumentException("转换坐标源不能为空");
        } else if (this.d.getLongitude() > 180.0d || this.d.getLongitude() < -180.0d) {
            throw new IllegalArgumentException("请传入合理经度");
        } else if (this.d.getLatitude() > 90.0d || this.d.getLatitude() < -90.0d) {
            throw new IllegalArgumentException("请传入合理纬度");
        } else {
            switch (this.c) {
                case BAIDU:
                    O000000o2 = bwb.O000000o(this.d);
                    this.f3262a = O000000o2;
                    break;
                case MAPBAR:
                    O000000o2 = bwb.O00000Oo(this.b, this.d);
                    this.f3262a = O000000o2;
                    break;
                case MAPABC:
                case SOSOMAP:
                case ALIYUN:
                case GOOGLE:
                    O000000o2 = this.d;
                    this.f3262a = O000000o2;
                    break;
                case GPS:
                    O000000o2 = bwb.O000000o(this.b, this.d);
                    this.f3262a = O000000o2;
                    break;
            }
        }
        return this.f3262a;
    }

    public synchronized CoordinateConverter coord(DPoint dPoint) throws Exception {
        if (dPoint != null) {
            try {
                if (dPoint.getLongitude() > 180.0d || dPoint.getLongitude() < -180.0d) {
                    throw new IllegalArgumentException("请传入合理经度");
                } else if (dPoint.getLatitude() > 90.0d || dPoint.getLatitude() < -90.0d) {
                    throw new IllegalArgumentException("请传入合理纬度");
                } else {
                    this.d = dPoint;
                }
            } catch (Throwable th) {
                throw th;
            }
        } else {
            throw new IllegalArgumentException("传入经纬度对象为空");
        }
        return this;
    }

    public synchronized CoordinateConverter from(CoordType coordType) {
        this.c = coordType;
        return this;
    }
}

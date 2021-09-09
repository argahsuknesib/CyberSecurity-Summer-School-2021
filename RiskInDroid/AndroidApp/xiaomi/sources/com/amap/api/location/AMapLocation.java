package com.amap.api.location;

import _m_j.bvz;
import _m_j.bwi;
import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import org.json.JSONObject;

public class AMapLocation extends Location implements Parcelable, Cloneable {
    public static final Parcelable.Creator<AMapLocation> CREATOR = new Parcelable.Creator<AMapLocation>() {
        /* class com.amap.api.location.AMapLocation.AnonymousClass1 */

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AMapLocation aMapLocation = new AMapLocation((Location) Location.CREATOR.createFromParcel(parcel));
            String unused = aMapLocation.h = parcel.readString();
            String unused2 = aMapLocation.i = parcel.readString();
            String unused3 = aMapLocation.w = parcel.readString();
            aMapLocation.f3251a = parcel.readString();
            String unused4 = aMapLocation.e = parcel.readString();
            String unused5 = aMapLocation.g = parcel.readString();
            String unused6 = aMapLocation.k = parcel.readString();
            String unused7 = aMapLocation.f = parcel.readString();
            int unused8 = aMapLocation.p = parcel.readInt();
            String unused9 = aMapLocation.q = parcel.readString();
            aMapLocation.b = parcel.readString();
            boolean z = true;
            boolean unused10 = aMapLocation.A = parcel.readInt() != 0;
            boolean unused11 = aMapLocation.o = parcel.readInt() != 0;
            double unused12 = aMapLocation.t = parcel.readDouble();
            String unused13 = aMapLocation.r = parcel.readString();
            int unused14 = aMapLocation.s = parcel.readInt();
            double unused15 = aMapLocation.u = parcel.readDouble();
            if (parcel.readInt() == 0) {
                z = false;
            }
            boolean unused16 = aMapLocation.y = z;
            String unused17 = aMapLocation.n = parcel.readString();
            String unused18 = aMapLocation.j = parcel.readString();
            String unused19 = aMapLocation.d = parcel.readString();
            String unused20 = aMapLocation.l = parcel.readString();
            int unused21 = aMapLocation.v = parcel.readInt();
            int unused22 = aMapLocation.x = parcel.readInt();
            String unused23 = aMapLocation.m = parcel.readString();
            String unused24 = aMapLocation.z = parcel.readString();
            String unused25 = aMapLocation.B = parcel.readString();
            int unused26 = aMapLocation.C = parcel.readInt();
            int unused27 = aMapLocation.D = parcel.readInt();
            return aMapLocation;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AMapLocation[i];
        }
    };
    /* access modifiers changed from: private */
    public boolean A = false;
    /* access modifiers changed from: private */
    public String B = "GCJ02";
    /* access modifiers changed from: private */
    public int C = 1;
    /* access modifiers changed from: private */
    public int D;

    /* renamed from: a  reason: collision with root package name */
    protected String f3251a = "";
    protected String b = "";
    AMapLocationQualityReport c = new AMapLocationQualityReport();
    /* access modifiers changed from: private */
    public String d = "";
    /* access modifiers changed from: private */
    public String e = "";
    /* access modifiers changed from: private */
    public String f = "";
    /* access modifiers changed from: private */
    public String g = "";
    /* access modifiers changed from: private */
    public String h = "";
    /* access modifiers changed from: private */
    public String i = "";
    /* access modifiers changed from: private */
    public String j = "";
    /* access modifiers changed from: private */
    public String k = "";
    /* access modifiers changed from: private */
    public String l = "";
    /* access modifiers changed from: private */
    public String m = "";
    /* access modifiers changed from: private */
    public String n = "";
    /* access modifiers changed from: private */
    public boolean o = true;
    /* access modifiers changed from: private */
    public int p = 0;
    /* access modifiers changed from: private */
    public String q = "success";
    /* access modifiers changed from: private */
    public String r = "";
    /* access modifiers changed from: private */
    public int s = 0;
    /* access modifiers changed from: private */
    public double t = 0.0d;
    /* access modifiers changed from: private */
    public double u = 0.0d;
    /* access modifiers changed from: private */
    public int v = 0;
    /* access modifiers changed from: private */
    public String w = "";
    /* access modifiers changed from: private */
    public int x = -1;
    /* access modifiers changed from: private */
    public boolean y = false;
    /* access modifiers changed from: private */
    public String z = "";

    public AMapLocation(Location location) {
        super(location);
        this.t = location.getLatitude();
        this.u = location.getLongitude();
    }

    public AMapLocation(String str) {
        super(str);
    }

    public AMapLocation clone() {
        try {
            super.clone();
        } catch (Throwable unused) {
        }
        AMapLocation aMapLocation = new AMapLocation(this);
        try {
            aMapLocation.setLatitude(this.t);
            aMapLocation.setLongitude(this.u);
            aMapLocation.setAdCode(this.h);
            aMapLocation.setAddress(this.i);
            aMapLocation.setAoiName(this.w);
            aMapLocation.setBuildingId(this.f3251a);
            aMapLocation.setCity(this.e);
            aMapLocation.setCityCode(this.g);
            aMapLocation.setCountry(this.k);
            aMapLocation.setDistrict(this.f);
            aMapLocation.setErrorCode(this.p);
            aMapLocation.setErrorInfo(this.q);
            aMapLocation.setFloor(this.b);
            aMapLocation.setFixLastLocation(this.A);
            aMapLocation.setOffset(this.o);
            aMapLocation.setLocationDetail(this.r);
            aMapLocation.setLocationType(this.s);
            aMapLocation.setMock(this.y);
            aMapLocation.setNumber(this.n);
            aMapLocation.setPoiName(this.j);
            aMapLocation.setProvince(this.d);
            aMapLocation.setRoad(this.l);
            aMapLocation.setSatellites(this.v);
            aMapLocation.setGpsAccuracyStatus(this.x);
            aMapLocation.setStreet(this.m);
            aMapLocation.setDescription(this.z);
            aMapLocation.setExtras(getExtras());
            if (this.c != null) {
                aMapLocation.setLocationQualityReport(this.c.clone());
            }
            aMapLocation.setCoordType(this.B);
            aMapLocation.setTrustedLevel(this.C);
            aMapLocation.setConScenario(this.D);
        } catch (Throwable th) {
            bvz.O000000o(th, "AMapLocation", "clone");
        }
        return aMapLocation;
    }

    public int describeContents() {
        return 0;
    }

    public float getAccuracy() {
        return super.getAccuracy();
    }

    public String getAdCode() {
        return this.h;
    }

    public String getAddress() {
        return this.i;
    }

    public double getAltitude() {
        return super.getAltitude();
    }

    public String getAoiName() {
        return this.w;
    }

    public float getBearing() {
        return super.getBearing();
    }

    public String getBuildingId() {
        return this.f3251a;
    }

    public String getCity() {
        return this.e;
    }

    public String getCityCode() {
        return this.g;
    }

    public int getConScenario() {
        return this.D;
    }

    public String getCoordType() {
        return this.B;
    }

    public String getCountry() {
        return this.k;
    }

    public String getDescription() {
        return this.z;
    }

    public String getDistrict() {
        return this.f;
    }

    public int getErrorCode() {
        return this.p;
    }

    public String getErrorInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.q);
        if (this.p != 0) {
            sb.append(" 请到http://lbs.amap.com/api/android-location-sdk/guide/utilities/errorcode/查看错误码说明");
            sb.append(",错误详细信息:" + this.r);
        }
        return sb.toString();
    }

    public String getFloor() {
        return this.b;
    }

    public int getGpsAccuracyStatus() {
        return this.x;
    }

    public double getLatitude() {
        return this.t;
    }

    public String getLocationDetail() {
        return this.r;
    }

    public AMapLocationQualityReport getLocationQualityReport() {
        return this.c;
    }

    public int getLocationType() {
        return this.s;
    }

    public double getLongitude() {
        return this.u;
    }

    public String getPoiName() {
        return this.j;
    }

    public String getProvider() {
        return super.getProvider();
    }

    public String getProvince() {
        return this.d;
    }

    public String getRoad() {
        return this.l;
    }

    public int getSatellites() {
        return this.v;
    }

    public float getSpeed() {
        return super.getSpeed();
    }

    public String getStreet() {
        return this.m;
    }

    public String getStreetNum() {
        return this.n;
    }

    public int getTrustedLevel() {
        return this.C;
    }

    public boolean isFixLastLocation() {
        return this.A;
    }

    public boolean isMock() {
        return this.y;
    }

    public boolean isOffset() {
        return this.o;
    }

    public void setAdCode(String str) {
        this.h = str;
    }

    public void setAddress(String str) {
        this.i = str;
    }

    public void setAoiName(String str) {
        this.w = str;
    }

    public void setBuildingId(String str) {
        this.f3251a = str;
    }

    public void setCity(String str) {
        this.e = str;
    }

    public void setCityCode(String str) {
        this.g = str;
    }

    public void setConScenario(int i2) {
        this.D = i2;
    }

    public void setCoordType(String str) {
        this.B = str;
    }

    public void setCountry(String str) {
        this.k = str;
    }

    public void setDescription(String str) {
        this.z = str;
    }

    public void setDistrict(String str) {
        this.f = str;
    }

    public void setErrorCode(int i2) {
        if (this.p == 0) {
            this.q = bwi.O00000Oo(i2);
            this.p = i2;
        }
    }

    public void setErrorInfo(String str) {
        this.q = str;
    }

    public void setFixLastLocation(boolean z2) {
        this.A = z2;
    }

    public void setFloor(String str) {
        if (!TextUtils.isEmpty(str)) {
            str = str.replace("F", "");
            try {
                Integer.parseInt(str);
            } catch (Throwable th) {
                bvz.O000000o(th, "AmapLoc", "setFloor");
                str = null;
            }
        }
        this.b = str;
    }

    public void setGpsAccuracyStatus(int i2) {
        this.x = i2;
    }

    public void setLatitude(double d2) {
        this.t = d2;
    }

    public void setLocationDetail(String str) {
        this.r = str;
    }

    public void setLocationQualityReport(AMapLocationQualityReport aMapLocationQualityReport) {
        if (aMapLocationQualityReport != null) {
            this.c = aMapLocationQualityReport;
        }
    }

    public void setLocationType(int i2) {
        this.s = i2;
    }

    public void setLongitude(double d2) {
        this.u = d2;
    }

    public void setMock(boolean z2) {
        this.y = z2;
    }

    public void setNumber(String str) {
        this.n = str;
    }

    public void setOffset(boolean z2) {
        this.o = z2;
    }

    public void setPoiName(String str) {
        this.j = str;
    }

    public void setProvince(String str) {
        this.d = str;
    }

    public void setRoad(String str) {
        this.l = str;
    }

    public void setSatellites(int i2) {
        this.v = i2;
    }

    public void setStreet(String str) {
        this.m = str;
    }

    public void setTrustedLevel(int i2) {
        this.C = i2;
    }

    public JSONObject toJson(int i2) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (i2 == 1) {
                try {
                    jSONObject.put("altitude", getAltitude());
                    jSONObject.put("speed", (double) getSpeed());
                    jSONObject.put("bearing", (double) getBearing());
                } catch (Throwable unused) {
                }
                jSONObject.put("citycode", this.g);
                jSONObject.put("adcode", this.h);
                jSONObject.put("country", this.k);
                jSONObject.put("province", this.d);
                jSONObject.put("city", this.e);
                jSONObject.put("district", this.f);
                jSONObject.put("road", this.l);
                jSONObject.put("street", this.m);
                jSONObject.put("number", this.n);
                jSONObject.put("poiname", this.j);
                jSONObject.put("errorCode", this.p);
                jSONObject.put("errorInfo", this.q);
                jSONObject.put("locationType", this.s);
                jSONObject.put("locationDetail", this.r);
                jSONObject.put("aoiname", this.w);
                jSONObject.put("address", this.i);
                jSONObject.put("poiid", this.f3251a);
                jSONObject.put("floor", this.b);
                jSONObject.put("description", this.z);
            } else if (i2 != 2) {
                if (i2 != 3) {
                    return jSONObject;
                }
                jSONObject.put("provider", getProvider());
                jSONObject.put("lon", getLongitude());
                jSONObject.put("lat", getLatitude());
                jSONObject.put("accuracy", (double) getAccuracy());
                jSONObject.put("isOffset", this.o);
                jSONObject.put("isFixLastLocation", this.A);
                jSONObject.put("coordType", this.B);
                return jSONObject;
            }
            jSONObject.put("time", getTime());
            jSONObject.put("provider", getProvider());
            jSONObject.put("lon", getLongitude());
            jSONObject.put("lat", getLatitude());
            jSONObject.put("accuracy", (double) getAccuracy());
            jSONObject.put("isOffset", this.o);
            jSONObject.put("isFixLastLocation", this.A);
            jSONObject.put("coordType", this.B);
            return jSONObject;
        } catch (Throwable th) {
            bvz.O000000o(th, "AmapLoc", "toStr");
            return null;
        }
    }

    public String toStr() {
        return toStr(1);
    }

    public String toStr(int i2) {
        JSONObject jSONObject;
        try {
            jSONObject = toJson(i2);
        } catch (Throwable th) {
            bvz.O000000o(th, "AMapLocation", "toStr part2");
            jSONObject = null;
        }
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.toString();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            stringBuffer.append("latitude=" + this.t + "#");
            stringBuffer.append("longitude=" + this.u + "#");
            stringBuffer.append("province=" + this.d + "#");
            stringBuffer.append("coordType=" + this.B + "#");
            stringBuffer.append("city=" + this.e + "#");
            stringBuffer.append("district=" + this.f + "#");
            stringBuffer.append("cityCode=" + this.g + "#");
            stringBuffer.append("adCode=" + this.h + "#");
            stringBuffer.append("address=" + this.i + "#");
            stringBuffer.append("country=" + this.k + "#");
            stringBuffer.append("road=" + this.l + "#");
            stringBuffer.append("poiName=" + this.j + "#");
            stringBuffer.append("street=" + this.m + "#");
            stringBuffer.append("streetNum=" + this.n + "#");
            stringBuffer.append("aoiName=" + this.w + "#");
            stringBuffer.append("poiid=" + this.f3251a + "#");
            stringBuffer.append("floor=" + this.b + "#");
            stringBuffer.append("errorCode=" + this.p + "#");
            stringBuffer.append("errorInfo=" + this.q + "#");
            stringBuffer.append("locationDetail=" + this.r + "#");
            stringBuffer.append("description=" + this.z + "#");
            stringBuffer.append("locationType=" + this.s + "#");
            StringBuilder sb = new StringBuilder("conScenario=");
            sb.append(this.D);
            stringBuffer.append(sb.toString());
        } catch (Throwable unused) {
        }
        return stringBuffer.toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        try {
            super.writeToParcel(parcel, i2);
            parcel.writeString(this.h);
            parcel.writeString(this.i);
            parcel.writeString(this.w);
            parcel.writeString(this.f3251a);
            parcel.writeString(this.e);
            parcel.writeString(this.g);
            parcel.writeString(this.k);
            parcel.writeString(this.f);
            parcel.writeInt(this.p);
            parcel.writeString(this.q);
            parcel.writeString(this.b);
            int i3 = 1;
            parcel.writeInt(this.A ? 1 : 0);
            parcel.writeInt(this.o ? 1 : 0);
            parcel.writeDouble(this.t);
            parcel.writeString(this.r);
            parcel.writeInt(this.s);
            parcel.writeDouble(this.u);
            if (!this.y) {
                i3 = 0;
            }
            parcel.writeInt(i3);
            parcel.writeString(this.n);
            parcel.writeString(this.j);
            parcel.writeString(this.d);
            parcel.writeString(this.l);
            parcel.writeInt(this.v);
            parcel.writeInt(this.x);
            parcel.writeString(this.m);
            parcel.writeString(this.z);
            parcel.writeString(this.B);
            parcel.writeInt(this.C);
            parcel.writeInt(this.D);
        } catch (Throwable th) {
            bvz.O000000o(th, "AMapLocation", "writeToParcel");
        }
    }
}

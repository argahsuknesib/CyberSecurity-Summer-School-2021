package com.amap.api.services.busline;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.a.s;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BusLineItem implements Parcelable {
    public static final Parcelable.Creator<BusLineItem> CREATOR = new Parcelable.Creator<BusLineItem>() {
        /* class com.amap.api.services.busline.BusLineItem.AnonymousClass1 */

        /* renamed from: a */
        public final BusLineItem[] newArray(int i) {
            return null;
        }

        /* renamed from: a */
        public final BusLineItem createFromParcel(Parcel parcel) {
            return new BusLineItem(parcel);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private float f3425a;
    private String b;
    private String c;
    private String d;
    private List<LatLonPoint> e = new ArrayList();
    private List<LatLonPoint> f = new ArrayList();
    private String g;
    private String h;
    private String i;
    private Date j;
    private Date k;
    private String l;
    private float m;
    private float n;
    private List<BusStationItem> o = new ArrayList();

    public int describeContents() {
        return 0;
    }

    public BusLineItem() {
    }

    public float getDistance() {
        return this.f3425a;
    }

    public void setDistance(float f2) {
        this.f3425a = f2;
    }

    public String getBusLineName() {
        return this.b;
    }

    public void setBusLineName(String str) {
        this.b = str;
    }

    public String getBusLineType() {
        return this.c;
    }

    public void setBusLineType(String str) {
        this.c = str;
    }

    public String getCityCode() {
        return this.d;
    }

    public void setCityCode(String str) {
        this.d = str;
    }

    public List<LatLonPoint> getDirectionsCoordinates() {
        return this.e;
    }

    public void setDirectionsCoordinates(List<LatLonPoint> list) {
        this.e = list;
    }

    public List<LatLonPoint> getBounds() {
        return this.f;
    }

    public void setBounds(List<LatLonPoint> list) {
        this.f = list;
    }

    public String getBusLineId() {
        return this.g;
    }

    public void setBusLineId(String str) {
        this.g = str;
    }

    public String getOriginatingStation() {
        return this.h;
    }

    public void setOriginatingStation(String str) {
        this.h = str;
    }

    public String getTerminalStation() {
        return this.i;
    }

    public void setTerminalStation(String str) {
        this.i = str;
    }

    public Date getFirstBusTime() {
        Date date = this.j;
        if (date == null) {
            return null;
        }
        return (Date) date.clone();
    }

    public void setFirstBusTime(Date date) {
        if (date == null) {
            this.j = null;
        } else {
            this.j = (Date) date.clone();
        }
    }

    public Date getLastBusTime() {
        Date date = this.k;
        if (date == null) {
            return null;
        }
        return (Date) date.clone();
    }

    public void setLastBusTime(Date date) {
        if (date == null) {
            this.k = null;
        } else {
            this.k = (Date) date.clone();
        }
    }

    public String getBusCompany() {
        return this.l;
    }

    public void setBusCompany(String str) {
        this.l = str;
    }

    public float getBasicPrice() {
        return this.m;
    }

    public void setBasicPrice(float f2) {
        this.m = f2;
    }

    public float getTotalPrice() {
        return this.n;
    }

    public void setTotalPrice(float f2) {
        this.n = f2;
    }

    public List<BusStationItem> getBusStations() {
        return this.o;
    }

    public void setBusStations(List<BusStationItem> list) {
        this.o = list;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BusLineItem busLineItem = (BusLineItem) obj;
        String str = this.g;
        if (str == null) {
            if (busLineItem.g != null) {
                return false;
            }
        } else if (!str.equals(busLineItem.g)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i2;
        String str = this.g;
        if (str == null) {
            i2 = 0;
        } else {
            i2 = str.hashCode();
        }
        return i2 + 31;
    }

    public String toString() {
        return this.b + " " + s.a(this.j) + "-" + s.a(this.k);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeFloat(this.f3425a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeList(this.e);
        parcel.writeList(this.f);
        parcel.writeString(this.g);
        parcel.writeString(this.h);
        parcel.writeString(this.i);
        parcel.writeString(s.a(this.j));
        parcel.writeString(s.a(this.k));
        parcel.writeString(this.l);
        parcel.writeFloat(this.m);
        parcel.writeFloat(this.n);
        parcel.writeList(this.o);
    }

    public BusLineItem(Parcel parcel) {
        this.f3425a = parcel.readFloat();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.e = parcel.readArrayList(LatLonPoint.class.getClassLoader());
        this.f = parcel.readArrayList(LatLonPoint.class.getClassLoader());
        this.g = parcel.readString();
        this.h = parcel.readString();
        this.i = parcel.readString();
        this.j = s.d(parcel.readString());
        this.k = s.d(parcel.readString());
        this.l = parcel.readString();
        this.m = parcel.readFloat();
        this.n = parcel.readFloat();
        this.o = parcel.readArrayList(BusStationItem.class.getClassLoader());
    }
}

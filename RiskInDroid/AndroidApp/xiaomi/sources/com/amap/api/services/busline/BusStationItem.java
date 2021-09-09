package com.amap.api.services.busline;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

public class BusStationItem implements Parcelable {
    public static final Parcelable.Creator<BusStationItem> CREATOR = new Parcelable.Creator<BusStationItem>() {
        /* class com.amap.api.services.busline.BusStationItem.AnonymousClass1 */

        /* renamed from: a */
        public final BusStationItem[] newArray(int i) {
            return null;
        }

        /* renamed from: a */
        public final BusStationItem createFromParcel(Parcel parcel) {
            return new BusStationItem(parcel);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f3430a;
    private String b;
    private LatLonPoint c;
    private String d;
    private String e;
    private List<BusLineItem> f;

    public int describeContents() {
        return 0;
    }

    public BusStationItem() {
        this.f = new ArrayList();
    }

    public String getBusStationId() {
        return this.f3430a;
    }

    public void setBusStationId(String str) {
        this.f3430a = str;
    }

    public String getBusStationName() {
        return this.b;
    }

    public void setBusStationName(String str) {
        this.b = str;
    }

    public LatLonPoint getLatLonPoint() {
        return this.c;
    }

    public void setLatLonPoint(LatLonPoint latLonPoint) {
        this.c = latLonPoint;
    }

    public String getCityCode() {
        return this.d;
    }

    public void setCityCode(String str) {
        this.d = str;
    }

    public String getAdCode() {
        return this.e;
    }

    public void setAdCode(String str) {
        this.e = str;
    }

    public List<BusLineItem> getBusLineItems() {
        return this.f;
    }

    public void setBusLineItems(List<BusLineItem> list) {
        this.f = list;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BusStationItem busStationItem = (BusStationItem) obj;
        String str = this.f3430a;
        if (str == null) {
            if (busStationItem.f3430a != null) {
                return false;
            }
        } else if (!str.equals(busStationItem.f3430a)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i;
        String str = this.f3430a;
        if (str == null) {
            i = 0;
        } else {
            i = str.hashCode();
        }
        return i + 31;
    }

    public String toString() {
        return "BusStationName: " + this.b + " LatLonPoint: " + this.c.toString() + " BusLines: " + a(this.f) + " CityCode: " + this.d + " AdCode: " + this.e;
    }

    private String a(List<BusLineItem> list) {
        StringBuffer stringBuffer = new StringBuffer();
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                stringBuffer.append(list.get(i).getBusLineName());
                if (i < list.size() - 1) {
                    stringBuffer.append("|");
                }
            }
        }
        return stringBuffer.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.b);
        parcel.writeString(this.f3430a);
        parcel.writeValue(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeList(this.f);
    }

    private BusStationItem(Parcel parcel) {
        this.f = new ArrayList();
        this.b = parcel.readString();
        this.f3430a = parcel.readString();
        this.c = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.d = parcel.readString();
        this.e = parcel.readString();
        this.f = parcel.readArrayList(BusLineItem.class.getClassLoader());
    }
}

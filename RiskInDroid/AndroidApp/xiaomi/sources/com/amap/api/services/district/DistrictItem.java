package com.amap.api.services.district;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class DistrictItem implements Parcelable {
    public static final Parcelable.Creator<DistrictItem> CREATOR = new Parcelable.Creator<DistrictItem>() {
        /* class com.amap.api.services.district.DistrictItem.AnonymousClass1 */

        /* renamed from: a */
        public final DistrictItem createFromParcel(Parcel parcel) {
            return new DistrictItem(parcel);
        }

        /* renamed from: a */
        public final DistrictItem[] newArray(int i) {
            return new DistrictItem[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f3447a;
    private String b;
    private String c;
    private LatLonPoint d;
    private String e;
    private List<DistrictItem> f = new ArrayList();
    private String[] g = new String[0];

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f3447a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeParcelable(this.d, i);
        parcel.writeString(this.e);
        parcel.writeTypedList(this.f);
        parcel.writeInt(this.g.length);
        parcel.writeStringArray(this.g);
    }

    public final void setDistrictBoundary(String[] strArr) {
        this.g = strArr;
    }

    public final String[] districtBoundary() {
        return this.g;
    }

    public DistrictItem() {
    }

    public DistrictItem(String str, String str2, String str3, LatLonPoint latLonPoint, String str4) {
        this.c = str;
        this.f3447a = str2;
        this.b = str3;
        this.d = latLonPoint;
        this.e = str4;
    }

    public final String getCitycode() {
        return this.f3447a;
    }

    public final void setCitycode(String str) {
        this.f3447a = str;
    }

    public final String getAdcode() {
        return this.b;
    }

    public final void setAdcode(String str) {
        this.b = str;
    }

    public final String getName() {
        return this.c;
    }

    public final void setName(String str) {
        this.c = str;
    }

    public final LatLonPoint getCenter() {
        return this.d;
    }

    public final void setCenter(LatLonPoint latLonPoint) {
        this.d = latLonPoint;
    }

    public final String getLevel() {
        return this.e;
    }

    public final void setLevel(String str) {
        this.e = str;
    }

    public final List<DistrictItem> getSubDistrict() {
        return this.f;
    }

    public final void setSubDistrict(ArrayList<DistrictItem> arrayList) {
        this.f = arrayList;
    }

    public DistrictItem(Parcel parcel) {
        this.f3447a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.e = parcel.readString();
        this.f = parcel.createTypedArrayList(CREATOR);
        this.g = new String[parcel.readInt()];
        parcel.readStringArray(this.g);
    }

    public final int hashCode() {
        int i;
        int i2;
        String str = this.b;
        int i3 = 0;
        int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        LatLonPoint latLonPoint = this.d;
        int hashCode2 = (hashCode + (latLonPoint == null ? 0 : latLonPoint.hashCode())) * 31;
        String str2 = this.f3447a;
        if (str2 == null) {
            i = 0;
        } else {
            i = str2.hashCode();
        }
        int hashCode3 = (((hashCode2 + i) * 31) + Arrays.hashCode(this.g)) * 31;
        List<DistrictItem> list = this.f;
        if (list == null) {
            i2 = 0;
        } else {
            i2 = list.hashCode();
        }
        int i4 = (hashCode3 + i2) * 31;
        String str3 = this.e;
        int hashCode4 = (i4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.c;
        if (str4 != null) {
            i3 = str4.hashCode();
        }
        return hashCode4 + i3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        DistrictItem districtItem = (DistrictItem) obj;
        String str = this.b;
        if (str == null) {
            if (districtItem.b != null) {
                return false;
            }
        } else if (!str.equals(districtItem.b)) {
            return false;
        }
        LatLonPoint latLonPoint = this.d;
        if (latLonPoint == null) {
            if (districtItem.d != null) {
                return false;
            }
        } else if (!latLonPoint.equals(districtItem.d)) {
            return false;
        }
        String str2 = this.f3447a;
        if (str2 == null) {
            if (districtItem.f3447a != null) {
                return false;
            }
        } else if (!str2.equals(districtItem.f3447a)) {
            return false;
        }
        if (!Arrays.equals(this.g, districtItem.g)) {
            return false;
        }
        List<DistrictItem> list = this.f;
        if (list == null) {
            if (districtItem.f != null) {
                return false;
            }
        } else if (!list.equals(districtItem.f)) {
            return false;
        }
        String str3 = this.e;
        if (str3 == null) {
            if (districtItem.e != null) {
                return false;
            }
        } else if (!str3.equals(districtItem.e)) {
            return false;
        }
        String str4 = this.c;
        if (str4 == null) {
            if (districtItem.c != null) {
                return false;
            }
        } else if (!str4.equals(districtItem.c)) {
            return false;
        }
        return true;
    }

    public final String toString() {
        return "DistrictItem [mCitycode=" + this.f3447a + ", mAdcode=" + this.b + ", mName=" + this.c + ", mCenter=" + this.d + ", mLevel=" + this.e + ", mDistricts=" + this.f + "]";
    }
}

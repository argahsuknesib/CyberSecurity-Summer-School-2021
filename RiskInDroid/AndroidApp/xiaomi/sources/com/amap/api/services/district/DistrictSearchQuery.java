package com.amap.api.services.district;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.a.s;

public class DistrictSearchQuery implements Parcelable, Cloneable {
    public static final Parcelable.Creator<DistrictSearchQuery> CREATOR = new Parcelable.Creator<DistrictSearchQuery>() {
        /* class com.amap.api.services.district.DistrictSearchQuery.AnonymousClass1 */

        /* renamed from: a */
        public final DistrictSearchQuery createFromParcel(Parcel parcel) {
            DistrictSearchQuery districtSearchQuery = new DistrictSearchQuery();
            districtSearchQuery.setKeywords(parcel.readString());
            districtSearchQuery.setKeywordsLevel(parcel.readString());
            districtSearchQuery.setPageNum(parcel.readInt());
            districtSearchQuery.setPageSize(parcel.readInt());
            boolean z = false;
            districtSearchQuery.setShowChild(parcel.readByte() == 1);
            districtSearchQuery.setShowBoundary(parcel.readByte() == 1);
            if (parcel.readByte() == 1) {
                z = true;
            }
            districtSearchQuery.setShowBusinessArea(z);
            return districtSearchQuery;
        }

        /* renamed from: a */
        public final DistrictSearchQuery[] newArray(int i) {
            return new DistrictSearchQuery[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private int f3451a;
    private int b;
    private String c;
    private String d;
    private boolean e;
    private boolean f;
    private boolean g;

    public int describeContents() {
        return 0;
    }

    public void setShowBoundary(boolean z) {
        this.g = z;
    }

    public boolean isShowBoundary() {
        return this.g;
    }

    public DistrictSearchQuery() {
        this.f3451a = 1;
        this.b = 20;
        this.e = true;
        this.f = false;
        this.g = false;
    }

    public DistrictSearchQuery(String str, String str2, int i) {
        this.f3451a = 1;
        this.b = 20;
        this.e = true;
        this.f = false;
        this.g = false;
        this.c = str;
        this.d = str2;
        this.f3451a = i;
    }

    public DistrictSearchQuery(String str, String str2, int i, boolean z, int i2) {
        this(str, str2, i);
        this.e = z;
        this.b = i2;
    }

    public int getPageNum() {
        int i = this.f3451a;
        if (i <= 0) {
            return 1;
        }
        return i;
    }

    public void setPageNum(int i) {
        this.f3451a = i;
    }

    public int getPageSize() {
        return this.b;
    }

    public void setPageSize(int i) {
        this.b = i;
    }

    public String getKeywords() {
        return this.c;
    }

    public void setKeywords(String str) {
        this.c = str;
    }

    public String getKeywordsLevel() {
        return this.d;
    }

    public void setKeywordsLevel(String str) {
        this.d = str;
    }

    public boolean isShowChild() {
        return this.e;
    }

    public void setShowChild(boolean z) {
        this.e = z;
    }

    public boolean isShowBusinessArea() {
        return this.f;
    }

    public void setShowBusinessArea(boolean z) {
        this.f = z;
    }

    public boolean checkLevels() {
        String str = this.d;
        if (str == null) {
            return false;
        }
        if (str.trim().equals("country") || this.d.trim().equals("province") || this.d.trim().equals("city") || this.d.trim().equals("district") || this.d.trim().equals("biz_area")) {
            return true;
        }
        return false;
    }

    public boolean checkKeyWords() {
        String str = this.c;
        if (str != null && !str.trim().equalsIgnoreCase("")) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i;
        int i2 = 1231;
        int i3 = ((this.g ? 1231 : 1237) + 31) * 31;
        String str = this.c;
        int i4 = 0;
        if (str == null) {
            i = 0;
        } else {
            i = str.hashCode();
        }
        int i5 = (i3 + i) * 31;
        String str2 = this.d;
        if (str2 != null) {
            i4 = str2.hashCode();
        }
        int i6 = (((((i5 + i4) * 31) + this.f3451a) * 31) + this.b) * 31;
        if (!this.e) {
            i2 = 1237;
        }
        return i6 + i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        DistrictSearchQuery districtSearchQuery = (DistrictSearchQuery) obj;
        if (this.g != districtSearchQuery.g) {
            return false;
        }
        String str = this.c;
        if (str == null) {
            if (districtSearchQuery.c != null) {
                return false;
            }
        } else if (!str.equals(districtSearchQuery.c)) {
            return false;
        }
        return this.f3451a == districtSearchQuery.f3451a && this.b == districtSearchQuery.b && this.e == districtSearchQuery.e;
    }

    public boolean weakEquals(DistrictSearchQuery districtSearchQuery) {
        if (this == districtSearchQuery) {
            return true;
        }
        if (districtSearchQuery == null) {
            return false;
        }
        String str = this.c;
        if (str == null) {
            if (districtSearchQuery.c != null) {
                return false;
            }
        } else if (!str.equals(districtSearchQuery.c)) {
            return false;
        }
        return this.b == districtSearchQuery.b && this.e == districtSearchQuery.e && this.g == districtSearchQuery.g;
    }

    public DistrictSearchQuery clone() {
        try {
            super.clone();
        } catch (CloneNotSupportedException e2) {
            s.a(e2, "DistrictSearchQuery", "clone");
        }
        DistrictSearchQuery districtSearchQuery = new DistrictSearchQuery();
        districtSearchQuery.setKeywords(this.c);
        districtSearchQuery.setKeywordsLevel(this.d);
        districtSearchQuery.setPageNum(this.f3451a);
        districtSearchQuery.setPageSize(this.b);
        districtSearchQuery.setShowChild(this.e);
        districtSearchQuery.setShowBoundary(this.g);
        districtSearchQuery.setShowBusinessArea(this.f);
        return districtSearchQuery;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeInt(this.f3451a);
        parcel.writeInt(this.b);
        parcel.writeByte(this.e ? (byte) 1 : 0);
        parcel.writeByte(this.g ? (byte) 1 : 0);
        parcel.writeByte(this.f ? (byte) 1 : 0);
    }
}

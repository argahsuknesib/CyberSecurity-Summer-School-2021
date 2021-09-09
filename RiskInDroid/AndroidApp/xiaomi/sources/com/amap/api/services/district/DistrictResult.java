package com.amap.api.services.district;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.AMapException;
import java.util.ArrayList;

public final class DistrictResult implements Parcelable {
    public Parcelable.Creator<DistrictResult> CREATOR = new Parcelable.Creator<DistrictResult>() {
        /* class com.amap.api.services.district.DistrictResult.AnonymousClass1 */

        /* renamed from: a */
        public DistrictResult createFromParcel(Parcel parcel) {
            return new DistrictResult(parcel);
        }

        /* renamed from: a */
        public DistrictResult[] newArray(int i) {
            return new DistrictResult[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private DistrictSearchQuery f3448a;
    private ArrayList<DistrictItem> b = new ArrayList<>();
    private int c;
    private AMapException d;

    public final int describeContents() {
        return 0;
    }

    public DistrictResult(DistrictSearchQuery districtSearchQuery, ArrayList<DistrictItem> arrayList) {
        this.f3448a = districtSearchQuery;
        this.b = arrayList;
    }

    public DistrictResult() {
    }

    public final ArrayList<DistrictItem> getDistrict() {
        return this.b;
    }

    public final void setDistrict(ArrayList<DistrictItem> arrayList) {
        this.b = arrayList;
    }

    public final DistrictSearchQuery getQuery() {
        return this.f3448a;
    }

    public final void setQuery(DistrictSearchQuery districtSearchQuery) {
        this.f3448a = districtSearchQuery;
    }

    public final int getPageCount() {
        return this.c;
    }

    public final void setPageCount(int i) {
        this.c = i;
    }

    public final AMapException getAMapException() {
        return this.d;
    }

    public final void setAMapException(AMapException aMapException) {
        this.d = aMapException;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f3448a, i);
        parcel.writeTypedList(this.b);
    }

    protected DistrictResult(Parcel parcel) {
        this.f3448a = (DistrictSearchQuery) parcel.readParcelable(DistrictSearchQuery.class.getClassLoader());
        this.b = parcel.createTypedArrayList(DistrictItem.CREATOR);
    }

    public final int hashCode() {
        int i;
        DistrictSearchQuery districtSearchQuery = this.f3448a;
        int i2 = 0;
        if (districtSearchQuery == null) {
            i = 0;
        } else {
            i = districtSearchQuery.hashCode();
        }
        int i3 = (i + 31) * 31;
        ArrayList<DistrictItem> arrayList = this.b;
        if (arrayList != null) {
            i2 = arrayList.hashCode();
        }
        return i3 + i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        DistrictResult districtResult = (DistrictResult) obj;
        DistrictSearchQuery districtSearchQuery = this.f3448a;
        if (districtSearchQuery == null) {
            if (districtResult.f3448a != null) {
                return false;
            }
        } else if (!districtSearchQuery.equals(districtResult.f3448a)) {
            return false;
        }
        ArrayList<DistrictItem> arrayList = this.b;
        if (arrayList == null) {
            if (districtResult.b != null) {
                return false;
            }
        } else if (!arrayList.equals(districtResult.b)) {
            return false;
        }
        return true;
    }

    public final String toString() {
        return "DistrictResult [mDisQuery=" + this.f3448a + ", mDistricts=" + this.b + "]";
    }
}

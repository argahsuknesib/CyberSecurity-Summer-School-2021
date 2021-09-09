package com.amap.api.services.cloud;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

public class CloudItemDetail extends CloudItem implements Parcelable {
    public static final Parcelable.Creator<CloudItemDetail> CREATOR = new Parcelable.Creator<CloudItemDetail>() {
        /* class com.amap.api.services.cloud.CloudItemDetail.AnonymousClass1 */

        /* renamed from: a */
        public final CloudItemDetail createFromParcel(Parcel parcel) {
            return new CloudItemDetail(parcel);
        }

        /* renamed from: a */
        public final CloudItemDetail[] newArray(int i) {
            return new CloudItemDetail[i];
        }
    };

    public int describeContents() {
        return 0;
    }

    public CloudItemDetail(String str, LatLonPoint latLonPoint, String str2, String str3) {
        super(str, latLonPoint, str2, str3);
    }

    protected CloudItemDetail(Parcel parcel) {
        super(parcel);
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }
}

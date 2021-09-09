package com.miui.tsmclient.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class SptcCardInfo extends FmshCardInfo {
    public static final Parcelable.Creator<SptcCardInfo> CREATOR = new Parcelable.Creator<SptcCardInfo>() {
        /* class com.miui.tsmclient.entity.SptcCardInfo.AnonymousClass1 */

        public final SptcCardInfo createFromParcel(Parcel parcel) {
            SptcCardInfo sptcCardInfo = new SptcCardInfo(null);
            sptcCardInfo.readFromParcel(parcel);
            return sptcCardInfo;
        }

        public final SptcCardInfo[] newArray(int i) {
            return new SptcCardInfo[i];
        }
    };

    public SptcCardInfo(String str) {
        super(str);
    }
}

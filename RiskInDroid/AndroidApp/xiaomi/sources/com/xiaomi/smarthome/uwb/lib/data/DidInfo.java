package com.xiaomi.smarthome.uwb.lib.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

public class DidInfo implements Parcelable {
    public static final Parcelable.Creator<DidInfo> CREATOR = new Parcelable.Creator<DidInfo>() {
        /* class com.xiaomi.smarthome.uwb.lib.data.DidInfo.AnonymousClass1 */

        public final DidInfo createFromParcel(Parcel parcel) {
            return new DidInfo(parcel);
        }

        public final DidInfo[] newArray(int i) {
            return new DidInfo[i];
        }
    };
    private String did;
    private String plainDid;

    public int describeContents() {
        return 0;
    }

    public static DidInfo parse(String str) {
        DidInfo didInfo = new DidInfo();
        didInfo.setDid(str);
        return didInfo;
    }

    public String getDid() {
        if (TextUtils.equals("000000", this.did)) {
            return "";
        }
        return this.did;
    }

    public void setDid(String str) {
        this.did = str;
    }

    public DidInfo() {
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.did);
        parcel.writeString(this.plainDid);
    }

    public void readFromParcel(Parcel parcel) {
        this.did = parcel.readString();
        this.plainDid = parcel.readString();
    }

    protected DidInfo(Parcel parcel) {
        this.did = parcel.readString();
        this.plainDid = parcel.readString();
    }

    public String getPlainDid() {
        return this.plainDid;
    }

    public void setPlainDid(String str) {
        this.plainDid = str;
    }

    public String toString() {
        return "DidInfo{did='" + this.did + '\'' + ", plainDid='" + this.plainDid + '\'' + '}';
    }
}

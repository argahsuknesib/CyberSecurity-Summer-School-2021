package com.ximalaya.ting.android.opensdk.model.statistic;

import android.os.Parcel;
import android.os.Parcelable;

public class RecordModel implements Parcelable {
    public static final Parcelable.Creator<RecordModel> CREATOR = new Parcelable.Creator<RecordModel>() {
        /* class com.ximalaya.ting.android.opensdk.model.statistic.RecordModel.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new RecordModel[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            RecordModel recordModel = new RecordModel();
            recordModel.O000000o(parcel);
            return recordModel;
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public int f12178O000000o;
    public int O00000Oo;
    public String O00000o0;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f12178O000000o);
        parcel.writeInt(this.O00000Oo);
        parcel.writeString(this.O00000o0);
    }

    public final void O000000o(Parcel parcel) {
        this.f12178O000000o = parcel.readInt();
        this.O00000Oo = parcel.readInt();
        this.O00000o0 = parcel.readString();
    }
}

package com.xiaomi.smarthome.core.entity.bluetooth;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.UUID;

public class SearchTask implements Parcelable {
    public static final Parcelable.Creator<SearchTask> CREATOR = new Parcelable.Creator<SearchTask>() {
        /* class com.xiaomi.smarthome.core.entity.bluetooth.SearchTask.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SearchTask[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new SearchTask(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public int f6725O000000o;
    public int O00000Oo;
    public UUID[] O00000o0;

    public int describeContents() {
        return 0;
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [java.util.UUID[], java.io.Serializable] */
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f6725O000000o);
        parcel.writeInt(this.O00000Oo);
        parcel.writeSerializable(this.O00000o0);
    }

    public SearchTask() {
    }

    protected SearchTask(Parcel parcel) {
        this.f6725O000000o = parcel.readInt();
        this.O00000Oo = parcel.readInt();
        this.O00000o0 = (UUID[]) parcel.readSerializable();
    }
}

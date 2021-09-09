package com.inuker.bluetooth.library.search;

import android.os.Parcel;
import android.os.Parcelable;

public class SearchTask implements Parcelable {
    public static final Parcelable.Creator<SearchTask> CREATOR = new Parcelable.Creator<SearchTask>() {
        /* class com.inuker.bluetooth.library.search.SearchTask.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SearchTask[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new SearchTask(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public int f4496O000000o;
    public int O00000Oo;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f4496O000000o);
        parcel.writeInt(this.O00000Oo);
    }

    public SearchTask() {
    }

    protected SearchTask(Parcel parcel) {
        this.f4496O000000o = parcel.readInt();
        this.O00000Oo = parcel.readInt();
    }
}

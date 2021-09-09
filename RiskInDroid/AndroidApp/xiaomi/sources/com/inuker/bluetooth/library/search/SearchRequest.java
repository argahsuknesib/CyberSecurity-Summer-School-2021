package com.inuker.bluetooth.library.search;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

public class SearchRequest implements Parcelable {
    public static final Parcelable.Creator<SearchRequest> CREATOR = new Parcelable.Creator<SearchRequest>() {
        /* class com.inuker.bluetooth.library.search.SearchRequest.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SearchRequest[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new SearchRequest(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public List<SearchTask> f4494O000000o;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.f4494O000000o);
    }

    public SearchRequest() {
    }

    protected SearchRequest(Parcel parcel) {
        this.f4494O000000o = new ArrayList();
        parcel.readTypedList(this.f4494O000000o, SearchTask.CREATOR);
    }
}

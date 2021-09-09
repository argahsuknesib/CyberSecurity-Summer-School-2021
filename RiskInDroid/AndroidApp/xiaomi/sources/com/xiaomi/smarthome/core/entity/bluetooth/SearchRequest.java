package com.xiaomi.smarthome.core.entity.bluetooth;

import _m_j.gmz;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SearchRequest implements Parcelable {
    public static final Parcelable.Creator<SearchRequest> CREATOR = new Parcelable.Creator<SearchRequest>() {
        /* class com.xiaomi.smarthome.core.entity.bluetooth.SearchRequest.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SearchRequest[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new SearchRequest(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    protected List<SearchTask> f6722O000000o;

    public int describeContents() {
        return 0;
    }

    public final gmz O000000o() {
        gmz.O00000Oo o00000Oo = new gmz.O00000Oo();
        List<SearchTask> list = this.f6722O000000o;
        if (list != null) {
            for (SearchTask next : list) {
                if (next.f6725O000000o == 2) {
                    o00000Oo.O000000o(next.O00000Oo, (UUID[]) null);
                } else if (next.f6725O000000o == 1) {
                    o00000Oo.O000000o(next.O00000Oo);
                }
            }
        }
        return o00000Oo.O000000o();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.f6722O000000o);
    }

    public SearchRequest() {
    }

    protected SearchRequest(Parcel parcel) {
        this.f6722O000000o = new ArrayList();
        parcel.readTypedList(this.f6722O000000o, SearchTask.CREATOR);
    }

    public final List<SearchTask> O00000Oo() {
        return this.f6722O000000o;
    }

    public final void O000000o(List<SearchTask> list) {
        this.f6722O000000o = list;
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        private List<SearchTask> f6723O000000o = new ArrayList();

        public final O000000o O000000o(int i, UUID[] uuidArr) {
            SearchTask searchTask = new SearchTask();
            searchTask.f6725O000000o = 2;
            searchTask.O00000Oo = i;
            searchTask.O00000o0 = uuidArr;
            this.f6723O000000o.add(searchTask);
            return this;
        }

        public final O000000o O000000o(int i, int i2) {
            return O00000Oo(i, i2);
        }

        public final O000000o O00000Oo(int i, int i2) {
            for (int i3 = 0; i3 < i2; i3++) {
                O000000o(i, (UUID[]) null);
            }
            return this;
        }

        public final O000000o O000000o(int i) {
            SearchTask searchTask = new SearchTask();
            searchTask.f6725O000000o = 1;
            searchTask.O00000Oo = i;
            this.f6723O000000o.add(searchTask);
            return this;
        }

        public final SearchRequest O000000o() {
            SearchRequest searchRequest = new SearchRequest();
            searchRequest.O000000o(this.f6723O000000o);
            return searchRequest;
        }
    }
}

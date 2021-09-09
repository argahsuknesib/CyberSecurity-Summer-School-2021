package com.xiaomi.smarthome.miio.message.p0.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class P0MessageList implements Parcelable {
    public static final Parcelable.Creator<P0MessageList> CREATOR = new Parcelable.Creator<P0MessageList>() {
        /* class com.xiaomi.smarthome.miio.message.p0.model.P0MessageList.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new P0MessageList[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new P0MessageList(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public List<P0Message> f9729O000000o;
    public int O00000Oo = 0;

    public int describeContents() {
        return 0;
    }

    public static P0MessageList O000000o(JSONObject jSONObject) {
        JSONArray optJSONArray;
        if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray("alertList")) == null) {
            return null;
        }
        P0MessageList p0MessageList = new P0MessageList();
        p0MessageList.O00000Oo = jSONObject.optInt("count");
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < optJSONArray.length(); i++) {
            P0Message O000000o2 = P0Message.O000000o(optJSONArray.optJSONObject(i));
            if (O000000o2 != null) {
                arrayList.add(O000000o2);
            }
        }
        p0MessageList.f9729O000000o = arrayList;
        return p0MessageList;
    }

    public P0MessageList() {
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.f9729O000000o);
        parcel.writeInt(this.O00000Oo);
    }

    protected P0MessageList(Parcel parcel) {
        this.f9729O000000o = parcel.createTypedArrayList(P0Message.CREATOR);
        this.O00000Oo = parcel.readInt();
    }
}

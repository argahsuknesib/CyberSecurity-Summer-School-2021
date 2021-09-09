package com.xiaomi.smarthome.ad.api;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class AdPosition implements Parcelable {
    public static final Parcelable.Creator<AdPosition> CREATOR = new Parcelable.Creator<AdPosition>() {
        /* class com.xiaomi.smarthome.ad.api.AdPosition.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AdPosition[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new AdPosition(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public String f4148O000000o;
    public List<Advertisement> O00000Oo = new ArrayList();

    public int describeContents() {
        return 0;
    }

    public AdPosition() {
    }

    protected AdPosition(Parcel parcel) {
        this.f4148O000000o = parcel.readString();
        parcel.readList(this.O00000Oo, getClass().getClassLoader());
    }

    public static AdPosition O000000o(JSONObject jSONObject) {
        AdPosition adPosition = new AdPosition();
        adPosition.f4148O000000o = jSONObject.optString("oper_key");
        JSONArray optJSONArray = jSONObject.optJSONArray("ads");
        for (int i = 0; i < optJSONArray.length(); i++) {
            adPosition.O00000Oo.add(Advertisement.O000000o(optJSONArray.optJSONObject(i)));
        }
        return adPosition;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4148O000000o);
        parcel.writeList(this.O00000Oo);
    }
}

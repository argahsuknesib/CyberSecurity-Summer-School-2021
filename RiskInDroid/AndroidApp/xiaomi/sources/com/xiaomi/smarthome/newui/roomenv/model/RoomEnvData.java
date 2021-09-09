package com.xiaomi.smarthome.newui.roomenv.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class RoomEnvData implements Parcelable {
    public static final Parcelable.Creator<RoomEnvData> CREATOR = new Parcelable.Creator<RoomEnvData>() {
        /* class com.xiaomi.smarthome.newui.roomenv.model.RoomEnvData.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new RoomEnvData[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new RoomEnvData(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public List<RoomEnvDataItem> f10270O000000o;
    public String O00000Oo;
    public String O00000o0;

    public int describeContents() {
        return 0;
    }

    public static RoomEnvData O000000o(JSONObject jSONObject) {
        RoomEnvDataItem O000000o2;
        if (jSONObject == null) {
            return null;
        }
        RoomEnvData roomEnvData = new RoomEnvData();
        String optString = jSONObject.optString("home_id");
        if (!TextUtils.isEmpty(optString)) {
            roomEnvData.O00000o0 = optString;
        }
        roomEnvData.O00000Oo = jSONObject.optString("room_id");
        JSONArray optJSONArray = jSONObject.optJSONArray("desc_list");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (!(optJSONObject == null || (O000000o2 = RoomEnvDataItem.O000000o(optJSONObject)) == null)) {
                    arrayList.add(O000000o2);
                }
            }
            roomEnvData.f10270O000000o = arrayList;
        }
        return roomEnvData;
    }

    public RoomEnvData() {
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.f10270O000000o);
        parcel.writeString(this.O00000Oo);
        parcel.writeString(this.O00000o0);
    }

    protected RoomEnvData(Parcel parcel) {
        this.f10270O000000o = parcel.createTypedArrayList(RoomEnvDataItem.CREATOR);
        this.O00000Oo = parcel.readString();
        this.O00000o0 = parcel.readString();
    }
}

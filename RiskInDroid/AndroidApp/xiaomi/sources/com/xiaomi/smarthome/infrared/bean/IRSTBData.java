package com.xiaomi.smarthome.infrared.bean;

import _m_j.gjd;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class IRSTBData implements Parcelable {
    public static final Parcelable.Creator<IRSTBData> CREATOR = new Parcelable.Creator<IRSTBData>() {
        /* class com.xiaomi.smarthome.infrared.bean.IRSTBData.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new IRSTBData[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new IRSTBData(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public int f9038O000000o;
    public String O00000Oo;
    public String O00000o;
    public String O00000o0;
    public String O00000oO;
    private String O00000oo;

    public int describeContents() {
        return 0;
    }

    public IRSTBData() {
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f9038O000000o);
        parcel.writeString(this.O00000Oo);
        parcel.writeString(this.O00000o0);
        parcel.writeString(this.O00000oo);
        parcel.writeString(this.O00000o);
        parcel.writeString(this.O00000oO);
    }

    protected IRSTBData(Parcel parcel) {
        this.f9038O000000o = parcel.readInt();
        this.O00000Oo = parcel.readString();
        this.O00000o0 = parcel.readString();
        this.O00000oo = parcel.readString();
        this.O00000o = parcel.readString();
        this.O00000oO = parcel.readString();
    }

    public static ArrayList<IRSTBData> O000000o(JSONArray jSONArray) {
        ArrayList<IRSTBData> arrayList = new ArrayList<>();
        int i = 0;
        while (i < jSONArray.length()) {
            try {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                IRSTBData iRSTBData = new IRSTBData();
                arrayList.add(iRSTBData);
                iRSTBData.f9038O000000o = optJSONObject.optInt("SpType");
                iRSTBData.O00000Oo = gjd.O000000o(optJSONObject, "Id");
                iRSTBData.O00000o0 = gjd.O000000o(optJSONObject, "SpId");
                iRSTBData.O00000oo = gjd.O000000o(optJSONObject, "AreaId");
                iRSTBData.O00000o = gjd.O000000o(optJSONObject, "CityId");
                iRSTBData.O00000oO = gjd.O000000o(optJSONObject, "Name");
                i++;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return arrayList;
    }
}

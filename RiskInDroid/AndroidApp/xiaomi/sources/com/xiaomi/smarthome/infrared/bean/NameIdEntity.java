package com.xiaomi.smarthome.infrared.bean;

import _m_j.gjd;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class NameIdEntity implements Parcelable {
    public static final Parcelable.Creator<NameIdEntity> CREATOR = new Parcelable.Creator<NameIdEntity>() {
        /* class com.xiaomi.smarthome.infrared.bean.NameIdEntity.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new NameIdEntity[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new NameIdEntity(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public String f9041O000000o;
    public String O00000Oo;

    public int describeContents() {
        return 0;
    }

    public NameIdEntity() {
    }

    protected NameIdEntity(Parcel parcel) {
        this.f9041O000000o = parcel.readString();
        this.O00000Oo = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f9041O000000o);
        parcel.writeString(this.O00000Oo);
    }

    public static ArrayList<NameIdEntity> O000000o(JSONArray jSONArray) {
        ArrayList<NameIdEntity> arrayList = new ArrayList<>();
        int i = 0;
        while (i < jSONArray.length()) {
            try {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                NameIdEntity nameIdEntity = new NameIdEntity();
                arrayList.add(nameIdEntity);
                nameIdEntity.f9041O000000o = gjd.O000000o(optJSONObject, "id");
                nameIdEntity.O00000Oo = gjd.O000000o(optJSONObject, "name");
                i++;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return arrayList;
    }
}

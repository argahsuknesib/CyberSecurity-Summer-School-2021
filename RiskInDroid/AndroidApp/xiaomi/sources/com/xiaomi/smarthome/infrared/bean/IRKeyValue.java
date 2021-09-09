package com.xiaomi.smarthome.infrared.bean;

import _m_j.gjd;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class IRKeyValue implements Parcelable {
    public static final Parcelable.Creator<IRKeyValue> CREATOR = new Parcelable.Creator<IRKeyValue>() {
        /* class com.xiaomi.smarthome.infrared.bean.IRKeyValue.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new IRKeyValue[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new IRKeyValue(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public String f9037O000000o;
    public String O00000Oo;
    public String O00000o;
    public IRType O00000o0;
    public String O00000oO;
    public String O00000oo;
    public int O0000O0o;
    public String O0000OOo;

    public int describeContents() {
        return 0;
    }

    public IRKeyValue() {
    }

    public String toString() {
        return "IRKeyValue{mKey='" + this.O00000o + '\'' + ", mHead='" + this.O00000oO + '\'' + ", mValue='" + this.O00000oo + '\'' + ", mFreq=" + this.O0000O0o + ", displayName='" + this.O0000OOo + '\'' + '}';
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f9037O000000o);
        parcel.writeString(this.O00000Oo);
        IRType iRType = this.O00000o0;
        parcel.writeInt(iRType == null ? -1 : iRType.ordinal());
        parcel.writeString(this.O00000o);
        parcel.writeString(this.O00000oO);
        parcel.writeString(this.O00000oo);
        parcel.writeInt(this.O0000O0o);
        parcel.writeString(this.O0000OOo);
    }

    protected IRKeyValue(Parcel parcel) {
        IRType iRType;
        this.f9037O000000o = parcel.readString();
        this.O00000Oo = parcel.readString();
        int readInt = parcel.readInt();
        if (readInt == -1) {
            iRType = null;
        } else {
            iRType = IRType.values()[readInt];
        }
        this.O00000o0 = iRType;
        this.O00000o = parcel.readString();
        this.O00000oO = parcel.readString();
        this.O00000oo = parcel.readString();
        this.O0000O0o = parcel.readInt();
        this.O0000OOo = parcel.readString();
    }

    public static ArrayList<IRKeyValue> O000000o(JSONArray jSONArray) {
        ArrayList<IRKeyValue> arrayList = new ArrayList<>();
        int i = 0;
        while (i < jSONArray.length()) {
            try {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                IRKeyValue iRKeyValue = new IRKeyValue();
                iRKeyValue.O0000OOo = gjd.O000000o(optJSONObject, "display_name");
                iRKeyValue.O00000o = gjd.O000000o(optJSONObject, "name");
                iRKeyValue.O00000Oo = gjd.O000000o(optJSONObject, "id");
                arrayList.add(iRKeyValue);
                i++;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }
}

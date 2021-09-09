package com.xiaomi.smarthome.infrared.bean;

import _m_j.ftl;
import _m_j.gjd;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class IRBrandType implements Parcelable, Comparable<IRBrandType> {
    public static final Parcelable.Creator<IRBrandType> CREATOR = new Parcelable.Creator<IRBrandType>() {
        /* class com.xiaomi.smarthome.infrared.bean.IRBrandType.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new IRBrandType[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new IRBrandType(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public String f9036O000000o;
    public String O00000Oo;
    public String O00000o;
    public String O00000o0;
    public String O00000oO;
    public boolean O00000oo;

    public int describeContents() {
        return 0;
    }

    public /* synthetic */ int compareTo(Object obj) {
        IRBrandType iRBrandType = (IRBrandType) obj;
        char charAt = this.O00000oO.toUpperCase().charAt(0);
        char charAt2 = iRBrandType.O00000oO.toUpperCase().charAt(0);
        if (charAt < 'A' || charAt > 'Z') {
            return 1;
        }
        if (charAt2 < 'A' || charAt2 > 'Z') {
            return -1;
        }
        return this.O00000oO.compareTo(iRBrandType.O00000oO);
    }

    public IRBrandType() {
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f9036O000000o);
        parcel.writeString(this.O00000Oo);
        parcel.writeString(this.O00000o0);
        parcel.writeString(this.O00000o);
        parcel.writeString(this.O00000oO);
        parcel.writeByte(this.O00000oo ? (byte) 1 : 0);
    }

    protected IRBrandType(Parcel parcel) {
        this.f9036O000000o = parcel.readString();
        this.O00000Oo = parcel.readString();
        this.O00000o0 = parcel.readString();
        this.O00000o = parcel.readString();
        this.O00000oO = parcel.readString();
        this.O00000oo = parcel.readByte() != 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x005e A[Catch:{ Throwable -> 0x0069 }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0061 A[Catch:{ Throwable -> 0x0069 }] */
    public static ArrayList<IRBrandType> O000000o(JSONArray jSONArray) {
        String str;
        ArrayList<IRBrandType> arrayList = new ArrayList<>();
        try {
            boolean O00000Oo2 = ftl.O00000Oo();
            for (int i = 0; i < jSONArray.length(); i++) {
                IRBrandType iRBrandType = new IRBrandType();
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                iRBrandType.O00000Oo = gjd.O000000o(optJSONObject, "id");
                iRBrandType.f9036O000000o = gjd.O000000o(optJSONObject, "name");
                iRBrandType.O00000o = gjd.O000000o(optJSONObject, "en_name");
                iRBrandType.O00000o0 = gjd.O000000o(optJSONObject, "pinyin");
                String str2 = O00000Oo2 ? iRBrandType.O00000o0 : iRBrandType.O00000o;
                if (str2 != null) {
                    if (str2.length() > 0) {
                        str = str2.substring(0, 1).toUpperCase();
                        if (!str.matches("[A-Z]")) {
                            iRBrandType.O00000oO = str;
                        } else {
                            iRBrandType.O00000oO = "#";
                        }
                        arrayList.add(iRBrandType);
                    }
                }
                str = "#";
                if (!str.matches("[A-Z]")) {
                }
                arrayList.add(iRBrandType);
            }
        } catch (Throwable unused) {
        }
        return arrayList;
    }
}

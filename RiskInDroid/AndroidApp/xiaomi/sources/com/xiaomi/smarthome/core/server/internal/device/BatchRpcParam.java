package com.xiaomi.smarthome.core.server.internal.device;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONArray;
import org.json.JSONException;

public class BatchRpcParam implements Parcelable {
    public static final Parcelable.Creator<BatchRpcParam> CREATOR = new Parcelable.Creator<BatchRpcParam>() {
        /* class com.xiaomi.smarthome.core.server.internal.device.BatchRpcParam.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new BatchRpcParam[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new BatchRpcParam(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public String f6888O000000o;
    public String O00000Oo;
    public String O00000o;
    public JSONArray O00000o0;

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "BatchRpcParam{did='" + this.f6888O000000o + '\'' + ", method='" + this.O00000Oo + '\'' + ", params=" + this.O00000o0 + ", sid='" + this.O00000o + '\'' + '}';
    }

    public BatchRpcParam() {
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f6888O000000o);
        parcel.writeString(this.O00000Oo);
        JSONArray jSONArray = this.O00000o0;
        parcel.writeString(jSONArray == null ? "[]" : jSONArray.toString());
        parcel.writeString(this.O00000o);
    }

    protected BatchRpcParam(Parcel parcel) {
        this.f6888O000000o = parcel.readString();
        this.O00000Oo = parcel.readString();
        try {
            this.O00000o0 = new JSONArray(parcel.readString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        this.O00000o = parcel.readString();
    }
}

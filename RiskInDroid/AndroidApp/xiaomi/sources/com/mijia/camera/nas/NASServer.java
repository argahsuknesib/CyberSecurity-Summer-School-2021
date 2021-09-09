package com.mijia.camera.nas;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class NASServer implements Parcelable {
    public static final Parcelable.Creator<NASServer> CREATOR = new Parcelable.Creator<NASServer>() {
        /* class com.mijia.camera.nas.NASServer.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new NASServer[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new NASServer(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public String f5188O000000o;
    int O00000Oo;
    public String O00000o;
    long O00000o0;
    public String O00000oO;
    public String O00000oo;
    public String O0000O0o = "";
    private String O0000OOo;
    private String O0000Oo0;

    public int describeContents() {
        return 0;
    }

    protected NASServer(Parcel parcel) {
        this.f5188O000000o = parcel.readString();
        this.O0000OOo = parcel.readString();
        this.O0000Oo0 = parcel.readString();
        this.O00000Oo = parcel.readInt();
        this.O00000o0 = parcel.readLong();
        this.O00000o = parcel.readString();
        this.O00000oO = parcel.readString();
        this.O00000oo = parcel.readString();
        this.O0000O0o = parcel.readString();
    }

    public NASServer() {
    }

    public final String O000000o() {
        if (TextUtils.isEmpty(this.O0000O0o)) {
            return "";
        }
        if (this.O0000O0o.lastIndexOf("/") <= 0) {
            return this.O0000O0o;
        }
        String str = this.O0000O0o;
        return str.substring(str.lastIndexOf("/") + 1, this.O0000O0o.length());
    }

    public static NASServer O000000o(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        NASServer nASServer = new NASServer();
        nASServer.O00000Oo = jSONObject.optInt("type");
        nASServer.O00000o = jSONObject.optString("group");
        nASServer.O00000o0 = jSONObject.optLong("addr");
        nASServer.f5188O000000o = jSONObject.optString("name");
        nASServer.O0000O0o = jSONObject.optString("dir");
        nASServer.O00000oo = jSONObject.optString("pass");
        nASServer.O00000oO = jSONObject.optString("user");
        return nASServer;
    }

    public final JSONObject O00000Oo() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", this.O00000Oo);
            jSONObject.put("group", this.O00000o);
            jSONObject.put("addr", this.O00000o0);
            jSONObject.put("name", this.f5188O000000o);
            jSONObject.put("dir", this.O0000O0o);
            jSONObject.put("user", this.O00000oO);
            jSONObject.put("pass", this.O00000oo);
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f5188O000000o);
        parcel.writeString(this.O0000OOo);
        parcel.writeString(this.O0000Oo0);
        parcel.writeInt(this.O00000Oo);
        parcel.writeLong(this.O00000o0);
        parcel.writeString(this.O00000o);
        parcel.writeString(this.O00000oO);
        parcel.writeString(this.O00000oo);
        parcel.writeString(this.O0000O0o);
    }
}

package com.mijia.camera.nas;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONException;
import org.json.JSONObject;

public class NASInfo implements Parcelable {
    public static final Parcelable.Creator<NASInfo> CREATOR = new Parcelable.Creator<NASInfo>() {
        /* class com.mijia.camera.nas.NASInfo.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new NASInfo[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new NASInfo(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public int f5186O000000o = 300;
    public int O00000Oo = 7776000;
    public int O00000o = 1;
    public long O00000o0 = 0;
    public int O00000oO;
    public NASServer O00000oo;

    public int describeContents() {
        return 0;
    }

    protected NASInfo(Parcel parcel) {
        this.f5186O000000o = parcel.readInt();
        this.O00000Oo = parcel.readInt();
        this.O00000o0 = parcel.readLong();
        this.O00000o = parcel.readInt();
        this.O00000oO = parcel.readInt();
        this.O00000oo = (NASServer) parcel.readParcelable(NASServer.class.getClassLoader());
    }

    public NASInfo() {
    }

    public NASInfo(NASServer nASServer) {
        this.O00000oo = nASServer;
    }

    public final String O000000o() {
        NASServer nASServer = this.O00000oo;
        return nASServer == null ? "" : nASServer.O0000O0o;
    }

    public static NASInfo O000000o(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        NASInfo nASInfo = new NASInfo();
        nASInfo.O00000Oo = jSONObject.optInt("video_retention_time");
        nASInfo.f5186O000000o = jSONObject.optInt("sync_interval");
        nASInfo.O00000o = jSONObject.optInt("state");
        nASInfo.O00000o0 = (long) jSONObject.optInt("last_sync_time");
        nASInfo.O00000oO = jSONObject.optInt("error_code");
        nASInfo.O00000oo = NASServer.O000000o(jSONObject.optJSONObject("share"));
        return nASInfo;
    }

    public final JSONObject O00000Oo() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("state", this.O00000o);
            jSONObject.put("sync_interval", this.f5186O000000o);
            jSONObject.put("video_retention_time", this.O00000Oo);
            jSONObject.put("share", this.O00000oo.O00000Oo());
            return jSONObject;
        } catch (NullPointerException | JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f5186O000000o);
        parcel.writeInt(this.O00000Oo);
        parcel.writeLong(this.O00000o0);
        parcel.writeInt(this.O00000o);
        parcel.writeInt(this.O00000oO);
        parcel.writeParcelable(this.O00000oo, i);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("mSycTime:");
        sb.append(this.f5186O000000o);
        sb.append(" mCycleTime:");
        sb.append(this.O00000Oo);
        sb.append(" mState:");
        sb.append(this.O00000o);
        sb.append(" mError:");
        sb.append(this.O00000oO);
        if (this.O00000oo != null) {
            sb.append(" mServer getName");
            sb.append(this.O00000oo.f5188O000000o);
            sb.append(" mServer getPwd:");
            sb.append(this.O00000oo.O00000oo);
            sb.append(" mServer getAddr:");
            sb.append(this.O00000oo.O00000o0);
            sb.append(" mServer getDir:");
            sb.append(this.O00000oo.O0000O0o);
            sb.append(" mServer getDirName:");
            sb.append(this.O00000oo.O000000o());
            sb.append(" mServer getUserName:");
            sb.append(this.O00000oo.O00000oO);
            sb.append(" mServer getType:");
            sb.append(this.O00000oo.O00000Oo);
        }
        return sb.toString();
    }
}

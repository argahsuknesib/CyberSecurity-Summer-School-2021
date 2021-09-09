package com.xiaomi.smarthome.ad.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Advertisement implements Parcelable {
    public static final Parcelable.Creator<Advertisement> CREATOR = new Parcelable.Creator<Advertisement>() {
        /* class com.xiaomi.smarthome.ad.api.Advertisement.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new Advertisement[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new Advertisement(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public long f4149O000000o;
    public String O00000Oo;
    public String O00000o;
    public String O00000o0;
    public String O00000oO;
    public String O00000oo;
    public String O0000O0o;
    public String O0000OOo;
    private String O0000Oo;
    public long O0000Oo0;
    private long O0000OoO;
    private boolean O0000Ooo;
    private int O0000o00;

    public int describeContents() {
        return 0;
    }

    public Advertisement() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00a9  */
    public static Advertisement O000000o(JSONObject jSONObject) {
        JSONArray jSONArray;
        int optInt;
        Advertisement advertisement = new Advertisement();
        advertisement.f4149O000000o = jSONObject.optLong("ad_id");
        advertisement.O00000Oo = jSONObject.optString("name");
        advertisement.O0000Oo = jSONObject.optString("intro");
        advertisement.O00000oo = jSONObject.optString("ad_copy");
        String optString = jSONObject.optString("pics", "");
        if (!TextUtils.isEmpty(optString)) {
            try {
                jSONArray = new JSONArray(optString);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            boolean z = false;
            if (jSONArray != null && jSONArray.length() > 0) {
                advertisement.O00000o = jSONArray.optString(0);
            }
            advertisement.O00000oO = jSONObject.optString("redirect");
            advertisement.O0000Oo0 = jSONObject.optLong("start_time");
            advertisement.O0000OoO = jSONObject.optLong("end_time");
            if (jSONObject.optInt("is_permanent") == 1) {
                z = true;
            }
            advertisement.O0000Ooo = z;
            advertisement.O0000o00 = jSONObject.optInt("show_rules");
            advertisement.O0000O0o = jSONObject.optString("ad_title");
            advertisement.O0000OOo = jSONObject.optString("ad_subtitle");
            optInt = jSONObject.optInt("type");
            if (optInt != 0) {
                advertisement.O00000o0 = "banner";
            } else if (optInt == 1) {
                advertisement.O00000o0 = "notice";
            } else if (optInt == 2) {
                advertisement.O00000o0 = "pop";
            } else if (optInt == 3) {
                advertisement.O00000o0 = "bottomPop";
            }
            return advertisement;
        }
        jSONArray = null;
        boolean z2 = false;
        advertisement.O00000o = jSONArray.optString(0);
        advertisement.O00000oO = jSONObject.optString("redirect");
        advertisement.O0000Oo0 = jSONObject.optLong("start_time");
        advertisement.O0000OoO = jSONObject.optLong("end_time");
        if (jSONObject.optInt("is_permanent") == 1) {
        }
        advertisement.O0000Ooo = z2;
        advertisement.O0000o00 = jSONObject.optInt("show_rules");
        advertisement.O0000O0o = jSONObject.optString("ad_title");
        advertisement.O0000OOo = jSONObject.optString("ad_subtitle");
        optInt = jSONObject.optInt("type");
        if (optInt != 0) {
        }
        return advertisement;
    }

    protected Advertisement(Parcel parcel) {
        this.f4149O000000o = parcel.readLong();
        this.O00000Oo = parcel.readString();
        this.O0000Oo = parcel.readString();
        this.O00000o0 = parcel.readString();
        this.O00000o = parcel.readString();
        this.O00000oO = parcel.readString();
        this.O00000oo = parcel.readString();
        this.O0000Oo0 = parcel.readLong();
        this.O0000OoO = parcel.readLong();
        this.O0000Ooo = parcel.readByte() != 0;
        this.O0000o00 = parcel.readInt();
        this.O0000O0o = parcel.readString();
        this.O0000OOo = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f4149O000000o);
        parcel.writeString(this.O00000Oo);
        parcel.writeString(this.O0000Oo);
        parcel.writeString(this.O00000o0);
        parcel.writeString(this.O00000o);
        parcel.writeString(this.O00000oO);
        parcel.writeString(this.O00000oo);
        parcel.writeLong(this.O0000Oo0);
        parcel.writeLong(this.O0000OoO);
        parcel.writeByte(this.O0000Ooo ^ true ? (byte) 1 : 0);
        parcel.writeInt(this.O0000o00);
        parcel.writeString(this.O0000O0o);
        parcel.writeString(this.O0000OOo);
    }
}

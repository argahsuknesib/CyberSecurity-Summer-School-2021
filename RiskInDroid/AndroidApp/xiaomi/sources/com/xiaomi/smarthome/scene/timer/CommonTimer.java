package com.xiaomi.smarthome.scene.timer;

import _m_j.ftn;
import _m_j.goz;
import _m_j.gwc;
import android.app.Activity;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.scene.model.CorntabUtils;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONObject;

public final class CommonTimer implements Parcelable, Cloneable {
    public static final Parcelable.Creator<CommonTimer> CREATOR = new Parcelable.Creator<CommonTimer>() {
        /* class com.xiaomi.smarthome.scene.timer.CommonTimer.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new CommonTimer[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new CommonTimer(parcel, (byte) 0);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public String f11210O000000o;
    public String O00000Oo;
    public String O00000o;
    public String O00000o0;
    public boolean O00000oO;
    public boolean O00000oo;
    public boolean O0000O0o;
    public String O0000OOo;
    public CorntabUtils.CorntabParam O0000Oo;
    public String O0000Oo0;
    public boolean O0000OoO;
    public String O0000Ooo;
    public CorntabUtils.CorntabParam O0000o0;
    public String O0000o00;
    public String O0000o0O;
    public int O0000o0o;

    public final int describeContents() {
        return 0;
    }

    /* synthetic */ CommonTimer(Parcel parcel, byte b) {
        this(parcel);
    }

    public CommonTimer() {
        this.f11210O000000o = null;
        this.O00000oO = true;
        this.O00000oo = true;
        this.O0000O0o = false;
        this.O0000OOo = null;
        this.O0000Oo0 = null;
        this.O0000Oo = new CorntabUtils.CorntabParam();
        this.O0000OoO = false;
        this.O0000Ooo = null;
        this.O0000o00 = null;
        this.O0000o0 = new CorntabUtils.CorntabParam();
        this.O00000o0 = null;
        this.O00000o = null;
        this.O0000o0o = 0;
        this.O0000o0O = "0";
        this.O00000Oo = null;
    }

    public static CommonTimer O000000o(PlugTimer plugTimer, String str, String str2, String str3, String str4) {
        CommonTimer commonTimer = new CommonTimer();
        commonTimer.f11210O000000o = plugTimer.O0000Oo;
        commonTimer.O00000oo = plugTimer.O00000Oo;
        commonTimer.O0000OoO = plugTimer.O00000oo;
        commonTimer.O0000o0 = plugTimer.O0000OOo;
        commonTimer.O0000O0o = plugTimer.O00000o0;
        commonTimer.O0000Oo = plugTimer.O00000oO;
        commonTimer.O00000o0 = "";
        commonTimer.O0000Ooo = str3;
        commonTimer.O0000o00 = str4;
        commonTimer.O0000OOo = str;
        commonTimer.O0000Oo0 = str2;
        commonTimer.O0000o0o = plugTimer.O0000Oo0;
        commonTimer.O0000o0O = plugTimer.O0000OoO;
        return commonTimer;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f11210O000000o);
        parcel.writeByte(this.O00000oO ? (byte) 1 : 0);
        parcel.writeByte(this.O00000oo ? (byte) 1 : 0);
        parcel.writeByte(this.O0000O0o ? (byte) 1 : 0);
        parcel.writeString(this.O0000OOo);
        parcel.writeString(this.O0000Oo0);
        parcel.writeInt(this.O0000Oo.f11160O000000o);
        parcel.writeInt(this.O0000Oo.O00000Oo);
        parcel.writeInt(this.O0000Oo.O00000o0);
        parcel.writeInt(this.O0000Oo.O00000o);
        parcel.writeInt(this.O0000Oo.O00000oO);
        parcel.writeInt(this.O0000Oo.O00000oo);
        parcel.writeString(this.O0000Oo.O0000OOo);
        parcel.writeBooleanArray(this.O0000Oo.O0000O0o);
        parcel.writeByte(this.O0000OoO ? (byte) 1 : 0);
        parcel.writeString(this.O0000Ooo);
        parcel.writeString(this.O0000o00);
        parcel.writeInt(this.O0000o0.f11160O000000o);
        parcel.writeInt(this.O0000o0.O00000Oo);
        parcel.writeInt(this.O0000o0.O00000o0);
        parcel.writeInt(this.O0000o0.O00000o);
        parcel.writeInt(this.O0000o0.O00000oO);
        parcel.writeInt(this.O0000o0.O00000oo);
        parcel.writeString(this.O0000o0.O0000OOo);
        parcel.writeBooleanArray(this.O0000o0.O0000O0o);
        parcel.writeString(this.O00000o0);
        parcel.writeString(this.O00000o);
        parcel.writeInt(this.O0000o0o);
        parcel.writeString(this.O0000o0O);
        parcel.writeString(this.O00000Oo);
    }

    public final Object clone() {
        try {
            CommonTimer commonTimer = (CommonTimer) super.clone();
            try {
                commonTimer.f11210O000000o = this.f11210O000000o;
                commonTimer.O00000oo = this.O00000oo;
                commonTimer.O0000O0o = this.O0000O0o;
                commonTimer.O0000OOo = this.O0000OOo;
                commonTimer.O0000Oo0 = this.O0000Oo0;
                commonTimer.O0000Oo = (CorntabUtils.CorntabParam) this.O0000Oo.clone();
                commonTimer.O0000OoO = this.O0000OoO;
                commonTimer.O0000Ooo = this.O0000Ooo;
                commonTimer.O0000o00 = this.O0000o00;
                commonTimer.O0000o0 = (CorntabUtils.CorntabParam) this.O0000o0.clone();
                commonTimer.O00000o0 = this.O00000o0;
                commonTimer.O00000o = this.O00000o;
                commonTimer.O0000o0o = this.O0000o0o;
                commonTimer.O0000o0O = this.O0000o0O;
                commonTimer.O00000Oo = this.O00000Oo;
                return commonTimer;
            } catch (CloneNotSupportedException unused) {
                return commonTimer;
            }
        } catch (CloneNotSupportedException unused2) {
            return null;
        }
    }

    private CommonTimer(Parcel parcel) {
        this.f11210O000000o = parcel.readString();
        boolean z = true;
        this.O00000oO = parcel.readByte() != 0;
        this.O00000oo = parcel.readByte() != 0;
        this.O0000O0o = parcel.readByte() != 0;
        this.O0000OOo = parcel.readString();
        this.O0000Oo0 = parcel.readString();
        this.O0000Oo = new CorntabUtils.CorntabParam();
        this.O0000Oo.f11160O000000o = parcel.readInt();
        this.O0000Oo.O00000Oo = parcel.readInt();
        this.O0000Oo.O00000o0 = parcel.readInt();
        this.O0000Oo.O00000o = parcel.readInt();
        this.O0000Oo.O00000oO = parcel.readInt();
        this.O0000Oo.O00000oo = parcel.readInt();
        this.O0000Oo.O0000OOo = parcel.readString();
        parcel.readBooleanArray(this.O0000Oo.O0000O0o);
        this.O0000OoO = parcel.readByte() == 0 ? false : z;
        this.O0000Ooo = parcel.readString();
        this.O0000o00 = parcel.readString();
        this.O0000o0 = new CorntabUtils.CorntabParam();
        this.O0000o0.f11160O000000o = parcel.readInt();
        this.O0000o0.O00000Oo = parcel.readInt();
        this.O0000o0.O00000o0 = parcel.readInt();
        this.O0000o0.O00000o = parcel.readInt();
        this.O0000o0.O00000oO = parcel.readInt();
        this.O0000o0.O00000oo = parcel.readInt();
        this.O0000o0.O0000OOo = parcel.readString();
        parcel.readBooleanArray(this.O0000o0.O0000O0o);
        this.O00000o0 = parcel.readString();
        this.O00000o = parcel.readString();
        this.O0000o0o = parcel.readInt();
        this.O0000o0O = parcel.readString();
        this.O00000Oo = parcel.readString();
    }

    public static String O000000o(Context context, CorntabUtils.CorntabParam corntabParam) {
        StringBuilder sb = new StringBuilder();
        Calendar instance = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance();
        instance2.set(instance.get(1), corntabParam.O00000oO - 1, corntabParam.O00000o);
        if (!goz.O000000o(instance, instance2)) {
            if (goz.O000000o(instance2, 1)) {
                sb.append(context.getString(R.string.plug_timer_tomorrow));
                sb.append(" ");
            } else if (goz.O000000o(instance2, 2)) {
                sb.append(context.getString(R.string.plug_timer_set_nextday));
                sb.append(" ");
            } else if (goz.O000000o(instance2)) {
                sb.append(context.getString(R.string.plug_timer_yesterday));
                sb.append(" ");
            }
        }
        int i = corntabParam.O00000o0;
        int i2 = corntabParam.O00000Oo;
        sb.append(O000000o(i) + ":" + O000000o(i2));
        return sb.toString();
    }

    private static String O000000o(int i) {
        return i < 10 ? "0".concat(String.valueOf(i)) : Integer.toString(i);
    }

    public static PlugTimer O000000o(CommonTimer commonTimer) {
        PlugTimer plugTimer = new PlugTimer();
        plugTimer.O0000Oo = commonTimer.f11210O000000o;
        plugTimer.O00000Oo = commonTimer.O00000oo;
        plugTimer.f11250O000000o = true;
        plugTimer.O00000oo = commonTimer.O0000OoO;
        plugTimer.O0000OOo = commonTimer.O0000o0;
        plugTimer.O00000o0 = commonTimer.O0000O0o;
        plugTimer.O00000oO = commonTimer.O0000Oo;
        plugTimer.O0000O0o = false;
        plugTimer.O00000o = false;
        plugTimer.O0000Oo0 = commonTimer.O0000o0o;
        plugTimer.O0000OoO = commonTimer.O0000o0O;
        return plugTimer;
    }

    public final String O000000o(Activity activity, String str, String str2) {
        if (!this.O00000oo || this.O0000Oo.O00000Oo() != 0) {
            return "";
        }
        if (this.O0000O0o && !this.O0000OoO) {
            return O000000o(activity, this.O0000Oo.O00000oo, this.O0000Oo.O00000oO, this.O0000Oo.O00000o) + " " + str;
        } else if (!this.O0000O0o && this.O0000OoO) {
            return O000000o(activity, this.O0000o0.O00000oo, this.O0000o0.O00000oO, this.O0000o0.O00000o) + " " + str2;
        } else if (this.O0000Oo.O000000o()) {
            return O000000o(activity, this.O0000o0.O00000oo, this.O0000o0.O00000oO, this.O0000o0.O00000o) + " " + str2;
        } else if (this.O0000o0.O000000o()) {
            return O000000o(activity, this.O0000Oo.O00000oo, this.O0000Oo.O00000oO, this.O0000Oo.O00000o) + " " + str;
        } else {
            return O000000o(activity, this.O0000Oo.O00000oo, this.O0000Oo.O00000oO, this.O0000Oo.O00000o) + " " + str;
        }
    }

    private static String O000000o(Activity activity, int i, int i2, int i3) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(gwc.O000000o(ftn.O00000o0(activity.getApplicationContext()), "-"));
        Calendar instance = Calendar.getInstance();
        instance.set(i, i2 - 1, i3);
        return simpleDateFormat.format(instance.getTime());
    }

    public static CommonTimer O000000o(JSONObject jSONObject) {
        CommonTimer commonTimer = new CommonTimer();
        commonTimer.f11210O000000o = jSONObject.optString("us_id");
        commonTimer.O00000o0 = jSONObject.optString("name");
        commonTimer.O00000o = jSONObject.optString("identify");
        JSONObject optJSONObject = jSONObject.optJSONObject("setting");
        JSONArray optJSONArray = jSONObject.optJSONArray("authed");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            commonTimer.O00000Oo = optJSONArray.optString(0);
        }
        commonTimer.O00000oO = optJSONObject.optString("enable_push").equals("1");
        commonTimer.O00000oo = optJSONObject.optString("enable_timer").equals("1");
        commonTimer.O0000O0o = optJSONObject.optString("enable_timer_on").equals("1");
        commonTimer.O0000OOo = optJSONObject.optString("on_method");
        commonTimer.O0000Oo0 = O000000o(optJSONObject, "on_param");
        commonTimer.O0000Oo = CorntabUtils.O000000o(optJSONObject.optString("on_time"));
        if (commonTimer.O0000Oo == null) {
            commonTimer.O0000Oo = new CorntabUtils.CorntabParam();
        } else {
            commonTimer.O0000Oo = CorntabUtils.O00000Oo(TimeZone.getDefault(), TimeZone.getTimeZone("Asia/Shanghai"), commonTimer.O0000Oo);
        }
        commonTimer.O0000OoO = optJSONObject.optString("enable_timer_off").equals("1");
        commonTimer.O0000Ooo = optJSONObject.optString("off_method");
        commonTimer.O0000o00 = O000000o(optJSONObject, "off_param");
        commonTimer.O0000o0 = CorntabUtils.O000000o(optJSONObject.optString("off_time"));
        if (commonTimer.O0000o0 == null) {
            commonTimer.O0000o0 = new CorntabUtils.CorntabParam();
        } else {
            commonTimer.O0000o0 = CorntabUtils.O00000Oo(TimeZone.getDefault(), TimeZone.getTimeZone("Asia/Shanghai"), commonTimer.O0000o0);
        }
        String optString = optJSONObject.optString("on_filter");
        if (!TextUtils.isEmpty(optString)) {
            commonTimer.O0000Oo.O0000OOo = optString;
        }
        String optString2 = optJSONObject.optString("off_filter");
        if (!TextUtils.isEmpty(optString2)) {
            commonTimer.O0000o0.O0000OOo = optString2;
        }
        commonTimer.O0000o0o = jSONObject.optInt("status", 0);
        String optString3 = optJSONObject.optString("timer_type");
        if (!TextUtils.isEmpty(optString3)) {
            commonTimer.O0000o0O = optString3;
        }
        return commonTimer;
    }

    private static String O000000o(JSONObject jSONObject, String str) {
        JSONArray optJSONArray;
        JSONObject optJSONObject;
        String optString = jSONObject.optString(str);
        if (optString == null && (optJSONObject = jSONObject.optJSONObject(str)) != null) {
            optString = optJSONObject.toString();
        }
        if (optString == null && (optJSONArray = jSONObject.optJSONArray(str)) != null && optJSONArray.length() > 0) {
            optString = optJSONArray.toString();
        }
        return optString == null ? "" : optString;
    }
}

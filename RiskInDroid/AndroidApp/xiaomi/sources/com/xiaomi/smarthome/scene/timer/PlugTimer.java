package com.xiaomi.smarthome.scene.timer;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.scene.model.CorntabUtils;
import java.util.Calendar;

public final class PlugTimer implements Parcelable, Cloneable {
    public static final Parcelable.Creator<PlugTimer> CREATOR = new Parcelable.Creator<PlugTimer>() {
        /* class com.xiaomi.smarthome.scene.timer.PlugTimer.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new PlugTimer[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new PlugTimer(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public boolean f11250O000000o;
    public boolean O00000Oo;
    public boolean O00000o;
    public boolean O00000o0;
    public CorntabUtils.CorntabParam O00000oO;
    public boolean O00000oo;
    public boolean O0000O0o;
    public CorntabUtils.CorntabParam O0000OOo;
    public String O0000Oo;
    public int O0000Oo0;
    public String O0000OoO;

    private static boolean O000000o(int i, int i2, int i3, int i4) {
        return (i3 * 60) + i4 >= (i * 60) + i2;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f11250O000000o ? 1 : 0);
        parcel.writeInt(this.O00000Oo ? 1 : 0);
        parcel.writeInt(this.O00000o0 ? 1 : 0);
        parcel.writeInt(this.O00000o ? 1 : 0);
        parcel.writeInt(this.O00000oO.f11160O000000o);
        parcel.writeInt(this.O00000oO.O00000Oo);
        parcel.writeInt(this.O00000oO.O00000o0);
        parcel.writeInt(this.O00000oO.O00000o);
        parcel.writeInt(this.O00000oO.O00000oO);
        parcel.writeInt(this.O00000oO.O00000oo);
        parcel.writeString(this.O00000oO.O0000OOo);
        parcel.writeBooleanArray(this.O00000oO.O0000O0o);
        parcel.writeInt(this.O00000oo ? 1 : 0);
        parcel.writeInt(this.O0000O0o ? 1 : 0);
        parcel.writeInt(this.O0000OOo.f11160O000000o);
        parcel.writeInt(this.O0000OOo.O00000Oo);
        parcel.writeInt(this.O0000OOo.O00000o0);
        parcel.writeInt(this.O0000OOo.O00000o);
        parcel.writeInt(this.O0000OOo.O00000oO);
        parcel.writeInt(this.O0000OOo.O00000oo);
        parcel.writeString(this.O0000OOo.O0000OOo);
        parcel.writeBooleanArray(this.O0000OOo.O0000O0o);
        parcel.writeString(this.O0000Oo);
        parcel.writeString(this.O0000OoO);
    }

    public PlugTimer(Parcel parcel) {
        boolean z = false;
        this.O0000Oo0 = 0;
        this.f11250O000000o = parcel.readInt() == 1;
        this.O00000Oo = parcel.readInt() == 1;
        this.O00000o0 = parcel.readInt() == 1;
        this.O00000o = parcel.readInt() == 1;
        this.O00000oO = new CorntabUtils.CorntabParam();
        this.O00000oO.f11160O000000o = parcel.readInt();
        this.O00000oO.O00000Oo = parcel.readInt();
        this.O00000oO.O00000o0 = parcel.readInt();
        this.O00000oO.O00000o = parcel.readInt();
        this.O00000oO.O00000oO = parcel.readInt();
        this.O00000oO.O00000oo = parcel.readInt();
        this.O00000oO.O0000OOo = parcel.readString();
        parcel.readBooleanArray(this.O00000oO.O0000O0o);
        this.O00000oo = parcel.readInt() == 1;
        this.O0000O0o = parcel.readInt() == 1 ? true : z;
        this.O0000OOo = new CorntabUtils.CorntabParam();
        this.O0000OOo.f11160O000000o = parcel.readInt();
        this.O0000OOo.O00000Oo = parcel.readInt();
        this.O0000OOo.O00000o0 = parcel.readInt();
        this.O0000OOo.O00000o = parcel.readInt();
        this.O0000OOo.O00000oO = parcel.readInt();
        this.O0000OOo.O00000oo = parcel.readInt();
        this.O0000OOo.O0000OOo = parcel.readString();
        parcel.readBooleanArray(this.O0000OOo.O0000O0o);
        this.O0000Oo = parcel.readString();
        this.O0000OoO = parcel.readString();
    }

    public PlugTimer() {
        this.O0000Oo0 = 0;
        this.f11250O000000o = true;
        this.O00000Oo = true;
        this.O00000o0 = false;
        this.O00000o = true;
        this.O00000oO = new CorntabUtils.CorntabParam();
        this.O00000oo = false;
        this.O0000O0o = true;
        this.O0000OOo = new CorntabUtils.CorntabParam();
        this.O0000Oo = null;
        this.O0000OoO = "0";
    }

    public final Object clone() {
        try {
            PlugTimer plugTimer = (PlugTimer) super.clone();
            try {
                plugTimer.f11250O000000o = this.f11250O000000o;
                plugTimer.O00000Oo = this.O00000Oo;
                plugTimer.O00000o0 = this.O00000o0;
                plugTimer.O00000o = this.O00000o;
                plugTimer.O00000oO = (CorntabUtils.CorntabParam) this.O00000oO.clone();
                plugTimer.O00000oo = this.O00000oo;
                plugTimer.O0000O0o = this.O0000O0o;
                plugTimer.O0000OOo = (CorntabUtils.CorntabParam) this.O0000OOo.clone();
                plugTimer.O0000Oo = this.O0000Oo;
                plugTimer.O0000OoO = this.O0000OoO;
                return plugTimer;
            } catch (CloneNotSupportedException unused) {
                return plugTimer;
            }
        } catch (CloneNotSupportedException unused2) {
            return null;
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof PlugTimer)) {
            return false;
        }
        PlugTimer plugTimer = (PlugTimer) obj;
        if (this.f11250O000000o == plugTimer.f11250O000000o && this.O00000Oo == plugTimer.O00000Oo && this.O00000o0 == plugTimer.O00000o0 && this.O00000o == plugTimer.O00000o && this.O00000oO.equals(plugTimer.O00000oO) && this.O00000oo == plugTimer.O00000oo && this.O0000O0o == plugTimer.O0000O0o && this.O0000OOo.equals(plugTimer.O0000OOo)) {
            return true;
        }
        return false;
    }

    public static String O000000o(Context context, CorntabUtils.CorntabParam corntabParam, CorntabUtils.CorntabParam corntabParam2, boolean z, int i, int i2, boolean z2) {
        StringBuilder sb = new StringBuilder();
        Calendar.getInstance();
        if (z2) {
            if (corntabParam.O00000Oo() == 0 && !O000000o(i, i2)) {
                sb.append(context.getString(R.string.plug_timer_tomorrow));
                sb.append(" ");
            }
        } else if (corntabParam2.O00000Oo() == 0) {
            if (z) {
                if (O000000o(corntabParam.O00000o0, corntabParam.O00000Oo)) {
                    if (!O000000o(corntabParam.O00000o0, corntabParam.O00000Oo, i, i2)) {
                        sb.append(context.getString(R.string.plug_timer_set_nextday));
                        sb.append(" ");
                    }
                } else if (O000000o(corntabParam.O00000o0, corntabParam.O00000Oo, i, i2)) {
                    sb.append(context.getString(R.string.plug_timer_tomorrow));
                    sb.append(" ");
                } else {
                    sb.append(context.getString(R.string.plug_timer_set_nextday));
                    sb.append(" ");
                }
            } else if (!O000000o(i, i2)) {
                sb.append(context.getString(R.string.plug_timer_tomorrow));
                sb.append(" ");
            }
        } else if (z && !O000000o(corntabParam.O00000o0, corntabParam.O00000Oo, i, i2)) {
            sb.append(context.getString(R.string.plug_timer_set_nextday));
            sb.append(" ");
        }
        sb.append(O000000o(i));
        sb.append(":");
        sb.append(O000000o(i2));
        return sb.toString();
    }

    private static boolean O000000o(int i, int i2) {
        Calendar instance = Calendar.getInstance();
        return (i * 60) + i2 > (instance.get(11) * 60) + instance.get(12);
    }

    private static String O000000o(int i) {
        return i < 10 ? "0".concat(String.valueOf(i)) : Integer.toString(i);
    }

    public static PlugTimer O000000o(CommonTimer commonTimer) {
        if (commonTimer == null) {
            return null;
        }
        PlugTimer plugTimer = new PlugTimer();
        plugTimer.O00000Oo = commonTimer.O00000oo;
        plugTimer.O00000o0 = commonTimer.O0000O0o;
        plugTimer.O00000oO = commonTimer.O0000Oo;
        plugTimer.O00000oo = commonTimer.O0000OoO;
        plugTimer.O0000OOo = commonTimer.O0000o0;
        plugTimer.O0000Oo0 = commonTimer.O0000o0o;
        plugTimer.O0000Oo = commonTimer.f11210O000000o;
        plugTimer.O0000OoO = "1";
        return plugTimer;
    }
}

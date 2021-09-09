package com.xiaomi.smarthome.core.entity.plugin;

import _m_j.gsy;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.xiaomi.smarthome.core.server.internal.plugin.PluginDeviceManager;
import com.xiaomi.smarthome.library.log.LogType;
import java.util.ArrayList;
import java.util.List;

public class PluginDeviceInfo implements Parcelable {
    public static final Parcelable.Creator<PluginDeviceInfo> CREATOR = new Parcelable.Creator<PluginDeviceInfo>() {
        /* class com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new PluginDeviceInfo[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new PluginDeviceInfo(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public String f6737O000000o;
    public int O00000Oo;
    public String O00000o;
    public int O00000o0;
    public String O00000oO;
    public String O00000oo;
    public int O0000O0o;
    public int O0000OOo;
    public int O0000Oo;
    public String O0000Oo0;
    public int O0000OoO;
    public int O0000Ooo;
    public int O0000o;
    public int O0000o0;
    public int O0000o00;
    public int O0000o0O;
    public int O0000o0o;
    public int O0000oO;
    public int O0000oO0;
    public int O0000oOO;
    public byte O0000oOo;
    public long O0000oo;
    public int O0000oo0;
    public List<Integer> O0000ooO;
    public int O0000ooo;
    public List<Integer> O000O00o;
    public boolean O000O0OO;
    public List<String> O000O0Oo;
    public int O000O0o;
    public int O000O0o0;
    private String O000O0oO;
    private String O000O0oo;
    private String O000OO;
    private String O000OO00;
    private String O000OO0o;
    public int O00oOoOo;
    public int O00oOooO;
    public List<Integer> O00oOooo;

    public int describeContents() {
        return 0;
    }

    public final boolean O000000o() {
        int i = this.O0000ooo;
        return i <= 25 || i == 19 || i == 20 || i == 18 || i == 22 || i == 17;
    }

    public PluginDeviceInfo() {
    }

    protected PluginDeviceInfo(Parcel parcel) {
        this.f6737O000000o = parcel.readString();
        this.O00000Oo = parcel.readInt();
        this.O00000o0 = parcel.readInt();
        this.O00000o = parcel.readString();
        this.O000O0oO = parcel.readString();
        this.O000O0oo = parcel.readString();
        this.O000OO00 = parcel.readString();
        this.O000OO0o = parcel.readString();
        this.O00000oO = parcel.readString();
        this.O00000oo = parcel.readString();
        this.O000OO = parcel.readString();
        this.O0000O0o = parcel.readInt();
        this.O0000OOo = parcel.readInt();
        this.O0000Oo0 = parcel.readString();
        this.O0000Oo = parcel.readInt();
        this.O0000OoO = parcel.readInt();
        this.O0000Ooo = parcel.readInt();
        this.O0000o00 = parcel.readInt();
        this.O0000o0 = parcel.readInt();
        this.O0000o0O = parcel.readInt();
        this.O0000o0o = parcel.readInt();
        this.O0000o = parcel.readInt();
        this.O0000ooo = parcel.readInt();
        this.O00oOooO = parcel.readInt();
        this.O00oOooo = parcel.readArrayList(ClassLoader.getSystemClassLoader());
        this.O0000oO0 = parcel.readInt();
        this.O0000oO = parcel.readInt();
        this.O000O00o = parcel.readArrayList(ClassLoader.getSystemClassLoader());
        this.O000O0OO = parcel.readInt() != 0;
        this.O0000oo0 = parcel.readInt();
        this.O000O0Oo = parcel.readArrayList(ClassLoader.getSystemClassLoader());
        this.O00oOoOo = parcel.readInt();
        this.O000O0o0 = parcel.readInt();
        this.O0000oOO = parcel.readInt();
        this.O0000oOo = parcel.readByte();
        this.O000O0o = parcel.readInt();
        this.O0000oo = parcel.readLong();
        this.O0000ooO = parcel.readArrayList(ClassLoader.getSystemClassLoader());
    }

    public final synchronized String O00000Oo() {
        if (TextUtils.isEmpty(this.f6737O000000o)) {
            return "";
        }
        return this.f6737O000000o;
    }

    public final synchronized void O000000o(String str) {
        this.f6737O000000o = str;
    }

    public final synchronized int O00000o0() {
        return this.O00000Oo;
    }

    public final synchronized void O000000o(int i) {
        this.O00000Oo = i;
    }

    public final synchronized int O00000o() {
        return this.O0000ooo;
    }

    public final synchronized void O00000Oo(int i) {
        this.O0000ooo = i;
    }

    public final synchronized int O00000oO() {
        return this.O00oOooO;
    }

    public final synchronized void O00000o0(int i) {
        this.O00oOooO = i;
    }

    public final synchronized void O000000o(List<Integer> list) {
        this.O00oOooo = new ArrayList();
        this.O00oOooo.addAll(list);
    }

    public final synchronized boolean O00000oo() {
        return this.O000O0OO;
    }

    public final synchronized void O000000o(boolean z) {
        this.O000O0OO = z;
    }

    public final synchronized List<Integer> O0000O0o() {
        return this.O000O00o;
    }

    public final synchronized void O00000Oo(List<Integer> list) {
        this.O000O00o = list;
    }

    public final synchronized int O0000OOo() {
        return this.O00000o0;
    }

    public final synchronized void O00000o(int i) {
        this.O00000o0 = i;
    }

    public final synchronized String O0000Oo0() {
        if (TextUtils.isEmpty(this.O00000o)) {
            return "";
        }
        return this.O00000o;
    }

    public final synchronized void O00000Oo(String str) {
        this.O00000o = str;
    }

    public final synchronized String O0000Oo() {
        if (this.O000O0oO == null) {
            O000O0o();
        }
        if (TextUtils.isEmpty(this.O000O0oO)) {
            return "";
        }
        return this.O000O0oO;
    }

    public final synchronized void O00000o0(String str) {
        this.O000O0oO = str;
    }

    public final synchronized String O0000OoO() {
        if (this.O000O0oo == null) {
            O000O0o();
        }
        if (TextUtils.isEmpty(this.O000O0oo)) {
            return "";
        }
        return this.O000O0oo;
    }

    public final synchronized void O00000o(String str) {
        this.O000O0oo = str;
    }

    public final synchronized String O0000Ooo() {
        if (this.O000OO00 == null) {
            O000O0o();
        }
        if (TextUtils.isEmpty(this.O000OO00)) {
            return "";
        }
        return this.O000OO00;
    }

    public final synchronized void O00000oO(String str) {
        this.O000OO00 = str;
    }

    public final synchronized String O0000o00() {
        if (this.O000OO0o == null) {
            O000O0o();
        }
        if (TextUtils.isEmpty(this.O000OO0o)) {
            return "";
        }
        return this.O000OO0o;
    }

    public final synchronized void O00000oo(String str) {
        this.O000OO0o = str;
    }

    public final synchronized String O0000o0() {
        if (TextUtils.isEmpty(this.O00000oO)) {
            return "";
        }
        return this.O00000oO;
    }

    public final synchronized void O0000O0o(String str) {
        this.O00000oO = str;
    }

    public final synchronized String O0000o0O() {
        return this.O00000oo;
    }

    public final synchronized void O0000OOo(String str) {
        this.O00000oo = str;
    }

    public final synchronized String O0000o0o() {
        if (this.O000OO == null) {
            O000O0o();
        }
        return this.O000OO;
    }

    public final synchronized void O0000Oo0(String str) {
        this.O000OO = str;
    }

    public final synchronized int O0000o() {
        return this.O0000O0o;
    }

    public final synchronized void O00000oO(int i) {
        this.O0000O0o = i;
    }

    public final synchronized PluginDeviceInfoStatus O0000oO0() {
        return PluginDeviceInfoStatus.valueOf(this.O0000OOo);
    }

    public final synchronized void O00000oo(int i) {
        this.O0000OOo = i;
    }

    public final synchronized String O0000oO() {
        return this.O0000Oo0;
    }

    public final synchronized void O0000Oo(String str) {
        this.O0000Oo0 = str;
    }

    public final synchronized int O0000oOO() {
        return this.O0000Oo;
    }

    public final synchronized void O0000O0o(int i) {
        this.O0000Oo = i;
    }

    public final synchronized int O0000oOo() {
        return this.O0000OoO;
    }

    public final synchronized void O0000OOo(int i) {
        this.O0000OoO = i;
    }

    public final synchronized int O0000oo0() {
        return this.O0000o00;
    }

    public final synchronized void O0000Oo0(int i) {
        this.O0000o00 = i;
    }

    public final synchronized int O0000oo() {
        return this.O0000o0;
    }

    public final synchronized void O0000Oo(int i) {
        this.O0000o0 = i;
    }

    public final synchronized int O0000ooO() {
        return this.O0000o0O;
    }

    public final synchronized void O0000OoO(int i) {
        this.O0000o0o = i;
    }

    public final synchronized int O0000ooo() {
        return this.O0000o0o;
    }

    public final synchronized void O0000Ooo(int i) {
        this.O0000o = i;
    }

    public final synchronized int O00oOooO() {
        return this.O0000o;
    }

    public final synchronized void O0000o00(int i) {
        this.O0000o0O = i;
    }

    public final synchronized int O00oOooo() {
        return this.O0000Ooo;
    }

    public final synchronized void O0000o0(int i) {
        this.O0000Ooo = i;
    }

    public final synchronized void O0000o0O(int i) {
        this.O0000oO0 = i;
    }

    public final synchronized int O000O00o() {
        return this.O0000oO0;
    }

    public final synchronized void O0000o0o(int i) {
        this.O0000oO = i;
    }

    public final synchronized int O000O0OO() {
        return this.O0000oO;
    }

    public final synchronized void O00000o0(List<String> list) {
        this.O000O0Oo = list;
    }

    public final synchronized List<String> O000O0Oo() {
        return this.O000O0Oo;
    }

    public final boolean O0000o(int i) {
        return (i & this.O000O0o) != 0;
    }

    public final synchronized void O0000oO0(int i) {
        this.O0000oOO = i;
    }

    public final synchronized int O00oOoOo() {
        return this.O0000oOO;
    }

    private void O000O0o() {
        LogType logType = LogType.PLUGIN;
        gsy.O00000o0(logType, "PluginDeviceManager", "loadOther mModel:" + this.f6737O000000o);
        PluginDeviceManager.instance.readDeviceOtherfInternal(this.f6737O000000o);
    }

    public final synchronized String O000O0o0() {
        return "PluginDeviceInfo[" + "model:" + this.f6737O000000o + " " + "productId:" + this.O00000Oo + " " + "minAppVersion:" + this.O00000o0 + " " + "name:" + this.O00000o + " " + "desc:" + this.O000OO + " " + "iconOn:" + this.O000O0oO + " " + "iconOff:" + this.O000O0oo + " " + "iconOffline:" + this.O000OO00 + " " + "modelRegex:" + this.O00000oo + " " + "categoryName:" + this.O0000Oo0 + " " + "iconBluetoothPair:" + this.O000OO0o + " " + "]";
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f6737O000000o);
        parcel.writeInt(this.O00000Oo);
        parcel.writeInt(this.O00000o0);
        parcel.writeString(this.O00000o);
        parcel.writeString(this.O000O0oO);
        parcel.writeString(this.O000O0oo);
        parcel.writeString(this.O000OO00);
        parcel.writeString(this.O000OO0o);
        parcel.writeString(this.O00000oO);
        parcel.writeString(this.O00000oo);
        parcel.writeString(this.O000OO);
        parcel.writeInt(this.O0000O0o);
        parcel.writeInt(this.O0000OOo);
        parcel.writeString(this.O0000Oo0);
        parcel.writeInt(this.O0000Oo);
        parcel.writeInt(this.O0000OoO);
        parcel.writeInt(this.O0000Ooo);
        parcel.writeInt(this.O0000o00);
        parcel.writeInt(this.O0000o0);
        parcel.writeInt(this.O0000o0O);
        parcel.writeInt(this.O0000o0o);
        parcel.writeInt(this.O0000o);
        parcel.writeInt(this.O0000ooo);
        parcel.writeInt(this.O00oOooO);
        parcel.writeList(this.O00oOooo);
        parcel.writeInt(this.O0000oO0);
        parcel.writeInt(this.O0000oO);
        parcel.writeList(this.O000O00o);
        parcel.writeByte(this.O000O0OO ? (byte) 1 : 0);
        parcel.writeInt(this.O0000oo0);
        parcel.writeList(this.O000O0Oo);
        parcel.writeInt(this.O00oOoOo);
        parcel.writeInt(this.O000O0o0);
        parcel.writeInt(this.O0000oOO);
        parcel.writeByte(this.O0000oOo);
        parcel.writeInt(this.O000O0o);
        parcel.writeLong(this.O0000oo);
        parcel.writeList(this.O0000ooO);
    }
}

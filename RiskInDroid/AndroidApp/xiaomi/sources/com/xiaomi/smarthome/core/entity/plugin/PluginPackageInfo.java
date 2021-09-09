package com.xiaomi.smarthome.core.entity.plugin;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

public class PluginPackageInfo implements Parcelable {
    public static final Parcelable.Creator<PluginPackageInfo> CREATOR = new Parcelable.Creator<PluginPackageInfo>() {
        /* class com.xiaomi.smarthome.core.entity.plugin.PluginPackageInfo.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new PluginPackageInfo[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new PluginPackageInfo(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    private long f6739O000000o;
    private long O00000Oo;
    private int O00000o;
    private String O00000o0;
    private int O00000oO;
    private long O00000oo;
    private String O0000O0o;
    private String O0000OOo;
    private List<String> O0000Oo;
    private String O0000Oo0;
    private boolean O0000OoO;
    private boolean O0000Ooo = true;
    private long O0000o00;

    public int describeContents() {
        return 0;
    }

    public PluginPackageInfo() {
    }

    public PluginPackageInfo(Parcel parcel) {
        boolean z = true;
        this.f6739O000000o = parcel.readLong();
        this.O00000Oo = parcel.readLong();
        this.O00000o0 = parcel.readString();
        this.O00000o = parcel.readInt();
        this.O00000oO = parcel.readInt();
        this.O00000oo = parcel.readLong();
        this.O0000O0o = parcel.readString();
        this.O0000OOo = parcel.readString();
        this.O0000Oo0 = parcel.readString();
        this.O0000Oo = new ArrayList();
        parcel.readStringList(this.O0000Oo);
        this.O0000OoO = parcel.readInt() != 0;
        this.O0000Ooo = parcel.readInt() == 0 ? false : z;
        this.O0000o00 = parcel.readLong();
    }

    public final synchronized long O000000o() {
        return this.f6739O000000o;
    }

    public final synchronized void O000000o(long j) {
        this.f6739O000000o = j;
    }

    public final synchronized long O00000Oo() {
        return this.O00000Oo;
    }

    public final synchronized void O00000Oo(long j) {
        this.O00000Oo = j;
    }

    public final synchronized void O000000o(boolean z) {
        this.O0000OoO = z;
    }

    public final synchronized void O00000Oo(boolean z) {
        this.O0000Ooo = z;
    }

    public final synchronized boolean O00000o0() {
        return this.O0000Ooo;
    }

    public final synchronized void O00000o0(long j) {
        this.O0000o00 = j;
    }

    public final synchronized String O00000o() {
        if (TextUtils.isEmpty(this.O00000o0)) {
            return "";
        }
        return this.O00000o0;
    }

    public final synchronized void O000000o(String str) {
        this.O00000o0 = str;
    }

    public final synchronized int O00000oO() {
        return this.O00000o;
    }

    public final synchronized void O000000o(int i) {
        this.O00000o = i;
    }

    public final synchronized String O00000oo() {
        if (TextUtils.isEmpty(this.O0000Oo0)) {
            return "";
        }
        return this.O0000Oo0;
    }

    public final synchronized void O00000Oo(String str) {
        this.O0000Oo0 = str;
    }

    public final synchronized String O0000O0o() {
        if (TextUtils.isEmpty(this.O0000O0o)) {
            return "";
        }
        return this.O0000O0o;
    }

    public final synchronized void O00000o0(String str) {
        this.O0000O0o = str;
    }

    public final synchronized int O0000OOo() {
        return this.O00000oO;
    }

    public final synchronized void O00000Oo(int i) {
        this.O00000oO = i;
    }

    public final synchronized long O0000Oo0() {
        return this.O00000oo;
    }

    public final synchronized void O00000o(long j) {
        this.O00000oo = j;
    }

    public final synchronized String O0000Oo() {
        return this.O0000OOo;
    }

    public final synchronized void O00000o(String str) {
        this.O0000OOo = str;
    }

    public final synchronized List<String> O0000OoO() {
        return this.O0000Oo;
    }

    public final synchronized void O000000o(List<String> list) {
        this.O0000Oo = list;
    }

    public final synchronized boolean O0000Ooo() {
        if (TextUtils.isEmpty(this.O0000O0o) || !this.O0000O0o.equalsIgnoreCase("apk")) {
            return false;
        }
        return true;
    }

    public final synchronized boolean O0000o00() {
        if (TextUtils.isEmpty(this.O0000O0o) || !this.O0000O0o.equalsIgnoreCase("h5")) {
            return false;
        }
        return true;
    }

    public final synchronized boolean O0000o0() {
        if (TextUtils.isEmpty(this.O0000O0o) || !this.O0000O0o.equalsIgnoreCase("mpk")) {
            return false;
        }
        return true;
    }

    public final synchronized boolean O0000o0O() {
        if (TextUtils.isEmpty(this.O0000O0o) || !this.O0000O0o.equalsIgnoreCase("rn")) {
            return false;
        }
        return true;
    }

    public final synchronized String O0000o0o() {
        return "PluginPackageInfo[" + "pluginId:" + this.f6739O000000o + " " + "packageId:" + this.O00000Oo + " " + "packagePath:" + this.O00000o0 + " " + "version:" + this.O00000o + " " + "minApiLevel:" + this.O00000oO + " " + "developerId:" + this.O00000oo + " " + "packageType:" + this.O0000O0o + " " + "platform:" + this.O0000OOo + " " + "packageName:" + this.O0000Oo0 + " " + "modelList:" + this.O0000Oo + " " + "packageLastModified" + this.O0000o00 + " " + "mIsSupportWidget" + this.O0000OoO + " " + "mIsSupportAppAV" + this.O0000Ooo + " " + "]";
    }

    private static void O000000o(String str, Parcel parcel) {
        if (str == null) {
            parcel.writeString("");
        } else {
            parcel.writeString(str);
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f6739O000000o);
        parcel.writeLong(this.O00000Oo);
        parcel.writeString(this.O00000o0);
        parcel.writeInt(this.O00000o);
        parcel.writeInt(this.O00000oO);
        parcel.writeLong(this.O00000oo);
        O000000o(this.O0000O0o, parcel);
        O000000o(this.O0000OOo, parcel);
        O000000o(this.O0000Oo0, parcel);
        if (this.O0000Oo == null) {
            this.O0000Oo = new ArrayList();
        }
        parcel.writeStringList(this.O0000Oo);
        parcel.writeInt(this.O0000OoO ? 1 : 0);
        parcel.writeInt(this.O0000Ooo ? 1 : 0);
        parcel.writeLong(this.O0000o00);
    }
}

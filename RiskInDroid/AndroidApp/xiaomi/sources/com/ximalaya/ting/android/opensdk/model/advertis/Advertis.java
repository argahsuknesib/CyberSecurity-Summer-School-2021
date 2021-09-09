package com.ximalaya.ting.android.opensdk.model.advertis;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Advertis implements Parcelable {
    public static final Parcelable.Creator<Advertis> CREATOR = new Parcelable.Creator<Advertis>() {
        /* class com.ximalaya.ting.android.opensdk.model.advertis.Advertis.AnonymousClass2 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new Advertis[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            Advertis advertis = new Advertis();
            advertis.O00000Oo = parcel.readInt();
            advertis.O00000o0 = parcel.readString();
            advertis.O00000o = parcel.readInt();
            advertis.O00000oO = parcel.readString();
            advertis.O00000oo = parcel.readString();
            advertis.O0000O0o = parcel.readString();
            advertis.O0000OOo = parcel.readString();
            advertis.O0000Oo0 = parcel.readString();
            advertis.O0000OoO = parcel.readInt();
            advertis.O0000Ooo = parcel.readInt();
            advertis.O0000o00 = parcel.readInt();
            advertis.O0000o0 = parcel.readInt();
            advertis.O0000o0O = parcel.readString();
            advertis.O0000o0o = parcel.readString();
            advertis.O0000o = parcel.readLong();
            advertis.O0000oOo = (AdShareDataForOpenSDK) parcel.readParcelable(AdShareDataForOpenSDK.class.getClassLoader());
            boolean z = false;
            advertis.O0000oOO = parcel.readInt() == 1;
            advertis.O0000oo0 = parcel.readInt() == 1;
            advertis.O0000oo = parcel.readInt();
            advertis.O0000ooO = parcel.readInt() == 1;
            advertis.O0000ooo = parcel.readString();
            ArrayList arrayList = new ArrayList();
            parcel.readStringList(arrayList);
            advertis.O00oOooo = arrayList;
            ArrayList arrayList2 = new ArrayList();
            parcel.readStringList(arrayList2);
            advertis.O00oOooO = arrayList2;
            advertis.O000O0OO = parcel.readString();
            advertis.O000O0Oo = parcel.readString();
            advertis.O00oOoOo = parcel.readLong();
            advertis.O000O0o0 = parcel.readInt() == 1;
            advertis.O000O0o = parcel.readLong();
            advertis.O000O0oO = parcel.readString();
            advertis.O000OOOo = parcel.readString();
            advertis.O000O0oo = parcel.readInt() == 1;
            ArrayList arrayList3 = new ArrayList();
            parcel.readStringList(arrayList3);
            advertis.O000OOo = arrayList3;
            ArrayList arrayList4 = new ArrayList();
            parcel.readStringList(arrayList4);
            advertis.O000OOoO = arrayList4;
            advertis.O0000oO0 = parcel.readLong();
            advertis.O0000oO = parcel.readLong();
            advertis.O000OOoo = parcel.readString();
            advertis.O000Oo00 = parcel.readString();
            advertis.O000Oo0 = parcel.readInt();
            advertis.O000OO00 = parcel.readInt();
            ArrayList arrayList5 = new ArrayList();
            parcel.readStringList(arrayList5);
            advertis.O000OO0o = arrayList5;
            advertis.O000Oo0O = parcel.readString();
            if (parcel.readInt() == 1) {
                z = true;
            }
            advertis.O000Oo0o = z;
            advertis.O000OoO0 = parcel.readString();
            return advertis;
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public static final Type f12168O000000o = new TypeToken<Advertis>() {
        /* class com.ximalaya.ting.android.opensdk.model.advertis.Advertis.AnonymousClass1 */
    }.getType();
    public static Set<String> O00O0Oo = new HashSet();
    @SerializedName(alternate = {"adId"}, value = "adid")
    public int O00000Oo;
    int O00000o;
    String O00000o0;
    @SerializedName("link")
    String O00000oO;
    @SerializedName(alternate = {"cover"}, value = "image")
    String O00000oo;
    @SerializedName("logo")
    String O0000O0o;
    public String O0000OOo;
    public int O0000Oo = 100;
    public String O0000Oo0;
    int O0000OoO;
    int O0000Ooo;
    public long O0000o;
    public int O0000o0;
    int O0000o00;
    String O0000o0O;
    String O0000o0o;
    long O0000oO;
    long O0000oO0;
    @SerializedName(alternate = {"shareFlag"}, value = "isShareFlag")
    boolean O0000oOO;
    AdShareDataForOpenSDK O0000oOo;
    @SerializedName(alternate = {"adType"}, value = "adtype")
    public int O0000oo;
    public boolean O0000oo0;
    boolean O0000ooO;
    String O0000ooo;
    public String O000O00o;
    public String O000O0OO;
    public String O000O0Oo;
    public long O000O0o;
    boolean O000O0o0;
    String O000O0oO;
    boolean O000O0oo;
    public int O000OO;
    int O000OO00;
    List<String> O000OO0o;
    String O000OOOo;
    public List<String> O000OOo;
    public List<String> O000OOo0;
    List<String> O000OOoO;
    String O000OOoo;
    int O000Oo0;
    String O000Oo00;
    public String O000Oo0O;
    public boolean O000Oo0o;
    private boolean O000OoO = true;
    String O000OoO0;
    private boolean O000OoOO = true;
    long O00oOoOo;
    public List<String> O00oOooO;
    List<String> O00oOooo;

    public int describeContents() {
        return 0;
    }

    public final String O000000o() {
        String str = this.O0000OOo;
        if (!TextUtils.isEmpty(str)) {
            String host = Uri.parse(str).getHost();
            if (!"fdfs.xmcdn.com".equals(host) && !"fdfs.ximalaya.com".equals(host)) {
                O00O0Oo.add(host);
            }
        }
        return str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.O00000Oo);
        parcel.writeString(this.O00000o0);
        parcel.writeInt(this.O00000o);
        parcel.writeString(this.O00000oO);
        parcel.writeString(this.O00000oo);
        parcel.writeString(this.O0000O0o);
        parcel.writeString(this.O0000OOo);
        parcel.writeString(this.O0000Oo0);
        parcel.writeInt(this.O0000OoO);
        parcel.writeInt(this.O0000Ooo);
        parcel.writeInt(this.O0000o00);
        parcel.writeInt(this.O0000o0);
        parcel.writeString(this.O0000o0O);
        parcel.writeString(this.O0000o0o);
        parcel.writeLong(this.O0000o);
        parcel.writeParcelable(this.O0000oOo, i);
        parcel.writeInt(this.O0000oOO ? 1 : 0);
        parcel.writeInt(this.O0000oo0 ? 1 : 0);
        parcel.writeInt(this.O0000oo);
        parcel.writeInt(this.O0000ooO ? 1 : 0);
        parcel.writeString(this.O0000ooo);
        parcel.writeStringList(this.O00oOooo);
        parcel.writeStringList(this.O00oOooO);
        parcel.writeString(this.O000O0OO);
        parcel.writeString(this.O000O0Oo);
        parcel.writeLong(this.O00oOoOo);
        parcel.writeInt(this.O000O0o0 ? 1 : 0);
        parcel.writeLong(this.O000O0o);
        parcel.writeString(this.O000O0oO);
        parcel.writeString(this.O000OOOo);
        parcel.writeInt(this.O000O0oo ? 1 : 0);
        parcel.writeStringList(this.O000OOo);
        parcel.writeStringList(this.O000OOoO);
        parcel.writeLong(this.O0000oO0);
        parcel.writeLong(this.O0000oO);
        parcel.writeString(this.O000OOoo);
        parcel.writeString(this.O000Oo00);
        parcel.writeInt(this.O000Oo0);
        parcel.writeInt(this.O000OO00);
        parcel.writeStringList(this.O000OO0o);
        parcel.writeString(this.O000Oo0O);
        parcel.writeInt(this.O000Oo0o ? 1 : 0);
        parcel.writeString(this.O000OoO0);
    }

    public String toString() {
        return "Advertis [adid=" + this.O00000Oo + ", name=" + this.O00000o0 + ", clickType=" + this.O00000o + ", linkUrl=" + this.O00000oO + ", imageUrl=" + this.O00000oo + ", soundType=" + this.O0000o0 + ", logoUrl=" + this.O0000O0o + ", soundUrl=" + this.O0000OOo + ", thirdStatUrl=" + this.O0000Oo0 + "]";
    }
}

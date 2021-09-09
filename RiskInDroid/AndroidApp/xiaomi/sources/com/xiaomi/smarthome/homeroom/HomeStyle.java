package com.xiaomi.smarthome.homeroom;

import _m_j.ixe;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B1\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\u0015\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\nHÆ\u0003J=\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\nHÆ\u0001J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0018HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0006HÖ\u0001J\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u0018H\u0016R\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000f¨\u0006#"}, d2 = {"Lcom/xiaomi/smarthome/homeroom/HomeStyle;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "style", "", "title", "homeStylePreview", "data", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "getData", "()Ljava/util/Map;", "getHomeStylePreview", "()Ljava/lang/String;", "getStyle", "getTitle", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "flags", "CREATOR", "smarthome-home_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class HomeStyle implements Parcelable {
    public static final O000000o CREATOR = new O000000o((byte) 0);

    /* renamed from: O000000o  reason: collision with root package name */
    final String f8923O000000o;
    final String O00000Oo;
    final Map<String, String> O00000o;
    final String O00000o0;

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HomeStyle)) {
            return false;
        }
        HomeStyle homeStyle = (HomeStyle) obj;
        return ixe.O000000o(this.f8923O000000o, homeStyle.f8923O000000o) && ixe.O000000o(this.O00000Oo, homeStyle.O00000Oo) && ixe.O000000o(this.O00000o0, homeStyle.O00000o0) && ixe.O000000o(this.O00000o, homeStyle.O00000o);
    }

    public final int hashCode() {
        return (((((this.f8923O000000o.hashCode() * 31) + this.O00000Oo.hashCode()) * 31) + this.O00000o0.hashCode()) * 31) + this.O00000o.hashCode();
    }

    public final String toString() {
        return "HomeStyle(style=" + this.f8923O000000o + ", title=" + this.O00000Oo + ", homeStylePreview=" + this.O00000o0 + ", data=" + this.O00000o + ')';
    }

    public HomeStyle(String str, String str2, String str3, Map<String, String> map) {
        ixe.O00000o(str, "style");
        ixe.O00000o(str2, "title");
        ixe.O00000o(str3, "homeStylePreview");
        ixe.O00000o(map, "data");
        this.f8923O000000o = str;
        this.O00000Oo = str2;
        this.O00000o0 = str3;
        this.O00000o = map;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public HomeStyle(Parcel parcel) {
        this(r0, r1, r2, new LinkedHashMap());
        ixe.O00000o(parcel, "parcel");
        String readString = parcel.readString();
        ixe.O000000o((Object) readString);
        String readString2 = parcel.readString();
        ixe.O000000o((Object) readString2);
        String readString3 = parcel.readString();
        ixe.O000000o((Object) readString3);
        parcel.readMap(this.O00000o, ClassLoader.getSystemClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        ixe.O00000o(parcel, "parcel");
        parcel.writeString(this.f8923O000000o);
        parcel.writeString(this.O00000Oo);
        parcel.writeString(this.O00000o0);
        parcel.writeMap(this.O00000o);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/xiaomi/smarthome/homeroom/HomeStyle$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/xiaomi/smarthome/homeroom/HomeStyle;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/xiaomi/smarthome/homeroom/HomeStyle;", "smarthome-home_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O000000o implements Parcelable.Creator<HomeStyle> {
        public /* synthetic */ O000000o(byte b) {
            this();
        }

        private O000000o() {
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            ixe.O00000o(parcel, "parcel");
            return new HomeStyle(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new HomeStyle[i];
        }
    }
}

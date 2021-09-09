package com.xiaomi.smarthome.shop.share;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;

public class ShareObject implements Parcelable {
    public static final Parcelable.Creator<ShareObject> CREATOR = new Parcelable.Creator<ShareObject>() {
        /* class com.xiaomi.smarthome.shop.share.ShareObject.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ShareObject[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new ShareObject(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public String f11389O000000o;
    public String O00000Oo;
    public String O00000o;
    public String O00000o0;
    public Uri O00000oO;
    public Uri O00000oo;
    private String O0000O0o;
    private ArrayList<Uri> O0000OOo;
    private String O0000Oo;
    private String O0000Oo0;
    private String O0000OoO;
    private String O0000Ooo;
    private String O0000o;
    private String O0000o0;
    private String O0000o00;
    private String O0000o0O;
    private String O0000o0o;

    public int describeContents() {
        return 0;
    }

    public ShareObject() {
        this.O0000o00 = "";
        this.O0000o0 = "";
        this.O0000o0O = "";
        this.O0000o0o = "";
        this.O0000o = "";
        this.O0000OOo = new ArrayList<>();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("title: ");
        sb.append(this.f11389O000000o);
        sb.append(10);
        sb.append("content: ");
        sb.append(this.O00000Oo);
        sb.append(10);
        sb.append("wb content: ");
        sb.append(this.O00000o0);
        sb.append(10);
        sb.append("url: ");
        sb.append(this.O00000o);
        sb.append(10);
        sb.append("filesUrl: ");
        sb.append(this.O0000O0o);
        sb.append(10);
        sb.append("thumb: ");
        sb.append(this.O00000oO);
        sb.append(10);
        sb.append("pic: ");
        sb.append(this.O00000oo);
        sb.append("\nothers: ");
        Iterator<Uri> it = this.O0000OOo.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append(' ');
        }
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f11389O000000o);
        parcel.writeString(this.O00000Oo);
        parcel.writeString(this.O00000o0);
        parcel.writeString(this.O00000o);
        parcel.writeString(this.O0000O0o);
        parcel.writeParcelable(this.O00000oO, 0);
        parcel.writeParcelable(this.O00000oo, 0);
        parcel.writeTypedList(this.O0000OOo);
        parcel.writeString(this.O0000Oo0);
        parcel.writeString(this.O0000Oo);
        parcel.writeString(this.O0000OoO);
        parcel.writeString(this.O0000Ooo);
        parcel.writeString(this.O0000o00);
        parcel.writeString(this.O0000o0);
        parcel.writeString(this.O0000o0O);
        parcel.writeString(this.O0000o0o);
        parcel.writeString(this.O0000o);
    }

    protected ShareObject(Parcel parcel) {
        this.O0000o00 = "";
        this.O0000o0 = "";
        this.O0000o0O = "";
        this.O0000o0o = "";
        this.O0000o = "";
        this.f11389O000000o = parcel.readString();
        this.O00000Oo = parcel.readString();
        this.O00000o0 = parcel.readString();
        this.O00000o = parcel.readString();
        this.O0000O0o = parcel.readString();
        this.O00000oO = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.O00000oo = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.O0000OOo = parcel.createTypedArrayList(Uri.CREATOR);
        this.O0000Oo0 = parcel.readString();
        this.O0000Oo = parcel.readString();
        this.O0000OoO = parcel.readString();
        this.O0000Ooo = parcel.readString();
        this.O0000o00 = parcel.readString();
        this.O0000o0 = parcel.readString();
        this.O0000o0O = parcel.readString();
        this.O0000o0o = parcel.readString();
        this.O0000o = parcel.readString();
    }
}

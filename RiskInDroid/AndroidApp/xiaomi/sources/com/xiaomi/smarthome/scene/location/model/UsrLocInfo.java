package com.xiaomi.smarthome.scene.location.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UsrLocInfo implements Parcelable, Comparable<UsrLocInfo> {
    public static final Parcelable.Creator<UsrLocInfo> CREATOR = new Parcelable.Creator<UsrLocInfo>() {
        /* class com.xiaomi.smarthome.scene.location.model.UsrLocInfo.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new UsrLocInfo[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new UsrLocInfo(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    private int f11158O000000o;
    private String O00000Oo;
    private Map<String, Object> O00000o;
    private List<String> O00000o0;

    public int describeContents() {
        return 0;
    }

    public /* synthetic */ int compareTo(Object obj) {
        UsrLocInfo usrLocInfo = (UsrLocInfo) obj;
        if (O000000o()) {
            return 1;
        }
        if (usrLocInfo.O000000o()) {
            return -1;
        }
        if (O00000Oo()) {
            return 1;
        }
        if (usrLocInfo.O00000Oo()) {
            return -1;
        }
        int i = this.f11158O000000o;
        int i2 = usrLocInfo.f11158O000000o;
        if (i > i2) {
            return 1;
        }
        if (i < i2) {
            return -1;
        }
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f11158O000000o);
        parcel.writeString(this.O00000Oo);
        parcel.writeStringList(this.O00000o0);
        parcel.writeInt(this.O00000o.size());
        for (Map.Entry next : this.O00000o.entrySet()) {
            parcel.writeString((String) next.getKey());
            parcel.writeValue(next.getValue());
        }
    }

    public UsrLocInfo() {
    }

    protected UsrLocInfo(Parcel parcel) {
        this.f11158O000000o = parcel.readInt();
        this.O00000Oo = parcel.readString();
        this.O00000o0 = parcel.createStringArrayList();
        int readInt = parcel.readInt();
        this.O00000o = new HashMap(readInt);
        for (int i = 0; i < readInt; i++) {
            this.O00000o.put(parcel.readString(), parcel.readValue(Object.class.getClassLoader()));
        }
    }

    private boolean O000000o() {
        Map<String, Object> map = this.O00000o;
        if (map == null || map.isEmpty() || !this.O00000o.containsKey("template")) {
            return false;
        }
        return "home".equals(this.O00000o.get("template"));
    }

    private boolean O00000Oo() {
        Map<String, Object> map = this.O00000o;
        if (map == null || map.isEmpty() || !this.O00000o.containsKey("template")) {
            return false;
        }
        return "office".equals(this.O00000o.get("template"));
    }
}

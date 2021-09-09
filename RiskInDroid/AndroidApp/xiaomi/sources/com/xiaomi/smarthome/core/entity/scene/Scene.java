package com.xiaomi.smarthome.core.entity.scene;

import android.os.Parcel;
import android.os.Parcelable;

public class Scene implements Parcelable {
    public static final Parcelable.Creator<Scene> CREATOR = new Parcelable.Creator<Scene>() {
        /* class com.xiaomi.smarthome.core.entity.scene.Scene.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new Scene[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new Scene(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public String f6741O000000o;
    public String O00000Oo;
    public int O00000o;
    public boolean O00000o0;
    public String O00000oO;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f6741O000000o);
        parcel.writeString(this.O00000Oo);
        parcel.writeInt(this.O00000o0 ? 1 : 0);
        parcel.writeInt(this.O00000o);
        parcel.writeString(this.O00000oO);
    }

    public Scene() {
    }

    public Scene(Parcel parcel) {
        this.f6741O000000o = parcel.readString();
        this.O00000Oo = parcel.readString();
        this.O00000o0 = parcel.readInt() != 0;
        this.O00000oO = parcel.readString();
    }
}

package com.xiaomi.smarthome.scene.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.xiaomi.smarthome.device.api.RecommendSceneItem;

public class DefaultSceneItemSet implements Parcelable {
    public static final Parcelable.Creator<DefaultSceneItemSet> CREATOR = new Parcelable.Creator<DefaultSceneItemSet>() {
        /* class com.xiaomi.smarthome.scene.bean.DefaultSceneItemSet.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new DefaultSceneItemSet[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new DefaultSceneItemSet(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public Boolean f11135O000000o;
    public String[] O00000Oo;
    public String O00000o;
    public RecommendSceneItem.Key[] O00000o0;
    public String O00000oO;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.f11135O000000o);
        parcel.writeStringArray(this.O00000Oo);
        RecommendSceneItem.Key[] keyArr = this.O00000o0;
        int i2 = 0;
        if (keyArr != null) {
            parcel.writeInt(keyArr.length);
            while (true) {
                RecommendSceneItem.Key[] keyArr2 = this.O00000o0;
                if (i2 >= keyArr2.length) {
                    break;
                }
                keyArr2[i2].writeToParcel(parcel);
                i2++;
            }
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.O00000o);
        parcel.writeString(this.O00000oO);
    }

    public DefaultSceneItemSet() {
    }

    public DefaultSceneItemSet(Parcel parcel) {
        this.f11135O000000o = (Boolean) parcel.readValue(ClassLoader.getSystemClassLoader());
        if (this.f11135O000000o == null) {
            this.f11135O000000o = Boolean.FALSE;
        }
        this.O00000Oo = parcel.createStringArray();
        int readInt = parcel.readInt();
        if (readInt != 0) {
            this.O00000o0 = new RecommendSceneItem.Key[readInt];
            for (int i = 0; i < readInt; i++) {
                this.O00000o0[i] = new RecommendSceneItem.Key();
                this.O00000o0[i].readFromParcel(parcel);
            }
        }
        this.O00000o = parcel.readString();
        this.O00000oO = parcel.readString();
    }
}

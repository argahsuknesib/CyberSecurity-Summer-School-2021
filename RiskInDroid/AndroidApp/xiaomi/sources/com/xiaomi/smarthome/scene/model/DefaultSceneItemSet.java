package com.xiaomi.smarthome.scene.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.xiaomi.smarthome.device.api.RecommendSceneItem;

public class DefaultSceneItemSet implements Parcelable {
    public static final Parcelable.Creator<com.xiaomi.smarthome.scene.bean.DefaultSceneItemSet> CREATOR = new Parcelable.Creator<com.xiaomi.smarthome.scene.bean.DefaultSceneItemSet>() {
        /* class com.xiaomi.smarthome.scene.model.DefaultSceneItemSet.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new com.xiaomi.smarthome.scene.bean.DefaultSceneItemSet[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new com.xiaomi.smarthome.scene.bean.DefaultSceneItemSet(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public Boolean f11161O000000o;
    public String[] O00000Oo;
    public String O00000o;
    public RecommendSceneItem.Key[] O00000o0;
    public String O00000oO;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.f11161O000000o);
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
}

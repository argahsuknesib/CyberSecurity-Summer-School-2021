package com.xiaomi.smarthome.framework.plugin.rn.nativemodule.thirdparty.jiqid.writepad.model.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class PointBean implements Parcelable {
    public static final Parcelable.Creator<PointBean> CREATOR = new Parcelable.Creator<PointBean>() {
        /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.thirdparty.jiqid.writepad.model.bean.PointBean.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new PointBean[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new PointBean(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public int f8430O000000o;
    public float O00000Oo;
    public float O00000o;
    public float O00000o0;

    public int describeContents() {
        return 0;
    }

    public PointBean() {
    }

    protected PointBean(Parcel parcel) {
        this.f8430O000000o = parcel.readInt();
        this.O00000Oo = parcel.readFloat();
        this.O00000o0 = parcel.readFloat();
        this.O00000o = parcel.readFloat();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f8430O000000o);
        parcel.writeFloat(this.O00000Oo);
        parcel.writeFloat(this.O00000o0);
        parcel.writeFloat(this.O00000o);
    }
}

package com.xiaomi.smarthome.framework.plugin.rn.nativemodule.thirdparty.jiqid.writepad.model.bean;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

public class PointsBean implements Parcelable {
    public static final Parcelable.Creator<PointsBean> CREATOR = new Parcelable.Creator<PointsBean>() {
        /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.thirdparty.jiqid.writepad.model.bean.PointsBean.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new PointsBean[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new PointsBean(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    private List<PointBean> f8431O000000o;

    public int describeContents() {
        return 0;
    }

    public PointsBean() {
    }

    protected PointsBean(Parcel parcel) {
        this.f8431O000000o = parcel.createTypedArrayList(PointBean.CREATOR);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.f8431O000000o);
    }
}

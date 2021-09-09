package com.xiaomi.smarthome.feedback;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

public class FeedbackLabelEntity implements Parcelable {
    public static final Parcelable.Creator<FeedbackLabelEntity> CREATOR = new Parcelable.Creator<FeedbackLabelEntity>() {
        /* class com.xiaomi.smarthome.feedback.FeedbackLabelEntity.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new FeedbackLabelEntity[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new FeedbackLabelEntity(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public String f7417O000000o;
    public String O00000Oo;
    public int O00000o;
    public String O00000o0;
    public ArrayList<FeedbackLabelEntity> O00000oO;

    public int describeContents() {
        return 0;
    }

    public FeedbackLabelEntity() {
    }

    protected FeedbackLabelEntity(Parcel parcel) {
        this.f7417O000000o = parcel.readString();
        this.O00000Oo = parcel.readString();
        this.O00000o0 = parcel.readString();
        this.O00000o = parcel.readInt();
        this.O00000oO = parcel.createTypedArrayList(CREATOR);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f7417O000000o);
        parcel.writeString(this.O00000Oo);
        parcel.writeString(this.O00000o0);
        parcel.writeInt(this.O00000o);
        parcel.writeTypedList(this.O00000oO);
    }
}

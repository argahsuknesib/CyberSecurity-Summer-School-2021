package com.hannesdorfmann.mosby3;

import _m_j.aq;
import _m_j.ar;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.customview.view.AbsSavedState;

public class MosbySavedState extends AbsSavedState {
    public static final Parcelable.Creator<MosbySavedState> CREATOR = aq.O000000o(new ar<MosbySavedState>() {
        /* class com.hannesdorfmann.mosby3.MosbySavedState.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new MosbySavedState[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
            if (classLoader == null) {
                classLoader = MosbySavedState.class.getClassLoader();
            }
            return new MosbySavedState(parcel, classLoader);
        }
    });

    /* renamed from: O000000o  reason: collision with root package name */
    public String f4332O000000o;

    public MosbySavedState(Parcelable parcelable, String str) {
        super(parcelable);
        this.f4332O000000o = str;
    }

    protected MosbySavedState(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f4332O000000o = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.f4332O000000o);
    }
}

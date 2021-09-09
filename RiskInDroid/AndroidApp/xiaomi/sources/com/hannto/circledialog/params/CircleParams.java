package com.hannto.circledialog.params;

import _m_j.O0000Oo;
import _m_j.dz;
import android.os.Parcel;
import android.os.Parcelable;

public final class CircleParams implements Parcelable {
    public static final Parcelable.Creator<CircleParams> CREATOR = new O000000o();

    /* renamed from: O000000o  reason: collision with root package name */
    public dz f4340O000000o;
    public DialogParams O00000Oo;
    public TextParams O00000o;
    public TitleParams O00000o0;
    public ButtonParams O00000oO;
    public ButtonParams O00000oo;
    public ItemsParams O0000O0o;
    public ProgressParams O0000OOo;
    public int O0000Oo;
    public InputParams O0000Oo0;
    public O0000Oo O0000OoO;

    public static class O000000o implements Parcelable.Creator<CircleParams> {
        public final Object createFromParcel(Parcel parcel) {
            return new CircleParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new CircleParams[i];
        }
    }

    public CircleParams() {
    }

    public CircleParams(Parcel parcel) {
        this.O00000Oo = (DialogParams) parcel.readParcelable(DialogParams.class.getClassLoader());
        this.O00000o0 = (TitleParams) parcel.readParcelable(TitleParams.class.getClassLoader());
        this.O00000o = (TextParams) parcel.readParcelable(TextParams.class.getClassLoader());
        this.O00000oO = (ButtonParams) parcel.readParcelable(ButtonParams.class.getClassLoader());
        this.O00000oo = (ButtonParams) parcel.readParcelable(ButtonParams.class.getClassLoader());
        this.O0000O0o = (ItemsParams) parcel.readParcelable(ItemsParams.class.getClassLoader());
        this.O0000OOo = (ProgressParams) parcel.readParcelable(ProgressParams.class.getClassLoader());
        this.O0000Oo0 = (InputParams) parcel.readParcelable(InputParams.class.getClassLoader());
        this.O0000Oo = parcel.readInt();
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.O00000Oo, i);
        parcel.writeParcelable(this.O00000o0, i);
        parcel.writeParcelable(this.O00000o, i);
        parcel.writeParcelable(this.O00000oO, i);
        parcel.writeParcelable(this.O00000oo, i);
        parcel.writeParcelable(this.O0000O0o, i);
        parcel.writeParcelable(this.O0000OOo, i);
        parcel.writeParcelable(this.O0000Oo0, i);
        parcel.writeInt(this.O0000Oo);
    }
}

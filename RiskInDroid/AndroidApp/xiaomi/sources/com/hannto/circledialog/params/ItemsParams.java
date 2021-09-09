package com.hannto.circledialog.params;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.AdapterView;

public class ItemsParams implements Parcelable {
    public static final Parcelable.Creator<ItemsParams> CREATOR = new O000000o();
    public O00000Oo O00000Oo;
    public int O00000o = 156;
    public AdapterView.OnItemClickListener O00000o0;
    public int[] O00000oO;
    public Object O00000oo;
    public int O0000O0o;
    public int O0000OOo = -16777216;
    public int O0000Oo;
    public int O0000Oo0 = 42;

    public static class O000000o implements Parcelable.Creator<ItemsParams> {
        public final Object createFromParcel(Parcel parcel) {
            return new ItemsParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new ItemsParams[i];
        }
    }

    public interface O00000Oo {
        String O000000o();
    }

    public ItemsParams() {
    }

    public ItemsParams(Parcel parcel) {
        this.O00000o = parcel.readInt();
        this.O00000oO = parcel.createIntArray();
        this.O0000O0o = parcel.readInt();
        this.O0000OOo = parcel.readInt();
        this.O0000Oo0 = parcel.readInt();
    }

    public void O000000o() {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.O00000o);
        parcel.writeIntArray(this.O00000oO);
        parcel.writeInt(this.O0000O0o);
        parcel.writeInt(this.O0000OOo);
        parcel.writeInt(this.O0000Oo0);
    }
}

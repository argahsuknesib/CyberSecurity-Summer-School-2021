package com.ximalaya.ting.android.opensdk.model.history;

import android.os.Parcel;
import android.os.Parcelable;
import com.ximalaya.ting.android.opensdk.model.live.radio.Radio;
import com.ximalaya.ting.android.opensdk.model.track.Track;

public class HistoryModel implements Parcelable {
    public static final Parcelable.Creator<HistoryModel> CREATOR = new Parcelable.Creator<HistoryModel>() {
        /* class com.ximalaya.ting.android.opensdk.model.history.HistoryModel.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new HistoryModel[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new HistoryModel(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public boolean f12176O000000o;
    private Track O00000Oo;
    private long O00000o;
    private Radio O00000o0;
    private boolean O00000oO;
    private boolean O00000oo;
    private long O0000O0o;
    private int O0000OOo;
    @Deprecated
    private String O0000Oo;
    private String O0000Oo0;
    private int O0000OoO;
    private long O0000Ooo;
    private long O0000o;
    private int O0000o0;
    private long O0000o00;
    private int O0000o0O;
    private long O0000o0o;
    private boolean O0000oO0;

    public int describeContents() {
        return 0;
    }

    protected HistoryModel(Parcel parcel) {
        boolean z = true;
        this.f12176O000000o = parcel.readByte() != 0;
        this.O00000Oo = (Track) parcel.readParcelable(Track.class.getClassLoader());
        this.O00000o0 = (Radio) parcel.readParcelable(Radio.class.getClassLoader());
        this.O00000o = parcel.readLong();
        this.O00000oO = parcel.readByte() != 0;
        this.O00000oo = parcel.readByte() != 0;
        this.O0000O0o = parcel.readLong();
        this.O0000OOo = parcel.readInt();
        this.O0000Oo0 = parcel.readString();
        this.O0000Oo = parcel.readString();
        this.O0000OoO = parcel.readInt();
        this.O0000Ooo = parcel.readLong();
        this.O0000o00 = parcel.readLong();
        this.O0000o0 = parcel.readInt();
        this.O0000o0O = parcel.readInt();
        this.O0000o0o = parcel.readLong();
        this.O0000o = parcel.readLong();
        this.O0000oO0 = parcel.readByte() == 0 ? false : z;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.f12176O000000o ? (byte) 1 : 0);
        parcel.writeParcelable(this.O00000Oo, i);
        parcel.writeParcelable(this.O00000o0, i);
        parcel.writeLong(this.O00000o);
        parcel.writeByte(this.O00000oO ? (byte) 1 : 0);
        parcel.writeByte(this.O00000oo ? (byte) 1 : 0);
        parcel.writeLong(this.O0000O0o);
        parcel.writeInt(this.O0000OOo);
        parcel.writeString(this.O0000Oo0);
        parcel.writeString(this.O0000Oo);
        parcel.writeInt(this.O0000OoO);
        parcel.writeLong(this.O0000Ooo);
        parcel.writeLong(this.O0000o00);
        parcel.writeInt(this.O0000o0);
        parcel.writeInt(this.O0000o0O);
        parcel.writeLong(this.O0000o0o);
        parcel.writeLong(this.O0000o);
        parcel.writeByte(this.O0000oO0 ? (byte) 1 : 0);
    }
}

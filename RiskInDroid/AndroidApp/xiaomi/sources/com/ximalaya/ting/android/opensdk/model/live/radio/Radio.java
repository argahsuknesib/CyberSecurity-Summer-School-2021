package com.ximalaya.ting.android.opensdk.model.live.radio;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.ximalaya.ting.android.opensdk.model.PlayableModel;

public class Radio extends PlayableModel implements Parcelable {
    public static final Parcelable.Creator<Radio> CREATOR = new Parcelable.Creator<Radio>() {
        /* class com.ximalaya.ting.android.opensdk.model.live.radio.Radio.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new Radio[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            Radio radio = new Radio();
            radio.O000000o(parcel);
            return radio;
        }
    };
    @SerializedName("radio_name")
    public String O0000OOo;
    @SerializedName("schedule_id")
    public long O0000Oo;
    @SerializedName("radio_desc")
    public String O0000Oo0;
    @SerializedName("start_time")
    public long O0000OoO;
    @SerializedName("end_time")
    public long O0000Ooo;
    @SerializedName("radio_play_count")
    public int O0000o;
    @SerializedName("rate24_ts_url")
    public String O0000o0;
    @SerializedName("rate24_aac_url")
    public String O0000o00;
    @SerializedName("rate64_aac_url")
    public String O0000o0O;
    @SerializedName("rate64_ts_url")
    public String O0000o0o;
    @SerializedName("cover_url_large")
    public String O0000oO;
    @SerializedName("cover_url_small")
    public String O0000oO0;
    @SerializedName("update_at")
    public long O0000oOO;
    public long O0000oOo;
    public long O0000oo;
    public boolean O0000oo0 = false;
    @SerializedName("program_name")
    private String O0000ooO;
    @SerializedName("support_bitrates")
    private int[] O0000ooo;
    private String O00oOooO;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.O0000OOo);
        parcel.writeString(this.O0000Oo0);
        parcel.writeString(this.O0000ooO);
        parcel.writeLong(this.O0000Oo);
        parcel.writeLong(this.O0000OoO);
        parcel.writeLong(this.O0000Ooo);
        int[] iArr = this.O0000ooo;
        int length = iArr == null ? 0 : iArr.length;
        parcel.writeInt(length);
        if (length > 0) {
            parcel.writeIntArray(this.O0000ooo);
        }
        parcel.writeString(this.O0000o00);
        parcel.writeString(this.O0000o0);
        parcel.writeString(this.O0000o0O);
        parcel.writeString(this.O0000o0o);
        parcel.writeInt(this.O0000o);
        parcel.writeString(this.O0000oO0);
        parcel.writeString(this.O0000oO);
        parcel.writeLong(this.O0000oOo);
        parcel.writeString(this.O00oOooO);
        parcel.writeInt(this.O0000oo0 ? 1 : 0);
        parcel.writeLong(this.O0000oo);
    }

    public final void O000000o(Parcel parcel) {
        super.O000000o(parcel);
        this.O0000OOo = parcel.readString();
        this.O0000Oo0 = parcel.readString();
        this.O0000ooO = parcel.readString();
        this.O0000Oo = parcel.readLong();
        this.O0000OoO = parcel.readLong();
        this.O0000Ooo = parcel.readLong();
        int readInt = parcel.readInt();
        if (readInt > 0) {
            int[] iArr = new int[readInt];
            parcel.readIntArray(iArr);
            this.O0000ooo = iArr;
        }
        this.O0000o00 = parcel.readString();
        this.O0000o0 = parcel.readString();
        this.O0000o0O = parcel.readString();
        this.O0000o0o = parcel.readString();
        this.O0000o = parcel.readInt();
        this.O0000oO0 = parcel.readString();
        this.O0000oO = parcel.readString();
        this.O0000oOo = parcel.readLong();
        this.O00oOooO = parcel.readString();
        this.O0000oo0 = parcel.readInt() != 0;
        this.O0000oo = parcel.readLong();
    }
}

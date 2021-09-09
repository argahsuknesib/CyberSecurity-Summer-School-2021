package com.ximalaya.ting.android.opensdk.model.live.program;

import _m_j.ijs;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

public class Program implements Parcelable {
    public static final Parcelable.Creator<Program> CREATOR = new Parcelable.Creator<Program>() {
        /* class com.ximalaya.ting.android.opensdk.model.live.program.Program.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new Program[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            Program program = new Program();
            program.f12177O000000o = parcel.readLong();
            program.O00000Oo = parcel.readString();
            program.O00000o0 = parcel.readString();
            int readInt = parcel.readInt();
            if (readInt > 0) {
                int[] iArr = new int[readInt];
                parcel.readIntArray(iArr);
                program.O00000o = iArr;
            }
            program.O00000oO = parcel.readString();
            program.O00000oo = parcel.readString();
            program.O0000O0o = parcel.readString();
            program.O0000OOo = parcel.readString();
            ArrayList arrayList = new ArrayList();
            parcel.readList(arrayList, ijs.class.getClassLoader());
            program.O0000Oo0 = arrayList;
            program.O0000Oo = (long) parcel.readInt();
            return program;
        }
    };
    @SerializedName("id")

    /* renamed from: O000000o  reason: collision with root package name */
    public long f12177O000000o;
    @SerializedName("program_name")
    public String O00000Oo;
    @SerializedName("support_bitrates")
    int[] O00000o;
    @SerializedName("back_pic_url")
    public String O00000o0;
    @SerializedName("rate24_aac_url")
    public String O00000oO;
    @SerializedName("rate24_ts_url")
    public String O00000oo;
    @SerializedName("rate64_aac_url")
    public String O0000O0o;
    @SerializedName("rate64_ts_url")
    public String O0000OOo;
    @SerializedName("update_at")
    long O0000Oo;
    @SerializedName("live_announcers")
    public List<ijs> O0000Oo0;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f12177O000000o);
        parcel.writeString(this.O00000Oo);
        parcel.writeString(this.O00000o0);
        int[] iArr = this.O00000o;
        int length = iArr == null ? 0 : iArr.length;
        parcel.writeInt(length);
        if (length > 0) {
            parcel.writeIntArray(this.O00000o);
        }
        parcel.writeString(this.O00000oO);
        parcel.writeString(this.O00000oo);
        parcel.writeString(this.O0000O0o);
        parcel.writeString(this.O0000OOo);
        parcel.writeList(this.O0000Oo0);
        parcel.writeLong(this.O0000Oo);
    }
}

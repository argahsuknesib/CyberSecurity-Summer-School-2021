package com.ximalaya.ting.android.opensdk.model.live.schedule;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.ximalaya.ting.android.opensdk.model.PlayableModel;
import com.ximalaya.ting.android.opensdk.model.live.program.Program;

public class Schedule extends PlayableModel implements Parcelable {
    public static final Parcelable.Creator<Schedule> CREATOR = new Parcelable.Creator<Schedule>() {
        /* class com.ximalaya.ting.android.opensdk.model.live.schedule.Schedule.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new Schedule[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            Schedule schedule = new Schedule();
            schedule.O000000o(parcel);
            return schedule;
        }
    };
    @SerializedName("start_time")
    public String O0000OOo;
    @SerializedName("related_program")
    public Program O0000Oo;
    @SerializedName("end_time")
    public String O0000Oo0;
    @SerializedName("update_at")
    public long O0000OoO;
    @SerializedName("listen_back_url")
    public String O0000Ooo;
    public String O0000o0;
    @SerializedName("radio_id")
    public long O0000o00;
    public int O0000o0O;
    @SerializedName("play_type")
    private int O0000o0o;

    public int describeContents() {
        return 0;
    }

    public final void O000000o(Parcel parcel) {
        super.O000000o(parcel);
        this.O0000OOo = parcel.readString();
        this.O0000Oo0 = parcel.readString();
        this.O0000o00 = parcel.readLong();
        this.O0000o0 = parcel.readString();
        this.O0000Oo = (Program) parcel.readParcelable(Schedule.class.getClassLoader());
        this.O0000o0O = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.O0000OOo);
        parcel.writeString(this.O0000Oo0);
        parcel.writeLong(this.O0000o00);
        parcel.writeParcelable(this.O0000Oo, 0);
        parcel.writeString(this.O0000o0);
        parcel.writeInt(this.O0000o0O);
    }
}

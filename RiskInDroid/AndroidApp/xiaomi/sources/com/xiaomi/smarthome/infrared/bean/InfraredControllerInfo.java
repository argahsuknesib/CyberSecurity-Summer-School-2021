package com.xiaomi.smarthome.infrared.bean;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

public class InfraredControllerInfo implements Parcelable {
    public static final Parcelable.Creator<InfraredControllerInfo> CREATOR = new Parcelable.Creator<InfraredControllerInfo>() {
        /* class com.xiaomi.smarthome.infrared.bean.InfraredControllerInfo.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new InfraredControllerInfo[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new InfraredControllerInfo(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public String f9040O000000o;
    public String O00000Oo;
    public IRType O00000o;
    public String O00000o0;
    public String O00000oO;
    public String O00000oo;
    public IRFunctionType O0000O0o;
    public String O0000OOo;
    public List<IRKeyValue> O0000Oo;
    public String O0000Oo0;
    private String O0000OoO;
    private String O0000Ooo;
    private String O0000o0;
    private String O0000o00;
    private int O0000o0O;

    public int describeContents() {
        return 0;
    }

    public InfraredControllerInfo() {
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f9040O000000o);
        parcel.writeString(this.O00000Oo);
        parcel.writeString(this.O00000o0);
        parcel.writeString(this.O0000OoO);
        IRType iRType = this.O00000o;
        int i2 = -1;
        parcel.writeInt(iRType == null ? -1 : iRType.ordinal());
        parcel.writeString(this.O00000oO);
        parcel.writeString(this.O00000oo);
        IRFunctionType iRFunctionType = this.O0000O0o;
        if (iRFunctionType != null) {
            i2 = iRFunctionType.ordinal();
        }
        parcel.writeInt(i2);
        parcel.writeString(this.O0000OOo);
        parcel.writeString(this.O0000Ooo);
        parcel.writeString(this.O0000o00);
        parcel.writeString(this.O0000o0);
        parcel.writeString(this.O0000Oo0);
        parcel.writeInt(this.O0000o0O);
        parcel.writeTypedList(this.O0000Oo);
    }

    protected InfraredControllerInfo(Parcel parcel) {
        IRType iRType;
        this.f9040O000000o = parcel.readString();
        this.O00000Oo = parcel.readString();
        this.O00000o0 = parcel.readString();
        this.O0000OoO = parcel.readString();
        int readInt = parcel.readInt();
        IRFunctionType iRFunctionType = null;
        if (readInt == -1) {
            iRType = null;
        } else {
            iRType = IRType.values()[readInt];
        }
        this.O00000o = iRType;
        this.O00000oO = parcel.readString();
        this.O00000oo = parcel.readString();
        int readInt2 = parcel.readInt();
        this.O0000O0o = readInt2 != -1 ? IRFunctionType.values()[readInt2] : iRFunctionType;
        this.O0000OOo = parcel.readString();
        this.O0000Ooo = parcel.readString();
        this.O0000o00 = parcel.readString();
        this.O0000o0 = parcel.readString();
        this.O0000Oo0 = parcel.readString();
        this.O0000o0O = parcel.readInt();
        this.O0000Oo = parcel.createTypedArrayList(IRKeyValue.CREATOR);
    }
}

package com.qti.geofence;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

public class GeofenceData implements Parcelable {
    public static final Parcelable.Creator<GeofenceData> CREATOR = new Parcelable.Creator<GeofenceData>() {
        /* class com.qti.geofence.GeofenceData.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new GeofenceData[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new GeofenceData(parcel);
        }
    };
    private static String O0000Ooo = "GeofenceData";
    private static final boolean O0000o00 = Log.isLoggable("GeofenceData", 2);

    /* renamed from: O000000o  reason: collision with root package name */
    public int f5436O000000o;
    public double O00000Oo;
    public double O00000o;
    public double O00000o0;
    public GeofenceTransitionTypes O00000oO;
    public GeofenceConfidence O00000oo;
    public DwellTypes O0000O0o;
    public int O0000OOo;
    public Bundle O0000Oo;
    public String O0000Oo0;
    public int O0000OoO;
    private boolean O0000o0;

    public int describeContents() {
        return 0;
    }

    public enum GeofenceTransitionTypes {
        UNKNOWN(0),
        ENTERED_ONLY(1),
        EXITED_ONLY(2),
        ENTERED_AND_EXITED(3);
        
        private final int mValue;

        private GeofenceTransitionTypes(int i) {
            this.mValue = i;
        }

        public final int getValue() {
            return this.mValue;
        }
    }

    public enum GeofenceConfidence {
        LOW(1),
        MEDIUM(2),
        HIGH(3);
        
        private final int mValue;

        private GeofenceConfidence(int i) {
            this.mValue = i;
        }

        public final int getValue() {
            return this.mValue;
        }
    }

    public enum DwellTypes {
        UNKNOWN(0),
        DWELL_TYPE_INSIDE(1),
        DWELL_TYPE_OUTSIDE(2),
        DWELL_TYPE_INSIDE_OUTSIDE(3);
        
        private final int mValue;

        private DwellTypes(int i) {
            this.mValue = i;
        }

        public final int getValue() {
            return this.mValue;
        }
    }

    public GeofenceData(Parcel parcel) {
        this.f5436O000000o = parcel.readInt();
        this.O00000Oo = parcel.readDouble();
        this.O00000o0 = parcel.readDouble();
        this.O00000o = parcel.readDouble();
        try {
            this.O00000oO = GeofenceTransitionTypes.valueOf(parcel.readString());
        } catch (IllegalArgumentException unused) {
            this.O00000oO = null;
        }
        try {
            this.O00000oo = GeofenceConfidence.valueOf(parcel.readString());
        } catch (IllegalArgumentException unused2) {
            this.O00000oo = null;
        }
        try {
            this.O0000O0o = DwellTypes.valueOf(parcel.readString());
        } catch (IllegalArgumentException unused3) {
            this.O0000O0o = null;
        }
        this.O0000OOo = parcel.readInt();
        try {
            this.O0000Oo0 = parcel.readString();
        } catch (IllegalArgumentException unused4) {
            this.O0000Oo0 = null;
        }
        this.O0000Oo = parcel.readBundle();
        this.O0000OoO = parcel.readInt();
        this.O0000o0 = parcel.readBoolean();
    }

    public GeofenceData(int i, double d, double d2, double d3, int i2, int i3, int i4, int i5, String str, Bundle bundle) {
        this.f5436O000000o = i;
        this.O00000Oo = d;
        this.O00000o0 = d2;
        this.O00000o = d3;
        O000000o(i2);
        O00000Oo(i3);
        O00000o0(i4);
        this.O0000OOo = i5;
        this.O0000Oo0 = str;
        this.O0000Oo = null;
        this.O0000OoO = -1;
        this.O0000o0 = false;
    }

    private void O000000o(int i) {
        this.O00000oO = GeofenceTransitionTypes.UNKNOWN;
        for (GeofenceTransitionTypes geofenceTransitionTypes : GeofenceTransitionTypes.values()) {
            if (geofenceTransitionTypes.getValue() == i) {
                this.O00000oO = geofenceTransitionTypes;
                return;
            }
        }
    }

    private void O00000Oo(int i) {
        this.O00000oo = GeofenceConfidence.LOW;
        for (GeofenceConfidence geofenceConfidence : GeofenceConfidence.values()) {
            if (geofenceConfidence.getValue() == i) {
                this.O00000oo = geofenceConfidence;
                return;
            }
        }
    }

    private void O00000o0(int i) {
        this.O0000O0o = DwellTypes.UNKNOWN;
        for (DwellTypes dwellTypes : DwellTypes.values()) {
            if (dwellTypes.getValue() == i) {
                this.O0000O0o = dwellTypes;
                return;
            }
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (O0000o00) {
            String str = O0000Ooo;
            int i2 = this.f5436O000000o;
            double d = this.O00000Oo;
            double d2 = this.O00000o0;
            double d3 = this.O00000o;
            String name = this.O00000oO.name();
            String name2 = this.O00000oo.name();
            String name3 = this.O0000O0o.name();
            int i3 = this.O0000OOo;
            String str2 = this.O0000Oo0;
            int i4 = this.O0000OoO;
            Log.v(str, "in GeofenceData: writeToParcel(); responsiveness is " + i2 + "; latitude is " + d + "; longitude is " + d2 + "; radius is " + d3 + "; transitionTypes is " + name + "; confidence is " + name2 + "; dwellTimeMask is " + name3 + "; dwellTime is " + i3 + "; AppTextData is " + str2 + "; Geofence id is " + i4);
        }
        Parcel parcel2 = parcel;
        parcel2.writeInt(this.f5436O000000o);
        parcel2.writeDouble(this.O00000Oo);
        parcel2.writeDouble(this.O00000o0);
        parcel2.writeDouble(this.O00000o);
        GeofenceTransitionTypes geofenceTransitionTypes = this.O00000oO;
        String str3 = "";
        parcel2.writeString(geofenceTransitionTypes == null ? str3 : geofenceTransitionTypes.name());
        GeofenceConfidence geofenceConfidence = this.O00000oo;
        parcel2.writeString(geofenceConfidence == null ? str3 : geofenceConfidence.name());
        DwellTypes dwellTypes = this.O0000O0o;
        if (dwellTypes != null) {
            str3 = dwellTypes.name();
        }
        parcel2.writeString(str3);
        parcel2.writeInt(this.O0000OOo);
        parcel2.writeString(this.O0000Oo0);
        parcel2.writeBundle(this.O0000Oo);
        parcel2.writeInt(this.O0000OoO);
        parcel2.writeBoolean(this.O0000o0);
    }

    public String toString() {
        int i = this.f5436O000000o;
        double d = this.O00000Oo;
        double d2 = this.O00000o0;
        double d3 = this.O00000o;
        String name = this.O00000oO.name();
        String name2 = this.O00000oo.name();
        String name3 = this.O0000O0o.name();
        int i2 = this.O0000OOo;
        String str = this.O0000Oo0;
        int i3 = this.O0000OoO;
        return "in GeofenceData: toString responsiveness is " + i + "; latitude is " + d + "; longitude is " + d2 + "; radius is " + d3 + "; transitionTypes is " + name + "; confidence is " + name2 + "; dwellTimeMask is " + name3 + "; dwellTime is " + i2 + "; AppTextData is " + str + "; Geofence id is " + i3;
    }
}

package com.xiaomi.smarthome.scene.activity;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

public final class CommonSceneOnline {

    /* renamed from: O000000o  reason: collision with root package name */
    public String f10655O000000o;
    public String O00000Oo;
    public ArrayList<O00000Oo> O00000o = new ArrayList<>();
    public String O00000o0;
    public ArrayList<O000000o> O00000oO = new ArrayList<>();
    public ArrayList<O00000o0> O00000oo = new ArrayList<>();
    public ArrayList<O00000o0> O0000O0o = new ArrayList<>();

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f10657O000000o;
        public int O00000Oo;
        public String O00000o;
        public int O00000o0 = -1;
        public String O00000oO;
        public Object O00000oo;
        public String O0000O0o;
        public int O0000OOo;
        public boolean O0000Oo = false;
        public O00000o O0000Oo0;
    }

    public static class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f10658O000000o;
        public int O00000Oo;
        public int O00000o = -1;
        public int O00000o0 = -1;
        public String O00000oO;
        public String O00000oo;
        public Object O0000O0o;
        public String O0000OOo;
        public boolean O0000Oo = false;
        public O00000o O0000Oo0;
    }

    public static class O00000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public int f10659O000000o;
    }

    public static class O00000o0 {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f10660O000000o;
        public int O00000Oo;
    }

    public static class O0000O0o extends O00000o {
        public float O00000Oo;
        public float O00000o;
        public float O00000o0;
        public String O00000oO;
        public String O00000oo;
        public String O0000O0o;
    }

    public static class O0000OOo extends O00000o {
        public float O00000Oo;
        public float O00000o;
        public float O00000o0;
        public String O00000oO;
        public String O00000oo;
        public String O0000O0o;
        public float O0000OOo;
        public ArrayList<NumberPickerTag> O0000Oo0 = new ArrayList<>();
    }

    public static class NumberPickerTag implements Parcelable {
        public static final Parcelable.Creator<NumberPickerTag> CREATOR = new Parcelable.Creator<NumberPickerTag>() {
            /* class com.xiaomi.smarthome.scene.activity.CommonSceneOnline.NumberPickerTag.AnonymousClass1 */

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new NumberPickerTag[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new NumberPickerTag(parcel);
            }
        };

        /* renamed from: O000000o  reason: collision with root package name */
        public float f10656O000000o;
        public float O00000Oo;
        public String O00000o0;

        public int describeContents() {
            return 0;
        }

        public NumberPickerTag() {
        }

        protected NumberPickerTag(Parcel parcel) {
            this.f10656O000000o = parcel.readFloat();
            this.O00000Oo = parcel.readFloat();
            this.O00000o0 = parcel.readString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeFloat(this.f10656O000000o);
            parcel.writeFloat(this.O00000Oo);
            parcel.writeString(this.O00000o0);
        }
    }
}

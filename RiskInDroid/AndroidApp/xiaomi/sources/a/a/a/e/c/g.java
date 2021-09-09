package a.a.a.e.c;

import _m_j.ooooooo;
import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONObject;

public class g implements Parcelable {
    public static final Parcelable.Creator<g> CREATOR = new O000000o();
    public int O00000o;
    public int O00000o0;
    public int O00000oO;
    public int O00000oo;
    public int O0000O0o;
    public int O0000OOo;
    public String O0000Oo;
    public String O0000Oo0;
    public String O0000OoO;
    public String O0000Ooo;
    public int O0000o;
    public String O0000o0;
    public String O0000o00;
    public String O0000o0O;
    public int O0000o0o;
    public int O0000oO0;

    public g(Parcel parcel) {
        this.O00000o0 = parcel.readInt();
        this.O00000o = parcel.readInt();
        this.O00000oO = parcel.readInt();
        this.O0000O0o = parcel.readInt();
        this.O00000oo = parcel.readInt();
        this.O0000OOo = parcel.readInt();
        this.O0000Oo0 = parcel.readString();
        this.O0000Oo = parcel.readString();
        this.O0000OoO = parcel.readString();
        this.O0000Ooo = parcel.readString();
        this.O0000o00 = parcel.readString();
        this.O0000o0 = parcel.readString();
        this.O0000o0O = parcel.readString();
        this.O0000o0o = parcel.readInt();
        this.O0000o = parcel.readInt();
        this.O0000oO0 = parcel.readInt();
    }

    public g(JSONObject jSONObject) {
        this.O0000Oo0 = jSONObject.getString("tid");
        this.O0000Oo = jSONObject.optString("tt");
        this.O0000OoO = jSONObject.optString("tm");
        this.O0000Ooo = jSONObject.optString("ht");
        this.O00000o0 = jSONObject.optInt("tp");
        this.O00000oo = jSONObject.optInt("epb");
        this.O0000o0 = jSONObject.optString("pbt");
        this.O0000O0o = jSONObject.optInt("enb");
        this.O0000o00 = jSONObject.optString("nbt");
        this.O00000o = jSONObject.optInt("td", 3);
        this.O00000oO = jSONObject.optInt("trd", 2);
        this.O0000o0O = jSONObject.optString("ed");
        O000000o(this.O0000o0O);
    }

    public ooooooo O000000o() {
        return new ooooooo();
    }

    public void O000000o(String str) {
    }

    public final boolean O00000Oo() {
        return this.O00000oo == 1;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.O00000o0);
        parcel.writeInt(this.O00000o);
        parcel.writeInt(this.O00000oO);
        parcel.writeInt(this.O0000O0o);
        parcel.writeInt(this.O00000oo);
        parcel.writeInt(this.O0000OOo);
        parcel.writeString(this.O0000Oo0);
        parcel.writeString(this.O0000Oo);
        parcel.writeString(this.O0000OoO);
        parcel.writeString(this.O0000Ooo);
        parcel.writeString(this.O0000o00);
        parcel.writeString(this.O0000o0);
        parcel.writeString(this.O0000o0O);
        parcel.writeInt(this.O0000o0o);
        parcel.writeInt(this.O0000o);
        parcel.writeInt(this.O0000oO0);
    }

    public class O000000o implements Parcelable.Creator<g> {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new g[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new g(parcel);
        }
    }
}

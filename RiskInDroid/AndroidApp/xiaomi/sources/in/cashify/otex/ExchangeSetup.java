package in.cashify.otex;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONObject;

public class ExchangeSetup implements Parcelable {
    public static final Parcelable.Creator<ExchangeSetup> CREATOR = new O000000o();

    /* renamed from: O000000o  reason: collision with root package name */
    public String f12265O000000o = "___otex_current";
    public int O00000Oo;
    public double O00000o;
    public String O00000o0;
    public int O00000oO;

    public ExchangeSetup() {
    }

    public ExchangeSetup(Parcel parcel) {
        this.f12265O000000o = parcel.readString();
        this.O00000Oo = parcel.readInt();
        this.O00000o0 = parcel.readString();
        this.O00000o = parcel.readDouble();
        this.O00000oO = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f12265O000000o);
        parcel.writeInt(this.O00000Oo);
        parcel.writeString(this.O00000o0);
        parcel.writeDouble(this.O00000o);
        parcel.writeInt(this.O00000oO);
    }

    public class O000000o implements Parcelable.Creator<ExchangeSetup> {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ExchangeSetup[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new ExchangeSetup(parcel);
        }
    }

    public final void O000000o(JSONObject jSONObject) {
        jSONObject.put("em", this.f12265O000000o);
        jSONObject.put("pc", this.O00000Oo);
        jSONObject.put("ndi", this.O00000o0);
        jSONObject.put("ndp", this.O00000o);
        jSONObject.put("daid", this.O00000oO);
    }
}

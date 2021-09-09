package a.a.a.e.c;

import _m_j.O0OoOo;
import _m_j.ooooooo;
import android.os.Parcel;
import android.os.Parcelable;
import com.xiaomi.smarthome.R;
import org.json.JSONObject;

public class l extends g {
    public static final Parcelable.Creator<l> CREATOR = new O000000o();

    /* renamed from: O000000o  reason: collision with root package name */
    public int f2617O000000o;
    public int O00000Oo;
    public int O0000oO;
    public String O0000oOO;
    public String O0000oOo;

    public l(Parcel parcel) {
        super(parcel);
        this.f2617O000000o = parcel.readInt();
        this.O00000Oo = parcel.readInt();
        this.O0000oO = parcel.readInt();
    }

    public final ooooooo O000000o() {
        return O0OoOo.O000000o(this);
    }

    public final void O000000o(String str) {
        super.O000000o(str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f2617O000000o = jSONObject.optInt("ssd", 1);
            this.O00000Oo = jSONObject.optInt("sas", 3);
            this.O0000oO = jSONObject.optInt("sa", 100);
            this.O0000oOO = jSONObject.optString("am", "");
            this.O0000oOo = jSONObject.optString("pam", "");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.f2617O000000o);
        parcel.writeInt(this.O00000Oo);
        parcel.writeInt(this.O0000oO);
    }

    public class O000000o implements Parcelable.Creator<l> {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new l[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new l(parcel);
        }
    }

    public l(JSONObject jSONObject) {
        super(jSONObject);
        this.O0000o0o = R.drawable.ic_volume;
        this.O0000o = R.drawable.ic_volume;
        this.O0000oO0 = R.drawable.ic_volume_s;
    }
}

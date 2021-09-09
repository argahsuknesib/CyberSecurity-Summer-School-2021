package a.a.a.e.c;

import _m_j.O0O0O;
import _m_j.ooooooo;
import android.os.Parcel;
import android.os.Parcelable;
import com.xiaomi.smarthome.R;
import org.json.JSONObject;

public class p extends g {
    public static final Parcelable.Creator<p> CREATOR = new O000000o();

    /* renamed from: O000000o  reason: collision with root package name */
    public int f2620O000000o;

    public p(Parcel parcel) {
        super(parcel);
        this.f2620O000000o = parcel.readInt();
    }

    public final ooooooo O000000o() {
        return O0O0O.O000000o(this);
    }

    public final void O000000o(String str) {
        super.O000000o(str);
        try {
            this.f2620O000000o = new JSONObject(str).optInt("mi");
        } catch (Throwable unused) {
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.f2620O000000o);
    }

    public class O000000o implements Parcelable.Creator<p> {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new p[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new p(parcel);
        }
    }

    public p(JSONObject jSONObject) {
        super(jSONObject);
        this.O0000o0o = R.drawable.ic_wifi;
        this.O0000o = R.drawable.ic_wifi;
        this.O0000oO0 = R.drawable.ic_wifi_s;
    }
}

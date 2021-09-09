package a.a.a.e.c;

import _m_j.O0O00o;
import _m_j.ooooooo;
import android.os.Parcel;
import android.os.Parcelable;
import com.xiaomi.smarthome.R;
import org.json.JSONObject;

public class h extends g {
    public static final Parcelable.Creator<h> CREATOR = new O000000o();

    /* renamed from: O000000o  reason: collision with root package name */
    public int f2614O000000o;

    public h(Parcel parcel) {
        super(parcel);
        this.f2614O000000o = parcel.readInt();
    }

    public final ooooooo O000000o() {
        return O0O00o.O000000o(this);
    }

    public final void O000000o(String str) {
        try {
            this.f2614O000000o = new JSONObject(str).optInt("mi");
        } catch (Throwable unused) {
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.f2614O000000o);
    }

    public class O000000o implements Parcelable.Creator<h> {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new h[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new h(parcel);
        }
    }

    public h(JSONObject jSONObject) {
        super(jSONObject);
        this.O0000o0o = R.drawable.ic_gps;
        this.O0000o = R.drawable.ic_gps;
        this.O0000oO0 = R.drawable.ic_gps_s;
    }
}

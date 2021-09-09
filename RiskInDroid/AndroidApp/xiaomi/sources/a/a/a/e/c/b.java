package a.a.a.e.c;

import _m_j.O0O00oO;
import _m_j.ooooooo;
import android.os.Parcel;
import android.os.Parcelable;
import com.xiaomi.smarthome.R;
import org.json.JSONObject;

public class b extends g {
    public static final Parcelable.Creator<b> CREATOR = new O000000o();

    public b(Parcel parcel) {
        super(parcel);
    }

    public final ooooooo O000000o() {
        return O0O00oO.O000000o(this);
    }

    public int describeContents() {
        return 0;
    }

    public class O000000o implements Parcelable.Creator<b> {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new b[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new b(parcel);
        }
    }

    public b(JSONObject jSONObject) {
        super(jSONObject);
        this.O0000o0o = R.drawable.ic_battery;
        this.O0000o = R.drawable.ic_battery;
        this.O0000oO0 = R.drawable.ic_battery_s;
    }
}

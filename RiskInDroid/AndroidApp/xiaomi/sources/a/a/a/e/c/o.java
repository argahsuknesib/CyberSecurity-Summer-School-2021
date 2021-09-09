package a.a.a.e.c;

import _m_j.O0OO00O;
import _m_j.ooooooo;
import android.os.Parcel;
import android.os.Parcelable;
import com.xiaomi.smarthome.R;
import org.json.JSONObject;

public class o extends g {
    public static final Parcelable.Creator<o> CREATOR = new O000000o();

    public o(Parcel parcel) {
        super(parcel);
    }

    public final ooooooo O000000o() {
        return O0OO00O.O000000o(this);
    }

    public int describeContents() {
        return 0;
    }

    public class O000000o implements Parcelable.Creator<o> {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new o[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new o(parcel);
        }
    }

    public o(JSONObject jSONObject) {
        super(jSONObject);
        this.O0000o = R.drawable.ic_volume_button_1;
        this.O0000oO0 = R.drawable.ic_vol_button_s;
    }
}

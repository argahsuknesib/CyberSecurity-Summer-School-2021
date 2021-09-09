package a.a.a.e.c;

import _m_j.O0O0o0;
import _m_j.ooooooo;
import android.os.Parcel;
import android.os.Parcelable;
import com.xiaomi.smarthome.R;
import org.json.JSONObject;

public class k extends g {
    public static final Parcelable.Creator<k> CREATOR = new O000000o();

    public k(Parcel parcel) {
        super(parcel);
    }

    public final ooooooo O000000o() {
        return O0O0o0.O000000o(this);
    }

    public int describeContents() {
        return 0;
    }

    public class O000000o implements Parcelable.Creator<k> {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new k[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new k(parcel);
        }
    }

    public k(JSONObject jSONObject) {
        super(jSONObject);
        this.O0000o0o = R.drawable.ic_proximity;
        this.O0000o = R.drawable.ic_proximity;
        this.O0000oO0 = R.drawable.ic_proximity_s;
    }
}

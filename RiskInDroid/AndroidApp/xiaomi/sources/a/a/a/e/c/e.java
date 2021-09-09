package a.a.a.e.c;

import _m_j.ooooooo;
import android.os.Parcel;
import android.os.Parcelable;
import com.xiaomi.smarthome.R;
import in.cashify.otex.diagnose.semi.ChargerDiagnoseFragment;
import org.json.JSONObject;

public class e extends g {
    public static final Parcelable.Creator<e> CREATOR = new O000000o();

    public e(Parcel parcel) {
        super(parcel);
    }

    public final ooooooo O000000o() {
        return ChargerDiagnoseFragment.O000000o(this);
    }

    public int describeContents() {
        return 0;
    }

    public class O000000o implements Parcelable.Creator<e> {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new e[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new e(parcel);
        }
    }

    public e(JSONObject jSONObject) {
        super(jSONObject);
        this.O0000o0o = R.drawable.ic_charger;
        this.O0000o = R.drawable.ic_charger;
        this.O0000oO0 = R.drawable.ic_charger_s;
    }
}

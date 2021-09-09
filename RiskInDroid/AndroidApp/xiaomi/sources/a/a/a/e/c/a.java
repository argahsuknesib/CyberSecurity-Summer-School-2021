package a.a.a.e.c;

import _m_j.ooooooo;
import android.os.Parcel;
import android.os.Parcelable;
import com.xiaomi.smarthome.R;
import org.json.JSONObject;

public class a extends g {
    public static final Parcelable.Creator<a> CREATOR = new O000000o();

    public a(Parcel parcel) {
        super(parcel);
    }

    public final ooooooo O000000o() {
        return a.a.a.e.e.a.O000000o(this);
    }

    public int describeContents() {
        return 0;
    }

    public class O000000o implements Parcelable.Creator<a> {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new a[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new a(parcel);
        }
    }

    public a(JSONObject jSONObject) {
        super(jSONObject);
        this.O0000o0o = R.drawable.ic_audio;
        this.O0000o = R.drawable.ic_audio;
        this.O0000oO0 = R.drawable.ic_audio_s;
    }
}

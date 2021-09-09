package a.a.a.e.c;

import _m_j.O0O0O0o;
import _m_j.ooooooo;
import android.os.Parcel;
import android.os.Parcelable;
import com.xiaomi.smarthome.R;
import org.json.JSONObject;

public class j extends g {
    public static final Parcelable.Creator<j> CREATOR = new O000000o();

    /* renamed from: O000000o  reason: collision with root package name */
    public int f2616O000000o;

    public j(Parcel parcel) {
        super(parcel);
        this.f2616O000000o = parcel.readInt();
    }

    public final ooooooo O000000o() {
        return O0O0O0o.O000000o(this);
    }

    public final void O000000o(String str) {
        try {
            this.f2616O000000o = new JSONObject(str).optInt("ma", 65);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.f2616O000000o);
    }

    public class O000000o implements Parcelable.Creator<j> {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new j[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new j(parcel);
        }
    }

    public j(JSONObject jSONObject) {
        super(jSONObject);
        this.O0000o = R.drawable.ic_mic1;
        this.O0000oO0 = R.drawable.ic_mic_s;
    }
}

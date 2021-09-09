package a.a.a.e.c;

import _m_j.O0O0OO0;
import _m_j.ooooooo;
import android.os.Parcel;
import android.os.Parcelable;
import com.xiaomi.smarthome.R;
import org.json.JSONArray;
import org.json.JSONObject;

public class f extends i implements Parcelable {
    public static final Parcelable.Creator<f> CREATOR = new O000000o();

    /* renamed from: O000000o  reason: collision with root package name */
    public long f2613O000000o;
    public int[] O00000Oo;

    public f(Parcel parcel) {
        super(parcel);
        this.f2613O000000o = parcel.readLong();
        this.O00000Oo = parcel.createIntArray();
    }

    public final ooooooo O000000o() {
        return O0O0OO0.O000000o(this);
    }

    public final void O000000o(String str) {
        super.O000000o(str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f2613O000000o = jSONObject.optLong("bdm", 1000);
            JSONArray optJSONArray = jSONObject.optJSONArray("bca");
            if (optJSONArray != null) {
                this.O00000Oo = new int[optJSONArray.length()];
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.O00000Oo[i] = optJSONArray.getInt(i);
                }
                return;
            }
            this.O00000Oo = new int[]{-1, -16777216};
        } catch (Throwable unused) {
            this.f2613O000000o = 1000;
            this.O00000Oo = new int[]{-1, -16777216};
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeLong(this.f2613O000000o);
        parcel.writeIntArray(this.O00000Oo);
    }

    public class O000000o implements Parcelable.Creator<f> {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new f[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new f(parcel);
        }
    }

    public f(JSONObject jSONObject) {
        super(jSONObject);
        this.O0000o0o = R.drawable.ic_dead_pixel;
        this.O0000o = R.drawable.ic_dead_pixel;
        this.O0000oO0 = R.drawable.ic_dead_pixel_s;
    }
}

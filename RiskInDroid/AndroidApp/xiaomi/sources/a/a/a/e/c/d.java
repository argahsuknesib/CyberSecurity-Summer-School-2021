package a.a.a.e.c;

import _m_j.O0O00o0;
import _m_j.ooooooo;
import android.os.Parcel;
import android.os.Parcelable;
import com.xiaomi.smarthome.R;
import in.cashify.otex.ExchangeManager;
import org.json.JSONObject;

public class d extends g {
    public static final Parcelable.Creator<d> CREATOR = new O000000o();

    /* renamed from: O000000o  reason: collision with root package name */
    public double f2612O000000o = 50.0d;
    public int O00000Oo = 65;

    public d(Parcel parcel) {
        super(parcel);
        this.O00000Oo = parcel.readInt();
        this.f2612O000000o = parcel.readDouble();
    }

    public final ooooooo O000000o() {
        return O0O00o0.O000000o(this);
    }

    public final void O000000o(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f2612O000000o = (double) jSONObject.optInt("cd");
            this.O00000Oo = jSONObject.optInt("ca");
        } catch (Exception unused) {
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.O00000Oo);
        parcel.writeDouble(this.f2612O000000o);
    }

    public class O000000o implements Parcelable.Creator<d> {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new d[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new d(parcel);
        }
    }

    public d(JSONObject jSONObject) {
        super(jSONObject);
        this.O0000o = O00000o0();
        this.O0000oO0 = O00000o0();
    }

    private int O00000o0() {
        return this.O0000Oo0.equals(ExchangeManager.h.BACK_CAMERA.a()) ? R.drawable.ic_back_camera_s : R.drawable.ic_front_cam_s;
    }
}

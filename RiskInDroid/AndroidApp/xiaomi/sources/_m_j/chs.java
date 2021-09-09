package _m_j;

import android.text.TextUtils;
import com.xiaomi.smarthome.device.api.DeviceStat;
import org.json.JSONException;
import org.json.JSONObject;

public class chs extends dty {

    /* renamed from: O000000o  reason: collision with root package name */
    protected boolean f13830O000000o;
    protected clk O00000Oo;
    private clm O00000o;
    private cll O00000o0;

    public chs(DeviceStat deviceStat) {
        super(deviceStat);
        this.f13830O000000o = false;
        this.O00000Oo = null;
        this.O00000o0 = null;
        this.O00000o = null;
        this.O00000o0 = new chx(this);
    }

    public final synchronized cll O000000o() {
        return this.O00000o0;
    }

    public final synchronized clm O00000Oo() {
        if (this.O00000o == null) {
            this.O00000o = new clm(this);
        }
        return this.O00000o;
    }

    public final String O00000o0() {
        try {
            String str = this.mDeviceStat.extrainfo;
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            try {
                return new JSONObject(str).optString("fw_version");
            } catch (JSONException e) {
                cki.O00000oO("BaseCameraDevice", "getDeviceVersion JSONException:" + e.getLocalizedMessage());
                return "";
            }
        } catch (Exception e2) {
            cki.O00000oO("BaseCameraDevice", "getDeviceVersion Exception:" + e2.getLocalizedMessage());
            return "";
        }
    }

    public final boolean O00000o() {
        return this.f13830O000000o;
    }

    public final synchronized clk O00000oO() {
        if (this.O00000Oo == null) {
            this.O00000Oo = new clk(getDid(), O0000oOo(), getModel());
        }
        return this.O00000Oo;
    }
}

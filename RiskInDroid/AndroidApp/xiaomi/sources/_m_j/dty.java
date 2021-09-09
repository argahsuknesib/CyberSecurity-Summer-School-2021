package _m_j;

import android.text.TextUtils;
import com.xiaomi.mistream.XmStreamClient;
import com.xiaomi.smarthome.camera.IXmConnectionClient;
import com.xiaomi.smarthome.camera.XmCameraP2p;
import com.xiaomi.smarthome.camera.XmP2PInfo;
import com.xiaomi.smarthome.device.api.BaseDevice;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.device.api.Parser;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.plugin.DeviceConstant;
import org.json.JSONArray;

public abstract class dty extends BaseDevice {

    /* renamed from: O000000o  reason: collision with root package name */
    private XmCameraP2p f14940O000000o = null;
    private XmStreamClient O00000Oo = null;
    private volatile IXmConnectionClient O00000o0 = null;
    public XmP2PInfo O00000oO = null;
    protected String O00000oo;

    public abstract cll O000000o();

    public abstract boolean O00000o();

    public abstract clk O00000oO();

    public dty(DeviceStat deviceStat) {
        super(deviceStat);
    }

    public final synchronized XmCameraP2p O0000ooo() {
        if (this.f14940O000000o == null) {
            this.f14940O000000o = XmPluginHostApi.instance().createCameraP2p(this.O00000oO, 1);
        }
        return this.f14940O000000o;
    }

    public final synchronized XmStreamClient O00oOooO() {
        if (this.O00000Oo == null) {
            synchronized (this) {
                this.O00000Oo = XmStreamClient.getInstance(deviceStat(), O0000oo0());
            }
        }
        return this.O00000Oo;
    }

    public String O0000oOo() {
        return this.O00000oo;
    }

    public final String O00oOooo() {
        XmP2PInfo xmP2PInfo = this.O00000oO;
        return xmP2PInfo != null ? xmP2PInfo.getPwd() : "";
    }

    public final void O000O00o() {
        this.f14940O000000o = null;
        this.O00000o0 = null;
    }

    public final void O00000Oo(final Callback<Void> callback) {
        XmPluginHostApi.instance().updateP2pPwd(deviceStat(), 1, new Callback<XmP2PInfo>() {
            /* class _m_j.dty.AnonymousClass1 */

            public final /* synthetic */ void onSuccess(Object obj) {
                dty dty = dty.this;
                dty.O00000oO = (XmP2PInfo) obj;
                dty.O00000oo = dty.O00000oO.getUid();
                Callback callback = callback;
                if (callback != null) {
                    callback.onSuccess(null);
                }
            }

            public final void onFailure(int i, String str) {
                Callback callback = callback;
                if (callback != null) {
                    callback.onFailure(i, str);
                }
            }
        });
    }

    public final void O000000o(String str, Object obj, Callback<Object> callback) {
        JSONArray jSONArray = new JSONArray();
        if (obj != null) {
            jSONArray.put(obj);
        }
        callMethod(str, jSONArray, callback, (Parser) null);
    }

    public String O0000oo0() {
        return getDid();
    }

    public String getDid() {
        return this.mDeviceStat != null ? this.mDeviceStat.did : "";
    }

    public final IXmConnectionClient O00000Oo(boolean z) {
        if (this.O00000o0 == null) {
            synchronized (this) {
                if (this.O00000o0 == null) {
                    this.O00000o0 = XmPluginHostApi.instance().createConnectionClient(this.O00000oO, deviceStat(), O0000oo0(), z);
                }
            }
        }
        return this.O00000o0;
    }

    public final int O000O0OO() {
        return ((TextUtils.isEmpty(getModel()) || !"chuangmi.camera.ipc019".equals(getModel())) && !DeviceConstant.is16K(getModel())) ? 8000 : 16000;
    }
}

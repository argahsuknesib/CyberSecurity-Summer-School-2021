package _m_j;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.exoplayer2.C;
import com.xiaomi.miio.MiioLocalAPI;
import com.xiaomi.smarthome.frame.ErrorCode;
import com.xiaomi.smarthome.wificonfig.BaseWifiSettingUtils;
import java.util.List;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class gjq {
    protected static String O00000oo = "BaseConfigProcess";
    protected static WifiManager O0000o0o;

    /* renamed from: O000000o  reason: collision with root package name */
    private BroadcastReceiver f17881O000000o = new BroadcastReceiver() {
        /* class _m_j.gjq.AnonymousClass2 */

        public final void onReceive(Context context, Intent intent) {
            Parcelable parcelableExtra;
            if (intent.getAction().equals("android.net.wifi.STATE_CHANGE") && (parcelableExtra = intent.getParcelableExtra("networkInfo")) != null) {
                Message obtainMessage = gjq.this.O0000OOo.obtainMessage();
                obtainMessage.what = 101;
                obtainMessage.obj = (NetworkInfo) parcelableExtra;
                gjq.this.O0000OOo.sendMessage(obtainMessage);
            }
        }
    };
    protected gkh O0000O0o;
    protected Handler O0000OOo;
    protected gkd O0000Oo;
    protected Context O0000Oo0;
    protected MiioLocalAPI.O000000o O0000OoO;
    protected boolean O0000Ooo;
    protected ConnectivityManager O0000o;
    protected long O0000o0;
    protected String O0000o00;
    protected String O0000o0O;
    protected ScanResult O0000oO;
    protected iad O0000oO0;
    public boolean O0000oOO = false;
    public boolean O0000oOo = false;

    /* access modifiers changed from: protected */
    public abstract void O000000o();

    /* access modifiers changed from: protected */
    public void O000000o(int i, Bundle bundle) {
    }

    /* access modifiers changed from: protected */
    public abstract void O000000o(Message message);

    /* access modifiers changed from: protected */
    public abstract void O000000o(List<gke> list);

    public void O000000o(Context context, List<gke> list, gkd gkd) {
        this.O0000Oo0 = context;
        this.O0000OOo = new Handler(Looper.getMainLooper()) {
            /* class _m_j.gjq.AnonymousClass1 */

            public final void handleMessage(Message message) {
                gjq.this.O000000o(message);
            }
        };
        O000000o(list);
        this.O0000Oo = gkd;
        O0000o0o = (WifiManager) this.O0000Oo0.getApplicationContext().getSystemService("wifi");
        this.O0000o = (ConnectivityManager) this.O0000Oo0.getSystemService("connectivity");
        gkd gkd2 = this.O0000Oo;
        if (gkd2 != null) {
            this.O0000oO = gkd2.O0000o00;
        }
        this.O0000Oo0.registerReceiver(this.f17881O000000o, new IntentFilter("android.net.wifi.STATE_CHANGE"));
    }

    public final Handler O0000OOo() {
        return this.O0000OOo;
    }

    public final void O000000o(gkh gkh) {
        this.O0000O0o = gkh;
    }

    /* access modifiers changed from: protected */
    public final void O0000Oo0() {
        this.O0000OOo.removeMessages(110);
    }

    public final void O0000Oo() {
        this.O0000oOO = true;
        this.O0000OOo.removeMessages(110);
    }

    public void O00000oO() {
        iad iad;
        this.O0000Ooo = false;
        this.O0000oOO = true;
        this.O0000oOo = true;
        try {
            this.O0000Oo0.unregisterReceiver(this.f17881O000000o);
        } catch (Exception e) {
            O00000Oo("unregisterReceiver meets exception: ".concat(String.valueOf(e)));
        }
        this.O0000OOo.removeMessages(110);
        this.O0000OOo.removeMessages(123);
        if (this.O0000o != null) {
            if (!(Build.VERSION.SDK_INT < 29 || (iad = this.O0000oO0) == null || iad.O00000o0 == null)) {
                this.O0000o.unregisterNetworkCallback(this.O0000oO0.O00000o0);
                this.O0000oO0.O00000o0 = null;
                this.O0000oO0 = null;
            }
            if (gnn.O00000oO) {
                O00000Oo("bindProcessToNetwork null");
                this.O0000o.bindProcessToNetwork(null);
            }
        }
    }

    public static void O00000Oo(String str) {
        gjn.O000000o().O000000o(O00000oo, str);
    }

    public static void O000000o(String str, Object... objArr) {
        gjn.O000000o().O000000o(O00000oo, String.format(str, objArr));
    }

    public static JSONObject O00000o0(String str) {
        JSONArray optJSONArray;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (AnonymousClass3.f17884O000000o[ErrorCode.valueof(jSONObject.optInt("code")).ordinal()] != 1) {
                return null;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("result");
            if (optJSONObject == null && (optJSONArray = jSONObject.optJSONArray("result")) != null) {
                optJSONObject = new JSONObject();
                optJSONObject.put("result", optJSONArray);
            }
            return optJSONObject == null ? jSONObject : optJSONObject;
        } catch (JSONException e) {
            gjm O000000o2 = gjn.O000000o();
            String str2 = O00000oo;
            O000000o2.O000000o(str2, "parseRpcResponse: " + Log.getStackTraceString(e));
            return null;
        }
    }

    /* renamed from: _m_j.gjq$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f17884O000000o = new int[ErrorCode.values().length];

        static {
            try {
                f17884O000000o[ErrorCode.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public final boolean O0000OoO() {
        WifiInfo connectionInfo;
        ScanResult scanResult;
        WifiManager wifiManager = O0000o0o;
        if (wifiManager != null && (connectionInfo = wifiManager.getConnectionInfo()) != null && !TextUtils.isEmpty(connectionInfo.getSSID()) && !connectionInfo.getSSID().contains("<unknown ssid>") && connectionInfo.getSupplicantState() == SupplicantState.COMPLETED && (scanResult = this.O0000oO) != null && BaseWifiSettingUtils.O000000o(connectionInfo.getSSID(), scanResult.SSID)) {
            return true;
        }
        return false;
    }

    public static int O0000Ooo() {
        return new Random().nextInt(C.MSG_CUSTOM_BASE) + 1;
    }

    public static boolean O0000o00() {
        WifiManager wifiManager = O0000o0o;
        WifiInfo connectionInfo = wifiManager != null ? wifiManager.getConnectionInfo() : null;
        if (connectionInfo == null) {
            return false;
        }
        String O0000Oo2 = gjn.O000000o().O0000Oo();
        String ssid = connectionInfo.getSSID();
        return TextUtils.equals(O0000Oo2, ssid) || TextUtils.equals(ssid, BaseWifiSettingUtils.O000000o(O0000Oo2));
    }

    /* access modifiers changed from: protected */
    public final void O000000o(int i, int i2) {
        Bundle bundle = new Bundle();
        bundle.putInt("error_code", i2);
        this.O0000O0o.O000000o(i, bundle);
    }

    /* access modifiers changed from: protected */
    public final void O000000o(Bundle bundle) {
        this.O0000O0o.O000000o(112, bundle);
    }

    /* access modifiers changed from: protected */
    public final void O000000o(int i, int i2, String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putInt("error_code", i2);
        if (!TextUtils.isEmpty(str)) {
            bundle.putString(str, str2);
        }
        this.O0000O0o.O000000o(i, bundle);
    }

    /* access modifiers changed from: protected */
    public final void O000000o(int i, String str, String str2, String str3, String str4) {
        Bundle bundle = new Bundle();
        bundle.putInt("error_code", 0);
        if (!TextUtils.isEmpty(str)) {
            bundle.putString(str, str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            bundle.putString(str3, str4);
        }
        this.O0000O0o.O000000o(i, bundle);
    }
}

package _m_j;

import _m_j.fat;
import _m_j.fnu;
import _m_j.hlz;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.facebook.drawee.view.SimpleDraweeView;
import com.tencent.mmkv.MMKV;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.device.XiaomiRedMiRouter15;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.library.common.dialog.BottomBaseDialog;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.miui.FindDeviceDialogActivity;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class fnu {

    /* renamed from: O000000o  reason: collision with root package name */
    public Context f16714O000000o;
    BottomBaseDialog O00000Oo;

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public static final fnu f16724O000000o = new fnu((byte) 0);
    }

    /* synthetic */ fnu(byte b) {
        this();
    }

    private fnu() {
        this.O00000Oo = null;
    }

    public final void O000000o(final O00000Oo o00000Oo) {
        boolean z;
        if (FindDeviceDialogActivity.sResumed) {
            O000000o("showFindXiaomiRouterDialog not show,because FindDeviceDialogActivity.sResumed(true)", new Object[0]);
        } else if (dcp.O000000o().O00000o0()) {
            O000000o("showFindXiaomiRouterDialog miui is connecting device, return", new Object[0]);
        } else {
            String str = o00000Oo.O00000o;
            if (TextUtils.isEmpty(str)) {
                z = true;
            } else {
                fat fat = fat.O000000o.f16039O000000o;
                Set<String> O00000Oo2 = MMKV.O000000o("smart.config.cache").O00000Oo("KEY.IGNORE.XIAOMI.ROUTERS", (Set<String>) null);
                if (O00000Oo2 == null || O00000Oo2.size() == 0) {
                    z = false;
                } else {
                    z = O00000Oo2.contains(str);
                }
            }
            if (z) {
                O000000o("showFindXiaomiRouterDialog not show,because is ignore device", new Object[0]);
            } else if (CoreApi.O000000o().O00000oO(o00000Oo.O00000Oo) == null) {
                O000000o("showFindXiaomiRouterDialog (%s) plugin device info is null, return!", o00000Oo.O00000Oo);
            } else {
                BottomBaseDialog bottomBaseDialog = this.O00000Oo;
                if (bottomBaseDialog != null && bottomBaseDialog.isShowing()) {
                    this.O00000Oo.dismiss();
                    this.O00000Oo = null;
                }
                if (this.f16714O000000o == null) {
                    O000000o("showFindXiaomiRouterDialog context is null ,return !", new Object[0]);
                    return;
                }
                O000000o("start showFindXiaomiRouterDialog", new Object[0]);
                this.O00000Oo = new BottomBaseDialog(this.f16714O000000o) {
                    /* class _m_j.fnu.AnonymousClass4 */

                    public final View O000000o() {
                        View inflate = LayoutInflater.from(this.O00000o0).inflate((int) R.layout.dialog_found_xiaomi_router, (ViewGroup) null);
                        ((TextView) inflate.findViewById(R.id.tv_device_name)).setText(DeviceFactory.O0000OoO(o00000Oo.O00000Oo));
                        final SimpleDraweeView simpleDraweeView = (SimpleDraweeView) inflate.findViewById(R.id.device_img);
                        if (!o00000Oo.f16725O000000o || !gof.O00000o0()) {
                            simpleDraweeView.setImageResource(R.drawable.icon_mijia_common_router);
                        } else {
                            hlz.O000000o(o00000Oo.O00000Oo, new fsm<hlz.O000000o, fso>() {
                                /* class _m_j.fnu.AnonymousClass4.AnonymousClass1 */

                                public final /* synthetic */ void onSuccess(Object obj) {
                                    simpleDraweeView.setImageURI(((hlz.O000000o) obj).f19057O000000o);
                                }

                                public final void onFailure(fso fso) {
                                    simpleDraweeView.setImageResource(R.drawable.icon_mijia_common_router);
                                }
                            });
                        }
                        ((TextView) inflate.findViewById(R.id.tv_ignore)).setOnClickListener(new View.OnClickListener() {
                            /* class _m_j.fnu.AnonymousClass4.AnonymousClass2 */

                            public final void onClick(View view) {
                                if (fnu.this.O00000Oo != null) {
                                    fnu.this.O00000Oo.dismiss();
                                    fnu.this.O00000Oo = null;
                                }
                                fnu fnu = fnu.this;
                                O00000Oo o00000Oo = o00000Oo;
                                if (fnu.f16714O000000o != null) {
                                    hab hab = new hab();
                                    hab.f18684O000000o = new View.OnClickListener(o00000Oo, hab) {
                                        /* class _m_j.fnu.AnonymousClass2 */

                                        /* renamed from: O000000o  reason: collision with root package name */
                                        final /* synthetic */ O00000Oo f16716O000000o;
                                        final /* synthetic */ hab O00000Oo;

                                        {
                                            this.f16716O000000o = r2;
                                            this.O00000Oo = r3;
                                        }

                                        public final void onClick(View view) {
                                            fnu.this.O000000o(this.f16716O000000o);
                                            this.O00000Oo.dismiss();
                                        }
                                    };
                                    hab.O00000Oo = new View.OnClickListener(o00000Oo, hab) {
                                        /* class _m_j.fnu.AnonymousClass3 */

                                        /* renamed from: O000000o  reason: collision with root package name */
                                        final /* synthetic */ O00000Oo f16717O000000o;
                                        final /* synthetic */ hab O00000Oo;

                                        {
                                            this.f16717O000000o = r2;
                                            this.O00000Oo = r3;
                                        }

                                        public final void onClick(View view) {
                                            String str = this.f16717O000000o.O00000o;
                                            if (!TextUtils.isEmpty(str)) {
                                                fat fat = fat.O000000o.f16039O000000o;
                                                Set O00000Oo2 = MMKV.O000000o("smart.config.cache").O00000Oo("KEY.IGNORE.XIAOMI.ROUTERS", (Set<String>) null);
                                                if (O00000Oo2 == null) {
                                                    O00000Oo2 = new HashSet();
                                                }
                                                O00000Oo2.add(str);
                                                fat fat2 = fat.O000000o.f16039O000000o;
                                                MMKV.O000000o("smart.config.cache").O000000o("KEY.IGNORE.XIAOMI.ROUTERS", O00000Oo2);
                                            }
                                            this.O00000Oo.dismiss();
                                        }
                                    };
                                    hab.show(((FragmentActivity) fnu.f16714O000000o).getSupportFragmentManager(), "ignore dialog show");
                                }
                            }
                        });
                        ((TextView) inflate.findViewById(R.id.tv_add_begin)).setOnClickListener(new View.OnClickListener() {
                            /* class _m_j.fnu.AnonymousClass4.AnonymousClass3 */

                            public final void onClick(View view) {
                                String str;
                                WifiInfo connectionInfo;
                                if (fnu.this.O00000Oo != null) {
                                    fnu.this.O00000Oo.dismiss();
                                    fnu.this.O00000Oo = null;
                                }
                                WifiManager wifiManager = (WifiManager) CommonApplication.getApplication().getApplicationContext().getSystemService("wifi");
                                if (wifiManager == null || (connectionInfo = wifiManager.getConnectionInfo()) == null) {
                                    str = "";
                                } else {
                                    str = connectionInfo.getSSID();
                                }
                                if (!TextUtils.isEmpty(str)) {
                                    fnu fnu = fnu.this;
                                    O00000Oo o00000Oo = o00000Oo;
                                    if (fnu.f16714O000000o == null) {
                                        fnu.O000000o("launchXiaomiRouterPlugin context is null", new Object[0]);
                                        return;
                                    }
                                    XiaomiRedMiRouter15 xiaomiRedMiRouter15 = new XiaomiRedMiRouter15(str, o00000Oo.O00000Oo);
                                    Bundle bundle = new Bundle();
                                    bundle.putInt("scene_type", -2);
                                    JSONObject jSONObject = new JSONObject();
                                    try {
                                        jSONObject.put("rn_ssid", str);
                                        jSONObject.put("rn_model", o00000Oo.O00000Oo);
                                        jSONObject.put("model", o00000Oo.O00000oO);
                                        jSONObject.put("ssid", str);
                                        jSONObject.put("isInited", o00000Oo.f16725O000000o);
                                        jSONObject.put("isBind", o00000Oo.O00000oo);
                                        jSONObject.put("isRelay", o00000Oo.O0000O0o);
                                        jSONObject.put("relayIp", o00000Oo.O0000OOo);
                                        JSONArray O00000o0 = XiaomiRedMiRouter15.O00000o0();
                                        if (O00000o0 != null) {
                                            jSONObject.put("bind_models", O00000o0);
                                        }
                                        bundle.putString("extra", jSONObject.toString());
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                    hna.O00000Oo().getActionByDeviceRenderer(xiaomiRedMiRouter15, fnu.f16714O000000o, bundle);
                                }
                            }
                        });
                        return inflate;
                    }
                };
                this.O00000Oo.show();
            }
        }
    }

    public final void O000000o(final String str, final boolean z) {
        hty.O000000o().isRouterInited(str, new Callback<String>() {
            /* class _m_j.fnu.AnonymousClass5 */

            public final /* synthetic */ void onSuccess(Object obj) {
                O00000Oo O000000o2;
                String str = (String) obj;
                if (!TextUtils.isEmpty(str) && (O000000o2 = O00000Oo.O000000o(str)) != null) {
                    fnu.O000000o("checkCurrentConnectedWifiIsXiaoMiRouter onResponse :url=%s,response=%s", str, str);
                    boolean z = z;
                    O000000o2.O0000Oo0 = z;
                    O000000o2.O0000O0o = z;
                    O000000o2.O0000OOo = str;
                    if (!O000000o2.f16725O000000o) {
                        CommonApplication.getGlobalHandler().post(new Runnable(O000000o2) {
                            /* class _m_j.$$Lambda$fnu$5$wUv9F0VJKf6oe62cP9CfYQq4A9c */
                            private final /* synthetic */ fnu.O00000Oo f$1;

                            {
                                this.f$1 = r2;
                            }

                            public final void run() {
                                fnu.AnonymousClass5.this.O000000o(this.f$1);
                            }
                        });
                        return;
                    }
                    fnu fnu = fnu.this;
                    if (fnu.f16714O000000o != null) {
                        hty.O000000o().isRouterBound(fnu.f16714O000000o, O000000o2.O00000o, O000000o2.O00000o0, new huc(O000000o2) {
                            /* class _m_j.fnu.AnonymousClass6 */

                            /* renamed from: O000000o  reason: collision with root package name */
                            final /* synthetic */ O00000Oo f16723O000000o;

                            {
                                this.f16723O000000o = r2;
                            }

                            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                             method: _m_j.fnu.O000000o(java.lang.String, boolean):void
                             arg types: [java.lang.String, int]
                             candidates:
                              _m_j.fnu.O000000o(java.lang.String, java.lang.Object[]):void
                              _m_j.fnu.O000000o(java.lang.String, boolean):void */
                            /* JADX WARNING: Removed duplicated region for block: B:44:0x00d8  */
                            /* JADX WARNING: Removed duplicated region for block: B:50:0x00e2  */
                            /* JADX WARNING: Removed duplicated region for block: B:56:0x00ec  */
                            /* JADX WARNING: Removed duplicated region for block: B:58:0x00f2  */
                            /* JADX WARNING: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
                            /* JADX WARNING: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
                            /* JADX WARNING: Removed duplicated region for block: B:64:? A[RETURN, SYNTHETIC] */
                            /* JADX WARNING: Unknown top exception splitter block from list: {B:41:0x00d3=Splitter:B:41:0x00d3, B:53:0x00e7=Splitter:B:53:0x00e7, B:47:0x00dd=Splitter:B:47:0x00dd} */
                            public final void O000000o(String str) {
                                boolean z;
                                try {
                                    z = new JSONObject(str).optBoolean("result", false);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                    z = false;
                                }
                                fnu.O000000o("checkXiaoMiRouterBound onResponse:".concat(String.valueOf(str)), new Object[0]);
                                if (!z) {
                                    CommonApplication.getGlobalHandler().post(new Runnable(this.f16723O000000o) {
                                        /* class _m_j.$$Lambda$fnu$6$KX11Jx2yg43dnHT0Z6E8wVzY */
                                        private final /* synthetic */ fnu.O00000Oo f$1;

                                        {
                                            this.f$1 = r2;
                                        }

                                        public final void run() {
                                            fnu.AnonymousClass6.this.O000000o(this.f$1);
                                        }
                                    });
                                } else if (!this.f16723O000000o.O0000Oo0) {
                                    fnu fnu = fnu.this;
                                    if (fnu.f16714O000000o == null) {
                                        fnu.O000000o("checkRelayMode context is null,then return!", new Object[0]);
                                        return;
                                    }
                                    fnu.O000000o("start CheckRelayMode", new Object[0]);
                                    DatagramSocket datagramSocket = null;
                                    InetAddress O000000o2 = hzb.O000000o(fnu.f16714O000000o);
                                    if (O000000o2 == null) {
                                        fnu.O000000o("checkRelayMode inetAddress is null,then return!", new Object[0]);
                                        return;
                                    }
                                    try {
                                        DatagramSocket datagramSocket2 = new DatagramSocket();
                                        try {
                                            datagramSocket2.setReuseAddress(true);
                                            byte[] bytes = "What?".getBytes();
                                            fnu.O000000o("send waht?", new Object[0]);
                                            datagramSocket2.send(new DatagramPacket(bytes, bytes.length, O000000o2, 988));
                                            byte[] bArr = new byte[2048];
                                            DatagramPacket datagramPacket = new DatagramPacket(bArr, 2048);
                                            datagramSocket2.setSoTimeout(3000);
                                            datagramSocket2.receive(datagramPacket);
                                            String str2 = new String(bArr, 0, datagramPacket.getLength());
                                            fnu.O000000o("checkRelayMode response = %s", str2);
                                            if (!TextUtils.isEmpty(str2) && str2.contains(":")) {
                                                String str3 = str2.split(":")[0];
                                                if (fnu.O000000o(str3)) {
                                                    fnu.O000000o(str3, true);
                                                } else {
                                                    fnu.O000000o("not invalid IP:".concat(String.valueOf(str3)), new Object[0]);
                                                }
                                            }
                                            datagramSocket2.close();
                                        } catch (SocketException e2) {
                                            e = e2;
                                            datagramSocket = datagramSocket2;
                                            e.printStackTrace();
                                            if (datagramSocket == null) {
                                                datagramSocket.close();
                                            }
                                        } catch (SocketTimeoutException e3) {
                                            e = e3;
                                            datagramSocket = datagramSocket2;
                                            e.printStackTrace();
                                            if (datagramSocket == null) {
                                                datagramSocket.close();
                                            }
                                        } catch (IOException e4) {
                                            e = e4;
                                            datagramSocket = datagramSocket2;
                                            try {
                                                e.printStackTrace();
                                                if (datagramSocket == null) {
                                                    datagramSocket.close();
                                                }
                                            } catch (Throwable th) {
                                                th = th;
                                                datagramSocket2 = datagramSocket;
                                                if (datagramSocket2 != null) {
                                                }
                                                throw th;
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                            if (datagramSocket2 != null) {
                                                datagramSocket2.close();
                                            }
                                            throw th;
                                        }
                                    } catch (SocketException e5) {
                                        e = e5;
                                        e.printStackTrace();
                                        if (datagramSocket == null) {
                                        }
                                    } catch (SocketTimeoutException e6) {
                                        e = e6;
                                        e.printStackTrace();
                                        if (datagramSocket == null) {
                                        }
                                    } catch (IOException e7) {
                                        e = e7;
                                        e.printStackTrace();
                                        if (datagramSocket == null) {
                                        }
                                    }
                                }
                            }

                            /* access modifiers changed from: private */
                            public /* synthetic */ void O000000o(O00000Oo o00000Oo) {
                                fnu.this.O000000o(o00000Oo);
                            }

                            public final void O000000o(int i, String str) {
                                fnu.O000000o("checkXiaoMiRouterBound onFailure: code=%d,msg=%s", Integer.valueOf(i), Integer.valueOf(i));
                            }
                        });
                    }
                }
            }

            /* access modifiers changed from: private */
            public /* synthetic */ void O000000o(O00000Oo o00000Oo) {
                fnu.this.O000000o(o00000Oo);
            }

            public final void onFailure(int i, String str) {
                fnu.O000000o("checkCurrentConnectedWifiIsXiaoMiRouter onFailure, code=%d,info=%s", Integer.valueOf(i), str);
            }
        });
    }

    public final boolean O000000o() {
        BottomBaseDialog bottomBaseDialog = this.O00000Oo;
        return bottomBaseDialog != null && bottomBaseDialog.isShowing();
    }

    static boolean O000000o(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String[] split = str.split("\\.");
        if (split.length == 4) {
            try {
                for (String str2 : split) {
                    if (Integer.parseInt(str2) < 0 || Integer.parseInt(str2) > 255) {
                        return false;
                    }
                }
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static void O000000o(String str, Object... objArr) {
        if (objArr.length > 0) {
            gsy.O00000o0(LogType.KUAILIAN, "XiaoMiRouter", String.format(str, objArr));
            return;
        }
        gsy.O00000o0(LogType.KUAILIAN, "XiaoMiRouter", str);
    }

    static class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        boolean f16725O000000o;
        String O00000Oo;
        String O00000o;
        String O00000o0;
        public String O00000oO;
        public boolean O00000oo = false;
        public boolean O0000O0o = false;
        public String O0000OOo = null;
        public boolean O0000Oo0 = false;

        private O00000Oo(String str, boolean z, String str2, String str3) {
            this.f16725O000000o = z;
            this.O00000Oo = str;
            this.O00000o0 = str2;
            this.O00000o = str3;
        }

        public static O00000Oo O000000o(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.optInt("code", -1) != 0) {
                    return null;
                }
                boolean z = true;
                if (jSONObject.optInt("inited", -1) != 1) {
                    z = false;
                }
                String optString = jSONObject.optString("model", "");
                String optString2 = jSONObject.optString("routerId", "");
                String optString3 = jSONObject.optString("id", "");
                String optString4 = jSONObject.optString("hardware");
                if (TextUtils.isEmpty(optString4) || TextUtils.isEmpty(optString2) || TextUtils.isEmpty(optString3)) {
                    return null;
                }
                if (TextUtils.isEmpty(optString)) {
                    optString = "xiaomi.router." + optString4.toLowerCase();
                }
                O00000Oo o00000Oo = new O00000Oo(optString, z, optString2, optString3);
                o00000Oo.O00000oO = optString4;
                return o00000Oo;
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
    }
}

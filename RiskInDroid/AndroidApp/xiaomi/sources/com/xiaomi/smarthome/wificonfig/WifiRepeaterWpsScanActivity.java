package com.xiaomi.smarthome.wificonfig;

import _m_j.cub;
import _m_j.cuh;
import _m_j.dxe;
import _m_j.gsy;
import _m_j.htq;
import _m_j.hua;
import _m_j.hub;
import _m_j.huc;
import _m_j.hud;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.DhcpInfo;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.xiaomi.miio.MiioLocalAPI;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.WifiRepeater;
import com.xiaomi.smarthome.device.choosedevice.ScanDeviceProgressBar;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.smartconfig.SmartConfigRouterFactory;
import com.xiaomi.smarthome.smartconfig.callback.ConfigKeyValuePair;
import com.xiaomi.smarthome.smartconfig.callback.ConfigNetRequest;
import com.xiaomi.smarthome.smartconfig.step.SmartConfigStep;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class WifiRepeaterWpsScanActivity extends BaseActivity implements ScanDeviceProgressBar.O000000o {

    /* renamed from: O000000o  reason: collision with root package name */
    static Map<String, String> f12030O000000o;
    private ScanDeviceProgressBar O00000Oo;
    private TextView O00000o;
    private Button O00000o0;
    private SmartConfigStep.O000000o O00000oO = new SmartConfigStep.O000000o() {
        /* class com.xiaomi.smarthome.wificonfig.WifiRepeaterWpsScanActivity.AnonymousClass1 */

        public final void O000000o(SmartConfigStep.Step step) {
        }

        public final void O00000Oo(SmartConfigStep.Step step) {
        }

        public final void O000000o() {
            WifiRepeaterWpsScanActivity.this.onBackPressed();
        }

        public final Handler O00000Oo() {
            return WifiRepeaterWpsScanActivity.this.mHandler;
        }

        public final void O000000o(boolean z) {
            WifiRepeaterWpsScanActivity.this.onBackPressed();
        }
    };
    public String mModel;
    public O000000o mUdpReceiver = null;

    public void writeLog(String str, Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            gsy.O00000o0(LogType.KUAILIAN, "Repeater-Binder", str);
            return;
        }
        gsy.O00000o0(LogType.KUAILIAN, "Repeater-Binder", String.format(str, objArr));
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == 24) {
            O000000o o000000o = this.mUdpReceiver;
            if (o000000o != null) {
                o000000o.O000000o();
                O000000o o000000o2 = this.mUdpReceiver;
                for (WifiRepeater next : o000000o2.O00000Oo) {
                    MiioLocalAPI.O000000o(next.ip, new dxe.O000000o(next) {
                        /* class com.xiaomi.smarthome.wificonfig.WifiRepeaterWpsScanActivity.O000000o.AnonymousClass1 */

                        /* renamed from: O000000o  reason: collision with root package name */
                        final /* synthetic */ WifiRepeater f12035O000000o;

                        {
                            this.f12035O000000o = r2;
                        }

                        public final void O000000o(JSONObject jSONObject) {
                            WifiRepeaterWpsScanActivity.this.writeLog("get token success", new Object[0]);
                            long parseLong = Long.parseLong(jSONObject.optString("did"));
                            String optString = jSONObject.optString("token");
                            WifiRepeater wifiRepeater = this.f12035O000000o;
                            wifiRepeater.did = parseLong;
                            wifiRepeater.token = optString;
                            if (parseLong > 0 && !TextUtils.isEmpty(optString)) {
                                JSONObject jSONObject2 = new JSONObject();
                                try {
                                    jSONObject2.put("id", System.currentTimeMillis() / 1000);
                                    jSONObject2.put("method", "localIO.get_system_init_info");
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                MiioLocalAPI.O000000o(this.f12035O000000o.ip, jSONObject2.toString(), parseLong, optString, new dxe.O000000o() {
                                    /* class com.xiaomi.smarthome.wificonfig.WifiRepeaterWpsScanActivity.O000000o.AnonymousClass1.AnonymousClass1 */

                                    public final void O000000o(int i, String str, Throwable th) {
                                    }

                                    public final void O000000o(JSONObject jSONObject) {
                                        boolean z = false;
                                        WifiRepeaterWpsScanActivity.this.writeLog("get get_system_init_info onSuccess: result".concat(String.valueOf(jSONObject)), new Object[0]);
                                        String optString = jSONObject.optString("id");
                                        String optString2 = jSONObject.optString("routerId");
                                        if (jSONObject.optInt("inited") != 0) {
                                            z = true;
                                        }
                                        if (z) {
                                            String optString3 = jSONObject.optString("mac");
                                            if (!TextUtils.isEmpty(optString3)) {
                                                AnonymousClass1.this.f12035O000000o.deviceMac = optString3;
                                            }
                                            htq O000000o2 = htq.O000000o();
                                            AnonymousClass1 r3 = new hua<Boolean, hud>() {
                                                /* class com.xiaomi.smarthome.wificonfig.WifiRepeaterWpsScanActivity.O000000o.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                                                public final void O000000o(hud hud) {
                                                }

                                                public final /* synthetic */ void O000000o(Object obj) {
                                                    if (!((Boolean) obj).booleanValue()) {
                                                        O000000o.this.O00000o0.add(AnonymousClass1.this.f12035O000000o.ip);
                                                        WifiRepeaterWpsScanActivity.this.findDevice();
                                                    }
                                                }
                                            };
                                            ArrayList arrayList = new ArrayList();
                                            JSONObject jSONObject2 = new JSONObject();
                                            try {
                                                jSONObject2.put("method", "POST");
                                                JSONObject jSONObject3 = new JSONObject();
                                                jSONObject3.put("serialNumber", optString);
                                                jSONObject3.put("deviceID", optString2);
                                                jSONObject2.put("params", jSONObject3);
                                            } catch (JSONException unused) {
                                            }
                                            arrayList.add(new ConfigKeyValuePair("data", jSONObject2.toString()));
                                            ConfigNetRequest.O000000o o000000o = new ConfigNetRequest.O000000o();
                                            o000000o.f11489O000000o = "POST";
                                            ConfigNetRequest.O000000o O000000o3 = o000000o.O000000o("/appgateway/third/miwifi/app/s/device/isDeviceBound");
                                            O000000o3.O00000o0 = arrayList;
                                            SmartConfigRouterFactory.getSmartConfigManager().sendSmartHomeRequest(O000000o3.O000000o(), new huc(new hub<Boolean>() {
                                                /* class _m_j.htq.AnonymousClass15 */

                                                public final /* synthetic */ Object parse(JSONObject jSONObject) {
                                                    if (jSONObject == null) {
                                                        return Boolean.FALSE;
                                                    }
                                                    return Boolean.valueOf(jSONObject.optBoolean("result", false));
                                                }
                                            }, r3) {
                                                /* class _m_j.htq.AnonymousClass16 */

                                                /* renamed from: O000000o */
                                                final /* synthetic */ hub f653O000000o;
                                                final /* synthetic */ hua O00000Oo;

                                                {
                                                    this.f653O000000o = r2;
                                                    this.O00000Oo = r3;
                                                }

                                                public final void O000000o(String str) {
                                                    hue.O000000o().O000000o(str, this.f653O000000o, this.O00000Oo);
                                                }

                                                public final void O000000o(int i, String str) {
                                                    hua hua = this.O00000Oo;
                                                    if (hua != null) {
                                                        hua.O00000Oo(new hud(i, str));
                                                    }
                                                }
                                            });
                                        }
                                    }
                                });
                            }
                        }

                        public final void O000000o(int i, String str, Throwable th) {
                            WifiRepeaterWpsScanActivity.this.writeLog("get token onFail,code=%d,result=%s", Integer.valueOf(i), str);
                        }
                    }, 3);
                }
            }
            this.mHandler.sendEmptyMessageDelayed(25, 4000);
        } else if (message.what == 25) {
            O000000o();
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f12030O000000o = hashMap;
        hashMap.put("RA75", "xiaomi.repeater.v6");
    }

    public void onTimeOut() {
        if (isValid()) {
            this.O00000o0.setVisibility(0);
            this.O00000Oo.setVisibility(4);
            this.O00000o.setText((int) R.string.wps_cannot_find_device);
            O000000o o000000o = this.mUdpReceiver;
            if (o000000o != null) {
                o000000o.O000000o();
            }
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    public void findDevice() {
        O000000o o000000o = this.mUdpReceiver;
        if (o000000o != null) {
            o000000o.O000000o();
            O000000o o000000o2 = this.mUdpReceiver;
            ArrayList arrayList = new ArrayList();
            if (o000000o2.O00000Oo != null && !o000000o2.O00000Oo.isEmpty()) {
                for (WifiRepeater next : o000000o2.O00000Oo) {
                    if (o000000o2.O00000o0.contains(next.ip)) {
                        arrayList.add(next);
                    }
                }
            }
            if (arrayList.size() > 0) {
                this.O00000Oo.O00000Oo();
                this.mHandler.removeCallbacksAndMessages(null);
                WifiRepeaterWPSBindActivity.invokeActivity(this, (WifiRepeater) arrayList.get(0));
                finish();
            }
        }
    }

    public boolean isValid() {
        if (isFinishing()) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 17 || !isDestroyed()) {
            return true;
        }
        return false;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_wifi_repeater_wps_scan);
        Intent intent = getIntent();
        if (intent != null) {
            this.mModel = intent.getStringExtra("model");
            intent.putExtra("connect_unique", UUID.randomUUID().toString());
        }
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.wificonfig.WifiRepeaterWpsScanActivity.AnonymousClass2 */

            public final void onClick(View view) {
                WifiRepeaterWpsScanActivity.this.onBackPressed();
            }
        });
        ((TextView) findViewById(R.id.module_a_3_return_title)).setText(getString(R.string.scan_device));
        this.O00000Oo = (ScanDeviceProgressBar) findViewById(R.id.progress_bar);
        this.O00000Oo.O00000o0 = this;
        this.O00000o0 = (Button) findViewById(R.id.btn_retry);
        this.O00000o0.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.wificonfig.$$Lambda$WifiRepeaterWpsScanActivity$032Dr5xzi_nmDqjKSf8ACPOOifE */

            public final void onClick(View view) {
                WifiRepeaterWpsScanActivity.this.O000000o(view);
            }
        });
        this.O00000o = (TextView) findViewById(R.id.scan_des);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(View view) {
        cub.O000000o(new cuh(this, "ResetDevicePage").O000000o("model", this.mModel));
        finish();
    }

    public void onBackPressed() {
        finish();
    }

    public void onResume() {
        super.onResume();
        this.O00000Oo.setTime(15000);
        O000000o();
        this.O00000Oo.O000000o();
    }

    public void onPause() {
        super.onPause();
        this.O00000Oo.O00000Oo();
    }

    public void onStop() {
        super.onStop();
    }

    public void onDestroy() {
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    private void O000000o() {
        new Thread(new Runnable() {
            /* class com.xiaomi.smarthome.wificonfig.WifiRepeaterWpsScanActivity.AnonymousClass3 */

            public final void run() {
                InetAddress wifiBroadcastAddressInner = WifiRepeaterWpsScanActivity.getWifiBroadcastAddressInner(WifiRepeaterWpsScanActivity.this);
                if (wifiBroadcastAddressInner == null) {
                    WifiRepeaterWpsScanActivity.this.writeLog("sendWPSBroadcast inetAddress is null,then return!", new Object[0]);
                    return;
                }
                try {
                    DatagramSocket datagramSocket = new DatagramSocket();
                    datagramSocket.setReuseAddress(true);
                    byte[] bytes = "What?".getBytes();
                    WifiRepeaterWpsScanActivity.this.writeLog("send waht?", new Object[0]);
                    datagramSocket.send(new DatagramPacket(bytes, bytes.length, wifiBroadcastAddressInner, 988));
                    WifiRepeaterWpsScanActivity.this.mUdpReceiver = new O000000o(datagramSocket);
                    WifiRepeaterWpsScanActivity.this.mUdpReceiver.start();
                    WifiRepeaterWpsScanActivity.this.mHandler.sendEmptyMessageDelayed(24, 3000);
                } catch (SocketException e) {
                    e.printStackTrace();
                } catch (SocketTimeoutException e2) {
                    e2.printStackTrace();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
        }).start();
    }

    class O000000o extends Thread {

        /* renamed from: O000000o  reason: collision with root package name */
        DatagramSocket f12034O000000o;
        List<WifiRepeater> O00000Oo = new ArrayList();
        Set<String> O00000o = new HashSet();
        List<String> O00000o0 = new ArrayList();
        private boolean O00000oo = false;

        public O000000o(DatagramSocket datagramSocket) {
            this.f12034O000000o = datagramSocket;
        }

        public final void run() {
            try {
                int O000000o2 = ContextCompat.O000000o(WifiRepeaterWpsScanActivity.this, "android.permission.INTERNET");
                WifiRepeaterWpsScanActivity wifiRepeaterWpsScanActivity = WifiRepeaterWpsScanActivity.this;
                wifiRepeaterWpsScanActivity.writeLog("check internet stat " + O000000o2 + ",need state =0", new Object[0]);
                while (!this.O00000oo) {
                    byte[] bArr = new byte[1024];
                    DatagramPacket datagramPacket = new DatagramPacket(bArr, 1024);
                    this.f12034O000000o.receive(datagramPacket);
                    String hostAddress = datagramPacket.getAddress().getHostAddress();
                    int port = datagramPacket.getPort();
                    String str = new String(bArr, 0, datagramPacket.getLength());
                    WifiRepeaterWpsScanActivity.this.writeLog("udpReceiver receive ip=%s,port=%d,msg=%s", hostAddress, Integer.valueOf(port), str);
                    if (!TextUtils.isEmpty(str) && str.contains(":")) {
                        String[] split = str.split(":");
                        String str2 = split[0];
                        if (WifiRepeaterWpsScanActivity.isIP(str2) && !this.O00000o.contains(str2)) {
                            this.O00000o.add(str2);
                            String str3 = WifiRepeaterWpsScanActivity.f12030O000000o.get(split[1].toUpperCase());
                            if (TextUtils.equals(str3, WifiRepeaterWpsScanActivity.this.mModel)) {
                                this.O00000Oo.add(new WifiRepeater(str3, hostAddress, split[2]));
                            }
                        }
                    }
                }
            } catch (SocketException e) {
                e.printStackTrace();
                WifiRepeaterWpsScanActivity wifiRepeaterWpsScanActivity2 = WifiRepeaterWpsScanActivity.this;
                wifiRepeaterWpsScanActivity2.writeLog("upd receive SocketException:" + e.getMessage(), new Object[0]);
            } catch (IOException e2) {
                e2.printStackTrace();
                WifiRepeaterWpsScanActivity wifiRepeaterWpsScanActivity3 = WifiRepeaterWpsScanActivity.this;
                wifiRepeaterWpsScanActivity3.writeLog("upd receive IoException:" + e2.getMessage(), new Object[0]);
            }
        }

        public final void O000000o() {
            DatagramSocket datagramSocket = this.f12034O000000o;
            if (datagramSocket != null) {
                datagramSocket.close();
                this.f12034O000000o = null;
            }
            this.O00000oo = true;
        }
    }

    @SuppressLint({"MissingPermission"})
    public static InetAddress getWifiBroadcastAddressInner(Context context) {
        DhcpInfo dhcpInfo;
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        boolean z = true;
        if (activeNetworkInfo == null || activeNetworkInfo.getType() != 1) {
            z = false;
        }
        if (!z || (dhcpInfo = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getDhcpInfo()) == null) {
            return null;
        }
        int i = (dhcpInfo.netmask ^ -1) | (dhcpInfo.ipAddress & dhcpInfo.netmask);
        byte[] bArr = new byte[4];
        for (int i2 = 0; i2 < 4; i2++) {
            bArr[i2] = (byte) ((i >> (i2 * 8)) & 255);
        }
        try {
            return InetAddress.getByAddress(bArr);
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean isIP(String str) {
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
}

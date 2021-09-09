package com.xiaomi.smarthome.smartconfig;

import _m_j.fbs;
import _m_j.fbt;
import _m_j.fob;
import _m_j.fon;
import _m_j.fqr;
import _m_j.ft;
import _m_j.gnk;
import _m_j.gnl;
import _m_j.gpn;
import _m_j.hti;
import _m_j.htr;
import _m_j.htv;
import _m_j.htw;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.net.wifi.ScanResult;
import android.os.Bundle;
import android.os.Message;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.core.entity.bluetooth.SearchRequest;
import com.xiaomi.smarthome.core.server.internal.bluetooth.recognizer.beacon.MiotBleAdvPacket;
import com.xiaomi.smarthome.device.BleDevice;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleResponse;
import com.xiaomi.smarthome.smartconfig.ChooseCameraActivity;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;

public class ChooseCameraActivity extends BaseActivity implements hti.O000000o {

    /* renamed from: O000000o  reason: collision with root package name */
    private ListView f11417O000000o;
    private hti O00000Oo;
    private HashMap<String, BleDevice> O00000o;
    private HashMap<String, ScanResult> O00000o0;
    private HashMap<String, O000000o> O00000oO;
    private O00000Oo O00000oo;
    public Button mBtnRefresh;
    public String mModel;
    public ProgressBar mPbar;

    public class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public ScanResult f11424O000000o;
        public BleDevice O00000Oo;

        public O000000o(ScanResult scanResult, BleDevice bleDevice) {
            this.f11424O000000o = scanResult;
            this.O00000Oo = bleDevice;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.choose_camera_activity);
        this.mModel = (String) htr.O000000o().O000000o("device_model");
        gnk.O00000o0(String.format("ChooseCameraActivity model = %s", this.mModel));
        findViewById(R.id.module_a_3_return_title);
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.ChooseCameraActivity.AnonymousClass1 */

            public final void onClick(View view) {
                ChooseCameraActivity.this.finish();
            }
        });
        findViewById(R.id.module_a_3_more).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.ChooseCameraActivity.AnonymousClass2 */

            public final void onClick(View view) {
                ChooseCameraActivity.this.finish();
            }
        });
        this.mPbar = (ProgressBar) findViewById(R.id.pbar);
        this.mBtnRefresh = (Button) findViewById(R.id.refresh);
        this.mBtnRefresh.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.ChooseCameraActivity.AnonymousClass3 */

            public final void onClick(View view) {
                ChooseCameraActivity.this.scanCamera();
            }
        });
        TextView textView = (TextView) findViewById(R.id.nothing);
        SpannableStringBuilder valueOf = SpannableStringBuilder.valueOf(getString(R.string.nothing));
        valueOf.setSpan(new ClickableSpan() {
            /* class com.xiaomi.smarthome.smartconfig.ChooseCameraActivity.AnonymousClass4 */

            public final void updateDrawState(TextPaint textPaint) {
                super.updateDrawState(textPaint);
                textPaint.setColor(Color.parseColor("#527acc"));
                textPaint.setUnderlineText(false);
            }

            public final void onClick(View view) {
                fbs.O000000o(new fbt(ChooseCameraActivity.this, "CameraBarcodeHelpActivity").O000000o("model", ChooseCameraActivity.this.mModel).O000000o("url", "/faq/detail.html?id=1016").O000000o(1));
            }
        }, 0, valueOf.length(), 33);
        textView.setHighlightColor(0);
        textView.setText(valueOf);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        this.f11417O000000o = (ListView) findViewById(R.id.listview);
        this.f11417O000000o.addHeaderView(LayoutInflater.from(this).inflate((int) R.layout.choose_camera_listview_header, (ViewGroup) null));
        this.f11417O000000o.setHeaderDividersEnabled(false);
        this.f11417O000000o.setDivider(null);
        this.f11417O000000o.setDividerHeight(0);
        this.O00000Oo = new hti(this);
        this.f11417O000000o.setAdapter((ListAdapter) this.O00000Oo);
        this.O00000o0 = new HashMap<>();
        this.O00000o = new HashMap<>();
        this.O00000oO = new HashMap<>();
        scanCamera();
        refreshWifiResults();
    }

    public void scanCamera() {
        gnk.O00000o0(String.format("scanBleForCameraAddress", new Object[0]));
        if (!gnl.O00000Oo()) {
            fqr.O000000o(this, new BleResponse() {
                /* class com.xiaomi.smarthome.smartconfig.ChooseCameraActivity.AnonymousClass5 */

                public final void onResponse(int i, Object obj) {
                    if (i == 0) {
                        ChooseCameraActivity.this.doScanCamera();
                    } else {
                        ChooseCameraActivity.this.finish();
                    }
                }
            });
        } else {
            doScanCamera();
        }
    }

    public void processBleSearchStopped() {
        this.mBtnRefresh.setEnabled(true);
        this.mBtnRefresh.setText((int) R.string.refresh);
        this.mPbar.setVisibility(8);
        O00000o0();
    }

    private void O000000o() {
        this.O00000oO.clear();
        for (String next : this.O00000o0.keySet()) {
            if (this.O00000o.containsKey(next)) {
                this.O00000oO.put(next, new O000000o(this.O00000o0.get(next), this.O00000o.get(next)));
            }
        }
        if (!this.O00000oO.isEmpty()) {
            this.f11417O000000o.setVisibility(0);
        } else {
            this.f11417O000000o.setVisibility(8);
        }
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 2000);
        }
    }

    public void refreshBleDevices(BleDevice bleDevice) {
        MiotBleAdvPacket O00000Oo2 = bleDevice.O00000Oo();
        if (O00000Oo2 != null && !TextUtils.isEmpty(O00000Oo2.O00000oo) && this.mModel.equals(bleDevice.model)) {
            gnk.O00000oO(String.format(">>> ble -> %s", bleDevice));
            this.O00000o.put(O00000Oo2.O00000oo, bleDevice);
        }
        O000000o();
    }

    public void refreshWifiResults() {
        LinkedList<ScanResult> linkedList = new LinkedList<>();
        htw O000000o2 = htv.O000000o();
        if (!(O000000o2 == null || O000000o2.getWifiScanResult() == null)) {
            linkedList.addAll(O000000o2.getWifiScanResult());
        }
        if (!gpn.O000000o(linkedList)) {
            for (ScanResult scanResult : linkedList) {
                if (DeviceFactory.O00000Oo(scanResult).equalsIgnoreCase(this.mModel)) {
                    gnk.O00000oO(String.format(">>> wifi -> %s", scanResult));
                    this.O00000o0.put(DeviceFactory.O0000Oo(scanResult), scanResult);
                }
            }
        }
        O000000o();
    }

    class O00000Oo extends BroadcastReceiver {
        private O00000Oo() {
        }

        /* synthetic */ O00000Oo(ChooseCameraActivity chooseCameraActivity, byte b) {
            this();
        }

        public final void onReceive(Context context, Intent intent) {
            if ("wifi_scan_result_broadcast".equals(intent.getAction())) {
                ChooseCameraActivity.this.refreshWifiResults();
            }
        }
    }

    private void O00000Oo() {
        if (this.O00000oo != null) {
            ft.O000000o(getApplicationContext()).O000000o(this.O00000oo);
            this.O00000oo = null;
        }
    }

    public void onPause() {
        super.onPause();
        O00000o0();
    }

    private void O00000o0() {
        O00000Oo();
        fob.O00000o0();
        CoreApi.O000000o().O000O0OO();
    }

    public void onResume() {
        super.onResume();
    }

    public void onCameraChoose(O000000o o000000o) {
        htr.O000000o().O00000Oo("device_ap", o000000o.f11424O000000o);
        setResult(-1);
        finish();
    }

    public void handleMessage(Message message) {
        if (message.what == 1) {
            hti hti = this.O00000Oo;
            hti.O00000o0.post(new Runnable(this.O00000oO.values()) {
                /* class _m_j.hti.AnonymousClass1 */

                /* renamed from: O000000o */
                final /* synthetic */ Collection f624O000000o;

                {
                    this.f624O000000o = r2;
                }

                public final void run() {
                    hti hti = hti.this;
                    Collection collection = this.f624O000000o;
                    hti.O00000Oo.clear();
                    hti.O00000Oo.addAll(collection);
                    Collections.sort(hti.O00000Oo, new Comparator<ChooseCameraActivity.O000000o>() {
                        /* class _m_j.hti.AnonymousClass2 */

                        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                            ChooseCameraActivity.O000000o o000000o = (ChooseCameraActivity.O000000o) obj;
                            ChooseCameraActivity.O000000o o000000o2 = (ChooseCameraActivity.O000000o) obj2;
                            int i = 0;
                            int i2 = o000000o2.O00000Oo != null ? o000000o2.O00000Oo.rssi : 0;
                            if (o000000o.O00000Oo != null) {
                                i = o000000o.O00000Oo.rssi;
                            }
                            return i2 - i;
                        }
                    });
                    hti.notifyDataSetChanged();
                }
            });
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1 && i2 == -1) {
            setResult(-1, intent);
            finish();
        }
    }

    public void doScanCamera() {
        if (this.O00000oo == null) {
            this.O00000oo = new O00000Oo(this, (byte) 0);
            ft.O000000o(getApplicationContext()).O000000o(this.O00000oo, new IntentFilter("wifi_scan_result_broadcast"));
        }
        CoreApi.O000000o().O000000o(2000);
        htw O000000o2 = htv.O000000o();
        if (O000000o2 != null) {
            O000000o2.startScan();
        }
        fob.O000000o(new SearchRequest.O000000o().O000000o(3000, 10).O000000o(), new fon() {
            /* class com.xiaomi.smarthome.smartconfig.ChooseCameraActivity.AnonymousClass6 */

            public final /* synthetic */ void O000000o(Object obj) {
                ChooseCameraActivity.this.refreshBleDevices((BleDevice) obj);
            }

            public final void O000000o() {
                ChooseCameraActivity.this.mBtnRefresh.setEnabled(false);
                ChooseCameraActivity.this.mPbar.setVisibility(0);
                ChooseCameraActivity.this.mBtnRefresh.setText("");
            }

            public final void O00000Oo() {
                ChooseCameraActivity.this.processBleSearchStopped();
            }

            public final void O00000o0() {
                ChooseCameraActivity.this.processBleSearchStopped();
            }
        });
    }
}

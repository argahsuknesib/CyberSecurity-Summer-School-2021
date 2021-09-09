package com.xiaomi.smarthome.device;

import _m_j.ddb;
import _m_j.fbs;
import _m_j.fbt;
import _m_j.fio;
import _m_j.fip;
import _m_j.fir;
import _m_j.fno;
import _m_j.foc;
import _m_j.fsm;
import _m_j.fso;
import _m_j.fwq;
import _m_j.gfx;
import _m_j.ggb;
import _m_j.gpn;
import _m_j.gsy;
import _m_j.htr;
import _m_j.hts;
import _m_j.htx;
import _m_j.hty;
import _m_j.inc;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.ScanResult;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.gson.annotations.SerializedName;
import com.xiaomi.qrcode2.ScanBarcodeActivity;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.ConfigRouterSubDeviceActivity;
import com.xiaomi.smarthome.device.api.DeviceApi;
import com.xiaomi.smarthome.device.utils.MoxiangOOBInfo;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.library.log.LogType;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONObject;

public class ConfigRouterSubDeviceActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final Boolean f6935O000000o = Boolean.TRUE;
    private O00000Oo O00000Oo;
    private Disposable O00000o;
    private XQProgressDialog O00000o0;
    private String O00000oO;
    private String O00000oo;
    private String O0000O0o;
    private String O0000OOo;
    private String O0000Oo;
    private String O0000Oo0;
    private String O0000OoO = null;
    private KeyPair O0000Ooo;
    public List<O00000o0> datas = new ArrayList();
    public O000000o mAdapter;
    @BindView(7253)
    ListView mContentRv;
    @BindView(6986)
    Button mNextBtn;
    @BindView(7591)
    TextView mNoDeviceTv;
    @BindView(6920)
    View mReturnBtn;
    @BindView(7517)
    View mTitleBar;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        hts.O000000o("mo_xiang:camera", "verify the log");
        setContentView((int) R.layout.smart_config_ap_add_sub_camera);
        ButterKnife.bind(this);
        this.O0000O0o = getIntent().getStringExtra("device_model");
        this.O0000Oo0 = getIntent().getStringExtra("key_qrcode_oob");
        this.O0000Oo = getIntent().getStringExtra("mac");
        this.O00000oO = getIntent().getStringExtra("station_model");
        if (TextUtils.isEmpty(this.O00000oO)) {
            this.O00000oO = "mxiang.camera.mwc11".equalsIgnoreCase(this.O0000O0o) ? "mxiang.camera.mwc10" : "mxiang.camera.mwc13";
        }
        this.O00000oo = getIntent().getStringExtra("station_did");
        writeLog("initData ,stationModel = %s, stationDid=%s, camera model =%s", this.O00000oO, this.O00000oo, this.O0000O0o);
        this.mReturnBtn.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.device.$$Lambda$ConfigRouterSubDeviceActivity$5PGKckAPZHPLdyjq5cu5emXZ1Dc */

            public final void onClick(View view) {
                ConfigRouterSubDeviceActivity.this.O00000o(view);
            }
        });
        this.mAdapter = new O000000o(this, (byte) 0);
        this.mContentRv.setAdapter((ListAdapter) this.mAdapter);
        this.mNextBtn.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.device.$$Lambda$ConfigRouterSubDeviceActivity$GLTLtOpMUaAjXKmDl9g_hYvunnc */

            public final void onClick(View view) {
                ConfigRouterSubDeviceActivity.this.O00000o0(view);
            }
        });
        this.mContentRv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.xiaomi.smarthome.device.ConfigRouterSubDeviceActivity.AnonymousClass1 */

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                int i2 = i - 1;
                O00000o0 o00000o0 = ConfigRouterSubDeviceActivity.this.datas.get(i2);
                if (o00000o0 != null) {
                    if (!o00000o0.O00000o) {
                        int size = ConfigRouterSubDeviceActivity.this.datas.size();
                        for (int i3 = 0; i3 < size; i3++) {
                            if (i2 != i3) {
                                ConfigRouterSubDeviceActivity.this.datas.get(i3).O00000o = false;
                            }
                        }
                        o00000o0.O00000o = true;
                    } else {
                        o00000o0.O00000o = false;
                    }
                    ConfigRouterSubDeviceActivity.this.mAdapter.notifyDataSetChanged();
                }
            }
        });
        if (!TextUtils.isEmpty(this.O00000oo)) {
            String stringExtra = getIntent().getStringExtra("station_device_name");
            String str = this.O00000oo;
            if (TextUtils.isEmpty(str)) {
                hts.O000000o("mo_xiang:camera", "[addDevice] station device id is empty ");
                return;
            }
            O00000o0 O000000o2 = O000000o(0, str, stringExtra);
            this.datas.clear();
            this.datas.add(O000000o2);
            O00000o();
            this.mNextBtn.setEnabled(false);
            this.mContentRv.setEnabled(false);
            O00000oO();
            return;
        }
        List<Device> list = null;
        if (TextUtils.isEmpty(this.O00000oO)) {
            hts.O000000o("mo_xiang:camera", "[startFetchBindStations] failed, empty station model");
        } else {
            List<Device> routerDevices = getRouterDevices(this.O00000oO);
            if (gpn.O000000o(routerDevices)) {
                hts.O000000o("mo_xiang:camera", "[startFetchBindStations] do not own (" + this.O00000oO + ")", new Object[0]);
            } else {
                Collections.sort(routerDevices, new Comparator<Device>() {
                    /* class com.xiaomi.smarthome.device.ConfigRouterSubDeviceActivity.AnonymousClass2 */

                    public final /* synthetic */ int compare(Object obj, Object obj2) {
                        Device device = (Device) obj;
                        Device device2 = (Device) obj2;
                        if (TextUtils.isEmpty(device.orderTimeJString) || TextUtils.isEmpty(device2.orderTimeJString)) {
                            return -1;
                        }
                        return device2.orderTimeJString.compareTo(device.orderTimeJString);
                    }
                });
                list = routerDevices;
            }
        }
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                Device device = (Device) list.get(i);
                arrayList.add(O000000o(i, device.did, device.getName()));
            }
        }
        if (!gpn.O000000o(arrayList)) {
            this.datas.addAll(arrayList);
            O00000o();
            return;
        }
        this.mContentRv.setVisibility(8);
        this.mNoDeviceTv.setVisibility(0);
    }

    public void onDestroy() {
        super.onDestroy();
        Disposable disposable = this.O00000o;
        if (disposable != null) {
            if (!disposable.isDisposed()) {
                this.O00000o.dispose();
            }
            this.O00000o = null;
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        StringBuilder sb = new StringBuilder();
        Bundle extras = intent.getExtras();
        sb.append("[");
        if (extras != null) {
            for (String next : extras.keySet()) {
                sb.append(next + "=" + extras.get(next));
            }
        }
        sb.append("]");
        objArr[2] = sb.toString();
        writeLog("onActivityResult, request code =%d, result code=%d, data=%s", objArr);
        if (i == 100) {
            if (i2 == -1) {
                if (TextUtils.isEmpty(this.O0000OOo)) {
                    this.O0000OOo = intent.getStringExtra("station_pin_code");
                }
                if (TextUtils.isEmpty(this.O0000Oo0)) {
                    this.O0000Oo0 = intent.getStringExtra("key_qrcode_oob");
                }
                if (TextUtils.isEmpty(this.O0000O0o)) {
                    this.O0000O0o = getIntent().getStringExtra("device_model");
                }
                if (TextUtils.isEmpty(this.O0000Oo)) {
                    this.O0000Oo = intent.getStringExtra("mac");
                }
                O00000Oo o00000Oo = this.O00000Oo;
                if (o00000Oo != null) {
                    O000000o(o00000Oo);
                    return;
                } else if (!TextUtils.isEmpty(this.O0000OOo)) {
                    O000000o(this.O0000OoO, this.O0000OOo);
                    return;
                }
            }
            this.mNextBtn.setEnabled(true);
        }
    }

    public void writeLog(String str, Object... objArr) {
        hts.O000000o("mo_xiang:camera", str, objArr);
    }

    public static void startWithDeviceModel(Context context, String str, String str2, String str3) {
        Intent intent = new Intent(context, ConfigRouterSubDeviceActivity.class);
        intent.putExtra("device_model", str);
        intent.putExtra("key_qrcode_oob", str2);
        intent.putExtra("mac", str3);
        gsy.O000000o(3, "weilun", "choose station start device with model".concat(String.valueOf(str)));
        context.startActivity(intent);
    }

    public static void startWithStationInfo(Context context, String str, String str2) {
        Intent intent = new Intent(context, ConfigRouterSubDeviceActivity.class);
        intent.putExtra("station_model", str2);
        intent.putExtra("station_did", str);
        context.startActivity(intent);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000o(View view) {
        onBackPressed();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000o0(View view) {
        O000000o();
    }

    private static O00000o0 O000000o(int i, String str, String str2) {
        Device O000000o2 = fno.O000000o().O000000o(str);
        if (TextUtils.isEmpty(str2) && O000000o2 != null) {
            str2 = String.valueOf(O000000o2.getName());
        }
        String O00000o2 = gfx.O00000o(str2);
        String O0000o00 = foc.O0000o00(str);
        hts.O000000o("mo_xiang:camera", "mapDeviceToAdapterItem, did = " + str + ", qrcode : " + O0000o00);
        O00000o0 o00000o0 = new O00000o0(O00000o2, str, O0000o00);
        if (i == 0) {
            o00000o0.O00000o = true;
        }
        return o00000o0;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{android.content.Intent.putExtra(java.lang.String, int):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, int[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Bundle):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.io.Serializable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent} */
    private void O000000o() {
        Intent intent = new Intent(this, ConfigRouterStationActivity.class);
        intent.putExtra("model", this.O00000oO);
        intent.putExtra("from_miui", false);
        startActivity(intent);
        finish();
    }

    public MoxiangOOBInfo getMoxiangOOBInfo(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return MoxiangOOBInfo.NONE_OOB_EXIST;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            return MoxiangOOBInfo.BOTH_OOB_EXIST;
        }
        if (!TextUtils.isEmpty(str)) {
            return MoxiangOOBInfo.ONLY_STAION_OOB_EXIST;
        }
        if (!TextUtils.isEmpty(str2)) {
            return MoxiangOOBInfo.ONLY_DEVICE_OOB_EXIST;
        }
        return MoxiangOOBInfo.NONE_OOB_EXIST;
    }

    private void O00000Oo() {
        O00000o0 o00000o0 = null;
        for (O00000o0 next : this.datas) {
            if (next.O00000o) {
                o00000o0 = next;
            }
        }
        if (o00000o0 == null) {
            Toast.makeText(this, getString(R.string.mx_choose_jizhan), 0).show();
            this.mNextBtn.setEnabled(true);
            return;
        }
        htr.O000000o().O00000Oo("mo_xiang_station_did", o00000o0.O00000Oo);
        this.O0000OOo = TextUtils.isEmpty(this.O0000OOo) ? o00000o0.O00000o0 : this.O0000OOo;
        if (TextUtils.isEmpty(this.O0000OOo)) {
            this.O0000OOo = foc.O0000o00(o00000o0.O00000Oo);
        }
        MoxiangOOBInfo moxiangOOBInfo = getMoxiangOOBInfo(this.O0000OOo, this.O0000Oo0);
        if (TextUtils.isEmpty(this.O0000OOo) || TextUtils.isEmpty(this.O0000Oo0)) {
            fwq.O000000o(this, true, new inc(o00000o0.O00000Oo, moxiangOOBInfo) {
                /* class com.xiaomi.smarthome.device.$$Lambda$ConfigRouterSubDeviceActivity$KSlNoAIOT5BBGFgkyoyLcdY3mPg */
                private final /* synthetic */ String f$1;
                private final /* synthetic */ MoxiangOOBInfo f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void onAction(List list) {
                    ConfigRouterSubDeviceActivity.this.O000000o(this.f$1, this.f$2, list);
                }
            });
            return;
        }
        O00000Oo o00000Oo = this.O00000Oo;
        if (o00000Oo != null) {
            O000000o(o00000Oo);
        } else {
            O000000o(o00000o0.O00000Oo, TextUtils.isEmpty(this.O0000OOo) ? o00000o0.O00000o0 : this.O0000OOo);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fbt.O000000o(java.lang.String, boolean):_m_j.fbt
     arg types: [java.lang.String, int]
     candidates:
      _m_j.fbt.O000000o(java.lang.String, java.lang.Object):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.Class, java.lang.String):T
      _m_j.fbt.O000000o(java.lang.String, int):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, android.os.Bundle):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, android.os.Parcelable):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.io.Serializable):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.CharSequence):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.String):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.util.ArrayList<? extends android.os.Parcelable>):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.String[]):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, boolean):_m_j.fbt */
    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(String str, MoxiangOOBInfo moxiangOOBInfo, List list) {
        this.O0000OoO = str;
        fbt O000000o2 = new fbt(this, ScanBarcodeActivity.TAG).O000000o(100);
        O000000o2.O000000o("from", 200);
        O000000o2.O000000o("show_add_manully", false);
        O000000o2.O000000o("moxiang_oob_info", moxiangOOBInfo.name());
        O000000o2.O000000o("station_did", str);
        fbs.O000000o(O000000o2);
    }

    private void O000000o(String str, String str2) {
        writeLog("start request station info , station did = %s, QR code =%s", str, str2);
        XQProgressDialog xQProgressDialog = this.O00000o0;
        if (xQProgressDialog == null || !xQProgressDialog.isShowing()) {
            this.O00000o0 = new XQProgressDialog(this);
            this.O00000o0.setCancelable(true);
            this.O00000o0.setMessage(getResources().getString(R.string.loading_share_info));
            this.O00000o0.show();
        }
        this.O0000Ooo = fir.O000000o();
        Base64.encodeToString(fio.O000000o((ECPrivateKey) this.O0000Ooo.getPrivate()), 2);
        String encodeToString = Base64.encodeToString(fio.O000000o((ECPublicKey) this.O0000Ooo.getPublic()), 2);
        String O000000o2 = O000000o(encodeToString);
        writeLog("startFetchSelectedStationInfoByDid appPublic key=%s,requestBody=%s", encodeToString, O000000o2);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(O000000o2)) {
            hts.O000000o("mo_xiang:camera", "[startFetchSelectedStationInfoByDid]  for did = " + str + " , requestBody " + O000000o2);
            return;
        }
        this.mNextBtn.setEnabled(false);
        this.O00000o = O000000o(str, O000000o2, str2).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer() {
            /* class com.xiaomi.smarthome.device.$$Lambda$ConfigRouterSubDeviceActivity$dPNBf9OGQa62yHttvGxKsi4U0 */

            public final void accept(Object obj) {
                ConfigRouterSubDeviceActivity.this.O00000Oo((ConfigRouterSubDeviceActivity.O00000Oo) obj);
            }
        }, new Consumer() {
            /* class com.xiaomi.smarthome.device.$$Lambda$ConfigRouterSubDeviceActivity$gMA99UNCVsUk0BClsUDBnZmAAJM */

            public final void accept(Object obj) {
                ConfigRouterSubDeviceActivity.this.O000000o((Throwable) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo(O00000Oo o00000Oo) throws Exception {
        O00000o0();
        this.mNextBtn.setEnabled(true);
        this.O00000Oo = o00000Oo;
        O000000o(o00000Oo);
        finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(Throwable th) throws Exception {
        O00000o0();
        this.mNextBtn.setEnabled(true);
        hts.O000000o("mo_xiang:camera", "rpc call failed + " + th.getMessage());
        Toast.makeText(this, th.getMessage(), 1).show();
    }

    private void O00000o0() {
        XQProgressDialog xQProgressDialog = this.O00000o0;
        if (xQProgressDialog != null && xQProgressDialog.isShowing()) {
            this.O00000o0.dismiss();
        }
    }

    private void O000000o(O00000Oo o00000Oo) {
        htr.O000000o().O00000Oo("mo_xiang_station_ssid", o00000Oo.f6940O000000o);
        htr.O000000o().O00000Oo("mo_xiang_station_passwd", o00000Oo.O00000Oo);
        htr.O000000o().O00000Oo("mo_xiang_static_key", o00000Oo.O00000o0);
        htr.O000000o().O00000Oo("mo_xiang_key_num", String.valueOf(o00000Oo.O00000o));
        Intent intent = getIntent();
        ScanResult scanResult = (intent == null || !intent.hasExtra("scanResult")) ? null : (ScanResult) intent.getParcelableExtra("scanResult");
        if (scanResult == null) {
            fbt fbt = new fbt(this, "ResetDevicePage");
            if (TextUtils.isEmpty(this.O0000O0o)) {
                this.O0000O0o = "mxiang.camera.mwc10".equalsIgnoreCase(this.O00000oO) ? "mxiang.camera.mwc11" : "mxiang.camera.mwc14";
            }
            fbt.O000000o("model", this.O0000O0o);
            fbt.O000000o("mac", this.O0000Oo);
            fbt.O000000o("key_qrcode_oob", this.O0000Oo0);
            fbs.O000000o(fbt);
        } else {
            htx O000000o2 = hty.O000000o();
            if (O000000o2 != null) {
                fbt smartConfigRequest = O000000o2.getSmartConfigRequest(this, scanResult, DeviceFactory.O00000Oo(scanResult), null, null);
                if (smartConfigRequest != null) {
                    fbs.O000000o(smartConfigRequest);
                }
            } else {
                return;
            }
        }
        finish();
    }

    private Observable<O00000Oo> O000000o(String str, String str2, String str3) {
        return Observable.create(new ObservableOnSubscribe(str, str2, str3) {
            /* class com.xiaomi.smarthome.device.$$Lambda$ConfigRouterSubDeviceActivity$fuVZPtlH4P9ASt0vwvzlGNs_q1E */
            private final /* synthetic */ String f$1;
            private final /* synthetic */ String f$2;
            private final /* synthetic */ String f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final void subscribe(ObservableEmitter observableEmitter) {
                ConfigRouterSubDeviceActivity.this.O000000o(this.f$1, this.f$2, this.f$3, observableEmitter);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(String str, String str2, final String str3, final ObservableEmitter observableEmitter) throws Exception {
        DeviceApi.getInstance().rpcAsyncRemote(this, str, str2, new fsm<JSONObject, fso>() {
            /* class com.xiaomi.smarthome.device.ConfigRouterSubDeviceActivity.AnonymousClass3 */

            public final /* synthetic */ void onSuccess(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                String optString = jSONObject.optString("encrypt_data");
                String optString2 = jSONObject.optString("gw_pub_key");
                boolean z = false;
                ConfigRouterSubDeviceActivity.this.writeLog("get station info remote RPC response: " + jSONObject.toString(), new Object[0]);
                try {
                    String decodeData = ConfigRouterSubDeviceActivity.this.decodeData(optString, optString2, str3);
                    ConfigRouterSubDeviceActivity.this.writeLog("decode finished ".concat(String.valueOf(decodeData)), new Object[0]);
                    if (TextUtils.isEmpty(decodeData) && !observableEmitter.isDisposed()) {
                        observableEmitter.onError(new RpcCallException(-10002, ConfigRouterSubDeviceActivity.this.getString(R.string.moxiang_station_decode_error)));
                    }
                    JSONObject jSONObject2 = new JSONObject(decodeData);
                    String optString3 = jSONObject2.optString("ssid");
                    String optString4 = jSONObject2.optString("passwd");
                    String optString5 = jSONObject2.optString("static_key");
                    int optInt = jSONObject2.optInt("static_key_num");
                    O00000Oo o00000Oo = new O00000Oo();
                    o00000Oo.f6940O000000o = optString3;
                    o00000Oo.O00000Oo = optString4;
                    o00000Oo.O00000o0 = optString5;
                    o00000Oo.O00000o = optInt;
                    if (!TextUtils.isEmpty(o00000Oo.f6940O000000o) && !TextUtils.isEmpty(o00000Oo.O00000Oo)) {
                        if (!TextUtils.isEmpty(o00000Oo.O00000o0)) {
                            z = true;
                        }
                    }
                    if (!z) {
                        if (!observableEmitter.isDisposed()) {
                            observableEmitter.onError(new RpcCallException(-10001, ConfigRouterSubDeviceActivity.this.getString(R.string.moxiang_station_rpc_error)));
                        }
                    } else if (!observableEmitter.isDisposed()) {
                        observableEmitter.onNext(o00000Oo);
                        observableEmitter.onComplete();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    if (!observableEmitter.isDisposed()) {
                        observableEmitter.onError(e);
                    }
                }
            }

            public final void onFailure(fso fso) {
                if (!observableEmitter.isDisposed()) {
                    observableEmitter.onError(new Exception(ConfigRouterSubDeviceActivity.this.getString(R.string.moxiang_station_rpc_error)));
                }
            }
        });
    }

    public String decodeData(String str, String str2, String str3) throws Exception {
        writeLog("start decode encrypt_data=%s, gwPubKey=%s ,QrCode=%s", str, str2, str3);
        SecretKey O000000o2 = fir.O000000o(fio.O000000o(Base64.decode(str2, 2), ((ECPublicKey) this.O0000Ooo.getPublic()).getParams()), this.O0000Ooo.getPrivate());
        fip O000000o3 = fip.O000000o("HmacSHA256");
        O000000o3.O000000o(O000000o2.getEncoded(), str3.getBytes());
        byte[] O000000o4 = O000000o3.O000000o("".getBytes(), 16);
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
        SecretKeySpec secretKeySpec = new SecretKeySpec(O000000o4, "AES");
        byte[] bArr = new byte[16];
        for (int i = 0; i < 16; i++) {
            bArr[i] = 0;
        }
        instance.init(2, secretKeySpec, new IvParameterSpec(bArr));
        return new String(instance.doFinal(Base64.decode(str, 2)));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.widget.ListView, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    private void O00000o() {
        LayoutInflater from = LayoutInflater.from(this);
        if (this.mContentRv.getFooterViewsCount() == 0) {
            View inflate = from.inflate((int) R.layout.smart_config_ap_info_item_footer, (ViewGroup) this.mContentRv, false);
            inflate.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.device.$$Lambda$ConfigRouterSubDeviceActivity$aC0BIX52QRZ0BKw14HUqb3AcA */

                public final void onClick(View view) {
                    ConfigRouterSubDeviceActivity.this.O00000Oo(view);
                }
            });
            this.mContentRv.addFooterView(inflate);
        }
        if (this.mContentRv.getHeaderViewsCount() == 0) {
            this.mContentRv.addHeaderView(from.inflate((int) R.layout.smart_config_ap_info_item_header, (ViewGroup) this.mContentRv, false));
        }
        this.mNextBtn.setText((int) R.string.next_button);
        this.mNextBtn.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.device.$$Lambda$ConfigRouterSubDeviceActivity$idHX5680SD8kUSPM9II6PNpHY0 */

            public final void onClick(View view) {
                ConfigRouterSubDeviceActivity.this.O000000o(view);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo(View view) {
        O000000o();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(View view) {
        O00000oO();
    }

    private void O00000oO() {
        int i = 0;
        this.mNextBtn.setEnabled(false);
        O00000o0 o00000o0 = null;
        for (O00000o0 next : this.datas) {
            if (next.O00000o) {
                o00000o0 = next;
            }
        }
        if (o00000o0 == null) {
            ddb.O00000Oo(R.string.mx_choose_jizhan);
            this.mNextBtn.setEnabled(true);
            return;
        }
        List<Device> O00000oO2 = fno.O000000o().O00000oO(o00000o0.O00000Oo);
        LogType logType = LogType.KUAILIAN;
        StringBuilder sb = new StringBuilder("getSubDeviceByParentDid subdevices num:");
        if (O00000oO2 != null) {
            i = O00000oO2.size();
        }
        sb.append(i);
        gsy.O00000o0(logType, "mo_xiang:camera", sb.toString());
        if (O00000oO2 == null || O00000oO2.size() != 4) {
            O00000Oo();
            return;
        }
        ddb.O00000Oo(R.string.moxiang_camera_max_num_error);
        this.mNextBtn.setEnabled(true);
    }

    private static String O000000o(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", (int) ((Math.random() * 100000.0d) + 100000.0d));
            jSONObject.put("method", "get_gwinfo");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("app_pub_key", str);
            jSONObject.put("params", jSONObject2);
            return jSONObject.toString();
        } catch (Exception e) {
            hts.O000000o("mo_xiang:camera", "[generateGetGWRPCMsgBody] failed: " + e.getStackTrace());
            return null;
        }
    }

    class O000000o extends BaseAdapter {
        public final long getItemId(int i) {
            return (long) i;
        }

        private O000000o() {
        }

        /* synthetic */ O000000o(ConfigRouterSubDeviceActivity configRouterSubDeviceActivity, byte b) {
            this();
        }

        public final int getCount() {
            return ConfigRouterSubDeviceActivity.this.datas.size();
        }

        public final Object getItem(int i) {
            return ConfigRouterSubDeviceActivity.this.datas.get(i);
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            O00000o o00000o;
            if (view == null) {
                view = View.inflate(ConfigRouterSubDeviceActivity.this, R.layout.smart_config_ap_info_item, null);
                o00000o = new O00000o(ConfigRouterSubDeviceActivity.this, (byte) 0);
                o00000o.O00000Oo = (ImageView) view.findViewById(R.id.iv_camera_ap_selected);
                o00000o.f6941O000000o = (TextView) view.findViewById(R.id.tv_camera_ap_info);
                view.setTag(o00000o);
            } else {
                o00000o = (O00000o) view.getTag();
            }
            O00000o0 o00000o0 = ConfigRouterSubDeviceActivity.this.datas.get(i);
            o00000o.f6941O000000o.setText(o00000o0.f6942O000000o);
            if (o00000o0.O00000o) {
                view.setBackgroundResource(R.drawable.moxiang_button_choose_bg);
                o00000o.f6941O000000o.setTextColor(ConfigRouterSubDeviceActivity.this.getResources().getColor(R.color.mx_choose_station_title_color));
                o00000o.O00000Oo.setVisibility(0);
            } else {
                view.setBackgroundResource(R.drawable.moxiang_button_not_choose_bg);
                o00000o.f6941O000000o.setTextColor(ConfigRouterSubDeviceActivity.this.getResources().getColor(R.color.mx_not_choose_station_title_color));
                o00000o.O00000Oo.setVisibility(8);
            }
            return view;
        }
    }

    class O00000o {

        /* renamed from: O000000o  reason: collision with root package name */
        TextView f6941O000000o;
        ImageView O00000Oo;

        private O00000o() {
        }

        /* synthetic */ O00000o(ConfigRouterSubDeviceActivity configRouterSubDeviceActivity, byte b) {
            this();
        }
    }

    static class O00000o0 {

        /* renamed from: O000000o  reason: collision with root package name */
        final String f6942O000000o;
        final String O00000Oo;
        boolean O00000o;
        final String O00000o0;

        public O00000o0(String str, String str2, String str3) {
            this.f6942O000000o = str;
            this.O00000Oo = str2;
            this.O00000o0 = str3;
        }

        public final String toString() {
            return "GatewayItemData{mTitle='" + this.f6942O000000o + '\'' + "mDid='" + this.O00000Oo + "'mQrCode='" + this.O00000o0 + "', mChecked=" + this.O00000o + '}';
        }
    }

    static class O00000Oo {
        @SerializedName("ssid")

        /* renamed from: O000000o  reason: collision with root package name */
        String f6940O000000o;
        @SerializedName("passwd")
        String O00000Oo;
        @SerializedName("static_key_num")
        int O00000o;
        @SerializedName("static_key")
        String O00000o0;

        O00000Oo() {
        }

        public final String toString() {
            return "GatewayInfo{mSsid='" + this.f6940O000000o + '\'' + ", mPasswd='" + this.O00000Oo + '\'' + ", mStaticKey='" + this.O00000o0 + '\'' + ", mStaticKeyNum=" + this.O00000o + '}';
        }
    }

    static class RpcCallException extends Exception {
        int mCode;

        RpcCallException(int i, String str) {
            super(str);
            this.mCode = i;
        }

        public String getMessage() {
            String message = super.getMessage();
            return "RpcCallException [code = " + this.mCode + "] " + message;
        }
    }

    public static List<Device> getRouterDevices(String str) {
        ArrayList arrayList = new ArrayList();
        List<String> O000000o2 = ggb.O00000Oo().O000000o(ggb.O00000Oo().O0000OOo(), new boolean[0]);
        if (O000000o2 != null) {
            for (String O000000o3 : O000000o2) {
                Device O000000o4 = fno.O000000o().O000000o(O000000o3);
                if (O000000o4 != null && str.equalsIgnoreCase(O000000o4.model) && O000000o4.isOnline) {
                    arrayList.add(O000000o4);
                }
            }
        }
        return arrayList;
    }
}

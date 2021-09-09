package com.xiaomi.miconnect;

import _m_j.dck;
import _m_j.dco;
import _m_j.dcp;
import _m_j.dct;
import _m_j.dcv;
import _m_j.dda;
import _m_j.dde;
import _m_j.ddl;
import _m_j.ddo;
import _m_j.ddp;
import _m_j.ddq;
import _m_j.ddr;
import _m_j.fbs;
import _m_j.fbt;
import _m_j.fea;
import _m_j.ffr;
import _m_j.fob;
import _m_j.ft;
import _m_j.fte;
import _m_j.gfr;
import _m_j.htn;
import _m_j.htx;
import _m_j.hty;
import _m_j.htz;
import _m_j.hug;
import _m_j.huj;
import _m_j.hum;
import android.app.Activity;
import android.bluetooth.le.ScanResult;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.smarthome.connect.bluetooth.MiConnectBleMatchActivity;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.core.server.internal.bluetooth.recognizer.beacon.MiotBleAdvPacket;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.bluetooth.search.BluetoothSearchResult;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.smartconfig.SmartConfigRouterFactory;

public class MiConnectLauncherActivity extends BaseActivity implements dck {

    /* renamed from: O000000o  reason: collision with root package name */
    BroadcastReceiver f6002O000000o = new BroadcastReceiver() {
        /* class com.xiaomi.miconnect.MiConnectLauncherActivity.AnonymousClass1 */

        public final void onReceive(Context context, Intent intent) {
            if ("home_room_updated".equals(intent.getAction()) && !MiConnectLauncherActivity.this.isFinishing()) {
                dct.O00000oO("onReceive");
                MiConnectLauncherActivity.this.mHandler.removeMessages(1000);
                if (!MiConnectLauncherActivity.this.mTimeOut) {
                    MiConnectLauncherActivity miConnectLauncherActivity = MiConnectLauncherActivity.this;
                    miConnectLauncherActivity.mTimeOut = true;
                    miConnectLauncherActivity.doConnect();
                }
                ft.O000000o(MiConnectLauncherActivity.this.getContext()).O000000o(this);
            }
        }
    };
    private final int O00000Oo = 1000;
    private final int O00000o = 1001;
    private final int O00000o0 = 1001;
    private String O00000oO = null;
    private BluetoothSearchResult O00000oo = null;
    private boolean O0000O0o = false;
    public int count = 0;
    public LinearLayout launcherContent;
    public TextView launcherTextView;
    public ddo loginDialog;
    public boolean mStateSaved = false;
    public boolean mTimeOut = false;
    public Runnable textAnimation = new Runnable() {
        /* class com.xiaomi.miconnect.MiConnectLauncherActivity.AnonymousClass7 */

        public final void run() {
            if (MiConnectLauncherActivity.this.launcherTextView != null) {
                if (MiConnectLauncherActivity.this.count < 3) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(MiConnectLauncherActivity.this.getString(R.string.miconnect_loading));
                    for (int i = 0; i <= MiConnectLauncherActivity.this.count; i++) {
                        sb.append(".");
                    }
                    MiConnectLauncherActivity.this.launcherTextView.setText(sb.toString());
                } else {
                    MiConnectLauncherActivity miConnectLauncherActivity = MiConnectLauncherActivity.this;
                    miConnectLauncherActivity.count = 0;
                    miConnectLauncherActivity.launcherTextView.setText(MiConnectLauncherActivity.this.getString(R.string.miconnect_loading));
                }
                MiConnectLauncherActivity.this.count++;
                MiConnectLauncherActivity.this.mHandler.postDelayed(MiConnectLauncherActivity.this.textAnimation, 400);
            }
        }
    };

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        dde.O000000o(getWindow());
        setContentView((int) R.layout.activity_miconnect_launcher_layout);
        ((TextView) findViewById(R.id.common_tile_tv)).setText((int) R.string.miconnect_discovery_new_device);
        this.launcherContent = (LinearLayout) findViewById(R.id.launch_content);
        this.launcherTextView = (TextView) findViewById(R.id.launcher_tv);
        dct.O00000oO("Launcher onCreate");
        dcv.O00000o0.O00000Oo = System.currentTimeMillis();
        this.mStateSaved = false;
        dcp O000000o2 = dcp.O000000o();
        String O00000o2 = O00000o();
        O000000o2.O0000Oo = true;
        O000000o2.O0000Oo0 = O00000o2;
        O000000o2.O00000o0 = false;
        if (O000000o2.O00000oo == null) {
            O000000o2.O00000oo = new dcp.O000000o(O000000o2, (byte) 0);
            getApplication().registerActivityLifecycleCallbacks(O000000o2.O00000oo);
        }
        dct.O00000oO("Miui start ");
        if (O000000o2.f14478O000000o == null) {
            synchronized (O000000o2) {
                if (O000000o2.f14478O000000o == null) {
                    O000000o2.f14478O000000o = getApplicationContext();
                }
            }
        }
        O000000o2.O00000o();
        SmartConfigRouterFactory.getSmartConfigManager().startCheck(new hum() {
            /* class com.xiaomi.miconnect.MiConnectLauncherActivity.AnonymousClass8 */

            public final void O000000o() {
                MiConnectLauncherActivity.this.finishConnect();
            }

            public final void O00000Oo() {
                MiConnectLauncherActivity.this.finishConnect();
            }

            public final void O00000o0() {
                if (MiConnectLauncherActivity.this.mStateSaved) {
                    fbt fbt = new fbt(MiConnectLauncherActivity.this, "SmartHomeMainActivity");
                    fbt.O00000Oo(67108864);
                    fbs.O000000o(fbt);
                    MiConnectLauncherActivity.this.finish();
                    return;
                }
                MiConnectLauncherActivity.this.doWork();
            }
        });
    }

    public void doWork() {
        if (!SmartConfigRouterFactory.getSmartConfigManager().isNetworkConnected(this)) {
            if (SmartConfigRouterFactory.getSmartConfigManager().isWifi() || !O00000oO()) {
                ddq ddq = new ddq();
                ddq.f14512O000000o = new Runnable() {
                    /* class com.xiaomi.miconnect.MiConnectLauncherActivity.AnonymousClass10 */

                    public final void run() {
                        MiConnectLauncherActivity.this.startActivity(new Intent("android.settings.SETTINGS"));
                        dcv.f14488O000000o.O00000Oo();
                        if (!MiConnectLauncherActivity.this.isFinishing()) {
                            MiConnectLauncherActivity.this.finish();
                        }
                    }
                };
                dcv.O00000Oo.O00000o0();
                ddq.show(getSupportFragmentManager(), "show no wifi dialog");
                return;
            }
            ddr ddr = new ddr();
            ddr.f14514O000000o = new Runnable() {
                /* class com.xiaomi.miconnect.MiConnectLauncherActivity.AnonymousClass9 */

                public final void run() {
                    MiConnectLauncherActivity.this.startActivity(new Intent("android.settings.WIFI_SETTINGS"));
                    dcv.f14488O000000o.O00000Oo();
                    if (!MiConnectLauncherActivity.this.isFinishing()) {
                        MiConnectLauncherActivity.this.finish();
                    }
                }
            };
            dcv.O00000Oo.O00000o0();
            ddr.show(getSupportFragmentManager(), "show no wifi dialog");
        } else if (!SmartConfigRouterFactory.getSmartConfigManager().isWifi() && O00000oO() && !SmartConfigRouterFactory.getSmartConfigManager().isWifi()) {
            ddr ddr2 = new ddr();
            ddr2.f14514O000000o = new Runnable() {
                /* class com.xiaomi.miconnect.MiConnectLauncherActivity.AnonymousClass11 */

                public final void run() {
                    MiConnectLauncherActivity.this.startActivity(new Intent("android.settings.WIFI_SETTINGS"));
                    dcv.f14488O000000o.O00000Oo();
                    if (!MiConnectLauncherActivity.this.isFinishing()) {
                        MiConnectLauncherActivity.this.finish();
                    }
                }
            };
            dcv.O00000Oo.O00000o0();
            ddr2.show(getSupportFragmentManager(), "show no wifi dialog");
        } else if (SmartConfigRouterFactory.getCoreApiManager().isMiLoggedIn()) {
            this.launcherContent.setVisibility(0);
            this.mHandler.post(this.textAnimation);
            this.mHandler.sendEmptyMessageDelayed(1001, 1000);
            startConnect();
        } else {
            this.loginDialog = new ddo();
            this.loginDialog.f14508O000000o = new Runnable() {
                /* class com.xiaomi.miconnect.MiConnectLauncherActivity.AnonymousClass13 */

                public final void run() {
                    dcv.f14488O000000o.f14489O000000o.O000000o("closeto_login_login", new Object[0]);
                    MiConnectLauncherActivity.this.gotoLoginPage();
                }
            };
            dct.O00000o0("show login dialog");
            dcv.O00000Oo.f14490O000000o.O000000o("closeto_login_no", new Object[0]);
            this.loginDialog.show(getSupportFragmentManager(), "show login dialog");
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1001) {
            dct.O00000oO("MiConnectConfigActivity onActivityResult");
            if (!SmartConfigRouterFactory.getSmartConfigManager().isLocationEnabled()) {
                finishConnect();
            } else {
                dcp.O000000o().O000000o(false);
                O00000Oo();
            }
        }
        dct.O00000oO("onActivityResult:".concat(String.valueOf(i)));
    }

    public void gotoLoginPage() {
        dct.O00000oO("gotoLoginPage");
        SmartConfigRouterFactory.getSmartConfigManager().startLogin(this, 5, new huj() {
            /* class com.xiaomi.miconnect.MiConnectLauncherActivity.AnonymousClass12 */

            public final void O000000o() {
                dct.O00000o0("onComplete");
                if (SmartConfigRouterFactory.getSmartConfigManager().isLoginSuccess()) {
                    if (MiConnectLauncherActivity.this.loginDialog != null) {
                        MiConnectLauncherActivity.this.loginDialog.dismiss();
                        MiConnectLauncherActivity.this.loginDialog = null;
                    }
                    MiConnectLauncherActivity.this.launcherContent.setVisibility(0);
                    MiConnectLauncherActivity.this.mHandler.post(MiConnectLauncherActivity.this.textAnimation);
                    MiConnectLauncherActivity.this.mHandler.sendEmptyMessageDelayed(1001, 1000);
                    MiConnectLauncherActivity.this.startConnect();
                    return;
                }
                MiConnectLauncherActivity.this.finishConnect();
            }
        });
    }

    public void startConnect() {
        SmartConfigRouterFactory.getHomeManager().init();
        dct.O00000oO("check coreReady");
        SmartConfigRouterFactory.getCoreApiManager().isCoreReady(this, new hug() {
            /* class com.xiaomi.miconnect.MiConnectLauncherActivity.AnonymousClass2 */

            public final void O000000o() {
                dct.O00000oO("check coreReady end");
                MiConnectLauncherActivity.this.mHandler.sendEmptyMessage(1001);
            }
        });
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fbt.O000000o(java.lang.String, android.os.Parcelable):_m_j.fbt
     arg types: [java.lang.String, com.xiaomi.smarthome.library.bluetooth.search.BluetoothSearchResult]
     candidates:
      _m_j.fbt.O000000o(java.lang.String, java.lang.Object):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.Class, java.lang.String):T
      _m_j.fbt.O000000o(java.lang.String, int):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, android.os.Bundle):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.io.Serializable):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.CharSequence):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.String):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.util.ArrayList<? extends android.os.Parcelable>):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, boolean):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.String[]):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, android.os.Parcelable):_m_j.fbt */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0212  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0216  */
    public void doConnect() {
        BluetoothSearchResult bluetoothSearchResult;
        BluetoothSearchResult bluetoothSearchResult2;
        boolean z;
        int i;
        ScanResult scanResult;
        ScanResult scanResult2;
        dct.O00000o0("startConnect timeout " + this.mTimeOut + " init " + SmartConfigRouterFactory.getHomeManager().isInited());
        dco.O000000o().O000000o(htn.O00000o());
        if (!SmartConfigRouterFactory.getHomeManager().isInited() && !this.mTimeOut) {
            if (SmartConfigRouterFactory.getHomeManager().isCurrentHomeExist()) {
                SmartConfigRouterFactory.getHomeManager().startSyncFromServerIfNeed();
            }
            ft.O000000o(this).O000000o(this.f6002O000000o, new IntentFilter("home_room_updated"));
            this.mHandler.sendEmptyMessageDelayed(1000, 4000);
            dct.O00000oO("doConnect no home");
        } else if (!O000000o()) {
        } else {
            if (O00000oo()) {
                O00000Oo();
                return;
            }
            Intent intent = getIntent();
            PluginDeviceInfo pluginInfo = SmartConfigRouterFactory.getCoreApiManager().getPluginInfo(SmartConfigRouterFactory.getCoreApiManager().getModelByProductId(intent.getIntExtra("pid", -1)));
            int O00000o2 = pluginInfo != null ? pluginInfo.O00000o() : -1;
            byte[] bArr = null;
            if (Build.VERSION.SDK_INT < 21 || (scanResult2 = (ScanResult) intent.getParcelableExtra("ble_result")) == null) {
                bluetoothSearchResult = null;
            } else {
                bluetoothSearchResult = new BluetoothSearchResult(scanResult2.getDevice(), scanResult2.getRssi(), scanResult2.getScanRecord() == null ? null : scanResult2.getScanRecord().getBytes());
            }
            boolean z2 = false;
            if ((O00000o2 == 3 || O00000o2 == 20 || O00000o2 == 2 || O00000o2 == 11 || O00000o2 == 25) && bluetoothSearchResult != null) {
                Intent intent2 = getIntent();
                int intExtra = intent2.getIntExtra("pid", -1);
                this.O00000oO = SmartConfigRouterFactory.getCoreApiManager().getModelByProductId(intExtra);
                dcv.O000000o(this.O00000oO);
                this.O00000oo = null;
                if (Build.VERSION.SDK_INT >= 21 && (scanResult = (ScanResult) intent2.getParcelableExtra("ble_result")) != null) {
                    if (scanResult.getScanRecord() != null) {
                        bArr = scanResult.getScanRecord().getBytes();
                    }
                    this.O00000oo = new BluetoothSearchResult(scanResult.getDevice(), scanResult.getRssi(), bArr);
                }
                dcp.O000000o().O00000Oo(this.O00000oO);
                if (intExtra == -1 || (bluetoothSearchResult2 = this.O00000oo) == null) {
                    dct.O00000o0("finishConnect pid " + intExtra + " model " + this.O00000oO);
                    finishConnect();
                    return;
                }
                if (bluetoothSearchResult2.O00000o0 != null) {
                    MiotBleAdvPacket O000000o2 = dda.O000000o(this.O00000oo.O00000o0);
                    if (O000000o2 != null) {
                        ffr.O00000Oo(this.O00000oo.O000000o(), intExtra);
                        ffr.O0000O0o(this.O00000oo.O000000o(), this.O00000oO);
                        if (!TextUtils.isEmpty(O000000o2.O00000o)) {
                            dct.O00000oO("setPropSMac " + dct.O000000o(O000000o2.O00000o));
                            ffr.O0000OOo(this.O00000oo.O000000o(), O000000o2.O00000o);
                        } else {
                            dct.O00000o0("setPropSMac packet mac = null");
                        }
                        dct.O00000oO("MiConnectLaunchActivity setPropProductId mac = " + dct.O000000o(O000000o2.O00000o) + " pid = " + intExtra);
                    }
                    if (!(O000000o2 == null || !O000000o2.O000000o() || O000000o2.O00000oo == null)) {
                        if (O000000o2 == null || O000000o2.f6871O000000o == null) {
                            i = 0;
                        } else {
                            i = O000000o2.f6871O000000o.O0000OOo;
                            if (!fea.O000000o(O000000o2.f6871O000000o.O0000Oo0)) {
                                fte.O00000Oo(" support version = " + O000000o2.f6871O000000o.O0000Oo0);
                                z = false;
                                if ((i != 0 || i == 2) && z) {
                                    fte.O00000Oo(" support authMode = ".concat(String.valueOf(i)));
                                    z2 = true;
                                } else {
                                    fte.O00000Oo("don't support authMode = ".concat(String.valueOf(i)));
                                }
                                if (z2) {
                                    O00000o0();
                                    return;
                                }
                                SmartConfigRouterFactory.getStatBindManager().initBindStep(this.O00000oO, 6);
                                fbt fbt = new fbt(this, "MiConnectConfigActivity");
                                fbt.O000000o("model", this.O00000oO);
                                fbt.O000000o("combo_ble_key", O000000o2.O00000oo);
                                fbt.O000000o("mac", this.O00000oo.O000000o());
                                fbt.O000000o("ble_result", (Parcelable) this.O00000oo);
                                dct.O00000o0("Launcher combo");
                                PluginDeviceInfo pluginInfo2 = SmartConfigRouterFactory.getCoreApiManager().getPluginInfo(this.O00000oO);
                                htx O000000o3 = hty.O000000o();
                                if (O000000o3 != null) {
                                    fbt = O000000o3.setQrStep(fbt, pluginInfo2.O00000o());
                                }
                                fbs.O000000o(fbt);
                                this.mTimeOut = true;
                                finish();
                                return;
                            }
                        }
                        z = true;
                        if (i != 0) {
                        }
                        fte.O00000Oo(" support authMode = ".concat(String.valueOf(i)));
                        z2 = true;
                        if (z2) {
                        }
                    }
                }
                O00000Oo();
            } else if (O0000O0o()) {
                O00000Oo();
            } else {
                O00000o0();
            }
        }
    }

    private boolean O000000o() {
        Intent intent = getIntent();
        int intExtra = intent.getIntExtra("pid", -1);
        if (intExtra == -1) {
            String stringExtra = intent.getStringExtra("pid");
            if (TextUtils.isEmpty(stringExtra)) {
                stringExtra = intent.getStringExtra("p");
            }
            try {
                intExtra = Integer.parseInt(stringExtra);
            } catch (Exception e) {
                dct.O00000o0(e.getLocalizedMessage());
            }
        }
        if (!TextUtils.isEmpty(SmartConfigRouterFactory.getCoreApiManager().getModelByProductId(intExtra))) {
            return true;
        }
        if (!this.mStateSaved) {
            this.mHandler.removeCallbacksAndMessages(null);
            this.launcherContent.setVisibility(8);
            ddl ddl = new ddl();
            ddl.f14499O000000o = new View.OnClickListener() {
                /* class com.xiaomi.miconnect.MiConnectLauncherActivity.AnonymousClass14 */

                public final void onClick(View view) {
                    dcv.f14488O000000o.f14489O000000o.O000000o("closeto_region_click", new Object[0]);
                    fbs.O000000o(new fbt(MiConnectLauncherActivity.this, "SmartHomeMainActivity"));
                    if (MiConnectLauncherActivity.this.isFinishing()) {
                        MiConnectLauncherActivity.this.finish();
                    }
                }
            };
            dcv.O00000Oo.f14490O000000o.O000000o("closeto_region_pop", new Object[0]);
            ddl.show(getSupportFragmentManager(), "Check Region Dialog");
        }
        return false;
    }

    private void O00000Oo() {
        if (SmartConfigRouterFactory.getSmartConfigManager().checkLocationGroupGranted()) {
            checkLocation();
            return;
        }
        dcp.O000000o().O000000o(true);
        SmartConfigRouterFactory.getSmartConfigManager().checkAndRequestCameraPermission(this, new htz() {
            /* class com.xiaomi.miconnect.MiConnectLauncherActivity.AnonymousClass3 */

            public final void O000000o() {
                dcp.O000000o().O000000o(false);
                MiConnectLauncherActivity.this.checkLocation();
            }

            public final void O00000Oo() {
                dcp.O000000o().O000000o(false);
                MiConnectLauncherActivity.this.finishConnect();
            }

            public final void O00000o0() {
                dcp.O000000o().O000000o(false);
                MiConnectLauncherActivity.this.finishConnect();
            }

            public final void O00000o() {
                MiConnectLauncherActivity.this.finishConnect();
            }
        }, getResources().getString(R.string.permission_location_rational_desc_new));
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
    public void checkLocation() {
        int i = 0;
        if (!SmartConfigRouterFactory.getSmartConfigManager().isLocationEnabled()) {
            MLAlertDialog O00000o2 = new MLAlertDialog.Builder(this).O00000Oo(getResources().getString(R.string.open_location_permission1)).O000000o(false).O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.miconnect.MiConnectLauncherActivity.AnonymousClass5 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    MiConnectLauncherActivity.this.finishConnect();
                    dcp.O000000o().O000000o(false);
                }
            }).O000000o((int) R.string.set_now, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.miconnect.MiConnectLauncherActivity.AnonymousClass4 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    dcp.O000000o().O000000o(true);
                    MiConnectLauncherActivity.this.startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 1001);
                }
            }).O00000o();
            if (!this.mStateSaved) {
                O00000o2.show();
            }
        } else if (O00000oo()) {
            Intent intent = getIntent();
            String stringExtra = intent.getStringExtra("a");
            int i2 = -1;
            try {
                i2 = Integer.parseInt(intent.getStringExtra("pid"));
            } catch (NumberFormatException e) {
                dct.O00000o0(e.getLocalizedMessage());
            }
            String stringExtra2 = intent.getStringExtra("did");
            String stringExtra3 = intent.getStringExtra("blemac");
            intent.getStringExtra("loginurl");
            fob.O00000o0();
            dcp.O000000o().O00000Oo(this.O00000oO);
            Intent intent2 = new Intent(this, MiConnectBleScanActivity.class);
            intent2.putExtra("ble_mac", stringExtra3);
            intent2.putExtra("aType", stringExtra);
            intent2.putExtra("did", stringExtra2);
            intent2.putExtra("pid", i2);
            startActivity(intent2);
            finish();
        } else if (O0000O0o()) {
            Intent intent3 = getIntent();
            String stringExtra4 = intent3.getStringExtra("p");
            String stringExtra5 = intent3.getStringExtra("m");
            String stringExtra6 = intent3.getStringExtra("O");
            try {
                i = Integer.parseInt(stringExtra4);
            } catch (Exception e2) {
                dct.O00000o0("processStandardQrCode " + e2.getLocalizedMessage());
            }
            String modelByProductId = SmartConfigRouterFactory.getCoreApiManager().getModelByProductId(i);
            fbt fbt = new fbt(this, "ResetDevicePage");
            fbt.O000000o("model", modelByProductId);
            fbt.O000000o("mac", stringExtra5);
            if (!TextUtils.isEmpty(stringExtra6)) {
                fbt.O000000o("key_qrcode_oob", stringExtra6);
            }
            fbt.O000000o("scan_from_miui", true);
            fbs.O000000o(fbt);
            finish();
        } else {
            String str = this.O00000oO;
            BluetoothSearchResult bluetoothSearchResult = this.O00000oo;
            SmartConfigRouterFactory.getStatBindManager().initBindStep(str, 6);
            Intent intent4 = new Intent();
            intent4.putExtra("model", str);
            intent4.putExtra("ble_result", bluetoothSearchResult);
            intent4.setClass(this, MiConnectBleMatchActivity.class);
            startActivity(intent4);
            this.mTimeOut = true;
            finish();
        }
    }

    private void O00000o0() {
        if (!this.mStateSaved) {
            dct.O00000Oo("showUpdateDialog");
            this.launcherContent.setVisibility(8);
            ddp ddp = new ddp();
            ddp.f14510O000000o = new Runnable() {
                /* class com.xiaomi.miconnect.MiConnectLauncherActivity.AnonymousClass6 */

                public final void run() {
                    MiConnectLauncherActivity.this.goUpdate();
                    MiConnectLauncherActivity.this.finishConnect();
                }
            };
            try {
                ddp.show(getSupportFragmentManager(), "need update mijia");
            } catch (IllegalStateException e) {
                e.printStackTrace();
                finishConnect();
            }
        }
    }

    public void goUpdate() {
        dct.O00000Oo("goUpdate");
        if ("GooglePlay".equals(gfr.O00000o)) {
            dct.O00000Oo("update in GooglePlay");
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=" + getPackageName()));
            intent.setPackage("com.android.vending");
            if (intent.resolveActivity(getPackageManager()) != null) {
                dct.O00000Oo("goto google play");
                startActivity(intent);
                return;
            }
            Intent intent2 = new Intent("android.intent.action.VIEW");
            intent2.addFlags(268435456);
            intent2.setData(Uri.parse("market://details?id=" + getPackageName()));
            if (intent2.resolveActivity(getPackageManager()) != null) {
                dct.O00000Oo("goto other store");
                startActivity(intent2);
                return;
            }
            intent2.setData(Uri.parse("https://play.google.com/store/apps/details?id=" + getPackageName()));
            if (intent2.resolveActivity(getPackageManager()) != null) {
                dct.O00000Oo("goto browser");
                startActivity(intent2);
                return;
            }
            return;
        }
        fbt fbt = new fbt(this, "UpdateActivity");
        fbt.O00000Oo(268435456);
        fbs.O000000o(fbt);
    }

    public void finishConnect() {
        dct.O00000o0("finishConnect");
        finish();
        dcp.O000000o().O000000o((Activity) this);
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == 1000) {
            dct.O00000oO("TIME_OUT");
            this.mTimeOut = true;
            startConnect();
        } else if (message.what != 1001) {
        } else {
            if (this.O0000O0o) {
                this.mHandler.removeCallbacks(this.textAnimation);
                doConnect();
                return;
            }
            this.O0000O0o = true;
        }
    }

    public void onDestroy() {
        super.onDestroy();
        dct.O00000oO("onDestroy");
        ft.O000000o(this).O000000o(this.f6002O000000o);
    }

    private String O00000o() {
        if (Build.VERSION.SDK_INT < 21) {
            return "";
        }
        try {
            ScanResult scanResult = (ScanResult) getIntent().getParcelableExtra("ble_result");
            if (scanResult == null || scanResult.getDevice() == null) {
                return "";
            }
            return scanResult.getDevice().getAddress();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private boolean O00000oO() {
        ScanResult scanResult;
        MiotBleAdvPacket O000000o2;
        if (O00000oo()) {
            return true;
        }
        Intent intent = getIntent();
        if (Build.VERSION.SDK_INT < 21 || (scanResult = (ScanResult) intent.getParcelableExtra("ble_result")) == null) {
            return false;
        }
        BluetoothSearchResult bluetoothSearchResult = new BluetoothSearchResult(scanResult.getDevice(), scanResult.getRssi(), scanResult.getScanRecord() == null ? null : scanResult.getScanRecord().getBytes());
        if (bluetoothSearchResult.O00000o0 == null || (O000000o2 = dda.O000000o(bluetoothSearchResult.O00000o0)) == null || !O000000o2.O000000o() || O000000o2.O00000oo == null) {
            return false;
        }
        return true;
    }

    private boolean O00000oo() {
        String stringExtra = getIntent().getStringExtra("f");
        return !TextUtils.isEmpty(stringExtra) && "fnetsuoiea".equalsIgnoreCase(stringExtra);
    }

    private boolean O0000O0o() {
        return !TextUtils.isEmpty(getIntent().getStringExtra("p"));
    }

    public void onSaveInstanceState(Bundle bundle) {
        this.mStateSaved = true;
        super.onSaveInstanceState(bundle);
    }
}

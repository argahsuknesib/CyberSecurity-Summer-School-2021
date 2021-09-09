package com.xiaomi.smarthome.framework.update.ui.group;

import _m_j.feo;
import _m_j.fes;
import _m_j.fgo;
import _m_j.fno;
import _m_j.fpo;
import _m_j.fqr;
import _m_j.ftd;
import _m_j.gnl;
import _m_j.gqb;
import _m_j.gqd;
import _m_j.gqg;
import _m_j.gsy;
import _m_j.hxi;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.os.PowerManager;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.exoplayer2.C;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.bluetooth.Response;
import com.xiaomi.smarthome.bluetooth.XmBluetoothDevice;
import com.xiaomi.smarthome.bluetooth.XmBluetoothManager;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.device.api.BleMeshFirmwareUpdateInfoV2;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.framework.update.ui.group.BleGroupMemberUpdateActivity;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleResponse;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.widget.ProgressButton;
import com.xiaomi.smarthome.library.log.LogType;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import java.io.File;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class BleGroupMemberUpdateActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private ListView f8755O000000o;
    private O00000Oo O00000Oo;
    private O000000o O00000o;
    private ArrayList<BleMeshFirmwareUpdateInfoV2> O00000o0;
    private TextView O00000oO;
    private TextView O00000oo;
    private View O0000O0o;
    private String O0000OOo;
    private PowerManager.WakeLock O0000Oo;
    private AtomicBoolean O0000Oo0 = new AtomicBoolean(false);
    public CompositeDisposable mDisposables = new CompositeDisposable();
    public List<O000000o> mUpdateItemList = new ArrayList();
    public AtomicBoolean sFirmwareLoading = new AtomicBoolean(false);
    public AtomicBoolean sFirmwareUpgrading = new AtomicBoolean(false);
    public AtomicBoolean sIsUpdating = new AtomicBoolean(false);
    public AtomicBoolean sMcuLoading = new AtomicBoolean(false);
    public AtomicBoolean sMcuUpgrading = new AtomicBoolean(false);

    enum UpdateStatus {
        PENDING,
        WATTING,
        WAITING_BUT_NOT_UPDATE,
        UPDATING,
        UPDATING_SUCCESS,
        UPDATING_FAILURE
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void O000000o(DialogInterface dialogInterface, int i) {
    }

    public static void open(Activity activity, List<BleMeshFirmwareUpdateInfoV2> list, ArrayList<KeyValuePair> arrayList, String str) {
        if (activity != null && list != null) {
            Intent intent = new Intent();
            intent.setClass(activity, BleGroupMemberUpdateActivity.class);
            intent.putExtra("members", (Serializable) list);
            intent.putExtra("group_did", str);
            intent.putParcelableArrayListExtra("key_no_ble_mesh_devices", arrayList);
            activity.startActivity(intent);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.widget.ListView, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_light_group_member_update);
        getWindow().addFlags(NotificationCompat.FLAG_HIGH_PRIORITY);
        Intent intent = getIntent();
        this.O00000o0 = (ArrayList) intent.getSerializableExtra("members");
        this.O0000OOo = intent.getStringExtra("group_did");
        Iterator<BleMeshFirmwareUpdateInfoV2> it = this.O00000o0.iterator();
        while (it.hasNext()) {
            BleMeshFirmwareUpdateInfoV2 next = it.next();
            Device O00000oo2 = fno.O000000o().O00000oo(next.did);
            if (O00000oo2 == null) {
                O00000oo2 = fno.O000000o().O000000o(next.did);
            }
            if (O00000oo2 != null) {
                O000000o o000000o = new O000000o();
                o000000o.O00000o0 = O00000oo2.model;
                o000000o.O00000o = O00000oo2.name;
                o000000o.O00000oO = O00000oo2.did;
                o000000o.O00000oo = O00000oo2.pid;
                o000000o.O0000O0o = O00000oo2.mac;
                o000000o.O0000OOo = next.currentVersion;
                o000000o.O0000Oo0 = next.version;
                o000000o.O0000Oo = next.changeLog;
                o000000o.O0000OoO = next.safeUrl;
                o000000o.O0000o0 = next.currentMcuVersion;
                o000000o.O0000o0O = next.mcuVersion;
                o000000o.O0000o0o = next.mcuSafeUrl;
                o000000o.O0000Ooo = next.timeout;
                o000000o.O0000o00 = next.uploadTime;
                this.mUpdateItemList.add(o000000o);
            }
        }
        ((TextView) findViewById(R.id.module_a_3_return_title)).setText((int) R.string.update_firmware);
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.update.ui.group.$$Lambda$BleGroupMemberUpdateActivity$8hMWyQRc3sw_xnwHYoUnw01T_g */

            public final void onClick(View view) {
                BleGroupMemberUpdateActivity.this.O00000Oo(view);
            }
        });
        this.O00000oO = (TextView) findViewById(R.id.onekey_upgrade);
        this.O00000oO.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.update.ui.group.$$Lambda$BleGroupMemberUpdateActivity$4_9nmUGphlQfvf_tIUQjnvgziA4 */

            public final void onClick(View view) {
                BleGroupMemberUpdateActivity.this.O000000o(view);
            }
        });
        TextView textView = this.O00000oO;
        ArrayList<BleMeshFirmwareUpdateInfoV2> arrayList = this.O00000o0;
        textView.setVisibility((arrayList == null || arrayList.isEmpty()) ? 4 : 0);
        findViewById(R.id.module_a_3_right_btn).setVisibility(8);
        this.f8755O000000o = (ListView) findViewById(R.id.listview);
        this.O00000oo = (TextView) findViewById(R.id.category);
        int size = this.mUpdateItemList.size();
        this.O00000oo.setText(gqb.O000000o(this, (int) R.plurals.fireware_update_size, size, Integer.valueOf(size)));
        if (this.f8755O000000o == null) {
            this.O00000oo.setVisibility(8);
        }
        View inflate = LayoutInflater.from(this).inflate((int) R.layout.update_ble_mesh_update_header, (ViewGroup) this.f8755O000000o, false);
        inflate.setBackgroundResource(R.color.mj_color_background);
        ((TextView) inflate.findViewById(R.id.category)).setText((int) R.string.ble_rssi_match_line_tips);
        if (this.f8755O000000o == null) {
            inflate.setVisibility(8);
        }
        this.f8755O000000o.addFooterView(inflate);
        this.O00000Oo = new O00000Oo();
        this.f8755O000000o.setAdapter((ListAdapter) this.O00000Oo);
        this.O0000O0o = findViewById(R.id.more_ota_device);
        this.O0000O0o.setVisibility(4);
        try {
            hxi.O00000o.O0000o0O(fno.O000000o().O00000oo(this.O00000o0.get(0).did).model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onBackPressed() {
        if (this.O0000Oo0.get() || this.sIsUpdating.get()) {
            new MLAlertDialog.Builder(this).O000000o((int) R.string.confirm, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.framework.update.ui.group.$$Lambda$BleGroupMemberUpdateActivity$nwbl_j55zt0Sa6mmwwgX8rFTK2s */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    BleGroupMemberUpdateActivity.this.O00000Oo(dialogInterface, i);
                }
            }).O00000Oo((int) R.string.sh_common_cancel, (DialogInterface.OnClickListener) null).O00000Oo((int) R.string.ble_mesh_upgrade_cancel).O00000Oo(true).O00000oo();
        } else {
            finish();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo(DialogInterface dialogInterface, int i) {
        finish();
    }

    public void onPause() {
        gsy.O00000o0(LogType.BLUETOOTH, "GroupMemberUpdate", "onPause: ");
        this.sIsUpdating.set(false);
        this.O0000Oo0.set(false);
        PowerManager.WakeLock wakeLock = this.O0000Oo;
        if (wakeLock != null) {
            wakeLock.release();
            this.O0000Oo = null;
        }
        if (this.sMcuLoading.get() && this.O00000o != null) {
            gsy.O00000o0(LogType.BLUETOOTH, "GroupMemberUpdate", "cancelBleMcuLoading: ");
            XmPluginHostApi.instance().cancelDownloadBleFirmware(this.O00000o.O0000o0o);
        }
        if (this.sMcuUpgrading.get() && this.O00000o != null) {
            gsy.O00000o0(LogType.BLUETOOTH, "GroupMemberUpdate", "cancelFirmwareLoading: ");
            XmBluetoothManager.getInstance().cancelBleMeshUpgrade(this.O00000o.O0000O0o);
        }
        if (this.sFirmwareUpgrading.get() && this.O00000o != null) {
            gsy.O00000o0(LogType.BLUETOOTH, "GroupMemberUpdate", "cancelBleMeshUpgrade: ");
            XmBluetoothManager.getInstance().cancelBleMeshUpgrade(this.O00000o.O0000O0o);
        }
        if (this.sFirmwareLoading.get() && this.O00000o != null) {
            gsy.O00000o0(LogType.BLUETOOTH, "GroupMemberUpdate", "cancelFirmwareLoading: ");
            XmPluginHostApi.instance().cancelDownloadBleFirmware(this.O00000o.O0000OoO);
        }
        super.onPause();
    }

    public void onDestroy() {
        gsy.O00000o0(LogType.BLUETOOTH, "GroupMemberUpdate", "onDestroy: ");
        super.onDestroy();
        this.mDisposables.clear();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo(View view) {
        onBackPressed();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(View view) {
        if (gnl.O00000Oo()) {
            O00000Oo();
        } else {
            fqr.O000000o(this, new BleResponse() {
                /* class com.xiaomi.smarthome.framework.update.ui.group.$$Lambda$BleGroupMemberUpdateActivity$tWvytSpr3JqIrAF6UBsuGn6nX84 */

                public final void onResponse(int i, Object obj) {
                    BleGroupMemberUpdateActivity.this.O000000o(i, obj);
                }
            });
        }
        try {
            hxi.O00000o.O0000o0O(fno.O000000o().O00000oo(this.O00000o0.get(0).did).model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(int i, Object obj) {
        hxi.O00000o.O00000o0();
        if (i == 0) {
            O00000Oo();
        }
    }

    private void O000000o() {
        int i = 0;
        for (O000000o o000000o : this.mUpdateItemList) {
            if (o000000o.f8765O000000o == UpdateStatus.UPDATING_SUCCESS) {
                i++;
            }
        }
        this.O00000oo.setTextColor(getResources().getColor(R.color.mj_color_green_normal));
        this.O00000oo.setText(i + "/" + gqb.O000000o(this, (int) R.plurals.fireware_update_succ_size, this.mUpdateItemList.size(), Integer.valueOf(this.mUpdateItemList.size())));
    }

    @SuppressLint({"InvalidWakeLockTag"})
    private void O00000Oo() {
        gsy.O00000o0(LogType.BLUETOOTH, "GroupMemberUpdate", "oneKeyUpgrade: ");
        if (!this.O0000Oo0.get()) {
            this.O0000Oo0.set(true);
            if (this.O0000Oo == null) {
                this.O0000Oo = ((PowerManager) getSystemService("power")).newWakeLock(6, "GroupMemberUpdate");
                this.O0000Oo.acquire();
            }
            O000000o(0);
        }
    }

    private void O000000o(long j) {
        if (this.O0000Oo0.get()) {
            gsy.O00000o0(LogType.BLUETOOTH, "GroupMemberUpdate", "upgradeNext: 一键更新");
            for (int i = 0; i < this.mUpdateItemList.size(); i++) {
                if (this.mUpdateItemList.get(i).f8765O000000o == UpdateStatus.PENDING) {
                    requestFirmwarUpdate(i, j, false);
                    return;
                }
            }
            this.O0000Oo0.set(false);
        }
    }

    public void startUpgrade(final O000000o o000000o, final boolean z) {
        if (o000000o != null && !this.sIsUpdating.getAndSet(true)) {
            this.O00000oO.setVisibility(4);
            this.O00000o = o000000o;
            for (O000000o next : this.mUpdateItemList) {
                if (next.f8765O000000o == UpdateStatus.PENDING && !TextUtils.equals(next.O00000oO, o000000o.O00000oO)) {
                    if (z) {
                        next.f8765O000000o = UpdateStatus.WAITING_BUT_NOT_UPDATE;
                    } else {
                        next.f8765O000000o = UpdateStatus.WATTING;
                    }
                }
            }
            o000000o.f8765O000000o = UpdateStatus.UPDATING;
            this.O00000Oo.notifyDataSetChanged();
            O000000o();
            gsy.O00000o0(LogType.BLUETOOTH, "GroupMemberUpdate", "bleMeshConnect");
            Observable.create(new ObservableOnSubscribe(o000000o) {
                /* class com.xiaomi.smarthome.framework.update.ui.group.$$Lambda$BleGroupMemberUpdateActivity$PjxbQE24nBUjExCCI6hsykSGvUM */
                private final /* synthetic */ BleGroupMemberUpdateActivity.O000000o f$1;

                {
                    this.f$1 = r2;
                }

                public final void subscribe(ObservableEmitter observableEmitter) {
                    BleGroupMemberUpdateActivity.this.O00000o(this.f$1, observableEmitter);
                }
            }).flatMap(new Function(o000000o) {
                /* class com.xiaomi.smarthome.framework.update.ui.group.$$Lambda$BleGroupMemberUpdateActivity$oUgTGS533nl7_zMREB1IW5vQ2SE */
                private final /* synthetic */ BleGroupMemberUpdateActivity.O000000o f$1;

                {
                    this.f$1 = r2;
                }

                public final Object apply(Object obj) {
                    return BleGroupMemberUpdateActivity.this.O00000o0(this.f$1, (Boolean) obj);
                }
            }).flatMap(new Function(o000000o) {
                /* class com.xiaomi.smarthome.framework.update.ui.group.$$Lambda$BleGroupMemberUpdateActivity$T99IkeyeM_yJV64MPOX9n9hL8 */
                private final /* synthetic */ BleGroupMemberUpdateActivity.O000000o f$1;

                {
                    this.f$1 = r2;
                }

                public final Object apply(Object obj) {
                    return BleGroupMemberUpdateActivity.this.O00000Oo(this.f$1, (String) obj);
                }
            }).flatMap(new Function(o000000o) {
                /* class com.xiaomi.smarthome.framework.update.ui.group.$$Lambda$BleGroupMemberUpdateActivity$FvxrnyWagWjh9lJdB0BXoHSto0k */
                private final /* synthetic */ BleGroupMemberUpdateActivity.O000000o f$1;

                {
                    this.f$1 = r2;
                }

                public final Object apply(Object obj) {
                    return BleGroupMemberUpdateActivity.this.O00000Oo(this.f$1, (Boolean) obj);
                }
            }).flatMap(new Function(o000000o) {
                /* class com.xiaomi.smarthome.framework.update.ui.group.$$Lambda$BleGroupMemberUpdateActivity$9a9a0bXCpdzjjL76RY3Lkh29oOI */
                private final /* synthetic */ BleGroupMemberUpdateActivity.O000000o f$1;

                {
                    this.f$1 = r2;
                }

                public final Object apply(Object obj) {
                    return BleGroupMemberUpdateActivity.this.O000000o(this.f$1, (String) obj);
                }
            }).flatMap(new Function() {
                /* class com.xiaomi.smarthome.framework.update.ui.group.$$Lambda$BleGroupMemberUpdateActivity$ZEyCOCR89FJDekzBBozIsOYfK44 */

                public final Object apply(Object obj) {
                    return Observable.create(new ObservableOnSubscribe() {
                        /* class com.xiaomi.smarthome.framework.update.ui.group.$$Lambda$BleGroupMemberUpdateActivity$bsZSCRREe1s0WxSOkZYsHAq2Kd0 */

                        public final void subscribe(ObservableEmitter observableEmitter) {
                            BleGroupMemberUpdateActivity.O000000o(BleGroupMemberUpdateActivity.O000000o.this, observableEmitter);
                        }
                    });
                }
            }).delay(5, TimeUnit.SECONDS).flatMap(new Function<Boolean, ObservableSource<Boolean>>() {
                /* class com.xiaomi.smarthome.framework.update.ui.group.BleGroupMemberUpdateActivity.AnonymousClass2 */

                public final /* synthetic */ Object apply(Object obj) throws Exception {
                    return BleGroupMemberUpdateActivity.this.createCheckIfUpgradeSuccessObservable(o000000o);
                }
            }).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<Boolean>() {
                /* class com.xiaomi.smarthome.framework.update.ui.group.BleGroupMemberUpdateActivity.AnonymousClass1 */

                public final void onSubscribe(Disposable disposable) {
                    BleGroupMemberUpdateActivity.this.mDisposables.add(disposable);
                    gsy.O00000o0(LogType.BLUETOOTH, "GroupMemberUpdate", "onSubscribe: ");
                }

                public final void onError(Throwable th) {
                    LogType logType = LogType.BLUETOOTH;
                    gsy.O00000o0(logType, "GroupMemberUpdate", "onError: " + th.getMessage());
                    gqg.O00000Oo(th.getMessage());
                    XmBluetoothManager.getInstance().disconnect(o000000o.O0000O0o);
                    BleGroupMemberUpdateActivity.this.upgradeFailed(o000000o, z);
                }

                public final void onComplete() {
                    gsy.O00000o0(LogType.BLUETOOTH, "GroupMemberUpdate", "onComplete: ");
                    XmBluetoothManager.getInstance().disconnect(o000000o.O0000O0o);
                    BleGroupMemberUpdateActivity.this.upgradeSuccess(o000000o, z);
                }

                public final /* synthetic */ void onNext(Object obj) {
                    gsy.O00000o0(LogType.BLUETOOTH, "GroupMemberUpdate", "onNext: ");
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000o(O000000o o000000o, ObservableEmitter observableEmitter) throws Exception {
        XmBluetoothManager.getInstance().bleMeshConnect(o000000o.O0000O0o, o000000o.O00000oO, new Response.BleConnectResponse(observableEmitter, o000000o) {
            /* class com.xiaomi.smarthome.framework.update.ui.group.$$Lambda$BleGroupMemberUpdateActivity$2IuARtai6u9lG9MMC66UBgOqzLE */
            private final /* synthetic */ ObservableEmitter f$1;
            private final /* synthetic */ BleGroupMemberUpdateActivity.O000000o f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onResponse(int i, Object obj) {
                BleGroupMemberUpdateActivity.this.O000000o(this.f$1, this.f$2, i, (Bundle) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(ObservableEmitter observableEmitter, O000000o o000000o, int i, Bundle bundle) {
        if (!observableEmitter.isDisposed()) {
            gsy.O00000o0(LogType.BLUETOOTH, "GroupMemberUpdate", "connectOnResponse: ".concat(String.valueOf(i)));
            if (!this.sIsUpdating.get() || i != 0) {
                observableEmitter.onError(new Exception("connectErr: ".concat(String.valueOf(i))));
                return;
            }
            o000000o.O00000Oo = 1.0f;
            updateView(this.mUpdateItemList.indexOf(o000000o));
            observableEmitter.onNext(Boolean.TRUE);
            observableEmitter.onComplete();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ObservableSource O00000o0(O000000o o000000o, Boolean bool) throws Exception {
        return Observable.create(new ObservableOnSubscribe(o000000o) {
            /* class com.xiaomi.smarthome.framework.update.ui.group.$$Lambda$BleGroupMemberUpdateActivity$QEOuQhDUgzJ5ytGlpngkkiEt8 */
            private final /* synthetic */ BleGroupMemberUpdateActivity.O000000o f$1;

            {
                this.f$1 = r2;
            }

            public final void subscribe(ObservableEmitter observableEmitter) {
                BleGroupMemberUpdateActivity.this.O00000o0(this.f$1, observableEmitter);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000o0(final O000000o o000000o, final ObservableEmitter observableEmitter) throws Exception {
        if (fpo.O000000o(o000000o.O0000o0O, o000000o.O0000o0) > 0) {
            this.sMcuLoading.set(true);
            gsy.O00000o0(LogType.BLUETOOTH, "GroupMemberUpdate", "downloadFirmware");
            XmPluginHostApi.instance().downloadFirmware(o000000o.O0000o0o, new Response.FirmwareUpgradeResponse() {
                /* class com.xiaomi.smarthome.framework.update.ui.group.BleGroupMemberUpdateActivity.AnonymousClass3 */

                public final void onProgress(int i) {
                    LogType logType = LogType.BLUETOOTH;
                    gsy.O00000o0(logType, "GroupMemberUpdate", "downloadFirmware pro: updateItem.mPercent: " + o000000o.O00000Oo);
                    if (!observableEmitter.isDisposed()) {
                        float f = (float) (i / 10);
                        if (f > o000000o.O00000Oo) {
                            o000000o.O00000Oo = f;
                            BleGroupMemberUpdateActivity bleGroupMemberUpdateActivity = BleGroupMemberUpdateActivity.this;
                            bleGroupMemberUpdateActivity.updateView(bleGroupMemberUpdateActivity.mUpdateItemList.indexOf(o000000o));
                        }
                    }
                }

                public final void onResponse(int i, String str, String str2) {
                    if (!observableEmitter.isDisposed()) {
                        gsy.O00000o0(LogType.BLUETOOTH, "GroupMemberUpdate", "downloadMcuOnResponse: ".concat(String.valueOf(i)));
                        gsy.O00000o0(LogType.BLUETOOTH, "GroupMemberUpdate", "path: ".concat(String.valueOf(str)));
                        BleGroupMemberUpdateActivity.this.sMcuLoading.set(false);
                        if (!BleGroupMemberUpdateActivity.this.sIsUpdating.get() || i != 0 || TextUtils.isEmpty(str)) {
                            observableEmitter.onError(new Exception("downloadBleFirmwareErr: ".concat(String.valueOf(i))));
                            return;
                        }
                        observableEmitter.onNext(str);
                        observableEmitter.onComplete();
                    }
                }
            });
            return;
        }
        observableEmitter.onNext("");
        observableEmitter.onComplete();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ObservableSource O00000Oo(O000000o o000000o, String str) throws Exception {
        return Observable.create(new ObservableOnSubscribe(str, o000000o) {
            /* class com.xiaomi.smarthome.framework.update.ui.group.$$Lambda$BleGroupMemberUpdateActivity$8gGyntpIiPx9U782GqeAClsVZA */
            private final /* synthetic */ String f$1;
            private final /* synthetic */ BleGroupMemberUpdateActivity.O000000o f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void subscribe(ObservableEmitter observableEmitter) {
                BleGroupMemberUpdateActivity.this.O00000Oo(this.f$1, this.f$2, observableEmitter);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo(final String str, final O000000o o000000o, final ObservableEmitter observableEmitter) throws Exception {
        if (TextUtils.isEmpty(str)) {
            observableEmitter.onNext(Boolean.TRUE);
            observableEmitter.onComplete();
            return;
        }
        boolean z = fpo.O000000o(o000000o.O0000Oo0, o000000o.O0000OOo) > 0;
        this.sMcuUpgrading.set(true);
        gsy.O00000o0(LogType.BLUETOOTH, "GroupMemberUpdate", "startMcuUpgrade");
        XmBluetoothManager.getInstance().startMcuUpgrade(o000000o.O0000O0o, o000000o.O0000o0, o000000o.O0000OOo, z, str, o000000o.O0000Ooo, new Response.BleUpgradeResponse() {
            /* class com.xiaomi.smarthome.framework.update.ui.group.BleGroupMemberUpdateActivity.AnonymousClass4 */

            public final boolean isMeshDevice() {
                return true;
            }

            public final /* synthetic */ void onResponse(int i, Object obj) {
                String str = (String) obj;
                gsy.O00000o0(LogType.BLUETOOTH, "GroupMemberUpdate", "startMcuUpgrade: ".concat(String.valueOf(i)));
                if (!observableEmitter.isDisposed()) {
                    BleGroupMemberUpdateActivity.this.sMcuUpgrading.set(false);
                    ftd.O00000o(str);
                    if (BleGroupMemberUpdateActivity.this.sIsUpdating.get() && i == 0) {
                        observableEmitter.onNext(Boolean.TRUE);
                        observableEmitter.onComplete();
                    } else if (i != 4) {
                        observableEmitter.onError(new Exception("McuUpgrade ".concat(String.valueOf(str))));
                    }
                }
            }

            public final void onProgress(int i) {
                gsy.O00000o0(LogType.BLUETOOTH, "GroupMemberUpdate", "startMcuUpgrade pro: ".concat(String.valueOf(i)));
                if (!observableEmitter.isDisposed()) {
                    float f = (float) (((i * 40) / 100) + 10);
                    if (f > o000000o.O00000Oo) {
                        o000000o.O00000Oo = f;
                        BleGroupMemberUpdateActivity bleGroupMemberUpdateActivity = BleGroupMemberUpdateActivity.this;
                        bleGroupMemberUpdateActivity.updateView(bleGroupMemberUpdateActivity.mUpdateItemList.indexOf(o000000o));
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ObservableSource O00000Oo(O000000o o000000o, Boolean bool) throws Exception {
        return Observable.create(new ObservableOnSubscribe(o000000o) {
            /* class com.xiaomi.smarthome.framework.update.ui.group.$$Lambda$BleGroupMemberUpdateActivity$dGWNLHrywuEIWZm4VHU6kW5hCc */
            private final /* synthetic */ BleGroupMemberUpdateActivity.O000000o f$1;

            {
                this.f$1 = r2;
            }

            public final void subscribe(ObservableEmitter observableEmitter) {
                BleGroupMemberUpdateActivity.this.O00000Oo(this.f$1, observableEmitter);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo(final O000000o o000000o, final ObservableEmitter observableEmitter) throws Exception {
        this.sFirmwareLoading.set(true);
        gsy.O00000o0(LogType.BLUETOOTH, "GroupMemberUpdate", "downloadFirmware firm ");
        XmPluginHostApi.instance().downloadFirmware(o000000o.O0000OoO, new Response.FirmwareUpgradeResponse() {
            /* class com.xiaomi.smarthome.framework.update.ui.group.BleGroupMemberUpdateActivity.AnonymousClass5 */

            public final void onProgress(int i) {
                gsy.O00000o0(LogType.BLUETOOTH, "GroupMemberUpdate", "downloadFirmware firm pro: ".concat(String.valueOf(i)));
                if (!observableEmitter.isDisposed()) {
                    float f = (float) (((i * 10) / 100) + 50);
                    if (f > o000000o.O00000Oo) {
                        o000000o.O00000Oo = f;
                        BleGroupMemberUpdateActivity bleGroupMemberUpdateActivity = BleGroupMemberUpdateActivity.this;
                        bleGroupMemberUpdateActivity.updateView(bleGroupMemberUpdateActivity.mUpdateItemList.indexOf(o000000o));
                    }
                }
            }

            public final void onResponse(int i, String str, String str2) {
                if (!observableEmitter.isDisposed()) {
                    gsy.O00000o0(LogType.BLUETOOTH, "GroupMemberUpdate", "downloadBleFirmwareOnResponse: ".concat(String.valueOf(i)));
                    gsy.O00000o0(LogType.BLUETOOTH, "GroupMemberUpdate", "path: ".concat(String.valueOf(str)));
                    BleGroupMemberUpdateActivity.this.sFirmwareLoading.set(false);
                    if (!BleGroupMemberUpdateActivity.this.sIsUpdating.get() || i != 0 || TextUtils.isEmpty(str)) {
                        observableEmitter.onError(new Exception("downloadBleFirmwareErr: ".concat(String.valueOf(i))));
                        return;
                    }
                    observableEmitter.onNext(str);
                    observableEmitter.onComplete();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ObservableSource O000000o(O000000o o000000o, String str) throws Exception {
        return Observable.create(new ObservableOnSubscribe(str, o000000o) {
            /* class com.xiaomi.smarthome.framework.update.ui.group.$$Lambda$BleGroupMemberUpdateActivity$HKlJ4IOeqnvbA_Foszme9FH1YE */
            private final /* synthetic */ String f$1;
            private final /* synthetic */ BleGroupMemberUpdateActivity.O000000o f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void subscribe(ObservableEmitter observableEmitter) {
                BleGroupMemberUpdateActivity.this.O000000o(this.f$1, this.f$2, observableEmitter);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(final String str, final O000000o o000000o, final ObservableEmitter observableEmitter) throws Exception {
        if (!observableEmitter.isDisposed()) {
            if (!new File(str).exists()) {
                observableEmitter.onError(new Exception("BleMeshUpgradeErr"));
            } else if (fpo.O000000o(o000000o.O0000Oo0, o000000o.O0000OOo) <= 0) {
                observableEmitter.onNext(Boolean.FALSE);
                observableEmitter.onComplete();
            } else {
                this.sFirmwareUpgrading.set(true);
                gsy.O00000o0(LogType.BLUETOOTH, "GroupMemberUpdate", "startBleMeshUpgrade");
                XmBluetoothManager.getInstance().startBleMeshUpgrade(o000000o.O0000O0o, o000000o.O00000oO, o000000o.O0000OOo, str, new Response.BleUpgradeResponse() {
                    /* class com.xiaomi.smarthome.framework.update.ui.group.BleGroupMemberUpdateActivity.AnonymousClass6 */

                    public final boolean isMeshDevice() {
                        return true;
                    }

                    public final /* synthetic */ void onResponse(int i, Object obj) {
                        String str = (String) obj;
                        gsy.O00000o0(LogType.BLUETOOTH, "GroupMemberUpdate", "BleMeshUpgradetOnResponse: ".concat(String.valueOf(i)));
                        if (!observableEmitter.isDisposed()) {
                            BleGroupMemberUpdateActivity.this.sFirmwareUpgrading.set(false);
                            ftd.O00000o(str);
                            if (!BleGroupMemberUpdateActivity.this.sIsUpdating.get() || i != 0) {
                                observableEmitter.onError(new Exception("BleMeshUpgradeErr ".concat(String.valueOf(str))));
                                return;
                            }
                            observableEmitter.onNext(Boolean.TRUE);
                            observableEmitter.onComplete();
                        }
                    }

                    public final void onProgress(int i) {
                        gsy.O00000o0(LogType.BLUETOOTH, "GroupMemberUpdate", "startBleMeshUpgrade firm pro = ".concat(String.valueOf(i)));
                        if (!observableEmitter.isDisposed()) {
                            float f = (float) (((i * 40) / 100) + 60);
                            if (f > o000000o.O00000Oo) {
                                o000000o.O00000Oo = f;
                                BleGroupMemberUpdateActivity bleGroupMemberUpdateActivity = BleGroupMemberUpdateActivity.this;
                                bleGroupMemberUpdateActivity.updateView(bleGroupMemberUpdateActivity.mUpdateItemList.indexOf(o000000o));
                            }
                        }
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void O000000o(O000000o o000000o, ObservableEmitter observableEmitter) throws Exception {
        XmBluetoothManager.getInstance().disconnect(o000000o.O0000O0o);
        observableEmitter.onNext(Boolean.TRUE);
        observableEmitter.onComplete();
    }

    public Observable<Boolean> createCheckIfUpgradeSuccessObservable(final O000000o o000000o) {
        return Observable.create(new ObservableOnSubscribe<Boolean>() {
            /* class com.xiaomi.smarthome.framework.update.ui.group.BleGroupMemberUpdateActivity.AnonymousClass7 */

            /* renamed from: O000000o  reason: collision with root package name */
            public AtomicBoolean f8762O000000o = new AtomicBoolean(false);

            public final void subscribe(final ObservableEmitter<Boolean> observableEmitter) throws Exception {
                XmBluetoothManager.getInstance().startScan(C.MSG_CUSTOM_BASE, 1, new XmBluetoothManager.BluetoothSearchResponse() {
                    /* class com.xiaomi.smarthome.framework.update.ui.group.BleGroupMemberUpdateActivity.AnonymousClass7.AnonymousClass1 */

                    public final void onSearchStarted() {
                        gsy.O00000o0(LogType.BLUETOOTH, "GroupMemberUpdate", "onSearchStarted: start search");
                    }

                    public final void onDeviceFounded(XmBluetoothDevice xmBluetoothDevice) {
                        if (AnonymousClass7.this.f8762O000000o.get()) {
                            gsy.O00000o0(LogType.BLUETOOTH, "GroupMemberUpdate", "onDeviceFounded: device already found,just ignore");
                        } else if (xmBluetoothDevice != null && xmBluetoothDevice.device != null && !TextUtils.isEmpty(o000000o.O0000O0o) && o000000o.O0000O0o.equalsIgnoreCase(xmBluetoothDevice.device.getAddress())) {
                            AnonymousClass7.this.f8762O000000o.set(true);
                            gsy.O00000o0(LogType.BLUETOOTH, "GroupMemberUpdate", "onDeviceFounded: device found, upgrade success");
                            XmBluetoothManager.getInstance().stopScan();
                            fgo.O00000Oo(o000000o.O00000oO, o000000o.O0000Oo0, new feo<Void, fes>() {
                                /* class com.xiaomi.smarthome.framework.update.ui.group.BleGroupMemberUpdateActivity.AnonymousClass7.AnonymousClass1.AnonymousClass1 */

                                public final void O000000o(fes fes) {
                                    String str;
                                    LogType logType = LogType.BLUETOOTH;
                                    StringBuilder sb = new StringBuilder("report ble firmware version fail, ");
                                    if (fes != null) {
                                        str = fes.O00000Oo;
                                    } else {
                                        str = "no detail message";
                                    }
                                    sb.append(str);
                                    gsy.O00000o0(logType, "GroupMemberUpdate", sb.toString());
                                }

                                public final /* synthetic */ void O000000o(Object obj) {
                                    gsy.O00000o0(LogType.BLUETOOTH, "GroupMemberUpdate", "report ble firmware version success");
                                }
                            });
                            if (!observableEmitter.isDisposed()) {
                                observableEmitter.onNext(Boolean.TRUE);
                                observableEmitter.onComplete();
                            }
                        }
                    }

                    public final void onSearchStopped() {
                        if (!AnonymousClass7.this.f8762O000000o.get()) {
                            gsy.O00000o0(LogType.BLUETOOTH, "GroupMemberUpdate", "onSearchStopped: haven't found target device yet");
                            observableEmitter.onError(new Exception("onSearchStopped,haven't found target device yet"));
                        }
                    }

                    public final void onSearchCanceled() {
                        if (!AnonymousClass7.this.f8762O000000o.get()) {
                            gsy.O00000o0(LogType.BLUETOOTH, "GroupMemberUpdate", "onSearchCanceled: haven't found target device yet");
                            observableEmitter.onError(new Exception("onSearchCanceled,haven't found target device yet"));
                        }
                    }
                });
            }
        });
    }

    public void upgradeFailed(O000000o o000000o, boolean z) {
        gsy.O00000o0(LogType.BLUETOOTH, "GroupMemberUpdate", "upgradeFailed: ");
        o000000o.O00000Oo = 0.0f;
        o000000o.f8765O000000o = UpdateStatus.UPDATING_FAILURE;
        for (O000000o next : this.mUpdateItemList) {
            if (!TextUtils.equals(next.O00000oO, o000000o.O00000oO) && (next.f8765O000000o == UpdateStatus.WATTING || next.f8765O000000o == UpdateStatus.WAITING_BUT_NOT_UPDATE)) {
                next.f8765O000000o = UpdateStatus.PENDING;
            }
        }
        this.O00000Oo.notifyDataSetChanged();
        new MLAlertDialog.Builder(this).O000000o((int) R.string.update_failure).O00000Oo((int) R.string.ble_new_connect_loading_title).O000000o((int) R.string.sh_confirm, $$Lambda$BleGroupMemberUpdateActivity$XCRE5opv5FYq2yA1xrSC4FVnNTY.INSTANCE).O000000o(false).O00000o().show();
        this.sIsUpdating.getAndSet(false);
        this.O00000o = null;
    }

    public void upgradeSuccess(O000000o o000000o, boolean z) {
        boolean z2;
        gsy.O00000o0(LogType.BLUETOOTH, "GroupMemberUpdate", "upgradeSuccess: ");
        o000000o.f8765O000000o = UpdateStatus.UPDATING_SUCCESS;
        for (O000000o next : this.mUpdateItemList) {
            if (!TextUtils.equals(next.O00000oO, o000000o.O00000oO) && (next.f8765O000000o == UpdateStatus.WATTING || next.f8765O000000o == UpdateStatus.WAITING_BUT_NOT_UPDATE)) {
                next.f8765O000000o = UpdateStatus.PENDING;
            }
        }
        int i = 0;
        while (true) {
            if (i >= this.mUpdateItemList.size()) {
                z2 = true;
                break;
            } else if (this.mUpdateItemList.get(i).f8765O000000o != UpdateStatus.UPDATING_SUCCESS) {
                z2 = false;
                break;
            } else {
                i++;
            }
        }
        if (z2) {
            Intent intent = new Intent(this, BleGroupUpgradeDectectActivity.class);
            intent.putExtra("arg_auth_type", 5);
            intent.putExtra("did", this.O0000OOo);
            startActivity(intent);
            finish();
            return;
        }
        this.O00000Oo.notifyDataSetChanged();
        O000000o();
        this.sIsUpdating.getAndSet(false);
        this.O00000o = null;
        if (!z) {
            O000000o(2000);
        }
    }

    public void handleMessage(Message message) {
        LogType logType = LogType.BLUETOOTH;
        gsy.O00000o0(logType, "GroupMemberUpdate", "handleMessage " + message.what);
        int i = message.what;
        Bundle data = message.getData();
        if (i >= this.mUpdateItemList.size() || data == null) {
            super.handleMessage(message);
            return;
        }
        startUpgrade(this.mUpdateItemList.get(i), data.getBoolean("is_one_update"));
    }

    public void requestFirmwarUpdate(int i, long j, boolean z) {
        if (i < this.mUpdateItemList.size()) {
            if (gnl.O00000Oo()) {
                this.mHandler.removeCallbacksAndMessages(null);
                Message message = new Message();
                message.what = i;
                Bundle bundle = new Bundle();
                bundle.putBoolean("is_one_update", z);
                message.setData(bundle);
                this.mHandler.sendMessageDelayed(message, j);
                return;
            }
            fqr.O000000o(this, new BleResponse(i, j) {
                /* class com.xiaomi.smarthome.framework.update.ui.group.$$Lambda$BleGroupMemberUpdateActivity$oE7FyMcaxIkjvtGcw72_zaxRfAo */
                private final /* synthetic */ int f$1;
                private final /* synthetic */ long f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void onResponse(int i, Object obj) {
                    BleGroupMemberUpdateActivity.this.O000000o(this.f$1, this.f$2, i, obj);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(int i, long j, int i2, Object obj) {
        hxi.O00000o.O00000o0();
        if (i2 == 0) {
            this.mHandler.removeCallbacksAndMessages(null);
            this.mHandler.sendEmptyMessageDelayed(i, j);
        }
    }

    class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        UpdateStatus f8765O000000o = UpdateStatus.PENDING;
        float O00000Oo = 0.0f;
        String O00000o;
        String O00000o0;
        String O00000oO;
        int O00000oo;
        String O0000O0o;
        String O0000OOo;
        String O0000Oo;
        String O0000Oo0;
        String O0000OoO;
        int O0000Ooo;
        String O0000o0;
        String O0000o00;
        String O0000o0O;
        String O0000o0o;

        O000000o() {
        }
    }

    public void updateView(int i) {
        int firstVisiblePosition;
        if (isValid() && i >= 0 && i < this.mUpdateItemList.size() && (firstVisiblePosition = i - this.f8755O000000o.getFirstVisiblePosition()) >= 0) {
            View childAt = this.f8755O000000o.getChildAt(firstVisiblePosition);
            O00000Oo o00000Oo = this.O00000Oo;
            if (childAt != null) {
                O00000o0 o00000o0 = (O00000o0) childAt.getTag();
                O000000o o000000o = BleGroupMemberUpdateActivity.this.mUpdateItemList.get(i);
                if (o00000o0.O00000oO.getButtonMode() != 1) {
                    o00000o0.O00000oO.setButtonMode(1);
                }
                o00000o0.O00000oO.setProgress((int) o000000o.O00000Oo);
                o00000o0.O00000oO.setText(((int) o000000o.O00000Oo) + "%");
            }
        }
    }

    public static String getDateString(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(Long.parseLong(str) * 1000));
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    class O00000Oo extends BaseAdapter {
        private final SparseBooleanArray O00000Oo = new SparseBooleanArray();

        public final long getItemId(int i) {
            return (long) i;
        }

        public O00000Oo() {
        }

        public final int getCount() {
            return BleGroupMemberUpdateActivity.this.mUpdateItemList.size();
        }

        public final Object getItem(int i) {
            return BleGroupMemberUpdateActivity.this.mUpdateItemList.get(i);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public final View getView(int i, View view, ViewGroup viewGroup) {
            O00000o0 o00000o0;
            String str;
            String str2;
            if (view == null) {
                view = BleGroupMemberUpdateActivity.this.getLayoutInflater().inflate((int) R.layout.update_ble_group_update_item, viewGroup, false);
                o00000o0 = new O00000o0();
                o00000o0.f8767O000000o = view.findViewById(R.id.bottom_divider);
                o00000o0.O00000Oo = (SimpleDraweeView) view.findViewById(R.id.icon);
                o00000o0.O00000o0 = (TextView) view.findViewById(R.id.title);
                o00000o0.O00000o = (TextView) view.findViewById(R.id.sub_title_1);
                o00000o0.O00000oO = (ProgressButton) view.findViewById(R.id.update_btn);
                o00000o0.O00000oo = (TextView) view.findViewById(R.id.expandable_text);
                o00000o0.O0000O0o = (TextView) view.findViewById(R.id.change_time);
                view.setTag(o00000o0);
            } else {
                o00000o0 = (O00000o0) view.getTag();
                o00000o0.f8767O000000o.setVisibility(8);
                o00000o0.O00000Oo.setImageURI(gqd.O000000o((int) R.drawable.device_list_phone_no));
                o00000o0.O00000o0.setText("");
                o00000o0.O00000o.setText("");
                o00000o0.O00000oO.setText("");
                o00000o0.O00000oO.setBackgroundResource(R.drawable.ble_mesh_item_button_pending_shape);
                o00000o0.O00000oO.setButtonMode(0);
                o00000o0.O00000oO.setTextColor(BleGroupMemberUpdateActivity.this.getResources().getColor(R.color.mj_color_green_normal));
                o00000o0.O00000oo.setText("");
                o00000o0.O0000O0o.setText("");
            }
            if (i == BleGroupMemberUpdateActivity.this.mUpdateItemList.size() - 1) {
                o00000o0.f8767O000000o.setVisibility(0);
            }
            O000000o o000000o = BleGroupMemberUpdateActivity.this.mUpdateItemList.get(i);
            if (!TextUtils.isEmpty(o000000o.O00000o)) {
                o00000o0.O00000o0.setText(o000000o.O00000o);
            } else {
                o00000o0.O00000o0.setText(BleGroupMemberUpdateActivity.this.getString(R.string.update_unknown_device));
            }
            if (TextUtils.isEmpty(o000000o.O0000o0)) {
                str = o000000o.O0000OOo;
            } else {
                str = o000000o.O0000OOo + "." + o000000o.O0000o0;
            }
            if (TextUtils.isEmpty(o000000o.O0000o0O)) {
                str2 = o000000o.O0000Oo0;
            } else {
                str2 = o000000o.O0000Oo0 + "." + o000000o.O0000o0O;
            }
            o00000o0.O00000o.setText(str + " → " + str2);
            DeviceFactory.O00000Oo(o000000o.O00000o0, o00000o0.O00000Oo);
            o00000o0.O00000oo.setText(BleGroupMemberUpdateActivity.this.getString(R.string.fireware_update_content) + o000000o.O0000Oo);
            o00000o0.O00000oo.setWidth(400);
            o00000o0.O0000O0o.setText(BleGroupMemberUpdateActivity.this.getString(R.string.fireware_update_time) + BleGroupMemberUpdateActivity.getDateString(o000000o.O0000o00));
            if (o000000o.f8765O000000o == UpdateStatus.PENDING) {
                o00000o0.O00000oO.setText(BleGroupMemberUpdateActivity.this.getString(R.string.update));
            } else if (o000000o.f8765O000000o == UpdateStatus.WATTING) {
                o00000o0.O00000oO.setTextColor(BleGroupMemberUpdateActivity.this.getResources().getColor(R.color.mj_color_gray_lighter));
                o00000o0.O00000oO.setBackgroundResource(R.drawable.ble_mesh_item_button_waiting_shape);
                o00000o0.O00000oO.setText(BleGroupMemberUpdateActivity.this.getString(R.string.watting));
            } else if (o000000o.f8765O000000o == UpdateStatus.WAITING_BUT_NOT_UPDATE) {
                o00000o0.O00000oO.setTextColor(BleGroupMemberUpdateActivity.this.getResources().getColor(R.color.mj_color_gray_lighter));
                o00000o0.O00000oO.setBackgroundResource(R.drawable.ble_mesh_item_button_waiting_shape);
                o00000o0.O00000oO.setText(BleGroupMemberUpdateActivity.this.getString(R.string.update));
            } else if (o000000o.f8765O000000o == UpdateStatus.UPDATING) {
                if (o00000o0.O00000oO.getButtonMode() != 1) {
                    o00000o0.O00000oO.setButtonMode(1);
                }
                o00000o0.O00000oO.setProgress((int) o000000o.O00000Oo);
                o00000o0.O00000oO.setText(((int) o000000o.O00000Oo) + "%");
            } else if (o000000o.f8765O000000o == UpdateStatus.UPDATING_SUCCESS) {
                o00000o0.O00000oO.setBackgroundResource(R.drawable.ble_mesh_update_button_normal_shape);
                o00000o0.O00000oO.setTextColor(BleGroupMemberUpdateActivity.this.getResources().getColor(R.color.mj_color_white));
                o00000o0.O00000oO.setText(BleGroupMemberUpdateActivity.this.getString(R.string.mj_complete));
            } else if (o000000o.f8765O000000o == UpdateStatus.UPDATING_FAILURE) {
                o00000o0.O00000oO.setText(BleGroupMemberUpdateActivity.this.getString(R.string.mj_retry));
            }
            o00000o0.O00000oO.setTag(o000000o);
            o00000o0.O00000oO.setOnClickListener(new View.OnClickListener(i) {
                /* class com.xiaomi.smarthome.framework.update.ui.group.$$Lambda$BleGroupMemberUpdateActivity$O00000Oo$iZvAmmYEWcXSIO62TTwAIV85FkI */
                private final /* synthetic */ int f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    BleGroupMemberUpdateActivity.O00000Oo.this.O000000o(this.f$1, view);
                }
            });
            return view;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O000000o(int i, View view) {
            O000000o o000000o = (O000000o) view.getTag();
            if (o000000o.f8765O000000o != UpdateStatus.UPDATING && o000000o.f8765O000000o != UpdateStatus.UPDATING_SUCCESS && o000000o.f8765O000000o != UpdateStatus.WATTING) {
                if ((o000000o.f8765O000000o == UpdateStatus.PENDING || o000000o.f8765O000000o == UpdateStatus.UPDATING_FAILURE) && !BleGroupMemberUpdateActivity.this.sIsUpdating.get()) {
                    BleGroupMemberUpdateActivity.this.requestFirmwarUpdate(i, 0, true);
                }
            }
        }
    }

    class O00000o0 {

        /* renamed from: O000000o  reason: collision with root package name */
        View f8767O000000o;
        SimpleDraweeView O00000Oo;
        TextView O00000o;
        TextView O00000o0;
        ProgressButton O00000oO;
        TextView O00000oo;
        TextView O0000O0o;

        O00000o0() {
        }
    }
}

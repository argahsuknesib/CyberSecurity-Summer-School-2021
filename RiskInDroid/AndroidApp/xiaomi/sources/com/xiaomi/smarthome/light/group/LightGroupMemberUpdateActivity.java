package com.xiaomi.smarthome.light.group;

import _m_j.fbs;
import _m_j.fbt;
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
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.os.Parcelable;
import android.os.PowerManager;
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
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.bluetooth.Response;
import com.xiaomi.smarthome.bluetooth.XmBluetoothManager;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.device.api.BleMeshFirmwareUpdateInfoV2;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleResponse;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.widget.ProgressButton;
import com.xiaomi.smarthome.light.group.LightGroupMemberUpdateActivity;
import com.xiaomi.smarthome.newui.widget.ExpandableTextView;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

public class LightGroupMemberUpdateActivity extends BaseActivity {
    public static final String TAG = "LightGroupMemberUpdateActivity";

    /* renamed from: O000000o  reason: collision with root package name */
    private ListView f9360O000000o;
    private O00000Oo O00000Oo;
    private ArrayList<KeyValuePair> O00000o;
    private ArrayList<BleMeshFirmwareUpdateInfoV2> O00000o0;
    private O000000o O00000oO;
    private TextView O00000oo;
    private TextView O0000O0o;
    private View O0000OOo;
    private PowerManager.WakeLock O0000Oo;
    private AtomicBoolean O0000Oo0 = new AtomicBoolean(false);
    public CompositeDisposable mDisposables = new CompositeDisposable();
    public List<O000000o> mUpdateItemList = new ArrayList();
    public AtomicBoolean sFirmwareLoading = new AtomicBoolean(false);
    public AtomicBoolean sFirmwareUpgrading = new AtomicBoolean(false);
    public AtomicBoolean sIsUpdating = new AtomicBoolean(false);

    enum UpdateStatus {
        PENDING,
        WATTING,
        UPDATING,
        UPDATING_SUCCESS,
        UPDATING_FAILURE
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
        Intent intent = getIntent();
        this.O00000o0 = (ArrayList) intent.getSerializableExtra("members");
        this.O00000o = (ArrayList) intent.getParcelableExtra("key_no_ble_mesh_devices");
        Iterator<BleMeshFirmwareUpdateInfoV2> it = this.O00000o0.iterator();
        while (it.hasNext()) {
            BleMeshFirmwareUpdateInfoV2 next = it.next();
            Device O00000oo2 = fno.O000000o().O00000oo(next.did);
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
                o000000o.O0000Ooo = next.uploadTime;
                this.mUpdateItemList.add(o000000o);
            }
        }
        ((TextView) findViewById(R.id.module_a_3_return_title)).setText((int) R.string.update_firmware);
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.light.group.$$Lambda$LightGroupMemberUpdateActivity$zB0JdL6SzYHXaQiTkcnsMgCVWPk */

            public final void onClick(View view) {
                LightGroupMemberUpdateActivity.this.O00000o0(view);
            }
        });
        this.O00000oo = (TextView) findViewById(R.id.onekey_upgrade);
        this.O00000oo.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.light.group.$$Lambda$LightGroupMemberUpdateActivity$Kb3n0PPe_LD2RxwfGBWnegLFeE */

            public final void onClick(View view) {
                LightGroupMemberUpdateActivity.this.O00000Oo(view);
            }
        });
        TextView textView = this.O00000oo;
        ArrayList<BleMeshFirmwareUpdateInfoV2> arrayList = this.O00000o0;
        int i = 4;
        textView.setVisibility((arrayList == null || arrayList.isEmpty()) ? 4 : 0);
        findViewById(R.id.module_a_3_right_btn).setVisibility(8);
        this.f9360O000000o = (ListView) findViewById(R.id.listview);
        this.O0000O0o = (TextView) findViewById(R.id.category);
        int size = this.mUpdateItemList.size();
        this.O0000O0o.setText(gqb.O000000o(this, (int) R.plurals.fireware_update_size, size, Integer.valueOf(size)));
        if (this.f9360O000000o == null) {
            this.O0000O0o.setVisibility(8);
        }
        View inflate = LayoutInflater.from(this).inflate((int) R.layout.update_ble_mesh_update_header, (ViewGroup) this.f9360O000000o, false);
        inflate.setBackgroundResource(R.color.mj_color_background);
        ((TextView) inflate.findViewById(R.id.category)).setText((int) R.string.ble_rssi_match_line_tips);
        if (this.f9360O000000o == null) {
            inflate.setVisibility(8);
        }
        this.f9360O000000o.addFooterView(inflate);
        this.O00000Oo = new O00000Oo();
        this.f9360O000000o.setAdapter((ListAdapter) this.O00000Oo);
        this.O0000OOo = findViewById(R.id.more_ota_device);
        this.O0000OOo.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.light.group.$$Lambda$LightGroupMemberUpdateActivity$Slihonolrj7dmYhebGXmB4vYO0 */

            public final void onClick(View view) {
                LightGroupMemberUpdateActivity.this.O000000o(view);
            }
        });
        View view = this.O0000OOo;
        ArrayList<KeyValuePair> arrayList2 = this.O00000o;
        if (arrayList2 != null && !arrayList2.isEmpty()) {
            i = 0;
        }
        view.setVisibility(i);
        try {
            hxi.O00000o.O0000o0O(fno.O000000o().O00000oo(this.O00000o0.get(0).did).model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onBackPressed() {
        if (this.O0000Oo0.get() || this.sIsUpdating.get()) {
            new MLAlertDialog.Builder(this).O000000o((int) R.string.confirm, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.light.group.$$Lambda$LightGroupMemberUpdateActivity$aDANEguuvEhBMaVNTRbbZWa3e4 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    LightGroupMemberUpdateActivity.this.O000000o(dialogInterface, i);
                }
            }).O00000Oo((int) R.string.sh_common_cancel, (DialogInterface.OnClickListener) null).O00000Oo((int) R.string.ble_mesh_upgrade_cancel).O00000Oo(true).O00000oo();
        } else {
            finish();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(DialogInterface dialogInterface, int i) {
        finish();
    }

    public void onPause() {
        gsy.O00000Oo(TAG, "onPause: ");
        this.sIsUpdating.set(false);
        this.O0000Oo0.set(false);
        PowerManager.WakeLock wakeLock = this.O0000Oo;
        if (wakeLock != null) {
            wakeLock.release();
            this.O0000Oo = null;
        }
        if (this.sFirmwareUpgrading.get() && this.O00000oO != null) {
            gsy.O00000Oo(TAG, "cancelBleMeshUpgrade: ");
            XmBluetoothManager.getInstance().cancelBleMeshUpgrade(this.O00000oO.O0000O0o);
        }
        if (this.sFirmwareLoading.get() && this.O00000oO != null) {
            gsy.O00000Oo(TAG, "cancelFirmwareLoading: ");
            XmPluginHostApi.instance().cancelDownloadBleFirmware(this.O00000oO.O0000OoO);
        }
        super.onPause();
    }

    public void onDestroy() {
        gsy.O00000Oo(TAG, "onDestroy: ");
        super.onDestroy();
        this.mDisposables.clear();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000o0(View view) {
        onBackPressed();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo(View view) {
        if (gnl.O00000Oo()) {
            O00000Oo();
        } else {
            fqr.O000000o(this, new BleResponse() {
                /* class com.xiaomi.smarthome.light.group.$$Lambda$LightGroupMemberUpdateActivity$TxyjBrOl0dwJlXWum8c3ZcDw9sM */

                public final void onResponse(int i, Object obj) {
                    LightGroupMemberUpdateActivity.this.O000000o(i, obj);
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

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fbt.O000000o(java.lang.String, java.util.ArrayList<? extends android.os.Parcelable>):_m_j.fbt
     arg types: [java.lang.String, java.util.ArrayList<com.xiaomi.smarthome.core.entity.net.KeyValuePair>]
     candidates:
      _m_j.fbt.O000000o(java.lang.String, java.lang.Object):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.Class, java.lang.String):T
      _m_j.fbt.O000000o(java.lang.String, int):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, android.os.Bundle):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, android.os.Parcelable):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.io.Serializable):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.CharSequence):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.String):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, boolean):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.String[]):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.util.ArrayList<? extends android.os.Parcelable>):_m_j.fbt */
    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(View view) {
        fbt fbt = new fbt(getContext(), "UpdateActivity");
        fbt.O000000o("arg_did_list", (ArrayList<? extends Parcelable>) this.O00000o);
        fbs.O000000o(fbt);
    }

    private void O000000o() {
        int i = 0;
        for (O000000o o000000o : this.mUpdateItemList) {
            if (o000000o.f9364O000000o == UpdateStatus.UPDATING_SUCCESS) {
                i++;
            }
        }
        this.O0000O0o.setTextColor(getResources().getColor(R.color.mj_color_green_normal));
        this.O0000O0o.setText(i + "/" + gqb.O000000o(this, (int) R.plurals.fireware_update_succ_size, this.mUpdateItemList.size(), Integer.valueOf(this.mUpdateItemList.size())));
    }

    private void O00000Oo() {
        gsy.O00000Oo(TAG, "oneKeyUpgrade: ");
        if (!this.O0000Oo0.get()) {
            this.O0000Oo0.set(true);
            if (this.O0000Oo == null) {
                this.O0000Oo = ((PowerManager) getSystemService("power")).newWakeLock(6, TAG);
                this.O0000Oo.acquire();
            }
            O000000o(0);
        }
    }

    private void O000000o(long j) {
        if (this.O0000Oo0.get()) {
            gsy.O00000Oo(TAG, "upgradeNext: 一键更新");
            for (int i = 0; i < this.mUpdateItemList.size(); i++) {
                if (this.mUpdateItemList.get(i).f9364O000000o == UpdateStatus.PENDING) {
                    requestFirmwarUpdate(i, j);
                    return;
                }
            }
            this.O0000Oo0.set(false);
        }
    }

    public void startUpgrade(final O000000o o000000o) {
        if (o000000o != null && !this.sIsUpdating.getAndSet(true)) {
            this.O00000oo.setVisibility(4);
            this.O00000oO = o000000o;
            for (O000000o next : this.mUpdateItemList) {
                if (next.f9364O000000o == UpdateStatus.PENDING && !TextUtils.equals(next.O00000oO, o000000o.O00000oO)) {
                    next.f9364O000000o = UpdateStatus.WATTING;
                }
            }
            o000000o.f9364O000000o = UpdateStatus.UPDATING;
            this.O00000Oo.notifyDataSetChanged();
            O000000o();
            Observable.create(new ObservableOnSubscribe(o000000o) {
                /* class com.xiaomi.smarthome.light.group.$$Lambda$LightGroupMemberUpdateActivity$bZmlBXS5kwF49brXhQw7Y1rYQU */
                private final /* synthetic */ LightGroupMemberUpdateActivity.O000000o f$1;

                {
                    this.f$1 = r2;
                }

                public final void subscribe(ObservableEmitter observableEmitter) {
                    LightGroupMemberUpdateActivity.this.O00000o0(this.f$1, observableEmitter);
                }
            }).flatMap(new Function(o000000o) {
                /* class com.xiaomi.smarthome.light.group.$$Lambda$LightGroupMemberUpdateActivity$bSDlG7du1DXqxME1k4_DsywolE */
                private final /* synthetic */ LightGroupMemberUpdateActivity.O000000o f$1;

                {
                    this.f$1 = r2;
                }

                public final Object apply(Object obj) {
                    return LightGroupMemberUpdateActivity.this.O00000Oo(this.f$1, (Boolean) obj);
                }
            }).flatMap(new Function(o000000o) {
                /* class com.xiaomi.smarthome.light.group.$$Lambda$LightGroupMemberUpdateActivity$coo5vZZnkhMNu3JnQPdDJOuwxlA */
                private final /* synthetic */ LightGroupMemberUpdateActivity.O000000o f$1;

                {
                    this.f$1 = r2;
                }

                public final Object apply(Object obj) {
                    return LightGroupMemberUpdateActivity.this.O000000o(this.f$1, (Boolean) obj);
                }
            }).flatMap(new Function(o000000o) {
                /* class com.xiaomi.smarthome.light.group.$$Lambda$LightGroupMemberUpdateActivity$gsSDYCs9UKqsNHhtXvtA9LuqnQ */
                private final /* synthetic */ LightGroupMemberUpdateActivity.O000000o f$1;

                {
                    this.f$1 = r2;
                }

                public final Object apply(Object obj) {
                    return LightGroupMemberUpdateActivity.this.O000000o(this.f$1, (String) obj);
                }
            }).subscribe(new Observer<Boolean>() {
                /* class com.xiaomi.smarthome.light.group.LightGroupMemberUpdateActivity.AnonymousClass1 */

                public final void onSubscribe(Disposable disposable) {
                    LightGroupMemberUpdateActivity.this.mDisposables.add(disposable);
                    gsy.O00000Oo(LightGroupMemberUpdateActivity.TAG, "onSubscribe: ");
                }

                public final void onError(Throwable th) {
                    String str = LightGroupMemberUpdateActivity.TAG;
                    gsy.O00000Oo(str, "onError: " + th.getMessage());
                    gqg.O00000Oo(th.getMessage());
                    XmBluetoothManager.getInstance().disconnect(o000000o.O0000O0o);
                    if (TextUtils.equals(th.getMessage(), "no_need_to_update")) {
                        LightGroupMemberUpdateActivity.this.upgradeSuccess(o000000o);
                    } else {
                        LightGroupMemberUpdateActivity.this.upgradeFailed(o000000o);
                    }
                }

                public final void onComplete() {
                    gsy.O00000Oo(LightGroupMemberUpdateActivity.TAG, "onComplete: ");
                    XmBluetoothManager.getInstance().disconnect(o000000o.O0000O0o);
                    LightGroupMemberUpdateActivity.this.upgradeSuccess(o000000o);
                }

                public final /* synthetic */ void onNext(Object obj) {
                    gsy.O00000Oo(LightGroupMemberUpdateActivity.TAG, "onNext: ");
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000o0(O000000o o000000o, ObservableEmitter observableEmitter) throws Exception {
        XmBluetoothManager.getInstance().bleMeshConnect(o000000o.O0000O0o, o000000o.O00000oO, new Response.BleConnectResponse(observableEmitter, o000000o) {
            /* class com.xiaomi.smarthome.light.group.$$Lambda$LightGroupMemberUpdateActivity$v2vJxwvgy54Xol7_NsPgDgvYbI */
            private final /* synthetic */ ObservableEmitter f$1;
            private final /* synthetic */ LightGroupMemberUpdateActivity.O000000o f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onResponse(int i, Object obj) {
                LightGroupMemberUpdateActivity.this.O000000o(this.f$1, this.f$2, i, (Bundle) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(ObservableEmitter observableEmitter, O000000o o000000o, int i, Bundle bundle) {
        if (!observableEmitter.isDisposed()) {
            gsy.O00000Oo(TAG, "connectOnResponse: ".concat(String.valueOf(i)));
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
    public /* synthetic */ ObservableSource O00000Oo(O000000o o000000o, Boolean bool) throws Exception {
        return Observable.create(new ObservableOnSubscribe(o000000o) {
            /* class com.xiaomi.smarthome.light.group.$$Lambda$LightGroupMemberUpdateActivity$6iJLLuCKkTYDwEV6atlBua7Bluo */
            private final /* synthetic */ LightGroupMemberUpdateActivity.O000000o f$1;

            {
                this.f$1 = r2;
            }

            public final void subscribe(ObservableEmitter observableEmitter) {
                LightGroupMemberUpdateActivity.this.O00000Oo(this.f$1, observableEmitter);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo(O000000o o000000o, ObservableEmitter observableEmitter) throws Exception {
        XmBluetoothManager.getInstance().getBleMeshFirmwareVersion(o000000o.O0000O0o, new Response.BleReadFirmwareVersionResponse(observableEmitter, o000000o) {
            /* class com.xiaomi.smarthome.light.group.$$Lambda$LightGroupMemberUpdateActivity$CpMI2OprnmtOsJrzahhBd61Vd8o */
            private final /* synthetic */ ObservableEmitter f$1;
            private final /* synthetic */ LightGroupMemberUpdateActivity.O000000o f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onResponse(int i, Object obj) {
                LightGroupMemberUpdateActivity.this.O000000o(this.f$1, this.f$2, i, (String) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(ObservableEmitter observableEmitter, O000000o o000000o, int i, String str) {
        if (!observableEmitter.isDisposed()) {
            gsy.O00000Oo(TAG, "getBleMeshFirmwareVersion: ".concat(String.valueOf(i)));
            if (!this.sIsUpdating.get() || i != 0) {
                observableEmitter.onError(new Exception("getBleMeshFirmwareVersionErr: ".concat(String.valueOf(i))));
                return;
            }
            gsy.O00000Oo(TAG, "getBleMeshFirmwareVersion: ".concat(String.valueOf(str)));
            if (fpo.O000000o(o000000o.O0000Oo0, str) > 0) {
                o000000o.O00000Oo = 2.0f;
                updateView(this.mUpdateItemList.indexOf(o000000o));
                observableEmitter.onNext(Boolean.TRUE);
                observableEmitter.onComplete();
                return;
            }
            observableEmitter.onError(new Exception("no_need_to_update"));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ObservableSource O000000o(O000000o o000000o, Boolean bool) throws Exception {
        return Observable.create(new ObservableOnSubscribe(o000000o) {
            /* class com.xiaomi.smarthome.light.group.$$Lambda$LightGroupMemberUpdateActivity$zJoEik67w6i5AhdUk3p0wrlSi8 */
            private final /* synthetic */ LightGroupMemberUpdateActivity.O000000o f$1;

            {
                this.f$1 = r2;
            }

            public final void subscribe(ObservableEmitter observableEmitter) {
                LightGroupMemberUpdateActivity.this.O000000o(this.f$1, observableEmitter);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(final O000000o o000000o, final ObservableEmitter observableEmitter) throws Exception {
        this.sFirmwareLoading.set(true);
        XmPluginHostApi.instance().downloadFirmware(o000000o.O0000OoO, new Response.FirmwareUpgradeResponse() {
            /* class com.xiaomi.smarthome.light.group.LightGroupMemberUpdateActivity.AnonymousClass2 */

            public final void onProgress(int i) {
                if (!observableEmitter.isDisposed()) {
                    float f = (float) (i / 10);
                    if (f > o000000o.O00000Oo) {
                        o000000o.O00000Oo = f;
                        LightGroupMemberUpdateActivity lightGroupMemberUpdateActivity = LightGroupMemberUpdateActivity.this;
                        lightGroupMemberUpdateActivity.updateView(lightGroupMemberUpdateActivity.mUpdateItemList.indexOf(o000000o));
                    }
                }
            }

            public final void onResponse(int i, String str, String str2) {
                if (!observableEmitter.isDisposed()) {
                    gsy.O00000Oo(LightGroupMemberUpdateActivity.TAG, "downloadBleFirmwareOnResponse: ".concat(String.valueOf(i)));
                    gsy.O00000Oo(LightGroupMemberUpdateActivity.TAG, "path: ".concat(String.valueOf(str)));
                    LightGroupMemberUpdateActivity.this.sFirmwareLoading.set(false);
                    if (!LightGroupMemberUpdateActivity.this.sIsUpdating.get() || i != 0 || TextUtils.isEmpty(str)) {
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
            /* class com.xiaomi.smarthome.light.group.$$Lambda$LightGroupMemberUpdateActivity$F6ORltxJr_k_z4wi6Naoaytirkc */
            private final /* synthetic */ String f$1;
            private final /* synthetic */ LightGroupMemberUpdateActivity.O000000o f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void subscribe(ObservableEmitter observableEmitter) {
                LightGroupMemberUpdateActivity.this.O000000o(this.f$1, this.f$2, observableEmitter);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(final String str, final O000000o o000000o, final ObservableEmitter observableEmitter) throws Exception {
        if (!observableEmitter.isDisposed()) {
            if (!new File(str).exists()) {
                observableEmitter.onError(new Exception("BleMeshUpgradeErr"));
                return;
            }
            this.sFirmwareUpgrading.set(true);
            XmBluetoothManager.getInstance().startBleMeshUpgrade(o000000o.O0000O0o, o000000o.O00000oO, o000000o.O0000Oo0, str, new Response.BleUpgradeResponse() {
                /* class com.xiaomi.smarthome.light.group.LightGroupMemberUpdateActivity.AnonymousClass3 */

                public final boolean isMeshDevice() {
                    return true;
                }

                public final /* synthetic */ void onResponse(int i, Object obj) {
                    String str = (String) obj;
                    gsy.O00000Oo(LightGroupMemberUpdateActivity.TAG, "BleMeshUpgradetOnResponse: ".concat(String.valueOf(i)));
                    LightGroupMemberUpdateActivity.this.sFirmwareUpgrading.set(false);
                    ftd.O00000o(str);
                    if (!LightGroupMemberUpdateActivity.this.sIsUpdating.get() || i != 0) {
                        observableEmitter.onError(new Exception("BleMeshUpgradeErr ".concat(String.valueOf(str))));
                        return;
                    }
                    observableEmitter.onNext(Boolean.TRUE);
                    observableEmitter.onComplete();
                    fgo.O000000o(o000000o.O00000oO, o000000o.O0000Oo0, "", "", "", "", null);
                }

                public final void onProgress(int i) {
                    if (!observableEmitter.isDisposed()) {
                        float f = (float) i;
                        if (f > o000000o.O00000Oo) {
                            o000000o.O00000Oo = f;
                            LightGroupMemberUpdateActivity lightGroupMemberUpdateActivity = LightGroupMemberUpdateActivity.this;
                            lightGroupMemberUpdateActivity.updateView(lightGroupMemberUpdateActivity.mUpdateItemList.indexOf(o000000o));
                        }
                    }
                }
            });
        }
    }

    public void upgradeFailed(O000000o o000000o) {
        gsy.O00000Oo(TAG, "upgradeFailed: ");
        o000000o.O00000Oo = 0.0f;
        o000000o.f9364O000000o = UpdateStatus.UPDATING_FAILURE;
        for (O000000o next : this.mUpdateItemList) {
            if (!TextUtils.equals(next.O00000oO, o000000o.O00000oO) && next.f9364O000000o == UpdateStatus.WATTING) {
                next.f9364O000000o = UpdateStatus.PENDING;
            }
        }
        this.O00000Oo.notifyDataSetChanged();
        this.sIsUpdating.getAndSet(false);
        this.O00000oO = null;
        O000000o(2000);
    }

    public void upgradeSuccess(O000000o o000000o) {
        gsy.O00000Oo(TAG, "upgradeSuccess: ");
        o000000o.f9364O000000o = UpdateStatus.UPDATING_SUCCESS;
        for (O000000o next : this.mUpdateItemList) {
            if (!TextUtils.equals(next.O00000oO, o000000o.O00000oO) && next.f9364O000000o == UpdateStatus.WATTING) {
                next.f9364O000000o = UpdateStatus.PENDING;
            }
        }
        this.O00000Oo.notifyDataSetChanged();
        this.sIsUpdating.getAndSet(false);
        this.O00000oO = null;
        O000000o();
        O000000o(2000);
    }

    public void handleMessage(Message message) {
        String str = TAG;
        gsy.O00000Oo(str, "handleMessage " + message.what);
        int i = message.what;
        if (i < this.mUpdateItemList.size()) {
            startUpgrade(this.mUpdateItemList.get(i));
        }
    }

    public void requestFirmwarUpdate(int i, long j) {
        if (i < this.mUpdateItemList.size()) {
            if (gnl.O00000Oo()) {
                this.mHandler.removeCallbacksAndMessages(null);
                this.mHandler.sendEmptyMessageDelayed(i, j);
                return;
            }
            fqr.O000000o(this, new BleResponse(i, j) {
                /* class com.xiaomi.smarthome.light.group.$$Lambda$LightGroupMemberUpdateActivity$WsxNyFJpcEt_7EdUy6VLHq8bjb0 */
                private final /* synthetic */ int f$1;
                private final /* synthetic */ long f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void onResponse(int i, Object obj) {
                    LightGroupMemberUpdateActivity.this.O000000o(this.f$1, this.f$2, i, obj);
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
        UpdateStatus f9364O000000o = UpdateStatus.PENDING;
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
        String O0000Ooo;

        O000000o() {
        }
    }

    public void updateView(int i) {
        int firstVisiblePosition;
        if (isValid() && i >= 0 && i < this.mUpdateItemList.size() && (firstVisiblePosition = i - this.f9360O000000o.getFirstVisiblePosition()) >= 0) {
            View childAt = this.f9360O000000o.getChildAt(firstVisiblePosition);
            O00000Oo o00000Oo = this.O00000Oo;
            if (childAt != null) {
                O00000o0 o00000o0 = (O00000o0) childAt.getTag();
                O000000o o000000o = LightGroupMemberUpdateActivity.this.mUpdateItemList.get(i);
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
            return LightGroupMemberUpdateActivity.this.mUpdateItemList.size();
        }

        public final Object getItem(int i) {
            return LightGroupMemberUpdateActivity.this.mUpdateItemList.get(i);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public final View getView(int i, View view, ViewGroup viewGroup) {
            O00000o0 o00000o0;
            if (view == null) {
                view = LightGroupMemberUpdateActivity.this.getLayoutInflater().inflate((int) R.layout.update_ble_mesh_update_item, viewGroup, false);
                o00000o0 = new O00000o0();
                o00000o0.f9366O000000o = view.findViewById(R.id.bottom_divider);
                o00000o0.O00000Oo = (SimpleDraweeView) view.findViewById(R.id.icon);
                o00000o0.O00000o0 = (TextView) view.findViewById(R.id.title);
                o00000o0.O00000o = (TextView) view.findViewById(R.id.sub_title_1);
                o00000o0.O00000oO = (ProgressButton) view.findViewById(R.id.update_btn);
                o00000o0.O00000oo = (ExpandableTextView) view.findViewById(R.id.expand_text_view);
                o00000o0.O0000O0o = (TextView) view.findViewById(R.id.change_time);
                view.setTag(o00000o0);
            } else {
                o00000o0 = (O00000o0) view.getTag();
                o00000o0.f9366O000000o.setVisibility(8);
                o00000o0.O00000Oo.setImageURI(gqd.O000000o((int) R.drawable.device_list_phone_no));
                o00000o0.O00000o0.setText("");
                o00000o0.O00000o.setText("");
                o00000o0.O00000oO.setText("");
                o00000o0.O00000oO.setBackgroundResource(R.drawable.ble_mesh_item_button_pending_shape);
                o00000o0.O00000oO.setButtonMode(0);
                o00000o0.O00000oO.setTextColor(LightGroupMemberUpdateActivity.this.getResources().getColor(R.color.mj_color_green_normal));
                o00000o0.O00000oo.setText("");
                o00000o0.O0000O0o.setText("");
            }
            if (i == LightGroupMemberUpdateActivity.this.mUpdateItemList.size() - 1) {
                o00000o0.f9366O000000o.setVisibility(0);
            }
            O000000o o000000o = LightGroupMemberUpdateActivity.this.mUpdateItemList.get(i);
            if (!TextUtils.isEmpty(o000000o.O00000o)) {
                o00000o0.O00000o0.setText(o000000o.O00000o);
            } else {
                o00000o0.O00000o0.setText(LightGroupMemberUpdateActivity.this.getString(R.string.update_unknown_device));
            }
            o00000o0.O00000o.setText(o000000o.O0000OOo + " → " + o000000o.O0000Oo0);
            DeviceFactory.O00000Oo(o000000o.O00000o0, o00000o0.O00000Oo);
            ExpandableTextView expandableTextView = o00000o0.O00000oo;
            SparseBooleanArray sparseBooleanArray = this.O00000Oo;
            expandableTextView.O0000Oo = sparseBooleanArray;
            expandableTextView.O0000OoO = i;
            boolean z = sparseBooleanArray.get(i, true);
            expandableTextView.clearAnimation();
            expandableTextView.O00000o0 = z;
            expandableTextView.O00000oO.O000000o(expandableTextView.O00000o0);
            expandableTextView.setText(LightGroupMemberUpdateActivity.this.getString(R.string.fireware_update_content) + o000000o.O0000Oo);
            o00000o0.O0000O0o.setText(LightGroupMemberUpdateActivity.this.getString(R.string.fireware_update_time) + LightGroupMemberUpdateActivity.getDateString(o000000o.O0000Ooo));
            if (o000000o.f9364O000000o == UpdateStatus.PENDING) {
                o00000o0.O00000oO.setText(LightGroupMemberUpdateActivity.this.getString(R.string.update));
            } else if (o000000o.f9364O000000o == UpdateStatus.WATTING) {
                o00000o0.O00000oO.setTextColor(LightGroupMemberUpdateActivity.this.getResources().getColor(R.color.mj_color_gray_lighter));
                o00000o0.O00000oO.setBackgroundResource(R.drawable.ble_mesh_item_button_waiting_shape);
                o00000o0.O00000oO.setText(LightGroupMemberUpdateActivity.this.getString(R.string.watting));
            } else if (o000000o.f9364O000000o == UpdateStatus.UPDATING) {
                if (o00000o0.O00000oO.getButtonMode() != 1) {
                    o00000o0.O00000oO.setButtonMode(1);
                }
                o00000o0.O00000oO.setProgress((int) o000000o.O00000Oo);
                o00000o0.O00000oO.setText(((int) o000000o.O00000Oo) + "%");
            } else if (o000000o.f9364O000000o == UpdateStatus.UPDATING_SUCCESS) {
                o00000o0.O00000oO.setBackgroundResource(R.drawable.ble_mesh_update_button_normal_shape);
                o00000o0.O00000oO.setTextColor(LightGroupMemberUpdateActivity.this.getResources().getColor(R.color.mj_color_white));
                o00000o0.O00000oO.setText(LightGroupMemberUpdateActivity.this.getString(R.string.mj_complete));
            } else if (o000000o.f9364O000000o == UpdateStatus.UPDATING_FAILURE) {
                o00000o0.O00000oO.setText(LightGroupMemberUpdateActivity.this.getString(R.string.failed));
            }
            o00000o0.O00000oO.setTag(o000000o);
            o00000o0.O00000oO.setOnClickListener(new View.OnClickListener(i) {
                /* class com.xiaomi.smarthome.light.group.$$Lambda$LightGroupMemberUpdateActivity$O00000Oo$GZy1kHb0eAt22D7Rg0DmopzosEk */
                private final /* synthetic */ int f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    LightGroupMemberUpdateActivity.O00000Oo.this.O000000o(this.f$1, view);
                }
            });
            return view;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O000000o(int i, View view) {
            O000000o o000000o = (O000000o) view.getTag();
            if (o000000o.f9364O000000o != UpdateStatus.UPDATING && o000000o.f9364O000000o != UpdateStatus.UPDATING_SUCCESS && o000000o.f9364O000000o != UpdateStatus.WATTING) {
                if ((o000000o.f9364O000000o == UpdateStatus.PENDING || o000000o.f9364O000000o == UpdateStatus.UPDATING_FAILURE) && !LightGroupMemberUpdateActivity.this.sIsUpdating.get()) {
                    LightGroupMemberUpdateActivity.this.requestFirmwarUpdate(i, 0);
                }
            }
        }
    }

    class O00000o0 {

        /* renamed from: O000000o  reason: collision with root package name */
        View f9366O000000o;
        SimpleDraweeView O00000Oo;
        TextView O00000o;
        TextView O00000o0;
        ProgressButton O00000oO;
        ExpandableTextView O00000oo;
        TextView O0000O0o;

        O00000o0() {
        }
    }
}

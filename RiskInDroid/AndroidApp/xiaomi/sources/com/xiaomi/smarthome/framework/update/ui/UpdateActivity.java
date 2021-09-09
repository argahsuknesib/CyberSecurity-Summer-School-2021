package com.xiaomi.smarthome.framework.update.ui;

import _m_j.fno;
import _m_j.fqt;
import _m_j.fsm;
import _m_j.fso;
import _m_j.fsr;
import _m_j.fvi;
import _m_j.gey;
import _m_j.gez;
import _m_j.gfa;
import _m_j.gqd;
import _m_j.grr;
import _m_j.gsy;
import _m_j.gye;
import _m_j.hxi;
import _m_j.hxp;
import _m_j.hyz;
import _m_j.izb;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.core.entity.plugin.PluginDownloadTask;
import com.xiaomi.smarthome.core.entity.plugin.PluginError;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.device.DeviceRouterFactory;
import com.xiaomi.smarthome.device.api.DeviceApi;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.plugin.PluginApi;
import com.xiaomi.smarthome.frame.plugin.SendMessageCallback;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressHorizontalDialog;
import com.xiaomi.smarthome.library.common.widget.PieProgressBar;
import com.xiaomi.smarthome.library.log.LogType;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class UpdateActivity extends BaseActivity {
    public static boolean DEBUG = (fsr.O0000O0o || fsr.O0000Oo0);

    /* renamed from: O000000o  reason: collision with root package name */
    boolean f8721O000000o = false;
    boolean O00000Oo = false;
    View O00000o;
    boolean O00000o0 = false;
    View O00000oO;
    View O00000oo;
    ListView O0000O0o;
    View O0000OOo;
    O0000Oo O0000Oo;
    TextView O0000Oo0;
    List<O00000o0> O0000OoO = new ArrayList();
    boolean O0000Ooo = false;
    private O000000o O0000o0 = new O000000o(this);
    private MLAlertDialog O0000o00;
    public Context mContext;
    public boolean mIsJumpFromLightGroup;
    public O0000o00 mSoftwareUpdateItem;

    static class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        String f8736O000000o;
        String O00000Oo;
        float O00000o;
        UpdateStatus O00000o0;
        String O00000oO;
    }

    interface O0000OOo {
        void O000000o();
    }

    enum UpdateStatus {
        PENDING,
        UPDATING,
        UPDATING_SUCCESS,
        UPDATING_FAILURE
    }

    public void installApk(String str) {
    }

    public void startAppUpdate(O00000Oo o00000Oo) {
    }

    public static void start(Context context, ArrayList<KeyValuePair> arrayList) {
        Intent intent = new Intent(context, UpdateActivity.class);
        intent.putParcelableArrayListExtra("arg_did_list", arrayList);
        context.startActivity(intent);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.util.List<java.lang.String>, boolean, com.xiaomi.smarthome.frame.core.CoreApi$O0000O0o):void
     arg types: [java.util.ArrayList<java.lang.String>, int, com.xiaomi.smarthome.framework.update.ui.UpdateActivity$6]
     candidates:
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(boolean, boolean, java.lang.String):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.smarthome.core.entity.net.NetRequest, _m_j.fss, _m_j.fsm):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String, _m_j.fsm<java.lang.Void, _m_j.fso>):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.security.SecureConnectOptions, _m_j.gle):com.xiaomi.smarthome.core.server.internal.bluetooth.security.ISecureConnectHandler
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, int, android.os.Bundle):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String, int):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, boolean, com.xiaomi.smarthome.frame.core.CoreApi$O0000OOo):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, boolean, com.xiaomi.smarthome.frame.core.CoreApi$O0000Oo):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, int, boolean):boolean
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.util.List<java.lang.String>, boolean, com.xiaomi.smarthome.frame.core.CoreApi$O0000O0o):void */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        gsy.O00000Oo(LogType.GENERAL, "UpdateActivity", "UpdateActivity onCreate:googleplay");
        this.mContext = this;
        setContentView((int) R.layout.update_activity_googleplay);
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.update.ui.UpdateActivity.AnonymousClass1 */

            public final void onClick(View view) {
                UpdateActivity.this.finish();
            }
        });
        ((TextView) findViewById(R.id.module_a_3_return_title)).setText(getString(R.string.activity_title_upgrade));
        this.O00000o = findViewById(R.id.checking_update_layer);
        this.O00000oO = findViewById(R.id.has_update_layer);
        this.O00000oo = findViewById(R.id.none_update_layer);
        this.O0000O0o = (ListView) findViewById(R.id.listview);
        this.O0000Oo = new O0000Oo();
        this.O0000O0o.setAdapter((ListAdapter) this.O0000Oo);
        this.O0000OOo = findViewById(R.id.footer);
        this.O0000Oo0 = (TextView) findViewById(R.id.update_all);
        this.O0000Oo0.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.update.ui.UpdateActivity.AnonymousClass4 */

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0049  */
            /* JADX WARNING: Removed duplicated region for block: B:33:0x005e A[EDGE_INSN: B:33:0x005e->B:22:0x005e ?: BREAK  , SYNTHETIC] */
            public final void onClick(View view) {
                boolean z;
                if (UpdateActivity.this.mSoftwareUpdateItem != null) {
                    z = UpdateActivity.this.mSoftwareUpdateItem.O00000o0() && (UpdateActivity.this.mSoftwareUpdateItem.O00000o.O00000o0 == UpdateStatus.PENDING || UpdateActivity.this.mSoftwareUpdateItem.O00000o.O00000o0 == UpdateStatus.UPDATING_FAILURE);
                    if (!z && UpdateActivity.this.mSoftwareUpdateItem.O00000o()) {
                        Iterator<O0000Oo0> it = UpdateActivity.this.mSoftwareUpdateItem.O00000oO.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                O0000Oo0 next = it.next();
                                if (next.O00000oO == UpdateStatus.PENDING || next.O00000oO == UpdateStatus.UPDATING_FAILURE) {
                                    z = true;
                                }
                                if (!it.hasNext()) {
                                    break;
                                }
                            }
                        }
                        z = true;
                    }
                } else {
                    z = false;
                }
                if (fvi.O000000o().O00000o() || !z) {
                    UpdateActivity.this.startAllUpdate();
                } else {
                    UpdateActivity.this.showNoneWifiUpdateConfirmDialog(new O0000OOo() {
                        /* class com.xiaomi.smarthome.framework.update.ui.UpdateActivity.AnonymousClass4.AnonymousClass1 */

                        public final void O000000o() {
                            UpdateActivity.this.startAllUpdate();
                        }
                    });
                }
                if (UpdateActivity.this.mIsJumpFromLightGroup) {
                    hxi.O00000o.f952O000000o.O000000o("lightgroup_wifi_upgrade_click", new Object[0]);
                }
                UpdateActivity.this.refreshUI();
            }
        });
        ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra("arg_did_list");
        this.mIsJumpFromLightGroup = parcelableArrayListExtra != null;
        if (!this.mIsJumpFromLightGroup) {
            parcelableArrayListExtra = new ArrayList();
            for (Map.Entry<String, Device> value : fno.O000000o().O0000O0o().entrySet()) {
                Device device = (Device) value.getValue();
                if (device != null) {
                    parcelableArrayListExtra.add(new KeyValuePair(device.did, device.model));
                }
            }
        }
        gfa.getInstance().checkAllFirmwareUpdate(parcelableArrayListExtra, new gye.O000000o() {
            /* class com.xiaomi.smarthome.framework.update.ui.UpdateActivity.AnonymousClass5 */

            public final void O000000o(boolean z, boolean z2, boolean z3) {
                UpdateActivity updateActivity = UpdateActivity.this;
                updateActivity.f8721O000000o = true;
                updateActivity.clearAllFirmwareUpdateItem();
                UpdateActivity.this.refreshUI();
            }

            public final void O000000o(boolean z, boolean z2, boolean z3, List<gey> list) {
                Device device;
                UpdateActivity updateActivity = UpdateActivity.this;
                updateActivity.f8721O000000o = true;
                updateActivity.clearAllFirmwareUpdateItem();
                if (list.size() > 0) {
                    int size = list.size();
                    for (int i = 0; i < size; i++) {
                        gey gey = list.get(i);
                        try {
                            device = fno.O000000o().O000000o(gey.f17608O000000o);
                        } catch (Exception unused) {
                            device = null;
                        }
                        if (device != null && device.isOnline && !gey.O0000OOo.equals("installed") && !gey.O00000oO) {
                            O00000o o00000o = new O00000o();
                            o00000o.O00000oO = device.model;
                            o00000o.O00000oo = device.name;
                            o00000o.O0000O0o = gey.f17608O000000o;
                            o00000o.O0000OOo = device.pid;
                            o00000o.O0000Oo0 = gey.O00000Oo;
                            o00000o.O0000Oo = gey.O00000o0;
                            o00000o.O0000OoO = gey.O00000o;
                            o00000o.O0000Ooo = gey.O00000oo;
                            o00000o.O0000o0 = gey.O0000OOo;
                            o00000o.O0000o00 = gey.O0000O0o;
                            if (gey.O00000Oo) {
                                o00000o.O00000Oo = UpdateStatus.UPDATING;
                            }
                            UpdateActivity.this.O0000OoO.add(o00000o);
                            if (gey.O00000Oo) {
                                o00000o.O00000o = true;
                                UpdateActivity.this.startFirmwareUpdatePoll(o00000o);
                            }
                        }
                    }
                }
                UpdateActivity.this.sortAllUpdateItem();
                UpdateActivity.this.refreshUI();
                try {
                    if (UpdateActivity.this.mIsJumpFromLightGroup) {
                        StringBuilder sb = new StringBuilder();
                        for (int i2 = 0; i2 < UpdateActivity.this.O0000OoO.size(); i2++) {
                            sb.append(((O00000o) UpdateActivity.this.O0000OoO.get(i2)).O00000oO);
                            if (i2 != UpdateActivity.this.O0000OoO.size() - 1) {
                                sb.append(",");
                            }
                        }
                        hxp hxp = hxi.O00000o0;
                        String sb2 = sb.toString();
                        hxp.f957O000000o.O000000o("lightgroup_wifi_upgrade_show", "model", sb2);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            public final void O000000o() {
                UpdateActivity updateActivity = UpdateActivity.this;
                updateActivity.f8721O000000o = true;
                updateActivity.clearAllFirmwareUpdateItem();
                UpdateActivity.this.refreshUI();
            }
        });
        if (!this.mIsJumpFromLightGroup) {
            CoreApi.O000000o().O000000o((List<String>) hyz.O000000o(), false, (CoreApi.O0000O0o) new CoreApi.O0000O0o() {
                /* class com.xiaomi.smarthome.framework.update.ui.UpdateActivity.AnonymousClass6 */

                public final void O000000o() {
                }

                public final void O000000o(String str) {
                }

                public final void O000000o(String str, float f) {
                }

                public final void O000000o(List<PluginDownloadTask> list) {
                }

                public final void O00000Oo(List<PluginDownloadTask> list) {
                    UpdateActivity.this.O00000o0 = true;
                    boolean z = false;
                    for (PluginDownloadTask next : list) {
                        if (CoreApi.O000000o().O0000Oo(next.f6738O000000o) != null) {
                            if (UpdateActivity.this.mSoftwareUpdateItem == null) {
                                UpdateActivity.this.mSoftwareUpdateItem = new O0000o00();
                            }
                            O0000Oo0 o0000Oo0 = new O0000Oo0();
                            o0000Oo0.O00000o0 = next.f6738O000000o;
                            o0000Oo0.O00000Oo = next.O00000Oo;
                            o0000Oo0.O00000o = next.O00000o0;
                            o0000Oo0.f8743O000000o = next.O00000o;
                            UpdateActivity.this.mSoftwareUpdateItem.O00000oO.add(o0000Oo0);
                            z = true;
                        }
                    }
                    if (z) {
                        UpdateActivity.this.clearSoftwareUpdateItem();
                        UpdateActivity updateActivity = UpdateActivity.this;
                        updateActivity.addSoftwareUpdateItem(updateActivity.mSoftwareUpdateItem);
                    }
                    UpdateActivity.this.sortAllUpdateItem();
                    UpdateActivity.this.refreshUI();
                }

                public final void O000000o(PluginError pluginError) {
                    UpdateActivity updateActivity = UpdateActivity.this;
                    updateActivity.O00000o0 = true;
                    updateActivity.refreshUI();
                }
            });
        } else {
            this.O00000o0 = true;
            this.O00000Oo = true;
        }
        refreshUI();
        gez.O000000o().O00000o0.removeCallbacksAndMessages(null);
        this.O00000Oo = true;
    }

    public void sortAllUpdateItem() {
        Collections.sort(this.O0000OoO, new Comparator<O00000o0>() {
            /* class com.xiaomi.smarthome.framework.update.ui.UpdateActivity.AnonymousClass7 */

            public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                O00000o0 o00000o0 = (O00000o0) obj2;
                if (((O00000o0) obj) instanceof O0000o00) {
                    return -1;
                }
                return o00000o0 instanceof O0000o00 ? 1 : 0;
            }
        });
    }

    public void addSoftwareUpdateItem(O0000o00 o0000o00) {
        this.O0000OoO.add(this.O0000OoO.size(), o0000o00);
    }

    public void clearAllFirmwareUpdateItem() {
        int i = 0;
        while (i < this.O0000OoO.size()) {
            if (this.O0000OoO.get(i) instanceof O00000o) {
                this.O0000OoO.remove(i);
                i--;
            }
            i++;
        }
    }

    public void clearSoftwareUpdateItem() {
        int i = 0;
        while (i < this.O0000OoO.size()) {
            if (this.O0000OoO.get(i) instanceof O0000o00) {
                this.O0000OoO.remove(i);
                i--;
            }
            i++;
        }
    }

    public void gotoDevicePage(String str, String str2) {
        Device O000000o2 = fno.O000000o().O000000o(str);
        if (O000000o2 == null) {
            O000000o2 = fno.O000000o().O00000Oo(str);
        }
        PluginDeviceInfo O00000oO2 = CoreApi.O000000o().O00000oO(str2);
        if (O000000o2 == null || O00000oO2 == null) {
            izb.O000000o(this.mContext, (int) R.string.update_success_open_failure, 0).show();
            return;
        }
        Intent intent = new Intent();
        final XQProgressHorizontalDialog O000000o3 = XQProgressHorizontalDialog.O000000o(this, getString(R.string.plugin_downloading) + O00000oO2.O0000Oo0() + getString(R.string.plugin));
        PluginApi.getInstance().sendMessage(this.mContext, str2, 1, intent, DeviceRouterFactory.getDeviceWrapper().newDeviceStat(O000000o2), null, false, new SendMessageCallback() {
            /* class com.xiaomi.smarthome.framework.update.ui.UpdateActivity.AnonymousClass8 */

            public final void onDownloadStart(final String str, final PluginDownloadTask pluginDownloadTask) {
                XQProgressHorizontalDialog xQProgressHorizontalDialog;
                if (UpdateActivity.this.isValid() && (xQProgressHorizontalDialog = O000000o3) != null) {
                    xQProgressHorizontalDialog.O000000o(true);
                    XQProgressHorizontalDialog xQProgressHorizontalDialog2 = O000000o3;
                    xQProgressHorizontalDialog2.f9117O000000o = false;
                    xQProgressHorizontalDialog2.setCancelable(true);
                    O000000o3.show();
                    O000000o3.setOnCancelListener(new DialogInterface.OnCancelListener() {
                        /* class com.xiaomi.smarthome.framework.update.ui.UpdateActivity.AnonymousClass8.AnonymousClass1 */

                        public final void onCancel(DialogInterface dialogInterface) {
                            CoreApi.O000000o().O000000o(str, pluginDownloadTask);
                        }
                    });
                }
            }

            public final void onDownloadProgress(String str, float f) {
                XQProgressHorizontalDialog xQProgressHorizontalDialog = O000000o3;
                if (xQProgressHorizontalDialog != null && xQProgressHorizontalDialog.isShowing()) {
                    O000000o3.O000000o(100, (int) (f * 100.0f));
                }
            }

            public final void onDownloadSuccess(String str) {
                XQProgressHorizontalDialog xQProgressHorizontalDialog = O000000o3;
                if (xQProgressHorizontalDialog != null && xQProgressHorizontalDialog.isShowing()) {
                    O000000o3.dismiss();
                }
            }

            public final void onDownloadFailure(PluginError pluginError) {
                XQProgressHorizontalDialog xQProgressHorizontalDialog = O000000o3;
                if (xQProgressHorizontalDialog != null && xQProgressHorizontalDialog.isShowing()) {
                    O000000o3.dismiss();
                }
            }

            public final void onDownloadCancel() {
                XQProgressHorizontalDialog xQProgressHorizontalDialog = O000000o3;
                if (xQProgressHorizontalDialog != null && xQProgressHorizontalDialog.isShowing()) {
                    O000000o3.dismiss();
                }
            }
        });
    }

    public void startRestartUpdate(final O00000o o00000o) {
        if (o00000o.O00000Oo != UpdateStatus.UPDATING && o00000o.O00000Oo != UpdateStatus.UPDATING_SUCCESS) {
            o00000o.O00000Oo = UpdateStatus.UPDATING;
            refreshUI();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("method", "miIO.ota_install");
                jSONObject.put("params", new JSONArray());
            } catch (Exception unused) {
            }
            DeviceApi.getInstance().rpcAsyncRemote(this.mContext, o00000o.O0000O0o, jSONObject.toString(), new fsm<JSONObject, fso>() {
                /* class com.xiaomi.smarthome.framework.update.ui.UpdateActivity.AnonymousClass9 */

                public final void onFailure(fso fso) {
                    o00000o.O00000Oo = UpdateStatus.UPDATING;
                    UpdateActivity.this.refreshUI();
                }

                public final /* synthetic */ void onSuccess(Object obj) {
                    o00000o.O00000Oo = UpdateStatus.UPDATING_SUCCESS;
                    UpdateActivity.this.refreshUI();
                }
            });
        }
    }

    public void startFirmwareUpdate(final O00000o o00000o) {
        if (o00000o.O00000Oo != UpdateStatus.UPDATING && o00000o.O00000Oo != UpdateStatus.UPDATING_SUCCESS) {
            o00000o.O00000Oo = UpdateStatus.UPDATING;
            refreshUI();
            gfa.getInstance().startFirmwareUpdate(o00000o.O0000O0o, o00000o.O0000OOo, o00000o.O0000OoO, new gye.O0000O0o() {
                /* class com.xiaomi.smarthome.framework.update.ui.UpdateActivity.AnonymousClass10 */

                public final void O000000o() {
                    UpdateActivity.this.startFirmwareUpdatePoll(o00000o);
                }

                public final void O00000Oo() {
                    o00000o.O00000Oo = UpdateStatus.UPDATING_FAILURE;
                    UpdateActivity.this.refreshUI();
                }
            });
        }
    }

    static class O0000O0o implements gye.O0000Oo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        private final O00000o f8738O000000o;

        /* synthetic */ O0000O0o(O00000o o00000o, byte b) {
            this(o00000o);
        }

        private O0000O0o(O00000o o00000o) {
            this.f8738O000000o = o00000o;
        }

        public final void O000000o(float f) {
            int i = (int) (f * 100.0f);
            gez.O000000o().O000000o(this.f8738O000000o.O0000O0o, this.f8738O000000o.O00000o, i);
            if (UpdateActivity.DEBUG) {
                Log.d("UpdateActivity", "onProgress: did: " + this.f8738O000000o.O0000O0o + " ; " + i);
            }
        }

        public final void O000000o() {
            gez.O000000o().O000000o(this.f8738O000000o.O0000O0o, this.f8738O000000o.O00000o, 100);
            if (UpdateActivity.DEBUG) {
                Log.d("UpdateActivity", "onSuccess: " + this.f8738O000000o.O0000O0o);
            }
        }

        public final void O00000Oo() {
            gez O000000o2 = gez.O000000o();
            String str = this.f8738O000000o.O0000O0o;
            for (WeakReference<gez.O000000o> weakReference : O000000o2.O00000Oo) {
                gez.O000000o o000000o = (gez.O000000o) weakReference.get();
                if (o000000o != null) {
                    O000000o2.O000000o(str);
                    o000000o.O00000Oo(str);
                } else {
                    gsy.O00000o0(LogType.GENERAL, "Wifi-OTA", "UpdateItemHelper :updateFailed did=%s, but listener is null");
                }
            }
            if (UpdateActivity.DEBUG) {
                Log.d("UpdateActivity", "onFailure: " + this.f8738O000000o.O0000O0o);
            }
        }
    }

    public void startFirmwareUpdatePoll(O00000o o00000o) {
        gfa.getInstance().startFirmwareUpdatePoll(o00000o.O0000O0o, o00000o.O0000OOo, o00000o.O0000OoO, new O0000O0o(o00000o, (byte) 0));
    }

    static class O000000o implements gye.O00000o {

        /* renamed from: O000000o  reason: collision with root package name */
        private WeakReference<UpdateActivity> f8735O000000o;

        O000000o(UpdateActivity updateActivity) {
            this.f8735O000000o = new WeakReference<>(updateActivity);
        }

        public final void O000000o(float f) {
            UpdateActivity updateActivity = this.f8735O000000o.get();
            if (updateActivity != null && !updateActivity.O0000Ooo && updateActivity.mSoftwareUpdateItem != null && updateActivity.mSoftwareUpdateItem.O00000o0()) {
                O00000Oo o00000Oo = updateActivity.mSoftwareUpdateItem.O00000o;
                o00000Oo.O00000o = f;
                o00000Oo.O00000o0 = UpdateStatus.UPDATING;
                updateActivity.refreshSoftwareUpdateItemStatus();
                updateActivity.refreshUI();
            }
        }

        public final void O000000o() {
            UpdateActivity updateActivity = this.f8735O000000o.get();
            if (updateActivity != null && !updateActivity.O0000Ooo && updateActivity.mSoftwareUpdateItem != null && updateActivity.mSoftwareUpdateItem.O00000o0()) {
                updateActivity.mSoftwareUpdateItem.O00000o.O00000o0 = UpdateStatus.UPDATING_FAILURE;
                updateActivity.refreshSoftwareUpdateItemStatus();
                updateActivity.refreshUI();
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, boolean, com.xiaomi.smarthome.frame.core.CoreApi$O0000OOo):void
     arg types: [java.lang.String, int, com.xiaomi.smarthome.framework.update.ui.UpdateActivity$11]
     candidates:
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(boolean, boolean, java.lang.String):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.smarthome.core.entity.net.NetRequest, _m_j.fss, _m_j.fsm):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String, _m_j.fsm<java.lang.Void, _m_j.fso>):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.security.SecureConnectOptions, _m_j.gle):com.xiaomi.smarthome.core.server.internal.bluetooth.security.ISecureConnectHandler
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, int, android.os.Bundle):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String, int):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, boolean, com.xiaomi.smarthome.frame.core.CoreApi$O0000Oo):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.util.List<java.lang.String>, boolean, com.xiaomi.smarthome.frame.core.CoreApi$O0000O0o):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, int, boolean):boolean
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, boolean, com.xiaomi.smarthome.frame.core.CoreApi$O0000OOo):void */
    public void startPluginUpdate(final O0000Oo0 o0000Oo0) {
        if (o0000Oo0.O00000oO != UpdateStatus.UPDATING && o0000Oo0.O00000oO != UpdateStatus.UPDATING_SUCCESS) {
            o0000Oo0.O00000oO = UpdateStatus.UPDATING;
            refreshUI();
            CoreApi.O000000o().O000000o(o0000Oo0.O00000o0, true, (CoreApi.O0000OOo) new CoreApi.O0000OOo() {
                /* class com.xiaomi.smarthome.framework.update.ui.UpdateActivity.AnonymousClass11 */

                public final void onDownInfoSuccess(String str, PluginDownloadTask pluginDownloadTask) {
                }

                public final void onStart(String str, PluginDownloadTask pluginDownloadTask) {
                }

                public final void onProgress(String str, float f) {
                    if (UpdateActivity.this.mSoftwareUpdateItem != null && UpdateActivity.this.mSoftwareUpdateItem.O00000o()) {
                        Iterator<O0000Oo0> it = UpdateActivity.this.mSoftwareUpdateItem.O00000oO.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            O0000Oo0 next = it.next();
                            if (!TextUtils.isEmpty(next.O00000o0) && next.O00000o0.equalsIgnoreCase(str)) {
                                next.O00000oo = f;
                                break;
                            }
                        }
                        UpdateActivity.this.refreshSoftwareUpdateItemStatus();
                        UpdateActivity.this.refreshUI();
                    }
                }

                public final void onSuccess(String str) {
                    if (UpdateActivity.this.mSoftwareUpdateItem != null && UpdateActivity.this.mSoftwareUpdateItem.O00000o()) {
                        Iterator<O0000Oo0> it = UpdateActivity.this.mSoftwareUpdateItem.O00000oO.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            O0000Oo0 next = it.next();
                            if (!TextUtils.isEmpty(next.O00000o0) && next.O00000o0.equalsIgnoreCase(str)) {
                                next.O00000oO = UpdateStatus.UPDATING_SUCCESS;
                                break;
                            }
                        }
                        UpdateActivity.this.refreshSoftwareUpdateItemStatus();
                        UpdateActivity.this.refreshUI();
                    }
                }

                public final void onFailure(PluginError pluginError) {
                    onCancel();
                }

                public final void onCancel() {
                    if (UpdateActivity.this.mSoftwareUpdateItem != null && UpdateActivity.this.mSoftwareUpdateItem.O00000o()) {
                        Iterator<O0000Oo0> it = UpdateActivity.this.mSoftwareUpdateItem.O00000oO.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            O0000Oo0 next = it.next();
                            if (!TextUtils.isEmpty(next.O00000o0) && next.O00000o0.equalsIgnoreCase(o0000Oo0.O00000o0)) {
                                next.O00000oO = UpdateStatus.UPDATING_FAILURE;
                                break;
                            }
                        }
                        UpdateActivity.this.refreshSoftwareUpdateItemStatus();
                        UpdateActivity.this.refreshUI();
                    }
                }
            });
        }
    }

    public void startAllUpdate() {
        int size = this.O0000OoO.size();
        for (int i = 0; i < size; i++) {
            O00000o0 o00000o0 = this.O0000OoO.get(i);
            if (o00000o0 instanceof O00000o) {
                O00000o o00000o = (O00000o) o00000o0;
                if (!(o00000o.O00000Oo == UpdateStatus.UPDATING || o00000o.O00000Oo == UpdateStatus.UPDATING_SUCCESS)) {
                    if ("downloaded".equals(o00000o.O0000o0)) {
                        startRestartUpdate(o00000o);
                    } else {
                        startFirmwareUpdate(o00000o);
                    }
                }
            } else if (o00000o0 instanceof O0000o00) {
                O0000o00 o0000o00 = (O0000o00) o00000o0;
                if (!(o0000o00.O00000Oo == UpdateStatus.UPDATING || o0000o00.O00000Oo == UpdateStatus.UPDATING_SUCCESS)) {
                    o0000o00.O00000Oo = UpdateStatus.UPDATING;
                    if (o0000o00.O00000o0()) {
                        startAppUpdate(o0000o00.O00000o);
                    }
                    if (o0000o00.O00000o()) {
                        int size2 = o0000o00.O00000oO.size();
                        for (int i2 = 0; i2 < size2; i2++) {
                            startPluginUpdate(o0000o00.O00000oO.get(i2));
                        }
                    }
                }
            }
        }
    }

    public void refreshSoftwareUpdateItemStatus() {
        boolean z;
        int i;
        float f = 0.0f;
        boolean z2 = false;
        if (this.mSoftwareUpdateItem.O00000o0()) {
            O00000Oo o00000Oo = this.mSoftwareUpdateItem.O00000o;
            if (o00000Oo.O00000o0 == UpdateStatus.UPDATING) {
                z2 = true;
            } else if (o00000Oo.O00000o0 == UpdateStatus.UPDATING_FAILURE) {
                z = true;
                f = 0.0f + o00000Oo.O00000o;
                i = 1;
            }
            z = false;
            f = 0.0f + o00000Oo.O00000o;
            i = 1;
        } else {
            i = 0;
            z = false;
        }
        if (this.mSoftwareUpdateItem.O00000o()) {
            for (O0000Oo0 next : this.mSoftwareUpdateItem.O00000oO) {
                if (next.O00000oO == UpdateStatus.UPDATING) {
                    z2 = true;
                } else if (next.O00000oO == UpdateStatus.UPDATING_FAILURE) {
                    z = true;
                }
                i++;
                f += next.O00000oo;
            }
        }
        if (z2) {
            this.mSoftwareUpdateItem.O00000Oo = UpdateStatus.UPDATING;
        } else if (z) {
            if (this.mSoftwareUpdateItem.O00000o0() && this.mSoftwareUpdateItem.O00000o.O00000o0 == UpdateStatus.UPDATING_SUCCESS) {
                installApk(this.mSoftwareUpdateItem.O00000o.O00000oO);
            }
            this.mSoftwareUpdateItem.O00000Oo = UpdateStatus.UPDATING_FAILURE;
        } else {
            if (this.mSoftwareUpdateItem.O00000o0() && this.mSoftwareUpdateItem.O00000o.O00000o0 == UpdateStatus.UPDATING_SUCCESS) {
                installApk(this.mSoftwareUpdateItem.O00000o.O00000oO);
            }
            this.mSoftwareUpdateItem.O00000Oo = UpdateStatus.UPDATING_SUCCESS;
        }
        this.mSoftwareUpdateItem.O00000o0 = f / ((float) i);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 10001 && i2 == 0) {
            try {
                this.mSoftwareUpdateItem.O00000o.O00000o0 = UpdateStatus.UPDATING_FAILURE;
                refreshSoftwareUpdateItemStatus();
                refreshUI();
            } catch (Exception unused) {
            }
        }
    }

    public void refreshUI() {
        if (!this.f8721O000000o || !this.O00000Oo || !this.O00000o0) {
            this.O00000o.setVisibility(0);
            this.O00000oO.setVisibility(8);
            this.O00000oo.setVisibility(8);
            return;
        }
        this.O00000o.setVisibility(8);
        List<O00000o0> list = this.O0000OoO;
        if (list == null || list.size() <= 0) {
            this.O00000oO.setVisibility(8);
            this.O00000oo.setVisibility(0);
        } else {
            boolean z = true;
            boolean z2 = true;
            for (O00000o0 next : this.O0000OoO) {
                if (next instanceof O00000o) {
                    O00000o o00000o = (O00000o) next;
                    if (o00000o.O00000Oo != UpdateStatus.PENDING) {
                        if (o00000o.O00000Oo != UpdateStatus.UPDATING_SUCCESS) {
                            if (o00000o.O00000Oo != UpdateStatus.UPDATING_FAILURE) {
                                if (o00000o.O00000Oo == UpdateStatus.UPDATING) {
                                    z = false;
                                }
                            }
                        }
                    }
                    z = false;
                    z2 = false;
                } else if (next instanceof O0000o00) {
                    O0000o00 o0000o00 = (O0000o00) next;
                    if (o0000o00.O00000o0()) {
                        if (o0000o00.O00000o.O00000o0 != UpdateStatus.PENDING) {
                            if (o0000o00.O00000o.O00000o0 != UpdateStatus.UPDATING_SUCCESS) {
                                if (o0000o00.O00000o.O00000o0 != UpdateStatus.UPDATING_FAILURE) {
                                    if (o0000o00.O00000o.O00000o0 == UpdateStatus.UPDATING) {
                                        z = false;
                                    }
                                }
                            }
                        }
                        z = false;
                        z2 = false;
                    }
                    if (o0000o00.O00000o()) {
                        for (O0000Oo0 next2 : o0000o00.O00000oO) {
                            if (next2.O00000oO != UpdateStatus.PENDING) {
                                if (next2.O00000oO != UpdateStatus.UPDATING_SUCCESS) {
                                    if (next2.O00000oO != UpdateStatus.UPDATING_FAILURE) {
                                        if (next2.O00000oO == UpdateStatus.UPDATING) {
                                            z = false;
                                        }
                                    }
                                }
                            }
                            z = false;
                            z2 = false;
                        }
                    }
                }
            }
            if (z) {
                this.O0000OOo.setVisibility(8);
                this.O0000Oo0.setEnabled(false);
                this.O0000Oo0.setVisibility(4);
            } else if (z2) {
                this.O0000OOo.setVisibility(0);
                this.O0000Oo0.setEnabled(false);
                this.O0000Oo0.setVisibility(0);
                this.O0000Oo0.setText((int) R.string.update_all_updating);
                this.O0000Oo0.setTextColor(getResources().getColor(R.color.mj_color_gray_lighter));
                this.O0000Oo0.setAlpha(0.5f);
            } else {
                this.O0000OOo.setVisibility(0);
                this.O0000Oo0.setEnabled(true);
                this.O0000Oo0.setVisibility(0);
                this.O0000Oo0.setText((int) R.string.update_all);
                this.O0000Oo0.setTextColor(getResources().getColor(R.color.mj_color_white));
                this.O0000Oo0.setAlpha(1.0f);
            }
            this.O00000oO.setVisibility(0);
            this.O00000oo.setVisibility(8);
        }
        this.O0000Oo.notifyDataSetChanged();
    }

    public void showNoneWifiUpdateConfirmDialog(final O0000OOo o0000OOo) {
        this.O0000o00 = new MLAlertDialog.Builder(this.mContext).O00000Oo(getString(R.string.update_none_wifi_confirm)).O000000o((int) R.string.update_none_wifi_confirm_ok, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.update.ui.UpdateActivity.AnonymousClass3 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                O0000OOo o0000OOo = o0000OOo;
                if (o0000OOo != null) {
                    o0000OOo.O000000o();
                }
            }
        }).O00000Oo((int) R.string.update_none_wifi_confirm_cancel, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.update.ui.UpdateActivity.AnonymousClass2 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).O00000o();
        this.O0000o00.show();
    }

    static abstract class O00000o0 {

        /* renamed from: O000000o  reason: collision with root package name */
        boolean f8737O000000o = true;

        /* access modifiers changed from: package-private */
        public abstract UpdateStatus O000000o();

        /* access modifiers changed from: package-private */
        public abstract float O00000Oo();

        O00000o0() {
        }
    }

    static class O00000o extends O00000o0 {
        UpdateStatus O00000Oo = UpdateStatus.PENDING;
        boolean O00000o = false;
        float O00000o0 = 0.0f;
        String O00000oO;
        String O00000oo;
        String O0000O0o;
        int O0000OOo;
        String O0000Oo;
        boolean O0000Oo0;
        String O0000OoO;
        String O0000Ooo;
        String O0000o0;
        int O0000o00;

        O00000o() {
        }

        /* access modifiers changed from: package-private */
        public final UpdateStatus O000000o() {
            return this.O00000Oo;
        }

        /* access modifiers changed from: package-private */
        public final float O00000Oo() {
            return this.O00000o0;
        }
    }

    static class O0000o00 extends O00000o0 {
        UpdateStatus O00000Oo = UpdateStatus.PENDING;
        O00000Oo O00000o;
        float O00000o0 = 0.0f;
        List<O0000Oo0> O00000oO = new ArrayList();

        O0000o00() {
        }

        /* access modifiers changed from: package-private */
        public final UpdateStatus O000000o() {
            return this.O00000Oo;
        }

        /* access modifiers changed from: package-private */
        public final float O00000Oo() {
            return this.O00000o0;
        }

        /* access modifiers changed from: package-private */
        public final boolean O00000o0() {
            return this.O00000o != null;
        }

        /* access modifiers changed from: package-private */
        public final boolean O00000o() {
            List<O0000Oo0> list = this.O00000oO;
            return list != null && list.size() > 0;
        }
    }

    static class O0000Oo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        long f8743O000000o;
        int O00000Oo;
        String O00000o;
        String O00000o0;
        UpdateStatus O00000oO = UpdateStatus.PENDING;
        float O00000oo;

        O0000Oo0() {
        }
    }

    static class O0000o0 {

        /* renamed from: O000000o  reason: collision with root package name */
        View f8744O000000o;
        TextView O00000Oo;
        TextView O00000o;
        SimpleDraweeView O00000o0;
        TextView O00000oO;
        TextView O00000oo;
        Button O0000O0o;
        PieProgressBar O0000OOo;
        TextView O0000Oo;
        TextView O0000Oo0;
        ImageView O0000OoO;
        ProgressBar O0000Ooo;
        TextView O0000o00;

        O0000o0() {
        }
    }

    class O0000Oo extends BaseAdapter implements gez.O000000o {
        public final long getItemId(int i) {
            return (long) i;
        }

        public O0000Oo() {
            gez.O000000o().O00000Oo.add(new WeakReference(this));
        }

        public final int getCount() {
            return UpdateActivity.this.O0000OoO.size();
        }

        public final Object getItem(int i) {
            return UpdateActivity.this.O0000OoO.get(i);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v3, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v12, resolved type: com.xiaomi.smarthome.device.Device} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: com.xiaomi.smarthome.framework.update.ui.UpdateActivity$O0000o0} */
        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        /* JADX WARNING: Multi-variable type inference failed */
        public final View getView(int i, View view, ViewGroup viewGroup) {
            O0000o0 o0000o0;
            View view2;
            Device device;
            O0000Oo o0000Oo = this;
            int i2 = i;
            String str = null;
            String str2 = "";
            int i3 = 0;
            if (view == null) {
                view2 = UpdateActivity.this.getLayoutInflater().inflate((int) R.layout.update_activity_update_item_googleplay, viewGroup, false);
                o0000o0 = new O0000o0();
                o0000o0.f8744O000000o = view2.findViewById(R.id.category_divider);
                o0000o0.O00000Oo = (TextView) view2.findViewById(R.id.category);
                o0000o0.O00000o0 = (SimpleDraweeView) view2.findViewById(R.id.icon);
                o0000o0.O00000o = (TextView) view2.findViewById(R.id.title);
                o0000o0.O00000oO = (TextView) view2.findViewById(R.id.sub_title_1);
                o0000o0.O00000oo = (TextView) view2.findViewById(R.id.sub_title_2);
                o0000o0.O0000O0o = (Button) view2.findViewById(R.id.update_btn);
                o0000o0.O0000OOo = (PieProgressBar) view2.findViewById(R.id.update_progress);
                o0000o0.O0000Oo0 = (TextView) view2.findViewById(R.id.update_percent);
                o0000o0.O0000OOo.setPercentView(o0000o0.O0000Oo0);
                o0000o0.O0000Oo = (TextView) view2.findViewById(R.id.change_log);
                o0000o0.O0000OoO = (ImageView) view2.findViewById(R.id.fold);
                o0000o0.O0000Ooo = (ProgressBar) view2.findViewById(R.id.installing_progress_bar);
                o0000o0.O0000o00 = (TextView) view2.findViewById(R.id.installing_progress_info);
                view2.setTag(o0000o0);
            } else {
                o0000o0 = view.getTag();
                o0000o0.f8744O000000o.setVisibility(8);
                o0000o0.O00000Oo.setText(str2);
                o0000o0.O00000Oo.setVisibility(8);
                o0000o0.O00000o0.setImageURI(gqd.O000000o((int) R.drawable.device_list_phone_no));
                o0000o0.O00000o.setText(str2);
                o0000o0.O00000oO.setText(str2);
                o0000o0.O00000oo.setText(str2);
                o0000o0.O00000oO.setVisibility(0);
                o0000o0.O00000oo.setVisibility(0);
                o0000o0.O0000O0o.setText(str2);
                o0000o0.O0000O0o.setBackgroundResource(R.drawable.std_btn_update_selector);
                o0000o0.O0000O0o.setTextColor(UpdateActivity.this.getResources().getColor(R.color.mj_color_white));
                o0000o0.O0000OOo.setPercent(0.0f);
                o0000o0.O0000Oo0.setText(str2);
                o0000o0.O0000Oo.setText(str2);
                o0000o0.O0000OoO.setTag(null);
                o0000o0.O0000Ooo.setVisibility(8);
                o0000o0.O0000o00.setVisibility(8);
                view2 = view;
            }
            O00000o0 o00000o0 = UpdateActivity.this.O0000OoO.get(i2);
            if (o00000o0.O000000o() == UpdateStatus.PENDING) {
                o0000o0.O0000O0o.setVisibility(0);
                o0000o0.O0000OOo.setVisibility(8);
                o0000o0.O0000Oo0.setVisibility(8);
                o0000o0.O0000O0o.setText(UpdateActivity.this.getString(R.string.update_immediately));
            } else if (o00000o0.O000000o() == UpdateStatus.UPDATING) {
                o0000o0.O0000O0o.setVisibility(4);
                o0000o0.O0000OOo.setVisibility(0);
                o0000o0.O0000Oo0.setVisibility(0);
                o0000o0.O0000OOo.setPercent(o00000o0.O00000Oo() * 100.0f);
            } else if (o00000o0.O000000o() == UpdateStatus.UPDATING_SUCCESS) {
                o0000o0.O0000O0o.setVisibility(0);
                o0000o0.O0000OOo.setVisibility(8);
                o0000o0.O0000Oo0.setVisibility(8);
                if (o00000o0 instanceof O00000o) {
                    o0000o0.O0000O0o.setBackgroundResource(R.drawable.std_btn_update_success_selector);
                    o0000o0.O0000O0o.setTextColor(UpdateActivity.this.getResources().getColor(R.color.mj_color_green_normal));
                    o0000o0.O0000O0o.setText(UpdateActivity.this.getString(R.string.update_success_open));
                } else {
                    o0000o0.O0000O0o.setBackgroundResource(R.drawable.common_btn_not_cllicked);
                    o0000o0.O0000O0o.setTextColor(UpdateActivity.this.getResources().getColor(R.color.mj_color_gray_lighter));
                    o0000o0.O0000O0o.setText(UpdateActivity.this.getString(R.string.update_success));
                }
            } else if (o00000o0.O000000o() == UpdateStatus.UPDATING_FAILURE) {
                o0000o0.O0000O0o.setVisibility(0);
                o0000o0.O0000OOo.setVisibility(8);
                o0000o0.O0000Oo0.setVisibility(8);
                o0000o0.O0000O0o.setText(UpdateActivity.this.getString(R.string.update_failure));
            }
            o0000o0.O0000O0o.setTag(o00000o0);
            o0000o0.O0000O0o.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.framework.update.ui.UpdateActivity.O0000Oo.AnonymousClass1 */

                public final void onClick(View view) {
                    Device O000000o2;
                    Object tag = view.getTag();
                    if (tag instanceof O00000o) {
                        O00000o o00000o = (O00000o) tag;
                        if (o00000o.O00000Oo != UpdateStatus.UPDATING) {
                            if (o00000o.O00000Oo == UpdateStatus.UPDATING_SUCCESS) {
                                Device O000000o3 = fno.O000000o().O000000o(o00000o.O0000O0o);
                                if (O000000o3 == null) {
                                    O000000o3 = fno.O000000o().O00000Oo(o00000o.O0000O0o);
                                }
                                if ("mxiang.camera.mwc11".equals(O000000o3.model) && !TextUtils.isEmpty(O000000o3.parentId) && (O000000o2 = fno.O000000o().O000000o(O000000o3.parentId)) != null) {
                                    O000000o3 = O000000o2;
                                }
                                UpdateActivity.this.gotoDevicePage(O000000o3 != null ? O000000o3.did : o00000o.O0000O0o, O000000o3 != null ? O000000o3.model : o00000o.O00000oO);
                                return;
                            }
                            if ("downloaded".equals(o00000o.O0000o0)) {
                                UpdateActivity.this.startRestartUpdate(o00000o);
                            } else {
                                UpdateActivity.this.startFirmwareUpdate(o00000o);
                            }
                            UpdateActivity.this.refreshUI();
                        }
                    } else if (tag instanceof O0000o00) {
                        final O0000o00 o0000o00 = (O0000o00) tag;
                        if (o0000o00.O00000Oo != UpdateStatus.UPDATING && o0000o00.O00000Oo != UpdateStatus.UPDATING_SUCCESS) {
                            if (o0000o00.O00000o0()) {
                                if (fvi.O000000o().O00000o() || !(o0000o00.O00000o.O00000o0 == UpdateStatus.PENDING || o0000o00.O00000o.O00000o0 == UpdateStatus.UPDATING_FAILURE)) {
                                    o0000o00.O00000Oo = UpdateStatus.UPDATING;
                                    UpdateActivity.this.startAppUpdate(o0000o00.O00000o);
                                    UpdateActivity.this.refreshUI();
                                } else {
                                    UpdateActivity.this.showNoneWifiUpdateConfirmDialog(new O0000OOo() {
                                        /* class com.xiaomi.smarthome.framework.update.ui.UpdateActivity.O0000Oo.AnonymousClass1.AnonymousClass1 */

                                        public final void O000000o() {
                                            o0000o00.O00000Oo = UpdateStatus.UPDATING;
                                            UpdateActivity.this.startAppUpdate(o0000o00.O00000o);
                                            UpdateActivity.this.refreshUI();
                                        }
                                    });
                                }
                            }
                            if (o0000o00.O00000o()) {
                                int size = o0000o00.O00000oO.size();
                                boolean z = !fvi.O000000o().O00000o();
                                for (int i = 0; i < size; i++) {
                                    final O0000Oo0 o0000Oo0 = o0000o00.O00000oO.get(i);
                                    if (!z || o0000Oo0.O00000oO != UpdateStatus.PENDING) {
                                        o0000o00.O00000Oo = UpdateStatus.UPDATING;
                                        UpdateActivity.this.startPluginUpdate(o0000Oo0);
                                        UpdateActivity.this.refreshUI();
                                    } else {
                                        UpdateActivity.this.showNoneWifiUpdateConfirmDialog(new O0000OOo() {
                                            /* class com.xiaomi.smarthome.framework.update.ui.UpdateActivity.O0000Oo.AnonymousClass1.AnonymousClass2 */

                                            public final void O000000o() {
                                                o0000o00.O00000Oo = UpdateStatus.UPDATING;
                                                UpdateActivity.this.startPluginUpdate(o0000Oo0);
                                                UpdateActivity.this.refreshUI();
                                            }
                                        });
                                        z = false;
                                    }
                                }
                            }
                        }
                    }
                }
            });
            int i4 = 1;
            if (o00000o0 instanceof O00000o) {
                if ((UpdateActivity.this.mSoftwareUpdateItem != null && i2 == 1) || (UpdateActivity.this.mSoftwareUpdateItem == null && i2 == 0)) {
                    o0000o0.O00000Oo.setVisibility(0);
                    o0000o0.O00000Oo.setText(UpdateActivity.this.getString(R.string.update_firmware));
                    o0000o0.f8744O000000o.setVisibility(0);
                }
                O00000o o00000o = (O00000o) o00000o0;
                String str3 = o00000o.O00000oo;
                DeviceFactory.O00000Oo(o00000o.O00000oO, o0000o0.O00000o0);
                if (!TextUtils.isEmpty(str3)) {
                    o0000o0.O00000o.setText(str3);
                } else {
                    o0000o0.O00000o.setText(UpdateActivity.this.getString(R.string.update_unknown_device));
                }
                if (o00000o0.O000000o() != UpdateStatus.UPDATING_SUCCESS) {
                    String O000000o2 = fqt.O000000o(fno.O000000o().O000000o(o00000o.O0000O0o));
                    if (TextUtils.isEmpty(O000000o2)) {
                        o0000o0.O00000oO.setVisibility(8);
                    } else {
                        o0000o0.O00000oO.setVisibility(0);
                        o0000o0.O00000oO.setText(O000000o2);
                    }
                    o0000o0.O00000oo.setText(String.format("%s——%s", o00000o.O0000Oo, o00000o.O0000OoO));
                } else {
                    o0000o0.O00000oO.setText(String.valueOf(o00000o.O0000OoO));
                    o0000o0.O00000oo.setText(str2);
                }
                o0000o0.O0000Oo.setText(o00000o.O0000Ooo);
            } else if (o00000o0 instanceof O0000o00) {
                o0000o0.O00000Oo.setVisibility(0);
                o0000o0.O00000Oo.setText(UpdateActivity.this.getString(R.string.update_software));
                O0000o00 o0000o00 = (O0000o00) o00000o0;
                if (o0000o00.O00000o0()) {
                    o0000o0.O00000o0.setImageResource(R.drawable.mj_ic_launcher);
                    o0000o0.O00000o.setText(UpdateActivity.this.getString(R.string.mj_app_name));
                    TextView textView = o0000o0.O00000oO;
                    StringBuilder sb = new StringBuilder();
                    sb.append(UpdateActivity.this.getString(R.string.list_item_curr_version));
                    sb.append(": ");
                    grr.O000000o();
                    sb.append(grr.O00000o(UpdateActivity.this.mContext));
                    textView.setText(sb.toString());
                    o0000o0.O00000oo.setText(UpdateActivity.this.getString(R.string.list_item_latest_version) + ": " + o0000o00.O00000o.f8736O000000o);
                } else {
                    int size = o0000o00.O00000oO != null ? o0000o00.O00000oO.size() : 0;
                    if (size == 1) {
                        PluginDeviceInfo O00000oO = CoreApi.O000000o().O00000oO(o0000o00.O00000oO.get(0).O00000o0);
                        String O0000o0 = O00000oO.O0000o0();
                        Object O0000Oo0 = O00000oO.O0000Oo0();
                        if (!TextUtils.isEmpty(O0000o0)) {
                            o0000o0.O00000o0.setImageURI(Uri.parse(O0000o0));
                        } else {
                            o0000o0.O00000o0.setImageURI(gqd.O000000o((int) R.drawable.icon_plugin_update));
                        }
                        o0000o0.O00000o.setText(String.format(UpdateActivity.this.getString(R.string.plugin_update_only_one_desc), O0000Oo0));
                    } else {
                        o0000o0.O00000o0.setImageResource(R.drawable.icon_plugin_update);
                        o0000o0.O00000o.setText(UpdateActivity.this.getResources().getQuantityString(R.plurals.list_item_plugin_only, size, Integer.valueOf(size)));
                    }
                    o0000o0.O00000oO.setVisibility(8);
                    o0000o0.O00000oo.setVisibility(8);
                }
                if (o0000o00.O00000o0()) {
                    str2 = str2 + UpdateActivity.this.getString(R.string.mj_app_name) + ":\n" + o0000o00.O00000o.O00000Oo;
                }
                if (o0000o00.O00000o()) {
                    SparseArray sparseArray = new SparseArray();
                    int size2 = o0000o00.O00000oO.size();
                    for (int i5 = 0; i5 < size2; i5++) {
                        O0000Oo0 o0000Oo0 = o0000o00.O00000oO.get(i5);
                        List list = (List) sparseArray.get((int) o0000Oo0.f8743O000000o);
                        if (list == null) {
                            list = new ArrayList();
                        }
                        list.add(o0000Oo0);
                        sparseArray.put((int) o0000Oo0.f8743O000000o, list);
                    }
                    String str4 = str2;
                    int i6 = 0;
                    while (i6 < sparseArray.size()) {
                        List list2 = (List) sparseArray.valueAt(i6);
                        if (!(list2 == null || list2.size() == 0)) {
                            if (list2.size() == i4) {
                                O0000Oo0 o0000Oo02 = (O0000Oo0) list2.get(i3);
                                PluginDeviceInfo O00000oO2 = CoreApi.O000000o().O00000oO(o0000Oo02.O00000o0);
                                if (i6 != 0 || o0000o00.O00000o0()) {
                                    str4 = str4 + "\n\n" + O00000oO2.O0000Oo0() + ":\n" + o0000Oo02.O00000o;
                                } else {
                                    str4 = str4 + O00000oO2.O0000Oo0() + ":\n" + o0000Oo02.O00000o;
                                }
                            } else {
                                String str5 = str;
                                int i7 = 0;
                                while (i7 < list2.size()) {
                                    O0000Oo0 o0000Oo03 = (O0000Oo0) list2.get(i7);
                                    Iterator<Map.Entry<String, Device>> it = fno.O000000o().O0000O0o().entrySet().iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            device = null;
                                            break;
                                        }
                                        device = it.next().getValue();
                                        if (!TextUtils.equals(o0000Oo03.O00000o0, device.model)) {
                                            break;
                                        }
                                    }
                                    if (device != null) {
                                        StringBuilder sb2 = new StringBuilder();
                                        sb2.append(device.name);
                                        Resources resources = UpdateActivity.this.getResources();
                                        int size3 = list2.size();
                                        StringBuilder sb3 = new StringBuilder();
                                        sb3.append(list2.size());
                                        sb2.append(resources.getQuantityString(R.plurals.more_device, size3, sb3.toString()));
                                        str5 = sb2.toString();
                                    }
                                    i7++;
                                    o0000Oo = this;
                                }
                                if (!TextUtils.isEmpty(str5)) {
                                    if (i6 != 0 || o0000o00.O00000o0()) {
                                        str4 = str4 + "\n\n" + str5 + "\n" + ((O0000Oo0) list2.get(0)).O00000o;
                                        i6++;
                                        str = null;
                                        i3 = 0;
                                        i4 = 1;
                                        o0000Oo = this;
                                    } else {
                                        str4 = str4 + str5 + "\n" + ((O0000Oo0) list2.get(0)).O00000o;
                                    }
                                }
                            }
                        }
                        i6++;
                        str = null;
                        i3 = 0;
                        i4 = 1;
                        o0000Oo = this;
                    }
                    str2 = str4;
                }
                o0000o0.O0000Oo.setText(str2);
            }
            return view2;
        }

        public final void O000000o(String str, int i) {
            for (O00000o0 next : UpdateActivity.this.O0000OoO) {
                if (next instanceof O00000o) {
                    O00000o o00000o = (O00000o) next;
                    if (o00000o.O0000O0o.equals(str)) {
                        if (!(o00000o.O00000Oo == UpdateStatus.UPDATING_FAILURE || o00000o.O00000Oo == UpdateStatus.UPDATING_SUCCESS)) {
                            o00000o.O00000Oo = UpdateStatus.UPDATING;
                            double d = (double) i;
                            Double.isNaN(d);
                            o00000o.O00000o0 = (float) (d / 100.0d);
                        }
                        UpdateActivity.this.refreshUI();
                        return;
                    }
                }
            }
        }

        public final void O000000o(String str) {
            for (O00000o0 next : UpdateActivity.this.O0000OoO) {
                if (next instanceof O00000o) {
                    O00000o o00000o = (O00000o) next;
                    if (o00000o.O0000O0o.equals(str)) {
                        if (!(o00000o.O00000Oo == UpdateStatus.UPDATING_FAILURE || o00000o.O00000Oo == UpdateStatus.UPDATING_SUCCESS)) {
                            o00000o.O00000Oo = UpdateStatus.UPDATING_SUCCESS;
                        }
                        UpdateActivity.this.refreshUI();
                        return;
                    }
                }
            }
        }

        public final void O00000Oo(String str) {
            for (O00000o0 next : UpdateActivity.this.O0000OoO) {
                if (next instanceof O00000o) {
                    O00000o o00000o = (O00000o) next;
                    if (o00000o.O0000O0o.equals(str)) {
                        o00000o.O00000Oo = UpdateStatus.UPDATING_FAILURE;
                        UpdateActivity.this.refreshUI();
                        return;
                    }
                }
            }
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.O0000Ooo = true;
        gez.O000000o().O000000o(false);
        MLAlertDialog mLAlertDialog = this.O0000o00;
        if (mLAlertDialog != null && mLAlertDialog.isShowing()) {
            this.O0000o00.dismiss();
        }
    }
}

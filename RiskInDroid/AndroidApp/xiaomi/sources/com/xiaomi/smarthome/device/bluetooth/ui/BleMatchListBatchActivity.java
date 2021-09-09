package com.xiaomi.smarthome.device.bluetooth.ui;

import _m_j.ddb;
import _m_j.fbs;
import _m_j.fbt;
import _m_j.fno;
import _m_j.fob;
import _m_j.fpo;
import _m_j.fte;
import _m_j.gle;
import _m_j.gqb;
import _m_j.gsy;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.device.BleDevice;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.device.bluetooth.connect.ConnectBaseActivity;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.library.bluetooth.BleConnectOptions;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.library.log.LogType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class BleMatchListBatchActivity extends ConnectBaseActivity {
    public static final String TAG = "BleMatchListBatchActivity";
    public static AtomicBoolean sIBinding = new AtomicBoolean(false);

    /* renamed from: O000000o  reason: collision with root package name */
    XQProgressDialog f7156O000000o;
    fno.O000000o O00000Oo = new fno.O000000o() {
        /* class com.xiaomi.smarthome.device.bluetooth.ui.BleMatchListBatchActivity.AnonymousClass1 */

        public final void onRefreshClientDeviceChanged(int i, Device device) {
        }

        public final void onRefreshClientDeviceSuccess(int i) {
            if (i == 3) {
                fno.O000000o().O00000Oo(BleMatchListBatchActivity.this.O00000Oo);
                BleMatchListBatchActivity.this.startChooseRoom();
                BleMatchListBatchActivity bleMatchListBatchActivity = BleMatchListBatchActivity.this;
                if (bleMatchListBatchActivity.f7156O000000o != null) {
                    bleMatchListBatchActivity.f7156O000000o.dismiss();
                }
            }
        }
    };
    private O000000o O00000o;
    private ListView O00000o0;
    private TextView O00000oO;
    private BleConnectOptions O00000oo;
    private TextView O0000O0o;
    private gle O0000OOo = new gle() {
        /* class com.xiaomi.smarthome.device.bluetooth.ui.BleMatchListBatchActivity.AnonymousClass4 */

        public final void O000000o(int i, Bundle bundle) {
            fte.O00000Oo(String.format("BleBindActivity onConnectResponse: code = %d", Integer.valueOf(i)));
            gsy.O00000Oo(LogType.BLUETOOTH, BleMatchListBatchActivity.TAG, String.format("BleBindActivity onConnectResponse: code = %d", Integer.valueOf(i)));
        }

        public final void O00000Oo(int i, Bundle bundle) {
            fte.O00000Oo(String.format("BleBindActivity onAuthResponse: code = %d", Integer.valueOf(i)));
            gsy.O00000Oo(LogType.BLUETOOTH, BleMatchListBatchActivity.TAG, String.format("BleBindActivity onAuthResponse: code = %d", Integer.valueOf(i)));
        }

        public final void O00000o0(int i, Bundle bundle) {
            fte.O00000Oo(String.format("BleBindActivity onBindResponse: code = %d", Integer.valueOf(i)));
            gsy.O00000Oo(LogType.BLUETOOTH, BleMatchListBatchActivity.TAG, String.format("BleBindActivity onBindResponse: code = %d", Integer.valueOf(i)));
        }

        public final void O00000o(int i, Bundle bundle) {
            fte.O00000Oo(String.format("BleBindActivity onLastResponse: code = %d", Integer.valueOf(i)));
            gsy.O00000Oo(LogType.BLUETOOTH, BleMatchListBatchActivity.TAG, String.format("BleBindActivity onLastResponse: code = %d", Integer.valueOf(i)));
            if (i == 0) {
                fob.O00000Oo((Device) BleMatchListBatchActivity.this.mCurrentBindItem.O00000o0);
                BleMatchListBatchActivity bleMatchListBatchActivity = BleMatchListBatchActivity.this;
                bleMatchListBatchActivity.bindSuccess(bleMatchListBatchActivity.mCurrentBindItem);
                return;
            }
            BleMatchListBatchActivity bleMatchListBatchActivity2 = BleMatchListBatchActivity.this;
            bleMatchListBatchActivity2.bindFailed(bleMatchListBatchActivity2.mCurrentBindItem);
        }
    };
    private View.OnClickListener O0000Oo0 = new View.OnClickListener() {
        /* class com.xiaomi.smarthome.device.bluetooth.ui.BleMatchListBatchActivity.AnonymousClass5 */

        public final void onClick(View view) {
            if (BleMatchListBatchActivity.sIBinding.get()) {
                new MLAlertDialog.Builder(BleMatchListBatchActivity.this).O000000o((int) R.string.ble_new_cancel_dialog_title).O00000Oo((int) R.string.ble_new_cancel_dialog_message).O000000o((int) R.string.ble_new_cancel_dialog_ok_button, new DialogInterface.OnClickListener() {
                    /* class com.xiaomi.smarthome.device.bluetooth.ui.BleMatchListBatchActivity.AnonymousClass5.AnonymousClass1 */

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        if (BleMatchListBatchActivity.this.mCurrentBindItem != null) {
                            BleMatchListBatchActivity.this.mCurrentBindItem.O00000o0.O00000oo();
                        }
                        BleMatchListBatchActivity.this.finish();
                    }
                }).O00000Oo((int) R.string.sh_common_lib_cancel, (DialogInterface.OnClickListener) null).O00000o().show();
            } else {
                BleMatchListBatchActivity.this.finish();
            }
        }
    };
    public List<O00000Oo> mBindItemList = new ArrayList();
    public O00000Oo mCurrentBindItem;

    enum UpdateStatus {
        PENDING,
        UPDATING,
        UPDATING_SUCCESS,
        UPDATING_FAILURE
    }

    public static void open(Activity activity, ArrayList<String> arrayList, String str) {
        if (activity != null && !TextUtils.isEmpty(str) && arrayList != null) {
            Intent intent = new Intent();
            intent.setClass(activity, BleMatchListBatchActivity.class);
            intent.putStringArrayListExtra("key_macs", arrayList);
            intent.putExtra("key_title", str);
            activity.startActivity(intent);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_ble_match_list_batch);
        ArrayList<String> stringArrayListExtra = getIntent().getStringArrayListExtra("key_macs");
        if (stringArrayListExtra == null) {
            ddb.O000000o("macs == null");
            finish();
        } else {
            Iterator<String> it = stringArrayListExtra.iterator();
            while (it.hasNext()) {
                BleDevice O00000o02 = fob.O00000o0(it.next());
                if (O00000o02 != null) {
                    O00000Oo o00000Oo = new O00000Oo();
                    o00000Oo.O00000o0 = O00000o02;
                    this.mBindItemList.add(o00000Oo);
                }
            }
        }
        ((TextView) findViewById(R.id.module_a_3_return_title)).setText(getIntent().getStringExtra("key_title"));
        ((ImageView) findViewById(R.id.module_a_3_return_btn)).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.device.bluetooth.ui.BleMatchListBatchActivity.AnonymousClass2 */

            public final void onClick(View view) {
                BleMatchListBatchActivity.this.onBackPressed();
            }
        });
        findViewById(R.id.module_a_3_right_btn).setVisibility(8);
        this.O0000O0o = (TextView) findViewById(R.id.next);
        this.O0000O0o.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.device.bluetooth.ui.BleMatchListBatchActivity.AnonymousClass3 */

            public final void onClick(View view) {
                fno.O000000o().O000000o(BleMatchListBatchActivity.this.O00000Oo);
                fno.O000000o().O0000Oo0();
                BleMatchListBatchActivity bleMatchListBatchActivity = BleMatchListBatchActivity.this;
                if (bleMatchListBatchActivity.isValid()) {
                    bleMatchListBatchActivity.f7156O000000o = new XQProgressDialog(bleMatchListBatchActivity);
                    bleMatchListBatchActivity.f7156O000000o.setMessage(bleMatchListBatchActivity.getString(R.string.device_more_security_loading_operation));
                    bleMatchListBatchActivity.f7156O000000o.show();
                }
            }
        });
        this.O00000oO = (TextView) findViewById(R.id.category);
        O000000o();
        this.O00000o0 = (ListView) findViewById(R.id.listview);
        this.O00000o0.setSelector(new ColorDrawable(0));
        this.O00000o = new O000000o(this, (byte) 0);
        this.O00000o0.setAdapter((ListAdapter) this.O00000o);
        BleConnectOptions.O000000o o000000o = new BleConnectOptions.O000000o();
        o000000o.f9073O000000o = 1;
        o000000o.O00000o0 = 31000;
        o000000o.O00000Oo = 2;
        o000000o.O00000o = 15000;
        this.O00000oo = o000000o.O000000o();
        O000000o(1000);
    }

    public void onPause() {
        super.onPause();
    }

    public void onDestroy() {
        O00000Oo o00000Oo;
        super.onDestroy();
        if (sIBinding.get() && (o00000Oo = this.mCurrentBindItem) != null) {
            o00000Oo.O00000o0.O00000oo();
        }
    }

    public void startChooseRoom() {
        ArrayList arrayList = new ArrayList();
        for (O00000Oo next : this.mBindItemList) {
            if (next.f7165O000000o == UpdateStatus.UPDATING_SUCCESS) {
                Device O00000o2 = fno.O000000o().O00000o(next.O00000o0.mac);
                if (O00000o2 == null) {
                    LogType logType = LogType.BLUETOOTH;
                    String str = TAG;
                    gsy.O00000Oo(logType, str, "find device by mac == null " + next.O00000o0.mac);
                } else {
                    arrayList.add(O00000o2.did);
                    O00000o2.isOnlineAdvance();
                }
            }
        }
        if (!arrayList.isEmpty()) {
            fbt fbt = new fbt(this, "initDeviceRoomActivity");
            fbt.O000000o().putStringArrayList("device_did_list", arrayList);
            fbs.O000000o(fbt);
            finish();
            return;
        }
        ddb.O000000o("didlist == " + arrayList.size());
    }

    private void O000000o() {
        int i = 0;
        int i2 = 0;
        for (O00000Oo next : this.mBindItemList) {
            if (next.f7165O000000o == UpdateStatus.UPDATING_SUCCESS) {
                i++;
            }
            if (next.f7165O000000o == UpdateStatus.PENDING) {
                i2++;
            }
        }
        this.O00000oO.setTextColor(getResources().getColor(R.color.mj_color_green_normal));
        this.O00000oO.setText(i + "/" + gqb.O000000o(this, (int) R.plurals.ble_mesh_add_succ_size, this.mBindItemList.size(), Integer.valueOf(this.mBindItemList.size())));
        if (i <= 0 || i2 != 0) {
            this.O0000O0o.setEnabled(false);
            return;
        }
        fno.O000000o().O0000Oo0();
        this.O0000O0o.setEnabled(true);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0079, code lost:
        if (r0.O00000Oo().f6871O000000o.O00000oO != false) goto L_0x0097;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0093, code lost:
        if (r1.O00000Oo().f6871O000000o.O00000oO != false) goto L_0x0097;
     */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a8  */
    public void handleMessage(Message message) {
        O00000Oo o00000Oo;
        BleDevice bleDevice;
        LogType logType = LogType.BLUETOOTH;
        String str = TAG;
        gsy.O00000Oo(logType, str, "handleMessage " + message.what);
        if (message.what < this.mBindItemList.size() && (bleDevice = (o00000Oo = this.mBindItemList.get(message.what)).O00000o0) != null) {
            boolean z = true;
            if (!sIBinding.getAndSet(true)) {
                this.mCurrentBindItem = o00000Oo;
                o00000Oo.f7165O000000o = UpdateStatus.UPDATING;
                this.O00000o.notifyDataSetChanged();
                if (bleDevice != null) {
                    PluginDeviceInfo O00000oO2 = CoreApi.O000000o().O00000oO(bleDevice.model);
                    if (O00000oO2 == null || O00000oO2.O0000o() != Device.PID_BLE_MESH) {
                        BleDevice O00000o02 = fob.O00000o0(bleDevice.mac);
                        if (bleDevice.O00000Oo() != null) {
                            if (bleDevice.O00000Oo().f6871O000000o != null) {
                            }
                        }
                        if (O00000o02 != null) {
                            if (O00000o02.O00000Oo() != null) {
                                if (O00000o02.O00000Oo().f6871O000000o != null) {
                                }
                            }
                        }
                    }
                    if (!z) {
                        fte.O00000Oo("Start bleMeshBind");
                        fpo.O00000o(bleDevice.mac, this.O00000oo, this.O0000OOo);
                        return;
                    }
                    bindFailed(o00000Oo);
                    return;
                }
                z = false;
                if (!z) {
                }
            }
        }
    }

    private void O000000o(long j) {
        gsy.O00000Oo(LogType.BLUETOOTH, TAG, "bindNext: ");
        for (int i = 0; i < this.mBindItemList.size(); i++) {
            if (this.mBindItemList.get(i).f7165O000000o == UpdateStatus.PENDING) {
                this.mHandler.removeCallbacksAndMessages(null);
                this.mHandler.sendEmptyMessageDelayed(i, j);
                return;
            }
        }
    }

    public void bindFailed(O00000Oo o00000Oo) {
        gsy.O00000Oo(LogType.BLUETOOTH, TAG, "bindFailed: ");
        o00000Oo.f7165O000000o = UpdateStatus.UPDATING_FAILURE;
        this.O00000o.notifyDataSetChanged();
        sIBinding.getAndSet(false);
        this.mCurrentBindItem = null;
        O000000o();
        o00000Oo.O00000o0.O00000oo();
        O000000o(500);
    }

    public void bindSuccess(O00000Oo o00000Oo) {
        gsy.O00000Oo(LogType.BLUETOOTH, TAG, "bindSuccess: ");
        o00000Oo.f7165O000000o = UpdateStatus.UPDATING_SUCCESS;
        this.O00000o.notifyDataSetChanged();
        sIBinding.getAndSet(false);
        this.mCurrentBindItem = null;
        O000000o();
        o00000Oo.O00000o0.O00000oo();
        O000000o(500);
    }

    public void onBackPressed() {
        this.O0000Oo0.onClick(null);
    }

    class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        UpdateStatus f7165O000000o = UpdateStatus.PENDING;
        float O00000Oo = 0.0f;
        BleDevice O00000o0;

        O00000Oo() {
        }
    }

    class O000000o extends BaseAdapter {
        public final long getItemId(int i) {
            return (long) i;
        }

        private O000000o() {
        }

        /* synthetic */ O000000o(BleMatchListBatchActivity bleMatchListBatchActivity, byte b) {
            this();
        }

        /* renamed from: com.xiaomi.smarthome.device.bluetooth.ui.BleMatchListBatchActivity$O000000o$O000000o  reason: collision with other inner class name */
        class C0067O000000o {

            /* renamed from: O000000o  reason: collision with root package name */
            SimpleDraweeView f7164O000000o;
            TextView O00000Oo;
            View O00000o;
            TextView O00000o0;
            ImageView O00000oO;
            ImageView O00000oo;
            ImageView O0000O0o;

            private C0067O000000o() {
            }

            /* synthetic */ C0067O000000o(O000000o o000000o, byte b) {
                this();
            }
        }

        public final int getCount() {
            if (BleMatchListBatchActivity.this.mBindItemList != null) {
                return BleMatchListBatchActivity.this.mBindItemList.size();
            }
            return 0;
        }

        /* access modifiers changed from: private */
        /* renamed from: O000000o */
        public O00000Oo getItem(int i) {
            if (i < 0 || i >= getCount()) {
                return null;
            }
            return BleMatchListBatchActivity.this.mBindItemList.get(i);
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            C0067O000000o o000000o;
            if (view == null) {
                view = LayoutInflater.from(BleMatchListBatchActivity.this).inflate((int) R.layout.ble_bind_item, (ViewGroup) null);
                o000000o = new C0067O000000o(this, (byte) 0);
                o000000o.f7164O000000o = (SimpleDraweeView) view.findViewById(R.id.icon);
                o000000o.O00000Oo = (TextView) view.findViewById(R.id.name);
                o000000o.O00000o0 = (TextView) view.findViewById(R.id.mac);
                o000000o.O00000o = view.findViewById(R.id.content);
                o000000o.O00000oO = (ImageView) view.findViewById(R.id.signal);
                o000000o.O00000oo = (ImageView) view.findViewById(R.id.arrow);
                o000000o.O0000O0o = (ImageView) view.findViewById(R.id.check);
                view.setTag(o000000o);
            } else {
                o000000o = (C0067O000000o) view.getTag();
            }
            O00000Oo O000000o2 = getItem(i);
            o000000o.O00000Oo.setText(O000000o2.O00000o0.name);
            o000000o.O00000o0.setText(O000000o2.O00000o0.mac);
            o000000o.O00000o0.setVisibility(TextUtils.isEmpty(O000000o2.O00000o0.mac) ? 8 : 0);
            o000000o.O00000oo.setVisibility(8);
            o000000o.O00000oO.setVisibility(8);
            o000000o.O0000O0o.setVisibility(0);
            if (O000000o2.f7165O000000o == UpdateStatus.PENDING) {
                o000000o.O0000O0o.setBackgroundResource(R.drawable.icon_pending);
                o000000o.O0000O0o.clearAnimation();
            } else if (O000000o2.f7165O000000o == UpdateStatus.UPDATING) {
                o000000o.O0000O0o.setBackgroundResource(R.drawable.icon_light_group_loading);
                o000000o.O0000O0o.startAnimation(AnimationUtils.loadAnimation(BleMatchListBatchActivity.this.getContext(), R.anim.miconnect_rotate_infinite));
                o000000o.O0000O0o.setOnClickListener(null);
            } else if (O000000o2.f7165O000000o == UpdateStatus.UPDATING_SUCCESS) {
                o000000o.O0000O0o.clearAnimation();
                o000000o.O0000O0o.setBackgroundResource(R.drawable.icon_light_group_checked);
            } else if (O000000o2.f7165O000000o == UpdateStatus.UPDATING_FAILURE) {
                o000000o.O0000O0o.clearAnimation();
                o000000o.O0000O0o.setBackgroundResource(R.drawable.icon_checkbox_offline);
            }
            DeviceFactory.O00000Oo(O000000o2.O00000o0.model, o000000o.f7164O000000o);
            return view;
        }
    }
}

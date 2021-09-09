package com.xiaomi.smarthome.device.bluetooth.ui;

import _m_j.fob;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.smarthome.connect.model.UnduplicateList;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.BleDevice;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.device.bluetooth.BleDeviceGroup;
import com.xiaomi.smarthome.device.bluetooth.connect.ConnectBaseActivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BleMatchListChoiceActivity extends ConnectBaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private ListView f7166O000000o;
    private BleDeviceGroup O00000Oo;
    private TextView O00000o;
    private TextView O00000o0;
    public O000000o mAdapter;
    public List<BleDevice> mMatchingDeviceList;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_ble_match_list);
        String stringExtra = getIntent().getStringExtra("key_model");
        this.mMatchingDeviceList = new ArrayList();
        this.O00000Oo = fob.O000000o(stringExtra);
        BleDeviceGroup bleDeviceGroup = this.O00000Oo;
        if (bleDeviceGroup != null) {
            bleDeviceGroup.O0000OoO();
            for (BleDevice next : this.O00000Oo.O0000OoO()) {
                if (!this.mMatchingDeviceList.contains(next)) {
                    this.mMatchingDeviceList.add(next);
                }
            }
        }
        Collections.sort(this.mMatchingDeviceList, new Comparator<BleDevice>() {
            /* class com.xiaomi.smarthome.device.bluetooth.ui.BleMatchListChoiceActivity.AnonymousClass1 */

            public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                return ((BleDevice) obj2).rssi - ((BleDevice) obj).rssi;
            }
        });
        final TextView textView = (TextView) findViewById(R.id.module_a_3_return_title);
        BleDeviceGroup bleDeviceGroup2 = this.O00000Oo;
        if (bleDeviceGroup2 != null) {
            textView.setText(BleDevice.O00000Oo(bleDeviceGroup2.model));
        }
        ((ImageView) findViewById(R.id.module_a_3_return_btn)).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.device.bluetooth.ui.BleMatchListChoiceActivity.AnonymousClass2 */

            public final void onClick(View view) {
                BleMatchListChoiceActivity.this.onBackPressed();
            }
        });
        this.O00000o0 = (TextView) findViewById(R.id.module_a_3_right_text_btn);
        this.O00000o0.setText((int) R.string.select_all);
        if (this.mMatchingDeviceList.size() > 0) {
            this.O00000o0.setVisibility(0);
            this.O00000o0.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.device.bluetooth.ui.BleMatchListChoiceActivity.AnonymousClass3 */

                public final void onClick(View view) {
                    O000000o o000000o = BleMatchListChoiceActivity.this.mAdapter;
                    boolean z = BleMatchListChoiceActivity.this.mAdapter.f7171O000000o.size() < BleMatchListChoiceActivity.this.mMatchingDeviceList.size();
                    for (int i = 0; i < BleMatchListChoiceActivity.this.mMatchingDeviceList.size(); i++) {
                        o000000o.O000000o(BleMatchListChoiceActivity.this.mMatchingDeviceList.get(i).mac, z);
                    }
                    BleMatchListChoiceActivity.this.mAdapter.notifyDataSetChanged();
                }
            });
        }
        findViewById(R.id.module_a_3_right_btn).setVisibility(8);
        this.O00000o = (TextView) findViewById(R.id.add_batch);
        this.O00000o.setEnabled(false);
        this.O00000o.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.device.bluetooth.ui.BleMatchListChoiceActivity.AnonymousClass4 */

            public final void onClick(View view) {
                BleMatchListBatchActivity.open(BleMatchListChoiceActivity.this, new ArrayList(BleMatchListChoiceActivity.this.mAdapter.f7171O000000o), textView.getText().toString());
            }
        });
        this.f7166O000000o = (ListView) findViewById(R.id.listview);
        this.f7166O000000o.setSelector(new ColorDrawable(0));
        this.mAdapter = new O000000o(this, (byte) 0);
        this.f7166O000000o.setAdapter((ListAdapter) this.mAdapter);
    }

    public void onPause() {
        super.onPause();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onBackPressed() {
        finish();
    }

    public void updateActionItems(int i) {
        try {
            if (i >= this.mMatchingDeviceList.size()) {
                this.O00000o0.setText((int) R.string.unselect_all);
            } else {
                this.O00000o0.setText((int) R.string.select_all);
            }
            if (this.mAdapter.f7171O000000o.size() > 0) {
                this.O00000o.setEnabled(true);
            } else {
                this.O00000o.setEnabled(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class O000000o extends BaseAdapter {

        /* renamed from: O000000o  reason: collision with root package name */
        public List<String> f7171O000000o;

        public final long getItemId(int i) {
            return (long) i;
        }

        private O000000o() {
            this.f7171O000000o = new UnduplicateList();
        }

        /* synthetic */ O000000o(BleMatchListChoiceActivity bleMatchListChoiceActivity, byte b) {
            this();
        }

        /* renamed from: com.xiaomi.smarthome.device.bluetooth.ui.BleMatchListChoiceActivity$O000000o$O000000o  reason: collision with other inner class name */
        class C0068O000000o {

            /* renamed from: O000000o  reason: collision with root package name */
            SimpleDraweeView f7173O000000o;
            TextView O00000Oo;
            View O00000o;
            TextView O00000o0;
            ImageView O00000oO;
            ImageView O00000oo;
            ImageView O0000O0o;

            private C0068O000000o() {
            }

            /* synthetic */ C0068O000000o(O000000o o000000o, byte b) {
                this();
            }
        }

        public final int getCount() {
            if (BleMatchListChoiceActivity.this.mMatchingDeviceList != null) {
                return BleMatchListChoiceActivity.this.mMatchingDeviceList.size();
            }
            return 0;
        }

        /* access modifiers changed from: private */
        /* renamed from: O000000o */
        public BleDevice getItem(int i) {
            if (i < 0 || i >= getCount()) {
                return null;
            }
            return BleMatchListChoiceActivity.this.mMatchingDeviceList.get(i);
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            final C0068O000000o o000000o;
            if (view == null) {
                view = LayoutInflater.from(BleMatchListChoiceActivity.this).inflate((int) R.layout.ble_bind_item, (ViewGroup) null);
                o000000o = new C0068O000000o(this, (byte) 0);
                o000000o.f7173O000000o = (SimpleDraweeView) view.findViewById(R.id.icon);
                o000000o.O00000Oo = (TextView) view.findViewById(R.id.name);
                o000000o.O00000o0 = (TextView) view.findViewById(R.id.mac);
                o000000o.O00000o = view.findViewById(R.id.content);
                o000000o.O00000oO = (ImageView) view.findViewById(R.id.signal);
                o000000o.O00000oo = (ImageView) view.findViewById(R.id.arrow);
                o000000o.O0000O0o = (ImageView) view.findViewById(R.id.check);
                view.setTag(o000000o);
            } else {
                o000000o = (C0068O000000o) view.getTag();
            }
            final BleDevice O000000o2 = getItem(i);
            o000000o.O00000Oo.setText(BleMatchListChoiceActivity.this.getDeviceName(O000000o2));
            o000000o.O00000o0.setText(O000000o2.mac);
            o000000o.O00000o0.setVisibility(TextUtils.isEmpty(O000000o2.mac) ? 8 : 0);
            o000000o.O00000oo.setVisibility(8);
            o000000o.O00000oO.setVisibility(8);
            o000000o.O0000O0o.setVisibility(0);
            o000000o.O00000o.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.device.bluetooth.ui.BleMatchListChoiceActivity.O000000o.AnonymousClass1 */

                public final void onClick(View view) {
                    boolean contains = O000000o.this.f7171O000000o.contains(O000000o2.mac);
                    O000000o.this.O000000o(O000000o2.mac, !contains);
                    o000000o.O0000O0o.setBackgroundResource(!contains ? R.drawable.mj_webp_widget_checkbox_pres : R.drawable.mj_webp_widget_checkbox_uncheck_pres);
                }
            });
            if (this.f7171O000000o.contains(O000000o2.mac)) {
                o000000o.O0000O0o.setBackgroundResource(R.drawable.mj_webp_widget_checkbox_pres);
            } else {
                o000000o.O0000O0o.setBackgroundResource(R.drawable.mj_webp_widget_checkbox_uncheck_pres);
            }
            DeviceFactory.O00000Oo(O000000o2.model, o000000o.f7173O000000o);
            return view;
        }

        public final void O000000o(String str, boolean z) {
            if (!TextUtils.isEmpty(str)) {
                if (z) {
                    this.f7171O000000o.add(str);
                } else {
                    this.f7171O000000o.remove(str);
                }
                BleMatchListChoiceActivity.this.updateActionItems(this.f7171O000000o.size());
            }
        }
    }

    public String getDeviceName(BleDevice bleDevice) {
        return BleDeviceGroup.O00000Oo(bleDevice.model);
    }
}

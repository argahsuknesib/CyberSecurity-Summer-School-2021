package com.xiaomi.smarthome.device.choosedevice;

import _m_j.fqy;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfoStatus;
import com.xiaomi.smarthome.core.server.internal.plugin.PluginDeviceManager;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.device.ResetDevicePage;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.common.widget.HeaderGridView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ScanQRCodeDeviceActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private HeaderGridView f7269O000000o;
    public O000000o mListAdapter;

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, com.xiaomi.smarthome.library.common.widget.HeaderGridView, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_scan_qrcode_device_list);
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.device.choosedevice.ScanQRCodeDeviceActivity.AnonymousClass1 */

            public final void onClick(View view) {
                ScanQRCodeDeviceActivity.this.finish();
            }
        });
        ((TextView) findViewById(R.id.module_a_3_return_title)).setText((int) R.string.choose_device_title);
        this.f7269O000000o = (HeaderGridView) findViewById(R.id.scan_qrcode_device_list);
        this.mListAdapter = new O000000o(this, (byte) 0);
        View inflate = LayoutInflater.from(this).inflate((int) R.layout.space_scan_qrcode_device_list, (ViewGroup) this.f7269O000000o, false);
        HeaderGridView headerGridView = this.f7269O000000o;
        ListAdapter adapter = headerGridView.getAdapter();
        if (adapter == null || (adapter instanceof HeaderGridView.O00000o0)) {
            HeaderGridView.O000000o o000000o = new HeaderGridView.O000000o((byte) 0);
            HeaderGridView.O00000Oo o00000Oo = new HeaderGridView.O00000Oo(headerGridView.getContext());
            o00000Oo.addView(inflate);
            o000000o.f9191O000000o = inflate;
            o000000o.O00000Oo = o00000Oo;
            o000000o.O00000o0 = null;
            o000000o.O00000o = true;
            headerGridView.f9190O000000o.add(o000000o);
            if (adapter != null) {
                ((HeaderGridView.O00000o0) adapter).f9193O000000o.notifyChanged();
            }
            this.f7269O000000o.setAdapter((ListAdapter) this.mListAdapter);
            CommonApplication.getGlobalWorkerHandler().post(new Runnable() {
                /* class com.xiaomi.smarthome.device.choosedevice.ScanQRCodeDeviceActivity.AnonymousClass2 */

                public final void run() {
                    ScanQRCodeDeviceActivity.this.processPluginData();
                }
            });
            return;
        }
        throw new IllegalStateException("Cannot add header view to grid -- setAdapter has already been called.");
    }

    public void processPluginData() {
        Map<String, PluginDeviceInfo> pluginInfoMap = PluginDeviceManager.instance.getPluginInfoMap();
        if (pluginInfoMap != null) {
            final ArrayList arrayList = new ArrayList(pluginInfoMap.values());
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (((PluginDeviceInfo) arrayList.get(size)).O00000o() != 5) {
                    arrayList.remove(size);
                } else {
                    int O00000oO = ((PluginDeviceInfo) arrayList.get(size)).O00000oO();
                    if (O00000oO != 3 && O00000oO != 4 && O00000oO != 1) {
                        arrayList.remove(size);
                    } else if (!(((PluginDeviceInfo) arrayList.get(size)).O0000oO0() == PluginDeviceInfoStatus.RELEASE || ((PluginDeviceInfo) arrayList.get(size)).O0000oO0() == PluginDeviceInfoStatus.WHITE_LIST)) {
                        arrayList.remove(size);
                    }
                }
            }
            this.mHandler.post(new Runnable() {
                /* class com.xiaomi.smarthome.device.choosedevice.ScanQRCodeDeviceActivity.AnonymousClass3 */

                public final void run() {
                    ScanQRCodeDeviceActivity.this.mListAdapter.f7273O000000o = arrayList;
                    ScanQRCodeDeviceActivity.this.mListAdapter.notifyDataSetChanged();
                }
            });
        }
    }

    class O000000o extends BaseAdapter {

        /* renamed from: O000000o  reason: collision with root package name */
        List<PluginDeviceInfo> f7273O000000o;

        private static boolean O000000o(char c) {
            if (c >= 'a' && c <= 'z') {
                return true;
            }
            if (c < 'A' || c > 'Z') {
                return c >= '0' && c <= '9';
            }
            return true;
        }

        public final Object getItem(int i) {
            return null;
        }

        public final long getItemId(int i) {
            return 0;
        }

        private O000000o() {
            this.f7273O000000o = new ArrayList();
        }

        /* synthetic */ O000000o(ScanQRCodeDeviceActivity scanQRCodeDeviceActivity, byte b) {
            this();
        }

        public final int getCount() {
            return this.f7273O000000o.size();
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public final View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(ScanQRCodeDeviceActivity.this.getContext()).inflate((int) R.layout.choose_device_grid_item, viewGroup, false);
            }
            final PluginDeviceInfo pluginDeviceInfo = this.f7273O000000o.get(i);
            TextView textView = (TextView) view.findViewById(R.id.name);
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.image);
            ((ImageView) view.findViewById(R.id.image_new_tag)).setVisibility(8);
            String O0000Oo0 = pluginDeviceInfo.O0000Oo0();
            if (O0000Oo0.length() <= 6) {
                textView.setText(O0000Oo0);
            } else {
                StringBuilder sb = new StringBuilder(O0000Oo0.substring(0, 6));
                StringBuilder sb2 = new StringBuilder(O0000Oo0.substring(6, O0000Oo0.length()));
                if (O000000o(sb.charAt(sb.length() - 1)) && O000000o(sb2.charAt(0))) {
                    while (sb2.length() > 0 && O000000o(sb2.charAt(0))) {
                        sb.append(sb2.charAt(0));
                        sb2.deleteCharAt(0);
                    }
                }
                if (sb2.toString().trim().length() > 6) {
                    sb2.delete(6, sb2.length());
                    sb2.append("...");
                }
                textView.setText(sb.toString().trim() + "\n" + sb2.toString().trim());
            }
            DeviceFactory.O00000Oo(pluginDeviceInfo.O00000Oo(), simpleDraweeView);
            view.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.device.choosedevice.ScanQRCodeDeviceActivity.O000000o.AnonymousClass1 */

                public final void onClick(View view) {
                    Intent intent = new Intent(ScanQRCodeDeviceActivity.this, ResetDevicePage.class);
                    pluginDeviceInfo.O00000Oo();
                    fqy.O000000o(intent, 3);
                    intent.putExtra("model", pluginDeviceInfo.O00000Oo());
                    intent.addFlags(536870912);
                    intent.addFlags(67108864);
                    ScanQRCodeDeviceActivity.this.startActivity(intent);
                    ScanQRCodeDeviceActivity.this.finish();
                }
            });
            return view;
        }
    }
}

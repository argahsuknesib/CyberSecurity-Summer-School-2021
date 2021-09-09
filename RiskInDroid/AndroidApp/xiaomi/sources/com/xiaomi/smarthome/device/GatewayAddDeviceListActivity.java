package com.xiaomi.smarthome.device;

import _m_j.ezb;
import _m_j.ezc;
import _m_j.fno;
import _m_j.fqg;
import _m_j.go;
import _m_j.gqg;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import java.util.ArrayList;
import java.util.List;

public class GatewayAddDeviceListActivity extends BaseActivity implements ezb.O000000o {
    public Device mGatewayDevice;
    public List<PluginDeviceInfo> mList = new ArrayList();
    public O000000o mSubDeviceAdapter;

    public static void showActivity(Activity activity, String str) {
        activity.startActivity(new Intent(activity, GatewayAddDeviceListActivity.class).putExtra("gateway_did", str));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_bind_subdevice_list);
        this.mGatewayDevice = fno.O000000o().O000000o(getIntent().getStringExtra("gateway_did"));
        if (this.mGatewayDevice == null) {
            gqg.O00000Oo((int) R.string.gateway_recongise_device_fail);
            finish();
            return;
        }
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.device_list_rv);
        findViewById(R.id.title_bar_return).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.device.GatewayAddDeviceListActivity.AnonymousClass3 */

            public final void onClick(View view) {
                GatewayAddDeviceListActivity.this.onBackPressed();
            }
        });
        View findViewById = findViewById(R.id.title_bar_more);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
        ((TextView) findViewById(R.id.title_bar_title)).setText((int) R.string.add_zigbee_sub_device);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        this.mSubDeviceAdapter = new O000000o(this, this.mList);
        recyclerView.setAdapter(this.mSubDeviceAdapter);
        recyclerView.setItemAnimator(new go());
        this.mSubDeviceAdapter.O00000o0 = this;
        if (fqg.O00000Oo.f16899O000000o.O000000o()) {
            requestData(fqg.O00000Oo.f16899O000000o.O00000Oo(this.mGatewayDevice));
        } else {
            fqg.O00000Oo.f16899O000000o.O000000o(new fqg.O00000o0() {
                /* class com.xiaomi.smarthome.device.GatewayAddDeviceListActivity.AnonymousClass1 */

                public final void O000000o() {
                    List<String> O00000Oo = fqg.O00000Oo.f16899O000000o.O00000Oo(GatewayAddDeviceListActivity.this.mGatewayDevice);
                    fqg.O00000Oo.f16899O000000o.O00000Oo(this);
                    GatewayAddDeviceListActivity.this.requestData(O00000Oo);
                }
            });
        }
    }

    public void requestData(List<String> list) {
        final ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (String O00000oO : list) {
                PluginDeviceInfo O00000oO2 = CoreApi.O000000o().O00000oO(O00000oO);
                if (O00000oO2 != null) {
                    arrayList.add(O00000oO2);
                }
            }
            this.mHandler.post(new Runnable() {
                /* class com.xiaomi.smarthome.device.GatewayAddDeviceListActivity.AnonymousClass2 */

                public final void run() {
                    GatewayAddDeviceListActivity.this.mList.clear();
                    GatewayAddDeviceListActivity.this.mList.addAll(arrayList);
                    GatewayAddDeviceListActivity.this.mSubDeviceAdapter.notifyDataSetChanged();
                }
            });
        }
    }

    public void onItemClick(RecyclerView recyclerView, View view, int i) {
        ChooseGatewayDevice.nextActivity(this, this.mGatewayDevice, this.mList.get(i), 11, null);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 11) {
            if (i2 == -1) {
                setResult(-2, intent);
            }
            finish();
        }
    }

    static class O000000o extends ezb<PluginDeviceInfo> {
        public final int O00000o0(int i) {
            return R.layout.gateway_choose_device_item_layout;
        }

        public final /* synthetic */ void O000000o(ezc ezc, Object obj, int i) {
            PluginDeviceInfo pluginDeviceInfo = (PluginDeviceInfo) obj;
            ((TextView) ezc.O000000o((int) R.id.add_sub_device_item_tv)).setText(pluginDeviceInfo.O0000Oo0());
            DeviceFactory.O00000Oo(pluginDeviceInfo.O00000Oo(), (SimpleDraweeView) ezc.O000000o((int) R.id.add_sub_device_item_iv));
        }

        public O000000o(Context context, List<PluginDeviceInfo> list) {
            super(context, list);
        }
    }
}

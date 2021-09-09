package com.xiaomi.smarthome.scene.pluginrecommend;

import _m_j.hpt;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.scene.activity.PluginRecommendSceneActionActivity;
import java.util.List;

public class LockDissConnectBleActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private TextView f11208O000000o;
    private TextView O00000Oo;
    private int O00000o;
    private String O00000o0;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.light_rec_scene_condition_activity);
        this.O00000o0 = getIntent().getStringExtra("home_id");
        this.O00000o = getIntent().getIntExtra("sr_id", 0);
        this.f11208O000000o = (TextView) findViewById(R.id.module_a_3_return_title);
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.pluginrecommend.$$Lambda$LockDissConnectBleActivity$GhHFO6CQ1B7uyr3SzjibPsMsyE4 */

            public final void onClick(View view) {
                LockDissConnectBleActivity.this.O000000o(view);
            }
        });
        if (hpt.O000000o().f492O000000o != null && !TextUtils.isEmpty(hpt.O000000o().f492O000000o.entryDesc)) {
            this.f11208O000000o.setText(hpt.O000000o().f492O000000o.intro);
        }
        final List<Device> O000000o2 = hpt.O000000o(this.O00000o0);
        View inflate = ((ViewStub) findViewById(R.id.ble_list_view)).inflate();
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.recycler_view);
        this.O00000Oo = (TextView) inflate.findViewById(R.id.connect_tip);
        if (this.O00000o == 1000) {
            this.O00000Oo.setText((int) R.string.rec_scene_lock_connect_ble_top);
        } else {
            this.O00000Oo.setText((int) R.string.rec_scene_device_connect_ble_top);
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new RecyclerView.O000000o<PluginRecommendSceneActionActivity.O00000Oo>() {
            /* class com.xiaomi.smarthome.scene.pluginrecommend.LockDissConnectBleActivity.AnonymousClass1 */

            public final long getItemId(int i) {
                return (long) i;
            }

            public final /* synthetic */ void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
                PluginRecommendSceneActionActivity.O00000Oo o00000Oo = (PluginRecommendSceneActionActivity.O00000Oo) o000OOo0;
                if (i == O000000o2.size() - 1) {
                    o00000Oo.O00000o0.setVisibility(0);
                } else {
                    o00000Oo.O00000o0.setVisibility(8);
                }
                String str = ((Device) O000000o2.get(i)).name;
                if (!TextUtils.isEmpty(str)) {
                    o00000Oo.O00000Oo.setText(str);
                } else {
                    o00000Oo.O00000Oo.setText("");
                }
                DeviceFactory.O00000Oo(((Device) O000000o2.get(i)).model, o00000Oo.f10798O000000o);
            }

            public final int getItemCount() {
                List list = O000000o2;
                if (list == null) {
                    return 0;
                }
                return list.size();
            }

            public final /* synthetic */ RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
                return new PluginRecommendSceneActionActivity.O00000Oo(LayoutInflater.from(LockDissConnectBleActivity.this).inflate((int) R.layout.item_plugin_rec_action_connect_ble, (ViewGroup) null));
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(View view) {
        finish();
    }
}

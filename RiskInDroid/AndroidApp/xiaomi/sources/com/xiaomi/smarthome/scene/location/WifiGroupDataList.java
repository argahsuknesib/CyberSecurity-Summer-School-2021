package com.xiaomi.smarthome.scene.location;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.common.widget.CustomPullDownRefreshListView;
import com.xiaomi.smarthome.library.common.widget.PullDownDragListView;
import com.xiaomi.smarthome.scene.location.model.WifiGroupData;
import java.util.ArrayList;
import java.util.List;

public class WifiGroupDataList extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    List<WifiGroupData> f11153O000000o = new ArrayList();
    private PullDownDragListView O00000Oo;
    private O000000o O00000o0;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.message_center_v2);
        findViewById(R.id.module_a_3_right_iv_setting_btn).setVisibility(0);
        findViewById(R.id.module_a_3_right_iv_setting_btn).setContentDescription(getString(R.string.scene_enter_or_leave_wifi));
        findViewById(R.id.module_a_3_right_iv_setting_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.location.WifiGroupDataList.AnonymousClass1 */

            public final void onClick(View view) {
                WifiGroupDataList.this.startActivityForResult(new Intent(WifiGroupDataList.this, ScenePoiSelectWifiActivity.class), 1);
            }
        });
        this.O00000Oo = (PullDownDragListView) findViewById(R.id.share_message_list);
        this.O00000o0 = new O000000o(this, (byte) 0);
        this.O00000Oo.setAdapter((ListAdapter) this.O00000o0);
        this.O00000Oo.setRefreshListener(new CustomPullDownRefreshListView.O00000o0() {
            /* class com.xiaomi.smarthome.scene.location.WifiGroupDataList.AnonymousClass2 */

            public final void startRefresh() {
            }
        });
        this.O00000Oo.O000000o();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    public void onResume() {
        super.onResume();
    }

    class O000000o extends BaseAdapter {
        public final long getItemId(int i) {
            return 0;
        }

        private O000000o() {
        }

        /* synthetic */ O000000o(WifiGroupDataList wifiGroupDataList, byte b) {
            this();
        }

        public final int getCount() {
            return WifiGroupDataList.this.f11153O000000o.size();
        }

        public final Object getItem(int i) {
            return WifiGroupDataList.this.f11153O000000o.get(i);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public final View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(WifiGroupDataList.this).inflate((int) R.layout.message_item_new, viewGroup, false);
            }
            final WifiGroupData wifiGroupData = WifiGroupDataList.this.f11153O000000o.get(i);
            ((TextView) view.findViewById(R.id.device_item)).setText(wifiGroupData.f11159O000000o);
            view.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.scene.location.WifiGroupDataList.O000000o.AnonymousClass1 */

                public final void onClick(View view) {
                    Intent intent = new Intent(WifiGroupDataList.this, ScenePoiSelectWifiActivity.class);
                    intent.putExtra("data", wifiGroupData);
                    WifiGroupDataList.this.startActivity(intent);
                }
            });
            return view;
        }
    }
}

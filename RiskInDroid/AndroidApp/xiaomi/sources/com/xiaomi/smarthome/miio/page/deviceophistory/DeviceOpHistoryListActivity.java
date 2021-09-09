package com.xiaomi.smarthome.miio.page.deviceophistory;

import _m_j.fno;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.common.widget.PullDownDragListView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DeviceOpHistoryListActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private O000000o f9897O000000o;
    private Handler O00000Oo = new Handler() {
        /* class com.xiaomi.smarthome.miio.page.deviceophistory.DeviceOpHistoryListActivity.AnonymousClass1 */

        public final void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                DeviceOpHistoryListActivity.this.showEmptyView();
            } else if (i == 2) {
                DeviceOpHistoryListActivity.this.showContentView();
            }
        }
    };
    @BindView(6771)
    TextView commonWhiteEmptyText;
    @BindView(6772)
    TextView commonWhiteEmptyText2;
    @BindView(6773)
    LinearLayout commonWhiteEmptyView;
    @BindView(6956)
    ImageView emptyIcon;
    @BindView(7396)
    PullDownDragListView list;
    @BindView(7573)
    ImageView moduleA3ReturnBtn;
    @BindView(7574)
    ImageView moduleA3ReturnMoreMoreBtn;
    @BindView(7578)
    TextView moduleA3ReturnTitle;
    @BindView(8427)
    FrameLayout titleBar;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_device_op_history_list);
        ButterKnife.bind(this);
        this.f9897O000000o = new O000000o(this, (byte) 0);
        this.list.setAdapter((ListAdapter) this.f9897O000000o);
        ((TextView) this.commonWhiteEmptyView.findViewById(R.id.common_white_empty_text)).setText((int) R.string.no_data_tips);
        findViewById(R.id.module_a_3_return_more_more_btn).setVisibility(8);
        ((TextView) findViewById(R.id.module_a_3_return_title)).setText((int) R.string.device_op_history);
        O000000o();
    }

    private void O000000o() {
        Map<String, Device> O0000O0o = fno.O000000o().O0000O0o();
        if (O0000O0o == null || O0000O0o.isEmpty()) {
            showEmptyView();
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, Device> value : O0000O0o.entrySet()) {
            Device device = (Device) value.getValue();
            PluginDeviceInfo O00000oO = CoreApi.O000000o().O00000oO(device.model);
            if (O00000oO != null && O00000oO.O00oOooO() == 1) {
                arrayList.add(device);
            }
        }
        if (arrayList.size() == 0) {
            showEmptyView();
            return;
        }
        this.f9897O000000o.O000000o(arrayList);
        showContentView();
    }

    public void showEmptyView() {
        this.commonWhiteEmptyView.setVisibility(0);
        this.list.setVisibility(8);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, com.xiaomi.smarthome.library.common.widget.PullDownDragListView, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public void showContentView() {
        this.commonWhiteEmptyView.setVisibility(8);
        this.list.setVisibility(0);
        this.f9897O000000o.notifyDataSetChanged();
        try {
            this.list.addHeaderView(LayoutInflater.from(this).inflate((int) R.layout.common_list_space_empty, (ViewGroup) this.list, false));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isValid() {
        if (isFinishing()) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 17 || !isDestroyed()) {
            return true;
        }
        return false;
    }

    @OnClick({7573, 6773})
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.module_a_3_return_btn) {
            finish();
        } else if (id == R.id.common_white_empty_view) {
            O000000o();
        }
    }

    class O000000o extends BaseAdapter {
        private List<Device> O00000Oo;

        public final long getItemId(int i) {
            return 0;
        }

        private O000000o() {
            this.O00000Oo = new ArrayList();
        }

        /* synthetic */ O000000o(DeviceOpHistoryListActivity deviceOpHistoryListActivity, byte b) {
            this();
        }

        public final void O000000o(List<Device> list) {
            this.O00000Oo.clear();
            this.O00000Oo.addAll(list);
        }

        public final int getCount() {
            return this.O00000Oo.size();
        }

        public final Object getItem(int i) {
            if (i < 0 || i >= this.O00000Oo.size()) {
                return null;
            }
            return this.O00000Oo.get(i);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public final View getView(int i, View view, ViewGroup viewGroup) {
            C0085O000000o o000000o;
            if (view == null) {
                view = LayoutInflater.from(DeviceOpHistoryListActivity.this).inflate((int) R.layout.device_auth_master_list_item, viewGroup, false);
                o000000o = new C0085O000000o(this, (byte) 0);
                o000000o.f9901O000000o = (TextView) view.findViewById(R.id.title);
                view.setTag(o000000o);
            } else {
                o000000o = (C0085O000000o) view.getTag();
            }
            final Device device = this.O00000Oo.get(i);
            o000000o.f9901O000000o.setText(device.getName());
            view.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.miio.page.deviceophistory.DeviceOpHistoryListActivity.O000000o.AnonymousClass1 */

                public final void onClick(View view) {
                    DeviceOpHistoryActivity.openOpHistoryActivity(DeviceOpHistoryListActivity.this, device.did);
                }
            });
            if (i == getCount() - 1) {
                view.setBackgroundResource(R.drawable.mj_rs_common_white_list_padding_no_left_margin);
            } else {
                view.setBackgroundResource(R.drawable.mj_rs_common_white_list_padding);
            }
            return view;
        }

        /* renamed from: com.xiaomi.smarthome.miio.page.deviceophistory.DeviceOpHistoryListActivity$O000000o$O000000o  reason: collision with other inner class name */
        class C0085O000000o {

            /* renamed from: O000000o  reason: collision with root package name */
            TextView f9901O000000o;

            private C0085O000000o() {
            }

            /* synthetic */ C0085O000000o(O000000o o000000o, byte b) {
                this();
            }
        }
    }
}

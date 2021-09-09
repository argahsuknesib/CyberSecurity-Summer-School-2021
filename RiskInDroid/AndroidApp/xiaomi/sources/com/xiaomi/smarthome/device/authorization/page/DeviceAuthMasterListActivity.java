package com.xiaomi.smarthome.device.authorization.page;

import _m_j.fak;
import _m_j.fno;
import _m_j.ggb;
import _m_j.gsy;
import _m_j.gty;
import _m_j.ibh;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
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
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.library.common.widget.CustomPullDownRefreshListView;
import com.xiaomi.smarthome.library.common.widget.PullDownDragListView;
import com.xiaomi.youpin.login.entity.Error;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public class DeviceAuthMasterListActivity extends BaseActivity {
    public static Set<String> denyModels = new HashSet();

    /* renamed from: O000000o  reason: collision with root package name */
    private O00000Oo f7075O000000o;
    private AtomicBoolean O00000Oo = new AtomicBoolean(false);
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

    public static void addLocalDeny() {
        if (denyModels == null) {
            denyModels = new HashSet();
        }
        denyModels.add("midr.watch.ds");
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_device_auth_list);
        ButterKnife.bind(this);
        fak.O000000o();
        fak.O00000o();
        this.f7075O000000o = new O00000Oo(this, (byte) 0);
        this.list.setAdapter((ListAdapter) this.f7075O000000o);
        ((TextView) this.commonWhiteEmptyView.findViewById(R.id.common_white_empty_text)).setText((int) R.string.no_data_tips);
        findViewById(R.id.module_a_3_return_more_more_btn).setVisibility(8);
        ((TextView) findViewById(R.id.module_a_3_return_title)).setText((int) R.string.device_auth);
        this.list.setRefreshListener(new CustomPullDownRefreshListView.O00000o0() {
            /* class com.xiaomi.smarthome.device.authorization.page.DeviceAuthMasterListActivity.AnonymousClass1 */

            public final void startRefresh() {
                gsy.O00000Oo("DeviceAuthMasterListActivity", "startRefresh");
                DeviceAuthMasterListActivity.this.getData();
            }
        });
        this.list.O000000o();
        this.commonWhiteEmptyView.setVisibility(8);
    }

    static class O000000o extends ibh<Void, Error> {

        /* renamed from: O000000o  reason: collision with root package name */
        private final WeakReference<DeviceAuthMasterListActivity> f7077O000000o;

        /* synthetic */ O000000o(DeviceAuthMasterListActivity deviceAuthMasterListActivity, byte b) {
            this(deviceAuthMasterListActivity);
        }

        private O000000o(DeviceAuthMasterListActivity deviceAuthMasterListActivity) {
            this.f7077O000000o = new WeakReference<>(deviceAuthMasterListActivity);
        }

        public final void onFailure(Error error) {
            DeviceAuthMasterListActivity deviceAuthMasterListActivity = this.f7077O000000o.get();
            if (deviceAuthMasterListActivity != null && deviceAuthMasterListActivity.isValid()) {
                deviceAuthMasterListActivity.getUserVoiceDevs();
            }
        }

        public final /* synthetic */ void onSuccess(Object obj) {
            DeviceAuthMasterListActivity deviceAuthMasterListActivity = this.f7077O000000o.get();
            if (deviceAuthMasterListActivity != null && deviceAuthMasterListActivity.isValid()) {
                deviceAuthMasterListActivity.getUserVoiceDevs();
            }
        }
    }

    public void getData() {
        gty.O000000o().initThirdAccountBind(new O000000o(this, (byte) 0));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, com.xiaomi.smarthome.library.common.widget.PullDownDragListView, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public void getUserVoiceDevs() {
        if (isValid()) {
            this.list.O00000Oo();
            Map<String, Device> O0000O0o = fno.O000000o().O0000O0o();
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, Device> value : O0000O0o.entrySet()) {
                Device device = (Device) value.getValue();
                if (device != null && device.voiceCtrl > 0 && !denyModels.contains(device.model)) {
                    gsy.O00000Oo("DeviceAuthMasterListActivity", ((int) device.voiceCtrl) + " did:" + device.did + " name:" + device.name);
                    arrayList.add(device);
                }
            }
            if (arrayList.isEmpty()) {
                this.commonWhiteEmptyView.setVisibility(0);
                this.list.setVisibility(8);
                return;
            }
            if (!this.O00000Oo.getAndSet(true) && arrayList.size() > 0) {
                try {
                    this.list.addHeaderView(LayoutInflater.from(this).inflate((int) R.layout.activity_device_auth_list_header, (ViewGroup) this.list, false));
                } catch (Exception unused) {
                }
            }
            O00000Oo o00000Oo = this.f7075O000000o;
            o00000Oo.f7078O000000o.clear();
            o00000Oo.f7078O000000o.addAll(arrayList);
            this.commonWhiteEmptyView.setVisibility(8);
            this.list.setVisibility(0);
            this.f7075O000000o.notifyDataSetChanged();
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
            getData();
        }
    }

    class O00000Oo extends BaseAdapter {

        /* renamed from: O000000o  reason: collision with root package name */
        List<Device> f7078O000000o;

        public final long getItemId(int i) {
            return 0;
        }

        private O00000Oo() {
            this.f7078O000000o = new ArrayList();
        }

        /* synthetic */ O00000Oo(DeviceAuthMasterListActivity deviceAuthMasterListActivity, byte b) {
            this();
        }

        public final int getCount() {
            return this.f7078O000000o.size();
        }

        public final Object getItem(int i) {
            if (i < 0 || i >= this.f7078O000000o.size()) {
                return null;
            }
            return this.f7078O000000o.get(i);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public final View getView(int i, View view, ViewGroup viewGroup) {
            O000000o o000000o;
            if (view == null) {
                view = LayoutInflater.from(DeviceAuthMasterListActivity.this).inflate((int) R.layout.device_auth_master_list_item_v2, viewGroup, false);
                o000000o = new O000000o(this, (byte) 0);
                o000000o.f7080O000000o = (TextView) view.findViewById(R.id.title);
                o000000o.O00000Oo = (TextView) view.findViewById(R.id.subtitle);
                o000000o.O00000o0 = (SimpleDraweeView) view.findViewById(R.id.icon);
                view.setTag(o000000o);
            } else {
                o000000o = (O000000o) view.getTag();
            }
            final Device device = this.f7078O000000o.get(i);
            if (device == null) {
                return view;
            }
            if (i == getCount() - 1) {
                view.setBackgroundResource(R.drawable.mj_rs_common_white_list_padding_no_left_margin);
            } else {
                view.setBackgroundResource(R.drawable.mj_rs_common_white_list_padding);
            }
            o000000o.f7080O000000o.setText(device.getName());
            Home O0000o0 = ggb.O00000Oo().O0000o0(device.did);
            if (O0000o0 != null) {
                StringBuilder sb = new StringBuilder();
                ggb.O00000Oo();
                sb.append(ggb.O000000o(O0000o0));
                sb.append("-");
                sb.append(ggb.O00000Oo().O0000o0O(device.did));
                o000000o.O00000Oo.setText(sb.toString());
            }
            DeviceFactory.O00000Oo(device.model, o000000o.O00000o0);
            view.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.device.authorization.page.DeviceAuthMasterListActivity.O00000Oo.AnonymousClass1 */

                /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                 method: ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent}
                 arg types: [java.lang.String, int]
                 candidates:
                  ClspMth{android.content.Intent.putExtra(java.lang.String, int):android.content.Intent}
                  ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String[]):android.content.Intent}
                  ClspMth{android.content.Intent.putExtra(java.lang.String, int[]):android.content.Intent}
                  ClspMth{android.content.Intent.putExtra(java.lang.String, double):android.content.Intent}
                  ClspMth{android.content.Intent.putExtra(java.lang.String, char):android.content.Intent}
                  ClspMth{android.content.Intent.putExtra(java.lang.String, boolean[]):android.content.Intent}
                  ClspMth{android.content.Intent.putExtra(java.lang.String, byte):android.content.Intent}
                  ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Bundle):android.content.Intent}
                  ClspMth{android.content.Intent.putExtra(java.lang.String, float):android.content.Intent}
                  ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence[]):android.content.Intent}
                  ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence):android.content.Intent}
                  ClspMth{android.content.Intent.putExtra(java.lang.String, long[]):android.content.Intent}
                  ClspMth{android.content.Intent.putExtra(java.lang.String, long):android.content.Intent}
                  ClspMth{android.content.Intent.putExtra(java.lang.String, short):android.content.Intent}
                  ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable[]):android.content.Intent}
                  ClspMth{android.content.Intent.putExtra(java.lang.String, java.io.Serializable):android.content.Intent}
                  ClspMth{android.content.Intent.putExtra(java.lang.String, double[]):android.content.Intent}
                  ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable):android.content.Intent}
                  ClspMth{android.content.Intent.putExtra(java.lang.String, float[]):android.content.Intent}
                  ClspMth{android.content.Intent.putExtra(java.lang.String, byte[]):android.content.Intent}
                  ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String):android.content.Intent}
                  ClspMth{android.content.Intent.putExtra(java.lang.String, short[]):android.content.Intent}
                  ClspMth{android.content.Intent.putExtra(java.lang.String, char[]):android.content.Intent}
                  ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent} */
                public final void onClick(View view) {
                    Intent intent = new Intent(DeviceAuthMasterListActivity.this, DeviceAuthSlaveListActivity.class);
                    intent.putExtra("device_id", device.did);
                    intent.putExtra("bottom_bar", false);
                    DeviceAuthMasterListActivity.this.startActivity(intent);
                }
            });
            if (i != getCount() - 1) {
                view.setBackgroundResource(R.drawable.mj_rs_common_white_list_padding);
            } else {
                view.setBackgroundResource(R.drawable.mj_rs_common_white_list_padding_no_left_margin);
            }
            return view;
        }

        class O000000o {

            /* renamed from: O000000o  reason: collision with root package name */
            TextView f7080O000000o;
            TextView O00000Oo;
            SimpleDraweeView O00000o0;

            private O000000o() {
            }

            /* synthetic */ O000000o(O00000Oo o00000Oo, byte b) {
                this();
            }
        }
    }
}

package com.xiaomi.smarthome.device;

import _m_j.fno;
import _m_j.fqg;
import _m_j.ggb;
import _m_j.gpc;
import _m_j.gqg;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.core.server.internal.plugin.PluginDeviceManager;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ChooseGatewayDevice extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private BaseAdapter f6924O000000o = new BaseAdapter() {
        /* class com.xiaomi.smarthome.device.ChooseGatewayDevice.AnonymousClass3 */

        public final long getItemId(int i) {
            return (long) i;
        }

        public final int getCount() {
            return ChooseGatewayDevice.this.mDevices.size();
        }

        public final Object getItem(int i) {
            return ChooseGatewayDevice.this.mDevices.get(i);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public final View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(ChooseGatewayDevice.this).inflate((int) R.layout.choose_device_item, viewGroup, false);
            }
            final Device device = ChooseGatewayDevice.this.mDevices.get(i);
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.image);
            TextView textView = (TextView) view.findViewById(R.id.name);
            TextView textView2 = (TextView) view.findViewById(R.id.name_status);
            int O000000o2 = fqg.O00000Oo.f16899O000000o.O000000o(device, ChooseGatewayDevice.this.mModel);
            if (O000000o2 != 0) {
                if (O000000o2 == 1) {
                    textView2.setVisibility(0);
                    textView2.setText((int) R.string.no_zigbee_version_low);
                    view.setAlpha(0.4f);
                } else if (O000000o2 == 2) {
                    textView2.setVisibility(0);
                    textView2.setText((int) R.string.zigbee_gateway_version_too_low);
                    view.setAlpha(0.4f);
                }
            } else if (device.isOnline) {
                textView2.setVisibility(8);
                view.setAlpha(1.0f);
            } else {
                textView2.setVisibility(0);
                textView2.setText((int) R.string.list_device_offline);
                view.setAlpha(0.4f);
            }
            DeviceFactory.O00000Oo(device.model, simpleDraweeView);
            textView.setText(device.name);
            if (i == ChooseGatewayDevice.this.mDevices.size() - 1) {
                View findViewById = view.findViewById(R.id.divider);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
                layoutParams.setMargins(0, 0, 0, 0);
                findViewById.setLayoutParams(layoutParams);
            }
            view.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.device.ChooseGatewayDevice.AnonymousClass3.AnonymousClass1 */

                public final void onClick(View view) {
                    if (fqg.O00000Oo.f16899O000000o.O000000o(device, ChooseGatewayDevice.this.mModel) == 0 && device.isOnline) {
                        ChooseGatewayDevice.nextActivity(ChooseGatewayDevice.this, device, ChooseGatewayDevice.this.mPluginRecord, 11, ChooseGatewayDevice.this.getIntent().getExtras());
                    }
                }
            });
            return view;
        }
    };
    @BindView(5613)
    View mBackBt;
    public List<Device> mDevices = new ArrayList();
    @BindView(5508)
    View mListTitle;
    @BindView(5504)
    ListView mListView;
    @BindView(5514)
    LinearLayout mLlGatewayContainer;
    public String mModel;
    public PluginDeviceInfo mPluginRecord;
    @BindView(6046)
    ScrollView mSvEmptyView;
    @BindView(5617)
    TextView mTitle;

    public static void selectActivity(final Activity activity, final PluginDeviceInfo pluginDeviceInfo, final int i, final Bundle bundle) {
        AnonymousClass1 r0 = new fqg.O00000o0() {
            /* class com.xiaomi.smarthome.device.ChooseGatewayDevice.AnonymousClass1 */

            public final void O000000o() {
                fqg.O00000Oo.f16899O000000o.O00000Oo(this);
                List<Device> gatewayDevices = ChooseGatewayDevice.getGatewayDevices(pluginDeviceInfo.O00000Oo());
                if (gatewayDevices.size() == 1) {
                    Device device = gatewayDevices.get(0);
                    if (fqg.O00000Oo.f16899O000000o.O000000o(device, pluginDeviceInfo.O00000Oo()) != 0 || !device.isOnline) {
                        ChooseGatewayDevice.showActivity(activity, pluginDeviceInfo, i, bundle);
                    } else {
                        ChooseGatewayDevice.nextActivity(activity, device, pluginDeviceInfo, i, bundle);
                    }
                } else {
                    ChooseGatewayDevice.showActivity(activity, pluginDeviceInfo, i, bundle);
                }
            }
        };
        if (fqg.O00000Oo.f16899O000000o.O000000o()) {
            r0.O000000o();
        } else {
            fqg.O00000Oo.f16899O000000o.O000000o(r0);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_choose_gateway_device);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        if (intent != null) {
            this.mModel = intent.getStringExtra("model");
            this.mPluginRecord = CoreApi.O000000o().O00000oO(this.mModel);
            this.mDevices = getGatewayDevices(this.mModel);
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.mTitle.setText(getResources().getString(R.string.add));
            }
        }
        this.mBackBt.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.device.ChooseGatewayDevice.AnonymousClass2 */

            public final void onClick(View view) {
                ChooseGatewayDevice.this.onBackPressed();
            }
        });
        if (this.mDevices.size() == 0) {
            this.mListView.setVisibility(8);
            this.mListTitle.setVisibility(8);
            this.mSvEmptyView.setVisibility(0);
            PluginDeviceInfo pluginInfo = PluginDeviceManager.instance.getPluginInfo(this.mModel);
            if (pluginInfo != null) {
                this.mTitle.setText(pluginInfo.O0000Oo0());
            }
            fqg fqg = fqg.O00000Oo.f16899O000000o;
            String str = this.mModel;
            ArrayList arrayList = new ArrayList();
            for (Map.Entry next : fqg.f16896O000000o.entrySet()) {
                if (((List) next.getValue()).contains(str)) {
                    arrayList.add(next.getKey());
                }
            }
            for (int i = 0; i < arrayList.size(); i++) {
                PluginDeviceInfo pluginInfo2 = PluginDeviceManager.instance.getPluginInfo((String) arrayList.get(i));
                if (pluginInfo2 != null) {
                    TextView textView = new TextView(this);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 17;
                    layoutParams.topMargin = gpc.O000000o(10.0f);
                    textView.setLayoutParams(layoutParams);
                    textView.setTextSize(16.0f);
                    textView.setTextColor(Color.parseColor("#666666"));
                    textView.setText(pluginInfo2.O0000Oo0());
                    this.mLlGatewayContainer.addView(textView);
                }
            }
            return;
        }
        this.mListView.setAdapter((ListAdapter) this.f6924O000000o);
        this.mSvEmptyView.setVisibility(8);
    }

    public static void showActivity(Activity activity, PluginDeviceInfo pluginDeviceInfo, int i, Bundle bundle) {
        Intent intent = new Intent(activity, ChooseGatewayDevice.class);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        intent.putExtra("model", pluginDeviceInfo.O00000Oo());
        intent.putExtra("name", pluginDeviceInfo.O0000Oo0());
        activity.startActivityForResult(intent, i);
    }

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
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("finish", false);
        setResult(0, intent);
        finish();
    }

    public static List<Device> getGatewayDevices(String str) {
        PluginDeviceInfo O00000oO;
        ArrayList arrayList = new ArrayList();
        List<String> O000000o2 = ggb.O00000Oo().O000000o(ggb.O00000Oo().O0000OOo(), new boolean[0]);
        if (O000000o2 != null) {
            for (String O000000o3 : O000000o2) {
                Device O000000o4 = fno.O000000o().O000000o(O000000o3);
                if ((O000000o4 == null || (O00000oO = CoreApi.O000000o().O00000oO(O000000o4.model)) == null || (fqg.O00000Oo.f16899O000000o.f16896O000000o.get(O000000o4.model) == null && !O00000oO.O0000o(4) && !O00000oO.O0000o(8))) ? false : true) {
                    arrayList.add(O000000o4);
                }
            }
        }
        return arrayList;
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

    public static void nextActivity(Activity activity, Device device, PluginDeviceInfo pluginDeviceInfo, int i, Bundle bundle) {
        if (fqg.O00000Oo.f16899O000000o.O000000o(device, pluginDeviceInfo.O00000Oo()) == 2) {
            gqg.O00000Oo((int) R.string.gateway_firm_too_low);
            return;
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString("gateway_did", device.did);
        ResetDevicePage.showActivity(activity, pluginDeviceInfo, i, bundle);
    }
}

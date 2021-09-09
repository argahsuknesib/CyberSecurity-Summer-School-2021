package com.xiaomi.smarthome.miio.activity;

import _m_j.fbv;
import _m_j.fcg;
import _m_j.fml;
import _m_j.fno;
import _m_j.ftn;
import _m_j.ggb;
import _m_j.gpv;
import _m_j.gqb;
import _m_j.hjp;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.device.MiioDeviceV2;
import com.xiaomi.smarthome.device.bluetooth.BleGatewayManager;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.library.common.widget.CustomPullDownRefreshListView;
import com.xiaomi.smarthome.library.common.widget.PullDownDragListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class BleGatewayListActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private Runnable f9628O000000o = new Runnable() {
        /* class com.xiaomi.smarthome.miio.activity.BleGatewayListActivity.AnonymousClass2 */

        public final void run() {
            List<String> bleGatewayDids = BleGatewayListActivity.this.getBleGatewayDids();
            if (bleGatewayDids.size() == 0) {
                BleGatewayListActivity.this.mEmptyView.setVisibility(0);
                BleGatewayListActivity.this.mListView.setVisibility(8);
                BleGatewayListActivity.this.mAdapter.notifyDataSetChanged();
                BleGatewayListActivity.this.mListView.O00000Oo();
                return;
            }
            BleGatewayManager.O000000o(bleGatewayDids, BleGatewayListActivity.this.mBatchCallback);
        }
    };
    @BindView(4798)
    TextView mAboutBleGateway;
    public O000000o mAdapter;
    public BleGatewayManager.O00000Oo mBatchCallback = new BleGatewayManager.O00000Oo() {
        /* class com.xiaomi.smarthome.miio.activity.BleGatewayListActivity.AnonymousClass1 */

        public final void O000000o(List<BleGatewayManager.O000000o> list) {
            BleGatewayListActivity.this.mGateways.clear();
            BleGatewayListActivity.this.mGateways.addAll(list);
            BleGatewayListActivity.this.mHandler.post(new Runnable() {
                /* class com.xiaomi.smarthome.miio.activity.BleGatewayListActivity.AnonymousClass1.AnonymousClass1 */

                public final void run() {
                    if (!BleGatewayListActivity.this.isFinishing()) {
                        if (BleGatewayListActivity.this.mGateways.size() == 0) {
                            BleGatewayListActivity.this.mEmptyView.setVisibility(0);
                            BleGatewayListActivity.this.mListView.setVisibility(8);
                        }
                        BleGatewayListActivity.this.mAdapter.notifyDataSetChanged();
                        try {
                            BleGatewayListActivity.this.mListView.O00000Oo();
                        } catch (Exception unused) {
                        }
                    }
                }
            });
        }
    };
    @BindView(5028)
    View mEmptyView;
    @BindView(5026)
    TextView mFirstEmptyText;
    public List<BleGatewayManager.O000000o> mGateways = new ArrayList();
    public Handler mHandler;
    @BindView(4928)
    PullDownDragListView mListView;
    @BindView(5414)
    ImageView mReturnButton;
    @BindView(5027)
    TextView mSecondEmptyText;
    @BindView(5824)
    View mTitleBar;
    @BindView(5418)
    TextView mTitleText;

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gpv.O000000o(java.lang.String, boolean):boolean
     arg types: [java.lang.String, int]
     candidates:
      _m_j.gpv.O000000o(android.content.Context, java.lang.String):int
      _m_j.gpv.O000000o(java.lang.String, java.lang.String):java.lang.String
      _m_j.gpv.O000000o(android.content.SharedPreferences, java.lang.String):boolean
      _m_j.gpv.O000000o(java.lang.String, boolean):boolean */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gpv.O00000Oo(java.lang.String, boolean):void
     arg types: [java.lang.String, int]
     candidates:
      _m_j.gpv.O00000Oo(android.content.Context, java.lang.String):void
      _m_j.gpv.O00000Oo(java.lang.String, java.lang.String):void
      _m_j.gpv.O00000Oo(java.lang.String, boolean):void */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_bluetooth_gateway_list_layout);
        ButterKnife.bind(this);
        this.mHandler = new Handler();
        this.mTitleText.setText((int) R.string.miio_bluetooth_gateway);
        this.mReturnButton.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.activity.BleGatewayListActivity.AnonymousClass3 */

            public final void onClick(View view) {
                BleGatewayListActivity.this.finish();
            }
        });
        this.mEmptyView.setVisibility(8);
        if (ftn.O00000Oo(CoreApi.O000000o().O0000ooO())) {
            this.mFirstEmptyText.setSingleLine(false);
            this.mFirstEmptyText.setMaxLines(2);
            this.mFirstEmptyText.setText((int) R.string.miio_empty_ble_gateway_list_international);
        } else {
            this.mFirstEmptyText.setText((int) R.string.miio_empty_ble_gateway_list);
            this.mSecondEmptyText.setVisibility(0);
            this.mSecondEmptyText.setText(Html.fromHtml(getResources().getString(R.string.miio_find_ble_gateway_in_store)));
            this.mSecondEmptyText.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.miio.activity.BleGatewayListActivity.AnonymousClass4 */

                public final void onClick(View view) {
                    BleGatewayListActivity.this.mSecondEmptyText.setEnabled(false);
                    hjp.O000000o("https://home.mi.com/app/shop/content?id=m6da1d039f1601ca1");
                }
            });
        }
        this.mAdapter = new O000000o();
        this.mListView.setAdapter((ListAdapter) this.mAdapter);
        this.mListView.setRefreshListener(new CustomPullDownRefreshListView.O00000o0() {
            /* class com.xiaomi.smarthome.miio.activity.BleGatewayListActivity.AnonymousClass5 */

            public final void startRefresh() {
                BleGatewayListActivity.this.startLoad();
            }
        });
        this.mAboutBleGateway.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.activity.BleGatewayListActivity.AnonymousClass6 */

            public final void onClick(View view) {
                BleGatewayListActivity.this.mAboutBleGateway.setEnabled(false);
                BleGatewayListActivity.this.gotoGuideActivity();
            }
        });
        this.mListView.O000000o();
        if (!gpv.O000000o("key_ble_gateway_guide_show", false)) {
            gotoGuideActivity();
            gpv.O00000Oo("key_ble_gateway_guide_show", true);
        }
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.mListView.O000000o();
    }

    public void onDestroy() {
        super.onDestroy();
        this.mHandler.removeCallbacks(this.f9628O000000o);
    }

    public void onResume() {
        super.onResume();
        this.mSecondEmptyText.setEnabled(true);
        this.mAboutBleGateway.setEnabled(true);
    }

    public void gotoGuideActivity() {
        startActivity(new Intent(this, BleGatewayGuideActivity.class));
    }

    public List<String> getBleGatewayDids() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, Device> value : fno.O000000o().O0000O0o().entrySet()) {
            Device device = (Device) value.getValue();
            PluginDeviceInfo O00000oO = CoreApi.O000000o().O00000oO(device.model);
            if (device.isOwner() && O00000oO != null) {
                boolean z = true;
                if (O00000oO.O000O0OO() == 1) {
                    if (device instanceof MiioDeviceV2) {
                        String str = ((MiioDeviceV2) device).mFwVersion;
                        List<fcg> list = fbv.O000000o().O00000o0;
                        if (list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
                            Iterator<fcg> it = list.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                fcg next = it.next();
                                if (TextUtils.equals(next.f16080O000000o, device.model)) {
                                    if (fml.O000000o(str, next.O00000Oo) < 0) {
                                        z = false;
                                    }
                                }
                            }
                        }
                    }
                    if (z) {
                        arrayList.add(device.did);
                    }
                }
            }
        }
        return arrayList;
    }

    public void startLoad() {
        List<String> bleGatewayDids = getBleGatewayDids();
        if (bleGatewayDids.size() == 0) {
            this.mHandler.postDelayed(this.f9628O000000o, 3000);
        } else {
            BleGatewayManager.O000000o(bleGatewayDids, this.mBatchCallback);
        }
    }

    public class O000000o extends BaseAdapter {
        public final long getItemId(int i) {
            return (long) i;
        }

        public O000000o() {
        }

        public final int getCount() {
            return BleGatewayListActivity.this.mGateways.size();
        }

        public final Object getItem(int i) {
            return BleGatewayListActivity.this.mGateways.get(i);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public final View getView(final int i, View view, ViewGroup viewGroup) {
            O00000Oo o00000Oo;
            String str;
            if (view == null) {
                view = LayoutInflater.from(BleGatewayListActivity.this).inflate((int) R.layout.ble_list_gateway_item, viewGroup, false);
                o00000Oo = new O00000Oo();
                o00000Oo.f9638O000000o = (SimpleDraweeView) view.findViewById(R.id.device_icon);
                o00000Oo.O00000Oo = (TextView) view.findViewById(R.id.device_item);
                o00000Oo.O00000o0 = (TextView) view.findViewById(R.id.device_item_info);
                o00000Oo.O00000o = (ImageView) view.findViewById(R.id.arrow);
                view.setTag(o00000Oo);
            } else {
                o00000Oo = (O00000Oo) view.getTag();
            }
            BleGatewayManager.O000000o o000000o = BleGatewayListActivity.this.mGateways.get(i);
            Device O000000o2 = fno.O000000o().O000000o(o000000o.f7099O000000o);
            if (O000000o2 != null) {
                DeviceFactory.O00000Oo(O000000o2.model, o00000Oo.f9638O000000o);
                o00000Oo.O00000Oo.setText(O000000o2.name);
                if (!O000000o2.isOnline) {
                    o00000Oo.O00000o0.setText((int) R.string.miio_ble_gateway_offline);
                    o00000Oo.O00000o0.setTextColor(BleGatewayListActivity.this.getResources().getColor(R.color.mj_color_orange_normal));
                    o00000Oo.O00000o.setImageResource(R.drawable.mj_webp_widget_second_arrow_dis);
                    o00000Oo.O00000Oo.setTextColor(BleGatewayListActivity.this.getResources().getColor(R.color.mj_color_black_50_transparent));
                    view.setOnClickListener(null);
                } else {
                    String quantityString = BleGatewayListActivity.this.getResources().getQuantityString(R.plurals.home_device_size, o000000o.O00000Oo.size(), Integer.valueOf(o000000o.O00000Oo.size()));
                    String O0000o0O = ggb.O00000Oo().O0000o0O(O000000o2.did);
                    Home O0000o0 = ggb.O00000Oo().O0000o0(O000000o2.did);
                    if (O0000o0 != null) {
                        ggb.O00000Oo();
                        str = ggb.O000000o(O0000o0);
                    } else {
                        str = "";
                    }
                    o00000Oo.O00000o0.setTextColor(BleGatewayListActivity.this.getResources().getColor(R.color.mj_color_black));
                    o00000Oo.O00000o0.setText(gqb.O000000o(str, 14, "…") + " | " + gqb.O000000o(O0000o0O, 10, "…") + " | " + quantityString);
                    o00000Oo.O00000o0.setTextColor(BleGatewayListActivity.this.getResources().getColor(R.color.mj_color_gray_lighter));
                    o00000Oo.O00000o.setImageResource(R.drawable.mj_webp_widget_second_arrow_nor);
                    o00000Oo.O00000Oo.setTextColor(BleGatewayListActivity.this.getResources().getColor(R.color.mj_color_black));
                    view.setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.miio.activity.BleGatewayListActivity.O000000o.AnonymousClass1 */

                        public final void onClick(View view) {
                            if (i < BleGatewayListActivity.this.mGateways.size()) {
                                Intent intent = new Intent(BleGatewayListActivity.this, BleGatewayActivity.class);
                                Bundle bundle = new Bundle();
                                bundle.putString("key_gateway_did", BleGatewayListActivity.this.mGateways.get(i).f7099O000000o);
                                bundle.putParcelableArrayList("key_gateway_items", BleGatewayListActivity.this.mGateways.get(i).O00000Oo);
                                intent.putExtras(bundle);
                                BleGatewayListActivity.this.startActivity(intent);
                            }
                        }
                    });
                }
            }
            return view;
        }
    }

    public class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        SimpleDraweeView f9638O000000o;
        TextView O00000Oo;
        ImageView O00000o;
        TextView O00000o0;

        public O00000Oo() {
        }
    }
}

package com.xiaomi.smarthome.miio.activity;

import _m_j.fnn;
import _m_j.fno;
import _m_j.fsm;
import _m_j.fso;
import _m_j.ggb;
import _m_j.ggw;
import _m_j.gpc;
import _m_j.gqg;
import _m_j.gsy;
import _m_j.gwv;
import _m_j.gwx;
import _m_j.hjp;
import _m_j.hxi;
import _m_j.hxk;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.ArcShape;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.utils.DeviceTagInterface;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.library.common.widget.DevicePtrFrameLayout;
import com.xiaomi.smarthome.miio.activity.ConsumablesActivity;
import com.xiaomi.smarthome.miio.consumables.Consumable;
import com.xiaomi.smarthome.miio.consumables.DeviceConsumble;
import com.xiaomi.smarthome.newui.HomeListDialogHelper;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ConsumablesActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    List<DeviceConsumble> f9647O000000o = new ArrayList();
    LinearLayoutManager O00000Oo = null;
    private XQProgressDialog O00000o0;
    public boolean isChangingHome = false;
    public boolean isOwnerHome;
    public boolean isRefreshing = false;
    @BindView(5111)
    RecyclerView list;
    public fno.O000000o listener = new fno.O000000o() {
        /* class com.xiaomi.smarthome.miio.activity.ConsumablesActivity.AnonymousClass1 */

        public final void onRefreshClientDeviceChanged(int i, Device device) {
        }

        public final void onRefreshClientDeviceSuccess(int i) {
            fno.O000000o().O00000Oo(ConsumablesActivity.this.listener);
            if (ConsumablesActivity.this.f9647O000000o != null && ConsumablesActivity.this.f9647O000000o.size() > 0) {
                ConsumablesActivity.this.updateUIData();
            }
        }
    };
    public Dialog loadingDialog;
    public O00000Oo mAdapter;
    @BindView(5101)
    TextView mEmptyTV;
    @BindView(5103)
    View mEmptyView;
    @BindView(6010)
    View mGroupTitle;
    public String mHomeId;
    @BindView(5486)
    View mMaskView;
    @BindView(5315)
    View mMenuIcom;
    @BindView(5705)
    DevicePtrFrameLayout mPullRefreshLL;
    @BindView(5539)
    TextView mTitle;
    @BindView(5994)
    View mTitleBar;
    @BindView(5535)
    View mback;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_consumables_list);
        ButterKnife.bind(this);
        if (ServiceApplication.getStateNotifier().f15923O000000o != 4) {
            finish();
            gqg.O000000o((int) R.string.login_des_tips);
            return;
        }
        this.mHomeId = ggb.O00000Oo().O0000OOo();
        refreshView(this.mHomeId);
    }

    public void refreshView(final String str) {
        Home O00000o = ggb.O00000Oo().O00000o(str);
        if (O00000o == null) {
            dismissProgressDialog();
            this.isChangingHome = false;
            return;
        }
        this.isOwnerHome = O00000o.isOwner();
        TextView textView = this.mTitle;
        ggb.O00000Oo();
        textView.setText(ggb.O000000o(O00000o));
        this.mEmptyTV.setText((int) R.string.no_data_tips);
        this.mback.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.activity.$$Lambda$ConsumablesActivity$bXLFuVRh_B6QaNugIZgcDAwQmM */

            public final void onClick(View view) {
                ConsumablesActivity.this.O00000o0(view);
            }
        });
        this.mEmptyView.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.activity.$$Lambda$ConsumablesActivity$6Wd9I0MgAw6raQEQroJxl2ydpU */

            public final void onClick(View view) {
                ConsumablesActivity.this.O00000Oo(view);
            }
        });
        this.O00000Oo = new LinearLayoutManager(this);
        this.mAdapter = new O00000Oo();
        this.list.setLayoutManager(this.O00000Oo);
        this.list.setAdapter(this.mAdapter);
        this.mPullRefreshLL.setPtrHandler(new PtrDefaultHandler() {
            /* class com.xiaomi.smarthome.miio.activity.ConsumablesActivity.AnonymousClass2 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.gwv.O000000o(android.content.Context, java.lang.String, boolean, _m_j.gwx):void
             arg types: [com.xiaomi.smarthome.miio.activity.ConsumablesActivity, java.lang.String, int, com.xiaomi.smarthome.miio.activity.ConsumablesActivity$2$1]
             candidates:
              _m_j.gwv.O000000o(android.content.Context, java.lang.String, java.lang.String, _m_j.fsm<org.json.JSONObject, _m_j.fso>):void
              _m_j.gwv.O000000o(android.content.Context, java.lang.String, boolean, _m_j.fsm<org.json.JSONObject, _m_j.fso>):void
              _m_j.gwv.O000000o(android.content.Context, java.lang.String, boolean, _m_j.gwx):void */
            public final void onRefreshBegin(PtrFrameLayout ptrFrameLayout) {
                if (ServiceApplication.getStateNotifier().f15923O000000o != 4) {
                    ConsumablesActivity.this.dismissProgressDialog();
                    ConsumablesActivity.this.showEmpty();
                    ConsumablesActivity.this.isChangingHome = false;
                } else if (ConsumablesActivity.this.isRefreshing) {
                    gsy.O00000Oo("ConsumableData", "isRefreshing==true");
                } else {
                    ConsumablesActivity.this.isRefreshing = true;
                    if (!fno.O000000o().O0000o00() || fno.O000000o().O0000o0()) {
                        fno.O000000o().O000000o(ConsumablesActivity.this.listener);
                        fno.O000000o().O0000Oo0();
                    }
                    ConsumablesActivity.this.f9647O000000o.clear();
                    ConsumablesActivity.this.mAdapter.O000000o(ConsumablesActivity.this.f9647O000000o);
                    gwv.O00000Oo().O000000o((Context) ConsumablesActivity.this, str, false, (gwx) new gwx() {
                        /* class com.xiaomi.smarthome.miio.activity.ConsumablesActivity.AnonymousClass2.AnonymousClass1 */

                        public final void O000000o(int i, String str, List<DeviceConsumble> list) {
                            Object obj;
                            ConsumablesActivity.this.isRefreshing = false;
                            if (i == 1) {
                                ConsumablesActivity.this.isChangingHome = false;
                            }
                            if (ConsumablesActivity.this.isValid()) {
                                ConsumablesActivity.this.dismissProgressDialog();
                                ConsumablesActivity.this.f9647O000000o.clear();
                                List<DeviceConsumble> list2 = ConsumablesActivity.this.f9647O000000o;
                                gwv O00000Oo = gwv.O00000Oo();
                                String str2 = ConsumablesActivity.this.mHomeId;
                                if (TextUtils.isEmpty(str2)) {
                                    obj = new ArrayList();
                                } else if (O00000Oo.O00000o0.containsKey(str2)) {
                                    obj = O00000Oo.O00000o0.get(str2);
                                } else {
                                    obj = new ArrayList();
                                }
                                list2.addAll(obj);
                                ConsumablesActivity.this.updateUIData();
                            }
                        }

                        public final void O000000o(String str, String str2) {
                            ConsumablesActivity.this.isRefreshing = false;
                            ConsumablesActivity.this.isChangingHome = false;
                            if (ConsumablesActivity.this.isValid()) {
                                ConsumablesActivity.this.dismissProgressDialog();
                                if (TextUtils.equals(ConsumablesActivity.this.mHomeId, str2)) {
                                    gsy.O000000o(6, "Consumables", str);
                                    gqg.O000000o((int) R.string.retrieve_data_fail);
                                }
                            }
                        }

                        public final void O000000o() {
                            ConsumablesActivity.this.isRefreshing = false;
                            ConsumablesActivity.this.isChangingHome = false;
                            if (ConsumablesActivity.this.isValid()) {
                                ConsumablesActivity.this.dismissProgressDialog();
                                if (ConsumablesActivity.this.mPullRefreshLL.isRefreshing()) {
                                    ConsumablesActivity.this.mPullRefreshLL.refreshComplete();
                                }
                            }
                        }
                    });
                }
            }
        });
        this.mPullRefreshLL.autoRefresh();
        this.mGroupTitle.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.activity.$$Lambda$ConsumablesActivity$8Yt15ZuiVRplONqpZnXaJZw9Py0 */

            public final void onClick(View view) {
                ConsumablesActivity.this.O000000o(view);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000o0(View view) {
        finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo(View view) {
        if (!this.mPullRefreshLL.isRefreshing()) {
            this.mPullRefreshLL.autoRefresh();
        }
    }

    public void onBackPressed() {
        finish();
    }

    public void doDropDownAnimation(boolean z) {
        View view;
        if (isValid() && (view = this.mMenuIcom) != null && this.mMaskView != null) {
            view.animate().rotation(z ? -180.0f : 0.0f).setDuration(200).setInterpolator(new AccelerateDecelerateInterpolator());
            this.mMaskView.setVisibility(z ? 0 : 8);
            this.mMaskView.setAnimation(AnimationUtils.loadAnimation(ServiceApplication.getAppContext(), z ? R.anim.dd_mask_in : R.anim.dd_mask_out));
        }
    }

    public void showProgressDialog() {
        if (isValid()) {
            dismissProgressDialog();
            this.O00000o0 = XQProgressDialog.O000000o(this, "", getString(R.string.mj_loading));
        }
    }

    public void dismissProgressDialog() {
        XQProgressDialog xQProgressDialog;
        if (isValid() && (xQProgressDialog = this.O00000o0) != null && xQProgressDialog.isShowing()) {
            this.O00000o0.dismiss();
        }
    }

    public void updateUIData() {
        ArrayList arrayList = new ArrayList();
        for (int size = this.f9647O000000o.size() - 1; size >= 0; size--) {
            Device O000000o2 = fno.O000000o().O000000o(this.f9647O000000o.get(size).did);
            if (O000000o2 == null || TextUtils.isEmpty(O000000o2.name)) {
                this.f9647O000000o.remove(size);
            } else {
                this.f9647O000000o.get(size).isOnline = O000000o2.isOnline;
                if (!this.f9647O000000o.get(size).isOnline) {
                    DeviceConsumble deviceConsumble = this.f9647O000000o.get(size);
                    deviceConsumble.isOnline = false;
                    deviceConsumble.isBleGateway = this.f9647O000000o.get(size).isBleGateway;
                    deviceConsumble.did = this.f9647O000000o.get(size).did;
                    deviceConsumble.isSkipRpc = this.f9647O000000o.get(size).isSkipRpc;
                    deviceConsumble.childSize = 0;
                    if (deviceConsumble.consumables != null) {
                        deviceConsumble.consumables.clear();
                    }
                    arrayList.add(0, deviceConsumble);
                    this.f9647O000000o.remove(size);
                }
            }
        }
        if (arrayList.size() > 0) {
            this.f9647O000000o.addAll(arrayList);
        }
        O000000o();
        this.mAdapter.O000000o(this.f9647O000000o);
        showEmpty();
    }

    private void O000000o() {
        String str;
        String str2;
        int i;
        int i2;
        int i3;
        try {
            JSONArray jSONArray = new JSONArray();
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            int i8 = 0;
            int i9 = 0;
            int i10 = 0;
            for (int i11 = 0; i11 < this.f9647O000000o.size(); i11++) {
                Device O000000o2 = fno.O000000o().O000000o(this.f9647O000000o.get(i11).did);
                if (O000000o2 != null) {
                    int i12 = i4 + 1;
                    if (O000000o2.isOnline) {
                        i5++;
                        str2 = "online";
                    } else {
                        PluginDeviceInfo O00000oO = CoreApi.O000000o().O00000oO(O000000o2.model);
                        if (O00000oO == null || O00000oO.O0000o() != Device.PID_BLUETOOTH) {
                            i6++;
                            str2 = "offline";
                        } else {
                            i7++;
                            str2 = "ble_offline";
                        }
                    }
                    JSONObject jSONObject = new JSONObject();
                    String str3 = i11 + "," + O000000o2.model;
                    jSONObject.put("on_line_status", str2);
                    if (this.f9647O000000o.get(i11).consumables != null) {
                        StringBuilder sb = new StringBuilder();
                        int i13 = i9;
                        int i14 = 0;
                        while (i14 < this.f9647O000000o.get(i11).consumables.size()) {
                            StringBuilder sb2 = new StringBuilder();
                            int i15 = i12;
                            String str4 = "剩余：";
                            if (TextUtils.isEmpty(this.f9647O000000o.get(i11).consumables.get(i14).description)) {
                                i3 = i5;
                            } else {
                                StringBuilder sb3 = new StringBuilder();
                                i3 = i5;
                                sb3.append(this.f9647O000000o.get(i11).consumables.get(i14).description);
                                sb3.append(str4);
                                str4 = sb3.toString();
                            }
                            sb2.append(str4);
                            sb2.append(this.f9647O000000o.get(i11).consumables.get(i14).percentage);
                            sb2.append("%");
                            sb.append(sb2.toString());
                            sb.append("url:");
                            if (TextUtils.isEmpty(this.f9647O000000o.get(i11).consumables.get(i14).buyUrl)) {
                                i10++;
                                sb.append("null;");
                            } else {
                                sb.append(this.f9647O000000o.get(i11).consumables.get(i14).buyUrl);
                                sb.append(";");
                                i13++;
                            }
                            i14++;
                            i12 = i15;
                            i5 = i3;
                        }
                        i2 = i12;
                        i = i5;
                        jSONObject.put(str3, sb.toString());
                        i9 = i13;
                    } else {
                        i2 = i12;
                        i = i5;
                        jSONObject.put(str3, "null");
                    }
                    i8 += this.f9647O000000o.get(i11).childSize;
                    jSONArray.put(jSONObject);
                    i4 = i2;
                    i5 = i;
                }
            }
            JSONObject jSONObject2 = new JSONObject();
            Home O00000o = ggb.O00000Oo().O00000o(this.mHomeId);
            if (O00000o == null) {
                str = "";
            } else {
                ggb.O00000Oo();
                str = ggb.O000000o(O00000o);
            }
            jSONObject2.put("homename", str);
            jSONObject2.put("device_total_number", i4);
            jSONObject2.put("online_device_total_number", i5);
            jSONObject2.put("offline_device_total_number", i6);
            jSONObject2.put("notconnect_device_total_number", i7);
            jSONObject2.put("consume_total_number", i8);
            jSONObject2.put("address_consume_total_number", i9);
            jSONObject2.put("noaddress_consume_total_number", i10);
            jSONObject2.put("list_detail", jSONArray);
            hxi.O00000oO.f958O000000o.O000000o("mine_consume_show", jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void showEmpty() {
        if (this.mAdapter.O000000o() == 0) {
            this.mEmptyView.setVisibility(0);
            this.list.setVisibility(8);
            return;
        }
        this.list.setVisibility(0);
        this.mEmptyView.setVisibility(8);
    }

    class O00000Oo extends RecyclerView.O000000o<RecyclerView.O000OOo0> {

        /* renamed from: O000000o  reason: collision with root package name */
        ShapeDrawable f9655O000000o;
        Drawable[] O00000Oo = new Drawable[3];
        private List<DeviceConsumble> O00000o = new ArrayList();

        public final long getItemId(int i) {
            return (long) i;
        }

        O00000Oo() {
            setHasStableIds(true);
            this.f9655O000000o = new ShapeDrawable(new OvalShape());
            this.f9655O000000o.getPaint().setColor(ConsumablesActivity.this.getResources().getColor(R.color.mj_color_white));
            this.f9655O000000o.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
            this.O00000Oo[2] = this.f9655O000000o;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public final RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
            if (i == 0) {
                return new O00000o0(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.item_consumable_first, viewGroup, false));
            }
            if (i == 5) {
                return new O00000o0(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.item_consumable_first_2, viewGroup, false));
            }
            if (i == 4) {
                return new O00000o0(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.item_consumable_group_last_0, viewGroup, false));
            }
            if (i == 1) {
                return new O000000o(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.item_consumable_second, viewGroup, false));
            }
            if (i == 2) {
                return new O000000o(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.item_consumable_last, viewGroup, false));
            }
            return new O000000o(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.item_consumable_group_last, viewGroup, false));
        }

        public final void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
            String str;
            String str2;
            TextView textView;
            DeviceConsumble deviceConsumble = null;
            o000OOo0.itemView.setOnClickListener(null);
            String str3 = "";
            int i2 = 0;
            if (o000OOo0 instanceof O00000o0) {
                if (this.O00000o != null) {
                    int i3 = 0;
                    while (true) {
                        if (i2 >= this.O00000o.size()) {
                            break;
                        } else if (i == i3) {
                            deviceConsumble = this.O00000o.get(i2);
                            break;
                        } else {
                            i3 += this.O00000o.get(i2).childSize + 1;
                            i2++;
                        }
                    }
                }
                if (deviceConsumble != null) {
                    Device O000000o2 = fno.O000000o().O000000o(deviceConsumble.did);
                    if (deviceConsumble.isOnline) {
                        str = str3;
                    } else if (deviceConsumble.isBleGateway) {
                        str = "(" + ConsumablesActivity.this.getString(R.string.cant_connect_ble) + ")";
                    } else {
                        str = "(" + ConsumablesActivity.this.getString(R.string.offline_device) + ")";
                    }
                    O00000o0 o00000o0 = (O00000o0) o000OOo0;
                    TextView textView2 = o00000o0.f9657O000000o;
                    if (O000000o2 != null && !TextUtils.isEmpty(O000000o2.name)) {
                        str = O000000o2.name + str;
                    }
                    textView2.setText(str);
                    if (!deviceConsumble.isOnline) {
                        o00000o0.f9657O000000o.setTextColor(ConsumablesActivity.this.getResources().getColor(R.color.mj_color_gray_lighter));
                    } else {
                        o00000o0.f9657O000000o.setTextColor(ConsumablesActivity.this.getResources().getColor(R.color.mj_color_gray_heavier));
                    }
                    if (ggb.O00000Oo().O0000o0(deviceConsumble.did) != null) {
                        ggb.O00000Oo();
                        str2 = ggb.O000000o(ggb.O00000Oo().O0000o0(deviceConsumble.did));
                    } else {
                        str2 = str3;
                    }
                    String name = ggb.O00000Oo().O0000o00(deviceConsumble.did) != null ? ggb.O00000Oo().O0000o00(deviceConsumble.did).getName() : str3;
                    if (TextUtils.isEmpty(name)) {
                        name = ConsumablesActivity.this.getString(R.string.default_room);
                    }
                    if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(name)) {
                        textView = o00000o0.O00000Oo;
                        str3 = str2 + " | " + name;
                    } else if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(name)) {
                        textView = o00000o0.O00000Oo;
                        str3 = TextUtils.isEmpty(str2) ? name : str2;
                    } else {
                        textView = o00000o0.O00000Oo;
                    }
                    textView.setText(str3);
                    return;
                }
                O00000o0 o00000o02 = (O00000o0) o000OOo0;
                o00000o02.f9657O000000o.setText(str3);
                o00000o02.O00000Oo.setText(str3);
                return;
            }
            Consumable O000000o3 = O000000o(i);
            if (O000000o3 != null) {
                if (O000000o3.reset) {
                    O000000o o000000o = (O000000o) o000OOo0;
                    o000000o.f9654O000000o.setVisibility(8);
                    o000000o.O00000o.setVisibility(0);
                    O000000o(o000000o.O00000o, (int) O000000o3.percentage, O000000o3.state);
                } else {
                    O000000o o000000o2 = (O000000o) o000OOo0;
                    o000000o2.f9654O000000o.setVisibility(0);
                    o000000o2.O00000o.setVisibility(8);
                    O000000o(o000000o2.f9654O000000o, (int) O000000o3.percentage, O000000o3.state);
                }
                if (!TextUtils.isEmpty(O000000o3.remark)) {
                    O000000o o000000o3 = (O000000o) o000OOo0;
                    o000000o3.O00000o0.setVisibility(0);
                    o000000o3.O00000o0.setText(O000000o3.remark);
                } else if (O000000o3.days >= 0) {
                    O000000o o000000o4 = (O000000o) o000OOo0;
                    o000000o4.O00000o0.setVisibility(0);
                    o000000o4.O00000o0.setText(ConsumablesActivity.this.getResources().getQuantityString(R.plurals.consumables_remain_days, O000000o3.days, Integer.valueOf(O000000o3.days)));
                } else if (O000000o3.percentage == 0.0d) {
                    O000000o o000000o5 = (O000000o) o000OOo0;
                    o000000o5.O00000o0.setVisibility(0);
                    o000000o5.O00000o0.setText((int) R.string.run_out);
                } else {
                    ((O000000o) o000OOo0).O00000o0.setVisibility(8);
                }
                O000000o o000000o6 = (O000000o) o000OOo0;
                o000000o6.O00000Oo.setText(O000000o3.description);
                if (O000000o3.reset) {
                    o000000o6.O00000oO.setVisibility(4);
                    o000OOo0.itemView.setClickable(false);
                    o000000o6.O00000oo.setVisibility(0);
                } else if (!TextUtils.isEmpty(O000000o3.buyUrl)) {
                    o000000o6.O00000oO.setVisibility(0);
                    o000OOo0.itemView.setClickable(true);
                    o000000o6.O00000oo.setVisibility(8);
                } else {
                    o000000o6.O00000oO.setVisibility(4);
                    o000OOo0.itemView.setClickable(false);
                    o000000o6.O00000oo.setVisibility(8);
                }
                if (!ConsumablesActivity.this.isOwnerHome) {
                    o000000o6.O00000oo.setVisibility(8);
                }
                o000OOo0.itemView.setOnClickListener(new View.OnClickListener(i, O000000o3) {
                    /* class com.xiaomi.smarthome.miio.activity.$$Lambda$ConsumablesActivity$O00000Oo$pl6Zdm1JvFm90a4qKkwQaWkmTTg */
                    private final /* synthetic */ int f$1;
                    private final /* synthetic */ Consumable f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void onClick(View view) {
                        ConsumablesActivity.O00000Oo.this.O000000o(this.f$1, this.f$2, view);
                    }
                });
                o000000o6.O00000oo.setOnClickListener(new View.OnClickListener(O000000o3, i) {
                    /* class com.xiaomi.smarthome.miio.activity.$$Lambda$ConsumablesActivity$O00000Oo$naxwbFX8kXZwU8rwcxckWfN8wQ */
                    private final /* synthetic */ Consumable f$1;
                    private final /* synthetic */ int f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void onClick(View view) {
                        ConsumablesActivity.O00000Oo.this.O000000o(this.f$1, this.f$2, view);
                    }
                });
                return;
            }
            O000000o o000000o7 = (O000000o) o000OOo0;
            O000000o(o000000o7.f9654O000000o, 0, str3);
            o000000o7.O00000Oo.setText(str3);
            o000000o7.f9654O000000o.setVisibility(8);
            o000000o7.O00000o.setVisibility(8);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O000000o(int i, Consumable consumable, View view) {
            String str;
            String str2;
            DeviceTagInterface.Category O00000o02;
            Consumable consumable2 = consumable;
            Device O000000o2 = fno.O000000o().O000000o(O00000Oo(i));
            String str3 = (O000000o2 == null || (O00000o02 = fnn.O000000o().O00000Oo().O00000o0(O000000o2.model)) == null) ? null : O00000o02.name;
            hxk hxk = hxi.O00000o;
            String str4 = "";
            if (TextUtils.isEmpty(str3)) {
                str3 = str4;
            }
            hxk.f952O000000o.O000000o("consumables_model", "type", str3, "title", TextUtils.isEmpty(consumable2.description) ? str4 : consumable2.description);
            hxk hxk2 = hxi.O00000o;
            String str5 = O000000o2.model;
            StringBuilder sb = new StringBuilder();
            String str6 = "剩余：";
            if (TextUtils.isEmpty(consumable2.description)) {
                str = str6;
            } else {
                str = consumable2.description + str6;
            }
            sb.append(str);
            sb.append(consumable2.percentage);
            sb.append("%");
            hxk2.f952O000000o.O000000o("mine_consum_click", "model", str5, "title", sb.toString(), "url", TextUtils.isEmpty(consumable2.buyUrl) ? str4 : consumable2.buyUrl);
            if (!TextUtils.isEmpty(consumable2.buyUrl)) {
                hjp.O000000o(consumable2.buyUrl);
            }
            Home O00000o2 = ggb.O00000Oo().O00000o(ConsumablesActivity.this.mHomeId);
            hxk hxk3 = hxi.O00000o;
            if (O00000o2 == null) {
                str2 = str4;
            } else {
                ggb.O00000Oo();
                str2 = ggb.O000000o(O00000o2);
            }
            int size = ConsumablesActivity.this.f9647O000000o.size();
            String str7 = consumable2.model;
            int i2 = consumable2.parentPos;
            StringBuilder sb2 = new StringBuilder();
            if (!TextUtils.isEmpty(consumable2.description)) {
                str6 = consumable2.description + str6;
            }
            sb2.append(str6);
            sb2.append(consumable2.percentage);
            sb2.append("%");
            String sb3 = sb2.toString();
            if (!TextUtils.isEmpty(consumable2.buyUrl)) {
                str4 = consumable2.buyUrl;
            }
            hxk3.f952O000000o.O000000o("mine_consume_address_click", "homename", str2, "device_total_number", Integer.valueOf(size), "model", str7, "order", Integer.valueOf(i2), "consume_status", sb3, "url", str4);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O000000o(final Consumable consumable, int i, View view) {
            if (ConsumablesActivity.this.isOwnerHome && consumable.reset && !TextUtils.isEmpty(consumable.prop)) {
                if (ConsumablesActivity.this.loadingDialog == null) {
                    ConsumablesActivity consumablesActivity = ConsumablesActivity.this;
                    consumablesActivity.loadingDialog = XQProgressDialog.O000000o(consumablesActivity, "", consumablesActivity.getString(R.string.unauthing));
                }
                if (ConsumablesActivity.this.loadingDialog != null && !ConsumablesActivity.this.loadingDialog.isShowing()) {
                    ConsumablesActivity.this.loadingDialog.show();
                }
                final String O00000Oo2 = O00000Oo(i);
                gwv.O00000Oo();
                gwv.O000000o(ConsumablesActivity.this, O00000Oo2, consumable.prop, new fsm<JSONObject, fso>() {
                    /* class com.xiaomi.smarthome.miio.activity.ConsumablesActivity.O00000Oo.AnonymousClass1 */

                    public final void onFailure(fso fso) {
                        if (ConsumablesActivity.this.isValid()) {
                            if (ConsumablesActivity.this.loadingDialog != null && ConsumablesActivity.this.loadingDialog.isShowing()) {
                                ConsumablesActivity.this.loadingDialog.dismiss();
                            }
                            gqg.O000000o((int) R.string.ble_mesh_toast_failed);
                        }
                    }

                    public final /* synthetic */ void onSuccess(Object obj) {
                        if (ConsumablesActivity.this.isValid()) {
                            ConsumablesActivity.this.refreshBatteryItem(O00000Oo2, consumable.prop);
                        }
                    }
                });
            }
        }

        public final int getItemCount() {
            return O000000o();
        }

        private int O000000o(View view, int i, String str) {
            int i2;
            int i3;
            float f = (i < 0 || i > 100) ? 0.0f : ((float) i) * 3.6f;
            int O000000o2 = gpc.O000000o(3.0f);
            if (i <= 0) {
                i2 = ConsumablesActivity.this.getResources().getColor(R.color.mj_color_red_normal);
            } else {
                i2 = ConsumablesActivity.this.getResources().getColor(R.color.mj_color_green_normal);
            }
            if ((i < 0 || i > 100) && "ok".equalsIgnoreCase(str)) {
                i3 = ConsumablesActivity.this.getResources().getColor(R.color.mj_color_green_normal);
                f = 360.0f;
            } else {
                i3 = i2;
            }
            ShapeDrawable shapeDrawable = new ShapeDrawable(new ArcShape(-90.0f, f));
            shapeDrawable.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
            if (f == 0.0f) {
                shapeDrawable.getPaint().setColor(0);
            } else {
                shapeDrawable.getPaint().setColor(i3);
            }
            this.O00000Oo[0] = shapeDrawable;
            ShapeDrawable shapeDrawable2 = new ShapeDrawable(new ArcShape(f - 90.0f, 360.0f - f));
            if (f == 360.0f) {
                shapeDrawable2.getPaint().setColor(ConsumablesActivity.this.getResources().getColor(R.color.mj_color_white_00_transparent));
            } else {
                shapeDrawable2.getPaint().setColor(ConsumablesActivity.this.getResources().getColor(R.color.mj_color_background));
            }
            shapeDrawable2.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
            Drawable[] drawableArr = this.O00000Oo;
            drawableArr[1] = shapeDrawable2;
            LayerDrawable layerDrawable = new LayerDrawable(drawableArr);
            layerDrawable.setLayerInset(2, O000000o2, O000000o2, O000000o2, O000000o2);
            view.setBackground(layerDrawable);
            if (view instanceof TextView) {
                if (i >= 0 && i <= 100) {
                    TextView textView = (TextView) view;
                    textView.setText(i + "%");
                    textView.getPaint().setFakeBoldText(false);
                } else if (!TextUtils.isEmpty(str)) {
                    TextView textView2 = (TextView) view;
                    textView2.setText(str);
                    textView2.getPaint().setFakeBoldText(true);
                } else {
                    ((TextView) view).setText("");
                }
                ((TextView) view).setTextColor(i3);
            }
            return i3;
        }

        public final int O000000o() {
            if (this.O00000o == null) {
                return 0;
            }
            int i = 0;
            for (int i2 = 0; i2 < this.O00000o.size(); i2++) {
                i += this.O00000o.get(i2).childSize + 1;
            }
            return i;
        }

        private Consumable O000000o(int i) {
            if (this.O00000o == null) {
                return null;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.O00000o.size(); i3++) {
                int i4 = i2 + 1;
                int i5 = i - i4;
                if (i5 < this.O00000o.get(i3).childSize) {
                    return this.O00000o.get(i3).consumables.get(i5);
                }
                i2 = i4 + this.O00000o.get(i3).childSize;
            }
            return null;
        }

        private String O00000Oo(int i) {
            if (this.O00000o == null) {
                return null;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.O00000o.size(); i3++) {
                int i4 = i2 + 1;
                if (i - i4 < this.O00000o.get(i3).childSize) {
                    return this.O00000o.get(i3).did;
                }
                i2 = i4 + this.O00000o.get(i3).childSize;
            }
            return null;
        }

        public final void O000000o(List<DeviceConsumble> list) {
            this.O00000o.clear();
            if (!list.isEmpty()) {
                this.O00000o.addAll(list);
            }
            ConsumablesActivity.this.list.stopScroll();
            ConsumablesActivity.this.list.getRecycledViewPool().O000000o();
            ConsumablesActivity.this.mAdapter.notifyDataSetChanged();
        }

        public final int getItemViewType(int i) {
            if (this.O00000o != null) {
                if (i == getItemCount() - 1) {
                    List<DeviceConsumble> list = this.O00000o;
                    return list.get(list.size() - 1).consumables.size() > 0 ? 3 : 4;
                }
                int i2 = 0;
                int i3 = 0;
                while (i2 < this.O00000o.size()) {
                    if (i != i3) {
                        i3 = i3 + 1 + this.O00000o.get(i2).childSize;
                        if (i == getItemCount() - 1) {
                            List<DeviceConsumble> list2 = this.O00000o;
                            return list2.get(list2.size() - 1).consumables.size() > 0 ? 3 : 4;
                        } else if (i == i3 - 1) {
                            return 2;
                        } else {
                            if (i < i3) {
                                return 1;
                            }
                            i2++;
                        }
                    } else if (this.O00000o.get(i2).childSize == 0) {
                        return 5;
                    } else {
                        return 0;
                    }
                }
            }
            return 0;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gwv.O000000o(android.content.Context, java.lang.String, boolean, _m_j.gwx):void
     arg types: [com.xiaomi.smarthome.miio.activity.ConsumablesActivity, java.lang.String, int, com.xiaomi.smarthome.miio.activity.ConsumablesActivity$4]
     candidates:
      _m_j.gwv.O000000o(android.content.Context, java.lang.String, java.lang.String, _m_j.fsm<org.json.JSONObject, _m_j.fso>):void
      _m_j.gwv.O000000o(android.content.Context, java.lang.String, boolean, _m_j.fsm<org.json.JSONObject, _m_j.fso>):void
      _m_j.gwv.O000000o(android.content.Context, java.lang.String, boolean, _m_j.gwx):void */
    public void refreshBatteryItem(final String str, final String str2) {
        Dialog dialog = this.loadingDialog;
        if (dialog != null && dialog.isShowing()) {
            this.loadingDialog.dismiss();
        }
        gwv.O00000Oo().O000000o((Context) this, this.mHomeId, true, (gwx) new gwx() {
            /* class com.xiaomi.smarthome.miio.activity.ConsumablesActivity.AnonymousClass4 */

            public final void O000000o(int i, String str, List<DeviceConsumble> list) {
                List<Consumable> list2;
                List<Consumable> list3;
                if (ConsumablesActivity.this.isValid() && TextUtils.equals(ConsumablesActivity.this.mHomeId, str) && i == 1) {
                    DeviceConsumble deviceConsumble = null;
                    for (int i2 = 0; i2 < list.size(); i2++) {
                        if (TextUtils.equals(list.get(i2).did, str) && (list3 = list.get(i2).consumables) != null && list3.size() > 0) {
                            int i3 = 0;
                            while (true) {
                                if (i3 >= list3.size()) {
                                    break;
                                } else if (TextUtils.equals(list3.get(i3).prop, str2)) {
                                    deviceConsumble = list.get(i2);
                                    break;
                                } else {
                                    i3++;
                                }
                            }
                        }
                    }
                    if (deviceConsumble == null) {
                        gqg.O000000o((int) R.string.retrieve_data_fail);
                        return;
                    }
                    for (int i4 = 0; i4 < ConsumablesActivity.this.f9647O000000o.size(); i4++) {
                        if (TextUtils.equals(ConsumablesActivity.this.f9647O000000o.get(i4).did, str) && (list2 = ConsumablesActivity.this.f9647O000000o.get(i4).consumables) != null && list2.size() > 0) {
                            int i5 = 0;
                            while (true) {
                                if (i5 >= list2.size()) {
                                    break;
                                } else if (TextUtils.equals(list2.get(i5).prop, str2)) {
                                    ConsumablesActivity.this.f9647O000000o.add(i4, deviceConsumble);
                                    ConsumablesActivity.this.f9647O000000o.remove(i4 + 1);
                                    break;
                                } else {
                                    i5++;
                                }
                            }
                        }
                    }
                    ConsumablesActivity.this.updateUIData();
                }
            }

            public final void O000000o(String str, String str2) {
                if (ConsumablesActivity.this.isValid() && TextUtils.equals(ConsumablesActivity.this.mHomeId, str2)) {
                    gsy.O000000o(6, "Consumables", str);
                    gqg.O000000o((int) R.string.retrieve_data_fail);
                }
            }

            public final void O000000o() {
                if (ConsumablesActivity.this.mPullRefreshLL.isRefreshing()) {
                    ConsumablesActivity.this.mPullRefreshLL.refreshComplete();
                }
                ConsumablesActivity.this.showEmpty();
            }
        });
    }

    static class O00000o0 extends RecyclerView.O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        TextView f9657O000000o;
        TextView O00000Oo;

        O00000o0(View view) {
            super(view);
            this.f9657O000000o = (TextView) view.findViewById(R.id.device_name);
            this.O00000Oo = (TextView) view.findViewById(R.id.home_room_name);
        }
    }

    static class O000000o extends RecyclerView.O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        TextView f9654O000000o;
        TextView O00000Oo;
        ImageView O00000o;
        TextView O00000o0;
        View O00000oO;
        View O00000oo;

        O000000o(View view) {
            super(view);
            this.f9654O000000o = (TextView) view.findViewById(R.id.percentage);
            this.O00000Oo = (TextView) view.findViewById(R.id.description);
            this.O00000oO = view.findViewById(R.id.to_buy);
            this.O00000o0 = (TextView) view.findViewById(R.id.remain_days);
            this.O00000oo = view.findViewById(R.id.btn_reset);
            this.O00000o = (ImageView) view.findViewById(R.id.icon_low_battery);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(View view) {
        if (!this.mPullRefreshLL.isRefreshing() && !this.isChangingHome && !this.isRefreshing) {
            this.isChangingHome = true;
            this.mPullRefreshLL.refreshComplete();
            doDropDownAnimation(true);
            HomeListDialogHelper.O000000o(this, this.mTitleBar, this.mHomeId, false, new HomeListDialogHelper.O000000o() {
                /* class com.xiaomi.smarthome.miio.activity.ConsumablesActivity.AnonymousClass3 */

                public final void O000000o() {
                    ConsumablesActivity.this.doDropDownAnimation(false);
                    ConsumablesActivity.this.isChangingHome = false;
                }

                public final void O000000o(Home home) {
                    if (home == null || TextUtils.equals(home.getId(), ConsumablesActivity.this.mHomeId)) {
                        ConsumablesActivity.this.isChangingHome = false;
                        return;
                    }
                    ConsumablesActivity.this.mHomeId = home.getId();
                    TextView textView = ConsumablesActivity.this.mTitle;
                    ggb.O00000Oo();
                    textView.setText(ggb.O000000o(home));
                    ConsumablesActivity.this.showProgressDialog();
                    ConsumablesActivity.this.f9647O000000o.clear();
                    ConsumablesActivity.this.mAdapter.O000000o(ConsumablesActivity.this.f9647O000000o);
                    try {
                        if (ggb.O00000Oo().O0000Oo(ConsumablesActivity.this.mHomeId).isEmpty()) {
                            ggw.O000000o().O000000o(Long.parseLong(ConsumablesActivity.this.mHomeId), new fsm() {
                                /* class com.xiaomi.smarthome.miio.activity.ConsumablesActivity.AnonymousClass3.AnonymousClass1 */

                                /* access modifiers changed from: private */
                                public /* synthetic */ void O00000Oo() {
                                    ConsumablesActivity.this.refreshView(ConsumablesActivity.this.mHomeId);
                                }

                                public final void onSuccess(Object obj) {
                                    ConsumablesActivity.this.mHandler.post(
                                    /*  JADX ERROR: Method code generation error
                                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000b: INVOKE  
                                          (wrap: android.os.Handler : 0x0004: IGET  (r2v3 android.os.Handler) = 
                                          (wrap: com.xiaomi.smarthome.miio.activity.ConsumablesActivity : 0x0002: IGET  (r2v2 com.xiaomi.smarthome.miio.activity.ConsumablesActivity) = 
                                          (wrap: com.xiaomi.smarthome.miio.activity.ConsumablesActivity$3 : 0x0000: IGET  (r2v1 com.xiaomi.smarthome.miio.activity.ConsumablesActivity$3) = (r1v0 'this' com.xiaomi.smarthome.miio.activity.ConsumablesActivity$3$1 A[THIS]) com.xiaomi.smarthome.miio.activity.ConsumablesActivity.3.1.O000000o com.xiaomi.smarthome.miio.activity.ConsumablesActivity$3)
                                         com.xiaomi.smarthome.miio.activity.ConsumablesActivity.3.O000000o com.xiaomi.smarthome.miio.activity.ConsumablesActivity)
                                         com.xiaomi.smarthome.miio.activity.ConsumablesActivity.mHandler android.os.Handler)
                                          (wrap: com.xiaomi.smarthome.miio.activity.-$$Lambda$ConsumablesActivity$3$1$dLB6soy-BgUtOWpdc2EGEy7kaeY : 0x0008: CONSTRUCTOR  (r0v0 com.xiaomi.smarthome.miio.activity.-$$Lambda$ConsumablesActivity$3$1$dLB6soy-BgUtOWpdc2EGEy7kaeY) = (r1v0 'this' com.xiaomi.smarthome.miio.activity.ConsumablesActivity$3$1 A[THIS]) call: com.xiaomi.smarthome.miio.activity.-$$Lambda$ConsumablesActivity$3$1$dLB6soy-BgUtOWpdc2EGEy7kaeY.<init>(com.xiaomi.smarthome.miio.activity.ConsumablesActivity$3$1):void type: CONSTRUCTOR)
                                         type: VIRTUAL call: android.os.Handler.post(java.lang.Runnable):boolean in method: com.xiaomi.smarthome.miio.activity.ConsumablesActivity.3.1.onSuccess(java.lang.Object):void, dex: classes5.dex
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:215)
                                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:208)
                                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:337)
                                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:290)
                                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:259)
                                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                                        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                                        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:678)
                                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:608)
                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:790)
                                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:730)
                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                        	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:318)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:69)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:215)
                                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:208)
                                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:337)
                                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:290)
                                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:259)
                                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                                        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                                        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:678)
                                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:608)
                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:790)
                                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:730)
                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:215)
                                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:208)
                                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:337)
                                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:290)
                                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:259)
                                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                                        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                                        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:226)
                                        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:115)
                                        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:81)
                                        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                                        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                                        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                                        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                                        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:297)
                                        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:276)
                                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0008: CONSTRUCTOR  (r0v0 com.xiaomi.smarthome.miio.activity.-$$Lambda$ConsumablesActivity$3$1$dLB6soy-BgUtOWpdc2EGEy7kaeY) = (r1v0 'this' com.xiaomi.smarthome.miio.activity.ConsumablesActivity$3$1 A[THIS]) call: com.xiaomi.smarthome.miio.activity.-$$Lambda$ConsumablesActivity$3$1$dLB6soy-BgUtOWpdc2EGEy7kaeY.<init>(com.xiaomi.smarthome.miio.activity.ConsumablesActivity$3$1):void type: CONSTRUCTOR in method: com.xiaomi.smarthome.miio.activity.ConsumablesActivity.3.1.onSuccess(java.lang.Object):void, dex: classes5.dex
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:790)
                                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:730)
                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                        	... 116 more
                                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.xiaomi.smarthome.miio.activity.-$$Lambda$ConsumablesActivity$3$1$dLB6soy-BgUtOWpdc2EGEy7kaeY, state: NOT_LOADED
                                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:270)
                                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                        	... 122 more
                                        */
                                    /*
                                        this = this;
                                        com.xiaomi.smarthome.miio.activity.ConsumablesActivity$3 r2 = com.xiaomi.smarthome.miio.activity.ConsumablesActivity.AnonymousClass3.this
                                        com.xiaomi.smarthome.miio.activity.ConsumablesActivity r2 = com.xiaomi.smarthome.miio.activity.ConsumablesActivity.this
                                        android.os.Handler r2 = r2.mHandler
                                        com.xiaomi.smarthome.miio.activity.-$$Lambda$ConsumablesActivity$3$1$dLB6soy-BgUtOWpdc2EGEy7kaeY r0 = new com.xiaomi.smarthome.miio.activity.-$$Lambda$ConsumablesActivity$3$1$dLB6soy-BgUtOWpdc2EGEy7kaeY
                                        r0.<init>(r1)
                                        r2.post(r0)
                                        return
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.smarthome.miio.activity.ConsumablesActivity.AnonymousClass3.AnonymousClass1.onSuccess(java.lang.Object):void");
                                }

                                /* access modifiers changed from: private */
                                public /* synthetic */ void O000000o() {
                                    ConsumablesActivity.this.refreshView(ConsumablesActivity.this.mHomeId);
                                }

                                public final void onFailure(fso fso) {
                                    ConsumablesActivity.this.mHandler.post(
                                    /*  JADX ERROR: Method code generation error
                                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000b: INVOKE  
                                          (wrap: android.os.Handler : 0x0004: IGET  (r2v3 android.os.Handler) = 
                                          (wrap: com.xiaomi.smarthome.miio.activity.ConsumablesActivity : 0x0002: IGET  (r2v2 com.xiaomi.smarthome.miio.activity.ConsumablesActivity) = 
                                          (wrap: com.xiaomi.smarthome.miio.activity.ConsumablesActivity$3 : 0x0000: IGET  (r2v1 com.xiaomi.smarthome.miio.activity.ConsumablesActivity$3) = (r1v0 'this' com.xiaomi.smarthome.miio.activity.ConsumablesActivity$3$1 A[THIS]) com.xiaomi.smarthome.miio.activity.ConsumablesActivity.3.1.O000000o com.xiaomi.smarthome.miio.activity.ConsumablesActivity$3)
                                         com.xiaomi.smarthome.miio.activity.ConsumablesActivity.3.O000000o com.xiaomi.smarthome.miio.activity.ConsumablesActivity)
                                         com.xiaomi.smarthome.miio.activity.ConsumablesActivity.mHandler android.os.Handler)
                                          (wrap: com.xiaomi.smarthome.miio.activity.-$$Lambda$ConsumablesActivity$3$1$N1S3L1mYnxNXug21Zp_uXnhLX00 : 0x0008: CONSTRUCTOR  (r0v0 com.xiaomi.smarthome.miio.activity.-$$Lambda$ConsumablesActivity$3$1$N1S3L1mYnxNXug21Zp_uXnhLX00) = (r1v0 'this' com.xiaomi.smarthome.miio.activity.ConsumablesActivity$3$1 A[THIS]) call: com.xiaomi.smarthome.miio.activity.-$$Lambda$ConsumablesActivity$3$1$N1S3L1mYnxNXug21Zp_uXnhLX00.<init>(com.xiaomi.smarthome.miio.activity.ConsumablesActivity$3$1):void type: CONSTRUCTOR)
                                         type: VIRTUAL call: android.os.Handler.post(java.lang.Runnable):boolean in method: com.xiaomi.smarthome.miio.activity.ConsumablesActivity.3.1.onFailure(_m_j.fso):void, dex: classes5.dex
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:215)
                                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:208)
                                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:337)
                                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:290)
                                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:259)
                                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                                        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                                        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:678)
                                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:608)
                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:790)
                                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:730)
                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                        	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:318)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:69)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:215)
                                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:208)
                                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:337)
                                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:290)
                                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:259)
                                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                                        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                                        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:678)
                                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:608)
                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:790)
                                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:730)
                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:215)
                                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:208)
                                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:337)
                                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:290)
                                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:259)
                                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                                        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                                        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:226)
                                        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:115)
                                        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:81)
                                        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                                        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                                        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                                        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                                        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:297)
                                        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:276)
                                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0008: CONSTRUCTOR  (r0v0 com.xiaomi.smarthome.miio.activity.-$$Lambda$ConsumablesActivity$3$1$N1S3L1mYnxNXug21Zp_uXnhLX00) = (r1v0 'this' com.xiaomi.smarthome.miio.activity.ConsumablesActivity$3$1 A[THIS]) call: com.xiaomi.smarthome.miio.activity.-$$Lambda$ConsumablesActivity$3$1$N1S3L1mYnxNXug21Zp_uXnhLX00.<init>(com.xiaomi.smarthome.miio.activity.ConsumablesActivity$3$1):void type: CONSTRUCTOR in method: com.xiaomi.smarthome.miio.activity.ConsumablesActivity.3.1.onFailure(_m_j.fso):void, dex: classes5.dex
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:790)
                                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:730)
                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                        	... 116 more
                                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.xiaomi.smarthome.miio.activity.-$$Lambda$ConsumablesActivity$3$1$N1S3L1mYnxNXug21Zp_uXnhLX00, state: NOT_LOADED
                                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:270)
                                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                        	... 122 more
                                        */
                                    /*
                                        this = this;
                                        com.xiaomi.smarthome.miio.activity.ConsumablesActivity$3 r2 = com.xiaomi.smarthome.miio.activity.ConsumablesActivity.AnonymousClass3.this
                                        com.xiaomi.smarthome.miio.activity.ConsumablesActivity r2 = com.xiaomi.smarthome.miio.activity.ConsumablesActivity.this
                                        android.os.Handler r2 = r2.mHandler
                                        com.xiaomi.smarthome.miio.activity.-$$Lambda$ConsumablesActivity$3$1$N1S3L1mYnxNXug21Zp_uXnhLX00 r0 = new com.xiaomi.smarthome.miio.activity.-$$Lambda$ConsumablesActivity$3$1$N1S3L1mYnxNXug21Zp_uXnhLX00
                                        r0.<init>(r1)
                                        r2.post(r0)
                                        return
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.smarthome.miio.activity.ConsumablesActivity.AnonymousClass3.AnonymousClass1.onFailure(_m_j.fso):void");
                                }
                            });
                        } else {
                            ConsumablesActivity.this.mHandler.post(new Runnable() {
                                /* class com.xiaomi.smarthome.miio.activity.$$Lambda$ConsumablesActivity$3$v_KHy72xZ_s9YgLfppQVLI827A */

                                public final void run() {
                                    ConsumablesActivity.AnonymousClass3.this.O00000o0();
                                }
                            });
                        }
                    } catch (Exception e) {
                        gsy.O00000Oo("Consumables", "Exception:" + e.getMessage());
                        ConsumablesActivity.this.mHandler.post(new Runnable() {
                            /* class com.xiaomi.smarthome.miio.activity.$$Lambda$ConsumablesActivity$3$i4g7_eGTw1zulFujevXGTjKpslw */

                            public final void run() {
                                ConsumablesActivity.AnonymousClass3.this.O00000Oo();
                            }
                        });
                    }
                }

                /* access modifiers changed from: private */
                public /* synthetic */ void O00000o0() {
                    ConsumablesActivity consumablesActivity = ConsumablesActivity.this;
                    consumablesActivity.refreshView(consumablesActivity.mHomeId);
                }

                /* access modifiers changed from: private */
                public /* synthetic */ void O00000Oo() {
                    ConsumablesActivity consumablesActivity = ConsumablesActivity.this;
                    consumablesActivity.refreshView(consumablesActivity.mHomeId);
                }
            });
        }
    }
}

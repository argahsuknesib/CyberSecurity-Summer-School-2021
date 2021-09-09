package com.xiaomi.smarthome.camera.lowpower.linkage;

import _m_j.fno;
import _m_j.ft;
import _m_j.ggb;
import _m_j.gqg;
import _m_j.hjp;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.activity.CameraBaseActivity;
import com.xiaomi.smarthome.camera.lowpower.LinkageManager;
import com.xiaomi.smarthome.camera.lowpower.entity.LinkageDeviceInfo;
import com.xiaomi.smarthome.camera.view.widget.CenterDrawableCheckBox;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.frame.core.CoreApi;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DeviceLinkSelectActivity extends CameraBaseActivity implements View.OnClickListener {
    public MyAdapter adapter;
    public BuyAdapter buyAdapter;
    private ImageView imgLoading;
    private boolean isMultiChoice;
    private ImageView mConfirmView;
    List<LinkageDeviceInfo> mLinkableDevices = new ArrayList();
    private int mMaxLength;
    private BroadcastReceiver mReceiver;
    public RecyclerView rcBuyList;
    private TextView tvNoBleLock;
    private TextView tvTitle;
    private View vBuyGuide;
    private View vDeviceArea;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.linkage_screen_device_selector_layout);
        this.isMultiChoice = getIntent().getBooleanExtra("extra_multi_choice", true);
        this.mMaxLength = getIntent().getIntExtra("max_length", -1);
        this.tvTitle = (TextView) findViewById(R.id.module_a_3_return_title);
        this.mConfirmView = (ImageView) findViewById(R.id.module_a_3_right_iv_setting_btn);
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.lowpower.linkage.$$Lambda$DeviceLinkSelectActivity$jPtdrvHZ6KtupFGG8Zr9ccwWAb4 */

            public final void onClick(View view) {
                DeviceLinkSelectActivity.this.lambda$onCreate$0$DeviceLinkSelectActivity(view);
            }
        });
        initData();
    }

    public /* synthetic */ void lambda$onCreate$0$DeviceLinkSelectActivity(View view) {
        finish();
    }

    private void initData() {
        if (!LinkageManager.getInstance().isRequesting()) {
            onDataCompleted();
        } else {
            registerListener();
        }
    }

    public void onDataCompleted() {
        this.mLinkableDevices = LinkageManager.getInstance().getLinkageList();
        if (this.mLinkableDevices.size() > 0) {
            getLinkableDeviceInfo();
        } else {
            showBuyGuide();
        }
    }

    private void registerListener() {
        this.mReceiver = new BroadcastReceiver() {
            /* class com.xiaomi.smarthome.camera.lowpower.linkage.DeviceLinkSelectActivity.AnonymousClass1 */

            public void onReceive(Context context, Intent intent) {
                DeviceLinkSelectActivity.this.onDataCompleted();
            }
        };
        ft.O000000o(this).O000000o(this.mReceiver, new IntentFilter("device_list_request_completed"));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: androidx.recyclerview.widget.GridLayoutManager.<init>(android.content.Context, int, int, boolean):void
     arg types: [com.xiaomi.smarthome.camera.lowpower.linkage.DeviceLinkSelectActivity, int, int, int]
     candidates:
      androidx.recyclerview.widget.GridLayoutManager.<init>(android.content.Context, android.util.AttributeSet, int, int):void
      androidx.recyclerview.widget.GridLayoutManager.<init>(android.content.Context, int, int, boolean):void */
    private void showBuyGuide() {
        this.tvTitle.setText((int) R.string.link_device);
        if (this.vBuyGuide == null) {
            this.vBuyGuide = ((ViewStub) findViewById(R.id.vs_buy_guide)).inflate();
        }
        View view = this.vDeviceArea;
        if (view != null) {
            view.setVisibility(8);
        }
        this.vBuyGuide.findViewById(R.id.common_white_empty_view).setBackgroundColor(getResources().getColor(R.color.mj_color_gray_lightest));
        this.vBuyGuide.findViewById(R.id.common_white_empty_view).setVisibility(0);
        ((ImageView) this.vBuyGuide.findViewById(R.id.empty_icon)).setImageResource(R.drawable.ic_plug_rec_action_empty_1000);
        ((TextView) this.vBuyGuide.findViewById(R.id.common_white_empty_text)).setText((int) R.string.no_linkage_screen_device);
        this.rcBuyList = (RecyclerView) this.vBuyGuide.findViewById(R.id.buy_list);
        this.rcBuyList.setLayoutManager(new GridLayoutManager((Context) this, 3, 1, false));
        this.buyAdapter = new BuyAdapter();
        this.rcBuyList.setAdapter(this.buyAdapter);
        getBuyDeviceList();
    }

    private void getBuyDeviceList() {
        XmPluginHostApi.instance().getAppConfig("screen_device_recommend", "zh_CN", "2", new Callback<String>() {
            /* class com.xiaomi.smarthome.camera.lowpower.linkage.DeviceLinkSelectActivity.AnonymousClass2 */

            public void onFailure(int i, String str) {
            }

            public void onSuccess(String str) {
                try {
                    JSONArray jSONArray = new JSONArray(str);
                    final ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        arrayList.add(jSONArray.getJSONObject(i));
                    }
                    DeviceLinkSelectActivity.this.runOnUiThread(new Runnable() {
                        /* class com.xiaomi.smarthome.camera.lowpower.linkage.DeviceLinkSelectActivity.AnonymousClass2.AnonymousClass1 */

                        public void run() {
                            DeviceLinkSelectActivity.this.rcBuyList.setVisibility(0);
                            DeviceLinkSelectActivity.this.buyAdapter.setData(arrayList);
                            DeviceLinkSelectActivity.this.buyAdapter.notifyDataSetChanged();
                        }
                    });
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void getLinkableDeviceInfo() {
        this.tvTitle.setText((int) R.string.choose_screen_device);
        this.mConfirmView.setVisibility(0);
        this.mConfirmView.setImageResource(R.drawable.title_right_tick_drawable);
        this.mConfirmView.setOnClickListener(this);
        showLinkableDevices();
    }

    private void showLinkableDevices() {
        this.vDeviceArea = ((ViewStub) findViewById(R.id.vs_condition_list)).inflate();
        this.tvNoBleLock = (TextView) this.vDeviceArea.findViewById(R.id.tv_not_connect_ble);
        String string = getString(R.string.device_rec_condition_no_gateway);
        int indexOf = string.indexOf("#start#");
        int indexOf2 = string.indexOf("#end#") - 7;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) string.replace("#start#", "").replace("#end#", ""));
        AnonymousClass3 r0 = new ClickableSpan() {
            /* class com.xiaomi.smarthome.camera.lowpower.linkage.DeviceLinkSelectActivity.AnonymousClass3 */

            public void onClick(View view) {
            }

            public void updateDrawState(TextPaint textPaint) {
                super.updateDrawState(textPaint);
                textPaint.setColor(DeviceLinkSelectActivity.this.getResources().getColor(R.color.mj_color_green_normal));
                textPaint.setUnderlineText(true);
            }
        };
        if (indexOf >= 0 && indexOf2 > 0) {
            try {
                spannableStringBuilder.setSpan(r0, indexOf, indexOf2, 33);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.tvNoBleLock.setText(spannableStringBuilder);
        this.tvNoBleLock.setMovementMethod(LinkMovementMethod.getInstance());
        if (this.mLinkableDevices.size() > 0) {
            this.tvNoBleLock.setVisibility(8);
        } else {
            this.tvNoBleLock.setVisibility(0);
        }
        this.imgLoading = (ImageView) this.vDeviceArea.findViewById(R.id.mj_loading);
        RecyclerView recyclerView = (RecyclerView) this.vDeviceArea.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.adapter = new MyAdapter();
        recyclerView.setAdapter(this.adapter);
        View view = this.vBuyGuide;
        if (view != null) {
            view.setVisibility(8);
        }
        this.imgLoading.setVisibility(8);
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.mReceiver != null) {
            ft.O000000o(this).O000000o(this.mReceiver);
        }
    }

    public class ConditionViewHolder extends RecyclerView.O000OOo0 {
        public CenterDrawableCheckBox checkBox;
        public TextView deviceName;
        public View divider;
        public View dividerLast;
        public SimpleDraweeView sdImg;
        public TextView tvRoomName;

        public ConditionViewHolder(View view) {
            super(view);
            this.deviceName = (TextView) view.findViewById(R.id.device_name);
            this.divider = view.findViewById(R.id.divider_x);
            this.dividerLast = view.findViewById(R.id.divider_last);
            this.tvRoomName = (TextView) view.findViewById(R.id.room_name);
            this.sdImg = (SimpleDraweeView) view.findViewById(R.id.sd_device_img);
            this.checkBox = (CenterDrawableCheckBox) view.findViewById(R.id.select_checkbox);
        }

        public void fillWithCondition(LinkageDeviceInfo linkageDeviceInfo, final int i) {
            Device O000000o2 = fno.O000000o().O000000o(linkageDeviceInfo.getDeviceStat().did);
            if (O000000o2 == null) {
                O000000o2 = DeviceFactory.O0000o0O(linkageDeviceInfo.getDeviceStat().model);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(TextUtils.isEmpty(linkageDeviceInfo.getDeviceStat().name) ? "" : linkageDeviceInfo.getDeviceStat().name);
            if (!O000000o2.isOnline) {
                sb.append("(");
                sb.append(DeviceLinkSelectActivity.this.getString(R.string.offline_device));
                sb.append(")");
            }
            this.deviceName.setText(sb.toString());
            String O0000o0O = ggb.O00000Oo().O0000o0O(O000000o2.did);
            TextView textView = this.tvRoomName;
            if (TextUtils.isEmpty(O0000o0O)) {
                O0000o0O = "";
            }
            textView.setText(O0000o0O);
            if (O000000o2 != null) {
                DeviceFactory.O00000Oo(O000000o2.model, this.sdImg);
            } else {
                DeviceFactory.O00000Oo((String) null, this.sdImg);
            }
            this.checkBox.setChecked(linkageDeviceInfo.isSelected());
            this.checkBox.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.camera.lowpower.linkage.DeviceLinkSelectActivity.ConditionViewHolder.AnonymousClass1 */

                public void onClick(View view) {
                    DeviceLinkSelectActivity.this.onCheckedChanged(ConditionViewHolder.this.checkBox.isChecked(), i);
                }
            });
        }
    }

    public void onCheckedChanged(boolean z, int i) {
        if (!this.isMultiChoice) {
            for (int i2 = 0; i2 < this.mLinkableDevices.size(); i2++) {
                LinkageDeviceInfo linkageDeviceInfo = this.mLinkableDevices.get(i2);
                if (i2 != i) {
                    linkageDeviceInfo.setSelected(false);
                } else {
                    linkageDeviceInfo.setSelected(z);
                }
            }
            this.mConfirmView.post(new Runnable() {
                /* class com.xiaomi.smarthome.camera.lowpower.linkage.DeviceLinkSelectActivity.AnonymousClass4 */

                public void run() {
                    DeviceLinkSelectActivity.this.adapter.notifyDataSetChanged();
                }
            });
            return;
        }
        int i3 = 0;
        for (LinkageDeviceInfo isSelected : this.mLinkableDevices) {
            if (isSelected.isSelected()) {
                i3++;
            }
        }
        if (i3 < this.mMaxLength || this.mLinkableDevices.get(i).isSelected()) {
            this.mLinkableDevices.get(i).setSelected(z);
        } else {
            gqg.O00000Oo(getString(R.string.max_devices_exceeded, new Object[]{Integer.valueOf(this.mMaxLength)}));
            this.mLinkableDevices.get(i).setSelected(false);
        }
        this.mConfirmView.post(new Runnable() {
            /* class com.xiaomi.smarthome.camera.lowpower.linkage.DeviceLinkSelectActivity.AnonymousClass5 */

            public void run() {
                DeviceLinkSelectActivity.this.adapter.notifyDataSetChanged();
            }
        });
    }

    public class MyAdapter extends RecyclerView.O000000o<RecyclerView.O000OOo0> {
        public long getItemId(int i) {
            return (long) i;
        }

        public int getItemViewType(int i) {
            return 0;
        }

        public MyAdapter() {
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
            DeviceLinkSelectActivity deviceLinkSelectActivity = DeviceLinkSelectActivity.this;
            return new ConditionViewHolder(LayoutInflater.from(deviceLinkSelectActivity).inflate((int) R.layout.linkage_device_select_item, viewGroup, false));
        }

        public void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
            ((ConditionViewHolder) o000OOo0).fillWithCondition(DeviceLinkSelectActivity.this.mLinkableDevices.get(i), i);
        }

        public int getItemCount() {
            return DeviceLinkSelectActivity.this.mLinkableDevices.size();
        }
    }

    public void onClick(View view) {
        if (view.getId() == R.id.module_a_3_right_iv_setting_btn) {
            submiteInfo();
        }
    }

    private void submiteInfo() {
        LinkageManager.getInstance().submitSelectedInfo(this.mDeviceStat.model, this.mDeviceStat.did, new Callback<JSONObject>() {
            /* class com.xiaomi.smarthome.camera.lowpower.linkage.DeviceLinkSelectActivity.AnonymousClass6 */

            public void onSuccess(JSONObject jSONObject) {
                DeviceLinkSelectActivity.this.runOnUiThread(new Runnable() {
                    /* class com.xiaomi.smarthome.camera.lowpower.linkage.DeviceLinkSelectActivity.AnonymousClass6.AnonymousClass1 */

                    public void run() {
                        gqg.O00000Oo((int) R.string.action_success);
                        DeviceLinkSelectActivity.this.updateLinkageDataSuccess();
                        DeviceLinkSelectActivity.this.finish();
                    }
                });
            }

            public void onFailure(int i, String str) {
                DeviceLinkSelectActivity.this.runOnUiThread(new Runnable() {
                    /* class com.xiaomi.smarthome.camera.lowpower.linkage.DeviceLinkSelectActivity.AnonymousClass6.AnonymousClass2 */

                    public void run() {
                        gqg.O00000Oo((int) R.string.action_fail);
                        DeviceLinkSelectActivity.this.updateLinkageDataFail();
                    }
                });
            }
        });
    }

    public void updateLinkageDataFail() {
        for (LinkageDeviceInfo next : this.mLinkableDevices) {
            next.setSelected(next.isBinded());
        }
        this.adapter.notifyDataSetChanged();
    }

    public void updateLinkageDataSuccess() {
        for (LinkageDeviceInfo next : this.mLinkableDevices) {
            next.setBinded(next.isSelected());
        }
        this.adapter.notifyDataSetChanged();
    }

    public static class BuyViewHolder extends RecyclerView.O000OOo0 {
        public TextView modelName;
        public SimpleDraweeView sdImg;

        public BuyViewHolder(View view) {
            super(view);
            this.modelName = (TextView) view.findViewById(R.id.model_name);
            this.sdImg = (SimpleDraweeView) view.findViewById(R.id.sd_model_img);
        }
    }

    public class BuyAdapter extends RecyclerView.O000000o<BuyViewHolder> {
        private List<JSONObject> buyData = new ArrayList();

        public long getItemId(int i) {
            return (long) i;
        }

        public BuyAdapter() {
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public BuyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new BuyViewHolder(LayoutInflater.from(DeviceLinkSelectActivity.this).inflate((int) R.layout.light_rec_scene_buy_item, viewGroup, false));
        }

        public void onBindViewHolder(BuyViewHolder buyViewHolder, int i) {
            JSONObject jSONObject = this.buyData.get(i);
            String optString = jSONObject.optString("model");
            String optString2 = jSONObject.optString("deviceBuyLink");
            String optString3 = jSONObject.optString("deviceName");
            if (!TextUtils.isEmpty(optString)) {
                DeviceFactory.O00000Oo(optString, buyViewHolder.sdImg);
                PluginDeviceInfo O00000oO = CoreApi.O000000o().O00000oO(optString);
                if (O00000oO != null) {
                    optString3 = O00000oO.O0000Oo0();
                }
                buyViewHolder.modelName.setText(optString3);
                buyViewHolder.itemView.setOnClickListener(new View.OnClickListener(optString2) {
                    /* class com.xiaomi.smarthome.camera.lowpower.linkage.$$Lambda$DeviceLinkSelectActivity$BuyAdapter$WukIGYHrxtoCA7QgP1xtaCmOvF4 */
                    private final /* synthetic */ String f$0;

                    {
                        this.f$0 = r1;
                    }

                    public final void onClick(View view) {
                        hjp.O000000o(this.f$0);
                    }
                });
            }
        }

        public int getItemCount() {
            List<JSONObject> list = this.buyData;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: androidx.recyclerview.widget.GridLayoutManager.<init>(android.content.Context, int, int, boolean):void
         arg types: [com.xiaomi.smarthome.camera.lowpower.linkage.DeviceLinkSelectActivity, int, int, int]
         candidates:
          androidx.recyclerview.widget.GridLayoutManager.<init>(android.content.Context, android.util.AttributeSet, int, int):void
          androidx.recyclerview.widget.GridLayoutManager.<init>(android.content.Context, int, int, boolean):void */
        public void setData(List<JSONObject> list) {
            this.buyData.clear();
            this.buyData.addAll(list);
            if (list.size() <= 2) {
                DeviceLinkSelectActivity.this.rcBuyList.setLayoutManager(new GridLayoutManager((Context) DeviceLinkSelectActivity.this, 2, 1, false));
            }
            notifyDataSetChanged();
        }
    }

    public void finish() {
        super.finish();
        for (LinkageDeviceInfo next : this.mLinkableDevices) {
            if (next != null) {
                next.setSelected(next.isBinded());
            }
        }
    }
}

package com.xiaomi.smarthome.miio.activity;

import _m_j.faw;
import _m_j.fcn;
import _m_j.fkv;
import _m_j.fno;
import _m_j.fsm;
import _m_j.fso;
import _m_j.ftl;
import _m_j.ftn;
import _m_j.gpc;
import _m_j.gsy;
import _m_j.gwa;
import _m_j.gwg;
import _m_j.hjp;
import _m_j.hzf;
import _m_j.izb;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.device.BleGatewayNestedScrollingParent;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.DeviceApi;
import com.xiaomi.smarthome.device.api.Parser;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.device.bluetooth.BleGatewayManager;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.library.common.widget.SwitchButton;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.miio.dialog.BleGatewayMeshDialog;
import com.xiaomi.smarthome.operation.js_sdk.OperationCommonWebViewActivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.json.JSONObject;

public class BleGatewayActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private List<Device> f9591O000000o = new ArrayList();
    private List<Device> O00000Oo = new ArrayList();
    private ObjectAnimator O00000o;
    private boolean O00000o0 = false;
    public boolean isLoadingData = false;
    public int mAlertType = 0;
    @BindView(5414)
    ImageView mBackBt;
    public O00000Oo mBleAdapter;
    @BindView(5872)
    TextView mBleButtonContent;
    public MLAlertDialog mBleMeshSwitchAlertDialog;
    @BindView(4925)
    CardView mBleSwitch;
    @BindView(4938)
    SwitchButton mBleSwitchBtn;
    @BindView(5871)
    TextView mBleSwitchTitle;
    @BindView(5028)
    View mEmptyView;
    @BindView(5121)
    View mEmptyViewContainer;
    @BindView(5026)
    TextView mFirstEmptyText;
    public Device mGatewayDevice;
    @BindView(5202)
    ImageView mHeadAnimImage;
    @BindView(5065)
    TextView mHeadDescView;
    @BindView(5204)
    SimpleDraweeView mHeadImageExtend;
    @BindView(5205)
    SimpleDraweeView mHeadImageShrink;
    public boolean mIsXiaoaiDevice = false;
    @BindView(5317)
    CardView mListCardView;
    public XQProgressDialog mLoadingDialog;
    @BindView(5393)
    TextView mMeshGatewayGuideView;
    @BindView(5636)
    BleGatewayNestedScrollingParent mNestedScrollView;
    @BindView(5315)
    RecyclerView mRecyclerView;
    @BindView(5560)
    ImageView mRefreshProgress;
    @BindView(5027)
    TextView mSecondEmptyText;
    public List<Device> mShowDevices = new ArrayList();
    public boolean mSwitchEnabled = false;
    @BindView(5418)
    TextView mTitle;
    @BindView(5948)
    View mViewBleSwitch;
    public int mWifiSpeakerBtSwitchStatus = 0;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_ble_gateway);
        ButterKnife.bind(this);
        this.mEmptyView.setVisibility(0);
        this.mMeshGatewayGuideView.getPaint().setFlags(8);
        if (ftn.O00000Oo(CoreApi.O000000o().O0000ooO())) {
            this.mFirstEmptyText.setText((int) R.string.miio_ble_gateway_scan_empty_international);
        } else {
            this.mFirstEmptyText.setText((int) R.string.miio_ble_gateway_scan_empty);
            this.mSecondEmptyText.setVisibility(0);
            this.mSecondEmptyText.setTextColor(getResources().getColor(R.color.mj_color_green_normal));
            this.mSecondEmptyText.setText((int) R.string.miio_find_ble_device_in_store);
            this.mSecondEmptyText.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.miio.activity.BleGatewayActivity.AnonymousClass15 */

                public final void onClick(View view) {
                    hjp.O000000o("https://home.mi.com/app/shop/content?id=vae2ad03985fd3bd7");
                }
            });
        }
        this.mBackBt.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.activity.BleGatewayActivity.AnonymousClass2 */

            public final void onClick(View view) {
                BleGatewayActivity.this.finish();
            }
        });
        this.mBleAdapter = new O00000Oo(this, (byte) 0);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(1);
        this.mRecyclerView.setLayoutManager(linearLayoutManager);
        this.mRecyclerView.setAdapter(this.mBleAdapter);
        this.mHeadAnimImage.setImageResource(R.drawable.ble_gateway_head);
        ((AnimationDrawable) this.mHeadAnimImage.getDrawable()).start();
        this.mNestedScrollView.setOnRefreshListener(new BleGatewayNestedScrollingParent.O000000o() {
            /* class com.xiaomi.smarthome.miio.activity.BleGatewayActivity.AnonymousClass3 */

            public final void O000000o() {
                BleGatewayActivity.this.showRefreshLoading();
                BleGatewayActivity.this.loadData();
            }
        });
        this.mMeshGatewayGuideView.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.activity.BleGatewayActivity.AnonymousClass4 */

            public final void onClick(View view) {
                Intent intent = new Intent(CommonApplication.getAppContext(), OperationCommonWebViewActivity.class);
                intent.putExtra("url", ftl.O00000Oo() ? "https://home.mi.com/app_webview/newoperation/index.html#/article?articleId=898437912000000001" : "https://home.mi.com/app_webview/newoperation/index.html#/article?articleId=100147623000000001");
                intent.putExtra("title", BleGatewayActivity.this.getResources().getString(R.string.mesh_gateway_guide));
                intent.setFlags(268435456);
                try {
                    CommonApplication.getAppContext().startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ArrayList arrayList = null;
        if (getIntent() != null) {
            String stringExtra = getIntent().getStringExtra("key_gateway_did");
            ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra("key_gateway_items");
            this.mGatewayDevice = fno.O000000o().O000000o(stringExtra);
            arrayList = parcelableArrayListExtra;
        }
        Device device = this.mGatewayDevice;
        if (device == null) {
            finish();
        } else {
            this.O00000o0 = BleGatewayManager.O000000o(device.did);
            if (this.O00000o0) {
                this.mMeshGatewayGuideView.setVisibility(0);
            }
            this.mNestedScrollView.setIsMesh(this.O00000o0);
            if (this.O00000o0) {
                this.mHeadDescView.setText((int) R.string.mesh_gateway_desc);
            }
            this.mTitle.setText(this.mGatewayDevice.name);
            DeviceFactory.O000000o(this.mGatewayDevice.model, this.mHeadImageExtend, (int) R.drawable.device_list_phone_no);
            DeviceFactory.O000000o(this.mGatewayDevice.model, this.mHeadImageShrink, (int) R.drawable.device_list_phone_no);
            if (arrayList == null) {
                loadData();
            } else {
                makeData(arrayList);
            }
        }
        DeviceApi.getInstance().requestBleWifiSpeakerState(getApplicationContext(), this.mGatewayDevice.did, new fsm<JSONObject, fso>() {
            /* class com.xiaomi.smarthome.miio.activity.BleGatewayActivity.AnonymousClass8 */

            public final /* synthetic */ void onSuccess(Object obj) {
                JSONObject optJSONObject;
                JSONObject jSONObject = (JSONObject) obj;
                if (jSONObject != null) {
                    gsy.O000000o(3, "BleGatewayActivity", "onSuccess: " + jSONObject.toString());
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("switch");
                if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject(BleGatewayActivity.this.mGatewayDevice.did)) != null) {
                    BleGatewayActivity.this.mSwitchEnabled = optJSONObject.optBoolean("enable");
                    BleGatewayActivity.this.mIsXiaoaiDevice = optJSONObject.optBoolean("is_xiao_ai");
                    if (BleGatewayActivity.this.mIsXiaoaiDevice) {
                        BleGatewayActivity.this.initWifiSpeakerBtInfo();
                    }
                    if (BleGatewayActivity.this.mSwitchEnabled) {
                        BleGatewayActivity.this.showBleSwitchLayout();
                        BleGatewayActivity.this.getBleSwitchState();
                    }
                }
            }

            public final void onFailure(fso fso) {
                gsy.O000000o(3, "BLEGateWay", "onFailure: " + fso.O00000Oo);
            }
        });
        this.mBleSwitchBtn.setOnTouchEnable(false);
        this.mViewBleSwitch.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.activity.BleGatewayActivity.AnonymousClass9 */

            public final void onClick(View view) {
                if (BleGatewayActivity.this.mSwitchEnabled) {
                    if (BleGatewayActivity.this.mBleSwitchBtn.isChecked()) {
                        if (BleGatewayActivity.this.mIsXiaoaiDevice) {
                            BleGatewayActivity.this.showMeshDialog(1);
                        } else {
                            BleGatewayActivity.this.closeBleSwitch();
                        }
                    } else if (BleGatewayActivity.this.isMeshBtConflict()) {
                        if (BleGatewayActivity.this.mBleMeshSwitchAlertDialog == null) {
                            MLAlertDialog.Builder builder = new MLAlertDialog.Builder(BleGatewayActivity.this);
                            builder.O000000o((int) R.string.common_hint);
                            builder.O00000Oo((int) R.string.ble_mesh_dialog_message_close_blue_while_open_mesh_gateway);
                            builder.O000000o((int) R.string.ble_mesh_dialog_continue, new DialogInterface.OnClickListener() {
                                /* class com.xiaomi.smarthome.miio.activity.BleGatewayActivity.AnonymousClass9.AnonymousClass1 */

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    gsy.O000000o(4, "BleGatewayActivity", "continue enable ble switch");
                                    BleGatewayActivity.this.openBleSwitch();
                                    BleGatewayActivity.this.disableWifiSpeakerBluetooth();
                                }
                            });
                            builder.O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
                                /* class com.xiaomi.smarthome.miio.activity.BleGatewayActivity.AnonymousClass9.AnonymousClass2 */

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    gsy.O000000o(4, "BleGatewayActivity", "cancel enable ble switch");
                                }
                            });
                            BleGatewayActivity.this.mBleMeshSwitchAlertDialog = builder.O00000o();
                        }
                        BleGatewayActivity.this.mBleMeshSwitchAlertDialog.show();
                    } else {
                        BleGatewayActivity.this.openBleSwitch();
                    }
                } else if (BleGatewayActivity.this.mAlertType == 2) {
                    BleGatewayActivity.this.showMeshDialog(3);
                } else if (BleGatewayActivity.this.mAlertType == 3) {
                    BleGatewayActivity.this.showMeshDialog(4);
                }
            }
        });
        gwg.O000000o(hzf.O000000o(CommonApplication.getAppContext()), findViewById(R.id.layout_title_bar));
    }

    public void initWifiSpeakerBtInfo() {
        gwa.O000000o().getWifiSpeakerBtSwitchStatus(getContext(), this.mGatewayDevice.did, new fkv<Integer, Integer>() {
            /* class com.xiaomi.smarthome.miio.activity.BleGatewayActivity.AnonymousClass1 */

            public final /* synthetic */ Object call(Object obj) throws RuntimeException {
                BleGatewayActivity.this.mWifiSpeakerBtSwitchStatus = ((Integer) obj).intValue();
                return 0;
            }
        });
    }

    public boolean isMeshBtConflict() {
        return gwa.O000000o().isMeshBtConflict(this.mGatewayDevice.did) && this.mWifiSpeakerBtSwitchStatus != 0;
    }

    public void disableWifiSpeakerBluetooth() {
        gwa.O000000o().disableWifiSpeakerBluetooth(this.mGatewayDevice.did);
    }

    public void showBleSwitchLayout() {
        this.mBleSwitch.setVisibility(0);
        if (!this.mIsXiaoaiDevice) {
            this.mBleButtonContent.setVisibility(8);
        }
        if (!this.O00000o0) {
            this.mBleSwitchTitle.setText((int) R.string.ble_gateway_switch_text);
        }
        showDeviceListLayer();
    }

    public void showDeviceListLayer() {
        if (this.mRecyclerView.getVisibility() != 0 || this.mBleSwitchBtn.isChecked()) {
            this.mListCardView.setAlpha(1.0f);
        } else {
            this.mListCardView.setAlpha(0.7f);
        }
    }

    public void showMeshDialog(final int i) {
        BleGatewayMeshDialog O000000o2 = BleGatewayMeshDialog.O000000o(i, this.O00000o0);
        O000000o2.f9716O000000o = new BleGatewayMeshDialog.O000000o() {
            /* class com.xiaomi.smarthome.miio.activity.BleGatewayActivity.AnonymousClass10 */

            public final void O000000o() {
                int i = i;
                if (i == 1) {
                    BleGatewayActivity.this.closeBleSwitch();
                } else if (i == 4) {
                    BleGatewayActivity.this.gotoXiaoAiSpeakerApp();
                }
            }
        };
        O000000o2.show(getSupportFragmentManager(), (String) null);
    }

    public void gotoXiaoAiSpeakerApp() {
        try {
            if (checkApkExist(getApplicationContext(), "com.xiaomi.mico")) {
                String format = String.format("mico://homepage/main?uid=%s", fcn.O000000o().O00000Oo());
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setPackage("com.xiaomi.mico");
                intent.setData(Uri.parse(format));
                startActivity(intent);
                return;
            }
            showMeshDialog(2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean checkApkExist(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            context.getPackageManager().getApplicationInfo(str, 8192);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    private void O000000o() {
        if (this.mLoadingDialog == null) {
            this.mLoadingDialog = new XQProgressDialog(this);
            this.mLoadingDialog.setMessage(getString(R.string.mj_loading));
            this.mLoadingDialog.setCancelable(true);
        }
        this.mLoadingDialog.show();
    }

    public void dismissLoadingDialog() {
        if (this.mLoadingDialog != null) {
            getWindow().getDecorView().postDelayed(new Runnable() {
                /* class com.xiaomi.smarthome.miio.activity.BleGatewayActivity.AnonymousClass11 */

                public final void run() {
                    if (BleGatewayActivity.this.mLoadingDialog != null) {
                        BleGatewayActivity.this.mLoadingDialog.dismiss();
                    }
                }
            }, 200);
        }
    }

    public void getBleSwitchState() {
        XmPluginHostApi.instance().callMethod(this.mGatewayDevice.did, "bt_gateway_status", new Object[0], new Callback<JSONObject>() {
            /* class com.xiaomi.smarthome.miio.activity.BleGatewayActivity.AnonymousClass12 */

            public final /* synthetic */ void onSuccess(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                if (jSONObject != null) {
                    LogType logType = LogType.GENERAL;
                    gsy.O00000o0(logType, "BleGatewayActivity", "getBleSwitchState：bt_gateway_status： onSuccess: " + jSONObject.toString());
                    if (TextUtils.equals("enable", jSONObject.optString("gateway_status"))) {
                        BleGatewayActivity.this.mBleSwitchBtn.setChecked(true);
                        hzf.O000000o((CompoundButton) BleGatewayActivity.this.mBleSwitchBtn);
                    }
                    BleGatewayActivity.this.showDeviceListLayer();
                }
            }

            public final void onFailure(int i, String str) {
                LogType logType = LogType.GENERAL;
                gsy.O00000o0(logType, "BleGatewayActivity", "getBleSwitchState：bt_gateway_status： onFailure: " + i + " " + str);
                izb.O000000o(BleGatewayActivity.this.getApplicationContext(), (int) R.string.ble_mesh_switch_state_failed, 0).show();
            }
        }, Parser.DEFAULT_PARSER);
    }

    public void openBleSwitch() {
        O000000o();
        XmPluginHostApi.instance().callMethod(this.mGatewayDevice.did, "bt_gateway_enable", new Object[0], new Callback<JSONObject>() {
            /* class com.xiaomi.smarthome.miio.activity.BleGatewayActivity.AnonymousClass13 */

            public final /* synthetic */ void onSuccess(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                BleGatewayActivity.this.dismissLoadingDialog();
                if (jSONObject != null) {
                    LogType logType = LogType.GENERAL;
                    gsy.O00000o0(logType, "BleGatewayActivity", "openBleSwitch ：bt_gateway_enable： onSuccess: " + jSONObject.toString());
                }
                BleGatewayActivity.this.mBleSwitchBtn.setChecked(true);
                hzf.O000000o((CompoundButton) BleGatewayActivity.this.mBleSwitchBtn);
                BleGatewayActivity.this.showDeviceListLayer();
                BleGatewayActivity.this.loadData();
            }

            public final void onFailure(int i, String str) {
                LogType logType = LogType.GENERAL;
                gsy.O00000o0(logType, "BleGatewayActivity", "openBleSwitch ：bt_gateway_enable：onFailure: " + i + " " + str);
                BleGatewayActivity.this.dismissLoadingDialog();
                izb.O000000o(BleGatewayActivity.this.getApplicationContext(), (int) R.string.ble_mesh_toast_failed, 0).show();
            }
        }, Parser.DEFAULT_PARSER);
    }

    public void closeBleSwitch() {
        O000000o();
        XmPluginHostApi.instance().callMethod(this.mGatewayDevice.did, "bt_gateway_disable", new Object[0], new Callback<JSONObject>() {
            /* class com.xiaomi.smarthome.miio.activity.BleGatewayActivity.AnonymousClass14 */

            public final /* synthetic */ void onSuccess(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                BleGatewayActivity.this.dismissLoadingDialog();
                if (jSONObject != null) {
                    LogType logType = LogType.GENERAL;
                    gsy.O00000o0(logType, "BleGatewayActivity", "getBleSwitchState：bt_gateway_disable： onSuccess: " + jSONObject.toString());
                }
                BleGatewayActivity.this.mBleSwitchBtn.setChecked(false);
                hzf.O000000o((CompoundButton) BleGatewayActivity.this.mBleSwitchBtn);
                BleGatewayActivity.this.showDeviceListLayer();
            }

            public final void onFailure(int i, String str) {
                LogType logType = LogType.GENERAL;
                gsy.O00000o0(logType, "BleGatewayActivity", "getBleSwitchState：bt_gateway_disable： onFailure: " + i + " " + str);
                BleGatewayActivity.this.dismissLoadingDialog();
                izb.O000000o(BleGatewayActivity.this.getApplicationContext(), (int) R.string.ble_mesh_toast_failed, 0).show();
            }
        }, Parser.DEFAULT_PARSER);
    }

    public void showRefreshLoading() {
        this.mRefreshProgress.setVisibility(0);
        ObjectAnimator objectAnimator = this.O00000o;
        if (objectAnimator == null || !objectAnimator.isRunning()) {
            this.O00000o = ObjectAnimator.ofFloat(this.mRefreshProgress, "rotation", 0.0f, 3600.0f);
            this.O00000o.setDuration(10000L);
            this.O00000o.setInterpolator(new LinearInterpolator());
            this.O00000o.setRepeatCount(-1);
            this.O00000o.start();
        }
    }

    public void finishRefreshLoading() {
        this.mRefreshProgress.setVisibility(8);
        ObjectAnimator objectAnimator = this.O00000o;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.O00000o.end();
        }
    }

    public void makeData(List<BleGatewayManager.BleGatewayItem> list) {
        this.f9591O000000o.clear();
        this.O00000Oo.clear();
        if (list != null) {
            for (BleGatewayManager.BleGatewayItem next : list) {
                Device O000000o2 = fno.O000000o().O000000o(next.f7098O000000o);
                if (O000000o2 != null) {
                    O000000o2.rssi = next.O00000Oo;
                    if (!this.O00000o0 || !(O000000o2.pid == Device.PID_BLE_MESH || O000000o2.pid == Device.PID_VIRTUAL_GROUP)) {
                        this.O00000Oo.add(O000000o2);
                    } else {
                        this.f9591O000000o.add(O000000o2);
                    }
                }
            }
            if (this.f9591O000000o.size() > 1) {
                O000000o(this.f9591O000000o);
            }
            if (this.O00000Oo.size() > 1) {
                O000000o(this.O00000Oo);
            }
        }
        if (this.f9591O000000o.size() > 0 || this.O00000Oo.size() > 0) {
            this.mShowDevices.clear();
            if (this.f9591O000000o.size() > 0) {
                Device device = new Device();
                device.name = getResources().getString(R.string.gateway_controllable_device);
                this.mShowDevices.add(device);
                this.mShowDevices.addAll(this.f9591O000000o);
            }
            if (this.O00000Oo.size() > 0) {
                Device device2 = new Device();
                device2.name = getResources().getString(R.string.gateway_viewable_device);
                this.mShowDevices.add(device2);
                this.mShowDevices.addAll(this.O00000Oo);
            }
            if (this.O00000o0) {
                Device device3 = new Device();
                device3.model = "last_empty_model";
                this.mShowDevices.add(device3);
            }
            this.mNestedScrollView.setCanScrollUp(true);
            this.mEmptyViewContainer.setVisibility(8);
            this.mListCardView.setVisibility(0);
            this.mRecyclerView.setVisibility(0);
            this.mBleAdapter.notifyDataSetChanged();
            DeviceApi.getInstance().updateDeviceDesc(this, this.mShowDevices, new fsm<List<Device>, fso>() {
                /* class com.xiaomi.smarthome.miio.activity.BleGatewayActivity.AnonymousClass5 */

                public final void onFailure(fso fso) {
                }

                public final /* synthetic */ void onSuccess(Object obj) {
                    BleGatewayActivity.this.mBleAdapter.notifyDataSetChanged();
                }
            });
            return;
        }
        this.mNestedScrollView.setCanScrollUp(false);
        this.mEmptyViewContainer.setVisibility(0);
        this.mListCardView.setVisibility(8);
        this.mRecyclerView.setVisibility(8);
    }

    private void O000000o(List<Device> list) {
        Collections.sort(list, new Comparator<Device>() {
            /* class com.xiaomi.smarthome.miio.activity.BleGatewayActivity.AnonymousClass6 */

            public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                return ((Device) obj2).rssi - ((Device) obj).rssi;
            }
        });
    }

    class O00000Oo extends RecyclerView.O000000o<RecyclerView.O000OOo0> {

        /* renamed from: O000000o  reason: collision with root package name */
        int f9610O000000o;
        int O00000Oo;
        int O00000o0;

        private O00000Oo() {
            this.f9610O000000o = 1;
            this.O00000Oo = 2;
            this.O00000o0 = 3;
        }

        /* synthetic */ O00000Oo(BleGatewayActivity bleGatewayActivity, byte b) {
            this();
        }

        public final int getItemCount() {
            return BleGatewayActivity.this.mShowDevices.size();
        }

        public final int getItemViewType(int i) {
            if (BleGatewayActivity.this.mShowDevices.get(i).model == null) {
                return this.f9610O000000o;
            }
            if (TextUtils.equals(BleGatewayActivity.this.mShowDevices.get(i).model, "last_empty_model")) {
                return this.O00000o0;
            }
            return this.O00000Oo;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public final RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
            if (i == this.O00000Oo) {
                return new O000000o(LayoutInflater.from(BleGatewayActivity.this).inflate((int) R.layout.ble_gateway_item, viewGroup, false));
            }
            if (i == this.O00000o0) {
                return new O000000o(LayoutInflater.from(BleGatewayActivity.this).inflate((int) R.layout.ble_gateway_empty_item, viewGroup, false));
            }
            return new O00000o0(LayoutInflater.from(BleGatewayActivity.this).inflate((int) R.layout.common_list_title, viewGroup, false));
        }

        public final void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
            String str;
            Device device = BleGatewayActivity.this.mShowDevices.get(i);
            int itemViewType = getItemViewType(i);
            if (itemViewType == this.f9610O000000o) {
                ((O00000o0) o000OOo0).f9611O000000o.setText(BleGatewayActivity.this.mShowDevices.get(i).name);
            } else if (itemViewType != this.O00000o0) {
                O000000o o000000o = (O000000o) o000OOo0;
                DeviceFactory.O000000o(device.model, o000000o.f9609O000000o, (int) R.drawable.device_list_phone_no);
                o000000o.O00000Oo.setText(BleGatewayActivity.this.mShowDevices.get(i).name);
                o000000o.O00000o.setImageLevel(BleGatewayActivity.this.mShowDevices.get(i).rssi);
                if (device.rssi >= -50) {
                    o000000o.O00000o.setImageResource(R.drawable.defaule_icon_ble_05);
                } else if (device.rssi >= -70) {
                    o000000o.O00000o.setImageResource(R.drawable.defaule_icon_ble_04);
                } else if (device.rssi >= -80) {
                    o000000o.O00000o.setImageResource(R.drawable.defaule_icon_ble_03);
                } else if (device.rssi >= -90) {
                    o000000o.O00000o.setImageResource(R.drawable.defaule_icon_ble_02);
                } else if (device.rssi >= -100) {
                    o000000o.O00000o.setImageResource(R.drawable.defaule_icon_ble_01);
                } else {
                    o000000o.O00000o.setImageResource(R.drawable.defaule_icon_ble_00);
                }
                int i2 = 0;
                if ((device.pid == Device.PID_BLE_MESH || device.pid == Device.PID_VIRTUAL_GROUP) && !device.isOnline) {
                    o000000o.O00000o0.setText((int) R.string.list_device_offline);
                } else {
                    ArrayList<Pair> deviceRenderData = faw.O00000o0().getDeviceRenderData(device, faw.O00000o0().getGridCard(device));
                    if (deviceRenderData == null || deviceRenderData.size() <= 0) {
                        str = "";
                    } else {
                        StringBuilder sb = new StringBuilder();
                        for (int i3 = 0; i3 < deviceRenderData.size(); i3++) {
                            Pair pair = deviceRenderData.get(i3);
                            if (pair != null && (pair.first instanceof String) && (pair.second instanceof String)) {
                                if (TextUtils.isEmpty((String) pair.first)) {
                                    sb.append(pair.second);
                                    sb.append(" ");
                                } else {
                                    sb.append(pair.first);
                                    sb.append(" ");
                                    sb.append(pair.second);
                                    sb.append(" ");
                                }
                            }
                        }
                        str = sb.toString().trim();
                    }
                    if (!TextUtils.isEmpty(str)) {
                        o000000o.O00000o0.setText(str);
                    } else if (device.pid == Device.PID_BLE_MESH || device.pid == Device.PID_VIRTUAL_GROUP) {
                        o000000o.O00000o0.setText((int) R.string.list_device_online);
                    } else {
                        o000000o.O00000o0.setText((int) R.string.miio_ble_gateway_default_subtitle);
                    }
                }
                boolean z = true;
                if (i != getItemCount() - 1) {
                    z = false;
                }
                ViewGroup.LayoutParams layoutParams = o000000o.O00000oO.getLayoutParams();
                if (layoutParams != null) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    if (!z) {
                        i2 = gpc.O000000o(24.0f);
                    }
                    marginLayoutParams.leftMargin = i2;
                }
            }
        }
    }

    static class O000000o extends RecyclerView.O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        SimpleDraweeView f9609O000000o;
        TextView O00000Oo;
        ImageView O00000o;
        TextView O00000o0;
        View O00000oO;
        View O00000oo;

        O000000o(View view) {
            super(view);
            this.f9609O000000o = (SimpleDraweeView) view.findViewById(R.id.image);
            this.O00000Oo = (TextView) view.findViewById(R.id.name);
            this.O00000o0 = (TextView) view.findViewById(R.id.status);
            this.O00000o = (ImageView) view.findViewById(R.id.signal_strength);
            this.O00000oO = view.findViewById(R.id.divider);
            this.O00000oo = view.findViewById(R.id.item_root);
        }
    }

    static class O00000o0 extends RecyclerView.O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        TextView f9611O000000o;

        O00000o0(View view) {
            super(view);
            this.f9611O000000o = (TextView) view.findViewById(R.id.title);
        }
    }

    public void loadData() {
        if (!this.isLoadingData && this.mGatewayDevice != null) {
            this.isLoadingData = true;
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.mGatewayDevice.did);
            BleGatewayManager.O000000o(arrayList, new BleGatewayManager.O00000Oo() {
                /* class com.xiaomi.smarthome.miio.activity.BleGatewayActivity.AnonymousClass7 */

                public final void O000000o(List<BleGatewayManager.O000000o> list) {
                    if (!BleGatewayActivity.this.isFinishing()) {
                        BleGatewayActivity bleGatewayActivity = BleGatewayActivity.this;
                        bleGatewayActivity.isLoadingData = false;
                        bleGatewayActivity.finishRefreshLoading();
                        BleGatewayActivity.this.mNestedScrollView.O00000Oo = false;
                        if (list == null || list.size() <= 0) {
                            BleGatewayActivity.this.mNestedScrollView.setCanScrollUp(false);
                            BleGatewayActivity.this.mEmptyViewContainer.setVisibility(0);
                            BleGatewayActivity.this.mListCardView.setVisibility(8);
                            BleGatewayActivity.this.mRecyclerView.setVisibility(8);
                            return;
                        }
                        BleGatewayActivity.this.makeData(list.get(0).O00000Oo);
                    }
                }
            });
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.mHeadAnimImage.setImageResource(R.drawable.ble_gateway_head);
        ((AnimationDrawable) this.mHeadAnimImage.getDrawable()).stop();
        finishRefreshLoading();
        this.mNestedScrollView.O00000Oo = false;
    }
}

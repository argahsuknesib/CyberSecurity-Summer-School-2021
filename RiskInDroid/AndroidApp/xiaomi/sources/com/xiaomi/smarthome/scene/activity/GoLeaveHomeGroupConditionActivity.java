package com.xiaomi.smarthome.scene.activity;

import _m_j.fbs;
import _m_j.fbt;
import _m_j.fno;
import _m_j.gog;
import _m_j.gqd;
import _m_j.hod;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.device.api.RecommendSceneItem;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.widget.SwitchButton;
import com.xiaomi.smarthome.scene.activity.SceneItemChooseFragment;
import com.xiaomi.smarthome.scene.api.SceneApi;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GoLeaveHomeGroupConditionActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    O000000o f10669O000000o;
    private ListView O00000Oo;
    private View O00000o;
    private View O00000o0;
    private View O00000oO;
    private boolean O00000oo;
    public SceneApi.O000000o mBodySensorCondition;
    public List<Device> mBodySensorDevice = new ArrayList();
    public SceneApi.O000000o mCameraCondition;
    public List<Device> mCameraDevice = new ArrayList();
    public SceneApi.O000000o mPhoneCondition;
    public RecommendSceneItem mRecommendScene;
    public SceneApi.O000000o mRouterCondition;
    public List<Device> mRouterDevice = new ArrayList();
    public SceneApi.O000OOOo mScene;
    public View phoneDeviceView;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.come_leave_home_group_condition_layout);
        boolean z = true;
        this.O00000oo = getIntent().getBooleanExtra("go_home_recommend_flag", true);
        this.mScene = SceneDataCache.INSTANCE.getCahcedScene();
        if (this.O00000oo) {
            hod.O0000OoO();
            this.mRecommendScene = null;
        } else {
            hod.O0000OoO();
            this.mRecommendScene = null;
        }
        this.mBodySensorDevice.clear();
        this.mCameraDevice.clear();
        this.mRouterDevice.clear();
        for (Map.Entry<String, Device> value : fno.O000000o().O0000O0o().entrySet()) {
            Device device = (Device) value.getValue();
            if (!device.isSubDevice()) {
                if (DeviceFactory.O0000O0o("yunyi.camera.v1", device.model)) {
                    this.mCameraDevice.add(device);
                }
                if (DeviceFactory.O0000O0o("xiaomi.router.", device.model)) {
                    this.mRouterDevice.add(device);
                }
            }
        }
        for (Map.Entry<String, Device> value2 : fno.O000000o().O00000Oo().entrySet()) {
            Device device2 = (Device) value2.getValue();
            if (device2.isSubDevice() && DeviceFactory.O0000O0o("lumi.sensor_motion.v1", device2.model)) {
                this.mBodySensorDevice.add(device2);
            }
        }
        SceneApi.O000OOOo o000OOOo = this.mScene;
        if (!(o000OOOo == null || o000OOOo.O0000oo0 == null || this.mScene.O0000oo0.O00000oO == null)) {
            for (SceneApi.O000000o next : this.mScene.O0000oo0.O00000oO) {
                if (next.O00000o0 != null) {
                    if (DeviceFactory.O0000O0o("lumi.sensor_motion.v1", next.O00000o0.O00000o)) {
                        this.mBodySensorCondition = next;
                    } else if (DeviceFactory.O0000O0o("yunyi.camera.v1", next.O00000o0.O00000o)) {
                        this.mCameraCondition = next;
                    } else if (DeviceFactory.O0000O0o("xiaomi.router.", next.O00000o0.O00000o)) {
                        this.mRouterCondition = next;
                    }
                }
                if (next.O00000o != null) {
                    this.mPhoneCondition = next;
                }
            }
        }
        View findViewById = findViewById(R.id.module_a_3_return_btn);
        if (findViewById != null) {
            findViewById.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.scene.activity.GoLeaveHomeGroupConditionActivity.AnonymousClass1 */

                public final void onClick(View view) {
                    GoLeaveHomeGroupConditionActivity.this.setResult();
                    GoLeaveHomeGroupConditionActivity.this.finish();
                }
            });
        }
        TextView textView = (TextView) findViewById(R.id.module_a_3_return_title);
        TextView textView2 = (TextView) findViewById(R.id.condition_title);
        if (this.O00000oo) {
            textView2.setText((int) R.string.scene_any_condition_satified);
            textView.setText((int) R.string.scene2_device_group_condition_come);
        } else {
            textView2.setText((int) R.string.scene_all_condition_satified);
            textView.setText((int) R.string.scene2_device_group_condition_leave);
        }
        this.O00000Oo = (ListView) findViewById(R.id.content_list_view);
        this.phoneDeviceView = O00000Oo();
        View view = this.phoneDeviceView;
        if (view != null) {
            O00000Oo o00000Oo = (O00000Oo) view.getTag();
            o00000Oo.O00000Oo.setImageURI(gqd.O000000o((int) R.drawable.device_list_phone));
            o00000Oo.O00000o.setText((int) R.string.phone);
            o00000Oo.O00000o0.setVisibility(0);
            if (this.O00000oo) {
                o00000Oo.O00000oO.setText((int) R.string.phone_connect_wifi);
            } else {
                o00000Oo.O00000oO.setText((int) R.string.phone_disconnect_wifi);
            }
            SwitchButton switchButton = o00000Oo.O00000o0;
            SceneApi.O000000o o000000o = this.mPhoneCondition;
            switchButton.setChecked(o000000o != null && o000000o.O0000o00);
            o00000Oo.f10689O000000o.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.scene.activity.GoLeaveHomeGroupConditionActivity.AnonymousClass4 */

                public final void onClick(View view) {
                    if (GoLeaveHomeGroupConditionActivity.this.mPhoneCondition == null) {
                        GoLeaveHomeGroupConditionActivity.this.mPhoneCondition = HomeSceneFactory.INSTANCE.createPhoneCondition(GoLeaveHomeGroupConditionActivity.this.mRecommendScene);
                        GoLeaveHomeGroupConditionActivity.this.mScene.O0000oo0.O00000oO.add(GoLeaveHomeGroupConditionActivity.this.mPhoneCondition);
                        O00000Oo o00000Oo = (O00000Oo) GoLeaveHomeGroupConditionActivity.this.phoneDeviceView.getTag();
                        o00000Oo.O00000o0.setEnabled(false);
                        o00000Oo.O00000o0.setChecked(true);
                        o00000Oo.O00000o0.setEnabled(true);
                    }
                    fbt fbt = new fbt(GoLeaveHomeGroupConditionActivity.this.getContext(), "HomeLogWifiSetting");
                    fbt.O000000o(12291);
                    fbs.O000000o(fbt);
                }
            });
            o00000Oo.O00000o0.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                /* class com.xiaomi.smarthome.scene.activity.GoLeaveHomeGroupConditionActivity.AnonymousClass5 */

                public final void onCheckedChanged(final CompoundButton compoundButton, boolean z) {
                    if (compoundButton.isEnabled()) {
                        compoundButton.setEnabled(false);
                        if (GoLeaveHomeGroupConditionActivity.this.mPhoneCondition == null) {
                            GoLeaveHomeGroupConditionActivity.this.mPhoneCondition = HomeSceneFactory.INSTANCE.createPhoneCondition(GoLeaveHomeGroupConditionActivity.this.mRecommendScene);
                            GoLeaveHomeGroupConditionActivity.this.mScene.O0000oo0.O00000oO.add(GoLeaveHomeGroupConditionActivity.this.mPhoneCondition);
                        }
                        GoLeaveHomeGroupConditionActivity.this.mPhoneCondition.O0000o00 = z;
                        GoLeaveHomeGroupConditionActivity.this.mHandler.postDelayed(new Runnable() {
                            /* class com.xiaomi.smarthome.scene.activity.GoLeaveHomeGroupConditionActivity.AnonymousClass5.AnonymousClass1 */

                            public final void run() {
                                compoundButton.setEnabled(true);
                            }
                        }, 400);
                    }
                }
            });
            this.O00000Oo.addHeaderView(this.phoneDeviceView);
        }
        if (this.O00000oo) {
            this.O00000o0 = O00000Oo();
            View view2 = this.O00000o0;
            if (view2 != null) {
                O00000Oo o00000Oo2 = (O00000Oo) view2.getTag();
                o00000Oo2.O00000Oo.setImageURI(gqd.O000000o((int) R.drawable.kuailian_router_icon));
                o00000Oo2.O00000o.setText((int) R.string.mi_router);
                o00000Oo2.O00000o0.setVisibility(0);
                if (this.O00000oo) {
                    o00000Oo2.O00000oO.setText((int) R.string.mi_router_connect_device);
                } else {
                    o00000Oo2.O00000oO.setText((int) R.string.mi_router_disconnect_device);
                }
                SwitchButton switchButton2 = o00000Oo2.O00000o0;
                SceneApi.O000000o o000000o2 = this.mRouterCondition;
                switchButton2.setChecked(o000000o2 != null && o000000o2.O0000o00);
                o00000Oo2.f10689O000000o.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.scene.activity.GoLeaveHomeGroupConditionActivity.AnonymousClass6 */

                    public final void onClick(View view) {
                        if (GoLeaveHomeGroupConditionActivity.this.mRouterDevice.isEmpty()) {
                            GoLeaveHomeGroupConditionActivity.this.O000000o();
                            return;
                        }
                        Intent intent = new Intent(GoLeaveHomeGroupConditionActivity.this.getContext(), MiRouterChooseActivity.class);
                        if (!(GoLeaveHomeGroupConditionActivity.this.mRouterCondition == null || GoLeaveHomeGroupConditionActivity.this.mRouterCondition.O00000o0 == null)) {
                            intent.putExtra("extra_did", GoLeaveHomeGroupConditionActivity.this.mRouterCondition.O00000o0.f11122O000000o);
                        }
                        GoLeaveHomeGroupConditionActivity.this.startActivityForResult(intent, 12289);
                    }
                });
                o00000Oo2.O00000o0.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    /* class com.xiaomi.smarthome.scene.activity.GoLeaveHomeGroupConditionActivity.AnonymousClass7 */

                    public final void onCheckedChanged(final CompoundButton compoundButton, boolean z) {
                        if (compoundButton.isEnabled()) {
                            compoundButton.setEnabled(false);
                            if (GoLeaveHomeGroupConditionActivity.this.mRouterDevice.isEmpty()) {
                                GoLeaveHomeGroupConditionActivity.this.mHandler.post(new Runnable() {
                                    /* class com.xiaomi.smarthome.scene.activity.GoLeaveHomeGroupConditionActivity.AnonymousClass7.AnonymousClass1 */

                                    public final void run() {
                                        compoundButton.setChecked(false);
                                    }
                                });
                                GoLeaveHomeGroupConditionActivity.this.O000000o();
                            } else if (GoLeaveHomeGroupConditionActivity.this.mRouterCondition == null) {
                                GoLeaveHomeGroupConditionActivity.this.startActivityForResult(new Intent(GoLeaveHomeGroupConditionActivity.this.getContext(), MiRouterChooseActivity.class), 12289);
                            } else {
                                GoLeaveHomeGroupConditionActivity.this.mRouterCondition.O0000o00 = z;
                            }
                            GoLeaveHomeGroupConditionActivity.this.mHandler.postDelayed(new Runnable() {
                                /* class com.xiaomi.smarthome.scene.activity.GoLeaveHomeGroupConditionActivity.AnonymousClass7.AnonymousClass2 */

                                public final void run() {
                                    compoundButton.setEnabled(true);
                                }
                            }, 400);
                        }
                    }
                });
                this.O00000Oo.addHeaderView(this.O00000o0);
            }
        }
        this.O00000o = O00000Oo();
        View view3 = this.O00000o;
        if (view3 != null) {
            O00000Oo o00000Oo3 = (O00000Oo) view3.getTag();
            Device O0000o0O = DeviceFactory.O0000o0O("lumi.sensor_motion.v1");
            o00000Oo3.O00000o.setText((int) R.string.gateway_motion_name);
            o00000Oo3.O00000o0.setVisibility(0);
            if (this.O00000oo) {
                o00000Oo3.O00000oO.setText((int) R.string.body_sensor_motion);
            } else {
                o00000Oo3.O00000oO.setText((int) R.string.body_sensor_no_motion);
            }
            if (O0000o0O != null) {
                DeviceFactory.O00000o0(O0000o0O.model, o00000Oo3.O00000Oo);
            }
            SwitchButton switchButton3 = o00000Oo3.O00000o0;
            SceneApi.O000000o o000000o3 = this.mBodySensorCondition;
            switchButton3.setChecked(o000000o3 != null && o000000o3.O0000o00);
            o00000Oo3.f10689O000000o.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.scene.activity.GoLeaveHomeGroupConditionActivity.AnonymousClass8 */

                public final void onClick(View view) {
                    if (!GoLeaveHomeGroupConditionActivity.this.mBodySensorDevice.isEmpty() || GoLeaveHomeGroupConditionActivity.this.mBodySensorCondition != null) {
                        Intent intent = new Intent(GoLeaveHomeGroupConditionActivity.this.getContext(), BodySensorChooseActivity.class);
                        if (GoLeaveHomeGroupConditionActivity.this.mBodySensorCondition != null) {
                            intent.putExtra("extra_did", GoLeaveHomeGroupConditionActivity.this.mBodySensorCondition.O00000o0.f11122O000000o);
                        }
                        GoLeaveHomeGroupConditionActivity.this.startActivityForResult(intent, 12288);
                        return;
                    }
                    GoLeaveHomeGroupConditionActivity.this.O000000o();
                }
            });
            o00000Oo3.O00000o0.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                /* class com.xiaomi.smarthome.scene.activity.GoLeaveHomeGroupConditionActivity.AnonymousClass9 */

                public final void onCheckedChanged(final CompoundButton compoundButton, boolean z) {
                    if (compoundButton.isEnabled()) {
                        compoundButton.setEnabled(false);
                        if (GoLeaveHomeGroupConditionActivity.this.mBodySensorDevice.isEmpty()) {
                            GoLeaveHomeGroupConditionActivity.this.mHandler.post(new Runnable() {
                                /* class com.xiaomi.smarthome.scene.activity.GoLeaveHomeGroupConditionActivity.AnonymousClass9.AnonymousClass1 */

                                public final void run() {
                                    compoundButton.setChecked(false);
                                }
                            });
                            GoLeaveHomeGroupConditionActivity.this.O000000o();
                        } else if (GoLeaveHomeGroupConditionActivity.this.mBodySensorCondition == null) {
                            GoLeaveHomeGroupConditionActivity.this.startActivityForResult(new Intent(GoLeaveHomeGroupConditionActivity.this.getContext(), BodySensorChooseActivity.class), 12288);
                        } else {
                            GoLeaveHomeGroupConditionActivity.this.mBodySensorCondition.O0000o00 = z;
                        }
                        GoLeaveHomeGroupConditionActivity.this.mHandler.postDelayed(new Runnable() {
                            /* class com.xiaomi.smarthome.scene.activity.GoLeaveHomeGroupConditionActivity.AnonymousClass9.AnonymousClass2 */

                            public final void run() {
                                compoundButton.setEnabled(true);
                            }
                        }, 400);
                    }
                }
            });
        }
        if (this.O00000oo) {
            this.O00000oO = O00000Oo();
            View view4 = this.O00000oO;
            if (view4 != null) {
                O00000Oo o00000Oo4 = (O00000Oo) view4.getTag();
                o00000Oo4.O00000o.setText((int) R.string.mi_camera);
                o00000Oo4.O00000o0.setVisibility(0);
                if (this.O00000oo) {
                    o00000Oo4.O00000oO.setText((int) R.string.mi_camera_change);
                } else {
                    o00000Oo4.O00000oO.setText((int) R.string.mi_camera_no_change);
                }
                Device O0000o0O2 = DeviceFactory.O0000o0O("yunyi.camera.v1");
                if (O0000o0O2 != null) {
                    DeviceFactory.O00000Oo(O0000o0O2.model, o00000Oo4.O00000Oo);
                }
                SwitchButton switchButton4 = o00000Oo4.O00000o0;
                SceneApi.O000000o o000000o4 = this.mCameraCondition;
                if (o000000o4 == null || !o000000o4.O0000o00) {
                    z = false;
                }
                switchButton4.setChecked(z);
                o00000Oo4.f10689O000000o.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.scene.activity.GoLeaveHomeGroupConditionActivity.AnonymousClass10 */

                    public final void onClick(View view) {
                        if (GoLeaveHomeGroupConditionActivity.this.mCameraDevice.isEmpty()) {
                            GoLeaveHomeGroupConditionActivity.this.O000000o();
                            return;
                        }
                        Intent intent = new Intent(GoLeaveHomeGroupConditionActivity.this.getContext(), CameraChooseActivity.class);
                        if (!(GoLeaveHomeGroupConditionActivity.this.mCameraCondition == null || GoLeaveHomeGroupConditionActivity.this.mCameraCondition.O00000o0 == null)) {
                            intent.putExtra("extra_did", GoLeaveHomeGroupConditionActivity.this.mCameraCondition.O00000o0.f11122O000000o);
                        }
                        GoLeaveHomeGroupConditionActivity.this.startActivityForResult(intent, 12290);
                    }
                });
                o00000Oo4.O00000o0.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    /* class com.xiaomi.smarthome.scene.activity.GoLeaveHomeGroupConditionActivity.AnonymousClass11 */

                    public final void onCheckedChanged(final CompoundButton compoundButton, boolean z) {
                        if (compoundButton.isEnabled()) {
                            compoundButton.setEnabled(false);
                            if (GoLeaveHomeGroupConditionActivity.this.mCameraDevice.isEmpty()) {
                                GoLeaveHomeGroupConditionActivity.this.mHandler.post(new Runnable() {
                                    /* class com.xiaomi.smarthome.scene.activity.GoLeaveHomeGroupConditionActivity.AnonymousClass11.AnonymousClass1 */

                                    public final void run() {
                                        compoundButton.setChecked(false);
                                    }
                                });
                                GoLeaveHomeGroupConditionActivity.this.O000000o();
                            } else if (GoLeaveHomeGroupConditionActivity.this.mCameraCondition == null) {
                                GoLeaveHomeGroupConditionActivity.this.startActivityForResult(new Intent(GoLeaveHomeGroupConditionActivity.this.getContext(), BodySensorChooseActivity.class), 12288);
                            } else {
                                GoLeaveHomeGroupConditionActivity.this.mCameraCondition.O0000o00 = z;
                            }
                            GoLeaveHomeGroupConditionActivity.this.mHandler.postDelayed(new Runnable() {
                                /* class com.xiaomi.smarthome.scene.activity.GoLeaveHomeGroupConditionActivity.AnonymousClass11.AnonymousClass2 */

                                public final void run() {
                                    compoundButton.setEnabled(true);
                                }
                            }, 400);
                        }
                    }
                });
            }
        }
        this.f10669O000000o = new O000000o();
        this.O00000Oo.setAdapter((ListAdapter) this.f10669O000000o);
    }

    public void setResult() {
        SceneDataCache.INSTANCE.setCachedScene(this.mScene);
        setResult(-1);
    }

    public void onPause() {
        super.onPause();
    }

    public void onBackPressed() {
        setResult();
        super.onBackPressed();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        SceneApi.O000000o createHomeDeviceCondition;
        if (i == 12288 || i == 12289 || i == 12290) {
            if (i2 == -1 && intent != null) {
                ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("item_choose_result");
                if (parcelableArrayListExtra.size() > 0 && (createHomeDeviceCondition = HomeSceneFactory.INSTANCE.createHomeDeviceCondition(fno.O000000o().O00000o0(((SceneItemChooseFragment.ItemData) parcelableArrayListExtra.get(0)).f10832O000000o), this.mRecommendScene)) != null) {
                    if (i == 12288) {
                        ((SceneApi.O00000o0) createHomeDeviceCondition.O00000o0).O0000Ooo = 120;
                        SceneApi.O000000o o000000o = this.mBodySensorCondition;
                        if (o000000o != null) {
                            createHomeDeviceCondition.O0000o00 = o000000o.O0000o00;
                        } else {
                            this.mScene.O0000oo0.O00000oO.add(createHomeDeviceCondition);
                        }
                        this.mBodySensorCondition = createHomeDeviceCondition;
                        O00000Oo o00000Oo = (O00000Oo) this.O00000o.getTag();
                        o00000Oo.O00000o0.setEnabled(false);
                        o00000Oo.O00000o0.setChecked(createHomeDeviceCondition.O0000o00);
                        o00000Oo.O00000o0.setEnabled(true);
                    } else if (i == 12290) {
                        SceneApi.O000000o o000000o2 = this.mCameraCondition;
                        if (o000000o2 != null) {
                            createHomeDeviceCondition.O0000o00 = o000000o2.O0000o00;
                        } else {
                            this.mScene.O0000oo0.O00000oO.add(createHomeDeviceCondition);
                        }
                        this.mCameraCondition = createHomeDeviceCondition;
                    } else {
                        String O00000o2 = gog.O00000o(getContext());
                        if (O00000o2 != null && !O00000o2.isEmpty()) {
                            ((SceneApi.O00000o0) createHomeDeviceCondition.O00000o0).O0000Ooo = O00000o2;
                            SceneApi.O000000o o000000o3 = this.mRouterCondition;
                            if (o000000o3 != null) {
                                createHomeDeviceCondition.O0000o00 = o000000o3.O0000o00;
                            } else {
                                this.mScene.O0000oo0.O00000oO.add(createHomeDeviceCondition);
                            }
                            this.mRouterCondition = createHomeDeviceCondition;
                            O00000Oo o00000Oo2 = (O00000Oo) this.O00000o0.getTag();
                            o00000Oo2.O00000o0.setEnabled(false);
                            o00000Oo2.O00000o0.setChecked(createHomeDeviceCondition.O0000o00);
                            o00000Oo2.O00000o0.setEnabled(true);
                        }
                    }
                }
            }
        } else if (i == 12291) {
            SceneApi.O000000o createPhoneCondition = HomeSceneFactory.INSTANCE.createPhoneCondition(this.mRecommendScene);
            SceneApi.O000000o o000000o4 = this.mPhoneCondition;
            if (o000000o4 != null) {
                createPhoneCondition.O0000o00 = o000000o4.O0000o00;
            } else {
                this.mScene.O0000oo0.O00000oO.add(createPhoneCondition);
            }
            this.mPhoneCondition = createPhoneCondition;
            O00000Oo o00000Oo3 = (O00000Oo) this.phoneDeviceView.getTag();
            o00000Oo3.O00000o0.setEnabled(false);
            o00000Oo3.O00000o0.setChecked(createPhoneCondition.O0000o00);
            o00000Oo3.O00000o0.setEnabled(true);
        }
    }

    /* access modifiers changed from: package-private */
    public final void O000000o() {
        new MLAlertDialog.Builder(this).O00000Oo((int) R.string.no_device_title).O000000o((int) R.string.go_to_buy, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.activity.GoLeaveHomeGroupConditionActivity.AnonymousClass3 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                GoLeaveHomeGroupConditionActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://m.mi.com")));
            }
        }).O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.activity.GoLeaveHomeGroupConditionActivity.AnonymousClass2 */

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        }).O00000oo();
    }

    class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        public View f10689O000000o;
        public SimpleDraweeView O00000Oo;
        public TextView O00000o;
        public SwitchButton O00000o0;
        public TextView O00000oO;
        public TextView O00000oo;
        public ImageView O0000O0o;
        public TextView O0000OOo;
        public TextView O0000Oo0;

        private O00000Oo() {
        }

        /* synthetic */ O00000Oo(GoLeaveHomeGroupConditionActivity goLeaveHomeGroupConditionActivity, byte b) {
            this();
        }
    }

    private View O00000Oo() {
        View inflate = getLayoutInflater().inflate((int) R.layout.scene_add_scene_condition_item, (ViewGroup) null);
        if (inflate != null) {
            O00000Oo o00000Oo = new O00000Oo(this, (byte) 0);
            o00000Oo.O00000Oo = (SimpleDraweeView) inflate.findViewById(R.id.icon);
            o00000Oo.O00000Oo.setHierarchy(new GenericDraweeHierarchyBuilder(o00000Oo.O00000Oo.getResources()).setFadeDuration(200).setPlaceholderImage(o00000Oo.O00000Oo.getResources().getDrawable(R.drawable.device_list_phone_no)).build());
            o00000Oo.f10689O000000o = inflate.findViewById(R.id.content_container);
            o00000Oo.O00000o0 = (SwitchButton) inflate.findViewById(R.id.item_enable);
            o00000Oo.O00000oo = (TextView) inflate.findViewById(R.id.add_timesp);
            o00000Oo.O00000oo.setVisibility(8);
            o00000Oo.O0000O0o = (ImageView) inflate.findViewById(R.id.set_time_btn);
            o00000Oo.O0000O0o.setVisibility(8);
            o00000Oo.O00000o = (TextView) inflate.findViewById(R.id.name);
            o00000Oo.O00000oO = (TextView) inflate.findViewById(R.id.key_name);
            o00000Oo.O0000OOo = (TextView) inflate.findViewById(R.id.offline);
            o00000Oo.O0000OOo.setVisibility(8);
            o00000Oo.O0000Oo0 = (TextView) inflate.findViewById(R.id.buy_button);
            o00000Oo.O0000Oo0.setVisibility(8);
            inflate.setTag(o00000Oo);
        }
        return inflate;
    }

    class O000000o extends BaseAdapter {
        public final int getCount() {
            return 0;
        }

        public final Object getItem(int i) {
            return null;
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            return null;
        }

        O000000o() {
        }
    }
}

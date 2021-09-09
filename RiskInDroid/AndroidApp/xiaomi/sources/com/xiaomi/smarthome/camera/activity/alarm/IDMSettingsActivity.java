package com.xiaomi.smarthome.camera.activity.alarm;

import _m_j.chr;
import _m_j.cki;
import _m_j.clf;
import _m_j.faw;
import _m_j.fnn;
import _m_j.fsm;
import _m_j.fso;
import _m_j.ggb;
import _m_j.gpc;
import _m_j.gpy;
import _m_j.gqg;
import _m_j.grv;
import _m_j.gsy;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.google.gson.Gson;
import com.mijia.widget.SettingsDeviceItem;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.camera.activity.CameraBaseActivity;
import com.xiaomi.smarthome.camera.v4.activity.CameraPlayerNewActivity;
import com.xiaomi.smarthome.camera.view.MutiSelectItemView;
import com.xiaomi.smarthome.camera.view.widget.SettingsItemView;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.device.utils.DeviceTagInterface;
import com.xiaomi.smarthome.homeroom.model.Room;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class IDMSettingsActivity extends CameraBaseActivity {
    public static final String TAG = "IDMSettingsActivity";
    private MLAlertDialog alertDialog;
    private String currentDid = "";
    public int currentEvent = 0;
    private View dialogView;
    public HashMap<String, IDMInfo> didHashMap = new HashMap<>();
    List<String> didViews = new ArrayList();
    List<String> dids = new ArrayList();
    public Gson gson = new Gson();
    private ScrollView has_tv_sl;
    IDMPairingInfo idmPairingInfo = new IDMPairingInfo();
    private LinearLayout idm_devices_view;
    private ImageView idm_icon;
    private String language;
    public XQProgressDialog mPD;
    private String md5Name;
    private boolean needChange = false;
    private LinearLayout no_tv_ll;
    private final String propKey = "prop.Idminfo";
    private LinearLayout setting_items_ll;
    private MutiSelectItemView settings_baby_cry_push;
    private MutiSelectItemView settings_baby_sleep_push;
    private SettingsItemView settings_idm_switch;
    private Button settings_idm_switch_first;
    private MutiSelectItemView settings_obj_motion_push;
    private MutiSelectItemView settings_people_motion_push;
    ImageView title_bar_more;
    ImageView title_bar_return;
    private boolean toSwitch = false;
    private List<SettingsDeviceItem> tvViews = new ArrayList();
    private TextView tv_device_idm_tips;

    static /* synthetic */ String lambda$onSubmit$2(String str) throws JSONException {
        return str;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gpy.O00000o0(android.content.Context, java.lang.String, java.lang.String, boolean):boolean
     arg types: [android.content.Context, java.lang.String, java.lang.String, int]
     candidates:
      _m_j.gpy.O00000o0(android.content.Context, java.lang.String, java.lang.String, java.lang.String):java.lang.String
      _m_j.gpy.O00000o0(android.content.Context, java.lang.String, java.lang.String, boolean):boolean */
    public void onCreate(Bundle bundle) {
        Locale locale;
        super.onCreate(bundle);
        setContentView((int) R.layout.camera_activity_setting_idm);
        this.md5Name = grv.O000000o(this.mCameraDevice.getModel() + this.mCameraDevice.getDid());
        this.language = getResources().getConfiguration().locale.getLanguage();
        if (gpy.O00000o0(CommonApplication.getAppContext(), "language_setting", "is_default", false)) {
            if (Build.VERSION.SDK_INT >= 24) {
                locale = Resources.getSystem().getConfiguration().getLocales().get(0);
            } else {
                locale = Locale.getDefault();
            }
            this.language = locale.getLanguage();
        }
        initView();
        initData();
    }

    public void getConfigs() {
        clf.O000000o().O00000Oo(this.mCameraDevice.getDid(), this.mCameraDevice.getModel(), new Callback<JSONObject>() {
            /* class com.xiaomi.smarthome.camera.activity.alarm.IDMSettingsActivity.AnonymousClass1 */

            public void onSuccess(JSONObject jSONObject) {
                cki.O000000o(IDMSettingsActivity.TAG, "getRangeExtraData=".concat(String.valueOf(jSONObject)));
                if (!IDMSettingsActivity.this.isFinishing()) {
                    IDMSettingsActivity.this.mPD.dismiss();
                    try {
                        IDMSettingsActivity.this.idmPairingInfo = (IDMPairingInfo) IDMSettingsActivity.this.gson.fromJson(jSONObject.toString(), IDMPairingInfo.class);
                        IDMSettingsActivity.this.currentEvent = Integer.parseInt(IDMSettingsActivity.this.idmPairingInfo.idm_eventType);
                    } catch (Exception e) {
                        cki.O00000oO(IDMSettingsActivity.TAG, e.toString());
                    }
                    IDMSettingsActivity.this.refreshUI();
                }
            }

            public void onFailure(int i, String str) {
                String str2 = IDMSettingsActivity.TAG;
                cki.O00000oO(str2, "getRangeExtraData onFailure=" + i + " " + str);
                if (!IDMSettingsActivity.this.isFinishing()) {
                    IDMSettingsActivity.this.mPD.dismiss();
                    IDMSettingsActivity.this.refreshUI();
                }
            }
        });
    }

    private void onCheckedChanged(boolean z, boolean z2) {
        try {
            IDMInfo iDMInfo = this.didHashMap.get(this.currentDid);
            cki.O000000o(TAG, "onCheckedChanged=".concat(String.valueOf(iDMInfo)));
            if ((iDMInfo != null || !z) && this.currentEvent != 0) {
                onSubmit(iDMInfo, z);
                return;
            }
            if (this.currentEvent == 0) {
                z = false;
            }
            String str = TAG;
            cki.O000000o(str, "currentEvent==" + this.currentEvent);
            if (z2) {
                gqg.O00000Oo((int) R.string.idm_empty_tv_device_tips);
                return;
            }
            if (this.alertDialog == null) {
                this.alertDialog = new MLAlertDialog.Builder(this).O000000o(this.dialogView).O00000o0().O00000o();
            }
            this.alertDialog.show();
            TextView textView = (TextView) this.dialogView.findViewById(R.id.alertTitle);
            textView.setSingleLine(false);
            textView.setLines(2);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setText((int) R.string.rec_scene_delete_msg);
            ((TextView) this.dialogView.findViewById(R.id.button1)).setText((int) R.string.save);
            this.dialogView.findViewById(R.id.button1).setOnClickListener(new View.OnClickListener(iDMInfo, z) {
                /* class com.xiaomi.smarthome.camera.activity.alarm.$$Lambda$IDMSettingsActivity$Zg1x60ZCPSAkziJFOnzx4wLDhXI */
                private final /* synthetic */ IDMInfo f$1;
                private final /* synthetic */ boolean f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void onClick(View view) {
                    IDMSettingsActivity.this.lambda$onCheckedChanged$0$IDMSettingsActivity(this.f$1, this.f$2, view);
                }
            });
            ((TextView) this.dialogView.findViewById(R.id.button2)).setText((int) R.string.rec_scene_cancel_finish);
            this.dialogView.findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.camera.activity.alarm.$$Lambda$IDMSettingsActivity$VXGUFutaLUi6e6E2f3XapyTDwWE */

                public final void onClick(View view) {
                    IDMSettingsActivity.this.lambda$onCheckedChanged$1$IDMSettingsActivity(view);
                }
            });
        } catch (Exception e) {
            cki.O00000oO(TAG, e.toString());
            gqg.O00000Oo(getString(R.string.action_fail));
            if (!z2) {
                super.onBackPressed();
            }
        }
    }

    public /* synthetic */ void lambda$onCheckedChanged$0$IDMSettingsActivity(IDMInfo iDMInfo, boolean z, View view) {
        this.alertDialog.dismiss();
        onSubmit(iDMInfo, z);
    }

    public /* synthetic */ void lambda$onCheckedChanged$1$IDMSettingsActivity(View view) {
        this.alertDialog.dismiss();
        super.onBackPressed();
    }

    private void onSubmit(IDMInfo iDMInfo, boolean z) {
        String str;
        try {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("idm_devDid", this.currentDid);
            jSONObject.put("idm_eventType", this.currentEvent);
            if (iDMInfo == null) {
                str = "";
            } else {
                str = iDMInfo.id_hash.trim();
            }
            jSONObject.put("idm_idHash", str);
            final int i = z ? 1 : 0;
            jSONObject.put("idm_switch", i);
            jSONArray.put(jSONObject);
            String str2 = TAG;
            cki.O00000o(str2, "_sync.set_idm_match_param =" + jSONArray.toString());
            this.mPD.show();
            this.mCameraDevice.callMethod("_sync.set_idm_match_param", jSONArray, new Callback<String>() {
                /* class com.xiaomi.smarthome.camera.activity.alarm.IDMSettingsActivity.AnonymousClass2 */

                public void onSuccess(String str) {
                    cki.O00000o(IDMSettingsActivity.TAG, "_sync.set_idm_match_param onSuccess=".concat(String.valueOf(str)));
                    IDMSettingsActivity.this.mPD.dismiss();
                    if (!IDMSettingsActivity.this.isFinishing()) {
                        try {
                            int i = 1;
                            if (new JSONObject(str).optInt("result", 0) == 1) {
                                chr.O000000o(chr.O00Oo0OO, "type", Integer.valueOf(IDMSettingsActivity.this.currentEvent));
                                String str2 = chr.O00Oo0;
                                if (i != 1) {
                                    i = 2;
                                }
                                chr.O000000o(str2, "type", Integer.valueOf(i));
                            } else {
                                gqg.O00000Oo(IDMSettingsActivity.this.getString(R.string.action_fail));
                            }
                        } catch (Exception e) {
                            cki.O00000oO(IDMSettingsActivity.TAG, e.toString());
                            gqg.O00000Oo(IDMSettingsActivity.this.getString(R.string.action_fail) + " exception=" + e.toString());
                        }
                        IDMSettingsActivity.this.refreshUI();
                        IDMSettingsActivity.super.onBackPressed();
                    }
                }

                public void onFailure(int i, String str) {
                    String str2 = IDMSettingsActivity.TAG;
                    cki.O00000o(str2, "_sync.set_idm_match_param onFailure=" + i + str);
                    IDMSettingsActivity.this.mPD.dismiss();
                    if (!IDMSettingsActivity.this.isFinishing()) {
                        gqg.O00000Oo(IDMSettingsActivity.this.getString(R.string.action_fail) + " error=" + i + " errorInfo=" + str);
                        IDMSettingsActivity.this.refreshUI();
                        IDMSettingsActivity.super.onBackPressed();
                    }
                }
            }, $$Lambda$IDMSettingsActivity$BsI5dt6_2zq7l7W5eKXBy3M5_g.INSTANCE);
        } catch (Exception e) {
            cki.O00000oO(TAG, e.toString());
            gqg.O00000Oo(getString(R.string.action_fail));
        }
    }

    private void initView() {
        this.dialogView = LayoutInflater.from(this).inflate((int) R.layout.scene_alert_dialog, (ViewGroup) null);
        this.idm_icon = (ImageView) findViewById(R.id.idm_icon);
        this.no_tv_ll = (LinearLayout) findViewById(R.id.no_tv_ll);
        this.has_tv_sl = (ScrollView) findViewById(R.id.has_tv_sl);
        this.title_bar_return = (ImageView) findViewById(R.id.title_bar_return);
        this.title_bar_return.setImageResource(R.drawable.title_cancel_selector);
        this.title_bar_return.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.alarm.$$Lambda$IDMSettingsActivity$z46SnMXDMDDd7ADEahH3wQeLJ7s */

            public final void onClick(View view) {
                IDMSettingsActivity.this.lambda$initView$3$IDMSettingsActivity(view);
            }
        });
        this.title_bar_more = (ImageView) findViewById(R.id.title_bar_more);
        this.title_bar_more.setVisibility(8);
        this.title_bar_more.setImageResource(R.drawable.mj_selector_rec_confirm);
        this.title_bar_more.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.alarm.$$Lambda$IDMSettingsActivity$P6ahu2P6a_YCCGOWrpogxrCB8s */

            public final void onClick(View view) {
                IDMSettingsActivity.this.lambda$initView$4$IDMSettingsActivity(view);
            }
        });
        this.tv_device_idm_tips = (TextView) findViewById(R.id.tv_device_idm_tips);
        this.settings_obj_motion_push = (MutiSelectItemView) findViewById(R.id.settings_obj_motion_push);
        this.settings_obj_motion_push.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.alarm.$$Lambda$IDMSettingsActivity$DDeXJ7fraWqMhNC9IZIpUiGaxzo */

            public final void onClick(View view) {
                IDMSettingsActivity.this.lambda$initView$5$IDMSettingsActivity(view);
            }
        });
        this.settings_people_motion_push = (MutiSelectItemView) findViewById(R.id.settings_people_motion_push);
        this.settings_people_motion_push.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.alarm.$$Lambda$IDMSettingsActivity$TlU4EuslK_o6sFScEsFV4wXZPhA */

            public final void onClick(View view) {
                IDMSettingsActivity.this.lambda$initView$6$IDMSettingsActivity(view);
            }
        });
        this.settings_baby_cry_push = (MutiSelectItemView) findViewById(R.id.settings_baby_cry_push);
        this.settings_baby_cry_push.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.alarm.$$Lambda$IDMSettingsActivity$raE9w3gSJkhJ0koA71CpUlGoUZQ */

            public final void onClick(View view) {
                IDMSettingsActivity.this.lambda$initView$7$IDMSettingsActivity(view);
            }
        });
        this.settings_baby_sleep_push = (MutiSelectItemView) findViewById(R.id.settings_baby_sleep_push);
        this.settings_baby_sleep_push.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.alarm.$$Lambda$IDMSettingsActivity$TAxiN5dZVJ69fYFFgpnlDJJ9TI */

            public final void onClick(View view) {
                IDMSettingsActivity.this.lambda$initView$8$IDMSettingsActivity(view);
            }
        });
        ((TextView) findViewById(R.id.title_bar_title)).setText((int) R.string.event_type_idm_cast_screen);
        this.idm_devices_view = (LinearLayout) findViewById(R.id.idm_devices_view);
        this.setting_items_ll = (LinearLayout) findViewById(R.id.setting_items_ll);
        this.settings_idm_switch_first = (Button) findViewById(R.id.settings_idm_switch_first);
        this.settings_idm_switch_first.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.alarm.$$Lambda$IDMSettingsActivity$FOrJMqMvYZ57DYYdBhCbTrQWRRM */

            public final void onClick(View view) {
                IDMSettingsActivity.this.lambda$initView$9$IDMSettingsActivity(view);
            }
        });
        this.settings_idm_switch = (SettingsItemView) findViewById(R.id.settings_idm_switch);
        this.settings_idm_switch.setIconSize(gpc.O000000o(40.0f), gpc.O000000o(40.0f));
        this.settings_idm_switch.setIconMargin(gpc.O000000o(25.0f), gpc.O000000o(20.0f));
        this.settings_idm_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.camera.activity.alarm.$$Lambda$IDMSettingsActivity$Xnu034IHcfKXdfw173x1CbNfYII */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                IDMSettingsActivity.this.lambda$initView$10$IDMSettingsActivity(compoundButton, z);
            }
        });
    }

    public /* synthetic */ void lambda$initView$3$IDMSettingsActivity(View view) {
        super.onBackPressed();
    }

    public /* synthetic */ void lambda$initView$4$IDMSettingsActivity(View view) {
        onBackPressed();
    }

    public /* synthetic */ void lambda$initView$5$IDMSettingsActivity(View view) {
        MutiSelectItemView mutiSelectItemView = this.settings_obj_motion_push;
        mutiSelectItemView.setSelect(!mutiSelectItemView.selectState);
        this.needChange = true;
        if (this.settings_obj_motion_push.selectState) {
            this.currentEvent |= 1;
        } else {
            this.currentEvent &= 14;
        }
        if (this.currentEvent == 0) {
            gqg.O00000Oo((int) R.string.idm_empty_tv_device_tips);
        }
        this.toSwitch = true;
    }

    public /* synthetic */ void lambda$initView$6$IDMSettingsActivity(View view) {
        MutiSelectItemView mutiSelectItemView = this.settings_people_motion_push;
        mutiSelectItemView.setSelect(!mutiSelectItemView.selectState);
        if (this.settings_people_motion_push.selectState) {
            this.currentEvent |= 2;
        } else {
            this.currentEvent &= 13;
        }
        if (this.currentEvent == 0) {
            gqg.O00000Oo((int) R.string.idm_empty_tv_device_tips);
        }
        this.toSwitch = true;
        this.needChange = true;
    }

    public /* synthetic */ void lambda$initView$7$IDMSettingsActivity(View view) {
        MutiSelectItemView mutiSelectItemView = this.settings_baby_cry_push;
        mutiSelectItemView.setSelect(!mutiSelectItemView.selectState);
        if (this.settings_baby_cry_push.selectState) {
            this.currentEvent |= 4;
        } else {
            this.currentEvent &= 11;
        }
        if (this.currentEvent == 0) {
            gqg.O00000Oo((int) R.string.idm_empty_tv_device_tips);
        }
        this.toSwitch = true;
        this.needChange = true;
    }

    public /* synthetic */ void lambda$initView$8$IDMSettingsActivity(View view) {
        MutiSelectItemView mutiSelectItemView = this.settings_baby_sleep_push;
        mutiSelectItemView.setSelect(!mutiSelectItemView.selectState);
        if (this.settings_baby_sleep_push.selectState) {
            this.currentEvent |= 8;
        } else {
            this.currentEvent &= 7;
        }
        if (this.currentEvent == 0) {
            gqg.O00000Oo((int) R.string.idm_empty_tv_device_tips);
        }
        this.toSwitch = true;
        this.needChange = true;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, boolean):void
     arg types: [com.xiaomi.smarthome.camera.activity.alarm.IDMSettingsActivity, java.lang.String, java.lang.String, int]
     candidates:
      _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, float):float
      _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, int):int
      _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, long):void
      _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, java.lang.String):void
      _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, boolean):void */
    public /* synthetic */ void lambda$initView$9$IDMSettingsActivity(View view) {
        gpy.O000000o((Context) this, this.md5Name, CameraPlayerNewActivity.IDM_FIRST_OPEN_BUTTON, false);
        this.toSwitch = true;
        onCheckedChanged(this.toSwitch, true);
    }

    public /* synthetic */ void lambda$initView$10$IDMSettingsActivity(CompoundButton compoundButton, boolean z) {
        this.toSwitch = z;
        this.idmPairingInfo.idm_switch = this.toSwitch ? "1" : "0";
        this.needChange = true;
        refreshUI();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gpy.O00000o0(android.content.Context, java.lang.String, java.lang.String, boolean):boolean
     arg types: [com.xiaomi.smarthome.camera.activity.alarm.IDMSettingsActivity, java.lang.String, java.lang.String, int]
     candidates:
      _m_j.gpy.O00000o0(android.content.Context, java.lang.String, java.lang.String, java.lang.String):java.lang.String
      _m_j.gpy.O00000o0(android.content.Context, java.lang.String, java.lang.String, boolean):boolean */
    public void refreshUI() {
        List<SettingsDeviceItem> list;
        boolean O00000o0 = gpy.O00000o0((Context) this, this.md5Name, CameraPlayerNewActivity.IDM_FIRST_OPEN_BUTTON, true);
        IDMPairingInfo iDMPairingInfo = this.idmPairingInfo;
        if (iDMPairingInfo == null || !"1".equals(iDMPairingInfo.idm_switch)) {
            if (O00000o0 || this.currentEvent == 0) {
                if (this.idm_devices_view.getChildCount() > 0) {
                    this.settings_idm_switch_first.setVisibility(0);
                }
                this.settings_idm_switch.setVisibility(8);
                this.title_bar_return.setImageResource(R.drawable.mj_common_title_bar_return);
                this.title_bar_more.setVisibility(8);
                this.idm_icon.setVisibility(0);
            } else {
                this.settings_idm_switch.setVisibility(0);
                this.settings_idm_switch_first.setVisibility(8);
            }
            this.settings_idm_switch.setChecked(false);
        } else {
            this.settings_idm_switch.setChecked(true);
        }
        try {
            int i = this.currentEvent;
            if ((i & 1) != 0) {
                this.settings_obj_motion_push.setSelect(true);
            } else {
                this.settings_obj_motion_push.setSelect(false);
            }
            if ((i & 2) != 0) {
                this.settings_people_motion_push.setSelect(true);
            } else {
                this.settings_people_motion_push.setSelect(false);
            }
            if ((i & 4) != 0) {
                this.settings_baby_cry_push.setSelect(true);
            } else {
                this.settings_baby_cry_push.setSelect(false);
            }
            if ((i & 8) != 0) {
                this.settings_baby_sleep_push.setSelect(true);
            } else {
                this.settings_baby_sleep_push.setSelect(false);
            }
        } catch (Exception e) {
            cki.O00000oO(TAG, e.toString());
        }
        this.currentDid = "";
        Iterator<SettingsDeviceItem> it = this.tvViews.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            SettingsDeviceItem next = it.next();
            String str = (String) next.getTag();
            if (this.idmPairingInfo.idm_devDid.equals(str)) {
                unCheckAllTV();
                this.currentDid = str;
                next.setChecked(true);
                break;
            }
        }
        if (TextUtils.isEmpty(this.currentDid) && (list = this.tvViews) != null && list.size() > 0) {
            this.tvViews.get(0).setChecked(true);
            this.currentDid = (String) this.tvViews.get(0).getTag();
        }
        this.setting_items_ll.setVisibility(0);
    }

    public void initTVViews() {
        String str;
        String str2;
        this.tvViews.clear();
        this.idm_devices_view.removeAllViews();
        for (String next : this.didViews) {
            SettingsDeviceItem settingsDeviceItem = new SettingsDeviceItem(this);
            DeviceStat deviceByDid = XmPluginHostApi.instance().getDeviceByDid(next);
            Room O0000o00 = ggb.O00000Oo().O0000o00(next);
            if (O0000o00 == null || TextUtils.isEmpty(O0000o00.getName())) {
                str2 = getString(R.string.tag_unassign);
            } else {
                str2 = O0000o00.getName();
            }
            DeviceFactory.O00000Oo(deviceByDid.model, settingsDeviceItem.f5244O000000o);
            if (deviceByDid.isOnline) {
                settingsDeviceItem.setSubTitle(str2);
            } else {
                settingsDeviceItem.setSubTitle(str2 + " | " + getString(R.string.offline_device));
            }
            settingsDeviceItem.setTitle(deviceByDid.name);
            settingsDeviceItem.setTag(next);
            settingsDeviceItem.setOnClickListener(new View.OnClickListener(next, settingsDeviceItem) {
                /* class com.xiaomi.smarthome.camera.activity.alarm.$$Lambda$IDMSettingsActivity$6TAx_ASCoFcGR9uooxCsidExDbc */
                private final /* synthetic */ String f$1;
                private final /* synthetic */ SettingsDeviceItem f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void onClick(View view) {
                    IDMSettingsActivity.this.lambda$initTVViews$11$IDMSettingsActivity(this.f$1, this.f$2, view);
                }
            });
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, gpc.O000000o(88.0f));
            layoutParams.topMargin = gpc.O000000o(10.0f);
            this.tvViews.add(settingsDeviceItem);
            this.idm_devices_view.addView(settingsDeviceItem, layoutParams);
        }
        if (this.idm_devices_view.getChildCount() <= 0) {
            this.idm_devices_view.setVisibility(8);
            this.tv_device_idm_tips.setText((int) R.string.tv_device_idm_tips_no);
            this.tv_device_idm_tips.setVisibility(0);
            this.no_tv_ll.setVisibility(0);
            this.settings_idm_switch_first.setVisibility(8);
            this.title_bar_return.setImageResource(R.drawable.mj_common_title_bar_return);
        } else {
            this.idm_devices_view.setVisibility(0);
            if ("zh".equalsIgnoreCase(this.language) || ((str = this.language) != null && str.toLowerCase().contains("zh"))) {
                this.tv_device_idm_tips.setText((int) R.string.tv_device_idm_tips_has);
                this.tv_device_idm_tips.setVisibility(0);
            } else {
                this.tv_device_idm_tips.setVisibility(8);
            }
            this.has_tv_sl.setVisibility(0);
            this.title_bar_more.setVisibility(0);
        }
        getConfigs();
    }

    public /* synthetic */ void lambda$initTVViews$11$IDMSettingsActivity(String str, SettingsDeviceItem settingsDeviceItem, View view) {
        unCheckAllTV();
        this.currentDid = str;
        settingsDeviceItem.setChecked(true);
        this.toSwitch = true;
        this.needChange = true;
    }

    private void unCheckAllTV() {
        for (SettingsDeviceItem checked : this.tvViews) {
            checked.setChecked(false);
        }
    }

    private void initData() {
        this.mPD = XQProgressDialog.O000000o(getContext(), null, getString(R.string.camera_waiting));
        Map<String, Set<String>> O000000o2 = fnn.O000000o().O00000Oo().O000000o(8);
        DeviceTagInterface.Category O0000Oo0 = fnn.O000000o().O00000Oo().O0000Oo0("15");
        Set<Object> hashSet = O0000Oo0 == null ? new HashSet<>() : O000000o2.get(O0000Oo0.name) == null ? new HashSet<>() : O000000o2.get(O0000Oo0.name);
        cki.O00000o(TAG, "tvDids=".concat(String.valueOf(hashSet)));
        this.dids.clear();
        for (Object add : hashSet) {
            this.dids.add(add);
        }
        List<String> list = this.dids;
        if (list == null || list.size() <= 0) {
            this.no_tv_ll.setVisibility(0);
            this.settings_idm_switch_first.setVisibility(8);
            this.title_bar_return.setImageResource(R.drawable.mj_common_title_bar_return);
            initTVViews();
            return;
        }
        loadCardPropsFromServer(this.dids, new fsm<String, fso>() {
            /* class com.xiaomi.smarthome.camera.activity.alarm.IDMSettingsActivity.AnonymousClass3 */

            public void onSuccess(String str) {
                cki.O000000o(IDMSettingsActivity.TAG, "loadCardPropsFromServer=".concat(String.valueOf(str)));
                if (!IDMSettingsActivity.this.isFinishing()) {
                    try {
                        cki.O000000o(IDMSettingsActivity.TAG, "loadCardPropsFromServer22=".concat(String.valueOf(str)));
                        JSONObject jSONObject = new JSONObject(str);
                        cki.O000000o(IDMSettingsActivity.TAG, "resultData=".concat(String.valueOf(jSONObject)));
                        for (String next : IDMSettingsActivity.this.dids) {
                            try {
                                cki.O000000o(IDMSettingsActivity.TAG, "for did=".concat(String.valueOf(next)));
                                JSONObject optJSONObject = jSONObject.optJSONObject(next);
                                cki.O000000o(IDMSettingsActivity.TAG, "itemJObj=".concat(String.valueOf(optJSONObject)));
                                JSONObject optJSONObject2 = optJSONObject.optJSONObject("prop.Idminfo");
                                cki.O000000o(IDMSettingsActivity.TAG, "idmInfo=".concat(String.valueOf(optJSONObject2)));
                                String optString = optJSONObject2.optString("value");
                                cki.O000000o(IDMSettingsActivity.TAG, "idmInfo value=".concat(String.valueOf(optString)));
                                IDMInfo iDMInfo = (IDMInfo) IDMSettingsActivity.this.gson.fromJson(optString, IDMInfo.class);
                                cki.O000000o(IDMSettingsActivity.TAG, "IdmInfo=".concat(String.valueOf(iDMInfo)));
                                if (!TextUtils.isEmpty(iDMInfo.id_hash)) {
                                    IDMSettingsActivity.this.didViews.add(next);
                                    IDMSettingsActivity.this.didHashMap.put(next, iDMInfo);
                                }
                            } catch (Exception e) {
                                String str2 = IDMSettingsActivity.TAG;
                                cki.O00000oO(str2, "in for exception=" + e.toString());
                            }
                        }
                        IDMSettingsActivity.this.initTVViews();
                    } catch (Exception e2) {
                        IDMSettingsActivity.this.mPD.dismiss();
                        cki.O00000oO(IDMSettingsActivity.TAG, e2.toString());
                        gqg.O00000Oo(IDMSettingsActivity.this.getString(R.string.toast_failed_retry));
                    }
                }
            }

            public void onFailure(fso fso) {
                String str = IDMSettingsActivity.TAG;
                cki.O00000oO(str, "loadCardPropsFromServer error =" + fso.toString());
                if (!IDMSettingsActivity.this.isFinishing()) {
                    IDMSettingsActivity.this.mPD.dismiss();
                    gqg.O00000Oo(IDMSettingsActivity.this.getString(R.string.toast_failed_retry));
                }
            }
        });
    }

    private void loadCardPropsFromServer(List<String> list, final fsm<String, fso> fsm) {
        if (list != null && list.size() > 0) {
            JSONArray jSONArray = new JSONArray();
            for (String next : list) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("did", next);
                    JSONArray jSONArray2 = new JSONArray();
                    jSONArray2.put("prop.Idminfo");
                    jSONObject.put("props", jSONArray2);
                    jSONArray.put(jSONObject);
                } catch (JSONException e) {
                    Log.e("mijia-card", "fatal", e);
                }
            }
            faw.O00000o().getDeviceProfileProp(CommonApplication.getAppContext(), jSONArray, new fsm<String, fso>() {
                /* class com.xiaomi.smarthome.camera.activity.alarm.IDMSettingsActivity.AnonymousClass4 */

                public void onSuccess(String str) {
                    fsm fsm;
                    if (!IDMSettingsActivity.this.isFinishing() && (fsm = fsm) != null) {
                        fsm.sendSuccessMessage(str);
                    }
                }

                public void onFailure(fso fso) {
                    fsm fsm;
                    gsy.O000000o(6, IDMSettingsActivity.TAG, "batchGetDevicePropsNew result error: ".concat(String.valueOf(fso)));
                    if (!IDMSettingsActivity.this.isFinishing() && (fsm = fsm) != null) {
                        fsm.sendFailureMessage(fso);
                    }
                }
            }, null);
        }
    }

    public void onBackPressed() {
        if (this.needChange) {
            onCheckedChanged(this.toSwitch, false);
        } else {
            super.onBackPressed();
        }
    }
}

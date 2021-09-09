package com.xiaomi.smarthome.camera.activity.sdcard;

import _m_j.chr;
import _m_j.civ;
import _m_j.cki;
import _m_j.clf;
import _m_j.ee;
import _m_j.ei;
import _m_j.gpy;
import _m_j.grv;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.mijia.model.sdcard.SDCardInfo;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.activity.CameraBaseActivity;
import com.xiaomi.smarthome.camera.activity.sdcard.fragment.CloudTimeLineFragment;
import com.xiaomi.smarthome.camera.activity.sdcard.fragment.SDCardTimeLineFragment;
import com.xiaomi.smarthome.camera.activity.setting.SDCardStatusActivityNew;
import com.xiaomi.smarthome.camera.activity.utils.CameraActivityUtils;
import com.xiaomi.smarthome.camera.activity.utils.SpecConstantUtils;
import com.xiaomi.smarthome.camera.v4.utils.CameraToastUtil;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.device.api.spec.operation.PropertyParam;
import java.util.List;
import org.json.JSONObject;

public class SDCardCloudVideoActivity extends CameraBaseActivity implements View.OnClickListener {
    public static final String TAG = "SDCardCloudVideoActivity";
    private final int FRAGMENT_TYPE_CLOUD = 1;
    private final int FRAGMENT_TYPE_SDCARD = 0;
    private CloudTimeLineFragment cloudTimeLineFragment;
    private ee fragmentManager;
    private boolean isFromRN = false;
    private boolean isVip = false;
    private TextView lab_cloud;
    private TextView lab_sdcard;
    public CameraActivityUtils.SdcardDetectResult mSdcardDetectResult = new CameraActivityUtils.SdcardDetectResult();
    private String md5Name;
    Callback<SDCardInfo> sdCardInfoCallback = null;
    public SDCardTimeLineFragment sdCardTimeLineFragment;
    private int sdcard_state = -1;
    private View title_bar;

    public boolean supportOrientationListen() {
        return true;
    }

    public void doCreate(Bundle bundle) {
        super.doCreate(bundle);
        setContentView((int) R.layout.camera_activity_sdcard_cloud_video);
        this.title_bar = findViewById(R.id.title_bar);
        this.md5Name = grv.O000000o(this.mCameraDevice.getModel() + this.mCameraDevice.getDid());
        boolean z = true;
        try {
            Intent intent = getIntent();
            this.mSdcardDetectResult.sdcardGetSuccess = intent.getExtras().getBoolean("sdcardGetSuccess", false);
            this.mSdcardDetectResult.sdcardStatus = intent.getExtras().getInt("sdcardStatus", 0);
            this.isFromRN = intent.getExtras().getBoolean("is_from_rn", false);
            this.isVip = intent.getExtras().getBoolean("isVip", false);
            if (!this.isFromRN) {
                this.isVip = this.mCameraDevice.O00000oO().O0000o0o == 0;
            }
            String str = TAG;
            civ.O000000o(str, "sdcardGetSuccess" + this.mSdcardDetectResult.sdcardGetSuccess + " sdcardStatus" + this.mSdcardDetectResult.sdcardStatus);
        } catch (Exception e) {
            civ.O00000o0(TAG, e.toString());
        }
        findViewById(R.id.title_bar_return).setOnClickListener(this);
        if (this.isFromRN && this.mDeviceStat != null && !TextUtils.isEmpty(this.mDeviceStat.model)) {
            if ("chuangmi.camera.ipc009".equals(this.mDeviceStat.model) && !clf.O000000o(this.mCameraDevice.O00000o0(), "3.4.2_0200")) {
                z = false;
            }
            clf.O00000Oo(z);
            clf.O0000Oo(this.mCameraDevice.getDid(), this.mCameraDevice.getModel(), new Callback<JSONObject>() {
                /* class com.xiaomi.smarthome.camera.activity.sdcard.SDCardCloudVideoActivity.AnonymousClass1 */

                public void onFailure(int i, String str) {
                }

                public void onSuccess(JSONObject jSONObject) {
                    JSONObject optJSONObject;
                    if (!SDCardCloudVideoActivity.this.isFinishing() && jSONObject != null) {
                        try {
                            if (jSONObject.optInt("code", -1) == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
                                boolean optBoolean = optJSONObject.optBoolean("vip");
                                boolean optBoolean2 = optJSONObject.optBoolean("closeWindow");
                                SDCardCloudVideoActivity.this.mCameraDevice.O00000oO().O00000Oo(optJSONObject.optInt("status"));
                                SDCardCloudVideoActivity.this.mCameraDevice.O00000oO().O00000o(optBoolean2);
                                SDCardCloudVideoActivity.this.mCameraDevice.O00000oO().O00000o0(optBoolean);
                            }
                        } catch (Exception e) {
                            String str = SDCardCloudVideoActivity.TAG;
                            civ.O000000o(str, "getCloudStatus exception:" + e.getMessage());
                        }
                    }
                }
            });
        }
        initView();
        initFragments();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, int):int
     arg types: [com.xiaomi.smarthome.camera.activity.sdcard.SDCardCloudVideoActivity, java.lang.String, java.lang.String, int]
     candidates:
      _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, float):float
      _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, long):void
      _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, java.lang.String):void
      _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, boolean):void
      _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, int):int */
    private void initFragments() {
        this.sdcard_state = gpy.O000000o((Context) this, this.md5Name, "SP_KEY_SDCARD_CLOUD_STATE", -1);
        this.fragmentManager = getSupportFragmentManager();
        ei O000000o2 = this.fragmentManager.O000000o();
        boolean z = true;
        if (!this.mSdcardDetectResult.sdcardGetSuccess || this.mSdcardDetectResult.sdcardStatus == 1 || this.mSdcardDetectResult.sdcardStatus == 5 || this.mSdcardDetectResult.sdcardStatus == 3) {
            z = false;
        }
        if (this.sdcard_state == 0 && z) {
            initSDCardFragment(O000000o2);
        } else if (this.isVip || !z) {
            initCloudFragment(O000000o2);
        } else {
            initSDCardFragment(O000000o2);
        }
        if (!this.mSdcardDetectResult.sdcardGetSuccess) {
            detectSDCard(false);
        }
        O000000o2.O00000Oo();
    }

    private void initSDCardFragment(ei eiVar) {
        this.sdCardTimeLineFragment = new SDCardTimeLineFragment();
        this.sdCardTimeLineFragment.setSDCardStatus(this.mSdcardDetectResult.sdcardGetSuccess, this.mSdcardDetectResult.sdcardStatus);
        this.sdCardTimeLineFragment.setData(this.mCameraDevice, this.mHandler);
        this.sdCardTimeLineFragment.setFromRN(this.isFromRN);
        eiVar.O000000o((int) R.id.fragment_container, this.sdCardTimeLineFragment);
        this.lab_cloud.setSelected(false);
        this.lab_sdcard.setSelected(true);
        chr.O000000o("8fq.a57.2w9.3t1");
    }

    private void initCloudFragment(ei eiVar) {
        this.cloudTimeLineFragment = new CloudTimeLineFragment();
        this.cloudTimeLineFragment.setData(this.mCameraDevice, this.mHandler);
        eiVar.O000000o((int) R.id.fragment_container, this.cloudTimeLineFragment);
        this.lab_cloud.setSelected(true);
        this.lab_sdcard.setSelected(false);
        chr.O000000o("8fq.a57.2w9.3t0");
    }

    private void initView() {
        this.lab_cloud = (TextView) findViewById(R.id.lab_cloud);
        this.lab_cloud.setOnClickListener(this);
        this.lab_sdcard = (TextView) findViewById(R.id.lab_sdcard);
        this.lab_sdcard.setOnClickListener(this);
        if (!clf.O00000oO() || !clf.O00000o0()) {
            this.lab_cloud.setVisibility(4);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cll.O000000o(java.lang.String, boolean):boolean
     arg types: [java.lang.String, int]
     candidates:
      _m_j.cll.O000000o(java.lang.String, java.lang.Object):void
      _m_j.cll.O000000o(java.lang.String[], com.xiaomi.smarthome.device.api.Callback<java.lang.Void>):void
      _m_j.cll.O000000o(java.lang.String, boolean):boolean */
    public void setOrientation(boolean z) {
        if (!this.mCameraDevice.O000000o().O000000o("power", true)) {
            CameraToastUtil.showPowerOffToast(this.mCameraDevice.getModel(), this, R.string.power_off);
        } else if (z) {
            enterPadFullScreen();
            setRequestedOrientation(0);
        } else {
            setRequestedOrientation(1);
        }
    }

    public void onBackPressed() {
        if (this.mFullScreen) {
            exitFullScreen(null);
        } else {
            super.onBackPressed();
        }
    }

    public void onClick(View view) {
        if (view.getId() == R.id.title_bar_return) {
            onBackPressed();
        } else if (view.getId() == R.id.lab_cloud) {
            setSelect(1);
            this.lab_cloud.setSelected(true);
            this.lab_sdcard.setSelected(false);
        } else if (view.getId() != R.id.lab_sdcard) {
        } else {
            if (this.mSdcardDetectResult.sdcardStatus == 3) {
                startActivity(new Intent(this, SDCardStatusActivityNew.class));
                return;
            }
            setSelect(0);
            this.lab_cloud.setSelected(false);
            this.lab_sdcard.setSelected(true);
        }
    }

    private void setSelect(int i) {
        ei O000000o2 = this.fragmentManager.O000000o();
        hideFragments(O000000o2);
        if (i == 0) {
            SDCardTimeLineFragment sDCardTimeLineFragment = this.sdCardTimeLineFragment;
            if (sDCardTimeLineFragment == null) {
                this.sdCardTimeLineFragment = new SDCardTimeLineFragment();
                this.sdCardTimeLineFragment.setSDCardStatus(this.mSdcardDetectResult.sdcardGetSuccess, this.mSdcardDetectResult.sdcardStatus);
                this.sdCardTimeLineFragment.setData(this.mCameraDevice, this.mHandler);
                this.sdCardTimeLineFragment.setFromRN(this.isFromRN);
                O000000o2.O000000o((int) R.id.fragment_container, this.sdCardTimeLineFragment);
            } else {
                O000000o2.O00000o0(sDCardTimeLineFragment);
                chr.O000000o("8fq.a57.2w9.3t1");
            }
        } else if (i == 1) {
            CloudTimeLineFragment cloudTimeLineFragment2 = this.cloudTimeLineFragment;
            if (cloudTimeLineFragment2 == null) {
                this.cloudTimeLineFragment = new CloudTimeLineFragment();
                this.cloudTimeLineFragment.setData(this.mCameraDevice, this.mHandler);
                O000000o2.O000000o((int) R.id.fragment_container, this.cloudTimeLineFragment);
            } else {
                O000000o2.O00000o0(cloudTimeLineFragment2);
                chr.O000000o("8fq.a57.2w9.3t0");
            }
        }
        this.sdcard_state = i;
        O000000o2.O00000Oo();
    }

    private void hideFragments(ei eiVar) {
        CloudTimeLineFragment cloudTimeLineFragment2 = this.cloudTimeLineFragment;
        if (cloudTimeLineFragment2 != null) {
            eiVar.O00000Oo(cloudTimeLineFragment2);
        }
        SDCardTimeLineFragment sDCardTimeLineFragment = this.sdCardTimeLineFragment;
        if (sDCardTimeLineFragment != null) {
            eiVar.O00000Oo(sDCardTimeLineFragment);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        try {
            super.onConfigurationChanged(configuration);
            if (this.mFullScreen) {
                this.title_bar.setVisibility(8);
                hideStatusBar();
                return;
            }
            this.title_bar.setVisibility(0);
        } catch (Exception e) {
            cki.O00000oO(TAG, e.toString());
        }
    }

    public void detectSDCard(final boolean z) {
        String str = TAG;
        civ.O000000o(str, "detectSDCard=" + this.mCameraDevice);
        if (this.mCameraDevice != null) {
            if (!this.mSdcardDetectResult.sdcardGetSuccess || this.mSdcardDetectResult.sdcardStatus == 0 || !z) {
                this.mSdcardDetectResult.sdcardStatus = 0;
                this.sdCardInfoCallback = new Callback<SDCardInfo>() {
                    /* class com.xiaomi.smarthome.camera.activity.sdcard.SDCardCloudVideoActivity.AnonymousClass2 */

                    public void onSuccess(SDCardInfo sDCardInfo) {
                        String str = SDCardCloudVideoActivity.TAG;
                        civ.O000000o(str, "detectSDCard onSuccess:" + SDCardCloudVideoActivity.this.mSdcardDetectResult.sdcardGetSuccess);
                        if (z) {
                            SDCardCloudVideoActivity.this.sdCardTimeLineFragment.updateSDCardStatus(SDCardCloudVideoActivity.this.mSdcardDetectResult.sdcardGetSuccess, SDCardCloudVideoActivity.this.mSdcardDetectResult.sdcardStatus);
                        }
                    }

                    public void onFailure(int i, String str) {
                        String str2 = SDCardCloudVideoActivity.TAG;
                        civ.O000000o(str2, "detectSDCard onFailure:" + i + " s:" + str);
                        if (-97 != i && z) {
                            SDCardCloudVideoActivity.this.sdCardTimeLineFragment.updateSDCardStatus(SDCardCloudVideoActivity.this.mSdcardDetectResult.sdcardGetSuccess, SDCardCloudVideoActivity.this.mSdcardDetectResult.sdcardStatus);
                        }
                    }
                };
                if (this.mCameraSpecDevice != null) {
                    toDetectSpecSDCard();
                } else {
                    CameraActivityUtils.detectSDCard(this, this.mCameraDevice, this.mSdcardDetectResult, this.sdCardInfoCallback);
                }
            } else {
                this.sdCardTimeLineFragment.updateSDCardStatus(this.mSdcardDetectResult.sdcardGetSuccess, this.mSdcardDetectResult.sdcardStatus);
            }
        }
    }

    private void toDetectSpecSDCard() {
        loadPropertiesFromServer(SpecConstantUtils.MCMSpecKV(null), new Callback<List<PropertyParam>>() {
            /* class com.xiaomi.smarthome.camera.activity.sdcard.SDCardCloudVideoActivity.AnonymousClass3 */

            public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                onSuccess((List<PropertyParam>) ((List) obj));
            }

            public void onSuccess(List<PropertyParam> list) {
                if (!SDCardCloudVideoActivity.this.isFinishing()) {
                    SDCardCloudVideoActivity.this.mCameraDevice.O000000o(XmPluginHostApi.instance().isUsrExpPlanEnabled(SDCardCloudVideoActivity.this.mCameraDevice.getDid()));
                    SDCardCloudVideoActivity.this.detectSpecSDCard();
                }
            }

            public void onFailure(int i, String str) {
                if (SDCardCloudVideoActivity.this.isFinishing()) {
                }
            }
        });
    }

    public void detectSpecSDCard() {
        Object propertyValueFromCache = getPropertyValueFromCache("memory-card-management", "status");
        if (propertyValueFromCache != null) {
            this.mSdcardDetectResult.sdcardStatus = ((Integer) propertyValueFromCache).intValue();
            this.mCameraDevice.O00000oO();
            this.mSdcardDetectResult.sdcardGetSuccess = true;
        } else {
            CameraActivityUtils.SdcardDetectResult sdcardDetectResult = this.mSdcardDetectResult;
            sdcardDetectResult.sdcardStatus = 1;
            sdcardDetectResult.sdcardGetSuccess = false;
        }
        this.sdCardInfoCallback.onSuccess(null);
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        SDCardTimeLineFragment sDCardTimeLineFragment = this.sdCardTimeLineFragment;
        if (sDCardTimeLineFragment != null) {
            sDCardTimeLineFragment.handleMessage(message);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gpy.O00000Oo(android.content.Context, java.lang.String, java.lang.String, int):void
     arg types: [com.xiaomi.smarthome.camera.activity.sdcard.SDCardCloudVideoActivity, java.lang.String, java.lang.String, int]
     candidates:
      _m_j.gpy.O00000Oo(android.content.Context, java.lang.String, java.lang.String, float):void
      _m_j.gpy.O00000Oo(android.content.Context, java.lang.String, java.lang.String, java.lang.String):void
      _m_j.gpy.O00000Oo(android.content.Context, java.lang.String, java.lang.String, boolean):void
      _m_j.gpy.O00000Oo(android.content.Context, java.lang.String, java.lang.String, int):void */
    public void onStop() {
        super.onStop();
        gpy.O00000Oo((Context) this, this.md5Name, "SP_KEY_SDCARD_CLOUD_STATE", this.sdcard_state);
    }
}

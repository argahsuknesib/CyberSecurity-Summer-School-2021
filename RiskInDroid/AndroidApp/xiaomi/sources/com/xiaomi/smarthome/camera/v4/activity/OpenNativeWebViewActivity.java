package com.xiaomi.smarthome.camera.v4.activity;

import _m_j.cid;
import _m_j.fbs;
import _m_j.fbt;
import _m_j.fbz;
import _m_j.fno;
import _m_j.fsp;
import _m_j.gqg;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.activity.sdcard.SDCardCloudVideoActivity;
import com.xiaomi.smarthome.camera.activity.setting.SDCardStatusActivityNew;
import com.xiaomi.smarthome.camera.v4.activity.setting.InfraredSettingActivity;
import com.xiaomi.smarthome.camera.v4.activity.setting.NoMemoryCardActivity;
import com.xiaomi.smarthome.camera.v4.activity.setting.RoteSettingActivity;
import com.xiaomi.smarthome.camera.v4.activity.setting.WdrSettingActivity;
import com.xiaomi.smarthome.camera.v4.utils.CameraToastUtil;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceRouterFactory;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.operation.js_sdk.base.BaseFragmentWebViewActivity;
import com.xiaomi.smarthome.plugin.DeviceConstant;
import org.json.JSONException;
import org.json.JSONObject;

public class OpenNativeWebViewActivity extends BaseFragmentWebViewActivity implements OpenNativeBridge {
    cid mCameraDevice;
    Device mDevice;
    DeviceStat mDeviceStat;
    String mDid;
    boolean mIsShowFace;
    boolean mSdcardGetSuccess;
    int mSdcardStatus;
    boolean mUseTitleBar;

    public int getFragmentContainerId() {
        return R.id.container;
    }

    public static Intent getIntent(Context context, String str, String str2, String str3, boolean z, boolean z2, int i, boolean z3) {
        Intent intent = new Intent(context, OpenNativeWebViewActivity.class);
        intent.putExtra("open_native_web_view_url", str);
        if (!TextUtils.isEmpty(str2)) {
            intent.putExtra("title", str2);
        }
        intent.putExtra("did", str3);
        intent.putExtra("show_face", z);
        intent.putExtra("use_title_bar", z3);
        intent.putExtra("sdcardGetSuccess", z2);
        intent.putExtra("sdcardStatus", i);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        return intent;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.camera.v4.activity.OpenNativeWebViewFragment.newInstance(java.lang.String, java.lang.String, boolean):com.xiaomi.smarthome.camera.v4.activity.OpenNativeWebViewFragment
     arg types: [java.lang.String, java.lang.String, boolean]
     candidates:
      _m_j.hke.newInstance(java.lang.String, java.lang.String, boolean):_m_j.hke
      com.xiaomi.smarthome.camera.v4.activity.OpenNativeWebViewFragment.newInstance(java.lang.String, java.lang.String, boolean):com.xiaomi.smarthome.camera.v4.activity.OpenNativeWebViewFragment */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_open_native_common_web_view);
        String stringExtra = getIntent().getStringExtra("open_native_web_view_url");
        String stringExtra2 = getIntent().getStringExtra("title");
        this.mDid = getIntent().getStringExtra("did");
        if (this.mDeviceStat == null) {
            try {
                this.mDeviceStat = XmPluginHostApi.instance().getDeviceByDid(this.mDid);
            } catch (Exception unused) {
                this.mDeviceStat = null;
            }
        }
        DeviceStat deviceStat = this.mDeviceStat;
        if (deviceStat == null) {
            finish();
            return;
        }
        this.mCameraDevice = cid.O000000o(deviceStat, deviceStat.did);
        this.mDevice = fno.O000000o().O000000o(this.mDeviceStat.did);
        Device device = this.mDevice;
        if (device != null && !TextUtils.isEmpty(device.specUrn)) {
            fbz.O000000o();
            if (fbz.O00000Oo(this.mDevice.model)) {
                this.mCameraDevice.setSpecUrn(this.mDevice.specUrn);
            }
        }
        this.mIsShowFace = getIntent().getBooleanExtra("show_face", true);
        this.mUseTitleBar = getIntent().getBooleanExtra("use_title_bar", true);
        this.mSdcardGetSuccess = getIntent().getBooleanExtra("sdcardGetSuccess", true);
        this.mSdcardStatus = getIntent().getIntExtra("sdcardStatus", 4);
        if (this.mDevice == null) {
            finish();
        } else {
            openNewWindow(null, OpenNativeWebViewFragment.newInstance(stringExtra, stringExtra2, this.mUseTitleBar));
        }
    }

    public boolean tryOpenNative(String str) {
        Intent intent;
        String str2 = str;
        if (str2.contains("camera_PresetPosition") || str2.contains("camera_PresetPosition".toLowerCase())) {
            Intent intent2 = new Intent(this, CameraPlayerNewActivity.class);
            intent2.addFlags(131072);
            intent2.putExtra(CameraPlayerNewActivity.JUMP_ACTION, "camera_PresetPosition");
            startActivity(intent2);
            finish();
            return true;
        } else if (str2.contains("camera_Sleep") || str2.contains("camera_Sleep".toLowerCase())) {
            if (DeviceConstant.isSupportAiNative(this.mCameraDevice.getModel())) {
                fsp.O000000o().O0000Oo.startSetTimerListV2(this, this.mDeviceStat.did, "set_power", "off", "set_power", "on", this.mDeviceStat.did, getString(R.string.camera_setting_wulizhebi_auto), getString(R.string.camera_setting_wulizhebi_settime), true, getString(R.string.start_time), getString(R.string.end_time), getString(R.string.wulizhebi_auto_item_title));
            } else {
                fsp.O000000o().O0000Oo.startSetTimerListV2(this, this.mDeviceStat.did, "set_power", "off", "set_power", "on", this.mDeviceStat.did, getString(R.string.auto_sleep), getString(R.string.auto_sleep_title), true, getString(R.string.sleep_auto_on_time), getString(R.string.sleep_auto_off_time), getString(R.string.sleep_auto_item_title));
            }
            finish();
            return true;
        } else if (str2.contains("camera_PlayBack") || str2.contains("camera_PlayBack".toLowerCase())) {
            gotoPlayback();
            finish();
            return true;
        } else if (str2.contains("camera_NightVision") || str2.contains("camera_NightVision".toLowerCase())) {
            Intent intent3 = new Intent(this, InfraredSettingActivity.class);
            intent3.putExtra("extra_device_did", this.mDid);
            startActivityForResult(intent3, 100);
            return true;
        } else if (str2.contains("camera_Face") || str2.contains("camera_Face".toLowerCase())) {
            if (this.mIsShowFace) {
                gotoCameraFace();
                finish();
                return true;
            }
            gqg.O000000o((int) R.string.camera_tips_hint);
            return true;
        } else if (str2.contains("camera_RotateImage") || str2.contains("camera_RotateImage".toLowerCase())) {
            Intent intent4 = new Intent(this, RoteSettingActivity.class);
            intent4.putExtra("extra_device_did", this.mDid);
            startActivityForResult(intent4, 100);
            return true;
        } else if (str2.contains("camera_Share") || str2.contains("camera_Share".toLowerCase())) {
            Device device = this.mDevice;
            if (device == null || !device.isOwner() || this.mDevice.isSubDevice() || !DeviceRouterFactory.getDeviceWrapper().canBeShared(this.mDevice)) {
                gqg.O000000o((int) R.string.camera_tips_hint);
                return true;
            }
            fbt fbt = new fbt(this, "/share/ShareDeviceActivity");
            fbt.O000000o("user_id", CoreApi.O000000o().O0000o0());
            fbt.O000000o("did", this.mDevice.did);
            fbt.O000000o(100);
            fbs.O000000o(fbt);
            return true;
        } else if (str2.contains("camera_wdr")) {
            Intent intent5 = new Intent(this, WdrSettingActivity.class);
            intent5.putExtra("extra_device_did", this.mDid);
            startActivityForResult(intent5, 100);
            return true;
        } else if (!str2.contains("camera_sdcardstorage")) {
            return false;
        } else {
            int i = this.mSdcardStatus;
            if (i == 1 || i == 5) {
                intent = new Intent(this, NoMemoryCardActivity.class);
            } else {
                intent = new Intent(this, SDCardStatusActivityNew.class);
            }
            intent.putExtra("extra_device_did", this.mDid);
            startActivityForResult(intent, 100);
            return true;
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (intent != null && intent.getBooleanExtra("finish", false)) {
            setResult(-1, intent);
        }
        finish();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: org.json.JSONObject.put(java.lang.String, boolean):org.json.JSONObject
     arg types: [java.lang.String, int]
     candidates:
      org.json.JSONObject.put(java.lang.String, double):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, float):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, int):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, long):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, java.lang.Object):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, java.util.Collection<?>):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, java.util.Map<?, ?>):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, boolean):org.json.JSONObject */
    /* access modifiers changed from: package-private */
    public void gotoCameraFace() {
        if (this.mCameraDevice.isShared()) {
            gqg.O000000o(getString(R.string.no_permit_for_face_tips));
        } else if (!this.mCameraDevice.O00000oO().O00000Oo()) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("is_vip_user", false);
                jSONObject.put("is_from_camera", true);
                if (this.mCameraDevice != null && DeviceConstant.isSupportFaceNative(this.mCameraDevice.getModel())) {
                    jSONObject.put("is_using_service", true);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            fsp.O000000o().O0000Oo.openFaceManagerActivity(546, this, this.mCameraDevice.getDid(), jSONObject.toString());
        } else {
            fsp.O000000o().O0000Oo.openFaceManagerActivity(this, this.mCameraDevice.getDid());
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cll.O000000o(java.lang.String, boolean):boolean
     arg types: [java.lang.String, int]
     candidates:
      _m_j.cll.O000000o(java.lang.String, java.lang.Object):void
      _m_j.cll.O000000o(java.lang.String[], com.xiaomi.smarthome.device.api.Callback<java.lang.Void>):void
      _m_j.cll.O000000o(java.lang.String, boolean):boolean */
    /* access modifiers changed from: package-private */
    public void gotoPlayback() {
        if (!this.mCameraDevice.O000000o().O000000o("power", true)) {
            CameraToastUtil.showPowerOffToast(this.mCameraDevice.getModel(), this, R.string.power_off);
            return;
        }
        cid cid = this.mCameraDevice;
        if (cid != null && cid.O00000o() && DeviceConstant.isSupportOperation(this.mCameraDevice.getModel())) {
            Intent intent = new Intent(this, SDCardCloudVideoActivity.class);
            intent.putExtra("sdcardGetSuccess", this.mSdcardGetSuccess);
            intent.putExtra("sdcardStatus", this.mSdcardStatus);
            intent.putExtra("extra_device_did", this.mDid);
            startActivity(intent);
        }
    }
}

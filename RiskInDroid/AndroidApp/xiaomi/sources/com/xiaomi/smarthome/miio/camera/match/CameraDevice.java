package com.xiaomi.smarthome.miio.camera.match;

import _m_j.gqb;
import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.device.Device;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

public class CameraDevice extends Device {
    String extraToken = "";
    public String fw_version;
    int mPingCount = 3;
    public long motionTime;
    public int needVerifyCode = 0;
    int sdcard_status;
    public int visitors;

    public void initial() {
    }

    public CameraDevice() {
        this.name = CommonApplication.getAppContext().getString(R.string.camera_name);
        this.pid = 1;
        this.model = "yunyi.camera.v1";
    }

    public void parseExtra(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.extraToken = jSONObject.optString("token");
                this.fw_version = jSONObject.optString("fw_version");
                this.needVerifyCode = jSONObject.optInt("needVerifyCode");
                this.sdcard_status = jSONObject.optInt("sdcard_status");
                this.visitors = jSONObject.optInt("visitors");
                String str2 = this.did;
                if (str2.startsWith("yunyi.")) {
                    str2.substring(6);
                }
            } catch (Exception unused) {
            }
        }
    }

    public void parseEvent(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() > 0) {
                    JSONObject jSONObject = jSONArray.getJSONObject(0);
                    if ("motion".equals(jSONObject.getString("key"))) {
                        this.motionTime = jSONObject.getLong("time");
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public CharSequence getStatusDescription(Context context) {
        if (!isBinded()) {
            return "";
        }
        if (!this.isOnline) {
            return context.getString(R.string.offline_device);
        }
        String string = context.getString(R.string.camera_online);
        if ((!isOwner() && !isFamily()) || this.motionTime <= 0) {
            return string;
        }
        String format = new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Timestamp(this.motionTime * 1000));
        return string + " " + String.format(gqb.O000000o(CommonApplication.getAppContext(), (int) R.string.camera_subtitle_motion), format);
    }

    public String getExtraToken() {
        return this.extraToken;
    }

    public synchronized void setPinCodeType(int i) {
        if (i == 2) {
            setPinCodeOpen(0);
            i = 0;
        }
        super.setPinCodeType(i);
    }

    public void parseFromJSONObject(JSONObject jSONObject) {
        super.parseFromJSONObject(jSONObject);
        setPinCodeType(getPinCodeType());
    }

    public void parseDBExtra() {
        super.parseDBExtra();
        setPinCodeType(getPinCodeType());
    }

    public void cloneTo(Device device) {
        super.cloneTo(device);
        setPinCodeType(getPinCodeType());
    }

    public void set(Device device) {
        super.set(device);
        setPinCodeType(getPinCodeType());
    }
}

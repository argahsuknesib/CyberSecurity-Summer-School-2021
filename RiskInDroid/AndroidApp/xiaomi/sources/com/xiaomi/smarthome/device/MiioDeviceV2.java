package com.xiaomi.smarthome.device;

import android.text.TextUtils;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.frame.core.CoreApi;

public class MiioDeviceV2 extends Device {
    public static final String O00000o0 = "MiioDeviceV2";
    public String mFwVersion;
    public boolean mIsFactory = false;
    public boolean mIsOpen = true;
    protected boolean mIsUpdate;
    public String mMcuVersion;

    public boolean isOpen() {
        if (this.propInfo != null) {
            String optString = this.propInfo.optString("turning");
            if (!TextUtils.isEmpty(optString)) {
                return optString.equals("true");
            }
        }
        if (this.model.equalsIgnoreCase("zhimi.airpurifier.v1") || this.model.equalsIgnoreCase("zhimi.airpurifier.v2") || this.model.equalsIgnoreCase("zhimi.airpurifier.v3")) {
            if (!this.model.equalsIgnoreCase("zhimi.airpurifier.v3") || !DeviceRouterFactory.getDeviceWrapper().isSupportCommonSwitch(this)) {
                if (this.propInfo != null) {
                    return !this.propInfo.optString("mode").equals("idle");
                }
            } else if (this.propInfo == null || this.propInfo.isNull("power")) {
                return this.mIsOpen;
            } else {
                return "on".equalsIgnoreCase(this.propInfo.optString("power"));
            }
        } else if (this.model.equalsIgnoreCase("ge.light.mono1")) {
            if (this.propInfo != null) {
                return "on".equalsIgnoreCase(this.propInfo.optString("power"));
            }
        } else if (this.model.equalsIgnoreCase("chuangmi.plug.v1") || this.model.equalsIgnoreCase("chuangmi.plug.v2")) {
            if (this.propInfo != null) {
                return this.propInfo.optBoolean("on");
            }
        } else if (this.model.equalsIgnoreCase("lumi.plug.v1") && this.propInfo != null) {
            return "on".equals(this.propInfo.optString("neutral_0"));
        }
        if (this.propInfo == null || this.propInfo.isNull("power")) {
            return this.mIsOpen;
        }
        return "on".equalsIgnoreCase(this.propInfo.optString("power"));
    }

    public String getDid() {
        return this.did;
    }

    public String getName() {
        return this.name;
    }

    public boolean isOnlineAdvance() {
        PluginDeviceInfo O00000oO = CoreApi.O000000o().O00000oO(this.model);
        if (O00000oO == null || O00000oO.O00000o() != 18) {
            return super.isOnlineAdvance();
        }
        return true;
    }
}

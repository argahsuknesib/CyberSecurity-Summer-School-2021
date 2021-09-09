package com.xiaomi.smarthome.uwb.lib.mitv.data;

import android.text.TextUtils;
import com.xiaomi.smarthome.uwb.lib.utils.UwbLogUtil;

public class MitvInfo {
    String bleMac;
    String ehMac;
    String isPlaying;
    VideoInfo mCurVideo = new VideoInfo();
    String miAccountId;
    String miplayFlag;
    String partnerId;
    String plazaMode;
    String powerShortPress;
    String screenOn;
    String supportXiaoai;
    String tvName;
    String uwbVersion;
    String wifiMac;

    public String getUwbVersion() {
        return this.uwbVersion;
    }

    public void setUwbVersion(String str) {
        this.uwbVersion = str;
    }

    public String getTvName() {
        return this.tvName;
    }

    public void setTvName(String str) {
        this.tvName = str;
    }

    public String getBleMac() {
        return this.bleMac;
    }

    public void setBleMac(String str) {
        this.bleMac = str;
    }

    public String getEhMac() {
        return this.ehMac;
    }

    public void setEhMac(String str) {
        this.ehMac = str;
    }

    public String getWifiMac() {
        return this.wifiMac;
    }

    public void setWifiMac(String str) {
        this.wifiMac = str;
    }

    public String getMiplayFlag() {
        return this.miplayFlag;
    }

    public void setMiplayFlag(String str) {
        this.miplayFlag = str;
    }

    public String getMiAccountId() {
        return this.miAccountId;
    }

    public void setMiAccountId(String str) {
        this.miAccountId = str;
    }

    public String getPartnerId() {
        return this.partnerId;
    }

    public void setPartnerId(String str) {
        this.partnerId = str;
    }

    public String getIsPlaying() {
        return this.isPlaying;
    }

    public void setIsPlaying(String str) {
        this.isPlaying = str;
    }

    public String getPlazaMode() {
        return this.plazaMode;
    }

    public void setPlazaMode(String str) {
        this.plazaMode = str;
    }

    public VideoInfo getmCurVideo() {
        return this.mCurVideo;
    }

    public void setmCurVideo(VideoInfo videoInfo) {
        this.mCurVideo = videoInfo;
    }

    public String getSupportXiaoai() {
        return this.supportXiaoai;
    }

    public void setSupportXiaoai(String str) {
        this.supportXiaoai = str;
    }

    public String getScreenOn() {
        return this.screenOn;
    }

    public void setScreenOn(String str) {
        this.screenOn = str;
    }

    public String getPowerShortPress() {
        return this.powerShortPress;
    }

    public void setPowerShortPress(String str) {
        this.powerShortPress = str;
    }

    public void merge(MitvInfo mitvInfo) {
        if (mitvInfo.uwbVersion != null) {
            UwbLogUtil.w("UwbLogUtilPlus", "UwbLogUtilPlus mitvInfo uwbVersion: " + mitvInfo.uwbVersion);
            this.uwbVersion = mitvInfo.uwbVersion;
        }
        if (!TextUtils.isEmpty(mitvInfo.tvName)) {
            this.tvName = mitvInfo.tvName;
        }
        if (!TextUtils.isEmpty(mitvInfo.bleMac)) {
            this.bleMac = mitvInfo.bleMac;
        }
        if (!TextUtils.isEmpty(mitvInfo.ehMac)) {
            this.ehMac = mitvInfo.ehMac;
        }
        if (!TextUtils.isEmpty(mitvInfo.wifiMac)) {
            this.wifiMac = mitvInfo.wifiMac;
        }
        if (!TextUtils.isEmpty(mitvInfo.miplayFlag)) {
            UwbLogUtil.w("UwbLogUtilPlus", "UwbLogUtilPlus mitvInfo miplayFlag: " + mitvInfo.miplayFlag);
            this.miplayFlag = mitvInfo.miplayFlag;
        }
        if (!TextUtils.isEmpty(mitvInfo.miAccountId)) {
            this.miAccountId = mitvInfo.miAccountId;
        }
        if (!TextUtils.isEmpty(mitvInfo.partnerId)) {
            this.partnerId = mitvInfo.partnerId;
        }
        if (!TextUtils.isEmpty(mitvInfo.isPlaying)) {
            UwbLogUtil.w("UwbLogUtilPlus", "UwbLogUtilPlus mitvInfo isPlaying: " + mitvInfo.isPlaying);
            this.isPlaying = mitvInfo.isPlaying;
        }
        if (!TextUtils.isEmpty(mitvInfo.plazaMode)) {
            UwbLogUtil.w("UwbLogUtilPlus", "UwbLogUtilPlus mitvInfo plazaMode: " + mitvInfo.plazaMode);
            this.plazaMode = mitvInfo.plazaMode;
        }
        this.mCurVideo.merge(mitvInfo.mCurVideo);
        if (!TextUtils.isEmpty(mitvInfo.screenOn)) {
            UwbLogUtil.w("UwbLogUtilPlus", "UwbLogUtilPlus mitvInfo screenOn: " + mitvInfo.screenOn);
            this.screenOn = mitvInfo.screenOn;
        }
        if (!TextUtils.isEmpty(mitvInfo.powerShortPress)) {
            UwbLogUtil.w("UwbLogUtilPlus", "UwbLogUtilPlus mitvInfo powerShortPress: " + mitvInfo.powerShortPress);
            this.powerShortPress = mitvInfo.powerShortPress;
        }
    }
}

package com.xiaomi.smarthome.uwb.lib.mitv.data;

import android.text.TextUtils;
import com.xiaomi.smarthome.uwb.lib.utils.UwbLogUtil;

public class VideoInfo {
    String ci;
    String duration;
    String mediaId;
    String mediaName;
    String position;
    String source;

    public String getMediaId() {
        return this.mediaId;
    }

    public void setMediaId(String str) {
        this.mediaId = str;
    }

    public String getMediaName() {
        return this.mediaName;
    }

    public void setMediaName(String str) {
        this.mediaName = str;
    }

    public String getCi() {
        return this.ci;
    }

    public void setCi(String str) {
        this.ci = str;
    }

    public String getDuration() {
        return this.duration;
    }

    public void setDuration(String str) {
        this.duration = str;
    }

    public String getPosition() {
        return this.position;
    }

    public long getPostionL() {
        try {
            return Long.parseLong(this.position);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public void setPosition(String str) {
        this.position = str;
    }

    public String getSource() {
        return this.source;
    }

    public void setSource(String str) {
        this.source = str;
    }

    public void merge(VideoInfo videoInfo) {
        if (!TextUtils.isEmpty(videoInfo.mediaId)) {
            UwbLogUtil.w("UwbLogUtilPlus", "UwbLogUtilPlus videoInfo mediaId: " + videoInfo.mediaId);
            this.mediaId = videoInfo.mediaId;
        }
        if (!TextUtils.isEmpty(videoInfo.mediaName)) {
            UwbLogUtil.w("UwbLogUtilPlus", "UwbLogUtilPlus videoInfo mediaName: " + videoInfo.mediaName);
            this.mediaName = videoInfo.mediaName;
        }
        if (!TextUtils.isEmpty(videoInfo.ci)) {
            UwbLogUtil.w("UwbLogUtilPlus", "UwbLogUtilPlus videoInfo ci: " + videoInfo.ci);
            this.ci = videoInfo.ci;
        }
        if (!TextUtils.isEmpty(videoInfo.duration)) {
            UwbLogUtil.w("UwbLogUtilPlus", "UwbLogUtilPlus videoInfo duration: " + videoInfo.duration);
            this.duration = videoInfo.duration;
        }
        if (!TextUtils.isEmpty(videoInfo.position)) {
            UwbLogUtil.w("UwbLogUtilPlus", "UwbLogUtilPlus videoInfo position: " + videoInfo.position);
            this.position = videoInfo.position;
        }
        if (!TextUtils.isEmpty(videoInfo.source)) {
            UwbLogUtil.w("UwbLogUtilPlus", "UwbLogUtilPlus videoInfo source: " + videoInfo.source);
            this.source = videoInfo.source;
        }
    }
}

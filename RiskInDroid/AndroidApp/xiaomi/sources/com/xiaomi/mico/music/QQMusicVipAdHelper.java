package com.xiaomi.mico.music;

import _m_j.ahg;
import _m_j.ahh;
import _m_j.jgc;
import android.content.Context;
import com.xiaomi.mico.api.ApiError;
import com.xiaomi.mico.api.ApiHelper;
import com.xiaomi.mico.api.ApiRequest;
import com.xiaomi.mico.api.model.QQMusicAdConfig;
import com.xiaomi.mico.common.application.AccountProfile;
import com.xiaomi.mico.common.application.AppCapability;
import com.xiaomi.mico.common.util.ContainerUtil;
import com.xiaomi.mico.common.util.GsonUtil;
import com.xiaomi.mico.common.util.PreferenceUtils;
import java.util.concurrent.TimeUnit;

public class QQMusicVipAdHelper {
    public static final ahg LOGGER_NEW = new ahg();
    public QQMusicAdConfig qqMusicAdConfig;
    private boolean removeAdd;

    static {
        QQMusicVipAdHelper.class.getSimpleName();
        new ahh();
    }

    private QQMusicVipAdHelper() {
    }

    public static QQMusicVipAdHelper getInstance() {
        return InstanceHolder.QQ_MUSIC_VIP_AD_HELPER;
    }

    public void removeAdd(Context context) {
        PreferenceUtils.setSettingLong(context, "LAST_REMOVE_OPEN_VIP_TIME", System.currentTimeMillis());
        jgc.O000000o().O00000o(new OpenQQMusicVipHeaderEvent(false, null));
        this.removeAdd = true;
    }

    static class InstanceHolder {
        static final QQMusicVipAdHelper QQ_MUSIC_VIP_AD_HELPER = new QQMusicVipAdHelper();

        InstanceHolder() {
        }
    }

    public void refreshAdConfigure(final Context context) {
        ahg.O000000o("refreshAdConfigure removeAdd: %b", Boolean.valueOf(this.removeAdd));
        if (this.removeAdd) {
            postRemoveHeaderEvent();
            return;
        }
        boolean needGetAdd = needGetAdd();
        ahg.O000000o("refreshAdConfigure needGetAdd: %b", Boolean.valueOf(needGetAdd));
        if (!needGetAdd) {
            postRemoveHeaderEvent();
            return;
        }
        if (this.qqMusicAdConfig != null) {
            ahg.O000000o("refreshAdConfigure qqMusicAdConfig != null");
            ahg.O000000o("refreshAdConfigure qqMusicAdConfig：%s", this.qqMusicAdConfig);
            handleResponse(context);
        }
        ApiHelper.loadConfig("app_homepage_greendiamond_tiny_banner", new ApiRequest.Listener<String>() {
            /* class com.xiaomi.mico.music.QQMusicVipAdHelper.AnonymousClass1 */

            public void onFailure(ApiError apiError) {
            }

            public void onSuccess(String str) {
                if (ContainerUtil.isEmpty(str)) {
                    QQMusicVipAdHelper.postRemoveHeaderEvent();
                    return;
                }
                QQMusicVipAdHelper.this.qqMusicAdConfig = (QQMusicAdConfig) GsonUtil.fromJson(str, QQMusicAdConfig.class);
                QQMusicVipAdHelper.this.handleResponse(context);
            }
        });
    }

    public void handleResponse(Context context) {
        if (this.qqMusicAdConfig.forceDisplay) {
            showAd();
            return;
        }
        long settingLong = PreferenceUtils.getSettingLong(context, "LAST_REMOVE_OPEN_VIP_TIME", 0);
        ahg.O000000o("handleResponse lastShowOpenVipTime: %d", Long.valueOf(settingLong));
        if (settingLong == 0) {
            showAd();
            return;
        }
        long days = TimeUnit.MILLISECONDS.toDays(System.currentTimeMillis() - settingLong);
        int i = this.qqMusicAdConfig.expiration;
        ahg.O000000o("handleResponse daysDiff: %d, expiration: %d", Long.valueOf(days), Integer.valueOf(i));
        if (days > ((long) i)) {
            showAd();
        } else {
            postRemoveHeaderEvent();
        }
    }

    private void showAd() {
        jgc.O000000o().O00000o(new OpenQQMusicVipHeaderEvent(true, this.qqMusicAdConfig));
    }

    public QQMusicAdConfig getQqMusicAdConfig() {
        return this.qqMusicAdConfig;
    }

    private boolean needGetAdd() {
        boolean hasCapabilityQQMusic = AppCapability.hasCapabilityQQMusic();
        AccountProfile current = AccountProfile.current();
        boolean isQQAccountAuthValid = current.isQQAccountAuthValid();
        boolean isQqMusicVipOpened = current.isQqMusicVipOpened();
        ahg.O000000o("needGetAdd hasCapabilityQQMusic: %b, qqAccountAuthValid: %b, qqMusicVipOpened: %b", Boolean.valueOf(hasCapabilityQQMusic), Boolean.valueOf(isQQAccountAuthValid), Boolean.valueOf(isQqMusicVipOpened));
        return hasCapabilityQQMusic && isQQAccountAuthValid && !isQqMusicVipOpened;
    }

    public static void postRemoveHeaderEvent() {
        jgc.O000000o().O00000o(new OpenQQMusicVipHeaderEvent(false, null));
    }

    public boolean hasCache() {
        return this.qqMusicAdConfig != null;
    }

    public void reset() {
        this.qqMusicAdConfig = null;
        this.removeAdd = false;
        postRemoveHeaderEvent();
    }

    public static class OpenQQMusicVipHeaderEvent {
        QQMusicAdConfig qqMusicAdConfig;
        public boolean showAdd;

        OpenQQMusicVipHeaderEvent(boolean z, QQMusicAdConfig qQMusicAdConfig) {
            this.showAdd = z;
            this.qqMusicAdConfig = qQMusicAdConfig;
        }
    }
}

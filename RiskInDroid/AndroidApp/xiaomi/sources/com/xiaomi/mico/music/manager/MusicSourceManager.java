package com.xiaomi.mico.music.manager;

import com.xiaomi.mico.api.ApiError;
import com.xiaomi.mico.api.ApiHelper;
import com.xiaomi.mico.api.ApiRequest;
import com.xiaomi.mico.api.model.Admin;
import com.xiaomi.mico.api.model.Remote;
import com.xiaomi.mico.application.MicoManager;
import com.xiaomi.mico.common.application.MicoCapabilityUtil;

public class MusicSourceManager {
    public static void sendMusicSourceChange() {
        for (Admin.Mico next : MicoManager.getInstance().getMicoList()) {
            if (MicoCapabilityUtil.hasMusicSourceChangeable(next.getHardwareType())) {
                ApiHelper.sendMusicSourceChange(next.deviceID, new ApiRequest.Listener<Remote.Response.NullInfo>() {
                    /* class com.xiaomi.mico.music.manager.MusicSourceManager.AnonymousClass1 */

                    public final void onSuccess(Remote.Response.NullInfo nullInfo) {
                        new Object[1][0] = "MusicSourceManager:sendMusicSourceChange ubus ".concat(String.valueOf(nullInfo));
                    }

                    public final void onFailure(ApiError apiError) {
                        new Object[1][0] = "MusicSourceManager: sendMusicSourceChange ubus " + apiError.toString();
                    }
                });
            }
        }
    }

    public static void sendMusicSourceChange(String str) {
        for (Admin.Mico next : MicoManager.getInstance().getMicoList()) {
            if (MicoCapabilityUtil.hasMusicSourceChangeable(next.getHardwareType())) {
                ApiHelper.sendMusicSourceChange(next.deviceID, str, new ApiRequest.Listener<Remote.Response.NullInfo>() {
                    /* class com.xiaomi.mico.music.manager.MusicSourceManager.AnonymousClass2 */

                    public final void onSuccess(Remote.Response.NullInfo nullInfo) {
                        new Object[1][0] = "MusicSourceManager: sendMusicSourceChange ubus ".concat(String.valueOf(nullInfo));
                    }

                    public final void onFailure(ApiError apiError) {
                        new Object[1][0] = "MusicSourceManager: sendMusicSourceChange ubus " + apiError.toString();
                    }
                });
            }
        }
    }

    public static void sendCpAccountBindStatusChanged(boolean z) {
        for (Admin.Mico next : MicoManager.getInstance().getMicoList()) {
            if (MicoCapabilityUtil.hasMusicSourceChangeable(next.getHardwareType())) {
                ApiHelper.sendCpAccountBindStatusChanged(next.deviceID, z, new ApiRequest.Listener<Remote.Response.NullInfo>() {
                    /* class com.xiaomi.mico.music.manager.MusicSourceManager.AnonymousClass3 */

                    public final void onSuccess(Remote.Response.NullInfo nullInfo) {
                        new Object[1][0] = "MusicSourceManager: sendCpAccountBindStatusChanged ubus ".concat(String.valueOf(nullInfo));
                    }

                    public final void onFailure(ApiError apiError) {
                        new Object[1][0] = "MusicSourceManager: sendCpAccountBindStatusChanged ubus " + apiError.toString();
                    }
                });
            }
        }
    }
}

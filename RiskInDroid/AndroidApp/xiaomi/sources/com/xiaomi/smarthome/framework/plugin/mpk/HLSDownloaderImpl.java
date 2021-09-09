package com.xiaomi.smarthome.framework.plugin.mpk;

import _m_j.gsy;
import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.smarthome.camera.HLSDownloader;
import com.xiaomi.smarthome.miio.camera.cloudstorage.Hls2Mp4;
import com.xiaomi.smarthome.miio.camera.cloudstorage.utils.CloudVideoNetUtils;
import com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo;

public class HLSDownloaderImpl implements HLSDownloader {
    public Hls2Mp4 hls2Mp4;
    public HLSDownloader.OnInfoListenerP onInfoListener;

    public void start(Context context, String str, String str2) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            gsy.O000000o(6, "HLSDownloaderImpl", "param(s) invalid(empty). m3u8Url:" + str + " mp4FilePath:" + str2);
            Hls2Mp4 hls2Mp42 = this.hls2Mp4;
            if (hls2Mp42 != null) {
                hls2Mp42.cancel();
                this.hls2Mp4 = null;
                return;
            }
            return;
        }
        if (this.hls2Mp4 == null) {
            this.hls2Mp4 = new Hls2Mp4();
            if (this.onInfoListener != null) {
                this.hls2Mp4.setInfoListener(new Hls2Mp4.OnInfoListener() {
                    /* class com.xiaomi.smarthome.framework.plugin.mpk.HLSDownloaderImpl.AnonymousClass1 */

                    public void onStart() {
                        if (HLSDownloaderImpl.this.onInfoListener != null) {
                            gsy.O00000Oo("HLSDownloaderImpl", "onStart");
                            HLSDownloaderImpl.this.onInfoListener.onStart();
                        }
                    }

                    public void onComplete() {
                        if (HLSDownloaderImpl.this.onInfoListener != null) {
                            gsy.O00000Oo("HLSDownloaderImpl", "onComplete");
                            HLSDownloaderImpl.this.onInfoListener.onComplete();
                        }
                        if (HLSDownloaderImpl.this.hls2Mp4 != null) {
                            HLSDownloaderImpl.this.hls2Mp4 = null;
                        }
                    }

                    public void onCancelled() {
                        if (HLSDownloaderImpl.this.onInfoListener != null) {
                            gsy.O00000Oo("HLSDownloaderImpl", "onCancelled");
                            HLSDownloaderImpl.this.onInfoListener.onCancelled();
                        }
                        if (HLSDownloaderImpl.this.hls2Mp4 != null) {
                            HLSDownloaderImpl.this.hls2Mp4 = null;
                        }
                    }

                    public void onInfo(int i) {
                        if (HLSDownloaderImpl.this.onInfoListener != null) {
                            gsy.O00000Oo("HLSDownloaderImpl", "onInfo:".concat(String.valueOf(i)));
                            HLSDownloaderImpl.this.onInfoListener.onInfo(i);
                        }
                    }

                    public void onError(int i) {
                        if (HLSDownloaderImpl.this.onInfoListener != null) {
                            gsy.O00000Oo("HLSDownloaderImpl", "onError:".concat(String.valueOf(i)));
                            HLSDownloaderImpl.this.onInfoListener.onError(i);
                        }
                        if (HLSDownloaderImpl.this.hls2Mp4 != null) {
                            HLSDownloaderImpl.this.hls2Mp4 = null;
                        }
                    }

                    public void onProgress(int i) {
                        if (HLSDownloaderImpl.this.onInfoListener != null) {
                            gsy.O00000Oo("HLSDownloaderImpl", "onProgress:".concat(String.valueOf(i)));
                            HLSDownloaderImpl.this.onInfoListener.onProgress(i);
                        }
                    }

                    public void onSize(int i) {
                        if (HLSDownloaderImpl.this.onInfoListener != null) {
                            HLSDownloaderImpl.this.onInfoListener.onSize(i);
                        }
                    }
                });
            }
        }
        MiServiceTokenInfo tokenInfo = CloudVideoNetUtils.getInstance().getTokenInfo();
        if (tokenInfo != null) {
            this.hls2Mp4.start(str, str2, "Cookie: yetAnotherServiceToken=" + tokenInfo.O00000o0);
            return;
        }
        this.hls2Mp4.start(str, str2);
    }

    public boolean isRunning() {
        Hls2Mp4 hls2Mp42 = this.hls2Mp4;
        if (hls2Mp42 != null) {
            return hls2Mp42.isRunning();
        }
        return false;
    }

    public void cancel() {
        Hls2Mp4 hls2Mp42 = this.hls2Mp4;
        if (hls2Mp42 != null) {
            hls2Mp42.cancel();
        }
    }

    public void setInfoListener(HLSDownloader.OnInfoListenerP onInfoListenerP) {
        if (onInfoListenerP != null) {
            this.onInfoListener = onInfoListenerP;
        }
    }

    public void removeInfoListener() {
        this.onInfoListener = null;
    }
}

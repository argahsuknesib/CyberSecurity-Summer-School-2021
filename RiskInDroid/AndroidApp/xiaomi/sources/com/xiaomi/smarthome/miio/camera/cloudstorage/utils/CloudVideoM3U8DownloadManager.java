package com.xiaomi.smarthome.miio.camera.cloudstorage.utils;

import _m_j.cki;
import _m_j.gsy;
import android.text.TextUtils;
import com.xiaomi.smarthome.device.api.ICloudDataCallback;
import com.xiaomi.smarthome.library.common.util.SerialExecutor;
import com.xiaomi.smarthome.miio.camera.cloudstorage.utils.M3U8DownloadAndDecryptTask;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

public class CloudVideoM3U8DownloadManager {
    private static Executor downloadExecutor;
    public static final ConcurrentHashMap<String, M3U8DownloadAndDecryptTask> taskHashMap = new ConcurrentHashMap<>();
    private String did;
    private String fileId;
    private M3U8DownloadAndDecryptTask m3U8DownloadAndDecryptTask = null;
    private boolean transcode = false;

    public void setTranscode(boolean z) {
        this.transcode = z;
    }

    private static Executor getDownloadExecutor() {
        if (downloadExecutor == null) {
            downloadExecutor = new SerialExecutor();
        }
        return downloadExecutor;
    }

    public void DownloadM3U8(final String str, final String str2, String str3, final ICloudDataCallback<List<String>> iCloudDataCallback) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            this.did = str;
            this.fileId = str2;
            this.m3U8DownloadAndDecryptTask = new M3U8DownloadAndDecryptTask(new M3U8DownloadAndDecryptTask.IFileDownloadCallback() {
                /* class com.xiaomi.smarthome.miio.camera.cloudstorage.utils.CloudVideoM3U8DownloadManager.AnonymousClass1 */

                public void onSuccess(List<String> list, String str) {
                    gsy.O00000Oo("CloudVideoM3U8DownloadManager", "DownloadM3U8:success:".concat(String.valueOf(str)));
                    ICloudDataCallback iCloudDataCallback = iCloudDataCallback;
                    if (iCloudDataCallback != null) {
                        iCloudDataCallback.onCloudDataSuccess(list, str);
                    }
                    try {
                        ConcurrentHashMap<String, M3U8DownloadAndDecryptTask> concurrentHashMap = CloudVideoM3U8DownloadManager.taskHashMap;
                        concurrentHashMap.remove(str + str2);
                    } catch (Exception e) {
                        cki.O00000oO("CloudVideoM3U8DownloadManager", e.toString());
                    }
                }

                public void onFailure(int i) {
                    gsy.O00000Oo("CloudVideoM3U8DownloadManager", "DownloadM3U8:fail:".concat(String.valueOf(i)));
                    ICloudDataCallback iCloudDataCallback = iCloudDataCallback;
                    if (iCloudDataCallback != null) {
                        iCloudDataCallback.onCloudDataFailed(i, "DownloadM3U8:fail:".concat(String.valueOf(i)));
                    }
                    try {
                        ConcurrentHashMap<String, M3U8DownloadAndDecryptTask> concurrentHashMap = CloudVideoM3U8DownloadManager.taskHashMap;
                        concurrentHashMap.remove(str + str2);
                    } catch (Exception e) {
                        cki.O00000oO("CloudVideoM3U8DownloadManager", e.toString());
                    }
                }

                public void onProgress(int i) {
                    ICloudDataCallback iCloudDataCallback = iCloudDataCallback;
                    if (iCloudDataCallback != null) {
                        iCloudDataCallback.onCloudDataProgress(i);
                    }
                }
            });
            try {
                this.m3U8DownloadAndDecryptTask.setTranscode(this.transcode);
                ConcurrentHashMap<String, M3U8DownloadAndDecryptTask> concurrentHashMap = taskHashMap;
                concurrentHashMap.put(str + str2, this.m3U8DownloadAndDecryptTask);
                StringBuilder sb = new StringBuilder("taskHashMap.size=");
                sb.append(taskHashMap.size());
                cki.O00000o("CloudVideoM3U8DownloadManager", sb.toString());
            } catch (Exception e) {
                cki.O00000oO("CloudVideoM3U8DownloadManager", e.toString());
            }
            this.m3U8DownloadAndDecryptTask.executeOnExecutor(getDownloadExecutor(), str3, str, str2);
        }
    }

    public void cancelDownload() {
        M3U8DownloadAndDecryptTask m3U8DownloadAndDecryptTask2 = this.m3U8DownloadAndDecryptTask;
        if (m3U8DownloadAndDecryptTask2 != null && !m3U8DownloadAndDecryptTask2.isCancelled()) {
            this.m3U8DownloadAndDecryptTask.cancel(true);
        }
    }

    public boolean cancelDownload(String str, String str2) {
        M3U8DownloadAndDecryptTask m3U8DownloadAndDecryptTask2;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !str.equals(this.did) || !str2.equals(this.fileId) || (m3U8DownloadAndDecryptTask2 = this.m3U8DownloadAndDecryptTask) == null || m3U8DownloadAndDecryptTask2.isCancelled()) {
            return false;
        }
        this.m3U8DownloadAndDecryptTask.cancel(true);
        try {
            ConcurrentHashMap<String, M3U8DownloadAndDecryptTask> concurrentHashMap = taskHashMap;
            concurrentHashMap.remove(str + str2);
            return true;
        } catch (Exception e) {
            cki.O00000oO("CloudVideoM3U8DownloadManager", e.toString());
            return true;
        }
    }

    public boolean cancelDownloadByRN(String str, String str2) {
        boolean z = true;
        try {
            ConcurrentHashMap<String, M3U8DownloadAndDecryptTask> concurrentHashMap = taskHashMap;
            M3U8DownloadAndDecryptTask m3U8DownloadAndDecryptTask2 = concurrentHashMap.get(str + str2);
            if (m3U8DownloadAndDecryptTask2 == null || m3U8DownloadAndDecryptTask2.isCancelled()) {
                return false;
            }
            m3U8DownloadAndDecryptTask2.cancel(true);
            try {
                ConcurrentHashMap<String, M3U8DownloadAndDecryptTask> concurrentHashMap2 = taskHashMap;
                concurrentHashMap2.remove(str + str2);
                return true;
            } catch (Exception e) {
                e = e;
            }
        } catch (Exception e2) {
            e = e2;
            z = false;
            cki.O00000oO("CloudVideoM3U8DownloadManager", "cancelDownloadByRN" + e.toString());
            return z;
        }
    }
}

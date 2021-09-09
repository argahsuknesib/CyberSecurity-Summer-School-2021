package com.xiaomi.smarthome.miio.camera.cloudstorage;

import _m_j.cjn;
import _m_j.cki;
import _m_j.fno;
import _m_j.gsy;
import _m_j.me;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.api.ICloudDataCallback;
import com.xiaomi.smarthome.library.common.util.SerialExecutor;
import com.xiaomi.smarthome.miio.camera.cloudstorage.M3U8ToMp4ConverterTask;
import com.xiaomi.smarthome.miio.camera.cloudstorage.model.CloudVideoDownloadInfo;
import com.xiaomi.smarthome.miio.camera.cloudstorage.utils.CloudVideoM3U8DownloadManager;
import com.xiaomi.smarthome.miio.camera.cloudstorage.utils.CloudVideoNetUtils;
import com.xiaomi.smarthome.plugin.DeviceConstant;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

public class CloudVideoDownloadManager {
    private static Executor downloadExecutor;
    private static volatile CloudVideoDownloadManager instance;
    private CloudVideoM3U8DownloadManager cloudVideoM3U8DownloadManager;
    private CloudVideoDownloadInfo info;
    public volatile boolean isDownloading;
    public List<ICloudVideoDownloadListener> listeners = new ArrayList();
    public M3U8ToMp4ConverterTask m3U8ToMp4ConverterTask;
    public Handler myHandler = new Handler(Looper.getMainLooper());

    public interface ICloudVideoDownloadListener {
        void onCancelled(CloudVideoDownloadInfo cloudVideoDownloadInfo);

        void onError(CloudVideoDownloadInfo cloudVideoDownloadInfo, int i);

        void onFinish(CloudVideoDownloadInfo cloudVideoDownloadInfo);

        void onInfo(CloudVideoDownloadInfo cloudVideoDownloadInfo, int i);

        void onM3U8ToMp4Finish(CloudVideoDownloadInfo cloudVideoDownloadInfo);

        void onProgress(CloudVideoDownloadInfo cloudVideoDownloadInfo, int i);

        void onSpeed(CloudVideoDownloadInfo cloudVideoDownloadInfo, int i);

        void onStart(CloudVideoDownloadInfo cloudVideoDownloadInfo);

        void onStop(CloudVideoDownloadInfo cloudVideoDownloadInfo, int i);
    }

    private void updateStatus(boolean z) {
    }

    public void startDownload() {
    }

    private CloudVideoDownloadManager() {
    }

    public static CloudVideoDownloadManager getInstance(String str) {
        CloudVideoConst.updateTableName(str);
        if (instance == null) {
            synchronized (CloudVideoDownloadManager.class) {
                if (instance == null) {
                    instance = new CloudVideoDownloadManager();
                }
            }
        }
        return instance;
    }

    public void addListener(ICloudVideoDownloadListener iCloudVideoDownloadListener) {
        gsy.O00000Oo("CloudVideoDownloadManager", "add listener");
        if (this.listeners.indexOf(iCloudVideoDownloadListener) < 0) {
            this.listeners.add(iCloudVideoDownloadListener);
        }
    }

    public void removeListener(ICloudVideoDownloadListener iCloudVideoDownloadListener) {
        gsy.O00000Oo("CloudVideoDownloadManager", "remove listener");
        this.listeners.remove(iCloudVideoDownloadListener);
    }

    public void resetStatus(String str, String str2) {
        List<CloudVideoDownloadInfo> records = CloudVideoDownloadDBManager.getInstance().getRecords(str, str2);
        if (records != null && records.size() > 0) {
            for (CloudVideoDownloadInfo next : records) {
                if (next.status == 1) {
                    next.status = 4;
                    updateRecord(next);
                }
            }
        }
    }

    public void resetStatusByMp4(String str, String str2) {
        List<CloudVideoDownloadInfo> records = CloudVideoDownloadDBManager.getInstance().getRecords(str, str2);
        if (records != null && records.size() > 0) {
            for (CloudVideoDownloadInfo next : records) {
                next.status = 4;
                updateRecord(next);
            }
        }
    }

    public void insertRecords(List<CloudVideoDownloadInfo> list) {
        CloudVideoDownloadDBManager.getInstance().insertRecords(list);
    }

    public void updateRecord(CloudVideoDownloadInfo cloudVideoDownloadInfo) {
        CloudVideoDownloadDBManager.getInstance().updateRecord(cloudVideoDownloadInfo);
    }

    public CloudVideoDownloadInfo getRecord(int i) {
        return CloudVideoDownloadDBManager.getInstance().getRecord(i);
    }

    public List<CloudVideoDownloadInfo> getRecords(String str, String str2) {
        return CloudVideoDownloadDBManager.getInstance().getRecords(str, str2);
    }

    public void deleteRecords(List<CloudVideoDownloadInfo> list) {
        if (list != null && list.size() > 0) {
            for (CloudVideoDownloadInfo next : list) {
                if (next.status == 1) {
                    cancelCurrentDownload(next.did, next.fileId);
                }
                if (CloudVideoDownloadDBManager.getInstance().getRecords(next.uid, next.did).size() <= 1) {
                    deleteLocalDir(next.m3u8LocalPath);
                    cki.O000000o("CloudVideoDownloadManager", "delete local file");
                }
            }
            CloudVideoDownloadDBManager.getInstance().deleteRecords(list);
        }
    }

    public void cancelCurrentDownload(String str, String str2) {
        CloudVideoM3U8DownloadManager cloudVideoM3U8DownloadManager2 = this.cloudVideoM3U8DownloadManager;
        if (cloudVideoM3U8DownloadManager2 != null && cloudVideoM3U8DownloadManager2.cancelDownload(str, str2)) {
            this.isDownloading = false;
        }
    }

    public void cancelConvertTask() {
        M3U8ToMp4ConverterTask m3U8ToMp4ConverterTask2 = this.m3U8ToMp4ConverterTask;
        if (m3U8ToMp4ConverterTask2 != null) {
            m3U8ToMp4ConverterTask2.isCanceled = true;
            m3U8ToMp4ConverterTask2.cancel(true);
        }
    }

    private void deleteLocalDir(String str) {
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (file.isDirectory()) {
                cjn.O000000o(file);
            }
        }
    }

    private void m3u8Download(Context context, CloudVideoDownloadInfo cloudVideoDownloadInfo) {
        cki.O000000o("M3u8ToMp4Task", "m3u8Download item.videoUrl=" + cloudVideoDownloadInfo.videoUrl);
        if (context == null || TextUtils.isEmpty(cloudVideoDownloadInfo.videoUrl)) {
            this.isDownloading = false;
            startDownloadFromList(context, cloudVideoDownloadInfo.uid, cloudVideoDownloadInfo.did);
            return;
        }
        this.isDownloading = true;
        CloudVideoDownloadDBManager.getInstance().updateRecord(cloudVideoDownloadInfo);
        doDownload(context, cloudVideoDownloadInfo);
    }

    public static Executor getDownloadExecutor() {
        if (downloadExecutor == null) {
            downloadExecutor = new SerialExecutor();
        }
        return downloadExecutor;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.me.O000000o(long, boolean, java.lang.String):java.lang.String
     arg types: [long, int, java.lang.String]
     candidates:
      _m_j.me.O000000o(java.lang.String, int, java.lang.String):java.lang.String
      _m_j.me.O000000o(java.lang.String, java.lang.String, int):java.lang.String
      _m_j.me.O000000o(long, boolean, java.lang.String):java.lang.String */
    public boolean isExistsVideo(String str, CloudVideoDownloadInfo cloudVideoDownloadInfo) {
        if (!DeviceConstant.isSupportCloudMp4Download(str) || !new File(me.O000000o(cloudVideoDownloadInfo.startTime, true, cloudVideoDownloadInfo.did)).exists()) {
            return false;
        }
        return true;
    }

    private void doDownload(final Context context, final CloudVideoDownloadInfo cloudVideoDownloadInfo) {
        if (!TextUtils.isEmpty(cloudVideoDownloadInfo.fileId)) {
            final Device O000000o2 = fno.O000000o().O000000o(cloudVideoDownloadInfo.did);
            if (isExistsVideo(O000000o2.model, cloudVideoDownloadInfo)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(cloudVideoDownloadInfo);
                CloudVideoDownloadDBManager.getInstance().deleteRecords(arrayList);
                for (ICloudVideoDownloadListener onFinish : this.listeners) {
                    onFinish.onFinish(cloudVideoDownloadInfo);
                }
                this.isDownloading = false;
                startDownloadFromList(context, cloudVideoDownloadInfo.uid, cloudVideoDownloadInfo.did);
                return;
            }
            this.cloudVideoM3U8DownloadManager = new CloudVideoM3U8DownloadManager();
            cloudVideoDownloadInfo.videoUrl = CloudVideoNetUtils.getInstance().getVideoFileUrl(cloudVideoDownloadInfo.did, cloudVideoDownloadInfo.fileId, cloudVideoDownloadInfo.isAlarm);
            this.cloudVideoM3U8DownloadManager.DownloadM3U8(cloudVideoDownloadInfo.did, cloudVideoDownloadInfo.fileId, cloudVideoDownloadInfo.videoUrl, new ICloudDataCallback<List<String>>() {
                /* class com.xiaomi.smarthome.miio.camera.cloudstorage.CloudVideoDownloadManager.AnonymousClass1 */

                public /* bridge */ /* synthetic */ void onCloudDataSuccess(Object obj, Object obj2) {
                    onCloudDataSuccess((List<String>) ((List) obj), obj2);
                }

                /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                 method: _m_j.me.O000000o(long, boolean, java.lang.String):java.lang.String
                 arg types: [long, int, java.lang.String]
                 candidates:
                  _m_j.me.O000000o(java.lang.String, int, java.lang.String):java.lang.String
                  _m_j.me.O000000o(java.lang.String, java.lang.String, int):java.lang.String
                  _m_j.me.O000000o(long, boolean, java.lang.String):java.lang.String */
                public void onCloudDataSuccess(List<String> list, Object obj) {
                    CloudVideoDownloadInfo cloudVideoDownloadInfo = cloudVideoDownloadInfo;
                    cloudVideoDownloadInfo.progress = 100;
                    cloudVideoDownloadInfo.status = 0;
                    cloudVideoDownloadInfo.m3u8LocalPath = (String) obj;
                    gsy.O00000Oo("CloudVideoDownloadManager", "onCloudDataSuccess:" + cloudVideoDownloadInfo.m3u8LocalPath);
                    if (DeviceConstant.isSupportCloudMp4Download(O000000o2.model)) {
                        final String O000000o2 = me.O000000o(cloudVideoDownloadInfo.startTime, true, O000000o2.did);
                        CloudVideoDownloadManager.this.m3U8ToMp4ConverterTask = new M3U8ToMp4ConverterTask(false, O000000o2.did, O000000o2.model, cloudVideoDownloadInfo.fileId, new M3U8ToMp4ConverterTask.IConvertTaskListener() {
                            /* class com.xiaomi.smarthome.miio.camera.cloudstorage.CloudVideoDownloadManager.AnonymousClass1.AnonymousClass1 */

                            public void onSuccess(String str) {
                                CloudVideoDownloadManager.this.isDownloading = false;
                                cki.O000000o("M3u8ToMp4Task", "M3U8ToMp4ConverterTask onSuccess mp4FilePath=".concat(String.valueOf(str)));
                                cloudVideoDownloadInfo.mp4FilePath = str;
                                for (ICloudVideoDownloadListener onFinish : CloudVideoDownloadManager.this.listeners) {
                                    onFinish.onFinish(cloudVideoDownloadInfo);
                                }
                                CloudVideoDownloadManager.this.startDownloadFromList(context, cloudVideoDownloadInfo.uid, cloudVideoDownloadInfo.did);
                            }

                            public void onFailed() {
                                CloudVideoDownloadManager.this.isDownloading = false;
                                cki.O000000o("M3u8ToMp4Task", "M3U8ToMp4ConverterTask onFailed");
                                for (ICloudVideoDownloadListener onError : CloudVideoDownloadManager.this.listeners) {
                                    onError.onError(cloudVideoDownloadInfo, -19000);
                                }
                                CloudVideoDownloadManager.this.startDownloadFromList(context, cloudVideoDownloadInfo.uid, cloudVideoDownloadInfo.did);
                            }

                            public void onProgress(Integer num) {
                                cloudVideoDownloadInfo.progress = num.intValue();
                                cloudVideoDownloadInfo.status = 1;
                                CloudVideoDownloadDBManager.getInstance().updateRecord(cloudVideoDownloadInfo);
                                for (ICloudVideoDownloadListener onProgress : CloudVideoDownloadManager.this.listeners) {
                                    onProgress.onProgress(cloudVideoDownloadInfo, num.intValue());
                                }
                            }
                        });
                        CloudVideoDownloadManager.this.myHandler.postDelayed(new Runnable() {
                            /* class com.xiaomi.smarthome.miio.camera.cloudstorage.CloudVideoDownloadManager.AnonymousClass1.AnonymousClass2 */

                            public void run() {
                                CloudVideoDownloadManager.this.m3U8ToMp4ConverterTask.executeOnExecutor(CloudVideoDownloadManager.getDownloadExecutor(), cloudVideoDownloadInfo.m3u8LocalPath, O000000o2);
                            }
                        }, 100);
                        return;
                    }
                    CloudVideoDownloadManager.this.isDownloading = false;
                    CloudVideoDownloadDBManager.getInstance().updateRecord(cloudVideoDownloadInfo);
                    for (ICloudVideoDownloadListener onFinish : CloudVideoDownloadManager.this.listeners) {
                        onFinish.onFinish(cloudVideoDownloadInfo);
                    }
                    CloudVideoDownloadManager.this.startDownloadFromList(context, cloudVideoDownloadInfo.uid, cloudVideoDownloadInfo.did);
                }

                public void onCloudDataFailed(int i, String str) {
                    CloudVideoDownloadManager.this.isDownloading = false;
                    CloudVideoDownloadInfo cloudVideoDownloadInfo = cloudVideoDownloadInfo;
                    cloudVideoDownloadInfo.progress = 0;
                    if (i == -104) {
                        cloudVideoDownloadInfo.status = 8;
                        CloudVideoDownloadDBManager.getInstance().updateRecord(cloudVideoDownloadInfo);
                        gsy.O000000o(6, "CloudVideoDownloadManager", "onCloudDataFailed paused:".concat(String.valueOf(i)));
                    } else {
                        cloudVideoDownloadInfo.status = 2;
                        CloudVideoDownloadDBManager.getInstance().updateRecord(cloudVideoDownloadInfo);
                        gsy.O000000o(6, "CloudVideoDownloadManager", "onCloudDataFailed:".concat(String.valueOf(i)));
                    }
                    for (ICloudVideoDownloadListener onError : CloudVideoDownloadManager.this.listeners) {
                        onError.onError(cloudVideoDownloadInfo, i);
                    }
                    CloudVideoDownloadManager.this.startDownloadFromList(context, cloudVideoDownloadInfo.uid, cloudVideoDownloadInfo.did);
                }

                public void onCloudDataProgress(int i) {
                    cki.O000000o("M3u8ToMp4Task", "onCloudDataProgress ".concat(String.valueOf(i)));
                    CloudVideoDownloadInfo cloudVideoDownloadInfo = cloudVideoDownloadInfo;
                    cloudVideoDownloadInfo.progress = i;
                    cloudVideoDownloadInfo.status = 1;
                    CloudVideoDownloadDBManager.getInstance().updateRecord(cloudVideoDownloadInfo);
                    for (ICloudVideoDownloadListener onProgress : CloudVideoDownloadManager.this.listeners) {
                        onProgress.onProgress(cloudVideoDownloadInfo, i);
                    }
                }
            });
            return;
        }
        this.isDownloading = false;
        startDownloadFromList(context, cloudVideoDownloadInfo.uid, cloudVideoDownloadInfo.did);
    }

    public void startDownloadFromList(Context context, String str, String str2) {
        fno.O000000o().O000000o(str2);
        List<CloudVideoDownloadInfo> records = CloudVideoDownloadDBManager.getInstance().getRecords(str, str2);
        cki.O000000o("M3u8ToMp4Task", "startDownloadFromList records=" + records.size());
        if (records != null && records.size() > 0) {
            for (CloudVideoDownloadInfo next : records) {
                if (next.status != 4 || this.isDownloading || TextUtils.isEmpty(next.fileId)) {
                    cki.O000000o("M3u8ToMp4Task", "startDownloadFromList no download item=" + next.status);
                } else {
                    m3u8Download(context, next);
                    return;
                }
            }
        }
    }

    private void startDownloadAll(Context context) {
        List<CloudVideoDownloadInfo> records = CloudVideoDownloadDBManager.getInstance().getRecords(4);
        if (records != null && records.size() > 0) {
            for (CloudVideoDownloadInfo next : records) {
                if (next.status == 4 && !this.isDownloading && !TextUtils.isEmpty(next.fileId)) {
                    m3u8Download(context, next);
                    return;
                }
            }
        }
    }

    public List<CloudVideoDownloadInfo> getRecordsFromDB(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        return CloudVideoDownloadDBManager.getInstance().getRecords(str, str2);
    }

    public void pullDownloadFromList(Context context, String str, String str2) {
        if (context != null) {
            startDownloadAll(context);
        }
    }
}

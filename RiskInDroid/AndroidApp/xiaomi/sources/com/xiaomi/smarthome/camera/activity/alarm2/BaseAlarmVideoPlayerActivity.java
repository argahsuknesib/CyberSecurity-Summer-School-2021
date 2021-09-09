package com.xiaomi.smarthome.camera.activity.alarm2;

import _m_j.chr;
import _m_j.fno;
import _m_j.ftn;
import _m_j.gkv;
import _m_j.gqg;
import _m_j.gsy;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.recyclerview.widget.RecyclerView;
import com.Utils.MediaStoreUtil;
import com.mijia.model.alarmcloud.AlarmVideo;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.camera.activity.CameraBaseActivity;
import com.xiaomi.smarthome.camera.activity.alarm2.adapter.AlarmEventOperationListAdapter;
import com.xiaomi.smarthome.camera.activity.alarm2.util.Alarm2Utils;
import com.xiaomi.smarthome.camera.view.widget.FeedbackDialog;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.miio.camera.cloudstorage.CloudVideoDownloadManager;
import com.xiaomi.smarthome.miio.camera.cloudstorage.model.CloudVideoDownloadInfo;
import com.xiaomi.smarthome.plugin.DeviceConstant;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BaseAlarmVideoPlayerActivity extends CameraBaseActivity {
    protected long createTime;
    String[] eventTypes = {"Default", "ObjectMotion", "PeopleMotion", "BabyCry", "Face", "Pet", "AI"};
    String[] eventTypesDesc = {gkv.f17949O000000o.getResources().getString(R.string.event_type_all), gkv.f17949O000000o.getResources().getString(R.string.event_type_obj_motion), gkv.f17949O000000o.getResources().getString(R.string.event_type_people_motion), gkv.f17949O000000o.getResources().getString(R.string.event_type_baby_cry), gkv.f17949O000000o.getResources().getString(R.string.event_type_face), gkv.f17949O000000o.getResources().getString(R.string.event_type_pet), gkv.f17949O000000o.getResources().getString(R.string.event_type_ai)};
    protected RecyclerView event_operation_rv;
    String fileId;
    protected boolean isFromRn = false;
    protected AlarmEventOperationListAdapter mAlarmEventOperationListAdapter;

    /* access modifiers changed from: package-private */
    public void afterM3u8ToMp4Task(String str, boolean z) {
    }

    public void doCreate(Bundle bundle) {
        super.doCreate(bundle);
        if (!"chuangmi.camera.ipc022".equals(this.mCameraDevice.getModel())) {
            this.eventTypes = new String[]{"Default", "ObjectMotion", "PeopleMotion", "BabyCry", "Face", "AI"};
            this.eventTypesDesc = new String[]{CommonApplication.getAppContext().getResources().getString(R.string.event_type_all), CommonApplication.getAppContext().getResources().getString(R.string.event_type_obj_motion), CommonApplication.getAppContext().getResources().getString(R.string.event_type_people_motion), CommonApplication.getAppContext().getResources().getString(R.string.event_type_baby_cry), CommonApplication.getAppContext().getResources().getString(R.string.event_type_face), CommonApplication.getAppContext().getResources().getString(R.string.event_type_ai)};
        }
    }

    public class M3u8ToMp4Task extends AsyncTask<String, Void, String> {
        boolean isSharing;

        M3u8ToMp4Task(boolean z) {
            this.isSharing = z;
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:52:0x0114 A[SYNTHETIC, Splitter:B:52:0x0114] */
        /* JADX WARNING: Removed duplicated region for block: B:57:0x0150 A[Catch:{ Exception -> 0x01a4 }] */
        /* JADX WARNING: Removed duplicated region for block: B:59:0x0155 A[Catch:{ Exception -> 0x01a4 }] */
        /* JADX WARNING: Removed duplicated region for block: B:66:0x0197 A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:69:0x019b A[SYNTHETIC, Splitter:B:69:0x019b] */
        public String doInBackground(String... strArr) {
            BufferedOutputStream bufferedOutputStream;
            int videoConverter;
            IOException e;
            try {
                String str = strArr[0];
                String str2 = strArr[1];
                File[] listFiles = new File(str).listFiles();
                if (listFiles == null) {
                    return "";
                }
                List<File> asList = Arrays.asList(listFiles);
                Collections.sort(asList, new Comparator<File>() {
                    /* class com.xiaomi.smarthome.camera.activity.alarm2.BaseAlarmVideoPlayerActivity.M3u8ToMp4Task.AnonymousClass1 */

                    public int compare(File file, File file2) {
                        return file.getName().compareTo(file2.getName());
                    }
                });
                StringBuilder sb = new StringBuilder();
                StringBuilder sb2 = new StringBuilder();
                for (File absolutePath : asList) {
                    String absolutePath2 = absolutePath.getAbsolutePath();
                    if (absolutePath2.contains(".ts")) {
                        sb.append("file '" + absolutePath2 + "'\r\n");
                    } else if (absolutePath2.contains("mp4")) {
                        sb2.append("file '" + absolutePath2 + "'\r\n");
                    }
                }
                gsy.O00000Oo("M3u8ToMp4Task", "concat =  " + sb.toString() + " concatMp4 = " + sb2.toString());
                if (TextUtils.isEmpty(sb) && TextUtils.isEmpty(sb2)) {
                    return "";
                }
                File file = new File(str + "/fileList.txt");
                if (!file.exists()) {
                    try {
                        file.createNewFile();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                try {
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                    try {
                        if (!TextUtils.isEmpty(sb)) {
                            bufferedOutputStream.write(sb.toString().getBytes());
                        } else if (!TextUtils.isEmpty(sb2)) {
                            bufferedOutputStream.write(sb2.toString().getBytes());
                        }
                        bufferedOutputStream.flush();
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    } catch (IOException e4) {
                        e = e4;
                        try {
                            e.printStackTrace();
                            if (bufferedOutputStream != null) {
                                bufferedOutputStream.close();
                            }
                            String str3 = "ffmpeg -f concat -safe 0 -i " + file.getAbsolutePath() + " -c copy " + str2;
                            gsy.O00000Oo("M3u8ToMp4Task", "begin transform ".concat(String.valueOf(str3)));
                            videoConverter = XmPluginHostApi.instance().videoConverter(BaseAlarmVideoPlayerActivity.this.mCameraDevice.getModel(), str3);
                            if (videoConverter == 0) {
                            }
                            if (videoConverter != 0) {
                            }
                        } catch (Throwable th) {
                            th = th;
                            if (bufferedOutputStream != null) {
                                try {
                                    bufferedOutputStream.close();
                                } catch (IOException e5) {
                                    e5.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    }
                } catch (IOException e6) {
                    bufferedOutputStream = null;
                    e = e6;
                    e.printStackTrace();
                    if (bufferedOutputStream != null) {
                    }
                    String str32 = "ffmpeg -f concat -safe 0 -i " + file.getAbsolutePath() + " -c copy " + str2;
                    gsy.O00000Oo("M3u8ToMp4Task", "begin transform ".concat(String.valueOf(str32)));
                    videoConverter = XmPluginHostApi.instance().videoConverter(BaseAlarmVideoPlayerActivity.this.mCameraDevice.getModel(), str32);
                    if (videoConverter == 0) {
                    }
                    if (videoConverter != 0) {
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedOutputStream = null;
                    if (bufferedOutputStream != null) {
                    }
                    throw th;
                }
                String str322 = "ffmpeg -f concat -safe 0 -i " + file.getAbsolutePath() + " -c copy " + str2;
                gsy.O00000Oo("M3u8ToMp4Task", "begin transform ".concat(String.valueOf(str322)));
                videoConverter = XmPluginHostApi.instance().videoConverter(BaseAlarmVideoPlayerActivity.this.mCameraDevice.getModel(), str322);
                if (videoConverter == 0) {
                    deleteM3U8();
                }
                if (videoConverter != 0) {
                    return "";
                }
                if (!BaseAlarmVideoPlayerActivity.this.isFromRn || BaseAlarmVideoPlayerActivity.this.mDeviceStat == null || DeviceConstant.shouldInsertIntoNonDidAlbum(BaseAlarmVideoPlayerActivity.this.mDeviceStat.model)) {
                    return str2;
                }
                File file2 = new File(str2);
                MediaStoreUtil.O00000Oo(BaseAlarmVideoPlayerActivity.this.getContext(), str2, BaseAlarmVideoPlayerActivity.this.mCameraDevice.getDid(), file2.getName());
                file2.delete();
                return str2.replaceFirst("/Xiaomi/local", "").replaceFirst("file://", "");
            } catch (Exception unused) {
                return "";
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String str) {
            BaseAlarmVideoPlayerActivity.this.afterM3u8ToMp4Task(str, this.isSharing);
        }

        private void deleteM3U8() {
            Device O000000o2 = fno.O000000o().O000000o(BaseAlarmVideoPlayerActivity.this.mCameraDevice.getDid());
            if (O000000o2 != null) {
                List<CloudVideoDownloadInfo> records = CloudVideoDownloadManager.getInstance(BaseAlarmVideoPlayerActivity.this.mCameraDevice.getModel()).getRecords(O000000o2.userId, O000000o2.did);
                CloudVideoDownloadInfo cloudVideoDownloadInfo = null;
                for (int i = 0; i < records.size(); i++) {
                    cloudVideoDownloadInfo = records.get(i);
                    if (cloudVideoDownloadInfo.fileId.equals(BaseAlarmVideoPlayerActivity.this.fileId)) {
                        break;
                    }
                }
                if (cloudVideoDownloadInfo != null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(cloudVideoDownloadInfo);
                    CloudVideoDownloadManager.getInstance(BaseAlarmVideoPlayerActivity.this.mCameraDevice.getModel()).deleteRecords(arrayList);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void setFeedbackData(AlarmVideo alarmVideo) {
        if (alarmVideo != null && this.mAlarmEventOperationListAdapter != null && ftn.O00000oo(this)) {
            String str = alarmVideo.eventType;
            if (!TextUtils.isEmpty(str)) {
                String[] sortEventTypes = Alarm2Utils.sortEventTypes(str);
                ArrayList arrayList = new ArrayList();
                for (String str2 : sortEventTypes) {
                    AlarmVideo alarmVideo2 = new AlarmVideo(alarmVideo);
                    alarmVideo2.eventType = str2;
                    if (str2.contains("KnownFace") || !(!str2.contains("Face") || alarmVideo2.fileIdMetaResult == null || alarmVideo2.fileIdMetaResult.faceInfoMetas == null)) {
                        arrayList.add(alarmVideo2);
                    } else if (str2.contains("PeopleMotion") || str2.contains("Pet")) {
                        arrayList.add(alarmVideo2);
                    }
                }
                this.mAlarmEventOperationListAdapter.setData(arrayList);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void showFeedbackDialog(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            chr.O000000o("u5v.u1o.4k5.69e");
            FeedbackDialog feedbackDialog = new FeedbackDialog(this);
            feedbackDialog.setTitle((int) R.string.match_error);
            feedbackDialog.setOnClickListener(new DialogInterface.OnClickListener(feedbackDialog, str, str2) {
                /* class com.xiaomi.smarthome.camera.activity.alarm2.$$Lambda$BaseAlarmVideoPlayerActivity$GmRK3kTRcM6YYgg4QuIKYIBSro */
                private final /* synthetic */ FeedbackDialog f$1;
                private final /* synthetic */ String f$2;
                private final /* synthetic */ String f$3;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    BaseAlarmVideoPlayerActivity.this.lambda$showFeedbackDialog$0$BaseAlarmVideoPlayerActivity(this.f$1, this.f$2, this.f$3, dialogInterface, i);
                }
            });
            feedbackDialog.setModel(this.mCameraDevice.getModel());
            feedbackDialog.show();
        }
    }

    public /* synthetic */ void lambda$showFeedbackDialog$0$BaseAlarmVideoPlayerActivity(FeedbackDialog feedbackDialog, String str, String str2, DialogInterface dialogInterface, int i) {
        feedbackDialog.dismiss();
        this.mCameraDevice.O00000oo().feedBack(str, true, new Callback() {
            /* class com.xiaomi.smarthome.camera.activity.alarm2.BaseAlarmVideoPlayerActivity.AnonymousClass1 */

            public void onSuccess(Object obj) {
                gqg.O00000Oo((int) R.string.thanks_feedback);
            }

            public void onFailure(int i, String str) {
                gqg.O00000Oo((int) R.string.action_fail);
            }
        }, str2);
    }
}

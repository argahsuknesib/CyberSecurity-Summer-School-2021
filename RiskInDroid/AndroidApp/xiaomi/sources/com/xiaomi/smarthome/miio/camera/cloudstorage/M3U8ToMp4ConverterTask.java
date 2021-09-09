package com.xiaomi.smarthome.miio.camera.cloudstorage;

import _m_j.cik;
import _m_j.cjn;
import _m_j.cki;
import _m_j.ckk;
import _m_j.fno;
import _m_j.gsc;
import android.media.MediaMetadataRetriever;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.miio.camera.cloudstorage.model.CloudVideoDownloadInfo;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class M3U8ToMp4ConverterTask extends AsyncTask<String, Integer, String> {
    String did;
    String fileId;
    public volatile boolean isCanceled = false;
    boolean isSharing;
    IConvertTaskListener listener;
    String model;

    public interface IConvertTaskListener {
        void onFailed();

        void onProgress(Integer num);

        void onSuccess(String str);
    }

    M3U8ToMp4ConverterTask(boolean z, String str, String str2, String str3, IConvertTaskListener iConvertTaskListener) {
        this.isSharing = z;
        this.did = str;
        this.model = str2;
        this.fileId = str3;
        this.listener = iConvertTaskListener;
    }

    /* access modifiers changed from: protected */
    public String doInBackground(String... strArr) {
        boolean z;
        ckk ckk = new ckk();
        ckk.O000000o("M3U8ToMp4ConverterTask", "convert task", "start");
        String str = strArr[0];
        String str2 = strArr[1];
        File file = new File(str);
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return "";
        }
        List asList = Arrays.asList(listFiles);
        Collections.sort(asList, new Comparator<File>() {
            /* class com.xiaomi.smarthome.miio.camera.cloudstorage.M3U8ToMp4ConverterTask.AnonymousClass1 */

            public int compare(File file, File file2) {
                return file.getName().compareTo(file2.getName());
            }
        });
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < asList.size(); i++) {
            File file2 = (File) asList.get(i);
            String absolutePath = file2.getAbsolutePath();
            if (absolutePath.contains(".ts") || absolutePath.contains("mp4")) {
                if (!file2.exists()) {
                    cki.O00000Oo("M3U8ToMp4ConverterTask", "file not exist %s", absolutePath);
                }
                arrayList.add(absolutePath);
            }
        }
        int size = arrayList.size();
        cki.O00000Oo("M3U8ToMp4ConverterTask", "path count:%d", Integer.valueOf(size));
        if (size < 100) {
            HashMap hashMap = new HashMap();
            for (int i2 = 0; i2 < size; i2++) {
                String sizeString = getSizeString((String) arrayList.get(i2));
                if (hashMap.containsKey(sizeString)) {
                    hashMap.put(sizeString, Integer.valueOf(((Integer) hashMap.get(sizeString)).intValue() + 1));
                } else {
                    hashMap.put(sizeString, 1);
                }
            }
            z = hashMap.size() > 1;
            cki.O00000Oo("M3U8ToMp4ConverterTask", "sizeCount count:%d,needConverter:%b", Integer.valueOf(hashMap.size()), Boolean.valueOf(z));
        } else {
            z = true;
        }
        if (z) {
            int i3 = 0;
            while (i3 < size) {
                arrayList.set(i3, doConvert((String) arrayList.get(i3)));
                i3++;
                int floor = (int) Math.floor((double) ((((float) i3) / ((float) asList.size())) * 100.0f));
                if (floor >= 100) {
                    floor = 99;
                }
                cki.O000000o("M3U8ToMp4ConverterTask", "percent=".concat(String.valueOf(floor)));
                publishProgress(Integer.valueOf(floor + 100));
                if (this.isCanceled) {
                    return "";
                }
            }
        }
        cki.O00000o0("M3U8ToMp4ConverterTask", "concatLists");
        String concatLists = concatLists(str, str2, file, arrayList);
        ckk.O00000Oo("M3U8ToMp4ConverterTask", "convert task", "end:" + concatLists + "exist:" + gsc.O00000oo(concatLists));
        return concatLists;
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x00c4 A[SYNTHETIC, Splitter:B:43:0x00c4] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00fe A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0149  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x016a A[SYNTHETIC, Splitter:B:75:0x016a] */
    private String concatLists(String str, String str2, File file, List<String> list) {
        BufferedOutputStream bufferedOutputStream;
        String str3;
        int O000000o2;
        int i;
        IOException e;
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (String next : list) {
            if (gsc.O00000oo(next) && (next.contains(".ts") || next.contains("mp4"))) {
                sb.append("file '" + next + "'\r\n");
            }
        }
        if (TextUtils.isEmpty(sb) && TextUtils.isEmpty(sb2)) {
            return "";
        }
        File file2 = new File(str + "/fileList.txt");
        if (!file2.exists()) {
            try {
                file2.createNewFile();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
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
                    cki.O00000oO("M3u8ToMp4Task bops.write exception", e.toString());
                    if (bufferedOutputStream != null) {
                        bufferedOutputStream.close();
                    }
                    str3 = "ffmpeg -f concat -safe 0 -i " + file2.getAbsolutePath() + " -c copy " + str2;
                    cki.O00000o("M3U8ToMp4ConverterTask", "begin transform ".concat(String.valueOf(str3)));
                    O000000o2 = cik.O000000o(str3);
                    i = 3;
                    while (O000000o2 != 0) {
                        cki.O00000o0("M3U8ToMp4ConverterTask", "end transform result=".concat(String.valueOf(O000000o2)));
                        cki.O00000o0("M3U8ToMp4ConverterTask", "start retry begin transform=".concat(String.valueOf(i)));
                        try {
                            Thread.sleep(1);
                        } catch (Exception e5) {
                            cki.O00000o0("M3u8ToMp4Task start retry begin transform exception", e5.toString());
                        }
                        O000000o2 = cik.O000000o(str3);
                        i--;
                    }
                    cki.O00000o("M3U8ToMp4ConverterTask", "end transform result=".concat(String.valueOf(O000000o2)));
                    deleteM3U8();
                    if (O000000o2 == 0) {
                    }
                    return "";
                } catch (Throwable th) {
                    th = th;
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException e6) {
                            e6.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
        } catch (IOException e7) {
            bufferedOutputStream = null;
            e = e7;
            cki.O00000oO("M3u8ToMp4Task bops.write exception", e.toString());
            if (bufferedOutputStream != null) {
            }
            str3 = "ffmpeg -f concat -safe 0 -i " + file2.getAbsolutePath() + " -c copy " + str2;
            cki.O00000o("M3U8ToMp4ConverterTask", "begin transform ".concat(String.valueOf(str3)));
            O000000o2 = cik.O000000o(str3);
            i = 3;
            while (O000000o2 != 0) {
            }
            cki.O00000o("M3U8ToMp4ConverterTask", "end transform result=".concat(String.valueOf(O000000o2)));
            deleteM3U8();
            if (O000000o2 == 0) {
            }
            return "";
        } catch (Throwable th2) {
            bufferedOutputStream = null;
            th = th2;
            if (bufferedOutputStream != null) {
            }
            throw th;
        }
        str3 = "ffmpeg -f concat -safe 0 -i " + file2.getAbsolutePath() + " -c copy " + str2;
        cki.O00000o("M3U8ToMp4ConverterTask", "begin transform ".concat(String.valueOf(str3)));
        O000000o2 = cik.O000000o(str3);
        i = 3;
        while (O000000o2 != 0 && i > 0 && !this.isCanceled) {
            cki.O00000o0("M3U8ToMp4ConverterTask", "end transform result=".concat(String.valueOf(O000000o2)));
            cki.O00000o0("M3U8ToMp4ConverterTask", "start retry begin transform=".concat(String.valueOf(i)));
            Thread.sleep(1);
            O000000o2 = cik.O000000o(str3);
            i--;
        }
        cki.O00000o("M3U8ToMp4ConverterTask", "end transform result=".concat(String.valueOf(O000000o2)));
        if (O000000o2 == 0 && !this.isCanceled) {
            deleteM3U8();
        }
        if (O000000o2 == 0 || this.isCanceled) {
            return "";
        }
        if (file.exists()) {
            cjn.O000000o(file2);
        }
        publishProgress(200);
        return str2;
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(String str) {
        if (!this.isCanceled) {
            afterM3u8ToMp4Task(str, this.isSharing);
        }
    }

    /* access modifiers changed from: protected */
    public void onProgressUpdate(Integer... numArr) {
        super.onProgressUpdate((Object[]) numArr);
        if (this.listener != null && !this.isCanceled) {
            this.listener.onProgress(numArr[0]);
        }
    }

    private void afterM3u8ToMp4Task(String str, boolean z) {
        if (this.listener != null) {
            if (TextUtils.isEmpty(str)) {
                this.listener.onFailed();
            } else {
                this.listener.onSuccess(str);
            }
        }
    }

    private void deleteM3U8() {
        cki.O00000o("M3U8ToMp4ConverterTask", "deleteM3U8 begin");
        Device O000000o2 = fno.O000000o().O000000o(this.did);
        if (O000000o2 != null) {
            List<CloudVideoDownloadInfo> records = CloudVideoDownloadManager.getInstance(this.model).getRecords(O000000o2.userId, O000000o2.did);
            CloudVideoDownloadInfo cloudVideoDownloadInfo = null;
            for (int i = 0; i < records.size(); i++) {
                cloudVideoDownloadInfo = records.get(i);
                if (cloudVideoDownloadInfo.fileId.equals(this.fileId)) {
                    break;
                }
            }
            if (cloudVideoDownloadInfo != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(cloudVideoDownloadInfo);
                CloudVideoDownloadManager.getInstance(this.model).deleteRecords(arrayList);
            }
            cki.O00000o("M3U8ToMp4ConverterTask", "deleteM3U8 end");
        }
    }

    private String doConvert(String str) {
        String str2;
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf != -1) {
            str2 = str.substring(0, lastIndexOf) + "_360" + str.substring(lastIndexOf);
        } else {
            str2 = str;
        }
        int O000000o2 = cik.O000000o(str, str2);
        if (O000000o2 < 0) {
            gsc.O00000o(str2);
            cki.O00000o("M3U8ToMp4ConverterTask", "doConvert failed and delete file result %d", Integer.valueOf(O000000o2));
        } else {
            gsc.O00000o(str);
        }
        return str2;
    }

    /* JADX INFO: finally extract failed */
    private String getSizeString(String str) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(str);
            String extractMetadata = mediaMetadataRetriever.extractMetadata(19);
            String extractMetadata2 = mediaMetadataRetriever.extractMetadata(18);
            cki.O00000Oo("M3U8ToMp4ConverterTask", "get video size %s:%s of %s", extractMetadata2, extractMetadata, str);
            String str2 = extractMetadata2 + ":" + extractMetadata;
            mediaMetadataRetriever.release();
            return str2;
        } catch (Exception e) {
            cki.O00000oO("M3U8ToMp4ConverterTask", "getSizeStringError:" + e.toString());
            mediaMetadataRetriever.release();
            return "";
        } catch (Throwable th) {
            mediaMetadataRetriever.release();
            throw th;
        }
    }
}

package com.xiaomi.account.diagnosis.task;

import _m_j.dwf;
import android.os.AsyncTask;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.xiaomi.account.diagnosis.DiagnosisConstants;
import com.xiaomi.account.diagnosis.DiagnosisController;
import com.xiaomi.account.diagnosis.upload.FDSUploader;
import com.xiaomi.account.diagnosis.util.FileUtils;
import com.xiaomi.account.diagnosis.util.LogcatCollector;
import com.xiaomi.account.diagnosis.util.ZipUtils;
import com.xiaomi.accountsdk.utils.XMPassportUtil;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class CollectAndUploadDiagnosisTask extends AsyncTask<Void, Void, String> {
    private final Callback mCallback;
    private Random mRandom = new Random();
    private final boolean mUseDefaultDiagnosisDomain;

    public interface Callback {
        void onFinished(boolean z, String str);
    }

    public CollectAndUploadDiagnosisTask(Callback callback, boolean z) {
        this.mCallback = callback;
        this.mUseDefaultDiagnosisDomain = z;
    }

    /* access modifiers changed from: protected */
    public String doInBackground(Void... voidArr) {
        dwf dwf;
        String diagnosisDomain = DiagnosisController.get().getDiagnosisDomain();
        if (TextUtils.isEmpty(diagnosisDomain) && !this.mUseDefaultDiagnosisDomain) {
            return null;
        }
        File collectLogcat = LogcatCollector.collectLogcat();
        File passportCacheDir = DiagnosisConstants.getPassportCacheDir();
        ArrayList arrayList = new ArrayList();
        for (File file : passportCacheDir.listFiles()) {
            if (file.isFile() && file.getName().endsWith(".log")) {
                arrayList.add(file);
            }
        }
        arrayList.add(collectLogcat);
        String generateTraceId = generateTraceId();
        File file2 = new File(DiagnosisConstants.getZipSubDir(), getFileNameByInfo(generateTraceId) + ".zip");
        File parentFile = file2.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        try {
            ZipUtils.zipFiles((File[]) arrayList.toArray(new File[0]), file2);
            dwf = FDSUploader.upload(file2, diagnosisDomain);
        } catch (IOException e) {
            e.printStackTrace();
            dwf = null;
        }
        try {
            FileUtils.cleanDirectory(file2.getParentFile());
            FileUtils.cleanDirectory(collectLogcat.getParentFile());
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        if (dwf == null) {
            return null;
        }
        return generateTraceId;
    }

    private String generateTraceId() {
        return String.valueOf(this.mRandom.nextInt(1000000));
    }

    private String getFileNameByInfo(String str) {
        return str + "-" + getModelWithBase64() + "-" + XMPassportUtil.getISOLocaleString(Locale.getDefault()) + "-" + (System.currentTimeMillis() / 1000);
    }

    private String getModelWithBase64() {
        return Base64.encodeToString(Build.MODEL.getBytes(), 10);
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(String str) {
        this.mCallback.onFinished(!TextUtils.isEmpty(str), str);
    }
}

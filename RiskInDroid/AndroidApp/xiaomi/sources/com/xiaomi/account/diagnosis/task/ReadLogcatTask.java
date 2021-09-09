package com.xiaomi.account.diagnosis.task;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Process;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ReadLogcatTask extends AsyncTask<Void, Void, String> {
    private final Callback mCallback;
    @SuppressLint({"StaticFieldLeak"})
    private final Context mContext;
    private final int mMaxLines;

    public interface Callback {
        void onReadLog(String str);
    }

    public ReadLogcatTask(Context context, Callback callback, int i) {
        this.mContext = context.getApplicationContext();
        this.mCallback = callback;
        this.mMaxLines = i;
    }

    /* access modifiers changed from: protected */
    public String doInBackground(Void... voidArr) {
        List readLogcatFilterByPids = readLogcatFilterByPids(getCurrentRunningPids());
        if (readLogcatFilterByPids != null && readLogcatFilterByPids.size() > this.mMaxLines) {
            readLogcatFilterByPids = readLogcatFilterByPids.subList(readLogcatFilterByPids.size() - this.mMaxLines, readLogcatFilterByPids.size() - 1);
        }
        return TextUtils.join("\n", readLogcatFilterByPids);
    }

    private String[] getCurrentRunningPids() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        String packageName = this.mContext.getPackageName();
        ActivityManager activityManager = (ActivityManager) this.mContext.getSystemService("activity");
        HashSet hashSet = new HashSet();
        if (!(activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null)) {
            for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
                if (next.processName != null && next.processName.contains(packageName)) {
                    hashSet.add(String.valueOf(next.pid));
                }
            }
        }
        hashSet.add(String.valueOf(Process.myPid()));
        return (String[]) hashSet.toArray(new String[0]);
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(String str) {
        this.mCallback.onReadLog(str);
        super.onPostExecute((Object) str);
    }

    private ArrayList<String> readLogcatFilterByPids(String[] strArr) {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("logcat -d -v time").getInputStream()));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                int length = strArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    } else if (readLine.contains(strArr[i])) {
                        arrayList.add(readLine);
                        break;
                    } else {
                        i++;
                    }
                }
            }
        } catch (IOException unused) {
        }
        return arrayList;
    }
}

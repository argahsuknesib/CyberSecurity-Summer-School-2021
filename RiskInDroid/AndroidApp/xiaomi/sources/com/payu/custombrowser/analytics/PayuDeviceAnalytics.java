package com.payu.custombrowser.analytics;

import android.content.Context;
import android.os.AsyncTask;
import com.payu.custombrowser.util.CBUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.Thread;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PayuDeviceAnalytics {
    public long TIMER_DELAY = 0;
    public CBUtil cbUtil;
    public final Context context;
    public String file_name = "cb_local_cache_device";
    public boolean isTimerCancelled;
    public ArrayList<String> mBuffer;
    public boolean mIsLocked = false;
    public Timer mTimer;

    public PayuDeviceAnalytics(Context context2, final String str) {
        this.context = context2;
        this.file_name = str;
        this.mBuffer = new ArrayList<>();
        this.cbUtil = new CBUtil();
        final Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            /* class com.payu.custombrowser.analytics.PayuDeviceAnalytics.AnonymousClass1 */

            public void uncaughtException(Thread thread, Throwable th) {
                PayuDeviceAnalytics.this.setLock();
                try {
                    FileOutputStream openFileOutput = PayuDeviceAnalytics.this.context.openFileOutput(str, 0);
                    int size = PayuDeviceAnalytics.this.mBuffer.size();
                    for (int i = 0; i < size; i++) {
                        openFileOutput.write((PayuDeviceAnalytics.this.mBuffer.get(i) + "\r\n").getBytes());
                    }
                    openFileOutput.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                PayuDeviceAnalytics.this.releaseLock();
                defaultUncaughtExceptionHandler.uncaughtException(thread, th);
            }
        });
    }

    public void log(String str) {
        JSONArray jSONArray;
        if (this.mIsLocked) {
            this.mBuffer.add(str);
        } else {
            setLock();
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!new File(this.context.getFilesDir(), this.file_name).exists()) {
                    this.context.openFileOutput(this.file_name, 0);
                }
                FileInputStream openFileInput = this.context.openFileInput(this.file_name);
                String str2 = "";
                while (true) {
                    int read = openFileInput.read();
                    if (read == -1) {
                        break;
                    }
                    str2 = str2 + Character.toString((char) read);
                }
                if (str2.equalsIgnoreCase("")) {
                    jSONArray = new JSONArray();
                } else {
                    jSONArray = new JSONArray(str2);
                }
                openFileInput.close();
                FileOutputStream openFileOutput = this.context.openFileOutput(this.file_name, 0);
                jSONArray.put(jSONArray.length(), jSONObject);
                openFileOutput.write(jSONArray.toString().getBytes());
                openFileOutput.close();
            } catch (IOException e) {
                e.printStackTrace();
                this.mBuffer.add(str);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            releaseLock();
        }
        resetTimer();
    }

    public void resetTimer() {
        Timer timer = this.mTimer;
        if (timer != null) {
            timer.cancel();
        }
        this.mTimer = new Timer();
        this.mTimer.schedule(new TimerTask() {
            /* class com.payu.custombrowser.analytics.PayuDeviceAnalytics.AnonymousClass2 */

            /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
                jadx.core.utils.exceptions.JadxOverflowException: 
                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
                	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
                */
            public void run() {
                /*
                    r7 = this;
                    java.lang.String r0 = "\r\n"
                    com.payu.custombrowser.analytics.PayuDeviceAnalytics r1 = com.payu.custombrowser.analytics.PayuDeviceAnalytics.this
                    r2 = 5000(0x1388, double:2.4703E-320)
                    r1.TIMER_DELAY = r2
                    r1.setLock()
                    java.lang.String r1 = ""
                    r2 = 1
                    r3 = 0
                    java.io.File r4 = new java.io.File     // Catch:{ IOException -> 0x00b4 }
                    com.payu.custombrowser.analytics.PayuDeviceAnalytics r5 = com.payu.custombrowser.analytics.PayuDeviceAnalytics.this     // Catch:{ IOException -> 0x00b4 }
                    android.content.Context r5 = r5.context     // Catch:{ IOException -> 0x00b4 }
                    java.io.File r5 = r5.getFilesDir()     // Catch:{ IOException -> 0x00b4 }
                    com.payu.custombrowser.analytics.PayuDeviceAnalytics r6 = com.payu.custombrowser.analytics.PayuDeviceAnalytics.this     // Catch:{ IOException -> 0x00b4 }
                    java.lang.String r6 = r6.file_name     // Catch:{ IOException -> 0x00b4 }
                    r4.<init>(r5, r6)     // Catch:{ IOException -> 0x00b4 }
                    boolean r4 = r4.exists()     // Catch:{ IOException -> 0x00b4 }
                    if (r4 != 0) goto L_0x0031
                    com.payu.custombrowser.analytics.PayuDeviceAnalytics r4 = com.payu.custombrowser.analytics.PayuDeviceAnalytics.this     // Catch:{ IOException -> 0x00b4 }
                    android.content.Context r4 = r4.context     // Catch:{ IOException -> 0x00b4 }
                    com.payu.custombrowser.analytics.PayuDeviceAnalytics r5 = com.payu.custombrowser.analytics.PayuDeviceAnalytics.this     // Catch:{ IOException -> 0x00b4 }
                    java.lang.String r5 = r5.file_name     // Catch:{ IOException -> 0x00b4 }
                    r4.openFileOutput(r5, r3)     // Catch:{ IOException -> 0x00b4 }
                L_0x0031:
                    com.payu.custombrowser.analytics.PayuDeviceAnalytics r4 = com.payu.custombrowser.analytics.PayuDeviceAnalytics.this     // Catch:{ IOException -> 0x00b4 }
                    android.content.Context r4 = r4.context     // Catch:{ IOException -> 0x00b4 }
                    com.payu.custombrowser.analytics.PayuDeviceAnalytics r5 = com.payu.custombrowser.analytics.PayuDeviceAnalytics.this     // Catch:{ IOException -> 0x00b4 }
                    java.lang.String r5 = r5.file_name     // Catch:{ IOException -> 0x00b4 }
                    java.io.FileInputStream r4 = r4.openFileInput(r5)     // Catch:{ IOException -> 0x00b4 }
                L_0x003d:
                    int r5 = r4.read()     // Catch:{ IOException -> 0x00b4 }
                    r6 = -1
                    if (r5 == r6) goto L_0x0059
                    java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00b4 }
                    r6.<init>()     // Catch:{ IOException -> 0x00b4 }
                    r6.append(r1)     // Catch:{ IOException -> 0x00b4 }
                    char r5 = (char) r5     // Catch:{ IOException -> 0x00b4 }
                    java.lang.String r5 = java.lang.Character.toString(r5)     // Catch:{ IOException -> 0x00b4 }
                    r6.append(r5)     // Catch:{ IOException -> 0x00b4 }
                    java.lang.String r1 = r6.toString()     // Catch:{ IOException -> 0x00b4 }
                    goto L_0x003d
                L_0x0059:
                    r4.close()     // Catch:{ IOException -> 0x00b4 }
                    com.payu.custombrowser.analytics.PayuDeviceAnalytics r4 = com.payu.custombrowser.analytics.PayuDeviceAnalytics.this
                    java.util.ArrayList<java.lang.String> r4 = r4.mBuffer
                    int r4 = r4.size()
                L_0x0064:
                    if (r4 <= 0) goto L_0x0098
                    int r4 = r4 + -1
                    java.lang.StringBuilder r5 = new java.lang.StringBuilder
                    r5.<init>()
                    r5.append(r1)
                    com.payu.custombrowser.analytics.PayuDeviceAnalytics r1 = com.payu.custombrowser.analytics.PayuDeviceAnalytics.this
                    java.util.ArrayList<java.lang.String> r1 = r1.mBuffer
                    java.lang.Object r1 = r1.get(r4)
                    java.lang.String r1 = (java.lang.String) r1
                    r5.append(r1)
                    r5.append(r0)
                    java.lang.String r1 = r5.toString()
                    if (r4 < 0) goto L_0x0064
                    com.payu.custombrowser.analytics.PayuDeviceAnalytics r5 = com.payu.custombrowser.analytics.PayuDeviceAnalytics.this
                    java.util.ArrayList<java.lang.String> r5 = r5.mBuffer
                    int r5 = r5.size()
                    if (r5 <= r4) goto L_0x0064
                    com.payu.custombrowser.analytics.PayuDeviceAnalytics r5 = com.payu.custombrowser.analytics.PayuDeviceAnalytics.this
                    java.util.ArrayList<java.lang.String> r5 = r5.mBuffer
                    r5.remove(r4)
                    goto L_0x0064
                L_0x0098:
                    java.lang.String r0 = r1.trim()
                    int r1 = r0.length()
                    if (r1 <= 0) goto L_0x010d
                    com.payu.custombrowser.analytics.PayuDeviceAnalytics$UploadData r1 = new com.payu.custombrowser.analytics.PayuDeviceAnalytics$UploadData
                    com.payu.custombrowser.analytics.PayuDeviceAnalytics r4 = com.payu.custombrowser.analytics.PayuDeviceAnalytics.this
                    r1.<init>(r0)
                    java.lang.String[] r2 = new java.lang.String[r2]
                    r2[r3] = r0
                    r1.execute(r2)
                    goto L_0x0114
                L_0x00b1:
                    r4 = move-exception
                    goto L_0x0129
                L_0x00b4:
                    r4 = move-exception
                    r4.printStackTrace()     // Catch:{ all -> 0x00b1 }
                    com.payu.custombrowser.analytics.PayuDeviceAnalytics r4 = com.payu.custombrowser.analytics.PayuDeviceAnalytics.this
                    java.util.ArrayList<java.lang.String> r4 = r4.mBuffer
                    int r4 = r4.size()
                L_0x00c0:
                    if (r4 <= 0) goto L_0x00f4
                    int r4 = r4 + -1
                    java.lang.StringBuilder r5 = new java.lang.StringBuilder
                    r5.<init>()
                    r5.append(r1)
                    com.payu.custombrowser.analytics.PayuDeviceAnalytics r1 = com.payu.custombrowser.analytics.PayuDeviceAnalytics.this
                    java.util.ArrayList<java.lang.String> r1 = r1.mBuffer
                    java.lang.Object r1 = r1.get(r4)
                    java.lang.String r1 = (java.lang.String) r1
                    r5.append(r1)
                    r5.append(r0)
                    java.lang.String r1 = r5.toString()
                    if (r4 < 0) goto L_0x00c0
                    com.payu.custombrowser.analytics.PayuDeviceAnalytics r5 = com.payu.custombrowser.analytics.PayuDeviceAnalytics.this
                    java.util.ArrayList<java.lang.String> r5 = r5.mBuffer
                    int r5 = r5.size()
                    if (r5 <= r4) goto L_0x00c0
                    com.payu.custombrowser.analytics.PayuDeviceAnalytics r5 = com.payu.custombrowser.analytics.PayuDeviceAnalytics.this
                    java.util.ArrayList<java.lang.String> r5 = r5.mBuffer
                    r5.remove(r4)
                    goto L_0x00c0
                L_0x00f4:
                    java.lang.String r0 = r1.trim()
                    int r1 = r0.length()
                    if (r1 <= 0) goto L_0x010d
                    com.payu.custombrowser.analytics.PayuDeviceAnalytics$UploadData r1 = new com.payu.custombrowser.analytics.PayuDeviceAnalytics$UploadData
                    com.payu.custombrowser.analytics.PayuDeviceAnalytics r4 = com.payu.custombrowser.analytics.PayuDeviceAnalytics.this
                    r1.<init>(r0)
                    java.lang.String[] r2 = new java.lang.String[r2]
                    r2[r3] = r0
                    r1.execute(r2)
                    goto L_0x0114
                L_0x010d:
                    com.payu.custombrowser.analytics.PayuDeviceAnalytics r0 = com.payu.custombrowser.analytics.PayuDeviceAnalytics.this
                    java.util.Timer r0 = r0.mTimer
                    r0.cancel()
                L_0x0114:
                    com.payu.custombrowser.analytics.PayuDeviceAnalytics r0 = com.payu.custombrowser.analytics.PayuDeviceAnalytics.this
                    java.util.ArrayList<java.lang.String> r0 = r0.mBuffer
                    int r0 = r0.size()
                    if (r0 <= 0) goto L_0x0123
                    com.payu.custombrowser.analytics.PayuDeviceAnalytics r0 = com.payu.custombrowser.analytics.PayuDeviceAnalytics.this
                    r0.resetTimer()
                L_0x0123:
                    com.payu.custombrowser.analytics.PayuDeviceAnalytics r0 = com.payu.custombrowser.analytics.PayuDeviceAnalytics.this
                    r0.releaseLock()
                    return
                L_0x0129:
                    com.payu.custombrowser.analytics.PayuDeviceAnalytics r5 = com.payu.custombrowser.analytics.PayuDeviceAnalytics.this
                    java.util.ArrayList<java.lang.String> r5 = r5.mBuffer
                    int r5 = r5.size()
                L_0x0131:
                    if (r5 <= 0) goto L_0x0165
                    int r5 = r5 + -1
                    java.lang.StringBuilder r6 = new java.lang.StringBuilder
                    r6.<init>()
                    r6.append(r1)
                    com.payu.custombrowser.analytics.PayuDeviceAnalytics r1 = com.payu.custombrowser.analytics.PayuDeviceAnalytics.this
                    java.util.ArrayList<java.lang.String> r1 = r1.mBuffer
                    java.lang.Object r1 = r1.get(r5)
                    java.lang.String r1 = (java.lang.String) r1
                    r6.append(r1)
                    r6.append(r0)
                    java.lang.String r1 = r6.toString()
                    if (r5 < 0) goto L_0x0131
                    com.payu.custombrowser.analytics.PayuDeviceAnalytics r6 = com.payu.custombrowser.analytics.PayuDeviceAnalytics.this
                    java.util.ArrayList<java.lang.String> r6 = r6.mBuffer
                    int r6 = r6.size()
                    if (r6 <= r5) goto L_0x0131
                    com.payu.custombrowser.analytics.PayuDeviceAnalytics r6 = com.payu.custombrowser.analytics.PayuDeviceAnalytics.this
                    java.util.ArrayList<java.lang.String> r6 = r6.mBuffer
                    r6.remove(r5)
                    goto L_0x0131
                L_0x0165:
                    java.lang.String r0 = r1.trim()
                    int r1 = r0.length()
                    if (r1 <= 0) goto L_0x017e
                    com.payu.custombrowser.analytics.PayuDeviceAnalytics$UploadData r1 = new com.payu.custombrowser.analytics.PayuDeviceAnalytics$UploadData
                    com.payu.custombrowser.analytics.PayuDeviceAnalytics r5 = com.payu.custombrowser.analytics.PayuDeviceAnalytics.this
                    r1.<init>(r0)
                    java.lang.String[] r2 = new java.lang.String[r2]
                    r2[r3] = r0
                    r1.execute(r2)
                    goto L_0x0185
                L_0x017e:
                    com.payu.custombrowser.analytics.PayuDeviceAnalytics r0 = com.payu.custombrowser.analytics.PayuDeviceAnalytics.this
                    java.util.Timer r0 = r0.mTimer
                    r0.cancel()
                L_0x0185:
                    goto L_0x0187
                L_0x0186:
                    throw r4
                L_0x0187:
                    goto L_0x0186
                */
                throw new UnsupportedOperationException("Method not decompiled: com.payu.custombrowser.analytics.PayuDeviceAnalytics.AnonymousClass2.run():void");
            }
        }, this.TIMER_DELAY);
    }

    public synchronized void setLock() {
        this.mIsLocked = true;
    }

    public synchronized void releaseLock() {
        this.mIsLocked = false;
    }

    public JSONArray removeJsonObjectAtJsonArrayIndex(JSONArray jSONArray, int i) throws JSONException {
        if (i < 0 || i > jSONArray.length() - 1) {
            throw new IndexOutOfBoundsException();
        }
        JSONArray jSONArray2 = new JSONArray();
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (i2 != i) {
                jSONArray2.put(jSONArray.get(i2));
            }
        }
        return jSONArray2;
    }

    public class UploadData extends AsyncTask<String, Void, String> {
        private String temp;

        UploadData(String str) {
            this.temp = str;
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String str) {
            super.onPostExecute((Object) str);
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x0108, code lost:
            r10 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x010a, code lost:
            r10 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
            r9.this$0.resetTimer();
            r10.printStackTrace();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x0114, code lost:
            r10 = e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x0116, code lost:
            r10 = e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x0117, code lost:
            r10.printStackTrace();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x011b, code lost:
            r10.printStackTrace();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
            return null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
            return null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:56:?, code lost:
            return null;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00f4 */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x010a A[ExcHandler: IOException (r10v5 'e' java.io.IOException A[CUSTOM_DECLARE]), Splitter:B:0:0x0000] */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x0114 A[Catch:{ Exception -> 0x0108 }, ExcHandler: ProtocolException (e java.net.ProtocolException), Splitter:B:0:0x0000] */
        /* JADX WARNING: Removed duplicated region for block: B:40:0x0116 A[Catch:{ Exception -> 0x0108 }, ExcHandler: MalformedURLException (e java.net.MalformedURLException), Splitter:B:0:0x0000] */
        public String doInBackground(String... strArr) {
            try {
                if (PayuDeviceAnalytics.this.context == null || PayuDeviceAnalytics.this.isTimerCancelled) {
                    return null;
                }
                JSONArray jSONArray = new JSONArray(strArr[0]);
                JSONArray jSONArray2 = jSONArray;
                for (int i = 0; i < jSONArray.length(); i++) {
                    CBUtil cBUtil = PayuDeviceAnalytics.this.cbUtil;
                    if (cBUtil.getBooleanSharedPreference(((JSONObject) jSONArray.get(i)).getString("merchant_key") + "|" + ((JSONObject) jSONArray.get(i)).getString("txnid"), PayuDeviceAnalytics.this.context)) {
                        jSONArray2 = PayuDeviceAnalytics.this.removeJsonObjectAtJsonArrayIndex(jSONArray, i);
                    }
                }
                if (jSONArray2.length() <= 0) {
                    return null;
                }
                HttpURLConnection httpsConn = PayuDeviceAnalytics.this.cbUtil.getHttpsConn("https://info.payu.in/merchant/MobileAnalytics", "command=DeviceAnalytics&data=" + jSONArray2.toString());
                if (httpsConn != null) {
                    if (httpsConn.getResponseCode() == 200) {
                        StringBuffer stringBufferFromInputStream = CBUtil.getStringBufferFromInputStream(httpsConn.getInputStream());
                        if (stringBufferFromInputStream == null) {
                            return null;
                        }
                        if (new JSONObject(stringBufferFromInputStream.toString()).has("status")) {
                            PayuDeviceAnalytics.this.context.deleteFile(PayuDeviceAnalytics.this.file_name);
                            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                                CBUtil cBUtil2 = PayuDeviceAnalytics.this.cbUtil;
                                cBUtil2.setBooleanSharedPreference(((JSONObject) jSONArray2.get(i2)).getString("merchant_key") + "|" + ((JSONObject) jSONArray2.get(i2)).getString("txnid"), true, PayuDeviceAnalytics.this.context);
                            }
                            return null;
                        }
                        PayuDeviceAnalytics.this.updateFile(this.temp);
                        return null;
                    }
                    PayuDeviceAnalytics.this.updateFile(this.temp);
                    return null;
                }
                PayuDeviceAnalytics.this.context.deleteFile(PayuDeviceAnalytics.this.file_name);
                return null;
            } catch (MalformedURLException e) {
            } catch (ProtocolException e2) {
            } catch (IOException e3) {
            }
        }
    }

    public void updateFile(String str) {
        try {
            FileOutputStream openFileOutput = this.context.openFileOutput(this.file_name, 0);
            openFileOutput.write(str.getBytes());
            openFileOutput.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Timer getmTimer() {
        this.isTimerCancelled = true;
        return this.mTimer;
    }
}

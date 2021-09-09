package com.payu.custombrowser.analytics;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.payu.custombrowser.util.CBUtil;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.Thread;
import java.net.HttpURLConnection;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CBAnalytics {
    private static CBAnalytics INSTANCE;
    public String ANALYTICS_BUFFER_KEY = "analytics_buffer_key";
    public CBUtil cbUtil;
    public String fileName;
    public volatile boolean mBufferLock;
    private Timer mTimer;
    public volatile boolean mainFileLocked = false;
    public final Context mcontext;

    private CBAnalytics(final Context context, String str) {
        this.mcontext = context;
        this.fileName = str;
        this.cbUtil = new CBUtil();
        final Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            /* class com.payu.custombrowser.analytics.CBAnalytics.AnonymousClass1 */

            public void uncaughtException(Thread thread, Throwable th) {
                do {
                } while (CBAnalytics.this.mainFileLocked);
                CBAnalytics.this.setLock();
                try {
                    FileOutputStream openFileOutput = CBAnalytics.this.mcontext.openFileOutput(CBAnalytics.this.fileName, 0);
                    if (CBAnalytics.this.cbUtil.getStringSharedPreference(CBAnalytics.this.mcontext, CBAnalytics.this.ANALYTICS_BUFFER_KEY).length() > 0) {
                        JSONArray jSONArray = new JSONArray();
                        JSONArray jSONArray2 = new JSONArray(CBAnalytics.this.cbUtil.getStringSharedPreference(CBAnalytics.this.mcontext, CBAnalytics.this.ANALYTICS_BUFFER_KEY).toString());
                        for (int i = 0; i < jSONArray2.length(); i++) {
                            jSONArray.put(jSONArray.length(), jSONArray2.getJSONObject(i));
                        }
                        openFileOutput.write(jSONArray.toString().getBytes());
                        CBAnalytics.this.cbUtil.deleteSharedPrefKey(context, CBAnalytics.this.ANALYTICS_BUFFER_KEY);
                    }
                    openFileOutput.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                CBAnalytics.this.releaseLock();
                defaultUncaughtExceptionHandler.uncaughtException(thread, th);
            }
        });
    }

    public static CBAnalytics getInstance(Context context, String str) {
        if (INSTANCE == null) {
            synchronized (CBAnalytics.class) {
                if (INSTANCE == null) {
                    INSTANCE = new CBAnalytics(context, str);
                }
            }
        }
        return INSTANCE;
    }

    public void log(final String str) {
        if (isOnline()) {
            resetTimer();
        }
        if (this.mainFileLocked) {
            new Thread(new Runnable() {
                /* class com.payu.custombrowser.analytics.CBAnalytics.AnonymousClass2 */

                public void run() {
                    JSONArray jSONArray;
                    do {
                        try {
                        } catch (Exception e) {
                            e.printStackTrace();
                            return;
                        }
                    } while (CBAnalytics.this.mBufferLock);
                    String stringSharedPreference = CBAnalytics.this.cbUtil.getStringSharedPreference(CBAnalytics.this.mcontext, CBAnalytics.this.ANALYTICS_BUFFER_KEY);
                    if (stringSharedPreference == null || stringSharedPreference.equalsIgnoreCase("")) {
                        jSONArray = new JSONArray();
                    } else {
                        jSONArray = new JSONArray(stringSharedPreference);
                    }
                    jSONArray.put(new JSONObject(str));
                    CBAnalytics.this.cbUtil.setStringSharedPreference(CBAnalytics.this.mcontext, CBAnalytics.this.ANALYTICS_BUFFER_KEY, jSONArray.toString());
                }
            }).start();
        } else {
            new Thread(new Runnable() {
                /* class com.payu.custombrowser.analytics.CBAnalytics.AnonymousClass3 */

                public void run() {
                    JSONArray jSONArray;
                    do {
                    } while (CBAnalytics.this.mainFileLocked);
                    CBAnalytics.this.setLock();
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        String readFileInputStream = CBAnalytics.this.cbUtil.readFileInputStream(CBAnalytics.this.mcontext, CBAnalytics.this.fileName, 0);
                        if (readFileInputStream != null) {
                            if (!readFileInputStream.equalsIgnoreCase("")) {
                                jSONArray = new JSONArray(readFileInputStream);
                                FileOutputStream openFileOutput = CBAnalytics.this.mcontext.openFileOutput(CBAnalytics.this.fileName, 0);
                                jSONArray.put(jSONArray.length(), jSONObject);
                                openFileOutput.write(jSONArray.toString().getBytes());
                                openFileOutput.close();
                                CBAnalytics.this.releaseLock();
                            }
                        }
                        jSONArray = new JSONArray();
                        FileOutputStream openFileOutput2 = CBAnalytics.this.mcontext.openFileOutput(CBAnalytics.this.fileName, 0);
                        jSONArray.put(jSONArray.length(), jSONObject);
                        openFileOutput2.write(jSONArray.toString().getBytes());
                        openFileOutput2.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    } catch (Throwable th) {
                        CBAnalytics.this.releaseLock();
                        throw th;
                    }
                    CBAnalytics.this.releaseLock();
                }
            }).start();
        }
    }

    public void resetTimer() {
        Timer timer = this.mTimer;
        if (timer != null) {
            timer.cancel();
        }
        this.mTimer = new Timer();
        this.mTimer.schedule(new TimerTask() {
            /* class com.payu.custombrowser.analytics.CBAnalytics.AnonymousClass4 */

            /* JADX WARNING: Removed duplicated region for block: B:17:0x005a A[Catch:{ Exception -> 0x00cb }] */
            /* JADX WARNING: Removed duplicated region for block: B:20:0x007f A[Catch:{ Exception -> 0x00cb }] */
            public void run() {
                StringBuffer stringBufferFromInputStream;
                JSONArray jSONArray;
                StringBuffer stringBufferFromInputStream2;
                do {
                } while (CBAnalytics.this.mainFileLocked);
                CBAnalytics.this.setLock();
                if (CBAnalytics.this.isOnline()) {
                    try {
                        String readFileInputStream = CBAnalytics.this.cbUtil.readFileInputStream(CBAnalytics.this.mcontext, CBAnalytics.this.fileName, 0);
                        if (readFileInputStream != null) {
                            try {
                                if (!readFileInputStream.equalsIgnoreCase("")) {
                                    jSONArray = new JSONArray(readFileInputStream);
                                    if (CBAnalytics.this.cbUtil.getStringSharedPreference(CBAnalytics.this.mcontext, CBAnalytics.this.ANALYTICS_BUFFER_KEY).length() > 1) {
                                        CBAnalytics.this.mBufferLock = true;
                                        jSONArray = CBAnalytics.this.copyBufferToFile(jSONArray, new JSONArray(CBAnalytics.this.cbUtil.getStringSharedPreference(CBAnalytics.this.mcontext, CBAnalytics.this.ANALYTICS_BUFFER_KEY)));
                                    }
                                    if (jSONArray.length() > 0) {
                                        HttpURLConnection httpsConn = CBAnalytics.this.cbUtil.getHttpsConn("https://info.payu.in/merchant/MobileAnalytics", "command=EventAnalytics&data=" + jSONArray.toString(), 30000);
                                        if (!(httpsConn == null || httpsConn.getResponseCode() != 200 || httpsConn.getInputStream() == null || (stringBufferFromInputStream2 = CBUtil.getStringBufferFromInputStream(httpsConn.getInputStream())) == null || !new JSONObject(stringBufferFromInputStream2.toString()).has("status"))) {
                                            CBAnalytics.this.mcontext.deleteFile(CBAnalytics.this.fileName);
                                        }
                                    }
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        jSONArray = new JSONArray();
                        if (CBAnalytics.this.cbUtil.getStringSharedPreference(CBAnalytics.this.mcontext, CBAnalytics.this.ANALYTICS_BUFFER_KEY).length() > 1) {
                        }
                        if (jSONArray.length() > 0) {
                        }
                    } catch (Throwable th) {
                        try {
                            JSONArray jSONArray2 = new JSONArray();
                            if (CBAnalytics.this.cbUtil.getStringSharedPreference(CBAnalytics.this.mcontext, CBAnalytics.this.ANALYTICS_BUFFER_KEY).length() > 1) {
                                CBAnalytics.this.mBufferLock = true;
                                jSONArray2 = CBAnalytics.this.copyBufferToFile(jSONArray2, new JSONArray(CBAnalytics.this.cbUtil.getStringSharedPreference(CBAnalytics.this.mcontext, CBAnalytics.this.ANALYTICS_BUFFER_KEY)));
                            }
                            if (jSONArray2.length() > 0) {
                                HttpURLConnection httpsConn2 = CBAnalytics.this.cbUtil.getHttpsConn("https://info.payu.in/merchant/MobileAnalytics", "command=EventAnalytics&data=" + jSONArray2.toString(), 30000);
                                if (!(httpsConn2 == null || httpsConn2.getResponseCode() != 200 || httpsConn2.getInputStream() == null || (stringBufferFromInputStream = CBUtil.getStringBufferFromInputStream(httpsConn2.getInputStream())) == null || !new JSONObject(stringBufferFromInputStream.toString()).has("status"))) {
                                    CBAnalytics.this.mcontext.deleteFile(CBAnalytics.this.fileName);
                                }
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        throw th;
                    }
                }
                CBAnalytics.this.releaseLock();
                if (CBAnalytics.this.cbUtil.getStringSharedPreference(CBAnalytics.this.mcontext, CBAnalytics.this.ANALYTICS_BUFFER_KEY).length() > 1) {
                    CBAnalytics.this.resetTimer();
                }
            }
        }, 5000);
    }

    public synchronized void setLock() {
        do {
        } while (this.mainFileLocked);
        this.mainFileLocked = true;
    }

    public void releaseLock() {
        this.mainFileLocked = false;
    }

    public boolean isOnline() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.mcontext.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    public Timer getmTimer() {
        return this.mTimer;
    }

    public JSONArray copyBufferToFile(JSONArray jSONArray, JSONArray jSONArray2) {
        FileOutputStream fileOutputStream = null;
        try {
            JSONArray jSONArray3 = new JSONArray(jSONArray.toString());
            for (int i = 0; i < jSONArray2.length(); i++) {
                jSONArray3.put(jSONArray2.getJSONObject(i));
            }
            FileOutputStream openFileOutput = this.mcontext.openFileOutput(this.fileName, 0);
            openFileOutput.write(jSONArray3.toString().getBytes());
            this.cbUtil.deleteSharedPrefKey(this.mcontext, this.ANALYTICS_BUFFER_KEY);
            if (openFileOutput != null) {
                try {
                    openFileOutput.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            this.mBufferLock = false;
            return jSONArray3;
        } catch (Exception e2) {
            e2.printStackTrace();
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
            this.mBufferLock = false;
            return jSONArray;
        } catch (Throwable th) {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
            this.mBufferLock = false;
            throw th;
        }
    }
}

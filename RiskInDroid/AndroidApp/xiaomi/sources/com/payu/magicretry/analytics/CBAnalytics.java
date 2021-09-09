package com.payu.magicretry.analytics;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;
import com.mixpanel.android.mpmetrics.MixpanelAPI;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.Thread;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class CBAnalytics {
    private static CBAnalytics INSTANCE;
    private static MixpanelAPI mixpanel;
    public String ANALYTICS_URL = "https://info.payu.in/merchant/postservice.php";
    public final Activity mActivity;
    public ArrayList<String> mBuffer = new ArrayList<>();
    public boolean mIsLocked = false;
    private Timer mTimer;

    private CBAnalytics(Activity activity) {
        this.mActivity = activity;
        final Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            /* class com.payu.magicretry.analytics.CBAnalytics.AnonymousClass1 */

            public void uncaughtException(Thread thread, Throwable th) {
                CBAnalytics.this.setLock();
                try {
                    FileOutputStream openFileOutput = CBAnalytics.this.mActivity.openFileOutput("mr_local_cache", 0);
                    int size = CBAnalytics.this.mBuffer.size();
                    for (int i = 0; i < size; i++) {
                        openFileOutput.write((CBAnalytics.this.mBuffer.get(i) + "\r\n").getBytes());
                    }
                    openFileOutput.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                CBAnalytics.this.releaseLock();
                defaultUncaughtExceptionHandler.uncaughtException(thread, th);
            }
        });
    }

    public static synchronized CBAnalytics getInstance(Activity activity) {
        CBAnalytics cBAnalytics;
        synchronized (CBAnalytics.class) {
            if (INSTANCE == null) {
                INSTANCE = new CBAnalytics(activity);
            }
            cBAnalytics = INSTANCE;
        }
        return cBAnalytics;
    }

    public void log(final String str) {
        resetTimer();
        if (this.mIsLocked) {
            this.mBuffer.add(str);
            return;
        }
        new AsyncTask<Void, Void, Void>() {
            /* class com.payu.magicretry.analytics.CBAnalytics.AnonymousClass2 */

            /* access modifiers changed from: protected */
            public Void doInBackground(Void... voidArr) {
                CBAnalytics.this.setLock();
                String str = "";
                try {
                    if (!new File(CBAnalytics.this.mActivity.getFilesDir(), "mr_local_cache").exists()) {
                        CBAnalytics.this.mActivity.openFileOutput("mr_local_cache", 0);
                    }
                    FileInputStream openFileInput = CBAnalytics.this.mActivity.openFileInput("mr_local_cache");
                    while (true) {
                        int read = openFileInput.read();
                        if (read == -1) {
                            break;
                        }
                        str = str + Character.toString((char) read);
                    }
                    openFileInput.close();
                    FileOutputStream openFileOutput = CBAnalytics.this.mActivity.openFileOutput("mr_local_cache", 0);
                    openFileOutput.write((str + str + "\r\n").getBytes());
                    openFileOutput.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    CBAnalytics.this.mBuffer.add(str);
                }
                CBAnalytics.this.releaseLock();
                return null;
            }
        }.execute(null, null, null);
    }

    public void resetTimer() {
        Timer timer = this.mTimer;
        if (timer != null) {
            timer.cancel();
        }
        this.mTimer = new Timer();
        this.mTimer.schedule(new TimerTask() {
            /* class com.payu.magicretry.analytics.CBAnalytics.AnonymousClass3 */

            /* JADX WARNING: Code restructure failed: missing block: B:100:0x02e2, code lost:
                r0.printStackTrace();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:30:0x011c, code lost:
                r0 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
                r0.printStackTrace();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:58:0x01e9, code lost:
                r0 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:60:?, code lost:
                r0.printStackTrace();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:62:0x01f0, code lost:
                r0 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:63:0x01f2, code lost:
                r0 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:65:0x01f8, code lost:
                r0.printStackTrace();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:66:0x01fc, code lost:
                r0.printStackTrace();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:95:0x02d4, code lost:
                r0 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:96:0x02d6, code lost:
                r0 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:97:0x02d8, code lost:
                r0 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:98:0x02da, code lost:
                r0.printStackTrace();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:99:0x02de, code lost:
                r0.printStackTrace();
             */
            /* JADX WARNING: Exception block dominator not found, dom blocks: [B:20:0x00ad, B:56:0x01d5] */
            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Removed duplicated region for block: B:62:0x01f0 A[ExcHandler: ProtocolException (r0v7 'e' java.net.ProtocolException A[CUSTOM_DECLARE]), Splitter:B:20:0x00ad] */
            /* JADX WARNING: Removed duplicated region for block: B:63:0x01f2 A[ExcHandler: MalformedURLException (r0v6 'e' java.net.MalformedURLException A[CUSTOM_DECLARE]), Splitter:B:20:0x00ad] */
            /* JADX WARNING: Removed duplicated region for block: B:96:0x02d6 A[ExcHandler: ProtocolException (r0v25 'e' java.net.ProtocolException A[CUSTOM_DECLARE]), Splitter:B:82:0x0262] */
            /* JADX WARNING: Removed duplicated region for block: B:97:0x02d8 A[ExcHandler: MalformedURLException (r0v24 'e' java.net.MalformedURLException A[CUSTOM_DECLARE]), Splitter:B:82:0x0262] */
            public void run() {
                CBAnalytics.this.setLock();
                String str = "";
                try {
                    if (!new File(CBAnalytics.this.mActivity.getFilesDir(), "mr_local_cache").exists()) {
                        CBAnalytics.this.mActivity.openFileOutput("mr_local_cache", 0);
                    }
                    FileInputStream openFileInput = CBAnalytics.this.mActivity.openFileInput("mr_local_cache");
                    while (true) {
                        int read = openFileInput.read();
                        if (read == -1) {
                            break;
                        }
                        str = str + Character.toString((char) read);
                    }
                    openFileInput.close();
                    int size = CBAnalytics.this.mBuffer.size();
                    while (size > 0) {
                        size--;
                        str = str + CBAnalytics.this.mBuffer.get(size) + "\r\n";
                        if (size >= 0 && CBAnalytics.this.mBuffer.size() > size) {
                            CBAnalytics.this.mBuffer.remove(size);
                        }
                    }
                    String trim = str.trim();
                    if (trim.length() > 0) {
                        String concat = "command=sdkWs&var1=".concat(String.valueOf(trim));
                        try {
                            byte[] bytes = concat.getBytes("UTF-8");
                            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(CBAnalytics.this.ANALYTICS_URL).openConnection();
                            httpURLConnection.setRequestMethod("POST");
                            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                            httpURLConnection.setRequestProperty("Content-Length", String.valueOf(concat.length()));
                            httpURLConnection.setDoOutput(true);
                            httpURLConnection.getOutputStream().write(bytes);
                            int responseCode = httpURLConnection.getResponseCode();
                            InputStream inputStream = httpURLConnection.getInputStream();
                            StringBuffer stringBuffer = new StringBuffer();
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int read2 = inputStream.read(bArr);
                                if (read2 == -1) {
                                    break;
                                }
                                stringBuffer.append(new String(bArr, 0, read2));
                            }
                            if (responseCode == 200) {
                                CBAnalytics.this.mActivity.deleteFile("mr_local_cache");
                            } else {
                                FileOutputStream openFileOutput = CBAnalytics.this.mActivity.openFileOutput("mr_local_cache", 0);
                                openFileOutput.write(trim.getBytes());
                                openFileOutput.close();
                            }
                        } catch (MalformedURLException e) {
                        } catch (ProtocolException e2) {
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                } catch (IOException e4) {
                    e4.printStackTrace();
                    int size2 = CBAnalytics.this.mBuffer.size();
                    while (size2 > 0) {
                        size2--;
                        str = str + CBAnalytics.this.mBuffer.get(size2) + "\r\n";
                        if (size2 >= 0 && CBAnalytics.this.mBuffer.size() > size2) {
                            CBAnalytics.this.mBuffer.remove(size2);
                        }
                    }
                    String trim2 = str.trim();
                    if (trim2.length() > 0) {
                        String concat2 = "command=sdkWs&var1=".concat(String.valueOf(trim2));
                        byte[] bytes2 = concat2.getBytes("UTF-8");
                        HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(CBAnalytics.this.ANALYTICS_URL).openConnection();
                        httpURLConnection2.setRequestMethod("POST");
                        httpURLConnection2.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                        httpURLConnection2.setRequestProperty("Content-Length", String.valueOf(concat2.length()));
                        httpURLConnection2.setDoOutput(true);
                        httpURLConnection2.getOutputStream().write(bytes2);
                        int responseCode2 = httpURLConnection2.getResponseCode();
                        InputStream inputStream2 = httpURLConnection2.getInputStream();
                        StringBuffer stringBuffer2 = new StringBuffer();
                        byte[] bArr2 = new byte[1024];
                        while (true) {
                            int read3 = inputStream2.read(bArr2);
                            if (read3 == -1) {
                                break;
                            }
                            stringBuffer2.append(new String(bArr2, 0, read3));
                        }
                        if (responseCode2 == 200) {
                            CBAnalytics.this.mActivity.deleteFile("mr_local_cache");
                        } else {
                            FileOutputStream openFileOutput2 = CBAnalytics.this.mActivity.openFileOutput("mr_local_cache", 0);
                            openFileOutput2.write(trim2.getBytes());
                            openFileOutput2.close();
                        }
                    }
                } catch (Throwable th) {
                    String str2 = str;
                    Throwable th2 = th;
                    String str3 = str2;
                    int size3 = CBAnalytics.this.mBuffer.size();
                    while (size3 > 0) {
                        size3--;
                        str3 = str3 + CBAnalytics.this.mBuffer.get(size3) + "\r\n";
                        if (size3 >= 0 && CBAnalytics.this.mBuffer.size() > size3) {
                            CBAnalytics.this.mBuffer.remove(size3);
                        }
                    }
                    String trim3 = str3.trim();
                    if (trim3.length() > 0) {
                        String concat3 = "command=sdkWs&var1=".concat(String.valueOf(trim3));
                        try {
                            byte[] bytes3 = concat3.getBytes("UTF-8");
                            HttpURLConnection httpURLConnection3 = (HttpURLConnection) new URL(CBAnalytics.this.ANALYTICS_URL).openConnection();
                            httpURLConnection3.setRequestMethod("POST");
                            httpURLConnection3.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                            httpURLConnection3.setRequestProperty("Content-Length", String.valueOf(concat3.length()));
                            httpURLConnection3.setDoOutput(true);
                            httpURLConnection3.getOutputStream().write(bytes3);
                            int responseCode3 = httpURLConnection3.getResponseCode();
                            InputStream inputStream3 = httpURLConnection3.getInputStream();
                            StringBuffer stringBuffer3 = new StringBuffer();
                            byte[] bArr3 = new byte[1024];
                            while (true) {
                                int read4 = inputStream3.read(bArr3);
                                if (read4 == -1) {
                                    break;
                                }
                                stringBuffer3.append(new String(bArr3, 0, read4));
                            }
                            if (responseCode3 == 200) {
                                CBAnalytics.this.mActivity.deleteFile("mr_local_cache");
                            } else {
                                FileOutputStream openFileOutput3 = CBAnalytics.this.mActivity.openFileOutput("mr_local_cache", 0);
                                openFileOutput3.write(trim3.getBytes());
                                openFileOutput3.close();
                            }
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        } catch (MalformedURLException e6) {
                        } catch (ProtocolException e7) {
                        }
                    }
                    throw th2;
                }
                if (CBAnalytics.this.mBuffer.size() > 0) {
                    CBAnalytics.this.resetTimer();
                }
                CBAnalytics.this.releaseLock();
            }
        }, 5000);
    }

    /* access modifiers changed from: package-private */
    public synchronized void setLock() {
        this.mIsLocked = true;
    }

    /* access modifiers changed from: package-private */
    public synchronized void releaseLock() {
        this.mIsLocked = false;
    }

    public void callMixPanel(String str, String str2, String str3) {
        try {
            log(getLogMessage(str.toLowerCase(), str2, str3));
        } catch (Exception e) {
            Log.e("#### PAYU", "MR Unable to add properties to JSONObject", e);
        }
    }

    public String getLogMessage(String str, String str2, String str3) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(this.mActivity.getPackageName());
            sb.append(",");
            if (str2 == null) {
                str2 = "";
            }
            sb.append(str2);
            sb.append(",");
            sb.append(System.currentTimeMillis());
            sb.append(",");
            sb.append(str3);
            sb.append(",");
            sb.append(str);
            String sb2 = sb.toString();
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.reset();
            instance.update(sb2.getBytes());
            BigInteger bigInteger = new BigInteger(1, instance.digest());
            return sb2 + "," + bigInteger.toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}

package com.facebook.react.modules.systeminfo;

import android.content.Context;
import android.os.Build;
import com.facebook.common.logging.FLog;
import com.xiaomi.smarthome.R;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Locale;

public class AndroidInfoHelpers {
    private static final String TAG = "AndroidInfoHelpers";
    private static String metroHostPropValue;

    private static boolean isRunningOnGenymotion() {
        return Build.FINGERPRINT.contains("vbox");
    }

    private static boolean isRunningOnStockEmulator() {
        return Build.FINGERPRINT.contains("generic");
    }

    public static String getServerHost(Integer num) {
        return getServerIpAddress(num.intValue());
    }

    public static String getServerHost(Context context) {
        return getServerIpAddress(getDevServerPort(context).intValue());
    }

    public static String getAdbReverseTcpCommand(Integer num) {
        return "adb reverse tcp:" + num + " tcp:" + num;
    }

    public static String getAdbReverseTcpCommand(Context context) {
        return getAdbReverseTcpCommand(getDevServerPort(context));
    }

    public static String getInspectorProxyHost(Context context) {
        return getServerIpAddress(getInspectorProxyPort(context).intValue());
    }

    public static String getFriendlyDeviceName() {
        if (isRunningOnGenymotion()) {
            return Build.MODEL;
        }
        return Build.MODEL + " - " + Build.VERSION.RELEASE + " - API " + Build.VERSION.SDK_INT;
    }

    private static Integer getDevServerPort(Context context) {
        return Integer.valueOf(context.getResources().getInteger(R.integer.react_native_dev_server_port));
    }

    private static Integer getInspectorProxyPort(Context context) {
        return Integer.valueOf(context.getResources().getInteger(R.integer.react_native_dev_server_port));
    }

    private static String getServerIpAddress(int i) {
        String metroHostPropValue2 = getMetroHostPropValue();
        if (metroHostPropValue2.equals("")) {
            if (isRunningOnGenymotion()) {
                metroHostPropValue2 = "10.0.3.2";
            } else {
                metroHostPropValue2 = isRunningOnStockEmulator() ? "10.0.2.2" : "localhost";
            }
        }
        return String.format(Locale.US, "%s:%d", metroHostPropValue2, Integer.valueOf(i));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003f, code lost:
        if (r2 == null) goto L_0x006b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        r2.destroy();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0068, code lost:
        if (r2 == null) goto L_0x006b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        r1 = com.facebook.react.modules.systeminfo.AndroidInfoHelpers.metroHostPropValue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x006e, code lost:
        return r1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0065 A[SYNTHETIC, Splitter:B:37:0x0065] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0072 A[SYNTHETIC, Splitter:B:47:0x0072] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0077 A[SYNTHETIC, Splitter:B:51:0x0077] */
    private static synchronized String getMetroHostPropValue() {
        Process process;
        Exception e;
        synchronized (AndroidInfoHelpers.class) {
            if (metroHostPropValue != null) {
                String str = metroHostPropValue;
                return str;
            }
            BufferedReader bufferedReader = null;
            try {
                process = Runtime.getRuntime().exec(new String[]{"/system/bin/getprop", "metro.host"});
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(process.getInputStream(), Charset.forName("UTF-8")));
                    String str2 = "";
                    while (true) {
                        try {
                            String readLine = bufferedReader2.readLine();
                            if (readLine == null) {
                                break;
                            }
                            str2 = readLine;
                        } catch (Exception e2) {
                            BufferedReader bufferedReader3 = bufferedReader2;
                            e = e2;
                            bufferedReader = bufferedReader3;
                            try {
                                FLog.w(TAG, "Failed to query for metro.host prop:", e);
                                metroHostPropValue = "";
                                if (bufferedReader != null) {
                                }
                            } catch (Throwable th) {
                                th = th;
                                if (bufferedReader != null) {
                                }
                                if (process != null) {
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            BufferedReader bufferedReader4 = bufferedReader2;
                            th = th2;
                            bufferedReader = bufferedReader4;
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Exception unused) {
                                }
                            }
                            if (process != null) {
                                process.destroy();
                            }
                            throw th;
                        }
                    }
                    metroHostPropValue = str2;
                    try {
                        bufferedReader2.close();
                    } catch (Exception unused2) {
                    }
                } catch (Exception e3) {
                    e = e3;
                    FLog.w(TAG, "Failed to query for metro.host prop:", e);
                    metroHostPropValue = "";
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception unused3) {
                        }
                    }
                }
            } catch (Exception e4) {
                e = e4;
                process = null;
                FLog.w(TAG, "Failed to query for metro.host prop:", e);
                metroHostPropValue = "";
                if (bufferedReader != null) {
                }
            } catch (Throwable th3) {
                th = th3;
                process = null;
                if (bufferedReader != null) {
                }
                if (process != null) {
                }
                throw th;
            }
        }
    }
}

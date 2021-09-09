package _m_j;

import android.content.Context;
import android.net.TrafficStats;
import android.os.Build;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public final class buv {

    /* renamed from: O000000o  reason: collision with root package name */
    private static boolean f13300O000000o = false;
    private static AtomicBoolean O00000Oo = new AtomicBoolean(false);

    public static boolean O000000o() {
        return f13300O000000o;
    }

    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00e4 A[Catch:{ Throwable -> 0x0172, all -> 0x016f }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0145  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0155  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x015a A[SYNTHETIC, Splitter:B:45:0x015a] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0162 A[Catch:{ IOException -> 0x015e }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x018e  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0193 A[SYNTHETIC, Splitter:B:73:0x0193] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x019b A[Catch:{ IOException -> 0x0197 }] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x01a4  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x01a9 A[SYNTHETIC, Splitter:B:85:0x01a9] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x01b1 A[Catch:{ IOException -> 0x01ad }] */
    /* JADX WARNING: Unknown variable types count: 1 */
    static void O000000o(Context context) {
        HttpURLConnection httpURLConnection;
        DataInputStream dataInputStream;
        OutputStream outputStream;
        String str;
        int responseCode;
        DataInputStream dataInputStream2;
        if (O00000Oo.compareAndSet(false, true)) {
            ? r3 = 0;
            try {
                if (Build.VERSION.SDK_INT >= 14) {
                    TrafficStats.setThreadStatsTag(40965);
                }
                buh O000000o2 = bui.O000000o(context);
                if (O000000o2 != null) {
                    if (!bvf.O000000o(O000000o2.O00000o)) {
                        str = O000000o2.O00000o;
                        buu.O000000o("stat: ".concat(String.valueOf(str)));
                        String concat = "HTTPDNS-".concat(String.valueOf(str));
                        String str2 = "23356390Raw" + bux.O000000o(concat);
                        httpURLConnection = (HttpURLConnection) new URL("http://adash.man.aliyuncs.com:80/man/api?ak=23356390&s=".concat(String.valueOf(bux.O00000Oo("16594f72217bece5a457b4803a48f2da" + bux.O000000o(str2) + "16594f72217bece5a457b4803a48f2da")))).openConnection();
                        httpURLConnection.setDoOutput(true);
                        httpURLConnection.setUseCaches(false);
                        String str3 = "===" + System.currentTimeMillis() + "===";
                        httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=".concat(String.valueOf(str3)));
                        String str4 = "--" + str3 + "\r\nContent-Disposition: form-data; name=\"Raw\"\r\nContent-Type: text/plain; charset=UTF-8\r\n\r\n" + concat + "\r\n--" + str3 + "--\r\n";
                        outputStream = httpURLConnection.getOutputStream();
                        outputStream.write(str4.getBytes());
                        responseCode = httpURLConnection.getResponseCode();
                        if (responseCode != 200) {
                            dataInputStream2 = new DataInputStream(httpURLConnection.getInputStream());
                            try {
                                StringBuilder sb = new StringBuilder();
                                byte[] bArr = new byte[1024];
                                while (true) {
                                    int read = dataInputStream2.read(bArr);
                                    if (read == -1) {
                                        break;
                                    }
                                    sb.append(new String(bArr, 0, read));
                                }
                                buu.O000000o("get MAN response: " + sb.toString());
                                try {
                                    if (((String) new JSONObject(sb.toString()).get("success")).equals("success")) {
                                        f13300O000000o = true;
                                    }
                                } catch (JSONException e) {
                                    buu.O000000o(e);
                                }
                            } catch (Throwable th) {
                                r3 = outputStream;
                                Throwable th2 = th;
                                dataInputStream = dataInputStream2;
                                th = th2;
                                if (httpURLConnection != null) {
                                }
                                if (r3 != 0) {
                                }
                                if (dataInputStream != null) {
                                }
                                O00000Oo.set(false);
                                throw th;
                            }
                        } else {
                            buu.O000000o("MAN API error: ".concat(String.valueOf(responseCode)));
                            dataInputStream2 = null;
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e2) {
                                e = e2;
                                buu.O000000o(e);
                                O00000Oo.set(false);
                            }
                        }
                        if (dataInputStream2 != null) {
                            dataInputStream2.close();
                        }
                        O00000Oo.set(false);
                    }
                }
                str = "ffffffffffffffffffffffff";
                buu.O000000o("stat: ".concat(String.valueOf(str)));
                String concat2 = "HTTPDNS-".concat(String.valueOf(str));
                String str22 = "23356390Raw" + bux.O000000o(concat2);
                httpURLConnection = (HttpURLConnection) new URL("http://adash.man.aliyuncs.com:80/man/api?ak=23356390&s=".concat(String.valueOf(bux.O00000Oo("16594f72217bece5a457b4803a48f2da" + bux.O000000o(str22) + "16594f72217bece5a457b4803a48f2da")))).openConnection();
                try {
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setUseCaches(false);
                    String str32 = "===" + System.currentTimeMillis() + "===";
                    httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=".concat(String.valueOf(str32)));
                    String str42 = "--" + str32 + "\r\nContent-Disposition: form-data; name=\"Raw\"\r\nContent-Type: text/plain; charset=UTF-8\r\n\r\n" + concat2 + "\r\n--" + str32 + "--\r\n";
                    outputStream = httpURLConnection.getOutputStream();
                } catch (Throwable th3) {
                    th = th3;
                    dataInputStream = null;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    if (r3 != 0) {
                        try {
                            r3.close();
                        } catch (IOException e3) {
                            buu.O000000o(e3);
                            O00000Oo.set(false);
                            throw th;
                        }
                    }
                    if (dataInputStream != null) {
                        dataInputStream.close();
                    }
                    O00000Oo.set(false);
                    throw th;
                }
                try {
                    outputStream.write(str42.getBytes());
                    responseCode = httpURLConnection.getResponseCode();
                    if (responseCode != 200) {
                    }
                    if (httpURLConnection != null) {
                    }
                    if (outputStream != null) {
                    }
                    if (dataInputStream2 != null) {
                    }
                } catch (Throwable th4) {
                    th = th4;
                    dataInputStream = null;
                    r3 = outputStream;
                    if (httpURLConnection != null) {
                    }
                    if (r3 != 0) {
                    }
                    if (dataInputStream != null) {
                    }
                    O00000Oo.set(false);
                    throw th;
                }
            } catch (Throwable th5) {
                th = th5;
                dataInputStream = null;
                httpURLConnection = null;
                if (httpURLConnection != null) {
                }
                if (r3 != 0) {
                }
                if (dataInputStream != null) {
                }
                O00000Oo.set(false);
                throw th;
            }
            O00000Oo.set(false);
        }
    }
}

package com.sina.weibo.sdk.net;

import _m_j.dbt;
import _m_j.dby;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.exception.WeiboHttpException;
import com.sina.weibo.sdk.network.IRequestParam;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.util.Set;

public class HttpManager {
    private static final String BOUNDARY = getBoundry();
    private static final String END_MP_BOUNDARY = ("--" + BOUNDARY + "--");
    private static final String MP_BOUNDARY = ("--" + BOUNDARY);

    private static native String calcOauthSignNative(Context context, String str, String str2);

    public static void fillCommonRequestParam(IRequestParam iRequestParam) {
    }

    static {
        System.loadLibrary("weibosdkcore");
    }

    public static String openUrl(Context context, String str, String str2, WeiboParameters weiboParameters) throws WeiboException {
        String requestHttpExecute = requestHttpExecute(context, str, str2, weiboParameters);
        dbt.O000000o("HttpManager", "Response : ".concat(String.valueOf(requestHttpExecute)));
        return requestHttpExecute;
    }

    private static String requestHttpExecute(Context context, String str, String str2, WeiboParameters weiboParameters) {
        HttpURLConnection httpURLConnection = null;
        try {
            setHttpCommonParam(context, weiboParameters);
            if ("GET".equals(str2)) {
                httpURLConnection = ConnectionFactory.createConnect(str + "?" + weiboParameters.encodeUrl(), context);
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setInstanceFollowRedirects(true);
                httpURLConnection.connect();
            } else {
                httpURLConnection = ConnectionFactory.createConnect(str, context);
                httpURLConnection.setInstanceFollowRedirects(true);
                httpURLConnection.connect();
                if (weiboParameters.hasBinaryData()) {
                    DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                    buildParams(dataOutputStream, weiboParameters);
                    dataOutputStream.flush();
                    dataOutputStream.close();
                } else {
                    DataOutputStream dataOutputStream2 = new DataOutputStream(httpURLConnection.getOutputStream());
                    dataOutputStream2.write(weiboParameters.encodeUrl().getBytes("UTF-8"));
                    dataOutputStream2.flush();
                    dataOutputStream2.close();
                }
            }
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200) {
                String readConnectResponse = readConnectResponse(httpURLConnection, false);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return readConnectResponse;
            }
            throw new WeiboHttpException(readConnectResponse(httpURLConnection, true), responseCode);
        } catch (IOException e) {
            e.printStackTrace();
            throw new WeiboException(e);
        } catch (Throwable th) {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:6|7|(2:(3:9|10|(1:12)(1:46))|13)|(2:18|19)|20|21|22) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x003a */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0058 A[SYNTHETIC, Splitter:B:38:0x0058] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x005d A[SYNTHETIC, Splitter:B:42:0x005d] */
    /* JADX WARNING: Unknown variable types count: 1 */
    private static String readConnectResponse(HttpURLConnection httpURLConnection, boolean z) {
        ByteArrayOutputStream byteArrayOutputStream;
        IOException e;
        InputStream inputStream;
        ? r1 = 0;
        try {
            byte[] bArr = new byte[8192];
            if (z) {
                inputStream = httpURLConnection.getErrorStream();
            } else {
                inputStream = httpURLConnection.getInputStream();
            }
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                if (inputStream != null) {
                    while (true) {
                        try {
                            int read = inputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, read);
                        } catch (IOException e2) {
                            e = e2;
                            r1 = inputStream;
                            try {
                                throw new WeiboException(e);
                            } catch (Throwable th) {
                                th = th;
                                r1 = r1;
                                if (r1 != 0) {
                                    try {
                                        r1.close();
                                    } catch (Exception unused) {
                                    }
                                }
                                if (byteArrayOutputStream != null) {
                                    try {
                                        byteArrayOutputStream.close();
                                    } catch (Exception unused2) {
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            r1 = inputStream;
                            th = th2;
                            if (r1 != 0) {
                            }
                            if (byteArrayOutputStream != null) {
                            }
                            throw th;
                        }
                    }
                    r1 = new String(byteArrayOutputStream.toByteArray(), "UTF-8");
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                byteArrayOutputStream.close();
                return r1;
            } catch (IOException e3) {
                e = e3;
                byteArrayOutputStream = null;
                r1 = inputStream;
                throw new WeiboException(e);
            } catch (Throwable th3) {
                r1 = inputStream;
                th = th3;
                byteArrayOutputStream = null;
                if (r1 != 0) {
                }
                if (byteArrayOutputStream != null) {
                }
                throw th;
            }
        } catch (IOException e4) {
            e = e4;
            byteArrayOutputStream = null;
            throw new WeiboException(e);
        } catch (Throwable th4) {
            th = th4;
            byteArrayOutputStream = null;
            if (r1 != 0) {
            }
            if (byteArrayOutputStream != null) {
            }
            throw th;
        }
    }

    private static void setHttpCommonParam(Context context, WeiboParameters weiboParameters) {
        String str;
        String str2 = "";
        if (!TextUtils.isEmpty(weiboParameters.getAppKey())) {
            str = dby.O00000Oo(context, weiboParameters.getAppKey());
            if (!TextUtils.isEmpty(str)) {
                weiboParameters.put("aid", str);
            }
        } else {
            str = str2;
        }
        String timestamp = getTimestamp();
        weiboParameters.put("oauth_timestamp", timestamp);
        Object obj = weiboParameters.get("access_token");
        Object obj2 = weiboParameters.get("refresh_token");
        Object obj3 = weiboParameters.get("phone");
        if (obj != null && (obj instanceof String)) {
            str2 = (String) obj;
        } else if (obj2 != null && (obj2 instanceof String)) {
            str2 = (String) obj2;
        } else if (obj3 != null && (obj3 instanceof String)) {
            str2 = (String) obj3;
        }
        weiboParameters.put("oauth_sign", getOauthSign(context, str, str2, weiboParameters.getAppKey(), timestamp));
    }

    public static String openRedirectUrl4LocationUri(Context context, String str, String str2, WeiboParameters weiboParameters) {
        HttpURLConnection httpURLConnection;
        if (str2.equals("GET")) {
            if (str.endsWith("?")) {
                str = str + weiboParameters.encodeUrl();
            } else {
                str = str + "?" + weiboParameters.encodeUrl();
            }
            httpURLConnection = ConnectionFactory.createConnect(str, context);
        } else {
            httpURLConnection = ConnectionFactory.createConnect(str, context);
        }
        try {
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.connect();
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode != 302) {
                if (responseCode != 301) {
                    if (responseCode == 200) {
                        return str;
                    }
                    return "";
                }
            }
            return httpURLConnection.getHeaderField("Location");
        } catch (Exception unused) {
            return "";
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(19:17|18|19|20|21|22|23|(1:25)(1:26)|27|(2:29|(1:31)(2:32|33))(1:34)|35|(2:36|(1:38)(1:56))|39|(2:41|(1:43)(3:44|45|46))|47|48|49|51|52) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x0054 */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x005c A[Catch:{ Exception -> 0x00cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0061 A[Catch:{ Exception -> 0x00cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x007c A[Catch:{ Exception -> 0x00cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0091 A[Catch:{ Exception -> 0x00cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00ab A[Catch:{ Exception -> 0x00cf }, LOOP:0: B:36:0x00a4->B:38:0x00ab, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00ba A[Catch:{ Exception -> 0x00cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00b0 A[EDGE_INSN: B:56:0x00b0->B:39:0x00b0 ?: BREAK  , SYNTHETIC] */
    public static synchronized String downloadFile(Context context, String str, String str2, String str3) throws WeiboException {
        long j;
        long j2;
        synchronized (HttpManager.class) {
            File file = new File(str2);
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, str3);
            if (file2.exists()) {
                String path = file2.getPath();
                return path;
            } else if (!URLUtil.isValidUrl(str)) {
                return "";
            } else {
                File file3 = new File(str2, str3 + "_temp");
                HttpURLConnection createConnect = ConnectionFactory.createConnect(str, context);
                createConnect.setConnectTimeout(300000);
                createConnect.setReadTimeout(300000);
                createConnect.setRequestMethod("GET");
                if (!file3.exists()) {
                    j = file3.length();
                } else {
                    file3.createNewFile();
                    j = 0;
                }
                createConnect.setRequestProperty("RANGE", "bytes=".concat(String.valueOf(j)));
                int responseCode = createConnect.getResponseCode();
                if (responseCode != 206) {
                    j2 = 0;
                } else if (responseCode == 200) {
                    j2 = (long) createConnect.getContentLength();
                } else {
                    throw new WeiboHttpException(readConnectResponse(createConnect, true), responseCode);
                }
                InputStream inputStream = createConnect.getInputStream();
                RandomAccessFile randomAccessFile = new RandomAccessFile(file3, "rw");
                randomAccessFile.seek(0);
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read != -1) {
                        break;
                    }
                    randomAccessFile.write(bArr, 0, read);
                }
                randomAccessFile.close();
                inputStream.close();
                if (j2 != 0) {
                    if (file3.length() >= j2) {
                        file3.renameTo(file2);
                        String path2 = file2.getPath();
                        return path2;
                    }
                }
                file3.delete();
                return "";
            }
        }
    }

    public static void buildParams(OutputStream outputStream, WeiboParameters weiboParameters) throws WeiboException {
        try {
            Set<String> keySet = weiboParameters.keySet();
            for (String next : keySet) {
                if (weiboParameters.get(next) instanceof String) {
                    StringBuilder sb = new StringBuilder(100);
                    sb.setLength(0);
                    sb.append(MP_BOUNDARY);
                    sb.append("\r\n");
                    sb.append("content-disposition: form-data; name=\"");
                    sb.append(next);
                    sb.append("\"\r\n\r\n");
                    sb.append(weiboParameters.get(next));
                    sb.append("\r\n");
                    outputStream.write(sb.toString().getBytes());
                }
            }
            for (String next2 : keySet) {
                Object obj = weiboParameters.get(next2);
                if (obj instanceof Bitmap) {
                    outputStream.write((MP_BOUNDARY + "\r\n" + "content-disposition: form-data; name=\"" + next2 + "\"; filename=\"file\"\r\n" + "Content-Type: application/octet-stream; charset=utf-8\r\n\r\n").getBytes());
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    ((Bitmap) obj).compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                    outputStream.write(byteArrayOutputStream.toByteArray());
                    outputStream.write("\r\n".getBytes());
                } else if (obj instanceof ByteArrayOutputStream) {
                    outputStream.write((MP_BOUNDARY + "\r\n" + "content-disposition: form-data; name=\"" + next2 + "\"; filename=\"file\"\r\n" + "Content-Type: application/octet-stream; charset=utf-8\r\n\r\n").getBytes());
                    ByteArrayOutputStream byteArrayOutputStream2 = (ByteArrayOutputStream) obj;
                    outputStream.write(byteArrayOutputStream2.toByteArray());
                    outputStream.write("\r\n".getBytes());
                    byteArrayOutputStream2.close();
                }
            }
            outputStream.write(("\r\n" + END_MP_BOUNDARY).getBytes());
        } catch (IOException e) {
            throw new WeiboException(e);
        }
    }

    public static String getBoundry() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 1; i < 12; i++) {
            long currentTimeMillis = System.currentTimeMillis() + ((long) i);
            long j = currentTimeMillis % 3;
            if (j == 0) {
                stringBuffer.append(((char) ((int) currentTimeMillis)) % 9);
            } else if (j == 1) {
                stringBuffer.append((char) ((int) ((currentTimeMillis % 26) + 65)));
            } else {
                stringBuffer.append((char) ((int) ((currentTimeMillis % 26) + 97)));
            }
        }
        return stringBuffer.toString();
    }

    private static String getTimestamp() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    public static String getOauthSign(Context context, String str, String str2, String str3, String str4) {
        StringBuilder sb = new StringBuilder("");
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            sb.append(str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            sb.append(str3);
        }
        return calcOauthSignNative(context, sb.toString(), str4);
    }
}

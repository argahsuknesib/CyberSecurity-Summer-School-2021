package com.xiaomi.smarthome.framework.plugin.rn.nativemodule;

import _m_j.dbj;
import _m_j.dn;
import _m_j.dr;
import _m_j.dxx;
import _m_j.fwz;
import _m_j.fyc;
import _m_j.fyf;
import _m_j.fyp;
import _m_j.fys;
import _m_j.fyt;
import _m_j.fyu;
import _m_j.fzo;
import _m_j.fzp;
import _m_j.fzu;
import _m_j.fzw;
import _m_j.fzy;
import _m_j.fzz;
import _m_j.gaa;
import _m_j.gad;
import _m_j.gaf;
import _m_j.gag;
import _m_j.gai;
import _m_j.gaq;
import _m_j.gbh;
import _m_j.gbi;
import _m_j.gbk;
import _m_j.gbm;
import _m_j.gbo;
import _m_j.gbq;
import _m_j.gbt;
import _m_j.gbu;
import _m_j.gbv;
import _m_j.gbx;
import _m_j.gby;
import _m_j.goq;
import _m_j.got;
import _m_j.gpg;
import _m_j.gsc;
import _m_j.gsy;
import _m_j.jdn;
import _m_j.md;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.os.StatFs;
import android.provider.DocumentsContract;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.Utils.MediaStoreUtil;
import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.MapView;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.uimanager.UIManagerModule;
import com.shockwave.pdfium.PdfPasswordException;
import com.shockwave.pdfium.PdfiumCore;
import com.shockwave.pdfium.util.Size;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.entity.Error;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.framework.plugin.rn.report.RnNetReport;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.GZIPInputStream;
import java.util.zip.Inflater;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class MIOTPersistModule extends MIOTBaseJavaModule {
    private static final String TAG = "com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTPersistModule";
    private Set mAlbumLegalModelSet;
    private Map<String, O000000o> mFileDownloadTaskMap = new ConcurrentHashMap();
    private Set mSaveNotesAppLegalModelSet;

    private int getEachCallbackTime(long j) {
        if (j < 10485760) {
            return 100;
        }
        return j < 104857600 ? 300 : 1000;
    }

    public String getName() {
        return "MIOTFile";
    }

    public MIOTPersistModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public Map<String, Object> getConstants() {
        HashMap hashMap = new HashMap();
        hashMap.put("storageBasePath", getFilesPath().getAbsolutePath());
        return hashMap;
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX INFO: additional move instructions added (5) to help type inference */
    /* JADX INFO: additional move instructions added (2) to help type inference */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v0, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v2, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v5, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v7, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v13, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v16, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v23, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v25, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v27, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v28, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v29, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v31, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v32, resolved type: java.net.HttpURLConnection} */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0146, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0147, code lost:
        r7 = r14;
        r10 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x014a, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x014b, code lost:
        r7 = r14;
        r10 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x019f, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x01a0, code lost:
        r12 = null;
        r10 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01a3, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x01a4, code lost:
        r12 = null;
        r10 = r9;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x01ed A[SYNTHETIC, Splitter:B:103:0x01ed] */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x01f2 A[Catch:{ Exception -> 0x01fa }] */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x01f7 A[Catch:{ Exception -> 0x01fa }] */
    /* JADX WARNING: Removed duplicated region for block: B:125:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0146 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:48:0x0113] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x019f A[ExcHandler: all (th java.lang.Throwable), Splitter:B:4:0x001d] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x01db A[SYNTHETIC, Splitter:B:94:0x01db] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x01e0 A[Catch:{ Exception -> 0x01e9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x01e5 A[Catch:{ Exception -> 0x01e9 }] */
    public static void download(String str, String str2, HashMap<String, Object> hashMap, String str3, int i, int i2, Callback callback) {
        BufferedInputStream bufferedInputStream;
        HttpURLConnection httpURLConnection;
        int i3;
        int i4;
        HttpURLConnection httpURLConnection2;
        HttpURLConnection httpURLConnection3;
        HttpURLConnection httpURLConnection4;
        int i5;
        FileOutputStream fileOutputStream;
        String str4 = str3;
        Callback callback2 = callback;
        int i6 = -1;
        FileOutputStream fileOutputStream2 = null;
        try {
            URL url = new URL(str2);
            dxx.O000000o();
            HttpURLConnection httpURLConnection5 = (HttpURLConnection) dxx.O000000o(url);
            if (hashMap != null) {
                try {
                    for (Map.Entry next : hashMap.entrySet()) {
                        Object value = next.getValue();
                        if (value != null) {
                            httpURLConnection5.setRequestProperty(URLEncoder.encode((String) next.getKey()), URLEncoder.encode(value.toString()));
                        }
                    }
                } catch (Throwable th) {
                }
            }
            httpURLConnection5.setConnectTimeout(i);
            httpURLConnection5.setReadTimeout(i2);
            httpURLConnection5.connect();
            int responseCode = httpURLConnection5.getResponseCode();
            i4 = httpURLConnection5.getContentLength();
            if (responseCode != 200 && (responseCode == 301 || responseCode == 302 || responseCode == 307 || responseCode == 308)) {
                String headerField = httpURLConnection5.getHeaderField("Location");
                httpURLConnection5.disconnect();
                URL url2 = new URL(headerField);
                dxx.O000000o();
                HttpURLConnection httpURLConnection6 = (HttpURLConnection) dxx.O000000o(url2);
                try {
                    httpURLConnection6.setConnectTimeout(5000);
                    httpURLConnection6.connect();
                    i5 = httpURLConnection6.getResponseCode();
                    i4 = httpURLConnection6.getContentLength();
                    httpURLConnection4 = httpURLConnection6;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedInputStream = null;
                    httpURLConnection = "Location";
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (Exception unused) {
                            throw th;
                        }
                    }
                    if (bufferedInputStream != null) {
                        bufferedInputStream.close();
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw th;
                }
            } else {
                int i7 = responseCode;
                httpURLConnection4 = httpURLConnection5;
                i5 = i7;
            }
            WritableMap createMap = Arguments.createMap();
            if (i5 < 200 || i5 >= 300) {
                bufferedInputStream = null;
                i3 = 0;
            } else {
                for (Map.Entry next2 : httpURLConnection4.getHeaderFields().entrySet()) {
                    String str5 = (String) next2.getKey();
                    String str6 = (String) ((List) next2.getValue()).get(0);
                    if (!(str5 == null || str6 == null)) {
                        createMap.putString(str5, str6);
                    }
                }
                callback2.invoke(Boolean.TRUE, null, 0, Integer.valueOf(i4));
                bufferedInputStream = new BufferedInputStream(httpURLConnection4.getInputStream(), 8192);
                try {
                    gbi.O00000o0(str3);
                    fileOutputStream = new FileOutputStream(str4);
                } catch (Throwable th3) {
                    th = th3;
                    httpURLConnection3 = httpURLConnection4;
                    i3 = 0;
                    httpURLConnection2 = httpURLConnection3;
                    Log.e("download", "fatal", th);
                    callback2.invoke(Boolean.FALSE, gbq.O000000o(-1, Log.getStackTraceString(th)), Integer.valueOf(i3), Integer.valueOf(i4));
                    if (fileOutputStream2 != null) {
                    }
                    if (bufferedInputStream != null) {
                    }
                    if (httpURLConnection2 == null) {
                    }
                }
                try {
                    byte[] bArr = new byte[8192];
                    i3 = 0;
                    while (true) {
                        int read = bufferedInputStream.read(bArr);
                        if (read == i6) {
                            break;
                        }
                        i3 += read;
                        callback2.invoke(Boolean.TRUE, null, Integer.valueOf(i3), Integer.valueOf(i4));
                        fileOutputStream.write(bArr, 0, read);
                        i6 = -1;
                    }
                    fileOutputStream.flush();
                    fileOutputStream2 = fileOutputStream;
                } catch (Throwable th4) {
                }
            }
            try {
                WritableMap createMap2 = Arguments.createMap();
                createMap2.putInt("status", i5);
                createMap2.putString("filename", str);
                createMap2.putString("path", str4);
                createMap2.putMap("header", createMap);
                callback2.invoke(Boolean.TRUE, createMap2, Integer.valueOf(i3), Integer.valueOf(i4));
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (Exception unused2) {
                        return;
                    }
                }
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                if (httpURLConnection4 != null) {
                    httpURLConnection4.disconnect();
                }
            } catch (Throwable th5) {
                th = th5;
                httpURLConnection2 = httpURLConnection4;
                Log.e("download", "fatal", th);
                callback2.invoke(Boolean.FALSE, gbq.O000000o(-1, Log.getStackTraceString(th)), Integer.valueOf(i3), Integer.valueOf(i4));
                if (fileOutputStream2 != null) {
                }
                if (bufferedInputStream != null) {
                }
                if (httpURLConnection2 == null) {
                }
            }
        } catch (Throwable th6) {
            th = th6;
            httpURLConnection = null;
            bufferedInputStream = null;
            if (fileOutputStream2 != null) {
            }
            if (bufferedInputStream != null) {
            }
            if (httpURLConnection != null) {
            }
            throw th;
        }
    }

    static final URLConnection openConnection_aroundBody0(URL url) {
        return url.openConnection();
    }

    static final URLConnection openConnection_aroundBody2(URL url) {
        return url.openConnection();
    }

    /* JADX WARNING: Removed duplicated region for block: B:124:0x0306 A[SYNTHETIC, Splitter:B:124:0x0306] */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x030d A[SYNTHETIC, Splitter:B:128:0x030d] */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0314 A[SYNTHETIC, Splitter:B:132:0x0314] */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x031b A[SYNTHETIC, Splitter:B:137:0x031b] */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x0322 A[SYNTHETIC, Splitter:B:141:0x0322] */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x0329 A[SYNTHETIC, Splitter:B:145:0x0329] */
    /* JADX WARNING: Removed duplicated region for block: B:169:? A[RETURN, SYNTHETIC] */
    private void downloadSupportBreakLoad(String str, String str2, HashMap<String, Object> hashMap, String str3, int i, int i2, ReadableMap readableMap, String str4, Callback callback) {
        InputStream inputStream;
        RandomAccessFile randomAccessFile;
        Response response;
        int i3;
        long j;
        String str5;
        String str6;
        Request request;
        InputStream inputStream2;
        String str7 = str;
        String str8 = str3;
        String str9 = str4;
        Callback callback2 = callback;
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            removeDownloadFileTask(str9);
            callback2.invoke(Boolean.FALSE, gbq.O000000o(-1, "url or filePathName is empty"));
            return;
        }
        boolean O00000o0 = gbv.O00000o0(readableMap, "allow_private_certificates");
        try {
            Object[] downloadFileLengthAndUrl = getDownloadFileLengthAndUrl(str2, hashMap, i, i2, O00000o0);
            if (downloadFileLengthAndUrl == null || downloadFileLengthAndUrl.length < 2) {
                removeDownloadFileTask(str9);
                gbu.O00000Oo("download file error, file info length is less than 2");
            } else if (TextUtils.isEmpty(str4) || !taskIsCancelLoadFile(str9)) {
                RnNetReport.reportDownloadFileURL(str2);
                try {
                    long longValue = ((Long) downloadFileLengthAndUrl[0]).longValue();
                    String obj = downloadFileLengthAndUrl[1].toString();
                    File file = new File(getTempFilesPath() + File.separator + gbk.O000000o(str2));
                    randomAccessFile = new RandomAccessFile(file, "rwd");
                    try {
                        long j2 = 0;
                        if (file.exists()) {
                            try {
                                j = file.length();
                                randomAccessFile.seek(j);
                            } catch (Exception e) {
                                e = e;
                                i3 = 2;
                                response = null;
                                inputStream = null;
                            } catch (Throwable th) {
                                th = th;
                                response = null;
                                inputStream = null;
                                if (randomAccessFile != null) {
                                }
                                if (inputStream != null) {
                                }
                                if (response != null) {
                                }
                                throw th;
                            }
                        } else {
                            j = 0;
                        }
                        String str10 = "current task is cancel, task id is ";
                        String str11 = obj;
                        boolean z = O00000o0;
                        if (longValue == -1 || longValue >= j) {
                            String str12 = "header";
                            OkHttpClient O000000o2 = fyu.O000000o().O000000o(z);
                            if (longValue != -1) {
                                str5 = "path";
                                Request.Builder url = new Request.Builder().url(str11);
                                str6 = "filename";
                                request = url.addHeader("Range", "bytes=" + j + "-" + longValue).build();
                            } else {
                                str5 = "path";
                                String str13 = str11;
                                str6 = "filename";
                                request = new Request.Builder().url(str13).build();
                            }
                            response = O000000o2.newCall(request).execute();
                            try {
                                inputStream2 = response.body().byteStream();
                                try {
                                    callback2.invoke(Boolean.TRUE, null, Long.valueOf(j), Long.valueOf(longValue));
                                    byte[] bArr = new byte[8192];
                                    int eachCallbackTime = getEachCallbackTime(longValue);
                                    while (true) {
                                        int read = inputStream2.read(bArr);
                                        inputStream = inputStream2;
                                        if (read == -1) {
                                            break;
                                        }
                                        try {
                                            if (!fwz.O000000o().O00000Oo().O0000oo0 || !taskIsLoadingFile(str9)) {
                                                break;
                                            }
                                            randomAccessFile.write(bArr, 0, read);
                                            j += (long) read;
                                            long currentTimeMillis = System.currentTimeMillis();
                                            long j3 = currentTimeMillis;
                                            if (currentTimeMillis - j2 <= ((long) eachCallbackTime)) {
                                                if (j != longValue) {
                                                    j3 = j2;
                                                    inputStream2 = inputStream;
                                                    j2 = j3;
                                                }
                                            }
                                            callback2.invoke(Boolean.TRUE, null, Long.valueOf(j), Long.valueOf(longValue));
                                            inputStream2 = inputStream;
                                            j2 = j3;
                                        } catch (Exception e2) {
                                            e = e2;
                                        }
                                    }
                                    if (j >= longValue) {
                                        removeDownloadFileTask(str9);
                                        File file2 = new File(str8);
                                        if (file2.exists()) {
                                            file2.delete();
                                        } else {
                                            file2.getParentFile().mkdirs();
                                        }
                                        file.renameTo(file2);
                                        WritableMap createMap = Arguments.createMap();
                                        Headers headers = response.headers();
                                        WritableMap createMap2 = Arguments.createMap();
                                        int i4 = 0;
                                        for (int size = headers.size(); i4 < size; size = size) {
                                            createMap2.putString(headers.name(i4), headers.value(i4));
                                            i4++;
                                        }
                                        createMap.putInt("status", response.code());
                                        createMap.putString(str6, str);
                                        createMap.putString(str5, str8);
                                        createMap.putMap(str12, createMap2);
                                        callback2.invoke(Boolean.TRUE, createMap, Double.valueOf((double) j), Double.valueOf((double) longValue));
                                    } else if (taskIsCancelLoadFile(str9)) {
                                        i3 = 2;
                                        try {
                                            Object[] objArr = new Object[2];
                                            objArr[0] = Boolean.FALSE;
                                            objArr[1] = gbq.O000000o(-1, str10.concat(String.valueOf(str4)));
                                            callback2.invoke(objArr);
                                        } catch (Exception e3) {
                                            e = e3;
                                            try {
                                                Object[] objArr2 = new Object[i3];
                                                objArr2[0] = Boolean.FALSE;
                                                objArr2[1] = gbq.O000000o(-1, e.toString());
                                                callback2.invoke(objArr2);
                                                if (randomAccessFile != null) {
                                                    try {
                                                        randomAccessFile.close();
                                                    } catch (IOException unused) {
                                                    }
                                                }
                                                if (inputStream != null) {
                                                    try {
                                                        inputStream.close();
                                                    } catch (IOException unused2) {
                                                    }
                                                }
                                                if (response != null) {
                                                    try {
                                                        response.close();
                                                        return;
                                                    } catch (Exception unused3) {
                                                        return;
                                                    }
                                                } else {
                                                    return;
                                                }
                                            } catch (Throwable th2) {
                                                th = th2;
                                                if (randomAccessFile != null) {
                                                }
                                                if (inputStream != null) {
                                                }
                                                if (response != null) {
                                                }
                                                throw th;
                                            }
                                        }
                                    }
                                    try {
                                        randomAccessFile.close();
                                    } catch (IOException unused4) {
                                    }
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (IOException unused5) {
                                        }
                                    }
                                    if (response != null) {
                                        try {
                                            response.close();
                                        } catch (Exception unused6) {
                                        }
                                    }
                                } catch (Exception e4) {
                                    e = e4;
                                    inputStream = inputStream2;
                                    i3 = 2;
                                    Object[] objArr22 = new Object[i3];
                                    objArr22[0] = Boolean.FALSE;
                                    objArr22[1] = gbq.O000000o(-1, e.toString());
                                    callback2.invoke(objArr22);
                                    if (randomAccessFile != null) {
                                    }
                                    if (inputStream != null) {
                                    }
                                    if (response != null) {
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    inputStream = inputStream2;
                                    if (randomAccessFile != null) {
                                    }
                                    if (inputStream != null) {
                                    }
                                    if (response != null) {
                                    }
                                    throw th;
                                }
                            } catch (Exception e5) {
                                e = e5;
                                inputStream2 = null;
                                inputStream = inputStream2;
                                i3 = 2;
                                Object[] objArr222 = new Object[i3];
                                objArr222[0] = Boolean.FALSE;
                                objArr222[1] = gbq.O000000o(-1, e.toString());
                                callback2.invoke(objArr222);
                                if (randomAccessFile != null) {
                                }
                                if (inputStream != null) {
                                }
                                if (response != null) {
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                inputStream2 = null;
                                inputStream = inputStream2;
                                if (randomAccessFile != null) {
                                }
                                if (inputStream != null) {
                                }
                                if (response != null) {
                                }
                                throw th;
                            }
                        } else {
                            removeDownloadFileTask(str9);
                            if (file.exists()) {
                                file.delete();
                            }
                            gbu.O00000Oo("download file, downLoadFileTotalLength is less than downloadedLen..." + longValue + "  " + j);
                            WritableMap createMap3 = Arguments.createMap();
                            createMap3.putInt("status", 500);
                            createMap3.putString("filename", str7);
                            createMap3.putString("path", str8);
                            createMap3.putMap("header", Arguments.createMap());
                            callback2.invoke(Boolean.TRUE, createMap3, Double.valueOf((double) j), Double.valueOf((double) longValue));
                            try {
                                randomAccessFile.close();
                            } catch (IOException unused7) {
                            }
                        }
                    } catch (Exception e6) {
                        e = e6;
                        response = null;
                        inputStream = null;
                        i3 = 2;
                        Object[] objArr2222 = new Object[i3];
                        objArr2222[0] = Boolean.FALSE;
                        objArr2222[1] = gbq.O000000o(-1, e.toString());
                        callback2.invoke(objArr2222);
                        if (randomAccessFile != null) {
                        }
                        if (inputStream != null) {
                        }
                        if (response != null) {
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        response = null;
                        inputStream = null;
                        if (randomAccessFile != null) {
                        }
                        if (inputStream != null) {
                        }
                        if (response != null) {
                        }
                        throw th;
                    }
                } catch (Exception e7) {
                    e = e7;
                    response = null;
                    randomAccessFile = null;
                    inputStream = null;
                    i3 = 2;
                    Object[] objArr22222 = new Object[i3];
                    objArr22222[0] = Boolean.FALSE;
                    objArr22222[1] = gbq.O000000o(-1, e.toString());
                    callback2.invoke(objArr22222);
                    if (randomAccessFile != null) {
                    }
                    if (inputStream != null) {
                    }
                    if (response != null) {
                    }
                } catch (Throwable th6) {
                    th = th6;
                    response = null;
                    randomAccessFile = null;
                    inputStream = null;
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException unused8) {
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused9) {
                        }
                    }
                    if (response != null) {
                        try {
                            response.close();
                        } catch (Exception unused10) {
                        }
                    }
                    throw th;
                }
            } else {
                callback2.invoke(Boolean.FALSE, gbq.O000000o(-1, "current task is cancel, task id is ".concat(String.valueOf(str4))));
            }
        } catch (Exception e8) {
            removeDownloadFileTask(str9);
            callback2.invoke(Boolean.FALSE, gbq.O000000o(-1, Log.getStackTraceString(e8)));
        }
    }

    private void addDownloadFileTask(String str) {
        if (TextUtils.isEmpty(str) || this.mFileDownloadTaskMap == null) {
            gbu.O000000o("down load file task id is empty...");
            return;
        }
        gbu.O000000o("down load file task id is  ".concat(String.valueOf(str)));
        this.mFileDownloadTaskMap.put(str, new O000000o(O000000o.f8353O000000o));
    }

    private void removeDownloadFileTask(String str) {
        Map<String, O000000o> map;
        if (!TextUtils.isEmpty(str) && (map = this.mFileDownloadTaskMap) != null) {
            map.remove(str);
        }
    }

    private boolean taskIsLoadingFile(String str) {
        Map<String, O000000o> map;
        O000000o o000000o;
        return TextUtils.isEmpty(str) || (map = this.mFileDownloadTaskMap) == null || (o000000o = map.get(str)) == null || o000000o.O00000o0 == O000000o.f8353O000000o;
    }

    private boolean taskIsCancelLoadFile(String str) {
        Map<String, O000000o> map;
        O000000o o000000o;
        return !TextUtils.isEmpty(str) && (map = this.mFileDownloadTaskMap) != null && (o000000o = map.get(str)) != null && o000000o.O00000o0 == O000000o.O00000Oo;
    }

    private Object[] getDownloadFileLengthAndUrl(String str, HashMap<String, Object> hashMap, int i, int i2, boolean z) throws Exception {
        HttpURLConnection O000000o2 = fyu.O000000o().O000000o(str, z);
        if (hashMap != null) {
            for (Map.Entry next : hashMap.entrySet()) {
                Object value = next.getValue();
                if (value != null) {
                    O000000o2.setRequestProperty(URLEncoder.encode((String) next.getKey()), URLEncoder.encode(value.toString()));
                }
            }
        }
        O000000o2.setConnectTimeout(i);
        O000000o2.setReadTimeout(i2);
        O000000o2.connect();
        int responseCode = O000000o2.getResponseCode();
        long contentLengthFromNetConnect = getContentLengthFromNetConnect(O000000o2);
        if (responseCode != 200 && (responseCode == 301 || responseCode == 302 || responseCode == 307 || responseCode == 308)) {
            str = O000000o2.getHeaderField("Location");
            O000000o2.disconnect();
            O000000o2 = fyu.O000000o().O000000o(str, z);
            O000000o2.setConnectTimeout(i);
            O000000o2.setReadTimeout(i2);
            O000000o2.connect();
            contentLengthFromNetConnect = getContentLengthFromNetConnect(O000000o2);
        }
        Object[] objArr = {Long.valueOf(contentLengthFromNetConnect), str};
        O000000o2.disconnect();
        return objArr;
    }

    private long getContentLengthFromNetConnect(HttpURLConnection httpURLConnection) {
        if (httpURLConnection == null) {
            return -1;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            return httpURLConnection.getContentLengthLong();
        }
        return (long) httpURLConnection.getContentLength();
    }

    private void deleteFile(File file) {
        if (!file.exists()) {
            return;
        }
        if (file.isDirectory()) {
            for (File deleteFile : file.listFiles()) {
                deleteFile(deleteFile);
            }
            file.delete();
            return;
        }
        file.delete();
    }

    @ReactMethod
    public final void deleteFile(String str, Callback callback) {
        if (checkFileNameValidCallBack(str, callback)) {
            try {
                File file = new File(getPathName(str));
                if (file.exists()) {
                    deleteFile(file);
                    callback.invoke(Boolean.TRUE);
                    return;
                }
                callback.invoke(Boolean.FALSE, gbq.O000000o(-1, "file path does not exist :".concat(String.valueOf(str))));
            } catch (Throwable th) {
                callback.invoke(Boolean.FALSE, gbq.O000000o(-1, Log.getStackTraceString(th)));
            }
        }
    }

    @ReactMethod
    public void isFileExists(String str, Callback callback) {
        if (checkFileNameValidCallBack(str, callback)) {
            try {
                callback.invoke(Boolean.TRUE, Boolean.valueOf(new File(getPathName(str)).exists()));
            } catch (Exception e) {
                callback.invoke(Boolean.FALSE, gbq.O000000o(-1, Log.getStackTraceString(e)));
            }
        }
    }

    @Deprecated
    @ReactMethod
    public final void readFileList(Callback callback) {
        try {
            File filesPath = getFilesPath();
            if (filesPath.exists()) {
                String[] list = filesPath.list();
                WritableNativeArray writableNativeArray = new WritableNativeArray();
                for (String putString : list) {
                    WritableNativeMap writableNativeMap = new WritableNativeMap();
                    writableNativeMap.putString("name", putString);
                    writableNativeArray.pushMap(writableNativeMap);
                }
                callback.invoke(Boolean.TRUE, writableNativeArray);
                return;
            }
            callback.invoke(Boolean.FALSE, gbq.O000000o(-1, "path does not exist"));
        } catch (Exception unused) {
            callback.invoke(Boolean.FALSE);
        }
    }

    @ReactMethod
    public final void writeFile(String str, String str2, Callback callback) {
        if (checkFileNameValidCallBack(str, callback)) {
            try {
                String pathName = getPathName(str);
                if (str2 == null) {
                    str2 = "";
                }
                writeByteAsyn(pathName, str2.getBytes(), false, callback);
            } catch (Exception e) {
                callback.invoke(Boolean.FALSE, gbq.O000000o(-1, "writeFile error:" + e.getMessage()));
            }
        }
    }

    @ReactMethod
    public void saveFileToNotesAppOnMIUI(final String str, final Callback callback) {
        gbu.O00000o("saveFileToNotesAppOnMIUI, fileName:".concat(String.valueOf(str)));
        if (checkFileNameValidCallBack(str, callback)) {
            if (!str.endsWith(".txt")) {
                callback.invoke(Boolean.FALSE, gbq.O000000o(-1, str + ",only txt file is supported"));
            } else if (!new File(getPathName(str)).exists()) {
                callback.invoke(Boolean.FALSE, gbq.O000000o(-1, str + ",file not exit"));
            } else {
                initSaveNotesAppLegalModelSetIfNeed();
                if (getDevice() == null || this.mSaveNotesAppLegalModelSet.contains(getDevice().model)) {
                    Observable.just(0).subscribeOn(Schedulers.io()).subscribe(new Action1<Integer>() {
                        /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTPersistModule.AnonymousClass1 */

                        public final /* synthetic */ void call(Object obj) {
                            try {
                                XmPluginHostApi.instance().saveStringToNotesAppOnMIUI(new String(MIOTPersistModule.this.readByte(MIOTPersistModule.this.getPathName(str))), new com.xiaomi.smarthome.device.api.Callback<Void>() {
                                    /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTPersistModule.AnonymousClass1.AnonymousClass1 */

                                    public final void onFailure(int i, String str) {
                                        Callback callback = callback;
                                        callback.invoke(Boolean.FALSE, gbq.O000000o(-4, str + "," + str));
                                    }

                                    public final /* synthetic */ void onSuccess(Object obj) {
                                        callback.invoke(Boolean.TRUE, gbq.O000000o(0, (Object) null));
                                    }
                                });
                            } catch (Throwable th) {
                                Callback callback = callback;
                                callback.invoke(Boolean.FALSE, gbq.O000000o(-3, str + "," + th.toString()));
                                StringBuilder sb = new StringBuilder("saveFileToNotesAppOnMIUI, getString error:");
                                sb.append(Log.getStackTraceString(th));
                                gbu.O00000o(sb.toString());
                            }
                        }
                    });
                    return;
                }
                callback.invoke(Boolean.FALSE, gbq.O000000o(-2, str + ",model not support"));
            }
        }
    }

    @ReactMethod
    public final void readFileListFrom(String str, Callback callback) {
        File file;
        String str2;
        Callback callback2 = callback;
        if (checkFolderValidCallBack(str, callback)) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    file = new File(getFilesPath() + File.separator + str);
                } else {
                    file = getFilesPath();
                }
                if (file.exists()) {
                    String[] list = file.list();
                    File[] listFiles = file.listFiles();
                    WritableNativeArray writableNativeArray = new WritableNativeArray();
                    int length = list.length;
                    for (int i = 0; i < length; i++) {
                        WritableNativeMap writableNativeMap = new WritableNativeMap();
                        writableNativeMap.putString("name", list[i]);
                        if (listFiles[i].isFile()) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(listFiles[i].length());
                            str2 = sb.toString();
                        } else {
                            str2 = "-1";
                        }
                        writableNativeMap.putString("size", str2);
                        writableNativeMap.putInt("modifyTime", (int) (listFiles[i].lastModified() / 1000));
                        writableNativeArray.pushMap(writableNativeMap);
                    }
                    callback2.invoke(Boolean.TRUE, writableNativeArray);
                    return;
                }
                callback2.invoke(Boolean.FALSE, gbq.O000000o(-1, "path does not exist"));
            } catch (Exception e) {
                callback2.invoke(Boolean.FALSE, gbq.O000000o(-1, e.toString()));
            }
        }
    }

    @ReactMethod
    public final void readFileInfo(String str, String str2, Callback callback) {
        if (!checkFileNameValidCallBack(str, callback)) {
            gbu.O00000o0("readFileInfo,check failed,fileName:".concat(String.valueOf(str)));
        } else {
            Observable.just(0).subscribeOn(gbm.O000000o()).doOnNext(new Action1(str, str2, callback) {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.$$Lambda$MIOTPersistModule$L6rTchnOifC7KVfSUtAdN3gAr24 */
                private final /* synthetic */ String f$1;
                private final /* synthetic */ String f$2;
                private final /* synthetic */ Callback f$3;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                }

                public final void call(Object obj) {
                    MIOTPersistModule.this.lambda$readFileInfo$0$MIOTPersistModule(this.f$1, this.f$2, this.f$3, (Integer) obj);
                }
            }).subscribe();
        }
    }

    public /* synthetic */ void lambda$readFileInfo$0$MIOTPersistModule(String str, String str2, Callback callback, Integer num) {
        String str3 = str;
        String str4 = str2;
        Callback callback2 = callback;
        try {
            String pathName = getPathName(str);
            File file = new File(pathName);
            gbu.O00000o0("readFileInfo,fileName:" + str3 + ",type:" + str4);
            if (!file.exists() || !file.isFile()) {
                gbu.O00000o0("readFileInfo,file not exist or not a file");
                callback2.invoke(Boolean.FALSE, gbq.O000000o(-1, "file not exist or not a file"));
            } else if (!TextUtils.equals("micloud_file_create", str4)) {
                WritableMap createMap = Arguments.createMap();
                createMap.putString("name", file.getName());
                createMap.putInt("size", (int) file.length());
                createMap.putString("mimeType", getMimeType(pathName));
                int lastModified = (int) (file.lastModified() / 1000);
                createMap.putInt("modifyTime", lastModified);
                createMap.putInt("createTime", lastModified);
                String O000000o2 = gbx.O000000o(pathName);
                if (TextUtils.isEmpty(O000000o2)) {
                    callback2.invoke(Boolean.FALSE, gbq.O000000o(-1, "fileToSHA1 fail"));
                    return;
                }
                createMap.putString("sha1", O000000o2);
                gbu.O00000o0("readFileInfo,fileToSHA1:".concat(String.valueOf(O000000o2)));
                callback2.invoke(Boolean.TRUE, createMap);
            } else {
                RandomAccessFile randomAccessFile = new RandomAccessFile(pathName, "r");
                int length = (int) randomAccessFile.length();
                gbu.O00000o0("readFileInfo,totalLength:".concat(String.valueOf(length)));
                if (length < 0) {
                    gbu.O00000o0("readFileInfo,file length illegal");
                    callback2.invoke(Boolean.FALSE, gbq.O000000o(-1, "file length illegal"));
                    return;
                }
                WritableNativeArray writableNativeArray = new WritableNativeArray();
                for (int i = 0; i < length; i += 4194304) {
                    int i2 = length - i;
                    if (i2 >= 4194304) {
                        i2 = 4194304;
                    }
                    String O000000o3 = gbx.O000000o(randomAccessFile, i, i2);
                    String O000000o4 = gbk.O000000o(randomAccessFile, i, i2);
                    gbu.O00000o0("readFileInfo,off:" + i + ",len:" + i2);
                    gbu.O00000o0("readFileInfo,sha1:".concat(String.valueOf(O000000o3)));
                    gbu.O00000o0("readFileInfo,md5:".concat(String.valueOf(O000000o4)));
                    WritableMap createMap2 = Arguments.createMap();
                    createMap2.putString("sha1", O000000o3);
                    createMap2.putString("md5", O000000o4);
                    createMap2.putInt("size", i2);
                    createMap2.putInt("offset", i);
                    writableNativeArray.pushMap(createMap2);
                }
                callback2.invoke(Boolean.TRUE, writableNativeArray);
                randomAccessFile.close();
            }
        } catch (Throwable th) {
            gbu.O00000o0("readFileInfo," + Log.getStackTraceString(th));
            callback2.invoke(Boolean.FALSE, gbq.O000000o(-1, "fileName: " + str3 + "  " + Log.getStackTraceString(th)));
        }
    }

    @ReactMethod
    public final void appendFile(String str, String str2, Callback callback) {
        if (checkFileNameValidCallBack(str, callback)) {
            try {
                String pathName = getPathName(str);
                if (str2 == null) {
                    str2 = "";
                }
                writeByteAsyn(pathName, str2.getBytes(), true, callback);
            } catch (Exception e) {
                callback.invoke(Boolean.FALSE, gbq.O000000o(-1, "appendFile error:" + e.getMessage()));
            }
        }
    }

    @ReactMethod
    public final void writeFileThroughBase64(String str, String str2, Callback callback) {
        if (checkFileNameValidCallBack(str, callback)) {
            if (str2 == null) {
                str2 = "";
            }
            try {
                writeByteAsyn(getPathName(str), Base64.decode(str2, 2), false, callback);
            } catch (Exception e) {
                callback.invoke(Boolean.FALSE, gbq.O000000o(-1, e.toString()));
            }
        }
    }

    @ReactMethod
    public final void appendFileThroughBase64(String str, String str2, Callback callback) {
        if (checkFileNameValidCallBack(str, callback)) {
            if (str2 == null) {
                str2 = "";
            }
            try {
                writeByteAsyn(getPathName(str), Base64.decode(str2, 2), true, callback);
            } catch (Exception e) {
                callback.invoke(Boolean.FALSE, gbq.O000000o(-1, e.toString()));
            }
        }
    }

    @ReactMethod
    public final void readFile(String str, Callback callback) {
        if (checkFileNameValidCallBack(str, callback)) {
            Observable.just(0).subscribeOn(gbm.O000000o()).doOnNext(new Action1(callback, str) {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.$$Lambda$MIOTPersistModule$pSTz3qgHyFILlxx1M_xoZ31NXcw */
                private final /* synthetic */ Callback f$1;
                private final /* synthetic */ String f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void call(Object obj) {
                    MIOTPersistModule.this.lambda$readFile$1$MIOTPersistModule(this.f$1, this.f$2, (Integer) obj);
                }
            }).subscribe();
        }
    }

    public /* synthetic */ void lambda$readFile$1$MIOTPersistModule(Callback callback, String str, Integer num) {
        try {
            callback.invoke(Boolean.TRUE, new String(readByte(getPathName(str))));
        } catch (Throwable th) {
            callback.invoke(Boolean.FALSE, gbq.O000000o(-1, "fileName: " + str + "  " + Log.getStackTraceString(th)));
        }
    }

    @ReactMethod
    public final void readFileToHexString(String str, Callback callback) {
        if (checkFileNameValidCallBack(str, callback)) {
            Observable.just(0).subscribeOn(gbm.O000000o()).doOnNext(new Action1(callback, str) {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.$$Lambda$MIOTPersistModule$GYzE7qKXZx6ds2kRdMHZqhsgJmQ */
                private final /* synthetic */ Callback f$1;
                private final /* synthetic */ String f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void call(Object obj) {
                    MIOTPersistModule.this.lambda$readFileToHexString$2$MIOTPersistModule(this.f$1, this.f$2, (Integer) obj);
                }
            }).subscribe();
        }
    }

    public /* synthetic */ void lambda$readFileToHexString$2$MIOTPersistModule(Callback callback, String str, Integer num) {
        try {
            callback.invoke(Boolean.TRUE, fyf.O000000o(readByte(getPathName(str))));
        } catch (Throwable th) {
            callback.invoke(Boolean.FALSE, gbq.O000000o(-1, "fileName: " + str + "  " + Log.getStackTraceString(th)));
        }
    }

    @ReactMethod
    public final void readFileSegmentToBase64(String str, int i, int i2, Callback callback) {
        gbu.O00000o0("readFileSegmentToBase64,fileName:" + str + ",off:" + i + ",len:" + i2);
        if (!checkFileNameValidCallBack(str, callback)) {
            gbu.O00000o("readFileSegmentToBase64,checkFileNameValidCallBack fail");
        } else {
            Observable.just(0).subscribeOn(gbm.O000000o()).doOnNext(new Action1(str, callback, i, i2) {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.$$Lambda$MIOTPersistModule$yZnAXgqA6ucX7iuBuyV0udw0__o */
                private final /* synthetic */ String f$1;
                private final /* synthetic */ Callback f$2;
                private final /* synthetic */ int f$3;
                private final /* synthetic */ int f$4;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                    this.f$4 = r5;
                }

                public final void call(Object obj) {
                    MIOTPersistModule.this.lambda$readFileSegmentToBase64$3$MIOTPersistModule(this.f$1, this.f$2, this.f$3, this.f$4, (Integer) obj);
                }
            }).subscribe();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x004b A[Catch:{ Throwable -> 0x00fa, all -> 0x00f8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0066  */
    public /* synthetic */ void lambda$readFileSegmentToBase64$3$MIOTPersistModule(String str, Callback callback, int i, int i2, Integer num) {
        RandomAccessFile randomAccessFile;
        long length;
        RandomAccessFile randomAccessFile2 = null;
        try {
            if (!TextUtils.isEmpty(str)) {
                if (str.contains("test.zip")) {
                    randomAccessFile = new RandomAccessFile(new File(CommonApplication.getAppContext().getExternalFilesDir(null), "test.zip"), "r");
                    randomAccessFile2 = randomAccessFile;
                    length = (long) ((int) randomAccessFile2.length());
                    gbu.O00000o0("readFileSegmentToBase64,totalLength:".concat(String.valueOf(length)));
                    if (length >= 0) {
                        gbu.O00000o0("readFileSegmentToBase64,file illegal");
                        callback.invoke(Boolean.FALSE, gbq.O000000o(-2, "file illegal"));
                        try {
                            randomAccessFile2.close();
                            return;
                        } catch (IOException unused) {
                            return;
                        }
                    } else {
                        long j = (long) i;
                        if (length <= j) {
                            gbu.O00000o0("readFileSegmentToBase64,file off illegal");
                            callback.invoke(Boolean.FALSE, gbq.O000000o(-3, "file off illegal"));
                            try {
                                randomAccessFile2.close();
                                return;
                            } catch (IOException unused2) {
                                return;
                            }
                        } else {
                            randomAccessFile2.seek(j);
                            byte[] bArr = new byte[i2];
                            int read = randomAccessFile2.read(bArr, 0, i2);
                            gbu.O00000o0("readFileSegmentToBase64,readLen:".concat(String.valueOf(read)));
                            if (read < 0) {
                                gbu.O00000o0("readFileSegmentToBase64,file read illegal");
                                callback.invoke(Boolean.FALSE, gbq.O000000o(-4, "file read illegal"));
                                try {
                                    randomAccessFile2.close();
                                    return;
                                } catch (IOException unused3) {
                                    return;
                                }
                            } else {
                                if (read < i2) {
                                    bArr = Arrays.copyOf(bArr, read);
                                }
                                String str2 = "";
                                if (bArr != null && bArr.length > 0) {
                                    str2 = Base64.encodeToString(bArr, 2);
                                    gbu.O00000o0("readFileSegmentToBase64,encodeToString:".concat(String.valueOf(str2)));
                                }
                                WritableMap createMap = Arguments.createMap();
                                createMap.putString("content", str2);
                                createMap.putDouble("totalLength", (double) length);
                                callback.invoke(Boolean.TRUE, gbq.O000000o(0, createMap));
                                try {
                                    randomAccessFile2.close();
                                    return;
                                } catch (IOException unused4) {
                                    return;
                                }
                            }
                        }
                    }
                }
            }
            randomAccessFile = new RandomAccessFile(getPathName(str), "r");
            randomAccessFile2 = randomAccessFile;
            length = (long) ((int) randomAccessFile2.length());
            gbu.O00000o0("readFileSegmentToBase64,totalLength:".concat(String.valueOf(length)));
            if (length >= 0) {
            }
        } catch (Throwable th) {
            if (randomAccessFile2 != null) {
                try {
                    randomAccessFile2.close();
                } catch (IOException unused5) {
                }
            }
            throw th;
        }
    }

    @ReactMethod
    public final void readFileToBase64(String str, Callback callback) {
        if (checkFileNameValidCallBack(str, callback)) {
            Observable.just(0).subscribeOn(gbm.O000000o()).doOnNext(new Action1(callback, str) {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.$$Lambda$MIOTPersistModule$MNEbxWYJgxharFJeRQE5hUH6UAY */
                private final /* synthetic */ Callback f$1;
                private final /* synthetic */ String f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void call(Object obj) {
                    MIOTPersistModule.this.lambda$readFileToBase64$4$MIOTPersistModule(this.f$1, this.f$2, (Integer) obj);
                }
            }).subscribe();
        }
    }

    public /* synthetic */ void lambda$readFileToBase64$4$MIOTPersistModule(Callback callback, String str, Integer num) {
        try {
            callback.invoke(Boolean.TRUE, Base64.encodeToString(readByte(getPathName(str)), 2));
        } catch (Throwable th) {
            callback.invoke(Boolean.FALSE, gbq.O000000o(-1, "fileName: " + str + "  " + Log.getStackTraceString(th)));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x001c A[SYNTHETIC, Splitter:B:13:0x001c] */
    public byte[] readByte(String str) throws IOException {
        RandomAccessFile randomAccessFile = null;
        try {
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(str, "r");
            try {
                byte[] bArr = new byte[((int) randomAccessFile2.length())];
                randomAccessFile2.read(bArr);
                try {
                    randomAccessFile2.close();
                } catch (IOException unused) {
                }
                return bArr;
            } catch (Throwable th) {
                th = th;
                randomAccessFile = randomAccessFile2;
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            if (randomAccessFile != null) {
            }
            throw th;
        }
    }

    public String getPathName(String str) {
        if (str == null) {
            return getFilesPath() + File.separator + "defaultname";
        } else if (str.startsWith(File.separator)) {
            return getFilesPath() + str;
        } else {
            return getFilesPath() + File.separator + str;
        }
    }

    private String getUnZipFileAbsPath(String str) {
        if (TextUtils.isEmpty(str)) {
            return getFilesPath().getPath();
        }
        return getFilesPath() + File.separator + str;
    }

    @ReactMethod
    public final void dataLengthOfBase64Data(String str, Callback callback) {
        if (str == null) {
            str = "";
        }
        try {
            callback.invoke(Integer.valueOf(new String(Base64.decode(str, 2)).length()));
        } catch (Throwable th) {
            callback.invoke(0, Boolean.FALSE, Log.getStackTraceString(th));
        }
    }

    @ReactMethod
    public final void subBase64DataOfBase64Data(String str, int i, int i2, Callback callback) {
        try {
            if (str == null) {
                str = "";
            }
            String str2 = new String(Base64.decode(str, 2));
            if (i < 0 || i >= str2.length() || i2 <= 0 || i + i2 > str2.length()) {
                callback.invoke(Boolean.FALSE, "data length :" + str2.length() + " require start :" + i + " require end:" + (i + i2));
            }
            callback.invoke(Boolean.TRUE, Base64.encodeToString(str2.substring(i, i2 + i).getBytes(), 2));
        } catch (Throwable th) {
            callback.invoke(Boolean.FALSE, Log.getStackTraceString(th));
        }
    }

    public /* synthetic */ void lambda$uploadFile$5$MIOTPersistModule(final String str, String str2, ReadableMap readableMap, ReadableMap readableMap2, WritableArray writableArray, boolean z, final Callback callback, Integer num) {
        HashMap<String, Object> hashMap;
        HashMap<String, Object> hashMap2 = null;
        if (readableMap == null) {
            hashMap = null;
        } else {
            try {
                hashMap = readableMap.toHashMap();
            } catch (Exception e) {
                callback.invoke(Boolean.FALSE, Log.getStackTraceString(e));
                return;
            }
        }
        if (readableMap2 != null) {
            hashMap2 = readableMap2.toHashMap();
        }
        upload(str, str2, hashMap, hashMap2, writableArray, z, new Callback() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTPersistModule.AnonymousClass12 */

            public final void invoke(Object... objArr) {
                if (objArr == null || objArr.length <= 2 || objArr[1] != null) {
                    callback.invoke(objArr);
                    return;
                }
                try {
                    MIOTPersistModule.this.sendFileUploadProgressEvent(str, objArr[2].toString(), ((Long) objArr[3]).longValue(), ((Long) objArr[4]).longValue());
                } catch (Exception e) {
                    gbu.O00000Oo(e.toString());
                }
            }
        });
    }

    private File getFileFromUri(Uri uri) {
        if (uri == null || uri.getScheme() == null) {
            return null;
        }
        gbu.O00000o0("upload file uri : " + uri.toString());
        String scheme = uri.getScheme();
        char c = 65535;
        int hashCode = scheme.hashCode();
        if (hashCode != 3143036) {
            if (hashCode == 951530617 && scheme.equals("content")) {
                c = 0;
            }
        } else if (scheme.equals("file")) {
            c = 1;
        }
        if (c == 0) {
            return getFileFromContentUri(uri, CommonApplication.getAppContext());
        }
        if (c == 1 && uri.getPath() != null) {
            return new File(uri.getPath());
        }
        return null;
    }

    private File getFileFromContentUri(Uri uri, Context context) {
        if (uri == null) {
            return null;
        }
        try {
            Cursor query = context.getContentResolver().query(uri, new String[]{"_data"}, null, null, null);
            if (query == null) {
                return null;
            }
            query.moveToFirst();
            String string = query.getString(query.getColumnIndex("_data"));
            query.close();
            if (!TextUtils.isEmpty(string)) {
                return new File(string);
            }
            return null;
        } catch (Exception e) {
            gbu.O00000Oo(e.toString());
            return null;
        }
    }

    public /* synthetic */ void lambda$uploadFileToMiCloud$6$MIOTPersistModule(String str, String str2, ReadableMap readableMap, ReadableMap readableMap2, Callback callback, Integer num) {
        HashMap<String, Object> hashMap;
        if (readableMap == null) {
            hashMap = null;
        } else {
            try {
                hashMap = readableMap.toHashMap();
            } catch (Exception e) {
                callback.invoke(Boolean.FALSE, Log.getStackTraceString(e));
                return;
            }
        }
        doUploadFileToMiCloud(str, str2, hashMap, readableMap2, callback);
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x0226  */
    /* JADX WARNING: Removed duplicated region for block: B:113:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0200  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0205  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x020a  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x020f  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0217  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x021c  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0221  */
    private void doUploadFileToMiCloud(String str, String str2, HashMap<String, Object> hashMap, ReadableMap readableMap, Callback callback) throws Exception {
        BufferedInputStream bufferedInputStream;
        DataOutputStream dataOutputStream;
        HttpURLConnection httpURLConnection;
        BufferedReader bufferedReader;
        HttpURLConnection httpURLConnection2;
        BufferedReader bufferedReader2;
        String string;
        int i;
        int i2;
        String string2;
        byte[] bArr;
        BufferedInputStream bufferedInputStream2;
        ReadableMap readableMap2 = readableMap;
        Callback callback2 = callback;
        try {
            URL url = new URL(str);
            dxx.O000000o();
            httpURLConnection = (HttpURLConnection) dxx.O000000o(url);
            try {
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setRequestMethod(str2);
                if (hashMap != null) {
                    try {
                        for (Map.Entry next : hashMap.entrySet()) {
                            Object value = next.getValue();
                            if (value != null) {
                                httpURLConnection.setRequestProperty(URLEncoder.encode((String) next.getKey()), URLEncoder.encode(value.toString()));
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = null;
                        dataOutputStream = null;
                        bufferedInputStream = null;
                        if (httpURLConnection != null) {
                        }
                        if (dataOutputStream != null) {
                        }
                        if (bufferedInputStream != null) {
                        }
                        if (bufferedReader != null) {
                        }
                        throw th;
                    }
                }
                RnNetReport.reportUploadFileURL(str);
                dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                try {
                    string = readableMap2.getString("filename");
                    ReadableMap map = readableMap2.getMap("range");
                    i = map.getInt("start");
                    i2 = map.getInt("length");
                    string2 = readableMap2.getString("securekey");
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader = null;
                    bufferedInputStream = null;
                    if (httpURLConnection != null) {
                    }
                    if (dataOutputStream != null) {
                    }
                    if (bufferedInputStream != null) {
                    }
                    if (bufferedReader != null) {
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
                dataOutputStream = null;
                bufferedInputStream = null;
                if (httpURLConnection != null) {
                }
                if (dataOutputStream != null) {
                }
                if (bufferedInputStream != null) {
                }
                if (bufferedReader != null) {
                }
                throw th;
            }
            try {
                String pathName = getPathName(string);
                gbu.O00000o0("uploadFileToMiCloud,fileName:" + string + ",start:" + i + ",shouldUploadLength" + i2);
                fyt fyt = new fyt(new File(pathName));
                fyt.O000000o((long) i);
                fyp fyp = new fyp(fyt, new fys(got.O000000o(string2)));
                if (i2 < 8192) {
                    bArr = new byte[i2];
                } else {
                    bArr = new byte[8192];
                }
                int length = bArr.length;
                int read = fyp.read(bArr, 0, length);
                long j = 0;
                long j2 = 0;
                while (read > 0) {
                    dataOutputStream.write(bArr, 0, read);
                    j2 += (long) read;
                    long j3 = ((long) i2) - j2;
                    if (j3 <= j) {
                        break;
                    }
                    if (j3 < ((long) bArr.length)) {
                        length = (int) j3;
                    }
                    read = fyp.read(bArr, 0, length);
                    j = 0;
                }
                dataOutputStream.flush();
                fyp.close();
                bufferedInputStream2 = new BufferedInputStream(httpURLConnection.getInputStream());
            } catch (Throwable th4) {
                th = th4;
                bufferedReader = null;
                bufferedInputStream = null;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                if (dataOutputStream != null) {
                    dataOutputStream.close();
                }
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                throw th;
            }
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(bufferedInputStream2));
                try {
                    WritableMap createMap = Arguments.createMap();
                    for (Map.Entry next2 : httpURLConnection.getHeaderFields().entrySet()) {
                        createMap.putString((String) next2.getKey(), (String) ((List) next2.getValue()).get(0));
                    }
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb.append(readLine);
                        sb.append("\n");
                    }
                    String sb2 = sb.toString();
                    int responseCode = httpURLConnection.getResponseCode();
                    WritableMap createMap2 = Arguments.createMap();
                    createMap2.putString("data", sb2);
                    createMap2.putInt("status", responseCode);
                    gbu.O00000o0("uploadFileToMiCloud,status:" + responseCode + ",response:" + sb2);
                    callback2.invoke(Boolean.TRUE, createMap2);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    dataOutputStream.close();
                    bufferedInputStream2.close();
                    bufferedReader.close();
                } catch (Throwable th5) {
                    th = th5;
                    bufferedInputStream = bufferedInputStream2;
                    if (httpURLConnection != null) {
                    }
                    if (dataOutputStream != null) {
                    }
                    if (bufferedInputStream != null) {
                    }
                    if (bufferedReader != null) {
                    }
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
                bufferedInputStream = bufferedInputStream2;
                bufferedReader = null;
                if (httpURLConnection != null) {
                }
                if (dataOutputStream != null) {
                }
                if (bufferedInputStream != null) {
                }
                if (bufferedReader != null) {
                }
                throw th;
            }
        } catch (Throwable th7) {
            th = th7;
            bufferedReader = null;
            httpURLConnection = null;
            dataOutputStream = null;
            bufferedInputStream = null;
            if (httpURLConnection != null) {
            }
            if (dataOutputStream != null) {
            }
            if (bufferedInputStream != null) {
            }
            if (bufferedReader != null) {
            }
            throw th;
        }
    }

    static final URLConnection openConnection_aroundBody4(MIOTPersistModule mIOTPersistModule, URL url) {
        return url.openConnection();
    }

    @ReactMethod
    public final void mergeFiles(ReadableArray readableArray, String str, Callback callback) {
        gbu.O00000o0("mergeFiles,fileName:".concat(String.valueOf(str)));
        Observable.just(0).subscribeOn(gbm.O000000o()).doOnNext(new Action1(str, callback, readableArray) {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.$$Lambda$MIOTPersistModule$sPHuD4FwQik4_C_dj8NSVCJfHM */
            private final /* synthetic */ String f$1;
            private final /* synthetic */ Callback f$2;
            private final /* synthetic */ ReadableArray f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final void call(Object obj) {
                MIOTPersistModule.this.lambda$mergeFiles$7$MIOTPersistModule(this.f$1, this.f$2, this.f$3, (Integer) obj);
            }
        }).subscribe();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gbq.O000000o(int, java.lang.Object):com.facebook.react.bridge.WritableMap
     arg types: [int, java.lang.String]
     candidates:
      _m_j.gbq.O000000o(int, java.lang.String):com.facebook.react.bridge.WritableMap
      _m_j.gbq.O000000o(com.xiaomi.smarthome.framework.plugin.rn.constants.RnApiErrorInfo, java.lang.String):com.facebook.react.bridge.WritableMap
      _m_j.gbq.O000000o(int, java.lang.Object):com.facebook.react.bridge.WritableMap */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0132 A[SYNTHETIC, Splitter:B:59:0x0132] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x013d A[SYNTHETIC, Splitter:B:65:0x013d] */
    /* JADX WARNING: Removed duplicated region for block: B:74:? A[RETURN, SYNTHETIC] */
    public /* synthetic */ void lambda$mergeFiles$7$MIOTPersistModule(String str, Callback callback, ReadableArray readableArray, Integer num) {
        RandomAccessFile randomAccessFile = null;
        try {
            if (checkFileNameValidCallBack(str, callback)) {
                String pathName = getPathName(str);
                gbi.O00000o0(pathName);
                File file = new File(pathName);
                if (file.exists() || file.createNewFile()) {
                    RandomAccessFile randomAccessFile2 = new RandomAccessFile(pathName, "rw");
                    if (readableArray != null) {
                        int i = 0;
                        while (i < readableArray.size()) {
                            try {
                                ReadableMap O000000o2 = fyf.O000000o(readableArray, i);
                                String O000000o3 = fyf.O000000o(O000000o2, "name", "");
                                if (!checkFileNameValidCallBack(O000000o3, callback)) {
                                    try {
                                        randomAccessFile2.close();
                                        return;
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                        return;
                                    }
                                } else {
                                    File file2 = new File(getPathName(O000000o3));
                                    if (!file2.exists()) {
                                        callback.invoke(Boolean.FALSE, gbq.O000000o(-2, "file is not exist"));
                                        try {
                                            randomAccessFile2.close();
                                            return;
                                        } catch (IOException e2) {
                                            e2.printStackTrace();
                                            return;
                                        }
                                    } else {
                                        String O000000o4 = fyf.O000000o(O000000o2, "securekey", "");
                                        gbu.O00000o0("mergeFiles,mergeFileName:" + O000000o3 + ",securekey:" + O000000o4);
                                        fyp fyp = new fyp(new fyt(file2), new fys(got.O000000o(O000000o4)));
                                        byte[] bArr = new byte[8192];
                                        while (true) {
                                            int read = fyp.read(bArr);
                                            if (read <= 0) {
                                                break;
                                            }
                                            randomAccessFile2.write(bArr, 0, read);
                                        }
                                        fyp.close();
                                        i++;
                                    }
                                }
                            } catch (Exception e3) {
                                e = e3;
                                randomAccessFile = randomAccessFile2;
                                try {
                                    gbu.O00000o0("mergeFiles,exception:".concat(String.valueOf(e)));
                                    callback.invoke(Boolean.FALSE, gbq.O000000o(-5, (Object) Log.getStackTraceString(e)));
                                    if (randomAccessFile == null) {
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    randomAccessFile2 = randomAccessFile;
                                    if (randomAccessFile2 != null) {
                                        try {
                                            randomAccessFile2.close();
                                        } catch (IOException e4) {
                                            e4.printStackTrace();
                                        }
                                    }
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                if (randomAccessFile2 != null) {
                                }
                                throw th;
                            }
                        }
                    }
                    callback.invoke(Boolean.TRUE, gbq.O000000o(0, (Object) str));
                    gbu.O00000o0("mergeFiles,success:".concat(String.valueOf(str)));
                    try {
                        randomAccessFile2.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                } else {
                    callback.invoke(Boolean.FALSE, gbq.O000000o(-4, str + "not exist and create failed"));
                }
            }
        } catch (Exception e6) {
            e = e6;
            gbu.O00000o0("mergeFiles,exception:".concat(String.valueOf(e)));
            callback.invoke(Boolean.FALSE, gbq.O000000o(-5, (Object) Log.getStackTraceString(e)));
            if (randomAccessFile == null) {
                try {
                    randomAccessFile.close();
                } catch (IOException e7) {
                    e7.printStackTrace();
                }
            }
        }
    }

    public void sendFileUploadProgressEvent(String str, String str2, long j, long j2) {
        WritableMap createMap = Arguments.createMap();
        createMap.putString("uploadUrl", str);
        createMap.putString("filename", str2);
        createMap.putDouble("uploadBytes", (double) j);
        createMap.putDouble("totalBytes", (double) j2);
        createMap.putString("eventName", "fileUploadProgress_36621");
        ((DeviceEventManagerModule.RCTDeviceEventEmitter) getReactApplicationContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("fileUploadProgress_36621", createMap);
    }

    @ReactMethod
    public final void downloadFile(String str, String str2, Callback callback) {
        if (checkFolderValidCallBack(str2, callback)) {
            Observable.just(0).subscribeOn(gbm.O000000o()).doOnNext(new Action1(str2, str, callback) {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.$$Lambda$MIOTPersistModule$ctEdAKQimAmtgtvKMbtV4xSwh5o */
                private final /* synthetic */ String f$1;
                private final /* synthetic */ String f$2;
                private final /* synthetic */ Callback f$3;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                }

                public final void call(Object obj) {
                    MIOTPersistModule.this.lambda$downloadFile$8$MIOTPersistModule(this.f$1, this.f$2, this.f$3, (Integer) obj);
                }
            }).subscribe();
        }
    }

    public /* synthetic */ void lambda$downloadFile$8$MIOTPersistModule(final String str, final String str2, final Callback callback, Integer num) {
        downloadSupportBreakLoad(str, str2, null, getPathName(str), 60000, 60000, null, null, new Callback() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTPersistModule.AnonymousClass20 */

            public final void invoke(Object... objArr) {
                if (!((Boolean) objArr[0]).booleanValue()) {
                    callback.invoke(objArr);
                } else if (objArr[1] == null) {
                    MIOTPersistModule.this.sendFileDownloadProgressEvent(str2, str, ((Long) objArr[2]).longValue(), ((Long) objArr[3]).longValue());
                } else {
                    callback.invoke(objArr);
                }
            }
        });
    }

    public void sendFileDownloadProgressEvent(String str, String str2, long j, long j2) {
        WritableMap createMap = Arguments.createMap();
        createMap.putString("filename", str2);
        createMap.putString("url", str);
        createMap.putDouble("totalBytesRead", (double) j);
        createMap.putDouble("totalBytesExpectedToRead", (double) j2);
        createMap.putString("eventName", "fileDownloadProgress_36621");
        ((DeviceEventManagerModule.RCTDeviceEventEmitter) getReactApplicationContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("fileDownloadProgress_36621", createMap);
    }

    @ReactMethod
    public void downloadFileWithParams(String str, String str2, ReadableMap readableMap, Callback callback) {
        if (checkFolderValidCallBack(str2, callback)) {
            String O000000o2 = gbv.O000000o(readableMap, "taskID");
            addDownloadFileTask(O000000o2);
            Observable.just(0).subscribeOn(gbm.O000000o()).doOnNext(new Action1(str2, str, readableMap, O000000o2, callback) {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.$$Lambda$MIOTPersistModule$65pnKqSOlPfxd2Vjb1QiR9PYB0 */
                private final /* synthetic */ String f$1;
                private final /* synthetic */ String f$2;
                private final /* synthetic */ ReadableMap f$3;
                private final /* synthetic */ String f$4;
                private final /* synthetic */ Callback f$5;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                    this.f$4 = r5;
                    this.f$5 = r6;
                }

                public final void call(Object obj) {
                    MIOTPersistModule.this.lambda$downloadFileWithParams$9$MIOTPersistModule(this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, (Integer) obj);
                }
            }).subscribe();
        }
    }

    public /* synthetic */ void lambda$downloadFileWithParams$9$MIOTPersistModule(final String str, final String str2, ReadableMap readableMap, String str3, Callback callback, Integer num) {
        final Callback callback2 = callback;
        downloadSupportBreakLoad(str, str2, null, getPathName(str), 60000, 60000, readableMap, str3, new Callback() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTPersistModule.AnonymousClass21 */

            public final void invoke(Object... objArr) {
                if (!((Boolean) objArr[0]).booleanValue()) {
                    callback2.invoke(objArr);
                } else if (objArr[1] == null) {
                    MIOTPersistModule.this.sendFileDownloadProgressEvent(str2, str, ((Long) objArr[2]).longValue(), ((Long) objArr[3]).longValue());
                } else {
                    callback2.invoke(objArr);
                }
            }
        });
    }

    @ReactMethod
    public void cancelDownloadFile(String str, Callback callback) {
        if (callback != null) {
            if (TextUtils.isEmpty(str)) {
                callback.invoke(Boolean.FALSE, gbq.O000000o(-1, "taskId is empty..."));
                return;
            }
            Map<String, O000000o> map = this.mFileDownloadTaskMap;
            if (map != null) {
                O000000o o000000o = map.get(str);
                if (o000000o != null) {
                    o000000o.O00000o0 = O000000o.O00000Oo;
                    callback.invoke(Boolean.TRUE, gbq.O000000o(0, Arguments.createMap()));
                    return;
                }
                callback.invoke(Boolean.FALSE, gbq.O000000o(-1, "can not find this taskId, taskId is ".concat(String.valueOf(str))));
                return;
            }
            callback.invoke(Boolean.FALSE, gbq.O000000o(-1, "task map is null..."));
        }
    }

    private void writeByteAsyn(final String str, final byte[] bArr, final boolean z, final Callback callback) {
        Observable.create(new Observable.OnSubscribe<Error>() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTPersistModule.AnonymousClass24 */

            /* JADX WARNING: Removed duplicated region for block: B:20:0x004e A[SYNTHETIC, Splitter:B:20:0x004e] */
            /* JADX WARNING: Removed duplicated region for block: B:25:0x0055 A[SYNTHETIC, Splitter:B:25:0x0055] */
            /* JADX WARNING: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
            public final /* synthetic */ void call(Object obj) {
                RandomAccessFile randomAccessFile;
                Throwable th;
                Subscriber subscriber = (Subscriber) obj;
                try {
                    gbi.O00000o0(str);
                    randomAccessFile = new RandomAccessFile(str, "rw");
                    try {
                        if (z) {
                            randomAccessFile.seek(randomAccessFile.length());
                        } else {
                            randomAccessFile.setLength(0);
                        }
                        randomAccessFile.write(bArr);
                        subscriber.onNext(new Error(1, ""));
                        try {
                            randomAccessFile.close();
                        } catch (IOException unused) {
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            subscriber.onNext(new Error(-1, Log.getStackTraceString(th)));
                            if (randomAccessFile == null) {
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            if (randomAccessFile != null) {
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th4) {
                    th = th4;
                    randomAccessFile = null;
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException unused2) {
                        }
                    }
                    throw th;
                }
            }
        }).subscribeOn(gbm.O000000o()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<Error>() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTPersistModule.AnonymousClass22 */

            public final /* synthetic */ void call(Object obj) {
                Error error = (Error) obj;
                if (error.f6718O000000o == 1) {
                    callback.invoke(Boolean.TRUE);
                    return;
                }
                callback.invoke(Boolean.FALSE, gbq.O000000o(-1, error.O00000Oo));
            }
        }, new Action1<Throwable>() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTPersistModule.AnonymousClass23 */

            public final /* synthetic */ void call(Object obj) {
                callback.invoke(Boolean.FALSE, gbq.O000000o(-1, ((Throwable) obj).toString()));
            }
        });
    }

    @ReactMethod
    public final void unzipFile(String str, String str2, Callback callback) {
        if (checkFileNameValidCallBack(str, callback) && checkFolderValidCallBack(str2, callback)) {
            try {
                String pathName = getPathName(str);
                if (str.lastIndexOf(46) >= 0) {
                    callback.invoke(Boolean.valueOf(gbt.O000000o(pathName, getUnZipFileAbsPath(str2))));
                    return;
                }
                callback.invoke(Boolean.FALSE, gbq.O000000o(-1, "filename mast contain ‘.’ , for example plugin.zip"));
            } catch (Exception e) {
                callback.invoke(Boolean.FALSE, gbq.O000000o(-1, Log.getStackTraceString(e)));
            }
        }
    }

    @ReactMethod
    public final void ungzYunMiFile(final String str, final Callback callback) {
        goq.O000000o(new Runnable() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTPersistModule.AnonymousClass25 */

            public final void run() {
                if (MIOTPersistModule.this.checkFileNameValidCallBack(str, callback)) {
                    String str = null;
                    File file = new File(MIOTPersistModule.this.getPathName(str));
                    if (!file.exists()) {
                        Callback callback = callback;
                        callback.invoke(Boolean.FALSE, file.getAbsolutePath() + " is not exists");
                    } else if (!file.isFile()) {
                        Callback callback2 = callback;
                        callback2.invoke(Boolean.FALSE, file.getAbsolutePath() + " is not a file");
                    } else {
                        byte[] uncompress = MIOTPersistModule.this.uncompress(file);
                        if (uncompress == null) {
                            callback.invoke(Boolean.FALSE, "ungzYunMiFile error, if you want to see error detail, please use Android Studio LogCat");
                            return;
                        }
                        try {
                            str = new String(Base64.encode(uncompress, 2), "utf-8");
                        } catch (UnsupportedEncodingException e) {
                            fyc.O00000o("rn-plugin", e.toString());
                        }
                        callback.invoke(Boolean.TRUE, str);
                    }
                }
            }
        });
    }

    @ReactMethod
    public final void ungzFile(final String str, final Callback callback) {
        goq.O000000o(new Runnable() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTPersistModule.AnonymousClass2 */

            /* JADX WARNING: Removed duplicated region for block: B:37:0x0095 A[SYNTHETIC, Splitter:B:37:0x0095] */
            /* JADX WARNING: Removed duplicated region for block: B:42:0x00a3 A[SYNTHETIC, Splitter:B:42:0x00a3] */
            /* JADX WARNING: Removed duplicated region for block: B:46:0x00aa A[SYNTHETIC, Splitter:B:46:0x00aa] */
            /* JADX WARNING: Removed duplicated region for block: B:51:0x00b8 A[SYNTHETIC, Splitter:B:51:0x00b8] */
            /* JADX WARNING: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
            public final void run() {
                ByteArrayOutputStream byteArrayOutputStream;
                GZIPInputStream gZIPInputStream;
                Exception e;
                if (MIOTPersistModule.this.checkFileNameValidCallBack(str, callback)) {
                    try {
                        gZIPInputStream = new GZIPInputStream(new FileInputStream(MIOTPersistModule.this.getPathName(str)));
                        try {
                            byteArrayOutputStream = new ByteArrayOutputStream();
                            try {
                                byte[] bArr = new byte[1024];
                                while (true) {
                                    int read = gZIPInputStream.read(bArr, 0, 1024);
                                    if (read == -1) {
                                        break;
                                    }
                                    byteArrayOutputStream.write(bArr, 0, read);
                                }
                                callback.invoke(Boolean.TRUE, Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2));
                                try {
                                    gZIPInputStream.close();
                                } catch (IOException e2) {
                                    gbu.O00000Oo(e2.toString());
                                }
                            } catch (Exception e3) {
                                e = e3;
                                try {
                                    callback.invoke(Boolean.FALSE, gbq.O000000o(-1, e.toString()));
                                    gbu.O00000Oo(e.toString());
                                    if (gZIPInputStream != null) {
                                    }
                                    if (byteArrayOutputStream != null) {
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    if (gZIPInputStream != null) {
                                        try {
                                            gZIPInputStream.close();
                                        } catch (IOException e4) {
                                            gbu.O00000Oo(e4.toString());
                                        }
                                    }
                                    if (byteArrayOutputStream != null) {
                                        try {
                                            byteArrayOutputStream.close();
                                        } catch (IOException e5) {
                                            gbu.O00000Oo(e5.toString());
                                        }
                                    }
                                    throw th;
                                }
                            }
                            try {
                                byteArrayOutputStream.close();
                            } catch (IOException e6) {
                                gbu.O00000Oo(e6.toString());
                            }
                        } catch (Exception e7) {
                            Exception exc = e7;
                            byteArrayOutputStream = null;
                            e = exc;
                            callback.invoke(Boolean.FALSE, gbq.O000000o(-1, e.toString()));
                            gbu.O00000Oo(e.toString());
                            if (gZIPInputStream != null) {
                                try {
                                    gZIPInputStream.close();
                                } catch (IOException e8) {
                                    gbu.O00000Oo(e8.toString());
                                }
                            }
                            if (byteArrayOutputStream != null) {
                                byteArrayOutputStream.close();
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            byteArrayOutputStream = null;
                            if (gZIPInputStream != null) {
                            }
                            if (byteArrayOutputStream != null) {
                            }
                            throw th;
                        }
                    } catch (Exception e9) {
                        byteArrayOutputStream = null;
                        e = e9;
                        gZIPInputStream = null;
                        callback.invoke(Boolean.FALSE, gbq.O000000o(-1, e.toString()));
                        gbu.O00000Oo(e.toString());
                        if (gZIPInputStream != null) {
                        }
                        if (byteArrayOutputStream != null) {
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        gZIPInputStream = null;
                        byteArrayOutputStream = null;
                        if (gZIPInputStream != null) {
                        }
                        if (byteArrayOutputStream != null) {
                        }
                        throw th;
                    }
                }
            }
        });
    }

    @ReactMethod
    public final void ungzipFileToString(ReadableMap readableMap, Callback callback) {
        Observable.just(0).subscribeOn(gbm.O000000o()).doOnNext(new Action1(gbv.O000000o(readableMap, "fileName"), callback, gbv.O000000o(readableMap, "charsetName")) {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.$$Lambda$MIOTPersistModule$VrrmzrtYAWVB7aer7HOvwNnc6Do */
            private final /* synthetic */ String f$1;
            private final /* synthetic */ Callback f$2;
            private final /* synthetic */ String f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final void call(Object obj) {
                MIOTPersistModule.this.lambda$ungzipFileToString$10$MIOTPersistModule(this.f$1, this.f$2, this.f$3, (Integer) obj);
            }
        }).subscribe();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gbq.O000000o(int, java.lang.Object):com.facebook.react.bridge.WritableMap
     arg types: [int, java.lang.String]
     candidates:
      _m_j.gbq.O000000o(int, java.lang.String):com.facebook.react.bridge.WritableMap
      _m_j.gbq.O000000o(com.xiaomi.smarthome.framework.plugin.rn.constants.RnApiErrorInfo, java.lang.String):com.facebook.react.bridge.WritableMap
      _m_j.gbq.O000000o(int, java.lang.Object):com.facebook.react.bridge.WritableMap */
    public /* synthetic */ void lambda$ungzipFileToString$10$MIOTPersistModule(String str, Callback callback, String str2, Integer num) {
        String str3;
        String str4;
        if (checkFileNameValidCallBack(str, callback)) {
            File file = new File(getPathName(str));
            if (!file.exists()) {
                callback.invoke(Boolean.FALSE, gbq.O000000o(-2, file.getAbsolutePath() + " is not exists"));
            } else if (!file.isFile()) {
                callback.invoke(Boolean.FALSE, gbq.O000000o(-3, file.getAbsolutePath() + " is not a file"));
            } else {
                try {
                    byte[] uncompress = uncompress(file);
                    if (uncompress == null) {
                        callback.invoke(Boolean.FALSE, gbq.O000000o(-4, "ungzipToString failed:internal error"));
                        return;
                    }
                    if (TextUtils.isEmpty(str2)) {
                        str2 = "base-64";
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        str3 = str2.toLowerCase();
                    } else {
                        str3 = "base-64";
                    }
                    if (TextUtils.equals("utf-8", str3)) {
                        str4 = new String(uncompress, str3);
                    } else if (TextUtils.equals("base-64", str3)) {
                        str4 = Base64.encodeToString(uncompress, 2);
                    } else if (TextUtils.equals("hex-string", str3)) {
                        str4 = fyf.O000000o(uncompress);
                    } else if (TextUtils.equals("int-array", str3)) {
                        str4 = gby.O000000o(uncompress);
                    } else {
                        fyc.O00000o0("StringUtil", "unsupported charsetName:".concat(String.valueOf(str3)));
                        throw new UnsupportedEncodingException(String.format("%s is not supported", str3));
                    }
                    callback.invoke(Boolean.TRUE, gbq.O000000o(0, (Object) str4));
                } catch (Throwable th) {
                    fyc.O000000o(TAG, "ungzipToString error:", th);
                    callback.invoke(Boolean.FALSE, gbq.O000000o(-5, Log.getStackTraceString(th)));
                }
            }
        }
    }

    @ReactMethod
    public final void saveImageToPhotosAlbum(String str, Callback callback) {
        try {
            saveImageToPhotosDidAlbumPub(null, str, callback);
        } catch (Exception e) {
            callback.invoke(Boolean.FALSE, gbq.O000000o(-1, "saveImageToPhotosAlbum error:" + e.getMessage()));
        }
    }

    @ReactMethod
    public void saveFileToPhotosAlbum(String str, Callback callback) {
        try {
            if (checkFileNameValidCallBack(str, callback)) {
                String mimeType = getMimeType(getPathName(str));
                if (!TextUtils.isEmpty(mimeType) && mimeType.contains("image")) {
                    gbu.O00000o0("saveFileToPhotosAlbum, image");
                    saveImageToPhotosDidAlbumPub(null, str, callback);
                } else if (TextUtils.isEmpty(mimeType) || !mimeType.contains("video")) {
                    gbu.O00000o0("saveFileToPhotosAlbum, other");
                    saveFilePub(str, callback);
                } else {
                    gbu.O00000o0("saveFileToPhotosAlbum, video");
                    saveVideoToPhotosDidAlbumPub(null, str, callback);
                }
            }
        } catch (Exception e) {
            callback.invoke(Boolean.FALSE, gbq.O000000o(-1, "saveFileToPhotosAlbum error:" + e.getMessage()));
        }
    }

    private void saveFilePub(final String str, final Callback callback) {
        if (Build.VERSION.SDK_INT > 29 || (Build.VERSION.SDK_INT == 29 && !Environment.isExternalStorageLegacy())) {
            gbu.O00000o0("saveFilePub, sdk >= Q and not legacy");
            Observable.just(0).subscribeOn(Schedulers.io()).subscribe(new Action1<Integer>() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTPersistModule.AnonymousClass3 */

                public final /* synthetic */ void call(Object obj) {
                    try {
                        boolean O00000Oo2 = gbi.O00000Oo(str, MIOTPersistModule.this.getPathName(str));
                        gbu.O00000o0("saveFilePub, sdk >= Q and not legacy isSuccess:".concat(String.valueOf(O00000Oo2)));
                        if (O00000Oo2) {
                            callback.invoke(Boolean.TRUE);
                            return;
                        }
                        callback.invoke(Boolean.FALSE, gbq.O000000o(-2, "insertFileToMediaStore fail"));
                    } catch (Throwable th) {
                        callback.invoke(Boolean.FALSE, gbq.O000000o(-1, th.toString()));
                        gbu.O00000o("saveFilePub, insertFileToMediaStore error:" + Log.getStackTraceString(th));
                    }
                }
            });
            return;
        }
        gbu.O00000o0("saveFilePub, sdk < Q or legacy");
        Observable.just(0).subscribeOn(Schedulers.io()).subscribe(new Action1<Integer>() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTPersistModule.AnonymousClass4 */

            public final /* synthetic */ void call(Object obj) {
                try {
                    String str = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath() + File.separator + str;
                    if (gbi.O000000o(MIOTPersistModule.this.getPathName(str), str)) {
                        callback.invoke(Boolean.TRUE);
                    } else {
                        callback.invoke(Boolean.FALSE, gbq.O000000o(-2, "copyFileToFile fail"));
                    }
                    try {
                        Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
                        intent.setData(Uri.fromFile(new File(str)));
                        MIOTPersistModule.this.getCurrentActivity().sendBroadcast(intent);
                    } catch (Throwable th) {
                        gbu.O00000o("saveFilePub, send ACTION_MEDIA_SCANNER_SCAN_FILE broadcast error:" + Log.getStackTraceString(th));
                    }
                } catch (Exception e) {
                    callback.invoke(Boolean.FALSE, gbq.O000000o(-1, "saveFile error:" + e.getMessage()));
                }
            }
        });
    }

    @ReactMethod
    public final void saveImageToPhotosDidAlbum(String str, String str2, Callback callback) {
        if (TextUtils.isEmpty(str)) {
            callback.invoke(Boolean.FALSE, gbq.O000000o(-2, "albumName is illegal"));
            return;
        }
        try {
            saveImageToPhotosDidAlbumPub(str, str2, callback);
        } catch (Exception e) {
            callback.invoke(Boolean.FALSE, gbq.O000000o(-1, "saveImageToPhotosDidAlbum error:" + e.getMessage()));
        }
    }

    private void saveImageToPhotosDidAlbumPub(String str, String str2, Callback callback) {
        final String pathName = getPathName(str2);
        final String generateFileNameByTime = generateFileNameByTime(1, gpg.O000000o(str2));
        final String str3 = str;
        final Callback callback2 = callback;
        Observable.just(0).subscribeOn(Schedulers.io()).subscribe(new Action1<Integer>() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTPersistModule.AnonymousClass5 */

            public final /* synthetic */ void call(Object obj) {
                WritableMap writableMap;
                try {
                    MediaStoreUtil.O000000o(CommonApplication.getAppContext(), pathName, str3, generateFileNameByTime);
                    callback2.invoke(Boolean.TRUE, gbq.O000000o(0, "success"));
                } catch (MediaStoreUtil.AccessMediaError e) {
                    int errorCode = e.getErrorCode();
                    if (errorCode == -6) {
                        writableMap = gbq.O000000o(-5, "filepath cannot convert to a image");
                    } else if (errorCode == -5) {
                        writableMap = gbq.O000000o(-2, "albumName is illegal");
                    } else if (errorCode != -1) {
                        writableMap = gbq.O000000o(-100, "failed to save image");
                    } else {
                        writableMap = gbq.O000000o(-3, "path is illegal or file not exist");
                    }
                    callback2.invoke(Boolean.FALSE, writableMap);
                } catch (Exception e2) {
                    Callback callback = callback2;
                    callback.invoke(Boolean.FALSE, gbq.O000000o(-100, "saveImageToPhotosDidAlbumPub error:" + e2.getMessage()));
                }
            }
        });
    }

    private void saveVideoToPhotosDidAlbumPub(String str, String str2, Callback callback) {
        final String pathName = getPathName(str2);
        final String generateFileNameByTime = generateFileNameByTime(2, null);
        final String str3 = str;
        final Callback callback2 = callback;
        Observable.just(0).subscribeOn(Schedulers.io()).subscribe(new Action1<Integer>() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTPersistModule.AnonymousClass6 */

            public final /* synthetic */ void call(Object obj) {
                WritableMap writableMap;
                try {
                    MediaStoreUtil.O00000Oo(CommonApplication.getAppContext(), pathName, str3, generateFileNameByTime);
                    callback2.invoke(Boolean.TRUE, gbq.O000000o(0, "success"));
                } catch (MediaStoreUtil.AccessMediaError e) {
                    int errorCode = e.getErrorCode();
                    if (errorCode == -7) {
                        writableMap = gbq.O000000o(-4, "filepath cannot seek to be video file");
                    } else if (errorCode == -5) {
                        writableMap = gbq.O000000o(-2, "albumName is illegal");
                    } else if (errorCode != -1) {
                        writableMap = gbq.O000000o(-100, "failed to save video");
                    } else {
                        writableMap = gbq.O000000o(-3, "path is illegal or file not exist");
                    }
                    callback2.invoke(Boolean.FALSE, writableMap);
                } catch (Exception e2) {
                    Callback callback = callback2;
                    callback.invoke(Boolean.FALSE, gbq.O000000o(-100, "saveVideoToPhotosDidAlbumPub error:" + e2.getMessage()));
                }
            }
        });
    }

    @ReactMethod
    public final void saveVideoToPhotosDidAlbum(String str, String str2, Callback callback) {
        if (TextUtils.isEmpty(str)) {
            callback.invoke(Boolean.FALSE, gbq.O000000o(-2, "albumName is illegal"));
            return;
        }
        try {
            saveVideoToPhotosDidAlbumPub(str, str2, callback);
        } catch (Exception e) {
            callback.invoke(Boolean.FALSE, gbq.O000000o(-1, "saveVideoToPhotosDidAlbum error:" + e.getMessage()));
        }
    }

    private static String generateFileNameByTime(int i, String str) {
        int i2 = i;
        Calendar instance = Calendar.getInstance();
        int i3 = instance.get(1);
        int i4 = instance.get(2) + 1;
        int i5 = instance.get(5);
        int i6 = instance.get(11);
        int i7 = instance.get(12);
        int i8 = instance.get(13);
        int i9 = instance.get(14);
        if (i2 == 1) {
            return String.format("PIC_%d%02d%02d_%02d%02d%02d%03d.".concat(String.valueOf(str)), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9));
        } else if (i2 != 2) {
            return String.format("MIOT_%d%02d%02d_%02d%02d%02d%03d", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9));
        } else {
            return String.format("VIDEO_%d%02d%02d_%02d%02d%02d%03d.mp4", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9));
        }
    }

    @ReactMethod
    public final void getAllSourceFromPhotosDidAlbum(final String str, final Callback callback) {
        if (TextUtils.isEmpty(str)) {
            callback.invoke(Boolean.FALSE, gbq.O000000o(-2, "albumName is illegal"));
            return;
        }
        try {
            Observable.just(0).subscribeOn(Schedulers.io()).subscribe(new Action1<Integer>() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTPersistModule.AnonymousClass7 */

                public final /* synthetic */ void call(Object obj) {
                    WritableMap writableMap;
                    try {
                        List<MediaStoreUtil.O00000Oo> O000000o2 = MediaStoreUtil.O000000o(CommonApplication.getAppContext(), str);
                        List<MediaStoreUtil.O00000Oo> O00000Oo2 = MediaStoreUtil.O00000Oo(CommonApplication.getAppContext(), str);
                        ArrayList<MediaStoreUtil.O00000Oo> arrayList = new ArrayList<>();
                        if (O000000o2.size() > 0) {
                            arrayList.addAll(O000000o2);
                        }
                        if (O00000Oo2.size() > 0) {
                            arrayList.addAll(O00000Oo2);
                        }
                        WritableArray createArray = Arguments.createArray();
                        if (arrayList.size() > 0) {
                            for (MediaStoreUtil.O00000Oo o00000Oo : arrayList) {
                                if (o00000Oo != null) {
                                    createArray.pushMap(O00000Oo.O000000o(o00000Oo));
                                }
                            }
                        }
                        callback.invoke(Boolean.TRUE, gbq.O000000o(0, createArray));
                    } catch (MediaStoreUtil.AccessMediaError e) {
                        if (e.getErrorCode() != -5) {
                            writableMap = gbq.O000000o(-401, "access to photo library denied");
                        } else {
                            writableMap = gbq.O000000o(-2, "albumName is illegal");
                        }
                        callback.invoke(Boolean.FALSE, writableMap);
                    } catch (Exception e2) {
                        Callback callback = callback;
                        callback.invoke(Boolean.FALSE, gbq.O000000o(-1, "getAllSourceFromPhotosDidAlbum error:" + e2.getMessage()));
                    }
                }
            });
        } catch (Exception e) {
            callback.invoke(Boolean.FALSE, gbq.O000000o(-1, "getAllSourceFromPhotosDidAlbum error:" + e.getMessage()));
        }
    }

    private void initAlbumLegalModelSetIfNeed() {
        if (this.mAlbumLegalModelSet == null) {
            this.mAlbumLegalModelSet = new HashSet(1);
            this.mAlbumLegalModelSet.add("xiaomi.router.ra70");
        }
    }

    private void initSaveNotesAppLegalModelSetIfNeed() {
        if (this.mSaveNotesAppLegalModelSet == null) {
            this.mSaveNotesAppLegalModelSet = new HashSet(1);
            this.mSaveNotesAppLegalModelSet.add("jiqid.sxb.v1");
        }
    }

    @ReactMethod
    public final void getAssets(final String str, final Callback callback) {
        initAlbumLegalModelSetIfNeed();
        if (getDevice() != null && !this.mAlbumLegalModelSet.contains(getDevice().model)) {
            callback.invoke(Boolean.FALSE, gbq.O000000o(-3, "model not support"));
        } else if (TextUtils.isEmpty(str)) {
            callback.invoke(Boolean.FALSE, gbq.O000000o(-2, "bucketId is illegal"));
        } else {
            try {
                Observable.just(0).subscribeOn(Schedulers.io()).subscribe(new Action1<Integer>() {
                    /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTPersistModule.AnonymousClass8 */

                    public final /* synthetic */ void call(Object obj) {
                        WritableMap writableMap;
                        try {
                            List<MediaStoreUtil.O00000Oo> O00000o02 = MediaStoreUtil.O00000o0(CommonApplication.getAppContext(), str);
                            WritableArray createArray = Arguments.createArray();
                            if (O00000o02.size() > 0) {
                                for (MediaStoreUtil.O00000Oo next : O00000o02) {
                                    if (next != null) {
                                        createArray.pushMap(O00000Oo.O000000o(next));
                                    }
                                }
                            }
                            callback.invoke(Boolean.TRUE, gbq.O000000o(0, createArray));
                        } catch (MediaStoreUtil.AccessMediaError e) {
                            if (e.getErrorCode() != -5) {
                                writableMap = gbq.O000000o(-401, "access to photo library denied");
                            } else {
                                writableMap = gbq.O000000o(-2, "bucketId is illegal");
                            }
                            callback.invoke(Boolean.FALSE, writableMap);
                        } catch (Exception e2) {
                            Callback callback = callback;
                            callback.invoke(Boolean.FALSE, gbq.O000000o(-1, "getAssets error:" + e2.getMessage()));
                        }
                    }
                });
            } catch (Exception e) {
                callback.invoke(Boolean.FALSE, gbq.O000000o(-1, "getAssets error:" + e.getMessage()));
            }
        }
    }

    @ReactMethod
    public final void getAlbums(final Callback callback) {
        initAlbumLegalModelSetIfNeed();
        if (getDevice() == null || this.mAlbumLegalModelSet.contains(getDevice().model)) {
            try {
                Observable.just(0).subscribeOn(Schedulers.io()).subscribe(new Action1<Integer>() {
                    /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTPersistModule.AnonymousClass9 */

                    public final /* synthetic */ void call(Object obj) {
                        try {
                            List<MediaStoreUtil.O000000o> O000000o2 = MediaStoreUtil.O000000o(CommonApplication.getAppContext());
                            WritableArray createArray = Arguments.createArray();
                            if (O000000o2.size() > 0) {
                                for (MediaStoreUtil.O000000o next : O000000o2) {
                                    if (next != null) {
                                        WritableMap createMap = Arguments.createMap();
                                        createMap.putString("albumID", next.f3111O000000o);
                                        createMap.putString("name", next.O00000Oo);
                                        createMap.putInt("size", next.O00000o0);
                                        createMap.putMap("thumb", O00000Oo.O000000o(next.O00000o));
                                        createArray.pushMap(createMap);
                                    }
                                }
                            }
                            callback.invoke(Boolean.TRUE, gbq.O000000o(0, createArray));
                        } catch (MediaStoreUtil.AccessMediaError e) {
                            e.getErrorCode();
                            WritableMap O000000o3 = gbq.O000000o(-401, "access to photo library denied");
                            callback.invoke(Boolean.FALSE, O000000o3);
                        } catch (Exception e2) {
                            Callback callback = callback;
                            callback.invoke(Boolean.FALSE, gbq.O000000o(-1, "getAlbums error:" + e2.getMessage()));
                        }
                    }
                });
            } catch (Exception e) {
                callback.invoke(Boolean.FALSE, gbq.O000000o(-1, "getAlbums error:" + e.getMessage()));
            }
        } else {
            callback.invoke(Boolean.FALSE, gbq.O000000o(-3, "model not support"));
        }
    }

    static class O00000Oo {
        public static WritableMap O000000o(MediaStoreUtil.O00000Oo o00000Oo) {
            WritableMap createMap = Arguments.createMap();
            createMap.putString("url", o00000Oo.O00000Oo);
            if (!TextUtils.isEmpty(o00000Oo.O00000o0)) {
                String lowerCase = o00000Oo.O00000o0.toLowerCase();
                if (lowerCase.startsWith("image/")) {
                    createMap.putInt("mediaType", 1);
                } else if (lowerCase.startsWith("video/")) {
                    createMap.putInt("mediaType", 2);
                } else if (lowerCase.startsWith("audio/")) {
                    createMap.putInt("mediaType", 3);
                }
                createMap.putInt("pixelWidth", o00000Oo.O00000o);
                createMap.putInt("pixelHeight", o00000Oo.O00000oO);
                createMap.putInt("creationDate", o00000Oo.O00000oo);
                createMap.putInt("modificationDate", o00000Oo.O0000O0o);
                createMap.putInt("duration", o00000Oo.O0000OOo);
                createMap.putString("uti", o00000Oo.O00000o0);
                return createMap;
            }
            createMap.putInt("mediaType", 0);
            createMap.putInt("pixelWidth", o00000Oo.O00000o);
            createMap.putInt("pixelHeight", o00000Oo.O00000oO);
            createMap.putInt("creationDate", o00000Oo.O00000oo);
            createMap.putInt("modificationDate", o00000Oo.O0000O0o);
            createMap.putInt("duration", o00000Oo.O0000OOo);
            createMap.putString("uti", o00000Oo.O00000o0);
            return createMap;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gbq.O000000o(int, java.lang.Object):com.facebook.react.bridge.WritableMap
     arg types: [int, java.lang.String]
     candidates:
      _m_j.gbq.O000000o(int, java.lang.String):com.facebook.react.bridge.WritableMap
      _m_j.gbq.O000000o(com.xiaomi.smarthome.framework.plugin.rn.constants.RnApiErrorInfo, java.lang.String):com.facebook.react.bridge.WritableMap
      _m_j.gbq.O000000o(int, java.lang.Object):com.facebook.react.bridge.WritableMap */
    @ReactMethod
    public final void fetchLocalVideoFilePathFromDidAlbumByUrl(String str, String str2, Callback callback) {
        callback.invoke(Boolean.TRUE, gbq.O000000o(0, (Object) str2));
    }

    @SuppressLint({"NewApi"})
    @ReactMethod
    public final void deleteAssetsFromAlbumByUrls(String str, final ReadableArray readableArray, final Callback callback) {
        final Activity currentActivity = getCurrentActivity();
        if (currentActivity != null) {
            Observable.just(0).subscribeOn(Schedulers.io()).subscribe(new Action1<Integer>() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTPersistModule.AnonymousClass10 */

                public final /* synthetic */ void call(Object obj) {
                    int size = readableArray.size();
                    int i = 0;
                    int i2 = 0;
                    while (i < size) {
                        try {
                            String string = readableArray.getString(i);
                            if (!TextUtils.isEmpty(string)) {
                                try {
                                    i2 += MediaStoreUtil.O00000o(currentActivity, string);
                                } catch (MediaStoreUtil.AccessMediaError unused) {
                                    callback.invoke(Boolean.FALSE, gbq.O000000o(-100, "delete assets failed"));
                                    return;
                                }
                            }
                            i++;
                        } catch (Exception unused2) {
                            callback.invoke(Boolean.FALSE, gbq.O000000o(-3, "urls cannot be parsed to a Array or it is empty"));
                            return;
                        }
                    }
                    WritableMap createMap = Arguments.createMap();
                    createMap.putInt("deleted_count", i2);
                    callback.invoke(Boolean.TRUE, gbq.O000000o(0, createMap));
                }
            });
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: org.json.JSONObject.put(java.lang.String, boolean):org.json.JSONObject
     arg types: [java.lang.String, int]
     candidates:
      org.json.JSONObject.put(java.lang.String, double):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, float):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, int):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, long):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, java.lang.Object):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, java.util.Collection<?>):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, java.util.Map<?, ?>):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, boolean):org.json.JSONObject */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: org.json.JSONObject.put(java.lang.String, double):org.json.JSONObject
     arg types: [java.lang.String, int]
     candidates:
      org.json.JSONObject.put(java.lang.String, float):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, int):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, long):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, java.lang.Object):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, java.util.Collection<?>):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, java.util.Map<?, ?>):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, boolean):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, double):org.json.JSONObject */
    @ReactMethod
    public final void screenShot(String str, Callback callback) {
        if (checkFileNameValidCallBack(str, callback)) {
            try {
                String O000000o2 = gpg.O000000o(str);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("format", O000000o2);
                jSONObject.put("result", "tmpfile");
                jSONObject.put("snapshotContentContainer", false);
                jSONObject.put("fileName", str);
                jSONObject.put("quality", 0.8d);
                captureRef(-1, jSONObject, callback);
            } catch (JSONException e) {
                gbu.O00000Oo(e.toString());
                callback.invoke(Boolean.FALSE, gbq.O000000o(-1, e.toString()));
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fyf.O000000o(com.facebook.react.bridge.ReadableMap, java.lang.String, double):double
     arg types: [com.facebook.react.bridge.ReadableMap, java.lang.String, int]
     candidates:
      _m_j.fyf.O000000o(com.facebook.react.bridge.ReadableMap, java.lang.String, int):int
      _m_j.fyf.O000000o(int, int, java.lang.String):java.lang.String
      _m_j.fyf.O000000o(com.facebook.react.bridge.ReadableMap, java.lang.String, java.lang.String):java.lang.String
      _m_j.fyf.O000000o(com.facebook.react.bridge.ReadableMap, java.lang.String, double):double */
    @ReactMethod
    public final void screenShotInRect(String str, ReadableMap readableMap, Callback callback) {
        ReadableMap readableMap2 = readableMap;
        if (checkFileNameValidCallBack(str, callback)) {
            final double O000000o2 = fyf.O000000o(readableMap2, "l", 0.0d);
            final double O000000o3 = fyf.O000000o(readableMap2, "t", 0.0d);
            final double O000000o4 = fyf.O000000o(readableMap2, "w", 0.0d);
            final double O000000o5 = fyf.O000000o(readableMap2, "h", 0.0d);
            final Bitmap.CompressFormat O00000Oo2 = gpg.O00000Oo(gpg.O000000o(str));
            View decorView = getCurrentActivity().getWindow().getDecorView();
            AnonymousClass11 r14 = r0;
            final View view = decorView;
            final String str2 = str;
            final Callback callback2 = callback;
            AnonymousClass11 r0 = new Runnable() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTPersistModule.AnonymousClass11 */

                /* JADX WARNING: Removed duplicated region for block: B:30:0x009c A[SYNTHETIC, Splitter:B:30:0x009c] */
                /* JADX WARNING: Removed duplicated region for block: B:34:0x00a3 A[SYNTHETIC, Splitter:B:34:0x00a3] */
                /* JADX WARNING: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
                public final void run() {
                    BufferedOutputStream bufferedOutputStream = null;
                    try {
                        view.setDrawingCacheEnabled(true);
                        Bitmap drawingCache = view.getDrawingCache();
                        float f = MIOTPersistModule.this.getReactApplicationContext().getResources().getDisplayMetrics().density;
                        String pathName = MIOTPersistModule.this.getPathName(str2);
                        BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(pathName));
                        double d = (double) f;
                        try {
                            double d2 = O000000o2;
                            Double.isNaN(d);
                            int i = (int) ((d2 * d) + 0.5d);
                            double d3 = O000000o3;
                            Double.isNaN(d);
                            int i2 = (int) ((d3 * d) + 0.5d);
                            double d4 = O000000o4;
                            Double.isNaN(d);
                            int i3 = (int) ((d4 * d) + 0.5d);
                            double d5 = O000000o5;
                            Double.isNaN(d);
                            Bitmap.createBitmap(drawingCache, i, i2, i3, (int) ((d * d5) + 0.5d)).compress(O00000Oo2, 90, bufferedOutputStream2);
                            view.setDrawingCacheEnabled(false);
                            callback2.invoke(Boolean.TRUE, pathName);
                            try {
                                bufferedOutputStream2.close();
                            } catch (Exception unused) {
                            }
                        } catch (Exception e) {
                            e = e;
                            bufferedOutputStream = bufferedOutputStream2;
                            try {
                                callback2.invoke(Boolean.FALSE, gbq.O000000o(-1, Log.getStackTraceString(e)));
                                if (bufferedOutputStream == null) {
                                    try {
                                        bufferedOutputStream.close();
                                    } catch (Exception unused2) {
                                    }
                                }
                            } catch (Throwable th) {
                                th = th;
                                if (bufferedOutputStream != null) {
                                    try {
                                        bufferedOutputStream.close();
                                    } catch (Exception unused3) {
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            bufferedOutputStream = bufferedOutputStream2;
                            if (bufferedOutputStream != null) {
                            }
                            throw th;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        callback2.invoke(Boolean.FALSE, gbq.O000000o(-1, Log.getStackTraceString(e)));
                        if (bufferedOutputStream == null) {
                        }
                    }
                }
            };
            decorView.post(r14);
        }
    }

    @ReactMethod
    public final void amapScreenShot(int i, String str, Callback callback) {
        try {
            if (checkFileNameValidCallBack(str, callback)) {
                final Bitmap.CompressFormat O00000Oo2 = gpg.O00000Oo(gpg.O000000o(str));
                MapView findViewById = getCurrentActivity().findViewById(i);
                final MapView mapView = findViewById;
                final String str2 = str;
                final Callback callback2 = callback;
                findViewById.post(new Runnable() {
                    /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTPersistModule.AnonymousClass13 */

                    public final void run() {
                        mapView.getMap().getMapScreenShot(new AMap.OnMapScreenShotListener() {
                            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTPersistModule.AnonymousClass13.AnonymousClass1 */
                        });
                    }
                });
            }
        } catch (Exception e) {
            callback.invoke(Boolean.FALSE, gbq.O000000o(-1, Log.getStackTraceString(e)));
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: org.json.JSONObject.put(java.lang.String, boolean):org.json.JSONObject
     arg types: [java.lang.String, int]
     candidates:
      org.json.JSONObject.put(java.lang.String, double):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, float):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, int):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, long):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, java.lang.Object):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, java.util.Collection<?>):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, java.util.Map<?, ?>):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, boolean):org.json.JSONObject */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: org.json.JSONObject.put(java.lang.String, double):org.json.JSONObject
     arg types: [java.lang.String, int]
     candidates:
      org.json.JSONObject.put(java.lang.String, float):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, int):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, long):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, java.lang.Object):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, java.util.Collection<?>):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, java.util.Map<?, ?>):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, boolean):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, double):org.json.JSONObject */
    @ReactMethod
    public final void longScreenShot(int i, String str, Callback callback) {
        try {
            if (checkFileNameValidCallBack(str, callback)) {
                String O000000o2 = gpg.O000000o(str);
                final Bitmap.CompressFormat O00000Oo2 = gpg.O00000Oo(O000000o2);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("format", O000000o2);
                jSONObject.put("result", "tmpfile");
                jSONObject.put("snapshotContentContainer", true);
                jSONObject.put("fileName", str);
                jSONObject.put("quality", 0.8d);
                View findViewById = getCurrentActivity().findViewById(i);
                if (findViewById == null) {
                    callback.invoke(Boolean.FALSE, gbq.O000000o(-1, "can not find view Id, id is ".concat(String.valueOf(i))));
                } else if (findViewById instanceof ScrollView) {
                    captureRef(i, jSONObject, callback);
                } else {
                    final String str2 = str;
                    final View view = findViewById;
                    final Callback callback2 = callback;
                    findViewById.post(new Runnable() {
                        /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTPersistModule.AnonymousClass14 */

                        public final void run() {
                            Bitmap bitmap;
                            try {
                                String pathName = MIOTPersistModule.this.getPathName(str2);
                                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(pathName));
                                View view = view;
                                if (view instanceof ScrollView) {
                                    bitmap = fyf.O000000o((ScrollView) view);
                                } else if (view instanceof ListView) {
                                    bitmap = fyf.O000000o((ListView) view);
                                } else {
                                    bitmap = view instanceof RecyclerView ? fyf.O000000o((RecyclerView) view) : null;
                                }
                                bitmap.compress(O00000Oo2, 90, bufferedOutputStream);
                                callback2.invoke(Boolean.TRUE, pathName);
                                bufferedOutputStream.close();
                            } catch (Exception e) {
                                callback2.invoke(Boolean.FALSE, gbq.O000000o(-1, Log.getStackTraceString(e)));
                            }
                        }
                    });
                }
            }
        } catch (Exception e) {
            callback.invoke(Boolean.FALSE, gbq.O000000o(-1, Log.getStackTraceString(e)));
        }
    }

    @ReactMethod
    public final void getRGBAValueFromImageAtPath(String str, ReadableArray readableArray, Callback callback) {
        try {
            if (checkFileNameValidCallBack(str, callback)) {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(getPathName(str)));
                Bitmap decodeStream = BitmapFactory.decodeStream(new BufferedInputStream(bufferedInputStream));
                WritableArray createArray = Arguments.createArray();
                if (readableArray == null || readableArray.size() <= 0) {
                    for (int i = 0; i < decodeStream.getWidth(); i++) {
                        WritableArray createArray2 = Arguments.createArray();
                        for (int i2 = 0; i2 < decodeStream.getHeight(); i2++) {
                            WritableArray createArray3 = Arguments.createArray();
                            int pixel = decodeStream.getPixel(i, i2);
                            createArray3.pushInt(Color.red(pixel));
                            createArray3.pushInt(Color.green(pixel));
                            createArray3.pushInt(Color.blue(pixel));
                            createArray3.pushInt(Color.alpha(pixel));
                            createArray2.pushArray(createArray3);
                        }
                        createArray.pushArray(createArray2);
                    }
                } else {
                    for (int i3 = 0; i3 < readableArray.size(); i3++) {
                        WritableArray createArray4 = Arguments.createArray();
                        int pixel2 = decodeStream.getPixel(fyf.O000000o(readableArray.getMap(i3), "x", 0), fyf.O000000o(readableArray.getMap(i3), "y", 0));
                        createArray4.pushInt(Color.red(pixel2));
                        createArray4.pushInt(Color.green(pixel2));
                        createArray4.pushInt(Color.blue(pixel2));
                        createArray4.pushInt(Color.alpha(pixel2));
                        createArray.pushArray(createArray4);
                    }
                }
                callback.invoke(Boolean.TRUE, createArray);
                bufferedInputStream.close();
                decodeStream.recycle();
            }
        } catch (Throwable th) {
            callback.invoke(Boolean.FALSE, Log.getStackTraceString(th));
        }
    }

    /* JADX WARN: Type inference failed for: r21v1 */
    /* JADX WARN: Type inference failed for: r21v2 */
    /* JADX WARNING: Incorrect type for immutable var: ssa=boolean, code=?, for r21v0, types: [boolean] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    private void captureRef(int i, JSONObject jSONObject, Callback callback) {
        Integer num;
        Integer num2;
        int i2;
        ? r21;
        boolean[] zArr;
        int i3;
        gaq gaq;
        JSONObject jSONObject2 = jSONObject;
        final Callback callback2 = callback;
        DisplayMetrics displayMetrics = getReactApplicationContext().getResources().getDisplayMetrics();
        String optString = jSONObject2.optString("format");
        double optDouble = jSONObject2.optDouble("quality");
        String optString2 = jSONObject2.optString("result");
        Boolean valueOf = Boolean.valueOf(jSONObject2.optBoolean("snapshotContentContainer"));
        String optString3 = jSONObject2.optString("fileName");
        if (jSONObject2.has("width")) {
            double d = (double) displayMetrics.density;
            double optDouble2 = jSONObject2.optDouble("width");
            Double.isNaN(d);
            num = Integer.valueOf((int) (d * optDouble2));
        } else {
            num = null;
        }
        if (jSONObject2.has("height")) {
            double d2 = (double) displayMetrics.density;
            double optDouble3 = jSONObject2.optDouble("height");
            Double.isNaN(d2);
            num2 = Integer.valueOf((int) (d2 * optDouble3));
        } else {
            num2 = null;
        }
        if ("jpg".equals(optString)) {
            i2 = 0;
        } else if ("webm".equals(optString)) {
            i2 = 2;
        } else {
            i2 = "raw".equals(optString) ? -1 : 1;
        }
        final boolean[] zArr2 = {false};
        try {
            File file = new File(getPathName(optString3));
            if (file.exists()) {
                file.delete();
            }
            Activity currentActivity = getCurrentActivity();
            UIManagerModule uIManagerModule = (UIManagerModule) getReactApplicationContext().getNativeModule(UIManagerModule.class);
            ReactApplicationContext reactApplicationContext = getReactApplicationContext();
            AnonymousClass15 r3 = new Promise() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTPersistModule.AnonymousClass15 */

                public final void resolve(Object obj) {
                    boolean[] zArr = zArr2;
                    if (!zArr[0]) {
                        zArr[0] = true;
                        try {
                            callback2.invoke(Boolean.TRUE, obj.toString());
                        } catch (Exception e) {
                            gbu.O00000Oo(e.toString());
                        }
                    }
                }

                public final void reject(String str, String str2) {
                    boolean[] zArr = zArr2;
                    if (!zArr[0]) {
                        zArr[0] = true;
                        try {
                            callback2.invoke(Boolean.FALSE, gbq.O000000o(-1, str2));
                        } catch (Exception e) {
                            gbu.O00000Oo(e.toString());
                        }
                    }
                }

                public final void reject(String str, Throwable th) {
                    boolean[] zArr = zArr2;
                    if (!zArr[0]) {
                        zArr[0] = true;
                        try {
                            callback2.invoke(Boolean.FALSE, gbq.O000000o(-1, th.toString()));
                        } catch (Exception e) {
                            gbu.O00000Oo(e.toString());
                        }
                    }
                }

                public final void reject(String str, String str2, Throwable th) {
                    boolean[] zArr = zArr2;
                    if (!zArr[0]) {
                        zArr[0] = true;
                        try {
                            callback2.invoke(Boolean.FALSE, gbq.O000000o(-1, str2));
                        } catch (Exception e) {
                            gbu.O00000Oo(e.toString());
                        }
                    }
                }

                public final void reject(String str) {
                    boolean[] zArr = zArr2;
                    if (!zArr[0]) {
                        zArr[0] = true;
                        try {
                            callback2.invoke(Boolean.FALSE, gbq.O000000o(-1, str));
                        } catch (Exception e) {
                            gbu.O00000Oo(e.toString());
                        }
                    }
                }

                public final void reject(Throwable th) {
                    boolean[] zArr = zArr2;
                    if (!zArr[0]) {
                        zArr[0] = true;
                        try {
                            callback2.invoke(Boolean.FALSE, gbq.O000000o(-1, th.toString()));
                        } catch (Exception e) {
                            gbu.O00000Oo(e.toString());
                        }
                    }
                }

                public final void reject(String str, WritableMap writableMap) {
                    boolean[] zArr = zArr2;
                    if (!zArr[0]) {
                        zArr[0] = true;
                        try {
                            callback2.invoke(Boolean.FALSE, writableMap.toString());
                        } catch (Exception e) {
                            gbu.O00000Oo(e.toString());
                        }
                    }
                }

                public final void reject(Throwable th, WritableMap writableMap) {
                    boolean[] zArr = zArr2;
                    if (!zArr[0]) {
                        zArr[0] = true;
                        try {
                            writableMap.putString("throwable", Log.getStackTraceString(th));
                            callback2.invoke(Boolean.FALSE, writableMap.toString());
                        } catch (Exception e) {
                            gbu.O00000Oo(e.toString());
                        }
                    }
                }

                public final void reject(String str, Throwable th, WritableMap writableMap) {
                    boolean[] zArr = zArr2;
                    if (!zArr[0]) {
                        zArr[0] = true;
                        try {
                            writableMap.putString("throwable", Log.getStackTraceString(th));
                            callback2.invoke(Boolean.FALSE, writableMap.toString());
                        } catch (Exception e) {
                            gbu.O00000Oo(e.toString());
                        }
                    }
                }

                public final void reject(String str, String str2, Throwable th, WritableMap writableMap) {
                    boolean[] zArr = zArr2;
                    if (!zArr[0]) {
                        zArr[0] = true;
                        try {
                            callback2.invoke(Boolean.FALSE, str2);
                        } catch (Exception e) {
                            gbu.O00000Oo(e.toString());
                        }
                    }
                }

                public final void reject(String str, String str2, WritableMap writableMap) {
                    boolean[] zArr = zArr2;
                    if (!zArr[0]) {
                        zArr[0] = true;
                        try {
                            callback2.invoke(Boolean.FALSE, str2);
                        } catch (Exception e) {
                            gbu.O00000Oo(e.toString());
                        }
                    }
                }
            };
            zArr = zArr2;
            gaq gaq2 = gaq;
            r21 = 1;
            i3 = 2;
            try {
                gaq = new gaq(i, optString, i2, optDouble, num, num2, file, optString2, valueOf, reactApplicationContext, currentActivity, r3);
                uIManagerModule.addUIBlock(gaq2);
            } catch (Throwable th) {
                th = th;
                if (zArr[0] != 0) {
                    zArr[0] = r21;
                    try {
                        Object[] objArr = new Object[i3];
                        objArr[0] = Boolean.FALSE;
                        objArr[r21] = gbq.O000000o(-1, th.toString());
                        callback.invoke(objArr);
                    } catch (Exception e) {
                        gbu.O00000Oo(e.toString());
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            zArr = zArr2;
            i3 = 2;
            r21 = 1;
            if (zArr[0] != 0) {
            }
        }
    }

    private boolean checkFolderValidCallBack(String str, Callback callback) {
        if (TextUtils.isEmpty(str) || gbt.O00000Oo(getFilesPath().toString(), getPathName(str))) {
            return true;
        }
        callback.invoke(Boolean.FALSE, str + ", this folder is not valid, cannot contains ...");
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:107:0x0263, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x0264, code lost:
        r13 = r38;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x0266, code lost:
        r7 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x026a, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x026b, code lost:
        r12 = r39;
        r7 = r21;
        r13 = r38;
        r10 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0277, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x0278, code lost:
        r12 = r39;
        r7 = r21;
        r13 = r38;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x0306, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x0307, code lost:
        r13 = r38;
        r17 = r1;
        r10 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x0374, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x0376, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x0377, code lost:
        r13 = r38;
        r17 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x0399, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x039a, code lost:
        r13 = r38;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x039e, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x039f, code lost:
        r10 = r23;
        r13 = r38;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x0407, code lost:
        r13.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x040c, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:184:0x0411, code lost:
        r17.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x0416, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x041d, code lost:
        r13.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:191:0x0422, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:0x0427, code lost:
        r17.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x042c, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:206:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:207:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x013a, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x013b, code lost:
        r13 = r38;
        r12 = r39;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x023b, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x023c, code lost:
        r13 = r38;
        r10 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0244, code lost:
        r0 = th;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x0376 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:121:0x02d3] */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x0399 A[ExcHandler: all (th java.lang.Throwable), PHI: r38 10  PHI: (r38v6 java.net.HttpURLConnection) = (r38v5 java.net.HttpURLConnection), (r38v5 java.net.HttpURLConnection), (r38v9 java.net.HttpURLConnection), (r38v9 java.net.HttpURLConnection), (r38v9 java.net.HttpURLConnection), (r38v9 java.net.HttpURLConnection), (r38v9 java.net.HttpURLConnection), (r38v9 java.net.HttpURLConnection), (r38v9 java.net.HttpURLConnection), (r38v9 java.net.HttpURLConnection), (r38v9 java.net.HttpURLConnection), (r38v9 java.net.HttpURLConnection), (r38v9 java.net.HttpURLConnection), (r38v12 java.net.HttpURLConnection) binds: [B:117:0x02a3, B:118:?, B:53:0x0151, B:76:0x01e6, B:104:0x0259, B:105:?, B:81:0x01f4, B:82:?, B:84:0x021d, B:92:0x0232, B:72:0x01e2, B:69:0x01dd, B:70:?, B:44:0x012d] A[DONT_GENERATE, DONT_INLINE], Splitter:B:44:0x012d] */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x0407  */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x040c  */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x0411  */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x0416  */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x041d  */
    /* JADX WARNING: Removed duplicated region for block: B:191:0x0422  */
    /* JADX WARNING: Removed duplicated region for block: B:193:0x0427  */
    /* JADX WARNING: Removed duplicated region for block: B:195:0x042c  */
    /* JADX WARNING: Removed duplicated region for block: B:207:? A[RETURN, SYNTHETIC] */
    private static void upload(String str, String str2, HashMap<String, Object> hashMap, HashMap<String, Object> hashMap2, ReadableArray readableArray, boolean z, Callback callback) throws Exception {
        BufferedInputStream bufferedInputStream;
        HttpURLConnection httpURLConnection;
        DataOutputStream dataOutputStream;
        BufferedReader bufferedReader;
        Callback callback2;
        long j;
        long j2;
        int i;
        BufferedReader bufferedReader2;
        long j3;
        HttpURLConnection httpURLConnection2;
        BufferedInputStream bufferedInputStream2;
        long j4;
        String str3;
        String str4;
        long j5;
        int i2;
        Callback callback3;
        long j6;
        long j7;
        byte[] bArr;
        long j8;
        long j9;
        Callback callback4 = callback;
        long calUploadFilesAllTotalSize = calUploadFilesAllTotalSize(readableArray);
        int i3 = 1;
        try {
            httpURLConnection = fyu.O000000o().O000000o(str, z);
            try {
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setRequestMethod(str2);
                httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=".concat("***miotuploadFile***"));
                if (hashMap != null) {
                    try {
                        for (Map.Entry next : hashMap.entrySet()) {
                            Object value = next.getValue();
                            if (value != null) {
                                httpURLConnection.setRequestProperty((String) next.getKey(), value.toString());
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader2 = null;
                        dataOutputStream = null;
                        bufferedInputStream = null;
                        if (httpURLConnection != null) {
                        }
                        if (dataOutputStream != null) {
                        }
                        if (bufferedInputStream != null) {
                        }
                        if (bufferedReader != null) {
                        }
                        throw th;
                    }
                }
                RnNetReport.reportUploadFileURL(str);
                dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                String str5 = "";
                String str6 = "--";
                if (hashMap2 != null) {
                    try {
                        for (Map.Entry next2 : hashMap2.entrySet()) {
                            dataOutputStream.writeBytes(str6 + "***miotuploadFile***" + "\r\n");
                            String str7 = (String) next2.getKey();
                            String obj = next2.getValue() == null ? str5 : next2.getValue().toString();
                            dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"" + str7 + jdn.f1779O000000o + "\r\n");
                            dataOutputStream.writeBytes("\r\n");
                            dataOutputStream.writeBytes(obj);
                            dataOutputStream.writeBytes("\r\n");
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader2 = null;
                        bufferedInputStream = null;
                        if (httpURLConnection != null) {
                        }
                        if (dataOutputStream != null) {
                        }
                        if (bufferedInputStream != null) {
                        }
                        if (bufferedReader != null) {
                        }
                        throw th;
                    }
                }
                int i4 = 0;
                i3 = 1;
                long j10 = 0;
                j3 = 0;
                long j11 = 0;
                while (i4 < readableArray.size()) {
                    try {
                        ReadableMap O000000o2 = fyf.O000000o(readableArray, i4);
                        if (O000000o2 != null) {
                            String O000000o3 = fyf.O000000o(O000000o2, "filepath", str5);
                            ReadableMap O00000o0 = fyf.O00000o0(O000000o2, "range");
                            str4 = str5;
                            ReadableMap O00000o02 = fyf.O00000o0(O000000o2, "formdata");
                            File file = new File(O000000o3);
                            String name = file.getName();
                            long length = file.length();
                            if (O00000o0 != null) {
                                httpURLConnection2 = httpURLConnection;
                                j5 = calUploadFilesAllTotalSize;
                                try {
                                    j7 = (long) gbv.O00000oo(O00000o0, "start");
                                    j6 = (long) gbv.O00000oo(O00000o0, "length");
                                } catch (Throwable th3) {
                                }
                            } else {
                                j5 = calUploadFilesAllTotalSize;
                                httpURLConnection2 = httpURLConnection;
                                j6 = length;
                                j7 = 0;
                            }
                            if (j7 < 0) {
                                j7 = 0;
                            }
                            if (j6 > file.length() || j6 < 1) {
                                j6 = file.length();
                            }
                            String O000000o4 = gbv.O000000o(O00000o02, "name");
                            i2 = i4;
                            String O000000o5 = gbv.O000000o(O00000o02, "filename");
                            if (TextUtils.isEmpty(O000000o4)) {
                                O000000o4 = name;
                            }
                            if (TextUtils.isEmpty(O000000o5)) {
                                O000000o5 = name;
                            }
                            String mimeType = getMimeType(O000000o3);
                            dataOutputStream.writeBytes(str6 + "***miotuploadFile***" + "\r\n");
                            dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"" + O000000o4 + "\";filename=\"" + O000000o5 + jdn.f1779O000000o + "\r\n");
                            StringBuilder sb = new StringBuilder("Content-Type: ");
                            sb.append(mimeType);
                            sb.append("\r\n");
                            dataOutputStream.writeBytes(sb.toString());
                            dataOutputStream.writeBytes("\r\n");
                            FileInputStream fileInputStream = new FileInputStream(file);
                            fileInputStream.skip(j7);
                            if (j6 < 4096) {
                                bArr = new byte[((int) j6)];
                            } else {
                                bArr = new byte[4096];
                            }
                            int length2 = bArr.length;
                            int read = fileInputStream.read(bArr, 0, length2);
                            str3 = str6;
                            long j12 = j10 + j6;
                            j8 = 0;
                            while (true) {
                                if (read <= 0) {
                                    callback3 = callback;
                                    j9 = j2;
                                    break;
                                }
                                dataOutputStream.write(bArr, 0, read);
                                long j13 = j6;
                                long j14 = (long) read;
                                j8 += j14;
                                j11 += j14;
                                callback3 = callback;
                                callback3.invoke(Boolean.TRUE, null, name, Long.valueOf(j11), Long.valueOf(j5));
                                long j15 = j13 - j8;
                                if (j15 <= 0) {
                                    j9 = j2;
                                    break;
                                }
                                j9 = j2;
                                if (j15 < ((long) bArr.length)) {
                                    length2 = (int) j15;
                                }
                                read = fileInputStream.read(bArr, 0, length2);
                                j6 = j13;
                                j12 = j9;
                            }
                            j = j8;
                            dataOutputStream.writeBytes("\r\n");
                            i3++;
                            j10 = j9;
                            j3 = j;
                        } else {
                            callback3 = callback4;
                            j5 = calUploadFilesAllTotalSize;
                            i2 = i4;
                            str3 = str6;
                            httpURLConnection2 = httpURLConnection;
                            str4 = str5;
                        }
                        i4 = i2 + 1;
                        str5 = str4;
                        str6 = str3;
                        httpURLConnection = httpURLConnection2;
                        callback4 = callback3;
                        calUploadFilesAllTotalSize = j5;
                    } catch (Throwable th4) {
                        th = th4;
                        bufferedReader2 = null;
                        bufferedInputStream = null;
                        if (httpURLConnection != null) {
                        }
                        if (dataOutputStream != null) {
                        }
                        if (bufferedInputStream != null) {
                        }
                        if (bufferedReader != null) {
                        }
                        throw th;
                    }
                }
                callback2 = callback4;
                String str8 = str6;
                httpURLConnection2 = httpURLConnection;
                j2 = j10;
                StringBuilder sb2 = new StringBuilder();
                String str9 = str8;
                sb2.append(str9);
                sb2.append("***miotuploadFile***");
                sb2.append(str9);
                sb2.append("\r\n");
                dataOutputStream.writeBytes(sb2.toString());
                dataOutputStream.flush();
                bufferedInputStream2 = new BufferedInputStream(httpURLConnection2.getInputStream());
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(bufferedInputStream2));
                } catch (Throwable th5) {
                    th = th5;
                    httpURLConnection = httpURLConnection2;
                    bufferedInputStream = bufferedInputStream2;
                    bufferedReader = null;
                    if (httpURLConnection != null) {
                    }
                    if (dataOutputStream != null) {
                    }
                    if (bufferedInputStream != null) {
                    }
                    if (bufferedReader != null) {
                    }
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
                bufferedReader2 = null;
                dataOutputStream = null;
                bufferedInputStream = null;
                if (httpURLConnection != null) {
                }
                if (dataOutputStream != null) {
                }
                if (bufferedInputStream != null) {
                }
                if (bufferedReader != null) {
                }
                throw th;
            }
            try {
                WritableMap createMap = Arguments.createMap();
                for (Map.Entry next3 : httpURLConnection2.getHeaderFields().entrySet()) {
                    createMap.putString((String) next3.getKey(), (String) ((List) next3.getValue()).get(0));
                }
                StringBuilder sb3 = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb3.append(readLine);
                    sb3.append("\n");
                }
                String sb4 = sb3.toString();
                int responseCode = httpURLConnection2.getResponseCode();
                WritableMap createMap2 = Arguments.createMap();
                createMap2.putMap("header", createMap);
                createMap2.putString("data", sb4);
                createMap2.putInt("status", responseCode);
                Object[] objArr = new Object[5];
                objArr[0] = Boolean.TRUE;
                objArr[1] = createMap2;
                objArr[2] = Integer.valueOf(i3);
                objArr[3] = Double.valueOf((double) j2);
                j4 = j3;
                objArr[4] = Double.valueOf((double) j4);
                callback2.invoke(objArr);
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                dataOutputStream.close();
                bufferedInputStream2.close();
                bufferedReader.close();
            } catch (Throwable th7) {
            }
        } catch (Throwable th8) {
            th = th8;
            bufferedReader2 = null;
            dataOutputStream = null;
            httpURLConnection = null;
            bufferedInputStream = null;
            if (httpURLConnection != null) {
            }
            if (dataOutputStream != null) {
            }
            if (bufferedInputStream != null) {
            }
            if (bufferedReader != null) {
            }
            throw th;
        }
    }

    private static long calUploadFilesAllTotalSize(ReadableArray readableArray) {
        long j;
        long j2;
        if (readableArray == null || readableArray.size() == 0) {
            return 1;
        }
        int size = readableArray.size();
        long j3 = 0;
        for (int i = 0; i < size; i++) {
            ReadableMap O000000o2 = fyf.O000000o(readableArray, i);
            if (O000000o2 != null) {
                String O000000o3 = fyf.O000000o(O000000o2, "filepath", "");
                ReadableMap O00000o0 = fyf.O00000o0(O000000o2, "range");
                long length = new File(O000000o3).length();
                if (length < 0) {
                    length = 1073741823;
                }
                if (O00000o0 != null) {
                    j2 = (long) gbv.O00000oo(O00000o0, "start");
                    j = (long) gbv.O00000oo(O00000o0, "length");
                } else {
                    j2 = 0;
                    j = length;
                }
                if (j2 > length) {
                    j2 = length;
                }
                if (j2 < 0) {
                    j2 = 0;
                }
                long j4 = length - j2;
                if (j <= j4 && j >= 1) {
                    j4 = j;
                }
                j3 += j4;
            }
        }
        if (j3 >= 1) {
            return j3;
        }
        gbu.O000000o("miot-rn-plugin", "test.test.test", "upload 上传文件，文件长度太大，已经超出了totalSize的范围");
        return 1;
    }

    static final URLConnection openConnection_aroundBody6(URL url) {
        return url.openConnection();
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: java.io.BufferedInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: java.io.BufferedInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.io.BufferedInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: java.io.BufferedInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: java.io.BufferedInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: java.io.BufferedInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: java.io.BufferedInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: java.io.BufferedInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: java.io.BufferedInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: java.io.BufferedInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: java.io.BufferedInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v9, resolved type: java.io.BufferedInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v10, resolved type: java.io.BufferedInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v11, resolved type: java.io.BufferedInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v13, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v14, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v25, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v26, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v12, resolved type: java.io.BufferedInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v27, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v15, resolved type: java.io.BufferedInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v28, resolved type: java.io.BufferedInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v29, resolved type: java.io.BufferedInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v16, resolved type: java.io.BufferedInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v30, resolved type: java.io.BufferedInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v33, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v34, resolved type: java.io.BufferedInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v18, resolved type: java.io.BufferedInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v36, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v19, resolved type: java.io.BufferedInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v37, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v20, resolved type: java.io.BufferedInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v38, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v21, resolved type: java.io.BufferedInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v39, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v22, resolved type: java.io.BufferedInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v40, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v41, resolved type: java.io.BufferedInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v42, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v43, resolved type: java.io.BufferedInputStream} */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x0217, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0218, code lost:
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x0219, code lost:
        r3 = r1;
        r1 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x021c, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x021d, code lost:
        r13 = r1;
        r1 = null;
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x0264, code lost:
        r11.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x0269, code lost:
        r12.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x026e, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x0273, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x027a, code lost:
        r11.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x027f, code lost:
        r12.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x0284, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x0289, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x009d, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x009e, code lost:
        r1 = null;
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00a2, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00a3, code lost:
        r13 = r1;
        r7 = 0;
        r1 = null;
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0108, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0139, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x013a, code lost:
        r13 = r27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x014f, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0150, code lost:
        r13 = r1;
        r1 = null;
        r3 = null;
        r7 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0211, code lost:
        r0 = th;
        r1 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0213, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0214, code lost:
        r3 = r1;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0217 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:35:0x00ab] */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0264  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0269  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x026e  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0273  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x027a  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x027f  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x0284  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0289  */
    /* JADX WARNING: Removed duplicated region for block: B:147:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x009d A[ExcHandler: all (th java.lang.Throwable), Splitter:B:21:0x006f] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0211 A[ExcHandler: all (th java.lang.Throwable), PHI: r1 10  PHI: (r1v11 ?) = (r1v12 java.io.BufferedReader), (r1v12 java.io.BufferedReader), (r1v33 java.io.BufferedReader), (r1v33 java.io.BufferedReader) binds: [B:73:0x015a, B:74:?, B:60:0x011b, B:61:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:60:0x011b] */
    public static void uploadToFDS(String str, String str2, HashMap<String, Object> hashMap, HashMap<String, Object> hashMap2, ReadableArray readableArray, Callback callback) throws Exception {
        DataOutputStream dataOutputStream;
        HttpURLConnection httpURLConnection;
        BufferedInputStream bufferedInputStream;
        BufferedReader bufferedReader;
        Callback callback2;
        long j;
        Callback callback3;
        BufferedReader bufferedReader2;
        BufferedInputStream bufferedInputStream2;
        int i;
        BufferedReader bufferedReader3;
        Callback callback4;
        long length;
        long j2;
        BufferedInputStream bufferedInputStream3;
        String str3;
        Callback callback5 = callback;
        long j3 = 0;
        int i2 = 1;
        try {
            URL url = new URL(str);
            dxx.O000000o();
            httpURLConnection = (HttpURLConnection) dxx.O000000o(url);
            try {
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setRequestMethod(str2);
                if (hashMap != null) {
                    try {
                        for (Map.Entry next : hashMap.entrySet()) {
                            Object value = next.getValue();
                            if (value != null) {
                                httpURLConnection.setRequestProperty((String) next.getKey(), value.toString());
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = null;
                        bufferedInputStream = null;
                        dataOutputStream = null;
                        if (httpURLConnection != null) {
                        }
                        if (dataOutputStream != null) {
                        }
                        if (bufferedInputStream != null) {
                        }
                        if (bufferedReader != null) {
                        }
                        throw th;
                    }
                }
                RnNetReport.reportUploadFileURL(str);
                dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                if (hashMap2 != null) {
                    try {
                        for (Map.Entry next2 : hashMap2.entrySet()) {
                            next2.getKey();
                            if (next2.getValue() == null) {
                                str3 = "";
                            } else {
                                str3 = next2.getValue().toString();
                            }
                            dataOutputStream.writeBytes(str3);
                            dataOutputStream.writeBytes("\r\n");
                        }
                    } catch (Throwable th2) {
                    }
                }
                try {
                    ReadableMap O000000o2 = fyf.O000000o(readableArray, 0);
                    if (O000000o2 != null) {
                        Object O000000o3 = fyf.O000000o(O000000o2, "filename", "");
                        File file = new File(fyf.O000000o(O000000o2, "filepath", ""));
                        byte[] bArr = new byte[4096];
                        FileInputStream fileInputStream = new FileInputStream(file);
                        int read = fileInputStream.read(bArr, 0, 4096);
                        length = (long) ((int) file.length());
                        j2 = ((long) read) + 0;
                        while (read > 0) {
                            dataOutputStream.write(bArr, 0, read);
                            read = fileInputStream.read(bArr, 0, 4096);
                            if (read == -1) {
                                callback2 = callback;
                                callback2.invoke(Boolean.TRUE, null, O000000o3, Long.valueOf(j2), Long.valueOf(length));
                            } else {
                                Callback callback6 = callback;
                                j2 += (long) read;
                                Object[] objArr = new Object[5];
                                objArr[0] = Boolean.TRUE;
                                bufferedReader = 0;
                                try {
                                    objArr[1] = null;
                                    objArr[2] = O000000o3;
                                    objArr[3] = Long.valueOf(j2);
                                    objArr[4] = Long.valueOf(length);
                                    callback6.invoke(objArr);
                                } catch (Throwable th3) {
                                }
                            }
                        }
                        callback4 = callback;
                        bufferedReader = null;
                        i = 2;
                        long j4 = j2;
                        j3 = length;
                        j = j4;
                    } else {
                        callback4 = callback5;
                        bufferedReader = null;
                        j = 0;
                        i = 1;
                    }
                    dataOutputStream.flush();
                    bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                } catch (Throwable th4) {
                }
            } catch (Throwable th5) {
                th = th5;
                bufferedReader = null;
                bufferedInputStream = null;
                dataOutputStream = null;
                if (httpURLConnection != null) {
                }
                if (dataOutputStream != null) {
                }
                if (bufferedInputStream != null) {
                }
                if (bufferedReader != null) {
                }
                throw th;
            }
            try {
                bufferedReader3 = new BufferedReader(new InputStreamReader(bufferedInputStream));
            } catch (Throwable th6) {
                th = th6;
                i2 = i;
                callback2.invoke(Boolean.FALSE, Log.getStackTraceString(th), Integer.valueOf(i2), Double.valueOf((double) j3), Double.valueOf((double) j));
                if (httpURLConnection != null) {
                }
                if (dataOutputStream != null) {
                }
                if (bufferedInputStream != null) {
                }
                if (bufferedReader == null) {
                }
            }
            try {
                WritableMap createMap = Arguments.createMap();
                for (Map.Entry next3 : httpURLConnection.getHeaderFields().entrySet()) {
                    createMap.putString((String) next3.getKey(), (String) ((List) next3.getValue()).get(0));
                }
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader3.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                    sb.append("\n");
                }
                String sb2 = sb.toString();
                int responseCode = httpURLConnection.getResponseCode();
                WritableMap createMap2 = Arguments.createMap();
                createMap2.putMap("header", createMap);
                createMap2.putString("data", sb2);
                createMap2.putInt("status", responseCode);
                callback2.invoke(Boolean.TRUE, createMap2, Integer.valueOf(i), Double.valueOf((double) j3), Double.valueOf((double) j));
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                dataOutputStream.close();
                bufferedInputStream.close();
                bufferedReader3.close();
                return;
            } catch (Throwable th7) {
                th = th7;
                bufferedReader = bufferedReader3;
                if (httpURLConnection != null) {
                }
                if (dataOutputStream != null) {
                }
                if (bufferedInputStream != null) {
                }
                if (bufferedReader != null) {
                }
                throw th;
            }
            bufferedInputStream3 = null;
            bufferedInputStream = null;
            long j5 = j2;
            j3 = length;
            j = j5;
            bufferedReader = bufferedInputStream3;
            callback2.invoke(Boolean.FALSE, Log.getStackTraceString(th), Integer.valueOf(i2), Double.valueOf((double) j3), Double.valueOf((double) j));
            if (httpURLConnection != null) {
            }
            if (dataOutputStream != null) {
            }
            if (bufferedInputStream != null) {
            }
            if (bufferedReader == null) {
            }
        } catch (Throwable th8) {
            th = th8;
            bufferedReader = null;
            bufferedInputStream = null;
            httpURLConnection = null;
            dataOutputStream = null;
            if (httpURLConnection != null) {
            }
            if (dataOutputStream != null) {
            }
            if (bufferedInputStream != null) {
            }
            if (bufferedReader != null) {
            }
            throw th;
        }
    }

    public boolean checkFileNameValidCallBack(String str, Callback callback) {
        if (TextUtils.isEmpty(str)) {
            callback.invoke(Boolean.FALSE, gbq.O000000o(-1, "fileName is empty..."));
            return false;
        } else if (gbt.O00000Oo(getFilesPath().toString(), getPathName(str))) {
            return true;
        } else {
            callback.invoke(Boolean.FALSE, gbq.O000000o(-1, str + ", this fileName is not valid, cannot contains ..."));
            return false;
        }
    }

    private static String getMimeType(String str) {
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
        if (fileExtensionFromUrl != null) {
            return MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl);
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x006b A[SYNTHETIC, Splitter:B:30:0x006b] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0074 A[SYNTHETIC, Splitter:B:35:0x0074] */
    public byte[] uncompress(File file) {
        byte[] bArr = new byte[0];
        try {
            bArr = getBytes(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Inflater inflater = new Inflater();
        inflater.reset();
        inflater.setInput(bArr, 0, bArr.length);
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(bArr.length);
            try {
                byte[] bArr2 = new byte[1024];
                while (true) {
                    if (inflater.finished()) {
                        break;
                    }
                    int inflate = inflater.inflate(bArr2);
                    byteArrayOutputStream2.write(bArr2, 0, inflate);
                    if (inflate <= 0) {
                        gbu.O00000Oo("MIOTPersistModule inflater.inflate return is ".concat(String.valueOf(inflate)));
                        break;
                    }
                }
                bArr = byteArrayOutputStream2.toByteArray();
            } catch (Exception e2) {
                e = e2;
                byteArrayOutputStream = byteArrayOutputStream2;
                try {
                    fyc.O00000o(TAG, e.toString());
                    if (byteArrayOutputStream != null) {
                    }
                    inflater.end();
                    return bArr;
                } catch (Throwable th) {
                    th = th;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    if (byteArrayOutputStream2 != null) {
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                if (byteArrayOutputStream2 != null) {
                    try {
                        byteArrayOutputStream2.close();
                    } catch (IOException e3) {
                        fyc.O00000o(TAG, e3.toString());
                    }
                }
                throw th;
            }
            try {
                byteArrayOutputStream2.close();
            } catch (IOException e4) {
                fyc.O00000o(TAG, e4.toString());
            }
        } catch (Exception e5) {
            e = e5;
            fyc.O00000o(TAG, e.toString());
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            inflater.end();
            return bArr;
        }
        inflater.end();
        return bArr;
    }

    private byte[] getBytes(FileInputStream fileInputStream) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1000);
            byte[] bArr = new byte[1000];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    fileInputStream.close();
                    byteArrayOutputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (FileNotFoundException e) {
            fyc.O00000o("rn-plugin", e.toString());
            return null;
        } catch (IOException e2) {
            fyc.O00000o("rn-plugin", e2.toString());
            return null;
        }
    }

    @ReactMethod
    public void getStorageInfo(Callback callback) {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        long totalBytes = statFs.getTotalBytes();
        long freeBytes = statFs.getFreeBytes();
        WritableMap createMap = Arguments.createMap();
        createMap.putDouble("totalSpace", (double) totalBytes);
        createMap.putDouble("freeSpace", (double) freeBytes);
        callback.invoke(Boolean.TRUE, gbq.O000000o(0, createMap));
    }

    public void onCatalystInstanceDestroy() {
        gbu.O000000o("MIOTPersistModule  destroy....");
        super.onCatalystInstanceDestroy();
    }

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public static byte f8353O000000o = 1;
        public static byte O00000Oo = 2;
        private static byte O00000o = 3;
        public volatile byte O00000o0;

        public O000000o() {
        }

        public O000000o(byte b) {
            this.O00000o0 = b;
        }
    }

    @ReactMethod
    public void mkdir(ReadableMap readableMap, Callback callback) {
        String O000000o2 = gbv.O000000o(readableMap, "dirPath");
        boolean O00000o0 = gbv.O00000o0(readableMap, "recursive");
        if (checkFileNameValidCallBack(O000000o2, callback)) {
            File file = new File(getPathName(O000000o2));
            if (file.exists()) {
                callback.invoke(Boolean.FALSE, gbq.O000000o(-2, String.format("file %s already exist:", O000000o2)));
                return;
            }
            if (O00000o0) {
                try {
                    file.mkdirs();
                } catch (SecurityException e) {
                    fyc.O000000o(TAG, "mkdir error:", e);
                    callback.invoke(Boolean.FALSE, gbq.O000000o(-4, "permission denied,cannot access dir:".concat(String.valueOf(O000000o2))));
                    return;
                }
            } else if (!file.mkdir() && !file.getParentFile().exists()) {
                callback.invoke(Boolean.FALSE, gbq.O000000o(-3, "parent directory is not exist:".concat(String.valueOf(O000000o2))));
                return;
            }
            callback.invoke(Boolean.TRUE, gbq.O000000o(0, null, "success"));
        }
    }

    private Uri pathToUri(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!MediaStoreUtil.O00000Oo(str)) {
            str = getPathName(str);
        }
        return Uri.parse(str);
    }

    @ReactMethod
    public void copyFile(ReadableMap readableMap, Callback callback) {
        String O000000o2 = gbv.O000000o(readableMap, "srcPath");
        String O000000o3 = gbv.O000000o(readableMap, "dstPath");
        String O000000o4 = gbv.O000000o(readableMap, "dstDir");
        if (TextUtils.isEmpty(O000000o2) || TextUtils.isEmpty(O000000o3)) {
            callback.invoke(Boolean.FALSE, gbq.O000000o(-1, "invalid srcPath or dstPath"));
        } else if (MediaStoreUtil.O00000Oo(O000000o2) || checkFileNameValidCallBack(O000000o2, callback)) {
            Observable.just(0).subscribeOn(Schedulers.io()).doOnNext(new Action1(O000000o2, O000000o4, O000000o3, callback) {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.$$Lambda$MIOTPersistModule$rL2ltbnAewMzyerJXc3vCe6t2bU */
                private final /* synthetic */ String f$1;
                private final /* synthetic */ String f$2;
                private final /* synthetic */ String f$3;
                private final /* synthetic */ Callback f$4;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                    this.f$4 = r5;
                }

                public final void call(Object obj) {
                    MIOTPersistModule.this.lambda$copyFile$11$MIOTPersistModule(this.f$1, this.f$2, this.f$3, this.f$4, (Integer) obj);
                }
            }).subscribe();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:112:0x0231 A[SYNTHETIC, Splitter:B:112:0x0231] */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0293 A[SYNTHETIC, Splitter:B:123:0x0293] */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x02f7 A[SYNTHETIC, Splitter:B:134:0x02f7] */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x031d A[SYNTHETIC, Splitter:B:143:0x031d] */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x017c A[EDGE_INSN: B:154:0x017c->B:73:0x017c ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0177 A[Catch:{ FileNotFoundException -> 0x01c3, IOException -> 0x01bf, Throwable -> 0x01bc, all -> 0x01b7 }, LOOP:1: B:70:0x0171->B:72:0x0177, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0195 A[SYNTHETIC, Splitter:B:75:0x0195] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:109:0x01f5=Splitter:B:109:0x01f5, B:120:0x0257=Splitter:B:120:0x0257, B:131:0x02b9=Splitter:B:131:0x02b9} */
    public /* synthetic */ void lambda$copyFile$11$MIOTPersistModule(String str, String str2, String str3, Callback callback, Integer num) {
        Uri uri;
        BufferedOutputStream bufferedOutputStream;
        BufferedInputStream bufferedInputStream;
        ParcelFileDescriptor parcelFileDescriptor;
        Throwable th;
        BufferedOutputStream bufferedOutputStream2;
        BufferedOutputStream bufferedOutputStream3;
        BufferedOutputStream bufferedOutputStream4;
        byte[] bArr;
        int read;
        String str4 = str3;
        Callback callback2 = callback;
        Uri pathToUri = pathToUri(str);
        dn dnVar = null;
        if (TextUtils.isEmpty(str2) || !MediaStoreUtil.O00000Oo(str2)) {
            if (checkFileNameValidCallBack(str4, callback2)) {
                File file = new File(getPathName(str4));
                if (file.exists()) {
                    callback2.invoke(Boolean.FALSE, gbq.O000000o(-2, String.format("file %s already exist", str4)));
                    return;
                }
                try {
                    file.createNewFile();
                    dnVar = dn.O000000o(file);
                    uri = dnVar.O000000o();
                } catch (IOException e) {
                    fyc.O000000o(TAG, "copy file,create file error:", e);
                    callback2.invoke(Boolean.FALSE, gbq.O000000o(-5, "copy file error,detail: create file error"));
                    return;
                }
            } else {
                return;
            }
        } else if (Build.VERSION.SDK_INT >= 21) {
            dn O000000o2 = dn.O000000o(CommonApplication.getAppContext(), pathToUri);
            String O00000o0 = O000000o2.O00000o0();
            if (!MediaStoreUtil.O00000Oo(str)) {
                try {
                    O00000o0 = getMimeType(getPathName(str));
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            String str5 = O00000o0;
            String O00000Oo2 = TextUtils.isEmpty(str3) ? O000000o2.O00000Oo() : str4;
            try {
                Context appContext = CommonApplication.getAppContext();
                Uri parse = Uri.parse(str2);
                dr drVar = Build.VERSION.SDK_INT >= 21 ? new dr(null, appContext, DocumentsContract.buildDocumentUriUsingTree(parse, DocumentsContract.getTreeDocumentId(parse))) : null;
                dn[] O0000O0o = drVar.O0000O0o();
                int length = O0000O0o.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        dnVar = null;
                        break;
                    }
                    dn dnVar2 = O0000O0o[i];
                    if (O00000Oo2.equals(dnVar2.O00000Oo())) {
                        dnVar = dnVar2;
                        break;
                    }
                    i++;
                }
                if (dnVar != null) {
                    if (dnVar.O00000oo()) {
                        callback2.invoke(Boolean.FALSE, gbq.O000000o(-2, String.format("file %s already exist", str4)));
                        return;
                    }
                }
                dnVar = drVar.O000000o(str5, O00000Oo2);
                if (dnVar == null) {
                    callback2.invoke(Boolean.FALSE, gbq.O000000o(-5, "copy file error,detail: create file error"));
                    return;
                }
                uri = dnVar.O000000o();
            } catch (Throwable th3) {
                th = th3;
                dnVar = null;
                callback2.invoke(Boolean.FALSE, gbq.O000000o(-4, "copy file error,detail:" + th.getMessage()));
                uri = null;
                parcelFileDescriptor = gbo.O000000o(pathToUri, 268435456);
                try {
                    ParcelFileDescriptor O000000o3 = gbo.O000000o(uri, 805306368);
                    bufferedInputStream = new BufferedInputStream(new FileInputStream(parcelFileDescriptor.getFileDescriptor()));
                    try {
                        bufferedOutputStream4 = new BufferedOutputStream(new FileOutputStream(O000000o3.getFileDescriptor()));
                    } catch (FileNotFoundException e2) {
                        e = e2;
                        bufferedOutputStream2 = null;
                        dnVar.O00000oO();
                        fyc.O00000o0(TAG, "copyFile error:" + Log.getStackTraceString(e));
                        callback2.invoke(Boolean.FALSE, gbq.O000000o(-3, "file not found,detail:" + e.getMessage()));
                        if (parcelFileDescriptor != null) {
                        }
                        gsc.O000000o((Closeable) bufferedInputStream);
                        gsc.O000000o(bufferedOutputStream);
                    } catch (IOException e3) {
                        e = e3;
                        bufferedOutputStream3 = null;
                        dnVar.O00000oO();
                        fyc.O00000o0(TAG, "copyFile error:" + Log.getStackTraceString(e));
                        callback2.invoke(Boolean.FALSE, gbq.O000000o(-4, "copy file error,detail:" + e.getMessage()));
                        if (parcelFileDescriptor != null) {
                        }
                        gsc.O000000o((Closeable) bufferedInputStream);
                        gsc.O000000o(bufferedOutputStream);
                    } catch (Throwable th4) {
                        th = th4;
                        bufferedOutputStream = null;
                        th = th;
                        if (parcelFileDescriptor != null) {
                        }
                        gsc.O000000o((Closeable) bufferedInputStream);
                        gsc.O000000o(bufferedOutputStream);
                        throw th;
                    }
                    try {
                        bArr = new byte[4096];
                        while (true) {
                            read = bufferedInputStream.read(bArr);
                            if (read > 0) {
                            }
                            bufferedOutputStream4.write(bArr, 0, read);
                        }
                        bufferedOutputStream4.flush();
                        callback2.invoke(Boolean.TRUE, gbq.O000000o(0, null, "success"));
                        if (parcelFileDescriptor != null) {
                        }
                        gsc.O000000o((Closeable) bufferedInputStream);
                        gsc.O000000o(bufferedOutputStream4);
                    } catch (FileNotFoundException e4) {
                        e = e4;
                        bufferedOutputStream2 = bufferedOutputStream4;
                        dnVar.O00000oO();
                        fyc.O00000o0(TAG, "copyFile error:" + Log.getStackTraceString(e));
                        callback2.invoke(Boolean.FALSE, gbq.O000000o(-3, "file not found,detail:" + e.getMessage()));
                        if (parcelFileDescriptor != null) {
                        }
                        gsc.O000000o((Closeable) bufferedInputStream);
                        gsc.O000000o(bufferedOutputStream);
                    } catch (IOException e5) {
                        e = e5;
                        bufferedOutputStream3 = bufferedOutputStream4;
                        dnVar.O00000oO();
                        fyc.O00000o0(TAG, "copyFile error:" + Log.getStackTraceString(e));
                        callback2.invoke(Boolean.FALSE, gbq.O000000o(-4, "copy file error,detail:" + e.getMessage()));
                        if (parcelFileDescriptor != null) {
                        }
                        gsc.O000000o((Closeable) bufferedInputStream);
                        gsc.O000000o(bufferedOutputStream);
                    } catch (Throwable th5) {
                        th = th5;
                        bufferedOutputStream = bufferedOutputStream4;
                        if (parcelFileDescriptor != null) {
                        }
                        gsc.O000000o((Closeable) bufferedInputStream);
                        gsc.O000000o(bufferedOutputStream);
                        throw th;
                    }
                } catch (FileNotFoundException e6) {
                    e = e6;
                    bufferedOutputStream2 = null;
                    bufferedInputStream = null;
                    dnVar.O00000oO();
                    fyc.O00000o0(TAG, "copyFile error:" + Log.getStackTraceString(e));
                    callback2.invoke(Boolean.FALSE, gbq.O000000o(-3, "file not found,detail:" + e.getMessage()));
                    if (parcelFileDescriptor != null) {
                        try {
                            parcelFileDescriptor.close();
                        } catch (IOException e7) {
                            IOException iOException = e7;
                            fyc.O00000o0(TAG, "copyFile,close srcFileDescriptor error," + Log.getStackTraceString(iOException));
                        }
                    }
                    gsc.O000000o((Closeable) bufferedInputStream);
                    gsc.O000000o(bufferedOutputStream);
                } catch (IOException e8) {
                    e = e8;
                    bufferedOutputStream3 = null;
                    bufferedInputStream = null;
                    dnVar.O00000oO();
                    fyc.O00000o0(TAG, "copyFile error:" + Log.getStackTraceString(e));
                    callback2.invoke(Boolean.FALSE, gbq.O000000o(-4, "copy file error,detail:" + e.getMessage()));
                    if (parcelFileDescriptor != null) {
                        try {
                            parcelFileDescriptor.close();
                        } catch (IOException e9) {
                            IOException iOException2 = e9;
                            fyc.O00000o0(TAG, "copyFile,close srcFileDescriptor error," + Log.getStackTraceString(iOException2));
                        }
                    }
                    gsc.O000000o((Closeable) bufferedInputStream);
                    gsc.O000000o(bufferedOutputStream);
                } catch (Throwable th6) {
                    bufferedOutputStream = null;
                    th = th6;
                    bufferedInputStream = null;
                    if (parcelFileDescriptor != null) {
                        try {
                            parcelFileDescriptor.close();
                        } catch (IOException e10) {
                            IOException iOException3 = e10;
                            fyc.O00000o0(TAG, "copyFile,close srcFileDescriptor error," + Log.getStackTraceString(iOException3));
                        }
                    }
                    gsc.O000000o((Closeable) bufferedInputStream);
                    gsc.O000000o(bufferedOutputStream);
                    throw th;
                }
            }
        } else {
            callback2.invoke(Boolean.FALSE, gbq.O000000o(-4, "copy file error,detail:only supported on Android API 21"));
            return;
        }
        try {
            parcelFileDescriptor = gbo.O000000o(pathToUri, 268435456);
            ParcelFileDescriptor O000000o32 = gbo.O000000o(uri, 805306368);
            bufferedInputStream = new BufferedInputStream(new FileInputStream(parcelFileDescriptor.getFileDescriptor()));
            bufferedOutputStream4 = new BufferedOutputStream(new FileOutputStream(O000000o32.getFileDescriptor()));
            bArr = new byte[4096];
            while (true) {
                read = bufferedInputStream.read(bArr);
                if (read > 0) {
                    break;
                }
                bufferedOutputStream4.write(bArr, 0, read);
            }
            bufferedOutputStream4.flush();
            callback2.invoke(Boolean.TRUE, gbq.O000000o(0, null, "success"));
            if (parcelFileDescriptor != null) {
                try {
                    parcelFileDescriptor.close();
                } catch (IOException e11) {
                    IOException iOException4 = e11;
                    fyc.O00000o0(TAG, "copyFile,close srcFileDescriptor error," + Log.getStackTraceString(iOException4));
                }
            }
            gsc.O000000o((Closeable) bufferedInputStream);
            gsc.O000000o(bufferedOutputStream4);
        } catch (FileNotFoundException e12) {
            e = e12;
            bufferedOutputStream2 = null;
            parcelFileDescriptor = null;
            bufferedInputStream = null;
            dnVar.O00000oO();
            fyc.O00000o0(TAG, "copyFile error:" + Log.getStackTraceString(e));
            callback2.invoke(Boolean.FALSE, gbq.O000000o(-3, "file not found,detail:" + e.getMessage()));
            if (parcelFileDescriptor != null) {
            }
            gsc.O000000o((Closeable) bufferedInputStream);
            gsc.O000000o(bufferedOutputStream);
        } catch (IOException e13) {
            e = e13;
            bufferedOutputStream3 = null;
            parcelFileDescriptor = null;
            bufferedInputStream = null;
            dnVar.O00000oO();
            fyc.O00000o0(TAG, "copyFile error:" + Log.getStackTraceString(e));
            callback2.invoke(Boolean.FALSE, gbq.O000000o(-4, "copy file error,detail:" + e.getMessage()));
            if (parcelFileDescriptor != null) {
            }
            gsc.O000000o((Closeable) bufferedInputStream);
            gsc.O000000o(bufferedOutputStream);
        } catch (Throwable th7) {
            bufferedOutputStream = null;
            th = th7;
            parcelFileDescriptor = null;
            bufferedInputStream = null;
            if (parcelFileDescriptor != null) {
            }
            gsc.O000000o((Closeable) bufferedInputStream);
            gsc.O000000o(bufferedOutputStream);
            throw th;
        }
    }

    @SuppressLint({"NewApi"})
    @ReactMethod
    public void queryFile(ReadableMap readableMap, Callback callback) {
        ReadableArray O00000oO = gbv.O00000oO(readableMap, "mimeTypes");
        int O00000Oo2 = gbv.O00000Oo(readableMap, "pageSize");
        int O00000Oo3 = gbv.O00000Oo(readableMap, "pageNum");
        if (O00000oO.size() == 0) {
            callback.invoke(Boolean.FALSE, gbq.O000000o(-1, "mimeType is empty"));
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < O00000oO.size(); i++) {
            arrayList.add(O00000oO.getString(i));
        }
        Observable.just(0).subscribeOn(Schedulers.io()).doOnNext(new Action1(MediaStoreUtil.O000000o(arrayList), O00000Oo2, O00000Oo3, callback) {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.$$Lambda$MIOTPersistModule$UJfJCsGL5c7Km_WjbWmr8onZi4 */
            private final /* synthetic */ String[] f$0;
            private final /* synthetic */ int f$1;
            private final /* synthetic */ int f$2;
            private final /* synthetic */ Callback f$3;

            {
                this.f$0 = r1;
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final void call(Object obj) {
                MIOTPersistModule.lambda$queryFile$12(this.f$0, this.f$1, this.f$2, this.f$3, (Integer) obj);
            }
        }).subscribe();
    }

    static /* synthetic */ void lambda$queryFile$12(String[] strArr, int i, int i2, Callback callback, Integer num) {
        WritableArray createArray = Arguments.createArray();
        try {
            for (MediaStoreUtil.O00000Oo next : MediaStoreUtil.O000000o(CommonApplication.getAppContext(), strArr, i, i2)) {
                WritableMap createMap = Arguments.createMap();
                createMap.putString("url", next.O00000Oo);
                createMap.putString("mediaType", next.O00000o0);
                createMap.putInt("modificationDate", next.O0000O0o);
                createMap.putInt("size", next.O0000Oo);
                createMap.putString("name", next.O0000OoO);
                createMap.putString("relativePath", next.O0000Oo0);
                createMap.putString("displayName", next.O0000Ooo);
                createArray.pushMap(createMap);
            }
            callback.invoke(Boolean.TRUE, gbq.O000000o(0, createArray));
        } catch (Exception e) {
            callback.invoke(Boolean.FALSE, gbq.O000000o(-2, "internal error:" + Log.getStackTraceString(e)));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:111:0x026d, code lost:
        r5.O00000Oo(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0093, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0094, code lost:
        r9 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0097, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0098, code lost:
        r9 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x009b, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x009c, code lost:
        r16 = r4;
        r9 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x01a3, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x01a4, code lost:
        r5 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x01b4, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x01b5, code lost:
        r5 = r12;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0238  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0264  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x026d  */
    /* JADX WARNING: Removed duplicated region for block: B:117:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:118:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:119:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x01a3 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:53:0x00ff] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x01b4 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:20:0x006f] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x01ed  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x01f8 A[Catch:{ all -> 0x0268 }] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x020d A[Catch:{ all -> 0x0268 }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:105:0x0241=Splitter:B:105:0x0241, B:86:0x01d2=Splitter:B:86:0x01d2, B:93:0x01f4=Splitter:B:93:0x01f4} */
    @ReactMethod
    public final void pdfToImage(ReadableMap readableMap, Callback callback) {
        char c;
        int i;
        dbj dbj;
        PdfiumCore pdfiumCore;
        String str;
        char c2;
        PdfiumCore pdfiumCore2;
        PdfiumCore pdfiumCore3;
        Bitmap.Config config;
        ReadableMap readableMap2 = readableMap;
        Callback callback2 = callback;
        String O000000o2 = gbv.O000000o(readableMap2, "srcPath");
        String O000000o3 = gbv.O000000o(readableMap2, "imageDir");
        int O00000Oo2 = gbv.O00000Oo(readableMap2, "pageIndex");
        String O000000o4 = gbv.O000000o(readableMap2, "password");
        boolean O00000o0 = gbv.O00000o0(readableMap2, "highQuality");
        if (TextUtils.isEmpty(O000000o2)) {
            c = 0;
            i = 2;
        } else if (TextUtils.isEmpty(O000000o3)) {
            i = 2;
            c = 0;
        } else if (checkFolderValidCallBack(O000000o3, callback2)) {
            if (MediaStoreUtil.O00000Oo(O000000o2) || checkFileNameValidCallBack(O000000o2, callback2)) {
                Activity currentActivity = getCurrentActivity();
                if (currentActivity == null) {
                    fyc.O00000o0(TAG, "readPdfMetaData activity is null");
                    return;
                }
                Uri pathToUri = pathToUri(O000000o2);
                dbj dbj2 = null;
                PdfiumCore pdfiumCore4 = new PdfiumCore(currentActivity);
                try {
                    dbj = pdfiumCore4.O000000o(gbo.O000000o(pathToUri, 268435456), O000000o4);
                    try {
                        if (O00000Oo2 >= pdfiumCore4.O000000o(dbj)) {
                            callback2.invoke(Boolean.FALSE, gbq.O000000o(-7, "invalid input params pageIndex,out of index:".concat(String.valueOf(O00000Oo2))));
                            pdfiumCore4.O00000Oo(dbj);
                            return;
                        }
                        Size O00000Oo3 = pdfiumCore4.O00000Oo(dbj, O00000Oo2);
                        pdfiumCore4.O000000o(dbj, O00000Oo2);
                        int i2 = O00000Oo3.f5609O000000o;
                        int i3 = O00000Oo3.O00000Oo;
                        if (O00000o0) {
                            config = Bitmap.Config.ARGB_8888;
                        } else {
                            config = Bitmap.Config.RGB_565;
                        }
                        Bitmap createBitmap = Bitmap.createBitmap(i2, i3, config);
                        PdfiumCore pdfiumCore5 = pdfiumCore4;
                        str = O000000o2;
                        c2 = 0;
                        try {
                            pdfiumCore4.O000000o(dbj, createBitmap, O00000Oo2, 0, 0, O00000Oo3.f5609O000000o, O00000Oo3.O00000Oo, false);
                            File file = new File(getPathName(O000000o3));
                            if (!file.exists()) {
                                try {
                                    file.mkdirs();
                                } catch (FileNotFoundException e) {
                                    e = e;
                                    dbj2 = dbj;
                                    pdfiumCore2 = pdfiumCore5;
                                } catch (IOException e2) {
                                    e = e2;
                                    dbj2 = dbj;
                                    pdfiumCore3 = pdfiumCore5;
                                    if (e instanceof PdfPasswordException) {
                                    }
                                    fyc.O000000o(TAG, "pdfToImage error:", e);
                                    if (dbj2 != null) {
                                    }
                                } catch (OutOfMemoryError e3) {
                                    e = e3;
                                    dbj2 = dbj;
                                    pdfiumCore = pdfiumCore5;
                                    try {
                                        fyc.O000000o(TAG, "pdfToImage error:", e);
                                        Object[] objArr = new Object[2];
                                        objArr[c2] = Boolean.FALSE;
                                        objArr[1] = gbq.O000000o(-4, "out of memory,set highQuality=false can reduce memory cost");
                                        callback2.invoke(objArr);
                                        if (dbj2 != null) {
                                        }
                                    } catch (Throwable th) {
                                        th = th;
                                        dbj = dbj2;
                                        if (dbj != null) {
                                        }
                                        throw th;
                                    }
                                } catch (Throwable th2) {
                                }
                            }
                            Calendar instance = Calendar.getInstance();
                            String format = String.format("P_PIC_%d%02d%02d_%02d%02d%02d%03d.jpg", Integer.valueOf(instance.get(1)), Integer.valueOf(instance.get(2) + 1), Integer.valueOf(instance.get(5)), Integer.valueOf(instance.get(11)), Integer.valueOf(instance.get(12)), Integer.valueOf(instance.get(13)), Integer.valueOf(instance.get(14)));
                            File file2 = new File(file, format);
                            if (file2.exists()) {
                                file2.delete();
                            }
                            createBitmap.compress(Bitmap.CompressFormat.JPEG, 90, new BufferedOutputStream(new FileOutputStream(file2)));
                            WritableMap createMap = Arguments.createMap();
                            createMap.putString("imageName", format);
                            callback2.invoke(Boolean.TRUE, gbq.O000000o(0, createMap));
                            pdfiumCore5.O00000Oo(dbj);
                            return;
                        } catch (FileNotFoundException e4) {
                            e = e4;
                            pdfiumCore2 = pdfiumCore5;
                            dbj2 = dbj;
                            fyc.O000000o(TAG, "pdfToImage error:", e);
                            Object[] objArr2 = new Object[2];
                            objArr2[c2] = Boolean.FALSE;
                            objArr2[1] = gbq.O000000o(-2, "no permission to access source file :".concat(String.valueOf(str)));
                            callback2.invoke(objArr2);
                            if (dbj2 != null) {
                                pdfiumCore.O00000Oo(dbj2);
                                return;
                            }
                            return;
                        } catch (IOException e5) {
                            e = e5;
                            pdfiumCore3 = pdfiumCore5;
                            dbj2 = dbj;
                            if (e instanceof PdfPasswordException) {
                                Object[] objArr3 = new Object[2];
                                objArr3[c2] = Boolean.FALSE;
                                objArr3[1] = gbq.O000000o(-3, "password required or incorrect password");
                                callback2.invoke(objArr3);
                            } else {
                                Object[] objArr4 = new Object[2];
                                objArr4[c2] = Boolean.FALSE;
                                objArr4[1] = gbq.O000000o(-6, "write image failed:" + Log.getStackTraceString(e));
                                callback2.invoke(objArr4);
                            }
                            fyc.O000000o(TAG, "pdfToImage error:", e);
                            if (dbj2 != null) {
                                pdfiumCore.O00000Oo(dbj2);
                                return;
                            }
                            return;
                        } catch (OutOfMemoryError e6) {
                            e = e6;
                            pdfiumCore = pdfiumCore5;
                            dbj2 = dbj;
                            fyc.O000000o(TAG, "pdfToImage error:", e);
                            Object[] objArr5 = new Object[2];
                            objArr5[c2] = Boolean.FALSE;
                            objArr5[1] = gbq.O000000o(-4, "out of memory,set highQuality=false can reduce memory cost");
                            callback2.invoke(objArr5);
                            if (dbj2 != null) {
                                pdfiumCore.O00000Oo(dbj2);
                                return;
                            }
                            return;
                        } catch (Throwable th22) {
                        }
                    } catch (FileNotFoundException e7) {
                        e = e7;
                        str = O000000o2;
                        pdfiumCore2 = pdfiumCore4;
                        c2 = 0;
                        dbj2 = dbj;
                        fyc.O000000o(TAG, "pdfToImage error:", e);
                        Object[] objArr22 = new Object[2];
                        objArr22[c2] = Boolean.FALSE;
                        objArr22[1] = gbq.O000000o(-2, "no permission to access source file :".concat(String.valueOf(str)));
                        callback2.invoke(objArr22);
                        if (dbj2 != null) {
                        }
                    } catch (IOException e8) {
                        e = e8;
                        pdfiumCore3 = pdfiumCore4;
                        c2 = 0;
                        dbj2 = dbj;
                        if (e instanceof PdfPasswordException) {
                        }
                        fyc.O000000o(TAG, "pdfToImage error:", e);
                        if (dbj2 != null) {
                        }
                    } catch (OutOfMemoryError e9) {
                        e = e9;
                        pdfiumCore = pdfiumCore4;
                        c2 = 0;
                        dbj2 = dbj;
                        fyc.O000000o(TAG, "pdfToImage error:", e);
                        Object[] objArr52 = new Object[2];
                        objArr52[c2] = Boolean.FALSE;
                        objArr52[1] = gbq.O000000o(-4, "out of memory,set highQuality=false can reduce memory cost");
                        callback2.invoke(objArr52);
                        if (dbj2 != null) {
                        }
                    } catch (Throwable th3) {
                    }
                } catch (FileNotFoundException e10) {
                    e = e10;
                    str = O000000o2;
                    pdfiumCore2 = pdfiumCore4;
                    c2 = 0;
                    fyc.O000000o(TAG, "pdfToImage error:", e);
                    Object[] objArr222 = new Object[2];
                    objArr222[c2] = Boolean.FALSE;
                    objArr222[1] = gbq.O000000o(-2, "no permission to access source file :".concat(String.valueOf(str)));
                    callback2.invoke(objArr222);
                    if (dbj2 != null) {
                    }
                } catch (IOException e11) {
                    e = e11;
                    pdfiumCore3 = pdfiumCore4;
                    c2 = 0;
                    if (e instanceof PdfPasswordException) {
                    }
                    fyc.O000000o(TAG, "pdfToImage error:", e);
                    if (dbj2 != null) {
                    }
                } catch (OutOfMemoryError e12) {
                    e = e12;
                    pdfiumCore = pdfiumCore4;
                    c2 = 0;
                    fyc.O000000o(TAG, "pdfToImage error:", e);
                    Object[] objArr522 = new Object[2];
                    objArr522[c2] = Boolean.FALSE;
                    objArr522[1] = gbq.O000000o(-4, "out of memory,set highQuality=false can reduce memory cost");
                    callback2.invoke(objArr522);
                    if (dbj2 != null) {
                    }
                } catch (Throwable th4) {
                    th = th4;
                    pdfiumCore = pdfiumCore4;
                    dbj = dbj2;
                    if (dbj != null) {
                    }
                    throw th;
                }
            } else {
                return;
            }
        } else {
            return;
        }
        Object[] objArr6 = new Object[i];
        objArr6[c] = Boolean.FALSE;
        objArr6[1] = gbq.O000000o(-1, "invalid srcPath or imageDir");
        callback2.invoke(objArr6);
    }

    @ReactMethod
    public final void readPdfMetaData(ReadableMap readableMap, Callback callback) {
        String O000000o2 = gbv.O000000o(readableMap, "srcPath");
        String O000000o3 = gbv.O000000o(readableMap, "password");
        if (TextUtils.isEmpty(O000000o2)) {
            callback.invoke(Boolean.FALSE, gbq.O000000o(-1, "invalid srcPath or imageDir"));
        } else if (MediaStoreUtil.O00000Oo(O000000o2) || checkFileNameValidCallBack(O000000o2, callback)) {
            Activity currentActivity = getCurrentActivity();
            if (currentActivity == null) {
                fyc.O00000o0(TAG, "readPdfMetaData activity is null");
                return;
            }
            Uri pathToUri = pathToUri(O000000o2);
            dbj dbj = null;
            PdfiumCore pdfiumCore = new PdfiumCore(currentActivity);
            try {
                dbj = pdfiumCore.O000000o(gbo.O000000o(pathToUri, 268435456), O000000o3);
                int O000000o4 = pdfiumCore.O000000o(dbj);
                WritableMap createMap = Arguments.createMap();
                createMap.putInt("pageCount", O000000o4);
                callback.invoke(Boolean.TRUE, gbq.O000000o(0, createMap));
                pdfiumCore.O00000Oo(dbj);
            } catch (FileNotFoundException e) {
                fyc.O000000o(TAG, "readPdfMetaData error:", e);
                callback.invoke(Boolean.FALSE, gbq.O000000o(-2, "no permission to access source file :".concat(String.valueOf(O000000o2))));
                if (dbj != null) {
                    pdfiumCore.O00000Oo(dbj);
                }
            } catch (IOException e2) {
                if (e2 instanceof PdfPasswordException) {
                    callback.invoke(Boolean.FALSE, gbq.O000000o(-3, "password required or incorrect password"));
                }
                fyc.O000000o(TAG, "readPdfMetaData error:", e2);
                if (dbj != null) {
                    pdfiumCore.O00000Oo(dbj);
                }
            } catch (Throwable th) {
                if (dbj != null) {
                    pdfiumCore.O00000Oo(dbj);
                }
                throw th;
            }
        }
    }

    @ReactMethod
    public void createMediaWithPoints(ReadableArray readableArray, String str, String str2, ReadableMap readableMap, final Callback callback) {
        String str3;
        ReadableMap map;
        List<md> O000000o2 = gag.O000000o(readableArray);
        fzo fzo = new fzo();
        if (readableMap.hasKey("backgroundColor") && !readableMap.isNull("backgroundColor")) {
            fzo.f17447O000000o = readableMap.getInt("backgroundColor");
        }
        if (readableMap.hasKey("lineColor") && !readableMap.isNull("lineColor")) {
            fzo.O00000Oo = readableMap.getInt("lineColor");
        }
        if (readableMap.hasKey("lineWidth") && !readableMap.isNull("lineWidth")) {
            fzo.O00000o0 = (float) readableMap.getDouble("lineWidth");
        }
        if (readableMap.hasKey("scale") && !readableMap.isNull("scale")) {
            fzo.O00000o = (float) readableMap.getDouble("scale");
        }
        if (readableMap.hasKey("size") && !readableMap.isNull("size") && (map = readableMap.getMap("size")) != null) {
            if (map.hasKey("width") && !map.isNull("width")) {
                fzo.O00000oO = map.getInt("width");
            }
            if (map.hasKey("height") && !map.isNull("height")) {
                fzo.O00000oo = map.getInt("height");
            }
        }
        if (readableMap.hasKey("maxPressure") && !readableMap.isNull("maxPressure")) {
            fzo.O0000O0o = readableMap.getInt("maxPressure");
        }
        if (readableMap.hasKey("pointsPerFrame") && !readableMap.isNull("pointsPerFrame")) {
            fzo.O0000OOo = readableMap.getInt("pointsPerFrame");
        }
        if (readableMap.hasKey("fps") && !readableMap.isNull("fps")) {
            fzo.O0000Oo0 = readableMap.getInt("fps");
        }
        AnonymousClass16 r10 = new gaa() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTPersistModule.AnonymousClass16 */

            public final void O000000o(String str) {
                callback.invoke(Boolean.TRUE, str);
            }

            public final void O000000o(int i) {
                callback.invoke(Boolean.FALSE, gbq.O000000o(i, fzy.O000000o(i)));
            }
        };
        fzy fzy = new fzy(O000000o2, getFilesPath().getAbsolutePath(), fzo);
        char c = 65535;
        int hashCode = str.hashCode();
        if (hashCode != 110834) {
            if (hashCode != 100313435) {
                if (hashCode == 112202875 && str.equals("video")) {
                    c = 1;
                }
            } else if (str.equals("image")) {
                c = 0;
            }
        } else if (str.equals("pdf")) {
            c = 2;
        }
        if (c == 0) {
            fzy.f17451O000000o = true;
            fzy.O00000o = r10;
            String str4 = fzy.O00000Oo + str2;
            if (TextUtils.isEmpty(str4)) {
                if (fzy.O00000o != null) {
                    fzy.O00000o.O000000o(10005);
                }
            } else if (!gad.O00000Oo(str4)) {
                String substring = str4.substring(0, str4.lastIndexOf(File.separator) + 1);
                String substring2 = str4.substring(str4.lastIndexOf(File.separator) + 1);
                if (gad.O000000o(substring)) {
                    fzy.O000000o();
                    fzy.O000000o(fzy.O00000o0);
                    Bitmap bitmap = fzy.O00000oo;
                    Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.PNG;
                    if (bitmap != null) {
                        try {
                            if (!TextUtils.isEmpty(substring)) {
                                if (!TextUtils.isEmpty(substring2)) {
                                    File file = new File(substring);
                                    if (!file.exists()) {
                                        file.mkdirs();
                                    }
                                    File file2 = new File(substring, substring2);
                                    if (!file2.exists()) {
                                        file2.createNewFile();
                                    } else if (file2.delete()) {
                                        file2.createNewFile();
                                    }
                                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
                                    bitmap.compress(compressFormat, 100, bufferedOutputStream);
                                    bufferedOutputStream.flush();
                                    bufferedOutputStream.close();
                                    str3 = substring + substring2;
                                    if (!TextUtils.isEmpty(str3) && fzy.O00000o != null && fzy.f17451O000000o) {
                                        fzy.O00000o.O000000o(str3);
                                    }
                                    gsy.O000000o(6, "saveImage", str3);
                                }
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                            if (bitmap != null) {
                                bitmap.recycle();
                            }
                            if (fzy.O00000o != null) {
                                fzy.O00000o.O000000o(10004);
                                return;
                            }
                            return;
                        }
                    }
                    str3 = null;
                    fzy.O00000o.O000000o(str3);
                    gsy.O000000o(6, "saveImage", str3);
                } else if (fzy.O00000o != null) {
                    fzy.O00000o.O000000o(10003);
                }
            } else if (fzy.O00000o != null) {
                fzy.O00000o.O000000o(10002);
            }
        } else if (c == 1) {
            fzy.f17451O000000o = false;
            fzy.O00000o = r10;
            String str5 = fzy.O00000Oo + str2;
            if (TextUtils.isEmpty(str5)) {
                if (fzy.O00000o != null) {
                    fzy.O00000o.O000000o(10005);
                }
            } else if (gad.O00000Oo(str5)) {
                if (fzy.O00000o != null) {
                    fzy.O00000o.O000000o(10002);
                }
            } else if (gad.O000000o(str5.substring(0, str5.lastIndexOf(File.separator) + 1))) {
                fzy.O000000o();
                fzw.O000000o(fzy.O0000O0o, fzy.O0000OOo, new fzu(str5) {
                    /* class _m_j.fzy.AnonymousClass1 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    final /* synthetic */ String f17452O000000o;

                    {
                        this.f17452O000000o = r2;
                    }

                    public final void O000000o() {
                        if (fzy.this.O0000O0o != null) {
                            fzy.this.O0000O0o.O00000o0();
                        }
                        if (fzy.this.O00000o != null) {
                            fzy.this.O00000o.O000000o(this.f17452O000000o);
                        }
                    }

                    public final void O00000Oo() {
                        if (fzy.this.O0000O0o != null) {
                            fzy.this.O0000O0o.O00000o0();
                        }
                        if (fzy.this.O00000o != null) {
                            fzy.this.O00000o.O000000o(10003);
                        }
                    }

                    public final void O00000o0() {
                        if (fzy.this.O0000O0o != null) {
                            fzy.this.O0000O0o.O00000o0();
                        }
                    }
                }, str5);
                fzy.O000000o(fzy.O00000o0);
            } else if (fzy.O00000o != null) {
                fzy.O00000o.O000000o(10003);
            }
        } else if (c != 2) {
            callback.invoke(Boolean.FALSE, gbq.O000000o(-1, "unsupported file type"));
        } else {
            fzy.f17451O000000o = true;
            fzy.O00000o = r10;
            String str6 = fzy.O00000Oo + str2;
            if (TextUtils.isEmpty(str6)) {
                if (fzy.O00000o != null) {
                    fzy.O00000o.O000000o(10005);
                }
            } else if (gad.O00000Oo(str6)) {
                if (fzy.O00000o != null) {
                    fzy.O00000o.O000000o(10002);
                }
            } else if (gad.O000000o(str6.substring(0, str6.lastIndexOf(File.separator) + 1))) {
                fzy.O000000o();
                fzy.O000000o(fzy.O00000o0);
                Bitmap bitmap2 = fzy.O00000oo;
                if (bitmap2 != null && !TextUtils.isEmpty(str6)) {
                    fzz O000000o3 = new fzz.O000000o(str6, new int[]{bitmap2.getWidth(), bitmap2.getHeight()}).O000000o().O000000o();
                    if (!(bitmap2 == null || O000000o3.f17453O000000o == null || O000000o3.O00000oO == null)) {
                        float width = (float) (O000000o3.f17453O000000o[0] / bitmap2.getWidth());
                        Matrix matrix = new Matrix();
                        matrix.postScale(width, width);
                        O000000o3.O00000oO.getCanvas().drawBitmap(bitmap2, matrix, new Paint(1));
                    }
                    boolean O00000o0 = O000000o3.O00000Oo().O00000o0();
                    if (fzy.O00000o == null) {
                        return;
                    }
                    if (O00000o0) {
                        fzy.O00000o.O000000o(str6);
                    } else {
                        fzy.O00000o.O000000o(10004);
                    }
                }
            } else if (fzy.O00000o != null) {
                fzy.O00000o.O000000o(10003);
            }
        }
    }

    @ReactMethod
    public void cropImage(String str, String str2, ReadableMap readableMap, final Callback callback) {
        File file = new File(getPathName(str));
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists()) {
            parentFile.mkdirs();
        }
        if (file.exists()) {
            callback.invoke(Boolean.FALSE, gbq.O000000o(-1, "targetFile is already exist"));
            return;
        }
        String pathName = getPathName(str2);
        if (!new File(pathName).exists()) {
            callback.invoke(Boolean.FALSE, gbq.O000000o(-2, "please specify a sourceFilename"));
            return;
        }
        gai.O000000o O000000o2 = gai.O000000o(readableMap);
        if (O000000o2 == null) {
            callback.invoke(Boolean.FALSE, gbq.O000000o(-3, "please specify offset and size"));
            return;
        }
        gai.O000000o(getReactApplicationContext(), pathName, file, O000000o2, new gbh<String>() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTPersistModule.AnonymousClass18 */

            public final /* synthetic */ void O000000o(Object obj) {
                callback.invoke(Boolean.TRUE, (String) obj);
            }

            public final void O000000o(String str) {
                callback.invoke(Boolean.FALSE, gbq.O000000o(-99, str));
            }
        });
    }

    @ReactMethod
    public final void uploadFile(ReadableMap readableMap, Callback callback) {
        ReadableArray readableArray;
        String str;
        MIOTPersistModule mIOTPersistModule = this;
        ReadableMap readableMap2 = readableMap;
        Callback callback2 = callback;
        String str2 = "";
        String O000000o2 = fyf.O000000o(readableMap2, "uploadUrl", str2);
        String O000000o3 = fyf.O000000o(readableMap2, "method", str2);
        ReadableMap O00000o0 = fyf.O00000o0(readableMap2, "headers");
        ReadableMap O00000o02 = fyf.O00000o0(readableMap2, "fields");
        ReadableArray O00000Oo2 = fyf.O00000Oo(readableMap2, "files");
        boolean O000000o4 = fyf.O000000o(readableMap2, "allow_private_certificates");
        if (O00000Oo2 != null) {
            WritableArray createArray = Arguments.createArray();
            int i = 0;
            while (i < O00000Oo2.size()) {
                ReadableMap map = O00000Oo2.getMap(i);
                String O000000o5 = fyf.O000000o(map, "path", str2);
                String O000000o6 = fyf.O000000o(map, "filename", str2);
                if (!mIOTPersistModule.checkFolderValidCallBack(O000000o5, callback2) || !mIOTPersistModule.checkFileNameValidCallBack(O000000o6, callback2)) {
                    gbu.O00000o("filepath or filename is invalid");
                    return;
                }
                if (O000000o6 != null) {
                    File fileFromUri = mIOTPersistModule.getFileFromUri(Uri.parse(O000000o6));
                    if (fileFromUri != null) {
                        O000000o5 = fileFromUri.getPath();
                        O000000o6 = fileFromUri.getName();
                    }
                    WritableMap createMap = Arguments.createMap();
                    createMap.putString("filename", O000000o6);
                    if (TextUtils.isEmpty(O000000o5)) {
                        O000000o5 = mIOTPersistModule.getPathName(O000000o6);
                    }
                    createMap.putString("filepath", O000000o5);
                    ReadableMap O00000o03 = fyf.O00000o0(map, "range");
                    if (O00000o03 != null) {
                        str = str2;
                        WritableMap createMap2 = Arguments.createMap();
                        readableArray = O00000Oo2;
                        createMap2.putDouble("start", gbv.O00000oo(O00000o03, "start"));
                        createMap2.putDouble("length", gbv.O00000oo(O00000o03, "length"));
                        createMap.putMap("range", createMap2);
                    } else {
                        str = str2;
                        readableArray = O00000Oo2;
                    }
                    ReadableMap O00000o04 = fyf.O00000o0(map, "formdata");
                    if (O00000o04 != null) {
                        WritableMap createMap3 = Arguments.createMap();
                        createMap3.putString("name", gbv.O000000o(O00000o04, "name"));
                        createMap3.putString("filename", gbv.O000000o(O00000o04, "filename"));
                        createMap.putMap("formdata", createMap3);
                    }
                    createArray.pushMap(createMap);
                } else {
                    str = str2;
                    readableArray = O00000Oo2;
                }
                i++;
                mIOTPersistModule = this;
                callback2 = callback;
                str2 = str;
                O00000Oo2 = readableArray;
            }
            Observable.just(0).subscribeOn(gbm.O000000o()).doOnNext(new Action1(O000000o2, O000000o3, O00000o0, O00000o02, createArray, O000000o4, callback) {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.$$Lambda$MIOTPersistModule$ZZTUwFBb1G5xS69pXASRqdW1p0E */
                private final /* synthetic */ String f$1;
                private final /* synthetic */ String f$2;
                private final /* synthetic */ ReadableMap f$3;
                private final /* synthetic */ ReadableMap f$4;
                private final /* synthetic */ WritableArray f$5;
                private final /* synthetic */ boolean f$6;
                private final /* synthetic */ Callback f$7;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                    this.f$4 = r5;
                    this.f$5 = r6;
                    this.f$6 = r7;
                    this.f$7 = r8;
                }

                public final void call(Object obj) {
                    MIOTPersistModule.this.lambda$uploadFile$5$MIOTPersistModule(this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7, (Integer) obj);
                }
            }).subscribe();
            return;
        }
        callback.invoke(Boolean.FALSE, "file path is illegal");
    }

    @ReactMethod
    public final void uploadFileToMiCloud(ReadableMap readableMap, Callback callback) {
        Observable.just(0).subscribeOn(gbm.O000000o()).doOnNext(new Action1(fyf.O000000o(readableMap, "uploadUrl", ""), fyf.O000000o(readableMap, "method", ""), fyf.O00000o0(readableMap, "headers"), fyf.O00000o0(readableMap, "file"), callback) {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.$$Lambda$MIOTPersistModule$M0JFoQjFAsEIHEVDOJmYRYAXKs */
            private final /* synthetic */ String f$1;
            private final /* synthetic */ String f$2;
            private final /* synthetic */ ReadableMap f$3;
            private final /* synthetic */ ReadableMap f$4;
            private final /* synthetic */ Callback f$5;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
                this.f$4 = r5;
                this.f$5 = r6;
            }

            public final void call(Object obj) {
                MIOTPersistModule.this.lambda$uploadFileToMiCloud$6$MIOTPersistModule(this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, (Integer) obj);
            }
        }).subscribe();
    }

    @ReactMethod
    public final void uploadFileToFDS(ReadableMap readableMap, Callback callback) {
        final String O000000o2 = fyf.O000000o(readableMap, "uploadUrl", "");
        final String O000000o3 = fyf.O000000o(readableMap, "method", "");
        final ReadableMap O00000o0 = fyf.O00000o0(readableMap, "headers");
        final ReadableMap O00000o02 = fyf.O00000o0(readableMap, "fields");
        ReadableArray O00000Oo2 = fyf.O00000Oo(readableMap, "files");
        if (O00000Oo2 != null) {
            final WritableArray createArray = Arguments.createArray();
            for (int i = 0; i < O00000Oo2.size(); i++) {
                ReadableMap map = O00000Oo2.getMap(i);
                String O000000o4 = fyf.O000000o(map, "path", "");
                String O000000o5 = fyf.O000000o(map, "filename", "");
                if (!checkFolderValidCallBack(O000000o4, callback) || !checkFileNameValidCallBack(O000000o5, callback)) {
                    gbu.O00000o("filepath or filename is invalid");
                    return;
                }
                if (O000000o5 != null) {
                    WritableMap createMap = Arguments.createMap();
                    createMap.putString("filename", O000000o5);
                    if (TextUtils.isEmpty(O000000o4)) {
                        O000000o4 = getPathName(O000000o5);
                    }
                    createMap.putString("filepath", O000000o4);
                    createArray.pushMap(createMap);
                }
            }
            final Callback callback2 = callback;
            Observable.just(0).observeOn(Schedulers.io()).map(new Func1<Integer, Boolean>() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTPersistModule.AnonymousClass19 */

                public final /* synthetic */ Object call(Object obj) {
                    return O000000o();
                }

                private Boolean O000000o() {
                    try {
                        String str = O000000o2;
                        String str2 = O000000o3;
                        HashMap<String, Object> hashMap = null;
                        HashMap<String, Object> hashMap2 = O00000o0 == null ? null : O00000o0.toHashMap();
                        if (O00000o02 != null) {
                            hashMap = O00000o02.toHashMap();
                        }
                        MIOTPersistModule.uploadToFDS(str, str2, hashMap2, hashMap, createArray, new Callback() {
                            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTPersistModule.AnonymousClass19.AnonymousClass1 */

                            public final void invoke(Object... objArr) {
                                if (objArr != null && objArr.length == 5 && objArr[1] == null) {
                                    try {
                                        MIOTPersistModule.this.sendFileUploadProgressEvent(O000000o2, objArr[2].toString(), ((Long) objArr[3]).longValue(), ((Long) objArr[4]).longValue());
                                    } catch (Exception e) {
                                        gbu.O00000Oo(e.toString());
                                    }
                                } else {
                                    callback2.invoke(objArr);
                                }
                            }
                        });
                    } catch (Exception e) {
                        callback2.invoke(Boolean.FALSE, Log.getStackTraceString(e));
                    }
                    return Boolean.TRUE;
                }
            }).subscribe();
            return;
        }
        callback.invoke(Boolean.FALSE, "file path is illegal");
    }

    @ReactMethod
    public void writePdfFile(String str, String str2, ReadableMap readableMap, Callback callback) {
        ReadableMap map;
        ReadableMap readableMap2 = readableMap;
        fzp fzp = new fzp();
        if (readableMap2.hasKey("color") && !readableMap2.isNull("color")) {
            fzp.f17448O000000o = readableMap2.getInt("color");
        }
        if (readableMap2.hasKey("fontSize") && !readableMap2.isNull("fontSize")) {
            fzp.O00000Oo = readableMap2.getInt("fontSize");
        }
        if (readableMap2.hasKey("pageSize") && !readableMap2.isNull("pageSize") && (map = readableMap2.getMap("pageSize")) != null) {
            if (map.hasKey("width") && !map.isNull("width")) {
                fzp.O00000o0 = map.getInt("width");
            }
            if (map.hasKey("height") && !map.isNull("height")) {
                fzp.O00000o0 = map.getInt("height");
            }
        }
        if (readableMap2.hasKey("marginHorizontal") && !readableMap2.isNull("marginHorizontal")) {
            fzp.O00000oO = readableMap2.getInt("marginHorizontal");
        }
        if (readableMap2.hasKey("marginVertical") && !readableMap2.isNull("marginVertical")) {
            fzp.O00000oo = readableMap2.getInt("marginVertical");
        }
        fzy fzy = new fzy(getFilesPath().getAbsolutePath());
        HashMap hashMap = new HashMap();
        Typeface create = Typeface.create(Typeface.DEFAULT, 0);
        hashMap.put("text_size", Integer.valueOf(fzp.O00000Oo));
        hashMap.put("text_color", Integer.valueOf(fzp.f17448O000000o));
        hashMap.put("typeface", create);
        hashMap.put("width", Integer.valueOf(fzp.O00000o0));
        hashMap.put("height", Integer.valueOf(fzp.O00000o));
        hashMap.put("margin_horizontal", Integer.valueOf(fzp.O00000oO));
        hashMap.put("margin_vertical", Integer.valueOf(fzp.O00000oo));
        final Callback callback2 = callback;
        fzy.O00000o = new gaa() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTPersistModule.AnonymousClass17 */

            public final void O000000o(String str) {
                callback2.invoke(Boolean.TRUE, str);
            }

            public final void O000000o(int i) {
                callback2.invoke(Boolean.FALSE, gbq.O000000o(i, fzy.O000000o(i)));
            }
        };
        String str3 = fzy.O00000Oo + str2;
        if (TextUtils.isEmpty(str3)) {
            if (fzy.O00000o != null) {
                fzy.O00000o.O000000o(10005);
            }
        } else if (gad.O00000Oo(str3)) {
            if (fzy.O00000o != null) {
                fzy.O00000o.O000000o(10002);
            }
        } else if (!gad.O000000o(str3.substring(0, str3.lastIndexOf(File.separator) + 1))) {
            if (fzy.O00000o != null) {
                fzy.O00000o.O000000o(10003);
            }
        } else if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3)) {
            Typeface.create(Typeface.DEFAULT, 0);
            int[] iArr = {gaf.O000000o(CommonApplication.getAppContext()), gaf.O00000Oo(CommonApplication.getAppContext())};
            int intValue = ((Integer) hashMap.get("text_size")).intValue();
            int intValue2 = ((Integer) hashMap.get("text_color")).intValue();
            int[] iArr2 = {((Integer) hashMap.get("width")).intValue(), ((Integer) hashMap.get("height")).intValue()};
            int[] iArr3 = {((Integer) hashMap.get("margin_horizontal")).intValue(), ((Integer) hashMap.get("margin_vertical")).intValue(), ((Integer) hashMap.get("margin_horizontal")).intValue(), ((Integer) hashMap.get("margin_vertical")).intValue()};
            fzz.O000000o o000000o = new fzz.O000000o(str3, iArr2);
            o000000o.O00000o = (float) intValue;
            o000000o.O00000oO = intValue2;
            o000000o.O00000oo = (Typeface) hashMap.get("typeface");
            o000000o.O00000o0 = iArr3;
            fzz O000000o2 = o000000o.O000000o().O000000o();
            if (!TextUtils.isEmpty(str) && O000000o2.O00000oO != null) {
                TextPaint textPaint = new TextPaint();
                textPaint.setColor(O000000o2.O00000Oo);
                textPaint.setTextSize(O000000o2.O00000o);
                textPaint.setTextAlign(Paint.Align.LEFT);
                textPaint.setTypeface(O000000o2.O00000o0);
                new StaticLayout(str, 0, str.length(), textPaint, O000000o2.O00000oO.getCanvas().getWidth(), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).draw(O000000o2.O00000oO.getCanvas());
            }
            boolean O00000o0 = O000000o2.O00000Oo().O00000o0();
            if (fzy.O00000o != null) {
                if (O00000o0) {
                    fzy.O00000o.O000000o(str3);
                } else {
                    fzy.O00000o.O000000o(10004);
                }
            }
        }
    }
}

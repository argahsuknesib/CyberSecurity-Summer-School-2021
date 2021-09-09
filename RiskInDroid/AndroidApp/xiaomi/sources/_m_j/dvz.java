package _m_j;

import com.google.gson.Gson;
import com.xiaomi.infra.galaxy.fds.android.GalaxyFDSClientImpl$1;
import com.xiaomi.infra.galaxy.fds.android.GalaxyFDSClientImpl$2;
import com.xiaomi.infra.galaxy.fds.android.exception.GalaxyFDSClientException;
import com.xiaomi.infra.galaxy.fds.model.HttpMethod;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;

public final class dvz implements dvy {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final boolean f14991O000000o;
    private final dvx O00000Oo;
    private ThreadPoolExecutor O00000o;
    private final HttpClient O00000o0;

    static {
        String property = System.getProperty("java.runtime.name");
        if (property == null || !property.equals("android runtime")) {
            f14991O000000o = true;
        } else {
            f14991O000000o = false;
        }
    }

    public dvz(dvx dvx) {
        this.O00000Oo = dvx;
        dvx dvx2 = this.O00000Oo;
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, dvx2.O00000Oo);
        HttpConnectionParams.setSoTimeout(basicHttpParams, dvx2.f14990O000000o);
        HttpConnectionParams.setStaleCheckingEnabled(basicHttpParams, true);
        HttpConnectionParams.setTcpNoDelay(basicHttpParams, true);
        int i = dvx2.O000000o()[0];
        int i2 = dvx2.O000000o()[1];
        if (i > 0 || i2 > 0) {
            HttpConnectionParams.setSocketBufferSize(basicHttpParams, Math.max(i, i2));
        }
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        if (dvx2.O0000Oo) {
            schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        }
        this.O00000o0 = new DefaultHttpClient(new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams);
        this.O00000o = new ThreadPoolExecutor(dvx.O00000oO, dvx.O00000oo, (long) dvx.O0000O0o, TimeUnit.SECONDS, new ArrayBlockingQueue(dvx.O0000OOo, true), new GalaxyFDSClientImpl$1(this));
    }

    private dwf O000000o(String str, String str2, File file, List<dwi> list) throws GalaxyFDSClientException {
        dwj.O000000o(file, "file");
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            dwd dwd = new dwd();
            dwd.O00000Oo.put("Content-Length", Long.toString(file.length()));
            dwd.O000000o(dwn.O000000o(file));
            dwd.O00000Oo.put("Last-Modified", dwn.O000000o(new Date(file.lastModified())));
            return O000000o(str, str2, bufferedInputStream, dwd, (List<dwi>) null, (dwe) null);
        } catch (FileNotFoundException e) {
            throw new GalaxyFDSClientException("Unable to find the file to be uploaded:" + file.getAbsolutePath(), e);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:81|(0)|85|86) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:85:0x01e2 */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0138 A[SYNTHETIC, Splitter:B:52:0x0138] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x01df A[SYNTHETIC, Splitter:B:83:0x01df] */
    private dwf O000000o(String str, String str2, InputStream inputStream, dwd dwd, List<dwi> list, dwe dwe) throws GalaxyFDSClientException {
        String str3;
        String str4;
        String str5;
        InputStream inputStream2;
        InputStream inputStream3;
        String str6;
        String str7;
        int i;
        GalaxyFDSClientImpl$2 galaxyFDSClientImpl$2;
        String str8 = str;
        InputStream inputStream4 = inputStream;
        dwd dwd2 = dwd;
        String str9 = "/";
        dwj.O000000o(str8, "bucket name");
        if (str8 == null) {
            throw new IllegalArgumentException("bucket name" + " may not be null");
        } else if (str.length() != 0) {
            dwj.O000000o(inputStream4, "input stream");
            dwj.O000000o(dwd2, "metadata");
            long O000000o2 = dwd.O000000o();
            if (O000000o2 >= 0) {
                if (dwd2.O00000Oo.get("Content-Type") == null) {
                    dwd2.O000000o(dwk.f15000O000000o);
                }
                dwl dwl = new dwl(inputStream4, dwd2, null);
                try {
                    dwc O000000o3 = O000000o(str, str2);
                    String str10 = O000000o3.O00000Oo;
                    try {
                        str4 = O000000o3.O00000o0;
                        try {
                            long j = (long) this.O00000Oo.O00000o;
                            int max = Math.max(1, (int) (((O000000o2 + j) - 1) / j));
                            ArrayList arrayList = new ArrayList(max);
                            int i2 = 1;
                            while (i2 <= max) {
                                ArrayList<Future> arrayList2 = new ArrayList<>(max);
                                str7 = str10;
                                long j2 = O000000o2;
                                int i3 = i2;
                                while (true) {
                                    if (i3 > max) {
                                        i = max;
                                        break;
                                    }
                                    i = max;
                                    try {
                                        if (i3 - i2 >= this.O00000Oo.O00000oo) {
                                            break;
                                        }
                                        long min = Math.min(j, j2);
                                        int i4 = i3;
                                        int i5 = (int) min;
                                        long j3 = min;
                                        byte[] bArr = new byte[i5];
                                        dwl.read(bArr, 0, i5);
                                        ThreadPoolExecutor threadPoolExecutor = this.O00000o;
                                        ArrayList arrayList3 = arrayList2;
                                        int i6 = i2;
                                        str3 = str9;
                                        ArrayList arrayList4 = arrayList;
                                        long j4 = j;
                                        try {
                                            new GalaxyFDSClientImpl$2(this, str4, str, str7, i4, bArr);
                                            arrayList3.add(threadPoolExecutor.submit(galaxyFDSClientImpl$2));
                                            j2 -= j3;
                                            i3 = i4 + 1;
                                            max = i;
                                            dwd dwd3 = dwd;
                                            arrayList2 = arrayList3;
                                            arrayList = arrayList4;
                                            i2 = i6;
                                            str9 = str3;
                                            j = j4;
                                            String str11 = str;
                                        } catch (Exception e) {
                                            e = e;
                                            str5 = str7;
                                            if (str4 != null) {
                                            }
                                            throw new GalaxyFDSClientException(e);
                                        }
                                    } catch (Exception e2) {
                                        e = e2;
                                        str3 = str9;
                                        str5 = str7;
                                        if (str4 != null) {
                                        }
                                        throw new GalaxyFDSClientException(e);
                                    }
                                }
                                int i7 = i3;
                                long j5 = j;
                                str3 = str9;
                                ArrayList arrayList5 = arrayList;
                                for (Future future : arrayList2) {
                                    arrayList5.add(future.get());
                                }
                                String str12 = str;
                                max = i;
                                dwd dwd4 = dwd;
                                arrayList = arrayList5;
                                O000000o2 = j2;
                                str10 = str7;
                                i2 = i7;
                                str9 = str3;
                                j = j5;
                            }
                            String str13 = str9;
                            dwh dwh = new dwh();
                            dwh.f14998O000000o = arrayList;
                            dwf O000000o4 = O000000o(str4, str, str10, dwd, dwh, list);
                            try {
                                dwl.close();
                            } catch (IOException unused) {
                            }
                            return O000000o4;
                        } catch (Exception e3) {
                            e = e3;
                            str3 = str9;
                            str7 = str10;
                            str5 = str7;
                            if (str4 != null) {
                            }
                            throw new GalaxyFDSClientException(e);
                        }
                    } catch (Exception e4) {
                        e = e4;
                        str6 = str9;
                        str5 = str10;
                        str4 = null;
                        if (str4 != null) {
                        }
                        throw new GalaxyFDSClientException(e);
                    }
                } catch (Exception e5) {
                    e = e5;
                    str6 = str9;
                    str5 = str2;
                    str4 = null;
                    if (str4 != null) {
                        try {
                            StringBuilder sb = new StringBuilder();
                            sb.append(this.O00000Oo.O00000Oo());
                            String str14 = str3;
                            sb.append(str14);
                            String str15 = str;
                            sb.append(str15);
                            sb.append(str14);
                            sb.append(str5);
                            sb.append("?uploadId=");
                            sb.append(str4);
                            String sb2 = sb.toString();
                            try {
                                inputStream3 = null;
                                try {
                                    HttpResponse execute = this.O00000o0.execute(dwm.O000000o(sb2, this.O00000Oo.O0000Oo0, HttpMethod.DELETE, null));
                                    inputStream2 = execute.getEntity().getContent();
                                    try {
                                        if (execute.getStatusLine().getStatusCode() != 200) {
                                            throw new GalaxyFDSClientException("Unable to upload object[" + str15 + str14 + str5 + "] to URI :" + sb2 + ". Fail to abort multipart upload: " + execute.getStatusLine().toString());
                                        } else if (inputStream2 != null) {
                                            try {
                                                inputStream2.close();
                                            } catch (IOException unused2) {
                                            }
                                        }
                                    } catch (IOException e6) {
                                        e = e6;
                                        try {
                                            throw new GalaxyFDSClientException("Fail to abort multipart upload. URI:".concat(String.valueOf(sb2)), e);
                                        } catch (Throwable th) {
                                            th = th;
                                            if (inputStream2 != null) {
                                            }
                                            throw th;
                                        }
                                    }
                                } catch (IOException e7) {
                                    e = e7;
                                    inputStream2 = inputStream3;
                                    throw new GalaxyFDSClientException("Fail to abort multipart upload. URI:".concat(String.valueOf(sb2)), e);
                                } catch (Throwable th2) {
                                    th = th2;
                                    inputStream2 = inputStream3;
                                    if (inputStream2 != null) {
                                        inputStream2.close();
                                    }
                                    throw th;
                                }
                            } catch (IOException e8) {
                                e = e8;
                                inputStream3 = null;
                                inputStream2 = inputStream3;
                                throw new GalaxyFDSClientException("Fail to abort multipart upload. URI:".concat(String.valueOf(sb2)), e);
                            } catch (Throwable th3) {
                                th = th3;
                                inputStream3 = null;
                                inputStream2 = inputStream3;
                                if (inputStream2 != null) {
                                }
                                throw th;
                            }
                        } catch (Throwable th4) {
                            try {
                                dwl.close();
                            } catch (IOException unused3) {
                            }
                            throw th4;
                        }
                    }
                    throw new GalaxyFDSClientException(e);
                }
            } else {
                throw new IllegalArgumentException("content length" + " may not be negative");
            }
        } else {
            throw new IllegalArgumentException("bucket name" + " may not be empty");
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.gson.Gson.fromJson(java.io.Reader, java.lang.Class):T
     arg types: [java.io.InputStreamReader, java.lang.Class]
     candidates:
      com.google.gson.Gson.fromJson(com.google.gson.JsonElement, java.lang.Class):T
      com.google.gson.Gson.fromJson(com.google.gson.JsonElement, java.lang.reflect.Type):T
      com.google.gson.Gson.fromJson(com.google.gson.stream.JsonReader, java.lang.reflect.Type):T
      com.google.gson.Gson.fromJson(java.io.Reader, java.lang.reflect.Type):T
      com.google.gson.Gson.fromJson(java.lang.String, java.lang.Class):T
      com.google.gson.Gson.fromJson(java.lang.String, java.lang.reflect.Type):T
      com.google.gson.Gson.fromJson(java.io.Reader, java.lang.Class):T */
    private dwc O000000o(String str, String str2) throws GalaxyFDSClientException {
        StringBuilder sb = new StringBuilder();
        sb.append(this.O00000Oo.O00000Oo());
        sb.append("/");
        sb.append(str);
        sb.append("/");
        sb.append(str2 == null ? "" : str2);
        sb.append("?uploads");
        String sb2 = sb.toString();
        InputStream inputStream = null;
        try {
            HttpResponse execute = this.O00000o0.execute(dwm.O000000o(sb2, this.O00000Oo.O0000Oo0, str2 == null ? HttpMethod.POST : HttpMethod.PUT, new HashMap()));
            inputStream = execute.getEntity().getContent();
            if (execute.getStatusLine().getStatusCode() == 200) {
                dwc dwc = (dwc) new Gson().fromJson((Reader) new InputStreamReader(inputStream), dwc.class);
                if (dwc == null || dwc.O00000o0 == null || dwc.O00000Oo == null || dwc.f14994O000000o == null) {
                    throw new GalaxyFDSClientException("Fail to parse the result of init multipart upload. bucket name:" + str + ", object name:" + str2);
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused) {
                    }
                }
                return dwc;
            }
            throw new GalaxyFDSClientException("Unable to upload object[" + str + "/" + str2 + "] to URI :" + sb2 + ". Fail to initiate multipart upload: " + execute.getStatusLine().toString());
        } catch (IOException e) {
            throw new GalaxyFDSClientException("Fail to initiate multipart upload. URI:".concat(String.valueOf(sb2)), e);
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused2) {
                }
            }
            throw th;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.gson.Gson.fromJson(java.io.Reader, java.lang.Class):T
     arg types: [java.io.InputStreamReader, java.lang.Class]
     candidates:
      com.google.gson.Gson.fromJson(com.google.gson.JsonElement, java.lang.Class):T
      com.google.gson.Gson.fromJson(com.google.gson.JsonElement, java.lang.reflect.Type):T
      com.google.gson.Gson.fromJson(com.google.gson.stream.JsonReader, java.lang.reflect.Type):T
      com.google.gson.Gson.fromJson(java.io.Reader, java.lang.reflect.Type):T
      com.google.gson.Gson.fromJson(java.lang.String, java.lang.Class):T
      com.google.gson.Gson.fromJson(java.lang.String, java.lang.reflect.Type):T
      com.google.gson.Gson.fromJson(java.io.Reader, java.lang.Class):T */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:1|2|3|4|(2:6|(3:15|16|17)(3:45|(2:11|12)|13))(3:44|18|19)) */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00de, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00ee, code lost:
        throw new com.xiaomi.infra.galaxy.fds.android.exception.GalaxyFDSClientException("Fail to put part. URI:".concat(java.lang.String.valueOf(r0)), r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00ef, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00f1, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00f2, code lost:
        r3 = r3 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00f8, code lost:
        if (r3 < r9.O00000Oo.O00000o0) goto L_0x00fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00fc, code lost:
        if (_m_j.dvz.f14991O000000o == false) goto L_0x00fe;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00fe, code lost:
        android.util.Log.i("GalaxyFDSClientImpl", "Retry the upload of object:" + r12 + " bucket:" + r11 + " upload id:" + r10 + " part number:" + r13 + " cause:" + _m_j.dwn.O000000o(r5));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        throw r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x013d, code lost:
        if (r4 != null) goto L_0x013f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0143, code lost:
        throw r10;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:1:0x0033 */
    /* JADX WARNING: Removed duplicated region for block: B:1:0x0033 A[LOOP:0: B:1:0x0033->B:43:0x0033, LOOP_START, PHI: r3 r4 10  PHI: (r3v1 int) = (r3v0 int), (r3v2 int) binds: [B:0:0x0000, B:43:0x0033] A[DONT_GENERATE, DONT_INLINE]10  PHI: (r4v1 java.io.InputStream) = (r4v0 java.io.InputStream), (r4v2 java.io.InputStream) binds: [B:0:0x0000, B:43:0x0033] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC, Splitter:B:1:0x0033] */
    public final dwg O000000o(String str, String str2, String str3, int i, byte[] bArr) throws GalaxyFDSClientException {
        String str4 = this.O00000Oo.O00000Oo() + "/" + str2 + "/" + str3 + "?uploadId=" + str + "&partNumber=" + i;
        int i2 = 0;
        InputStream inputStream = null;
        while (true) {
            HttpPut O000000o2 = dwm.O000000o(str4, this.O00000Oo.O0000Oo0, HttpMethod.PUT, null);
            O000000o2.setEntity(new ByteArrayEntity(bArr));
            HttpResponse execute = this.O00000o0.execute(O000000o2);
            inputStream = execute.getEntity().getContent();
            if (execute.getStatusLine().getStatusCode() == 200) {
                dwg dwg = (dwg) new Gson().fromJson((Reader) new InputStreamReader(inputStream), dwg.class);
                if (dwg == null || dwg.f14997O000000o == null) {
                    throw new GalaxyFDSClientException("Fail to parse the result of uploading part. bucket name:" + str2 + ", object name:" + str3 + ", upload ID:" + str);
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused) {
                    }
                }
                return dwg;
            }
            throw new GalaxyFDSClientException("Unable to upload object[" + str2 + "/" + str3 + "] to URI :" + str4 + ". Fail to upload part " + i + ": " + execute.getStatusLine().toString());
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.gson.Gson.fromJson(java.io.Reader, java.lang.Class):T
     arg types: [java.io.InputStreamReader, java.lang.Class]
     candidates:
      com.google.gson.Gson.fromJson(com.google.gson.JsonElement, java.lang.Class):T
      com.google.gson.Gson.fromJson(com.google.gson.JsonElement, java.lang.reflect.Type):T
      com.google.gson.Gson.fromJson(com.google.gson.stream.JsonReader, java.lang.reflect.Type):T
      com.google.gson.Gson.fromJson(java.io.Reader, java.lang.reflect.Type):T
      com.google.gson.Gson.fromJson(java.lang.String, java.lang.Class):T
      com.google.gson.Gson.fromJson(java.lang.String, java.lang.reflect.Type):T
      com.google.gson.Gson.fromJson(java.io.Reader, java.lang.Class):T */
    private dwf O000000o(String str, String str2, String str3, dwd dwd, dwh dwh, List<dwi> list) throws GalaxyFDSClientException {
        HashMap hashMap;
        StringBuilder sb = new StringBuilder();
        sb.append(this.O00000Oo.O00000Oo() + "/" + str2 + "/" + str3 + "?uploadId=" + str);
        if (list != null) {
            for (dwi dwi : list) {
                sb.append('&');
                sb.append(dwi.toString());
            }
        }
        String sb2 = sb.toString();
        InputStream inputStream = null;
        if (dwd != null) {
            try {
                hashMap = new HashMap();
                HashMap hashMap2 = new HashMap(dwd.O00000Oo);
                hashMap2.putAll(dwd.f14995O000000o);
                for (Map.Entry entry : hashMap2.entrySet()) {
                    hashMap.put(((String) entry.getKey()).toLowerCase(), entry.getValue());
                }
            } catch (IOException e) {
                throw new GalaxyFDSClientException("Fail to complete multipart upload. URI:".concat(String.valueOf(sb2)), e);
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused) {
                    }
                }
                throw th;
            }
        } else {
            hashMap = null;
        }
        HttpPut O000000o2 = dwm.O000000o(sb2, this.O00000Oo.O0000Oo0, HttpMethod.PUT, hashMap);
        O000000o2.setEntity(new StringEntity(new Gson().toJson(dwh)));
        HttpResponse execute = this.O00000o0.execute(O000000o2);
        inputStream = execute.getEntity().getContent();
        if (execute.getStatusLine().getStatusCode() == 200) {
            dwf dwf = (dwf) new Gson().fromJson((Reader) new InputStreamReader(inputStream), dwf.class);
            if (dwf == null || dwf.f14996O000000o == null || dwf.O00000Oo == null || dwf.O00000oO == 0) {
                throw new GalaxyFDSClientException("Fail to parse the result of completing multipart upload. bucket name:" + str2 + ", object name:" + str3 + ", upload ID:" + str);
            }
            dwf.O00000o0 = this.O00000Oo.O000000o(false);
            dwf.O00000o = this.O00000Oo.O000000o(true);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused2) {
                }
            }
            return dwf;
        }
        throw new GalaxyFDSClientException("Unable to upload object[" + str2 + "/" + str3 + "] to URI :" + sb2 + ". Fail to complete multipart upload: " + execute.getStatusLine().toString());
    }

    public final dwf O000000o(String str, String str2, File file) throws GalaxyFDSClientException {
        return O000000o(str, str2, file, null);
    }
}

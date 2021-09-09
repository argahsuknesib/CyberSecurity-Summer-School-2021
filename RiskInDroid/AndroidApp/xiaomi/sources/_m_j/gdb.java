package _m_j;

import android.os.AsyncTask;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.NoSuchKeyException;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.WritableMap;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public final class gdb extends AsyncTask<gcz, int[], gda> {

    /* renamed from: O000000o  reason: collision with root package name */
    public gcz f17550O000000o;
    public gda O00000Oo;
    public AtomicBoolean O00000o0 = new AtomicBoolean(false);

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object doInBackground(Object[] objArr) {
        this.f17550O000000o = ((gcz[]) objArr)[0];
        this.O00000Oo = new gda();
        new Thread(new Runnable() {
            /* class _m_j.gdb.AnonymousClass1 */

            /* JADX WARN: Failed to insert an additional move for type inference into block B:3:0x002a */
            /* JADX INFO: additional move instructions added (1) to help type inference */
            /* JADX WARN: Failed to insert an additional move for type inference into block B:26:0x00d1 */
            /* JADX WARN: Failed to insert an additional move for type inference into block B:77:0x0242 */
            /* JADX WARN: Failed to insert an additional move for type inference into block B:119:0x0307 */
            /* JADX WARN: Failed to insert an additional move for type inference into block B:123:0x0320 */
            /* JADX WARN: Failed to insert an additional move for type inference into block B:134:0x037d */
            /* JADX WARN: Failed to insert an additional move for type inference into block B:138:0x038b */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v9, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v10, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v52, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v53, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v59, resolved type: java.lang.String} */
            /* JADX WARN: Type inference failed for: r3v2, types: [_m_j.gdb] */
            /* JADX WARN: Type inference failed for: r3v3 */
            /* JADX WARN: Type inference failed for: r3v6 */
            /* JADX WARN: Type inference failed for: r3v11 */
            /* JADX WARN: Type inference failed for: r3v17, types: [java.util.Iterator] */
            /* JADX WARN: Type inference failed for: r3v20, types: [java.io.Reader, java.io.InputStreamReader] */
            /* JADX WARN: Type inference failed for: r3v22, types: [_m_j.gda] */
            /* JADX WARN: Type inference failed for: r3v23, types: [_m_j.gdb$1] */
            /* JADX WARN: Type inference failed for: r3v36 */
            /* JADX WARN: Type inference failed for: r3v65 */
            /* JADX WARN: Type inference failed for: r3v67 */
            /* JADX WARN: Type inference failed for: r3v68 */
            /* JADX WARNING: Can't wrap try/catch for region: R(5:42|43|(1:45)(1:46)|(1:48)|49) */
            /* JADX WARNING: Code restructure failed: missing block: B:164:0x03d6, code lost:
                r0 = e;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:165:0x03d7, code lost:
                r3 = r3;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
                r17 = r10.getString(r2);
                r25 = r10.getString(r0);
                r3 = android.webkit.MimeTypeMap.getFileExtensionFromUrl(r10.getString(r11));
             */
            /* JADX WARNING: Code restructure failed: missing block: B:44:0x0132, code lost:
                if (r3 != null) goto L_0x0134;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:45:0x0134, code lost:
                r27 = r0;
                r0 = android.webkit.MimeTypeMap.getSingleton().getMimeTypeFromExtension(r3.toLowerCase());
             */
            /* JADX WARNING: Code restructure failed: missing block: B:46:0x0143, code lost:
                r27 = r0;
                r0 = null;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:47:0x0146, code lost:
                if (r0 == null) goto L_0x0148;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:48:0x0148, code lost:
                r0 = "*/*";
             */
            /* JADX WARNING: Code restructure failed: missing block: B:49:0x014a, code lost:
                r3 = r0;
             */
            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Missing exception handler attribute for start block: B:42:0x0122 */
            /* JADX WARNING: Multi-variable type inference failed */
            /* JADX WARNING: Removed duplicated region for block: B:163:0x03d2 A[Catch:{ Exception -> 0x03d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:167:0x03da A[Catch:{ Exception -> 0x03d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:169:0x03df A[Catch:{ Exception -> 0x03d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:171:0x03e4 A[Catch:{ Exception -> 0x03d6 }] */
            public final void run() {
                AnonymousClass1 r3;
                HttpURLConnection httpURLConnection;
                DataOutputStream dataOutputStream;
                BufferedInputStream bufferedInputStream;
                BufferedReader bufferedReader;
                String str;
                gdb gdb;
                gcz gcz;
                long j;
                String str2;
                String str3;
                String[] strArr;
                gdb gdb2;
                HttpURLConnection httpURLConnection2;
                DataOutputStream dataOutputStream2;
                String str4;
                String string;
                String string2;
                String str5;
                String str6;
                Object[] objArr;
                String str7;
                AnonymousClass1 r1 = this;
                String str8 = "filename";
                String str9 = "name";
                try {
                    String str10 = gdb.this;
                    gcz gcz2 = gdb.this.f17550O000000o;
                    String str11 = "\r\n" + "--" + "*****" + "--" + "\r\n";
                    try {
                        Object[] array = gcz2.O00000Oo.toArray();
                        boolean z = gcz2.O00000o0;
                        URL url = gcz2.f17547O000000o;
                        dxx.O000000o();
                        HttpURLConnection httpURLConnection3 = (HttpURLConnection) dxx.O000000o(url);
                        try {
                            httpURLConnection3.setDoOutput(true);
                            ReadableMapKeySetIterator keySetIterator = gcz2.O00000o.keySetIterator();
                            httpURLConnection3.setRequestMethod(gcz2.O00000oo);
                            if (!z) {
                                httpURLConnection3.setRequestProperty("Content-Type", "multipart/form-data;boundary=".concat("*****"));
                            }
                            while (keySetIterator.hasNextKey()) {
                                String nextKey = keySetIterator.nextKey();
                                httpURLConnection3.setRequestProperty(nextKey, gcz2.O00000o.getString(nextKey));
                            }
                            ReadableMapKeySetIterator keySetIterator2 = gcz2.O00000oO.keySetIterator();
                            str = "";
                            while (keySetIterator2.hasNextKey()) {
                                httpURLConnection = httpURLConnection3;
                                try {
                                    String nextKey2 = keySetIterator2.nextKey();
                                    ReadableMapKeySetIterator readableMapKeySetIterator = keySetIterator2;
                                    Object obj = str10;
                                    str = str + "--" + "*****" + "\r\n" + "Content-Disposition: form-data; name=\"" + nextKey2 + jdn.f1779O000000o + "\r\n" + "\r\n" + gcz2.O00000oO.getString(nextKey2) + "\r\n";
                                    r1 = this;
                                    httpURLConnection3 = httpURLConnection;
                                    keySetIterator2 = readableMapKeySetIterator;
                                    str10 = obj;
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
                            gdb = str10;
                            httpURLConnection = httpURLConnection3;
                        } catch (Throwable th2) {
                            th = th2;
                            AnonymousClass1 r32 = r1;
                            httpURLConnection = httpURLConnection3;
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
                            str10 = "" + str;
                            String[] strArr2 = new String[array.length];
                            Iterator<ReadableMap> it = gcz2.O00000Oo.iterator();
                            gcz = gcz2;
                            String str12 = jdn.f1779O000000o;
                            int i = 0;
                            j = 0;
                            while (true) {
                                str2 = str;
                                str3 = "filepath";
                                if (!it.hasNext()) {
                                    break;
                                }
                                Iterator<ReadableMap> it2 = it;
                                ReadableMap next = it.next();
                                try {
                                    string = next.getString(str9);
                                    string2 = next.getString(str8);
                                    str4 = str10;
                                    str6 = next.getString("filetype");
                                    str5 = str8;
                                } catch (NoSuchKeyException unused) {
                                    str4 = str10;
                                }
                                String str13 = string;
                                String str14 = str9;
                                String str15 = str6;
                                String str16 = string2;
                                String[] strArr3 = strArr2;
                                long length = new File(next.getString(str3)).length();
                                j += length;
                                if (!z) {
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("--");
                                    sb.append("*****");
                                    sb.append("\r\n");
                                    sb.append("Content-Disposition: form-data; name=\"");
                                    sb.append(str13);
                                    sb.append("\"; filename=\"");
                                    sb.append(str16);
                                    str7 = str12;
                                    sb.append(str7);
                                    sb.append("\r\n");
                                    sb.append("Content-Type: ");
                                    sb.append(str15);
                                    sb.append("\r\n");
                                    String sb2 = sb.toString();
                                    if (array.length - 1 == i) {
                                        objArr = array;
                                        j += (long) str11.length();
                                    } else {
                                        objArr = array;
                                    }
                                    String str17 = "Content-length: " + length + "\r\n";
                                    strArr3[i] = sb2 + str17 + "\r\n";
                                    str10 = str4 + sb2 + str17 + "\r\n";
                                } else {
                                    objArr = array;
                                    str7 = str12;
                                    str10 = str4;
                                }
                                i++;
                                str12 = str7;
                                str9 = str14;
                                array = objArr;
                                str = str2;
                                it = it2;
                                strArr2 = strArr3;
                                str8 = str5;
                            }
                            String str18 = str10;
                            strArr = strArr2;
                            Object[] objArr2 = array;
                            gdb2 = gdb;
                            if (gdb2.f17550O000000o.O0000Oo0 != null) {
                                gdb2.f17550O000000o.O0000Oo0.O000000o();
                            }
                            if (!z) {
                                try {
                                    String str19 = "Content-length";
                                    StringBuilder sb3 = new StringBuilder();
                                    int length2 = (int) (((long) (str18.length() + (objArr2.length * 2))) + j);
                                    sb3.append(length2);
                                    String sb4 = sb3.toString();
                                    httpURLConnection2 = httpURLConnection;
                                    try {
                                        httpURLConnection2.setRequestProperty(str19, sb4);
                                        httpURLConnection2.setFixedLengthStreamingMode(length2);
                                        str10 = str19;
                                    } catch (Throwable th3) {
                                        th = th3;
                                        bufferedReader = null;
                                        bufferedInputStream = null;
                                        dataOutputStream = null;
                                        httpURLConnection = httpURLConnection2;
                                    }
                                } catch (Throwable th4) {
                                    th = th4;
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
                            } else {
                                httpURLConnection2 = httpURLConnection;
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
                            httpURLConnection2.connect();
                            dataOutputStream2 = new DataOutputStream(httpURLConnection2.getOutputStream());
                            if (!z) {
                                try {
                                    dataOutputStream2.writeBytes(str2);
                                } catch (Throwable th6) {
                                    th = th6;
                                    dataOutputStream = dataOutputStream2;
                                    httpURLConnection = httpURLConnection2;
                                }
                            }
                            try {
                                Runtime runtime = Runtime.getRuntime();
                                int i2 = 0;
                                int i3 = 0;
                                ? r33 = gcz.O00000Oo.iterator();
                                while (str10.hasNext()) {
                                    try {
                                        ReadableMap readableMap = (ReadableMap) str10.next();
                                        if (!z) {
                                            dataOutputStream2.writeBytes(strArr[i2]);
                                        }
                                        File file = new File(readableMap.getString(str3));
                                        String str20 = str3;
                                        int length3 = (int) file.length();
                                        Object obj2 = str10;
                                        BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
                                        String str21 = str20;
                                        int ceil = (int) Math.ceil((double) (((float) length3) / 100.0f));
                                        httpURLConnection = httpURLConnection2;
                                        byte[] bArr = new byte[(((float) ceil) > ((float) runtime.freeMemory()) / 10.0f ? (int) Math.ceil((double) (((float) runtime.freeMemory()) / 10.0f)) : ceil)];
                                        while (true) {
                                            int read = bufferedInputStream2.read(bArr);
                                            if (read == -1) {
                                                break;
                                            }
                                            dataOutputStream2.write(bArr, 0, read);
                                            if (gdb2.f17550O000000o.O0000OOo != null) {
                                                i3 += read;
                                                gdb2.f17550O000000o.O0000OOo.O000000o((int) j, i3);
                                            }
                                        }
                                        if (!z) {
                                            dataOutputStream2.writeBytes("\r\n");
                                        }
                                        i2++;
                                        bufferedInputStream2.close();
                                        str3 = str21;
                                        r33 = obj2;
                                        httpURLConnection2 = httpURLConnection;
                                    } catch (Throwable th7) {
                                        th = th7;
                                        bufferedReader = null;
                                        bufferedInputStream = null;
                                        dataOutputStream = dataOutputStream2;
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
                                httpURLConnection = httpURLConnection2;
                                if (!z) {
                                    dataOutputStream2.writeBytes(str11);
                                }
                            } catch (Throwable th8) {
                                th = th8;
                                httpURLConnection = httpURLConnection2;
                                dataOutputStream = dataOutputStream2;
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
                            try {
                                dataOutputStream2.flush();
                                dataOutputStream2.close();
                                bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                                try {
                                    str10 = new InputStreamReader(bufferedInputStream);
                                    bufferedReader = new BufferedReader(str10);
                                } catch (Throwable th9) {
                                    th = th9;
                                    dataOutputStream = dataOutputStream2;
                                    bufferedReader = null;
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
                            } catch (Throwable th10) {
                                th = th10;
                                dataOutputStream = dataOutputStream2;
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
                        } catch (Throwable th11) {
                            th = th11;
                            httpURLConnection = httpURLConnection2;
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
                            WritableMap createMap = Arguments.createMap();
                            for (Map.Entry next2 : httpURLConnection.getHeaderFields().entrySet()) {
                                createMap.putString((String) next2.getKey(), (String) ((List) next2.getValue()).get(0));
                            }
                            StringBuilder sb5 = new StringBuilder();
                            while (true) {
                                String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                sb5.append(readLine);
                                sb5.append("\n");
                            }
                            String sb6 = sb5.toString();
                            int responseCode = httpURLConnection.getResponseCode();
                            gdb2.O00000Oo.O00000Oo = createMap;
                            str10 = gdb2.O00000Oo;
                            str10.O00000o = sb6;
                            gdb2.O00000Oo.f17549O000000o = responseCode;
                            if (httpURLConnection != null) {
                                try {
                                    httpURLConnection.disconnect();
                                } catch (Exception e) {
                                    e = e;
                                    r3 = this;
                                    gdb.this.O00000Oo.O00000o0 = e;
                                    gdb.this.f17550O000000o.O0000O0o.O000000o(gdb.this.O00000Oo);
                                }
                            }
                            dataOutputStream2.close();
                            bufferedInputStream.close();
                            bufferedReader.close();
                            str10 = this;
                            gdb.this.f17550O000000o.O0000O0o.O000000o(gdb.this.O00000Oo);
                        } catch (Throwable th12) {
                            th = th12;
                            dataOutputStream = dataOutputStream2;
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
                    } catch (Throwable th13) {
                        th = th13;
                        AnonymousClass1 r34 = r1;
                        bufferedReader = null;
                        bufferedInputStream = null;
                        dataOutputStream = null;
                        httpURLConnection = null;
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
                } catch (Exception e2) {
                    e = e2;
                    r3 = r1;
                    gdb.this.O00000Oo.O00000o0 = e;
                    gdb.this.f17550O000000o.O0000O0o.O000000o(gdb.this.O00000Oo);
                }
            }
        }).start();
        return this.O00000Oo;
    }
}

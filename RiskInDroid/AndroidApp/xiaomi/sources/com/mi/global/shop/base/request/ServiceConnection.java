package com.mi.global.shop.base.request;

import _m_j.bym;
import _m_j.byt;
import _m_j.ccr;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.exoplayer2.C;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.TreeMap;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.json.JSONException;
import org.json.JSONObject;

public class ServiceConnection {
    private static final String TAG = "ServiceConnection";
    private HostnameVerifier DO_NOT_VERIFY = new HostnameVerifier() {
        /* class com.mi.global.shop.base.request.ServiceConnection.AnonymousClass1 */

        public boolean verify(String str, SSLSession sSLSession) {
            return true;
        }
    };
    private String mContentType;
    protected Parameter mParameter;
    private byte[] mPostData;
    protected JSONObject mResponse;
    protected String mString;
    protected URL mUrl;
    protected boolean mUseGet;
    private TrustManager[] xtmArray = {new MytmArray()};

    public enum NetworkError {
        OK,
        URL_ERROR,
        NETWORK_ERROR,
        CLIENT_ERROR,
        SERVER_ERROR,
        RESULT_ERROR,
        UNKNOWN_ERROR
    }

    /* access modifiers changed from: protected */
    public HttpURLConnection onConnectionCreated(HttpURLConnection httpURLConnection) throws ConnectionException {
        return httpURLConnection;
    }

    /* access modifiers changed from: protected */
    public Parameter onQueryCreated(Parameter parameter) throws ConnectionException {
        return parameter;
    }

    /* access modifiers changed from: protected */
    public String onURLCreated(String str, Parameter parameter) throws ConnectionException {
        return str;
    }

    public ServiceConnection(String str) {
        URL url;
        try {
            url = new URL(str);
        } catch (MalformedURLException e) {
            if (bym.O00000Oo) {
                Log.e(TAG, "URL error: ".concat(String.valueOf(e)));
            }
            url = null;
        }
        init(url);
    }

    private void init(URL url) {
        this.mUseGet = false;
        if (checkURL(url)) {
            this.mUrl = url;
        }
    }

    public JSONObject getResponse() {
        return this.mResponse;
    }

    public String getStringResponse() {
        return this.mString;
    }

    public Parameter getParameter() {
        return this.mParameter;
    }

    public void setUseGet(boolean z) {
        this.mUseGet = z;
    }

    public void setPostData(byte[] bArr) {
        this.mPostData = bArr;
    }

    public NetworkError requestJSON() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        NetworkError request = request(new MemoryResetableOutputStream(byteArrayOutputStream));
        try {
            if (request == NetworkError.OK) {
                String str = TAG;
                ccr.O00000Oo(str, "baos.toString():" + byteArrayOutputStream.toString());
                this.mResponse = new JSONObject(byteArrayOutputStream.toString());
            } else if (bym.O00000Oo) {
                ccr.O00000Oo(TAG, "ServiceConnection failed : ".concat(String.valueOf(request)));
            }
            try {
                byteArrayOutputStream.close();
            } catch (IOException unused) {
            }
            return request;
        } catch (JSONException e) {
            if (bym.O00000Oo) {
                ccr.O00000Oo(TAG, "JSON error: ".concat(String.valueOf(e)));
            }
            NetworkError networkError = NetworkError.RESULT_ERROR;
            try {
                byteArrayOutputStream.close();
            } catch (IOException unused2) {
            }
            return networkError;
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (IOException unused3) {
            }
            throw th;
        }
    }

    public NetworkError requestString() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        NetworkError request = request(new MemoryResetableOutputStream(byteArrayOutputStream));
        if (request == NetworkError.OK) {
            this.mString = byteArrayOutputStream.toString();
            if (bym.O00000Oo) {
                Log.d(TAG, this.mString);
            }
        } else if (bym.O00000Oo) {
            Log.e(TAG, "ServiceConnection failed : ".concat(String.valueOf(request)));
        }
        try {
            byteArrayOutputStream.close();
        } catch (IOException unused) {
        }
        return request;
    }

    public NetworkError requestFile(File file) throws FileNotFoundException {
        if (file != null) {
            ccr.O00000Oo(TAG, String.format("outFile:%s", file.getAbsolutePath()));
            try {
                FileResetableOutputStream fileResetableOutputStream = new FileResetableOutputStream(file);
                NetworkError request = request(fileResetableOutputStream);
                try {
                    fileResetableOutputStream.close();
                    if (request != NetworkError.OK) {
                        if (bym.O00000Oo) {
                            Log.e(TAG, "ServiceConnection failed : ".concat(String.valueOf(request)));
                        }
                        file.delete();
                    }
                } catch (IOException unused) {
                }
                return request;
            } catch (FileNotFoundException e) {
                if (bym.O00000Oo) {
                    Log.e(TAG, "File not found: ".concat(String.valueOf(e)));
                }
                throw e;
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    /* access modifiers changed from: protected */
    public NetworkError request(ResetableOutputStream resetableOutputStream) {
        ccr.O00000Oo(TAG, "ServiceConnection.request mUrl:" + this.mUrl);
        if (this.mUrl == null) {
            return NetworkError.URL_ERROR;
        }
        if (!byt.O000000o.O000000o(bym.f13411O000000o)) {
            return NetworkError.NETWORK_ERROR;
        }
        if (this.mParameter == null) {
            this.mParameter = new Parameter(this);
        }
        try {
            Parameter onQueryCreated = onQueryCreated(this.mParameter);
            String url = this.mUrl.toString();
            if (this.mUseGet && !onQueryCreated.isEmpty()) {
                String query = this.mUrl.getQuery();
                String url2 = this.mUrl.toString();
                if (TextUtils.isEmpty(query)) {
                    url = url2 + "?" + onQueryCreated.toEncodedString();
                } else {
                    url = url2 + "&" + onQueryCreated.toEncodedString();
                }
            }
            try {
                String onURLCreated = onURLCreated(url, onQueryCreated);
                if (bym.O00000Oo) {
                    Log.d(TAG, "connection url: ".concat(String.valueOf(onURLCreated)));
                }
                if (!this.mUseGet) {
                    byte[] bArr = this.mPostData;
                    if (bArr != null && bArr.length > 0) {
                        this.mContentType = "application/octet-stream";
                    } else if (!onQueryCreated.isEmpty()) {
                        this.mPostData = onQueryCreated.toEncodedString().getBytes();
                        if (bym.O00000Oo) {
                            Log.d(TAG, "[post]".concat(String.valueOf(onQueryCreated)));
                        }
                    }
                    byte[] bArr2 = this.mPostData;
                    if (bArr2 == null || bArr2.length == 0) {
                        return NetworkError.CLIENT_ERROR;
                    }
                }
                long currentTimeMillis = System.currentTimeMillis();
                NetworkError innerRequest = innerRequest(onURLCreated, this.mPostData, this.mUseGet, resetableOutputStream);
                if (bym.O00000Oo) {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (bym.O00000Oo) {
                        Log.d(TAG, "Time(ms) spent in request: " + (currentTimeMillis2 - currentTimeMillis) + ", " + onURLCreated);
                    }
                }
                return innerRequest;
            } catch (ConnectionException e) {
                return e.mError;
            }
        } catch (ConnectionException e2) {
            return e2.mError;
        }
    }

    class MytmArray implements X509TrustManager {
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }

        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }

        MytmArray() {
        }

        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    private void trustAllHosts() {
        try {
            SSLContext instance = SSLContext.getInstance("TLS");
            instance.init(null, this.xtmArray, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(instance.getSocketFactory());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0127, code lost:
        if (r11 != null) goto L_0x00f6;
     */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0177  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0107 A[Catch:{ all -> 0x012a }] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x012d A[SYNTHETIC, Splitter:B:77:0x012d] */
    private NetworkError innerRequest(String str, byte[] bArr, boolean z, ResetableOutputStream resetableOutputStream) {
        URL url;
        HttpURLConnection httpURLConnection;
        BufferedInputStream bufferedInputStream;
        Exception e;
        if (bym.O00000Oo) {
            Log.d(TAG, "hosted connection url: ".concat(String.valueOf(str)));
        }
        HttpURLConnection httpURLConnection2 = null;
        try {
            url = new URL(str);
        } catch (MalformedURLException e2) {
            if (bym.O00000Oo) {
                Log.e(TAG, " URL error :".concat(String.valueOf(e2)));
            }
            url = null;
        }
        try {
            if (url.getProtocol().equalsIgnoreCase("https")) {
                trustAllHosts();
                httpURLConnection = (HttpsURLConnection) url.openConnection();
                try {
                    ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(this.DO_NOT_VERIFY);
                } catch (Exception e3) {
                    e = e3;
                    httpURLConnection2 = httpURLConnection;
                } catch (Throwable th) {
                    th = th;
                    if (httpURLConnection != null) {
                    }
                    throw th;
                }
            } else {
                httpURLConnection = (HttpURLConnection) url.openConnection();
            }
            httpURLConnection.setConnectTimeout(C.MSG_CUSTOM_BASE);
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) bym.f13411O000000o.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.getType() == 1) {
                httpURLConnection.setReadTimeout(C.MSG_CUSTOM_BASE);
            } else {
                httpURLConnection.setReadTimeout(30000);
            }
            if (z) {
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setDoOutput(false);
            } else {
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setUseCaches(false);
                if (bArr != null && bArr.length > 0) {
                    httpURLConnection.setRequestProperty("Content-Length", Integer.toString(bArr.length));
                }
                if (!TextUtils.isEmpty(this.mContentType)) {
                    httpURLConnection.setRequestProperty("Content-Type", this.mContentType);
                }
            }
            try {
                httpURLConnection = onConnectionCreated(httpURLConnection);
                httpURLConnection.connect();
                if (!z && bArr != null && bArr.length > 0) {
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    outputStream.write(bArr);
                    outputStream.close();
                }
                NetworkError handleResponseCode = handleResponseCode(httpURLConnection.getResponseCode());
                if (handleResponseCode == NetworkError.OK && resetableOutputStream != null) {
                    try {
                        bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream(), 8192);
                        try {
                            byte[] bArr2 = new byte[1024];
                            while (true) {
                                int read = bufferedInputStream.read(bArr2, 0, 1024);
                                if (read <= 0) {
                                    break;
                                }
                                resetableOutputStream.write(bArr2, 0, read);
                            }
                            resetableOutputStream.flush();
                        } catch (Exception e4) {
                            e = e4;
                            try {
                                if (bym.O00000Oo) {
                                }
                                resetableOutputStream.reset();
                            } catch (Throwable th2) {
                                th = th2;
                                if (bufferedInputStream != null) {
                                }
                                throw th;
                            }
                        }
                    } catch (Exception e5) {
                        e = e5;
                        bufferedInputStream = null;
                        if (bym.O00000Oo) {
                            Log.e(TAG, "ServiceConnection Exception for " + url.getHost() + " : read file stream error " + e);
                        }
                        resetableOutputStream.reset();
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedInputStream = null;
                        if (bufferedInputStream != null) {
                            bufferedInputStream.close();
                        }
                        throw th;
                    }
                    bufferedInputStream.close();
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return handleResponseCode;
            } catch (ConnectionException e6) {
                NetworkError networkError = e6.mError;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return networkError;
            }
        } catch (Exception e7) {
            e = e7;
            try {
                if (bym.O00000Oo) {
                    Log.e(TAG, "ServiceConnection Exception for " + url.getHost() + " :" + e);
                }
                e.printStackTrace();
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                return NetworkError.NETWORK_ERROR;
            } catch (Throwable th4) {
                th = th4;
                httpURLConnection = httpURLConnection2;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean checkURL(URL url) {
        if (url == null) {
            return false;
        }
        if (TextUtils.equals(url.getProtocol(), "http") || TextUtils.equals(url.getProtocol(), "https")) {
            return true;
        }
        return false;
    }

    private NetworkError handleResponseCode(int i) {
        if (i == 200) {
            return NetworkError.OK;
        }
        if (bym.O00000Oo) {
            Log.e(TAG, "Network Error : ".concat(String.valueOf(i)));
        }
        return NetworkError.SERVER_ERROR;
    }

    public static StringBuilder appendParameter(StringBuilder sb, String str, String str2, String str3) {
        if (sb.length() > 0) {
            sb.append("&");
        }
        sb.append(str);
        sb.append("=");
        try {
            sb.append(URLEncoder.encode(str2, str3));
        } catch (UnsupportedEncodingException unused) {
        }
        return sb;
    }

    public static StringBuilder appendParameter(StringBuilder sb, String str, String str2) {
        if (sb.length() > 0) {
            sb.append("&");
        }
        sb.append(str);
        sb.append("=");
        sb.append(str2);
        return sb;
    }

    public class Parameter {
        private boolean disallowEmptyValue;
        private TreeMap<String, String> params;

        public Parameter(ServiceConnection serviceConnection) {
            this(true);
        }

        public Parameter(boolean z) {
            this.disallowEmptyValue = false;
            this.params = new TreeMap<>();
            this.disallowEmptyValue = false;
            if (z) {
                ServiceConnection.this.mParameter = this;
            }
        }

        public void setDisallowEmptyValue(boolean z) {
            this.disallowEmptyValue = z;
        }

        public Parameter add(String str, String str2) {
            if (TextUtils.isEmpty(str2)) {
                if (this.disallowEmptyValue) {
                    return this;
                }
                str2 = "";
            }
            this.params.put(str, str2);
            return this;
        }

        public Parameter add(String str, Object obj) {
            if (obj == null) {
                if (this.disallowEmptyValue) {
                    return this;
                }
                obj = "";
            }
            this.params.put(str, String.valueOf(obj));
            return this;
        }

        public Parameter add(String str, boolean z) {
            this.params.put(str, String.valueOf(z));
            return this;
        }

        public Parameter add(String str, int i) {
            this.params.put(str, String.valueOf(i));
            return this;
        }

        public String get(String str) {
            return this.params.get(str);
        }

        public boolean isEmpty() {
            return this.params.isEmpty();
        }

        public String toString() {
            if (this.params.isEmpty()) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (String next : this.params.keySet()) {
                sb = ServiceConnection.appendParameter(sb, next, this.params.get(next));
            }
            return sb.toString();
        }

        public String toEncodedString() {
            return toEncodedString("UTF-8");
        }

        public String toEncodedString(String str) {
            if (this.params.isEmpty()) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (String next : this.params.keySet()) {
                sb = ServiceConnection.appendParameter(sb, next, this.params.get(next), str);
            }
            return sb.toString();
        }

        public TreeMap<String, String> getParams() {
            return this.params;
        }
    }

    public class ConnectionException extends Exception {
        private static final long serialVersionUID = 1;
        protected NetworkError mError;

        public ConnectionException(NetworkError networkError) {
            this.mError = networkError;
        }
    }

    public abstract class ResetableOutputStream extends OutputStream {
        protected OutputStream mOutputStream;

        public abstract void reset();

        public ResetableOutputStream(OutputStream outputStream) {
            if (outputStream != null) {
                this.mOutputStream = outputStream;
                return;
            }
            throw new IllegalArgumentException("outputstream is null");
        }

        public void close() throws IOException {
            this.mOutputStream.close();
        }

        public void flush() throws IOException {
            this.mOutputStream.flush();
        }

        public void write(byte[] bArr) throws IOException {
            this.mOutputStream.write(bArr);
        }

        public void write(byte[] bArr, int i, int i2) throws IOException {
            this.mOutputStream.write(bArr, i, i2);
        }

        public void write(int i) throws IOException {
            this.mOutputStream.write(i);
        }
    }

    public class MemoryResetableOutputStream extends ResetableOutputStream {
        public MemoryResetableOutputStream(ByteArrayOutputStream byteArrayOutputStream) {
            super(byteArrayOutputStream);
        }

        public void reset() {
            ((ByteArrayOutputStream) this.mOutputStream).reset();
        }
    }

    public class FileResetableOutputStream extends ResetableOutputStream {
        private File mFile;

        public FileResetableOutputStream(File file) throws FileNotFoundException {
            super(new FileOutputStream(file));
            this.mFile = file;
        }

        public void reset() {
            try {
                this.mOutputStream.close();
            } catch (IOException unused) {
            }
            this.mFile.delete();
            try {
                this.mOutputStream = new FileOutputStream(this.mFile);
            } catch (FileNotFoundException unused2) {
            }
        }
    }
}

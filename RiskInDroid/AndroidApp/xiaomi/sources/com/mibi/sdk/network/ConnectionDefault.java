package com.mibi.sdk.network;

import android.text.TextUtils;
import com.google.android.exoplayer2.C;
import com.mibi.sdk.common.SortedParameter;
import com.mibi.sdk.common.Utils;
import com.mibi.sdk.common.exception.ConnectionException;
import com.mibi.sdk.common.exception.PaymentException;
import com.mibi.sdk.common.exception.ResultException;
import com.mibi.sdk.common.exception.ServerException;
import com.mibi.sdk.common.exception.ServiceTokenExpiredException;
import com.mibi.sdk.common.utils.MibiLog;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.TreeMap;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;

public class ConnectionDefault implements Connection {
    protected boolean mNeedGzipRequest;
    protected Parameter mParameter;
    protected JSONObject mResponse;
    protected int mResponseCode;
    private volatile Status mStatus;
    protected String mString;
    protected URL mUrl;
    protected boolean mUseGet;

    public enum NetworkError {
        OK,
        NETWORK_ERROR,
        ACCOUNT_CHANGED_ERROR,
        AUTH_ERROR,
        SERVER_ERROR,
        RESULT_ERROR,
        UNKNOWN_ERROR
    }

    public enum Status {
        PENDING,
        RUNNING,
        FINISHED
    }

    /* access modifiers changed from: protected */
    public boolean checkURL(URL url) {
        return url != null;
    }

    /* access modifiers changed from: protected */
    public HttpURLConnection onConnectionCreated(HttpURLConnection httpURLConnection) {
        return httpURLConnection;
    }

    /* access modifiers changed from: protected */
    public Parameter onQueryCreated(Parameter parameter) {
        return parameter;
    }

    /* access modifiers changed from: protected */
    public URL onURLCreated(URL url, Parameter parameter) {
        return url;
    }

    ConnectionDefault(String str) {
        this.mStatus = Status.PENDING;
        try {
            init(new URL(str));
        } catch (MalformedURLException unused) {
            throw new IllegalArgumentException("URL error: " + ((Object) null));
        }
    }

    ConnectionDefault(String str, String str2) {
        this(connect(str, str2));
    }

    public static String connect(String str, String str2) {
        return Utils.join(str, str2);
    }

    private void init(URL url) {
        this.mUseGet = false;
        this.mNeedGzipRequest = false;
        if (checkURL(url)) {
            this.mUrl = url;
            return;
        }
        throw new IllegalArgumentException("URL error: ".concat(String.valueOf(url)));
    }

    public URL getUrl() {
        return this.mUrl;
    }

    public JSONObject getResponse() {
        return this.mResponse;
    }

    public String getStringResponse() {
        return this.mString;
    }

    public int getResponseCode() {
        return this.mResponseCode;
    }

    public Parameter getParameter() {
        if (this.mParameter == null) {
            this.mParameter = new Parameter();
        }
        return this.mParameter;
    }

    public void setUseGet(boolean z) {
        this.mUseGet = z;
    }

    public void setNeedGzipRequest(boolean z) {
        this.mNeedGzipRequest = z;
    }

    public JSONObject requestJSON() throws PaymentException {
        requestString();
        try {
            this.mResponse = new JSONObject(this.mString);
            return this.mResponse;
        } catch (Exception e) {
            throw new ResultException(e);
        }
    }

    public String requestString() throws PaymentException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        request(byteArrayOutputStream);
        this.mString = byteArrayOutputStream.toString();
        try {
            byteArrayOutputStream.close();
        } catch (IOException unused) {
        }
        return this.mString;
    }

    /* renamed from: com.mibi.sdk.network.ConnectionDefault$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$mibi$sdk$network$ConnectionDefault$Status = new int[Status.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            $SwitchMap$com$mibi$sdk$network$ConnectionDefault$Status[Status.RUNNING.ordinal()] = 1;
            $SwitchMap$com$mibi$sdk$network$ConnectionDefault$Status[Status.FINISHED.ordinal()] = 2;
        }
    }

    /* access modifiers changed from: protected */
    public void request(OutputStream outputStream) throws PaymentException {
        if (this.mStatus != Status.PENDING) {
            int i = AnonymousClass1.$SwitchMap$com$mibi$sdk$network$ConnectionDefault$Status[this.mStatus.ordinal()];
            if (i == 1) {
                throw new IllegalStateException("Cannot start: the connection is already running.");
            } else if (i == 2) {
                throw new IllegalStateException("Cannot start: the connection has already finished.");
            }
        }
        this.mStatus = Status.RUNNING;
        Parameter onQueryCreated = onQueryCreated(getParameter());
        String url = this.mUrl.toString();
        if (this.mUseGet && !onQueryCreated.isEmpty()) {
            if (TextUtils.isEmpty(this.mUrl.getQuery())) {
                url = url + "?" + onQueryCreated.toString();
            } else {
                url = url + "&" + onQueryCreated.toString();
            }
        }
        try {
            innerRequest(onURLCreated(new URL(url), onQueryCreated), !this.mUseGet ? onQueryCreated.toString() : "", this.mUseGet, this.mNeedGzipRequest, outputStream);
            this.mStatus = Status.FINISHED;
        } catch (MalformedURLException e) {
            throw new IllegalStateException(e);
        }
    }

    /* JADX WARN: Failed to insert an additional move for type inference into block B:77:0x0103 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00a9 A[SYNTHETIC, Splitter:B:49:0x00a9] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0114  */
    private void innerRequest(URL url, String str, boolean z, boolean z2, OutputStream outputStream) throws PaymentException {
        HttpURLConnection httpURLConnection;
        BufferedInputStream bufferedInputStream = 0;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) url.openConnection();
            try {
                httpURLConnection2.setConnectTimeout(C.MSG_CUSTOM_BASE);
                httpURLConnection2.setReadTimeout(C.MSG_CUSTOM_BASE);
                if (z) {
                    httpURLConnection2.setRequestMethod("GET");
                    httpURLConnection2.setDoOutput(false);
                } else {
                    httpURLConnection2.setRequestMethod("POST");
                    httpURLConnection2.setDoOutput(true);
                }
                if (z2) {
                    httpURLConnection2.setRequestProperty("Content-Type", "application/gzip");
                    httpURLConnection2.setRequestProperty("Content-Encoding", "gzip");
                }
                httpURLConnection = onConnectionCreated(httpURLConnection2);
                httpURLConnection.connect();
                if (!z && !TextUtils.isEmpty(str)) {
                    OutputStream outputStream2 = httpURLConnection.getOutputStream();
                    if (z2) {
                        outputStream2 = new GZIPOutputStream(outputStream2);
                    }
                    outputStream2.write(str.getBytes());
                    outputStream2.flush();
                    outputStream2.close();
                }
                this.mResponseCode = httpURLConnection.getResponseCode();
                if (this.mResponseCode == 200) {
                    if (outputStream != null) {
                        try {
                            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(httpURLConnection.getInputStream(), 8192);
                            try {
                                byte[] bArr = new byte[1024];
                                while (true) {
                                    int read = bufferedInputStream2.read(bArr, 0, 1024);
                                    if (read <= 0) {
                                        break;
                                    }
                                    outputStream.write(bArr, 0, read);
                                }
                                outputStream.flush();
                                bufferedInputStream2.close();
                            } catch (IOException e) {
                                e = e;
                                throw new ConnectionException(url, "read file stream error ", e);
                            } catch (Exception e2) {
                                e = e2;
                                bufferedInputStream = bufferedInputStream2;
                                throw new ConnectionException(url, "error read/write data", e);
                            } catch (Throwable th) {
                                th = th;
                                bufferedInputStream = bufferedInputStream2;
                                if (bufferedInputStream != null) {
                                }
                                throw th;
                            }
                        } catch (IOException e3) {
                            e = e3;
                            throw new ConnectionException(url, "read file stream error ", e);
                        } catch (Exception e4) {
                            e = e4;
                            throw new ConnectionException(url, "error read/write data", e);
                        } catch (Throwable th2) {
                            th = th2;
                            if (bufferedInputStream != null) {
                                bufferedInputStream.close();
                            }
                            throw th;
                        }
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                } else if (this.mResponseCode == 401) {
                    MibiLog.d("ConnectionDefault", "401, unauthorized");
                    throw new ServiceTokenExpiredException();
                } else if (this.mResponseCode == 404) {
                    MibiLog.d("ConnectionDefault", "404, maybe the account's region is not cn");
                    throw new ServerException(this.mResponseCode, url);
                } else {
                    MibiLog.d("ConnectionDefault", "unknown error, responseCode : " + this.mResponseCode);
                    throw new ServerException(this.mResponseCode, url);
                }
            } catch (PaymentException e5) {
                e = e5;
            } catch (IOException e6) {
                e = e6;
                throw new ConnectionException(url, e);
            } catch (Exception e7) {
                e = e7;
                bufferedInputStream = httpURLConnection;
                throw new ConnectionException(url, e);
            } catch (Throwable th3) {
                th = th3;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        } catch (PaymentException e8) {
            e = e8;
            throw e;
        } catch (IOException e9) {
            e = e9;
            throw new ConnectionException(url, e);
        } catch (Exception e10) {
            e = e10;
            throw new ConnectionException(url, e);
        } catch (Throwable th4) {
            th = th4;
            httpURLConnection = bufferedInputStream;
            if (httpURLConnection != null) {
            }
            throw th;
        }
    }

    public class Parameter extends SortedParameter {
        Parameter() {
        }

        public String toString() {
            if (this.mParams.isEmpty()) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (String str : this.mParams.keySet()) {
                sb.append(str);
                sb.append("=");
                try {
                    sb.append(URLEncoder.encode(this.mParams.get(str).toString(), "UTF-8"));
                } catch (UnsupportedEncodingException unused) {
                }
                sb.append("&");
            }
            return sb.deleteCharAt(sb.length() - 1).toString();
        }

        public TreeMap<String, Object> getParams() {
            return this.mParams;
        }
    }
}

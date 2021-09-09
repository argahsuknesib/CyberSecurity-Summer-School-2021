package _m_j;

import _m_j.dxr;
import com.xiaomi.miot.support.monitor.core.net.NetInfo;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.security.Permission;
import java.util.List;
import java.util.Map;

public final class dyk extends HttpURLConnection implements dyj {

    /* renamed from: O000000o  reason: collision with root package name */
    private final HttpURLConnection f15070O000000o;
    private NetInfo O00000Oo;

    public dyk(HttpURLConnection httpURLConnection) {
        super(httpURLConnection.getURL());
        this.f15070O000000o = httpURLConnection;
    }

    private static void O000000o(NetInfo netInfo, HttpURLConnection httpURLConnection) {
        int contentLength = httpURLConnection.getContentLength();
        if (contentLength >= 0) {
            netInfo.receivedBytes = (long) contentLength;
        }
        try {
            netInfo.statusCode = httpURLConnection.getResponseCode();
        } catch (IOException | NullPointerException unused) {
        }
    }

    private NetInfo O000000o() {
        if (this.O00000Oo == null) {
            this.O00000Oo = new NetInfo((byte) 0);
            this.O00000Oo.O000000o(this.f15070O000000o.getURL().toString());
            this.O00000Oo.back_type = dzf.O000000o(dxr.O000000o.f15041O000000o.O00000Oo) ? 1 : 2;
        }
        return this.O00000Oo;
    }

    public final void addRequestProperty(String str, String str2) {
        this.f15070O000000o.addRequestProperty(str, str2);
    }

    public final void disconnect() {
        this.O00000Oo.O00000Oo();
        this.f15070O000000o.disconnect();
    }

    public final boolean usingProxy() {
        return this.f15070O000000o.usingProxy();
    }

    public final void connect() throws IOException {
        O000000o();
        try {
            this.f15070O000000o.connect();
        } catch (IOException e) {
            throw e;
        }
    }

    public final boolean getAllowUserInteraction() {
        return this.f15070O000000o.getAllowUserInteraction();
    }

    public final int getConnectTimeout() {
        return this.f15070O000000o.getConnectTimeout();
    }

    public final Object getContent() throws IOException {
        O000000o();
        try {
            Object content = this.f15070O000000o.getContent();
            int contentLength = this.f15070O000000o.getContentLength();
            if (contentLength >= 0) {
                NetInfo O000000o2 = O000000o();
                O000000o2.receivedBytes = (long) contentLength;
                O000000o2.O00000Oo();
            }
            return content;
        } catch (IOException e) {
            throw e;
        }
    }

    public final Object getContent(Class[] clsArr) throws IOException {
        O000000o();
        try {
            Object content = this.f15070O000000o.getContent(clsArr);
            O000000o(O000000o(), this.f15070O000000o);
            return content;
        } catch (IOException e) {
            throw e;
        }
    }

    public final String getContentEncoding() {
        O000000o();
        String contentEncoding = this.f15070O000000o.getContentEncoding();
        O000000o(O000000o(), this.f15070O000000o);
        return contentEncoding;
    }

    public final int getContentLength() {
        O000000o();
        int contentLength = this.f15070O000000o.getContentLength();
        O000000o(O000000o(), this.f15070O000000o);
        return contentLength;
    }

    public final String getContentType() {
        O000000o();
        String contentType = this.f15070O000000o.getContentType();
        O000000o(O000000o(), this.f15070O000000o);
        return contentType;
    }

    public final long getDate() {
        O000000o();
        long date = this.f15070O000000o.getDate();
        O000000o(O000000o(), this.f15070O000000o);
        return date;
    }

    public final InputStream getErrorStream() {
        O000000o();
        try {
            return new dym(this.f15070O000000o.getErrorStream());
        } catch (Exception unused) {
            return this.f15070O000000o.getErrorStream();
        }
    }

    public final long getHeaderFieldDate(String str, long j) {
        O000000o();
        long headerFieldDate = this.f15070O000000o.getHeaderFieldDate(str, j);
        O000000o(O000000o(), this.f15070O000000o);
        return headerFieldDate;
    }

    public final boolean getInstanceFollowRedirects() {
        return this.f15070O000000o.getInstanceFollowRedirects();
    }

    public final Permission getPermission() throws IOException {
        return this.f15070O000000o.getPermission();
    }

    public final String getRequestMethod() {
        return this.f15070O000000o.getRequestMethod();
    }

    public final int getResponseCode() throws IOException {
        O000000o();
        try {
            int responseCode = this.f15070O000000o.getResponseCode();
            O000000o(O000000o(), this.f15070O000000o);
            return responseCode;
        } catch (IOException e) {
            throw e;
        }
    }

    public final String getResponseMessage() throws IOException {
        O000000o();
        try {
            String responseMessage = this.f15070O000000o.getResponseMessage();
            O000000o(O000000o(), this.f15070O000000o);
            return responseMessage;
        } catch (IOException e) {
            throw e;
        }
    }

    public final void setChunkedStreamingMode(int i) {
        this.f15070O000000o.setChunkedStreamingMode(i);
    }

    public final void setFixedLengthStreamingMode(int i) {
        this.f15070O000000o.setFixedLengthStreamingMode(i);
    }

    public final void setInstanceFollowRedirects(boolean z) {
        this.f15070O000000o.setInstanceFollowRedirects(z);
    }

    public final void setRequestMethod(String str) throws ProtocolException {
        O000000o();
        try {
            this.f15070O000000o.setRequestMethod(str);
        } catch (ProtocolException e) {
            throw e;
        }
    }

    public final boolean getDefaultUseCaches() {
        return this.f15070O000000o.getDefaultUseCaches();
    }

    public final boolean getDoInput() {
        return this.f15070O000000o.getDoInput();
    }

    public final boolean getDoOutput() {
        return this.f15070O000000o.getDoOutput();
    }

    public final long getExpiration() {
        O000000o();
        long expiration = this.f15070O000000o.getExpiration();
        O000000o(O000000o(), this.f15070O000000o);
        return expiration;
    }

    public final String getHeaderField(int i) {
        O000000o();
        String headerField = this.f15070O000000o.getHeaderField(i);
        O000000o(O000000o(), this.f15070O000000o);
        return headerField;
    }

    public final String getHeaderField(String str) {
        O000000o();
        String headerField = this.f15070O000000o.getHeaderField(str);
        O000000o(O000000o(), this.f15070O000000o);
        return headerField;
    }

    public final int getHeaderFieldInt(String str, int i) {
        O000000o();
        int headerFieldInt = this.f15070O000000o.getHeaderFieldInt(str, i);
        O000000o(O000000o(), this.f15070O000000o);
        return headerFieldInt;
    }

    public final String getHeaderFieldKey(int i) {
        O000000o();
        String headerFieldKey = this.f15070O000000o.getHeaderFieldKey(i);
        O000000o(O000000o(), this.f15070O000000o);
        return headerFieldKey;
    }

    public final Map<String, List<String>> getHeaderFields() {
        O000000o();
        Map<String, List<String>> headerFields = this.f15070O000000o.getHeaderFields();
        O000000o(O000000o(), this.f15070O000000o);
        return headerFields;
    }

    public final long getIfModifiedSince() {
        O000000o();
        long ifModifiedSince = this.f15070O000000o.getIfModifiedSince();
        O000000o(O000000o(), this.f15070O000000o);
        return ifModifiedSince;
    }

    public final InputStream getInputStream() throws IOException {
        NetInfo O000000o2 = O000000o();
        try {
            dym dym = new dym(this.f15070O000000o.getInputStream());
            O000000o(O000000o2, this.f15070O000000o);
            dym.f15072O000000o = this;
            return dym;
        } catch (IOException e) {
            throw e;
        }
    }

    public final long getLastModified() {
        O000000o();
        long lastModified = this.f15070O000000o.getLastModified();
        O000000o(O000000o(), this.f15070O000000o);
        return lastModified;
    }

    public final OutputStream getOutputStream() throws IOException {
        O000000o();
        try {
            dyn dyn = new dyn(this.f15070O000000o.getOutputStream());
            dyn.f15073O000000o = this;
            return dyn;
        } catch (IOException e) {
            throw e;
        }
    }

    public final int getReadTimeout() {
        return this.f15070O000000o.getReadTimeout();
    }

    public final Map<String, List<String>> getRequestProperties() {
        return this.f15070O000000o.getRequestProperties();
    }

    public final String getRequestProperty(String str) {
        return this.f15070O000000o.getRequestProperty(str);
    }

    public final URL getURL() {
        return this.f15070O000000o.getURL();
    }

    public final boolean getUseCaches() {
        return this.f15070O000000o.getUseCaches();
    }

    public final void setAllowUserInteraction(boolean z) {
        this.f15070O000000o.setAllowUserInteraction(z);
    }

    public final void setConnectTimeout(int i) {
        this.f15070O000000o.setConnectTimeout(i);
    }

    public final void setDefaultUseCaches(boolean z) {
        this.f15070O000000o.setDefaultUseCaches(z);
    }

    public final void setDoInput(boolean z) {
        this.f15070O000000o.setDoInput(z);
    }

    public final void setDoOutput(boolean z) {
        this.f15070O000000o.setDoOutput(z);
    }

    public final void setIfModifiedSince(long j) {
        this.f15070O000000o.setIfModifiedSince(j);
    }

    public final void setReadTimeout(int i) {
        this.f15070O000000o.setReadTimeout(i);
    }

    public final void setRequestProperty(String str, String str2) {
        this.f15070O000000o.setRequestProperty(str, str2);
    }

    public final void setUseCaches(boolean z) {
        this.f15070O000000o.setUseCaches(z);
    }

    public final String toString() {
        HttpURLConnection httpURLConnection = this.f15070O000000o;
        if (httpURLConnection == null) {
            return "this connection object is null";
        }
        return httpURLConnection.toString();
    }

    public final void O000000o(long j) {
        NetInfo netInfo = this.O00000Oo;
        netInfo.receivedBytes = j;
        netInfo.O00000Oo();
    }

    public final void O00000o0(long j) {
        NetInfo netInfo = this.O00000Oo;
        netInfo.receivedBytes = j;
        netInfo.O00000Oo();
    }

    public final void O00000Oo(long j) {
        NetInfo netInfo = this.O00000Oo;
        netInfo.sentBytes = j;
        netInfo.O00000Oo();
    }

    public final void O00000o(long j) {
        NetInfo netInfo = this.O00000Oo;
        netInfo.sentBytes = j;
        netInfo.O00000Oo();
    }
}

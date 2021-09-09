package _m_j;

import _m_j.dxr;
import com.xiaomi.miot.support.monitor.core.net.NetInfo;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ProtocolException;
import java.net.URL;
import java.security.Permission;
import java.security.Principal;
import java.security.cert.Certificate;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;

public final class dyl extends HttpsURLConnection implements dyj {

    /* renamed from: O000000o  reason: collision with root package name */
    private HttpsURLConnection f15071O000000o;
    private NetInfo O00000Oo;

    public dyl(HttpsURLConnection httpsURLConnection) {
        super(httpsURLConnection.getURL());
        this.f15071O000000o = httpsURLConnection;
    }

    public final String getCipherSuite() {
        return this.f15071O000000o.getCipherSuite();
    }

    public final Certificate[] getLocalCertificates() {
        return this.f15071O000000o.getLocalCertificates();
    }

    public final Certificate[] getServerCertificates() throws SSLPeerUnverifiedException {
        try {
            return this.f15071O000000o.getServerCertificates();
        } catch (SSLPeerUnverifiedException e) {
            throw e;
        }
    }

    public final void addRequestProperty(String str, String str2) {
        this.f15071O000000o.addRequestProperty(str, str2);
    }

    public final void disconnect() {
        this.O00000Oo.O00000Oo();
        this.f15071O000000o.disconnect();
    }

    public final boolean usingProxy() {
        return this.f15071O000000o.usingProxy();
    }

    public final void connect() throws IOException {
        O00000Oo();
        try {
            this.f15071O000000o.connect();
        } catch (IOException e) {
            throw e;
        }
    }

    public final boolean getAllowUserInteraction() {
        return this.f15071O000000o.getAllowUserInteraction();
    }

    public final int getConnectTimeout() {
        return this.f15071O000000o.getConnectTimeout();
    }

    public final Object getContent() throws IOException {
        O00000Oo();
        try {
            Object content = this.f15071O000000o.getContent();
            int contentLength = this.f15071O000000o.getContentLength();
            if (contentLength >= 0) {
                NetInfo O00000Oo2 = O00000Oo();
                O00000Oo2.receivedBytes = (long) contentLength;
                O00000Oo2.O00000Oo();
            }
            return content;
        } catch (IOException e) {
            throw e;
        }
    }

    public final Object getContent(Class[] clsArr) throws IOException {
        O00000Oo();
        try {
            Object content = this.f15071O000000o.getContent(clsArr);
            O000000o();
            return content;
        } catch (IOException e) {
            throw e;
        }
    }

    public final String getContentEncoding() {
        O00000Oo();
        String contentEncoding = this.f15071O000000o.getContentEncoding();
        O000000o();
        return contentEncoding;
    }

    public final int getContentLength() {
        O00000Oo();
        int contentLength = this.f15071O000000o.getContentLength();
        O000000o();
        return contentLength;
    }

    public final String getContentType() {
        O00000Oo();
        String contentType = this.f15071O000000o.getContentType();
        O000000o();
        return contentType;
    }

    public final long getDate() {
        O00000Oo();
        long date = this.f15071O000000o.getDate();
        O000000o();
        return date;
    }

    public final InputStream getErrorStream() {
        O00000Oo();
        try {
            return new dym(this.f15071O000000o.getErrorStream());
        } catch (Exception unused) {
            return this.f15071O000000o.getErrorStream();
        }
    }

    public final long getHeaderFieldDate(String str, long j) {
        O00000Oo();
        long headerFieldDate = this.f15071O000000o.getHeaderFieldDate(str, j);
        O000000o();
        return headerFieldDate;
    }

    public final boolean getInstanceFollowRedirects() {
        return this.f15071O000000o.getInstanceFollowRedirects();
    }

    public final Permission getPermission() throws IOException {
        return this.f15071O000000o.getPermission();
    }

    public final String getRequestMethod() {
        return this.f15071O000000o.getRequestMethod();
    }

    public final int getResponseCode() throws IOException {
        O00000Oo();
        try {
            int responseCode = this.f15071O000000o.getResponseCode();
            O000000o();
            return responseCode;
        } catch (IOException e) {
            throw e;
        }
    }

    public final String getResponseMessage() throws IOException {
        O00000Oo();
        try {
            String responseMessage = this.f15071O000000o.getResponseMessage();
            O000000o();
            return responseMessage;
        } catch (IOException e) {
            throw e;
        }
    }

    public final void setChunkedStreamingMode(int i) {
        this.f15071O000000o.setChunkedStreamingMode(i);
    }

    public final void setFixedLengthStreamingMode(int i) {
        this.f15071O000000o.setFixedLengthStreamingMode(i);
    }

    public final void setInstanceFollowRedirects(boolean z) {
        this.f15071O000000o.setInstanceFollowRedirects(z);
    }

    public final void setRequestMethod(String str) throws ProtocolException {
        try {
            this.f15071O000000o.setRequestMethod(str);
        } catch (ProtocolException e) {
            throw e;
        }
    }

    public final boolean getDefaultUseCaches() {
        return this.f15071O000000o.getDefaultUseCaches();
    }

    public final boolean getDoInput() {
        return this.f15071O000000o.getDoInput();
    }

    public final boolean getDoOutput() {
        return this.f15071O000000o.getDoOutput();
    }

    public final long getExpiration() {
        O00000Oo();
        long expiration = this.f15071O000000o.getExpiration();
        O000000o();
        return expiration;
    }

    public final String getHeaderField(int i) {
        O00000Oo();
        String headerField = this.f15071O000000o.getHeaderField(i);
        O000000o();
        return headerField;
    }

    public final String getHeaderField(String str) {
        O00000Oo();
        String headerField = this.f15071O000000o.getHeaderField(str);
        O000000o();
        return headerField;
    }

    public final int getHeaderFieldInt(String str, int i) {
        O00000Oo();
        int headerFieldInt = this.f15071O000000o.getHeaderFieldInt(str, i);
        O000000o();
        return headerFieldInt;
    }

    public final String getHeaderFieldKey(int i) {
        O00000Oo();
        String headerFieldKey = this.f15071O000000o.getHeaderFieldKey(i);
        O000000o();
        return headerFieldKey;
    }

    public final Map<String, List<String>> getHeaderFields() {
        O00000Oo();
        Map<String, List<String>> headerFields = this.f15071O000000o.getHeaderFields();
        O000000o();
        return headerFields;
    }

    public final long getIfModifiedSince() {
        O00000Oo();
        long ifModifiedSince = this.f15071O000000o.getIfModifiedSince();
        O000000o();
        return ifModifiedSince;
    }

    public final InputStream getInputStream() throws IOException {
        NetInfo O00000Oo2 = O00000Oo();
        try {
            dym dym = new dym(this.f15071O000000o.getInputStream());
            O000000o(O00000Oo2, this.f15071O000000o);
            dym.f15072O000000o = this;
            return dym;
        } catch (IOException e) {
            throw e;
        }
    }

    public final long getLastModified() {
        O00000Oo();
        long lastModified = this.f15071O000000o.getLastModified();
        O000000o();
        return lastModified;
    }

    public final OutputStream getOutputStream() throws IOException {
        O00000Oo();
        try {
            dyn dyn = new dyn(this.f15071O000000o.getOutputStream());
            dyn.f15073O000000o = this;
            return dyn;
        } catch (IOException e) {
            throw e;
        }
    }

    public final int getReadTimeout() {
        return this.f15071O000000o.getReadTimeout();
    }

    public final Map<String, List<String>> getRequestProperties() {
        return this.f15071O000000o.getRequestProperties();
    }

    public final String getRequestProperty(String str) {
        return this.f15071O000000o.getRequestProperty(str);
    }

    public final URL getURL() {
        return this.f15071O000000o.getURL();
    }

    public final boolean getUseCaches() {
        return this.f15071O000000o.getUseCaches();
    }

    public final void setAllowUserInteraction(boolean z) {
        this.f15071O000000o.setAllowUserInteraction(z);
    }

    public final void setConnectTimeout(int i) {
        this.f15071O000000o.setConnectTimeout(i);
    }

    public final void setDefaultUseCaches(boolean z) {
        this.f15071O000000o.setDefaultUseCaches(z);
    }

    public final void setDoInput(boolean z) {
        this.f15071O000000o.setDoInput(z);
    }

    public final void setDoOutput(boolean z) {
        this.f15071O000000o.setDoOutput(z);
    }

    public final void setIfModifiedSince(long j) {
        this.f15071O000000o.setIfModifiedSince(j);
    }

    public final void setReadTimeout(int i) {
        this.f15071O000000o.setReadTimeout(i);
    }

    public final void setRequestProperty(String str, String str2) {
        this.f15071O000000o.setRequestProperty(str, str2);
    }

    public final void setUseCaches(boolean z) {
        this.f15071O000000o.setUseCaches(z);
    }

    public final String toString() {
        HttpsURLConnection httpsURLConnection = this.f15071O000000o;
        if (httpsURLConnection == null) {
            return "this connection object is null";
        }
        return httpsURLConnection.toString();
    }

    public final Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        return this.f15071O000000o.getPeerPrincipal();
    }

    public final Principal getLocalPrincipal() {
        return this.f15071O000000o.getLocalPrincipal();
    }

    public final void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        this.f15071O000000o.setHostnameVerifier(hostnameVerifier);
    }

    public final HostnameVerifier getHostnameVerifier() {
        return this.f15071O000000o.getHostnameVerifier();
    }

    public final void setSSLSocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.f15071O000000o.setSSLSocketFactory(sSLSocketFactory);
    }

    public final SSLSocketFactory getSSLSocketFactory() {
        return this.f15071O000000o.getSSLSocketFactory();
    }

    private void O000000o() {
        O000000o(O00000Oo(), this.f15071O000000o);
    }

    private NetInfo O00000Oo() {
        if (this.O00000Oo == null) {
            this.O00000Oo = new NetInfo((byte) 0);
            this.O00000Oo.O000000o(this.f15071O000000o.getURL().toString());
            this.O00000Oo.startTime = System.currentTimeMillis();
            this.O00000Oo.back_type = dzf.O000000o(dxr.O000000o.f15041O000000o.O00000Oo) ? 1 : 2;
        }
        return this.O00000Oo;
    }

    private static void O000000o(NetInfo netInfo, HttpsURLConnection httpsURLConnection) {
        int contentLength = httpsURLConnection.getContentLength();
        if (contentLength >= 0) {
            netInfo.receivedBytes = (long) contentLength;
        }
        try {
            netInfo.statusCode = httpsURLConnection.getResponseCode();
        } catch (IOException | NullPointerException unused) {
        }
    }

    public final void O000000o(long j) {
        NetInfo netInfo = this.O00000Oo;
        netInfo.receivedBytes = j;
        if (netInfo.startTime > 0) {
            this.O00000Oo.costTime = System.currentTimeMillis() - this.O00000Oo.startTime;
        }
        this.O00000Oo.O00000Oo();
    }

    public final void O00000o0(long j) {
        NetInfo netInfo = this.O00000Oo;
        netInfo.receivedBytes = j;
        if (netInfo.startTime > 0) {
            this.O00000Oo.costTime = System.currentTimeMillis() - this.O00000Oo.startTime;
        }
        this.O00000Oo.O00000Oo();
    }

    public final void O00000Oo(long j) {
        NetInfo netInfo = this.O00000Oo;
        netInfo.sentBytes = j;
        if (netInfo.startTime > 0) {
            this.O00000Oo.costTime = System.currentTimeMillis() - this.O00000Oo.startTime;
        }
        this.O00000Oo.O00000Oo();
    }

    public final void O00000o(long j) {
        NetInfo netInfo = this.O00000Oo;
        netInfo.sentBytes = j;
        if (netInfo.startTime > 0) {
            this.O00000Oo.costTime = System.currentTimeMillis() - this.O00000Oo.startTime;
        }
        this.O00000Oo.O00000Oo();
    }
}

package okhttp3.internal.huc;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ProtocolException;
import java.net.URL;
import java.security.Permission;
import java.security.Principal;
import java.security.cert.Certificate;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.Handshake;
import okhttp3.OkHttpClient;
import okhttp3.internal.URLFilter;

public final class OkHttpsURLConnection extends DelegatingHttpsURLConnection {
    private final OkHttpURLConnection delegate;

    public final /* bridge */ /* synthetic */ void addRequestProperty(String str, String str2) {
        super.addRequestProperty(str, str2);
    }

    public final /* bridge */ /* synthetic */ void connect() throws IOException {
        super.connect();
    }

    public final /* bridge */ /* synthetic */ void disconnect() {
        super.disconnect();
    }

    public final /* bridge */ /* synthetic */ boolean getAllowUserInteraction() {
        return super.getAllowUserInteraction();
    }

    public final /* bridge */ /* synthetic */ String getCipherSuite() {
        return super.getCipherSuite();
    }

    public final /* bridge */ /* synthetic */ int getConnectTimeout() {
        return super.getConnectTimeout();
    }

    public final /* bridge */ /* synthetic */ Object getContent() throws IOException {
        return super.getContent();
    }

    public final /* bridge */ /* synthetic */ Object getContent(Class[] clsArr) throws IOException {
        return super.getContent(clsArr);
    }

    public final /* bridge */ /* synthetic */ String getContentEncoding() {
        return super.getContentEncoding();
    }

    public final /* bridge */ /* synthetic */ int getContentLength() {
        return super.getContentLength();
    }

    public final /* bridge */ /* synthetic */ long getContentLengthLong() {
        return super.getContentLengthLong();
    }

    public final /* bridge */ /* synthetic */ String getContentType() {
        return super.getContentType();
    }

    public final /* bridge */ /* synthetic */ long getDate() {
        return super.getDate();
    }

    public final /* bridge */ /* synthetic */ boolean getDefaultUseCaches() {
        return super.getDefaultUseCaches();
    }

    public final /* bridge */ /* synthetic */ boolean getDoInput() {
        return super.getDoInput();
    }

    public final /* bridge */ /* synthetic */ boolean getDoOutput() {
        return super.getDoOutput();
    }

    public final /* bridge */ /* synthetic */ InputStream getErrorStream() {
        return super.getErrorStream();
    }

    public final /* bridge */ /* synthetic */ long getExpiration() {
        return super.getExpiration();
    }

    public final /* bridge */ /* synthetic */ String getHeaderField(int i) {
        return super.getHeaderField(i);
    }

    public final /* bridge */ /* synthetic */ String getHeaderField(String str) {
        return super.getHeaderField(str);
    }

    public final /* bridge */ /* synthetic */ long getHeaderFieldDate(String str, long j) {
        return super.getHeaderFieldDate(str, j);
    }

    public final /* bridge */ /* synthetic */ int getHeaderFieldInt(String str, int i) {
        return super.getHeaderFieldInt(str, i);
    }

    public final /* bridge */ /* synthetic */ String getHeaderFieldKey(int i) {
        return super.getHeaderFieldKey(i);
    }

    public final /* bridge */ /* synthetic */ long getHeaderFieldLong(String str, long j) {
        return super.getHeaderFieldLong(str, j);
    }

    public final /* bridge */ /* synthetic */ Map getHeaderFields() {
        return super.getHeaderFields();
    }

    public final /* bridge */ /* synthetic */ long getIfModifiedSince() {
        return super.getIfModifiedSince();
    }

    public final /* bridge */ /* synthetic */ InputStream getInputStream() throws IOException {
        return super.getInputStream();
    }

    public final /* bridge */ /* synthetic */ boolean getInstanceFollowRedirects() {
        return super.getInstanceFollowRedirects();
    }

    public final /* bridge */ /* synthetic */ long getLastModified() {
        return super.getLastModified();
    }

    public final /* bridge */ /* synthetic */ Certificate[] getLocalCertificates() {
        return super.getLocalCertificates();
    }

    public final /* bridge */ /* synthetic */ Principal getLocalPrincipal() {
        return super.getLocalPrincipal();
    }

    public final /* bridge */ /* synthetic */ OutputStream getOutputStream() throws IOException {
        return super.getOutputStream();
    }

    public final /* bridge */ /* synthetic */ Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        return super.getPeerPrincipal();
    }

    public final /* bridge */ /* synthetic */ Permission getPermission() throws IOException {
        return super.getPermission();
    }

    public final /* bridge */ /* synthetic */ int getReadTimeout() {
        return super.getReadTimeout();
    }

    public final /* bridge */ /* synthetic */ String getRequestMethod() {
        return super.getRequestMethod();
    }

    public final /* bridge */ /* synthetic */ Map getRequestProperties() {
        return super.getRequestProperties();
    }

    public final /* bridge */ /* synthetic */ String getRequestProperty(String str) {
        return super.getRequestProperty(str);
    }

    public final /* bridge */ /* synthetic */ int getResponseCode() throws IOException {
        return super.getResponseCode();
    }

    public final /* bridge */ /* synthetic */ String getResponseMessage() throws IOException {
        return super.getResponseMessage();
    }

    public final /* bridge */ /* synthetic */ Certificate[] getServerCertificates() throws SSLPeerUnverifiedException {
        return super.getServerCertificates();
    }

    public final /* bridge */ /* synthetic */ URL getURL() {
        return super.getURL();
    }

    public final /* bridge */ /* synthetic */ boolean getUseCaches() {
        return super.getUseCaches();
    }

    public final /* bridge */ /* synthetic */ void setAllowUserInteraction(boolean z) {
        super.setAllowUserInteraction(z);
    }

    public final /* bridge */ /* synthetic */ void setChunkedStreamingMode(int i) {
        super.setChunkedStreamingMode(i);
    }

    public final /* bridge */ /* synthetic */ void setConnectTimeout(int i) {
        super.setConnectTimeout(i);
    }

    public final /* bridge */ /* synthetic */ void setDefaultUseCaches(boolean z) {
        super.setDefaultUseCaches(z);
    }

    public final /* bridge */ /* synthetic */ void setDoInput(boolean z) {
        super.setDoInput(z);
    }

    public final /* bridge */ /* synthetic */ void setDoOutput(boolean z) {
        super.setDoOutput(z);
    }

    public final /* bridge */ /* synthetic */ void setFixedLengthStreamingMode(int i) {
        super.setFixedLengthStreamingMode(i);
    }

    public final /* bridge */ /* synthetic */ void setFixedLengthStreamingMode(long j) {
        super.setFixedLengthStreamingMode(j);
    }

    public final /* bridge */ /* synthetic */ void setIfModifiedSince(long j) {
        super.setIfModifiedSince(j);
    }

    public final /* bridge */ /* synthetic */ void setInstanceFollowRedirects(boolean z) {
        super.setInstanceFollowRedirects(z);
    }

    public final /* bridge */ /* synthetic */ void setReadTimeout(int i) {
        super.setReadTimeout(i);
    }

    public final /* bridge */ /* synthetic */ void setRequestMethod(String str) throws ProtocolException {
        super.setRequestMethod(str);
    }

    public final /* bridge */ /* synthetic */ void setRequestProperty(String str, String str2) {
        super.setRequestProperty(str, str2);
    }

    public final /* bridge */ /* synthetic */ void setUseCaches(boolean z) {
        super.setUseCaches(z);
    }

    public final /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public final /* bridge */ /* synthetic */ boolean usingProxy() {
        return super.usingProxy();
    }

    public OkHttpsURLConnection(URL url, OkHttpClient okHttpClient) {
        this(new OkHttpURLConnection(url, okHttpClient));
    }

    public OkHttpsURLConnection(URL url, OkHttpClient okHttpClient, URLFilter uRLFilter) {
        this(new OkHttpURLConnection(url, okHttpClient, uRLFilter));
    }

    public OkHttpsURLConnection(OkHttpURLConnection okHttpURLConnection) {
        super(okHttpURLConnection);
        this.delegate = okHttpURLConnection;
    }

    /* access modifiers changed from: protected */
    public final Handshake handshake() {
        if (this.delegate.call != null) {
            return this.delegate.handshake;
        }
        throw new IllegalStateException("Connection has not yet been established");
    }

    public final void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        OkHttpURLConnection okHttpURLConnection = this.delegate;
        okHttpURLConnection.client = okHttpURLConnection.client.newBuilder().hostnameVerifier(hostnameVerifier).build();
    }

    public final HostnameVerifier getHostnameVerifier() {
        return this.delegate.client.hostnameVerifier();
    }

    public final void setSSLSocketFactory(SSLSocketFactory sSLSocketFactory) {
        if (sSLSocketFactory != null) {
            OkHttpURLConnection okHttpURLConnection = this.delegate;
            okHttpURLConnection.client = okHttpURLConnection.client.newBuilder().sslSocketFactory(sSLSocketFactory).build();
            return;
        }
        throw new IllegalArgumentException("sslSocketFactory == null");
    }

    public final SSLSocketFactory getSSLSocketFactory() {
        return this.delegate.client.sslSocketFactory();
    }
}

package com.hzy.tvmao.model.legacy.api;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Arrays;
import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class g extends SSLSocketFactory {

    /* renamed from: a  reason: collision with root package name */
    private final SSLSocketFactory f4434a;

    public g() {
        this.f4434a = HttpsURLConnection.getDefaultSSLSocketFactory();
    }

    public g(SSLSocketFactory sSLSocketFactory) {
        this.f4434a = sSLSocketFactory;
    }

    public String[] getDefaultCipherSuites() {
        return this.f4434a.getDefaultCipherSuites();
    }

    public String[] getSupportedCipherSuites() {
        return this.f4434a.getSupportedCipherSuites();
    }

    private Socket a(Socket socket) {
        return socket instanceof SSLSocket ? new b((SSLSocket) socket) : socket;
    }

    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        return a(this.f4434a.createSocket(socket, str, i, z));
    }

    public Socket createSocket(String str, int i) throws IOException {
        return a(this.f4434a.createSocket(str, i));
    }

    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException {
        return a(this.f4434a.createSocket(str, i, inetAddress, i2));
    }

    public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        return a(this.f4434a.createSocket(inetAddress, i));
    }

    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        return a(this.f4434a.createSocket(inetAddress, i, inetAddress2, i2));
    }

    class b extends a {
        private b(SSLSocket sSLSocket) {
            super(sSLSocket);
        }

        public void setEnabledProtocols(String[] strArr) {
            if (strArr != null && strArr.length == 1 && "SSLv3".equals(strArr[0])) {
                ArrayList arrayList = new ArrayList(Arrays.asList(this.f4435a.getEnabledProtocols()));
                if (arrayList.size() > 1) {
                    arrayList.remove("SSLv3");
                    System.out.println("Removed SSLv3 from enabled protocols");
                } else {
                    PrintStream printStream = System.out;
                    printStream.println("SSL stuck with protocol available for " + String.valueOf(arrayList));
                }
                strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
            }
            super.setEnabledProtocols(strArr);
        }
    }

    public class a extends SSLSocket {

        /* renamed from: a  reason: collision with root package name */
        protected final SSLSocket f4435a;

        a(SSLSocket sSLSocket) {
            this.f4435a = sSLSocket;
        }

        public String[] getSupportedCipherSuites() {
            return this.f4435a.getSupportedCipherSuites();
        }

        public String[] getEnabledCipherSuites() {
            return this.f4435a.getEnabledCipherSuites();
        }

        public void setEnabledCipherSuites(String[] strArr) {
            this.f4435a.setEnabledCipherSuites(strArr);
        }

        public String[] getSupportedProtocols() {
            return this.f4435a.getSupportedProtocols();
        }

        public String[] getEnabledProtocols() {
            return this.f4435a.getEnabledProtocols();
        }

        public void setEnabledProtocols(String[] strArr) {
            this.f4435a.setEnabledProtocols(strArr);
        }

        public SSLSession getSession() {
            return this.f4435a.getSession();
        }

        public void addHandshakeCompletedListener(HandshakeCompletedListener handshakeCompletedListener) {
            this.f4435a.addHandshakeCompletedListener(handshakeCompletedListener);
        }

        public void removeHandshakeCompletedListener(HandshakeCompletedListener handshakeCompletedListener) {
            this.f4435a.removeHandshakeCompletedListener(handshakeCompletedListener);
        }

        public void startHandshake() throws IOException {
            this.f4435a.startHandshake();
        }

        public void setUseClientMode(boolean z) {
            this.f4435a.setUseClientMode(z);
        }

        public boolean getUseClientMode() {
            return this.f4435a.getUseClientMode();
        }

        public void setNeedClientAuth(boolean z) {
            this.f4435a.setNeedClientAuth(z);
        }

        public void setWantClientAuth(boolean z) {
            this.f4435a.setWantClientAuth(z);
        }

        public boolean getNeedClientAuth() {
            return this.f4435a.getNeedClientAuth();
        }

        public boolean getWantClientAuth() {
            return this.f4435a.getWantClientAuth();
        }

        public void setEnableSessionCreation(boolean z) {
            this.f4435a.setEnableSessionCreation(z);
        }

        public boolean getEnableSessionCreation() {
            return this.f4435a.getEnableSessionCreation();
        }

        public void bind(SocketAddress socketAddress) throws IOException {
            this.f4435a.bind(socketAddress);
        }

        public synchronized void close() throws IOException {
            this.f4435a.close();
        }

        public void connect(SocketAddress socketAddress) throws IOException {
            this.f4435a.connect(socketAddress);
        }

        public void connect(SocketAddress socketAddress, int i) throws IOException {
            this.f4435a.connect(socketAddress, i);
        }

        public SocketChannel getChannel() {
            return this.f4435a.getChannel();
        }

        public InetAddress getInetAddress() {
            return this.f4435a.getInetAddress();
        }

        public InputStream getInputStream() throws IOException {
            return this.f4435a.getInputStream();
        }

        public boolean getKeepAlive() throws SocketException {
            return this.f4435a.getKeepAlive();
        }

        public InetAddress getLocalAddress() {
            return this.f4435a.getLocalAddress();
        }

        public int getLocalPort() {
            return this.f4435a.getLocalPort();
        }

        public SocketAddress getLocalSocketAddress() {
            return this.f4435a.getLocalSocketAddress();
        }

        public boolean getOOBInline() throws SocketException {
            return this.f4435a.getOOBInline();
        }

        public OutputStream getOutputStream() throws IOException {
            return this.f4435a.getOutputStream();
        }

        public int getPort() {
            return this.f4435a.getPort();
        }

        public synchronized int getReceiveBufferSize() throws SocketException {
            return this.f4435a.getReceiveBufferSize();
        }

        public SocketAddress getRemoteSocketAddress() {
            return this.f4435a.getRemoteSocketAddress();
        }

        public boolean getReuseAddress() throws SocketException {
            return this.f4435a.getReuseAddress();
        }

        public synchronized int getSendBufferSize() throws SocketException {
            return this.f4435a.getSendBufferSize();
        }

        public int getSoLinger() throws SocketException {
            return this.f4435a.getSoLinger();
        }

        public synchronized int getSoTimeout() throws SocketException {
            return this.f4435a.getSoTimeout();
        }

        public boolean getTcpNoDelay() throws SocketException {
            return this.f4435a.getTcpNoDelay();
        }

        public int getTrafficClass() throws SocketException {
            return this.f4435a.getTrafficClass();
        }

        public boolean isBound() {
            return this.f4435a.isBound();
        }

        public boolean isClosed() {
            return this.f4435a.isClosed();
        }

        public boolean isConnected() {
            return this.f4435a.isConnected();
        }

        public boolean isInputShutdown() {
            return this.f4435a.isInputShutdown();
        }

        public boolean isOutputShutdown() {
            return this.f4435a.isOutputShutdown();
        }

        public void sendUrgentData(int i) throws IOException {
            this.f4435a.sendUrgentData(i);
        }

        public void setKeepAlive(boolean z) throws SocketException {
            this.f4435a.setKeepAlive(z);
        }

        public void setOOBInline(boolean z) throws SocketException {
            this.f4435a.setOOBInline(z);
        }

        public void setPerformancePreferences(int i, int i2, int i3) {
            this.f4435a.setPerformancePreferences(i, i2, i3);
        }

        public synchronized void setReceiveBufferSize(int i) throws SocketException {
            this.f4435a.setReceiveBufferSize(i);
        }

        public void setReuseAddress(boolean z) throws SocketException {
            this.f4435a.setReuseAddress(z);
        }

        public synchronized void setSendBufferSize(int i) throws SocketException {
            this.f4435a.setSendBufferSize(i);
        }

        public void setSoLinger(boolean z, int i) throws SocketException {
            this.f4435a.setSoLinger(z, i);
        }

        public synchronized void setSoTimeout(int i) throws SocketException {
            this.f4435a.setSoTimeout(i);
        }

        public void setTcpNoDelay(boolean z) throws SocketException {
            this.f4435a.setTcpNoDelay(z);
        }

        public void setTrafficClass(int i) throws SocketException {
            this.f4435a.setTrafficClass(i);
        }

        public void shutdownInput() throws IOException {
            this.f4435a.shutdownInput();
        }

        public void shutdownOutput() throws IOException {
            this.f4435a.shutdownOutput();
        }

        public String toString() {
            return this.f4435a.toString();
        }

        public boolean equals(Object obj) {
            return this.f4435a.equals(obj);
        }
    }
}

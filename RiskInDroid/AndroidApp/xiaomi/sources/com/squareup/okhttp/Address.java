package com.squareup.okhttp;

import com.squareup.okhttp.internal.Util;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

public final class Address {
    final Authenticator authenticator;
    final CertificatePinner certificatePinner;
    final List<ConnectionSpec> connectionSpecs;
    final Dns dns;
    final HostnameVerifier hostnameVerifier;
    final List<Protocol> protocols;
    final Proxy proxy;
    final ProxySelector proxySelector;
    final SocketFactory socketFactory;
    final SSLSocketFactory sslSocketFactory;
    final String uriHost;
    final int uriPort;

    public Address(String str, int i, Dns dns2, SocketFactory socketFactory2, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier2, CertificatePinner certificatePinner2, Authenticator authenticator2, Proxy proxy2, List<Protocol> list, List<ConnectionSpec> list2, ProxySelector proxySelector2) {
        if (str != null) {
            this.uriHost = str;
            if (i > 0) {
                this.uriPort = i;
                if (dns2 != null) {
                    this.dns = dns2;
                    if (socketFactory2 != null) {
                        this.socketFactory = socketFactory2;
                        if (authenticator2 != null) {
                            this.authenticator = authenticator2;
                            if (list != null) {
                                this.protocols = Util.immutableList(list);
                                if (list2 != null) {
                                    this.connectionSpecs = Util.immutableList(list2);
                                    if (proxySelector2 != null) {
                                        this.proxySelector = proxySelector2;
                                        this.proxy = proxy2;
                                        this.sslSocketFactory = sSLSocketFactory;
                                        this.hostnameVerifier = hostnameVerifier2;
                                        this.certificatePinner = certificatePinner2;
                                        return;
                                    }
                                    throw new IllegalArgumentException("proxySelector == null");
                                }
                                throw new IllegalArgumentException("connectionSpecs == null");
                            }
                            throw new IllegalArgumentException("protocols == null");
                        }
                        throw new IllegalArgumentException("authenticator == null");
                    }
                    throw new IllegalArgumentException("socketFactory == null");
                }
                throw new IllegalArgumentException("dns == null");
            }
            throw new IllegalArgumentException("uriPort <= 0: ".concat(String.valueOf(i)));
        }
        throw new NullPointerException("uriHost == null");
    }

    public final String getUriHost() {
        return this.uriHost;
    }

    public final int getUriPort() {
        return this.uriPort;
    }

    public final Dns getDns() {
        return this.dns;
    }

    public final SocketFactory getSocketFactory() {
        return this.socketFactory;
    }

    public final Authenticator getAuthenticator() {
        return this.authenticator;
    }

    public final List<Protocol> getProtocols() {
        return this.protocols;
    }

    public final List<ConnectionSpec> getConnectionSpecs() {
        return this.connectionSpecs;
    }

    public final ProxySelector getProxySelector() {
        return this.proxySelector;
    }

    public final Proxy getProxy() {
        return this.proxy;
    }

    public final SSLSocketFactory getSslSocketFactory() {
        return this.sslSocketFactory;
    }

    public final HostnameVerifier getHostnameVerifier() {
        return this.hostnameVerifier;
    }

    public final CertificatePinner getCertificatePinner() {
        return this.certificatePinner;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Address) {
            Address address = (Address) obj;
            if (!this.uriHost.equals(address.uriHost) || this.uriPort != address.uriPort || !this.dns.equals(address.dns) || !this.authenticator.equals(address.authenticator) || !this.protocols.equals(address.protocols) || !this.connectionSpecs.equals(address.connectionSpecs) || !this.proxySelector.equals(address.proxySelector) || !Util.equal(this.proxy, address.proxy) || !Util.equal(this.sslSocketFactory, address.sslSocketFactory) || !Util.equal(this.hostnameVerifier, address.hostnameVerifier) || !Util.equal(this.certificatePinner, address.certificatePinner)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = (((((((((((((this.uriHost.hashCode() + 527) * 31) + this.uriPort) * 31) + this.dns.hashCode()) * 31) + this.authenticator.hashCode()) * 31) + this.protocols.hashCode()) * 31) + this.connectionSpecs.hashCode()) * 31) + this.proxySelector.hashCode()) * 31;
        Proxy proxy2 = this.proxy;
        int i = 0;
        int hashCode2 = (hashCode + (proxy2 != null ? proxy2.hashCode() : 0)) * 31;
        SSLSocketFactory sSLSocketFactory = this.sslSocketFactory;
        int hashCode3 = (hashCode2 + (sSLSocketFactory != null ? sSLSocketFactory.hashCode() : 0)) * 31;
        HostnameVerifier hostnameVerifier2 = this.hostnameVerifier;
        int hashCode4 = (hashCode3 + (hostnameVerifier2 != null ? hostnameVerifier2.hashCode() : 0)) * 31;
        CertificatePinner certificatePinner2 = this.certificatePinner;
        if (certificatePinner2 != null) {
            i = certificatePinner2.hashCode();
        }
        return hashCode4 + i;
    }
}

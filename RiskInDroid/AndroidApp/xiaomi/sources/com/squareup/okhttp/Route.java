package com.squareup.okhttp;

import java.net.InetSocketAddress;
import java.net.Proxy;

public final class Route {
    final Address address;
    final InetSocketAddress inetSocketAddress;
    final Proxy proxy;

    public Route(Address address2, Proxy proxy2, InetSocketAddress inetSocketAddress2) {
        if (address2 == null) {
            throw new NullPointerException("address == null");
        } else if (proxy2 == null) {
            throw new NullPointerException("proxy == null");
        } else if (inetSocketAddress2 != null) {
            this.address = address2;
            this.proxy = proxy2;
            this.inetSocketAddress = inetSocketAddress2;
        } else {
            throw new NullPointerException("inetSocketAddress == null");
        }
    }

    public final Address getAddress() {
        return this.address;
    }

    public final Proxy getProxy() {
        return this.proxy;
    }

    public final InetSocketAddress getSocketAddress() {
        return this.inetSocketAddress;
    }

    public final boolean requiresTunnel() {
        return this.address.sslSocketFactory != null && this.proxy.type() == Proxy.Type.HTTP;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Route) {
            Route route = (Route) obj;
            if (!this.address.equals(route.address) || !this.proxy.equals(route.proxy) || !this.inetSocketAddress.equals(route.inetSocketAddress)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.address.hashCode() + 527) * 31) + this.proxy.hashCode()) * 31) + this.inetSocketAddress.hashCode();
    }
}

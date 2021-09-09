package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Address;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Route;
import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.RouteDatabase;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public final class RouteSelector {
    private final Address address;
    private final OkHttpClient client;
    private List<InetSocketAddress> inetSocketAddresses = Collections.emptyList();
    private InetSocketAddress lastInetSocketAddress;
    private Proxy lastProxy;
    private int nextInetSocketAddressIndex;
    private int nextProxyIndex;
    private final List<Route> postponedRoutes = new ArrayList();
    private List<Proxy> proxies = Collections.emptyList();
    private final RouteDatabase routeDatabase;
    private final HttpUrl url;

    private RouteSelector(Address address2, HttpUrl httpUrl, OkHttpClient okHttpClient) {
        this.address = address2;
        this.url = httpUrl;
        this.client = okHttpClient;
        this.routeDatabase = Internal.instance.routeDatabase(okHttpClient);
        resetNextProxy(httpUrl, address2.getProxy());
    }

    public static RouteSelector get(Address address2, Request request, OkHttpClient okHttpClient) throws IOException {
        return new RouteSelector(address2, request.httpUrl(), okHttpClient);
    }

    public final boolean hasNext() {
        return hasNextInetSocketAddress() || hasNextProxy() || hasNextPostponed();
    }

    public final Route next() throws IOException {
        while (true) {
            if (!hasNextInetSocketAddress()) {
                if (hasNextProxy()) {
                    this.lastProxy = nextProxy();
                } else if (hasNextPostponed()) {
                    return nextPostponed();
                } else {
                    throw new NoSuchElementException();
                }
            }
            this.lastInetSocketAddress = nextInetSocketAddress();
            Route route = new Route(this.address, this.lastProxy, this.lastInetSocketAddress);
            if (!this.routeDatabase.shouldPostpone(route)) {
                return route;
            }
            this.postponedRoutes.add(route);
        }
    }

    public final void connectFailed(Route route, IOException iOException) {
        if (!(route.getProxy().type() == Proxy.Type.DIRECT || this.address.getProxySelector() == null)) {
            this.address.getProxySelector().connectFailed(this.url.uri(), route.getProxy().address(), iOException);
        }
        this.routeDatabase.failed(route);
    }

    private void resetNextProxy(HttpUrl httpUrl, Proxy proxy) {
        if (proxy != null) {
            this.proxies = Collections.singletonList(proxy);
        } else {
            this.proxies = new ArrayList();
            List<Proxy> select = this.client.getProxySelector().select(httpUrl.uri());
            if (select != null) {
                this.proxies.addAll(select);
            }
            this.proxies.removeAll(Collections.singleton(Proxy.NO_PROXY));
            this.proxies.add(Proxy.NO_PROXY);
        }
        this.nextProxyIndex = 0;
    }

    private boolean hasNextProxy() {
        return this.nextProxyIndex < this.proxies.size();
    }

    private Proxy nextProxy() throws IOException {
        if (hasNextProxy()) {
            List<Proxy> list = this.proxies;
            int i = this.nextProxyIndex;
            this.nextProxyIndex = i + 1;
            Proxy proxy = list.get(i);
            resetNextInetSocketAddress(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.address.getUriHost() + "; exhausted proxy configurations: " + this.proxies);
    }

    private void resetNextInetSocketAddress(Proxy proxy) throws IOException {
        int i;
        String str;
        this.inetSocketAddresses = new ArrayList();
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
            str = this.address.getUriHost();
            i = this.address.getUriPort();
        } else {
            SocketAddress address2 = proxy.address();
            if (address2 instanceof InetSocketAddress) {
                InetSocketAddress inetSocketAddress = (InetSocketAddress) address2;
                str = getHostString(inetSocketAddress);
                i = inetSocketAddress.getPort();
            } else {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + address2.getClass());
            }
        }
        if (i <= 0 || i > 65535) {
            throw new SocketException("No route to " + str + ":" + i + "; port is out of range");
        }
        List<InetAddress> lookup = this.address.getDns().lookup(str);
        int size = lookup.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.inetSocketAddresses.add(new InetSocketAddress(lookup.get(i2), i));
        }
        this.nextInetSocketAddressIndex = 0;
    }

    static String getHostString(InetSocketAddress inetSocketAddress) {
        InetAddress address2 = inetSocketAddress.getAddress();
        if (address2 == null) {
            return inetSocketAddress.getHostName();
        }
        return address2.getHostAddress();
    }

    private boolean hasNextInetSocketAddress() {
        return this.nextInetSocketAddressIndex < this.inetSocketAddresses.size();
    }

    private InetSocketAddress nextInetSocketAddress() throws IOException {
        if (hasNextInetSocketAddress()) {
            List<InetSocketAddress> list = this.inetSocketAddresses;
            int i = this.nextInetSocketAddressIndex;
            this.nextInetSocketAddressIndex = i + 1;
            return list.get(i);
        }
        throw new SocketException("No route to " + this.address.getUriHost() + "; exhausted inet socket addresses: " + this.inetSocketAddresses);
    }

    private boolean hasNextPostponed() {
        return !this.postponedRoutes.isEmpty();
    }

    private Route nextPostponed() {
        return this.postponedRoutes.remove(0);
    }
}

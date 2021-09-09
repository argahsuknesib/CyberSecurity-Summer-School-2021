package com.squareup.okhttp.internal;

import _m_j.jay;
import _m_j.jaz;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Connection;
import com.squareup.okhttp.ConnectionPool;
import com.squareup.okhttp.ConnectionSpec;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.internal.http.HttpEngine;
import com.squareup.okhttp.internal.http.RouteException;
import com.squareup.okhttp.internal.http.Transport;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;

public abstract class Internal {
    public static Internal instance;
    public static final Logger logger = Logger.getLogger(OkHttpClient.class.getName());

    public abstract void addLenient(Headers.Builder builder, String str);

    public abstract void addLenient(Headers.Builder builder, String str, String str2);

    public abstract void apply(ConnectionSpec connectionSpec, SSLSocket sSLSocket, boolean z);

    public abstract Connection callEngineGetConnection(Call call);

    public abstract void callEngineReleaseConnection(Call call) throws IOException;

    public abstract void callEnqueue(Call call, Callback callback, boolean z);

    public abstract boolean clearOwner(Connection connection);

    public abstract void closeIfOwnedBy(Connection connection, Object obj) throws IOException;

    public abstract void connectAndSetOwner(OkHttpClient okHttpClient, Connection connection, HttpEngine httpEngine) throws RouteException;

    public abstract jay connectionRawSink(Connection connection);

    public abstract jaz connectionRawSource(Connection connection);

    public abstract void connectionSetOwner(Connection connection, Object obj);

    public abstract HttpUrl getHttpUrlChecked(String str) throws MalformedURLException, UnknownHostException;

    public abstract InternalCache internalCache(OkHttpClient okHttpClient);

    public abstract boolean isReadable(Connection connection);

    public abstract Transport newTransport(Connection connection, HttpEngine httpEngine) throws IOException;

    public abstract void recycle(ConnectionPool connectionPool, Connection connection);

    public abstract int recycleCount(Connection connection);

    public abstract RouteDatabase routeDatabase(OkHttpClient okHttpClient);

    public abstract void setCache(OkHttpClient okHttpClient, InternalCache internalCache);

    public abstract void setOwner(Connection connection, HttpEngine httpEngine);

    public static void initializeInstanceForTests() {
        new OkHttpClient();
    }
}

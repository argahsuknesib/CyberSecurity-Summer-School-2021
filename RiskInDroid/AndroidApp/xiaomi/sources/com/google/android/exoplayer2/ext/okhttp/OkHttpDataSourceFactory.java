package com.google.android.exoplayer2.ext.okhttp;

import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.TransferListener;
import okhttp3.CacheControl;
import okhttp3.Call;

public final class OkHttpDataSourceFactory extends HttpDataSource.BaseFactory {
    private final CacheControl cacheControl;
    private final Call.Factory callFactory;
    private final TransferListener listener;
    private final String userAgent;

    public OkHttpDataSourceFactory(Call.Factory factory, String str) {
        this(factory, str, null, null);
    }

    public OkHttpDataSourceFactory(Call.Factory factory, String str, CacheControl cacheControl2) {
        this(factory, str, null, cacheControl2);
    }

    public OkHttpDataSourceFactory(Call.Factory factory, String str, TransferListener transferListener) {
        this(factory, str, transferListener, null);
    }

    public OkHttpDataSourceFactory(Call.Factory factory, String str, TransferListener transferListener, CacheControl cacheControl2) {
        this.callFactory = factory;
        this.userAgent = str;
        this.listener = transferListener;
        this.cacheControl = cacheControl2;
    }

    /* access modifiers changed from: protected */
    public final OkHttpDataSource createDataSourceInternal(HttpDataSource.RequestProperties requestProperties) {
        OkHttpDataSource okHttpDataSource = new OkHttpDataSource(this.callFactory, this.userAgent, this.cacheControl, requestProperties);
        TransferListener transferListener = this.listener;
        if (transferListener != null) {
            okHttpDataSource.addTransferListener(transferListener);
        }
        return okHttpDataSource;
    }
}

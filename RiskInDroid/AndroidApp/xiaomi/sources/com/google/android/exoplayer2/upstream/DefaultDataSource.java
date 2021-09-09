package com.google.android.exoplayer2.upstream;

import android.content.Context;
import android.net.Uri;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class DefaultDataSource implements DataSource {
    private DataSource assetDataSource;
    private final DataSource baseDataSource;
    private DataSource contentDataSource;
    private final Context context;
    private DataSource dataSchemeDataSource;
    private DataSource dataSource;
    private DataSource fileDataSource;
    private DataSource rawResourceDataSource;
    private DataSource rtmpDataSource;
    private final List<TransferListener> transferListeners;
    private DataSource udpDataSource;

    public DefaultDataSource(Context context2, String str, boolean z) {
        this(context2, str, 8000, 8000, z);
    }

    public DefaultDataSource(Context context2, String str, int i, int i2, boolean z) {
        this(context2, new DefaultHttpDataSource(str, i, i2, z, null));
    }

    public DefaultDataSource(Context context2, DataSource dataSource2) {
        this.context = context2.getApplicationContext();
        this.baseDataSource = (DataSource) Assertions.checkNotNull(dataSource2);
        this.transferListeners = new ArrayList();
    }

    public final void addTransferListener(TransferListener transferListener) {
        this.baseDataSource.addTransferListener(transferListener);
        this.transferListeners.add(transferListener);
        maybeAddListenerToDataSource(this.fileDataSource, transferListener);
        maybeAddListenerToDataSource(this.assetDataSource, transferListener);
        maybeAddListenerToDataSource(this.contentDataSource, transferListener);
        maybeAddListenerToDataSource(this.rtmpDataSource, transferListener);
        maybeAddListenerToDataSource(this.udpDataSource, transferListener);
        maybeAddListenerToDataSource(this.dataSchemeDataSource, transferListener);
        maybeAddListenerToDataSource(this.rawResourceDataSource, transferListener);
    }

    public final long open(DataSpec dataSpec) throws IOException {
        Assertions.checkState(this.dataSource == null);
        String scheme = dataSpec.uri.getScheme();
        if (Util.isLocalFileUri(dataSpec.uri)) {
            String path = dataSpec.uri.getPath();
            if (path == null || !path.startsWith("/android_asset/")) {
                this.dataSource = getFileDataSource();
            } else {
                this.dataSource = getAssetDataSource();
            }
        } else if ("asset".equals(scheme)) {
            this.dataSource = getAssetDataSource();
        } else if ("content".equals(scheme)) {
            this.dataSource = getContentDataSource();
        } else if ("rtmp".equals(scheme)) {
            this.dataSource = getRtmpDataSource();
        } else if ("udp".equals(scheme)) {
            this.dataSource = getUdpDataSource();
        } else if ("data".equals(scheme)) {
            this.dataSource = getDataSchemeDataSource();
        } else if ("rawresource".equals(scheme)) {
            this.dataSource = getRawResourceDataSource();
        } else {
            this.dataSource = this.baseDataSource;
        }
        return this.dataSource.open(dataSpec);
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        return ((DataSource) Assertions.checkNotNull(this.dataSource)).read(bArr, i, i2);
    }

    public final Uri getUri() {
        DataSource dataSource2 = this.dataSource;
        if (dataSource2 == null) {
            return null;
        }
        return dataSource2.getUri();
    }

    public final Map<String, List<String>> getResponseHeaders() {
        DataSource dataSource2 = this.dataSource;
        return dataSource2 == null ? Collections.emptyMap() : dataSource2.getResponseHeaders();
    }

    public final void close() throws IOException {
        DataSource dataSource2 = this.dataSource;
        if (dataSource2 != null) {
            try {
                dataSource2.close();
            } finally {
                this.dataSource = null;
            }
        }
    }

    private DataSource getUdpDataSource() {
        if (this.udpDataSource == null) {
            this.udpDataSource = new UdpDataSource();
            addListenersToDataSource(this.udpDataSource);
        }
        return this.udpDataSource;
    }

    private DataSource getFileDataSource() {
        if (this.fileDataSource == null) {
            this.fileDataSource = new FileDataSource();
            addListenersToDataSource(this.fileDataSource);
        }
        return this.fileDataSource;
    }

    private DataSource getAssetDataSource() {
        if (this.assetDataSource == null) {
            this.assetDataSource = new AssetDataSource(this.context);
            addListenersToDataSource(this.assetDataSource);
        }
        return this.assetDataSource;
    }

    private DataSource getContentDataSource() {
        if (this.contentDataSource == null) {
            this.contentDataSource = new ContentDataSource(this.context);
            addListenersToDataSource(this.contentDataSource);
        }
        return this.contentDataSource;
    }

    private DataSource getRtmpDataSource() {
        if (this.rtmpDataSource == null) {
            try {
                this.rtmpDataSource = (DataSource) Class.forName("com.google.android.exoplayer2.ext.rtmp.RtmpDataSource").getConstructor(new Class[0]).newInstance(new Object[0]);
                addListenersToDataSource(this.rtmpDataSource);
            } catch (ClassNotFoundException unused) {
                Log.w("DefaultDataSource", "Attempting to play RTMP stream without depending on the RTMP extension");
            } catch (Exception e) {
                throw new RuntimeException("Error instantiating RTMP extension", e);
            }
            if (this.rtmpDataSource == null) {
                this.rtmpDataSource = this.baseDataSource;
            }
        }
        return this.rtmpDataSource;
    }

    private DataSource getDataSchemeDataSource() {
        if (this.dataSchemeDataSource == null) {
            this.dataSchemeDataSource = new DataSchemeDataSource();
            addListenersToDataSource(this.dataSchemeDataSource);
        }
        return this.dataSchemeDataSource;
    }

    private DataSource getRawResourceDataSource() {
        if (this.rawResourceDataSource == null) {
            this.rawResourceDataSource = new RawResourceDataSource(this.context);
            addListenersToDataSource(this.rawResourceDataSource);
        }
        return this.rawResourceDataSource;
    }

    private void addListenersToDataSource(DataSource dataSource2) {
        for (int i = 0; i < this.transferListeners.size(); i++) {
            dataSource2.addTransferListener(this.transferListeners.get(i));
        }
    }

    private void maybeAddListenerToDataSource(DataSource dataSource2, TransferListener transferListener) {
        if (dataSource2 != null) {
            dataSource2.addTransferListener(transferListener);
        }
    }
}

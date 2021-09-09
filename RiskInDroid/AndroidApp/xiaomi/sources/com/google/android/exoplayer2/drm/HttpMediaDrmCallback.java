package com.google.android.exoplayer2.drm;

import android.text.TextUtils;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.drm.ExoMediaDrm;
import com.google.android.exoplayer2.upstream.DataSourceInputStream;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public final class HttpMediaDrmCallback implements MediaDrmCallback {
    private final HttpDataSource.Factory dataSourceFactory;
    private final String defaultLicenseUrl;
    private final boolean forceDefaultLicenseUrl;
    private final Map<String, String> keyRequestProperties;

    public HttpMediaDrmCallback(String str, HttpDataSource.Factory factory) {
        this(str, false, factory);
    }

    public HttpMediaDrmCallback(String str, boolean z, HttpDataSource.Factory factory) {
        this.dataSourceFactory = factory;
        this.defaultLicenseUrl = str;
        this.forceDefaultLicenseUrl = z;
        this.keyRequestProperties = new HashMap();
    }

    public final void setKeyRequestProperty(String str, String str2) {
        Assertions.checkNotNull(str);
        Assertions.checkNotNull(str2);
        synchronized (this.keyRequestProperties) {
            this.keyRequestProperties.put(str, str2);
        }
    }

    public final void clearKeyRequestProperty(String str) {
        Assertions.checkNotNull(str);
        synchronized (this.keyRequestProperties) {
            this.keyRequestProperties.remove(str);
        }
    }

    public final void clearAllKeyRequestProperties() {
        synchronized (this.keyRequestProperties) {
            this.keyRequestProperties.clear();
        }
    }

    public final byte[] executeProvisionRequest(UUID uuid, ExoMediaDrm.ProvisionRequest provisionRequest) throws IOException {
        return executePost(this.dataSourceFactory, provisionRequest.getDefaultUrl() + "&signedRequest=" + Util.fromUtf8Bytes(provisionRequest.getData()), null, null);
    }

    public final byte[] executeKeyRequest(UUID uuid, ExoMediaDrm.KeyRequest keyRequest) throws Exception {
        String str;
        String licenseServerUrl = keyRequest.getLicenseServerUrl();
        if (this.forceDefaultLicenseUrl || TextUtils.isEmpty(licenseServerUrl)) {
            licenseServerUrl = this.defaultLicenseUrl;
        }
        HashMap hashMap = new HashMap();
        if (C.PLAYREADY_UUID.equals(uuid)) {
            str = "text/xml";
        } else {
            str = C.CLEARKEY_UUID.equals(uuid) ? "application/json" : "application/octet-stream";
        }
        hashMap.put("Content-Type", str);
        if (C.PLAYREADY_UUID.equals(uuid)) {
            hashMap.put("SOAPAction", "http://schemas.microsoft.com/DRM/2007/03/protocols/AcquireLicense");
        }
        synchronized (this.keyRequestProperties) {
            hashMap.putAll(this.keyRequestProperties);
        }
        return executePost(this.dataSourceFactory, licenseServerUrl, keyRequest.getData(), hashMap);
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x006e A[Catch:{ InvalidResponseCodeException -> 0x0056, all -> 0x0054 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0076 A[LOOP:1: B:7:0x002c->B:28:0x0076, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x007b A[EDGE_INSN: B:29:0x007b->B:30:? ?: BREAK  , SYNTHETIC, Splitter:B:29:0x007b] */
    private static byte[] executePost(HttpDataSource.Factory factory, String str, byte[] bArr, Map<String, String> map) throws IOException {
        String redirectUrl;
        HttpDataSource createDataSource = factory.createDataSource();
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                createDataSource.setRequestProperty((String) next.getKey(), (String) next.getValue());
            }
        }
        int i = 0;
        while (true) {
            boolean z = true;
            DataSourceInputStream dataSourceInputStream = new DataSourceInputStream(createDataSource, new DataSpec.Builder().setUri(str).setHttpMethod(2).setHttpBody(bArr).setFlags(1).build());
            try {
                byte[] byteArray = Util.toByteArray(dataSourceInputStream);
                Util.closeQuietly(dataSourceInputStream);
                return byteArray;
            } catch (HttpDataSource.InvalidResponseCodeException e) {
                if (e.responseCode == 307 || e.responseCode == 308) {
                    int i2 = i + 1;
                    if (i < 5) {
                        i = i2;
                        redirectUrl = !z ? getRedirectUrl(e) : null;
                        if (redirectUrl == null) {
                            Util.closeQuietly(dataSourceInputStream);
                            str = redirectUrl;
                        } else {
                            throw e;
                        }
                    } else {
                        i = i2;
                    }
                }
                z = false;
                if (!z) {
                }
                if (redirectUrl == null) {
                }
            } catch (Throwable th) {
                Util.closeQuietly(dataSourceInputStream);
                throw th;
            }
        }
    }

    private static String getRedirectUrl(HttpDataSource.InvalidResponseCodeException invalidResponseCodeException) {
        List list;
        Map<String, List<String>> map = invalidResponseCodeException.headerFields;
        if (map == null || (list = map.get("Location")) == null || list.isEmpty()) {
            return null;
        }
        return (String) list.get(0);
    }
}

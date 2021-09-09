package com.google.android.exoplayer2.upstream;

import android.text.TextUtils;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.util.Predicate;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface HttpDataSource extends DataSource {
    public static final Predicate<String> REJECT_PAYWALL_TYPES = $$Lambda$HttpDataSource$fzi4cgBB9tTB1JUdq8hmlAPFIw.INSTANCE;

    public interface Factory extends DataSource.Factory {

        /* renamed from: com.google.android.exoplayer2.upstream.HttpDataSource$Factory$-CC  reason: invalid class name */
        public final /* synthetic */ class CC {
        }

        @Deprecated
        void clearAllDefaultRequestProperties();

        @Deprecated
        void clearDefaultRequestProperty(String str);

        HttpDataSource createDataSource();

        RequestProperties getDefaultRequestProperties();

        @Deprecated
        void setDefaultRequestProperty(String str, String str2);
    }

    void clearAllRequestProperties();

    void clearRequestProperty(String str);

    void close() throws HttpDataSourceException;

    int getResponseCode();

    Map<String, List<String>> getResponseHeaders();

    long open(DataSpec dataSpec) throws HttpDataSourceException;

    int read(byte[] bArr, int i, int i2) throws HttpDataSourceException;

    void setRequestProperty(String str, String str2);

    public static final class RequestProperties {
        private final Map<String, String> requestProperties = new HashMap();
        private Map<String, String> requestPropertiesSnapshot;

        public final synchronized void set(String str, String str2) {
            this.requestPropertiesSnapshot = null;
            this.requestProperties.put(str, str2);
        }

        public final synchronized void set(Map<String, String> map) {
            this.requestPropertiesSnapshot = null;
            this.requestProperties.putAll(map);
        }

        public final synchronized void clearAndSet(Map<String, String> map) {
            this.requestPropertiesSnapshot = null;
            this.requestProperties.clear();
            this.requestProperties.putAll(map);
        }

        public final synchronized void remove(String str) {
            this.requestPropertiesSnapshot = null;
            this.requestProperties.remove(str);
        }

        public final synchronized void clear() {
            this.requestPropertiesSnapshot = null;
            this.requestProperties.clear();
        }

        public final synchronized Map<String, String> getSnapshot() {
            if (this.requestPropertiesSnapshot == null) {
                this.requestPropertiesSnapshot = Collections.unmodifiableMap(new HashMap(this.requestProperties));
            }
            return this.requestPropertiesSnapshot;
        }
    }

    public static abstract class BaseFactory implements Factory {
        private final RequestProperties defaultRequestProperties = new RequestProperties();

        /* access modifiers changed from: protected */
        public abstract HttpDataSource createDataSourceInternal(RequestProperties requestProperties);

        public final HttpDataSource createDataSource() {
            return createDataSourceInternal(this.defaultRequestProperties);
        }

        public final RequestProperties getDefaultRequestProperties() {
            return this.defaultRequestProperties;
        }

        @Deprecated
        public final void setDefaultRequestProperty(String str, String str2) {
            this.defaultRequestProperties.set(str, str2);
        }

        @Deprecated
        public final void clearDefaultRequestProperty(String str) {
            this.defaultRequestProperties.remove(str);
        }

        @Deprecated
        public final void clearAllDefaultRequestProperties() {
            this.defaultRequestProperties.clear();
        }
    }

    /* renamed from: com.google.android.exoplayer2.upstream.HttpDataSource$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static /* synthetic */ boolean lambda$static$0(String str) {
            String lowerInvariant = Util.toLowerInvariant(str);
            if (!TextUtils.isEmpty(lowerInvariant)) {
                return (!lowerInvariant.contains("text") || lowerInvariant.contains("text/vtt")) && !lowerInvariant.contains("html") && !lowerInvariant.contains("xml");
            }
            return false;
        }
    }

    public static class HttpDataSourceException extends IOException {
        public final DataSpec dataSpec;
        public final int type;

        @Documented
        @Retention(RetentionPolicy.SOURCE)
        public @interface Type {
        }

        public HttpDataSourceException(DataSpec dataSpec2, int i) {
            this.dataSpec = dataSpec2;
            this.type = i;
        }

        public HttpDataSourceException(String str, DataSpec dataSpec2, int i) {
            super(str);
            this.dataSpec = dataSpec2;
            this.type = i;
        }

        public HttpDataSourceException(IOException iOException, DataSpec dataSpec2, int i) {
            super(iOException);
            this.dataSpec = dataSpec2;
            this.type = i;
        }

        public HttpDataSourceException(String str, IOException iOException, DataSpec dataSpec2, int i) {
            super(str, iOException);
            this.dataSpec = dataSpec2;
            this.type = i;
        }
    }

    public static final class InvalidContentTypeException extends HttpDataSourceException {
        public final String contentType;

        public InvalidContentTypeException(String str, DataSpec dataSpec) {
            super("Invalid content type: ".concat(String.valueOf(str)), dataSpec, 1);
            this.contentType = str;
        }
    }

    public static final class InvalidResponseCodeException extends HttpDataSourceException {
        public final Map<String, List<String>> headerFields;
        public final int responseCode;
        public final String responseMessage;

        @Deprecated
        public InvalidResponseCodeException(int i, Map<String, List<String>> map, DataSpec dataSpec) {
            this(i, null, map, dataSpec);
        }

        public InvalidResponseCodeException(int i, String str, Map<String, List<String>> map, DataSpec dataSpec) {
            super("Response code: ".concat(String.valueOf(i)), dataSpec, 1);
            this.responseCode = i;
            this.responseMessage = str;
            this.headerFields = map;
        }
    }
}

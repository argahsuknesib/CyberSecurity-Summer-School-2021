package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import com.google.android.exoplayer2.util.Assertions;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class DataSpec {
    @Deprecated
    public final long absoluteStreamPosition;
    public final Object customData;
    public final int flags;
    public final byte[] httpBody;
    public final int httpMethod;
    public final Map<String, String> httpRequestHeaders;
    public final String key;
    public final long length;
    public final long position;
    public final Uri uri;
    public final long uriPositionOffset;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface HttpMethod {
    }

    public static final class Builder {
        private Object customData;
        private int flags;
        private byte[] httpBody;
        private int httpMethod;
        private Map<String, String> httpRequestHeaders;
        private String key;
        private long length;
        private long position;
        private Uri uri;
        private long uriPositionOffset;

        public Builder() {
            this.httpMethod = 1;
            this.httpRequestHeaders = Collections.emptyMap();
            this.length = -1;
        }

        private Builder(DataSpec dataSpec) {
            this.uri = dataSpec.uri;
            this.uriPositionOffset = dataSpec.uriPositionOffset;
            this.httpMethod = dataSpec.httpMethod;
            this.httpBody = dataSpec.httpBody;
            this.httpRequestHeaders = dataSpec.httpRequestHeaders;
            this.position = dataSpec.position;
            this.length = dataSpec.length;
            this.key = dataSpec.key;
            this.flags = dataSpec.flags;
            this.customData = dataSpec.customData;
        }

        public final Builder setUri(String str) {
            this.uri = Uri.parse(str);
            return this;
        }

        public final Builder setUri(Uri uri2) {
            this.uri = uri2;
            return this;
        }

        public final Builder setUriPositionOffset(long j) {
            this.uriPositionOffset = j;
            return this;
        }

        public final Builder setHttpMethod(int i) {
            this.httpMethod = i;
            return this;
        }

        public final Builder setHttpBody(byte[] bArr) {
            this.httpBody = bArr;
            return this;
        }

        public final Builder setHttpRequestHeaders(Map<String, String> map) {
            this.httpRequestHeaders = map;
            return this;
        }

        public final Builder setPosition(long j) {
            this.position = j;
            return this;
        }

        public final Builder setLength(long j) {
            this.length = j;
            return this;
        }

        public final Builder setKey(String str) {
            this.key = str;
            return this;
        }

        public final Builder setFlags(int i) {
            this.flags = i;
            return this;
        }

        public final Builder setCustomData(Object obj) {
            this.customData = obj;
            return this;
        }

        public final DataSpec build() {
            Assertions.checkStateNotNull(this.uri, "The uri must be set.");
            return new DataSpec(this.uri, this.uriPositionOffset, this.httpMethod, this.httpBody, this.httpRequestHeaders, this.position, this.length, this.key, this.flags, this.customData);
        }
    }

    public static String getStringForHttpMethod(int i) {
        if (i == 1) {
            return "GET";
        }
        if (i == 2) {
            return "POST";
        }
        if (i == 3) {
            return "HEAD";
        }
        throw new IllegalStateException();
    }

    public DataSpec(Uri uri2) {
        this(uri2, 0, -1);
    }

    public DataSpec(Uri uri2, long j, long j2) {
        this(uri2, 0, 1, null, Collections.emptyMap(), j, j2, null, 0, null);
    }

    @Deprecated
    public DataSpec(Uri uri2, int i) {
        this(uri2, 0, -1, null, i);
    }

    @Deprecated
    public DataSpec(Uri uri2, long j, long j2, String str) {
        this(uri2, j, j, j2, str, 0);
    }

    @Deprecated
    public DataSpec(Uri uri2, long j, long j2, String str, int i) {
        this(uri2, j, j, j2, str, i);
    }

    @Deprecated
    public DataSpec(Uri uri2, long j, long j2, String str, int i, Map<String, String> map) {
        this(uri2, 1, null, j, j, j2, str, i, map);
    }

    @Deprecated
    public DataSpec(Uri uri2, long j, long j2, long j3, String str, int i) {
        this(uri2, null, j, j2, j3, str, i);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @Deprecated
    public DataSpec(Uri uri2, byte[] bArr, long j, long j2, long j3, String str, int i) {
        this(uri2, bArr != null ? 2 : 1, bArr, j, j2, j3, str, i);
    }

    @Deprecated
    public DataSpec(Uri uri2, int i, byte[] bArr, long j, long j2, long j3, String str, int i2) {
        this(uri2, i, bArr, j, j2, j3, str, i2, Collections.emptyMap());
    }

    @Deprecated
    public DataSpec(Uri uri2, int i, byte[] bArr, long j, long j2, long j3, String str, int i2, Map<String, String> map) {
        this(uri2, j - j2, i, bArr, map, j2, j3, str, i2, null);
    }

    private DataSpec(Uri uri2, long j, int i, byte[] bArr, Map<String, String> map, long j2, long j3, String str, int i2, Object obj) {
        long j4 = j;
        byte[] bArr2 = bArr;
        long j5 = j2;
        long j6 = j3;
        long j7 = j4 + j5;
        boolean z = true;
        Assertions.checkArgument(j7 >= 0);
        Assertions.checkArgument(j5 >= 0);
        if (j6 <= 0 && j6 != -1) {
            z = false;
        }
        Assertions.checkArgument(z);
        this.uri = uri2;
        this.uriPositionOffset = j4;
        this.httpMethod = i;
        this.httpBody = (bArr2 == null || bArr2.length == 0) ? null : bArr2;
        this.httpRequestHeaders = Collections.unmodifiableMap(new HashMap(map));
        this.position = j5;
        this.absoluteStreamPosition = j7;
        this.length = j6;
        this.key = str;
        this.flags = i2;
        this.customData = obj;
    }

    public final boolean isFlagSet(int i) {
        return (this.flags & i) == i;
    }

    public final String getHttpMethodString() {
        return getStringForHttpMethod(this.httpMethod);
    }

    public final Builder buildUpon() {
        return new Builder();
    }

    public final DataSpec subrange(long j) {
        long j2 = this.length;
        long j3 = -1;
        if (j2 != -1) {
            j3 = j2 - j;
        }
        return subrange(j, j3);
    }

    public final DataSpec subrange(long j, long j2) {
        if (j == 0 && this.length == j2) {
            return this;
        }
        return new DataSpec(this.uri, this.uriPositionOffset, this.httpMethod, this.httpBody, this.httpRequestHeaders, this.position + j, j2, this.key, this.flags, this.customData);
    }

    public final DataSpec withUri(Uri uri2) {
        return new DataSpec(uri2, this.uriPositionOffset, this.httpMethod, this.httpBody, this.httpRequestHeaders, this.position, this.length, this.key, this.flags, this.customData);
    }

    public final DataSpec withRequestHeaders(Map<String, String> map) {
        return new DataSpec(this.uri, this.uriPositionOffset, this.httpMethod, this.httpBody, map, this.position, this.length, this.key, this.flags, this.customData);
    }

    public final DataSpec withAdditionalHeaders(Map<String, String> map) {
        HashMap hashMap = new HashMap(this.httpRequestHeaders);
        hashMap.putAll(map);
        return new DataSpec(this.uri, this.uriPositionOffset, this.httpMethod, this.httpBody, hashMap, this.position, this.length, this.key, this.flags, this.customData);
    }

    public final String toString() {
        return "DataSpec[" + getHttpMethodString() + " " + this.uri + ", " + this.position + ", " + this.length + ", " + this.key + ", " + this.flags + "]";
    }
}

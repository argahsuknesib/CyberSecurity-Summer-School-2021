package com.android.volley;

import java.util.Collections;
import java.util.Map;
import org.apache.http.Header;

public class NetworkResponse {
    public Header[] allHeaders;
    public final byte[] data;
    public final Map<String, String> headers;
    public final boolean notModified;
    public final int statusCode;

    public NetworkResponse(int i, byte[] bArr, Map<String, String> map, boolean z) {
        this.statusCode = i;
        this.data = bArr;
        this.headers = map;
        this.notModified = z;
    }

    public NetworkResponse(byte[] bArr) {
        this(200, bArr, Collections.emptyMap(), false);
    }

    public NetworkResponse(byte[] bArr, Map<String, String> map) {
        this(200, bArr, map, false);
    }
}

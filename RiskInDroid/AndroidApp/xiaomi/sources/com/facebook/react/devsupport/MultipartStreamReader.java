package com.facebook.react.devsupport;

import _m_j.jax;
import _m_j.jaz;
import _m_j.jbm;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import okio.ByteString;

public class MultipartStreamReader {
    private final String mBoundary;
    private long mLastProgressEvent;
    private final jaz mSource;

    public interface ChunkListener {
        void onChunkComplete(Map<String, String> map, jax jax, boolean z) throws IOException;

        void onChunkProgress(Map<String, String> map, long j, long j2) throws IOException;
    }

    public MultipartStreamReader(jaz jaz, String str) {
        this.mSource = jaz;
        this.mBoundary = str;
    }

    private Map<String, String> parseHeaders(jax jax) {
        HashMap hashMap = new HashMap();
        for (String str : jax.O0000o().split("\r\n")) {
            int indexOf = str.indexOf(":");
            if (indexOf != -1) {
                hashMap.put(str.substring(0, indexOf).trim(), str.substring(indexOf + 1).trim());
            }
        }
        return hashMap;
    }

    private void emitChunk(jax jax, boolean z, ChunkListener chunkListener) throws IOException {
        ByteString O000000o2 = ByteString.O000000o("\r\n\r\n");
        long O000000o3 = jax.O000000o(O000000o2, 0);
        if (O000000o3 == -1) {
            chunkListener.onChunkComplete(null, jax, z);
            return;
        }
        jax jax2 = new jax();
        jax jax3 = new jax();
        jax.read(jax2, O000000o3);
        jax.O0000Oo0((long) O000000o2.O0000OOo());
        jax.O000000o((jbm) jax3);
        chunkListener.onChunkComplete(parseHeaders(jax2), jax3, z);
    }

    private void emitProgress(Map<String, String> map, long j, boolean z, ChunkListener chunkListener) throws IOException {
        if (map != null && chunkListener != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.mLastProgressEvent > 16 || z) {
                this.mLastProgressEvent = currentTimeMillis;
                chunkListener.onChunkProgress(map, j, map.get("Content-Length") != null ? Long.parseLong(map.get("Content-Length")) : 0);
            }
        }
    }

    public boolean readAllParts(ChunkListener chunkListener) throws IOException {
        boolean z;
        long j;
        ByteString O000000o2 = ByteString.O000000o("\r\n--" + this.mBoundary + "\r\n");
        ByteString O000000o3 = ByteString.O000000o("\r\n--" + this.mBoundary + "--\r\n");
        ByteString O000000o4 = ByteString.O000000o("\r\n\r\n");
        jax jax = new jax();
        long j2 = 0;
        long j3 = 0;
        long j4 = 0;
        Map<String, String> map = null;
        while (true) {
            long max = Math.max(j2 - ((long) O000000o3.O0000OOo()), j3);
            long O000000o5 = jax.O000000o(O000000o2, max);
            if (O000000o5 == -1) {
                O000000o5 = jax.O000000o(O000000o3, max);
                z = true;
            } else {
                z = false;
            }
            if (O000000o5 == -1) {
                long j5 = jax.O00000Oo;
                if (map == null) {
                    long O000000o6 = jax.O000000o(O000000o4, max);
                    if (O000000o6 >= 0) {
                        this.mSource.read(jax, O000000o6);
                        jax jax2 = new jax();
                        j = j5;
                        jax.O000000o(jax2, max, O000000o6 - max);
                        j4 = jax2.O00000Oo + ((long) O000000o4.O0000OOo());
                        map = parseHeaders(jax2);
                    } else {
                        j = j5;
                    }
                } else {
                    j = j5;
                    emitProgress(map, jax.O00000Oo - j4, false, chunkListener);
                }
                if (this.mSource.read(jax, 4096) <= 0) {
                    return false;
                }
                j2 = j;
            } else {
                long j6 = O000000o5 - j3;
                if (j3 > 0) {
                    jax jax3 = new jax();
                    jax.O0000Oo0(j3);
                    jax.read(jax3, j6);
                    emitProgress(map, jax3.O00000Oo - j4, true, chunkListener);
                    emitChunk(jax3, z, chunkListener);
                    j4 = 0;
                    map = null;
                } else {
                    jax.O0000Oo0(O000000o5);
                }
                if (z) {
                    return true;
                }
                j3 = (long) O000000o2.O0000OOo();
                j2 = j3;
            }
        }
    }
}

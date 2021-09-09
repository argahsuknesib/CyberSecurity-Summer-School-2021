package com.squareup.okhttp.internal.framed;

import _m_j.jaz;
import java.io.IOException;
import java.util.List;

public interface PushObserver {
    public static final PushObserver CANCEL = new PushObserver() {
        /* class com.squareup.okhttp.internal.framed.PushObserver.AnonymousClass1 */

        public final boolean onHeaders(int i, List<Header> list, boolean z) {
            return true;
        }

        public final boolean onRequest(int i, List<Header> list) {
            return true;
        }

        public final void onReset(int i, ErrorCode errorCode) {
        }

        public final boolean onData(int i, jaz jaz, int i2, boolean z) throws IOException {
            jaz.O0000Oo0((long) i2);
            return true;
        }
    };

    boolean onData(int i, jaz jaz, int i2, boolean z) throws IOException;

    boolean onHeaders(int i, List<Header> list, boolean z);

    boolean onRequest(int i, List<Header> list);

    void onReset(int i, ErrorCode errorCode);
}

package com.squareup.okhttp.internal.framed;

import java.io.IOException;

public interface IncomingStreamHandler {
    public static final IncomingStreamHandler REFUSE_INCOMING_STREAMS = new IncomingStreamHandler() {
        /* class com.squareup.okhttp.internal.framed.IncomingStreamHandler.AnonymousClass1 */

        public final void receive(FramedStream framedStream) throws IOException {
            framedStream.close(ErrorCode.REFUSED_STREAM);
        }
    };

    void receive(FramedStream framedStream) throws IOException;
}

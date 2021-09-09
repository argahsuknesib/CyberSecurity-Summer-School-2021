package org.mp4parser.streaming.input.h264;

import _m_j.jjs;
import _m_j.jjx;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class H264AnnexBTrack extends jjx implements Callable<Void> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private InputStream inputStream;

    public H264AnnexBTrack(InputStream inputStream2) throws IOException {
        this.inputStream = new BufferedInputStream(inputStream2);
    }

    public Void call() throws IOException, InterruptedException {
        byte[] byteArray;
        O00000Oo o00000Oo = new O00000Oo(this.inputStream);
        while (true) {
            if (O00000Oo.f15447O000000o.isLoggable(Level.FINEST)) {
                O00000Oo.f15447O000000o.finest("getNext() called");
            }
            while (true) {
                int read = o00000Oo.O00000o.read();
                if (read == -1) {
                    byteArray = o00000Oo.O00000Oo.toByteArray();
                    o00000Oo.O00000Oo.reset();
                    if (byteArray.length <= 0) {
                        byteArray = null;
                    }
                } else if (o00000Oo.O00000o0 == 2 && read == 3) {
                    o00000Oo.O00000o0 = 0;
                } else {
                    o00000Oo.O00000Oo.write(read);
                    if (o00000Oo.O00000o0 == 0 && read == 0) {
                        o00000Oo.O00000o0 = 1;
                    } else if (o00000Oo.O00000o0 == 1 && read == 0) {
                        o00000Oo.O00000o0 = 2;
                    } else if (o00000Oo.O00000o0 == 2 && read == 0) {
                        byteArray = o00000Oo.O00000Oo.O000000o();
                        o00000Oo.O00000Oo.reset();
                        if (byteArray != null) {
                            break;
                        }
                    } else if (o00000Oo.O00000o0 == 2 && read == 1) {
                        byteArray = o00000Oo.O00000Oo.O000000o();
                        o00000Oo.O00000Oo.reset();
                        o00000Oo.O00000o0 = 0;
                        if (byteArray != null) {
                            break;
                        }
                    } else if (o00000Oo.O00000o0 != 0) {
                        o00000Oo.O00000o0 = 0;
                    }
                }
            }
            if (byteArray != null) {
                consumeNal(ByteBuffer.wrap(byteArray));
            } else {
                pushSample(createSample(this.buffered, this.fvnd.f1889O000000o, this.sliceNalUnitHeader), true, true);
                return null;
            }
        }
    }

    public String toString() {
        jjs jjs = (jjs) getTrackExtension(jjs.class);
        if (jjs == null) {
            return "H264AnnexBTrack{}";
        }
        return "H264AnnexBTrack{trackId=" + jjs.f1886O000000o + "}";
    }

    public static class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        static final Logger f15447O000000o = Logger.getLogger(O00000Oo.class.getName());
        O000000o O00000Oo = new O000000o();
        InputStream O00000o;
        int O00000o0 = 0;

        public O00000Oo(InputStream inputStream) {
            this.O00000o = inputStream;
        }
    }

    static class O000000o extends ByteArrayOutputStream {
        O000000o() {
        }

        public final byte[] O000000o() {
            if (this.count <= 3) {
                return null;
            }
            return Arrays.copyOf(this.buf, this.count - 3 > 0 ? this.count - 3 : 0);
        }
    }
}

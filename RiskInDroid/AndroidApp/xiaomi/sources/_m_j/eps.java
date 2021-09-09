package _m_j;

import android.support.v4.app.NotificationCompat;
import com.xiaomi.push.service.bi;
import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.zip.Adler32;

final class eps {

    /* renamed from: O000000o  reason: collision with root package name */
    epv f15710O000000o;
    epx O00000Oo;
    byte[] O00000o;
    volatile boolean O00000o0;
    private ByteBuffer O00000oO = ByteBuffer.allocate(2048);
    private ByteBuffer O00000oo = ByteBuffer.allocate(4);
    private Adler32 O0000O0o = new Adler32();
    private InputStream O0000OOo;

    eps(InputStream inputStream, epx epx) {
        this.O0000OOo = new BufferedInputStream(inputStream);
        this.O00000Oo = epx;
        this.f15710O000000o = new epv();
    }

    private void O000000o(ByteBuffer byteBuffer, int i) {
        int position = byteBuffer.position();
        do {
            int read = this.O0000OOo.read(byteBuffer.array(), position, i);
            if (read != -1) {
                i -= read;
                position += read;
            } else {
                throw new EOFException();
            }
        } while (i > 0);
        byteBuffer.position(position);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00be A[Catch:{ IOException -> 0x0151 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0119 A[Catch:{ IOException -> 0x0151 }] */
    public final epq O000000o() {
        int i;
        ByteBuffer allocate;
        int i2 = 0;
        try {
            this.O00000oO.clear();
            O000000o(this.O00000oO, 8);
            short s = this.O00000oO.getShort(0);
            short s2 = this.O00000oO.getShort(2);
            if (s == -15618 && s2 == 5) {
                int i3 = this.O00000oO.getInt(4);
                int position = this.O00000oO.position();
                if (i3 <= 32768) {
                    if (i3 + 4 > this.O00000oO.remaining()) {
                        allocate = ByteBuffer.allocate(i3 + 2048);
                        allocate.put(this.O00000oO.array(), 0, this.O00000oO.arrayOffset() + this.O00000oO.position());
                    } else {
                        if (this.O00000oO.capacity() > 4096 && i3 < 2048) {
                            allocate = ByteBuffer.allocate(2048);
                            allocate.put(this.O00000oO.array(), 0, this.O00000oO.arrayOffset() + this.O00000oO.position());
                        }
                        O000000o(this.O00000oO, i3);
                        this.O00000oo.clear();
                        O000000o(this.O00000oo, 4);
                        this.O00000oo.position(0);
                        i = this.O00000oo.getInt();
                        this.O0000O0o.reset();
                        this.O0000O0o.update(this.O00000oO.array(), 0, this.O00000oO.position());
                        if (i != ((int) this.O0000O0o.getValue())) {
                            if (this.O00000o != null) {
                                bi.a(this.O00000o, this.O00000oO.array(), true, position, i3);
                            }
                            ByteBuffer byteBuffer = this.O00000oO;
                            int position2 = byteBuffer.position();
                            byteBuffer.flip();
                            byteBuffer.position(8);
                            epq epw = position2 == 8 ? new epw() : epq.O00000Oo(byteBuffer.slice());
                            duv.O00000o0("[Slim] Read {cmd=" + epw.f15708O000000o.O00000oo + ";chid=" + epw.f15708O000000o.f15684O000000o + ";len=" + position2 + "}");
                            return epw;
                        }
                        duv.O000000o("CRC = " + ((int) this.O0000O0o.getValue()) + " and " + i);
                        throw new IOException("Corrupted Blob bad CRC");
                    }
                    this.O00000oO = allocate;
                    O000000o(this.O00000oO, i3);
                    this.O00000oo.clear();
                    O000000o(this.O00000oo, 4);
                    this.O00000oo.position(0);
                    i = this.O00000oo.getInt();
                    this.O0000O0o.reset();
                    this.O0000O0o.update(this.O00000oO.array(), 0, this.O00000oO.position());
                    if (i != ((int) this.O0000O0o.getValue())) {
                    }
                } else {
                    throw new IOException("Blob size too large");
                }
            } else {
                throw new IOException("Malformed Input");
            }
        } catch (IOException e) {
            if (0 == 0) {
                i2 = this.O00000oO.position();
            }
            StringBuilder sb = new StringBuilder("[Slim] read Blob [");
            byte[] array = this.O00000oO.array();
            if (i2 > 128) {
                i2 = NotificationCompat.FLAG_HIGH_PRIORITY;
            }
            sb.append(ell.O000000o(array, i2));
            sb.append("] Err:");
            sb.append(e.getMessage());
            duv.O000000o(sb.toString());
            throw e;
        }
    }
}

package _m_j;

import com.xiaomi.push.service.bi;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.TimeZone;
import java.util.zip.Adler32;

public final class ept {

    /* renamed from: O000000o  reason: collision with root package name */
    ByteBuffer f15711O000000o = ByteBuffer.allocate(2048);
    epx O00000Oo;
    int O00000o;
    OutputStream O00000o0;
    int O00000oO;
    private ByteBuffer O00000oo = ByteBuffer.allocate(4);
    private Adler32 O0000O0o = new Adler32();
    private byte[] O0000OOo;

    ept(OutputStream outputStream, epx epx) {
        this.O00000o0 = new BufferedOutputStream(outputStream);
        this.O00000Oo = epx;
        TimeZone timeZone = TimeZone.getDefault();
        this.O00000o = timeZone.getRawOffset() / 3600000;
        this.O00000oO = timeZone.useDaylightTime() ? 1 : 0;
    }

    public final int O000000o(epq epq) {
        int O00000o2 = epq.O00000o();
        if (O00000o2 > 32768) {
            duv.O000000o("Blob size=" + O00000o2 + " should be less than 32768 Drop blob chid=" + epq.f15708O000000o.f15684O000000o + " id=" + epq.O000000o());
            return 0;
        }
        this.f15711O000000o.clear();
        int i = O00000o2 + 8 + 4;
        if (i > this.f15711O000000o.capacity() || this.f15711O000000o.capacity() > 4096) {
            this.f15711O000000o = ByteBuffer.allocate(i);
        }
        this.f15711O000000o.putShort(-15618);
        this.f15711O000000o.putShort(5);
        this.f15711O000000o.putInt(O00000o2);
        int position = this.f15711O000000o.position();
        this.f15711O000000o = epq.O000000o(this.f15711O000000o);
        if (!"CONN".equals(epq.f15708O000000o.O00000oo)) {
            if (this.O0000OOo == null) {
                this.O0000OOo = this.O00000Oo.O000000o();
            }
            bi.a(this.O0000OOo, this.f15711O000000o.array(), true, position, O00000o2);
        }
        this.O0000O0o.reset();
        this.O0000O0o.update(this.f15711O000000o.array(), 0, this.f15711O000000o.position());
        this.O00000oo.putInt(0, (int) this.O0000O0o.getValue());
        this.O00000o0.write(this.f15711O000000o.array(), 0, this.f15711O000000o.position());
        this.O00000o0.write(this.O00000oo.array(), 0, 4);
        this.O00000o0.flush();
        int position2 = this.f15711O000000o.position() + 4;
        duv.O00000o0("[Slim] Wrote {cmd=" + epq.f15708O000000o.O00000oo + ";chid=" + epq.f15708O000000o.f15684O000000o + ";len=" + position2 + "}");
        return position2;
    }
}

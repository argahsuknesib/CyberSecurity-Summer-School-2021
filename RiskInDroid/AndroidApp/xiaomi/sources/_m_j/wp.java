package _m_j;

import com.drew.imaging.png.PngProcessingException;
import java.io.IOException;

public final class wp {

    /* renamed from: O000000o  reason: collision with root package name */
    final int f2580O000000o;
    final int O00000Oo;
    final int O00000o;
    final int O00000o0;
    final int O00000oO;
    final int O00000oo;
    final int O0000O0o;
    final int O0000OOo;

    public wp(byte[] bArr) throws PngProcessingException {
        if (bArr.length == 32) {
            xl xlVar = new xl(bArr);
            try {
                this.f2580O000000o = xlVar.O0000OOo();
                this.O00000Oo = xlVar.O0000OOo();
                this.O00000o0 = xlVar.O0000OOo();
                this.O00000o = xlVar.O0000OOo();
                this.O00000oO = xlVar.O0000OOo();
                this.O00000oo = xlVar.O0000OOo();
                this.O0000O0o = xlVar.O0000OOo();
                this.O0000OOo = xlVar.O0000OOo();
            } catch (IOException e) {
                throw new PngProcessingException(e);
            }
        } else {
            throw new PngProcessingException("Invalid number of bytes");
        }
    }
}

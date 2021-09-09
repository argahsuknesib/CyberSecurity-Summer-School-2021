package _m_j;

import com.drew.imaging.png.PngColorType;
import com.drew.imaging.png.PngProcessingException;
import java.io.IOException;

public final class wt {

    /* renamed from: O000000o  reason: collision with root package name */
    int f2584O000000o;
    int O00000Oo;
    PngColorType O00000o;
    byte O00000o0;
    byte O00000oO;
    byte O00000oo;
    byte O0000O0o;

    public wt(byte[] bArr) throws PngProcessingException {
        if (bArr.length == 13) {
            xl xlVar = new xl(bArr);
            try {
                this.f2584O000000o = xlVar.O0000OOo();
                this.O00000Oo = xlVar.O0000OOo();
                this.O00000o0 = xlVar.O00000Oo();
                byte O00000Oo2 = xlVar.O00000Oo();
                PngColorType fromNumericValue = PngColorType.fromNumericValue(O00000Oo2);
                if (fromNumericValue != null) {
                    this.O00000o = fromNumericValue;
                    this.O00000oO = xlVar.O00000Oo();
                    this.O00000oo = xlVar.O00000Oo();
                    this.O0000O0o = xlVar.O00000Oo();
                    return;
                }
                throw new PngProcessingException("Unexpected PNG color type: ".concat(String.valueOf((int) O00000Oo2)));
            } catch (IOException e) {
                throw new PngProcessingException(e);
            }
        } else {
            throw new PngProcessingException("PNG header chunk must have 13 data bytes");
        }
    }
}

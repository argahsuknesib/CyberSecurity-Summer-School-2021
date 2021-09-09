package _m_j;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public final class bto extends btp {
    public bto() {
    }

    public bto(btp btp) {
        super(btp);
    }

    /* access modifiers changed from: protected */
    public final byte[] O000000o(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(new SimpleDateFormat("yyyyMMdd HHmmss").format(new Date()));
        stringBuffer.append(" ");
        stringBuffer.append(UUID.randomUUID().toString());
        stringBuffer.append(" ");
        if (stringBuffer.length() != 53) {
            return new byte[0];
        }
        byte[] O000000o2 = brs.O000000o(stringBuffer.toString());
        byte[] bArr2 = new byte[(O000000o2.length + bArr.length)];
        System.arraycopy(O000000o2, 0, bArr2, 0, O000000o2.length);
        System.arraycopy(bArr, 0, bArr2, O000000o2.length, bArr.length);
        return bArr2;
    }
}

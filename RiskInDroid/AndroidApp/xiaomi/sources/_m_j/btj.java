package _m_j;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public final class btj extends btp {

    /* renamed from: O000000o  reason: collision with root package name */
    ByteArrayOutputStream f13271O000000o = new ByteArrayOutputStream();

    public btj() {
    }

    public btj(btp btp) {
        super(btp);
    }

    /* access modifiers changed from: protected */
    public final byte[] O000000o(byte[] bArr) {
        byte[] byteArray = this.f13271O000000o.toByteArray();
        try {
            this.f13271O000000o.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.f13271O000000o = new ByteArrayOutputStream();
        return byteArray;
    }

    public final void O00000Oo(byte[] bArr) {
        try {
            this.f13271O000000o.write(bArr);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}

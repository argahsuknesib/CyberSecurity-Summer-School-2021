package _m_j;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public abstract class brw {

    /* renamed from: O000000o  reason: collision with root package name */
    brw f13226O000000o;

    brw() {
    }

    brw(brw brw) {
        this.f13226O000000o = brw;
    }

    /* access modifiers changed from: protected */
    public abstract byte[] O000000o(byte[] bArr) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException;

    public final byte[] O00000Oo(byte[] bArr) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        brw brw = this.f13226O000000o;
        if (brw != null) {
            bArr = brw.O00000Oo(bArr);
        }
        return O000000o(bArr);
    }
}

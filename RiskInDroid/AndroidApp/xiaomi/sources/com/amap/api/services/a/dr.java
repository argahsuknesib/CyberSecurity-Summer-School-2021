package com.amap.api.services.a;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class dr extends dw {

    /* renamed from: a  reason: collision with root package name */
    private cc f3411a = new cf();

    public dr() {
    }

    public dr(dw dwVar) {
        super(dwVar);
    }

    /* access modifiers changed from: protected */
    public byte[] a(byte[] bArr) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        return this.f3411a.b(bArr);
    }
}

package com.amap.api.services.a;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public abstract class dw {
    dw c;
    byte[] d = null;

    /* access modifiers changed from: protected */
    public abstract byte[] a(byte[] bArr) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException;

    public void b(byte[] bArr) {
    }

    dw() {
    }

    dw(dw dwVar) {
        this.c = dwVar;
    }

    public byte[] a() throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        byte[] a2 = a(this.d);
        dw dwVar = this.c;
        if (dwVar == null) {
            return a2;
        }
        dwVar.c(a2);
        return this.c.a();
    }

    /* access modifiers changed from: package-private */
    public void c(byte[] bArr) {
        this.d = bArr;
    }
}

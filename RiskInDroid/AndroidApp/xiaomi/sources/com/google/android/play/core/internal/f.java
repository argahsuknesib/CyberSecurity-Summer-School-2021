package com.google.android.play.core.internal;

import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;

final class f extends g {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f3766a;

    public f(X509Certificate x509Certificate, byte[] bArr) {
        super(x509Certificate);
        this.f3766a = bArr;
    }

    public final byte[] getEncoded() throws CertificateEncodingException {
        return this.f3766a;
    }
}

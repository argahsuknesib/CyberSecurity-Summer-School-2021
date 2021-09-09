package com.google.android.play.core.internal;

import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.Set;

class g extends X509Certificate {

    /* renamed from: a  reason: collision with root package name */
    private final X509Certificate f3767a;

    public g(X509Certificate x509Certificate) {
        this.f3767a = x509Certificate;
    }

    public final void checkValidity() throws CertificateExpiredException, CertificateNotYetValidException {
        this.f3767a.checkValidity();
    }

    public final void checkValidity(Date date) throws CertificateExpiredException, CertificateNotYetValidException {
        this.f3767a.checkValidity(date);
    }

    public final int getBasicConstraints() {
        return this.f3767a.getBasicConstraints();
    }

    public final Set<String> getCriticalExtensionOIDs() {
        return this.f3767a.getCriticalExtensionOIDs();
    }

    public byte[] getEncoded() throws CertificateEncodingException {
        return this.f3767a.getEncoded();
    }

    public final byte[] getExtensionValue(String str) {
        return this.f3767a.getExtensionValue(str);
    }

    public final Principal getIssuerDN() {
        return this.f3767a.getIssuerDN();
    }

    public final boolean[] getIssuerUniqueID() {
        return this.f3767a.getIssuerUniqueID();
    }

    public final boolean[] getKeyUsage() {
        return this.f3767a.getKeyUsage();
    }

    public final Set<String> getNonCriticalExtensionOIDs() {
        return this.f3767a.getNonCriticalExtensionOIDs();
    }

    public final Date getNotAfter() {
        return this.f3767a.getNotAfter();
    }

    public final Date getNotBefore() {
        return this.f3767a.getNotBefore();
    }

    public final PublicKey getPublicKey() {
        return this.f3767a.getPublicKey();
    }

    public final BigInteger getSerialNumber() {
        return this.f3767a.getSerialNumber();
    }

    public final String getSigAlgName() {
        return this.f3767a.getSigAlgName();
    }

    public final String getSigAlgOID() {
        return this.f3767a.getSigAlgOID();
    }

    public final byte[] getSigAlgParams() {
        return this.f3767a.getSigAlgParams();
    }

    public final byte[] getSignature() {
        return this.f3767a.getSignature();
    }

    public final Principal getSubjectDN() {
        return this.f3767a.getSubjectDN();
    }

    public final boolean[] getSubjectUniqueID() {
        return this.f3767a.getSubjectUniqueID();
    }

    public final byte[] getTBSCertificate() throws CertificateEncodingException {
        return this.f3767a.getTBSCertificate();
    }

    public final int getVersion() {
        return this.f3767a.getVersion();
    }

    public final boolean hasUnsupportedCriticalExtension() {
        return this.f3767a.hasUnsupportedCriticalExtension();
    }

    public final String toString() {
        return this.f3767a.toString();
    }

    public final void verify(PublicKey publicKey) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
        this.f3767a.verify(publicKey);
    }

    public final void verify(PublicKey publicKey, String str) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
        this.f3767a.verify(publicKey, str);
    }
}

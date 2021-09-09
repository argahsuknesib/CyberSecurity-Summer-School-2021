package com.mibi.sdk.common.exception;

import com.mibi.sdk.common.exception.CertificateDateNotValidException;
import java.io.IOException;
import java.net.URL;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;

public class ConnectionException extends NetworkException {
    private URL mUrl;

    public String getIdentifier() {
        return "CN";
    }

    public ConnectionException(Throwable th) {
        super(parseCause(null, th));
    }

    public ConnectionException(URL url, Throwable th) {
        super(parseCause(url, th));
        this.mUrl = url;
    }

    public ConnectionException(URL url, String str, Throwable th) {
        super(str, parseCause(url, th));
        this.mUrl = url;
    }

    private static Throwable parseCause(URL url, Throwable th) {
        if (th instanceof IOException) {
            for (Throwable th2 = th; th2 != null; th2 = th2.getCause()) {
                if (th2 instanceof CertificateNotYetValidException) {
                    return new CertificateDateNotValidException(CertificateDateNotValidException.Type.NOT_YET_VALID, th);
                }
                if (th2 instanceof CertificateExpiredException) {
                    return new CertificateDateNotValidException(CertificateDateNotValidException.Type.EXPIRED, th);
                }
            }
        }
        return th;
    }

    public URL getUrl() {
        return this.mUrl;
    }
}

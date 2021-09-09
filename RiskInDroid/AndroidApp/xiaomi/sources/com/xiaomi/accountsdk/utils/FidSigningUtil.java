package com.xiaomi.accountsdk.utils;

public class FidSigningUtil {

    public interface IFidSigner {
        boolean canSign() throws FidSignException;

        String getFid() throws FidSignException;

        byte[] sign(byte[] bArr) throws FidSignException;
    }

    public interface IFidSignerExtension {
        String getFidDirect() throws FidSignException;
    }

    public static class FidSignException extends Exception {
        public FidSignException(Throwable th) {
            super(th);
        }

        public FidSignException(String str) {
            super(str);
        }
    }

    static class FidSignerHolder {
        public static volatile IFidSigner sInstance = new FidSignerImplDefault();

        private FidSignerHolder() {
        }
    }

    public static IFidSigner getFidSigner() {
        return FidSignerHolder.sInstance;
    }

    public static void setFidSigner(IFidSigner iFidSigner) {
        if (iFidSigner != null) {
            FidSignerHolder.sInstance = iFidSigner;
            return;
        }
        throw new IllegalArgumentException("signer == null");
    }

    public static final class FidSignerImplDefault implements IFidSigner {
        public final boolean canSign() {
            return false;
        }

        public final byte[] sign(byte[] bArr) throws FidSignException {
            return bArr;
        }

        public final String getFid() throws FidSignException {
            throw new FidSignException("单发应用场景无法调用");
        }
    }
}

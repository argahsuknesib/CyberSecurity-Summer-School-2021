package android.support.v4.hardware.fingerprint;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.hardware.fingerprint.FingerprintManagerCompatApi23;
import android.support.v4.os.CancellationSignal;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

public final class FingerprintManagerCompat {
    static final FingerprintManagerCompatImpl IMPL;
    private Context mContext;

    public static abstract class AuthenticationCallback {
        public void onAuthenticationError(int i, CharSequence charSequence) {
        }

        public void onAuthenticationFailed() {
        }

        public void onAuthenticationHelp(int i, CharSequence charSequence) {
        }

        public void onAuthenticationSucceeded(AuthenticationResult authenticationResult) {
        }
    }

    interface FingerprintManagerCompatImpl {
        void authenticate(Context context, CryptoObject cryptoObject, int i, CancellationSignal cancellationSignal, AuthenticationCallback authenticationCallback, Handler handler);

        boolean hasEnrolledFingerprints(Context context);

        boolean isHardwareDetected(Context context);
    }

    static class LegacyFingerprintManagerCompatImpl implements FingerprintManagerCompatImpl {
        public void authenticate(Context context, CryptoObject cryptoObject, int i, CancellationSignal cancellationSignal, AuthenticationCallback authenticationCallback, Handler handler) {
        }

        public boolean hasEnrolledFingerprints(Context context) {
            return false;
        }

        public boolean isHardwareDetected(Context context) {
            return false;
        }
    }

    public static FingerprintManagerCompat from(Context context) {
        return new FingerprintManagerCompat(context);
    }

    private FingerprintManagerCompat(Context context) {
        this.mContext = context;
    }

    static {
        if (Build.VERSION.SDK_INT >= 23) {
            IMPL = new Api23FingerprintManagerCompatImpl();
        } else {
            IMPL = new LegacyFingerprintManagerCompatImpl();
        }
    }

    public final boolean hasEnrolledFingerprints() {
        return IMPL.hasEnrolledFingerprints(this.mContext);
    }

    public final boolean isHardwareDetected() {
        return IMPL.isHardwareDetected(this.mContext);
    }

    public final void authenticate(@Nullable CryptoObject cryptoObject, int i, @Nullable CancellationSignal cancellationSignal, @NonNull AuthenticationCallback authenticationCallback, @Nullable Handler handler) {
        IMPL.authenticate(this.mContext, cryptoObject, i, cancellationSignal, authenticationCallback, handler);
    }

    public static class CryptoObject {
        private final Cipher mCipher;
        private final Mac mMac;
        private final Signature mSignature;

        public CryptoObject(Signature signature) {
            this.mSignature = signature;
            this.mCipher = null;
            this.mMac = null;
        }

        public CryptoObject(Cipher cipher) {
            this.mCipher = cipher;
            this.mSignature = null;
            this.mMac = null;
        }

        public CryptoObject(Mac mac) {
            this.mMac = mac;
            this.mCipher = null;
            this.mSignature = null;
        }

        public Signature getSignature() {
            return this.mSignature;
        }

        public Cipher getCipher() {
            return this.mCipher;
        }

        public Mac getMac() {
            return this.mMac;
        }
    }

    public static final class AuthenticationResult {
        private CryptoObject mCryptoObject;

        public AuthenticationResult(CryptoObject cryptoObject) {
            this.mCryptoObject = cryptoObject;
        }

        public final CryptoObject getCryptoObject() {
            return this.mCryptoObject;
        }
    }

    static class Api23FingerprintManagerCompatImpl implements FingerprintManagerCompatImpl {
        public boolean hasEnrolledFingerprints(Context context) {
            return FingerprintManagerCompatApi23.hasEnrolledFingerprints(context);
        }

        public boolean isHardwareDetected(Context context) {
            return FingerprintManagerCompatApi23.isHardwareDetected(context);
        }

        public void authenticate(Context context, CryptoObject cryptoObject, int i, CancellationSignal cancellationSignal, AuthenticationCallback authenticationCallback, Handler handler) {
            FingerprintManagerCompatApi23.authenticate(context, wrapCryptoObject(cryptoObject), i, cancellationSignal != null ? cancellationSignal.getCancellationSignalObject() : null, wrapCallback(authenticationCallback), handler);
        }

        private static FingerprintManagerCompatApi23.CryptoObject wrapCryptoObject(CryptoObject cryptoObject) {
            if (cryptoObject == null) {
                return null;
            }
            if (cryptoObject.getCipher() != null) {
                return new FingerprintManagerCompatApi23.CryptoObject(cryptoObject.getCipher());
            }
            if (cryptoObject.getSignature() != null) {
                return new FingerprintManagerCompatApi23.CryptoObject(cryptoObject.getSignature());
            }
            if (cryptoObject.getMac() != null) {
                return new FingerprintManagerCompatApi23.CryptoObject(cryptoObject.getMac());
            }
            return null;
        }

        static CryptoObject unwrapCryptoObject(FingerprintManagerCompatApi23.CryptoObject cryptoObject) {
            if (cryptoObject == null) {
                return null;
            }
            if (cryptoObject.getCipher() != null) {
                return new CryptoObject(cryptoObject.getCipher());
            }
            if (cryptoObject.getSignature() != null) {
                return new CryptoObject(cryptoObject.getSignature());
            }
            if (cryptoObject.getMac() != null) {
                return new CryptoObject(cryptoObject.getMac());
            }
            return null;
        }

        private static FingerprintManagerCompatApi23.AuthenticationCallback wrapCallback(final AuthenticationCallback authenticationCallback) {
            return new FingerprintManagerCompatApi23.AuthenticationCallback() {
                /* class android.support.v4.hardware.fingerprint.FingerprintManagerCompat.Api23FingerprintManagerCompatImpl.AnonymousClass1 */

                public final void onAuthenticationError(int i, CharSequence charSequence) {
                    authenticationCallback.onAuthenticationError(i, charSequence);
                }

                public final void onAuthenticationHelp(int i, CharSequence charSequence) {
                    authenticationCallback.onAuthenticationHelp(i, charSequence);
                }

                public final void onAuthenticationSucceeded(FingerprintManagerCompatApi23.AuthenticationResultInternal authenticationResultInternal) {
                    authenticationCallback.onAuthenticationSucceeded(new AuthenticationResult(Api23FingerprintManagerCompatImpl.unwrapCryptoObject(authenticationResultInternal.getCryptoObject())));
                }

                public final void onAuthenticationFailed() {
                    authenticationCallback.onAuthenticationFailed();
                }
            };
        }
    }
}

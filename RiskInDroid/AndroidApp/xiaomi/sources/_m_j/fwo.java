package _m_j;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface;
import android.hardware.biometrics.BiometricPrompt;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Vibrator;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import javax.crypto.Cipher;

@TargetApi(23)
public final class fwo extends FingerprintManager.AuthenticationCallback {
    private static final long[] O00000o = {100, 500};

    /* renamed from: O000000o  reason: collision with root package name */
    public DialogInterface.OnClickListener f17318O000000o;
    public fwf O00000Oo;
    public boolean O00000o0 = true;
    private final boolean O00000oO;
    private FingerprintManager O00000oo;
    private Context O0000O0o;
    private MLAlertDialog O0000OOo;
    private CancellationSignal O0000Oo;
    private FingerprintManager.CryptoObject O0000Oo0;
    private DialogInterface.OnClickListener O0000OoO = new DialogInterface.OnClickListener() {
        /* class _m_j.fwo.AnonymousClass1 */

        public final void onClick(DialogInterface dialogInterface, int i) {
            if (fwo.this.O00000Oo != null) {
                fwo.this.O00000Oo.O000000o();
            }
        }
    };
    private DialogInterface.OnClickListener O0000Ooo = new DialogInterface.OnClickListener() {
        /* class _m_j.fwo.AnonymousClass2 */

        public final void onClick(DialogInterface dialogInterface, int i) {
            if (fwo.this.f17318O000000o != null) {
                fwo.this.f17318O000000o.onClick(dialogInterface, i);
            }
        }
    };

    public fwo(Context context, FingerprintManager.CryptoObject cryptoObject, fwf fwf, boolean z) {
        this.O0000O0o = context;
        this.O0000Oo0 = cryptoObject;
        this.O00000Oo = fwf;
        this.O00000oO = z;
        this.O00000oo = (FingerprintManager) this.O0000O0o.getSystemService(FingerprintManager.class);
    }

    public final void O000000o(String str) {
        BiometricPrompt.CryptoObject cryptoObject;
        if (this.O00000o0) {
            this.O00000o0 = false;
            this.O0000Oo = new CancellationSignal();
            if (Build.VERSION.SDK_INT >= 28) {
                BiometricPrompt.Builder negativeButton = new BiometricPrompt.Builder(this.O0000O0o).setTitle(this.O0000O0o.getString(R.string.device_more_fingerprint_title)).setDescription("").setNegativeButton(this.O0000O0o.getString(R.string.sh_common_cancel), this.O0000O0o.getMainExecutor(), this.O0000OoO);
                if (this.O00000oO) {
                    try {
                        Method method = negativeButton.getClass().getMethod("setPositiveButton", CharSequence.class, Executor.class, DialogInterface.OnClickListener.class);
                        method.setAccessible(true);
                        method.invoke(negativeButton, this.O0000O0o.getString(R.string.device_more_fingerprint_input_pw), this.O0000O0o.getMainExecutor(), this.O0000Ooo);
                    } catch (Exception e) {
                        negativeButton.setNegativeButton(this.O0000O0o.getString(R.string.device_more_fingerprint_input_pw), this.O0000O0o.getMainExecutor(), this.O0000Ooo);
                        gsy.O000000o(6, "FingerPrintOpenVerifyDialog", Log.getStackTraceString(e));
                    }
                }
                BiometricPrompt build = negativeButton.build();
                if (this.O0000Oo0.getCipher() != null) {
                    cryptoObject = new BiometricPrompt.CryptoObject(this.O0000Oo0.getCipher());
                } else if (this.O0000Oo0.getSignature() != null) {
                    cryptoObject = new BiometricPrompt.CryptoObject(this.O0000Oo0.getSignature());
                } else {
                    cryptoObject = new BiometricPrompt.CryptoObject(this.O0000Oo0.getMac());
                }
                build.authenticate(cryptoObject, this.O0000Oo, this.O0000O0o.getMainExecutor(), new BiometricPrompt.AuthenticationCallback() {
                    /* class _m_j.fwo.AnonymousClass3 */

                    public final void onAuthenticationError(int i, CharSequence charSequence) {
                        fwo.this.onAuthenticationError(i, charSequence);
                    }

                    public final void onAuthenticationHelp(int i, CharSequence charSequence) {
                        fwo.this.onAuthenticationHelp(i, charSequence);
                    }

                    public final void onAuthenticationSucceeded(BiometricPrompt.AuthenticationResult authenticationResult) {
                        fwo.this.O000000o(authenticationResult.getCryptoObject().getCipher());
                    }

                    public final void onAuthenticationFailed() {
                        fwo.this.onAuthenticationFailed();
                    }
                });
                return;
            }
            if (this.O0000OOo == null) {
                ImageView imageView = new ImageView(this.O0000O0o);
                imageView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2, 17.0f));
                imageView.setImageResource(R.drawable.xiaomi_sm_fingerprint_demo);
                MLAlertDialog.Builder O000000o2 = new MLAlertDialog.Builder(this.O0000O0o).O000000o(this.O0000O0o.getString(R.string.device_more_fingerprint_title)).O00000Oo((int) R.string.sh_common_cancel, this.O0000OoO).O000000o(imageView);
                if (this.O00000oO) {
                    O000000o2.O000000o(this.O0000O0o.getString(R.string.device_more_fingerprint_input_pw), new DialogInterface.OnClickListener() {
                        /* class _m_j.fwo.AnonymousClass4 */

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            if (fwo.this.f17318O000000o != null) {
                                fwo.this.f17318O000000o.onClick(dialogInterface, i);
                            }
                        }
                    });
                }
                O000000o2.O000000o(false);
                this.O0000OOo = O000000o2.O00000o();
            }
            if (!this.O0000OOo.isShowing()) {
                this.O0000OOo.show();
            }
            this.O0000OOo.setTitle(str);
            this.O00000oo.authenticate(this.O0000Oo0, this.O0000Oo, 0, this, null);
        }
    }

    public final void O000000o() {
        if (!this.O00000o0) {
            this.O00000o0 = true;
            this.O0000Oo.cancel();
            this.O0000Oo = null;
        }
    }

    public final void onAuthenticationError(int i, CharSequence charSequence) {
        fwf fwf = this.O00000Oo;
        if (fwf == null) {
            return;
        }
        if (i == 5) {
            fwf.O00000Oo();
        } else if (i != 7) {
            fwf.O000000o();
        } else {
            fwf.O000000o(charSequence);
        }
    }

    public final void onAuthenticationHelp(int i, CharSequence charSequence) {
        if (!this.O00000o0 && this.O0000OOo != null && !TextUtils.isEmpty(charSequence)) {
            this.O0000OOo.setTitle(charSequence);
        }
    }

    public final void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult authenticationResult) {
        O000000o(authenticationResult.getCryptoObject().getCipher());
    }

    public final void O000000o(Cipher cipher) {
        if (!this.O00000o0 && this.O00000Oo != null) {
            gqg.O00000Oo(this.O0000O0o.getString(R.string.device_more_verify_success));
            this.O00000Oo.O000000o(cipher);
        }
    }

    public final void onAuthenticationFailed() {
        MLAlertDialog mLAlertDialog;
        if (!this.O00000o0 && (mLAlertDialog = this.O0000OOo) != null) {
            mLAlertDialog.setTitle(this.O0000O0o.getString(R.string.device_more_fingerprint_error));
            Vibrator vibrator = (Vibrator) this.O0000O0o.getSystemService("vibrator");
            if (vibrator != null) {
                vibrator.vibrate(O00000o, -1);
            }
        }
    }

    public final void O00000Oo() {
        O000000o();
        MLAlertDialog mLAlertDialog = this.O0000OOo;
        if (mLAlertDialog != null) {
            mLAlertDialog.dismiss();
        }
    }
}

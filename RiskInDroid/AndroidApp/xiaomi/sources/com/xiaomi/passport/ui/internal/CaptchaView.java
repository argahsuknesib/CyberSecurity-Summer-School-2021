package com.xiaomi.passport.ui.internal;

import _m_j.eim;
import _m_j.ekx;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.xiaomi.accountsdk.request.AccessDeniedException;
import com.xiaomi.accountsdk.request.AuthenticationFailureException;
import com.xiaomi.accountsdk.request.SimpleRequest;
import com.xiaomi.accountsdk.request.SimpleRequestForAccount;
import com.xiaomi.accountsdk.utils.AccountLog;
import com.xiaomi.passport.ui.R$id;
import com.xiaomi.passport.uicontroller.SimpleFutureTask;
import com.xiaomi.smarthome.R;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

public class CaptchaView extends LinearLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    public ImageView f6242O000000o;
    public volatile String O00000Oo;
    private String O00000o;
    private EditText O00000o0;
    private SimpleFutureTask<Pair<Bitmap, String>> O00000oO;

    public CaptchaView(Context context) {
        super(context);
        O000000o(context);
    }

    public CaptchaView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CaptchaView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O000000o(context);
    }

    private void O000000o(Context context) {
        View inflate = LayoutInflater.from(context).inflate((int) R.layout.passport_captcha, this);
        this.f6242O000000o = (ImageView) inflate.findViewById(R$id.et_captcha_image);
        this.O00000o0 = (EditText) inflate.findViewById(R$id.et_captcha_code);
        this.f6242O000000o.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.passport.ui.internal.CaptchaView.AnonymousClass1 */

            public final void onClick(View view) {
                CaptchaView.this.O000000o();
            }
        });
    }

    public String getCaptchaCode() {
        String obj = this.O00000o0.getText().toString();
        if (!TextUtils.isEmpty(obj)) {
            return obj;
        }
        this.O00000o0.requestFocus();
        this.O00000o0.setError(getResources().getString(R.string.passport_error_empty_captcha_code));
        return null;
    }

    public String getCaptchaIck() {
        return this.O00000Oo;
    }

    public final void O000000o(String str) {
        this.O00000o = str;
        O000000o();
    }

    public final void O000000o() {
        O00000Oo(this.O00000o);
    }

    private void O00000Oo(String str) {
        SimpleFutureTask<Pair<Bitmap, String>> simpleFutureTask = this.O00000oO;
        if (simpleFutureTask == null || simpleFutureTask.isDone()) {
            final Context applicationContext = getContext().getApplicationContext();
            final int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.passport_captcha_img_w);
            final int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.passport_captcha_img_h);
            final String str2 = str;
            this.O00000oO = new SimpleFutureTask<>(new Callable<Pair<Bitmap, String>>() {
                /* class com.xiaomi.passport.ui.internal.CaptchaView.AnonymousClass3 */

                public Pair<Bitmap, String> call() throws Exception {
                    Pair<File, String> O000000o2 = CaptchaView.O000000o(applicationContext, str2);
                    if (O000000o2 != null) {
                        return Pair.create(CaptchaView.O000000o(((File) O000000o2.first).getPath(), dimensionPixelSize, dimensionPixelSize2), O000000o2.second);
                    }
                    AccountLog.e("CaptchaView", "image captcha result is null");
                    return null;
                }
            }, new SimpleFutureTask.O000000o<Pair<Bitmap, String>>() {
                /* class com.xiaomi.passport.ui.internal.CaptchaView.AnonymousClass2 */

                public final void O000000o(SimpleFutureTask<Pair<Bitmap, String>> simpleFutureTask) {
                    try {
                        Pair pair = (Pair) simpleFutureTask.get();
                        if (pair == null) {
                            Toast.makeText(CaptchaView.this.getContext(), (int) R.string.passport_input_captcha_hint, 1).show();
                            return;
                        }
                        CaptchaView.this.O00000Oo = (String) pair.second;
                        CaptchaView.this.f6242O000000o.setImageBitmap((Bitmap) pair.first);
                    } catch (InterruptedException e) {
                        AccountLog.e("CaptchaView", "downloadCaptchaImage", e);
                    } catch (ExecutionException e2) {
                        AccountLog.e("CaptchaView", "downloadCaptchaImage", e2);
                    }
                }
            });
            ekx.O000000o().execute(this.O00000oO);
            return;
        }
        AccountLog.w("CaptchaView", "pre image task passport_input_speaker_capcha_hintis doing");
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x001b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x001c A[SYNTHETIC, Splitter:B:12:0x001c] */
    public static Pair<File, String> O000000o(Context context, String str) {
        SimpleRequest.StreamContent streamContent;
        try {
            streamContent = SimpleRequestForAccount.getAsStream(str, null, null);
        } catch (IOException e) {
            AccountLog.w("CaptchaView", "getCaptcha", e);
            streamContent = null;
            if (streamContent != null) {
            }
        } catch (AccessDeniedException e2) {
            AccountLog.w("CaptchaView", "getCaptcha", e2);
            streamContent = null;
            if (streamContent != null) {
            }
        } catch (AuthenticationFailureException e3) {
            AccountLog.w("CaptchaView", "getCaptcha", e3);
            streamContent = null;
            if (streamContent != null) {
            }
        }
        if (streamContent != null) {
            return null;
        }
        try {
            return Pair.create(eim.O000000o(context, streamContent.getStream(), "captcha"), streamContent.getHeader("ick"));
        } catch (IOException e4) {
            AccountLog.w("CaptchaView", "getCaptcha", e4);
            return null;
        } finally {
            streamContent.closeStream();
        }
    }

    public static Bitmap O000000o(String str, int i, int i2) {
        Bitmap decodeFile = BitmapFactory.decodeFile(str);
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(decodeFile, i, i2, true);
        if (decodeFile != createScaledBitmap) {
            decodeFile.recycle();
        }
        return createScaledBitmap;
    }
}

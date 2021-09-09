package com.xiaomi.passport.ui.settings;

import _m_j.ein;
import _m_j.ejk;
import _m_j.ekx;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
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
    public ImageView f6295O000000o;
    public ImageView O00000Oo;
    public volatile String O00000o;
    public EditText O00000o0;
    public volatile boolean O00000oO;
    SimpleFutureTask<Pair<Bitmap, String>> O00000oo;
    SimpleFutureTask<Boolean> O0000O0o;
    public O000000o O0000OOo;
    private String O0000Oo;
    private boolean O0000Oo0;
    private String O0000OoO;

    public interface O000000o {
        void O000000o(boolean z);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        SimpleFutureTask<Pair<Bitmap, String>> simpleFutureTask = this.O00000oo;
        if (simpleFutureTask != null) {
            simpleFutureTask.cancel(true);
        }
        SimpleFutureTask<Boolean> simpleFutureTask2 = this.O0000O0o;
        if (simpleFutureTask2 != null) {
            simpleFutureTask2.cancel(true);
        }
        super.onDetachedFromWindow();
    }

    public CaptchaView(Context context) {
        super(context);
        this.O00000oO = false;
        O000000o(context);
    }

    public CaptchaView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CaptchaView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.O00000oO = false;
        O000000o(context);
    }

    private void O000000o(Context context) {
        View inflate = LayoutInflater.from(context).inflate((int) R.layout.passport_captcha, this);
        this.f6295O000000o = (ImageView) inflate.findViewById(R$id.et_captcha_image);
        this.O00000Oo = (ImageView) inflate.findViewById(R$id.et_switch);
        this.O00000o0 = (EditText) inflate.findViewById(R$id.et_captcha_code);
        if (this.O00000Oo != null) {
            this.O0000Oo0 = ejk.O000000o(context);
            this.O00000Oo.setVisibility(this.O0000Oo0 ? 0 : 8);
            this.O00000Oo.setContentDescription(getResources().getString(R.string.passport_talkback_switch_voice_captcha));
            this.O00000Oo.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.passport.ui.settings.CaptchaView.AnonymousClass1 */

                public final void onClick(View view) {
                    Drawable drawable;
                    Drawable drawable2 = null;
                    CaptchaView.this.O00000o0.setError(null, null);
                    CaptchaView captchaView = CaptchaView.this;
                    if (captchaView.O00000oo != null) {
                        captchaView.O00000oo.cancel(true);
                        captchaView.O00000oo = null;
                    }
                    if (captchaView.O0000O0o != null) {
                        captchaView.O0000O0o.cancel(true);
                        captchaView.O0000O0o = null;
                    }
                    CaptchaView captchaView2 = CaptchaView.this;
                    captchaView2.O00000oO = !captchaView2.O00000oO;
                    ImageView imageView = CaptchaView.this.O00000Oo;
                    CaptchaView captchaView3 = CaptchaView.this;
                    imageView.setImageDrawable(captchaView3.O000000o(captchaView3.O00000oO ? R.drawable.passport_ic_captcha_switch_image : R.drawable.passport_ic_captcha_switch_speaker));
                    CaptchaView.this.O00000Oo.setContentDescription(CaptchaView.this.getResources().getString(CaptchaView.this.O00000oO ? R.string.passport_talkback_switch_image_captcha : R.string.passport_talkback_switch_voice_captcha));
                    ImageView imageView2 = CaptchaView.this.f6295O000000o;
                    if (CaptchaView.this.O00000oO) {
                        drawable2 = CaptchaView.this.O000000o((int) R.drawable.passport_ic_sound_wave_retry);
                    }
                    imageView2.setImageDrawable(drawable2);
                    CaptchaView.this.f6295O000000o.setContentDescription(CaptchaView.this.getResources().getString(CaptchaView.this.O00000oO ? R.string.passport_talkback_voice_captcha : R.string.passport_talkback_image_captcha));
                    if (CaptchaView.this.O0000OOo != null) {
                        CaptchaView.this.O0000OOo.O000000o(CaptchaView.this.O00000oO);
                    }
                    ImageView imageView3 = CaptchaView.this.f6295O000000o;
                    if (CaptchaView.this.O00000oO) {
                        drawable = CaptchaView.this.O000000o((int) R.drawable.passport_ic_sound_wave_retry);
                    } else {
                        drawable = CaptchaView.this.O000000o((int) R.drawable.passport_ic_captch_retry);
                    }
                    imageView3.setImageDrawable(drawable);
                    CaptchaView.this.O00000o0.setHint(CaptchaView.this.O00000oO ? R.string.passport_input_voice_captcha_hint : R.string.passport_input_captcha_hint);
                    CaptchaView.this.O000000o();
                }
            });
        }
        this.f6295O000000o.setContentDescription(getResources().getString(R.string.passport_talkback_image_captcha));
        this.f6295O000000o.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.passport.ui.settings.CaptchaView.AnonymousClass2 */

            public final void onClick(View view) {
                CaptchaView.this.O00000o0.setText((CharSequence) null);
                CaptchaView.this.O000000o();
            }
        });
    }

    public String getCaptchaCode() {
        String str;
        String obj = this.O00000o0.getText().toString();
        if (!TextUtils.isEmpty(obj)) {
            return obj;
        }
        this.O00000o0.requestFocus();
        EditText editText = this.O00000o0;
        if (this.O00000oO) {
            str = getResources().getString(R.string.passport_error_empty_voice_code);
        } else {
            str = getResources().getString(R.string.passport_error_empty_captcha_code);
        }
        editText.setError(str);
        return null;
    }

    public String getCaptchaIck() {
        return this.O00000o;
    }

    public final void O000000o(String str, String str2) {
        this.O0000OoO = str2;
        this.O0000Oo = str;
        this.O00000o0.setText((CharSequence) null);
        O000000o();
    }

    public final void O000000o() {
        if (this.O00000oO) {
            O00000Oo(this.O0000OoO);
        } else {
            O000000o(this.O0000Oo);
        }
    }

    public final Drawable O000000o(int i) {
        return getResources().getDrawable(i);
    }

    private void O000000o(String str) {
        SimpleFutureTask<Pair<Bitmap, String>> simpleFutureTask = this.O00000oo;
        if (simpleFutureTask == null || simpleFutureTask.isDone()) {
            final Context applicationContext = getContext().getApplicationContext();
            final int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.passport_captcha_img_w);
            final int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.passport_captcha_img_h);
            final String str2 = str;
            this.O00000oo = new SimpleFutureTask<>(new Callable<Pair<Bitmap, String>>() {
                /* class com.xiaomi.passport.ui.settings.CaptchaView.AnonymousClass4 */

                public Pair<Bitmap, String> call() throws Exception {
                    Pair<File, String> O000000o2 = CaptchaView.O000000o(applicationContext, str2);
                    if (O000000o2 != null) {
                        return Pair.create(CaptchaView.O000000o(((File) O000000o2.first).getPath(), dimensionPixelSize, dimensionPixelSize2), O000000o2.second);
                    }
                    AccountLog.e("CaptchaView", "image captcha result is null");
                    return null;
                }
            }, new SimpleFutureTask.O000000o<Pair<Bitmap, String>>() {
                /* class com.xiaomi.passport.ui.settings.CaptchaView.AnonymousClass3 */

                public final void O000000o(SimpleFutureTask<Pair<Bitmap, String>> simpleFutureTask) {
                    try {
                        Pair pair = (Pair) simpleFutureTask.get();
                        if (pair == null) {
                            Toast.makeText(CaptchaView.this.getContext(), (int) R.string.passport_input_captcha_hint, 1).show();
                            return;
                        }
                        CaptchaView.this.O00000o = (String) pair.second;
                        CaptchaView.this.f6295O000000o.setImageBitmap((Bitmap) pair.first);
                    } catch (InterruptedException e) {
                        AccountLog.e("CaptchaView", "downloadCaptchaImage", e);
                    } catch (ExecutionException e2) {
                        AccountLog.e("CaptchaView", "downloadCaptchaImage", e2);
                    }
                }
            });
            ekx.O000000o().execute(this.O00000oo);
            return;
        }
        AccountLog.w("CaptchaView", "pre image task passport_input_speaker_capcha_hintis doing");
    }

    private void O00000Oo(final String str) {
        SimpleFutureTask<Boolean> simpleFutureTask = this.O0000O0o;
        if (simpleFutureTask == null || simpleFutureTask.isDone()) {
            final MediaPlayer mediaPlayer = new MediaPlayer();
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                /* class com.xiaomi.passport.ui.settings.CaptchaView.AnonymousClass5 */

                public final void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.release();
                    if (CaptchaView.this.O00000oO) {
                        CaptchaView.this.f6295O000000o.setImageDrawable(CaptchaView.this.O000000o((int) R.drawable.passport_ic_sound_wave_retry));
                    }
                }
            });
            this.O0000O0o = new SimpleFutureTask<>(new Callable<Boolean>() {
                /* class com.xiaomi.passport.ui.settings.CaptchaView.AnonymousClass7 */

                public Boolean call() throws Exception {
                    Context applicationContext = CaptchaView.this.getContext().getApplicationContext();
                    Pair<File, String> O000000o2 = CaptchaView.O000000o(applicationContext, str);
                    if (O000000o2 == null) {
                        AccountLog.w("CaptchaView", "speaker captcha null");
                        return Boolean.FALSE;
                    }
                    mediaPlayer.setDataSource(applicationContext, Uri.fromFile((File) O000000o2.first));
                    mediaPlayer.prepare();
                    CaptchaView.this.O00000o = (String) O000000o2.second;
                    return Boolean.TRUE;
                }
            }, new SimpleFutureTask.O000000o<Boolean>() {
                /* class com.xiaomi.passport.ui.settings.CaptchaView.AnonymousClass6 */

                public final void O000000o(SimpleFutureTask<Boolean> simpleFutureTask) {
                    try {
                        boolean booleanValue = ((Boolean) simpleFutureTask.get()).booleanValue();
                        if (booleanValue) {
                            CaptchaView.this.f6295O000000o.setImageDrawable(CaptchaView.this.O000000o((int) R.drawable.passport_ic_sound_wave));
                            mediaPlayer.start();
                        } else {
                            Toast.makeText(CaptchaView.this.getContext(), (int) R.string.passport_input_voice_captcha_hint, 1).show();
                        }
                        if (booleanValue) {
                            return;
                        }
                    } catch (InterruptedException e) {
                        AccountLog.e("CaptchaView", "downloadSpeakerCaptcha", e);
                        if (0 != 0) {
                            return;
                        }
                    } catch (ExecutionException e2) {
                        AccountLog.e("CaptchaView", "downloadSpeakerCaptcha", e2);
                        if (0 != 0) {
                            return;
                        }
                    } catch (Throwable th) {
                        if (0 == 0) {
                            mediaPlayer.release();
                        }
                        throw th;
                    }
                    mediaPlayer.release();
                }
            });
            ekx.O000000o().execute(this.O0000O0o);
            return;
        }
        AccountLog.w("CaptchaView", "pre speaker task is doing");
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
            return Pair.create(ein.O000000o(context, streamContent.getStream(), "captcha"), streamContent.getHeader("ick"));
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

    public void setOnCaptchaSwitchChange(O000000o o000000o) {
        this.O0000OOo = o000000o;
    }
}

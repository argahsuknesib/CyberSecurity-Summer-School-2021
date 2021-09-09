package com.alipay.sdk.widget;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alipay.sdk.util.c;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import java.io.ByteArrayInputStream;

public class a {
    public static String d = "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";
    /* access modifiers changed from: private */
    public C0021a e;
    /* access modifiers changed from: private */
    public Activity f;
    /* access modifiers changed from: private */
    public String g;
    private long h = -1;
    private final int i = 1;
    private final long j = DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS;
    /* access modifiers changed from: private */
    public boolean k = false;
    /* access modifiers changed from: private */
    public Handler l = new Handler(Looper.getMainLooper()) {
        /* class com.alipay.sdk.widget.a.AnonymousClass3 */

        public void dispatchMessage(Message message) {
            a.this.c();
        }
    };

    /* renamed from: com.alipay.sdk.widget.a$a  reason: collision with other inner class name */
    public class C0021a extends AlertDialog {
        protected C0021a(Context context) {
            super(context);
        }

        /* access modifiers changed from: protected */
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            setContentView(a(getContext()));
            Window window = getWindow();
            if (window != null) {
                window.setBackgroundDrawable(new ColorDrawable(0));
            }
        }

        private View a(Context context) {
            Context context2 = context;
            LinearLayout linearLayout = new LinearLayout(context2);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, a(context2, 50.0f));
            layoutParams.gravity = 17;
            linearLayout.setOrientation(0);
            linearLayout.setLayoutParams(layoutParams);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(-450944201);
            gradientDrawable.setCornerRadius((float) a(context2, 5.0f));
            linearLayout.setBackgroundDrawable(gradientDrawable);
            ImageView imageView = new ImageView(context2);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(a(context2, 20.0f), a(context2, 20.0f));
            layoutParams2.gravity = 16;
            layoutParams2.setMargins(a(a.this.f, 17.0f), a(a.this.f, 10.0f), a(a.this.f, 8.0f), a(a.this.f, 10.0f));
            imageView.setLayoutParams(layoutParams2);
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setImageDrawable(a(context2, a.d, 480));
            RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 359.0f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setRepeatCount(-1);
            rotateAnimation.setDuration(900);
            rotateAnimation.setInterpolator(new LinearInterpolator());
            imageView.startAnimation(rotateAnimation);
            TextView textView = new TextView(context2);
            textView.setText(TextUtils.isEmpty(a.this.g) ? "正在加载" : a.this.g);
            textView.setTextSize(16.0f);
            textView.setTextColor(-1);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams3.gravity = 16;
            layoutParams3.setMargins(0, 0, a(context2, 17.0f), 0);
            textView.setLayoutParams(layoutParams3);
            linearLayout.addView(imageView);
            linearLayout.addView(textView);
            FrameLayout frameLayout = new FrameLayout(context2);
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            frameLayout.addView(linearLayout);
            return frameLayout;
        }

        /* JADX WARNING: Removed duplicated region for block: B:18:0x003e A[SYNTHETIC, Splitter:B:18:0x003e] */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x0046 A[SYNTHETIC, Splitter:B:25:0x0046] */
        private Drawable a(Context context, String str, int i) {
            ByteArrayInputStream byteArrayInputStream;
            try {
                byteArrayInputStream = new ByteArrayInputStream(com.alipay.sdk.encrypt.a.a(str));
                try {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    if (i <= 0) {
                        i = 240;
                    }
                    options.inDensity = i;
                    options.inTargetDensity = context.getResources().getDisplayMetrics().densityDpi;
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(context.getResources(), BitmapFactory.decodeStream(byteArrayInputStream, null, options));
                    try {
                        byteArrayInputStream.close();
                        return bitmapDrawable;
                    } catch (Exception unused) {
                        return bitmapDrawable;
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        c.a(th);
                        if (byteArrayInputStream != null) {
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (byteArrayInputStream != null) {
                        }
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                byteArrayInputStream = null;
                if (byteArrayInputStream != null) {
                    try {
                        byteArrayInputStream.close();
                    } catch (Exception unused2) {
                    }
                }
                throw th;
            }
        }

        private int a(Context context, float f) {
            return (int) (f * (context == null ? Resources.getSystem() : context.getResources()).getDisplayMetrics().density);
        }
    }

    public a(Activity activity) {
        this.f = activity;
    }

    public a(Activity activity, String str) {
        this.f = activity;
        this.g = str;
    }

    public void a(boolean z) {
        this.k = z;
    }

    public void a(String str) {
        this.g = str;
    }

    public String a() {
        return this.g;
    }

    public void b() {
        Activity activity = this.f;
        if (activity != null) {
            activity.runOnUiThread(new Runnable() {
                /* class com.alipay.sdk.widget.a.AnonymousClass1 */

                public void run() {
                    if (a.this.e == null) {
                        a aVar = a.this;
                        C0021a unused = aVar.e = new C0021a(aVar.f);
                        a.this.e.setCancelable(a.this.k);
                    }
                    try {
                        if (!a.this.e.isShowing()) {
                            a.this.e.show();
                            a.this.l.sendEmptyMessageDelayed(1, DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS);
                        }
                    } catch (Exception e) {
                        c.a(e);
                    }
                }
            });
        }
    }

    public void c() {
        Activity activity = this.f;
        if (activity != null) {
            activity.runOnUiThread(new Runnable() {
                /* class com.alipay.sdk.widget.a.AnonymousClass2 */

                public void run() {
                    if (a.this.e != null && a.this.e.isShowing()) {
                        try {
                            a.this.l.removeMessages(1);
                            a.this.e.dismiss();
                        } catch (Exception e) {
                            c.a(e);
                        }
                    }
                }
            });
        }
    }

    public void d() {
        this.f = null;
        this.e = null;
    }
}

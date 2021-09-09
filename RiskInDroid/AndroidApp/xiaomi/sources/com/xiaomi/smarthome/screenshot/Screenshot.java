package com.xiaomi.smarthome.screenshot;

import _m_j.gsy;
import _m_j.hrx;
import _m_j.hry;
import _m_j.hrz;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.webkit.WebView;
import java.util.ArrayList;

public class Screenshot {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final String f11334O000000o = "com.xiaomi.smarthome.screenshot.Screenshot";
    public static final Object O00000Oo = new Object();
    public boolean O00000o;
    public View O00000o0;
    public volatile int O00000oO;
    public int O00000oo;
    public volatile int O0000O0o;
    public volatile int O0000OOo;
    public volatile O00000Oo O0000Oo;
    public volatile Bitmap O0000Oo0;
    public hry O0000OoO;
    public hrz O0000Ooo;
    private String O0000o0;
    private Context O0000o00;
    private O000000o O0000o0O;
    private Thread O0000o0o;

    /* synthetic */ Screenshot(Builder builder, byte b) {
        this(builder);
    }

    private Screenshot(Builder builder) {
        this.O0000o0 = "";
        this.O00000o = false;
        this.O0000Ooo = new hrz.O000000o() {
            /* class com.xiaomi.smarthome.screenshot.Screenshot.AnonymousClass1 */

            public final void O000000o() {
                Screenshot screenshot = Screenshot.this;
                screenshot.O0000Oo0 = hrx.O000000o(screenshot.O00000o0);
            }
        };
        this.O0000o00 = builder.f11338O000000o;
        this.O00000o0 = builder.O00000Oo;
        this.O0000o0 = builder.O00000o0;
        this.O00000o = builder.O00000o;
        this.O0000OoO = builder.O00000oO;
        this.O0000Oo = new O00000Oo(this.O0000o00.getMainLooper());
    }

    private String O00000Oo() {
        if (this.O0000o00 == null) {
            return "context not null";
        }
        return this.O00000o0 == null ? "target view not null" : "";
    }

    public final void O000000o() {
        String O00000Oo2 = O00000Oo();
        if (!TextUtils.isEmpty(O00000Oo2)) {
            this.O0000Oo.O000000o(O00000Oo2);
            return;
        }
        gsy.O00000Oo(f11334O000000o, "------------ start screenshot ------------");
        if (!this.O00000o) {
            O00000o0();
        } else {
            O00000o();
        }
    }

    private void O00000o0() {
        Bitmap O000000o2 = hrx.O000000o(hrx.O000000o(this.O00000o0));
        O000000o(O000000o2);
        this.O0000Oo.O000000o(O000000o2);
    }

    private void O00000o() {
        this.O0000Oo.O000000o();
        this.O00000oo = this.O00000o0.getHeight();
        this.O00000o0.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        this.O00000oO = this.O00000o0.getMeasuredHeight();
        this.O0000O0o = this.O00000oO / this.O00000oo;
        this.O0000OOo = this.O00000oO - (this.O0000O0o * this.O00000oo);
        String str = f11334O000000o;
        gsy.O00000Oo(str, "WebView内容高度: " + this.O00000oO);
        String str2 = f11334O000000o;
        gsy.O00000Oo(str2, "WebView控件高度: " + this.O00000oo);
        String str3 = f11334O000000o;
        gsy.O00000Oo(str3, "WebView滚动次数: " + this.O0000O0o);
        String str4 = f11334O000000o;
        gsy.O00000Oo(str4, "WebView剩余高度: " + this.O0000OOo);
        O00000oO();
    }

    private void O00000oO() {
        this.O0000o0O = new O000000o();
        this.O0000o0o = new Thread(this.O0000o0O);
        this.O0000o0o.start();
    }

    public final void O000000o(Bitmap bitmap) {
        if (!TextUtils.isEmpty(this.O0000o0)) {
            hrx.O000000o(bitmap, this.O0000o0);
            String str = f11334O000000o;
            gsy.O00000Oo(str, "filePath: " + this.O0000o0);
        }
    }

    public final void O000000o(int i) {
        View view = this.O00000o0;
        if (view instanceof WebView) {
            WebView webView = (WebView) view;
            boolean isVerticalScrollBarEnabled = webView.isVerticalScrollBarEnabled();
            if (i != 400 || !isVerticalScrollBarEnabled) {
                webView.setVerticalScrollBarEnabled(true);
            } else {
                webView.setVerticalScrollBarEnabled(false);
            }
        }
    }

    class O000000o implements Runnable {

        /* renamed from: O000000o  reason: collision with root package name */
        public volatile boolean f11339O000000o = false;

        O000000o() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:45:0x00c0, code lost:
            return;
         */
        public final void run() {
            try {
                synchronized (Screenshot.O00000Oo) {
                    ArrayList<Bitmap> arrayList = new ArrayList<>();
                    int i = Screenshot.this.O0000O0o;
                    if (Screenshot.this.O0000OOo > 0) {
                        i++;
                    }
                    int i2 = 0;
                    while (i2 < i) {
                        if (!Thread.currentThread().isInterrupted()) {
                            if (this.f11339O000000o) {
                                break;
                            }
                            if (i2 == 0) {
                                Screenshot.this.O0000Oo.O000000o(0);
                            } else {
                                Screenshot.this.O0000Oo.O000000o(Screenshot.this.O00000oo);
                            }
                            try {
                                gsy.O00000Oo(Screenshot.f11334O000000o, "当前线程阻塞,等待主(UI)线程滚动截图");
                                Screenshot.O00000Oo.wait();
                                arrayList.add(hrx.O000000o(Screenshot.this.O0000Oo0));
                                Screenshot.this.O0000Oo0.recycle();
                                i2++;
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                                for (Bitmap bitmap : arrayList) {
                                    if (bitmap != null && !bitmap.isRecycled()) {
                                        bitmap.recycle();
                                    }
                                }
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                    if (!this.f11339O000000o) {
                        Bitmap O000000o2 = hrx.O000000o(arrayList, Screenshot.this.O00000oO, Screenshot.this.O0000OOo);
                        gsy.O00000Oo(Screenshot.f11334O000000o, "合并图片成功");
                        Screenshot.this.O000000o(O000000o2);
                        for (Bitmap bitmap2 : arrayList) {
                            if (bitmap2 != null && !bitmap2.isRecycled()) {
                                bitmap2.recycle();
                            }
                        }
                        Screenshot.this.O0000Oo.O000000o(O000000o2);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static class Builder {

        /* renamed from: O000000o  reason: collision with root package name */
        public Context f11338O000000o;
        public View O00000Oo;
        public boolean O00000o;
        public String O00000o0;
        public hry O00000oO;

        public Builder(Context context) {
            this.f11338O000000o = context;
        }

        public final Screenshot O000000o() {
            return new Screenshot(this, (byte) 0);
        }
    }

    class O00000Oo extends Handler {
        public O00000Oo(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            int i = message.what;
            if (i == 100) {
                Bitmap bitmap = (Bitmap) message.obj;
                if (Screenshot.this.O0000OoO != null) {
                    Screenshot.this.O0000OoO.O000000o(bitmap);
                }
                Screenshot.this.O000000o(message.what);
                gsy.O00000Oo(Screenshot.f11334O000000o, "------------ finish screenshot ------------");
            } else if (i == 200) {
                int i2 = message.arg1;
                String str = (String) message.obj;
                if (Screenshot.this.O0000OoO != null) {
                    Screenshot.this.O0000OoO.O000000o(str);
                }
                Screenshot.this.O000000o(message.what);
            } else if (i == 300) {
                int i3 = message.arg1;
                Screenshot screenshot = Screenshot.this;
                int scrollY = screenshot.O00000o0.getScrollY();
                if (i3 <= 0) {
                    synchronized (Screenshot.O00000Oo) {
                        screenshot.O0000Ooo.O000000o();
                        gsy.O00000Oo(Screenshot.f11334O000000o, "主线程滚动截图完毕,环境LongScreenshotRunabable继续工作");
                        Screenshot.O00000Oo.notify();
                    }
                    return;
                }
                ValueAnimator ofInt = ValueAnimator.ofInt(0, i3);
                ofInt.setInterpolator(new LinearInterpolator());
                ofInt.setDuration(1000L);
                ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(scrollY) {
                    /* class com.xiaomi.smarthome.screenshot.Screenshot.AnonymousClass2 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    final /* synthetic */ int f11336O000000o;

                    {
                        this.f11336O000000o = r2;
                    }

                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        Screenshot.this.O00000o0.scrollTo(0, ((Integer) valueAnimator.getAnimatedValue()).intValue() + this.f11336O000000o);
                    }
                });
                ofInt.addListener(new AnimatorListenerAdapter() {
                    /* class com.xiaomi.smarthome.screenshot.Screenshot.AnonymousClass3 */

                    public final void onAnimationStart(Animator animator) {
                    }

                    public final void onAnimationEnd(Animator animator) {
                        synchronized (Screenshot.O00000Oo) {
                            Screenshot.this.O0000Ooo.O000000o();
                            gsy.O00000Oo(Screenshot.f11334O000000o, "主线程滚动截图完毕,环境LongScreenshotRunabable继续工作");
                            Screenshot.O00000Oo.notify();
                        }
                    }
                });
                ofInt.start();
            } else if (i == 400) {
                if (Screenshot.this.O0000OoO != null) {
                    Screenshot.this.O0000OoO.O000000o();
                }
                Screenshot.this.O000000o(message.what);
            }
        }

        public final void O000000o(int i) {
            Message obtainMessage = obtainMessage(300);
            obtainMessage.arg1 = i;
            sendMessage(obtainMessage);
        }

        public final void O000000o(Bitmap bitmap) {
            Message obtainMessage = obtainMessage(100);
            obtainMessage.obj = bitmap;
            sendMessage(obtainMessage);
        }

        public final void O000000o(String str) {
            Message obtainMessage = obtainMessage(100);
            obtainMessage.arg1 = 1001;
            obtainMessage.obj = str;
            sendMessage(obtainMessage);
        }

        public final void O000000o() {
            obtainMessage(400).sendToTarget();
        }
    }
}

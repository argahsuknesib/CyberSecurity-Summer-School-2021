package com.xiaomi.smarthome.framework.plugin.rn.view;

import _m_j.fwz;
import _m_j.gbu;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.react.modules.debug.FpsDebugFrameCallback;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.core.entity.plugin.PluginPackageInfo;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import java.util.Locale;

public class FpsMemoryView extends LinearLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    public FpsDebugFrameCallback f8463O000000o;
    public O000000o O00000Oo;
    public int O00000o;
    public boolean O00000o0;
    public int O00000oO;
    public int O00000oo;
    TextView O0000O0o;
    TextView O0000OOo;
    boolean O0000Oo;
    TextView O0000Oo0;
    private int O0000OoO;
    private int O0000Ooo;
    private boolean O0000o;
    private int O0000o0;
    private int O0000o00;
    private int O0000o0O;
    private int O0000o0o;
    private int O0000oO0;

    public FpsMemoryView(Context context) {
        this(context, null);
    }

    public FpsMemoryView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FpsMemoryView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.O0000OoO = 0;
        this.O0000Ooo = 0;
        this.O0000o00 = 0;
        this.O0000o0 = 0;
        this.O0000o0O = 720;
        this.O0000o0o = 1280;
        this.O00000o0 = true;
        this.O0000o = false;
        setOrientation(1);
        LayoutInflater.from(context).inflate((int) R.layout.fps_memory, this);
        this.O0000O0o = (TextView) findViewById(R.id.tv_content_default);
        this.O0000OOo = (TextView) findViewById(R.id.tv_content_more);
        this.O0000Oo0 = (TextView) findViewById(R.id.v_expansion);
        this.O0000Oo0.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.view.FpsMemoryView.AnonymousClass1 */

            public final void onClick(View view) {
                FpsMemoryView fpsMemoryView = FpsMemoryView.this;
                fpsMemoryView.O0000Oo = !fpsMemoryView.O0000Oo;
                if (fpsMemoryView.O0000Oo) {
                    fpsMemoryView.O0000Oo0.setText((int) R.string.fold);
                    fpsMemoryView.O0000OOo.setVisibility(0);
                } else {
                    fpsMemoryView.O0000Oo0.setText((int) R.string.unfold);
                    fpsMemoryView.O0000OOo.setVisibility(8);
                }
                fpsMemoryView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                    /* class com.xiaomi.smarthome.framework.plugin.rn.view.FpsMemoryView.AnonymousClass2 */

                    public final void onGlobalLayout() {
                        gbu.O000000o("FpsMemoryView  onGlobalLayout:");
                        FpsMemoryView fpsMemoryView = FpsMemoryView.this;
                        if (fpsMemoryView != null) {
                            fpsMemoryView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                            int measuredHeight = FpsMemoryView.this.getMeasuredHeight();
                            gbu.O000000o("FpsMemoryView  onGlobalLayout,isFirstInit:" + FpsMemoryView.this.O00000o0 + ",lastLayoutLeft:" + FpsMemoryView.this.O00000o);
                            if (!FpsMemoryView.this.O00000o0) {
                                FpsMemoryView fpsMemoryView2 = FpsMemoryView.this;
                                fpsMemoryView2.layout(fpsMemoryView2.O00000o, FpsMemoryView.this.O00000oO, FpsMemoryView.this.O00000oo, FpsMemoryView.this.O00000oO + measuredHeight);
                            }
                        }
                    }
                });
            }
        });
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        this.O0000o0O = displayMetrics.widthPixels;
        this.O0000o0o = displayMetrics.heightPixels;
        this.O00000o0 = true;
        this.O0000o = false;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.O0000OoO = (int) motionEvent.getRawX();
            this.O0000Ooo = (int) motionEvent.getRawY();
            this.O0000o00 = this.O0000OoO;
            this.O0000o0 = this.O0000Ooo;
            this.O0000o = true;
            return true;
        } else if (action != 1) {
            if (action == 2) {
                int rawX = ((int) motionEvent.getRawX()) - this.O0000OoO;
                int rawY = ((int) motionEvent.getRawY()) - this.O0000Ooo;
                int left = getLeft() + rawX;
                int top = getTop() + rawY;
                int right = getRight() + rawX;
                int bottom = getBottom() + rawY;
                if (left < 0) {
                    right = getWidth() + 0;
                    left = 0;
                }
                int i = this.O0000o0O;
                if (right > i) {
                    left = i - getWidth();
                } else {
                    i = right;
                }
                if (top < 0) {
                    bottom = getHeight() + 0;
                    top = 0;
                }
                int i2 = this.O0000o0o;
                if (bottom > i2) {
                    top = i2 - getHeight();
                    bottom = i2;
                }
                this.O00000o0 = false;
                this.O00000o = left;
                this.O00000oO = top;
                this.O00000oo = i;
                this.O0000oO0 = bottom;
                layout(left, top, i, bottom);
                this.O0000OoO = (int) motionEvent.getRawX();
                this.O0000Ooo = (int) motionEvent.getRawY();
            }
            return super.onTouchEvent(motionEvent);
        } else {
            this.O0000o = false;
            if (Math.abs(this.O0000OoO - this.O0000o00) < 10 && Math.abs(this.O0000Ooo - this.O0000o0) < 10) {
                return super.onTouchEvent(motionEvent);
            }
            setPressed(false);
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        gbu.O000000o("FpsMemoryView  onAttachedToWindow...");
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        gbu.O000000o("FpsMemoryView  onDetachedFromWindow...");
        FpsDebugFrameCallback fpsDebugFrameCallback = this.f8463O000000o;
        if (fpsDebugFrameCallback != null) {
            fpsDebugFrameCallback.stop();
        }
        O000000o o000000o = this.O00000Oo;
        if (o000000o != null) {
            o000000o.f8466O000000o = true;
        }
    }

    public class O000000o implements Runnable {

        /* renamed from: O000000o  reason: collision with root package name */
        public boolean f8466O000000o;

        private O000000o() {
            this.f8466O000000o = true;
        }

        public /* synthetic */ O000000o(FpsMemoryView fpsMemoryView, byte b) {
            this();
        }

        public final void run() {
            String str;
            String str2;
            String str3;
            if (!this.f8466O000000o) {
                long freeMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
                FpsMemoryView fpsMemoryView = FpsMemoryView.this;
                double fps = fpsMemoryView.f8463O000000o.getFPS();
                double jsfps = FpsMemoryView.this.f8463O000000o.getJSFPS();
                double d = (double) freeMemory;
                Double.isNaN(d);
                double d2 = (double) Runtime.getRuntime().totalMemory();
                Double.isNaN(d2);
                fpsMemoryView.O0000O0o.setText(String.format(Locale.US, "UI: %.2f fps\nJS: %.2f fps\nuseMemory: %.2f MB\nallocateMemory: %.2f MB", Double.valueOf(fps), Double.valueOf(jsfps), Double.valueOf(d / 1048576.0d), Double.valueOf(d2 / 1048576.0d)));
                FpsMemoryView.this.f8463O000000o.reset();
                FpsMemoryView fpsMemoryView2 = FpsMemoryView.this;
                DeviceStat deviceStat = fwz.O000000o().O00000Oo().O0000o00;
                String str4 = "";
                if (deviceStat != null) {
                    str = deviceStat.did;
                    str2 = deviceStat.model;
                } else {
                    str2 = str4;
                    str = str2;
                }
                PluginPackageInfo pluginPackageInfo = fwz.O000000o().O00000Oo().O0000OoO;
                if (pluginPackageInfo != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(pluginPackageInfo.O00000Oo());
                    str4 = sb.toString();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(pluginPackageInfo.O000000o());
                    str3 = sb2.toString();
                } else {
                    str3 = str4;
                }
                String accountId = XmPluginHostApi.instance().getAccountId();
                StringBuilder sb3 = new StringBuilder();
                sb3.append(Build.VERSION.SDK_INT);
                String sb4 = sb3.toString();
                fpsMemoryView2.O0000OOo.setText(String.format(Locale.US, "did: %s\nuid: %s\npackageId: %s\npluginId:%s\nmodel:%s\nrnNativeApiLevel:%s\nappVersionName:%s\nappVersionCode:%s\nsdkVersion:%s", str, accountId, str4, str3, str2, "10058", "6.10.703", "64706", sb4));
                FpsMemoryView.this.postDelayed(this, 500);
            }
        }
    }
}

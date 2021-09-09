package com.xiaomi.smarthome.newui.widget.dragsort;

import _m_j.gri;
import _m_j.gs;
import _m_j.gsy;
import _m_j.hhm;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Vibrator;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.concurrent.atomic.AtomicBoolean;

public class SimpleItemDelegateTouchHelperCallback extends gs.O000000o {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final String f10339O000000o = "SimpleItemDelegateTouchHelperCallback";
    private int[] O00000Oo = new int[2];
    private int[] O00000o = new int[2];
    private boolean O00000o0 = false;
    private Vibrator O00000oO;
    private WindowManager O00000oo;
    private WindowManager.LayoutParams O0000O0o;
    private Bitmap O0000OOo;
    private int O0000Oo;
    private int O0000Oo0;
    private float O0000OoO = 1.1f;
    private ImageView O0000Ooo;
    private View O0000o = null;
    private boolean O0000o0 = false;
    private FrameLayout O0000o00;
    private boolean O0000o0O = false;
    private int O0000o0o;
    private AtomicBoolean O0000oO0 = new AtomicBoolean(false);

    public final int O000000o(RecyclerView recyclerView, RecyclerView.O000OOo0 o000OOo0) {
        return 0;
    }

    public final void O000000o(RecyclerView.O000OOo0 o000OOo0) {
    }

    public final boolean O000000o() {
        return false;
    }

    public final boolean O000000o(RecyclerView.O000OOo0 o000OOo0, RecyclerView.O000OOo0 o000OOo02) {
        return false;
    }

    public SimpleItemDelegateTouchHelperCallback(Context context) {
        this.O00000oO = (Vibrator) context.getSystemService("vibrator");
        this.O00000oo = (WindowManager) context.getSystemService("window");
    }

    public final int O000000o(RecyclerView recyclerView, int i, int i2, int i3, long j) {
        return ((int) Math.signum((float) i2)) * 10;
    }

    public final void O000000o(Canvas canvas, RecyclerView recyclerView, RecyclerView.O000OOo0 o000OOo0, float f, float f2, int i, boolean z) {
        o000OOo0.itemView.getLocationInWindow(this.O00000Oo);
        if (this.O00000o0) {
            this.O00000o0 = false;
        }
        if (i == 1) {
            o000OOo0.itemView.setAlpha(1.0f - (Math.abs(f) / ((float) o000OOo0.itemView.getWidth())));
            o000OOo0.itemView.setTranslationX(f);
            return;
        }
        super.O000000o(canvas, recyclerView, o000OOo0, f, f2, i, z);
    }

    public final void O000000o(RecyclerView.O000OOo0 o000OOo0, int i) {
        gsy.O000000o(3, f10339O000000o, "onSelectedChanged ".concat(String.valueOf(i)));
        super.O000000o(o000OOo0, i);
        boolean z = false;
        if (i == 0) {
            if (this.O0000Ooo != null) {
                this.O00000oo.removeView(this.O0000o00);
                this.O0000o00 = null;
                this.O0000Ooo = null;
                Object tag = this.O0000o.getTag();
                if (tag instanceof Float) {
                    this.O0000o.setAlpha(((Float) tag).floatValue());
                } else {
                    this.O0000o.setAlpha(1.0f);
                }
            }
            if (this.O00000Oo[0] < 100) {
                z = true;
            }
            this.O00000o0 = z;
        } else if (i != 1 && i == 2) {
            this.O0000oO0.set(true);
            if (o000OOo0 instanceof hhm) {
                ((hhm) o000OOo0).O000000o();
            }
            this.O0000o0 = true;
            this.O0000o = o000OOo0.itemView;
            View view = this.O0000o;
            view.setTag(Float.valueOf(view.getAlpha()));
            this.O0000o.getLocationOnScreen(this.O00000o);
            this.O0000Oo0 = 0;
            this.O0000Oo = 0;
            this.O0000o.setDrawingCacheEnabled(true);
            Bitmap drawingCache = this.O0000o.getDrawingCache();
            this.O0000OOo = Bitmap.createScaledBitmap(drawingCache, (int) (((float) drawingCache.getWidth()) * this.O0000OoO), (int) (((float) drawingCache.getHeight()) * this.O0000OoO), true);
            this.O0000o.destroyDrawingCache();
            this.O0000o0o = gri.O000000o(10.0f);
            Context context = o000OOo0.itemView.getContext();
            Bitmap bitmap = this.O0000OOo;
            int[] iArr = this.O00000o;
            int i2 = iArr[0];
            int i3 = this.O0000o0o;
            this.O0000O0o = new WindowManager.LayoutParams();
            WindowManager.LayoutParams layoutParams = this.O0000O0o;
            layoutParams.format = -3;
            layoutParams.gravity = 51;
            layoutParams.x = i2 - i3;
            layoutParams.y = iArr[1] - i3;
            Object tag2 = this.O0000o.getTag();
            if (tag2 == null || !(tag2 instanceof Float)) {
                this.O0000O0o.alpha = 1.0f;
            } else {
                this.O0000O0o.alpha = ((Float) tag2).floatValue();
            }
            WindowManager.LayoutParams layoutParams2 = this.O0000O0o;
            layoutParams2.width = -2;
            layoutParams2.height = -2;
            layoutParams2.flags = 24;
            this.O0000Ooo = new ImageView(context);
            this.O0000Ooo.setImageBitmap(bitmap);
            this.O0000o00 = new FrameLayout(context);
            this.O0000o00.addView(this.O0000Ooo);
            this.O00000oo.addView(this.O0000o00, this.O0000O0o);
            this.O0000o.setAlpha(0.0f);
        }
    }

    public final void O00000o(RecyclerView recyclerView, RecyclerView.O000OOo0 o000OOo0) {
        super.O00000o(recyclerView, o000OOo0);
        if (o000OOo0 instanceof hhm) {
            ((hhm) o000OOo0).O00000Oo();
        }
        this.O0000oO0.set(false);
    }
}

package com.xiaomi.smarthome.wificonfig;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.os.Build;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import com.xiaomi.smarthome.R;
import java.io.IOException;
import java.io.InputStream;

public class GifView extends View {

    /* renamed from: O000000o  reason: collision with root package name */
    private int f11985O000000o;
    private Movie O00000Oo;
    private int O00000o;
    private long O00000o0;
    private float O00000oO;
    private float O00000oo;
    private float O0000O0o;
    private int O0000OOo;
    private boolean O0000Oo;
    private int O0000Oo0;
    private volatile boolean O0000OoO;

    public GifView(Context context) {
        this(context, null);
    }

    public GifView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GifView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.O00000o = 0;
        this.O0000Oo = true;
        this.O0000OoO = false;
        if (Build.VERSION.SDK_INT >= 11) {
            setLayerType(1, null);
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.freezesAnimation, R.attr.gif, R.attr.loopCount, R.attr.paused}, i, -1);
        this.f11985O000000o = obtainStyledAttributes.getResourceId(1, -1);
        this.O0000OoO = obtainStyledAttributes.getBoolean(3, false);
        obtainStyledAttributes.recycle();
        if (this.f11985O000000o != -1) {
            InputStream openRawResource = getResources().openRawResource(this.f11985O000000o);
            this.O00000Oo = Movie.decodeStream(openRawResource);
            try {
                openRawResource.close();
            } catch (IOException unused) {
            }
        }
    }

    public void setMovieResource(int i) {
        this.f11985O000000o = i;
        InputStream openRawResource = getResources().openRawResource(this.f11985O000000o);
        this.O00000Oo = Movie.decodeStream(openRawResource);
        try {
            openRawResource.close();
        } catch (IOException unused) {
        }
        requestLayout();
    }

    public void setMovie(Movie movie) {
        this.O00000Oo = movie;
        requestLayout();
    }

    public Movie getMovie() {
        return this.O00000Oo;
    }

    public void setMovieTime(int i) {
        this.O00000o = i;
        invalidate();
    }

    public void setPaused(boolean z) {
        this.O0000OoO = z;
        if (!z) {
            this.O00000o0 = SystemClock.uptimeMillis() - ((long) this.O00000o);
        }
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        Movie movie = this.O00000Oo;
        if (movie != null) {
            int width = movie.width();
            int height = this.O00000Oo.height();
            int size = View.MeasureSpec.getSize(i);
            this.O0000O0o = 1.0f / (((float) width) / ((float) size));
            this.O0000OOo = size;
            this.O0000Oo0 = (int) (((float) height) * this.O0000O0o);
            setMeasuredDimension(this.O0000OOo, this.O0000Oo0);
            return;
        }
        setMeasuredDimension(getSuggestedMinimumWidth(), getSuggestedMinimumHeight());
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.O00000oO = ((float) (getWidth() - this.O0000OOo)) / 2.0f;
        this.O00000oo = ((float) (getHeight() - this.O0000Oo0)) / 2.0f;
        this.O0000Oo = getVisibility() == 0;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (this.O00000Oo == null) {
            return;
        }
        if (!this.O0000OoO) {
            long uptimeMillis = SystemClock.uptimeMillis();
            if (this.O00000o0 == 0) {
                this.O00000o0 = uptimeMillis;
            }
            int duration = this.O00000Oo.duration();
            if (duration == 0) {
                duration = 1000;
            }
            this.O00000o = (int) ((uptimeMillis - this.O00000o0) % ((long) duration));
            O000000o(canvas);
            O000000o();
            return;
        }
        O000000o(canvas);
    }

    @SuppressLint({"NewApi"})
    private void O000000o() {
        if (!this.O0000Oo) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            postInvalidateOnAnimation();
        } else {
            invalidate();
        }
    }

    private void O000000o(Canvas canvas) {
        this.O00000Oo.setTime(this.O00000o);
        canvas.save();
        float f = this.O0000O0o;
        canvas.scale(f, f);
        Movie movie = this.O00000Oo;
        float f2 = this.O00000oO;
        float f3 = this.O0000O0o;
        movie.draw(canvas, f2 / f3, this.O00000oo / f3);
        canvas.restore();
    }

    @SuppressLint({"NewApi"})
    public void onScreenStateChanged(int i) {
        super.onScreenStateChanged(i);
        boolean z = true;
        if (i != 1) {
            z = false;
        }
        this.O0000Oo = z;
        O000000o();
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"NewApi"})
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        this.O0000Oo = i == 0;
        O000000o();
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.O0000Oo = i == 0;
        O000000o();
    }
}

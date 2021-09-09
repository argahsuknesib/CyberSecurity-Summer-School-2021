package _m_j;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.SystemClock;
import android.widget.MediaController;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Locale;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import pl.droidsonroids.gif.GifInfoHandle;
import pl.droidsonroids.gif.GifRenderingExecutor;

public final class jnw extends Drawable implements Animatable, MediaController.MediaPlayerControl {

    /* renamed from: O000000o  reason: collision with root package name */
    final ScheduledThreadPoolExecutor f1983O000000o;
    volatile boolean O00000Oo;
    protected final Paint O00000o;
    long O00000o0;
    public final Bitmap O00000oO;
    public final GifInfoHandle O00000oo;
    final ConcurrentLinkedQueue<Object> O0000O0o;
    final boolean O0000OOo;
    ScheduledFuture<?> O0000Oo;
    final jnz O0000Oo0;
    private final Rect O0000OoO;
    private ColorStateList O0000Ooo;
    private int O0000o;
    private PorterDuff.Mode O0000o0;
    private PorterDuffColorFilter O0000o00;
    private final job O0000o0O;
    private final Rect O0000o0o;
    private jod O0000oO;
    private int O0000oO0;

    public final boolean canPause() {
        return true;
    }

    public final int getAudioSessionId() {
        return 0;
    }

    public final int getBufferPercentage() {
        return 100;
    }

    public jnw(Resources resources, int i) throws Resources.NotFoundException, IOException {
        this(resources.openRawResourceFd(i));
        float O000000o2 = jnx.O000000o(resources, i);
        this.O0000oO0 = (int) (((float) this.O00000oo.O0000o0O()) * O000000o2);
        this.O0000o = (int) (((float) this.O00000oo.O0000o0()) * O000000o2);
    }

    private jnw(AssetFileDescriptor assetFileDescriptor) throws IOException {
        this(new GifInfoHandle(assetFileDescriptor));
    }

    public jnw(ByteBuffer byteBuffer) throws IOException {
        this(new GifInfoHandle(byteBuffer));
    }

    public jnw(ContentResolver contentResolver, Uri uri) throws IOException {
        this(GifInfoHandle.O000000o(contentResolver, uri));
    }

    private jnw(GifInfoHandle gifInfoHandle) {
        this.O00000Oo = true;
        this.O00000o0 = Long.MIN_VALUE;
        this.O0000OoO = new Rect();
        this.O00000o = new Paint(6);
        this.O0000O0o = new ConcurrentLinkedQueue<>();
        this.O0000o0O = new job(this);
        this.O0000OOo = true;
        this.f1983O000000o = GifRenderingExecutor.getInstance();
        this.O00000oo = gifInfoHandle;
        this.O00000oO = Bitmap.createBitmap(this.O00000oo.O0000o0(), this.O00000oo.O0000o0O(), Bitmap.Config.ARGB_8888);
        this.O00000oO.setHasAlpha(!gifInfoHandle.O0000o());
        this.O0000o0o = new Rect(0, 0, this.O00000oo.O0000o0(), this.O00000oo.O0000o0O());
        this.O0000Oo0 = new jnz(this);
        this.O0000o0O.O000000o();
        this.O0000o = this.O00000oo.O0000o0();
        this.O0000oO0 = this.O00000oo.O0000o0O();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.max(long, long):long}
     arg types: [int, long]
     candidates:
      ClspMth{java.lang.Math.max(double, double):double}
      ClspMth{java.lang.Math.max(int, int):int}
      ClspMth{java.lang.Math.max(float, float):float}
      ClspMth{java.lang.Math.max(long, long):long} */
    public final void invalidateSelf() {
        super.invalidateSelf();
        if (this.O0000OOo && this.O00000Oo) {
            long j = this.O00000o0;
            if (j != Long.MIN_VALUE) {
                long max = Math.max(0L, j - SystemClock.uptimeMillis());
                this.O00000o0 = Long.MIN_VALUE;
                this.f1983O000000o.remove(this.O0000o0O);
                this.O0000Oo = this.f1983O000000o.schedule(this.O0000o0O, max, TimeUnit.MILLISECONDS);
            }
        }
    }

    public final int getIntrinsicHeight() {
        return this.O0000oO0;
    }

    public final int getIntrinsicWidth() {
        return this.O0000o;
    }

    public final void setAlpha(int i) {
        this.O00000o.setAlpha(i);
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.O00000o.setColorFilter(colorFilter);
    }

    public final int getOpacity() {
        return (!this.O00000oo.O0000o() || this.O00000o.getAlpha() < 255) ? -2 : -1;
    }

    public final void start() {
        synchronized (this) {
            if (!this.O00000Oo) {
                this.O00000Oo = true;
                O000000o(this.O00000oo.O00000Oo());
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.max(long, long):long}
     arg types: [long, int]
     candidates:
      ClspMth{java.lang.Math.max(double, double):double}
      ClspMth{java.lang.Math.max(int, int):int}
      ClspMth{java.lang.Math.max(float, float):float}
      ClspMth{java.lang.Math.max(long, long):long} */
    public final void O000000o(long j) {
        if (this.O0000OOo) {
            this.O00000o0 = 0;
            this.O0000Oo0.sendEmptyMessageAtTime(-1, 0);
            return;
        }
        O00000Oo();
        this.O0000Oo = this.f1983O000000o.schedule(this.O0000o0O, Math.max(j, 0L), TimeUnit.MILLISECONDS);
    }

    public final void stop() {
        synchronized (this) {
            if (this.O00000Oo) {
                this.O00000Oo = false;
                O00000Oo();
                this.O00000oo.O00000o();
            }
        }
    }

    private void O00000Oo() {
        ScheduledFuture<?> scheduledFuture = this.O0000Oo;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.O0000Oo0.removeMessages(-1);
    }

    public final boolean isRunning() {
        return this.O00000Oo;
    }

    public final void O000000o(int i) {
        this.O00000oo.O000000o(i);
    }

    public final String toString() {
        return String.format(Locale.ENGLISH, "GIF: size: %dx%d, frames: %d, error: %d", Integer.valueOf(this.O00000oo.O0000o0()), Integer.valueOf(this.O00000oo.O0000o0O()), Integer.valueOf(this.O00000oo.O0000o0o()), Integer.valueOf(this.O00000oo.O00000oo()));
    }

    public final void pause() {
        stop();
    }

    public final int getDuration() {
        return this.O00000oo.O0000O0o();
    }

    public final int getCurrentPosition() {
        return this.O00000oo.O0000OOo();
    }

    public final void seekTo(final int i) {
        if (i >= 0) {
            this.f1983O000000o.execute(new joc(this) {
                /* class _m_j.jnw.AnonymousClass2 */

                public final void O000000o() {
                    jnw.this.O00000oo.O000000o(i, jnw.this.O00000oO);
                    this.O00000o0.O0000Oo0.sendEmptyMessageAtTime(-1, 0);
                }
            });
            return;
        }
        throw new IllegalArgumentException("Position is not positive");
    }

    public final boolean isPlaying() {
        return this.O00000Oo;
    }

    /* access modifiers changed from: protected */
    public final void onBoundsChange(Rect rect) {
        this.O0000OoO.set(rect);
    }

    public final void draw(Canvas canvas) {
        boolean z;
        if (this.O0000o00 == null || this.O00000o.getColorFilter() != null) {
            z = false;
        } else {
            this.O00000o.setColorFilter(this.O0000o00);
            z = true;
        }
        if (this.O0000oO == null) {
            canvas.drawBitmap(this.O00000oO, this.O0000o0o, this.O0000OoO, this.O00000o);
        }
        if (z) {
            this.O00000o.setColorFilter(null);
        }
    }

    public final int getAlpha() {
        return this.O00000o.getAlpha();
    }

    public final void setFilterBitmap(boolean z) {
        this.O00000o.setFilterBitmap(z);
        invalidateSelf();
    }

    @Deprecated
    public final void setDither(boolean z) {
        this.O00000o.setDither(z);
        invalidateSelf();
    }

    public final ColorFilter getColorFilter() {
        return this.O00000o.getColorFilter();
    }

    private PorterDuffColorFilter O000000o(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    public final void setTintList(ColorStateList colorStateList) {
        this.O0000Ooo = colorStateList;
        this.O0000o00 = O000000o(colorStateList, this.O0000o0);
        invalidateSelf();
    }

    public final void setTintMode(PorterDuff.Mode mode) {
        this.O0000o0 = mode;
        this.O0000o00 = O000000o(this.O0000Ooo, mode);
        invalidateSelf();
    }

    /* access modifiers changed from: protected */
    public final boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.O0000Ooo;
        if (colorStateList == null || (mode = this.O0000o0) == null) {
            return false;
        }
        this.O0000o00 = O000000o(colorStateList, mode);
        return true;
    }

    public final boolean isStateful() {
        if (super.isStateful()) {
            return true;
        }
        ColorStateList colorStateList = this.O0000Ooo;
        return colorStateList != null && colorStateList.isStateful();
    }

    public final boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (!this.O0000OOo) {
            if (z) {
                if (z2) {
                    this.f1983O000000o.execute(new joc(this) {
                        /* class _m_j.jnw.AnonymousClass1 */

                        public final void O000000o() {
                            if (jnw.this.O00000oo.O00000o0()) {
                                jnw.this.start();
                            }
                        }
                    });
                }
                if (visible) {
                    start();
                }
            } else if (visible) {
                stop();
            }
        }
        return visible;
    }

    public final int O000000o() {
        int O0000Oo2 = this.O00000oo.O0000Oo();
        return (O0000Oo2 == 0 || O0000Oo2 < this.O00000oo.O00000oO()) ? O0000Oo2 : O0000Oo2 - 1;
    }

    public final boolean canSeekBackward() {
        return this.O00000oo.O0000o0o() > 1;
    }

    public final boolean canSeekForward() {
        return this.O00000oo.O0000o0o() > 1;
    }
}

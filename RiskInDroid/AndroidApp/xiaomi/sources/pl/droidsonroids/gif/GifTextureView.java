package pl.droidsonroids.gif;

import _m_j.jnv;
import _m_j.jnx;
import _m_j.jny;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Surface;
import android.view.TextureView;
import android.widget.ImageView;
import com.google.android.exoplayer2.C;
import com.xiaomi.smarthome.R;
import java.io.IOException;
import java.lang.ref.WeakReference;

public class GifTextureView extends TextureView {
    private static final ImageView.ScaleType[] O00000o = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};

    /* renamed from: O000000o  reason: collision with root package name */
    public jny f15484O000000o;
    public float O00000Oo = 1.0f;
    public jnx.O00000Oo O00000o0;
    private ImageView.ScaleType O00000oO = ImageView.ScaleType.FIT_CENTER;
    private final Matrix O00000oo = new Matrix();
    private O00000Oo O0000O0o;

    public interface O000000o {
    }

    public TextureView.SurfaceTextureListener getSurfaceTextureListener() {
        return null;
    }

    public GifTextureView(Context context) {
        super(context);
        O000000o(null, 0);
    }

    public GifTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o(attributeSet, 0);
    }

    public GifTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O000000o(attributeSet, i);
    }

    private void O000000o(AttributeSet attributeSet, int i) {
        if (attributeSet != null) {
            int attributeIntValue = attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "scaleType", -1);
            if (attributeIntValue >= 0) {
                ImageView.ScaleType[] scaleTypeArr = O00000o;
                if (attributeIntValue < scaleTypeArr.length) {
                    this.O00000oO = scaleTypeArr[attributeIntValue];
                }
            }
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, new int[]{R.attr.gifSource, R.attr.isOpaque}, i, 0);
            this.f15484O000000o = O000000o(obtainStyledAttributes);
            super.setOpaque(obtainStyledAttributes.getBoolean(1, false));
            obtainStyledAttributes.recycle();
            this.O00000o0 = new jnx.O00000Oo(this, attributeSet, i, 0);
        } else {
            super.setOpaque(false);
            this.O00000o0 = new jnx.O00000Oo();
        }
        if (!isInEditMode()) {
            this.O0000O0o = new O00000Oo(this);
            if (this.f15484O000000o != null) {
                this.O0000O0o.start();
            }
        }
    }

    public void setSurfaceTextureListener(TextureView.SurfaceTextureListener surfaceTextureListener) {
        throw new UnsupportedOperationException("Changing SurfaceTextureListener is not supported");
    }

    public void setSurfaceTexture(SurfaceTexture surfaceTexture) {
        throw new UnsupportedOperationException("Changing SurfaceTexture is not supported");
    }

    private static jny O000000o(TypedArray typedArray) {
        TypedValue typedValue = new TypedValue();
        if (!typedArray.getValue(0, typedValue)) {
            return null;
        }
        if (typedValue.resourceId != 0) {
            String resourceTypeName = typedArray.getResources().getResourceTypeName(typedValue.resourceId);
            if (jnx.f1986O000000o.contains(resourceTypeName)) {
                return new jny.O00000Oo(typedArray.getResources(), typedValue.resourceId);
            }
            if (!"string".equals(resourceTypeName)) {
                throw new IllegalArgumentException("Expected string, drawable, mipmap or raw resource type. '" + resourceTypeName + "' is not supported");
            }
        }
        return new jny.O000000o(typedArray.getResources().getAssets(), typedValue.string.toString());
    }

    static class O00000Oo extends Thread implements TextureView.SurfaceTextureListener {

        /* renamed from: O000000o  reason: collision with root package name */
        final jnv f15486O000000o = new jnv();
        public GifInfoHandle O00000Oo = new GifInfoHandle();
        long[] O00000o;
        public IOException O00000o0;
        private final WeakReference<GifTextureView> O00000oO;

        public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        }

        public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        O00000Oo(GifTextureView gifTextureView) {
            super("GifRenderThread");
            this.O00000oO = new WeakReference<>(gifTextureView);
        }

        public final void run() {
            try {
                GifTextureView gifTextureView = this.O00000oO.get();
                if (gifTextureView != null) {
                    this.O00000Oo = gifTextureView.f15484O000000o.O000000o();
                    GifInfoHandle gifInfoHandle = this.O00000Oo;
                    GifInfoHandle.setOptions(gifInfoHandle.f15482O000000o, 1, gifTextureView.isOpaque());
                    if (gifTextureView.O00000o0.O00000o >= 0) {
                        this.O00000Oo.O000000o(gifTextureView.O00000o0.O00000o);
                    }
                    final GifTextureView gifTextureView2 = this.O00000oO.get();
                    if (gifTextureView2 == null) {
                        this.O00000Oo.O000000o();
                        return;
                    }
                    gifTextureView2.setSuperSurfaceTextureListener(this);
                    boolean isAvailable = gifTextureView2.isAvailable();
                    this.f15486O000000o.O000000o(isAvailable);
                    if (isAvailable) {
                        gifTextureView2.post(new Runnable() {
                            /* class pl.droidsonroids.gif.GifTextureView.O00000Oo.AnonymousClass1 */

                            public final void run() {
                                gifTextureView2.O000000o(O00000Oo.this.O00000Oo);
                            }
                        });
                    }
                    this.O00000Oo.O000000o(gifTextureView2.O00000Oo);
                    while (!isInterrupted()) {
                        try {
                            this.f15486O000000o.O00000o0();
                            GifTextureView gifTextureView3 = this.O00000oO.get();
                            if (gifTextureView3 == null) {
                                break;
                            }
                            SurfaceTexture surfaceTexture = gifTextureView3.getSurfaceTexture();
                            if (surfaceTexture != null) {
                                Surface surface = new Surface(surfaceTexture);
                                try {
                                    GifInfoHandle gifInfoHandle2 = this.O00000Oo;
                                    GifInfoHandle.bindSurface(gifInfoHandle2.f15482O000000o, surface, this.O00000o);
                                } finally {
                                    surface.release();
                                }
                            }
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    this.O00000Oo.O000000o();
                    this.O00000Oo = new GifInfoHandle();
                }
            } catch (IOException e) {
                this.O00000o0 = e;
            }
        }

        public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            GifTextureView gifTextureView = this.O00000oO.get();
            if (gifTextureView != null) {
                gifTextureView.O000000o(this.O00000Oo);
            }
            this.f15486O000000o.O000000o();
        }

        public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            this.f15486O000000o.O00000Oo();
            this.O00000Oo.O0000Ooo();
            interrupt();
            return true;
        }

        /* access modifiers changed from: package-private */
        public final void O000000o(GifTextureView gifTextureView, O000000o o000000o) {
            this.f15486O000000o.O00000Oo();
            gifTextureView.setSuperSurfaceTextureListener(null);
            this.O00000Oo.O0000Ooo();
            interrupt();
        }
    }

    public void setSuperSurfaceTextureListener(TextureView.SurfaceTextureListener surfaceTextureListener) {
        super.setSurfaceTextureListener(surfaceTextureListener);
    }

    public void setOpaque(boolean z) {
        if (z != isOpaque()) {
            super.setOpaque(z);
            setInputSource(this.f15484O000000o);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        this.O0000O0o.O000000o(this, null);
        super.onDetachedFromWindow();
        SurfaceTexture surfaceTexture = getSurfaceTexture();
        if (surfaceTexture != null) {
            surfaceTexture.release();
        }
    }

    public synchronized void setInputSource(jny jny) {
        setInputSource$2db1edb1(jny);
    }

    private synchronized void setInputSource$2db1edb1(jny jny) {
        this.O0000O0o.O000000o(this, null);
        try {
            this.O0000O0o.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.f15484O000000o = jny;
        this.O0000O0o = new O00000Oo(this);
        if (jny != null) {
            this.O0000O0o.start();
        }
    }

    public void setSpeed(float f) {
        this.O00000Oo = f;
        this.O0000O0o.O00000Oo.O000000o(f);
    }

    public IOException getIOException() {
        if (this.O0000O0o.O00000o0 != null) {
            return this.O0000O0o.O00000o0;
        }
        return GifIOException.O000000o(this.O0000O0o.O00000Oo.O00000oo());
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        this.O00000oO = scaleType;
        O000000o(this.O0000O0o.O00000Oo);
    }

    public ImageView.ScaleType getScaleType() {
        return this.O00000oO;
    }

    public final void O000000o(GifInfoHandle gifInfoHandle) {
        Matrix matrix = new Matrix();
        float width = (float) getWidth();
        float height = (float) getHeight();
        float O0000o0 = ((float) gifInfoHandle.O0000o0()) / width;
        float O0000o0O = ((float) gifInfoHandle.O0000o0O()) / height;
        RectF rectF = new RectF(0.0f, 0.0f, (float) gifInfoHandle.O0000o0(), (float) gifInfoHandle.O0000o0O());
        RectF rectF2 = new RectF(0.0f, 0.0f, width, height);
        float f = 1.0f;
        switch (AnonymousClass1.f15485O000000o[this.O00000oO.ordinal()]) {
            case 1:
                matrix.setScale(O0000o0, O0000o0O, width / 2.0f, height / 2.0f);
                break;
            case 2:
                float min = 1.0f / Math.min(O0000o0, O0000o0O);
                matrix.setScale(O0000o0 * min, min * O0000o0O, width / 2.0f, height / 2.0f);
                break;
            case 3:
                if (((float) gifInfoHandle.O0000o0()) > width || ((float) gifInfoHandle.O0000o0O()) > height) {
                    f = Math.min(1.0f / O0000o0, 1.0f / O0000o0O);
                }
                matrix.setScale(O0000o0 * f, f * O0000o0O, width / 2.0f, height / 2.0f);
                break;
            case 4:
                matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
                matrix.preScale(O0000o0, O0000o0O);
                break;
            case 5:
                matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.END);
                matrix.preScale(O0000o0, O0000o0O);
                break;
            case 6:
                matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.START);
                matrix.preScale(O0000o0, O0000o0O);
                break;
            case 7:
                return;
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                matrix.set(this.O00000oo);
                matrix.preScale(O0000o0, O0000o0O);
                break;
        }
        super.setTransform(matrix);
    }

    /* renamed from: pl.droidsonroids.gif.GifTextureView$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f15485O000000o = new int[ImageView.ScaleType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|(3:15|16|18)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0040 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x004b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0056 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            f15485O000000o[ImageView.ScaleType.CENTER.ordinal()] = 1;
            f15485O000000o[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            f15485O000000o[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            f15485O000000o[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            f15485O000000o[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            f15485O000000o[ImageView.ScaleType.FIT_START.ordinal()] = 6;
            f15485O000000o[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            try {
                f15485O000000o[ImageView.ScaleType.MATRIX.ordinal()] = 8;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public void setImageMatrix(Matrix matrix) {
        setTransform(matrix);
    }

    public void setTransform(Matrix matrix) {
        this.O00000oo.set(matrix);
        O000000o(this.O0000O0o.O00000Oo);
    }

    public Matrix getTransform(Matrix matrix) {
        if (matrix == null) {
            matrix = new Matrix();
        }
        matrix.set(this.O00000oo);
        return matrix;
    }

    public Parcelable onSaveInstanceState() {
        O00000Oo o00000Oo = this.O0000O0o;
        o00000Oo.O00000o = o00000Oo.O00000Oo.O0000o00();
        return new GifViewSavedState(super.onSaveInstanceState(), this.O00000o0.O00000o0 ? this.O0000O0o.O00000o : null);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof GifViewSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        GifViewSavedState gifViewSavedState = (GifViewSavedState) parcelable;
        super.onRestoreInstanceState(gifViewSavedState.getSuperState());
        this.O0000O0o.O00000o = gifViewSavedState.f15488O000000o[0];
    }

    public void setFreezesAnimation(boolean z) {
        this.O00000o0.O00000o0 = z;
    }
}

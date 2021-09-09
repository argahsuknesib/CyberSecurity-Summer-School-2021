package _m_j;

import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.renderscript.Allocation;
import androidx.renderscript.Element;
import androidx.renderscript.RenderScript;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.xiaomi.smarthome.R;

public final class gcb extends View {
    private static final int O00000o = Color.parseColor("#AAFFFFFF");

    /* renamed from: O000000o  reason: collision with root package name */
    protected View f17510O000000o;
    public RenderScript O00000Oo;
    public hq O00000o0;
    private ThemedReactContext O00000oO;
    private boolean O00000oo;
    private int O0000O0o;
    private int O0000OOo;
    private int O0000Oo;
    private int O0000Oo0;
    private boolean O0000OoO;
    private Bitmap O0000Ooo;
    private Canvas O0000o0;
    private Bitmap O0000o00;
    private Allocation O0000o0O;
    private Allocation O0000o0o;

    public gcb(ThemedReactContext themedReactContext) {
        this(themedReactContext, (byte) 0);
    }

    private gcb(ThemedReactContext themedReactContext, byte b) {
        super(themedReactContext, null);
        this.O00000oo = false;
        getResources();
        int i = O00000o;
        this.O00000oO = themedReactContext;
        this.O00000Oo = RenderScript.O000000o(themedReactContext);
        RenderScript renderScript = this.O00000Oo;
        this.O00000o0 = hq.O000000o(renderScript, Element.O00000o0(renderScript));
        TypedArray obtainStyledAttributes = themedReactContext.obtainStyledAttributes((AttributeSet) null, new int[]{R.attr.blurRadius, R.attr.downsampleFactor, R.attr.overlayColor});
        setBlurRadius(obtainStyledAttributes.getInt(0, 15));
        setDownsampleFactor(obtainStyledAttributes.getInt(1, 8));
        setOverlayColor(obtainStyledAttributes.getColor(2, i));
        obtainStyledAttributes.recycle();
    }

    public final void setBlurredView(View view) {
        this.f17510O000000o = view;
        O000000o();
        invalidate();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00ba, code lost:
        if (r8.O0000o00 == null) goto L_0x00ae;
     */
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        View view = this.f17510O000000o;
        if (view != null) {
            boolean z = true;
            if (this.O00000oo) {
                View decorView = this.O00000oO.getCurrentActivity().getWindow().getDecorView();
                decorView.setDrawingCacheEnabled(true);
                decorView.destroyDrawingCache();
                decorView.buildDrawingCache();
                Bitmap drawingCache = decorView.getDrawingCache();
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(drawingCache, Math.round((float) (drawingCache.getWidth() * this.O0000O0o)), Math.round((float) (drawingCache.getHeight() * this.O0000O0o)), false);
                Bitmap createBitmap = Bitmap.createBitmap(createScaledBitmap);
                Allocation O000000o2 = Allocation.O000000o(this.O00000Oo, createScaledBitmap);
                Allocation O000000o3 = Allocation.O000000o(this.O00000Oo, createBitmap);
                this.O00000o0.O000000o(O000000o2);
                this.O00000o0.O00000Oo(O000000o3);
                O000000o3.O00000Oo(createBitmap);
                canvas.drawBitmap(createBitmap, 0.0f, 0.0f, (Paint) null);
                drawingCache.recycle();
                return;
            }
            int width = view.getWidth();
            int height = this.f17510O000000o.getHeight();
            if (this.O0000o0 == null || this.O0000OoO || this.O0000Oo0 != width || this.O0000Oo != height) {
                this.O0000OoO = false;
                this.O0000Oo0 = width;
                this.O0000Oo = height;
                int i = this.O0000O0o;
                int i2 = width / i;
                int i3 = height / i;
                Bitmap bitmap = this.O0000o00;
                if (!(bitmap != null && bitmap.getWidth() == i2 && this.O0000o00.getHeight() == i3)) {
                    this.O0000Ooo = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
                    if (this.O0000Ooo != null) {
                        this.O0000o00 = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
                    }
                    z = false;
                }
                this.O0000o0 = new Canvas(this.O0000Ooo);
                Canvas canvas2 = this.O0000o0;
                int i4 = this.O0000O0o;
                canvas2.scale(1.0f / ((float) i4), 1.0f / ((float) i4));
                this.O0000o0O = Allocation.O000000o(this.O00000Oo, this.O0000Ooo, Allocation.MipmapControl.MIPMAP_NONE, 1);
                this.O0000o0o = Allocation.O000000o(this.O00000Oo, this.O0000o0O.O000000o());
            }
            if (z) {
                if (this.f17510O000000o.getBackground() == null || !(this.f17510O000000o.getBackground() instanceof ColorDrawable)) {
                    this.O0000Ooo.eraseColor(0);
                } else {
                    this.O0000Ooo.eraseColor(((ColorDrawable) this.f17510O000000o.getBackground()).getColor());
                }
                this.f17510O000000o.draw(this.O0000o0);
                this.O0000o0O.O000000o(this.O0000Ooo);
                this.O00000o0.O000000o(this.O0000o0O);
                this.O00000o0.O00000Oo(this.O0000o0o);
                this.O0000o0o.O00000Oo(this.O0000o00);
                canvas.save();
                canvas.translate(this.f17510O000000o.getX() - getX(), this.f17510O000000o.getY() - getY());
                int i5 = this.O0000O0o;
                canvas.scale((float) i5, (float) i5);
                canvas.drawBitmap(this.O0000o00, 0.0f, 0.0f, (Paint) null);
                canvas.restore();
            }
            canvas.drawColor(this.O0000OOo);
        }
    }

    public final void setBlurRadius(int i) {
        this.O00000o0.O000000o((float) i);
        invalidate();
    }

    public final void setDownsampleFactor(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Downsample factor must be greater than 0.");
        } else if (this.O0000O0o != i) {
            this.O0000O0o = i;
            this.O0000OoO = true;
            invalidate();
        }
    }

    public final void setOverlayColor(int i) {
        if (this.O0000OOo != i) {
            this.O0000OOo = i;
            invalidate();
        }
    }

    /* access modifiers changed from: protected */
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        invalidate();
        O000000o();
    }

    /* access modifiers changed from: protected */
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public final void setmIsBlurReactModalHostView(boolean z) {
        this.O00000oo = z;
    }

    private void O000000o() {
        if (this.f17510O000000o != null && getParent() != null) {
            if (this.f17510O000000o.findViewById(getId()) != null) {
                ((DeviceEventManagerModule.RCTDeviceEventEmitter) ((ThemedReactContext) getContext()).getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("ReactNativeBlurError", "BlurView must not be a child of the view that is being blurred.");
                setBlurredView(null);
                invalidate();
            }
        }
    }
}

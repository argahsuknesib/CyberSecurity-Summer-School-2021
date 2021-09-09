package _m_j;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Shader;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.google.android.exoplayer2.C;

public class OOOO0 {
    private static final int[] O00000Oo = {16843067, 16843068};

    /* renamed from: O000000o  reason: collision with root package name */
    public Bitmap f12325O000000o;
    private final ProgressBar O00000o0;

    public OOOO0(ProgressBar progressBar) {
        this.O00000o0 = progressBar;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.OOOO0.O000000o(android.graphics.drawable.Drawable, boolean):android.graphics.drawable.Drawable
     arg types: [android.graphics.drawable.Drawable, int]
     candidates:
      _m_j.OOOO0.O000000o(android.util.AttributeSet, int):void
      _m_j.OOOO0.O000000o(android.graphics.drawable.Drawable, boolean):android.graphics.drawable.Drawable */
    public void O000000o(AttributeSet attributeSet, int i) {
        Oo O000000o2 = Oo.O000000o(this.O00000o0.getContext(), attributeSet, O00000Oo, i, 0);
        Drawable O00000Oo2 = O000000o2.O00000Oo(0);
        if (O00000Oo2 != null) {
            ProgressBar progressBar = this.O00000o0;
            if (O00000Oo2 instanceof AnimationDrawable) {
                AnimationDrawable animationDrawable = (AnimationDrawable) O00000Oo2;
                int numberOfFrames = animationDrawable.getNumberOfFrames();
                AnimationDrawable animationDrawable2 = new AnimationDrawable();
                animationDrawable2.setOneShot(animationDrawable.isOneShot());
                for (int i2 = 0; i2 < numberOfFrames; i2++) {
                    Drawable O000000o3 = O000000o(animationDrawable.getFrame(i2), true);
                    O000000o3.setLevel(C.MSG_CUSTOM_BASE);
                    animationDrawable2.addFrame(O000000o3, animationDrawable.getDuration(i2));
                }
                animationDrawable2.setLevel(C.MSG_CUSTOM_BASE);
                O00000Oo2 = animationDrawable2;
            }
            progressBar.setIndeterminateDrawable(O00000Oo2);
        }
        Drawable O00000Oo3 = O000000o2.O00000Oo(1);
        if (O00000Oo3 != null) {
            this.O00000o0.setProgressDrawable(O000000o(O00000Oo3, false));
        }
        O000000o2.f12340O000000o.recycle();
    }

    private Drawable O000000o(Drawable drawable, boolean z) {
        if (drawable instanceof ad) {
            ad adVar = (ad) drawable;
            Drawable O000000o2 = adVar.O000000o();
            if (O000000o2 != null) {
                adVar.O000000o(O000000o(O000000o2, z));
            }
        } else if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            Drawable[] drawableArr = new Drawable[numberOfLayers];
            for (int i = 0; i < numberOfLayers; i++) {
                int id = layerDrawable.getId(i);
                drawableArr[i] = O000000o(layerDrawable.getDrawable(i), id == 16908301 || id == 16908303);
            }
            LayerDrawable layerDrawable2 = new LayerDrawable(drawableArr);
            for (int i2 = 0; i2 < numberOfLayers; i2++) {
                layerDrawable2.setId(i2, layerDrawable.getId(i2));
            }
            return layerDrawable2;
        } else if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            Bitmap bitmap = bitmapDrawable.getBitmap();
            if (this.f12325O000000o == null) {
                this.f12325O000000o = bitmap;
            }
            ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null));
            shapeDrawable.getPaint().setShader(new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP));
            shapeDrawable.getPaint().setColorFilter(bitmapDrawable.getPaint().getColorFilter());
            return z ? new ClipDrawable(shapeDrawable, 3, 1) : shapeDrawable;
        }
        return drawable;
    }
}

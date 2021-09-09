package androidx.swiperefreshlayout.widget;

import _m_j.cb;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.view.animation.Animation;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;

class CircleImageView extends ImageView {
    private Animation.AnimationListener mListener;
    int mShadowRadius;

    CircleImageView(Context context, int i) {
        super(context);
        ShapeDrawable shapeDrawable;
        float f = getContext().getResources().getDisplayMetrics().density;
        int i2 = (int) (1.75f * f);
        int i3 = (int) (0.0f * f);
        this.mShadowRadius = (int) (3.5f * f);
        if (elevationSupported()) {
            shapeDrawable = new ShapeDrawable(new OvalShape());
            cb.O0000Oo(this, f * 4.0f);
        } else {
            ShapeDrawable shapeDrawable2 = new ShapeDrawable(new O000000o(this.mShadowRadius));
            setLayerType(1, shapeDrawable2.getPaint());
            shapeDrawable2.getPaint().setShadowLayer((float) this.mShadowRadius, (float) i3, (float) i2, 503316480);
            int i4 = this.mShadowRadius;
            setPadding(i4, i4, i4, i4);
            shapeDrawable = shapeDrawable2;
        }
        shapeDrawable.getPaint().setColor(i);
        cb.O000000o(this, shapeDrawable);
    }

    private boolean elevationSupported() {
        return Build.VERSION.SDK_INT >= 21;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (!elevationSupported()) {
            setMeasuredDimension(getMeasuredWidth() + (this.mShadowRadius * 2), getMeasuredHeight() + (this.mShadowRadius * 2));
        }
    }

    public void setAnimationListener(Animation.AnimationListener animationListener) {
        this.mListener = animationListener;
    }

    public void onAnimationStart() {
        super.onAnimationStart();
        Animation.AnimationListener animationListener = this.mListener;
        if (animationListener != null) {
            animationListener.onAnimationStart(getAnimation());
        }
    }

    public void onAnimationEnd() {
        super.onAnimationEnd();
        Animation.AnimationListener animationListener = this.mListener;
        if (animationListener != null) {
            animationListener.onAnimationEnd(getAnimation());
        }
    }

    public void setBackgroundColorRes(int i) {
        setBackgroundColor(ContextCompat.O00000o0(getContext(), i));
    }

    public void setBackgroundColor(int i) {
        if (getBackground() instanceof ShapeDrawable) {
            ((ShapeDrawable) getBackground()).getPaint().setColor(i);
        }
    }

    class O000000o extends OvalShape {
        private RadialGradient O00000Oo;
        private Paint O00000o0 = new Paint();

        O000000o(int i) {
            CircleImageView.this.mShadowRadius = i;
            O000000o((int) rect().width());
        }

        /* access modifiers changed from: protected */
        public final void onResize(float f, float f2) {
            super.onResize(f, f2);
            O000000o((int) f);
        }

        public final void draw(Canvas canvas, Paint paint) {
            int width = CircleImageView.this.getWidth() / 2;
            float f = (float) width;
            float height = (float) (CircleImageView.this.getHeight() / 2);
            canvas.drawCircle(f, height, f, this.O00000o0);
            canvas.drawCircle(f, height, (float) (width - CircleImageView.this.mShadowRadius), paint);
        }

        private void O000000o(int i) {
            float f = (float) (i / 2);
            this.O00000Oo = new RadialGradient(f, f, (float) CircleImageView.this.mShadowRadius, new int[]{1023410176, 0}, (float[]) null, Shader.TileMode.CLAMP);
            this.O00000o0.setShader(this.O00000Oo);
        }
    }
}

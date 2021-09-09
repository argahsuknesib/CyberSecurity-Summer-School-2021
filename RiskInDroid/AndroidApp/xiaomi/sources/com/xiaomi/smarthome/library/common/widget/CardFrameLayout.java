package com.xiaomi.smarthome.library.common.widget;

import _m_j.hyy;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;

public class CardFrameLayout extends FrameLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    public final Path f9145O000000o;
    public O000000o O00000Oo;
    private float O00000o0;

    public interface O000000o {
        float getRadius(CardFrameLayout cardFrameLayout, int i, int i2);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ float O000000o(CardFrameLayout cardFrameLayout, int i, int i2) {
        View childAt = getChildAt(0);
        if (childAt != null && hyy.O000000o()) {
            return ((float) Math.min(childAt.getWidth(), childAt.getHeight())) * 0.05f;
        }
        return 0.0f;
    }

    public CardFrameLayout(Context context) {
        super(context);
        this.f9145O000000o = new Path();
        this.O00000Oo = new O000000o() {
            /* class com.xiaomi.smarthome.library.common.widget.$$Lambda$CardFrameLayout$ciNmX8I5ajmCo8kYAWKQCxP14sU */

            public final float getRadius(CardFrameLayout cardFrameLayout, int i, int i2) {
                return CardFrameLayout.this.O000000o(cardFrameLayout, i, i2);
            }
        };
        this.O00000o0 = -1.0f;
        O000000o((AttributeSet) null);
    }

    public CardFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9145O000000o = new Path();
        this.O00000Oo = new O000000o() {
            /* class com.xiaomi.smarthome.library.common.widget.$$Lambda$CardFrameLayout$ciNmX8I5ajmCo8kYAWKQCxP14sU */

            public final float getRadius(CardFrameLayout cardFrameLayout, int i, int i2) {
                return CardFrameLayout.this.O000000o(cardFrameLayout, i, i2);
            }
        };
        this.O00000o0 = -1.0f;
        O000000o(attributeSet);
    }

    public CardFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f9145O000000o = new Path();
        this.O00000Oo = new O000000o() {
            /* class com.xiaomi.smarthome.library.common.widget.$$Lambda$CardFrameLayout$ciNmX8I5ajmCo8kYAWKQCxP14sU */

            public final float getRadius(CardFrameLayout cardFrameLayout, int i, int i2) {
                return CardFrameLayout.this.O000000o(cardFrameLayout, i, i2);
            }
        };
        this.O00000o0 = -1.0f;
        O000000o(attributeSet);
    }

    @SuppressLint({"NewApi"})
    public CardFrameLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f9145O000000o = new Path();
        this.O00000Oo = new O000000o() {
            /* class com.xiaomi.smarthome.library.common.widget.$$Lambda$CardFrameLayout$ciNmX8I5ajmCo8kYAWKQCxP14sU */

            public final float getRadius(CardFrameLayout cardFrameLayout, int i, int i2) {
                return CardFrameLayout.this.O000000o(cardFrameLayout, i, i2);
            }
        };
        this.O00000o0 = -1.0f;
        O000000o(attributeSet);
    }

    public CardFrameLayout(View view) {
        this(view.getContext());
        addView(view, new FrameLayout.LayoutParams(-1, -1));
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (this.O00000o0 > 0.0f) {
            if (View.MeasureSpec.getMode(i) == 1073741824) {
                i2 = View.MeasureSpec.makeMeasureSpec((int) (((float) View.MeasureSpec.getSize(i)) * this.O00000o0), 1073741824);
            } else if (View.MeasureSpec.getMode(i2) == 1073741824) {
                i = View.MeasureSpec.makeMeasureSpec((int) (((float) View.MeasureSpec.getSize(i2)) / this.O00000o0), 1073741824);
            }
        }
        super.onMeasure(i, i2);
    }

    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return O000000o(super.generateLayoutParams(attributeSet));
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return O000000o((FrameLayout.LayoutParams) super.generateLayoutParams(layoutParams));
    }

    /* access modifiers changed from: protected */
    public FrameLayout.LayoutParams generateDefaultLayoutParams() {
        return O000000o(super.generateDefaultLayoutParams());
    }

    /* access modifiers changed from: protected */
    public FrameLayout.LayoutParams O000000o(FrameLayout.LayoutParams layoutParams) {
        if (getChildCount() != 0) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) getChildAt(0).getLayoutParams();
            layoutParams.height = layoutParams2.height;
            layoutParams.width = layoutParams2.width;
            layoutParams.gravity = layoutParams2.gravity;
            layoutParams.rightMargin = layoutParams2.rightMargin;
            layoutParams.leftMargin = layoutParams2.leftMargin;
            layoutParams.topMargin = layoutParams2.topMargin;
            layoutParams.bottomMargin = layoutParams2.bottomMargin;
        }
        return layoutParams;
    }

    private void O000000o(AttributeSet attributeSet) {
        if (attributeSet != null) {
            this.O00000o0 = attributeSet.getAttributeFloatValue(null, "ratio", -1.0f);
            float attributeFloatValue = attributeSet.getAttributeFloatValue(null, "radius", -1.0f);
            if (attributeFloatValue != -1.0f) {
                this.O00000Oo = new O000000o(attributeFloatValue) {
                    /* class com.xiaomi.smarthome.library.common.widget.$$Lambda$CardFrameLayout$JMFvtA76Clup2MzSWGhnwC7Uh3g */
                    private final /* synthetic */ float f$0;

                    {
                        this.f$0 = r1;
                    }

                    public final float getRadius(CardFrameLayout cardFrameLayout, int i, int i2) {
                        return CardFrameLayout.O000000o(this.f$0, cardFrameLayout, i, i2);
                    }
                };
            }
        }
        this.f9145O000000o.setFillType(Path.FillType.INVERSE_WINDING);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ float O000000o(float f, CardFrameLayout cardFrameLayout, int i, int i2) {
        return f * ((float) Math.min(i, i2));
    }

    public O000000o getRadius() {
        return this.O00000Oo;
    }

    public void addView(final View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (Build.VERSION.SDK_INT >= 21 && getChildCount() == 1) {
            view.setOutlineProvider(new ViewOutlineProvider() {
                /* class com.xiaomi.smarthome.library.common.widget.CardFrameLayout.AnonymousClass1 */

                public final void getOutline(View view, Outline outline) {
                    if (CardFrameLayout.this.O00000Oo != null) {
                        float radius = CardFrameLayout.this.O00000Oo.getRadius(CardFrameLayout.this, view.getWidth(), view.getHeight());
                        float f = radius;
                        outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), f);
                        CardFrameLayout.this.f9145O000000o.reset();
                        CardFrameLayout.this.f9145O000000o.addRoundRect((float) (view.getLeft() + 1), (float) (view.getTop() + 1), (float) (view.getRight() - 1), (float) (view.getBottom() - 1), f, radius, Path.Direction.CW);
                    }
                }
            });
            view.setClipToOutline(true);
        }
    }

    public void setBackgroundColor(int i) {
        setBackground(new ColorDrawable(i) {
            /* class com.xiaomi.smarthome.library.common.widget.CardFrameLayout.AnonymousClass2 */

            public final void draw(Canvas canvas) {
                canvas.clipPath(CardFrameLayout.this.f9145O000000o);
                super.draw(canvas);
            }
        });
    }
}

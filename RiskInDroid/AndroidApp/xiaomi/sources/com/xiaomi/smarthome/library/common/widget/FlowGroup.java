package com.xiaomi.smarthome.library.common.widget;

import _m_j.gri;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.xiaomi.smarthome.R;

public class FlowGroup extends ViewGroup {

    /* renamed from: O000000o  reason: collision with root package name */
    public boolean f9182O000000o = true;
    public O000000o O00000Oo;
    private int O00000o;
    private boolean O00000o0 = true;
    private int O00000oO;
    private int O00000oo = 0;

    public interface O000000o {
        void O000000o(boolean z);
    }

    public FlowGroup(Context context) {
        super(context);
        O000000o();
    }

    public FlowGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o();
    }

    public FlowGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O000000o();
    }

    private void O000000o() {
        this.O00000o = gri.O000000o(16.0f);
        this.O00000oO = gri.O000000o(18.0f);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int childCount = getChildCount();
        if (childCount == 0) {
            super.onMeasure(i, i2);
            return;
        }
        ((ImageView) getChildAt(childCount - 1)).measure(0, 0);
        boolean z = true;
        int i3 = 0;
        int i4 = 0;
        int i5 = 1;
        int i6 = 0;
        while (true) {
            if (i3 >= childCount) {
                break;
            }
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                childAt.measure(0, 0);
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = getChildAt(0).getMeasuredHeight() + this.O00000oO;
                if (i4 + measuredWidth > size) {
                    if (i5 < 3 || this.O00000o0) {
                        i5++;
                        i6 += measuredHeight;
                        i4 = 0;
                    } else if (i3 < childCount) {
                        z = false;
                    }
                }
                i4 += measuredWidth + this.O00000o;
            }
            i3++;
        }
        this.f9182O000000o = z;
        this.O00000oo = i5;
        setMeasuredDimension(size, i6 + getChildAt(0).getMeasuredHeight() + gri.O000000o(26.0f));
    }

    public void setExpand(boolean z) {
        this.O00000o0 = z;
        requestLayout();
        invalidate();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0061 A[EDGE_INSN: B:29:0x0061->B:20:0x0061 ?: BREAK  , SYNTHETIC] */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2;
        int childCount = getChildCount();
        if (childCount != 0) {
            int i5 = i3 - i;
            int i6 = childCount - 1;
            ImageView imageView = (ImageView) getChildAt(i6);
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            int measuredWidth = imageView.getMeasuredWidth();
            int i7 = 1;
            int i8 = 0;
            int i9 = 0;
            for (int i10 = 0; i10 < i6; i10++) {
                View childAt = getChildAt(i10);
                if (childAt.getVisibility() != 8) {
                    int measuredWidth2 = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (i7 >= this.O00000oo) {
                        int i11 = i8 + measuredWidth2;
                        if (this.O00000o + i11 + measuredWidth >= i5 && i11 >= i5) {
                            z2 = true;
                            if (!z2) {
                                break;
                            }
                            if (i8 + measuredWidth2 > i5) {
                                i7++;
                                i9 += this.O00000oO + measuredHeight;
                                i8 = 0;
                            }
                            childAt.layout(i8, i9, i8 + measuredWidth2, measuredHeight + i9);
                            i8 += measuredWidth2 + this.O00000o;
                        }
                    }
                    z2 = false;
                    if (!z2) {
                    }
                }
            }
            if (!this.f9182O000000o) {
                imageView.setImageResource(R.drawable.choose_tag_more);
            } else {
                imageView.setImageResource(R.drawable.choose_tag_add);
            }
            if (imageView.getMeasuredWidth() + i8 > i5) {
                i9 += getChildAt(0).getMeasuredHeight() + this.O00000oO;
                i8 = 0;
            }
            imageView.layout(i8, i9, imageView.getMeasuredWidth() + i8, getChildAt(0).getMeasuredHeight() + i9);
            imageView.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.library.common.widget.FlowGroup.AnonymousClass1 */

                public final void onClick(View view) {
                    if (FlowGroup.this.O00000Oo != null) {
                        FlowGroup.this.O00000Oo.O000000o(FlowGroup.this.f9182O000000o);
                    }
                }
            });
        }
    }

    public void setMoreClickListener(O000000o o000000o) {
        this.O00000Oo = o000000o;
    }
}

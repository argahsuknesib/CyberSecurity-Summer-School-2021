package com.xiaomi.smarthome.miui;

import _m_j.ggb;
import _m_j.gpc;
import _m_j.gyv;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.homeroom.model.GridViewData;
import com.xiaomi.smarthome.homeroom.model.Home;
import java.util.Arrays;

public class AutoMaskLinearLayout extends LinearLayout {
    private static final AccelerateDecelerateInterpolator O0000o00 = new AccelerateDecelerateInterpolator();

    /* renamed from: O000000o  reason: collision with root package name */
    Paint f9987O000000o = new Paint(1);
    Paint O00000Oo = new Paint(1);
    boolean O00000o = false;
    int[] O00000o0 = new int[2];
    boolean O00000oO = true;
    boolean O00000oo = false;
    private int O0000O0o = 0;
    private RecyclerView O0000OOo;
    private long O0000Oo = 0;
    private boolean O0000Oo0 = false;
    private int[] O0000OoO = new int[2];
    private Rect O0000Ooo = null;

    public AutoMaskLinearLayout(Context context) {
        super(context);
        this.f9987O000000o.setColor(getResources().getColor(R.color.mj_color_white_30_transparent));
        this.O00000Oo.setTextSize((float) gpc.O000000o(getContext(), 11.0f));
        this.O00000Oo.setColor(getResources().getColor(R.color.mj_color_white_80_transparent));
        setWillNotDraw(false);
    }

    public AutoMaskLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9987O000000o.setColor(getResources().getColor(R.color.mj_color_white_30_transparent));
        this.O00000Oo.setTextSize((float) gpc.O000000o(getContext(), 11.0f));
        this.O00000Oo.setColor(getResources().getColor(R.color.mj_color_white_80_transparent));
        setWillNotDraw(false);
    }

    public AutoMaskLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f9987O000000o.setColor(getResources().getColor(R.color.mj_color_white_30_transparent));
        this.O00000Oo.setTextSize((float) gpc.O000000o(getContext(), 11.0f));
        this.O00000Oo.setColor(getResources().getColor(R.color.mj_color_white_80_transparent));
        setWillNotDraw(false);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.O00000oO) {
            canvas.save();
            canvas.drawRect(0.0f, 0.0f, (float) getWidth(), (float) getHeight(), this.f9987O000000o);
            String string = getResources().getString(R.string.common_device_loading);
            canvas.drawText(string, (((float) getWidth()) - this.O00000Oo.measureText(string)) / 2.0f, (float) (getHeight() / 2), this.O00000Oo);
            canvas.restore();
        } else if (this.O00000o) {
            canvas.save();
            int i = this.O0000O0o > gyv.f18590O000000o ? gyv.f18590O000000o : this.O0000O0o;
            String quantityString = getResources().getQuantityString(R.plurals.drag_tips, i, Integer.valueOf(i));
            Home O0000Oo02 = ggb.O00000Oo().O0000Oo0();
            if (O0000Oo02 != null && !O0000Oo02.isOwner()) {
                quantityString = getResources().getString(R.string.share_home_edit_device_tips);
            }
            String str = quantityString;
            float width = (((float) getWidth()) - this.O00000Oo.measureText(str)) / 2.0f;
            if (this.O0000Oo0) {
                long currentTimeMillis = System.currentTimeMillis();
                long j = this.O0000Oo;
                if (300 + j < currentTimeMillis) {
                    this.O0000Oo0 = false;
                    canvas.drawRect(0.0f, (float) this.O00000o0[1], (float) getWidth(), (float) getHeight(), this.f9987O000000o);
                    RecyclerView recyclerView = this.O0000OOo;
                    if (recyclerView != null && ((float) this.O00000o0[0]) > recyclerView.getY()) {
                        canvas.drawText(str, width, ((float) this.O00000o0[0]) + this.O00000Oo.getFontSpacing(), this.O00000Oo);
                    }
                } else {
                    float interpolation = O0000o00.getInterpolation(((float) (currentTimeMillis - j)) / 300.0f);
                    int[] iArr = this.O0000OoO;
                    canvas.drawRect(0.0f, (float) ((int) (((float) iArr[1]) + (((float) (this.O00000o0[1] - iArr[1])) * interpolation))), (float) getWidth(), (float) getHeight(), this.f9987O000000o);
                    RecyclerView recyclerView2 = this.O0000OOo;
                    if (recyclerView2 != null && ((float) this.O00000o0[0]) > recyclerView2.getY()) {
                        int[] iArr2 = this.O0000OoO;
                        canvas.drawText(str, width, ((float) ((int) (((float) iArr2[0]) + (((float) (this.O00000o0[0] - iArr2[0])) * interpolation)))) + this.O00000Oo.getFontSpacing(), this.O00000Oo);
                    }
                    postInvalidate();
                }
            } else {
                canvas.drawRect(0.0f, (float) this.O00000o0[1], (float) getWidth(), (float) getHeight(), this.f9987O000000o);
                RecyclerView recyclerView3 = this.O0000OOo;
                if (recyclerView3 != null && ((float) this.O00000o0[0]) > recyclerView3.getY()) {
                    canvas.drawText(str, width, ((float) this.O00000o0[0]) + this.O00000Oo.getFontSpacing(), this.O00000Oo);
                }
            }
            if (this.O00000oo) {
                Drawable drawable = getResources().getDrawable(R.drawable.common_item_camera_pos_bg);
                drawable.setBounds(this.O0000Ooo);
                drawable.draw(canvas);
            }
            canvas.restore();
        } else {
            canvas.save();
            canvas.drawRect(0.0f, (float) this.O00000o0[1], (float) getWidth(), (float) getHeight(), this.f9987O000000o);
            canvas.restore();
            this.O0000OoO = Arrays.copyOf(this.O00000o0, 2);
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                if (getChildAt(i2) instanceof RecyclerView) {
                    this.O0000OOo = (RecyclerView) getChildAt(i2);
                    RecyclerView.LayoutManager layoutManager = this.O0000OOo.getLayoutManager();
                    int i3 = 0;
                    while (i3 < layoutManager.getChildCount()) {
                        View childAt = layoutManager.getChildAt(i3);
                        if (childAt == null || layoutManager.getItemViewType(childAt) != GridViewData.GridType.TYPE_TIPS.ordinal()) {
                            i3++;
                        } else {
                            this.O00000o0[0] = ((int) (this.O0000OOo.getY() + ((float) childAt.getTop()))) + gpc.O00000o0(getContext(), 8.0f);
                            this.O00000o0[1] = ((int) (this.O0000OOo.getY() + ((float) childAt.getBottom()))) - gpc.O00000o0(getContext(), 7.0f);
                            if (this.O0000Oo0) {
                                this.O0000Oo = System.currentTimeMillis();
                            }
                            invalidate();
                            this.O00000o = true;
                            return;
                        }
                    }
                    return;
                }
            }
        }
    }

    public void setScrolledY(int i) {
        int[] iArr = this.O00000o0;
        iArr[0] = iArr[0] + i;
        iArr[1] = iArr[1] + i;
    }

    public void setDeviceCount(int i) {
        if (this.O0000O0o != i) {
            this.O00000o = false;
        }
        this.O0000O0o = i;
    }

    public void setShowLoading(boolean z) {
        this.O00000oO = z;
    }
}

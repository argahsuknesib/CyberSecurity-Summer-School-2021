package _m_j;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.List;

public final class gs extends RecyclerView.O0000Oo implements RecyclerView.O0000o00 {

    /* renamed from: O000000o  reason: collision with root package name */
    final List<View> f18192O000000o = new ArrayList();
    RecyclerView.O000OOo0 O00000Oo = null;
    float O00000o;
    float O00000o0;
    float O00000oO;
    float O00000oo;
    float O0000O0o;
    float O0000OOo;
    O000000o O0000Oo;
    int O0000Oo0 = -1;
    int O0000OoO;
    List<O00000o0> O0000Ooo = new ArrayList();
    int O0000o = -1;
    final Runnable O0000o0 = new Runnable() {
        /* class _m_j.gs.AnonymousClass1 */

        /* JADX WARNING: Code restructure failed: missing block: B:32:0x00cc, code lost:
            if (r2 > 0) goto L_0x00d0;
         */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x008d  */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x00d2  */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x00ec  */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x0108  */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x0113  */
        /* JADX WARNING: Removed duplicated region for block: B:48:0x0120  */
        /* JADX WARNING: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
        public final void run() {
            int i;
            int i2;
            int i3;
            int width;
            if (gs.this.O00000Oo != null) {
                gs gsVar = gs.this;
                boolean z = false;
                if (gsVar.O00000Oo != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = gsVar.O0000oOO == Long.MIN_VALUE ? 0 : currentTimeMillis - gsVar.O0000oOO;
                    RecyclerView.LayoutManager layoutManager = gsVar.O0000o00.getLayoutManager();
                    if (gsVar.O0000oO == null) {
                        gsVar.O0000oO = new Rect();
                    }
                    layoutManager.calculateItemDecorationsForChild(gsVar.O00000Oo.itemView, gsVar.O0000oO);
                    if (layoutManager.canScrollHorizontally()) {
                        int i4 = (int) (gsVar.O0000O0o + gsVar.O00000oO);
                        int paddingLeft = (i4 - gsVar.O0000oO.left) - gsVar.O0000o00.getPaddingLeft();
                        if (gsVar.O00000oO < 0.0f && paddingLeft < 0) {
                            i = paddingLeft;
                            if (layoutManager.canScrollVertically()) {
                            }
                            i2 = 0;
                            if (i != 0) {
                            }
                            int i5 = i;
                            if (i2 == 0) {
                            }
                            if (gsVar.O0000oOO == Long.MIN_VALUE) {
                            }
                            gsVar.O0000o00.scrollBy(i3, i2);
                            z = true;
                            if (z) {
                            }
                        } else if (gsVar.O00000oO > 0.0f && (width = ((i4 + gsVar.O00000Oo.itemView.getWidth()) + gsVar.O0000oO.right) - (gsVar.O0000o00.getWidth() - gsVar.O0000o00.getPaddingRight())) > 0) {
                            i = width;
                            if (layoutManager.canScrollVertically()) {
                                int i6 = (int) (gsVar.O0000OOo + gsVar.O00000oo);
                                int paddingTop = (i6 - gsVar.O0000oO.top) - gsVar.O0000o00.getPaddingTop();
                                if (gsVar.O00000oo < 0.0f && paddingTop < 0) {
                                    i2 = paddingTop;
                                    if (i != 0) {
                                        i = gsVar.O0000Oo.O000000o(gsVar.O0000o00, gsVar.O00000Oo.itemView.getWidth(), i, gsVar.O0000o00.getWidth(), j);
                                    }
                                    int i52 = i;
                                    if (i2 == 0) {
                                        i3 = i52;
                                        i2 = gsVar.O0000Oo.O000000o(gsVar.O0000o00, gsVar.O00000Oo.itemView.getHeight(), i2, gsVar.O0000o00.getHeight(), j);
                                    } else {
                                        i3 = i52;
                                    }
                                    if (!(i3 == 0 && i2 == 0)) {
                                        if (gsVar.O0000oOO == Long.MIN_VALUE) {
                                            gsVar.O0000oOO = currentTimeMillis;
                                        }
                                        gsVar.O0000o00.scrollBy(i3, i2);
                                        z = true;
                                        if (z) {
                                            if (gs.this.O00000Oo != null) {
                                                gs gsVar2 = gs.this;
                                                gsVar2.O000000o(gsVar2.O00000Oo);
                                            }
                                            gs.this.O0000o00.removeCallbacks(gs.this.O0000o0);
                                            cb.O000000o(gs.this.O0000o00, this);
                                            return;
                                        }
                                        return;
                                    }
                                } else if (gsVar.O00000oo > 0.0f) {
                                    i2 = ((i6 + gsVar.O00000Oo.itemView.getHeight()) + gsVar.O0000oO.bottom) - (gsVar.O0000o00.getHeight() - gsVar.O0000o00.getPaddingBottom());
                                }
                            }
                            i2 = 0;
                            if (i != 0) {
                            }
                            int i522 = i;
                            if (i2 == 0) {
                            }
                            if (gsVar.O0000oOO == Long.MIN_VALUE) {
                            }
                            gsVar.O0000o00.scrollBy(i3, i2);
                            z = true;
                            if (z) {
                            }
                        }
                    }
                    i = 0;
                    if (layoutManager.canScrollVertically()) {
                    }
                    i2 = 0;
                    if (i != 0) {
                    }
                    int i5222 = i;
                    if (i2 == 0) {
                    }
                    if (gsVar.O0000oOO == Long.MIN_VALUE) {
                    }
                    gsVar.O0000o00.scrollBy(i3, i2);
                    z = true;
                    if (z) {
                    }
                }
                gsVar.O0000oOO = Long.MIN_VALUE;
                if (z) {
                }
            }
        }
    };
    RecyclerView O0000o00;
    VelocityTracker O0000o0O;
    View O0000o0o = null;
    Rect O0000oO;
    bj O0000oO0;
    long O0000oOO;
    private final float[] O0000oOo = new float[2];
    private float O0000oo;
    private float O0000oo0;
    private int O0000ooO = 0;
    private int O0000ooo;
    private RecyclerView.O00000o O000O00o = null;
    private O00000Oo O000O0OO;
    private final RecyclerView.O0000o O000O0Oo = new RecyclerView.O0000o() {
        /* class _m_j.gs.AnonymousClass2 */

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.gs.O000000o(androidx.recyclerview.widget.RecyclerView$O000OOo0, boolean):void
         arg types: [androidx.recyclerview.widget.RecyclerView$O000OOo0, int]
         candidates:
          _m_j.gs.O000000o(androidx.recyclerview.widget.RecyclerView$O000OOo0, int):void
          _m_j.gs.O000000o(androidx.recyclerview.widget.RecyclerView$O000OOo0, boolean):void */
        public final boolean O000000o(RecyclerView recyclerView, MotionEvent motionEvent) {
            int findPointerIndex;
            gs.this.O0000oO0.O000000o(motionEvent);
            int actionMasked = motionEvent.getActionMasked();
            O00000o0 o00000o0 = null;
            if (actionMasked == 0) {
                gs.this.O0000Oo0 = motionEvent.getPointerId(0);
                gs.this.O00000o0 = motionEvent.getX();
                gs.this.O00000o = motionEvent.getY();
                gs.this.O000000o();
                if (gs.this.O00000Oo == null) {
                    gs gsVar = gs.this;
                    if (!gsVar.O0000Ooo.isEmpty()) {
                        View O000000o2 = gsVar.O000000o(motionEvent);
                        int size = gsVar.O0000Ooo.size() - 1;
                        while (true) {
                            if (size < 0) {
                                break;
                            }
                            O00000o0 o00000o02 = gsVar.O0000Ooo.get(size);
                            if (o00000o02.O0000OOo.itemView == O000000o2) {
                                o00000o0 = o00000o02;
                                break;
                            }
                            size--;
                        }
                    }
                    if (o00000o0 != null) {
                        gs.this.O00000o0 -= o00000o0.O0000o00;
                        gs.this.O00000o -= o00000o0.O0000o0;
                        gs.this.O000000o(o00000o0.O0000OOo, true);
                        if (gs.this.f18192O000000o.remove(o00000o0.O0000OOo.itemView)) {
                            gs.this.O0000Oo.O00000o(gs.this.O0000o00, o00000o0.O0000OOo);
                        }
                        gs.this.O000000o(o00000o0.O0000OOo, o00000o0.O0000Oo0);
                        gs gsVar2 = gs.this;
                        gsVar2.O000000o(motionEvent, gsVar2.O0000OoO, 0);
                    }
                }
            } else if (actionMasked == 3 || actionMasked == 1) {
                gs gsVar3 = gs.this;
                gsVar3.O0000Oo0 = -1;
                gsVar3.O000000o((RecyclerView.O000OOo0) null, 0);
            } else if (gs.this.O0000Oo0 != -1 && (findPointerIndex = motionEvent.findPointerIndex(gs.this.O0000Oo0)) >= 0) {
                gs.this.O000000o(actionMasked, motionEvent, findPointerIndex);
            }
            if (gs.this.O0000o0O != null) {
                gs.this.O0000o0O.addMovement(motionEvent);
            }
            return gs.this.O00000Oo != null;
        }

        public final void O00000Oo(RecyclerView recyclerView, MotionEvent motionEvent) {
            gs.this.O0000oO0.O000000o(motionEvent);
            if (gs.this.O0000o0O != null) {
                gs.this.O0000o0O.addMovement(motionEvent);
            }
            if (gs.this.O0000Oo0 != -1) {
                int actionMasked = motionEvent.getActionMasked();
                int findPointerIndex = motionEvent.findPointerIndex(gs.this.O0000Oo0);
                if (findPointerIndex >= 0) {
                    gs.this.O000000o(actionMasked, motionEvent, findPointerIndex);
                }
                RecyclerView.O000OOo0 o000OOo0 = gs.this.O00000Oo;
                if (o000OOo0 != null) {
                    int i = 0;
                    if (actionMasked != 1) {
                        if (actionMasked != 2) {
                            if (actionMasked != 3) {
                                if (actionMasked == 6) {
                                    int actionIndex = motionEvent.getActionIndex();
                                    if (motionEvent.getPointerId(actionIndex) == gs.this.O0000Oo0) {
                                        if (actionIndex == 0) {
                                            i = 1;
                                        }
                                        gs.this.O0000Oo0 = motionEvent.getPointerId(i);
                                        gs gsVar = gs.this;
                                        gsVar.O000000o(motionEvent, gsVar.O0000OoO, actionIndex);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            } else if (gs.this.O0000o0O != null) {
                                gs.this.O0000o0O.clear();
                            }
                        } else if (findPointerIndex >= 0) {
                            gs gsVar2 = gs.this;
                            gsVar2.O000000o(motionEvent, gsVar2.O0000OoO, findPointerIndex);
                            gs.this.O000000o(o000OOo0);
                            gs.this.O0000o00.removeCallbacks(gs.this.O0000o0);
                            gs.this.O0000o0.run();
                            gs.this.O0000o00.invalidate();
                            return;
                        } else {
                            return;
                        }
                    }
                    gs.this.O000000o((RecyclerView.O000OOo0) null, 0);
                    gs.this.O0000Oo0 = -1;
                }
            }
        }

        public final void O000000o(boolean z) {
            if (z) {
                gs.this.O000000o((RecyclerView.O000OOo0) null, 0);
            }
        }
    };
    private List<RecyclerView.O000OOo0> O00oOooO;
    private List<Integer> O00oOooo;

    public interface O00000o {
        void prepareForDrop(View view, View view2, int i, int i2);
    }

    public final void O000000o(View view) {
    }

    public gs(O000000o o000000o) {
        this.O0000Oo = o000000o;
    }

    private static boolean O000000o(View view, float f, float f2, float f3, float f4) {
        return f >= f3 && f <= f3 + ((float) view.getWidth()) && f2 >= f4 && f2 <= f4 + ((float) view.getHeight());
    }

    public final void O000000o(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.O0000o00;
        if (recyclerView2 != recyclerView) {
            if (recyclerView2 != null) {
                recyclerView2.removeItemDecoration(this);
                this.O0000o00.removeOnItemTouchListener(this.O000O0Oo);
                this.O0000o00.removeOnChildAttachStateChangeListener(this);
                int size = this.O0000Ooo.size();
                while (true) {
                    size--;
                    if (size < 0) {
                        break;
                    }
                    this.O0000Oo.O00000o(this.O0000o00, this.O0000Ooo.get(0).O0000OOo);
                }
                this.O0000Ooo.clear();
                this.O0000o0o = null;
                this.O0000o = -1;
                O00000Oo();
                O00000Oo o00000Oo = this.O000O0OO;
                if (o00000Oo != null) {
                    o00000Oo.f18199O000000o = false;
                    this.O000O0OO = null;
                }
                if (this.O0000oO0 != null) {
                    this.O0000oO0 = null;
                }
            }
            this.O0000o00 = recyclerView;
            if (recyclerView != null) {
                Resources resources = recyclerView.getResources();
                this.O0000oo0 = resources.getDimension(R.dimen.item_touch_helper_swipe_escape_velocity);
                this.O0000oo = resources.getDimension(R.dimen.item_touch_helper_swipe_escape_max_velocity);
                this.O0000ooo = ViewConfiguration.get(this.O0000o00.getContext()).getScaledTouchSlop();
                this.O0000o00.addItemDecoration(this);
                this.O0000o00.addOnItemTouchListener(this.O000O0Oo);
                this.O0000o00.addOnChildAttachStateChangeListener(this);
                this.O000O0OO = new O00000Oo();
                this.O0000oO0 = new bj(this.O0000o00.getContext(), this.O000O0OO);
            }
        }
    }

    private void O000000o(float[] fArr) {
        if ((this.O0000OoO & 12) != 0) {
            fArr[0] = (this.O0000O0o + this.O00000oO) - ((float) this.O00000Oo.itemView.getLeft());
        } else {
            fArr[0] = this.O00000Oo.itemView.getTranslationX();
        }
        if ((this.O0000OoO & 3) != 0) {
            fArr[1] = (this.O0000OOo + this.O00000oo) - ((float) this.O00000Oo.itemView.getTop());
        } else {
            fArr[1] = this.O00000Oo.itemView.getTranslationY();
        }
    }

    public final void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.O000OO0o o000OO0o) {
        if (this.O00000Oo != null) {
            O000000o(this.O0000oOo);
        }
        RecyclerView.O000OOo0 o000OOo0 = this.O00000Oo;
        List<O00000o0> list = this.O0000Ooo;
        int size = list.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            list.get(i);
            int save = canvas.save();
            O000000o.O00000Oo();
            canvas.restoreToCount(save);
        }
        if (o000OOo0 != null) {
            int save2 = canvas.save();
            O000000o.O00000Oo();
            canvas.restoreToCount(save2);
        }
        for (int i2 = size - 1; i2 >= 0; i2--) {
            O00000o0 o00000o0 = list.get(i2);
            if (o00000o0.O0000o0o && !o00000o0.O0000Ooo) {
                list.remove(i2);
            } else if (!o00000o0.O0000o0o) {
                z = true;
            }
        }
        if (z) {
            recyclerView.invalidate();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gs.O000000o.O000000o(android.graphics.Canvas, androidx.recyclerview.widget.RecyclerView, androidx.recyclerview.widget.RecyclerView$O000OOo0, float, float, int, boolean):void
     arg types: [android.graphics.Canvas, androidx.recyclerview.widget.RecyclerView, androidx.recyclerview.widget.RecyclerView$O000OOo0, float, float, int, int]
     candidates:
      _m_j.gs.O000000o.O000000o(androidx.recyclerview.widget.RecyclerView, androidx.recyclerview.widget.RecyclerView$O000OOo0, int, androidx.recyclerview.widget.RecyclerView$O000OOo0, int, int, int):void
      _m_j.gs.O000000o.O000000o(android.graphics.Canvas, androidx.recyclerview.widget.RecyclerView, androidx.recyclerview.widget.RecyclerView$O000OOo0, float, float, int, boolean):void */
    public final void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.O000OO0o o000OO0o) {
        float f;
        float f2;
        Canvas canvas2 = canvas;
        this.O0000o = -1;
        if (this.O00000Oo != null) {
            O000000o(this.O0000oOo);
            float[] fArr = this.O0000oOo;
            float f3 = fArr[0];
            f = fArr[1];
            f2 = f3;
        } else {
            f2 = 0.0f;
            f = 0.0f;
        }
        O000000o o000000o = this.O0000Oo;
        RecyclerView.O000OOo0 o000OOo0 = this.O00000Oo;
        List<O00000o0> list = this.O0000Ooo;
        int i = this.O0000ooO;
        int i2 = 0;
        for (int size = list.size(); i2 < size; size = size) {
            O00000o0 o00000o0 = list.get(i2);
            if (o00000o0.O00000o == o00000o0.O00000oo) {
                o00000o0.O0000o00 = o00000o0.O0000OOo.itemView.getTranslationX();
            } else {
                o00000o0.O0000o00 = o00000o0.O00000o + (o00000o0.O0000o * (o00000o0.O00000oo - o00000o0.O00000o));
            }
            if (o00000o0.O00000oO == o00000o0.O0000O0o) {
                o00000o0.O0000o0 = o00000o0.O0000OOo.itemView.getTranslationY();
            } else {
                o00000o0.O0000o0 = o00000o0.O00000oO + (o00000o0.O0000o * (o00000o0.O0000O0o - o00000o0.O00000oO));
            }
            int save = canvas.save();
            RecyclerView.O000OOo0 o000OOo02 = o00000o0.O0000OOo;
            float f4 = o00000o0.O0000o00;
            float f5 = o00000o0.O0000o0;
            int i3 = save;
            float f6 = f5;
            int i4 = i2;
            o000000o.O000000o(canvas, recyclerView, o000OOo02, f4, f6, o00000o0.O0000Oo0, false);
            canvas2.restoreToCount(i3);
            i2 = i4 + 1;
        }
        if (o000OOo0 != null) {
            int save2 = canvas.save();
            o000000o.O000000o(canvas, recyclerView, o000OOo0, f2, f, i, true);
            canvas2.restoreToCount(save2);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gs.O000000o(androidx.recyclerview.widget.RecyclerView$O000OOo0, boolean):void
     arg types: [androidx.recyclerview.widget.RecyclerView$O000OOo0, int]
     candidates:
      _m_j.gs.O000000o(androidx.recyclerview.widget.RecyclerView$O000OOo0, int):void
      _m_j.gs.O000000o(androidx.recyclerview.widget.RecyclerView$O000OOo0, boolean):void */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00a4, code lost:
        if (r0 > 0) goto L_0x00a6;
     */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00ce A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x010b  */
    public final void O000000o(RecyclerView.O000OOo0 o000OOo0, int i) {
        boolean z;
        boolean z2;
        int i2;
        float f;
        float f2;
        int i3;
        int O000000o2;
        RecyclerView.O000OOo0 o000OOo02 = o000OOo0;
        int i4 = i;
        if (o000OOo02 != this.O00000Oo || i4 != this.O0000ooO) {
            this.O0000oOO = Long.MIN_VALUE;
            int i5 = this.O0000ooO;
            O000000o(o000OOo02, true);
            this.O0000ooO = i4;
            if (i4 == 2) {
                if (o000OOo02 != null) {
                    this.O0000o0o = o000OOo02.itemView;
                    if (Build.VERSION.SDK_INT < 21) {
                        if (this.O000O00o == null) {
                            this.O000O00o = new RecyclerView.O00000o() {
                                /* class _m_j.gs.AnonymousClass5 */

                                public final int O000000o(int i, int i2) {
                                    if (gs.this.O0000o0o == null) {
                                        return i2;
                                    }
                                    int i3 = gs.this.O0000o;
                                    if (i3 == -1) {
                                        i3 = gs.this.O0000o00.indexOfChild(gs.this.O0000o0o);
                                        gs.this.O0000o = i3;
                                    }
                                    if (i2 == i - 1) {
                                        return i3;
                                    }
                                    return i2 < i3 ? i2 : i2 + 1;
                                }
                            };
                        }
                        this.O0000o00.setChildDrawingOrderCallback(this.O000O00o);
                    }
                } else {
                    throw new IllegalArgumentException("Must pass a ViewHolder when dragging");
                }
            }
            int i6 = (1 << ((i4 * 8) + 8)) - 1;
            RecyclerView.O000OOo0 o000OOo03 = this.O00000Oo;
            if (o000OOo03 != null) {
                if (o000OOo03.itemView.getParent() != null) {
                    if (!(i5 == 2 || this.O0000ooO == 2)) {
                        int O000000o3 = this.O0000Oo.O000000o(this.O0000o00, o000OOo03);
                        int O00000Oo2 = (O000000o.O00000Oo(O000000o3, cb.O0000Oo0(this.O0000o00)) & 65280) >> 8;
                        if (O00000Oo2 != 0) {
                            int i7 = (O000000o3 & 65280) >> 8;
                            if (Math.abs(this.O00000oO) > Math.abs(this.O00000oo)) {
                                i3 = O000000o(O00000Oo2);
                                if (i3 > 0) {
                                    if ((i7 & i3) == 0) {
                                        O000000o2 = O000000o.O000000o(i3, cb.O0000Oo0(this.O0000o00));
                                    }
                                    i2 = i3;
                                    O00000Oo();
                                    if (i2 != 1 || i2 == 2) {
                                        f = Math.signum(this.O00000oo) * ((float) this.O0000o00.getHeight());
                                        f2 = 0.0f;
                                    } else {
                                        if (i2 == 4 || i2 == 8 || i2 == 16 || i2 == 32) {
                                            f2 = Math.signum(this.O00000oO) * ((float) this.O0000o00.getWidth());
                                        } else {
                                            f2 = 0.0f;
                                        }
                                        f = 0.0f;
                                    }
                                    int i8 = i5 == 2 ? 8 : i2 > 0 ? 2 : 4;
                                    O000000o(this.O0000oOo);
                                    float[] fArr = this.O0000oOo;
                                    AnonymousClass3 r14 = r0;
                                    z = false;
                                    RecyclerView.O000OOo0 o000OOo04 = o000OOo03;
                                    final int i9 = i2;
                                    final RecyclerView.O000OOo0 o000OOo05 = o000OOo04;
                                    AnonymousClass3 r0 = new O00000o0(o000OOo03, i8, i5, fArr[0], fArr[1], f2, f) {
                                        /* class _m_j.gs.AnonymousClass3 */

                                        public final void onAnimationEnd(Animator animator) {
                                            super.onAnimationEnd(animator);
                                            if (!this.O0000o0O) {
                                                if (i9 <= 0) {
                                                    gs.this.O0000Oo.O00000o(gs.this.O0000o00, o000OOo05);
                                                } else {
                                                    gs.this.f18192O000000o.add(o000OOo05.itemView);
                                                    this.O0000Ooo = true;
                                                    int i = i9;
                                                    if (i > 0) {
                                                        gs gsVar = gs.this;
                                                        gsVar.O0000o00.post(new Runnable(this, i) {
                                                            /* class _m_j.gs.AnonymousClass4 */

                                                            /* renamed from: O000000o  reason: collision with root package name */
                                                            final /* synthetic */ O00000o0 f18196O000000o;
                                                            final /* synthetic */ int O00000Oo;

                                                            {
                                                                this.f18196O000000o = r2;
                                                                this.O00000Oo = r3;
                                                            }

                                                            public final void run() {
                                                                if (gs.this.O0000o00 != null && gs.this.O0000o00.isAttachedToWindow() && !this.f18196O000000o.O0000o0O && this.f18196O000000o.O0000OOo.getAdapterPosition() != -1) {
                                                                    RecyclerView.O0000OOo itemAnimator = gs.this.O0000o00.getItemAnimator();
                                                                    if (itemAnimator == null || !itemAnimator.O00000Oo()) {
                                                                        gs gsVar = gs.this;
                                                                        int size = gsVar.O0000Ooo.size();
                                                                        boolean z = false;
                                                                        int i = 0;
                                                                        while (true) {
                                                                            if (i >= size) {
                                                                                break;
                                                                            } else if (!gsVar.O0000Ooo.get(i).O0000o0o) {
                                                                                z = true;
                                                                                break;
                                                                            } else {
                                                                                i++;
                                                                            }
                                                                        }
                                                                        if (!z) {
                                                                            gs.this.O0000Oo.O000000o(this.f18196O000000o.O0000OOo);
                                                                            return;
                                                                        }
                                                                    }
                                                                    gs.this.O0000o00.post(this);
                                                                }
                                                            }
                                                        });
                                                    }
                                                }
                                                if (gs.this.O0000o0o == o000OOo05.itemView) {
                                                    gs.this.O00000o0(o000OOo05.itemView);
                                                }
                                            }
                                        }
                                    };
                                    r14.O0000Oo.setDuration(O000000o.O000000o(this.O0000o00, i8));
                                    this.O0000Ooo.add(r14);
                                    r14.O0000OOo.setIsRecyclable(false);
                                    r14.O0000Oo.start();
                                    z2 = true;
                                } else {
                                    O000000o2 = O00000Oo(O00000Oo2);
                                }
                            } else {
                                i3 = O00000Oo(O00000Oo2);
                                if (i3 <= 0) {
                                    int O000000o4 = O000000o(O00000Oo2);
                                    if (O000000o4 > 0) {
                                        if ((i7 & O000000o4) == 0) {
                                            O000000o2 = O000000o.O000000o(O000000o4, cb.O0000Oo0(this.O0000o00));
                                        } else {
                                            i2 = O000000o4;
                                            O00000Oo();
                                            if (i2 != 1) {
                                            }
                                            f = Math.signum(this.O00000oo) * ((float) this.O0000o00.getHeight());
                                            f2 = 0.0f;
                                            if (i5 == 2) {
                                            }
                                            O000000o(this.O0000oOo);
                                            float[] fArr2 = this.O0000oOo;
                                            AnonymousClass3 r142 = r0;
                                            z = false;
                                            RecyclerView.O000OOo0 o000OOo042 = o000OOo03;
                                            final int i92 = i2;
                                            final RecyclerView.O000OOo0 o000OOo052 = o000OOo042;
                                            AnonymousClass3 r02 = new O00000o0(o000OOo03, i8, i5, fArr2[0], fArr2[1], f2, f) {
                                                /* class _m_j.gs.AnonymousClass3 */

                                                public final void onAnimationEnd(Animator animator) {
                                                    super.onAnimationEnd(animator);
                                                    if (!this.O0000o0O) {
                                                        if (i92 <= 0) {
                                                            gs.this.O0000Oo.O00000o(gs.this.O0000o00, o000OOo052);
                                                        } else {
                                                            gs.this.f18192O000000o.add(o000OOo052.itemView);
                                                            this.O0000Ooo = true;
                                                            int i = i92;
                                                            if (i > 0) {
                                                                gs gsVar = gs.this;
                                                                gsVar.O0000o00.post(new Runnable(this, i) {
                                                                    /* class _m_j.gs.AnonymousClass4 */

                                                                    /* renamed from: O000000o  reason: collision with root package name */
                                                                    final /* synthetic */ O00000o0 f18196O000000o;
                                                                    final /* synthetic */ int O00000Oo;

                                                                    {
                                                                        this.f18196O000000o = r2;
                                                                        this.O00000Oo = r3;
                                                                    }

                                                                    public final void run() {
                                                                        if (gs.this.O0000o00 != null && gs.this.O0000o00.isAttachedToWindow() && !this.f18196O000000o.O0000o0O && this.f18196O000000o.O0000OOo.getAdapterPosition() != -1) {
                                                                            RecyclerView.O0000OOo itemAnimator = gs.this.O0000o00.getItemAnimator();
                                                                            if (itemAnimator == null || !itemAnimator.O00000Oo()) {
                                                                                gs gsVar = gs.this;
                                                                                int size = gsVar.O0000Ooo.size();
                                                                                boolean z = false;
                                                                                int i = 0;
                                                                                while (true) {
                                                                                    if (i >= size) {
                                                                                        break;
                                                                                    } else if (!gsVar.O0000Ooo.get(i).O0000o0o) {
                                                                                        z = true;
                                                                                        break;
                                                                                    } else {
                                                                                        i++;
                                                                                    }
                                                                                }
                                                                                if (!z) {
                                                                                    gs.this.O0000Oo.O000000o(this.f18196O000000o.O0000OOo);
                                                                                    return;
                                                                                }
                                                                            }
                                                                            gs.this.O0000o00.post(this);
                                                                        }
                                                                    }
                                                                });
                                                            }
                                                        }
                                                        if (gs.this.O0000o0o == o000OOo052.itemView) {
                                                            gs.this.O00000o0(o000OOo052.itemView);
                                                        }
                                                    }
                                                }
                                            };
                                            r142.O0000Oo.setDuration(O000000o.O000000o(this.O0000o00, i8));
                                            this.O0000Ooo.add(r142);
                                            r142.O0000OOo.setIsRecyclable(false);
                                            r142.O0000Oo.start();
                                            z2 = true;
                                        }
                                    }
                                }
                                i2 = i3;
                                O00000Oo();
                                if (i2 != 1) {
                                }
                                f = Math.signum(this.O00000oo) * ((float) this.O0000o00.getHeight());
                                f2 = 0.0f;
                                if (i5 == 2) {
                                }
                                O000000o(this.O0000oOo);
                                float[] fArr22 = this.O0000oOo;
                                AnonymousClass3 r1422 = r02;
                                z = false;
                                RecyclerView.O000OOo0 o000OOo0422 = o000OOo03;
                                final int i922 = i2;
                                final RecyclerView.O000OOo0 o000OOo0522 = o000OOo0422;
                                AnonymousClass3 r022 = new O00000o0(o000OOo03, i8, i5, fArr22[0], fArr22[1], f2, f) {
                                    /* class _m_j.gs.AnonymousClass3 */

                                    public final void onAnimationEnd(Animator animator) {
                                        super.onAnimationEnd(animator);
                                        if (!this.O0000o0O) {
                                            if (i922 <= 0) {
                                                gs.this.O0000Oo.O00000o(gs.this.O0000o00, o000OOo0522);
                                            } else {
                                                gs.this.f18192O000000o.add(o000OOo0522.itemView);
                                                this.O0000Ooo = true;
                                                int i = i922;
                                                if (i > 0) {
                                                    gs gsVar = gs.this;
                                                    gsVar.O0000o00.post(new Runnable(this, i) {
                                                        /* class _m_j.gs.AnonymousClass4 */

                                                        /* renamed from: O000000o  reason: collision with root package name */
                                                        final /* synthetic */ O00000o0 f18196O000000o;
                                                        final /* synthetic */ int O00000Oo;

                                                        {
                                                            this.f18196O000000o = r2;
                                                            this.O00000Oo = r3;
                                                        }

                                                        public final void run() {
                                                            if (gs.this.O0000o00 != null && gs.this.O0000o00.isAttachedToWindow() && !this.f18196O000000o.O0000o0O && this.f18196O000000o.O0000OOo.getAdapterPosition() != -1) {
                                                                RecyclerView.O0000OOo itemAnimator = gs.this.O0000o00.getItemAnimator();
                                                                if (itemAnimator == null || !itemAnimator.O00000Oo()) {
                                                                    gs gsVar = gs.this;
                                                                    int size = gsVar.O0000Ooo.size();
                                                                    boolean z = false;
                                                                    int i = 0;
                                                                    while (true) {
                                                                        if (i >= size) {
                                                                            break;
                                                                        } else if (!gsVar.O0000Ooo.get(i).O0000o0o) {
                                                                            z = true;
                                                                            break;
                                                                        } else {
                                                                            i++;
                                                                        }
                                                                    }
                                                                    if (!z) {
                                                                        gs.this.O0000Oo.O000000o(this.f18196O000000o.O0000OOo);
                                                                        return;
                                                                    }
                                                                }
                                                                gs.this.O0000o00.post(this);
                                                            }
                                                        }
                                                    });
                                                }
                                            }
                                            if (gs.this.O0000o0o == o000OOo0522.itemView) {
                                                gs.this.O00000o0(o000OOo0522.itemView);
                                            }
                                        }
                                    }
                                };
                                r1422.O0000Oo.setDuration(O000000o.O000000o(this.O0000o00, i8));
                                this.O0000Ooo.add(r1422);
                                r1422.O0000OOo.setIsRecyclable(false);
                                r1422.O0000Oo.start();
                                z2 = true;
                            }
                            i2 = O000000o2;
                            O00000Oo();
                            if (i2 != 1) {
                            }
                            f = Math.signum(this.O00000oo) * ((float) this.O0000o00.getHeight());
                            f2 = 0.0f;
                            if (i5 == 2) {
                            }
                            O000000o(this.O0000oOo);
                            float[] fArr222 = this.O0000oOo;
                            AnonymousClass3 r14222 = r022;
                            z = false;
                            RecyclerView.O000OOo0 o000OOo04222 = o000OOo03;
                            final int i9222 = i2;
                            final RecyclerView.O000OOo0 o000OOo05222 = o000OOo04222;
                            AnonymousClass3 r0222 = new O00000o0(o000OOo03, i8, i5, fArr222[0], fArr222[1], f2, f) {
                                /* class _m_j.gs.AnonymousClass3 */

                                public final void onAnimationEnd(Animator animator) {
                                    super.onAnimationEnd(animator);
                                    if (!this.O0000o0O) {
                                        if (i9222 <= 0) {
                                            gs.this.O0000Oo.O00000o(gs.this.O0000o00, o000OOo05222);
                                        } else {
                                            gs.this.f18192O000000o.add(o000OOo05222.itemView);
                                            this.O0000Ooo = true;
                                            int i = i9222;
                                            if (i > 0) {
                                                gs gsVar = gs.this;
                                                gsVar.O0000o00.post(new Runnable(this, i) {
                                                    /* class _m_j.gs.AnonymousClass4 */

                                                    /* renamed from: O000000o  reason: collision with root package name */
                                                    final /* synthetic */ O00000o0 f18196O000000o;
                                                    final /* synthetic */ int O00000Oo;

                                                    {
                                                        this.f18196O000000o = r2;
                                                        this.O00000Oo = r3;
                                                    }

                                                    public final void run() {
                                                        if (gs.this.O0000o00 != null && gs.this.O0000o00.isAttachedToWindow() && !this.f18196O000000o.O0000o0O && this.f18196O000000o.O0000OOo.getAdapterPosition() != -1) {
                                                            RecyclerView.O0000OOo itemAnimator = gs.this.O0000o00.getItemAnimator();
                                                            if (itemAnimator == null || !itemAnimator.O00000Oo()) {
                                                                gs gsVar = gs.this;
                                                                int size = gsVar.O0000Ooo.size();
                                                                boolean z = false;
                                                                int i = 0;
                                                                while (true) {
                                                                    if (i >= size) {
                                                                        break;
                                                                    } else if (!gsVar.O0000Ooo.get(i).O0000o0o) {
                                                                        z = true;
                                                                        break;
                                                                    } else {
                                                                        i++;
                                                                    }
                                                                }
                                                                if (!z) {
                                                                    gs.this.O0000Oo.O000000o(this.f18196O000000o.O0000OOo);
                                                                    return;
                                                                }
                                                            }
                                                            gs.this.O0000o00.post(this);
                                                        }
                                                    }
                                                });
                                            }
                                        }
                                        if (gs.this.O0000o0o == o000OOo05222.itemView) {
                                            gs.this.O00000o0(o000OOo05222.itemView);
                                        }
                                    }
                                }
                            };
                            r14222.O0000Oo.setDuration(O000000o.O000000o(this.O0000o00, i8));
                            this.O0000Ooo.add(r14222);
                            r14222.O0000OOo.setIsRecyclable(false);
                            r14222.O0000Oo.start();
                            z2 = true;
                        }
                    }
                    i2 = 0;
                    O00000Oo();
                    if (i2 != 1) {
                    }
                    f = Math.signum(this.O00000oo) * ((float) this.O0000o00.getHeight());
                    f2 = 0.0f;
                    if (i5 == 2) {
                    }
                    O000000o(this.O0000oOo);
                    float[] fArr2222 = this.O0000oOo;
                    AnonymousClass3 r142222 = r0222;
                    z = false;
                    RecyclerView.O000OOo0 o000OOo042222 = o000OOo03;
                    final int i92222 = i2;
                    final RecyclerView.O000OOo0 o000OOo052222 = o000OOo042222;
                    AnonymousClass3 r02222 = new O00000o0(o000OOo03, i8, i5, fArr2222[0], fArr2222[1], f2, f) {
                        /* class _m_j.gs.AnonymousClass3 */

                        public final void onAnimationEnd(Animator animator) {
                            super.onAnimationEnd(animator);
                            if (!this.O0000o0O) {
                                if (i92222 <= 0) {
                                    gs.this.O0000Oo.O00000o(gs.this.O0000o00, o000OOo052222);
                                } else {
                                    gs.this.f18192O000000o.add(o000OOo052222.itemView);
                                    this.O0000Ooo = true;
                                    int i = i92222;
                                    if (i > 0) {
                                        gs gsVar = gs.this;
                                        gsVar.O0000o00.post(new Runnable(this, i) {
                                            /* class _m_j.gs.AnonymousClass4 */

                                            /* renamed from: O000000o  reason: collision with root package name */
                                            final /* synthetic */ O00000o0 f18196O000000o;
                                            final /* synthetic */ int O00000Oo;

                                            {
                                                this.f18196O000000o = r2;
                                                this.O00000Oo = r3;
                                            }

                                            public final void run() {
                                                if (gs.this.O0000o00 != null && gs.this.O0000o00.isAttachedToWindow() && !this.f18196O000000o.O0000o0O && this.f18196O000000o.O0000OOo.getAdapterPosition() != -1) {
                                                    RecyclerView.O0000OOo itemAnimator = gs.this.O0000o00.getItemAnimator();
                                                    if (itemAnimator == null || !itemAnimator.O00000Oo()) {
                                                        gs gsVar = gs.this;
                                                        int size = gsVar.O0000Ooo.size();
                                                        boolean z = false;
                                                        int i = 0;
                                                        while (true) {
                                                            if (i >= size) {
                                                                break;
                                                            } else if (!gsVar.O0000Ooo.get(i).O0000o0o) {
                                                                z = true;
                                                                break;
                                                            } else {
                                                                i++;
                                                            }
                                                        }
                                                        if (!z) {
                                                            gs.this.O0000Oo.O000000o(this.f18196O000000o.O0000OOo);
                                                            return;
                                                        }
                                                    }
                                                    gs.this.O0000o00.post(this);
                                                }
                                            }
                                        });
                                    }
                                }
                                if (gs.this.O0000o0o == o000OOo052222.itemView) {
                                    gs.this.O00000o0(o000OOo052222.itemView);
                                }
                            }
                        }
                    };
                    r142222.O0000Oo.setDuration(O000000o.O000000o(this.O0000o00, i8));
                    this.O0000Ooo.add(r142222);
                    r142222.O0000OOo.setIsRecyclable(false);
                    r142222.O0000Oo.start();
                    z2 = true;
                } else {
                    RecyclerView.O000OOo0 o000OOo06 = o000OOo03;
                    z = false;
                    O00000o0(o000OOo06.itemView);
                    this.O0000Oo.O00000o(this.O0000o00, o000OOo06);
                    z2 = false;
                }
                this.O00000Oo = null;
            } else {
                z = false;
                z2 = false;
            }
            if (o000OOo02 != null) {
                this.O0000OoO = (this.O0000Oo.O00000Oo(this.O0000o00, o000OOo02) & i6) >> (this.O0000ooO * 8);
                this.O0000O0o = (float) o000OOo02.itemView.getLeft();
                this.O0000OOo = (float) o000OOo02.itemView.getTop();
                this.O00000Oo = o000OOo02;
                if (i == 2) {
                    this.O00000Oo.itemView.performHapticFeedback(z ? 1 : 0);
                }
            }
            ViewParent parent = this.O0000o00.getParent();
            if (parent != null) {
                if (this.O00000Oo != null) {
                    z = true;
                }
                parent.requestDisallowInterceptTouchEvent(z);
            }
            if (!z2) {
                this.O0000o00.getLayoutManager().requestSimpleAnimationsInNextLayout();
            }
            this.O0000Oo.O000000o(this.O00000Oo, this.O0000ooO);
            this.O0000o00.invalidate();
        }
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(RecyclerView.O000OOo0 o000OOo0) {
        int i;
        int i2;
        RecyclerView.O000OOo0 o000OOo02 = o000OOo0;
        if (!this.O0000o00.isLayoutRequested() && this.O0000ooO == 2) {
            int i3 = (int) (this.O0000O0o + this.O00000oO);
            int i4 = (int) (this.O0000OOo + this.O00000oo);
            if (((float) Math.abs(i4 - o000OOo02.itemView.getTop())) >= ((float) o000OOo02.itemView.getHeight()) * 0.5f || ((float) Math.abs(i3 - o000OOo02.itemView.getLeft())) >= ((float) o000OOo02.itemView.getWidth()) * 0.5f) {
                List<RecyclerView.O000OOo0> list = this.O00oOooO;
                if (list == null) {
                    this.O00oOooO = new ArrayList();
                    this.O00oOooo = new ArrayList();
                } else {
                    list.clear();
                    this.O00oOooo.clear();
                }
                int round = Math.round(this.O0000O0o + this.O00000oO) - 0;
                int round2 = Math.round(this.O0000OOo + this.O00000oo) - 0;
                int width = o000OOo02.itemView.getWidth() + round + 0;
                int height = o000OOo02.itemView.getHeight() + round2 + 0;
                int i5 = (round + width) / 2;
                int i6 = (round2 + height) / 2;
                RecyclerView.LayoutManager layoutManager = this.O0000o00.getLayoutManager();
                int childCount = layoutManager.getChildCount();
                int i7 = 0;
                while (i7 < childCount) {
                    View childAt = layoutManager.getChildAt(i7);
                    if (childAt == o000OOo02.itemView || childAt.getBottom() < round2 || childAt.getTop() > height || childAt.getRight() < round || childAt.getLeft() > width) {
                        i2 = round;
                        i = round2;
                    } else {
                        RecyclerView.O000OOo0 childViewHolder = this.O0000o00.getChildViewHolder(childAt);
                        int abs = Math.abs(i5 - ((childAt.getLeft() + childAt.getRight()) / 2));
                        int abs2 = Math.abs(i6 - ((childAt.getTop() + childAt.getBottom()) / 2));
                        int i8 = (abs * abs) + (abs2 * abs2);
                        int size = this.O00oOooO.size();
                        i2 = round;
                        i = round2;
                        int i9 = 0;
                        int i10 = 0;
                        while (i9 < size) {
                            int i11 = size;
                            if (i8 <= this.O00oOooo.get(i9).intValue()) {
                                break;
                            }
                            i10++;
                            i9++;
                            size = i11;
                        }
                        this.O00oOooO.add(i10, childViewHolder);
                        this.O00oOooo.add(i10, Integer.valueOf(i8));
                    }
                    i7++;
                    round = i2;
                    round2 = i;
                }
                List<RecyclerView.O000OOo0> list2 = this.O00oOooO;
                if (list2.size() != 0) {
                    RecyclerView.O000OOo0 O000000o2 = O000000o.O000000o(o000OOo02, list2, i3, i4);
                    if (O000000o2 == null) {
                        this.O00oOooO.clear();
                        this.O00oOooo.clear();
                        return;
                    }
                    int adapterPosition = O000000o2.getAdapterPosition();
                    int adapterPosition2 = o000OOo0.getAdapterPosition();
                    if (this.O0000Oo.O000000o(o000OOo02, O000000o2)) {
                        this.O0000Oo.O000000o(this.O0000o00, o000OOo0, adapterPosition2, O000000o2, adapterPosition, i3, i4);
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gs.O000000o(androidx.recyclerview.widget.RecyclerView$O000OOo0, boolean):void
     arg types: [androidx.recyclerview.widget.RecyclerView$O000OOo0, int]
     candidates:
      _m_j.gs.O000000o(androidx.recyclerview.widget.RecyclerView$O000OOo0, int):void
      _m_j.gs.O000000o(androidx.recyclerview.widget.RecyclerView$O000OOo0, boolean):void */
    public final void O00000Oo(View view) {
        O00000o0(view);
        RecyclerView.O000OOo0 childViewHolder = this.O0000o00.getChildViewHolder(view);
        if (childViewHolder != null) {
            RecyclerView.O000OOo0 o000OOo0 = this.O00000Oo;
            if (o000OOo0 == null || childViewHolder != o000OOo0) {
                O000000o(childViewHolder, false);
                if (this.f18192O000000o.remove(childViewHolder.itemView)) {
                    this.O0000Oo.O00000o(this.O0000o00, childViewHolder);
                    return;
                }
                return;
            }
            O000000o((RecyclerView.O000OOo0) null, 0);
        }
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(RecyclerView.O000OOo0 o000OOo0, boolean z) {
        for (int size = this.O0000Ooo.size() - 1; size >= 0; size--) {
            O00000o0 o00000o0 = this.O0000Ooo.get(size);
            if (o00000o0.O0000OOo == o000OOo0) {
                o00000o0.O0000o0O |= z;
                if (!o00000o0.O0000o0o) {
                    o00000o0.O0000Oo.cancel();
                }
                this.O0000Ooo.remove(size);
                return;
            }
        }
    }

    public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.O000OO0o o000OO0o) {
        rect.setEmpty();
    }

    /* access modifiers changed from: package-private */
    public final void O000000o() {
        VelocityTracker velocityTracker = this.O0000o0O;
        if (velocityTracker != null) {
            velocityTracker.recycle();
        }
        this.O0000o0O = VelocityTracker.obtain();
    }

    private void O00000Oo() {
        VelocityTracker velocityTracker = this.O0000o0O;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.O0000o0O = null;
        }
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(int i, MotionEvent motionEvent, int i2) {
        int O00000Oo2;
        View O000000o2;
        if (this.O00000Oo == null && i == 2 && this.O0000ooO != 2 && this.O0000o00.getScrollState() != 1) {
            RecyclerView.LayoutManager layoutManager = this.O0000o00.getLayoutManager();
            int i3 = this.O0000Oo0;
            RecyclerView.O000OOo0 o000OOo0 = null;
            if (i3 != -1) {
                int findPointerIndex = motionEvent.findPointerIndex(i3);
                float abs = Math.abs(motionEvent.getX(findPointerIndex) - this.O00000o0);
                float abs2 = Math.abs(motionEvent.getY(findPointerIndex) - this.O00000o);
                int i4 = this.O0000ooo;
                if ((abs >= ((float) i4) || abs2 >= ((float) i4)) && ((abs <= abs2 || !layoutManager.canScrollHorizontally()) && ((abs2 <= abs || !layoutManager.canScrollVertically()) && (O000000o2 = O000000o(motionEvent)) != null))) {
                    o000OOo0 = this.O0000o00.getChildViewHolder(O000000o2);
                }
            }
            if (o000OOo0 != null && (O00000Oo2 = (this.O0000Oo.O00000Oo(this.O0000o00, o000OOo0) & 65280) >> 8) != 0) {
                float x = motionEvent.getX(i2);
                float y = motionEvent.getY(i2);
                float f = x - this.O00000o0;
                float f2 = y - this.O00000o;
                float abs3 = Math.abs(f);
                float abs4 = Math.abs(f2);
                int i5 = this.O0000ooo;
                if (abs3 >= ((float) i5) || abs4 >= ((float) i5)) {
                    if (abs3 > abs4) {
                        if (f < 0.0f && (O00000Oo2 & 4) == 0) {
                            return;
                        }
                        if (f > 0.0f && (O00000Oo2 & 8) == 0) {
                            return;
                        }
                    } else if (f2 < 0.0f && (O00000Oo2 & 1) == 0) {
                        return;
                    } else {
                        if (f2 > 0.0f && (O00000Oo2 & 2) == 0) {
                            return;
                        }
                    }
                    this.O00000oo = 0.0f;
                    this.O00000oO = 0.0f;
                    this.O0000Oo0 = motionEvent.getPointerId(0);
                    O000000o(o000OOo0, 1);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final View O000000o(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        RecyclerView.O000OOo0 o000OOo0 = this.O00000Oo;
        if (o000OOo0 != null) {
            View view = o000OOo0.itemView;
            if (O000000o(view, x, y, this.O0000O0o + this.O00000oO, this.O0000OOo + this.O00000oo)) {
                return view;
            }
        }
        for (int size = this.O0000Ooo.size() - 1; size >= 0; size--) {
            O00000o0 o00000o0 = this.O0000Ooo.get(size);
            View view2 = o00000o0.O0000OOo.itemView;
            if (O000000o(view2, x, y, o00000o0.O0000o00, o00000o0.O0000o0)) {
                return view2;
            }
        }
        return this.O0000o00.findChildViewUnder(x, y);
    }

    public final void O00000Oo(RecyclerView.O000OOo0 o000OOo0) {
        if (!this.O0000Oo.O00000o0(this.O0000o00, o000OOo0)) {
            Log.e("ItemTouchHelper", "Start drag has been called but dragging is not enabled");
        } else if (o000OOo0.itemView.getParent() != this.O0000o00) {
            Log.e("ItemTouchHelper", "Start drag has been called with a view holder which is not a child of the RecyclerView which is controlled by this ItemTouchHelper.");
        } else {
            O000000o();
            this.O00000oo = 0.0f;
            this.O00000oO = 0.0f;
            O000000o(o000OOo0, 2);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.max(float, float):float}
     arg types: [int, float]
     candidates:
      ClspMth{java.lang.Math.max(double, double):double}
      ClspMth{java.lang.Math.max(int, int):int}
      ClspMth{java.lang.Math.max(long, long):long}
      ClspMth{java.lang.Math.max(float, float):float} */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.min(float, float):float}
     arg types: [int, float]
     candidates:
      ClspMth{java.lang.Math.min(double, double):double}
      ClspMth{java.lang.Math.min(long, long):long}
      ClspMth{java.lang.Math.min(int, int):int}
      ClspMth{java.lang.Math.min(float, float):float} */
    /* access modifiers changed from: package-private */
    public final void O000000o(MotionEvent motionEvent, int i, int i2) {
        float x = motionEvent.getX(i2);
        float y = motionEvent.getY(i2);
        this.O00000oO = x - this.O00000o0;
        this.O00000oo = y - this.O00000o;
        if ((i & 4) == 0) {
            this.O00000oO = Math.max(0.0f, this.O00000oO);
        }
        if ((i & 8) == 0) {
            this.O00000oO = Math.min(0.0f, this.O00000oO);
        }
        if ((i & 1) == 0) {
            this.O00000oo = Math.max(0.0f, this.O00000oo);
        }
        if ((i & 2) == 0) {
            this.O00000oo = Math.min(0.0f, this.O00000oo);
        }
    }

    private int O000000o(int i) {
        if ((i & 12) == 0) {
            return 0;
        }
        int i2 = 8;
        int i3 = this.O00000oO > 0.0f ? 8 : 4;
        VelocityTracker velocityTracker = this.O0000o0O;
        if (velocityTracker != null && this.O0000Oo0 >= 0) {
            velocityTracker.computeCurrentVelocity(1000, O000000o.O00000Oo(this.O0000oo));
            float xVelocity = this.O0000o0O.getXVelocity(this.O0000Oo0);
            float yVelocity = this.O0000o0O.getYVelocity(this.O0000Oo0);
            if (xVelocity <= 0.0f) {
                i2 = 4;
            }
            float abs = Math.abs(xVelocity);
            if ((i2 & i) != 0 && i3 == i2 && abs >= O000000o.O000000o(this.O0000oo0) && abs > Math.abs(yVelocity)) {
                return i2;
            }
        }
        float width = ((float) this.O0000o00.getWidth()) * 0.5f;
        if ((i & i3) == 0 || Math.abs(this.O00000oO) <= width) {
            return 0;
        }
        return i3;
    }

    private int O00000Oo(int i) {
        if ((i & 3) == 0) {
            return 0;
        }
        int i2 = 2;
        int i3 = this.O00000oo > 0.0f ? 2 : 1;
        VelocityTracker velocityTracker = this.O0000o0O;
        if (velocityTracker != null && this.O0000Oo0 >= 0) {
            velocityTracker.computeCurrentVelocity(1000, O000000o.O00000Oo(this.O0000oo));
            float xVelocity = this.O0000o0O.getXVelocity(this.O0000Oo0);
            float yVelocity = this.O0000o0O.getYVelocity(this.O0000Oo0);
            if (yVelocity <= 0.0f) {
                i2 = 1;
            }
            float abs = Math.abs(yVelocity);
            if ((i2 & i) != 0 && i2 == i3 && abs >= O000000o.O000000o(this.O0000oo0) && abs > Math.abs(xVelocity)) {
                return i2;
            }
        }
        float height = ((float) this.O0000o00.getHeight()) * 0.5f;
        if ((i & i3) == 0 || Math.abs(this.O00000oo) <= height) {
            return 0;
        }
        return i3;
    }

    /* access modifiers changed from: package-private */
    public final void O00000o0(View view) {
        if (view == this.O0000o0o) {
            this.O0000o0o = null;
            if (this.O000O00o != null) {
                this.O0000o00.setChildDrawingOrderCallback(null);
            }
        }
    }

    public static abstract class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        private static final Interpolator f18198O000000o = new Interpolator() {
            /* class _m_j.gs.O000000o.AnonymousClass1 */

            public final float getInterpolation(float f) {
                return f * f * f * f * f;
            }
        };
        private static final Interpolator O00000Oo = new Interpolator() {
            /* class _m_j.gs.O000000o.AnonymousClass2 */

            public final float getInterpolation(float f) {
                float f2 = f - 1.0f;
                return (f2 * f2 * f2 * f2 * f2) + 1.0f;
            }
        };
        private int O00000o0 = -1;

        public static float O000000o(float f) {
            return f;
        }

        public static int O000000o(int i) {
            return (i << 16) | ((i | 0) << 0) | 0;
        }

        public static int O000000o(int i, int i2) {
            int i3;
            int i4 = i & 789516;
            if (i4 == 0) {
                return i;
            }
            int i5 = i & (i4 ^ -1);
            if (i2 == 0) {
                i3 = i4 << 2;
            } else {
                int i6 = i4 << 1;
                i5 |= -789517 & i6;
                i3 = (i6 & 789516) << 2;
            }
            return i5 | i3;
        }

        public static float O00000Oo(float f) {
            return f;
        }

        public static int O00000Oo(int i, int i2) {
            int i3;
            int i4 = i & 3158064;
            if (i4 == 0) {
                return i;
            }
            int i5 = i & (i4 ^ -1);
            if (i2 == 0) {
                i3 = i4 >> 2;
            } else {
                int i6 = i4 >> 1;
                i5 |= -3158065 & i6;
                i3 = (i6 & 3158064) >> 2;
            }
            return i5 | i3;
        }

        public abstract int O000000o(RecyclerView recyclerView, RecyclerView.O000OOo0 o000OOo0);

        public abstract void O000000o(RecyclerView.O000OOo0 o000OOo0);

        public boolean O000000o() {
            return true;
        }

        public abstract boolean O000000o(RecyclerView.O000OOo0 o000OOo0, RecyclerView.O000OOo0 o000OOo02);

        /* access modifiers changed from: package-private */
        public final int O00000Oo(RecyclerView recyclerView, RecyclerView.O000OOo0 o000OOo0) {
            return O00000Oo(O000000o(recyclerView, o000OOo0), cb.O0000Oo0(recyclerView));
        }

        /* access modifiers changed from: package-private */
        public final boolean O00000o0(RecyclerView recyclerView, RecyclerView.O000OOo0 o000OOo0) {
            return (O00000Oo(recyclerView, o000OOo0) & 16711680) != 0;
        }

        public static RecyclerView.O000OOo0 O000000o(RecyclerView.O000OOo0 o000OOo0, List<RecyclerView.O000OOo0> list, int i, int i2) {
            int bottom;
            int abs;
            int top;
            int abs2;
            int left;
            int abs3;
            int right;
            int abs4;
            int width = o000OOo0.itemView.getWidth() + i;
            int height = o000OOo0.itemView.getHeight() + i2;
            int left2 = i - o000OOo0.itemView.getLeft();
            int top2 = i2 - o000OOo0.itemView.getTop();
            int size = list.size();
            RecyclerView.O000OOo0 o000OOo02 = null;
            int i3 = -1;
            for (int i4 = 0; i4 < size; i4++) {
                RecyclerView.O000OOo0 o000OOo03 = list.get(i4);
                if (left2 > 0 && (right = o000OOo03.itemView.getRight() - width) < 0 && o000OOo03.itemView.getRight() > o000OOo0.itemView.getRight() && (abs4 = Math.abs(right)) > i3) {
                    o000OOo02 = o000OOo03;
                    i3 = abs4;
                }
                if (left2 < 0 && (left = o000OOo03.itemView.getLeft() - i) > 0 && o000OOo03.itemView.getLeft() < o000OOo0.itemView.getLeft() && (abs3 = Math.abs(left)) > i3) {
                    o000OOo02 = o000OOo03;
                    i3 = abs3;
                }
                if (top2 < 0 && (top = o000OOo03.itemView.getTop() - i2) > 0 && o000OOo03.itemView.getTop() < o000OOo0.itemView.getTop() && (abs2 = Math.abs(top)) > i3) {
                    o000OOo02 = o000OOo03;
                    i3 = abs2;
                }
                if (top2 > 0 && (bottom = o000OOo03.itemView.getBottom() - height) < 0 && o000OOo03.itemView.getBottom() > o000OOo0.itemView.getBottom() && (abs = Math.abs(bottom)) > i3) {
                    o000OOo02 = o000OOo03;
                    i3 = abs;
                }
            }
            return o000OOo02;
        }

        public void O000000o(RecyclerView.O000OOo0 o000OOo0, int i) {
            if (o000OOo0 != null) {
                gt gtVar = gu.f18275O000000o;
            }
        }

        public void O000000o(RecyclerView recyclerView, RecyclerView.O000OOo0 o000OOo0, int i, RecyclerView.O000OOo0 o000OOo02, int i2, int i3, int i4) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof O00000o) {
                ((O00000o) layoutManager).prepareForDrop(o000OOo0.itemView, o000OOo02.itemView, i3, i4);
                return;
            }
            if (layoutManager.canScrollHorizontally()) {
                if (layoutManager.getDecoratedLeft(o000OOo02.itemView) <= recyclerView.getPaddingLeft()) {
                    recyclerView.scrollToPosition(i2);
                }
                if (layoutManager.getDecoratedRight(o000OOo02.itemView) >= recyclerView.getWidth() - recyclerView.getPaddingRight()) {
                    recyclerView.scrollToPosition(i2);
                }
            }
            if (layoutManager.canScrollVertically()) {
                if (layoutManager.getDecoratedTop(o000OOo02.itemView) <= recyclerView.getPaddingTop()) {
                    recyclerView.scrollToPosition(i2);
                }
                if (layoutManager.getDecoratedBottom(o000OOo02.itemView) >= recyclerView.getHeight() - recyclerView.getPaddingBottom()) {
                    recyclerView.scrollToPosition(i2);
                }
            }
        }

        public void O00000o(RecyclerView recyclerView, RecyclerView.O000OOo0 o000OOo0) {
            gu.f18275O000000o.O000000o(o000OOo0.itemView);
        }

        public void O000000o(Canvas canvas, RecyclerView recyclerView, RecyclerView.O000OOo0 o000OOo0, float f, float f2, int i, boolean z) {
            gu.f18275O000000o.O000000o(recyclerView, o000OOo0.itemView, f, f2, z);
        }

        public static void O00000Oo() {
            gt gtVar = gu.f18275O000000o;
        }

        public static long O000000o(RecyclerView recyclerView, int i) {
            RecyclerView.O0000OOo itemAnimator = recyclerView.getItemAnimator();
            if (itemAnimator == null) {
                return i == 8 ? 200 : 250;
            }
            if (i == 8) {
                return itemAnimator.O0000OoO;
            }
            return itemAnimator.O0000Oo;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{java.lang.Math.min(float, float):float}
         arg types: [int, float]
         candidates:
          ClspMth{java.lang.Math.min(double, double):double}
          ClspMth{java.lang.Math.min(long, long):long}
          ClspMth{java.lang.Math.min(int, int):int}
          ClspMth{java.lang.Math.min(float, float):float} */
        public int O000000o(RecyclerView recyclerView, int i, int i2, int i3, long j) {
            if (this.O00000o0 == -1) {
                this.O00000o0 = recyclerView.getResources().getDimensionPixelSize(R.dimen.item_touch_helper_max_drag_scroll_per_frame);
            }
            float f = 1.0f;
            int signum = (int) (((float) (((int) Math.signum((float) i2)) * this.O00000o0)) * O00000Oo.getInterpolation(Math.min(1.0f, (((float) Math.abs(i2)) * 1.0f) / ((float) i))));
            if (j <= 2000) {
                f = ((float) j) / 2000.0f;
            }
            int interpolation = (int) (((float) signum) * f18198O000000o.getInterpolation(f));
            if (interpolation != 0) {
                return interpolation;
            }
            if (i2 > 0) {
                return 1;
            }
            return -1;
        }
    }

    class O00000Oo extends GestureDetector.SimpleOnGestureListener {

        /* renamed from: O000000o  reason: collision with root package name */
        boolean f18199O000000o = true;

        public final boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        O00000Oo() {
        }

        public final void onLongPress(MotionEvent motionEvent) {
            View O000000o2;
            RecyclerView.O000OOo0 childViewHolder;
            if (this.f18199O000000o && (O000000o2 = gs.this.O000000o(motionEvent)) != null && (childViewHolder = gs.this.O0000o00.getChildViewHolder(O000000o2)) != null && gs.this.O0000Oo.O00000o0(gs.this.O0000o00, childViewHolder) && motionEvent.getPointerId(0) == gs.this.O0000Oo0) {
                int findPointerIndex = motionEvent.findPointerIndex(gs.this.O0000Oo0);
                float x = motionEvent.getX(findPointerIndex);
                float y = motionEvent.getY(findPointerIndex);
                gs gsVar = gs.this;
                gsVar.O00000o0 = x;
                gsVar.O00000o = y;
                gsVar.O00000oo = 0.0f;
                gsVar.O00000oO = 0.0f;
                if (gsVar.O0000Oo.O000000o()) {
                    gs.this.O000000o(childViewHolder, 2);
                }
            }
        }
    }

    static class O00000o0 implements Animator.AnimatorListener {
        final float O00000o;
        final float O00000oO;
        final float O00000oo;
        final float O0000O0o;
        final RecyclerView.O000OOo0 O0000OOo;
        final ValueAnimator O0000Oo;
        final int O0000Oo0;
        final int O0000OoO;
        boolean O0000Ooo;
        float O0000o;
        float O0000o0;
        float O0000o00;
        boolean O0000o0O = false;
        boolean O0000o0o = false;

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }

        O00000o0(RecyclerView.O000OOo0 o000OOo0, int i, int i2, float f, float f2, float f3, float f4) {
            this.O0000Oo0 = i2;
            this.O0000OoO = i;
            this.O0000OOo = o000OOo0;
            this.O00000o = f;
            this.O00000oO = f2;
            this.O00000oo = f3;
            this.O0000O0o = f4;
            this.O0000Oo = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.O0000Oo.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                /* class _m_j.gs.O00000o0.AnonymousClass1 */

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    O00000o0.this.O0000o = valueAnimator.getAnimatedFraction();
                }
            });
            this.O0000Oo.setTarget(o000OOo0.itemView);
            this.O0000Oo.addListener(this);
            this.O0000o = 0.0f;
        }

        public void onAnimationEnd(Animator animator) {
            if (!this.O0000o0o) {
                this.O0000OOo.setIsRecyclable(true);
            }
            this.O0000o0o = true;
        }

        public void onAnimationCancel(Animator animator) {
            this.O0000o = 1.0f;
        }
    }
}

package androidx.appcompat.widget;

import _m_j.OO0o;
import _m_j.OOOo000;
import _m_j.bk;
import _m_j.cb;
import _m_j.cw;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import com.xiaomi.smarthome.R;
import java.lang.reflect.Method;

public class ListPopupWindow implements OO0o {

    /* renamed from: O000000o  reason: collision with root package name */
    private static Method f2720O000000o;
    private static Method O00000Oo;
    private static Method O00000o0;
    private Context O00000o;
    public OOOo000 O00000oO;
    public int O00000oo;
    public int O0000O0o;
    public int O0000OOo;
    int O0000Oo;
    public int O0000Oo0;
    int O0000OoO;
    public View O0000Ooo;
    public PopupWindow O0000o;
    final O0000O0o O0000o0;
    public AdapterView.OnItemClickListener O0000o00;
    final Handler O0000o0O;
    public boolean O0000o0o;
    private int O0000oO;
    private ListAdapter O0000oO0;
    private int O0000oOO;
    private boolean O0000oOo;
    private boolean O0000oo;
    private boolean O0000oo0;
    private boolean O0000ooO;
    private boolean O0000ooo;
    private Drawable O000O00o;
    private AdapterView.OnItemSelectedListener O000O0OO;
    private final O00000o O000O0Oo;
    private Runnable O000O0o;
    private final O000000o O000O0o0;
    private final Rect O000O0oO;
    private Rect O000O0oo;
    private final O00000o0 O00oOoOo;
    private View O00oOooO;
    private DataSetObserver O00oOooo;

    static {
        if (Build.VERSION.SDK_INT <= 28) {
            Class<PopupWindow> cls = PopupWindow.class;
            try {
                f2720O000000o = cls.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException unused) {
                Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
            try {
                O00000o0 = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
            } catch (NoSuchMethodException unused2) {
                Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
            }
        }
        if (Build.VERSION.SDK_INT <= 23) {
            Class<PopupWindow> cls2 = PopupWindow.class;
            try {
                O00000Oo = cls2.getDeclaredMethod("getMaxAvailableHeight", View.class, Integer.TYPE, Boolean.TYPE);
            } catch (NoSuchMethodException unused3) {
                Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
            }
        }
    }

    public ListPopupWindow(Context context) {
        this(context, null, R.attr.listPopupWindowStyle);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listPopupWindowStyle);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int i, int i2) {
        this.O00000oo = -2;
        this.O0000O0o = -2;
        this.O0000oOO = 1002;
        this.O0000Oo0 = 0;
        this.O0000ooO = false;
        this.O0000ooo = false;
        this.O0000Oo = Integer.MAX_VALUE;
        this.O0000OoO = 0;
        this.O0000o0 = new O0000O0o();
        this.O000O0Oo = new O00000o();
        this.O00oOoOo = new O00000o0();
        this.O000O0o0 = new O000000o();
        this.O000O0oO = new Rect();
        this.O00000o = context;
        this.O0000o0O = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16843436, 16843437}, i, i2);
        this.O0000OOo = obtainStyledAttributes.getDimensionPixelOffset(0, 0);
        this.O0000oO = obtainStyledAttributes.getDimensionPixelOffset(1, 0);
        if (this.O0000oO != 0) {
            this.O0000oOo = true;
        }
        obtainStyledAttributes.recycle();
        this.O0000o = new AppCompatPopupWindow(context, attributeSet, i, i2);
        this.O0000o.setInputMethodMode(1);
    }

    public void O000000o(ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = this.O00oOooo;
        if (dataSetObserver == null) {
            this.O00oOooo = new O00000Oo();
        } else {
            ListAdapter listAdapter2 = this.O0000oO0;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.O0000oO0 = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.O00oOooo);
        }
        OOOo000 oOOo000 = this.O00000oO;
        if (oOOo000 != null) {
            oOOo000.setAdapter(this.O0000oO0);
        }
    }

    public final void O0000OOo() {
        this.O0000o0o = true;
        this.O0000o.setFocusable(true);
    }

    public final Drawable O00000o() {
        return this.O0000o.getBackground();
    }

    public final void O000000o(Drawable drawable) {
        this.O0000o.setBackgroundDrawable(drawable);
    }

    public final int O00000oo() {
        return this.O0000OOo;
    }

    public final void O00000Oo(int i) {
        this.O0000OOo = i;
    }

    public final int O00000oO() {
        if (!this.O0000oOo) {
            return 0;
        }
        return this.O0000oO;
    }

    public final void O000000o(int i) {
        this.O0000oO = i;
        this.O0000oOo = true;
    }

    public final void O000000o(Rect rect) {
        this.O000O0oo = rect != null ? new Rect(rect) : null;
    }

    public final void O00000o(int i) {
        Drawable background = this.O0000o.getBackground();
        if (background != null) {
            background.getPadding(this.O000O0oO);
            this.O0000O0o = this.O000O0oO.left + this.O000O0oO.right + i;
            return;
        }
        this.O0000O0o = i;
    }

    public final void O00000Oo() {
        this.O0000o.dismiss();
        O0000O0o();
        this.O0000o.setContentView(null);
        this.O00000oO = null;
        this.O0000o0O.removeCallbacks(this.O0000o0);
    }

    public final void O000000o(PopupWindow.OnDismissListener onDismissListener) {
        this.O0000o.setOnDismissListener(onDismissListener);
    }

    private void O0000O0o() {
        View view = this.O00oOooO;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.O00oOooO);
            }
        }
    }

    public final void O0000Oo0() {
        this.O0000o.setInputMethodMode(2);
    }

    public final void O0000Oo() {
        OOOo000 oOOo000 = this.O00000oO;
        if (oOOo000 != null) {
            oOOo000.setListSelectionHidden(true);
            oOOo000.requestLayout();
        }
    }

    public final boolean O00000o0() {
        return this.O0000o.isShowing();
    }

    public final boolean O0000OoO() {
        return this.O0000o.getInputMethodMode() == 2;
    }

    public final ListView b_() {
        return this.O00000oO;
    }

    /* access modifiers changed from: protected */
    public OOOo000 O000000o(Context context, boolean z) {
        return new OOOo000(context, z);
    }

    public final void O0000o00() {
        this.O0000oo = true;
        this.O0000oo0 = true;
    }

    class O00000Oo extends DataSetObserver {
        O00000Oo() {
        }

        public final void onChanged() {
            if (ListPopupWindow.this.O0000o.isShowing()) {
                ListPopupWindow.this.a_();
            }
        }

        public final void onInvalidated() {
            ListPopupWindow.this.O00000Oo();
        }
    }

    class O000000o implements Runnable {
        O000000o() {
        }

        public final void run() {
            ListPopupWindow.this.O0000Oo();
        }
    }

    class O0000O0o implements Runnable {
        O0000O0o() {
        }

        public final void run() {
            if (ListPopupWindow.this.O00000oO != null && cb.O000OO0o(ListPopupWindow.this.O00000oO) && ListPopupWindow.this.O00000oO.getCount() > ListPopupWindow.this.O00000oO.getChildCount() && ListPopupWindow.this.O00000oO.getChildCount() <= ListPopupWindow.this.O0000Oo) {
                ListPopupWindow.this.O0000o.setInputMethodMode(2);
                ListPopupWindow.this.a_();
            }
        }
    }

    class O00000o implements View.OnTouchListener {
        O00000o() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && ListPopupWindow.this.O0000o != null && ListPopupWindow.this.O0000o.isShowing() && x >= 0 && x < ListPopupWindow.this.O0000o.getWidth() && y >= 0 && y < ListPopupWindow.this.O0000o.getHeight()) {
                ListPopupWindow.this.O0000o0O.postDelayed(ListPopupWindow.this.O0000o0, 250);
                return false;
            } else if (action != 1) {
                return false;
            } else {
                ListPopupWindow.this.O0000o0O.removeCallbacks(ListPopupWindow.this.O0000o0);
                return false;
            }
        }
    }

    class O00000o0 implements AbsListView.OnScrollListener {
        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        O00000o0() {
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1 && !ListPopupWindow.this.O0000OoO() && ListPopupWindow.this.O0000o.getContentView() != null) {
                ListPopupWindow.this.O0000o0O.removeCallbacks(ListPopupWindow.this.O0000o0);
                ListPopupWindow.this.O0000o0.run();
            }
        }
    }

    private int O000000o(View view, int i, boolean z) {
        if (Build.VERSION.SDK_INT > 23) {
            return this.O0000o.getMaxAvailableHeight(view, i, z);
        }
        Method method = O00000Oo;
        if (method != null) {
            try {
                return ((Integer) method.invoke(this.O0000o, view, Integer.valueOf(i), Boolean.valueOf(z))).intValue();
            } catch (Exception unused) {
                Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
            }
        }
        return this.O0000o.getMaxAvailableHeight(view, i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v54, resolved type: _m_j.OOOo000} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v55, resolved type: _m_j.OOOo000} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v19, resolved type: android.widget.LinearLayout} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v60, resolved type: _m_j.OOOo000} */
    /* JADX WARNING: Multi-variable type inference failed */
    public final void a_() {
        int i;
        int i2;
        int i3;
        int makeMeasureSpec;
        int i4;
        boolean z = true;
        if (this.O00000oO == null) {
            Context context = this.O00000o;
            this.O000O0o = new Runnable() {
                /* class androidx.appcompat.widget.ListPopupWindow.AnonymousClass1 */

                public final void run() {
                    View view = ListPopupWindow.this.O0000Ooo;
                    if (view != null && view.getWindowToken() != null) {
                        ListPopupWindow.this.a_();
                    }
                }
            };
            this.O00000oO = O000000o(context, !this.O0000o0o);
            Drawable drawable = this.O000O00o;
            if (drawable != null) {
                this.O00000oO.setSelector(drawable);
            }
            this.O00000oO.setAdapter(this.O0000oO0);
            this.O00000oO.setOnItemClickListener(this.O0000o00);
            this.O00000oO.setFocusable(true);
            this.O00000oO.setFocusableInTouchMode(true);
            this.O00000oO.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                /* class androidx.appcompat.widget.ListPopupWindow.AnonymousClass2 */

                public final void onNothingSelected(AdapterView<?> adapterView) {
                }

                public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                    OOOo000 oOOo000;
                    if (i != -1 && (oOOo000 = ListPopupWindow.this.O00000oO) != null) {
                        oOOo000.setListSelectionHidden(false);
                    }
                }
            });
            this.O00000oO.setOnScrollListener(this.O00oOoOo);
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.O000O0OO;
            if (onItemSelectedListener != null) {
                this.O00000oO.setOnItemSelectedListener(onItemSelectedListener);
            }
            OOOo000 oOOo000 = this.O00000oO;
            View view = this.O00oOooO;
            if (view != null) {
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0f);
                int i5 = this.O0000OoO;
                if (i5 == 0) {
                    linearLayout.addView(view);
                    linearLayout.addView(oOOo000, layoutParams);
                } else if (i5 != 1) {
                    Log.e("ListPopupWindow", "Invalid hint position " + this.O0000OoO);
                } else {
                    linearLayout.addView(oOOo000, layoutParams);
                    linearLayout.addView(view);
                }
                int i6 = this.O0000O0o;
                if (i6 >= 0) {
                    i4 = Integer.MIN_VALUE;
                } else {
                    i6 = 0;
                    i4 = 0;
                }
                view.measure(View.MeasureSpec.makeMeasureSpec(i6, i4), 0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view.getLayoutParams();
                i = view.getMeasuredHeight() + layoutParams2.topMargin + layoutParams2.bottomMargin;
                oOOo000 = linearLayout;
            } else {
                i = 0;
            }
            this.O0000o.setContentView(oOOo000);
        } else {
            this.O0000o.getContentView();
            View view2 = this.O00oOooO;
            if (view2 != null) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                i = view2.getMeasuredHeight() + layoutParams3.topMargin + layoutParams3.bottomMargin;
            } else {
                i = 0;
            }
        }
        Drawable background = this.O0000o.getBackground();
        if (background != null) {
            background.getPadding(this.O000O0oO);
            i2 = this.O000O0oO.top + this.O000O0oO.bottom;
            if (!this.O0000oOo) {
                this.O0000oO = -this.O000O0oO.top;
            }
        } else {
            this.O000O0oO.setEmpty();
            i2 = 0;
        }
        int O000000o2 = O000000o(this.O0000Ooo, this.O0000oO, this.O0000o.getInputMethodMode() == 2);
        if (this.O0000ooO || this.O00000oo == -1) {
            i3 = O000000o2 + i2;
        } else {
            int i7 = this.O0000O0o;
            if (i7 == -2) {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.O00000o.getResources().getDisplayMetrics().widthPixels - (this.O000O0oO.left + this.O000O0oO.right), Integer.MIN_VALUE);
            } else if (i7 != -1) {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i7, 1073741824);
            } else {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.O00000o.getResources().getDisplayMetrics().widthPixels - (this.O000O0oO.left + this.O000O0oO.right), 1073741824);
            }
            int O000000o3 = this.O00000oO.O000000o(makeMeasureSpec, 0, -1, O000000o2 - i, -1);
            if (O000000o3 > 0) {
                i += i2 + this.O00000oO.getPaddingTop() + this.O00000oO.getPaddingBottom();
            }
            i3 = O000000o3 + i;
        }
        boolean O0000OoO2 = O0000OoO();
        cw.O000000o(this.O0000o, this.O0000oOO);
        if (!this.O0000o.isShowing()) {
            int i8 = this.O0000O0o;
            if (i8 == -1) {
                i8 = -1;
            } else if (i8 == -2) {
                i8 = this.O0000Ooo.getWidth();
            }
            int i9 = this.O00000oo;
            if (i9 == -1) {
                i3 = -1;
            } else if (i9 != -2) {
                i3 = i9;
            }
            this.O0000o.setWidth(i8);
            this.O0000o.setHeight(i3);
            if (Build.VERSION.SDK_INT <= 28) {
                Method method = f2720O000000o;
                if (method != null) {
                    try {
                        method.invoke(this.O0000o, Boolean.TRUE);
                    } catch (Exception unused) {
                        Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
                    }
                }
            } else {
                this.O0000o.setIsClippedToScreen(true);
            }
            this.O0000o.setOutsideTouchable(!this.O0000ooo && !this.O0000ooO);
            this.O0000o.setTouchInterceptor(this.O000O0Oo);
            if (this.O0000oo) {
                cw.O000000o(this.O0000o, this.O0000oo0);
            }
            if (Build.VERSION.SDK_INT <= 28) {
                Method method2 = O00000o0;
                if (method2 != null) {
                    try {
                        method2.invoke(this.O0000o, this.O000O0oo);
                    } catch (Exception e) {
                        Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e);
                    }
                }
            } else {
                this.O0000o.setEpicenterBounds(this.O000O0oo);
            }
            PopupWindow popupWindow = this.O0000o;
            View view3 = this.O0000Ooo;
            int i10 = this.O0000OOo;
            int i11 = this.O0000oO;
            int i12 = this.O0000Oo0;
            if (Build.VERSION.SDK_INT >= 19) {
                popupWindow.showAsDropDown(view3, i10, i11, i12);
            } else {
                if ((bk.O000000o(i12, cb.O0000Oo0(view3)) & 7) == 5) {
                    i10 -= popupWindow.getWidth() - view3.getWidth();
                }
                popupWindow.showAsDropDown(view3, i10, i11);
            }
            this.O00000oO.setSelection(-1);
            if (!this.O0000o0o || this.O00000oO.isInTouchMode()) {
                O0000Oo();
            }
            if (!this.O0000o0o) {
                this.O0000o0O.post(this.O000O0o0);
            }
        } else if (cb.O000OO0o(this.O0000Ooo)) {
            int i13 = this.O0000O0o;
            if (i13 == -1) {
                i13 = -1;
            } else if (i13 == -2) {
                i13 = this.O0000Ooo.getWidth();
            }
            int i14 = this.O00000oo;
            if (i14 == -1) {
                if (!O0000OoO2) {
                    i3 = -1;
                }
                if (O0000OoO2) {
                    this.O0000o.setWidth(this.O0000O0o == -1 ? -1 : 0);
                    this.O0000o.setHeight(0);
                } else {
                    this.O0000o.setWidth(this.O0000O0o == -1 ? -1 : 0);
                    this.O0000o.setHeight(-1);
                }
            } else if (i14 != -2) {
                i3 = i14;
            }
            PopupWindow popupWindow2 = this.O0000o;
            if (this.O0000ooo || this.O0000ooO) {
                z = false;
            }
            popupWindow2.setOutsideTouchable(z);
            this.O0000o.update(this.O0000Ooo, this.O0000OOo, this.O0000oO, i13 < 0 ? -1 : i13, i3 < 0 ? -1 : i3);
        }
    }

    public final int O0000Ooo() {
        if (!this.O0000o.isShowing()) {
            return -1;
        }
        return this.O00000oO.getSelectedItemPosition();
    }
}

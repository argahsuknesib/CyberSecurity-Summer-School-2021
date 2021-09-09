package androidx.appcompat.widget;

import _m_j.OO0o;
import _m_j.OOO0OO0;
import _m_j.OOOo00;
import _m_j.Oo;
import _m_j.cb;
import _m_j.cl;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.view.ActionProvider;
import com.xiaomi.smarthome.R;

public class ActivityChooserView extends ViewGroup {

    /* renamed from: O000000o  reason: collision with root package name */
    final O000000o f2696O000000o;
    final View O00000Oo;
    final FrameLayout O00000o;
    final Drawable O00000o0;
    final FrameLayout O00000oO;
    final ImageView O00000oo;
    ActionProvider O0000O0o;
    final DataSetObserver O0000OOo;
    boolean O0000Oo;
    PopupWindow.OnDismissListener O0000Oo0;
    int O0000OoO;
    int O0000Ooo;
    private ListPopupWindow O0000o;
    private final ImageView O0000o0;
    private final O00000Oo O0000o00;
    private final int O0000o0O;
    private final ViewTreeObserver.OnGlobalLayoutListener O0000o0o;
    private boolean O0000oO0;

    public ActivityChooserView(Context context) {
        this(context, null);
    }

    public ActivityChooserView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, androidx.appcompat.widget.ActivityChooserView, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public ActivityChooserView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.O0000OOo = new DataSetObserver() {
            /* class androidx.appcompat.widget.ActivityChooserView.AnonymousClass1 */

            public final void onChanged() {
                super.onChanged();
                ActivityChooserView.this.f2696O000000o.notifyDataSetChanged();
            }

            public final void onInvalidated() {
                super.onInvalidated();
                ActivityChooserView.this.f2696O000000o.notifyDataSetInvalidated();
            }
        };
        this.O0000o0o = new ViewTreeObserver.OnGlobalLayoutListener() {
            /* class androidx.appcompat.widget.ActivityChooserView.AnonymousClass2 */

            public final void onGlobalLayout() {
                if (!ActivityChooserView.this.O00000o0()) {
                    return;
                }
                if (!ActivityChooserView.this.isShown()) {
                    ActivityChooserView.this.getListPopupWindow().O00000Oo();
                    return;
                }
                ActivityChooserView.this.getListPopupWindow().a_();
                if (ActivityChooserView.this.O0000O0o != null) {
                    ActivityChooserView.this.O0000O0o.O000000o(true);
                }
            }
        };
        this.O0000OoO = 4;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.expandActivityOverflowButtonDrawable, R.attr.initialActivityCount}, i, 0);
        cb.O000000o(this, context, new int[]{R.attr.expandActivityOverflowButtonDrawable, R.attr.initialActivityCount}, attributeSet, obtainStyledAttributes, i);
        this.O0000OoO = obtainStyledAttributes.getInt(1, 4);
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
        LayoutInflater.from(getContext()).inflate((int) R.layout.abc_activity_chooser_view, (ViewGroup) this, true);
        this.O0000o00 = new O00000Oo();
        this.O00000Oo = findViewById(R.id.activity_chooser_view_content);
        this.O00000o0 = this.O00000Oo.getBackground();
        this.O00000oO = (FrameLayout) findViewById(R.id.default_activity_button);
        this.O00000oO.setOnClickListener(this.O0000o00);
        this.O00000oO.setOnLongClickListener(this.O0000o00);
        this.O00000oo = (ImageView) this.O00000oO.findViewById(R.id.image);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.expand_activities_button);
        frameLayout.setOnClickListener(this.O0000o00);
        frameLayout.setAccessibilityDelegate(new View.AccessibilityDelegate() {
            /* class androidx.appcompat.widget.ActivityChooserView.AnonymousClass3 */

            public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                cl O000000o2 = cl.O000000o(accessibilityNodeInfo);
                if (Build.VERSION.SDK_INT >= 19) {
                    O000000o2.f13980O000000o.setCanOpenPopup(true);
                }
            }
        });
        frameLayout.setOnTouchListener(new OOOo00(frameLayout) {
            /* class androidx.appcompat.widget.ActivityChooserView.AnonymousClass4 */

            public final OO0o O000000o() {
                return ActivityChooserView.this.getListPopupWindow();
            }

            public final boolean O00000Oo() {
                ActivityChooserView.this.O000000o();
                return true;
            }

            public final boolean O00000o0() {
                ActivityChooserView.this.O00000Oo();
                return true;
            }
        });
        this.O00000o = frameLayout;
        this.O0000o0 = (ImageView) frameLayout.findViewById(R.id.image);
        this.O0000o0.setImageDrawable(drawable);
        this.f2696O000000o = new O000000o();
        this.f2696O000000o.registerDataSetObserver(new DataSetObserver() {
            /* class androidx.appcompat.widget.ActivityChooserView.AnonymousClass5 */

            public final void onChanged() {
                super.onChanged();
                ActivityChooserView activityChooserView = ActivityChooserView.this;
                if (activityChooserView.f2696O000000o.getCount() > 0) {
                    activityChooserView.O00000o.setEnabled(true);
                } else {
                    activityChooserView.O00000o.setEnabled(false);
                }
                int O000000o2 = activityChooserView.f2696O000000o.f2703O000000o.O000000o();
                int O00000o0 = activityChooserView.f2696O000000o.f2703O000000o.O00000o0();
                if (O000000o2 == 1 || (O000000o2 > 1 && O00000o0 > 0)) {
                    activityChooserView.O00000oO.setVisibility(0);
                    ResolveInfo O00000Oo = activityChooserView.f2696O000000o.f2703O000000o.O00000Oo();
                    PackageManager packageManager = activityChooserView.getContext().getPackageManager();
                    activityChooserView.O00000oo.setImageDrawable(O00000Oo.loadIcon(packageManager));
                    if (activityChooserView.O0000Ooo != 0) {
                        CharSequence loadLabel = O00000Oo.loadLabel(packageManager);
                        activityChooserView.O00000oO.setContentDescription(activityChooserView.getContext().getString(activityChooserView.O0000Ooo, loadLabel));
                    }
                } else {
                    activityChooserView.O00000oO.setVisibility(8);
                }
                if (activityChooserView.O00000oO.getVisibility() == 0) {
                    activityChooserView.O00000Oo.setBackgroundDrawable(activityChooserView.O00000o0);
                } else {
                    activityChooserView.O00000Oo.setBackgroundDrawable(null);
                }
            }
        });
        Resources resources = context.getResources();
        this.O0000o0O = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
    }

    public void setActivityChooserModel(OOO0OO0 ooo0oo0) {
        O000000o o000000o = this.f2696O000000o;
        OOO0OO0 ooo0oo02 = ActivityChooserView.this.f2696O000000o.f2703O000000o;
        if (ooo0oo02 != null && ActivityChooserView.this.isShown()) {
            ooo0oo02.unregisterObserver(ActivityChooserView.this.O0000OOo);
        }
        o000000o.f2703O000000o = ooo0oo0;
        if (ooo0oo0 != null && ActivityChooserView.this.isShown()) {
            ooo0oo0.registerObserver(ActivityChooserView.this.O0000OOo);
        }
        o000000o.notifyDataSetChanged();
        if (getListPopupWindow().O0000o.isShowing()) {
            O00000Oo();
            O000000o();
        }
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        this.O0000o0.setImageDrawable(drawable);
    }

    public void setExpandActivityOverflowButtonContentDescription(int i) {
        this.O0000o0.setContentDescription(getContext().getString(i));
    }

    public void setProvider(ActionProvider actionProvider) {
        this.O0000O0o = actionProvider;
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(int i) {
        if (this.f2696O000000o.f2703O000000o != null) {
            getViewTreeObserver().addOnGlobalLayoutListener(this.O0000o0o);
            boolean z = this.O00000oO.getVisibility() == 0;
            int O000000o2 = this.f2696O000000o.f2703O000000o.O000000o();
            if (i == Integer.MAX_VALUE || O000000o2 <= i + (z ? 1 : 0)) {
                this.f2696O000000o.O000000o(false);
                this.f2696O000000o.O000000o(i);
            } else {
                this.f2696O000000o.O000000o(true);
                this.f2696O000000o.O000000o(i - 1);
            }
            ListPopupWindow listPopupWindow = getListPopupWindow();
            if (!listPopupWindow.O0000o.isShowing()) {
                if (this.O0000Oo || !z) {
                    this.f2696O000000o.O000000o(true, z);
                } else {
                    this.f2696O000000o.O000000o(false, false);
                }
                listPopupWindow.O00000o(Math.min(this.f2696O000000o.O000000o(), this.O0000o0O));
                listPopupWindow.a_();
                ActionProvider actionProvider = this.O0000O0o;
                if (actionProvider != null) {
                    actionProvider.O000000o(true);
                }
                listPopupWindow.O00000oO.setContentDescription(getContext().getString(R.string.abc_activitychooserview_choose_application));
                listPopupWindow.O00000oO.setSelector(new ColorDrawable(0));
                return;
            }
            return;
        }
        throw new IllegalStateException("No data model. Did you call #setDataModel?");
    }

    public final boolean O00000o0() {
        return getListPopupWindow().O0000o.isShowing();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        OOO0OO0 ooo0oo0 = this.f2696O000000o.f2703O000000o;
        if (ooo0oo0 != null) {
            ooo0oo0.registerObserver(this.O0000OOo);
        }
        this.O0000oO0 = true;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        OOO0OO0 ooo0oo0 = this.f2696O000000o.f2703O000000o;
        if (ooo0oo0 != null) {
            ooo0oo0.unregisterObserver(this.O0000OOo);
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.O0000o0o);
        }
        if (O00000o0()) {
            O00000Oo();
        }
        this.O0000oO0 = false;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        View view = this.O00000Oo;
        if (this.O00000oO.getVisibility() != 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2), 1073741824);
        }
        measureChild(view, i, i2);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.O00000Oo.layout(0, 0, i3 - i, i4 - i2);
        if (!O00000o0()) {
            O00000Oo();
        }
    }

    public OOO0OO0 getDataModel() {
        return this.f2696O000000o.f2703O000000o;
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.O0000Oo0 = onDismissListener;
    }

    public void setInitialActivityCount(int i) {
        this.O0000OoO = i;
    }

    public void setDefaultActionButtonContentDescription(int i) {
        this.O0000Ooo = i;
    }

    /* access modifiers changed from: package-private */
    public ListPopupWindow getListPopupWindow() {
        if (this.O0000o == null) {
            this.O0000o = new ListPopupWindow(getContext());
            this.O0000o.O000000o(this.f2696O000000o);
            ListPopupWindow listPopupWindow = this.O0000o;
            listPopupWindow.O0000Ooo = this;
            listPopupWindow.O0000OOo();
            ListPopupWindow listPopupWindow2 = this.O0000o;
            O00000Oo o00000Oo = this.O0000o00;
            listPopupWindow2.O0000o00 = o00000Oo;
            listPopupWindow2.O000000o(o00000Oo);
        }
        return this.O0000o;
    }

    class O00000Oo implements View.OnClickListener, View.OnLongClickListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener {
        O00000Oo() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            int itemViewType = ((O000000o) adapterView.getAdapter()).getItemViewType(i);
            if (itemViewType == 0) {
                ActivityChooserView.this.O00000Oo();
                if (!ActivityChooserView.this.O0000Oo) {
                    if (!ActivityChooserView.this.f2696O000000o.O00000Oo) {
                        i++;
                    }
                    Intent O00000Oo = ActivityChooserView.this.f2696O000000o.f2703O000000o.O00000Oo(i);
                    if (O00000Oo != null) {
                        O00000Oo.addFlags(524288);
                        ActivityChooserView.this.getContext().startActivity(O00000Oo);
                    }
                } else if (i > 0) {
                    OOO0OO0 ooo0oo0 = ActivityChooserView.this.f2696O000000o.f2703O000000o;
                    synchronized (ooo0oo0.O00000Oo) {
                        ooo0oo0.O00000o();
                        OOO0OO0.O000000o o000000o = ooo0oo0.O00000o0.get(i);
                        OOO0OO0.O000000o o000000o2 = ooo0oo0.O00000o0.get(0);
                        ooo0oo0.O000000o(new OOO0OO0.O00000o(new ComponentName(o000000o.f12317O000000o.activityInfo.packageName, o000000o.f12317O000000o.activityInfo.name), System.currentTimeMillis(), o000000o2 != null ? (o000000o2.O00000Oo - o000000o.O00000Oo) + 5.0f : 1.0f));
                    }
                }
            } else if (itemViewType == 1) {
                ActivityChooserView.this.O000000o(Integer.MAX_VALUE);
            } else {
                throw new IllegalArgumentException();
            }
        }

        public final void onClick(View view) {
            if (view == ActivityChooserView.this.O00000oO) {
                ActivityChooserView.this.O00000Oo();
                Intent O00000Oo = ActivityChooserView.this.f2696O000000o.f2703O000000o.O00000Oo(ActivityChooserView.this.f2696O000000o.f2703O000000o.O000000o(ActivityChooserView.this.f2696O000000o.f2703O000000o.O00000Oo()));
                if (O00000Oo != null) {
                    O00000Oo.addFlags(524288);
                    ActivityChooserView.this.getContext().startActivity(O00000Oo);
                }
            } else if (view == ActivityChooserView.this.O00000o) {
                ActivityChooserView activityChooserView = ActivityChooserView.this;
                activityChooserView.O0000Oo = false;
                activityChooserView.O000000o(activityChooserView.O0000OoO);
            } else {
                throw new IllegalArgumentException();
            }
        }

        public final boolean onLongClick(View view) {
            if (view == ActivityChooserView.this.O00000oO) {
                if (ActivityChooserView.this.f2696O000000o.getCount() > 0) {
                    ActivityChooserView activityChooserView = ActivityChooserView.this;
                    activityChooserView.O0000Oo = true;
                    activityChooserView.O000000o(activityChooserView.O0000OoO);
                }
                return true;
            }
            throw new IllegalArgumentException();
        }

        public final void onDismiss() {
            if (ActivityChooserView.this.O0000Oo0 != null) {
                ActivityChooserView.this.O0000Oo0.onDismiss();
            }
            if (ActivityChooserView.this.O0000O0o != null) {
                ActivityChooserView.this.O0000O0o.O000000o(false);
            }
        }
    }

    class O000000o extends BaseAdapter {

        /* renamed from: O000000o  reason: collision with root package name */
        OOO0OO0 f2703O000000o;
        boolean O00000Oo;
        private int O00000o = 4;
        private boolean O00000oO;
        private boolean O00000oo;

        public final long getItemId(int i) {
            return (long) i;
        }

        public final int getViewTypeCount() {
            return 3;
        }

        O000000o() {
        }

        public final int getItemViewType(int i) {
            return (!this.O00000oo || i != getCount() - 1) ? 0 : 1;
        }

        public final int getCount() {
            int O000000o2 = this.f2703O000000o.O000000o();
            if (!this.O00000Oo && this.f2703O000000o.O00000Oo() != null) {
                O000000o2--;
            }
            int min = Math.min(O000000o2, this.O00000o);
            return this.O00000oo ? min + 1 : min;
        }

        public final Object getItem(int i) {
            int itemViewType = getItemViewType(i);
            if (itemViewType == 0) {
                if (!this.O00000Oo && this.f2703O000000o.O00000Oo() != null) {
                    i++;
                }
                return this.f2703O000000o.O000000o(i);
            } else if (itemViewType == 1) {
                return null;
            } else {
                throw new IllegalArgumentException();
            }
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public final View getView(int i, View view, ViewGroup viewGroup) {
            int itemViewType = getItemViewType(i);
            if (itemViewType == 0) {
                if (view == null || view.getId() != R.id.list_item) {
                    view = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate((int) R.layout.abc_activity_chooser_view_list_item, viewGroup, false);
                }
                PackageManager packageManager = ActivityChooserView.this.getContext().getPackageManager();
                ResolveInfo resolveInfo = (ResolveInfo) getItem(i);
                ((ImageView) view.findViewById(R.id.icon)).setImageDrawable(resolveInfo.loadIcon(packageManager));
                ((TextView) view.findViewById(R.id.title)).setText(resolveInfo.loadLabel(packageManager));
                if (!this.O00000Oo || i != 0 || !this.O00000oO) {
                    view.setActivated(false);
                } else {
                    view.setActivated(true);
                }
                return view;
            } else if (itemViewType != 1) {
                throw new IllegalArgumentException();
            } else if (view != null && view.getId() == 1) {
                return view;
            } else {
                View inflate = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate((int) R.layout.abc_activity_chooser_view_list_item, viewGroup, false);
                inflate.setId(1);
                ((TextView) inflate.findViewById(R.id.title)).setText(ActivityChooserView.this.getContext().getString(R.string.abc_activity_chooser_view_see_all));
                return inflate;
            }
        }

        public final int O000000o() {
            int i = this.O00000o;
            this.O00000o = Integer.MAX_VALUE;
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
            int count = getCount();
            View view = null;
            int i2 = 0;
            for (int i3 = 0; i3 < count; i3++) {
                view = getView(i3, view, null);
                view.measure(makeMeasureSpec, makeMeasureSpec2);
                i2 = Math.max(i2, view.getMeasuredWidth());
            }
            this.O00000o = i;
            return i2;
        }

        public final void O000000o(int i) {
            if (this.O00000o != i) {
                this.O00000o = i;
                notifyDataSetChanged();
            }
        }

        public final void O000000o(boolean z) {
            if (this.O00000oo != z) {
                this.O00000oo = z;
                notifyDataSetChanged();
            }
        }

        public final void O000000o(boolean z, boolean z2) {
            if (this.O00000Oo != z || this.O00000oO != z2) {
                this.O00000Oo = z;
                this.O00000oO = z2;
                notifyDataSetChanged();
            }
        }
    }

    public static class InnerLayout extends LinearLayout {

        /* renamed from: O000000o  reason: collision with root package name */
        private static final int[] f2702O000000o = {16842964};

        public InnerLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            Oo O000000o2 = Oo.O000000o(context, attributeSet, f2702O000000o);
            setBackgroundDrawable(O000000o2.O000000o(0));
            O000000o2.f12340O000000o.recycle();
        }
    }

    public final boolean O000000o() {
        if (getListPopupWindow().O0000o.isShowing() || !this.O0000oO0) {
            return false;
        }
        this.O0000Oo = false;
        O000000o(this.O0000OoO);
        return true;
    }

    public final boolean O00000Oo() {
        if (!getListPopupWindow().O0000o.isShowing()) {
            return true;
        }
        getListPopupWindow().O00000Oo();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (!viewTreeObserver.isAlive()) {
            return true;
        }
        viewTreeObserver.removeGlobalOnLayoutListener(this.O0000o0o);
        return true;
    }
}

package _m_j;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.common.widget.CardFrameLayout;
import com.xiaomi.smarthome.library.common.widget.ConstraintHeightListView;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\"B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b¢\u0006\u0002\u0010\fJ\u0017\u0010\u0018\u001a\u0004\u0018\u00010\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\u0002\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010 \u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0003J\u0006\u0010!\u001a\u00020\u001dR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/xiaomi/smarthome/newui/SelectPopupWindow;", "", "decor", "Landroid/view/View;", "datas", "", "", "select", "", "clickListener", "Landroid/widget/AdapterView$OnItemClickListener;", "gravity", "(Landroid/view/View;Ljava/util/List;ILandroid/widget/AdapterView$OnItemClickListener;I)V", "menuPopupWindow", "Landroid/widget/PopupWindow;", "pivotX", "", "getPivotX", "()F", "setPivotX", "(F)V", "pivotY", "getPivotY", "setPivotY", "calcMenuMaxHeight", "context", "Landroid/content/Context;", "(Landroid/content/Context;)Ljava/lang/Integer;", "dismiss", "", "layout", "Lcom/xiaomi/smarthome/library/common/widget/CardFrameLayout;", "initView", "show", "SelectListAdapter", "smarthome-activity_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class hal {

    /* renamed from: O000000o  reason: collision with root package name */
    public final int f18707O000000o;
    public PopupWindow O00000Oo;
    private final List<String> O00000o;
    private final View O00000o0;
    private final AdapterView.OnItemClickListener O00000oO;
    private final int O00000oo = 53;
    private float O0000O0o;
    private float O0000OOo;

    public hal(View view, List<String> list, int i, AdapterView.OnItemClickListener onItemClickListener) {
        ixe.O00000o(view, "decor");
        ixe.O00000o(list, "datas");
        this.O00000o0 = view;
        this.O00000o = list;
        this.f18707O000000o = i;
        this.O00000oO = onItemClickListener;
    }

    /* JADX WARN: Type inference failed for: r7v8, types: [android.view.ViewGroup$LayoutParams] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    public final void O000000o() {
        DisplayMetrics displayMetrics;
        ConstraintHeightListView constraintHeightListView = new ConstraintHeightListView(this.O00000o0.getContext());
        ViewGroup.MarginLayoutParams marginLayoutParams = null;
        constraintHeightListView.setDivider(null);
        constraintHeightListView.setBackgroundResource(R.color.mj_color_white);
        FrameLayout frameLayout = new FrameLayout(this.O00000o0.getContext());
        frameLayout.setBackgroundColor(1711276032);
        CardFrameLayout cardFrameLayout = new CardFrameLayout(constraintHeightListView);
        cardFrameLayout.O00000Oo = $$Lambda$hal$Z7ZdPpeBkhgAycH0kFtLWqY0lRE.INSTANCE;
        View childAt = cardFrameLayout.getChildAt(0);
        if (childAt != null) {
            ConstraintHeightListView constraintHeightListView2 = (ConstraintHeightListView) childAt;
            Context context = this.O00000o0.getContext();
            ixe.O00000Oo(context, "decor.context");
            constraintHeightListView2.setAdapter((ListAdapter) new O000000o(this, context, this.O00000o));
            Context context2 = this.O00000o0.getContext();
            Resources resources = context2 == null ? null : context2.getResources();
            Integer valueOf = (resources == null || (displayMetrics = resources.getDisplayMetrics()) == null) ? null : Integer.valueOf(displayMetrics.heightPixels);
            Integer valueOf2 = valueOf == null ? null : Integer.valueOf((int) (((float) valueOf.intValue()) * 0.4f));
            if (valueOf2 != null) {
                constraintHeightListView2.setMaxHeight(valueOf2.intValue());
            }
            int i = this.f18707O000000o;
            if (i != -1) {
                constraintHeightListView2.setItemChecked(i, true);
            }
            ? layoutParams = constraintHeightListView2.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = layoutParams;
            }
            if (marginLayoutParams != null) {
                marginLayoutParams.width = gpc.O000000o(hyy.O000000o() ? 280.0f : 212.0f);
            }
            constraintHeightListView2.setOnItemClickListener(new AdapterView.OnItemClickListener(cardFrameLayout) {
                /* class _m_j.$$Lambda$hal$z6nxoJmbQCPy_SKDJTeMs8HkuE */
                private final /* synthetic */ CardFrameLayout f$1;

                {
                    this.f$1 = r2;
                }

                public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                    hal.O000000o(hal.this, this.f$1, adapterView, view, i, j);
                }
            });
            frameLayout.setOnClickListener(new View.OnClickListener(cardFrameLayout) {
                /* class _m_j.$$Lambda$hal$ZIBbx8390q8CyqlbcwkoO9s9wWY */
                private final /* synthetic */ CardFrameLayout f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    hal.O000000o(hal.this, this.f$1, view);
                }
            });
            frameLayout.addView(cardFrameLayout);
            frameLayout.setAlpha(0.4f);
            frameLayout.animate().alpha(1.0f).start();
            Paint paint = new Paint();
            paint.setTextSize((float) gpc.O000000o(16.0f));
            float f = 0.0f;
            for (String measureText : this.O00000o) {
                f = Math.max(paint.measureText(measureText), f);
            }
            int[] iArr = new int[2];
            this.O00000o0.getLocationInWindow(iArr);
            DisplayMetrics displayMetrics2 = this.O00000o0.getResources().getDisplayMetrics();
            ViewGroup.LayoutParams layoutParams2 = cardFrameLayout.getLayoutParams();
            if (layoutParams2 != null) {
                FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) layoutParams2;
                int i2 = this.O00000oo;
                layoutParams3.gravity = i2;
                if ((i2 & 48) == 48) {
                    this.O0000O0o = 0.0f;
                    layoutParams3.topMargin = iArr[1];
                    if ((i2 & 3) == 3) {
                        this.O0000OOo = 0.0f;
                        layoutParams3.leftMargin = iArr[0];
                    } else {
                        this.O0000OOo = 1.0f;
                        layoutParams3.rightMargin = displayMetrics2.widthPixels - (iArr[0] + this.O00000o0.getWidth());
                    }
                } else {
                    this.O0000O0o = 1.0f;
                    layoutParams3.bottomMargin = displayMetrics2.heightPixels - (iArr[1] + this.O00000o0.getHeight());
                    if ((this.O00000oo & 3) == 3) {
                        this.O0000OOo = 0.0f;
                        layoutParams3.leftMargin = iArr[0];
                    } else {
                        this.O0000OOo = 1.0f;
                        layoutParams3.rightMargin = displayMetrics2.widthPixels - (iArr[0] + this.O00000o0.getWidth());
                    }
                }
                layoutParams3.width = Math.min((int) (f + ((float) gpc.O000000o(100.0f))), (displayMetrics2.widthPixels - layoutParams3.leftMargin) - layoutParams3.rightMargin);
                constraintHeightListView.getLayoutParams().width = layoutParams3.width;
                layoutParams3.height = -2;
                ScaleAnimation scaleAnimation = new ScaleAnimation(0.4f, 1.0f, 0.4f, 1.0f, 1, this.O0000OOo, 1, this.O0000O0o);
                scaleAnimation.setDuration(300);
                cardFrameLayout.startAnimation(scaleAnimation);
                PopupWindow popupWindow = new PopupWindow(frameLayout, -1, -1);
                popupWindow.setClippingEnabled(false);
                popupWindow.setAnimationStyle(R.style.anim_popupwindow_alpha);
                popupWindow.setBackgroundDrawable(new ColorDrawable(0));
                popupWindow.setFocusable(true);
                popupWindow.setTouchable(true);
                popupWindow.setOutsideTouchable(false);
                popupWindow.showAtLocation(this.O00000o0, 51, 0, 0);
                popupWindow.update();
                this.O00000Oo = popupWindow;
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        }
        throw new NullPointerException("null cannot be cast to non-null type com.xiaomi.smarthome.library.common.widget.ConstraintHeightListView");
    }

    /* access modifiers changed from: private */
    public static final float O000000o(CardFrameLayout cardFrameLayout, int i, int i2) {
        return (float) gpc.O000000o(16.0f);
    }

    /* access modifiers changed from: private */
    public static final void O000000o(hal hal, CardFrameLayout cardFrameLayout, View view) {
        ixe.O00000o(hal, "this$0");
        ixe.O00000o(cardFrameLayout, "$cardFrameLayout");
        hal.O000000o(cardFrameLayout);
    }

    private final void O000000o(CardFrameLayout cardFrameLayout) {
        ViewPropertyAnimator duration;
        ViewPropertyAnimator animate;
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.4f, 1.0f, 0.4f, 1, this.O0000OOo, 1, this.O0000O0o);
        scaleAnimation.setDuration(300);
        cardFrameLayout.startAnimation(scaleAnimation);
        PopupWindow popupWindow = this.O00000Oo;
        ViewPropertyAnimator viewPropertyAnimator = null;
        View contentView = popupWindow == null ? null : popupWindow.getContentView();
        if (!(contentView == null || (animate = contentView.animate()) == null)) {
            viewPropertyAnimator = animate.alpha(0.0f);
        }
        if (!(viewPropertyAnimator == null || (duration = viewPropertyAnimator.setDuration(300)) == null)) {
            duration.start();
        }
        scaleAnimation.setAnimationListener(new O00000Oo(this));
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\b"}, d2 = {"com/xiaomi/smarthome/newui/SelectPopupWindow$dismiss$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "smarthome-activity_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O00000Oo implements Animation.AnimationListener {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ hal f18708O000000o;

        public final void onAnimationRepeat(Animation animation) {
        }

        public final void onAnimationStart(Animation animation) {
        }

        O00000Oo(hal hal) {
            this.f18708O000000o = hal;
        }

        public final void onAnimationEnd(Animation animation) {
            PopupWindow popupWindow = this.f18708O000000o.O00000Oo;
            if (popupWindow != null) {
                popupWindow.dismiss();
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void O000000o(hal hal, CardFrameLayout cardFrameLayout, AdapterView adapterView, View view, int i, long j) {
        ixe.O00000o(hal, "this$0");
        ixe.O00000o(cardFrameLayout, "$layout");
        AdapterView.OnItemClickListener onItemClickListener = hal.O00000oO;
        if (onItemClickListener != null) {
            onItemClickListener.onItemClick(adapterView, view, i, j);
        }
        hal.O000000o(cardFrameLayout);
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006¢\u0006\u0002\u0010\u0007J$\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/xiaomi/smarthome/newui/SelectPopupWindow$SelectListAdapter;", "Lcom/xiaomi/smarthome/adapter/BaseListAdapter;", "", "c", "Landroid/content/Context;", "mDatas", "", "(Lcom/xiaomi/smarthome/newui/SelectPopupWindow;Landroid/content/Context;Ljava/util/List;)V", "getC", "()Landroid/content/Context;", "getMDatas", "()Ljava/util/List;", "convert", "", "holder", "Lcom/xiaomi/smarthome/adapter/ViewHolder;", "item", "position", "", "getItemLayoutID", "type", "smarthome-activity_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    final class O000000o extends eza<String> {
        private final Context O00000o;
        final /* synthetic */ hal O00000o0;
        private final List<String> O00000oO;

        public final int O000000o() {
            return R.layout.item_select_popwin;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public O000000o(hal hal, Context context, List<String> list) {
            super(context, list);
            ixe.O00000o(hal, "this$0");
            ixe.O00000o(context, "c");
            ixe.O00000o(list, "mDatas");
            this.O00000o0 = hal;
            this.O00000o = context;
            this.O00000oO = list;
        }

        public final /* synthetic */ void O000000o(ezc ezc, Object obj, int i) {
            View view;
            String str = (String) obj;
            View view2 = null;
            TextView textView = ezc == null ? null : (TextView) ezc.O000000o((int) R.id.name);
            if (textView != null) {
                textView.setText(str);
            }
            int i2 = 0;
            boolean z = this.O00000o0.f18707O000000o == i;
            if (ezc != null) {
                view2 = ezc.O000000o((int) R.id.icon);
            }
            if (view2 != null) {
                if (!z) {
                    i2 = 4;
                }
                view2.setVisibility(i2);
            }
            if (textView != null) {
                textView.setTextColor(this.O00000o.getResources().getColor(z ? R.color.mj_color_green_normal : R.color.mj_color_black));
            }
            if (ezc != null && (view = ezc.itemView) != null) {
                view.setBackgroundColor(this.O00000o.getResources().getColor(z ? R.color.mj_color_home_list_selected : R.color.mj_color_dialog_bg_nor));
            }
        }
    }
}

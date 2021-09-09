package com.xiaomi.smarthome.newui;

import _m_j.fsm;
import _m_j.ggb;
import _m_j.ggc;
import _m_j.gpc;
import _m_j.gpy;
import _m_j.grv;
import _m_j.hxi;
import _m_j.hyy;
import _m_j.ixe;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.fragment.app.FragmentActivity;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.homeroom.MultiHomeManagerActivity;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.library.common.widget.ConstraintHeightListView;
import com.xiaomi.smarthome.newui.page.IPage;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001d2\u00020\u0001:\u0003\u001d\u001e\u001fB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\r\u0010\u000f\u001a\u00020\u0010H\u0016¢\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0005H\u0003J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u001bH\u0014J\b\u0010\u001c\u001a\u00020\u0013H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/xiaomi/smarthome/newui/ChangeHomePopupWindow;", "Lcom/xiaomi/smarthome/newui/page/IPage;", "activity", "Landroidx/fragment/app/FragmentActivity;", "decor", "Landroid/view/View;", "(Landroidx/fragment/app/FragmentActivity;Landroid/view/View;)V", "mListView", "Lcom/xiaomi/smarthome/library/common/widget/ConstraintHeightListView;", "getMListView", "()Lcom/xiaomi/smarthome/library/common/widget/ConstraintHeightListView;", "setMListView", "(Lcom/xiaomi/smarthome/library/common/widget/ConstraintHeightListView;)V", "menuPopupWindow", "Landroid/widget/PopupWindow;", "calcMenuMaxHeight", "", "()Ljava/lang/Integer;", "dismiss", "", "initView", "layout", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreateView", "container", "Landroid/view/ViewGroup;", "show", "Companion", "InternalHomeListAdapter", "ViewHolder", "smarthome-home_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ChangeHomePopupWindow extends IPage {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final O000000o f10084O000000o = new O000000o((byte) 0);
    private final View O00000Oo;
    private PopupWindow O00000o0;
    private ConstraintHeightListView O0000OOo;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChangeHomePopupWindow(FragmentActivity fragmentActivity, View view) {
        super(fragmentActivity);
        ixe.O00000o(fragmentActivity, "activity");
        ixe.O00000o(view, "decor");
        this.O00000Oo = view;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/xiaomi/smarthome/newui/ChangeHomePopupWindow$Companion;", "", "()V", "TAG", "", "smarthome-home_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O000000o {
        public /* synthetic */ O000000o(byte b) {
            this();
        }

        private O000000o() {
        }
    }

    public final View O000000o(ViewGroup viewGroup) {
        ixe.O00000o(viewGroup, "container");
        FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        frameLayout.setBackgroundColor(Color.parseColor("#ff000000"));
        frameLayout.setAlpha(0.0f);
        return frameLayout;
    }

    public final Integer O00000o0() {
        int i;
        if (hyy.O000000o()) {
            i = (int) (((float) gpc.O000000o()) * 0.4f);
        } else {
            i = gpc.O000000o(360.0f);
        }
        return Integer.valueOf(i);
    }

    public final void O000000o(Configuration configuration) {
        ixe.O00000o(configuration, "newConfig");
        super.O000000o(configuration);
        ConstraintHeightListView constraintHeightListView = this.O0000OOo;
        if (constraintHeightListView != null) {
            Context context = constraintHeightListView.getContext();
            ixe.O00000Oo(context, "it.context");
            constraintHeightListView.setMaxHeight(O000000o(context, this.O00000Oo));
        }
        View view = this.O00000oO;
        if (view != null) {
            view.requestLayout();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gpy.O00000Oo(android.content.Context, java.lang.String, java.lang.String, boolean):void
     arg types: [android.content.Context, java.lang.String, java.lang.String, int]
     candidates:
      _m_j.gpy.O00000Oo(android.content.Context, java.lang.String, java.lang.String, float):void
      _m_j.gpy.O00000Oo(android.content.Context, java.lang.String, java.lang.String, int):void
      _m_j.gpy.O00000Oo(android.content.Context, java.lang.String, java.lang.String, java.lang.String):void
      _m_j.gpy.O00000Oo(android.content.Context, java.lang.String, java.lang.String, boolean):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
    public final void e_() {
        ConstraintHeightListView constraintHeightListView;
        ViewPropertyAnimator alpha;
        super.e_();
        View view = this.O00000oO;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.newui.$$Lambda$ChangeHomePopupWindow$861jfkkTkI0pQcOJYZgOkPRILzM */

                public final void onClick(View view) {
                    ChangeHomePopupWindow.O000000o(ChangeHomePopupWindow.this, view);
                }
            });
        }
        View view2 = this.O00000oO;
        ViewGroup.MarginLayoutParams marginLayoutParams = null;
        ViewPropertyAnimator animate = view2 == null ? null : view2.animate();
        ViewPropertyAnimator duration = (animate == null || (alpha = animate.alpha(0.4f)) == null) ? null : alpha.setDuration(300);
        if (duration != null) {
            duration.setInterpolator(new AccelerateDecelerateInterpolator());
        }
        View inflate = LayoutInflater.from(this.O00000Oo.getContext()).inflate((int) R.layout.main_change_home_list_menu, (ViewGroup) null);
        ixe.O00000Oo(inflate, "layout");
        this.O0000OOo = (ConstraintHeightListView) inflate.findViewById(R.id.lv_home);
        View inflate2 = LayoutInflater.from(this.O00000Oo.getContext()).inflate((int) R.layout.item_homelist_footview, this.O0000OOo, false);
        View inflate3 = LayoutInflater.from(this.O00000Oo.getContext()).inflate((int) R.layout.home_list_space_20dp, this.O0000OOo, false);
        Context context = this.O00000Oo.getContext();
        ixe.O00000Oo(context, "decor.context");
        List<Home> list = ggb.O00000Oo().O0000OoO.O00000Oo;
        ixe.O00000Oo(list, "getInstance().allHome");
        O00000Oo o00000Oo = new O00000Oo(this, context, list);
        ConstraintHeightListView constraintHeightListView2 = this.O0000OOo;
        if (constraintHeightListView2 != null) {
            constraintHeightListView2.addFooterView(inflate3, null, false);
        }
        ConstraintHeightListView constraintHeightListView3 = this.O0000OOo;
        if (constraintHeightListView3 != null) {
            constraintHeightListView3.addFooterView(inflate2);
        }
        ConstraintHeightListView constraintHeightListView4 = this.O0000OOo;
        if (constraintHeightListView4 != null) {
            constraintHeightListView4.setAdapter((ListAdapter) o00000Oo);
        }
        ConstraintHeightListView constraintHeightListView5 = this.O0000OOo;
        if (constraintHeightListView5 != null) {
            Context context2 = this.O00000Oo.getContext();
            ixe.O00000Oo(context2, "decor.context");
            constraintHeightListView5.setMaxHeight(O000000o(context2, this.O00000Oo));
        }
        String O0000OOo2 = ggb.O00000Oo().O0000OOo();
        if (!(o00000Oo.O000000o(O0000OOo2) == -1 || (constraintHeightListView = this.O0000OOo) == null)) {
            constraintHeightListView.setItemChecked(o00000Oo.O000000o(O0000OOo2), true);
        }
        ConstraintHeightListView constraintHeightListView6 = this.O0000OOo;
        ViewGroup.LayoutParams layoutParams = constraintHeightListView6 == null ? null : constraintHeightListView6.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        }
        if (marginLayoutParams != null) {
            marginLayoutParams.width = gpc.O000000o(hyy.O000000o() ? 280.0f : 212.0f);
        }
        ConstraintHeightListView constraintHeightListView7 = this.O0000OOo;
        if (constraintHeightListView7 != null) {
            constraintHeightListView7.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                /* class com.xiaomi.smarthome.newui.$$Lambda$ChangeHomePopupWindow$L0qu1lxeupEFB3KpDsp9RedKL0 */

                public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                    ChangeHomePopupWindow.O000000o(ChangeHomePopupWindow.this, adapterView, view, i, j);
                }
            });
        }
        PopupWindow popupWindow = new PopupWindow(inflate, -2, -2);
        popupWindow.setClippingEnabled(false);
        popupWindow.setAnimationStyle(R.style.anim_popupwindow);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        popupWindow.setFocusable(true);
        popupWindow.setTouchable(true);
        popupWindow.setOutsideTouchable(false);
        popupWindow.showAsDropDown(this.O00000Oo, -gpc.O000000o(9.0f), -gpc.O000000o(12.0f));
        popupWindow.update();
        this.O00000o0 = popupWindow;
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            /* class com.xiaomi.smarthome.newui.$$Lambda$ChangeHomePopupWindow$kAt5UcNmOViSAYne8BY2oGt9jI */

            public final void onDismiss() {
                ChangeHomePopupWindow.O000000o(ChangeHomePopupWindow.this);
            }
        });
        gpy.O00000Oo(this.O00000Oo.getContext(), ixe.O000000o("home_room_manager_sp_", (Object) grv.O000000o(CoreApi.O000000o().O0000o0())), "show_change_home_red_dot", false);
        ggc.O000000o().O00000oo.onNext(Boolean.FALSE);
    }

    /* access modifiers changed from: private */
    public static final void O000000o(ChangeHomePopupWindow changeHomePopupWindow, View view) {
        ixe.O00000o(changeHomePopupWindow, "this$0");
        changeHomePopupWindow.O00000Oo();
    }

    /* access modifiers changed from: private */
    public static final void O000000o(ChangeHomePopupWindow changeHomePopupWindow) {
        ixe.O00000o(changeHomePopupWindow, "this$0");
        changeHomePopupWindow.O00000Oo();
    }

    public final void O00000Oo() {
        ViewPropertyAnimator alpha;
        PopupWindow popupWindow = this.O00000o0;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        View view = this.O00000oO;
        ViewPropertyAnimator animate = view == null ? null : view.animate();
        if (animate != null && (alpha = animate.alpha(0.0f)) != null) {
            alpha.withEndAction(new Runnable() {
                /* class com.xiaomi.smarthome.newui.$$Lambda$ChangeHomePopupWindow$AZ50cn4AwRrWbCSaah5ZvJRBU8 */

                public final void run() {
                    ChangeHomePopupWindow.O00000Oo(ChangeHomePopupWindow.this);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public static final void O00000Oo(ChangeHomePopupWindow changeHomePopupWindow) {
        ixe.O00000o(changeHomePopupWindow, "this$0");
        super.O00000Oo();
    }

    /* access modifiers changed from: private */
    public static final void O000000o(ChangeHomePopupWindow changeHomePopupWindow, AdapterView adapterView, View view, int i, long j) {
        String str;
        ixe.O00000o(changeHomePopupWindow, "this$0");
        if (i >= adapterView.getAdapter().getCount() - 1) {
            PopupWindow popupWindow = changeHomePopupWindow.O00000o0;
            if (popupWindow != null) {
                popupWindow.dismiss();
            }
            changeHomePopupWindow.O00000Oo.getContext().startActivity(new Intent(changeHomePopupWindow.O00000Oo.getContext(), MultiHomeManagerActivity.class));
            hxi.O00000o.O0000O0o();
            return;
        }
        Home home = (Home) adapterView.getAdapter().getItem(i);
        if (home == null) {
            str = null;
        } else {
            str = home.getId();
        }
        if (!TextUtils.equals(str, ggb.O00000Oo().O0000OOo())) {
            PopupWindow popupWindow2 = changeHomePopupWindow.O00000o0;
            if (popupWindow2 != null) {
                popupWindow2.dismiss();
            }
            ggb.O00000Oo().O000000o(home == null ? null : home.getId(), (fsm) null);
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0012\u001a\u00020\rH\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\rH\u0016J$\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/xiaomi/smarthome/newui/ChangeHomePopupWindow$InternalHomeListAdapter;", "Landroid/widget/BaseAdapter;", "mContext", "Landroid/content/Context;", "mDatas", "", "Lcom/xiaomi/smarthome/homeroom/model/Home;", "(Lcom/xiaomi/smarthome/newui/ChangeHomePopupWindow;Landroid/content/Context;Ljava/util/List;)V", "getMContext", "()Landroid/content/Context;", "getMDatas", "()Ljava/util/List;", "getCount", "", "getCurrentHomePos", "currentHomeId", "", "getItem", "position", "getItemId", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "smarthome-home_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    final class O00000Oo extends BaseAdapter {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ ChangeHomePopupWindow f10085O000000o;
        private final Context O00000Oo;
        private final List<Home> O00000o0;

        public final long getItemId(int i) {
            return (long) i;
        }

        /* JADX WARN: Type inference failed for: r4v0, types: [java.util.List<com.xiaomi.smarthome.homeroom.model.Home>, java.lang.Object, java.util.List<? extends com.xiaomi.smarthome.homeroom.model.Home>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        public O00000Oo(ChangeHomePopupWindow changeHomePopupWindow, Context context, List<? extends Home> r4) {
            ixe.O00000o(changeHomePopupWindow, "this$0");
            ixe.O00000o(context, "mContext");
            ixe.O00000o(r4, "mDatas");
            this.f10085O000000o = changeHomePopupWindow;
            this.O00000Oo = context;
            this.O00000o0 = r4;
        }

        public final int O000000o(String str) {
            int size = this.O00000o0.size() - 1;
            if (size >= 0) {
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    if (TextUtils.equals(str, this.O00000o0.get(i).getId())) {
                        return i;
                    }
                    if (i2 > size) {
                        break;
                    }
                    i = i2;
                }
            }
            return -1;
        }

        public final int getCount() {
            return this.O00000o0.size();
        }

        /* access modifiers changed from: private */
        /* renamed from: O000000o */
        public Home getItem(int i) {
            return this.O00000o0.get(i);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public final View getView(int i, View view, ViewGroup viewGroup) {
            O00000o0 o00000o0;
            Boolean bool;
            String str;
            boolean z = false;
            if (view == null) {
                view = LayoutInflater.from(this.O00000Oo).inflate((int) R.layout.item_single_choice_v2, viewGroup, false);
                ixe.O00000Oo(view, "from(mContext).inflate(R.layout.item_single_choice_v2, parent, false)");
                o00000o0 = new O00000o0(this.f10085O000000o);
                o00000o0.f10086O000000o = (ChangeHomeListItemView) view.findViewById(R.id.root);
                view.setTag(o00000o0);
            } else {
                Object tag = view.getTag();
                if (tag != null) {
                    o00000o0 = (O00000o0) tag;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type com.xiaomi.smarthome.newui.ChangeHomePopupWindow.ViewHolder");
                }
            }
            Home O000000o2 = getItem(i);
            ChangeHomeListItemView changeHomeListItemView = o00000o0.f10086O000000o;
            if (changeHomeListItemView != null) {
                ggb.O00000Oo();
                changeHomeListItemView.setText(ggb.O000000o(O000000o2));
            }
            ChangeHomeListItemView changeHomeListItemView2 = o00000o0.f10086O000000o;
            if (changeHomeListItemView2 != null) {
                if (O000000o2 == null) {
                    bool = null;
                } else {
                    bool = Boolean.valueOf(O000000o2.isOwner());
                }
                if (!ixe.O000000o(bool, Boolean.FALSE)) {
                    str = "";
                } else {
                    str = this.O00000Oo.getResources().getString(R.string.menu_edit_share);
                    ixe.O00000Oo(str, "mContext.resources.getString(R.string.menu_edit_share)");
                }
                changeHomeListItemView2.setSubText(str);
            }
            ChangeHomeListItemView changeHomeListItemView3 = o00000o0.f10086O000000o;
            if (changeHomeListItemView3 != null) {
                if (i == 0) {
                    z = true;
                }
                changeHomeListItemView3.setTopSpaceVisivle(z);
            }
            return view;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/xiaomi/smarthome/newui/ChangeHomePopupWindow$ViewHolder;", "", "(Lcom/xiaomi/smarthome/newui/ChangeHomePopupWindow;)V", "root", "Lcom/xiaomi/smarthome/newui/ChangeHomeListItemView;", "getRoot", "()Lcom/xiaomi/smarthome/newui/ChangeHomeListItemView;", "setRoot", "(Lcom/xiaomi/smarthome/newui/ChangeHomeListItemView;)V", "smarthome-home_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    final class O00000o0 {

        /* renamed from: O000000o  reason: collision with root package name */
        ChangeHomeListItemView f10086O000000o;
        final /* synthetic */ ChangeHomePopupWindow O00000Oo;

        public O00000o0(ChangeHomePopupWindow changeHomePopupWindow) {
            ixe.O00000o(changeHomePopupWindow, "this$0");
            this.O00000Oo = changeHomePopupWindow;
        }
    }
}

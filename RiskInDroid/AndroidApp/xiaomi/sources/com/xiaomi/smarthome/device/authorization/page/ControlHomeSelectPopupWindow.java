package com.xiaomi.smarthome.device.authorization.page;

import _m_j.ggb;
import _m_j.gpc;
import _m_j.gzm;
import _m_j.ixe;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.newui.HomeListDialogHelper;
import com.xiaomi.smarthome.newui.page.IPage;
import com.xiaomi.smarthome.ui.MaxHeightRecyclerView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0019B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0005H\u0002J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0017H\u0014J\b\u0010\u0018\u001a\u00020\u000fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/xiaomi/smarthome/device/authorization/page/ControlHomeSelectPopupWindow;", "Lcom/xiaomi/smarthome/newui/page/IPage;", "activity", "Landroidx/fragment/app/FragmentActivity;", "decor", "Landroid/view/View;", "did", "", "homeId", "listener", "Lcom/xiaomi/smarthome/newui/HomeListDialogHelper$ItemClickListener;", "(Landroidx/fragment/app/FragmentActivity;Landroid/view/View;Ljava/lang/String;Ljava/lang/String;Lcom/xiaomi/smarthome/newui/HomeListDialogHelper$ItemClickListener;)V", "menuPopupWindow", "Landroid/widget/PopupWindow;", "dismiss", "", "initView", "layout", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreateView", "container", "Landroid/view/ViewGroup;", "show", "ItemAdapter", "smarthome-setting_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ControlHomeSelectPopupWindow extends IPage {

    /* renamed from: O000000o  reason: collision with root package name */
    public final View f7050O000000o;
    private final String O00000Oo;
    private final String O00000o0;
    private final HomeListDialogHelper.O00000Oo O0000OOo;
    private PopupWindow O0000Oo0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ControlHomeSelectPopupWindow(FragmentActivity fragmentActivity, View view, String str, String str2, HomeListDialogHelper.O00000Oo o00000Oo) {
        super(fragmentActivity);
        ixe.O00000o(fragmentActivity, "activity");
        ixe.O00000o(view, "decor");
        ixe.O00000o(str, "did");
        ixe.O00000o(str2, "homeId");
        ixe.O00000o(o00000Oo, "listener");
        this.f7050O000000o = view;
        this.O00000Oo = str;
        this.O00000o0 = str2;
        this.O0000OOo = o00000Oo;
    }

    public final View O000000o(ViewGroup viewGroup) {
        ixe.O00000o(viewGroup, "container");
        FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        frameLayout.setBackgroundColor(Color.parseColor("#ff000000"));
        frameLayout.setAlpha(0.0f);
        return frameLayout;
    }

    public final void e_() {
        ViewPropertyAnimator alpha;
        super.e_();
        View view = this.O00000oO;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.device.authorization.page.$$Lambda$ControlHomeSelectPopupWindow$Gw4VISu9nH7g995q0HLFIIINC0 */

                public final void onClick(View view) {
                    ControlHomeSelectPopupWindow.O000000o(ControlHomeSelectPopupWindow.this, view);
                }
            });
        }
        View view2 = this.O00000oO;
        ViewPropertyAnimator animate = view2 == null ? null : view2.animate();
        ViewPropertyAnimator duration = (animate == null || (alpha = animate.alpha(0.4f)) == null) ? null : alpha.setDuration(300);
        if (duration != null) {
            duration.setInterpolator(new AccelerateDecelerateInterpolator());
        }
        View inflate = LayoutInflater.from(this.f7050O000000o.getContext()).inflate((int) R.layout.control_home_select_popup_window, (ViewGroup) null);
        ixe.O00000Oo(inflate, "layout");
        O000000o(inflate);
        PopupWindow popupWindow = new PopupWindow(inflate, -2, -2);
        popupWindow.setClippingEnabled(false);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        popupWindow.setFocusable(true);
        popupWindow.setTouchable(true);
        popupWindow.setOutsideTouchable(false);
        popupWindow.setAnimationStyle(R.style.pop_anim);
        View view3 = this.f7050O000000o;
        popupWindow.showAsDropDown(view3, (-gpc.O00000o0(view3.getContext(), 266.0f)) + this.f7050O000000o.getWidth(), -this.f7050O000000o.getHeight());
        this.O0000Oo0 = popupWindow;
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            /* class com.xiaomi.smarthome.device.authorization.page.$$Lambda$ControlHomeSelectPopupWindow$yC7WOOArnLKJZU4VSAjwDsd3tek */

            public final void onDismiss() {
                ControlHomeSelectPopupWindow.O000000o(ControlHomeSelectPopupWindow.this);
            }
        });
    }

    /* access modifiers changed from: private */
    public static final void O000000o(ControlHomeSelectPopupWindow controlHomeSelectPopupWindow, View view) {
        ixe.O00000o(controlHomeSelectPopupWindow, "this$0");
        controlHomeSelectPopupWindow.O00000Oo();
    }

    /* access modifiers changed from: private */
    public static final void O000000o(ControlHomeSelectPopupWindow controlHomeSelectPopupWindow) {
        ixe.O00000o(controlHomeSelectPopupWindow, "this$0");
        controlHomeSelectPopupWindow.O00000Oo();
    }

    public final void O00000Oo() {
        ViewPropertyAnimator alpha;
        PopupWindow popupWindow = this.O0000Oo0;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        View view = this.O00000oO;
        ViewPropertyAnimator animate = view == null ? null : view.animate();
        if (animate != null && (alpha = animate.alpha(0.0f)) != null) {
            alpha.withEndAction(new Runnable() {
                /* class com.xiaomi.smarthome.device.authorization.page.$$Lambda$ControlHomeSelectPopupWindow$YO33phI2Q9aqho1vAnz7a308Ez4 */

                public final void run() {
                    ControlHomeSelectPopupWindow.O00000Oo(ControlHomeSelectPopupWindow.this);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public static final void O00000Oo(ControlHomeSelectPopupWindow controlHomeSelectPopupWindow) {
        ixe.O00000o(controlHomeSelectPopupWindow, "this$0");
        super.O00000Oo();
    }

    public final void O000000o(Configuration configuration) {
        ixe.O00000o(configuration, "newConfig");
        super.O000000o(configuration);
        View view = this.O00000oO;
        if (view != null) {
            view.requestLayout();
        }
    }

    private final void O000000o(View view) {
        MaxHeightRecyclerView maxHeightRecyclerView = (MaxHeightRecyclerView) view.findViewById(R.id.recycler);
        maxHeightRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        maxHeightRecyclerView.setHasFixedSize(true);
        List arrayList = new ArrayList();
        for (Home next : ggb.O00000Oo().O0000OoO.O00000Oo) {
            if (next.isOwner()) {
                ixe.O00000Oo(next, "h");
                arrayList.add(next);
            }
        }
        O000000o o000000o = new O000000o(this, this.O00000Oo, this.O00000o0, this.O0000OOo);
        ixe.O00000o(arrayList, "data");
        if (arrayList.size() > 0) {
            o000000o.O00000o.clear();
            o000000o.O00000o.addAll(arrayList);
            o000000o.O00000oO = ggb.O00000Oo().O0000o0(o000000o.f7051O000000o);
            if (o000000o.O00000oO != null) {
                List<Home> list = o000000o.O00000o;
                Home home = o000000o.O00000oO;
                ixe.O000000o(home);
                list.remove(home);
                List<Home> list2 = o000000o.O00000o;
                Home home2 = o000000o.O00000oO;
                ixe.O000000o(home2);
                list2.add(0, home2);
            }
        }
        maxHeightRecyclerView.setAdapter(o000000o);
    }

    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u001bB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\rH\u0016J \u0010\u0013\u001a\n0\u0014R\u00060\u0000R\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\rH\u0016J\u0014\u0010\u0018\u001a\u00020\u000f2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\t0\u001aR\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/xiaomi/smarthome/device/authorization/page/ControlHomeSelectPopupWindow$ItemAdapter;", "Lcom/xiaomi/smarthome/multi_item/IAdapter;", "mDid", "", "mHomeId", "mListener", "Lcom/xiaomi/smarthome/newui/HomeListDialogHelper$ItemClickListener;", "(Lcom/xiaomi/smarthome/device/authorization/page/ControlHomeSelectPopupWindow;Ljava/lang/String;Ljava/lang/String;Lcom/xiaomi/smarthome/newui/HomeListDialogHelper$ItemClickListener;)V", "devHome", "Lcom/xiaomi/smarthome/homeroom/model/Home;", "mHomeList", "", "getItemCount", "", "onBindViewHolder", "", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "position", "onCreateViewHolder", "Lcom/xiaomi/smarthome/device/authorization/page/ControlHomeSelectPopupWindow$ItemAdapter$VH;", "Lcom/xiaomi/smarthome/device/authorization/page/ControlHomeSelectPopupWindow;", "container", "Landroid/view/ViewGroup;", "updateData", "data", "", "VH", "smarthome-setting_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    final class O000000o extends gzm {

        /* renamed from: O000000o  reason: collision with root package name */
        final String f7051O000000o;
        public final String O00000Oo;
        List<Home> O00000o = new ArrayList();
        public final HomeListDialogHelper.O00000Oo O00000o0;
        public Home O00000oO;
        final /* synthetic */ ControlHomeSelectPopupWindow O00000oo;

        public O000000o(ControlHomeSelectPopupWindow controlHomeSelectPopupWindow, String str, String str2, HomeListDialogHelper.O00000Oo o00000Oo) {
            ixe.O00000o(controlHomeSelectPopupWindow, "this$0");
            ixe.O00000o(str, "mDid");
            ixe.O00000o(str2, "mHomeId");
            ixe.O00000o(o00000Oo, "mListener");
            this.O00000oo = controlHomeSelectPopupWindow;
            this.f7051O000000o = str;
            this.O00000Oo = str2;
            this.O00000o0 = o00000Oo;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public final /* synthetic */ RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
            ixe.O00000o(viewGroup, "container");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.control_home_select_menu_item, viewGroup, false);
            ixe.O00000Oo(inflate, "from(container.context)\n                        .inflate(R.layout.control_home_select_menu_item, container, false)");
            return new C0065O000000o(this, inflate);
        }

        public final int getItemCount() {
            return this.O00000o.size();
        }

        /* JADX WARNING: Removed duplicated region for block: B:10:0x00ff  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x00ca  */
        public final void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
            String str;
            ixe.O00000o(o000OOo0, "viewHolder");
            C0065O000000o o000000o = (C0065O000000o) o000OOo0;
            Home home = this.O00000o.get(i);
            ixe.O00000o(home, "home");
            View findViewById = o000000o.itemView.findViewById(R.id.ll_select_home);
            ixe.O00000Oo(findViewById, "itemView.findViewById(R.id.ll_select_home)");
            LinearLayout linearLayout = (LinearLayout) findViewById;
            View findViewById2 = o000000o.itemView.findViewById(R.id.tv_home_selected);
            ixe.O00000Oo(findViewById2, "itemView.findViewById(R.id.tv_home_selected)");
            TextView textView = (TextView) findViewById2;
            View findViewById3 = o000000o.itemView.findViewById(R.id.iv_home_checked);
            ixe.O00000Oo(findViewById3, "itemView.findViewById(R.id.iv_home_checked)");
            ImageView imageView = (ImageView) findViewById3;
            linearLayout.setEnabled(true);
            linearLayout.setClickable(true);
            linearLayout.setOnClickListener(new C0065O000000o.C0066O000000o(o000000o.f7052O000000o.O00000oo, o000000o.f7052O000000o, home));
            if (o000000o.f7052O000000o.O00000oO != null) {
                Home home2 = o000000o.f7052O000000o.O00000oO;
                ixe.O000000o(home2);
                if (TextUtils.equals(home.getId(), home2.getId())) {
                    StringBuilder sb = new StringBuilder();
                    ggb.O00000Oo();
                    sb.append(ggb.O000000o(home));
                    sb.append(' ');
                    sb.append(o000000o.f7052O000000o.O00000oo.f7050O000000o.getContext().getString(R.string.device_located_home));
                    str = sb.toString();
                    textView.setText(str);
                    if (!TextUtils.equals(home.getId(), o000000o.f7052O000000o.O00000Oo)) {
                        linearLayout.setBackgroundColor(o000000o.f7052O000000o.O00000oo.f7050O000000o.getContext().getResources().getColor(R.color.mj_popup_select_bg));
                        imageView.setVisibility(0);
                        textView.setTextColor(o000000o.f7052O000000o.O00000oo.f7050O000000o.getContext().getResources().getColor(R.color.mj_popup_select_text_color));
                        return;
                    }
                    linearLayout.setBackgroundResource(R.drawable.item_ripple_no_radius);
                    imageView.setVisibility(8);
                    textView.setTextColor(o000000o.f7052O000000o.O00000oo.f7050O000000o.getContext().getResources().getColor(R.color.mj_color_black));
                    return;
                }
            }
            ggb.O00000Oo();
            str = ggb.O000000o(home);
            ixe.O00000Oo(str, "{\n                    HomeManager.getInstance().getSanitizedHomeName(home)\n                }");
            textView.setText(str);
            if (!TextUtils.equals(home.getId(), o000000o.f7052O000000o.O00000Oo)) {
            }
        }

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Lcom/xiaomi/smarthome/device/authorization/page/ControlHomeSelectPopupWindow$ItemAdapter$VH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "item", "Landroid/view/View;", "(Lcom/xiaomi/smarthome/device/authorization/page/ControlHomeSelectPopupWindow$ItemAdapter;Landroid/view/View;)V", "bind", "", "home", "Lcom/xiaomi/smarthome/homeroom/model/Home;", "position", "", "smarthome-setting_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        /* renamed from: com.xiaomi.smarthome.device.authorization.page.ControlHomeSelectPopupWindow$O000000o$O000000o  reason: collision with other inner class name */
        public final class C0065O000000o extends RecyclerView.O000OOo0 {

            /* renamed from: O000000o  reason: collision with root package name */
            final /* synthetic */ O000000o f7052O000000o;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0065O000000o(O000000o o000000o, View view) {
                super(view);
                ixe.O00000o(o000000o, "this$0");
                ixe.O00000o(view, "item");
                this.f7052O000000o = o000000o;
            }

            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/xiaomi/smarthome/device/authorization/page/ControlHomeSelectPopupWindow$ItemAdapter$VH$bind$1", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "smarthome-setting_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
            /* renamed from: com.xiaomi.smarthome.device.authorization.page.ControlHomeSelectPopupWindow$O000000o$O000000o$O000000o  reason: collision with other inner class name */
            public static final class C0066O000000o implements View.OnClickListener {

                /* renamed from: O000000o  reason: collision with root package name */
                final /* synthetic */ ControlHomeSelectPopupWindow f7053O000000o;
                final /* synthetic */ O000000o O00000Oo;
                final /* synthetic */ Home O00000o0;

                C0066O000000o(ControlHomeSelectPopupWindow controlHomeSelectPopupWindow, O000000o o000000o, Home home) {
                    this.f7053O000000o = controlHomeSelectPopupWindow;
                    this.O00000Oo = o000000o;
                    this.O00000o0 = home;
                }

                public final void onClick(View view) {
                    this.f7053O000000o.O00000Oo();
                    HomeListDialogHelper.O00000Oo o00000Oo = this.O00000Oo.O00000o0;
                    if (o00000Oo != null) {
                        o00000Oo.O000000o(this.O00000o0.getId());
                    }
                }
            }
        }
    }
}

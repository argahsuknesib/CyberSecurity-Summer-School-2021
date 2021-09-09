package com.smarthome.uwb.ui.widget;

import _m_j.gpc;
import _m_j.gzl;
import _m_j.gzm;
import _m_j.iwb;
import _m_j.ixe;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.newui.page.IPage;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001a2\u00020\u0001:\u0004\u0019\u001a\u001b\u001cB+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0005H\u0003J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0017H\u0014J\b\u0010\u0018\u001a\u00020\u000fH\u0016R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/smarthome/uwb/ui/widget/CustomPopWindow;", "Lcom/xiaomi/smarthome/newui/page/IPage;", "activity", "Landroidx/fragment/app/FragmentActivity;", "decor", "Landroid/view/View;", "items", "", "Lcom/smarthome/uwb/ui/widget/CustomPopWindow$Item;", "clickCallback", "Lcom/smarthome/uwb/ui/widget/CustomPopWindow$ClickProxy;", "(Landroidx/fragment/app/FragmentActivity;Landroid/view/View;Ljava/util/List;Lcom/smarthome/uwb/ui/widget/CustomPopWindow$ClickProxy;)V", "menuPopupWindow", "Landroid/widget/PopupWindow;", "dismiss", "", "initView", "layout", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreateView", "container", "Landroid/view/ViewGroup;", "show", "ClickProxy", "Companion", "Item", "ItemAdapter", "uwb-mijia_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class CustomPopWindow extends IPage {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final O00000Oo f5752O000000o = new O00000Oo((byte) 0);
    public final O000000o O00000Oo;
    private final View O00000o0;
    private final List<O00000o0> O0000OOo;
    private PopupWindow O0000Oo0;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/smarthome/uwb/ui/widget/CustomPopWindow$ClickProxy;", "", "onClick", "", "item", "Lcom/smarthome/uwb/ui/widget/CustomPopWindow$Item;", "uwb-mijia_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface O000000o {
        void O000000o(O00000o0 o00000o0);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomPopWindow(FragmentActivity fragmentActivity, View view, List<O00000o0> list, O000000o o000000o) {
        super(fragmentActivity);
        ixe.O00000o(fragmentActivity, "activity");
        ixe.O00000o(view, "decor");
        ixe.O00000o(list, "items");
        ixe.O00000o(o000000o, "clickCallback");
        this.O00000o0 = view;
        this.O0000OOo = list;
        this.O00000Oo = o000000o;
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J-\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/smarthome/uwb/ui/widget/CustomPopWindow$Item;", "", "id", "", "title", "isEnable", "Lkotlin/Function0;", "", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "getId", "()Ljava/lang/String;", "()Lkotlin/jvm/functions/Function0;", "getTitle", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "uwb-mijia_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O00000o0 {

        /* renamed from: O000000o  reason: collision with root package name */
        public final String f5755O000000o;
        final String O00000Oo;
        final iwb<Boolean> O00000o0;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof O00000o0)) {
                return false;
            }
            O00000o0 o00000o0 = (O00000o0) obj;
            return ixe.O000000o(this.f5755O000000o, o00000o0.f5755O000000o) && ixe.O000000o(this.O00000Oo, o00000o0.O00000Oo) && ixe.O000000o(this.O00000o0, o00000o0.O00000o0);
        }

        public final int hashCode() {
            return (((this.f5755O000000o.hashCode() * 31) + this.O00000Oo.hashCode()) * 31) + this.O00000o0.hashCode();
        }

        public final String toString() {
            return "Item(id=" + this.f5755O000000o + ", title=" + this.O00000Oo + ", isEnable=" + this.O00000o0 + ')';
        }

        public O00000o0(String str, String str2, iwb<Boolean> iwb) {
            ixe.O00000o(str, "id");
            ixe.O00000o(str2, "title");
            ixe.O00000o(iwb, "isEnable");
            this.f5755O000000o = str;
            this.O00000Oo = str2;
            this.O00000o0 = iwb;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/smarthome/uwb/ui/widget/CustomPopWindow$Companion;", "", "()V", "TAG", "", "uwb-mijia_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O00000Oo {
        public /* synthetic */ O00000Oo(byte b) {
            this();
        }

        private O00000Oo() {
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

    public final void e_() {
        ViewPropertyAnimator alpha;
        super.e_();
        View view = this.O00000oO;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() {
                /* class com.smarthome.uwb.ui.widget.$$Lambda$CustomPopWindow$Dh4Tr35Qiq66OXyWDTqfK1y9G50 */

                public final void onClick(View view) {
                    CustomPopWindow.O000000o(CustomPopWindow.this, view);
                }
            });
        }
        View view2 = this.O00000oO;
        ViewPropertyAnimator animate = view2 == null ? null : view2.animate();
        ViewPropertyAnimator duration = (animate == null || (alpha = animate.alpha(0.4f)) == null) ? null : alpha.setDuration(300);
        if (duration != null) {
            duration.setInterpolator(new AccelerateDecelerateInterpolator());
        }
        View inflate = LayoutInflater.from(this.O00000o0.getContext()).inflate((int) R.layout.custom_items_popupwindow, (ViewGroup) null);
        ixe.O00000Oo(inflate, "layout");
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new CustomPopWindow$initView$1(inflate.getContext()));
        recyclerView.setHasFixedSize(true);
        gzl gzl = new gzl();
        gzl.O000000o(new O00000o(this, this.O0000OOo));
        recyclerView.setAdapter(gzl);
        PopupWindow popupWindow = new PopupWindow(inflate, -2, -2);
        popupWindow.setClippingEnabled(false);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        popupWindow.setFocusable(true);
        popupWindow.setTouchable(true);
        popupWindow.setOutsideTouchable(false);
        popupWindow.setAnimationStyle(R.style.pop_anim);
        View view3 = this.O00000o0;
        popupWindow.showAsDropDown(view3, (-gpc.O00000o0(view3.getContext(), 212.0f)) + this.O00000o0.getWidth(), -this.O00000o0.getHeight());
        this.O0000Oo0 = popupWindow;
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            /* class com.smarthome.uwb.ui.widget.$$Lambda$CustomPopWindow$j65FY2xVEQEoATPgi_Fa4LoIXo0 */

            public final void onDismiss() {
                CustomPopWindow.O000000o(CustomPopWindow.this);
            }
        });
    }

    /* access modifiers changed from: private */
    public static final void O000000o(CustomPopWindow customPopWindow, View view) {
        ixe.O00000o(customPopWindow, "this$0");
        customPopWindow.O00000Oo();
    }

    /* access modifiers changed from: private */
    public static final void O000000o(CustomPopWindow customPopWindow) {
        ixe.O00000o(customPopWindow, "this$0");
        customPopWindow.O00000Oo();
    }

    /* access modifiers changed from: private */
    public static final void O00000Oo(CustomPopWindow customPopWindow) {
        ixe.O00000o(customPopWindow, "this$0");
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

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0014B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\tH\u0016J \u0010\u000f\u001a\n0\u0010R\u00060\u0000R\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\tH\u0016R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0015"}, d2 = {"Lcom/smarthome/uwb/ui/widget/CustomPopWindow$ItemAdapter;", "Lcom/xiaomi/smarthome/multi_item/IAdapter;", "items", "", "Lcom/smarthome/uwb/ui/widget/CustomPopWindow$Item;", "(Lcom/smarthome/uwb/ui/widget/CustomPopWindow;Ljava/util/List;)V", "getItems", "()Ljava/util/List;", "getItemCount", "", "onBindViewHolder", "", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "position", "onCreateViewHolder", "Lcom/smarthome/uwb/ui/widget/CustomPopWindow$ItemAdapter$VH;", "Lcom/smarthome/uwb/ui/widget/CustomPopWindow;", "container", "Landroid/view/ViewGroup;", "VH", "uwb-mijia_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    final class O00000o extends gzm {

        /* renamed from: O000000o  reason: collision with root package name */
        final List<O00000o0> f5753O000000o;
        final /* synthetic */ CustomPopWindow O00000Oo;

        public O00000o(CustomPopWindow customPopWindow, List<O00000o0> list) {
            ixe.O00000o(customPopWindow, "this$0");
            ixe.O00000o(list, "items");
            this.O00000Oo = customPopWindow;
            this.f5753O000000o = list;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public final /* synthetic */ RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
            ixe.O00000o(viewGroup, "container");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.popup_list_item_layout, viewGroup, false);
            ixe.O00000Oo(inflate, "from(container.context)\n                        .inflate(R.layout.popup_list_item_layout, container, false)");
            return new O000000o(this, inflate);
        }

        public final int getItemCount() {
            return this.f5753O000000o.size();
        }

        public final void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
            ixe.O00000o(o000OOo0, "viewHolder");
            ((O000000o) o000OOo0).O000000o(this.f5753O000000o.get(i), i);
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/smarthome/uwb/ui/widget/CustomPopWindow$ItemAdapter$VH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "item", "Landroid/view/View;", "(Lcom/smarthome/uwb/ui/widget/CustomPopWindow$ItemAdapter;Landroid/view/View;)V", "titleTv", "Landroid/widget/TextView;", "bind", "", "Lcom/smarthome/uwb/ui/widget/CustomPopWindow$Item;", "position", "", "setBackground", "uwb-mijia_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public final class O000000o extends RecyclerView.O000OOo0 {

            /* renamed from: O000000o  reason: collision with root package name */
            final /* synthetic */ O00000o f5754O000000o;
            private final TextView O00000Oo;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public O000000o(O00000o o00000o, View view) {
                super(view);
                ixe.O00000o(o00000o, "this$0");
                ixe.O00000o(view, "item");
                this.f5754O000000o = o00000o;
                View findViewById = view.findViewById(R.id.room_name_tv);
                if (findViewById != null) {
                    this.O00000Oo = (TextView) findViewById;
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
            }

            public final void O000000o(O00000o0 o00000o0, int i) {
                ixe.O00000o(o00000o0, "item");
                this.itemView.setEnabled(o00000o0.O00000o0.invoke().booleanValue());
                this.itemView.setAlpha(o00000o0.O00000o0.invoke().booleanValue() ? 1.0f : 0.4f);
                this.O00000Oo.setText(o00000o0.O00000Oo);
                this.itemView.setOnClickListener(
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0043: INVOKE  
                      (wrap: android.view.View : 0x0038: IGET  (r0v4 android.view.View) = (r3v0 'this' com.smarthome.uwb.ui.widget.CustomPopWindow$O00000o$O000000o A[THIS]) com.smarthome.uwb.ui.widget.CustomPopWindow.O00000o.O000000o.itemView android.view.View)
                      (wrap: com.smarthome.uwb.ui.widget.-$$Lambda$CustomPopWindow$O00000o$O000000o$Uhl31M0WCDLJ7tej8GudjmxIymg : 0x0040: CONSTRUCTOR  (r2v0 com.smarthome.uwb.ui.widget.-$$Lambda$CustomPopWindow$O00000o$O000000o$Uhl31M0WCDLJ7tej8GudjmxIymg) = 
                      (wrap: com.smarthome.uwb.ui.widget.CustomPopWindow : 0x003c: IGET  (r1v12 com.smarthome.uwb.ui.widget.CustomPopWindow) = 
                      (wrap: com.smarthome.uwb.ui.widget.CustomPopWindow$O00000o : 0x003a: IGET  (r1v11 com.smarthome.uwb.ui.widget.CustomPopWindow$O00000o) = (r3v0 'this' com.smarthome.uwb.ui.widget.CustomPopWindow$O00000o$O000000o A[THIS]) com.smarthome.uwb.ui.widget.CustomPopWindow.O00000o.O000000o.O000000o com.smarthome.uwb.ui.widget.CustomPopWindow$O00000o)
                     com.smarthome.uwb.ui.widget.CustomPopWindow.O00000o.O00000Oo com.smarthome.uwb.ui.widget.CustomPopWindow)
                      (r4v0 'o00000o0' com.smarthome.uwb.ui.widget.CustomPopWindow$O00000o0)
                     call: com.smarthome.uwb.ui.widget.-$$Lambda$CustomPopWindow$O00000o$O000000o$Uhl31M0WCDLJ7tej8GudjmxIymg.<init>(com.smarthome.uwb.ui.widget.CustomPopWindow, com.smarthome.uwb.ui.widget.CustomPopWindow$O00000o0):void type: CONSTRUCTOR)
                     type: VIRTUAL call: android.view.View.setOnClickListener(android.view.View$OnClickListener):void in method: com.smarthome.uwb.ui.widget.CustomPopWindow.O00000o.O000000o.O000000o(com.smarthome.uwb.ui.widget.CustomPopWindow$O00000o0, int):void, dex: classes4.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:215)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:208)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:337)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:290)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:259)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                    	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                    	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:226)
                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:115)
                    	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:268)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:257)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                    	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                    	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:226)
                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:115)
                    	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:268)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:257)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                    	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                    	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:226)
                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:115)
                    	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:81)
                    	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                    	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                    	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                    	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:297)
                    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:276)
                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0040: CONSTRUCTOR  (r2v0 com.smarthome.uwb.ui.widget.-$$Lambda$CustomPopWindow$O00000o$O000000o$Uhl31M0WCDLJ7tej8GudjmxIymg) = 
                      (wrap: com.smarthome.uwb.ui.widget.CustomPopWindow : 0x003c: IGET  (r1v12 com.smarthome.uwb.ui.widget.CustomPopWindow) = 
                      (wrap: com.smarthome.uwb.ui.widget.CustomPopWindow$O00000o : 0x003a: IGET  (r1v11 com.smarthome.uwb.ui.widget.CustomPopWindow$O00000o) = (r3v0 'this' com.smarthome.uwb.ui.widget.CustomPopWindow$O00000o$O000000o A[THIS]) com.smarthome.uwb.ui.widget.CustomPopWindow.O00000o.O000000o.O000000o com.smarthome.uwb.ui.widget.CustomPopWindow$O00000o)
                     com.smarthome.uwb.ui.widget.CustomPopWindow.O00000o.O00000Oo com.smarthome.uwb.ui.widget.CustomPopWindow)
                      (r4v0 'o00000o0' com.smarthome.uwb.ui.widget.CustomPopWindow$O00000o0)
                     call: com.smarthome.uwb.ui.widget.-$$Lambda$CustomPopWindow$O00000o$O000000o$Uhl31M0WCDLJ7tej8GudjmxIymg.<init>(com.smarthome.uwb.ui.widget.CustomPopWindow, com.smarthome.uwb.ui.widget.CustomPopWindow$O00000o0):void type: CONSTRUCTOR in method: com.smarthome.uwb.ui.widget.CustomPopWindow.O00000o.O000000o.O000000o(com.smarthome.uwb.ui.widget.CustomPopWindow$O00000o0, int):void, dex: classes4.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:790)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:730)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                    	... 63 more
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.smarthome.uwb.ui.widget.-$$Lambda$CustomPopWindow$O00000o$O000000o$Uhl31M0WCDLJ7tej8GudjmxIymg, state: NOT_LOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:270)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                    	... 69 more
                    */
                /*
                    this = this;
                    java.lang.String r0 = "item"
                    _m_j.ixe.O00000o(r4, r0)
                    android.view.View r0 = r3.itemView
                    _m_j.iwb<java.lang.Boolean> r1 = r4.O00000o0
                    java.lang.Object r1 = r1.invoke()
                    java.lang.Boolean r1 = (java.lang.Boolean) r1
                    boolean r1 = r1.booleanValue()
                    r0.setEnabled(r1)
                    android.view.View r0 = r3.itemView
                    _m_j.iwb<java.lang.Boolean> r1 = r4.O00000o0
                    java.lang.Object r1 = r1.invoke()
                    java.lang.Boolean r1 = (java.lang.Boolean) r1
                    boolean r1 = r1.booleanValue()
                    if (r1 == 0) goto L_0x0029
                    r1 = 1065353216(0x3f800000, float:1.0)
                    goto L_0x002c
                L_0x0029:
                    r1 = 1053609165(0x3ecccccd, float:0.4)
                L_0x002c:
                    r0.setAlpha(r1)
                    android.widget.TextView r0 = r3.O00000Oo
                    java.lang.String r1 = r4.O00000Oo
                    java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                    r0.setText(r1)
                    android.view.View r0 = r3.itemView
                    com.smarthome.uwb.ui.widget.CustomPopWindow$O00000o r1 = r3.f5754O000000o
                    com.smarthome.uwb.ui.widget.CustomPopWindow r1 = r1.O00000Oo
                    com.smarthome.uwb.ui.widget.-$$Lambda$CustomPopWindow$O00000o$O000000o$Uhl31M0WCDLJ7tej8GudjmxIymg r2 = new com.smarthome.uwb.ui.widget.-$$Lambda$CustomPopWindow$O00000o$O000000o$Uhl31M0WCDLJ7tej8GudjmxIymg
                    r2.<init>(r1, r4)
                    r0.setOnClickListener(r2)
                    r4 = 1115684864(0x42800000, float:64.0)
                    r0 = 1091567616(0x41100000, float:9.0)
                    r1 = 0
                    if (r5 != 0) goto L_0x0077
                    android.view.View r5 = r3.itemView
                    android.view.ViewGroup$LayoutParams r5 = r5.getLayoutParams()
                    if (r5 == 0) goto L_0x005f
                    android.content.Context r2 = com.xiaomi.smarthome.application.CommonApplication.getAppContext()
                    int r4 = _m_j.gpc.O00000o0(r2, r4)
                    r5.height = r4
                L_0x005f:
                    android.view.View r4 = r3.itemView
                    android.view.View r5 = r3.itemView
                    android.content.Context r5 = r5.getContext()
                    int r5 = _m_j.gpc.O00000o0(r5, r0)
                    r4.setPadding(r1, r5, r1, r1)
                    android.view.View r4 = r3.itemView
                    r5 = 2132085303(0x7f150a37, float:1.98108E38)
                    r4.setBackgroundResource(r5)
                    return
                L_0x0077:
                    com.smarthome.uwb.ui.widget.CustomPopWindow$O00000o r2 = r3.f5754O000000o
                    java.util.List<com.smarthome.uwb.ui.widget.CustomPopWindow$O00000o0> r2 = r2.f5753O000000o
                    int r2 = _m_j.iuo.O000000o(r2)
                    if (r5 != r2) goto L_0x00ab
                    android.view.View r5 = r3.itemView
                    android.view.ViewGroup$LayoutParams r5 = r5.getLayoutParams()
                    if (r5 == 0) goto L_0x0093
                    android.content.Context r2 = com.xiaomi.smarthome.application.CommonApplication.getAppContext()
                    int r4 = _m_j.gpc.O00000o0(r2, r4)
                    r5.height = r4
                L_0x0093:
                    android.view.View r4 = r3.itemView
                    android.view.View r5 = r3.itemView
                    android.content.Context r5 = r5.getContext()
                    int r5 = _m_j.gpc.O00000o0(r5, r0)
                    r4.setPadding(r1, r5, r1, r1)
                    android.view.View r4 = r3.itemView
                    r5 = 2132085302(0x7f150a36, float:1.9810799E38)
                    r4.setBackgroundResource(r5)
                    return
                L_0x00ab:
                    android.view.View r4 = r3.itemView
                    r4.setPadding(r1, r1, r1, r1)
                    android.view.View r4 = r3.itemView
                    android.view.ViewGroup$LayoutParams r4 = r4.getLayoutParams()
                    if (r4 == 0) goto L_0x00c4
                    android.content.Context r5 = com.xiaomi.smarthome.application.CommonApplication.getAppContext()
                    r0 = 1113325568(0x425c0000, float:55.0)
                    int r5 = _m_j.gpc.O00000o0(r5, r0)
                    r4.height = r5
                L_0x00c4:
                    android.view.View r4 = r3.itemView
                    r5 = 2132085304(0x7f150a38, float:1.9810803E38)
                    r4.setBackgroundResource(r5)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.smarthome.uwb.ui.widget.CustomPopWindow.O00000o.O000000o.O000000o(com.smarthome.uwb.ui.widget.CustomPopWindow$O00000o0, int):void");
            }

            /* access modifiers changed from: private */
            public static final void O000000o(CustomPopWindow customPopWindow, O00000o0 o00000o0, View view) {
                ixe.O00000o(customPopWindow, "this$0");
                ixe.O00000o(o00000o0, "$item");
                customPopWindow.O00000Oo();
                customPopWindow.O00000Oo.O000000o(o00000o0);
            }
        }
    }

    public final void O00000Oo() {
        ViewPropertyAnimator alpha;
        super.O00000oo();
        PopupWindow popupWindow = this.O0000Oo0;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        if (this.O00000oO != null) {
            View view = this.O00000oO;
            ViewPropertyAnimator animate = view == null ? null : view.animate();
            if (animate != null && (alpha = animate.alpha(0.0f)) != null) {
                alpha.withEndAction(new Runnable() {
                    /* class com.smarthome.uwb.ui.widget.$$Lambda$CustomPopWindow$S2RkWXfxSHWeIEbOJpNa6YURS8 */

                    public final void run() {
                        CustomPopWindow.O00000Oo(CustomPopWindow.this);
                    }
                });
                return;
            }
            return;
        }
        super.O00000Oo();
    }
}

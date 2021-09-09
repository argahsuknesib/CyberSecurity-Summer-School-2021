package com.xiaomi.smarthome.newui;

import _m_j.fbs;
import _m_j.fbt;
import _m_j.gfz;
import _m_j.ggb;
import _m_j.gpc;
import _m_j.gzl;
import _m_j.gzm;
import _m_j.gzq;
import _m_j.gzw;
import _m_j.hxi;
import _m_j.hxk;
import _m_j.hxp;
import _m_j.hyy;
import _m_j.iuh;
import _m_j.ixe;
import android.content.Context;
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
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.newui.page.IPage;
import com.xiaomi.smarthome.newui.widget.topnavi.PageBean;
import com.xiaomi.smarthome.ui.MaxHeightRecyclerView;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001d2\u00020\u0001:\u0004\u001d\u001e\u001f B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\r\u0010\u000f\u001a\u00020\u0010H\u0016¢\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0005H\u0003J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u001bH\u0014J\b\u0010\u001c\u001a\u00020\u0013H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006!"}, d2 = {"Lcom/xiaomi/smarthome/newui/MainRoomMenuPopupWindow;", "Lcom/xiaomi/smarthome/newui/page/IPage;", "activity", "Landroidx/fragment/app/FragmentActivity;", "decor", "Landroid/view/View;", "(Landroidx/fragment/app/FragmentActivity;Landroid/view/View;)V", "menuPopupWindow", "Landroid/widget/PopupWindow;", "recyclerView", "Lcom/xiaomi/smarthome/ui/MaxHeightRecyclerView;", "getRecyclerView", "()Lcom/xiaomi/smarthome/ui/MaxHeightRecyclerView;", "setRecyclerView", "(Lcom/xiaomi/smarthome/ui/MaxHeightRecyclerView;)V", "calcMenuMaxHeight", "", "()Ljava/lang/Integer;", "dismiss", "", "initView", "layout", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreateView", "container", "Landroid/view/ViewGroup;", "show", "Companion", "DividerPlaceHolderAdapter", "ItemAdapter", "MenuAdapter", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class MainRoomMenuPopupWindow extends IPage {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final O000000o f10109O000000o = new O000000o((byte) 0);
    private final View O00000Oo;
    private PopupWindow O00000o0;
    private MaxHeightRecyclerView O0000OOo;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MainRoomMenuPopupWindow(FragmentActivity fragmentActivity, View view) {
        super(fragmentActivity);
        ixe.O00000o(fragmentActivity, "activity");
        ixe.O00000o(view, "decor");
        this.O00000Oo = view;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/xiaomi/smarthome/newui/MainRoomMenuPopupWindow$Companion;", "", "()V", "TAG", "", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
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
            i = (int) (((float) gpc.O000000o()) * 0.6f);
        } else {
            i = gpc.O000000o(340.0f);
        }
        return Integer.valueOf(i);
    }

    /* JADX WARN: Type inference failed for: r4v4, types: [android.view.ViewGroup$LayoutParams] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    public final void e_() {
        ViewPropertyAnimator alpha;
        super.e_();
        View view = this.O00000oO;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.newui.$$Lambda$MainRoomMenuPopupWindow$N0eJXL6ty3U0mHA73dpT4cj7Vi4 */

                public final void onClick(View view) {
                    MainRoomMenuPopupWindow.O000000o(MainRoomMenuPopupWindow.this, view);
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
        View inflate = LayoutInflater.from(this.O00000Oo.getContext()).inflate((int) R.layout.main_room_menu, (ViewGroup) null);
        ixe.O00000Oo(inflate, "layout");
        MaxHeightRecyclerView maxHeightRecyclerView = (MaxHeightRecyclerView) inflate.findViewById(R.id.recycler);
        maxHeightRecyclerView.setLayoutManager(new MainRoomMenuPopupWindow$initView$1$1(inflate.getContext()));
        maxHeightRecyclerView.setHasFixedSize(true);
        Context context = inflate.getContext();
        ixe.O00000Oo(context, "layout.context");
        maxHeightRecyclerView.setMaxHeight(O000000o(context, this.O00000Oo));
        ? layoutParams = maxHeightRecyclerView.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = layoutParams;
        }
        float f = 280.0f;
        if (marginLayoutParams != null) {
            marginLayoutParams.width = gpc.O00000o0(maxHeightRecyclerView.getContext(), hyy.O000000o() ? 280.0f : 212.0f);
        }
        iuh iuh = iuh.f1631O000000o;
        this.O0000OOo = maxHeightRecyclerView;
        gzl gzl = new gzl();
        PageBean.O000000o o000000o = PageBean.CREATOR;
        Context context2 = inflate.getContext();
        ixe.O00000Oo(context2, "layout.context");
        gzl.O000000o(new O00000o0(this, PageBean.O000000o.O000000o(context2)));
        gzl.O000000o(new O00000Oo());
        gzl.O000000o(new O00000o(this));
        MaxHeightRecyclerView maxHeightRecyclerView2 = this.O0000OOo;
        if (maxHeightRecyclerView2 != null) {
            maxHeightRecyclerView2.setAdapter(gzl);
        }
        PopupWindow popupWindow = new PopupWindow(inflate, -2, -2);
        popupWindow.setClippingEnabled(false);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        popupWindow.setFocusable(true);
        popupWindow.setTouchable(true);
        popupWindow.setOutsideTouchable(false);
        popupWindow.setAnimationStyle(R.style.pop_anim);
        View view3 = this.O00000Oo;
        Context context3 = view3.getContext();
        if (!hyy.O000000o()) {
            f = 212.0f;
        }
        popupWindow.showAsDropDown(view3, (-gpc.O00000o0(context3, f)) + this.O00000Oo.getWidth(), -this.O00000Oo.getHeight());
        this.O00000o0 = popupWindow;
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            /* class com.xiaomi.smarthome.newui.$$Lambda$MainRoomMenuPopupWindow$s862P5TgsDyPvtLPjV6pKGvaDE */

            public final void onDismiss() {
                MainRoomMenuPopupWindow.O000000o(MainRoomMenuPopupWindow.this);
            }
        });
    }

    /* access modifiers changed from: private */
    public static final void O000000o(MainRoomMenuPopupWindow mainRoomMenuPopupWindow, View view) {
        ixe.O00000o(mainRoomMenuPopupWindow, "this$0");
        mainRoomMenuPopupWindow.O00000Oo();
    }

    /* access modifiers changed from: private */
    public static final void O000000o(MainRoomMenuPopupWindow mainRoomMenuPopupWindow) {
        ixe.O00000o(mainRoomMenuPopupWindow, "this$0");
        mainRoomMenuPopupWindow.O00000Oo();
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
                /* class com.xiaomi.smarthome.newui.$$Lambda$MainRoomMenuPopupWindow$zN5g8ZWAfJEadfCOC9oIX4YcyQg */

                public final void run() {
                    MainRoomMenuPopupWindow.O00000Oo(MainRoomMenuPopupWindow.this);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public static final void O00000Oo(MainRoomMenuPopupWindow mainRoomMenuPopupWindow) {
        ixe.O00000o(mainRoomMenuPopupWindow, "this$0");
        super.O00000Oo();
    }

    public final void O000000o(Configuration configuration) {
        ixe.O00000o(configuration, "newConfig");
        super.O000000o(configuration);
        MaxHeightRecyclerView maxHeightRecyclerView = this.O0000OOo;
        if (maxHeightRecyclerView != null) {
            Context context = maxHeightRecyclerView.getContext();
            ixe.O00000Oo(context, "it.context");
            maxHeightRecyclerView.setMaxHeight(O000000o(context, this.O00000Oo));
        }
        View view = this.O00000oO;
        if (view != null) {
            view.requestLayout();
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0014B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\tH\u0016J \u0010\u000f\u001a\n0\u0010R\u00060\u0000R\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\tH\u0016R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0015"}, d2 = {"Lcom/xiaomi/smarthome/newui/MainRoomMenuPopupWindow$ItemAdapter;", "Lcom/xiaomi/smarthome/multi_item/IAdapter;", "rooms", "", "Lcom/xiaomi/smarthome/newui/widget/topnavi/PageBean;", "(Lcom/xiaomi/smarthome/newui/MainRoomMenuPopupWindow;Ljava/util/List;)V", "getRooms", "()Ljava/util/List;", "getItemCount", "", "onBindViewHolder", "", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "position", "onCreateViewHolder", "Lcom/xiaomi/smarthome/newui/MainRoomMenuPopupWindow$ItemAdapter$VH;", "Lcom/xiaomi/smarthome/newui/MainRoomMenuPopupWindow;", "container", "Landroid/view/ViewGroup;", "VH", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    final class O00000o0 extends gzm {

        /* renamed from: O000000o  reason: collision with root package name */
        final List<PageBean> f10113O000000o;
        final /* synthetic */ MainRoomMenuPopupWindow O00000Oo;

        public O00000o0(MainRoomMenuPopupWindow mainRoomMenuPopupWindow, List<PageBean> list) {
            ixe.O00000o(mainRoomMenuPopupWindow, "this$0");
            ixe.O00000o(list, "rooms");
            this.O00000Oo = mainRoomMenuPopupWindow;
            this.f10113O000000o = list;
            hxp hxp = hxi.O00000o0;
            long currentTimeMillis = System.currentTimeMillis();
            String O0000o0 = CoreApi.O000000o().O0000o0();
            int size = this.f10113O000000o.size();
            hxp.f957O000000o.O000000o("all.room.panel.show.1", "time", Long.valueOf(currentTimeMillis), "uid", O0000o0, "total number", Integer.valueOf(size));
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public final /* synthetic */ RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
            ixe.O00000o(viewGroup, "container");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.device_room_list_item_layout, viewGroup, false);
            ixe.O00000Oo(inflate, "from(container.context)\n                        .inflate(R.layout.device_room_list_item_layout, container, false)");
            return new O000000o(this, inflate);
        }

        public final int getItemCount() {
            return this.f10113O000000o.size();
        }

        public final void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
            ixe.O00000o(o000OOo0, "viewHolder");
            ((O000000o) o000OOo0).O000000o(this.f10113O000000o.get(i), i);
        }

        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/xiaomi/smarthome/newui/MainRoomMenuPopupWindow$ItemAdapter$VH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "item", "Landroid/view/View;", "(Lcom/xiaomi/smarthome/newui/MainRoomMenuPopupWindow$ItemAdapter;Landroid/view/View;)V", "roomDeviceCntTv", "Landroid/widget/TextView;", "roomNameTv", "bind", "", "page", "Lcom/xiaomi/smarthome/newui/widget/topnavi/PageBean;", "position", "", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public final class O000000o extends RecyclerView.O000OOo0 {

            /* renamed from: O000000o  reason: collision with root package name */
            final /* synthetic */ O00000o0 f10114O000000o;
            private final TextView O00000Oo;
            private final TextView O00000o0;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public O000000o(O00000o0 o00000o0, View view) {
                super(view);
                ixe.O00000o(o00000o0, "this$0");
                ixe.O00000o(view, "item");
                this.f10114O000000o = o00000o0;
                View findViewById = view.findViewById(R.id.room_name_tv);
                if (findViewById != null) {
                    this.O00000Oo = (TextView) findViewById;
                    View findViewById2 = view.findViewById(R.id.room_device_cnt_tv);
                    if (findViewById2 != null) {
                        this.O00000o0 = (TextView) findViewById2;
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
                }
                throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
            }

            public final void O000000o(PageBean pageBean, int i) {
                ixe.O00000o(pageBean, "page");
                this.O00000Oo.setText(pageBean.f10340O000000o);
                this.O00000o0.setText(String.valueOf(gfz.f17670O000000o.O000000o(pageBean).size()));
                View view = this.itemView;
                O00000o0 o00000o0 = this.f10114O000000o;
                view.setOnClickListener(
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x002e: INVOKE  
                      (r0v7 'view' android.view.View)
                      (wrap: com.xiaomi.smarthome.newui.-$$Lambda$MainRoomMenuPopupWindow$O00000o0$O000000o$ZaoSvAfFlhLobHdXPcJ25kzyNgc : 0x002b: CONSTRUCTOR  (r3v0 com.xiaomi.smarthome.newui.-$$Lambda$MainRoomMenuPopupWindow$O00000o0$O000000o$ZaoSvAfFlhLobHdXPcJ25kzyNgc) = 
                      (r5v0 'pageBean' com.xiaomi.smarthome.newui.widget.topnavi.PageBean)
                      (r1v3 'o00000o0' com.xiaomi.smarthome.newui.MainRoomMenuPopupWindow$O00000o0)
                      (wrap: com.xiaomi.smarthome.newui.MainRoomMenuPopupWindow : 0x0027: IGET  (r2v0 com.xiaomi.smarthome.newui.MainRoomMenuPopupWindow) = (r1v3 'o00000o0' com.xiaomi.smarthome.newui.MainRoomMenuPopupWindow$O00000o0) com.xiaomi.smarthome.newui.MainRoomMenuPopupWindow.O00000o0.O00000Oo com.xiaomi.smarthome.newui.MainRoomMenuPopupWindow)
                     call: com.xiaomi.smarthome.newui.-$$Lambda$MainRoomMenuPopupWindow$O00000o0$O000000o$ZaoSvAfFlhLobHdXPcJ25kzyNgc.<init>(com.xiaomi.smarthome.newui.widget.topnavi.PageBean, com.xiaomi.smarthome.newui.MainRoomMenuPopupWindow$O00000o0, com.xiaomi.smarthome.newui.MainRoomMenuPopupWindow):void type: CONSTRUCTOR)
                     type: VIRTUAL call: android.view.View.setOnClickListener(android.view.View$OnClickListener):void in method: com.xiaomi.smarthome.newui.MainRoomMenuPopupWindow.O00000o0.O000000o.O000000o(com.xiaomi.smarthome.newui.widget.topnavi.PageBean, int):void, dex: classes5.dex
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
                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x002b: CONSTRUCTOR  (r3v0 com.xiaomi.smarthome.newui.-$$Lambda$MainRoomMenuPopupWindow$O00000o0$O000000o$ZaoSvAfFlhLobHdXPcJ25kzyNgc) = 
                      (r5v0 'pageBean' com.xiaomi.smarthome.newui.widget.topnavi.PageBean)
                      (r1v3 'o00000o0' com.xiaomi.smarthome.newui.MainRoomMenuPopupWindow$O00000o0)
                      (wrap: com.xiaomi.smarthome.newui.MainRoomMenuPopupWindow : 0x0027: IGET  (r2v0 com.xiaomi.smarthome.newui.MainRoomMenuPopupWindow) = (r1v3 'o00000o0' com.xiaomi.smarthome.newui.MainRoomMenuPopupWindow$O00000o0) com.xiaomi.smarthome.newui.MainRoomMenuPopupWindow.O00000o0.O00000Oo com.xiaomi.smarthome.newui.MainRoomMenuPopupWindow)
                     call: com.xiaomi.smarthome.newui.-$$Lambda$MainRoomMenuPopupWindow$O00000o0$O000000o$ZaoSvAfFlhLobHdXPcJ25kzyNgc.<init>(com.xiaomi.smarthome.newui.widget.topnavi.PageBean, com.xiaomi.smarthome.newui.MainRoomMenuPopupWindow$O00000o0, com.xiaomi.smarthome.newui.MainRoomMenuPopupWindow):void type: CONSTRUCTOR in method: com.xiaomi.smarthome.newui.MainRoomMenuPopupWindow.O00000o0.O000000o.O000000o(com.xiaomi.smarthome.newui.widget.topnavi.PageBean, int):void, dex: classes5.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:790)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:730)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                    	... 63 more
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.xiaomi.smarthome.newui.-$$Lambda$MainRoomMenuPopupWindow$O00000o0$O000000o$ZaoSvAfFlhLobHdXPcJ25kzyNgc, state: NOT_LOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:270)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                    	... 69 more
                    */
                /*
                    this = this;
                    java.lang.String r0 = "page"
                    _m_j.ixe.O00000o(r5, r0)
                    android.widget.TextView r0 = r4.O00000Oo
                    java.lang.String r1 = r5.f10340O000000o
                    java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                    r0.setText(r1)
                    _m_j.gfz r0 = _m_j.gfz.f17670O000000o
                    java.util.List r0 = r0.O000000o(r5)
                    int r0 = r0.size()
                    android.widget.TextView r1 = r4.O00000o0
                    java.lang.String r0 = java.lang.String.valueOf(r0)
                    java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                    r1.setText(r0)
                    android.view.View r0 = r4.itemView
                    com.xiaomi.smarthome.newui.MainRoomMenuPopupWindow$O00000o0 r1 = r4.f10114O000000o
                    com.xiaomi.smarthome.newui.MainRoomMenuPopupWindow r2 = r1.O00000Oo
                    com.xiaomi.smarthome.newui.-$$Lambda$MainRoomMenuPopupWindow$O00000o0$O000000o$ZaoSvAfFlhLobHdXPcJ25kzyNgc r3 = new com.xiaomi.smarthome.newui.-$$Lambda$MainRoomMenuPopupWindow$O00000o0$O000000o$ZaoSvAfFlhLobHdXPcJ25kzyNgc
                    r3.<init>(r5, r1, r2)
                    r0.setOnClickListener(r3)
                    r5 = 0
                    if (r6 != 0) goto L_0x0062
                    android.view.View r6 = r4.itemView
                    android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
                    if (r6 == 0) goto L_0x0048
                    android.content.Context r0 = com.xiaomi.smarthome.application.CommonApplication.getAppContext()
                    r1 = 1115684864(0x42800000, float:64.0)
                    int r0 = _m_j.gpc.O00000o0(r0, r1)
                    r6.height = r0
                L_0x0048:
                    android.view.View r6 = r4.itemView
                    android.view.View r0 = r4.itemView
                    android.content.Context r0 = r0.getContext()
                    r1 = 1091567616(0x41100000, float:9.0)
                    int r0 = _m_j.gpc.O00000o0(r0, r1)
                    r6.setPadding(r5, r0, r5, r5)
                    android.view.View r5 = r4.itemView
                    r6 = 2132085303(0x7f150a37, float:1.98108E38)
                    r5.setBackgroundResource(r6)
                    return
                L_0x0062:
                    android.view.View r6 = r4.itemView
                    r6.setPadding(r5, r5, r5, r5)
                    android.view.View r5 = r4.itemView
                    android.view.ViewGroup$LayoutParams r5 = r5.getLayoutParams()
                    if (r5 == 0) goto L_0x007b
                    android.content.Context r6 = com.xiaomi.smarthome.application.CommonApplication.getAppContext()
                    r0 = 1113325568(0x425c0000, float:55.0)
                    int r6 = _m_j.gpc.O00000o0(r6, r0)
                    r5.height = r6
                L_0x007b:
                    android.view.View r5 = r4.itemView
                    r6 = 2132085304(0x7f150a38, float:1.9810803E38)
                    r5.setBackgroundResource(r6)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.smarthome.newui.MainRoomMenuPopupWindow.O00000o0.O000000o.O000000o(com.xiaomi.smarthome.newui.widget.topnavi.PageBean, int):void");
            }

            /* access modifiers changed from: private */
            public static final void O000000o(PageBean pageBean, O00000o0 o00000o0, MainRoomMenuPopupWindow mainRoomMenuPopupWindow, View view) {
                ixe.O00000o(pageBean, "$page");
                ixe.O00000o(o00000o0, "this$0");
                ixe.O00000o(mainRoomMenuPopupWindow, "this$1");
                gzq.O000000o o000000o = gzq.f18638O000000o;
                gzw.O000000o(gzq.O00000o0, new MainRoomMenuPopupWindow$ItemAdapter$VH$bind$1$1(pageBean));
                hxk hxk = hxi.O00000o;
                long currentTimeMillis = System.currentTimeMillis();
                String O0000o0 = CoreApi.O000000o().O0000o0();
                String str = pageBean.f10340O000000o;
                int indexOf = o00000o0.f10113O000000o.indexOf(pageBean);
                int size = o00000o0.f10113O000000o.size();
                hxk.f952O000000o.O000000o("home.tab.all.clk", "time", Long.valueOf(currentTimeMillis), "uid", O0000o0, "name", str, "number", Integer.valueOf(indexOf), "total number", Integer.valueOf(size));
                mainRoomMenuPopupWindow.O00000Oo();
            }
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004H\u0016¨\u0006\u000f"}, d2 = {"Lcom/xiaomi/smarthome/newui/MainRoomMenuPopupWindow$DividerPlaceHolderAdapter;", "Lcom/xiaomi/smarthome/multi_item/IAdapter;", "()V", "getItemCount", "", "onBindViewHolder", "", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "p1", "ViewHolder", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    static final class O00000Oo extends gzm {
        public final int getItemCount() {
            return 1;
        }

        public final void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
            ixe.O00000o(o000OOo0, "holder");
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public final RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
            ixe.O00000o(viewGroup, "parent");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.activity_main_room_adater_menu_divider_item, viewGroup, false);
            ixe.O00000Oo(inflate, "item");
            return new O000000o(this, inflate);
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/xiaomi/smarthome/newui/MainRoomMenuPopupWindow$DividerPlaceHolderAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/xiaomi/smarthome/newui/MainRoomMenuPopupWindow$DividerPlaceHolderAdapter;Landroid/view/View;)V", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        final class O000000o extends RecyclerView.O000OOo0 {

            /* renamed from: O000000o  reason: collision with root package name */
            final /* synthetic */ O00000Oo f10110O000000o;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public O000000o(O00000Oo o00000Oo, View view) {
                super(view);
                ixe.O00000o(o00000Oo, "this$0");
                ixe.O00000o(view, "itemView");
                this.f10110O000000o = o00000Oo;
            }
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004H\u0016J \u0010\u000b\u001a\n0\fR\u00060\u0000R\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u0004H\u0016¨\u0006\u0011"}, d2 = {"Lcom/xiaomi/smarthome/newui/MainRoomMenuPopupWindow$MenuAdapter;", "Lcom/xiaomi/smarthome/multi_item/IAdapter;", "(Lcom/xiaomi/smarthome/newui/MainRoomMenuPopupWindow;)V", "getColumn", "", "getItemCount", "onBindViewHolder", "", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "p1", "onCreateViewHolder", "Lcom/xiaomi/smarthome/newui/MainRoomMenuPopupWindow$MenuAdapter$VH;", "Lcom/xiaomi/smarthome/newui/MainRoomMenuPopupWindow;", "container", "Landroid/view/ViewGroup;", "VH", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    final class O00000o extends gzm {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ MainRoomMenuPopupWindow f10111O000000o;

        public final int O000000o() {
            return 1;
        }

        public final int getItemCount() {
            return 1;
        }

        public O00000o(MainRoomMenuPopupWindow mainRoomMenuPopupWindow) {
            ixe.O00000o(mainRoomMenuPopupWindow, "this$0");
            this.f10111O000000o = mainRoomMenuPopupWindow;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public final /* synthetic */ RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
            ixe.O00000o(viewGroup, "container");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.activity_main_room_adapter_menu_item, viewGroup, false);
            ixe.O00000Oo(inflate, "from(container.context)\n                        .inflate(R.layout.activity_main_room_adapter_menu_item, container, false)");
            return new O000000o(this, inflate);
        }

        public final void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
            ixe.O00000o(o000OOo0, "viewHolder");
            ((O000000o) o000OOo0).O000000o();
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/xiaomi/smarthome/newui/MainRoomMenuPopupWindow$MenuAdapter$VH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "item", "Landroid/view/View;", "(Lcom/xiaomi/smarthome/newui/MainRoomMenuPopupWindow$MenuAdapter;Landroid/view/View;)V", "bind", "", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public final class O000000o extends RecyclerView.O000OOo0 {

            /* renamed from: O000000o  reason: collision with root package name */
            final /* synthetic */ O00000o f10112O000000o;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public O000000o(O00000o o00000o, View view) {
                super(view);
                ixe.O00000o(o00000o, "this$0");
                ixe.O00000o(view, "item");
                this.f10112O000000o = o00000o;
            }

            public final void O000000o() {
                this.itemView.findViewById(R.id.all_device_btn).setOnClickListener(
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0012: INVOKE  
                      (wrap: android.view.View : 0x0005: INVOKE  (r0v1 android.view.View) = 
                      (wrap: android.view.View : 0x0000: IGET  (r0v0 android.view.View) = (r3v0 'this' com.xiaomi.smarthome.newui.MainRoomMenuPopupWindow$O00000o$O000000o A[THIS]) com.xiaomi.smarthome.newui.MainRoomMenuPopupWindow.O00000o.O000000o.itemView android.view.View)
                      (wrap: ? : ?: SGET   com.xiaomi.smarthome.R.id.all_device_btn int)
                     type: VIRTUAL call: android.view.View.findViewById(int):android.view.View)
                      (wrap: com.xiaomi.smarthome.newui.-$$Lambda$MainRoomMenuPopupWindow$O00000o$O000000o$hwbbMfV2N3OuvT0Y9LoMx2t8BjE : 0x000f: CONSTRUCTOR  (r2v0 com.xiaomi.smarthome.newui.-$$Lambda$MainRoomMenuPopupWindow$O00000o$O000000o$hwbbMfV2N3OuvT0Y9LoMx2t8BjE) = 
                      (r3v0 'this' com.xiaomi.smarthome.newui.MainRoomMenuPopupWindow$O00000o$O000000o A[THIS])
                      (wrap: com.xiaomi.smarthome.newui.MainRoomMenuPopupWindow : 0x000b: IGET  (r1v2 com.xiaomi.smarthome.newui.MainRoomMenuPopupWindow) = 
                      (wrap: com.xiaomi.smarthome.newui.MainRoomMenuPopupWindow$O00000o : 0x0009: IGET  (r1v1 com.xiaomi.smarthome.newui.MainRoomMenuPopupWindow$O00000o) = (r3v0 'this' com.xiaomi.smarthome.newui.MainRoomMenuPopupWindow$O00000o$O000000o A[THIS]) com.xiaomi.smarthome.newui.MainRoomMenuPopupWindow.O00000o.O000000o.O000000o com.xiaomi.smarthome.newui.MainRoomMenuPopupWindow$O00000o)
                     com.xiaomi.smarthome.newui.MainRoomMenuPopupWindow.O00000o.O000000o com.xiaomi.smarthome.newui.MainRoomMenuPopupWindow)
                     call: com.xiaomi.smarthome.newui.-$$Lambda$MainRoomMenuPopupWindow$O00000o$O000000o$hwbbMfV2N3OuvT0Y9LoMx2t8BjE.<init>(com.xiaomi.smarthome.newui.MainRoomMenuPopupWindow$O00000o$O000000o, com.xiaomi.smarthome.newui.MainRoomMenuPopupWindow):void type: CONSTRUCTOR)
                     type: VIRTUAL call: android.view.View.setOnClickListener(android.view.View$OnClickListener):void in method: com.xiaomi.smarthome.newui.MainRoomMenuPopupWindow.O00000o.O000000o.O000000o():void, dex: classes5.dex
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
                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000f: CONSTRUCTOR  (r2v0 com.xiaomi.smarthome.newui.-$$Lambda$MainRoomMenuPopupWindow$O00000o$O000000o$hwbbMfV2N3OuvT0Y9LoMx2t8BjE) = 
                      (r3v0 'this' com.xiaomi.smarthome.newui.MainRoomMenuPopupWindow$O00000o$O000000o A[THIS])
                      (wrap: com.xiaomi.smarthome.newui.MainRoomMenuPopupWindow : 0x000b: IGET  (r1v2 com.xiaomi.smarthome.newui.MainRoomMenuPopupWindow) = 
                      (wrap: com.xiaomi.smarthome.newui.MainRoomMenuPopupWindow$O00000o : 0x0009: IGET  (r1v1 com.xiaomi.smarthome.newui.MainRoomMenuPopupWindow$O00000o) = (r3v0 'this' com.xiaomi.smarthome.newui.MainRoomMenuPopupWindow$O00000o$O000000o A[THIS]) com.xiaomi.smarthome.newui.MainRoomMenuPopupWindow.O00000o.O000000o.O000000o com.xiaomi.smarthome.newui.MainRoomMenuPopupWindow$O00000o)
                     com.xiaomi.smarthome.newui.MainRoomMenuPopupWindow.O00000o.O000000o com.xiaomi.smarthome.newui.MainRoomMenuPopupWindow)
                     call: com.xiaomi.smarthome.newui.-$$Lambda$MainRoomMenuPopupWindow$O00000o$O000000o$hwbbMfV2N3OuvT0Y9LoMx2t8BjE.<init>(com.xiaomi.smarthome.newui.MainRoomMenuPopupWindow$O00000o$O000000o, com.xiaomi.smarthome.newui.MainRoomMenuPopupWindow):void type: CONSTRUCTOR in method: com.xiaomi.smarthome.newui.MainRoomMenuPopupWindow.O00000o.O000000o.O000000o():void, dex: classes5.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:790)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:730)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                    	... 63 more
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.xiaomi.smarthome.newui.-$$Lambda$MainRoomMenuPopupWindow$O00000o$O000000o$hwbbMfV2N3OuvT0Y9LoMx2t8BjE, state: NOT_LOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:270)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                    	... 69 more
                    */
                /*
                    this = this;
                    android.view.View r0 = r3.itemView
                    r1 = 2132148493(0x7f16010d, float:1.9938966E38)
                    android.view.View r0 = r0.findViewById(r1)
                    com.xiaomi.smarthome.newui.MainRoomMenuPopupWindow$O00000o r1 = r3.f10112O000000o
                    com.xiaomi.smarthome.newui.MainRoomMenuPopupWindow r1 = r1.f10111O000000o
                    com.xiaomi.smarthome.newui.-$$Lambda$MainRoomMenuPopupWindow$O00000o$O000000o$hwbbMfV2N3OuvT0Y9LoMx2t8BjE r2 = new com.xiaomi.smarthome.newui.-$$Lambda$MainRoomMenuPopupWindow$O00000o$O000000o$hwbbMfV2N3OuvT0Y9LoMx2t8BjE
                    r2.<init>(r3, r1)
                    r0.setOnClickListener(r2)
                    android.view.View r0 = r3.itemView
                    r1 = 2132152588(0x7f16110c, float:1.9947271E38)
                    android.view.View r0 = r0.findViewById(r1)
                    _m_j.ggb r1 = _m_j.ggb.O00000Oo()
                    com.xiaomi.smarthome.homeroom.model.Home r1 = r1.O0000Oo0()
                    if (r1 != 0) goto L_0x002a
                    r1 = 0
                    goto L_0x0032
                L_0x002a:
                    boolean r1 = r1.isOwner()
                    java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
                L_0x0032:
                    java.lang.Boolean r2 = java.lang.Boolean.TRUE
                    boolean r1 = _m_j.ixe.O000000o(r1, r2)
                    if (r1 == 0) goto L_0x003c
                    r1 = 0
                    goto L_0x003e
                L_0x003c:
                    r1 = 8
                L_0x003e:
                    r0.setVisibility(r1)
                    com.xiaomi.smarthome.newui.MainRoomMenuPopupWindow$O00000o r1 = r3.f10112O000000o
                    com.xiaomi.smarthome.newui.MainRoomMenuPopupWindow r1 = r1.f10111O000000o
                    com.xiaomi.smarthome.newui.-$$Lambda$MainRoomMenuPopupWindow$O00000o$O000000o$bfMnTgvH-t9FR5rmsR0Mi6YR3Dc r2 = new com.xiaomi.smarthome.newui.-$$Lambda$MainRoomMenuPopupWindow$O00000o$O000000o$bfMnTgvH-t9FR5rmsR0Mi6YR3Dc
                    r2.<init>(r1)
                    r0.setOnClickListener(r2)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.smarthome.newui.MainRoomMenuPopupWindow.O00000o.O000000o.O000000o():void");
            }

            /* access modifiers changed from: private */
            public static final void O000000o(O000000o o000000o, MainRoomMenuPopupWindow mainRoomMenuPopupWindow, View view) {
                ixe.O00000o(o000000o, "this$0");
                ixe.O00000o(mainRoomMenuPopupWindow, "this$1");
                AllDeviceActivity.startActivity(o000000o.itemView.getContext());
                mainRoomMenuPopupWindow.O00000Oo();
            }

            /* access modifiers changed from: private */
            public static final void O000000o(MainRoomMenuPopupWindow mainRoomMenuPopupWindow, View view) {
                ixe.O00000o(mainRoomMenuPopupWindow, "this$0");
                fbt fbt = new fbt(view.getContext(), "HomeRoomManageListActivity");
                fbt.O000000o("home_id", ggb.O00000Oo().O0000OOo());
                fbs.O000000o(fbt);
                mainRoomMenuPopupWindow.O00000Oo();
            }
        }
    }
}

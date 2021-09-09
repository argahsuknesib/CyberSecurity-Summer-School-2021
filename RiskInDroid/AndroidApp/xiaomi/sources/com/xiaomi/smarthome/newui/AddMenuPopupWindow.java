package com.xiaomi.smarthome.newui;

import _m_j.fbs;
import _m_j.fbt;
import _m_j.gpc;
import _m_j.gty;
import _m_j.hna;
import _m_j.htv;
import _m_j.htw;
import _m_j.hyy;
import _m_j.inc;
import _m_j.ixe;
import _m_j.izb;
import android.app.Activity;
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
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.newui.page.IPage;
import com.xiaomi.smarthome.ui.MaxHeightRecyclerView;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 *2\u00020\u0001:\u0001*B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\r\u0010\u0018\u001a\u00020\u0019H\u0016¢\u0006\u0002\u0010\u001aJ\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u0005H\u0003J\u0010\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020$H\u0014J\u0010\u0010%\u001a\u00020\u001c2\b\u0010&\u001a\u0004\u0018\u00010'J\u000e\u0010(\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020'J\b\u0010)\u001a\u00020\u001cH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\n\"\u0004\b\u0017\u0010\f¨\u0006+"}, d2 = {"Lcom/xiaomi/smarthome/newui/AddMenuPopupWindow;", "Lcom/xiaomi/smarthome/newui/page/IPage;", "activity", "Landroidx/fragment/app/FragmentActivity;", "decor", "Landroid/view/View;", "(Landroidx/fragment/app/FragmentActivity;Landroid/view/View;)V", "addDeviceTv", "Landroid/widget/TextView;", "getAddDeviceTv", "()Landroid/widget/TextView;", "setAddDeviceTv", "(Landroid/widget/TextView;)V", "menuPopupWindow", "Landroid/widget/PopupWindow;", "recyclerView", "Lcom/xiaomi/smarthome/ui/MaxHeightRecyclerView;", "getRecyclerView", "()Lcom/xiaomi/smarthome/ui/MaxHeightRecyclerView;", "setRecyclerView", "(Lcom/xiaomi/smarthome/ui/MaxHeightRecyclerView;)V", "scanDeviceTv", "getScanDeviceTv", "setScanDeviceTv", "calcMenuMaxHeight", "", "()Ljava/lang/Integer;", "dismiss", "", "initView", "layout", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreateView", "container", "Landroid/view/ViewGroup;", "openChooseDevice", "context", "Landroid/content/Context;", "openScanQRActivity", "show", "Companion", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class AddMenuPopupWindow extends IPage {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final O000000o f10068O000000o = new O000000o((byte) 0);
    private final FragmentActivity O00000Oo;
    private final View O00000o0;
    private PopupWindow O0000OOo;
    private TextView O0000Oo;
    private MaxHeightRecyclerView O0000Oo0;
    private TextView O0000OoO;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AddMenuPopupWindow(FragmentActivity fragmentActivity, View view) {
        super(fragmentActivity);
        ixe.O00000o(fragmentActivity, "activity");
        ixe.O00000o(view, "decor");
        this.O00000Oo = fragmentActivity;
        this.O00000o0 = view;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/xiaomi/smarthome/newui/AddMenuPopupWindow$Companion;", "", "()V", "TAG", "", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
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

    public final void e_() {
        ViewPropertyAnimator alpha;
        super.e_();
        View view = this.O00000oO;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.newui.$$Lambda$AddMenuPopupWindow$BCv8__JIrZ7yMoCfUlJzR1Hpcms */

                public final void onClick(View view) {
                    AddMenuPopupWindow.O000000o(AddMenuPopupWindow.this, view);
                }
            });
        }
        View view2 = this.O00000oO;
        ViewPropertyAnimator animate = view2 == null ? null : view2.animate();
        ViewPropertyAnimator duration = (animate == null || (alpha = animate.alpha(0.4f)) == null) ? null : alpha.setDuration(300);
        if (duration != null) {
            duration.setInterpolator(new AccelerateDecelerateInterpolator());
        }
        View inflate = LayoutInflater.from(this.O00000o0.getContext()).inflate((int) R.layout.mj_add_device_menu, (ViewGroup) null);
        ixe.O00000Oo(inflate, "layout");
        this.O0000Oo = (TextView) inflate.findViewById(R.id.add_device_tv);
        TextView textView = this.O0000Oo;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.newui.$$Lambda$AddMenuPopupWindow$bHXLAqlSAndWRMGx8BMn53Oc4Tc */

                public final void onClick(View view) {
                    AddMenuPopupWindow.O00000Oo(AddMenuPopupWindow.this, view);
                }
            });
        }
        this.O0000OoO = (TextView) inflate.findViewById(R.id.scan_device_tv);
        TextView textView2 = this.O0000OoO;
        if (textView2 != null) {
            textView2.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.newui.$$Lambda$AddMenuPopupWindow$h42VvHpbCWKckRk3VQV78RQ9emU */

                public final void onClick(View view) {
                    AddMenuPopupWindow.O00000o0(AddMenuPopupWindow.this, view);
                }
            });
        }
        PopupWindow popupWindow = new PopupWindow(inflate, -2, -2);
        popupWindow.setClippingEnabled(false);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        popupWindow.setFocusable(true);
        popupWindow.setTouchable(true);
        popupWindow.setOutsideTouchable(false);
        popupWindow.setAnimationStyle(R.style.pop_anim);
        View view3 = this.O00000o0;
        popupWindow.showAsDropDown(view3, (-gpc.O00000o0(view3.getContext(), hyy.O000000o() ? 280.0f : 212.0f)) + this.O00000o0.getWidth(), (-this.O00000o0.getHeight()) + 30);
        this.O0000OOo = popupWindow;
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            /* class com.xiaomi.smarthome.newui.$$Lambda$AddMenuPopupWindow$PORmIN7MszyKZdLeIrn_t2m1SY */

            public final void onDismiss() {
                AddMenuPopupWindow.O000000o(AddMenuPopupWindow.this);
            }
        });
    }

    /* access modifiers changed from: private */
    public static final void O000000o(AddMenuPopupWindow addMenuPopupWindow, View view) {
        ixe.O00000o(addMenuPopupWindow, "this$0");
        addMenuPopupWindow.O00000Oo();
    }

    /* access modifiers changed from: private */
    public static final void O000000o(AddMenuPopupWindow addMenuPopupWindow) {
        ixe.O00000o(addMenuPopupWindow, "this$0");
        addMenuPopupWindow.O00000Oo();
    }

    public final void O00000Oo() {
        ViewPropertyAnimator alpha;
        PopupWindow popupWindow = this.O0000OOo;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        View view = this.O00000oO;
        ViewPropertyAnimator animate = view == null ? null : view.animate();
        if (animate != null && (alpha = animate.alpha(0.0f)) != null) {
            alpha.withEndAction(new Runnable() {
                /* class com.xiaomi.smarthome.newui.$$Lambda$AddMenuPopupWindow$VXaBTWTvy1m8vPjG9UbyXaBhLsk */

                public final void run() {
                    AddMenuPopupWindow.O00000Oo(AddMenuPopupWindow.this);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public static final void O00000Oo(AddMenuPopupWindow addMenuPopupWindow) {
        ixe.O00000o(addMenuPopupWindow, "this$0");
        super.O00000Oo();
    }

    public final void O000000o(Configuration configuration) {
        ixe.O00000o(configuration, "newConfig");
        super.O000000o(configuration);
        MaxHeightRecyclerView maxHeightRecyclerView = this.O0000Oo0;
        if (maxHeightRecyclerView != null) {
            Context context = maxHeightRecyclerView.getContext();
            ixe.O00000Oo(context, "it.context");
            maxHeightRecyclerView.setMaxHeight(O000000o(context, this.O00000o0));
        }
        View view = this.O00000oO;
        if (view != null) {
            view.requestLayout();
        }
    }

    /* access modifiers changed from: private */
    public static final void O00000Oo(AddMenuPopupWindow addMenuPopupWindow, View view) {
        ixe.O00000o(addMenuPopupWindow, "this$0");
        Context context = addMenuPopupWindow.O00000Oo;
        if (!CoreApi.O000000o().O0000Ooo()) {
            gty.O000000o().startLogin(context, 1, null);
        } else {
            htw O000000o2 = htv.O000000o();
            if (O000000o2 == null || !O000000o2.isFindingNew()) {
                ixe.O000000o(context);
                fbt fbt = new fbt(context, "ChooseDeviceActivity");
                fbt.O000000o(3);
                fbs.O000000o(fbt);
            } else {
                izb.O000000o(context, (int) R.string.smart_config_connecting, 0).show();
            }
        }
        addMenuPopupWindow.O00000Oo();
    }

    /* access modifiers changed from: private */
    public static final void O00000o0(AddMenuPopupWindow addMenuPopupWindow, View view) {
        ixe.O00000o(addMenuPopupWindow, "this$0");
        Context context = addMenuPopupWindow.O00000Oo;
        ixe.O00000o(context, "context");
        if (!CoreApi.O000000o().O0000Ooo()) {
            gty.O000000o().startLogin(context, 1, null);
        } else {
            hna.O000000o().checkPassedForCamera((Activity) context, true, new inc(context) {
                /* class com.xiaomi.smarthome.newui.$$Lambda$AddMenuPopupWindow$Ax7ZPXdHC8_vs9bmV_czbKWsLvk */
                private final /* synthetic */ Context f$0;

                {
                    this.f$0 = r1;
                }

                public final void onAction(List list) {
                    AddMenuPopupWindow.O000000o(this.f$0, list);
                }
            });
        }
        addMenuPopupWindow.O00000Oo();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fbt.O000000o(java.lang.String, boolean):_m_j.fbt
     arg types: [java.lang.String, int]
     candidates:
      _m_j.fbt.O000000o(java.lang.String, java.lang.Object):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.Class, java.lang.String):T
      _m_j.fbt.O000000o(java.lang.String, int):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, android.os.Bundle):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, android.os.Parcelable):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.io.Serializable):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.CharSequence):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.String):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.util.ArrayList<? extends android.os.Parcelable>):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.String[]):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, boolean):_m_j.fbt */
    /* access modifiers changed from: private */
    public static final void O000000o(Context context, List list) {
        ixe.O00000o(context, "$context");
        fbt fbt = new fbt(context, "ChooseDeviceActivity");
        fbt.O000000o(4);
        fbt.O000000o("from_mainpage", true);
        fbs.O000000o(fbt);
    }
}

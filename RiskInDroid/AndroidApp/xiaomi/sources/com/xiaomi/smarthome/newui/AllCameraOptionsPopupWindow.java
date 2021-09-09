package com.xiaomi.smarthome.newui;

import _m_j.fsm;
import _m_j.fso;
import _m_j.ft;
import _m_j.gpc;
import _m_j.gsy;
import _m_j.gti;
import _m_j.hxi;
import _m_j.ixe;
import android.content.Intent;
import android.content.SharedPreferences;
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
import com.xiaomi.smarthome.camera.api.CameraRouterFactory;
import com.xiaomi.smarthome.newui.page.IPage;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0005H\u0003J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0018H\u0014J\b\u0010\u0019\u001a\u00020\u0010H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/xiaomi/smarthome/newui/AllCameraOptionsPopupWindow;", "Lcom/xiaomi/smarthome/newui/page/IPage;", "activity", "Landroidx/fragment/app/FragmentActivity;", "decor", "Landroid/view/View;", "mViewMode", "", "(Landroidx/fragment/app/FragmentActivity;Landroid/view/View;I)V", "getMViewMode", "()I", "setMViewMode", "(I)V", "menuPopupWindow", "Landroid/widget/PopupWindow;", "dismiss", "", "initView", "layout", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreateView", "container", "Landroid/view/ViewGroup;", "show", "Companion", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class AllCameraOptionsPopupWindow extends IPage {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final O000000o f10077O000000o = new O000000o((byte) 0);
    public final View O00000Oo;
    private int O00000o0;
    private PopupWindow O0000OOo;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AllCameraOptionsPopupWindow(FragmentActivity fragmentActivity, View view, int i) {
        super(fragmentActivity);
        ixe.O00000o(fragmentActivity, "activity");
        ixe.O00000o(view, "decor");
        this.O00000Oo = view;
        this.O00000o0 = i;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/xiaomi/smarthome/newui/AllCameraOptionsPopupWindow$Companion;", "", "()V", "TAG", "", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
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

    public final void e_() {
        ViewPropertyAnimator alpha;
        super.e_();
        View view = this.O00000oO;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.newui.$$Lambda$AllCameraOptionsPopupWindow$hYcLbkxNKWqnHL34cwrtCmO_tw */

                public final void onClick(View view) {
                    AllCameraOptionsPopupWindow.O000000o(AllCameraOptionsPopupWindow.this, view);
                }
            });
        }
        View view2 = this.O00000oO;
        ViewPropertyAnimator animate = view2 == null ? null : view2.animate();
        ViewPropertyAnimator duration = (animate == null || (alpha = animate.alpha(0.4f)) == null) ? null : alpha.setDuration(300);
        if (duration != null) {
            duration.setInterpolator(new AccelerateDecelerateInterpolator());
        }
        View inflate = LayoutInflater.from(this.O00000Oo.getContext()).inflate((int) R.layout.popup_camera_select_showmode, (ViewGroup) null);
        ixe.O00000Oo(inflate, "layout");
        TextView textView = (TextView) inflate.findViewById(R.id.tv_select_mode);
        textView.setText(this.O00000o0 == 0 ? R.string.camera_option_select_smarll_show : R.string.camera_option_select_large_show);
        ((TextView) inflate.findViewById(R.id.tv_sort)).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.newui.$$Lambda$AllCameraOptionsPopupWindow$qeu6XPgcaztzbSn2y6xxIl_y9Ws */

            public final void onClick(View view) {
                AllCameraOptionsPopupWindow.O00000Oo(AllCameraOptionsPopupWindow.this, view);
            }
        });
        textView.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.newui.$$Lambda$AllCameraOptionsPopupWindow$YLB136Vi1yFeR0n1sV0xY62WlI */

            public final void onClick(View view) {
                AllCameraOptionsPopupWindow.O00000o0(AllCameraOptionsPopupWindow.this, view);
            }
        });
        PopupWindow popupWindow = new PopupWindow(inflate, -2, -2);
        popupWindow.setClippingEnabled(false);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        popupWindow.setFocusable(true);
        popupWindow.setTouchable(true);
        popupWindow.setOutsideTouchable(false);
        popupWindow.setAnimationStyle(R.style.pop_anim);
        View view3 = this.O00000Oo;
        popupWindow.showAsDropDown(view3, (-gpc.O00000o0(view3.getContext(), 222.0f)) + this.O00000Oo.getWidth(), 0);
        this.O0000OOo = popupWindow;
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            /* class com.xiaomi.smarthome.newui.$$Lambda$AllCameraOptionsPopupWindow$7puzmL_4SZrhjO1o8NhNWrqcwHQ */

            public final void onDismiss() {
                AllCameraOptionsPopupWindow.O000000o(AllCameraOptionsPopupWindow.this);
            }
        });
    }

    /* access modifiers changed from: private */
    public static final void O000000o(AllCameraOptionsPopupWindow allCameraOptionsPopupWindow, View view) {
        ixe.O00000o(allCameraOptionsPopupWindow, "this$0");
        allCameraOptionsPopupWindow.O00000Oo();
    }

    /* access modifiers changed from: private */
    public static final void O000000o(AllCameraOptionsPopupWindow allCameraOptionsPopupWindow) {
        ixe.O00000o(allCameraOptionsPopupWindow, "this$0");
        allCameraOptionsPopupWindow.O00000Oo();
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
                /* class com.xiaomi.smarthome.newui.$$Lambda$AllCameraOptionsPopupWindow$G0yh8CKZcPw2H3YPJi_v9cWujTE */

                public final void run() {
                    AllCameraOptionsPopupWindow.O00000Oo(AllCameraOptionsPopupWindow.this);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public static final void O00000Oo(AllCameraOptionsPopupWindow allCameraOptionsPopupWindow) {
        ixe.O00000o(allCameraOptionsPopupWindow, "this$0");
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

    /* access modifiers changed from: private */
    public static final void O00000Oo(AllCameraOptionsPopupWindow allCameraOptionsPopupWindow, View view) {
        ixe.O00000o(allCameraOptionsPopupWindow, "this$0");
        allCameraOptionsPopupWindow.O00000Oo.getContext().startActivity(new Intent(allCameraOptionsPopupWindow.O00000Oo.getContext(), CameraRouterFactory.getCameraManagerApi().getCameraSortActivityClass()));
        PopupWindow popupWindow = allCameraOptionsPopupWindow.O0000OOo;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        hxi.O00000o.f952O000000o.O000000o("all_camera_setorder_click", new Object[0]);
    }

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\u0016J\u0012\u0010\u0007\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, d2 = {"com/xiaomi/smarthome/newui/AllCameraOptionsPopupWindow$initView$2$1", "Lcom/xiaomi/smarthome/frame/AsyncCallback;", "Ljava/lang/Void;", "Lcom/xiaomi/smarthome/frame/Error;", "onFailure", "", "error", "onSuccess", "result", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O00000Oo extends fsm<Void, fso> {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ AllCameraOptionsPopupWindow f10078O000000o;

        O00000Oo(AllCameraOptionsPopupWindow allCameraOptionsPopupWindow) {
            this.f10078O000000o = allCameraOptionsPopupWindow;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
         arg types: [java.lang.String, _m_j.fso]
         candidates:
          _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
          _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
          _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
          _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
        public final void onFailure(fso fso) {
            ixe.O00000o(fso, "error");
            gsy.O00000Oo("AllCameraOptionsPopupWindow", ixe.O000000o("setShowViewType onFailure=", (Object) fso));
        }

        public final /* synthetic */ void onSuccess(Object obj) {
            ft.O000000o(this.f10078O000000o.O00000Oo.getContext()).O000000o(new Intent("change_adapter"));
        }
    }

    /* access modifiers changed from: private */
    public static final void O00000o0(AllCameraOptionsPopupWindow allCameraOptionsPopupWindow, View view) {
        ixe.O00000o(allCameraOptionsPopupWindow, "this$0");
        gti O000000o2 = gti.O000000o();
        int i = allCameraOptionsPopupWindow.O00000o0 == 0 ? 1 : 0;
        fsm o00000Oo = new O00000Oo(allCameraOptionsPopupWindow);
        O000000o2.O00000Oo = i;
        SharedPreferences.Editor edit = O000000o2.f18243O000000o.edit();
        edit.putInt("all_camera_show_view_type", O000000o2.O00000Oo);
        edit.commit();
        o00000Oo.onSuccess(null);
        O000000o2.O000000o(new fsm<Void, fso>(o00000Oo) {
            /* class _m_j.gti.AnonymousClass2 */

            /* renamed from: O000000o  reason: collision with root package name */
            final /* synthetic */ fsm f18245O000000o;

            public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
            }

            {
                this.f18245O000000o = r2;
            }

            public final void onFailure(fso fso) {
                this.f18245O000000o.onFailure(fso);
                gti gti = gti.this;
                gti.O00000Oo = (gti.O00000Oo + 1) % 2;
            }
        });
        hxi.O00000o.f952O000000o.O000000o("all_camera_changetype_click", "type", Integer.valueOf(allCameraOptionsPopupWindow.O00000o0 == 0 ? 1 : 2));
        PopupWindow popupWindow = allCameraOptionsPopupWindow.O0000OOo;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }
}

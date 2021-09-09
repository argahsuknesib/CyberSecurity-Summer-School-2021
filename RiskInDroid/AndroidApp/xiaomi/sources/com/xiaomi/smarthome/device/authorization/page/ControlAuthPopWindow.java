package com.xiaomi.smarthome.device.authorization.page;

import _m_j.gpc;
import _m_j.hxi;
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
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.newui.page.IPage;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00182\u00020\u0001:\u0002\u0018\u0019B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0005H\u0002J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0016H\u0014J\b\u0010\u0017\u001a\u00020\u000eH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/xiaomi/smarthome/device/authorization/page/ControlAuthPopWindow;", "Lcom/xiaomi/smarthome/newui/page/IPage;", "activity", "Landroidx/fragment/app/FragmentActivity;", "decor", "Landroid/view/View;", "authMode", "", "selectCallBack", "Lcom/xiaomi/smarthome/device/authorization/page/ControlAuthPopWindow$ControlAuthSelectCallBack;", "(Landroidx/fragment/app/FragmentActivity;Landroid/view/View;Ljava/lang/String;Lcom/xiaomi/smarthome/device/authorization/page/ControlAuthPopWindow$ControlAuthSelectCallBack;)V", "menuPopupWindow", "Landroid/widget/PopupWindow;", "dismiss", "", "initView", "layout", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreateView", "container", "Landroid/view/ViewGroup;", "show", "Companion", "ControlAuthSelectCallBack", "smarthome-setting_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ControlAuthPopWindow extends IPage {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final O000000o f7049O000000o = new O000000o((byte) 0);
    private final View O00000Oo;
    private final String O00000o0;
    private final O00000Oo O0000OOo;
    private PopupWindow O0000Oo0;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/xiaomi/smarthome/device/authorization/page/ControlAuthPopWindow$ControlAuthSelectCallBack;", "", "onAuthModeChange", "", "selectedAuthMode", "", "smarthome-setting_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface O00000Oo {
        void O000000o(String str);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ControlAuthPopWindow(FragmentActivity fragmentActivity, View view, String str, O00000Oo o00000Oo) {
        super(fragmentActivity);
        ixe.O00000o(fragmentActivity, "activity");
        ixe.O00000o(view, "decor");
        ixe.O00000o(str, "authMode");
        ixe.O00000o(o00000Oo, "selectCallBack");
        this.O00000Oo = view;
        this.O00000o0 = str;
        this.O0000OOo = o00000Oo;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/xiaomi/smarthome/device/authorization/page/ControlAuthPopWindow$Companion;", "", "()V", "TAG", "", "smarthome-setting_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
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
        hxi.O00000o.f952O000000o.O000000o("speaker_choose_show", new Object[0]);
        View view = this.O00000oO;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.device.authorization.page.$$Lambda$ControlAuthPopWindow$YFKFXsj6NeWCCCpw8xzxaBB0kKw */

                public final void onClick(View view) {
                    ControlAuthPopWindow.O000000o(ControlAuthPopWindow.this, view);
                }
            });
        }
        View view2 = this.O00000oO;
        ViewPropertyAnimator animate = view2 == null ? null : view2.animate();
        ViewPropertyAnimator duration = (animate == null || (alpha = animate.alpha(0.4f)) == null) ? null : alpha.setDuration(300);
        if (duration != null) {
            duration.setInterpolator(new AccelerateDecelerateInterpolator());
        }
        View inflate = LayoutInflater.from(this.O00000Oo.getContext()).inflate((int) R.layout.control_auth_pop_view, (ViewGroup) null);
        ixe.O00000Oo(inflate, "layout");
        View findViewById = inflate.findViewById(R.id.ll_choose_device);
        ixe.O00000Oo(findViewById, "layout.findViewById(R.id.ll_choose_device)");
        View findViewById2 = inflate.findViewById(R.id.tv_choose_device);
        ixe.O00000Oo(findViewById2, "layout.findViewById(R.id.tv_choose_device)");
        TextView textView = (TextView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.iv_choose_device_checked);
        ixe.O00000Oo(findViewById3, "layout.findViewById(R.id.iv_choose_device_checked)");
        findViewById.setEnabled(true);
        findViewById.setClickable(true);
        View findViewById4 = inflate.findViewById(R.id.ll_choose_home_room);
        ixe.O00000Oo(findViewById4, "layout.findViewById(R.id.ll_choose_home_room)");
        View findViewById5 = inflate.findViewById(R.id.tv_choose_home_room);
        ixe.O00000Oo(findViewById5, "layout.findViewById(R.id.tv_choose_home_room)");
        TextView textView2 = (TextView) findViewById5;
        View findViewById6 = inflate.findViewById(R.id.iv_choose_home_room_checked);
        ixe.O00000Oo(findViewById6, "layout.findViewById(R.id.iv_choose_home_room_checked)");
        findViewById4.setEnabled(true);
        findViewById4.setClickable(true);
        if (TextUtils.equals(this.O00000o0, DeviceAuthFragment.f7054O000000o)) {
            findViewById.setBackgroundColor(this.O00000Oo.getContext().getResources().getColor(R.color.mj_popup_select_bg));
            textView.setTextColor(this.O00000Oo.getContext().getResources().getColor(R.color.mj_popup_select_text_color));
            findViewById3.setVisibility(0);
            findViewById4.setBackgroundResource(R.drawable.item_ripple_no_radius);
            textView2.setTextColor(textView.getContext().getResources().getColor(R.color.mj_color_black));
            findViewById6.setVisibility(8);
        } else if (TextUtils.equals(this.O00000o0, DeviceAuthFragment.O00000Oo)) {
            findViewById.setBackgroundResource(R.drawable.item_ripple_no_radius);
            textView.setTextColor(textView.getContext().getResources().getColor(R.color.mj_color_black));
            findViewById3.setVisibility(8);
            findViewById4.setBackgroundColor(this.O00000Oo.getContext().getResources().getColor(R.color.mj_popup_select_bg));
            textView2.setTextColor(this.O00000Oo.getContext().getResources().getColor(R.color.mj_popup_select_text_color));
            findViewById6.setVisibility(0);
        }
        findViewById.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.device.authorization.page.$$Lambda$ControlAuthPopWindow$V1OjdiorRBdiDBIVvnwvvfNVrk */

            public final void onClick(View view) {
                ControlAuthPopWindow.O00000Oo(ControlAuthPopWindow.this, view);
            }
        });
        findViewById4.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.device.authorization.page.$$Lambda$ControlAuthPopWindow$3_npB4Sfpu7dnTq4SLH8j94lI */

            public final void onClick(View view) {
                ControlAuthPopWindow.O00000o0(ControlAuthPopWindow.this, view);
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
        popupWindow.showAsDropDown(view3, (-gpc.O00000o0(view3.getContext(), 270.0f)) + this.O00000Oo.getWidth(), -this.O00000Oo.getHeight());
        this.O0000Oo0 = popupWindow;
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            /* class com.xiaomi.smarthome.device.authorization.page.$$Lambda$ControlAuthPopWindow$jVDGOJBT_RnBJ1umS8Bv29ORjk */

            public final void onDismiss() {
                ControlAuthPopWindow.O000000o(ControlAuthPopWindow.this);
            }
        });
    }

    /* access modifiers changed from: private */
    public static final void O000000o(ControlAuthPopWindow controlAuthPopWindow, View view) {
        ixe.O00000o(controlAuthPopWindow, "this$0");
        controlAuthPopWindow.O00000Oo();
    }

    /* access modifiers changed from: private */
    public static final void O000000o(ControlAuthPopWindow controlAuthPopWindow) {
        ixe.O00000o(controlAuthPopWindow, "this$0");
        controlAuthPopWindow.O00000Oo();
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
                /* class com.xiaomi.smarthome.device.authorization.page.$$Lambda$ControlAuthPopWindow$MlW4AcugBzTLhxChbyai6eJEHUE */

                public final void run() {
                    ControlAuthPopWindow.O00000Oo(ControlAuthPopWindow.this);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public static final void O00000Oo(ControlAuthPopWindow controlAuthPopWindow) {
        ixe.O00000o(controlAuthPopWindow, "this$0");
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
    public static final void O00000Oo(ControlAuthPopWindow controlAuthPopWindow, View view) {
        ixe.O00000o(controlAuthPopWindow, "this$0");
        O00000Oo o00000Oo = controlAuthPopWindow.O0000OOo;
        if (o00000Oo != null) {
            String str = DeviceAuthFragment.f7054O000000o;
            ixe.O00000Oo(str, "AUTH_MODE_DEVICE");
            o00000Oo.O000000o(str);
        }
        hxi.O00000o.O0000o00(1);
        controlAuthPopWindow.O00000Oo();
    }

    /* access modifiers changed from: private */
    public static final void O00000o0(ControlAuthPopWindow controlAuthPopWindow, View view) {
        ixe.O00000o(controlAuthPopWindow, "this$0");
        O00000Oo o00000Oo = controlAuthPopWindow.O0000OOo;
        if (o00000Oo != null) {
            String str = DeviceAuthFragment.O00000Oo;
            ixe.O00000Oo(str, "AUTH_MODE_HOME_ROOM");
            o00000Oo.O000000o(str);
        }
        hxi.O00000o.O0000o00(2);
        controlAuthPopWindow.O00000Oo();
    }
}

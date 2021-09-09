package com.xiaomi.smarthome.newui.page;

import _m_j.gpc;
import _m_j.gwg;
import _m_j.ixe;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import androidx.fragment.app.FragmentActivity;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.newui.widget.DeviceMainPageEditBarV2;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001 B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0010H\u0002J\b\u0010\u0014\u001a\u00020\u0012H\u0016J\u0006\u0010\u0015\u001a\u00020\u0012J\u0006\u0010\u0016\u001a\u00020\u0010J\u0006\u0010\u0017\u001a\u00020\u0010J\b\u0010\u0018\u001a\u00020\fH\u0014J\u0010\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001eH\u0014J\b\u0010\u001f\u001a\u00020\u0012H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/xiaomi/smarthome/newui/page/DeviceEditPage;", "Lcom/xiaomi/smarthome/newui/page/IPage;", "activity", "Landroidx/fragment/app/FragmentActivity;", "callback", "Lcom/xiaomi/smarthome/newui/page/DeviceEditPage$IExitCallBack;", "(Landroidx/fragment/app/FragmentActivity;Lcom/xiaomi/smarthome/newui/page/DeviceEditPage$IExitCallBack;)V", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", "getCallback", "()Lcom/xiaomi/smarthome/newui/page/DeviceEditPage$IExitCallBack;", "isEditMode", "", "menuBar", "Lcom/xiaomi/smarthome/newui/widget/DeviceMainPageEditBarV2;", "titleBar", "Landroid/view/View;", "afterInflate", "", "root", "dismiss", "enterEditMode", "getChooseDeviceMenuBar2", "getChooseDeviceTitleBar", "interceptTouchEvent", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreateView", "container", "Landroid/view/ViewGroup;", "show", "IExitCallBack", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DeviceEditPage extends IPage {

    /* renamed from: O000000o  reason: collision with root package name */
    public boolean f10267O000000o;
    public View O00000Oo;
    public DeviceMainPageEditBarV2 O00000o0;
    private final FragmentActivity O0000OOo;
    private final O000000o O0000Oo0;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/xiaomi/smarthome/newui/page/DeviceEditPage$IExitCallBack;", "", "onExit", "", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface O000000o {
        void onExit();
    }

    /* access modifiers changed from: protected */
    public final boolean O00000o() {
        return false;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceEditPage(FragmentActivity fragmentActivity, O000000o o000000o) {
        super(fragmentActivity);
        ixe.O00000o(fragmentActivity, "activity");
        ixe.O00000o(o000000o, "callback");
        this.O0000OOo = fragmentActivity;
        this.O0000Oo0 = o000000o;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    /* access modifiers changed from: protected */
    public final View O000000o(ViewGroup viewGroup) {
        ixe.O00000o(viewGroup, "container");
        View inflate = LayoutInflater.from(this.O0000OOo).inflate((int) R.layout.device_edit_action_bar_main_page_delegate, viewGroup, false);
        ixe.O00000Oo(inflate, "root");
        View findViewById = inflate.findViewById(R.id.title_bar_choose_device);
        ixe.O00000Oo(findViewById, "root.findViewById(R.id.title_bar_choose_device)");
        this.O00000Oo = findViewById;
        View findViewById2 = inflate.findViewById(R.id.menu_bar_choose_device);
        ixe.O00000Oo(findViewById2, "root.findViewById(R.id.menu_bar_choose_device)");
        this.O00000o0 = (DeviceMainPageEditBarV2) findViewById2;
        return inflate;
    }

    public final View O00000oO() {
        DeviceMainPageEditBarV2 deviceMainPageEditBarV2 = this.O00000o0;
        if (deviceMainPageEditBarV2 != null) {
            return deviceMainPageEditBarV2;
        }
        ixe.O000000o("menuBar");
        throw null;
    }

    public final void e_() {
        gwg.O00000Oo(this.O0000OOo.getWindow());
        super.e_();
    }

    public final void O00000Oo() {
        if (this.f10267O000000o) {
            View view = this.O00000Oo;
            if (view != null) {
                view.sendAccessibilityEvent(65536);
                this.f10267O000000o = false;
                this.O0000Oo0.onExit();
                View view2 = this.O00000Oo;
                if (view2 != null) {
                    ViewPropertyAnimator animate = view2.animate();
                    View view3 = this.O00000Oo;
                    if (view3 != null) {
                        animate.translationY(-((float) gpc.O00000o0(view3.getContext(), 86.0f)));
                        DeviceMainPageEditBarV2 deviceMainPageEditBarV2 = this.O00000o0;
                        if (deviceMainPageEditBarV2 != null) {
                            ViewPropertyAnimator animate2 = deviceMainPageEditBarV2.animate();
                            DeviceMainPageEditBarV2 deviceMainPageEditBarV22 = this.O00000o0;
                            if (deviceMainPageEditBarV22 != null) {
                                animate2.translationY((float) gpc.O00000o0(deviceMainPageEditBarV22.getContext(), 90.0f)).withEndAction(new Runnable() {
                                    /* class com.xiaomi.smarthome.newui.page.$$Lambda$DeviceEditPage$zqTGicgp5Rh4BhBjEafmU1hGQS0 */

                                    public final void run() {
                                        DeviceEditPage.O000000o(DeviceEditPage.this);
                                    }
                                });
                            } else {
                                ixe.O000000o("menuBar");
                                throw null;
                            }
                        } else {
                            ixe.O000000o("menuBar");
                            throw null;
                        }
                    } else {
                        ixe.O000000o("titleBar");
                        throw null;
                    }
                } else {
                    ixe.O000000o("titleBar");
                    throw null;
                }
            } else {
                ixe.O000000o("titleBar");
                throw null;
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void O000000o(DeviceEditPage deviceEditPage) {
        ixe.O00000o(deviceEditPage, "this$0");
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
}

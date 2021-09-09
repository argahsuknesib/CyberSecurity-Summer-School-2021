package com.xiaomi.smarthome.miio.page;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;

public class SharePolymerizationActivity_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private SharePolymerizationActivity f9872O000000o;
    private View O00000Oo;
    private View O00000o;
    private View O00000o0;
    private View O00000oO;

    public SharePolymerizationActivity_ViewBinding(final SharePolymerizationActivity sharePolymerizationActivity, View view) {
        this.f9872O000000o = sharePolymerizationActivity;
        View findRequiredView = Utils.findRequiredView(view, R.id.module_a_3_return_btn, "field 'moduleA3ReturnBtn' and method 'onViewClicked'");
        sharePolymerizationActivity.moduleA3ReturnBtn = (ImageView) Utils.castView(findRequiredView, R.id.module_a_3_return_btn, "field 'moduleA3ReturnBtn'", ImageView.class);
        this.O00000Oo = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.miio.page.SharePolymerizationActivity_ViewBinding.AnonymousClass1 */

            public final void doClick(View view) {
                sharePolymerizationActivity.onViewClicked(view);
            }
        });
        sharePolymerizationActivity.moduleA3ReturnTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.module_a_3_return_title, "field 'moduleA3ReturnTitle'", TextView.class);
        sharePolymerizationActivity.moduleA3RightIvSettingBtn = (ImageView) Utils.findRequiredViewAsType(view, R.id.module_a_3_right_iv_setting_btn, "field 'moduleA3RightIvSettingBtn'", ImageView.class);
        View findRequiredView2 = Utils.findRequiredView(view, R.id.cr_share_home, "field 'crShareHome' and method 'onViewClicked'");
        sharePolymerizationActivity.crShareHome = (FrameLayout) Utils.castView(findRequiredView2, R.id.cr_share_home, "field 'crShareHome'", FrameLayout.class);
        this.O00000o0 = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.miio.page.SharePolymerizationActivity_ViewBinding.AnonymousClass2 */

            public final void doClick(View view) {
                sharePolymerizationActivity.onViewClicked(view);
            }
        });
        View findRequiredView3 = Utils.findRequiredView(view, R.id.cr_share_device, "field 'crShareDevice' and method 'onViewClicked'");
        sharePolymerizationActivity.crShareDevice = (FrameLayout) Utils.castView(findRequiredView3, R.id.cr_share_device, "field 'crShareDevice'", FrameLayout.class);
        this.O00000o = findRequiredView3;
        findRequiredView3.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.miio.page.SharePolymerizationActivity_ViewBinding.AnonymousClass3 */

            public final void doClick(View view) {
                sharePolymerizationActivity.onViewClicked(view);
            }
        });
        sharePolymerizationActivity.rlShareWx = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_share_wx, "field 'rlShareWx'", RelativeLayout.class);
        View findRequiredView4 = Utils.findRequiredView(view, R.id.cr_share_wx, "field 'crShareWx' and method 'onViewClicked'");
        sharePolymerizationActivity.crShareWx = (FrameLayout) Utils.castView(findRequiredView4, R.id.cr_share_wx, "field 'crShareWx'", FrameLayout.class);
        this.O00000oO = findRequiredView4;
        findRequiredView4.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.miio.page.SharePolymerizationActivity_ViewBinding.AnonymousClass4 */

            public final void doClick(View view) {
                sharePolymerizationActivity.onViewClicked(view);
            }
        });
    }

    public void unbind() {
        SharePolymerizationActivity sharePolymerizationActivity = this.f9872O000000o;
        if (sharePolymerizationActivity != null) {
            this.f9872O000000o = null;
            sharePolymerizationActivity.moduleA3ReturnBtn = null;
            sharePolymerizationActivity.moduleA3ReturnTitle = null;
            sharePolymerizationActivity.moduleA3RightIvSettingBtn = null;
            sharePolymerizationActivity.crShareHome = null;
            sharePolymerizationActivity.crShareDevice = null;
            sharePolymerizationActivity.rlShareWx = null;
            sharePolymerizationActivity.crShareWx = null;
            this.O00000Oo.setOnClickListener(null);
            this.O00000Oo = null;
            this.O00000o0.setOnClickListener(null);
            this.O00000o0 = null;
            this.O00000o.setOnClickListener(null);
            this.O00000o = null;
            this.O00000oO.setOnClickListener(null);
            this.O00000oO = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}

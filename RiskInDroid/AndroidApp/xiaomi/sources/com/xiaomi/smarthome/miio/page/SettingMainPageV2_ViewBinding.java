package com.xiaomi.smarthome.miio.page;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.xiaomi.smarthome.R;

public class SettingMainPageV2_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private SettingMainPageV2 f9834O000000o;
    private View O00000Oo;
    private View O00000o;
    private View O00000o0;
    private View O00000oO;
    private View O00000oo;
    private View O0000O0o;
    private View O0000OOo;
    private View O0000Oo;
    private View O0000Oo0;
    private View O0000OoO;
    private View O0000Ooo;
    private View O0000o;
    private View O0000o0;
    private View O0000o00;
    private View O0000o0O;
    private View O0000o0o;
    private View O0000oO;
    private View O0000oO0;
    private View O0000oOO;

    public SettingMainPageV2_ViewBinding(final SettingMainPageV2 settingMainPageV2, View view) {
        this.f9834O000000o = settingMainPageV2;
        settingMainPageV2.mToolbar = Utils.findRequiredView(view, R.id.title_bar, "field 'mToolbar'");
        View findRequiredView = Utils.findRequiredView(view, R.id.cl_usr, "field 'mLoginFrame' and method 'onClickLoginFrame'");
        settingMainPageV2.mLoginFrame = findRequiredView;
        this.O00000Oo = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.miio.page.SettingMainPageV2_ViewBinding.AnonymousClass1 */

            public final void doClick(View view) {
                settingMainPageV2.onClickLoginFrame();
            }
        });
        settingMainPageV2.mTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitle'", TextView.class);
        View findRequiredView2 = Utils.findRequiredView(view, R.id.usr_name, "field 'mNickView' and method 'onClickLoginFrame'");
        settingMainPageV2.mNickView = (TextView) Utils.castView(findRequiredView2, R.id.usr_name, "field 'mNickView'", TextView.class);
        this.O00000o0 = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.miio.page.SettingMainPageV2_ViewBinding.AnonymousClass12 */

            public final void doClick(View view) {
                settingMainPageV2.onClickLoginFrame();
            }
        });
        View findRequiredView3 = Utils.findRequiredView(view, R.id.usr_icon, "field 'mUsrIcon' and method 'onClickLoginFrame'");
        settingMainPageV2.mUsrIcon = (SimpleDraweeView) Utils.castView(findRequiredView3, R.id.usr_icon, "field 'mUsrIcon'", SimpleDraweeView.class);
        this.O00000o = findRequiredView3;
        findRequiredView3.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.miio.page.SettingMainPageV2_ViewBinding.AnonymousClass13 */

            public final void doClick(View view) {
                settingMainPageV2.onClickLoginFrame();
            }
        });
        settingMainPageV2.mDevCountView = (TextView) Utils.findRequiredViewAsType(view, R.id.usr_dev_count, "field 'mDevCountView'", TextView.class);
        settingMainPageV2.mCollapsingToolbar = (CollapsingToolbarLayout) Utils.findRequiredViewAsType(view, R.id.collapsing_toolbar, "field 'mCollapsingToolbar'", CollapsingToolbarLayout.class);
        settingMainPageV2.mAppBarLayout = (AppBarLayout) Utils.findRequiredViewAsType(view, R.id.appBarLayout, "field 'mAppBarLayout'", AppBarLayout.class);
        settingMainPageV2.mViewContainer = (CoordinatorLayout) Utils.findRequiredViewAsType(view, R.id.view_container, "field 'mViewContainer'", CoordinatorLayout.class);
        View findRequiredView4 = Utils.findRequiredView(view, R.id.rl_consumables, "field 'mConsumables' and method 'onClickDispatcher'");
        settingMainPageV2.mConsumables = (RelativeLayout) Utils.castView(findRequiredView4, R.id.rl_consumables, "field 'mConsumables'", RelativeLayout.class);
        this.O00000oO = findRequiredView4;
        findRequiredView4.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.miio.page.SettingMainPageV2_ViewBinding.AnonymousClass14 */

            public final void doClick(View view) {
                settingMainPageV2.onClickDispatcher(view);
            }
        });
        settingMainPageV2.mConsumableRedDot = Utils.findRequiredView(view, R.id.consumables_red_dot, "field 'mConsumableRedDot'");
        View findRequiredView5 = Utils.findRequiredView(view, R.id.rl_voice_assistant, "field 'mVoiceAssistant' and method 'onClickDispatcher'");
        settingMainPageV2.mVoiceAssistant = (RelativeLayout) Utils.castView(findRequiredView5, R.id.rl_voice_assistant, "field 'mVoiceAssistant'", RelativeLayout.class);
        this.O00000oo = findRequiredView5;
        findRequiredView5.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.miio.page.SettingMainPageV2_ViewBinding.AnonymousClass15 */

            public final void doClick(View view) {
                settingMainPageV2.onClickDispatcher(view);
            }
        });
        View findRequiredView6 = Utils.findRequiredView(view, R.id.rl_third_account, "field 'mThirdAccountBtn' and method 'onClickDispatcher'");
        settingMainPageV2.mThirdAccountBtn = (RelativeLayout) Utils.castView(findRequiredView6, R.id.rl_third_account, "field 'mThirdAccountBtn'", RelativeLayout.class);
        this.O0000O0o = findRequiredView6;
        findRequiredView6.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.miio.page.SettingMainPageV2_ViewBinding.AnonymousClass16 */

            public final void doClick(View view) {
                settingMainPageV2.onClickDispatcher(view);
            }
        });
        View findRequiredView7 = Utils.findRequiredView(view, R.id.rl_shop, "field 'mMyShopBtn' and method 'onClickDispatcher'");
        settingMainPageV2.mMyShopBtn = (RelativeLayout) Utils.castView(findRequiredView7, R.id.rl_shop, "field 'mMyShopBtn'", RelativeLayout.class);
        this.O0000OOo = findRequiredView7;
        findRequiredView7.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.miio.page.SettingMainPageV2_ViewBinding.AnonymousClass17 */

            public final void doClick(View view) {
                settingMainPageV2.onClickDispatcher(view);
            }
        });
        View findRequiredView8 = Utils.findRequiredView(view, R.id.rl_laboratory, "field 'mLaboratory' and method 'onClickDispatcher'");
        settingMainPageV2.mLaboratory = (RelativeLayout) Utils.castView(findRequiredView8, R.id.rl_laboratory, "field 'mLaboratory'", RelativeLayout.class);
        this.O0000Oo0 = findRequiredView8;
        findRequiredView8.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.miio.page.SettingMainPageV2_ViewBinding.AnonymousClass18 */

            public final void doClick(View view) {
                settingMainPageV2.onClickDispatcher(view);
            }
        });
        View findRequiredView9 = Utils.findRequiredView(view, R.id.rl_score, "field 'mScore' and method 'onClickDispatcher'");
        settingMainPageV2.mScore = (RelativeLayout) Utils.castView(findRequiredView9, R.id.rl_score, "field 'mScore'", RelativeLayout.class);
        this.O0000Oo = findRequiredView9;
        findRequiredView9.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.miio.page.SettingMainPageV2_ViewBinding.AnonymousClass19 */

            public final void doClick(View view) {
                settingMainPageV2.onClickDispatcher(view);
            }
        });
        View findRequiredView10 = Utils.findRequiredView(view, R.id.rl_family, "field 'mFamily' and method 'onClickDispatcher'");
        settingMainPageV2.mFamily = (RelativeLayout) Utils.castView(findRequiredView10, R.id.rl_family, "field 'mFamily'", RelativeLayout.class);
        this.O0000OoO = findRequiredView10;
        findRequiredView10.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.miio.page.SettingMainPageV2_ViewBinding.AnonymousClass2 */

            public final void doClick(View view) {
                settingMainPageV2.onClickDispatcher(view);
            }
        });
        View findRequiredView11 = Utils.findRequiredView(view, R.id.rl_voice_control, "field 'mVoiceControl' and method 'onClickDispatcher'");
        settingMainPageV2.mVoiceControl = (RelativeLayout) Utils.castView(findRequiredView11, R.id.rl_voice_control, "field 'mVoiceControl'", RelativeLayout.class);
        this.O0000Ooo = findRequiredView11;
        findRequiredView11.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.miio.page.SettingMainPageV2_ViewBinding.AnonymousClass3 */

            public final void doClick(View view) {
                settingMainPageV2.onClickDispatcher(view);
            }
        });
        settingMainPageV2.mLaboratoryRedDot = Utils.findRequiredView(view, R.id.laboratory_red_dot, "field 'mLaboratoryRedDot'");
        settingMainPageV2.mImgFeedbackDot = Utils.findRequiredView(view, R.id.feedback_red_dot, "field 'mImgFeedbackDot'");
        settingMainPageV2.mImgAboutDot = Utils.findRequiredView(view, R.id.about_red_dot, "field 'mImgAboutDot'");
        settingMainPageV2.mVoiceRedDot = Utils.findRequiredView(view, R.id.voice_control_red_dot, "field 'mVoiceRedDot'");
        View findRequiredView12 = Utils.findRequiredView(view, R.id.rl_permission, "field 'mPermissionBtn' and method 'onClickDispatcher'");
        settingMainPageV2.mPermissionBtn = (ViewGroup) Utils.castView(findRequiredView12, R.id.rl_permission, "field 'mPermissionBtn'", ViewGroup.class);
        this.O0000o00 = findRequiredView12;
        findRequiredView12.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.miio.page.SettingMainPageV2_ViewBinding.AnonymousClass4 */

            public final void doClick(View view) {
                settingMainPageV2.onClickDispatcher(view);
            }
        });
        settingMainPageV2.mGroup1 = (ViewGroup) Utils.findRequiredViewAsType(view, R.id.setting_main_page_group_1, "field 'mGroup1'", ViewGroup.class);
        settingMainPageV2.mGroup2 = (ViewGroup) Utils.findRequiredViewAsType(view, R.id.setting_main_page_group_2, "field 'mGroup2'", ViewGroup.class);
        settingMainPageV2.mGroup3 = (ViewGroup) Utils.findRequiredViewAsType(view, R.id.setting_main_page_group_3, "field 'mGroup3'", ViewGroup.class);
        settingMainPageV2.mLfGroup = (ViewGroup) Utils.findRequiredViewAsType(view, R.id.lf_group, "field 'mLfGroup'", ViewGroup.class);
        View findRequiredView13 = Utils.findRequiredView(view, R.id.rl_rn_debug, "field 'layoutRnDebug' and method 'onClickDispatcher'");
        settingMainPageV2.layoutRnDebug = findRequiredView13;
        this.O0000o0 = findRequiredView13;
        findRequiredView13.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.miio.page.SettingMainPageV2_ViewBinding.AnonymousClass5 */

            public final void doClick(View view) {
                settingMainPageV2.onClickDispatcher(view);
            }
        });
        settingMainPageV2.tvRnDebugLeftInfo2 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_rn_debug_left_info_2, "field 'tvRnDebugLeftInfo2'", TextView.class);
        View findRequiredView14 = Utils.findRequiredView(view, R.id.iv_qrcode, "method 'onClickDispatcher'");
        this.O0000o0O = findRequiredView14;
        findRequiredView14.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.miio.page.SettingMainPageV2_ViewBinding.AnonymousClass6 */

            public final void doClick(View view) {
                settingMainPageV2.onClickDispatcher(view);
            }
        });
        View findRequiredView15 = Utils.findRequiredView(view, R.id.rl_share, "method 'onClickDispatcher'");
        this.O0000o0o = findRequiredView15;
        findRequiredView15.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.miio.page.SettingMainPageV2_ViewBinding.AnonymousClass7 */

            public final void doClick(View view) {
                settingMainPageV2.onClickDispatcher(view);
            }
        });
        View findRequiredView16 = Utils.findRequiredView(view, R.id.rl_bluetooth_gateway, "method 'onClickDispatcher'");
        this.O0000o = findRequiredView16;
        findRequiredView16.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.miio.page.SettingMainPageV2_ViewBinding.AnonymousClass8 */

            public final void doClick(View view) {
                settingMainPageV2.onClickDispatcher(view);
            }
        });
        View findRequiredView17 = Utils.findRequiredView(view, R.id.rl_feedback, "method 'onClickDispatcher'");
        this.O0000oO0 = findRequiredView17;
        findRequiredView17.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.miio.page.SettingMainPageV2_ViewBinding.AnonymousClass9 */

            public final void doClick(View view) {
                settingMainPageV2.onClickDispatcher(view);
            }
        });
        View findRequiredView18 = Utils.findRequiredView(view, R.id.rl_about, "method 'onClickDispatcher'");
        this.O0000oO = findRequiredView18;
        findRequiredView18.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.miio.page.SettingMainPageV2_ViewBinding.AnonymousClass10 */

            public final void doClick(View view) {
                settingMainPageV2.onClickDispatcher(view);
            }
        });
        View findRequiredView19 = Utils.findRequiredView(view, R.id.rl_privacy, "method 'onClickDispatcher'");
        this.O0000oOO = findRequiredView19;
        findRequiredView19.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.miio.page.SettingMainPageV2_ViewBinding.AnonymousClass11 */

            public final void doClick(View view) {
                settingMainPageV2.onClickDispatcher(view);
            }
        });
    }

    public void unbind() {
        SettingMainPageV2 settingMainPageV2 = this.f9834O000000o;
        if (settingMainPageV2 != null) {
            this.f9834O000000o = null;
            settingMainPageV2.mToolbar = null;
            settingMainPageV2.mLoginFrame = null;
            settingMainPageV2.mTitle = null;
            settingMainPageV2.mNickView = null;
            settingMainPageV2.mUsrIcon = null;
            settingMainPageV2.mDevCountView = null;
            settingMainPageV2.mCollapsingToolbar = null;
            settingMainPageV2.mAppBarLayout = null;
            settingMainPageV2.mViewContainer = null;
            settingMainPageV2.mConsumables = null;
            settingMainPageV2.mConsumableRedDot = null;
            settingMainPageV2.mVoiceAssistant = null;
            settingMainPageV2.mThirdAccountBtn = null;
            settingMainPageV2.mMyShopBtn = null;
            settingMainPageV2.mLaboratory = null;
            settingMainPageV2.mScore = null;
            settingMainPageV2.mFamily = null;
            settingMainPageV2.mVoiceControl = null;
            settingMainPageV2.mLaboratoryRedDot = null;
            settingMainPageV2.mImgFeedbackDot = null;
            settingMainPageV2.mImgAboutDot = null;
            settingMainPageV2.mVoiceRedDot = null;
            settingMainPageV2.mPermissionBtn = null;
            settingMainPageV2.mGroup1 = null;
            settingMainPageV2.mGroup2 = null;
            settingMainPageV2.mGroup3 = null;
            settingMainPageV2.mLfGroup = null;
            settingMainPageV2.layoutRnDebug = null;
            settingMainPageV2.tvRnDebugLeftInfo2 = null;
            this.O00000Oo.setOnClickListener(null);
            this.O00000Oo = null;
            this.O00000o0.setOnClickListener(null);
            this.O00000o0 = null;
            this.O00000o.setOnClickListener(null);
            this.O00000o = null;
            this.O00000oO.setOnClickListener(null);
            this.O00000oO = null;
            this.O00000oo.setOnClickListener(null);
            this.O00000oo = null;
            this.O0000O0o.setOnClickListener(null);
            this.O0000O0o = null;
            this.O0000OOo.setOnClickListener(null);
            this.O0000OOo = null;
            this.O0000Oo0.setOnClickListener(null);
            this.O0000Oo0 = null;
            this.O0000Oo.setOnClickListener(null);
            this.O0000Oo = null;
            this.O0000OoO.setOnClickListener(null);
            this.O0000OoO = null;
            this.O0000Ooo.setOnClickListener(null);
            this.O0000Ooo = null;
            this.O0000o00.setOnClickListener(null);
            this.O0000o00 = null;
            this.O0000o0.setOnClickListener(null);
            this.O0000o0 = null;
            this.O0000o0O.setOnClickListener(null);
            this.O0000o0O = null;
            this.O0000o0o.setOnClickListener(null);
            this.O0000o0o = null;
            this.O0000o.setOnClickListener(null);
            this.O0000o = null;
            this.O0000oO0.setOnClickListener(null);
            this.O0000oO0 = null;
            this.O0000oO.setOnClickListener(null);
            this.O0000oO = null;
            this.O0000oOO.setOnClickListener(null);
            this.O0000oOO = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}

package com.xiaomi.smarthome.scene.activity;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.common.widget.SwitchButton;

public class SmartHomeSceneCreateEditActivity_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private SmartHomeSceneCreateEditActivity f10956O000000o;
    private View O00000Oo;
    private View O00000o;
    private View O00000o0;
    private View O00000oO;
    private View O00000oo;
    private View O0000O0o;
    private View O0000OOo;

    public SmartHomeSceneCreateEditActivity_ViewBinding(final SmartHomeSceneCreateEditActivity smartHomeSceneCreateEditActivity, View view) {
        this.f10956O000000o = smartHomeSceneCreateEditActivity;
        View findRequiredView = Utils.findRequiredView(view, R.id.module_a_4_return_btn, "field 'mModuleA4ReturnBtn' and method 'back'");
        smartHomeSceneCreateEditActivity.mModuleA4ReturnBtn = (ImageView) Utils.castView(findRequiredView, R.id.module_a_4_return_btn, "field 'mModuleA4ReturnBtn'", ImageView.class);
        this.O00000Oo = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.scene.activity.SmartHomeSceneCreateEditActivity_ViewBinding.AnonymousClass1 */

            public final void doClick(View view) {
                smartHomeSceneCreateEditActivity.back();
            }
        });
        smartHomeSceneCreateEditActivity.mModuleA4ReturnTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.module_a_4_return_title, "field 'mModuleA4ReturnTitle'", TextView.class);
        View findRequiredView2 = Utils.findRequiredView(view, R.id.module_a_4_commit, "field 'mModuleA4Commit' and method 'gotoMorePage'");
        smartHomeSceneCreateEditActivity.mModuleA4Commit = (TextView) Utils.castView(findRequiredView2, R.id.module_a_4_commit, "field 'mModuleA4Commit'", TextView.class);
        this.O00000o0 = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.scene.activity.SmartHomeSceneCreateEditActivity_ViewBinding.AnonymousClass2 */

            public final void doClick(View view) {
                smartHomeSceneCreateEditActivity.gotoMorePage();
            }
        });
        smartHomeSceneCreateEditActivity.mConditionListView = (ListView) Utils.findRequiredViewAsType(view, R.id.condition_listview, "field 'mConditionListView'", ListView.class);
        smartHomeSceneCreateEditActivity.mDivider1 = Utils.findRequiredView(view, R.id.divider_1, "field 'mDivider1'");
        smartHomeSceneCreateEditActivity.mDivider2 = Utils.findRequiredView(view, R.id.divider_2, "field 'mDivider2'");
        smartHomeSceneCreateEditActivity.mDivider3 = Utils.findRequiredView(view, R.id.divider_3, "field 'mDivider3'");
        smartHomeSceneCreateEditActivity.mDivider4 = Utils.findRequiredView(view, R.id.divider_4, "field 'mDivider4'");
        smartHomeSceneCreateEditActivity.mTaskListView = (ListView) Utils.findRequiredViewAsType(view, R.id.task_listview, "field 'mTaskListView'", ListView.class);
        smartHomeSceneCreateEditActivity.mNoConditionTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.no_condition_title, "field 'mNoConditionTitle'", TextView.class);
        smartHomeSceneCreateEditActivity.mNoActionTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.no_action_title, "field 'mNoActionTitle'", TextView.class);
        View findRequiredView3 = Utils.findRequiredView(view, R.id.task_layout, "field 'mTaskLayout' and method 'startTaskBar'");
        smartHomeSceneCreateEditActivity.mTaskLayout = findRequiredView3;
        this.O00000o = findRequiredView3;
        findRequiredView3.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.scene.activity.SmartHomeSceneCreateEditActivity_ViewBinding.AnonymousClass3 */

            public final void doClick(View view) {
                smartHomeSceneCreateEditActivity.startTaskBar();
            }
        });
        smartHomeSceneCreateEditActivity.mScrollVIew = (ScrollView) Utils.findRequiredViewAsType(view, R.id.scroll_view, "field 'mScrollVIew'", ScrollView.class);
        smartHomeSceneCreateEditActivity.mConditionTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.condition_title, "field 'mConditionTitle'", TextView.class);
        smartHomeSceneCreateEditActivity.mExpressView = Utils.findRequiredView(view, R.id.smarthome_express_choose, "field 'mExpressView'");
        smartHomeSceneCreateEditActivity.mExpressAll = (TextView) Utils.findRequiredViewAsType(view, R.id.express_all_condition, "field 'mExpressAll'", TextView.class);
        smartHomeSceneCreateEditActivity.mLockView = Utils.findRequiredView(view, R.id.all_selected_item_lock, "field 'mLockView'");
        smartHomeSceneCreateEditActivity.mExpressAny = (TextView) Utils.findRequiredViewAsType(view, R.id.express_any_condition, "field 'mExpressAny'", TextView.class);
        smartHomeSceneCreateEditActivity.mTitleBar = Utils.findRequiredView(view, R.id.title_bar, "field 'mTitleBar'");
        smartHomeSceneCreateEditActivity.mContainer = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.smarthome_create_container, "field 'mContainer'", LinearLayout.class);
        smartHomeSceneCreateEditActivity.mViewTag = Utils.findRequiredView(view, R.id.view_tag, "field 'mViewTag'");
        smartHomeSceneCreateEditActivity.mCheckBox = (SwitchButton) Utils.findRequiredViewAsType(view, R.id.open_check, "field 'mCheckBox'", SwitchButton.class);
        smartHomeSceneCreateEditActivity.mSwitchContainer = Utils.findRequiredView(view, R.id.open_switch_container, "field 'mSwitchContainer'");
        View findRequiredView4 = Utils.findRequiredView(view, R.id.module_a_4_commit_btn, "field 'mConfirmBtn' and method 'completeScene'");
        smartHomeSceneCreateEditActivity.mConfirmBtn = (Button) Utils.castView(findRequiredView4, R.id.module_a_4_commit_btn, "field 'mConfirmBtn'", Button.class);
        this.O00000oO = findRequiredView4;
        findRequiredView4.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.scene.activity.SmartHomeSceneCreateEditActivity_ViewBinding.AnonymousClass4 */

            public final void doClick(View view) {
                smartHomeSceneCreateEditActivity.completeScene();
            }
        });
        smartHomeSceneCreateEditActivity.mExeTimeRL = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.scene_exe_time_rl, "field 'mExeTimeRL'", RelativeLayout.class);
        smartHomeSceneCreateEditActivity.mExeTimeTV = (TextView) Utils.findRequiredViewAsType(view, R.id.scene_exe_time_tv, "field 'mExeTimeTV'", TextView.class);
        View findRequiredView5 = Utils.findRequiredView(view, R.id.add_condition_icon, "method 'startConditionForCondition'");
        this.O00000oo = findRequiredView5;
        findRequiredView5.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.scene.activity.SmartHomeSceneCreateEditActivity_ViewBinding.AnonymousClass5 */

            public final void doClick(View view) {
                smartHomeSceneCreateEditActivity.startConditionForCondition();
            }
        });
        View findRequiredView6 = Utils.findRequiredView(view, R.id.condition_layout, "method 'startConditionBar'");
        this.O0000O0o = findRequiredView6;
        findRequiredView6.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.scene.activity.SmartHomeSceneCreateEditActivity_ViewBinding.AnonymousClass6 */

            public final void doClick(View view) {
                smartHomeSceneCreateEditActivity.startConditionBar();
            }
        });
        View findRequiredView7 = Utils.findRequiredView(view, R.id.add_action_icon, "method 'startAddActionForTaskBtn'");
        this.O0000OOo = findRequiredView7;
        findRequiredView7.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.scene.activity.SmartHomeSceneCreateEditActivity_ViewBinding.AnonymousClass7 */

            public final void doClick(View view) {
                smartHomeSceneCreateEditActivity.startAddActionForTaskBtn();
            }
        });
    }

    public void unbind() {
        SmartHomeSceneCreateEditActivity smartHomeSceneCreateEditActivity = this.f10956O000000o;
        if (smartHomeSceneCreateEditActivity != null) {
            this.f10956O000000o = null;
            smartHomeSceneCreateEditActivity.mModuleA4ReturnBtn = null;
            smartHomeSceneCreateEditActivity.mModuleA4ReturnTitle = null;
            smartHomeSceneCreateEditActivity.mModuleA4Commit = null;
            smartHomeSceneCreateEditActivity.mConditionListView = null;
            smartHomeSceneCreateEditActivity.mDivider1 = null;
            smartHomeSceneCreateEditActivity.mDivider2 = null;
            smartHomeSceneCreateEditActivity.mDivider3 = null;
            smartHomeSceneCreateEditActivity.mDivider4 = null;
            smartHomeSceneCreateEditActivity.mTaskListView = null;
            smartHomeSceneCreateEditActivity.mNoConditionTitle = null;
            smartHomeSceneCreateEditActivity.mNoActionTitle = null;
            smartHomeSceneCreateEditActivity.mTaskLayout = null;
            smartHomeSceneCreateEditActivity.mScrollVIew = null;
            smartHomeSceneCreateEditActivity.mConditionTitle = null;
            smartHomeSceneCreateEditActivity.mExpressView = null;
            smartHomeSceneCreateEditActivity.mExpressAll = null;
            smartHomeSceneCreateEditActivity.mLockView = null;
            smartHomeSceneCreateEditActivity.mExpressAny = null;
            smartHomeSceneCreateEditActivity.mTitleBar = null;
            smartHomeSceneCreateEditActivity.mContainer = null;
            smartHomeSceneCreateEditActivity.mViewTag = null;
            smartHomeSceneCreateEditActivity.mCheckBox = null;
            smartHomeSceneCreateEditActivity.mSwitchContainer = null;
            smartHomeSceneCreateEditActivity.mConfirmBtn = null;
            smartHomeSceneCreateEditActivity.mExeTimeRL = null;
            smartHomeSceneCreateEditActivity.mExeTimeTV = null;
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
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}

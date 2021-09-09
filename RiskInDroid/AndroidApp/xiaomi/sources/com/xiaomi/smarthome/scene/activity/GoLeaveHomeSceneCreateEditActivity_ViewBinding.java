package com.xiaomi.smarthome.scene.activity;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.common.widget.SwitchButton;

public class GoLeaveHomeSceneCreateEditActivity_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private GoLeaveHomeSceneCreateEditActivity f10733O000000o;
    private View O00000Oo;

    public GoLeaveHomeSceneCreateEditActivity_ViewBinding(final GoLeaveHomeSceneCreateEditActivity goLeaveHomeSceneCreateEditActivity, View view) {
        this.f10733O000000o = goLeaveHomeSceneCreateEditActivity;
        goLeaveHomeSceneCreateEditActivity.mModuleA4ReturnTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.module_a_4_return_title, "field 'mModuleA4ReturnTitle'", TextView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.module_a_4_commit, "field 'mModuleA4Commit' and method 'gotoMorePage'");
        goLeaveHomeSceneCreateEditActivity.mModuleA4Commit = (TextView) Utils.castView(findRequiredView, R.id.module_a_4_commit, "field 'mModuleA4Commit'", TextView.class);
        this.O00000Oo = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.scene.activity.GoLeaveHomeSceneCreateEditActivity_ViewBinding.AnonymousClass1 */

            public final void doClick(View view) {
                goLeaveHomeSceneCreateEditActivity.gotoMorePage();
            }
        });
        goLeaveHomeSceneCreateEditActivity.mConditionTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.condition_title, "field 'mConditionTitle'", TextView.class);
        goLeaveHomeSceneCreateEditActivity.mConditionListView = (ListView) Utils.findRequiredViewAsType(view, R.id.condition_listview, "field 'mConditionListView'", ListView.class);
        goLeaveHomeSceneCreateEditActivity.mActionListView = (ListView) Utils.findRequiredViewAsType(view, R.id.task_listview, "field 'mActionListView'", ListView.class);
        goLeaveHomeSceneCreateEditActivity.mDivider2 = Utils.findRequiredView(view, R.id.divider_2, "field 'mDivider2'");
        goLeaveHomeSceneCreateEditActivity.mDivider4 = Utils.findRequiredView(view, R.id.divider_4, "field 'mDivider4'");
        goLeaveHomeSceneCreateEditActivity.mNoConditionTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.no_condition_title, "field 'mNoConditionTitle'", TextView.class);
        goLeaveHomeSceneCreateEditActivity.mNoActionTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.no_action_title, "field 'mNoActionTitle'", TextView.class);
        goLeaveHomeSceneCreateEditActivity.mConditionLayout = Utils.findRequiredView(view, R.id.condition_layout, "field 'mConditionLayout'");
        goLeaveHomeSceneCreateEditActivity.mTaskLayout = Utils.findRequiredView(view, R.id.task_layout, "field 'mTaskLayout'");
        goLeaveHomeSceneCreateEditActivity.mTitleBar = Utils.findRequiredView(view, R.id.title_bar, "field 'mTitleBar'");
        goLeaveHomeSceneCreateEditActivity.mContainer = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.smarthome_create_container, "field 'mContainer'", LinearLayout.class);
        goLeaveHomeSceneCreateEditActivity.mViewTag = Utils.findRequiredView(view, R.id.view_tag, "field 'mViewTag'");
        goLeaveHomeSceneCreateEditActivity.mCheckBox = (SwitchButton) Utils.findRequiredViewAsType(view, R.id.open_check, "field 'mCheckBox'", SwitchButton.class);
        goLeaveHomeSceneCreateEditActivity.mSwitchContainer = Utils.findRequiredView(view, R.id.open_switch_container, "field 'mSwitchContainer'");
        goLeaveHomeSceneCreateEditActivity.mConfirmBtn = (Button) Utils.findRequiredViewAsType(view, R.id.module_a_4_commit_btn, "field 'mConfirmBtn'", Button.class);
        goLeaveHomeSceneCreateEditActivity.mConditionExpress = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.smarthome_express_choose, "field 'mConditionExpress'", LinearLayout.class);
        goLeaveHomeSceneCreateEditActivity.mAddAction = Utils.findRequiredView(view, R.id.add_action_icon, "field 'mAddAction'");
        goLeaveHomeSceneCreateEditActivity.mAddCondition = Utils.findRequiredView(view, R.id.add_condition_icon, "field 'mAddCondition'");
    }

    public void unbind() {
        GoLeaveHomeSceneCreateEditActivity goLeaveHomeSceneCreateEditActivity = this.f10733O000000o;
        if (goLeaveHomeSceneCreateEditActivity != null) {
            this.f10733O000000o = null;
            goLeaveHomeSceneCreateEditActivity.mModuleA4ReturnTitle = null;
            goLeaveHomeSceneCreateEditActivity.mModuleA4Commit = null;
            goLeaveHomeSceneCreateEditActivity.mConditionTitle = null;
            goLeaveHomeSceneCreateEditActivity.mConditionListView = null;
            goLeaveHomeSceneCreateEditActivity.mActionListView = null;
            goLeaveHomeSceneCreateEditActivity.mDivider2 = null;
            goLeaveHomeSceneCreateEditActivity.mDivider4 = null;
            goLeaveHomeSceneCreateEditActivity.mNoConditionTitle = null;
            goLeaveHomeSceneCreateEditActivity.mNoActionTitle = null;
            goLeaveHomeSceneCreateEditActivity.mConditionLayout = null;
            goLeaveHomeSceneCreateEditActivity.mTaskLayout = null;
            goLeaveHomeSceneCreateEditActivity.mTitleBar = null;
            goLeaveHomeSceneCreateEditActivity.mContainer = null;
            goLeaveHomeSceneCreateEditActivity.mViewTag = null;
            goLeaveHomeSceneCreateEditActivity.mCheckBox = null;
            goLeaveHomeSceneCreateEditActivity.mSwitchContainer = null;
            goLeaveHomeSceneCreateEditActivity.mConfirmBtn = null;
            goLeaveHomeSceneCreateEditActivity.mConditionExpress = null;
            goLeaveHomeSceneCreateEditActivity.mAddAction = null;
            goLeaveHomeSceneCreateEditActivity.mAddCondition = null;
            this.O00000Oo.setOnClickListener(null);
            this.O00000Oo = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}

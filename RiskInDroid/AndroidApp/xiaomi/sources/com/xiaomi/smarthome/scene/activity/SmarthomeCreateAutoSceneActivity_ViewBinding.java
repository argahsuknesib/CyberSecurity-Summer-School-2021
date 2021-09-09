package com.xiaomi.smarthome.scene.activity;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.newui.widget.EditTextViewWithSingleWatcher;
import com.xiaomi.smarthome.scene.view.HomeSceneScrollView;

public class SmarthomeCreateAutoSceneActivity_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private SmarthomeCreateAutoSceneActivity f11034O000000o;
    private View O00000Oo;
    private View O00000o0;

    public SmarthomeCreateAutoSceneActivity_ViewBinding(final SmarthomeCreateAutoSceneActivity smarthomeCreateAutoSceneActivity, View view) {
        this.f11034O000000o = smarthomeCreateAutoSceneActivity;
        smarthomeCreateAutoSceneActivity.mModuleA4ReturnBtn = (ImageView) Utils.findRequiredViewAsType(view, R.id.module_a_4_return_btn, "field 'mModuleA4ReturnBtn'", ImageView.class);
        smarthomeCreateAutoSceneActivity.mModuleA4ReturnTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.module_a_4_return_title, "field 'mModuleA4ReturnTitle'", TextView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.module_a_4_commit, "field 'mModuleA4MoreBtn' and method 'gotoMorePage'");
        smarthomeCreateAutoSceneActivity.mModuleA4MoreBtn = (TextView) Utils.castView(findRequiredView, R.id.module_a_4_commit, "field 'mModuleA4MoreBtn'", TextView.class);
        this.O00000Oo = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.scene.activity.SmarthomeCreateAutoSceneActivity_ViewBinding.AnonymousClass1 */

            public final void doClick(View view) {
                smarthomeCreateAutoSceneActivity.gotoMorePage();
            }
        });
        View findRequiredView2 = Utils.findRequiredView(view, R.id.module_a_4_commit_btn, "field 'mConfirmBtn' and method 'completeScene'");
        smarthomeCreateAutoSceneActivity.mConfirmBtn = (ImageButton) Utils.castView(findRequiredView2, R.id.module_a_4_commit_btn, "field 'mConfirmBtn'", ImageButton.class);
        this.O00000o0 = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.scene.activity.SmarthomeCreateAutoSceneActivity_ViewBinding.AnonymousClass2 */

            public final void doClick(View view) {
                smarthomeCreateAutoSceneActivity.completeScene();
            }
        });
        smarthomeCreateAutoSceneActivity.mExeTimeRL = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.scene_exe_time_rl, "field 'mExeTimeRL'", RelativeLayout.class);
        smarthomeCreateAutoSceneActivity.mExeTimeTV = (TextView) Utils.findRequiredViewAsType(view, R.id.scene_exe_time_tv, "field 'mExeTimeTV'", TextView.class);
        smarthomeCreateAutoSceneActivity.mExeTimeHint = (TextView) Utils.findRequiredViewAsType(view, R.id.exe_time_tv_hint, "field 'mExeTimeHint'", TextView.class);
        smarthomeCreateAutoSceneActivity.mEditCancaelBtn = (Button) Utils.findRequiredViewAsType(view, R.id.edit_cancel_btn, "field 'mEditCancaelBtn'", Button.class);
        smarthomeCreateAutoSceneActivity.mEditCompleteBtn = (Button) Utils.findRequiredViewAsType(view, R.id.edit_complete_btn, "field 'mEditCompleteBtn'", Button.class);
        smarthomeCreateAutoSceneActivity.mConditionRV = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.auto_scene_condition_rv, "field 'mConditionRV'", RecyclerView.class);
        smarthomeCreateAutoSceneActivity.mAddContionTV = (TextView) Utils.findRequiredViewAsType(view, R.id.add_scene_condition_add_again_tv, "field 'mAddContionTV'", TextView.class);
        smarthomeCreateAutoSceneActivity.mActionRV = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.auto_scene_action_rv, "field 'mActionRV'", RecyclerView.class);
        smarthomeCreateAutoSceneActivity.mAddActionTV = (TextView) Utils.findRequiredViewAsType(view, R.id.add_scene_action_add_again_tv, "field 'mAddActionTV'", TextView.class);
        smarthomeCreateAutoSceneActivity.mLayoutSceneName = Utils.findRequiredView(view, R.id.scene_name_layout, "field 'mLayoutSceneName'");
        smarthomeCreateAutoSceneActivity.mTextSceneName = (EditTextViewWithSingleWatcher) Utils.findRequiredViewAsType(view, R.id.name_content, "field 'mTextSceneName'", EditTextViewWithSingleWatcher.class);
        smarthomeCreateAutoSceneActivity.mTextSceneNameErrorMsg = (TextView) Utils.findRequiredViewAsType(view, R.id.name_content_error_msg, "field 'mTextSceneNameErrorMsg'", TextView.class);
        smarthomeCreateAutoSceneActivity.mImgClearName = Utils.findRequiredView(view, R.id.clear_name, "field 'mImgClearName'");
        smarthomeCreateAutoSceneActivity.mHandTV = (TextView) Utils.findRequiredViewAsType(view, R.id.hand_tv, "field 'mHandTV'", TextView.class);
        smarthomeCreateAutoSceneActivity.mScrollView = (HomeSceneScrollView) Utils.findRequiredViewAsType(view, R.id.home_scene_scroll_view, "field 'mScrollView'", HomeSceneScrollView.class);
    }

    public void unbind() {
        SmarthomeCreateAutoSceneActivity smarthomeCreateAutoSceneActivity = this.f11034O000000o;
        if (smarthomeCreateAutoSceneActivity != null) {
            this.f11034O000000o = null;
            smarthomeCreateAutoSceneActivity.mModuleA4ReturnBtn = null;
            smarthomeCreateAutoSceneActivity.mModuleA4ReturnTitle = null;
            smarthomeCreateAutoSceneActivity.mModuleA4MoreBtn = null;
            smarthomeCreateAutoSceneActivity.mConfirmBtn = null;
            smarthomeCreateAutoSceneActivity.mExeTimeRL = null;
            smarthomeCreateAutoSceneActivity.mExeTimeTV = null;
            smarthomeCreateAutoSceneActivity.mExeTimeHint = null;
            smarthomeCreateAutoSceneActivity.mEditCancaelBtn = null;
            smarthomeCreateAutoSceneActivity.mEditCompleteBtn = null;
            smarthomeCreateAutoSceneActivity.mConditionRV = null;
            smarthomeCreateAutoSceneActivity.mAddContionTV = null;
            smarthomeCreateAutoSceneActivity.mActionRV = null;
            smarthomeCreateAutoSceneActivity.mAddActionTV = null;
            smarthomeCreateAutoSceneActivity.mLayoutSceneName = null;
            smarthomeCreateAutoSceneActivity.mTextSceneName = null;
            smarthomeCreateAutoSceneActivity.mTextSceneNameErrorMsg = null;
            smarthomeCreateAutoSceneActivity.mImgClearName = null;
            smarthomeCreateAutoSceneActivity.mHandTV = null;
            smarthomeCreateAutoSceneActivity.mScrollView = null;
            this.O00000Oo.setOnClickListener(null);
            this.O00000Oo = null;
            this.O00000o0.setOnClickListener(null);
            this.O00000o0 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}

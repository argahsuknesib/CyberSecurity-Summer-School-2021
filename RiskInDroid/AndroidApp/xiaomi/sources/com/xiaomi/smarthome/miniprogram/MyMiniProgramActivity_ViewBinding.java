package com.xiaomi.smarthome.miniprogram;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.common.widget.CustomPullDownRefreshLinearLayout;
import com.xiaomi.smarthome.library.common.widget.PullDownDragListView;

public class MyMiniProgramActivity_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private MyMiniProgramActivity f9986O000000o;

    public MyMiniProgramActivity_ViewBinding(MyMiniProgramActivity myMiniProgramActivity, View view) {
        this.f9986O000000o = myMiniProgramActivity;
        myMiniProgramActivity.mBackView = Utils.findRequiredView(view, R.id.module_a_3_return_btn, "field 'mBackView'");
        myMiniProgramActivity.mTopManageBar = Utils.findRequiredView(view, R.id.top_delete_bar, "field 'mTopManageBar'");
        myMiniProgramActivity.mBottomDeleteBar = Utils.findRequiredView(view, R.id.bottom_delete_bar, "field 'mBottomDeleteBar'");
        myMiniProgramActivity.mBottomDeleteBtn = Utils.findRequiredView(view, R.id.delete_msg_btn, "field 'mBottomDeleteBtn'");
        myMiniProgramActivity.mManageBtn = (ImageView) Utils.findRequiredViewAsType(view, R.id.module_a_3_right_iv_setting_btn, "field 'mManageBtn'", ImageView.class);
        myMiniProgramActivity.mCancelBtn = Utils.findRequiredView(view, R.id.cancel_btn, "field 'mCancelBtn'");
        myMiniProgramActivity.mIvSelectAll = (ImageView) Utils.findRequiredViewAsType(view, R.id.select_all_btn, "field 'mIvSelectAll'", ImageView.class);
        myMiniProgramActivity.mSelectCountText = (TextView) Utils.findRequiredViewAsType(view, R.id.selected_cnt, "field 'mSelectCountText'", TextView.class);
        myMiniProgramActivity.mListView = (PullDownDragListView) Utils.findRequiredViewAsType(view, R.id.list, "field 'mListView'", PullDownDragListView.class);
        myMiniProgramActivity.mEmptyView = (CustomPullDownRefreshLinearLayout) Utils.findRequiredViewAsType(view, R.id.common_white_empty_view, "field 'mEmptyView'", CustomPullDownRefreshLinearLayout.class);
        myMiniProgramActivity.mErrorTipTxt = (TextView) Utils.findRequiredViewAsType(view, R.id.common_white_empty_text, "field 'mErrorTipTxt'", TextView.class);
        myMiniProgramActivity.mTipsTxt = (TextView) Utils.findRequiredViewAsType(view, R.id.tips, "field 'mTipsTxt'", TextView.class);
    }

    public void unbind() {
        MyMiniProgramActivity myMiniProgramActivity = this.f9986O000000o;
        if (myMiniProgramActivity != null) {
            this.f9986O000000o = null;
            myMiniProgramActivity.mBackView = null;
            myMiniProgramActivity.mTopManageBar = null;
            myMiniProgramActivity.mBottomDeleteBar = null;
            myMiniProgramActivity.mBottomDeleteBtn = null;
            myMiniProgramActivity.mManageBtn = null;
            myMiniProgramActivity.mCancelBtn = null;
            myMiniProgramActivity.mIvSelectAll = null;
            myMiniProgramActivity.mSelectCountText = null;
            myMiniProgramActivity.mListView = null;
            myMiniProgramActivity.mEmptyView = null;
            myMiniProgramActivity.mErrorTipTxt = null;
            myMiniProgramActivity.mTipsTxt = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}

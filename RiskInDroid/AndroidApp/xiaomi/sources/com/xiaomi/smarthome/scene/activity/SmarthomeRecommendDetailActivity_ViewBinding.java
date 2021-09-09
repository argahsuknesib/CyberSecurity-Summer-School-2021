package com.xiaomi.smarthome.scene.activity;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.scene.view.ExpandableListViewWithScrollView;
import com.xiaomi.smarthome.scene.view.HomeSceneScrollView;

public class SmarthomeRecommendDetailActivity_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private SmarthomeRecommendDetailActivity f11080O000000o;

    public SmarthomeRecommendDetailActivity_ViewBinding(SmarthomeRecommendDetailActivity smarthomeRecommendDetailActivity, View view) {
        this.f11080O000000o = smarthomeRecommendDetailActivity;
        smarthomeRecommendDetailActivity.mTitleBar = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.title_bar, "field 'mTitleBar'", FrameLayout.class);
        smarthomeRecommendDetailActivity.mReturnIV = (ImageView) Utils.findRequiredViewAsType(view, R.id.module_a_3_return_btn, "field 'mReturnIV'", ImageView.class);
        smarthomeRecommendDetailActivity.mTitleTV = (TextView) Utils.findRequiredViewAsType(view, R.id.module_a_3_return_title, "field 'mTitleTV'", TextView.class);
        smarthomeRecommendDetailActivity.mVideoView = (VideoView) Utils.findRequiredViewAsType(view, R.id.recommend_detail_video_view, "field 'mVideoView'", VideoView.class);
        smarthomeRecommendDetailActivity.mPlaceHolder = (SimpleDraweeView) Utils.findRequiredViewAsType(view, R.id.recommend_detail_place_hold, "field 'mPlaceHolder'", SimpleDraweeView.class);
        smarthomeRecommendDetailActivity.mActionLV = (ExpandableListViewWithScrollView) Utils.findRequiredViewAsType(view, R.id.auto_scene_action_expand_list_view, "field 'mActionLV'", ExpandableListViewWithScrollView.class);
        smarthomeRecommendDetailActivity.mContionLV = (ExpandableListViewWithScrollView) Utils.findRequiredViewAsType(view, R.id.auto_scene_condition_expand_list_view, "field 'mContionLV'", ExpandableListViewWithScrollView.class);
        smarthomeRecommendDetailActivity.mStartBtn = (TextView) Utils.findRequiredViewAsType(view, R.id.recommend_start_btn, "field 'mStartBtn'", TextView.class);
        smarthomeRecommendDetailActivity.mTitleBarItem = (TextView) Utils.findRequiredViewAsType(view, R.id.title_bar_item, "field 'mTitleBarItem'", TextView.class);
        smarthomeRecommendDetailActivity.mRecommendDetailRL = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.recommend_detail_rl, "field 'mRecommendDetailRL'", RelativeLayout.class);
        smarthomeRecommendDetailActivity.mScrollView = (HomeSceneScrollView) Utils.findRequiredViewAsType(view, R.id.home_scrollview, "field 'mScrollView'", HomeSceneScrollView.class);
        smarthomeRecommendDetailActivity.mMaskView = Utils.findRequiredView(view, R.id.mask_view, "field 'mMaskView'");
    }

    public void unbind() {
        SmarthomeRecommendDetailActivity smarthomeRecommendDetailActivity = this.f11080O000000o;
        if (smarthomeRecommendDetailActivity != null) {
            this.f11080O000000o = null;
            smarthomeRecommendDetailActivity.mTitleBar = null;
            smarthomeRecommendDetailActivity.mReturnIV = null;
            smarthomeRecommendDetailActivity.mTitleTV = null;
            smarthomeRecommendDetailActivity.mVideoView = null;
            smarthomeRecommendDetailActivity.mPlaceHolder = null;
            smarthomeRecommendDetailActivity.mActionLV = null;
            smarthomeRecommendDetailActivity.mContionLV = null;
            smarthomeRecommendDetailActivity.mStartBtn = null;
            smarthomeRecommendDetailActivity.mTitleBarItem = null;
            smarthomeRecommendDetailActivity.mRecommendDetailRL = null;
            smarthomeRecommendDetailActivity.mScrollView = null;
            smarthomeRecommendDetailActivity.mMaskView = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}

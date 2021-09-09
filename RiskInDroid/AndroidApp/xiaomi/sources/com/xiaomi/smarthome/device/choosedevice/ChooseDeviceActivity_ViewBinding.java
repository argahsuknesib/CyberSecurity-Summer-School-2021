package com.xiaomi.smarthome.device.choosedevice;

import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;

public class ChooseDeviceActivity_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private ChooseDeviceActivity f7240O000000o;

    public ChooseDeviceActivity_ViewBinding(ChooseDeviceActivity chooseDeviceActivity, View view) {
        this.f7240O000000o = chooseDeviceActivity;
        chooseDeviceActivity.mNormalBackImg = (ImageView) Utils.findRequiredViewAsType(view, R.id.normal_back_img, "field 'mNormalBackImg'", ImageView.class);
        chooseDeviceActivity.mAddDeviceHeadTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.add_device_head_title, "field 'mAddDeviceHeadTitle'", TextView.class);
        chooseDeviceActivity.mSearchBtn = (ImageView) Utils.findRequiredViewAsType(view, R.id.mj_search_btn, "field 'mSearchBtn'", ImageView.class);
        chooseDeviceActivity.mCommonHelpImg = (ImageView) Utils.findRequiredViewAsType(view, R.id.common_help_iv, "field 'mCommonHelpImg'", ImageView.class);
        chooseDeviceActivity.mSearchTextTitle = Utils.findRequiredView(view, R.id.mj_add_device_search_title, "field 'mSearchTextTitle'");
        chooseDeviceActivity.mViewPager = Utils.findRequiredView(view, R.id.pager, "field 'mViewPager'");
        chooseDeviceActivity.mSearchContainerView = Utils.findRequiredView(view, R.id.layout_search_container, "field 'mSearchContainerView'");
        chooseDeviceActivity.mSearchConentLayout = Utils.findRequiredView(view, R.id.search_content_layout, "field 'mSearchConentLayout'");
        chooseDeviceActivity.mSearchHistoryTv = Utils.findRequiredView(view, R.id.search_history_tv, "field 'mSearchHistoryTv'");
        chooseDeviceActivity.mHistoryTextFitlineLayout = (ViewGroup) Utils.findRequiredViewAsType(view, R.id.fit_line_layout_history_text, "field 'mHistoryTextFitlineLayout'", ViewGroup.class);
        chooseDeviceActivity.mSearchListView = (ListView) Utils.findRequiredViewAsType(view, R.id.device_grid_list, "field 'mSearchListView'", ListView.class);
        chooseDeviceActivity.mNoSearchResultView = Utils.findRequiredView(view, R.id.no_search_results, "field 'mNoSearchResultView'");
        chooseDeviceActivity.mSearchEt = (EditText) Utils.findRequiredViewAsType(view, R.id.search_et, "field 'mSearchEt'", EditText.class);
        chooseDeviceActivity.mSearchEtClearBtn = Utils.findRequiredView(view, R.id.search_et_clear_btn, "field 'mSearchEtClearBtn'");
        chooseDeviceActivity.mExitSearchBtn = Utils.findRequiredView(view, R.id.exit_search_btn, "field 'mExitSearchBtn'");
        chooseDeviceActivity.mTitleBar = (ViewGroup) Utils.findRequiredViewAsType(view, R.id.title_bar, "field 'mTitleBar'", ViewGroup.class);
        chooseDeviceActivity.mNormalHeader = Utils.findRequiredView(view, R.id.normal_header, "field 'mNormalHeader'");
        chooseDeviceActivity.mMoreHeader = Utils.findRequiredView(view, R.id.more_device_header, "field 'mMoreHeader'");
        chooseDeviceActivity.mMoreBackImg = (ImageView) Utils.findRequiredViewAsType(view, R.id.more_back_img, "field 'mMoreBackImg'", ImageView.class);
    }

    public void unbind() {
        ChooseDeviceActivity chooseDeviceActivity = this.f7240O000000o;
        if (chooseDeviceActivity != null) {
            this.f7240O000000o = null;
            chooseDeviceActivity.mNormalBackImg = null;
            chooseDeviceActivity.mAddDeviceHeadTitle = null;
            chooseDeviceActivity.mSearchBtn = null;
            chooseDeviceActivity.mCommonHelpImg = null;
            chooseDeviceActivity.mSearchTextTitle = null;
            chooseDeviceActivity.mViewPager = null;
            chooseDeviceActivity.mSearchContainerView = null;
            chooseDeviceActivity.mSearchConentLayout = null;
            chooseDeviceActivity.mSearchHistoryTv = null;
            chooseDeviceActivity.mHistoryTextFitlineLayout = null;
            chooseDeviceActivity.mSearchListView = null;
            chooseDeviceActivity.mNoSearchResultView = null;
            chooseDeviceActivity.mSearchEt = null;
            chooseDeviceActivity.mSearchEtClearBtn = null;
            chooseDeviceActivity.mExitSearchBtn = null;
            chooseDeviceActivity.mTitleBar = null;
            chooseDeviceActivity.mNormalHeader = null;
            chooseDeviceActivity.mMoreHeader = null;
            chooseDeviceActivity.mMoreBackImg = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}

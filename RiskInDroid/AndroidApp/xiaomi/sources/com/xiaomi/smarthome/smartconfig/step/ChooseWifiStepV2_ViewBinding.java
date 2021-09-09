package com.xiaomi.smarthome.smartconfig.step;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.common.widget.CustomPullDownRefreshLinearLayout;

public class ChooseWifiStepV2_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private ChooseWifiStepV2 f11729O000000o;

    public ChooseWifiStepV2_ViewBinding(ChooseWifiStepV2 chooseWifiStepV2, View view) {
        this.f11729O000000o = chooseWifiStepV2;
        chooseWifiStepV2.mTitleBar = Utils.findRequiredView(view, R.id.title_bar, "field 'mTitleBar'");
        chooseWifiStepV2.mTitleTv = (TextView) Utils.findRequiredViewAsType(view, R.id.module_a_3_return_title, "field 'mTitleTv'", TextView.class);
        chooseWifiStepV2.mReturnBt = Utils.findRequiredView(view, R.id.module_a_3_return_btn, "field 'mReturnBt'");
        chooseWifiStepV2.mSavedListView = (ListView) Utils.findRequiredViewAsType(view, R.id.saved_wifi_list, "field 'mSavedListView'", ListView.class);
        chooseWifiStepV2.mOtherListView = (ListView) Utils.findRequiredViewAsType(view, R.id.other_wifi_list, "field 'mOtherListView'", ListView.class);
        chooseWifiStepV2.mSaveWifiViewRoot = Utils.findRequiredView(view, R.id.saved_wifi_root, "field 'mSaveWifiViewRoot'");
        chooseWifiStepV2.mEditWifiViewRoot = Utils.findRequiredView(view, R.id.edit_wifi_root, "field 'mEditWifiViewRoot'");
        chooseWifiStepV2.mCheckBox = (CheckBox) Utils.findRequiredViewAsType(view, R.id.check_box_confirm, "field 'mCheckBox'", CheckBox.class);
        chooseWifiStepV2.mNextButton = (Button) Utils.findRequiredViewAsType(view, R.id.next_btn, "field 'mNextButton'", Button.class);
        chooseWifiStepV2.mChangePasswordView = Utils.findRequiredView(view, R.id.change_password, "field 'mChangePasswordView'");
        chooseWifiStepV2.mDeleteWifiView = Utils.findRequiredView(view, R.id.delete_wifi, "field 'mDeleteWifiView'");
        chooseWifiStepV2.mLicenseTv = (TextView) Utils.findRequiredViewAsType(view, R.id.agree_license, "field 'mLicenseTv'", TextView.class);
        chooseWifiStepV2.mScanResultListRoot = (CustomPullDownRefreshLinearLayout) Utils.findRequiredViewAsType(view, R.id.wifi_refresh_container, "field 'mScanResultListRoot'", CustomPullDownRefreshLinearLayout.class);
        chooseWifiStepV2.mScrollWifiList = (ScrollView) Utils.findRequiredViewAsType(view, R.id.wifi_list_scroll_view, "field 'mScrollWifiList'", ScrollView.class);
        chooseWifiStepV2.mSubTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.module_a_3_return_subtitle, "field 'mSubTitle'", TextView.class);
        chooseWifiStepV2.mCannotFindTips = (TextView) Utils.findRequiredViewAsType(view, R.id.can_not_find_wifi, "field 'mCannotFindTips'", TextView.class);
        chooseWifiStepV2.mEmptyView = Utils.findRequiredView(view, R.id.empty_mask, "field 'mEmptyView'");
        chooseWifiStepV2.llCurrentWifi = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_current_wifi, "field 'llCurrentWifi'", LinearLayout.class);
        chooseWifiStepV2.rlCurrentWifiItem = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.tv_current_wifi_item, "field 'rlCurrentWifiItem'", RelativeLayout.class);
        chooseWifiStepV2.ivCurrentWifiPointer = (ImageView) Utils.findRequiredViewAsType(view, R.id.tv_current_wifi_pointer, "field 'ivCurrentWifiPointer'", ImageView.class);
        chooseWifiStepV2.tvCurrentWifiName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_current_wifi_name, "field 'tvCurrentWifiName'", TextView.class);
        chooseWifiStepV2.ivCurrentWifiSignl = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_img_wifi_signal, "field 'ivCurrentWifiSignl'", ImageView.class);
        chooseWifiStepV2.mTxtChoose5GWifiTips = (TextView) Utils.findRequiredViewAsType(view, R.id.txt_choose_5g_tips, "field 'mTxtChoose5GWifiTips'", TextView.class);
    }

    public void unbind() {
        ChooseWifiStepV2 chooseWifiStepV2 = this.f11729O000000o;
        if (chooseWifiStepV2 != null) {
            this.f11729O000000o = null;
            chooseWifiStepV2.mTitleBar = null;
            chooseWifiStepV2.mTitleTv = null;
            chooseWifiStepV2.mReturnBt = null;
            chooseWifiStepV2.mSavedListView = null;
            chooseWifiStepV2.mOtherListView = null;
            chooseWifiStepV2.mSaveWifiViewRoot = null;
            chooseWifiStepV2.mEditWifiViewRoot = null;
            chooseWifiStepV2.mCheckBox = null;
            chooseWifiStepV2.mNextButton = null;
            chooseWifiStepV2.mChangePasswordView = null;
            chooseWifiStepV2.mDeleteWifiView = null;
            chooseWifiStepV2.mLicenseTv = null;
            chooseWifiStepV2.mScanResultListRoot = null;
            chooseWifiStepV2.mScrollWifiList = null;
            chooseWifiStepV2.mSubTitle = null;
            chooseWifiStepV2.mCannotFindTips = null;
            chooseWifiStepV2.mEmptyView = null;
            chooseWifiStepV2.llCurrentWifi = null;
            chooseWifiStepV2.rlCurrentWifiItem = null;
            chooseWifiStepV2.ivCurrentWifiPointer = null;
            chooseWifiStepV2.tvCurrentWifiName = null;
            chooseWifiStepV2.ivCurrentWifiSignl = null;
            chooseWifiStepV2.mTxtChoose5GWifiTips = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}

package com.xiaomi.smarthome.miio.activity;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.common.widget.DevicePtrFrameLayout;

public class ConsumablesActivity_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private ConsumablesActivity f9658O000000o;

    public ConsumablesActivity_ViewBinding(ConsumablesActivity consumablesActivity, View view) {
        this.f9658O000000o = consumablesActivity;
        consumablesActivity.mPullRefreshLL = (DevicePtrFrameLayout) Utils.findRequiredViewAsType(view, R.id.pull_down_refresh, "field 'mPullRefreshLL'", DevicePtrFrameLayout.class);
        consumablesActivity.list = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.consumables_list, "field 'list'", RecyclerView.class);
        consumablesActivity.mEmptyView = Utils.findRequiredView(view, R.id.common_white_empty_view, "field 'mEmptyView'");
        consumablesActivity.mTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.module_a_3_return_title, "field 'mTitle'", TextView.class);
        consumablesActivity.mGroupTitle = Utils.findRequiredView(view, R.id.title_group, "field 'mGroupTitle'");
        consumablesActivity.mMenuIcom = Utils.findRequiredView(view, R.id.home_change_icon, "field 'mMenuIcom'");
        consumablesActivity.mTitleBar = Utils.findRequiredView(view, R.id.title_bar, "field 'mTitleBar'");
        consumablesActivity.mEmptyTV = (TextView) Utils.findRequiredViewAsType(view, R.id.common_white_empty_text, "field 'mEmptyTV'", TextView.class);
        consumablesActivity.mMaskView = Utils.findRequiredView(view, R.id.mask, "field 'mMaskView'");
        consumablesActivity.mback = Utils.findRequiredView(view, R.id.module_a_3_return_btn, "field 'mback'");
    }

    public void unbind() {
        ConsumablesActivity consumablesActivity = this.f9658O000000o;
        if (consumablesActivity != null) {
            this.f9658O000000o = null;
            consumablesActivity.mPullRefreshLL = null;
            consumablesActivity.list = null;
            consumablesActivity.mEmptyView = null;
            consumablesActivity.mTitle = null;
            consumablesActivity.mGroupTitle = null;
            consumablesActivity.mMenuIcom = null;
            consumablesActivity.mTitleBar = null;
            consumablesActivity.mEmptyTV = null;
            consumablesActivity.mMaskView = null;
            consumablesActivity.mback = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}

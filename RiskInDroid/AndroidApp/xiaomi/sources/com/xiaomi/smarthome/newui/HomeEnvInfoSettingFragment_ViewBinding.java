package com.xiaomi.smarthome.newui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.common.widget.DevicePtrFrameLayout;

public class HomeEnvInfoSettingFragment_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private HomeEnvInfoSettingFragment f10103O000000o;

    public HomeEnvInfoSettingFragment_ViewBinding(HomeEnvInfoSettingFragment homeEnvInfoSettingFragment, View view) {
        this.f10103O000000o = homeEnvInfoSettingFragment;
        homeEnvInfoSettingFragment.mReturnImageView = (ImageView) Utils.findRequiredViewAsType(view, R.id.module_a_3_return_btn, "field 'mReturnImageView'", ImageView.class);
        homeEnvInfoSettingFragment.mRecyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recycler_view, "field 'mRecyclerView'", RecyclerView.class);
        homeEnvInfoSettingFragment.mPullRefresh = (DevicePtrFrameLayout) Utils.findRequiredViewAsType(view, R.id.pull_down_refresh, "field 'mPullRefresh'", DevicePtrFrameLayout.class);
        homeEnvInfoSettingFragment.mTextTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.module_a_3_return_title, "field 'mTextTitle'", TextView.class);
        homeEnvInfoSettingFragment.mEmpty = (TextView) Utils.findRequiredViewAsType(view, R.id.empty, "field 'mEmpty'", TextView.class);
    }

    public void unbind() {
        HomeEnvInfoSettingFragment homeEnvInfoSettingFragment = this.f10103O000000o;
        if (homeEnvInfoSettingFragment != null) {
            this.f10103O000000o = null;
            homeEnvInfoSettingFragment.mReturnImageView = null;
            homeEnvInfoSettingFragment.mRecyclerView = null;
            homeEnvInfoSettingFragment.mPullRefresh = null;
            homeEnvInfoSettingFragment.mTextTitle = null;
            homeEnvInfoSettingFragment.mEmpty = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}

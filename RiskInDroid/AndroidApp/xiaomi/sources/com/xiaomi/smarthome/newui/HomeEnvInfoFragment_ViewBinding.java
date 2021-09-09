package com.xiaomi.smarthome.newui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.common.widget.DevicePtrFrameLayout;

public class HomeEnvInfoFragment_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private HomeEnvInfoFragment f10098O000000o;

    public HomeEnvInfoFragment_ViewBinding(HomeEnvInfoFragment homeEnvInfoFragment, View view) {
        this.f10098O000000o = homeEnvInfoFragment;
        homeEnvInfoFragment.mReturnImageView = (ImageView) Utils.findRequiredViewAsType(view, R.id.module_a_3_return_btn, "field 'mReturnImageView'", ImageView.class);
        homeEnvInfoFragment.mRecyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recycler_view, "field 'mRecyclerView'", RecyclerView.class);
        homeEnvInfoFragment.mPullRefresh = (DevicePtrFrameLayout) Utils.findRequiredViewAsType(view, R.id.pull_down_refresh, "field 'mPullRefresh'", DevicePtrFrameLayout.class);
        homeEnvInfoFragment.mMaskView = Utils.findRequiredView(view, R.id.mask, "field 'mMaskView'");
        homeEnvInfoFragment.mTitleTv = (TextView) Utils.findRequiredViewAsType(view, R.id.module_a_3_return_title, "field 'mTitleTv'", TextView.class);
        homeEnvInfoFragment.mEmpty = (TextView) Utils.findRequiredViewAsType(view, R.id.empty, "field 'mEmpty'", TextView.class);
    }

    public void unbind() {
        HomeEnvInfoFragment homeEnvInfoFragment = this.f10098O000000o;
        if (homeEnvInfoFragment != null) {
            this.f10098O000000o = null;
            homeEnvInfoFragment.mReturnImageView = null;
            homeEnvInfoFragment.mRecyclerView = null;
            homeEnvInfoFragment.mPullRefresh = null;
            homeEnvInfoFragment.mMaskView = null;
            homeEnvInfoFragment.mTitleTv = null;
            homeEnvInfoFragment.mEmpty = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}

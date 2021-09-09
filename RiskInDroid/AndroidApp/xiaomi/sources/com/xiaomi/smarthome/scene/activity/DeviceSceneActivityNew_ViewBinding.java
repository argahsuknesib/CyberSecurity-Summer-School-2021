package com.xiaomi.smarthome.scene.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.scene.widget.SceneTabIndicator;

public class DeviceSceneActivityNew_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private DeviceSceneActivityNew f10666O000000o;

    public DeviceSceneActivityNew_ViewBinding(DeviceSceneActivityNew deviceSceneActivityNew, View view) {
        this.f10666O000000o = deviceSceneActivityNew;
        deviceSceneActivityNew.mViewPager = (ViewPager) Utils.findRequiredViewAsType(view, R.id.view_pager, "field 'mViewPager'", ViewPager.class);
        deviceSceneActivityNew.mIndicator = (SceneTabIndicator) Utils.findRequiredViewAsType(view, R.id.top_indicator, "field 'mIndicator'", SceneTabIndicator.class);
        deviceSceneActivityNew.mTitleTV = (TextView) Utils.findRequiredViewAsType(view, R.id.module_a_3_return_title, "field 'mTitleTV'", TextView.class);
        deviceSceneActivityNew.mReturnIV = (ImageView) Utils.findRequiredViewAsType(view, R.id.module_a_3_return_btn, "field 'mReturnIV'", ImageView.class);
        deviceSceneActivityNew.mRightTitleIV = (ImageView) Utils.findRequiredViewAsType(view, R.id.module_a_3_right_iv_setting_btn, "field 'mRightTitleIV'", ImageView.class);
        deviceSceneActivityNew.mLoadingView = Utils.findRequiredView(view, R.id.mj_loading, "field 'mLoadingView'");
    }

    public void unbind() {
        DeviceSceneActivityNew deviceSceneActivityNew = this.f10666O000000o;
        if (deviceSceneActivityNew != null) {
            this.f10666O000000o = null;
            deviceSceneActivityNew.mViewPager = null;
            deviceSceneActivityNew.mIndicator = null;
            deviceSceneActivityNew.mTitleTV = null;
            deviceSceneActivityNew.mReturnIV = null;
            deviceSceneActivityNew.mRightTitleIV = null;
            deviceSceneActivityNew.mLoadingView = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}

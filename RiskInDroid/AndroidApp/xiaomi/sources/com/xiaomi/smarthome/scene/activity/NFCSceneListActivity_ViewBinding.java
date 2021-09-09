package com.xiaomi.smarthome.scene.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.google.android.material.tabs.TabLayout;
import com.xiaomi.smarthome.R;

public class NFCSceneListActivity_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private NFCSceneListActivity f10789O000000o;

    public NFCSceneListActivity_ViewBinding(NFCSceneListActivity nFCSceneListActivity, View view) {
        this.f10789O000000o = nFCSceneListActivity;
        nFCSceneListActivity.mViewPager = (ViewPager) Utils.findRequiredViewAsType(view, R.id.view_pager, "field 'mViewPager'", ViewPager.class);
        nFCSceneListActivity.mTabLayout = (TabLayout) Utils.findRequiredViewAsType(view, R.id.tab_layout, "field 'mTabLayout'", TabLayout.class);
        nFCSceneListActivity.mTitleTV = (TextView) Utils.findRequiredViewAsType(view, R.id.module_a_3_return_title, "field 'mTitleTV'", TextView.class);
        nFCSceneListActivity.mReturnIV = (ImageView) Utils.findRequiredViewAsType(view, R.id.module_a_3_return_btn, "field 'mReturnIV'", ImageView.class);
        nFCSceneListActivity.mLoadingView = Utils.findRequiredView(view, R.id.mj_loading, "field 'mLoadingView'");
    }

    public void unbind() {
        NFCSceneListActivity nFCSceneListActivity = this.f10789O000000o;
        if (nFCSceneListActivity != null) {
            this.f10789O000000o = null;
            nFCSceneListActivity.mViewPager = null;
            nFCSceneListActivity.mTabLayout = null;
            nFCSceneListActivity.mTitleTV = null;
            nFCSceneListActivity.mReturnIV = null;
            nFCSceneListActivity.mLoadingView = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}

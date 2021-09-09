package com.xiaomi.smarthome.scene;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;
import in.srain.cube.views.ptr.PtrFrameLayout;

public class NFCSceneListFragment_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private NFCSceneListFragment f10605O000000o;

    public NFCSceneListFragment_ViewBinding(NFCSceneListFragment nFCSceneListFragment, View view) {
        this.f10605O000000o = nFCSceneListFragment;
        nFCSceneListFragment.mEmptyTV = (TextView) Utils.findRequiredViewAsType(view, R.id.common_white_empty_text, "field 'mEmptyTV'", TextView.class);
        nFCSceneListFragment.mEmptyView = Utils.findRequiredView(view, R.id.common_white_empty_view, "field 'mEmptyView'");
        nFCSceneListFragment.mTextBuy = Utils.findRequiredView(view, R.id.tv_buy, "field 'mTextBuy'");
        nFCSceneListFragment.buyParent = Utils.findRequiredView(view, R.id.buy_parent, "field 'buyParent'");
        nFCSceneListFragment.mPullRefreshLL = (PtrFrameLayout) Utils.findRequiredViewAsType(view, R.id.pull_down_refresh, "field 'mPullRefreshLL'", PtrFrameLayout.class);
        nFCSceneListFragment.mSceneViewRV = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.scene_rv, "field 'mSceneViewRV'", RecyclerView.class);
        nFCSceneListFragment.mPlaceHolderView = Utils.findRequiredView(view, R.id.place_holder, "field 'mPlaceHolderView'");
    }

    public void unbind() {
        NFCSceneListFragment nFCSceneListFragment = this.f10605O000000o;
        if (nFCSceneListFragment != null) {
            this.f10605O000000o = null;
            nFCSceneListFragment.mEmptyTV = null;
            nFCSceneListFragment.mEmptyView = null;
            nFCSceneListFragment.mTextBuy = null;
            nFCSceneListFragment.buyParent = null;
            nFCSceneListFragment.mPullRefreshLL = null;
            nFCSceneListFragment.mSceneViewRV = null;
            nFCSceneListFragment.mPlaceHolderView = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}

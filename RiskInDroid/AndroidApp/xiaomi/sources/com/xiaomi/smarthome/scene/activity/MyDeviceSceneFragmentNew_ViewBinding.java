package com.xiaomi.smarthome.scene.activity;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;
import in.srain.cube.views.ptr.PtrFrameLayout;

public class MyDeviceSceneFragmentNew_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private MyDeviceSceneFragmentNew f10785O000000o;

    public MyDeviceSceneFragmentNew_ViewBinding(MyDeviceSceneFragmentNew myDeviceSceneFragmentNew, View view) {
        this.f10785O000000o = myDeviceSceneFragmentNew;
        myDeviceSceneFragmentNew.mPullRefreshLL = (PtrFrameLayout) Utils.findRequiredViewAsType(view, R.id.pull_down_refresh, "field 'mPullRefreshLL'", PtrFrameLayout.class);
        myDeviceSceneFragmentNew.mEmptyView = Utils.findRequiredView(view, R.id.common_white_empty_view, "field 'mEmptyView'");
        myDeviceSceneFragmentNew.mSceneViewRV = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.scene_rv, "field 'mSceneViewRV'", RecyclerView.class);
        myDeviceSceneFragmentNew.mEmptyTV = (TextView) Utils.findRequiredViewAsType(view, R.id.common_white_empty_text, "field 'mEmptyTV'", TextView.class);
        myDeviceSceneFragmentNew.mPlaceHolderView = Utils.findRequiredView(view, R.id.place_holder, "field 'mPlaceHolderView'");
    }

    public void unbind() {
        MyDeviceSceneFragmentNew myDeviceSceneFragmentNew = this.f10785O000000o;
        if (myDeviceSceneFragmentNew != null) {
            this.f10785O000000o = null;
            myDeviceSceneFragmentNew.mPullRefreshLL = null;
            myDeviceSceneFragmentNew.mEmptyView = null;
            myDeviceSceneFragmentNew.mSceneViewRV = null;
            myDeviceSceneFragmentNew.mEmptyTV = null;
            myDeviceSceneFragmentNew.mPlaceHolderView = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}

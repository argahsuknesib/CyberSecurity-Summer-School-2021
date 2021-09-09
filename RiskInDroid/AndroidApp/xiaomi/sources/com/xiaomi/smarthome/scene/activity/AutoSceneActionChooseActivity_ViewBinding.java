package com.xiaomi.smarthome.scene.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;
import in.srain.cube.views.ptr.PtrFrameLayout;

public class AutoSceneActionChooseActivity_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private AutoSceneActionChooseActivity f10647O000000o;

    public AutoSceneActionChooseActivity_ViewBinding(AutoSceneActionChooseActivity autoSceneActionChooseActivity, View view) {
        this.f10647O000000o = autoSceneActionChooseActivity;
        autoSceneActionChooseActivity.mTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.module_a_3_return_title, "field 'mTitle'", TextView.class);
        autoSceneActionChooseActivity.mPullRefreshLL = (PtrFrameLayout) Utils.findRequiredViewAsType(view, R.id.pull_down_refresh, "field 'mPullRefreshLL'", PtrFrameLayout.class);
        autoSceneActionChooseActivity.mRecyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.scene_item_view, "field 'mRecyclerView'", RecyclerView.class);
        autoSceneActionChooseActivity.mReturnBtn = (ImageView) Utils.findRequiredViewAsType(view, R.id.module_a_3_return_btn, "field 'mReturnBtn'", ImageView.class);
        autoSceneActionChooseActivity.mNoSceneView = Utils.findRequiredView(view, R.id.no_scene_item_view, "field 'mNoSceneView'");
    }

    public void unbind() {
        AutoSceneActionChooseActivity autoSceneActionChooseActivity = this.f10647O000000o;
        if (autoSceneActionChooseActivity != null) {
            this.f10647O000000o = null;
            autoSceneActionChooseActivity.mTitle = null;
            autoSceneActionChooseActivity.mPullRefreshLL = null;
            autoSceneActionChooseActivity.mRecyclerView = null;
            autoSceneActionChooseActivity.mReturnBtn = null;
            autoSceneActionChooseActivity.mNoSceneView = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}

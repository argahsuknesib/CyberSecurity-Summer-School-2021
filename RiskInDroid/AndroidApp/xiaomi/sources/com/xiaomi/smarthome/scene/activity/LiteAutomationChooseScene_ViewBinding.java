package com.xiaomi.smarthome.scene.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;
import in.srain.cube.views.ptr.PtrFrameLayout;

public class LiteAutomationChooseScene_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private LiteAutomationChooseScene f10741O000000o;

    public LiteAutomationChooseScene_ViewBinding(LiteAutomationChooseScene liteAutomationChooseScene, View view) {
        this.f10741O000000o = liteAutomationChooseScene;
        liteAutomationChooseScene.mPullRefreshLL = (PtrFrameLayout) Utils.findRequiredViewAsType(view, R.id.pull_down_refresh, "field 'mPullRefreshLL'", PtrFrameLayout.class);
        liteAutomationChooseScene.mRecyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.scene_item_view, "field 'mRecyclerView'", RecyclerView.class);
        liteAutomationChooseScene.mTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.module_a_3_return_title, "field 'mTitle'", TextView.class);
        liteAutomationChooseScene.mReturnBtn = (ImageView) Utils.findRequiredViewAsType(view, R.id.module_a_3_return_btn, "field 'mReturnBtn'", ImageView.class);
        liteAutomationChooseScene.mNoSceneView = Utils.findRequiredView(view, R.id.no_scene_item_view, "field 'mNoSceneView'");
    }

    public void unbind() {
        LiteAutomationChooseScene liteAutomationChooseScene = this.f10741O000000o;
        if (liteAutomationChooseScene != null) {
            this.f10741O000000o = null;
            liteAutomationChooseScene.mPullRefreshLL = null;
            liteAutomationChooseScene.mRecyclerView = null;
            liteAutomationChooseScene.mTitle = null;
            liteAutomationChooseScene.mReturnBtn = null;
            liteAutomationChooseScene.mNoSceneView = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}

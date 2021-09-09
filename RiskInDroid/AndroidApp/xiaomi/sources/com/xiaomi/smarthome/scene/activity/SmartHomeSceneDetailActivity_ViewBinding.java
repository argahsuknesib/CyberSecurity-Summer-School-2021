package com.xiaomi.smarthome.scene.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;

public class SmartHomeSceneDetailActivity_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private SmartHomeSceneDetailActivity f10971O000000o;

    public SmartHomeSceneDetailActivity_ViewBinding(SmartHomeSceneDetailActivity smartHomeSceneDetailActivity, View view) {
        this.f10971O000000o = smartHomeSceneDetailActivity;
        smartHomeSceneDetailActivity.mBackBtn = (ImageView) Utils.findRequiredViewAsType(view, R.id.module_a_3_return_btn, "field 'mBackBtn'", ImageView.class);
        smartHomeSceneDetailActivity.mTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.module_a_3_return_title, "field 'mTitle'", TextView.class);
        smartHomeSceneDetailActivity.mContentList = (ListView) Utils.findRequiredViewAsType(view, R.id.content_list_view, "field 'mContentList'", ListView.class);
    }

    public void unbind() {
        SmartHomeSceneDetailActivity smartHomeSceneDetailActivity = this.f10971O000000o;
        if (smartHomeSceneDetailActivity != null) {
            this.f10971O000000o = null;
            smartHomeSceneDetailActivity.mBackBtn = null;
            smartHomeSceneDetailActivity.mTitle = null;
            smartHomeSceneDetailActivity.mContentList = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}

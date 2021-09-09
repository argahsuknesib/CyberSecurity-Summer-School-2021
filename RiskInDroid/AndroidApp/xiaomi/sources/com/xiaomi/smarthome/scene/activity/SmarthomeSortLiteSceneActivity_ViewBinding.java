package com.xiaomi.smarthome.scene.activity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;

public class SmarthomeSortLiteSceneActivity_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private SmarthomeSortLiteSceneActivity f11087O000000o;

    public SmarthomeSortLiteSceneActivity_ViewBinding(SmarthomeSortLiteSceneActivity smarthomeSortLiteSceneActivity, View view) {
        this.f11087O000000o = smarthomeSortLiteSceneActivity;
        smarthomeSortLiteSceneActivity.moduleA4ReturnBtn = (Button) Utils.findRequiredViewAsType(view, R.id.module_a_4_return_btn, "field 'moduleA4ReturnBtn'", Button.class);
        smarthomeSortLiteSceneActivity.moduleA4ReturnTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.module_a_4_return_title, "field 'moduleA4ReturnTitle'", TextView.class);
        smarthomeSortLiteSceneActivity.mCommitBtn = (Button) Utils.findRequiredViewAsType(view, R.id.module_a_4_commit_btn, "field 'mCommitBtn'", Button.class);
    }

    public void unbind() {
        SmarthomeSortLiteSceneActivity smarthomeSortLiteSceneActivity = this.f11087O000000o;
        if (smarthomeSortLiteSceneActivity != null) {
            this.f11087O000000o = null;
            smarthomeSortLiteSceneActivity.moduleA4ReturnBtn = null;
            smarthomeSortLiteSceneActivity.moduleA4ReturnTitle = null;
            smarthomeSortLiteSceneActivity.mCommitBtn = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}

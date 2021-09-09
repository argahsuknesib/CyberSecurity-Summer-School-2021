package com.xiaomi.smarthome.scene.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;

public class AutoSceneActionDetailChooseActivity_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private AutoSceneActionDetailChooseActivity f10652O000000o;

    public AutoSceneActionDetailChooseActivity_ViewBinding(AutoSceneActionDetailChooseActivity autoSceneActionDetailChooseActivity, View view) {
        this.f10652O000000o = autoSceneActionDetailChooseActivity;
        autoSceneActionDetailChooseActivity.mTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.module_a_3_return_title, "field 'mTitle'", TextView.class);
        autoSceneActionDetailChooseActivity.mReturnBtn = (ImageView) Utils.findRequiredViewAsType(view, R.id.module_a_3_return_btn, "field 'mReturnBtn'", ImageView.class);
        autoSceneActionDetailChooseActivity.mCloseTV = (TextView) Utils.findRequiredViewAsType(view, R.id.close_item, "field 'mCloseTV'", TextView.class);
        autoSceneActionDetailChooseActivity.mOpenTV = (TextView) Utils.findRequiredViewAsType(view, R.id.open_item, "field 'mOpenTV'", TextView.class);
    }

    public void unbind() {
        AutoSceneActionDetailChooseActivity autoSceneActionDetailChooseActivity = this.f10652O000000o;
        if (autoSceneActionDetailChooseActivity != null) {
            this.f10652O000000o = null;
            autoSceneActionDetailChooseActivity.mTitle = null;
            autoSceneActionDetailChooseActivity.mReturnBtn = null;
            autoSceneActionDetailChooseActivity.mCloseTV = null;
            autoSceneActionDetailChooseActivity.mOpenTV = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}

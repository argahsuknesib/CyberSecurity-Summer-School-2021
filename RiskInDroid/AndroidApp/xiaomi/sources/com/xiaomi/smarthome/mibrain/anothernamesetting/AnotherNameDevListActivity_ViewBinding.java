package com.xiaomi.smarthome.mibrain.anothernamesetting;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;

public class AnotherNameDevListActivity_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private AnotherNameDevListActivity f9469O000000o;

    public AnotherNameDevListActivity_ViewBinding(AnotherNameDevListActivity anotherNameDevListActivity, View view) {
        this.f9469O000000o = anotherNameDevListActivity;
        anotherNameDevListActivity.mReturn = (ImageView) Utils.findRequiredViewAsType(view, R.id.module_a_3_return_btn, "field 'mReturn'", ImageView.class);
        anotherNameDevListActivity.mTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.module_a_3_return_title, "field 'mTitle'", TextView.class);
        anotherNameDevListActivity.mTitleRightIcon = (ImageView) Utils.findRequiredViewAsType(view, R.id.module_a_3_right_iv_setting_btn, "field 'mTitleRightIcon'", ImageView.class);
        anotherNameDevListActivity.mRecyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecyclerView'", RecyclerView.class);
        anotherNameDevListActivity.mIntroduction = (TextView) Utils.findRequiredViewAsType(view, R.id.id_introduction, "field 'mIntroduction'", TextView.class);
        anotherNameDevListActivity.mGuide = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.guide, "field 'mGuide'", LinearLayout.class);
        anotherNameDevListActivity.mGuideCancel = (ImageView) Utils.findRequiredViewAsType(view, R.id.guide_cancel, "field 'mGuideCancel'", ImageView.class);
        anotherNameDevListActivity.mEmpty = (TextView) Utils.findRequiredViewAsType(view, R.id.empty, "field 'mEmpty'", TextView.class);
    }

    public void unbind() {
        AnotherNameDevListActivity anotherNameDevListActivity = this.f9469O000000o;
        if (anotherNameDevListActivity != null) {
            this.f9469O000000o = null;
            anotherNameDevListActivity.mReturn = null;
            anotherNameDevListActivity.mTitle = null;
            anotherNameDevListActivity.mTitleRightIcon = null;
            anotherNameDevListActivity.mRecyclerView = null;
            anotherNameDevListActivity.mIntroduction = null;
            anotherNameDevListActivity.mGuide = null;
            anotherNameDevListActivity.mGuideCancel = null;
            anotherNameDevListActivity.mEmpty = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}

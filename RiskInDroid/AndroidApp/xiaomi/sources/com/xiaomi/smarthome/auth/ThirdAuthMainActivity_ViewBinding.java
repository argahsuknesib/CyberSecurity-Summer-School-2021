package com.xiaomi.smarthome.auth;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.common.widget.ListViewWithFixedHeight;

public class ThirdAuthMainActivity_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private ThirdAuthMainActivity f4278O000000o;

    public ThirdAuthMainActivity_ViewBinding(ThirdAuthMainActivity thirdAuthMainActivity, View view) {
        this.f4278O000000o = thirdAuthMainActivity;
        thirdAuthMainActivity.mAppIconIV = (SimpleDraweeView) Utils.findRequiredViewAsType(view, R.id.app_icon, "field 'mAppIconIV'", SimpleDraweeView.class);
        thirdAuthMainActivity.mAppNameTV = (TextView) Utils.findRequiredViewAsType(view, R.id.app_name, "field 'mAppNameTV'", TextView.class);
        thirdAuthMainActivity.mAppDescTV = (TextView) Utils.findRequiredViewAsType(view, R.id.app_desc, "field 'mAppDescTV'", TextView.class);
        thirdAuthMainActivity.mAuthDesc = (TextView) Utils.findRequiredViewAsType(view, R.id.auth_desc, "field 'mAuthDesc'", TextView.class);
        thirdAuthMainActivity.mListView = (ListViewWithFixedHeight) Utils.findRequiredViewAsType(view, R.id.auto_lv, "field 'mListView'", ListViewWithFixedHeight.class);
        thirdAuthMainActivity.mAuthCancelTV = (TextView) Utils.findRequiredViewAsType(view, R.id.auth_cancel, "field 'mAuthCancelTV'", TextView.class);
        thirdAuthMainActivity.mAuthAgreeTV = (TextView) Utils.findRequiredViewAsType(view, R.id.auth_agree, "field 'mAuthAgreeTV'", TextView.class);
        thirdAuthMainActivity.mTitleTV = (TextView) Utils.findRequiredViewAsType(view, R.id.module_a_3_return_title, "field 'mTitleTV'", TextView.class);
        thirdAuthMainActivity.mBackIV = (ImageView) Utils.findRequiredViewAsType(view, R.id.module_a_3_return_btn, "field 'mBackIV'", ImageView.class);
        thirdAuthMainActivity.mSelectAll = (CheckBox) Utils.findRequiredViewAsType(view, R.id.ckb_select_all, "field 'mSelectAll'", CheckBox.class);
    }

    public void unbind() {
        ThirdAuthMainActivity thirdAuthMainActivity = this.f4278O000000o;
        if (thirdAuthMainActivity != null) {
            this.f4278O000000o = null;
            thirdAuthMainActivity.mAppIconIV = null;
            thirdAuthMainActivity.mAppNameTV = null;
            thirdAuthMainActivity.mAppDescTV = null;
            thirdAuthMainActivity.mAuthDesc = null;
            thirdAuthMainActivity.mListView = null;
            thirdAuthMainActivity.mAuthCancelTV = null;
            thirdAuthMainActivity.mAuthAgreeTV = null;
            thirdAuthMainActivity.mTitleTV = null;
            thirdAuthMainActivity.mBackIV = null;
            thirdAuthMainActivity.mSelectAll = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}

package com.xiaomi.smarthome.auth;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;

public class AuthManagerListActivity_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private AuthManagerListActivity f4264O000000o;

    public AuthManagerListActivity_ViewBinding(AuthManagerListActivity authManagerListActivity, View view) {
        this.f4264O000000o = authManagerListActivity;
        authManagerListActivity.mTitleTV = (TextView) Utils.findRequiredViewAsType(view, R.id.module_a_3_return_title, "field 'mTitleTV'", TextView.class);
        authManagerListActivity.mBackIV = (ImageView) Utils.findRequiredViewAsType(view, R.id.module_a_3_return_btn, "field 'mBackIV'", ImageView.class);
        authManagerListActivity.mListView = (ListView) Utils.findRequiredViewAsType(view, R.id.auth_manager_list_lv, "field 'mListView'", ListView.class);
        authManagerListActivity.mEmptyLL = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.empty_ll, "field 'mEmptyLL'", LinearLayout.class);
    }

    public void unbind() {
        AuthManagerListActivity authManagerListActivity = this.f4264O000000o;
        if (authManagerListActivity != null) {
            this.f4264O000000o = null;
            authManagerListActivity.mTitleTV = null;
            authManagerListActivity.mBackIV = null;
            authManagerListActivity.mListView = null;
            authManagerListActivity.mEmptyLL = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}

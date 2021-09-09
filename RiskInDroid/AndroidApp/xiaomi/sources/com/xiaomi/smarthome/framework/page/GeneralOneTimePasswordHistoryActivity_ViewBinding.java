package com.xiaomi.smarthome.framework.page;

import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.common.widget.DevicePtrFrameLayout;

public class GeneralOneTimePasswordHistoryActivity_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private GeneralOneTimePasswordHistoryActivity f7771O000000o;

    public GeneralOneTimePasswordHistoryActivity_ViewBinding(GeneralOneTimePasswordHistoryActivity generalOneTimePasswordHistoryActivity, View view) {
        this.f7771O000000o = generalOneTimePasswordHistoryActivity;
        generalOneTimePasswordHistoryActivity.mBackBt = (ImageView) Utils.findRequiredViewAsType(view, R.id.module_a_3_return_btn, "field 'mBackBt'", ImageView.class);
        generalOneTimePasswordHistoryActivity.mListView = (ListView) Utils.findRequiredViewAsType(view, R.id.recycler_view, "field 'mListView'", ListView.class);
        generalOneTimePasswordHistoryActivity.mEmptyView = Utils.findRequiredView(view, R.id.empty_all_page, "field 'mEmptyView'");
        generalOneTimePasswordHistoryActivity.mPullRefresh = (DevicePtrFrameLayout) Utils.findRequiredViewAsType(view, R.id.pull_down_refresh, "field 'mPullRefresh'", DevicePtrFrameLayout.class);
        generalOneTimePasswordHistoryActivity.mGeneratePwdBtn = (ImageView) Utils.findRequiredViewAsType(view, R.id.generate_pwd_btn, "field 'mGeneratePwdBtn'", ImageView.class);
        generalOneTimePasswordHistoryActivity.mSubTitle = Utils.findRequiredView(view, R.id.sub_title_bar, "field 'mSubTitle'");
    }

    public void unbind() {
        GeneralOneTimePasswordHistoryActivity generalOneTimePasswordHistoryActivity = this.f7771O000000o;
        if (generalOneTimePasswordHistoryActivity != null) {
            this.f7771O000000o = null;
            generalOneTimePasswordHistoryActivity.mBackBt = null;
            generalOneTimePasswordHistoryActivity.mListView = null;
            generalOneTimePasswordHistoryActivity.mEmptyView = null;
            generalOneTimePasswordHistoryActivity.mPullRefresh = null;
            generalOneTimePasswordHistoryActivity.mGeneratePwdBtn = null;
            generalOneTimePasswordHistoryActivity.mSubTitle = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}

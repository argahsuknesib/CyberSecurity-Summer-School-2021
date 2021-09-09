package com.xiaomi.smarthome.scene.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;

public class SmarthomeChooseWeatherConditionDetailActivity_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private SmarthomeChooseWeatherConditionDetailActivity f11004O000000o;

    public SmarthomeChooseWeatherConditionDetailActivity_ViewBinding(SmarthomeChooseWeatherConditionDetailActivity smarthomeChooseWeatherConditionDetailActivity, View view) {
        this.f11004O000000o = smarthomeChooseWeatherConditionDetailActivity;
        smarthomeChooseWeatherConditionDetailActivity.mListView = (ListView) Utils.findRequiredViewAsType(view, R.id.list_view, "field 'mListView'", ListView.class);
        smarthomeChooseWeatherConditionDetailActivity.mReturnIV = (ImageView) Utils.findRequiredViewAsType(view, R.id.module_a_3_return_btn, "field 'mReturnIV'", ImageView.class);
        smarthomeChooseWeatherConditionDetailActivity.mTitleTV = (TextView) Utils.findRequiredViewAsType(view, R.id.module_a_3_return_title, "field 'mTitleTV'", TextView.class);
    }

    public void unbind() {
        SmarthomeChooseWeatherConditionDetailActivity smarthomeChooseWeatherConditionDetailActivity = this.f11004O000000o;
        if (smarthomeChooseWeatherConditionDetailActivity != null) {
            this.f11004O000000o = null;
            smarthomeChooseWeatherConditionDetailActivity.mListView = null;
            smarthomeChooseWeatherConditionDetailActivity.mReturnIV = null;
            smarthomeChooseWeatherConditionDetailActivity.mTitleTV = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}

package com.xiaomi.smarthome.scene.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;

public class SmarthomeChooseWeatherConditionActivity_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private SmarthomeChooseWeatherConditionActivity f10998O000000o;

    public SmarthomeChooseWeatherConditionActivity_ViewBinding(SmarthomeChooseWeatherConditionActivity smarthomeChooseWeatherConditionActivity, View view) {
        this.f10998O000000o = smarthomeChooseWeatherConditionActivity;
        smarthomeChooseWeatherConditionActivity.mListView = (ListView) Utils.findRequiredViewAsType(view, R.id.list_view, "field 'mListView'", ListView.class);
        smarthomeChooseWeatherConditionActivity.mReturnIV = (ImageView) Utils.findRequiredViewAsType(view, R.id.module_a_3_return_btn, "field 'mReturnIV'", ImageView.class);
        smarthomeChooseWeatherConditionActivity.mTitleTV = (TextView) Utils.findRequiredViewAsType(view, R.id.module_a_3_return_title, "field 'mTitleTV'", TextView.class);
    }

    public void unbind() {
        SmarthomeChooseWeatherConditionActivity smarthomeChooseWeatherConditionActivity = this.f10998O000000o;
        if (smarthomeChooseWeatherConditionActivity != null) {
            this.f10998O000000o = null;
            smarthomeChooseWeatherConditionActivity.mListView = null;
            smarthomeChooseWeatherConditionActivity.mReturnIV = null;
            smarthomeChooseWeatherConditionActivity.mTitleTV = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}

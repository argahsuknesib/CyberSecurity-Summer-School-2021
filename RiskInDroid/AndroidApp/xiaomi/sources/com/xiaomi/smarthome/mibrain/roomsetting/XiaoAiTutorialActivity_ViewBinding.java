package com.xiaomi.smarthome.mibrain.roomsetting;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.mibigkoo.convenientbanner.ConvenientBanner;
import com.xiaomi.smarthome.R;

public class XiaoAiTutorialActivity_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private XiaoAiTutorialActivity f9510O000000o;

    public XiaoAiTutorialActivity_ViewBinding(XiaoAiTutorialActivity xiaoAiTutorialActivity, View view) {
        this.f9510O000000o = xiaoAiTutorialActivity;
        xiaoAiTutorialActivity.banner = (ConvenientBanner) Utils.findRequiredViewAsType(view, R.id.banner, "field 'banner'", ConvenientBanner.class);
        xiaoAiTutorialActivity.close = Utils.findRequiredView(view, R.id.close, "field 'close'");
    }

    public void unbind() {
        XiaoAiTutorialActivity xiaoAiTutorialActivity = this.f9510O000000o;
        if (xiaoAiTutorialActivity != null) {
            this.f9510O000000o = null;
            xiaoAiTutorialActivity.banner = null;
            xiaoAiTutorialActivity.close = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}

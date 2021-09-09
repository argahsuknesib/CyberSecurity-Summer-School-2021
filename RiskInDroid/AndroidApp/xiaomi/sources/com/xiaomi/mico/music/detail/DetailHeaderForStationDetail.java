package com.xiaomi.mico.music.detail;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.xiaomi.mico.api.model.Music;
import com.xiaomi.mico.common.application.AppCapability;
import com.xiaomi.smarthome.R;
import java.io.Serializable;

public class DetailHeaderForStationDetail extends DetailHeader {
    View babyScheduleContainer;

    public DetailHeaderForStationDetail(Context context) {
        super(context);
    }

    public DetailHeaderForStationDetail(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        this.babyScheduleContainer = findViewById(R.id.babyScheduleContainer);
    }

    public void updateBabyScheduleIconVisibility(Serializable serializable, boolean z) {
        if (!z && (serializable instanceof Music.Station) && AppCapability.hasCapabilityBabySchedule()) {
            if (((Music.Station) serializable).isChild()) {
                View view = this.babyScheduleContainer;
                if (view != null) {
                    view.setVisibility(0);
                }
                this.mLove.setVisibility(8);
                return;
            }
            this.babyScheduleContainer.setVisibility(8);
            this.mLove.setVisibility(0);
        }
    }

    public void hideLoveIcon() {
        this.ivLoveBellow.setVisibility(8);
        this.mLove.setVisibility(8);
    }
}

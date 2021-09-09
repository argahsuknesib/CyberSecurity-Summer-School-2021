package com.xiaomi.mico.setting;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.xiaomi.mico.R2;
import com.xiaomi.mico.api.ApiError;
import com.xiaomi.mico.api.ApiHelper;
import com.xiaomi.mico.api.ApiRequest;
import com.xiaomi.mico.api.model.ThirdPartyResponse;
import com.xiaomi.mico.application.MicoManager;
import com.xiaomi.mico.base.MicoBaseActivity;
import com.xiaomi.mico.common.util.GPSUtil;
import com.xiaomi.mico.common.util.ToastUtil;
import com.xiaomi.mico.common.widget.TitleBar;
import com.xiaomi.smarthome.R;
import java.util.List;

public class TrafficSettingActivity extends MicoBaseActivity {
    TextView saveBtn;
    TitleBar titleBar;
    TrafficSettingView trafficSettingView;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_traffic_setting);
        this.titleBar = (TitleBar) findViewById(R.id.title_bar);
        this.saveBtn = (TextView) findViewById(R.id.save_btn);
        this.saveBtn.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.setting.$$Lambda$TrafficSettingActivity$2e9iixxnvZ3Y4F6Gj5HvfcgCq4 */

            public final void onClick(View view) {
                TrafficSettingActivity.this.lambda$onCreate$0$TrafficSettingActivity(view);
            }
        });
        this.trafficSettingView = (TrafficSettingView) findViewById(R.id.traffic_setting_view);
        this.titleBar.setOnLeftIconClickListener(new TitleBar.OnLeftIconClickListener() {
            /* class com.xiaomi.mico.setting.TrafficSettingActivity.AnonymousClass1 */

            public void onLeftIconClick() {
                TrafficSettingActivity.this.onBackPressed();
            }
        });
        loadTrafficInfo();
        GPSUtil.checkGpsEnabled(this);
    }

    private void loadTrafficInfo() {
        ApiHelper.getTrafficInfo(MicoManager.getInstance().getCurrentMicoID(), new ApiRequest.Listener<ThirdPartyResponse.TrafficInfo>() {
            /* class com.xiaomi.mico.setting.TrafficSettingActivity.AnonymousClass2 */

            public void onSuccess(ThirdPartyResponse.TrafficInfo trafficInfo) {
                TrafficSettingActivity.this.trafficSettingView.setData(trafficInfo);
            }

            public void onFailure(ApiError apiError) {
                new Object[1][0] = apiError;
                Toast.makeText(TrafficSettingActivity.this.getContext(), (int) R.string.common_load_failed, 1).show();
            }
        });
    }

    /* renamed from: onViewClicked */
    public void lambda$onCreate$0$TrafficSettingActivity(View view) {
        saveInfo();
    }

    private void saveInfo() {
        if (this.trafficSettingView.isMicoAddressIllegal()) {
            ToastUtil.showToast((int) R.string.setting_traffic_home_default);
        } else {
            ApiHelper.setTrafficInfo(MicoManager.getInstance().getCurrentMicoID(), this.trafficSettingView.getHomeAddress(), this.trafficSettingView.getOfficeAddress(), this.trafficSettingView.getMicoAddress(), this.trafficSettingView.getMode(), this.trafficSettingView.getArriveTime(), 1, 0, new ApiRequest.Listener<Object>() {
                /* class com.xiaomi.mico.setting.TrafficSettingActivity.AnonymousClass3 */

                public void onSuccess(Object obj) {
                    Toast.makeText(TrafficSettingActivity.this.getContext(), (int) R.string.mico_common_save_success, 0).show();
                    TrafficSettingActivity.this.finish();
                }

                public void onFailure(ApiError apiError) {
                    new Object[1][0] = apiError;
                    Toast.makeText(TrafficSettingActivity.this.getContext(), (int) R.string.common_save_fail, 1).show();
                }
            });
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 991:
                    this.trafficSettingView.setHomeAddress(new ThirdPartyResponse.TrafficAddress((ThirdPartyResponse.POIResponse) intent.getSerializableExtra("SELECTED_ADDRESS")));
                    return;
                case 992:
                    this.trafficSettingView.setOfficeAddress(new ThirdPartyResponse.TrafficAddress((ThirdPartyResponse.POIResponse) intent.getSerializableExtra("SELECTED_ADDRESS")));
                    return;
                case R2.attr.name:
                    this.trafficSettingView.setPlateInfo((List) intent.getSerializableExtra("PLATENUMBER_INFO"));
                    return;
                default:
                    return;
            }
        }
    }
}

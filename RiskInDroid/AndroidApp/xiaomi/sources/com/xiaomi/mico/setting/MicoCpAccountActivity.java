package com.xiaomi.mico.setting;

import _m_j.jgc;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.xiaomi.mico.api.ApiConstants;
import com.xiaomi.mico.api.ApiError;
import com.xiaomi.mico.api.ApiHelper;
import com.xiaomi.mico.api.ApiRequest;
import com.xiaomi.mico.application.MicoApplication;
import com.xiaomi.mico.application.MicoManager;
import com.xiaomi.mico.base.MicoBaseActivity;
import com.xiaomi.mico.common.application.AccountProfile;
import com.xiaomi.mico.common.application.AppCapability;
import com.xiaomi.mico.common.application.AreaCode;
import com.xiaomi.mico.common.event.KKBoxAuthEvent;
import com.xiaomi.mico.common.schema.SchemaManager;
import com.xiaomi.mico.common.schema.handler.SkillSchemaHandler;
import com.xiaomi.mico.common.widget.KKBoxAuthPopupView;
import com.xiaomi.mico.common.widget.QQMusicAuthPopupView;
import com.xiaomi.smarthome.R;
import org.json.JSONException;
import org.json.JSONObject;

public class MicoCpAccountActivity extends MicoBaseActivity {
    ImageView mBackImgView;
    RelativeLayout settingDedaoAccountView;
    RelativeLayout settingKKboxAccountView;
    RelativeLayout settingQqAccountView;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.mico_cp_account_activity);
        this.mBackImgView = (ImageView) findViewById(R.id.title_bar_left_icon);
        this.mBackImgView.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.setting.$$Lambda$MicoCpAccountActivity$7GRI8GKkJ2Q0b60OZzXKN7_Zc8I */

            public final void onClick(View view) {
                MicoCpAccountActivity.this.lambda$onCreate$0$MicoCpAccountActivity(view);
            }
        });
        this.settingQqAccountView = (RelativeLayout) findViewById(R.id.mico_account_qq_container);
        this.settingQqAccountView.setVisibility(AppCapability.hasCapabilityQQMusic() ? 0 : 8);
        this.settingQqAccountView.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.setting.$$Lambda$MicoCpAccountActivity$zHevS3jytyUF2Rfr4bl7390qFVE */

            public final void onClick(View view) {
                MicoCpAccountActivity.this.lambda$onCreate$1$MicoCpAccountActivity(view);
            }
        });
        this.settingDedaoAccountView = (RelativeLayout) findViewById(R.id.mico_account_dedao_container);
        this.settingDedaoAccountView.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.setting.$$Lambda$MicoCpAccountActivity$q4I6YcMfkDkprhvCF0LI5b7U7I */

            public final void onClick(View view) {
                MicoCpAccountActivity.this.lambda$onCreate$2$MicoCpAccountActivity(view);
            }
        });
        this.settingKKboxAccountView = (RelativeLayout) findViewById(R.id.mico_account_kkbox_container);
        this.settingKKboxAccountView.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.setting.$$Lambda$MicoCpAccountActivity$1qgmtW3CJ23rBgrOmDpfzl3iK7Q */

            public final void onClick(View view) {
                MicoCpAccountActivity.this.lambda$onCreate$3$MicoCpAccountActivity(view);
            }
        });
        if (AreaCode.CN == ApiConstants.getAreaCode()) {
            this.settingDedaoAccountView.setVisibility(0);
            this.settingKKboxAccountView.setVisibility(8);
            return;
        }
        this.settingDedaoAccountView.setVisibility(8);
        this.settingKKboxAccountView.setVisibility(0);
    }

    public /* synthetic */ void lambda$onCreate$0$MicoCpAccountActivity(View view) {
        onBackPressed();
    }

    /* access modifiers changed from: private */
    /* renamed from: onClickView */
    public void lambda$onCreate$3$MicoCpAccountActivity(View view) {
        int id = view.getId();
        if (id == R.id.mico_account_qq_container) {
            if (AccountProfile.current().isQQAccountAuthValid()) {
                MusicAccountAuthInfoActivity.start(getContext(), "", "个人中心");
            } else {
                QQMusicAuthPopupView.showAuthAlert(getContext(), AccountProfile.current().getQQBindStatus());
            }
        } else if (id == R.id.mico_account_dedao_container) {
            SchemaManager.handleSchema(getContext(), "mico://services/oauth?skillId=279202210947007488&providerID=269135865337350144");
        } else if (id != R.id.mico_account_kkbox_container) {
        } else {
            if (AccountProfile.current().isKKBoxAuthValid()) {
                MusicAccountAuthInfoActivity.start(getContext(), "kkbox", "个人中心");
            } else {
                KKBoxAuthPopupView.showAuthAlert(getContext());
            }
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 1102) {
            KKBoxAuthEvent completeEvent = KKBoxAuthEvent.completeEvent(intent.getData());
            if (completeEvent.success) {
                acquireMembership();
            }
            jgc.O000000o().O00000o(completeEvent);
        }
    }

    private static void acquireMembership() {
        String currentMicoID = MicoManager.getInstance().getCurrentMicoID();
        String currentMicoSN = MicoManager.getInstance().getCurrentMicoSN();
        if (!TextUtils.isEmpty(currentMicoID)) {
            ApiHelper.kkboxSalesPromotion(currentMicoID, currentMicoSN, new ApiRequest.Listener<String>() {
                /* class com.xiaomi.mico.setting.MicoCpAccountActivity.AnonymousClass1 */

                public final void onFailure(ApiError apiError) {
                }

                public final void onSuccess(String str) {
                    if (str != null && !TextUtils.isEmpty(str)) {
                        try {
                            String optString = new JSONObject(str).optString("url");
                            if (!TextUtils.isEmpty(optString)) {
                                SchemaManager.handleSchema(MicoApplication.getInstance().getGlobalContext(), SkillSchemaHandler.buildWebSchema("", optString, false));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
    }
}

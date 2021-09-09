package com.xiaomi.mico.music;

import _m_j.hxi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.xiaomi.mico.api.ApiConstants;
import com.xiaomi.mico.api.ApiError;
import com.xiaomi.mico.api.ApiHelper;
import com.xiaomi.mico.api.ApiRequest;
import com.xiaomi.mico.api.model.Payment;
import com.xiaomi.mico.common.application.AccountProfile;
import com.xiaomi.mico.common.util.PreferenceUtils;
import com.xiaomi.mico.setting.MusicAccountAuthInfoActivity;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import org.json.JSONObject;

public class OpenQQMusicVIPView extends FrameLayout {
    public static Boolean cachedVipOpenStatus;
    TextView tvOpenVipDes;
    TextView tvToOpen;

    public OpenQQMusicVIPView(Context context) {
        super(context);
        init(context);
    }

    public OpenQQMusicVIPView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public OpenQQMusicVIPView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public static void clearData(Context context) {
        cachedVipOpenStatus = null;
        PreferenceUtils.removePreference(context, "QQMusicVipStatus");
    }

    private void init(Context context) {
        View.inflate(context, R.layout.view_open_qq_music_vip, this);
        this.tvOpenVipDes = (TextView) findViewById(R.id.tvOpenVipDes);
        this.tvToOpen = (TextView) findViewById(R.id.tvToOpen);
        this.tvToOpen.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.music.$$Lambda$OpenQQMusicVIPView$miMBSVxBE6PcSJxHzi2NJXGUOk */

            public final void onClick(View view) {
                OpenQQMusicVIPView.this.lambda$init$0$OpenQQMusicVIPView(view);
            }
        });
    }

    public void updateTexts(boolean z) {
        setVisibility(0);
        if (z) {
            this.tvOpenVipDes.setText((int) R.string.qq_music_vip_tip);
            this.tvToOpen.setVisibility(0);
            this.tvToOpen.setText((int) R.string.qq_music_vip_to_open);
            return;
        }
        this.tvOpenVipDes.setText((int) R.string.tool_debug_music_list);
        this.tvToOpen.setVisibility(8);
    }

    /* renamed from: onClick */
    public void lambda$init$0$OpenQQMusicVIPView(View view) {
        if (view.getId() == R.id.tvToOpen) {
            hxi.O00000o.O000000o("content_qqdetail_vip", (JSONObject) null);
            MusicAccountAuthInfoActivity.start(CommonApplication.getAppContext(), "", "歌单");
        }
    }

    public void updateOpenVipViewVisibility(final Context context) {
        if (!ApiConstants.isAreaCodeInTaiWan() && AccountProfile.current().isQQMusicSource() && AccountProfile.current().isQQAccountAuthValid()) {
            if (cachedVipOpenStatus == null) {
                cachedVipOpenStatus = Boolean.valueOf(PreferenceUtils.getSettingBoolean(context, "QQMusicVipStatus", true));
            }
            updateTexts(!cachedVipOpenStatus.booleanValue());
            ApiHelper.getQQMusicMemberStatus(new ApiRequest.Listener<Payment.MemberStatus>() {
                /* class com.xiaomi.mico.music.OpenQQMusicVIPView.AnonymousClass1 */

                public void onSuccess(Payment.MemberStatus memberStatus) {
                    boolean isVipOpened = memberStatus.isVipOpened();
                    OpenQQMusicVIPView.this.updateTexts(!isVipOpened);
                    OpenQQMusicVIPView.cachedVipOpenStatus = Boolean.valueOf(isVipOpened);
                    PreferenceUtils.setSettingBoolean(context, "QQMusicVipStatus", isVipOpened);
                }

                public void onFailure(ApiError apiError) {
                    Object[] objArr = {"loadQQVIPStatus->onFailure apiError:%s", apiError};
                    OpenQQMusicVIPView.this.updateTexts(true);
                }
            });
        }
    }
}

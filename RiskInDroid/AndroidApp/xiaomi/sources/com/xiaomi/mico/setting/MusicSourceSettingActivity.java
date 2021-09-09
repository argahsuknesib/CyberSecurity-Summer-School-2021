package com.xiaomi.mico.setting;

import _m_j.dka;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.xiaomi.mico.api.ApiError;
import com.xiaomi.mico.api.ApiHelper;
import com.xiaomi.mico.api.ApiRequest;
import com.xiaomi.mico.api.model.MiBrain;
import com.xiaomi.mico.base.MicoBaseActivity;
import com.xiaomi.mico.common.application.AccountProfile;
import com.xiaomi.mico.common.event.QQAuthUiListener;
import com.xiaomi.mico.common.widget.QQMusicAuthPopupView;
import com.xiaomi.mico.common.widget.RadioItemLinearView;
import com.xiaomi.mico.common.widget.TitleBar;
import com.xiaomi.mico.music.cache.MusicCache;
import com.xiaomi.mico.music.manager.MusicSourceManager;
import com.xiaomi.smarthome.R;

public class MusicSourceSettingActivity extends MicoBaseActivity {
    TitleBar mTitleBar;
    RadioItemLinearView miSource;
    public String musicSource;
    RadioItemLinearView qqSource;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_setting_music_source);
        this.mTitleBar = (TitleBar) findViewById(R.id.title_bar);
        this.miSource = (RadioItemLinearView) findViewById(R.id.mi_music_source);
        this.miSource.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.setting.$$Lambda$MusicSourceSettingActivity$eDCvecLLYuWUIbzI_IQ2HG_ZYg */

            public final void onClick(View view) {
                MusicSourceSettingActivity.this.lambda$onCreate$0$MusicSourceSettingActivity(view);
            }
        });
        this.qqSource = (RadioItemLinearView) findViewById(R.id.qq_music_source);
        this.qqSource.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.setting.$$Lambda$MusicSourceSettingActivity$775KFHFohY82z8IusUzO5Kfa__c */

            public final void onClick(View view) {
                MusicSourceSettingActivity.this.lambda$onCreate$1$MusicSourceSettingActivity(view);
            }
        });
        this.mTitleBar.setOnLeftIconClickListener(new TitleBar.OnLeftIconClickListener() {
            /* class com.xiaomi.mico.setting.MusicSourceSettingActivity.AnonymousClass1 */

            public void onLeftIconClick() {
                MusicSourceSettingActivity.this.onBackPressed();
            }
        });
        AccountProfile.MusicSuorce musicSource2 = AccountProfile.current().getMusicSource();
        if (musicSource2 != null) {
            this.musicSource = musicSource2.getSource();
        }
        setMusicSourceStatus(this.musicSource);
        getMusicSource();
    }

    public void setMusicSourceStatus(String str) {
        if (AccountProfile.MusicSuorce.QQ.getSource().equalsIgnoreCase(str)) {
            this.qqSource.setChecked(Boolean.TRUE);
            this.miSource.setChecked(Boolean.FALSE);
        } else if (AccountProfile.MusicSuorce.MI.getSource().equalsIgnoreCase(str)) {
            this.qqSource.setChecked(Boolean.FALSE);
            this.miSource.setChecked(Boolean.TRUE);
        }
    }

    public void onDestroy() {
        super.onDestroy();
    }

    /* renamed from: onClick */
    public void lambda$onCreate$1$MusicSourceSettingActivity(View view) {
        int id = view.getId();
        if (id == R.id.mi_music_source) {
            setMusicSource(AccountProfile.MusicSuorce.MI.getSource());
        } else if (id == R.id.qq_music_source) {
            setMusicSource(AccountProfile.MusicSuorce.QQ.getSource());
        }
    }

    private void setMusicSource(final String str) {
        if (!str.equalsIgnoreCase(this.musicSource)) {
            setMusicSourceStatus(str);
            showProgressDialog(null);
            ApiHelper.setMusicSource(str, new ApiRequest.Listener<Boolean>() {
                /* class com.xiaomi.mico.setting.MusicSourceSettingActivity.AnonymousClass2 */

                public void onSuccess(Boolean bool) {
                    MusicSourceSettingActivity.this.dismissProgressDialog();
                    if (bool.booleanValue()) {
                        MusicSourceSettingActivity musicSourceSettingActivity = MusicSourceSettingActivity.this;
                        musicSourceSettingActivity.musicSource = str;
                        musicSourceSettingActivity.setMusicSourceStatus(musicSourceSettingActivity.musicSource);
                        AccountProfile.current().setMusicSource(MusicSourceSettingActivity.this.musicSource);
                        MusicCache.clearCache();
                        MusicSourceManager.sendMusicSourceChange(MusicSourceSettingActivity.this.musicSource);
                        if (AccountProfile.MusicSuorce.QQ.getSource().equalsIgnoreCase(MusicSourceSettingActivity.this.musicSource)) {
                            AccountProfile.current().syncQQBindStatus(new ApiRequest.Listener<MiBrain.CPBindStatus>() {
                                /* class com.xiaomi.mico.setting.MusicSourceSettingActivity.AnonymousClass2.AnonymousClass1 */

                                public void onFailure(ApiError apiError) {
                                }

                                public void onSuccess(MiBrain.CPBindStatus cPBindStatus) {
                                    if (AccountProfile.current().isQQAccountNotBinded()) {
                                        QQMusicAuthPopupView.showAuthAlert(MusicSourceSettingActivity.this);
                                    } else if (AccountProfile.current().isQQAccountAuthValid()) {
                                        MusicSourceSettingActivity.this.onBackPressed();
                                    } else {
                                        QQMusicAuthPopupView.showAuthAlert(MusicSourceSettingActivity.this, cPBindStatus);
                                    }
                                }
                            });
                        } else {
                            MusicSourceSettingActivity.this.onBackPressed();
                        }
                    }
                }

                public void onFailure(ApiError apiError) {
                    MusicSourceSettingActivity musicSourceSettingActivity = MusicSourceSettingActivity.this;
                    musicSourceSettingActivity.setMusicSourceStatus(musicSourceSettingActivity.musicSource);
                    MusicSourceSettingActivity.this.dismissProgressDialog();
                    new Object[1][0] = apiError.getMessage();
                }
            });
        }
    }

    private void getMusicSource() {
        ApiHelper.getMusicSource(new ApiRequest.Listener<String>() {
            /* class com.xiaomi.mico.setting.MusicSourceSettingActivity.AnonymousClass3 */

            public void onSuccess(String str) {
                if (!TextUtils.isEmpty(str)) {
                    MusicSourceSettingActivity musicSourceSettingActivity = MusicSourceSettingActivity.this;
                    musicSourceSettingActivity.musicSource = str;
                    musicSourceSettingActivity.setMusicSourceStatus(str);
                    AccountProfile.current().setMusicSource(MusicSourceSettingActivity.this.musicSource);
                }
            }

            public void onFailure(ApiError apiError) {
                new Object[1][0] = apiError.getMessage();
            }
        });
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        dka.O000000o(i, i2, intent, new QQAuthUiListener());
    }
}

package com.xiaomi.mico.setting;

import _m_j.gsy;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.xiaomi.mico.api.ApiError;
import com.xiaomi.mico.api.ApiHelper;
import com.xiaomi.mico.api.ApiRequest;
import com.xiaomi.mico.api.model.MiBrain;
import com.xiaomi.mico.common.application.AccountProfile;
import com.xiaomi.mico.common.widget.QQMusicAuthPopupView;
import com.xiaomi.mico.common.widget.RadioItemLinearView;
import com.xiaomi.mico.common.widget.dialog.MLAlertDialog2;
import com.xiaomi.mico.music.cache.MusicCache;
import com.xiaomi.mico.music.manager.MusicSourceManager;
import com.xiaomi.smarthome.R;

public class MusicSourceSettingPopupView2 extends LinearLayout {
    private MLAlertDialog2 mDialog;
    RadioItemLinearView miSource;
    public String musicSource;
    RadioItemLinearView qqSource;

    public MusicSourceSettingPopupView2(Context context) {
        super(context);
    }

    public MusicSourceSettingPopupView2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MusicSourceSettingPopupView2(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        this.miSource = (RadioItemLinearView) findViewById(R.id.mi_music_source);
        this.miSource.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.setting.$$Lambda$MusicSourceSettingPopupView2$ieCcOZ2jLbajkusjJ4zNVVY0AE */

            public final void onClick(View view) {
                MusicSourceSettingPopupView2.this.lambda$onFinishInflate$0$MusicSourceSettingPopupView2(view);
            }
        });
        this.qqSource = (RadioItemLinearView) findViewById(R.id.qq_music_source);
        this.qqSource.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.setting.$$Lambda$MusicSourceSettingPopupView2$ZCSaj1e6cVhoC3TloVM5ur2wWJk */

            public final void onClick(View view) {
                MusicSourceSettingPopupView2.this.lambda$onFinishInflate$1$MusicSourceSettingPopupView2(view);
            }
        });
        findViewById(R.id.button_continue).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.setting.$$Lambda$MusicSourceSettingPopupView2$fxq7tq30q74MybYX5OdozjDJ7z8 */

            public final void onClick(View view) {
                MusicSourceSettingPopupView2.this.lambda$onFinishInflate$2$MusicSourceSettingPopupView2(view);
            }
        });
        initData();
    }

    public /* synthetic */ void lambda$onFinishInflate$2$MusicSourceSettingPopupView2(View view) {
        dismiss();
    }

    private void initData() {
        AccountProfile.MusicSuorce musicSource2 = AccountProfile.current().getMusicSource();
        if (musicSource2 != null) {
            this.musicSource = musicSource2.getSource();
        }
        setMusicSourceStatus(this.musicSource);
        getMusicSource();
    }

    public void setDialog(MLAlertDialog2 mLAlertDialog2) {
        this.mDialog = mLAlertDialog2;
        this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            /* class com.xiaomi.mico.setting.MusicSourceSettingPopupView2.AnonymousClass1 */

            public void onDismiss(DialogInterface dialogInterface) {
            }
        });
        this.mDialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
            /* class com.xiaomi.mico.setting.MusicSourceSettingPopupView2.AnonymousClass2 */

            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return i == 4 && keyEvent.getRepeatCount() == 0;
            }
        });
    }

    /* renamed from: onViewClicked */
    public void lambda$onFinishInflate$1$MusicSourceSettingPopupView2(View view) {
        int id = view.getId();
        if (id == R.id.mi_music_source) {
            setMusicSource(AccountProfile.MusicSuorce.MI.getSource());
        } else if (id == R.id.qq_music_source) {
            setMusicSource(AccountProfile.MusicSuorce.QQ.getSource());
        }
    }

    public static void showAlert(Context context) {
        MusicSourceSettingPopupView2 musicSourceSettingPopupView2 = (MusicSourceSettingPopupView2) LayoutInflater.from(context).inflate((int) R.layout.popup_view_music_source_setting2, (ViewGroup) null);
        MLAlertDialog2 create = new MLAlertDialog2.Builder(context).setView(musicSourceSettingPopupView2).create();
        create.setCanceledOnTouchOutside(false);
        musicSourceSettingPopupView2.setDialog(create);
        create.show();
    }

    public void dismiss() {
        MLAlertDialog2 mLAlertDialog2 = this.mDialog;
        if (mLAlertDialog2 != null && mLAlertDialog2.isShowing()) {
            this.mDialog.dismiss();
            this.mDialog = null;
        }
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

    private void setMusicSource(final String str) {
        if (!str.equalsIgnoreCase(this.musicSource)) {
            setMusicSourceStatus(str);
            ApiHelper.setMusicSource(str, new ApiRequest.Listener<Boolean>() {
                /* class com.xiaomi.mico.setting.MusicSourceSettingPopupView2.AnonymousClass3 */

                public void onSuccess(Boolean bool) {
                    if (bool.booleanValue()) {
                        MusicSourceSettingPopupView2 musicSourceSettingPopupView2 = MusicSourceSettingPopupView2.this;
                        musicSourceSettingPopupView2.musicSource = str;
                        musicSourceSettingPopupView2.setMusicSourceStatus(musicSourceSettingPopupView2.musicSource);
                        AccountProfile.current().setMusicSource(MusicSourceSettingPopupView2.this.musicSource);
                        MusicCache.clearCache();
                        MusicSourceManager.sendMusicSourceChange(MusicSourceSettingPopupView2.this.musicSource);
                        if (AccountProfile.MusicSuorce.QQ.getSource().equalsIgnoreCase(MusicSourceSettingPopupView2.this.musicSource)) {
                            AccountProfile.current().syncQQBindStatus(new ApiRequest.Listener<MiBrain.CPBindStatus>() {
                                /* class com.xiaomi.mico.setting.MusicSourceSettingPopupView2.AnonymousClass3.AnonymousClass1 */

                                public void onFailure(ApiError apiError) {
                                }

                                public void onSuccess(MiBrain.CPBindStatus cPBindStatus) {
                                    if (AccountProfile.current().isQQAccountNotBinded()) {
                                        QQMusicAuthPopupView.showAuthAlert(MusicSourceSettingPopupView2.this.getContext());
                                    } else if (AccountProfile.current().isQQAccountAuthValid()) {
                                        MusicSourceSettingPopupView2.this.dismiss();
                                    } else {
                                        QQMusicAuthPopupView.showAuthAlert(MusicSourceSettingPopupView2.this.getContext(), cPBindStatus);
                                    }
                                }
                            });
                        } else {
                            MusicSourceSettingPopupView2.this.dismiss();
                        }
                    }
                }

                public void onFailure(ApiError apiError) {
                    MusicSourceSettingPopupView2 musicSourceSettingPopupView2 = MusicSourceSettingPopupView2.this;
                    musicSourceSettingPopupView2.setMusicSourceStatus(musicSourceSettingPopupView2.musicSource);
                    new Object[1][0] = apiError.getMessage();
                    gsy.O00000Oo(12000, "12000.4.1", "remote fail");
                }
            });
        }
    }

    private void getMusicSource() {
        ApiHelper.getMusicSource(new ApiRequest.Listener<String>() {
            /* class com.xiaomi.mico.setting.MusicSourceSettingPopupView2.AnonymousClass4 */

            public void onSuccess(String str) {
                if (!TextUtils.isEmpty(str)) {
                    MusicSourceSettingPopupView2 musicSourceSettingPopupView2 = MusicSourceSettingPopupView2.this;
                    musicSourceSettingPopupView2.musicSource = str;
                    musicSourceSettingPopupView2.setMusicSourceStatus(str);
                    AccountProfile.current().setMusicSource(MusicSourceSettingPopupView2.this.musicSource);
                }
            }

            public void onFailure(ApiError apiError) {
                new Object[1][0] = apiError.getMessage();
            }
        });
    }
}

package com.xiaomi.mico.common.widget;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import butterknife.ButterKnife;
import com.xiaomi.mico.api.ApiError;
import com.xiaomi.mico.api.ApiHelper;
import com.xiaomi.mico.api.ApiRequest;
import com.xiaomi.mico.api.model.MiBrain;
import com.xiaomi.mico.common.application.AccountProfile;
import com.xiaomi.mico.common.util.DisplayUtils;
import com.xiaomi.mico.common.util.ToastUtil;
import com.xiaomi.mico.music.manager.MusicSourceManager;
import com.xiaomi.smarthome.R;

public class MusicSourceSettingPopupView extends LinearLayout {
    View continueView;
    private AlertDialog mDialog;
    RadioItemLinearView miSource;
    RadioItemLinearView qqSource;

    public MusicSourceSettingPopupView(Context context) {
        super(context);
    }

    public MusicSourceSettingPopupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MusicSourceSettingPopupView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this);
    }

    public void setDialog(AlertDialog alertDialog) {
        this.mDialog = alertDialog;
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.mi_music_source) {
            this.miSource.setChecked(Boolean.TRUE);
            this.qqSource.setChecked(Boolean.FALSE);
        } else if (id == R.id.qq_music_source) {
            this.qqSource.setChecked(Boolean.TRUE);
            this.miSource.setChecked(Boolean.FALSE);
        } else if (id == R.id.button_continue) {
            String str = null;
            if (this.miSource.isChecked()) {
                str = AccountProfile.MusicSuorce.MI.getSource();
            } else if (this.qqSource.isChecked()) {
                str = AccountProfile.MusicSuorce.QQ.getSource();
            }
            if (str != null) {
                setMusicSource(str);
            } else {
                ToastUtil.showToast((int) R.string.music_source_selection_tip);
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.graphics.drawable.InsetDrawable.<init>(android.graphics.drawable.Drawable, int):void}
     arg types: [android.graphics.drawable.ColorDrawable, int]
     candidates:
      ClspMth{android.graphics.drawable.InsetDrawable.<init>(android.graphics.drawable.Drawable, float):void}
      ClspMth{android.graphics.drawable.InsetDrawable.<init>(android.graphics.drawable.Drawable, int):void} */
    public static void show(Context context) {
        MusicSourceSettingPopupView musicSourceSettingPopupView = (MusicSourceSettingPopupView) LayoutInflater.from(context).inflate((int) R.layout.popup_view_music_source_setting, (ViewGroup) null);
        musicSourceSettingPopupView.findViewById(R.id.mi_music_source).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.common.widget.$$Lambda$MusicSourceSettingPopupView$ZS2tpahxIyvEhvzC2UGQMb1n_ZE */

            public final void onClick(View view) {
                MusicSourceSettingPopupView.this.onClick(view);
            }
        });
        musicSourceSettingPopupView.findViewById(R.id.qq_music_source).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.common.widget.$$Lambda$MusicSourceSettingPopupView$7ZehcGjAlFdopDFrZfuBmfOybao */

            public final void onClick(View view) {
                MusicSourceSettingPopupView.this.onClick(view);
            }
        });
        musicSourceSettingPopupView.findViewById(R.id.button_continue).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.common.widget.$$Lambda$MusicSourceSettingPopupView$b5DIF4wRb7fRiY4S4UCxQjB1vU */

            public final void onClick(View view) {
                MusicSourceSettingPopupView.this.onClick(view);
            }
        });
        musicSourceSettingPopupView.miSource = (RadioItemLinearView) musicSourceSettingPopupView.findViewById(R.id.mi_music_source);
        musicSourceSettingPopupView.qqSource = (RadioItemLinearView) musicSourceSettingPopupView.findViewById(R.id.qq_music_source);
        musicSourceSettingPopupView.continueView = musicSourceSettingPopupView.findViewById(R.id.button_continue);
        AlertDialog create = new AlertDialog.Builder(context).setView(musicSourceSettingPopupView).create();
        musicSourceSettingPopupView.setDialog(create);
        create.getWindow().setBackgroundDrawable(new InsetDrawable((Drawable) new ColorDrawable(0), DisplayUtils.dip2px(context, 34.0f)));
        create.setCanceledOnTouchOutside(false);
        create.setOnKeyListener(new DialogInterface.OnKeyListener() {
            /* class com.xiaomi.mico.common.widget.MusicSourceSettingPopupView.AnonymousClass1 */

            public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (i != 4 || keyEvent.getRepeatCount() != 0) {
                    return false;
                }
                ToastUtil.showToast((int) R.string.music_source_setting_tip);
                return true;
            }
        });
        create.show();
    }

    public void dismiss() {
        AlertDialog alertDialog = this.mDialog;
        if (alertDialog != null && alertDialog.isShowing()) {
            this.mDialog.dismiss();
        }
    }

    private void setMusicSource(final String str) {
        this.continueView.setEnabled(false);
        ApiHelper.setMusicSource(str, new ApiRequest.Listener<Boolean>() {
            /* class com.xiaomi.mico.common.widget.MusicSourceSettingPopupView.AnonymousClass2 */

            public void onSuccess(Boolean bool) {
                AccountProfile.current().setMusicSource(str);
                MusicSourceManager.sendMusicSourceChange(str);
                if (AccountProfile.MusicSuorce.QQ.getSource().equalsIgnoreCase(str)) {
                    MusicSourceSettingPopupView.this.checkQQMusicBindStetus();
                } else if (AccountProfile.MusicSuorce.MI.getSource().equalsIgnoreCase(str)) {
                    MusicSourceSettingPopupView.this.dismiss();
                }
            }

            public void onFailure(ApiError apiError) {
                new Object[1][0] = apiError.getMessage();
                MusicSourceSettingPopupView.this.continueView.setEnabled(true);
            }
        });
    }

    public void checkQQMusicBindStetus() {
        AccountProfile.current().syncQQBindStatus(new ApiRequest.Listener<MiBrain.CPBindStatus>() {
            /* class com.xiaomi.mico.common.widget.MusicSourceSettingPopupView.AnonymousClass3 */

            public void onSuccess(MiBrain.CPBindStatus cPBindStatus) {
                if (AccountProfile.current().isQQAccountNotBinded()) {
                    QQMusicAuthPopupView.showAuthAlert(MusicSourceSettingPopupView.this.getContext());
                } else {
                    QQMusicAuthPopupView.showAuthAlert(MusicSourceSettingPopupView.this.getContext(), cPBindStatus);
                }
                MusicSourceSettingPopupView.this.dismiss();
            }

            public void onFailure(ApiError apiError) {
                new Object[1][0] = apiError.getMessage();
                MusicSourceSettingPopupView.this.dismiss();
            }
        });
    }

    private void showAuthQQMusic() {
        QQMusicAuthPopupView.showAuthAlert(getContext());
    }
}

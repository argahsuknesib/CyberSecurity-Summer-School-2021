package com.xiaomi.mico.common.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.Window;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.xiaomi.mico.api.model.Music;
import com.xiaomi.mico.common.util.DisplayUtils;
import com.xiaomi.mico.setting.MusicAccountAuthInfoActivity;
import com.xiaomi.smarthome.R;

public class OpenQQMusicVipPopupView extends ConstraintLayout {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    static /* synthetic */ void lambda$showOpenVipPopupView$1(View view) {
    }

    public OpenQQMusicVipPopupView(Context context) {
        super(context);
    }

    public OpenQQMusicVipPopupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public OpenQQMusicVipPopupView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.graphics.drawable.InsetDrawable.<init>(android.graphics.drawable.Drawable, int):void}
     arg types: [android.graphics.drawable.ColorDrawable, int]
     candidates:
      ClspMth{android.graphics.drawable.InsetDrawable.<init>(android.graphics.drawable.Drawable, float):void}
      ClspMth{android.graphics.drawable.InsetDrawable.<init>(android.graphics.drawable.Drawable, int):void} */
    public static boolean showOpenVipPopupView(Music.Song song, Context context) {
        boolean needToBeVip = song.needToBeVip();
        if (needToBeVip) {
            Dialog dialog = new Dialog(context);
            dialog.setContentView((int) R.layout.popup_view_open_vip);
            dialog.setCancelable(true);
            dialog.setCanceledOnTouchOutside(true);
            Window window = dialog.getWindow();
            window.setGravity(17);
            window.setBackgroundDrawable(new InsetDrawable((Drawable) new ColorDrawable(0), DisplayUtils.dip2px(context, 0.0f)));
            View decorView = window.getDecorView();
            decorView.findViewById(R.id.rootView).setOnClickListener(new View.OnClickListener(dialog) {
                /* class com.xiaomi.mico.common.widget.$$Lambda$OpenQQMusicVipPopupView$nPqLCUtST_1UV0Fn2jG4g2idYE */
                private final /* synthetic */ Dialog f$0;

                {
                    this.f$0 = r1;
                }

                public final void onClick(View view) {
                    this.f$0.dismiss();
                }
            });
            decorView.findViewById(R.id.dialogBg).setOnClickListener($$Lambda$OpenQQMusicVipPopupView$3UM1xeEqkIvTOiduBSkj39z1mHw.INSTANCE);
            decorView.findViewById(R.id.tvOpenInstantly).setOnClickListener(new View.OnClickListener(context) {
                /* class com.xiaomi.mico.common.widget.$$Lambda$OpenQQMusicVipPopupView$bMZKmWfZcUuNLlwqMLedNZvUDA */
                private final /* synthetic */ Context f$0;

                {
                    this.f$0 = r1;
                }

                public final void onClick(View view) {
                    MusicAccountAuthInfoActivity.start(this.f$0, "", "弹窗");
                }
            });
            dialog.show();
        }
        return needToBeVip;
    }
}

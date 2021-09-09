package com.xiaomi.smarthome.newui.adapter;

import _m_j.fbs;
import _m_j.fbt;
import _m_j.hbb;
import _m_j.iwc;
import _m_j.ixe;
import _m_j.ixh;
import _m_j.iyo;
import android.app.Dialog;
import android.content.Context;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.newui.adapter.FavoriteCameraCardAdapter;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "Landroid/widget/TextView;", "dialog", "Landroid/app/Dialog;"}, k = 3, mv = {1, 5, 1}, xi = 48)
final class FavoriteCameraCardAdapter$VH$showConnectHelperDialog$getContentView$1 extends Lambda implements iwc<Dialog, TextView> {
    final /* synthetic */ Context $context;
    final /* synthetic */ FavoriteCameraCardAdapter.O0000O0o this$0;
    final /* synthetic */ FavoriteCameraCardAdapter this$1;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FavoriteCameraCardAdapter$VH$showConnectHelperDialog$getContentView$1(Context context, FavoriteCameraCardAdapter.O0000O0o o0000O0o, FavoriteCameraCardAdapter favoriteCameraCardAdapter) {
        super(1);
        this.$context = context;
        this.this$0 = o0000O0o;
        this.this$1 = favoriteCameraCardAdapter;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.iyx.O000000o(java.lang.CharSequence, java.lang.String, int, boolean, int):int
     arg types: [java.lang.String, java.lang.String, int, int, int]
     candidates:
      _m_j.iyx.O000000o(java.lang.CharSequence, java.lang.CharSequence, int, int, boolean):boolean
      _m_j.iyw.O000000o(java.lang.String, java.lang.String, int, int, boolean):boolean
      _m_j.iyx.O000000o(java.lang.CharSequence, java.lang.String, int, boolean, int):int */
    public final /* synthetic */ Object invoke(Object obj) {
        final Dialog dialog = (Dialog) obj;
        ixe.O00000o(dialog, "dialog");
        String obj2 = this.$context.getResources().getText(R.string.mj_camera_card_error_dialog_help_msg_main).toString();
        String obj3 = this.$context.getResources().getText(R.string.mj_camera_card_error_dialog_help_msg_sub1).toString();
        String obj4 = this.$context.getResources().getText(R.string.mj_camera_card_error_dialog_help_msg_sub2).toString();
        ixh ixh = ixh.f1644O000000o;
        String format = String.format(obj2, Arrays.copyOf(new Object[]{obj3, obj4}, 2));
        ixe.O00000Oo(format, "java.lang.String.format(format, *args)");
        SpannableString spannableString = new SpannableString(format);
        String spannableString2 = spannableString.toString();
        ixe.O00000Oo(spannableString2, "spannable.toString()");
        int O000000o2 = iyo.O000000o((CharSequence) spannableString2, obj3, 0, false, 6);
        final FavoriteCameraCardAdapter.O0000O0o o0000O0o = this.this$0;
        final FavoriteCameraCardAdapter favoriteCameraCardAdapter = this.this$1;
        spannableString.setSpan(new ClickableSpan() {
            /* class com.xiaomi.smarthome.newui.adapter.FavoriteCameraCardAdapter$VH$showConnectHelperDialog$getContentView$1.AnonymousClass1 */

            public final void onClick(View view) {
                ixe.O00000o(view, "view");
                dialog.dismiss();
                if (FavoriteCameraCardAdapter.O0000O0o.O000000o(o0000O0o, 60000, 2) && o0000O0o.O000000o(false)) {
                    o0000O0o.O00000oO.setVisibility(4);
                    favoriteCameraCardAdapter.O0000o0.remove(o0000O0o.O00000o0());
                }
            }
        }, O000000o2, obj3.length() + O000000o2, 33);
        String spannableString3 = spannableString.toString();
        ixe.O00000Oo(spannableString3, "spannable.toString()");
        int O000000o3 = iyo.O000000o((CharSequence) spannableString3, obj4, 0, false, 6);
        final FavoriteCameraCardAdapter.O0000O0o o0000O0o2 = this.this$0;
        spannableString.setSpan(new ClickableSpan() {
            /* class com.xiaomi.smarthome.newui.adapter.FavoriteCameraCardAdapter$VH$showConnectHelperDialog$getContentView$1.AnonymousClass2 */

            public final void onClick(View view) {
                ixe.O00000o(view, "view");
                dialog.dismiss();
                fbt fbt = new fbt(view.getContext(), "/userCenter/FeedbackActivity");
                MainCameraCardModel mainCameraCardModel = o0000O0o2.O0000O0o;
                fbt.O000000o("extra_device_model", mainCameraCardModel == null ? null : mainCameraCardModel.O00000Oo);
                fbs.O000000o(fbt);
            }
        }, O000000o3, obj4.length() + O000000o3, 33);
        TextView textView = new TextView(this.$context);
        textView.setText(spannableString);
        textView.setTextColor(this.$context.getResources().getColor(R.color.mj_color_gray_normal));
        textView.setTextAlignment(5);
        textView.setTextSize(14.0f);
        textView.setHighlightColor(this.$context.getResources().getColor(R.color.mj_color_green_normal));
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -2);
        marginLayoutParams.leftMargin = hbb.O000000o(42.0f);
        marginLayoutParams.rightMargin = hbb.O000000o(42.0f);
        textView.setLayoutParams(marginLayoutParams);
        return textView;
    }
}

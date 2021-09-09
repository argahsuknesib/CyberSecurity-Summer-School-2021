package _m_j;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;

public final class exq {
    public static Dialog O000000o(final AppCompatActivity appCompatActivity) {
        MLAlertDialog O00000o = new MLAlertDialog.Builder(appCompatActivity).O00000Oo(false).O000000o(true).O000000o(new DialogInterface.OnCancelListener() {
            /* class _m_j.exq.AnonymousClass4 */

            public final void onCancel(DialogInterface dialogInterface) {
                dialogInterface.dismiss();
                hxi.O00000o.f952O000000o.O000000o("home_score_close", new Object[0]);
            }
        }).O000000o((int) R.string.comment_for_mihome_title).O00000Oo((int) R.string.give_advice, new DialogInterface.OnClickListener() {
            /* class _m_j.exq.AnonymousClass3 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                fbt fbt = new fbt(CommonApplication.getAppContext(), "/userCenter/FeedbackActivity");
                fbt.O000000o("extra_device_model", "exp");
                fbt.O000000o("extra_source", 0);
                fbt.O00000Oo(268435456);
                fbs.O000000o(fbt);
                hxi.O00000o.f952O000000o.O000000o("home_score_cancel", new Object[0]);
            }
        }).O000000o((int) R.string.like_it_btn, new DialogInterface.OnClickListener() {
            /* class _m_j.exq.AnonymousClass2 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                boolean z;
                try {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    String O00000Oo = goy.O00000Oo(appCompatActivity);
                    if (!TextUtils.isEmpty(O00000Oo)) {
                        intent.setPackage(O00000Oo);
                    }
                    intent.addFlags(268435456);
                    intent.setData(Uri.parse("market://details?id=" + appCompatActivity.getPackageName()));
                    if (intent.resolveActivity(appCompatActivity.getPackageManager()) != null) {
                        appCompatActivity.startActivity(intent);
                    } else {
                        intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=" + appCompatActivity.getPackageName()));
                        if (intent.resolveActivity(appCompatActivity.getPackageManager()) != null) {
                            appCompatActivity.startActivity(intent);
                        }
                    }
                    z = true;
                } catch (Exception unused) {
                    z = false;
                }
                if (z) {
                    hxi.O00000o.f952O000000o.O000000o("home_score_into", new Object[0]);
                }
                dialogInterface.dismiss();
            }
        }).O00000o();
        TextView textView = new TextView(appCompatActivity);
        textView.setText((int) R.string.comment_for_mihome_detail_international);
        textView.setTextColor(appCompatActivity.getResources().getColor(R.color.mj_color_gray_normal));
        textView.setLineSpacing(0.0f, 1.0f);
        O00000o.setView(textView, gpc.O000000o(20.0f), gpc.O000000o(5.0f) * -1, gpc.O000000o(20.0f), gpc.O000000o(10.0f));
        if (gqd.O000000o((Activity) appCompatActivity)) {
            O00000o.show();
            String O0000o0 = CoreApi.O000000o().O0000o0();
            if (!TextUtils.isEmpty(O0000o0)) {
                SharedPreferences.Editor edit = CommonApplication.getAppContext().getSharedPreferences("com.xiaomi.mihome.enter".concat(String.valueOf(O0000o0)), 0).edit();
                edit.putLong("mihome_enter_main_page_intl_shown_ts", System.currentTimeMillis());
                edit.putInt("mihome_enter_main_page_intl", 0);
                edit.apply();
            }
            hxi.O00000oO.f958O000000o.O000000o("home_score_popup", new Object[0]);
        }
        return O00000o;
    }
}

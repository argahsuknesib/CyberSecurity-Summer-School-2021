package _m_j;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.sankuai.waimai.router.annotation.RouterService;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.frame.server_compact.ServerBean;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import java.util.Locale;

@RouterService
public class gfs implements gfu {
    private static final gfs INSTANCE = new gfs();

    public ez getLifecycleObserver() {
        return null;
    }

    public boolean refreshToken(String str) {
        return false;
    }

    @cug
    public static gfs provideInstance() {
        return INSTANCE;
    }

    public Fragment createGlobalShopFragment() {
        gsy.O000000o(3, "GlobalShopApiImpl", "getFragment");
        return new htg();
    }

    public Class<? extends Fragment> getFragmentClass() {
        return htg.class;
    }

    public boolean isShowGlobalShop(ServerBean serverBean) {
        return hth.O00000Oo(serverBean);
    }

    public boolean isShowGlobalShop(Context context) {
        return hth.O000000o(context);
    }

    public String getLocaleFromSDK(Context context) {
        return hth.O00000Oo(context);
    }

    public String getLocaleFromSDK(String str) {
        return hth.O000000o(str);
    }

    public void onLogout() {
        hth.O000000o();
    }

    public void onLoginSuccess() {
        hth.O00000Oo();
    }

    public void onChangeServer(ServerBean serverBean) {
        hth.O00000o0(serverBean);
    }

    public void initMiShopGlobalSDK(boolean z) {
        hth.O000000o(z);
    }

    public boolean preFetchSidToken() {
        return hth.O00000o0();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gpy.O00000o0(android.content.Context, java.lang.String, java.lang.String, boolean):boolean
     arg types: [android.content.Context, java.lang.String, java.lang.String, int]
     candidates:
      _m_j.gpy.O00000o0(android.content.Context, java.lang.String, java.lang.String, java.lang.String):java.lang.String
      _m_j.gpy.O00000o0(android.content.Context, java.lang.String, java.lang.String, boolean):boolean */
    public boolean showPrivacyDiaglogIfNeed(Activity activity, View view) {
        try {
            Context appContext = CommonApplication.getAppContext();
            if (gpy.O00000o0(appContext, "prefs_disclaim", "is_show_global_shop_disclaim_" + ftn.O000000o(CommonApplication.getAppContext()).O00000Oo, true)) {
                byl.O000000o(false, hth.f619O000000o.get(ftn.O000000o(CommonApplication.getAppContext()).O00000Oo));
                showGlobalPrivacyDialog(activity, view, true);
                return true;
            }
            byl.O000000o(true, hth.f619O000000o.get(ftn.O000000o(activity).O00000Oo));
            if (!gox.O000000o(activity, "android.permission.READ_PHONE_STATE")) {
                byl.O0000Oo0 = true;
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void showGlobalPrivacyDialog(final Activity activity, View view, final boolean z) {
        String str;
        MLAlertDialog.Builder builder = new MLAlertDialog.Builder(activity);
        if (z) {
            str = activity.getString(R.string.device_shop_global);
        } else {
            str = activity.getString(R.string.bbs);
        }
        String string = activity.getString(R.string.shop_global_privacy_msg, new Object[]{str});
        int indexOf = string.indexOf("#start#");
        int indexOf2 = string.indexOf("#end#") - 7;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) string.replace("#start#", "").replace("#end#", ""));
        AnonymousClass1 r1 = new ClickableSpan() {
            /* class _m_j.gfs.AnonymousClass1 */

            public final void onClick(View view) {
                Uri uri;
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                Locale O00000o02 = ftn.O00000o0(activity);
                if (gwc.O000000o(Locale.US, O00000o02) || gwc.O000000o(gwc.O0000Oo, O00000o02)) {
                    if (ftn.O0000Oo(activity)) {
                        O00000o02 = new Locale("en", "IN");
                    } else if (ftn.O0000OoO(activity)) {
                        O00000o02 = gwc.O0000Oo;
                    }
                }
                if (z) {
                    ServerBean O000000o2 = ftn.O000000o(activity);
                    if (O000000o2 == null) {
                        uri = Uri.parse("https://privacy.mi.com/all/".concat(String.valueOf(O00000o02)));
                    } else {
                        uri = Uri.parse(hth.O000000o(O000000o2));
                    }
                } else {
                    uri = Uri.parse("https://privacy.mi.com/all/".concat(String.valueOf(O00000o02)));
                }
                intent.setData(uri);
                activity.startActivity(intent);
            }

            public final void updateDrawState(TextPaint textPaint) {
                super.updateDrawState(textPaint);
                textPaint.setColor(Color.parseColor("#FF527ACC"));
                textPaint.setUnderlineText(false);
            }
        };
        if (indexOf >= 0 && indexOf2 > 0) {
            try {
                spannableStringBuilder.setSpan(r1, indexOf, indexOf2, 33);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        builder.O000000o((int) R.string.dialog_privacy_title).O000000o(spannableStringBuilder).O000000o((int) R.string.license_positive_btn, new DialogInterface.OnClickListener(z, activity, view) {
            /* class _m_j.$$Lambda$gfs$lxJqSe7VehdoXypgA6dgFlpJnZQ */
            private final /* synthetic */ boolean f$0;
            private final /* synthetic */ Activity f$1;
            private final /* synthetic */ View f$2;

            {
                this.f$0 = r1;
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                gfs.lambda$showGlobalPrivacyDialog$0(this.f$0, this.f$1, this.f$2, dialogInterface, i);
            }
        }).O00000Oo((int) R.string.license_negative_btn, $$Lambda$gfs$f1Atg__S0J7OvBRc7pFBN6poKJg.INSTANCE);
        MLAlertDialog O00000o = builder.O00000o();
        O00000o.setCancelable(false);
        O00000o.show();
        if (z) {
            hxi.O00000oO.O00000Oo();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, boolean):void
     arg types: [android.content.Context, java.lang.String, java.lang.String, int]
     candidates:
      _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, float):float
      _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, int):int
      _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, long):void
      _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, java.lang.String):void
      _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, boolean):void */
    static /* synthetic */ void lambda$showGlobalPrivacyDialog$0(boolean z, Activity activity, View view, DialogInterface dialogInterface, int i) {
        if (z) {
            Context applicationContext = activity.getApplicationContext();
            gpy.O000000o(applicationContext, "prefs_disclaim", "is_show_global_shop_disclaim_" + ftn.O000000o(CommonApplication.getAppContext()).O00000Oo, false);
            hxi.O00000o.O0000o0();
        } else {
            Context applicationContext2 = activity.getApplicationContext();
            gpy.O000000o(applicationContext2, "prefs_disclaim", "is_show_global_bbs_disclaim_" + ftn.O000000o(CommonApplication.getAppContext()).O00000Oo, false);
        }
        if (!gox.O000000o(activity, "android.permission.READ_PHONE_STATE")) {
            byl.O0000Oo0 = true;
        }
        view.performClick();
        dialogInterface.dismiss();
    }

    public void setCanCheckPermission(boolean z) {
        byl.O0000Oo0 = z;
    }
}

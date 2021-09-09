package com.google.android.gms.common.internal;

import _m_j.bf;
import _m_j.c;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.AccountPicker;
import com.google.android.gms.common.GoogleSignatureVerifier;
import com.google.android.gms.common.api.Scope;
import java.util.Locale;

public class GmsIntents {
    private static final Uri zztz;
    private static final Uri zzua;

    static {
        Uri parse = Uri.parse("https://plus.google.com/");
        zztz = parse;
        zzua = parse.buildUpon().appendPath("circles").appendPath("find").build();
    }

    private GmsIntents() {
    }

    public static Intent createAndroidWearUpdateIntent() {
        Intent intent = new Intent("com.google.android.clockwork.home.UPDATE_ANDROID_WEAR_ACTION");
        intent.setPackage("com.google.android.wearable.app");
        return intent;
    }

    public static Intent createChooseGmsAccountIntent() {
        return AccountPicker.newChooseAccountIntent(null, null, new String[]{"com.google"}, true, null, null, null, null, true);
    }

    public static Intent createChooseGmsAccountWithConsentIntent(String str, Scope[] scopeArr, boolean z) {
        Intent intent = new Intent("com.google.android.gms.signin.action.SIGN_IN");
        intent.putExtra("SIGN_IN_PACKAGE_NAME", str);
        intent.putExtra("SIGN_IN_SCOPE_ARRAY", scopeArr);
        intent.putExtra("SIGN_IN_SAVE_DEFAULT_ACCOUNT", z);
        return intent;
    }

    public static Intent createDateSettingsIntent() {
        return new Intent("android.settings.DATE_SETTINGS");
    }

    public static Intent createFindPeopleIntent(Context context) {
        return zza(context, zzua);
    }

    public static Intent createPlayStoreGamesIntent(Context context) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("http://play.google.com/store/apps/category/GAME"));
        intent.addFlags(524288);
        intent.setPackage("com.android.vending");
        if (context.getPackageManager().resolveActivity(intent, 65536) != null) {
            return intent;
        }
        Intent intent2 = new Intent(intent.getAction(), intent.getData());
        intent2.setFlags(intent.getFlags());
        return intent2;
    }

    public static Intent createPlayStoreIntent(String str) {
        return createPlayStoreIntent(str, null);
    }

    public static Intent createPlayStoreIntent(String str, String str2) {
        Intent intent = new Intent("android.intent.action.VIEW");
        Uri.Builder appendQueryParameter = Uri.parse("market://details").buildUpon().appendQueryParameter("id", str);
        if (!TextUtils.isEmpty(str2)) {
            appendQueryParameter.appendQueryParameter("pcampaignid", str2);
        }
        intent.setData(appendQueryParameter.build());
        intent.setPackage("com.android.vending");
        intent.addFlags(524288);
        return intent;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{android.content.Intent.putExtra(java.lang.String, int):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, int[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Bundle):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.io.Serializable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent} */
    public static Intent createPlayStoreLightPurchaseFlowIntent(Context context, String str, String str2) {
        Intent intent = new Intent("com.android.vending.billing.PURCHASE");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setPackage("com.android.vending");
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("authAccount", str);
        }
        intent.putExtra("backend", 3);
        intent.putExtra("document_type", 1);
        intent.putExtra("full_docid", str2);
        intent.putExtra("backend_docid", str2);
        intent.putExtra("offer_type", 1);
        if (isIntentResolvable(context.getPackageManager(), intent)) {
            return intent;
        }
        Intent intent2 = new Intent("android.intent.action.VIEW");
        intent2.setData(Uri.parse(String.format(Locale.US, "https://play.google.com/store/apps/details?id=%1$s&rdid=%1$s&rdot=%2$d", str2, 1)));
        intent2.setPackage("com.android.vending");
        intent2.putExtra("use_direct_purchase", true);
        return intent2;
    }

    public static Intent createSettingsIntent(String str) {
        Uri fromParts = Uri.fromParts("package", str, null);
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(fromParts);
        return intent;
    }

    public static Intent createShowProfileIntent(Context context, String str) {
        return zza(context, Uri.parse(String.format("https://plus.google.com/%s/about", str)));
    }

    public static Intent getFitnessAppDisconnectedIntent(String str, String str2) {
        Intent intent = new Intent();
        intent.setPackage("com.google.android.gms");
        intent.setAction("com.google.android.gms.fitness.app_disconnected");
        intent.setType("vnd.google.android.fitness/app_disconnect");
        intent.putExtra("com.google.android.gms.fitness.disconnected_app", str);
        intent.putExtra("com.google.android.gms.fitness.disconnected_account", str2);
        return intent;
    }

    public static Uri getPlayStoreUri(String str) {
        return Uri.parse("https://play.google.com/store/apps/details").buildUpon().appendQueryParameter("id", str).build();
    }

    public static boolean isIntentResolvable(PackageManager packageManager, Intent intent) {
        return packageManager.resolveActivity(intent, 65536) != null;
    }

    public static void sendIcingContactChangedBroadcast(Context context, boolean z) {
        Intent putExtra = new Intent("com.google.android.gms.icing.action.CONTACT_CHANGED").setPackage("com.google.android.gms").putExtra("com.google.android.gms.icing.extra.isSignificant", z);
        if (Log.isLoggable("GmsIntents", 2)) {
            String action = putExtra.getAction();
            StringBuilder sb = new StringBuilder(String.valueOf(action).length() + 98);
            sb.append("Icing detected contact change, broadcasting it with intent action: ");
            sb.append(action);
            sb.append(" and isSignificant extra: ");
            sb.append(z);
            Log.v("GmsIntents", sb.toString());
        }
        context.sendBroadcast(putExtra);
    }

    public static void sendSetGmsAccountIntent(Context context, String str, String str2) {
        Intent intent = new Intent("com.google.android.gms.common.SET_GMS_ACCOUNT");
        intent.putExtra("ACCOUNT_NAME", str);
        intent.putExtra("PACKAGE_NAME", str2);
        intent.setPackage("com.google.android.gms");
        context.sendBroadcast(intent, "com.google.android.gms.permission.INTERNAL_BROADCAST");
    }

    public static void sendUdcSettingsChangedBroadcast(Context context, String str, int[] iArr) {
        zza("com.google.android.gms", context, str, iArr);
        if (GoogleSignatureVerifier.getInstance(context).isPackageGoogleSigned("com.google.android.googlequicksearchbox")) {
            zza("com.google.android.googlequicksearchbox", context, str, iArr);
        } else if (Log.isLoggable("GmsIntents", 5)) {
            Log.w("GmsIntents", "Google now certificate not valid. UDC settings broadcast will not be sent.");
        }
    }

    private static Intent zza(Context context, Uri uri) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        intent.setPackage("com.google.android.apps.plus");
        return isIntentResolvable(context.getPackageManager(), intent) ? intent : createPlayStoreIntent("com.google.android.apps.plus");
    }

    private static void zza(String str, Context context, String str2, int[] iArr) {
        Intent putExtra = new Intent("com.google.android.gms.udc.action.SETTING_CHANGED").setPackage(str).putExtra("com.google.android.gms.udc.extra.accountName", str2).putExtra("com.google.android.gms.udc.extra.settingIdList", iArr);
        if (Log.isLoggable("GmsIntents", 3)) {
            String action = putExtra.getAction();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 72 + String.valueOf(action).length());
            sb.append("UDC settings changed, sending broadcast to package ");
            sb.append(str);
            sb.append(" with intent action: ");
            sb.append(action);
            Log.d("GmsIntents", sb.toString());
        }
        context.sendBroadcast(putExtra);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence):android.content.Intent}
     arg types: [java.lang.String, java.lang.String]
     candidates:
      ClspMth{android.content.Intent.putExtra(java.lang.String, int):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, int[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Bundle):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.io.Serializable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence):android.content.Intent} */
    public static Intent createShareOnPlusIntent(Activity activity, String str, String str2) {
        c.O000000o o000000o = new c.O000000o((Context) bf.O000000o(activity), activity.getComponentName());
        o000000o.f13508O000000o.putExtra("android.intent.extra.SUBJECT", str);
        o000000o.f13508O000000o.putExtra("android.intent.extra.TEXT", (CharSequence) str2);
        o000000o.f13508O000000o.setType("text/plain");
        if (o000000o.O00000Oo != null) {
            o000000o.O000000o("android.intent.extra.EMAIL", o000000o.O00000Oo);
            o000000o.O00000Oo = null;
        }
        if (o000000o.O00000o0 != null) {
            o000000o.O000000o("android.intent.extra.CC", o000000o.O00000o0);
            o000000o.O00000o0 = null;
        }
        if (o000000o.O00000o != null) {
            o000000o.O000000o("android.intent.extra.BCC", o000000o.O00000o);
            o000000o.O00000o = null;
        }
        boolean z = true;
        if (o000000o.O00000oO == null || o000000o.O00000oO.size() <= 1) {
            z = false;
        }
        boolean equals = "android.intent.action.SEND_MULTIPLE".equals(o000000o.f13508O000000o.getAction());
        if (!z && equals) {
            o000000o.f13508O000000o.setAction("android.intent.action.SEND");
            if (o000000o.O00000oO == null || o000000o.O00000oO.isEmpty()) {
                o000000o.f13508O000000o.removeExtra("android.intent.extra.STREAM");
            } else {
                o000000o.f13508O000000o.putExtra("android.intent.extra.STREAM", o000000o.O00000oO.get(0));
            }
            o000000o.O00000oO = null;
        }
        if (z && !equals) {
            o000000o.f13508O000000o.setAction("android.intent.action.SEND_MULTIPLE");
            if (o000000o.O00000oO == null || o000000o.O00000oO.isEmpty()) {
                o000000o.f13508O000000o.removeExtra("android.intent.extra.STREAM");
            } else {
                o000000o.f13508O000000o.putParcelableArrayListExtra("android.intent.extra.STREAM", o000000o.O00000oO);
            }
        }
        Intent intent = o000000o.f13508O000000o;
        intent.setPackage("com.google.android.apps.plus");
        return isIntentResolvable(activity.getPackageManager(), intent) ? intent : createPlayStoreIntent("com.google.android.apps.plus");
    }
}

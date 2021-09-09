package com.tencent.tauth;

import _m_j.diq;
import _m_j.diz;
import _m_j.djn;
import _m_j.djp;
import _m_j.djz;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.connect.common.AssistActivity;

public class AuthActivity extends Activity {

    /* renamed from: O000000o  reason: collision with root package name */
    private static int f5883O000000o;

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
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.djn.O000000o(android.content.Context, java.lang.String):java.lang.String
     arg types: [com.tencent.tauth.AuthActivity, java.lang.String]
     candidates:
      _m_j.djn.O000000o(java.lang.String, java.lang.String):int
      _m_j.djn.O000000o(java.io.InputStream, java.io.OutputStream):long
      _m_j.djn.O000000o(android.app.Activity, java.lang.String):java.lang.String
      _m_j.djn.O000000o(android.content.Context, android.content.Intent):boolean
      _m_j.djn.O000000o(android.content.Context, java.lang.String):java.lang.String */
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        String str = "";
        super.onCreate(bundle);
        if (getIntent() == null) {
            diz.O00000o("openSDK_LOG.AuthActivity", "-->onCreate, getIntent() return null");
            finish();
            return;
        }
        Uri uri = null;
        try {
            uri = getIntent().getData();
        } catch (Exception e) {
            e.printStackTrace();
        }
        diz.O000000o("openSDK_LOG.AuthActivity", "-->onCreate, uri: ".concat(String.valueOf(uri)));
        try {
            diz.O00000o0("openSDK_LOG.AuthActivity", "-->handleActionUri--start");
            if (!(uri == null || uri.toString() == null)) {
                if (!uri.toString().equals(str)) {
                    String uri2 = uri.toString();
                    Bundle O000000o2 = djp.O000000o(uri2.substring(uri2.indexOf("#") + 1));
                    if (O000000o2 == null) {
                        diz.O00000o("openSDK_LOG.AuthActivity", "-->handleActionUri, bundle is null");
                        finish();
                        return;
                    }
                    String string = O000000o2.getString("action");
                    diz.O00000o0("openSDK_LOG.AuthActivity", "-->handleActionUri, action: ".concat(String.valueOf(string)));
                    if (string == null) {
                        finish();
                        return;
                    }
                    if (!string.equals("shareToQQ")) {
                        if (!string.equals("shareToQzone") && !string.equals("sendToMyComputer")) {
                            if (!string.equals("shareToTroopBar")) {
                                if (string.equals("addToQQFavorites")) {
                                    Intent intent = getIntent();
                                    intent.putExtras(O000000o2);
                                    intent.putExtra("key_action", "action_share");
                                    djz O000000o3 = diq.O000000o().O000000o(string);
                                    if (O000000o3 != null) {
                                        diq.O000000o();
                                        diq.O000000o(intent, O000000o3);
                                    }
                                    finish();
                                    return;
                                } else if (string.equals("sharePrize")) {
                                    Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getPackageName());
                                    try {
                                        str = djp.O00000o(O000000o2.getString("response")).getString("activityid");
                                    } catch (Exception e2) {
                                        diz.O00000Oo("openSDK_LOG.AuthActivity", "sharePrize parseJson has exception.", e2);
                                    }
                                    if (!TextUtils.isEmpty(str)) {
                                        launchIntentForPackage.putExtra("sharePrize", true);
                                        Bundle bundle2 = new Bundle();
                                        bundle2.putString("activityid", str);
                                        launchIntentForPackage.putExtras(bundle2);
                                    }
                                    startActivity(launchIntentForPackage);
                                    finish();
                                    return;
                                } else if (string.equals("sdkSetAvatar")) {
                                    boolean booleanExtra = getIntent().getBooleanExtra("stay_back_stack", false);
                                    Intent intent2 = new Intent(this, AssistActivity.class);
                                    intent2.putExtra("key_request_code", 10108);
                                    intent2.putExtra("stay_back_stack", booleanExtra);
                                    intent2.putExtras(O000000o2);
                                    intent2.setFlags(603979776);
                                    startActivity(intent2);
                                    finish();
                                    return;
                                } else if ("sdkSetDynamicAvatar".equals(string)) {
                                    boolean booleanExtra2 = getIntent().getBooleanExtra("stay_back_stack", false);
                                    Intent intent3 = new Intent(this, AssistActivity.class);
                                    intent3.putExtra("key_request_code", 10110);
                                    intent3.putExtra("stay_back_stack", booleanExtra2);
                                    intent3.putExtras(O000000o2);
                                    intent3.setFlags(603979776);
                                    startActivity(intent3);
                                    finish();
                                    return;
                                } else if (string.equals("sdkSetEmotion")) {
                                    boolean booleanExtra3 = getIntent().getBooleanExtra("stay_back_stack", false);
                                    Intent intent4 = new Intent(this, AssistActivity.class);
                                    intent4.putExtra("key_request_code", 10109);
                                    intent4.putExtra("stay_back_stack", booleanExtra3);
                                    intent4.putExtras(O000000o2);
                                    intent4.setFlags(603979776);
                                    startActivity(intent4);
                                    finish();
                                    return;
                                } else if (string.equals("bindGroup")) {
                                    diz.O00000o0("openSDK_LOG.AuthActivity", "-->handleActionUri--bind group callback.");
                                    boolean booleanExtra4 = getIntent().getBooleanExtra("stay_back_stack", false);
                                    Intent intent5 = new Intent(this, AssistActivity.class);
                                    intent5.putExtra("key_request_code", 10112);
                                    intent5.putExtra("stay_back_stack", booleanExtra4);
                                    intent5.putExtras(O000000o2);
                                    intent5.setFlags(603979776);
                                    startActivity(intent5);
                                    finish();
                                    return;
                                } else if (string.equals("joinGroup")) {
                                    diz.O00000o0("openSDK_LOG.AuthActivity", "-->handleActionUri--join group callback. ");
                                    boolean booleanExtra5 = getIntent().getBooleanExtra("stay_back_stack", false);
                                    Intent intent6 = new Intent(this, AssistActivity.class);
                                    intent6.putExtra("key_request_code", 10111);
                                    intent6.putExtra("stay_back_stack", booleanExtra5);
                                    intent6.putExtras(O000000o2);
                                    intent6.setFlags(603979776);
                                    startActivity(intent6);
                                    finish();
                                    return;
                                } else {
                                    finish();
                                    return;
                                }
                            }
                        }
                    }
                    if (string.equals("shareToQzone") && djn.O000000o((Context) this, "com.tencent.mobileqq") != null && djn.O000000o(djn.O000000o((Context) this, "com.tencent.mobileqq"), "5.2.0") < 0) {
                        int i = f5883O000000o + 1;
                        f5883O000000o = i;
                        if (i == 2) {
                            f5883O000000o = 0;
                            finish();
                            return;
                        }
                    }
                    diz.O00000o0("openSDK_LOG.AuthActivity", "-->handleActionUri, most share action, start assistactivity");
                    Intent intent7 = new Intent(this, AssistActivity.class);
                    intent7.putExtras(O000000o2);
                    intent7.setFlags(603979776);
                    startActivity(intent7);
                    finish();
                    return;
                }
            }
            diz.O00000o("openSDK_LOG.AuthActivity", "-->handleActionUri, uri invalid");
            finish();
        } catch (Exception e3) {
            e3.printStackTrace();
            finish();
        }
    }
}

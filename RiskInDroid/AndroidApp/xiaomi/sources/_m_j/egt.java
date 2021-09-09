package _m_j;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import com.facebook.FacebookSdk;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.xiaomi.accountsdk.account.XMPassportUserAgent;
import com.xiaomi.accountsdk.utils.AccountLog;
import com.xiaomi.passport.ui.internal.AuthComponent;
import com.xiaomi.passport.ui.onetrack.Analytics;
import com.xiaomi.phonenum.utils.ILogger;
import com.xiaomi.phonenum.utils.ITracker;
import com.xiaomi.phonenum.utils.PhoneNumberKeepLogger;
import com.xiaomi.phonenum.utils.PhoneNumberKeepTracker;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020\u0004H\u0002J\u0010\u0010C\u001a\u00020D2\u0006\u0010G\u001a\u00020,H\u0002J\u0018\u0010H\u001a\u00020%2\u0006\u0010E\u001a\u00020F2\u0006\u0010I\u001a\u00020JH\u0002J+\u0010K\u001a\u00020D2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020\u00042\f\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00040MH\u0002¢\u0006\u0002\u0010NJ\u000e\u0010O\u001a\u00020D2\u0006\u0010E\u001a\u00020FJ\u000e\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020\u0004J\u0006\u0010S\u001a\u00020QJ\u0010\u0010T\u001a\u0004\u0018\u00010,2\u0006\u0010U\u001a\u00020VJ\u0010\u0010T\u001a\u0004\u0018\u00010,2\u0006\u0010R\u001a\u00020\u0004J\u0012\u0010W\u001a\u0004\u0018\u00010J2\u0006\u0010E\u001a\u00020FH\u0002J\u000e\u0010X\u001a\u00020D2\u0006\u0010E\u001a\u00020FJ\u000e\u0010Y\u001a\u00020D2\u0006\u0010G\u001a\u00020\u0004J\u0014\u0010Z\u001a\u00020D2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00040=J\u000e\u0010[\u001a\u00020D2\u0006\u0010E\u001a\u00020FJ\u000e\u0010\\\u001a\u00020D2\u0006\u0010E\u001a\u00020FJ)\u0010]\u001a\u00020D2\b\u0010^\u001a\u0004\u0018\u00010J2\u0006\u0010E\u001a\u00020F2\b\u0010_\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0002\u0010`R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\n \u0019*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\"\u001a\u00020\u00048\u0006XT¢\u0006\b\n\u0000\u0012\u0004\b#\u0010\u0002R\u001a\u0010$\u001a\u00020%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R \u0010*\u001a\b\u0012\u0004\u0012\u00020,0+X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001a\u00101\u001a\u000202X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001c\u00107\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R \u0010<\u001a\b\u0012\u0004\u0012\u00020\u00040=X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010.\"\u0004\b?\u00100R\u001c\u0010@\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u00109\"\u0004\bB\u0010;¨\u0006a"}, d2 = {"Lcom/xiaomi/passport/ui/internal/PassportUI;", "", "()V", "ACTION_LOCAL_ACCOUNT_CHANGE_EMAIL", "", "ACTION_LOCAL_ACCOUNT_CHANGE_PASSWORD", "ACTION_LOCAL_ACCOUNT_CHANGE_PHONE", "CHINA_COUNTRY_CODE", "EXTRA_DEFAULT_AUTH_PROVIDER", "EXTRA_DEFAULT_PHONE_COUNTRY_CODE", "EXTRA_LOCAL_ACCOUNT_CHANGE_EMAIL_RESULT", "EXTRA_LOCAL_ACCOUNT_CHANGE_EMAIL_RESULT_CODE", "EXTRA_LOCAL_ACCOUNT_CHANGE_PASSWORD_RESULT", "EXTRA_LOCAL_ACCOUNT_CHANGE_PASSWORD_RESULT_CODE", "EXTRA_LOCAL_ACCOUNT_CHANGE_PHONE_RESULT", "EXTRA_LOCAL_ACCOUNT_CHANGE_PHONE_RESULT_CODE", "EXTRA_SNS_SIGN_IN", "FACEBOOK_AUTH_PROVIDER", "GOOGLE_AUTH_PROVIDER", "ID_PSW_AUTH_PROVIDER", "INPUT_ID_PSW_SHOW_COUNTRY_CODE_MIN_LENGTH_", "", "PHONE_SMS_AUTH_PROVIDER", "QQ_AUTH_PROVIDER", "TAG", "kotlin.jvm.PlatformType", "WECHAT_AUTH_PROVIDER", "WEIBO_AUTH_PROVIDER", "WXAPIEventHandler", "getWXAPIEventHandler", "()Ljava/lang/Object;", "setWXAPIEventHandler", "(Ljava/lang/Object;)V", "WX_API_STATE_PASSPORT", "ZHIFUBAO_AUTH_PROVIDER", "ZHIFUBAO_AUTH_PROVIDER$annotations", "international", "", "getInternational", "()Z", "setInternational", "(Z)V", "mProviders", "", "Lcom/xiaomi/passport/ui/internal/AuthProvider;", "getMProviders$client_ui_release", "()Ljava/util/List;", "setMProviders$client_ui_release", "(Ljava/util/List;)V", "passportRepo", "Lcom/xiaomi/passport/ui/internal/PassportRepo;", "getPassportRepo", "()Lcom/xiaomi/passport/ui/internal/PassportRepo;", "setPassportRepo", "(Lcom/xiaomi/passport/ui/internal/PassportRepo;)V", "privacyPolicyUrl", "getPrivacyPolicyUrl", "()Ljava/lang/String;", "setPrivacyPolicyUrl", "(Ljava/lang/String;)V", "snsInvisibleList", "", "getSnsInvisibleList", "setSnsInvisibleList", "userAgreementUrl", "getUserAgreementUrl", "setUserAgreementUrl", "addProvider", "", "context", "Landroid/content/Context;", "provider", "checkActivityIntent", "intent", "Landroid/content/Intent;", "checkNeededComponentOrThrow", "activityNames", "", "(Landroid/content/Context;Ljava/lang/String;[Ljava/lang/String;)V", "forceStartLocalAccountSettings", "getBaseAuthProvider", "Lcom/xiaomi/passport/ui/internal/BaseAuthProvider;", "providerName", "getDefaultBaseAuthProvider", "getProvider", "authCredential", "Lcom/xiaomi/passport/ui/internal/AuthCredential;", "getSystemAccountSettingsIntent", "init", "rmProvider", "setSNSInvisibleList", "startAccountSettings", "startChangePassword", "tryStartActivityIntent", "accountSettingsIntent", "requestCode", "(Landroid/content/Intent;Landroid/content/Context;Ljava/lang/Integer;)V", "client-ui_release"}, k = 1, mv = {1, 1, 10})
public final class egt {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final egt f15254O000000o = new egt();
    private static final String O00000Oo = egt.class.getSimpleName();
    private static List<String> O00000o = new ArrayList();
    private static List<eft> O00000o0 = new ArrayList();
    private static String O00000oO;
    private static String O00000oo;
    private static egr O0000O0o = new egs();
    private static boolean O0000OOo;
    private static Object O0000Oo0;

    static {
        XMPassportUserAgent.addExtendedUserAgent("PassportSDK/3.2.4.bugfix");
        XMPassportUserAgent.addExtendedUserAgent("passport-ui/3.2.4.bugfix");
        O00000o0.add(new egj());
        O00000o0.add(new ehe());
    }

    private egt() {
    }

    public static List<eft> O000000o() {
        return O00000o0;
    }

    public static List<String> O00000Oo() {
        return O00000o;
    }

    public static String O00000o0() {
        return O00000oO;
    }

    public static String O00000o() {
        return O00000oo;
    }

    public static boolean O00000oO() {
        return O0000OOo;
    }

    public static void O00000oo() {
        O0000OOo = true;
    }

    public final void O000000o(Context context) {
        ixe.O00000o0(context, "context");
        eeu.f15193O000000o = new AuthComponent(context);
        O000000o(context, "FACEBOOK_AUTH_PROVIDER");
        O000000o(context, "GOOGLE_AUTH_PROVIDER");
        O000000o(context, "WEIBO_AUTH_PROVIDER");
        O000000o(context, "QQ_AUTH_PROVIDER");
        O000000o(context, "WECHAT_AUTH_PROVIDER");
        Analytics.O000000o(context);
        try {
            PhoneNumberKeepLogger.setLogger(new O000000o());
            PhoneNumberKeepTracker.setTracker(new O00000Oo());
        } catch (NoClassDefFoundError e) {
            AccountLog.e(O00000Oo, "init logger and tracker", e);
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"com/xiaomi/passport/ui/internal/PassportUI$init$1", "Lcom/xiaomi/phonenum/utils/ILogger;", "()V", "log", "", "logLevel", "", "tag", "", "message", "throwable", "", "client-ui_release"}, k = 1, mv = {1, 1, 10})
    public static final class O000000o implements ILogger {
        O000000o() {
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\bH\u0016¨\u0006\n"}, d2 = {"com/xiaomi/passport/ui/internal/PassportUI$init$2", "Lcom/xiaomi/phonenum/utils/ITracker;", "()V", "track", "", "eventName", "", "params", "", "", "client-ui_release"}, k = 1, mv = {1, 1, 10})
    public static final class O00000Oo implements ITracker {
        O00000Oo() {
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void */
    private final void O000000o(Context context, String str) {
        boolean z = true;
        if (ixe.O000000o((Object) str, (Object) "WEIBO_AUTH_PROVIDER")) {
            String string = context.getString(R.string.weibo_application_id);
            ixe.O000000o((Object) string, "context.getString(R.string.weibo_application_id)");
            if (string != null) {
                if (!(iyo.O00000Oo(string).toString().length() == 0)) {
                    O000000o(new eil());
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
            }
        }
        if (ixe.O000000o((Object) str, (Object) "QQ_AUTH_PROVIDER")) {
            String string2 = context.getString(R.string.qq_application_id);
            ixe.O000000o((Object) string2, "context.getString(R.string.qq_application_id)");
            if (string2 != null) {
                if (!(iyo.O00000Oo(string2).toString().length() == 0)) {
                    O000000o(context, str, new String[]{"com.tencent.tauth.AuthActivity", "com.tencent.connect.common.AssistActivity"});
                    O000000o(new ehm());
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
            }
        }
        if (ixe.O000000o((Object) str, (Object) "WECHAT_AUTH_PROVIDER")) {
            String string3 = context.getString(R.string.wechat_application_id);
            ixe.O000000o((Object) string3, "context.getString(R.string.wechat_application_id)");
            if (string3 != null) {
                if (!(iyo.O00000Oo(string3).toString().length() == 0)) {
                    try {
                        AccountLog.v(O00000Oo, WXAPIFactory.class.getName());
                        O000000o(new eig());
                    } catch (NoClassDefFoundError unused) {
                        new RuntimeException("WE_CHAT provider cannot be configured without dependency. Did you forget to add 'com.tencent.mm.opensdk:wechat-sdk-android-without-mta:+' dependency?").printStackTrace();
                    }
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
            }
        }
        if (ixe.O000000o((Object) str, (Object) "FACEBOOK_AUTH_PROVIDER")) {
            String string4 = context.getString(R.string.facebook_application_id);
            ixe.O000000o((Object) string4, "context.getString(R.stri….facebook_application_id)");
            if (string4 != null) {
                if (!(iyo.O00000Oo(string4).toString().length() == 0)) {
                    O000000o(context, str, new String[]{"com.facebook.FacebookActivity", "com.facebook.CustomTabActivity"});
                    try {
                        AccountLog.v(O00000Oo, FacebookSdk.class.getName());
                        O000000o(new egf());
                    } catch (NoClassDefFoundError unused2) {
                        new RuntimeException("FaceBook provider cannot be configured without dependency. Did you forget to add com.facebook.android:facebook-login:+ dependency?").printStackTrace();
                    }
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
            }
        }
        if (ixe.O000000o((Object) str, (Object) "GOOGLE_AUTH_PROVIDER")) {
            String string5 = context.getString(R.string.google_application_id);
            ixe.O000000o((Object) string5, "context.getString(R.string.google_application_id)");
            if (string5 != null) {
                if (iyo.O00000Oo((CharSequence) string5).toString().length() != 0) {
                    z = false;
                }
                if (!z) {
                    try {
                        AccountLog.v(O00000Oo, GoogleSignInClient.class.getName());
                        O000000o(new egh());
                    } catch (NoClassDefFoundError unused3) {
                        new RuntimeException("Google provider cannot be configured without dependency. Did you forget to add \"com.google.android.gms:play-services-auth:16.0.1\" dependency?").printStackTrace();
                    }
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
            }
        }
    }

    private static void O000000o(Context context, String str, String[] strArr) {
        ActivityInfo[] activityInfoArr;
        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 1);
        ActivityInfo activityInfo = null;
        if (packageInfo != null && (activityInfoArr = packageInfo.activities) != null) {
            int length = activityInfoArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                ActivityInfo activityInfo2 = activityInfoArr[i];
                if (iuj.O000000o(strArr, activityInfo2.name)) {
                    activityInfo = activityInfo2;
                    break;
                }
                i++;
            }
        }
        if (activityInfo == null) {
            throw new RuntimeException("Provider " + str + " needs " + Arrays.toString(strArr) + ", did you forget to add into AndroidManifest.xml? View wiki: https://git.n.xiaomi.com/passport-android/passport-sdk-demo/wikis/passport-ui/SNS.md or contact to Mi Passport Client team");
        }
    }

    private static void O00000o0(String str) {
        ixe.O00000o0(str, "provider");
        if (iuo.O000000o(O00000o0, O000000o(str))) {
            Collection collection = O00000o0;
            eft O000000o2 = O000000o(str);
            if (collection != null) {
                ixi.O00000Oo(collection).remove(O000000o2);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
        }
    }

    public static efw O0000O0o() {
        if (O0000OOo) {
            eft O000000o2 = O000000o("ID_PSW_AUTH_PROVIDER");
            if (O000000o2 != null) {
                return (efw) O000000o2;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.xiaomi.passport.ui.internal.BaseAuthProvider");
        }
        eft O000000o3 = O000000o("PHONE_SMS_AUTH_PROVIDER");
        if (O000000o3 != null) {
            return (efw) O000000o3;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.xiaomi.passport.ui.internal.BaseAuthProvider");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean */
    public static eft O000000o(String str) {
        ixe.O00000o0(str, "providerName");
        Collection arrayList = new ArrayList();
        for (Object next : O00000o0) {
            if (ixe.O000000o((Object) ((eft) next).f15234O000000o, (Object) str)) {
                arrayList.add(next);
            }
        }
        Iterator it = ((List) arrayList).iterator();
        if (it.hasNext()) {
            return (eft) it.next();
        }
        return null;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean */
    public static efw O00000Oo(String str) {
        ixe.O00000o0(str, "providerName");
        Collection arrayList = new ArrayList();
        for (Object next : O00000o0) {
            if (ixe.O000000o((Object) ((eft) next).f15234O000000o, (Object) str)) {
                arrayList.add(next);
            }
        }
        Iterator it = ((List) arrayList).iterator();
        if (it.hasNext()) {
            eft eft = (eft) it.next();
            if (eft != null) {
                return (efw) eft;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.xiaomi.passport.ui.internal.BaseAuthProvider");
        }
        throw new RuntimeException("FaceBook provider cannot be configured ");
    }

    public static void O000000o(List<String> list) {
        ixe.O00000o0(list, "snsInvisibleList");
        O00000o = list;
    }

    public static Object O0000OOo() {
        return O0000Oo0;
    }

    private final void O000000o(eft eft) {
        O00000o0(eft.f15234O000000o);
        O00000o0.add(eft);
    }

    public static eft O000000o(efs efs) {
        ixe.O00000o0(efs, "authCredential");
        return O000000o(efs.O00000o0);
    }
}

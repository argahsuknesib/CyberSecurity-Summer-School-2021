package _m_j;

import android.content.Context;
import android.content.res.Resources;
import java.util.Arrays;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bJ\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/xiaomi/passport/ui/internal/UserLicenseUtils;", "", "()V", "privacyPolicyUrl", "", "userAgreementUrl", "getPrivacyPolicyClicked", "context", "Landroid/content/Context;", "getProductAgreement", "Lcom/xiaomi/passport/ui/internal/License;", "getUrl", "urlFormat", "getUserAgreementClicked", "Companion", "client-ui_release"}, k = 1, mv = {1, 1, 10})
public final class eie {
    public static final O000000o O00000o0 = new O000000o((byte) 0);

    /* renamed from: O000000o  reason: collision with root package name */
    public String f15315O000000o = egt.O00000o0();
    public String O00000Oo;

    public eie() {
        egt egt = egt.f15254O000000o;
        egt egt2 = egt.f15254O000000o;
        this.O00000Oo = egt.O00000o();
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/xiaomi/passport/ui/internal/UserLicenseUtils$Companion;", "", "()V", "URL_MI_PRIVACY_POLICY", "", "URL_MI_USER_AGREEMENT", "mProductAgreement", "Lcom/xiaomi/passport/ui/internal/License;", "addLicense", "", "readableText", "url", "client-ui_release"}, k = 1, mv = {1, 1, 10})
    public static final class O000000o {
        private O000000o() {
        }

        public /* synthetic */ O000000o(byte b) {
            this();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
     arg types: [android.content.res.Resources, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void */
    public static String O000000o(String str, Context context) {
        Resources resources = context.getResources();
        ixe.O000000o((Object) resources, "context.resources");
        String locale = resources.getConfiguration().locale.toString();
        ixh ixh = ixh.f1644O000000o;
        String format = String.format(str, Arrays.copyOf(new Object[]{locale}, 1));
        ixe.O000000o((Object) format, "java.lang.String.format(format, *args)");
        return format;
    }
}

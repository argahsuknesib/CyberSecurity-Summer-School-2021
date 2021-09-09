package _m_j;

import android.app.Activity;
import android.content.Intent;
import com.xiaomi.accountsdk.utils.XMPassportUtil;
import com.xiaomi.passport.ui.internal.AuthComponent;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0016\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/xiaomi/passport/ui/internal/WebViewUtils;", "", "()V", "Companion", "client-ui_release"}, k = 1, mv = {1, 1, 10})
public final class eik {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final O000000o f15320O000000o = new O000000o((byte) 0);

    public static final void O000000o(Activity activity, String str) {
        O000000o.O000000o(activity, str);
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Lcom/xiaomi/passport/ui/internal/WebViewUtils$Companion;", "", "()V", "startWebViewActivity", "", "activity", "Landroid/app/Activity;", "url", "", "client-ui_release"}, k = 1, mv = {1, 1, 10})
    public static final class O000000o {
        private O000000o() {
        }

        public /* synthetic */ O000000o(byte b) {
            this();
        }

        public static void O000000o(Activity activity, String str) {
            ixe.O00000o0(activity, "activity");
            ixe.O00000o0(str, "url");
            Intent intent = new Intent();
            intent.putExtra("notification_url", XMPassportUtil.buildUrlWithLocaleQueryParam(str));
            intent.setComponent(new AuthComponent(activity).O00000o0());
            activity.startActivity(intent);
        }
    }
}

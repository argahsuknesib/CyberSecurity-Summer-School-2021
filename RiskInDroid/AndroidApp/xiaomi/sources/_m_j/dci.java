package _m_j;

import android.content.Context;
import android.os.Bundle;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.web.BaseWebViewRequestData;
import com.sina.weibo.sdk.web.WebRequestType;

public abstract class dci {

    /* renamed from: O000000o  reason: collision with root package name */
    public BaseWebViewRequestData f14467O000000o;
    protected Context O00000Oo;
    private String O00000o0;

    public interface O000000o {
        void O000000o();

        void O00000Oo();
    }

    public void O000000o(O000000o o000000o) {
    }

    /* access modifiers changed from: protected */
    public abstract void O000000o(Bundle bundle);

    public boolean O000000o() {
        return false;
    }

    public abstract String O00000Oo();

    /* access modifiers changed from: protected */
    public abstract void O00000Oo(Bundle bundle);

    public dci() {
    }

    public dci(AuthInfo authInfo, WebRequestType webRequestType, String str, String str2, String str3, Context context) {
        this(authInfo, webRequestType, str, 0, str2, str3, context);
    }

    public dci(AuthInfo authInfo, WebRequestType webRequestType, String str, int i, String str2, String str3, Context context) {
        this.f14467O000000o = new BaseWebViewRequestData(authInfo, webRequestType, str, i, str2, str3);
        this.O00000Oo = context;
        this.O00000o0 = String.valueOf(System.currentTimeMillis());
    }

    public final void O000000o(Context context) {
        this.O00000Oo = context;
    }

    public final Bundle O00000o0(Bundle bundle) {
        BaseWebViewRequestData baseWebViewRequestData = this.f14467O000000o;
        if (baseWebViewRequestData != null) {
            bundle.putSerializable("base", baseWebViewRequestData);
            int i = AnonymousClass1.f14468O000000o[this.f14467O000000o.type.ordinal()];
            if (i == 1) {
                bundle.putInt("type", 0);
            } else if (i == 2) {
                bundle.putInt("type", 1);
            } else if (i == 3) {
                bundle.putInt("type", 2);
            }
            bundle.putString("_weibo_transaction", this.O00000o0);
            O000000o(bundle);
            return bundle;
        }
        throw new NullPointerException("构造方法错误，请使用全参数的构造方法构建");
    }

    /* renamed from: _m_j.dci$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f14468O000000o = new int[WebRequestType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            f14468O000000o[WebRequestType.DEFAULT.ordinal()] = 1;
            f14468O000000o[WebRequestType.SHARE.ordinal()] = 2;
            try {
                f14468O000000o[WebRequestType.AUTH.ordinal()] = 3;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public final void O00000o(Bundle bundle) {
        this.f14467O000000o = (BaseWebViewRequestData) bundle.getSerializable("base");
        this.O00000o0 = bundle.getString("_weibo_transaction");
        O00000Oo(bundle);
    }
}

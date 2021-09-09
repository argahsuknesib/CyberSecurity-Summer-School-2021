package _m_j;

import android.text.TextUtils;
import android.widget.Toast;

public final class cuw implements cvc {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final cuw f14375O000000o = new cuw();

    public final void O000000o(cvg cvg, int i) {
        String str = (String) cvg.O000000o(String.class, "com.sankuai.waimai.router.core.error.msg", null);
        if (TextUtils.isEmpty(str)) {
            str = i != 403 ? i != 404 ? "跳转失败" : "不支持的跳转链接" : "没有权限";
        }
        String str2 = str + "(" + i + ")";
        if (cvb.O00000Oo()) {
            str2 = str2 + "\n" + cvg.O00000Oo.toString();
        }
        Toast.makeText(cvg.f14384O000000o, str2, 1).show();
    }
}

package _m_j;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.xiaomi.smarthome.R;
import java.util.HashMap;
import java.util.Map;

public final class bzl {

    /* renamed from: O000000o  reason: collision with root package name */
    private static Map<String, Drawable> f13493O000000o;

    static {
        Resources resources = byl.O00000oO().getResources();
        HashMap hashMap = new HashMap();
        f13493O000000o = hashMap;
        hashMap.put("CITI", resources.getDrawable(R.drawable.shop_netbank_citi));
        f13493O000000o.put("HDFC", resources.getDrawable(R.drawable.shop_netbank_hdfc));
        f13493O000000o.put("AXIB", resources.getDrawable(R.drawable.shop_netbank_axis));
        f13493O000000o.put("HDFB", resources.getDrawable(R.drawable.shop_netbank_hdfc));
        f13493O000000o.put("ICIB", resources.getDrawable(R.drawable.shop_netbank_icici));
        f13493O000000o.put("SBIB", resources.getDrawable(R.drawable.shop_netbank_indiabank));
        f13493O000000o.put("ADBB", resources.getDrawable(R.drawable.shop_netbank_adbb));
        f13493O000000o.put("CABB", resources.getDrawable(R.drawable.shop_netbank_cabb));
        f13493O000000o.put("AXIS", resources.getDrawable(R.drawable.shop_netbank_axis));
        f13493O000000o.put("AMEX", resources.getDrawable(R.drawable.shop_emi_amex));
        f13493O000000o.put("ICICI", resources.getDrawable(R.drawable.shop_netbank_icici));
        f13493O000000o.put("KOTAK", resources.getDrawable(R.drawable.shop_emi_kotak));
        f13493O000000o.put("SBI", resources.getDrawable(R.drawable.shop_netbank_indiabank));
        f13493O000000o.put("BFL", resources.getDrawable(R.drawable.netbank_bfl));
    }

    public static Drawable O000000o(String str) {
        return f13493O000000o.get(str);
    }
}

package _m_j;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.xiaomi.smarthome.R;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public final class bzs {

    /* renamed from: O000000o  reason: collision with root package name */
    public static HashMap<String, Drawable> f13499O000000o;
    public static Set<String> O00000Oo;
    public static Set<String> O00000o0;

    public static void O000000o(Resources resources) {
        HashMap<String, Drawable> hashMap = new HashMap<>();
        f13499O000000o = hashMap;
        hashMap.put("VISA", resources.getDrawable(R.drawable.shop_visa));
        f13499O000000o.put("LASER", resources.getDrawable(R.drawable.shop_laser));
        f13499O000000o.put("DISCOVER", resources.getDrawable(R.drawable.shop_discover));
        f13499O000000o.put("MAES", resources.getDrawable(R.drawable.shop_maestro));
        f13499O000000o.put("MAST", resources.getDrawable(R.drawable.shop_master));
        f13499O000000o.put("AMEX", resources.getDrawable(R.drawable.shop_amex));
        f13499O000000o.put("DINR", resources.getDrawable(R.drawable.shop_diner));
        f13499O000000o.put("JCB", resources.getDrawable(R.drawable.shop_jcb));
        f13499O000000o.put("SMAE", resources.getDrawable(R.drawable.shop_maestro));
        f13499O000000o.put("RUPAY", resources.getDrawable(R.drawable.shop_rupay));
    }

    static {
        HashSet hashSet = new HashSet();
        O00000Oo = hashSet;
        hashSet.add("VISA");
        O00000Oo.add("LASER");
        O00000Oo.add("DISCOVER");
        O00000Oo.add("MAES");
        O00000Oo.add("MAST");
        O00000Oo.add("AMEX");
        O00000Oo.add("DINR");
        O00000Oo.add("JCB");
        O00000Oo.add("SMAE");
        O00000Oo.add("RUPAY");
        O00000Oo.add("BFL");
        HashSet hashSet2 = new HashSet();
        O00000o0 = hashSet2;
        hashSet2.add("504435");
        O00000o0.add("504645");
        O00000o0.add("504645");
        O00000o0.add("504775");
        O00000o0.add("504809");
        O00000o0.add("504993");
        O00000o0.add("600206");
        O00000o0.add("603845");
        O00000o0.add("622018");
    }

    public static Boolean O000000o(String str) {
        if (str.length() < 12) {
            return Boolean.FALSE;
        }
        if (O00000Oo(str).contentEquals("RUPAY") && str.length() == 16) {
            return O00000o0(str);
        }
        if (O00000Oo(str).contentEquals("VISA") && str.length() == 16) {
            return O00000o0(str);
        }
        if (O00000Oo(str).contentEquals("MAST") && str.length() == 16) {
            return O00000o0(str);
        }
        if ((O00000Oo(str).contentEquals("MAES") || O00000Oo(str).contentEquals("SMAE")) && str.length() >= 12 && str.length() <= 19) {
            return O00000o0(str);
        }
        if (O00000Oo(str).contentEquals("DINR") && str.length() == 14) {
            return O00000o0(str);
        }
        if (O00000Oo(str).contentEquals("AMEX") && str.length() == 15) {
            return O00000o0(str);
        }
        if (O00000Oo(str).contentEquals("JCB") && str.length() == 16) {
            return O00000o0(str);
        }
        if (!O00000Oo(str).contentEquals("BFL") || str.length() != 16) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    private static Boolean O00000o0(String str) {
        int i = 0;
        boolean z = false;
        for (int length = str.length() - 1; length >= 0; length--) {
            int parseInt = Integer.parseInt(str.substring(length, length + 1));
            if (z && (parseInt = parseInt * 2) > 9) {
                parseInt = (parseInt % 10) + 1;
            }
            i += parseInt;
            z = !z;
        }
        if (i % 10 == 0) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public static String O00000Oo(String str) {
        if (str.startsWith("4")) {
            return "VISA";
        }
        if (str.length() <= 16 && str.matches("^508[5-9][0-9][0-9][\\d]+|60698[5-9][\\d]+|60699[0-9][\\d]+|607[0-8][0-9][0-9][\\d]+|6079[0-7][0-9][\\d]+|60798[0-4][\\d]+|(?!608000)608[0-4][0-9][0-9][\\d]+|608500[\\d]+|6521[5-9][0-9][\\d]+|652[2-9][0-9][0-9][\\d]+|6530[0-9][0-9][\\d]+|6531[0-4][0-9][\\d]+")) {
            ccr.O00000Oo("RUPAY_MATCH", "match");
            return "RUPAY";
        } else if (str.matches("^((6304)|(6706)|(6771)|(6709))[\\d]+") || str.matches("6(?:011|5[0-9]{2})[0-9]{12}[\\d]+")) {
            return "LASER";
        } else {
            if (str.matches("(5[06-8]|6\\d)\\d{14}(\\d{2,3})?[\\d]+") || str.matches("(5[06-8]|6\\d)[\\d]+") || str.matches("((504([435|645|774|775|809|993]))|(60([0206]|[3845]))|(622[018])\\d)[\\d]+")) {
                return (str.length() <= 6 || !O00000o0.contains(str.substring(0, 6))) ? "MAES" : "SMAE";
            }
            if (str.matches("^5[1-5][\\d]+")) {
                return "MAST";
            }
            if (str.matches("^3[47][\\d]+")) {
                return "AMEX";
            }
            if (str.startsWith("36") || str.matches("^30[0-5][\\d]+") || str.matches("2(014|149)[\\d]+")) {
                return "DINR";
            }
            if (str.matches("^35(2[89]|[3-8][0-9])[\\d]+")) {
                return "JCB";
            }
            return str.startsWith("203040") ? "BFL" : "";
        }
    }

    public static boolean O000000o(String str, String str2) {
        String O00000Oo2 = O00000Oo(str);
        if (O00000Oo2.contentEquals("SMAE") || O00000Oo2.contentEquals("BFL")) {
            return true;
        }
        if (O00000Oo2.contentEquals("AMEX") && str2.length() == 4) {
            return true;
        }
        if (O00000Oo2.contentEquals("AMEX") || str2.length() != 3) {
            return false;
        }
        return true;
    }
}

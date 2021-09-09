package _m_j;

import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;
import java.util.List;

public final class baf {
    public static void O000000o(Context context, List<baa> list) {
        try {
            Intent intent = new Intent();
            intent.setAction(azj.O00000Oo(context));
            intent.setPackage(azj.O000000o(context));
            intent.putExtra("appPackage", context.getPackageName());
            intent.putExtra("type", 12291);
            intent.putExtra("count", list.size());
            ArrayList arrayList = new ArrayList();
            for (baa O000000o2 : list) {
                arrayList.add(O000000o2.O000000o());
            }
            intent.putStringArrayListExtra("list", arrayList);
            context.startService(intent);
        } catch (Exception e) {
            bae.O00000Oo("statisticMessage--Exception" + e.getMessage());
        }
    }

    public static boolean O000000o(Context context) {
        String O000000o2 = azj.O000000o(context);
        return bag.O000000o(context, O000000o2) && bag.O00000Oo(context, O000000o2) >= 1017;
    }
}

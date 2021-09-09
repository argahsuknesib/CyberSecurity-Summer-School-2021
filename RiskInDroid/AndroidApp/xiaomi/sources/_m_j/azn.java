package _m_j;

import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;
import java.util.List;

public abstract class azn implements azo {
    public static List<azz> O000000o(Context context, Intent intent) {
        azz O000000o2;
        if (intent == null) {
            return null;
        }
        int i = 4096;
        try {
            i = Integer.parseInt(bad.O000000o(intent.getStringExtra("type")));
        } catch (Exception e) {
            bae.O00000Oo("MessageParser--getMessageByIntent--Exception:" + e.getMessage());
        }
        bae.O000000o("MessageParser--getMessageByIntent--type:".concat(String.valueOf(i)));
        ArrayList arrayList = new ArrayList();
        for (azo next : azj.O000000o().O00000o0) {
            if (!(next == null || (O000000o2 = next.O000000o(context, i, intent)) == null)) {
                arrayList.add(O000000o2);
            }
        }
        return arrayList;
    }
}

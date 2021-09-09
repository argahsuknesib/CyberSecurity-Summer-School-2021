package _m_j;

import _m_j.guk;
import android.content.Intent;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.miio.db.record.MessageRecordTypeList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class guw {
    private static volatile guw O00000Oo;

    /* renamed from: O000000o  reason: collision with root package name */
    public List<MessageRecordTypeList> f18322O000000o = new ArrayList();
    private Map<String, gum> O00000o0 = new HashMap();

    private guw() {
        this.O00000o0.put("1", new guv());
        this.O00000o0.put("3", new gux());
        this.O00000o0.put("6", new guh());
        this.O00000o0.put("7", new gug());
        this.O00000o0.put("8", new guk());
        this.O00000o0.put("10", new gur());
        this.O00000o0.put("11", new guj());
    }

    public static guw O000000o() {
        if (O00000Oo == null) {
            synchronized (guw.class) {
                if (O00000Oo == null) {
                    O00000Oo = new guw();
                }
            }
        }
        return O00000Oo;
    }

    public final List<gul> O000000o(List<MessageRecordTypeList> list) {
        gum gum;
        gul O000000o2;
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        for (int i = 0; i < list.size(); i++) {
            MessageRecordTypeList messageRecordTypeList = list.get(i);
            if (!(messageRecordTypeList == null || (gum = this.O00000o0.get(messageRecordTypeList.messageType)) == null || (O000000o2 = gum.O000000o(messageRecordTypeList.toMsgRecord())) == null)) {
                arrayList.add(O000000o2);
                if (O000000o2 instanceof guk.O000000o) {
                    long O00000oO = ((guk.O000000o) O000000o2).O00000oO();
                    if (O00000oO != 0 && ggg.O000000o().O000000o(O00000oO) == null) {
                        hashSet.add(Long.valueOf(O00000oO));
                    }
                }
            }
        }
        if (!hashSet.isEmpty()) {
            ggg.O000000o().O000000o(hashSet, null);
        }
        return arrayList;
    }

    public static void O000000o(int i) {
        Intent intent = new Intent("message_center_updated");
        intent.putExtra("result_code", i);
        ft.O000000o(ServiceApplication.getAppContext()).O000000o(intent);
    }
}

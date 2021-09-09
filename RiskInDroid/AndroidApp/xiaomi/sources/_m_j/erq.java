package _m_j;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.ht;
import com.xiaomi.push.service.bs;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class erq {
    public static void O000000o(Context context, ers ers, List<ht> list) {
        HashMap<String, ArrayList<ht>> O000000o2 = O000000o(context, list);
        if (O000000o2 == null || O000000o2.size() == 0) {
            duv.O000000o("TinyData TinyDataCacheUploader.uploadTinyData itemsUploading == null || itemsUploading.size() == 0  ts:" + System.currentTimeMillis());
            return;
        }
        O000000o(ers, O000000o2);
    }

    private static HashMap<String, ArrayList<ht>> O000000o(Context context, List<ht> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        HashMap<String, ArrayList<ht>> hashMap = new HashMap<>();
        for (ht next : list) {
            O000000o(context, next);
            ArrayList arrayList = hashMap.get(next.e);
            if (arrayList == null) {
                arrayList = new ArrayList();
                hashMap.put(next.e, arrayList);
            }
            arrayList.add(next);
        }
        return hashMap;
    }

    private static void O000000o(Context context, ht htVar) {
        if (htVar.f55a) {
            htVar.f52a = "push_sdk_channel";
        }
        if (TextUtils.isEmpty(htVar.f)) {
            htVar.f = bs.a();
        }
        htVar.O00000Oo(System.currentTimeMillis());
        if (TextUtils.isEmpty(htVar.g)) {
            htVar.e = context.getPackageName();
        }
        if (TextUtils.isEmpty(htVar.e)) {
            htVar.e = htVar.g;
        }
    }

    private static void O000000o(ers ers, HashMap<String, ArrayList<ht>> hashMap) {
        for (Map.Entry next : hashMap.entrySet()) {
            try {
                ArrayList arrayList = (ArrayList) next.getValue();
                if (arrayList != null) {
                    if (arrayList.size() != 0) {
                        ers.a(arrayList, ((ht) arrayList.get(0)).g, (String) next.getKey());
                    }
                }
            } catch (Exception unused) {
            }
        }
    }
}

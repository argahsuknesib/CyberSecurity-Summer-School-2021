package com.mi.global.shop.model.push;

import _m_j.byl;
import _m_j.cbm;
import _m_j.cec;
import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.Iterator;

public class PushClassifyModel {
    @SerializedName("pushTypeList")
    public ArrayList<PushClassifyItem> items;

    public static class PushClassifyItem {
        @SerializedName("defaultStatus")
        public boolean defaultStatus;
        @SerializedName("desc")
        public String desc;
        @SerializedName("enableclose")
        public boolean enableclose;
        @SerializedName("key")
        public String key;
        @SerializedName("title")
        public String title;
    }

    public static void changeKeyChecked(Context context, String str, boolean z) {
        Gson gson = new Gson();
        ArrayList arrayList = new ArrayList();
        try {
            arrayList = (ArrayList) gson.fromJson(cbm.O00000o0.O00000Oo(byl.O00000oO(), "pref_key_push_classify_key", ""), new TypeToken<ArrayList<PushClassifyItem>>() {
                /* class com.mi.global.shop.model.push.PushClassifyModel.AnonymousClass1 */
            }.getType());
        } catch (Exception e) {
            cec.O000000o(context, context.getResources().getString(R.string.invalid_data), 3000);
            e.printStackTrace();
        }
        if (arrayList == null) {
            arrayList = new ArrayList();
        }
        boolean z2 = true;
        if (arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                PushClassifyItem pushClassifyItem = (PushClassifyItem) it.next();
                if (pushClassifyItem.key.equals(str)) {
                    pushClassifyItem.defaultStatus = z;
                    z2 = false;
                }
            }
        }
        if (z2) {
            PushClassifyItem pushClassifyItem2 = new PushClassifyItem();
            pushClassifyItem2.key = str;
            pushClassifyItem2.defaultStatus = z;
            arrayList.add(pushClassifyItem2);
        }
        cbm.O00000o0.O000000o(byl.O00000oO(), "pref_key_push_classify_key", gson.toJson(arrayList));
    }
}

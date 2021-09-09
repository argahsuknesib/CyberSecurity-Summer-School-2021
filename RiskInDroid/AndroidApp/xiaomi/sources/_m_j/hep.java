package _m_j;

import com.xiaomi.smarthome.device.api.spec.instance.Spec;
import com.xiaomi.smarthome.library.log.LogType;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class hep extends hcc<hej, Spec.SpecItem> {
    public ArrayList<ArrayList<Integer>> O00000o;
    public String[] O00000o0;

    public hep(JSONObject jSONObject, ArrayList<hej> arrayList) {
        if (jSONObject != null) {
            this.O00000Oo = 10001;
            JSONArray optJSONArray = jSONObject.optJSONArray("card_layout");
            this.O00000o0 = fli.O000000o(jSONObject, "disable_type");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                this.O00000o = new ArrayList<>(length);
                for (int i = 0; i < length; i++) {
                    JSONArray optJSONArray2 = optJSONArray.optJSONArray(i);
                    int length2 = optJSONArray2.length();
                    ArrayList arrayList2 = new ArrayList(length2);
                    this.O00000o.add(arrayList2);
                    int i2 = 0;
                    while (i2 < length2) {
                        int optInt = optJSONArray2.optInt(i2);
                        arrayList2.add(Integer.valueOf(optInt));
                        if (optInt < arrayList.size()) {
                            this.f18768O000000o.add(arrayList.get(optInt));
                            i2++;
                        } else {
                            LogType logType = LogType.CARD;
                            gsy.O00000o0(logType, "mijia-card", "SpecCard not match card_layout:" + this.O00000o.toString() + " index:" + optInt);
                            this.f18768O000000o.clear();
                            return;
                        }
                    }
                }
            }
        }
    }
}

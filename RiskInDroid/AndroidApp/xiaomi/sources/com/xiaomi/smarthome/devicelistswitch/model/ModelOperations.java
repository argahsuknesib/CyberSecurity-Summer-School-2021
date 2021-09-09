package com.xiaomi.smarthome.devicelistswitch.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ModelOperations implements Parcelable {
    public static final Parcelable.Creator<ModelOperations> CREATOR = new Parcelable.Creator<ModelOperations>() {
        /* class com.xiaomi.smarthome.devicelistswitch.model.ModelOperations.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ModelOperations[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new ModelOperations(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public String f7303O000000o;
    public Operation[] O00000Oo;
    private int O00000o0 = 0;

    public int describeContents() {
        return 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0049 A[SYNTHETIC, Splitter:B:18:0x0049] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005d A[Catch:{ JSONException -> 0x007f }] */
    public static List<ModelOperations> O000000o(JSONObject jSONObject) {
        boolean z;
        ArrayList arrayList = new ArrayList();
        if (jSONObject != null) {
            try {
                if (!jSONObject.isNull("model")) {
                    Object obj = jSONObject.get("model");
                    if (!jSONObject.isNull("type")) {
                        Object obj2 = jSONObject.get("type");
                        if ((obj2 instanceof JSONObject) && !((JSONObject) obj2).isNull("type_value")) {
                            Object obj3 = ((JSONObject) obj2).get("type_value");
                            if (obj3 instanceof String) {
                                z = TextUtils.equals((String) obj3, "pause-resume");
                                if (!(obj instanceof String)) {
                                    ModelOperations O000000o2 = O000000o(jSONObject.optJSONArray("operations"));
                                    O000000o2.f7303O000000o = jSONObject.optString("model");
                                    O000000o2.O00000o0 = z;
                                    arrayList.add(O000000o2);
                                } else if (obj instanceof JSONArray) {
                                    JSONArray jSONArray = (JSONArray) obj;
                                    for (int i = 0; i < jSONArray.length(); i++) {
                                        ModelOperations O000000o3 = O000000o(jSONObject.optJSONArray("operations"));
                                        O000000o3.f7303O000000o = jSONArray.optString(i);
                                        O000000o3.O00000o0 = z ? 1 : 0;
                                        arrayList.add(O000000o3);
                                    }
                                }
                            }
                        }
                    }
                    z = false;
                    if (!(obj instanceof String)) {
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    private static ModelOperations O000000o(JSONArray jSONArray) {
        ModelOperations modelOperations = new ModelOperations();
        if (jSONArray != null && jSONArray.length() > 0) {
            Operation[] operationArr = new Operation[jSONArray.length()];
            for (int i = 0; i < jSONArray.length(); i++) {
                operationArr[i] = Operation.O000000o(jSONArray.optJSONObject(i));
            }
            modelOperations.O00000Oo = operationArr;
        }
        return modelOperations;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f7303O000000o);
        parcel.writeTypedArray(this.O00000Oo, i);
    }

    public ModelOperations() {
    }

    protected ModelOperations(Parcel parcel) {
        this.f7303O000000o = parcel.readString();
        this.O00000Oo = (Operation[]) parcel.createTypedArray(Operation.CREATOR);
    }
}

package com.xiaomi.smarthome.device.api.spec.instance;

import android.os.Parcel;
import android.os.Parcelable;
import com.xiaomi.smarthome.device.api.spec.definitions.ActionDefinition;
import org.json.JSONArray;

public class SpecAction extends ActionDefinition implements Parcelable {
    public static final Parcelable.Creator<SpecAction> CREATOR = new Parcelable.Creator<SpecAction>() {
        /* class com.xiaomi.smarthome.device.api.spec.instance.SpecAction.AnonymousClass1 */

        public final SpecAction createFromParcel(Parcel parcel) {
            return new SpecAction(parcel);
        }

        public final SpecAction[] newArray(int i) {
            return new SpecAction[i];
        }
    };

    public SpecAction(int i, String str, String str2, String str3, JSONArray jSONArray, JSONArray jSONArray2) {
        super(i, str, str2, str3, jSONArray, jSONArray2);
    }

    public SpecAction(int i, String str, String str2, JSONArray jSONArray, JSONArray jSONArray2) {
        super(i, str, str2, jSONArray, jSONArray2);
    }

    protected SpecAction(Parcel parcel) {
        super(parcel);
    }

    public SpecAction(int i, ActionDefinition actionDefinition) {
        super(actionDefinition.getIid(), actionDefinition.getType(), actionDefinition.getDescription(), actionDefinition.getInJSONArray(), actionDefinition.getOutJSONArray());
    }
}

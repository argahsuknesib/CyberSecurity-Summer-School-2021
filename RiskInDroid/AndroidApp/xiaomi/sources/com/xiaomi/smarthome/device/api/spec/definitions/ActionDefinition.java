package com.xiaomi.smarthome.device.api.spec.definitions;

import _m_j.hfb;
import android.os.Parcel;
import android.os.Parcelable;
import com.xiaomi.smarthome.device.api.spec.instance.Spec;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

public class ActionDefinition extends Spec.SpecItem implements Parcelable {
    public static final Parcelable.Creator<ActionDefinition> CREATOR = new Parcelable.Creator<ActionDefinition>() {
        /* class com.xiaomi.smarthome.device.api.spec.definitions.ActionDefinition.AnonymousClass1 */

        public final ActionDefinition createFromParcel(Parcel parcel) {
            return new ActionDefinition(parcel);
        }

        public final ActionDefinition[] newArray(int i) {
            return new ActionDefinition[i];
        }
    };

    /* renamed from: in  reason: collision with root package name */
    private JSONArray f7047in;
    private JSONArray out;

    public int describeContents() {
        return 0;
    }

    public ActionDefinition getActionDefinition() {
        return this;
    }

    public ActionDefinition(int i, String str, String str2, String str3, JSONArray jSONArray, JSONArray jSONArray2) {
        super(i, str, str2, str3);
        this.f7047in = new JSONArray();
        this.out = new JSONArray();
        this.f7047in = jSONArray;
        this.out = jSONArray2;
    }

    public ActionDefinition(int i, String str, String str2, JSONArray jSONArray, JSONArray jSONArray2) {
        this(i, str, null, str2, jSONArray, jSONArray2);
    }

    protected ActionDefinition(Parcel parcel) {
        super(parcel);
        this.f7047in = new JSONArray();
        this.out = new JSONArray();
        String readString = parcel.readString();
        String readString2 = parcel.readString();
        if (readString != null) {
            try {
                this.f7047in = new JSONArray(readString);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        if (readString2 != null) {
            try {
                this.out = new JSONArray(readString2);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        JSONArray jSONArray = this.f7047in;
        String str = null;
        parcel.writeString(jSONArray == null ? null : jSONArray.toString());
        JSONArray jSONArray2 = this.out;
        if (jSONArray2 != null) {
            str = jSONArray2.toString();
        }
        parcel.writeString(str);
    }

    public List<Object> getIn() {
        return hfb.O00000Oo(this.f7047in);
    }

    public JSONArray getInJSONArray() {
        return this.f7047in;
    }

    public void setIn(List<Object> list) {
        if (list != null) {
            this.f7047in = new JSONArray((Collection<?>) list);
        }
    }

    public List<Object> getOut() {
        return hfb.O00000Oo(this.out);
    }

    public JSONArray getOutJSONArray() {
        return this.out;
    }

    public void setOut(List<Object> list) {
        if (list != null) {
            this.out = new JSONArray((Collection<?>) list);
        }
    }
}

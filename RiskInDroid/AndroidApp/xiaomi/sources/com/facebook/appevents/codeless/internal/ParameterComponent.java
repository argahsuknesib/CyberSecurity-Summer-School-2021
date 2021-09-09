package com.facebook.appevents.codeless.internal;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ParameterComponent {
    public final String name;
    public final List<PathComponent> path;
    public final String pathType;
    public final String value;

    public ParameterComponent(JSONObject jSONObject) throws JSONException {
        this.name = jSONObject.getString("name");
        this.value = jSONObject.optString("value");
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("path");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                arrayList.add(new PathComponent(optJSONArray.getJSONObject(i)));
            }
        }
        this.path = arrayList;
        this.pathType = jSONObject.optString("path_type", "absolute");
    }
}

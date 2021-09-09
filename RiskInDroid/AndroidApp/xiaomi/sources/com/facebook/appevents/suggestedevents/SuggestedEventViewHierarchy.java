package com.facebook.appevents.suggestedevents;

import android.view.View;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TimePicker;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class SuggestedEventViewHierarchy {
    static final String TAG = "com.facebook.appevents.suggestedevents.SuggestedEventViewHierarchy";
    private static final List<Class<? extends View>> blacklistedViews = new ArrayList(Arrays.asList(Switch.class, Spinner.class, DatePicker.class, TimePicker.class, RadioGroup.class, RatingBar.class, EditText.class, AdapterView.class));

    SuggestedEventViewHierarchy() {
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: org.json.JSONObject.put(java.lang.String, boolean):org.json.JSONObject
     arg types: [java.lang.String, int]
     candidates:
      org.json.JSONObject.put(java.lang.String, double):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, float):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, int):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, long):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, java.lang.Object):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, java.util.Collection<?>):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, java.util.Map<?, ?>):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, boolean):org.json.JSONObject */
    static JSONObject getDictionaryOfView(View view, View view2) {
        JSONObject jSONObject = new JSONObject();
        if (view == view2) {
            try {
                jSONObject.put("is_interacted", true);
            } catch (JSONException unused) {
            }
        }
        updateBasicInfo(view, jSONObject);
        JSONArray jSONArray = new JSONArray();
        List<View> childrenOfView = ViewHierarchy.getChildrenOfView(view);
        for (int i = 0; i < childrenOfView.size(); i++) {
            jSONArray.put(getDictionaryOfView(childrenOfView.get(i), view2));
        }
        jSONObject.put("childviews", jSONArray);
        return jSONObject;
    }

    static void updateBasicInfo(View view, JSONObject jSONObject) {
        try {
            String textOfView = ViewHierarchy.getTextOfView(view);
            String hintOfView = ViewHierarchy.getHintOfView(view);
            jSONObject.put("classname", view.getClass().getSimpleName());
            jSONObject.put("classtypebitmask", ViewHierarchy.getClassTypeBitmask(view));
            if (!textOfView.isEmpty()) {
                jSONObject.put("text", textOfView);
            }
            if (!hintOfView.isEmpty()) {
                jSONObject.put("hint", hintOfView);
            }
            if (view instanceof EditText) {
                jSONObject.put("inputtype", ((EditText) view).getInputType());
            }
        } catch (JSONException unused) {
        }
    }

    static List<View> getAllClickableViews(View view) {
        ArrayList arrayList = new ArrayList();
        for (Class<? extends View> isInstance : blacklistedViews) {
            if (isInstance.isInstance(view)) {
                return arrayList;
            }
        }
        if (view.isClickable()) {
            arrayList.add(view);
        }
        for (View allClickableViews : ViewHierarchy.getChildrenOfView(view)) {
            arrayList.addAll(getAllClickableViews(allClickableViews));
        }
        return arrayList;
    }
}

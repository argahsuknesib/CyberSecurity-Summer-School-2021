package com.facebook.appevents;

import android.os.Build;
import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.appevents.restrictivedatafilter.AddressFilterManager;
import com.facebook.appevents.restrictivedatafilter.RestrictiveDataManager;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class AppEvent implements Serializable {
    private static final long serialVersionUID = 1;
    private static final HashSet<String> validatedIdentifiers = new HashSet<>();
    private final String checksum;
    private final boolean inBackground;
    private final boolean isImplicit;
    private final JSONObject jsonObject;
    private final String name;

    public AppEvent(String str, String str2, Double d, Bundle bundle, boolean z, boolean z2, UUID uuid) throws JSONException, FacebookException {
        this.isImplicit = z;
        this.inBackground = z2;
        this.name = str2;
        this.jsonObject = getJSONObjectForAppEvent(str, str2, d, bundle, uuid);
        this.checksum = calculateChecksum();
    }

    public String getName() {
        return this.name;
    }

    private AppEvent(String str, boolean z, boolean z2, String str2) throws JSONException {
        this.jsonObject = new JSONObject(str);
        this.isImplicit = z;
        this.name = this.jsonObject.optString("_eventName");
        this.checksum = str2;
        this.inBackground = z2;
    }

    public boolean getIsImplicit() {
        return this.isImplicit;
    }

    public JSONObject getJSONObject() {
        return this.jsonObject;
    }

    public boolean isChecksumValid() {
        if (this.checksum == null) {
            return true;
        }
        return calculateChecksum().equals(this.checksum);
    }

    private static void validateIdentifier(String str) throws FacebookException {
        boolean contains;
        if (str == null || str.length() == 0 || str.length() > 40) {
            if (str == null) {
                str = "<None Provided>";
            }
            throw new FacebookException(String.format(Locale.ROOT, "Identifier '%s' must be less than %d characters", str, 40));
        }
        synchronized (validatedIdentifiers) {
            contains = validatedIdentifiers.contains(str);
        }
        if (contains) {
            return;
        }
        if (str.matches("^[0-9a-zA-Z_]+[0-9a-zA-Z _-]*$")) {
            synchronized (validatedIdentifiers) {
                validatedIdentifiers.add(str);
            }
            return;
        }
        throw new FacebookException(String.format("Skipping event named '%s' due to illegal name - must be under 40 chars and alphanumeric, _, - or space, and not start with a space or hyphen.", str));
    }

    private JSONObject getJSONObjectForAppEvent(String str, String str2, Double d, Bundle bundle, UUID uuid) throws JSONException {
        validateIdentifier(str2);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("_eventName", str2);
        jSONObject.put("_eventName_md5", md5Checksum(str2));
        jSONObject.put("_logTime", System.currentTimeMillis() / 1000);
        jSONObject.put("_ui", str);
        if (uuid != null) {
            jSONObject.put("_session_id", uuid);
        }
        if (bundle != null) {
            Map<String, String> validateParameters = validateParameters(bundle);
            for (String next : validateParameters.keySet()) {
                jSONObject.put(next, validateParameters.get(next));
            }
        }
        if (d != null) {
            jSONObject.put("_valueToSum", d.doubleValue());
        }
        if (this.inBackground) {
            jSONObject.put("_inBackground", "1");
        }
        if (this.isImplicit) {
            jSONObject.put("_implicitlyLogged", "1");
        } else {
            Logger.log(LoggingBehavior.APP_EVENTS, "AppEvents", "Created app event '%s'", jSONObject.toString());
        }
        return jSONObject;
    }

    private Map<String, String> validateParameters(Bundle bundle) throws FacebookException {
        HashMap hashMap = new HashMap();
        for (String next : bundle.keySet()) {
            validateIdentifier(next);
            Object obj = bundle.get(next);
            if ((obj instanceof String) || (obj instanceof Number)) {
                hashMap.put(next, obj.toString());
            } else {
                throw new FacebookException(String.format("Parameter value '%s' for key '%s' should be a string or a numeric type.", obj, next));
            }
        }
        AddressFilterManager.processParameters(hashMap);
        RestrictiveDataManager.processParameters(hashMap, this.name);
        return hashMap;
    }

    static class SerializationProxyV1 implements Serializable {
        private static final long serialVersionUID = -2488473066578201069L;
        private final boolean inBackground;
        private final boolean isImplicit;
        private final String jsonString;

        private SerializationProxyV1(String str, boolean z, boolean z2) {
            this.jsonString = str;
            this.isImplicit = z;
            this.inBackground = z2;
        }

        private Object readResolve() throws JSONException {
            return new AppEvent(this.jsonString, this.isImplicit, this.inBackground, null);
        }
    }

    static class SerializationProxyV2 implements Serializable {
        private static final long serialVersionUID = 20160803001L;
        private final String checksum;
        private final boolean inBackground;
        private final boolean isImplicit;
        private final String jsonString;

        private SerializationProxyV2(String str, boolean z, boolean z2, String str2) {
            this.jsonString = str;
            this.isImplicit = z;
            this.inBackground = z2;
            this.checksum = str2;
        }

        private Object readResolve() throws JSONException {
            return new AppEvent(this.jsonString, this.isImplicit, this.inBackground, this.checksum);
        }
    }

    private Object writeReplace() {
        return new SerializationProxyV2(this.jsonObject.toString(), this.isImplicit, this.inBackground, this.checksum);
    }

    public String toString() {
        return String.format("\"%s\", implicit: %b, json: %s", this.jsonObject.optString("_eventName"), Boolean.valueOf(this.isImplicit), this.jsonObject.toString());
    }

    private String calculateChecksum() {
        if (Build.VERSION.SDK_INT > 19) {
            return md5Checksum(this.jsonObject.toString());
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> keys = this.jsonObject.keys();
        while (keys.hasNext()) {
            arrayList.add(keys.next());
        }
        Collections.sort(arrayList);
        StringBuilder sb = new StringBuilder();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            sb.append(str);
            sb.append(" = ");
            sb.append(this.jsonObject.optString(str));
            sb.append(10);
        }
        return md5Checksum(sb.toString());
    }

    private static String md5Checksum(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            byte[] bytes = str.getBytes("UTF-8");
            instance.update(bytes, 0, bytes.length);
            return AppEventUtility.bytesToHex(instance.digest());
        } catch (NoSuchAlgorithmException e) {
            Utility.logd("Failed to generate checksum: ", e);
            return "0";
        } catch (UnsupportedEncodingException e2) {
            Utility.logd("Failed to generate checksum: ", e2);
            return "1";
        }
    }
}

package org.json;

import java.util.Enumeration;
import java.util.Properties;

public class Property {
    public static JSONObject toJSONObject(Properties properties) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (properties != null && !properties.isEmpty()) {
            Enumeration<?> propertyNames = properties.propertyNames();
            while (propertyNames.hasMoreElements()) {
                String str = (String) propertyNames.nextElement();
                jSONObject.put(str, properties.getProperty(str));
            }
        }
        return jSONObject;
    }

    public static Properties toProperties(JSONObject jSONObject) throws JSONException {
        Properties properties = new Properties();
        if (jSONObject != null) {
            for (String next : jSONObject.keySet()) {
                Object opt = jSONObject.opt(next);
                if (!JSONObject.NULL.equals(opt)) {
                    properties.put(next, opt.toString());
                }
            }
        }
        return properties;
    }
}

package com.hzy.tvmao.model.legacy.api;

import _m_j.ajj;
import com.fasterxml.jackson.databind.DeserializationFeature;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class o {
    public static <T> List<T> a(JSONArray jSONArray) throws Exception {
        int length = jSONArray.length();
        ArrayList arrayList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            arrayList.add(jSONArray.get(i));
        }
        return arrayList;
    }

    public static n a(String str, Map<String, String> map, Object obj) throws Exception {
        return a(str, map, obj, false, false);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.akc.O000000o(java.lang.String, java.lang.Class):T
     arg types: [T, java.lang.Class]
     candidates:
      _m_j.akc.O000000o(_m_j.ajt, _m_j.ajv):_m_j.ajw<java.lang.Object>
      _m_j.akc.O000000o(com.fasterxml.jackson.core.JsonParser, _m_j.ajs):_m_j.alf
      _m_j.akc.O000000o(com.fasterxml.jackson.core.JsonParser, _m_j.ajv):java.lang.Object
      _m_j.akc.O000000o(java.lang.String, _m_j.ajj):T
      _m_j.akc.O000000o(com.fasterxml.jackson.core.JsonGenerator, java.lang.Object):void
      _m_j.ail.O000000o(com.fasterxml.jackson.core.JsonGenerator, java.lang.Object):void
      _m_j.akc.O000000o(java.lang.String, java.lang.Class):T */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.akc.O000000o(java.lang.String, _m_j.ajj):T
     arg types: [T, _m_j.ajj]
     candidates:
      _m_j.akc.O000000o(_m_j.ajt, _m_j.ajv):_m_j.ajw<java.lang.Object>
      _m_j.akc.O000000o(com.fasterxml.jackson.core.JsonParser, _m_j.ajs):_m_j.alf
      _m_j.akc.O000000o(com.fasterxml.jackson.core.JsonParser, _m_j.ajv):java.lang.Object
      _m_j.akc.O000000o(java.lang.String, java.lang.Class):T
      _m_j.akc.O000000o(com.fasterxml.jackson.core.JsonGenerator, java.lang.Object):void
      _m_j.ail.O000000o(com.fasterxml.jackson.core.JsonGenerator, java.lang.Object):void
      _m_j.akc.O000000o(java.lang.String, _m_j.ajj):T */
    public static n a(String str, Map<String, String> map, Object obj, boolean z, boolean z2) throws Exception {
        c cVar = new c(true);
        cVar.a(z);
        cVar.b(z2);
        if (map != null) {
            cVar.a(map);
        }
        Map<String, Object> a2 = cVar.a(str, false);
        if (!a2.get("errno").equals("0")) {
            return n.a(0, (String) a2.get("content"));
        }
        JSONArray jSONArray = new JSONArray((String) a2.get("content"));
        n nVar = new n();
        nVar.f4436a = jSONArray.getInt(0);
        nVar.b = jSONArray.getString(1);
        String str2 = (String) a2.get("Cookie");
        if (str2 != null) {
            nVar.c = str2;
        }
        T t = "";
        if (nVar.f4436a == 2) {
            if (jSONArray.length() > 2) {
                t = jSONArray.getString(2);
            }
            nVar.e = t;
            if (z2) {
                nVar.d = (byte[]) a2.get("encrypt_data");
            }
            return nVar;
        }
        if (nVar.a()) {
            T string = jSONArray.length() > 2 ? jSONArray.getString(2) : t;
            if (obj == null || obj == JSONObject.class) {
                if (string.length() > 0) {
                    t = new JSONObject((String) string);
                }
                nVar.e = t;
            } else if (obj == Object.class) {
                List a3 = a(jSONArray);
                nVar.e = a3.subList(2, a3.size());
            } else if (obj instanceof Class) {
                f.a().b().O00000Oo(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
                nVar.e = f.a().b().O000000o((String) string, (Class) obj);
            } else if (obj instanceof ajj) {
                f.a().b().O000000o(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
                nVar.e = f.a().b().O000000o((String) string, (ajj) obj);
            }
            if (z2) {
                nVar.d = (byte[]) a2.get("encrypt_data");
            }
        }
        return nVar;
    }
}

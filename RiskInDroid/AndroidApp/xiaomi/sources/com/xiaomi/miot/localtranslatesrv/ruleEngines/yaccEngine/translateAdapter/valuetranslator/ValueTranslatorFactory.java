package com.xiaomi.miot.localtranslatesrv.ruleEngines.yaccEngine.translateAdapter.valuetranslator;

import _m_j.jcu;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class ValueTranslatorFactory {
    private final Map<String, ValueProcessor> valueProcessors;

    static class Holder {
        public static final ValueTranslatorFactory INSTANCE = new ValueTranslatorFactory();

        private Holder() {
        }
    }

    public static ValueTranslatorFactory get() {
        return Holder.INSTANCE;
    }

    private ValueTranslatorFactory() {
        this.valueProcessors = new HashMap();
    }

    public void init() {
        try {
            init(model2clazz("/valuetranslator.json"));
        } catch (Exception unused) {
            System.out.println("read the processor config file failed ! ");
        }
    }

    private void init(JSONObject jSONObject) throws Exception {
        for (String next : jSONObject.keySet()) {
            this.valueProcessors.put(next, createDeviceInstance(String.valueOf(jSONObject.get(next))));
        }
    }

    public ValueProcessor getValueProcessor(String str) {
        return this.valueProcessors.get(str);
    }

    private JSONObject model2clazz(String str) throws IOException {
        return new JSONObject(jcu.O000000o(getClass().getResourceAsStream(str), Charset.defaultCharset()));
    }

    private ValueProcessor createDeviceInstance(String str) throws Exception {
        try {
            try {
                Object newInstance = Class.forName(str).newInstance();
                if (newInstance instanceof ValueProcessor) {
                    return (ValueProcessor) newInstance;
                }
                throw new Exception("create processor failed ! ");
            } catch (IllegalAccessException | InstantiationException unused) {
                throw new Exception("create processor failed ! ");
            }
        } catch (ClassNotFoundException unused2) {
            throw new Exception("create processor failed ! ");
        }
    }
}

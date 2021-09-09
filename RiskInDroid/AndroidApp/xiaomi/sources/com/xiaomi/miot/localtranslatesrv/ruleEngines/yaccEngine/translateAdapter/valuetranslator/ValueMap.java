package com.xiaomi.miot.localtranslatesrv.ruleEngines.yaccEngine.translateAdapter.valuetranslator;

import com.xiaomi.miot.localtranslatesrv.core.metaDatas.InputTranslateSource;
import com.xiaomi.miot.localtranslatesrv.core.metaDatas.OutputTranslateTarget;
import com.xiaomi.miot.localtranslatesrv.core.metaDatas.TranslateMeta;
import org.json.JSONObject;

public class ValueMap extends ValueProcessor {
    public void Translate(InputTranslateSource inputTranslateSource, OutputTranslateTarget outputTranslateTarget, TranslateMeta translateMeta) {
        try {
            try {
                outputTranslateTarget.setTargetValue(new JSONObject(translateMeta.getConfig().getTargetValueTranslateExpression()).toMap().get((String) inputTranslateSource.getSrcValue()));
            } catch (Exception unused) {
                System.out.println("targetValue is not found in map ! ");
            }
        } catch (Exception unused2) {
            System.out.println("Json paser error: translatedcode expression ! ");
        }
    }
}

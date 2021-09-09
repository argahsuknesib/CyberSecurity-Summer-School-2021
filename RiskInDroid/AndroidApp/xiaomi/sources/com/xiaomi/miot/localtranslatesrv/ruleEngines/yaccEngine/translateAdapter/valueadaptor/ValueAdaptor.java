package com.xiaomi.miot.localtranslatesrv.ruleEngines.yaccEngine.translateAdapter.valueadaptor;

import com.xiaomi.miot.localtranslatesrv.core.metaDatas.InputTranslateSource;
import com.xiaomi.miot.localtranslatesrv.core.metaDatas.OutputTranslateTarget;
import com.xiaomi.miot.localtranslatesrv.core.metaDatas.TranslateMeta;
import com.xiaomi.miot.localtranslatesrv.ruleEngines.yaccEngine.translateAdapter.valuetranslator.Translator;
import com.xiaomi.miot.localtranslatesrv.ruleEngines.yaccEngine.translateAdapter.valuetranslator.ValueTranslatorFactory;

public class ValueAdaptor implements Translator {
    private static String doNothing = "donothing";
    private static String expression = "expression";
    private static String rangeMap = "rangemap";
    private static String typeParse = "typeparse";
    private static String valueMap = "valuemap";

    public void Translate(InputTranslateSource inputTranslateSource, OutputTranslateTarget outputTranslateTarget, TranslateMeta translateMeta) throws Exception {
        outputTranslateTarget.setTargetType(translateMeta.getConfig().getTargetType());
        outputTranslateTarget.setTargetKey(translateMeta.getConfig().getTargetKey());
        outputTranslateTarget.setTargetId(translateMeta.getConfig().getTargetId());
        outputTranslateTarget.setAdditionalMethod(translateMeta.getConfig().getAdditionalMethod());
        outputTranslateTarget.setMetaData(translateMeta.getMetaData());
        if (inputTranslateSource.getSrcValue() != null) {
            ValueTranslatorFactory.get().init();
            int valueTranslateType = translateMeta.getConfig().getValueTranslateType();
            if (valueTranslateType == 0) {
                ValueTranslatorFactory.get().getValueProcessor(doNothing).Translate(inputTranslateSource, outputTranslateTarget, translateMeta);
            } else if (valueTranslateType == 1) {
                ValueTranslatorFactory.get().getValueProcessor(typeParse).Translate(inputTranslateSource, outputTranslateTarget, translateMeta);
            } else if (valueTranslateType == 2) {
                ValueTranslatorFactory.get().getValueProcessor(valueMap).Translate(inputTranslateSource, outputTranslateTarget, translateMeta);
            } else if (valueTranslateType == 3) {
                ValueTranslatorFactory.get().getValueProcessor(rangeMap).Translate(inputTranslateSource, outputTranslateTarget, translateMeta);
            } else if (valueTranslateType == 4) {
                ValueTranslatorFactory.get().getValueProcessor(expression).Translate(inputTranslateSource, outputTranslateTarget, translateMeta);
            } else {
                throw new Exception("not a valid value translated code type in conf");
            }
        }
    }
}

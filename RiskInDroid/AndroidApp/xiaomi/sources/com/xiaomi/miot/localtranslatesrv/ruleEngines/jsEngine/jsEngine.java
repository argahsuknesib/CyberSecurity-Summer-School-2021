package com.xiaomi.miot.localtranslatesrv.ruleEngines.jsEngine;

import com.xiaomi.miot.localtranslatesrv.core.metaDatas.InputTranslateSource;
import com.xiaomi.miot.localtranslatesrv.core.metaDatas.OutputTranslateTarget;
import com.xiaomi.miot.localtranslatesrv.core.metaDatas.TranslateMeta;
import com.xiaomi.miot.localtranslatesrv.ruleEngines.core.ruleBasedTranslator;

public class jsEngine implements ruleBasedTranslator {
    public OutputTranslateTarget Translate(InputTranslateSource inputTranslateSource, TranslateMeta translateMeta) throws Exception {
        return new OutputTranslateTarget();
    }
}

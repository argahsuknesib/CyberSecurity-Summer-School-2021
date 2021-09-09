package com.xiaomi.miot.localtranslatesrv.ruleEngines.core;

import com.xiaomi.miot.localtranslatesrv.core.metaDatas.InputTranslateSource;
import com.xiaomi.miot.localtranslatesrv.core.metaDatas.OutputTranslateTarget;
import com.xiaomi.miot.localtranslatesrv.core.metaDatas.TranslateMeta;

public interface ruleBasedTranslator {
    OutputTranslateTarget Translate(InputTranslateSource inputTranslateSource, TranslateMeta translateMeta) throws Exception;
}

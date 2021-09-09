package com.xiaomi.miot.localtranslatesrv.core.metaDatas;

public class TranslateMeta {
    private TranslateConfig config;
    private MetaData metaData;

    public MetaData getMetaData() {
        return this.metaData;
    }

    public TranslateConfig getConfig() {
        return this.config;
    }

    public void setConfig(TranslateConfig translateConfig) {
        this.config = translateConfig;
    }

    public void setMetaData(MetaData metaData2) {
        this.metaData = metaData2;
    }
}

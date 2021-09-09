package com.xiaomi.miot.localtranslatesrv;

import com.xiaomi.miot.localtranslatesrv.core.ProfileProperty;
import com.xiaomi.miot.localtranslatesrv.core.SpecProperty;
import com.xiaomi.miot.localtranslatesrv.core.coreInterface.TranslateEngine;
import com.xiaomi.miot.localtranslatesrv.core.metaDatas.translateStatus;
import com.xiaomi.miot.localtranslatesrv.database.DatabaseExecutor;
import com.xiaomi.miot.localtranslatesrv.database.DatabaseExecutorBuilder;
import com.xiaomi.miot.localtranslatesrv.ruleEngines.RuleEngineManager;
import java.sql.SQLException;

public class LocalTranslateManager implements TranslateEngine {
    private DatabaseExecutor dataBaseExecutor;
    private TranslateEngine engine = new RuleEngineManager();

    public ProfileProperty encodeGetProp(String str, SpecProperty specProperty) {
        return null;
    }

    public ProfileProperty encodeRpcJson(String str, SpecProperty specProperty, TranslateEngine.RPC_TYPE rpc_type) throws Exception {
        return null;
    }

    public void setDataBaseBuilder(DatabaseExecutorBuilder databaseExecutorBuilder) throws Exception {
        this.dataBaseExecutor = databaseExecutorBuilder.createExecutor();
        this.engine.setDataBaseBuilder(databaseExecutorBuilder);
    }

    public SpecProperty propProfileToSpec(String str, ProfileProperty profileProperty) {
        TranslateEngine translateEngine = this.engine;
        if (isSpecNative(profileProperty.getModel())) {
            SpecProperty specProperty = new SpecProperty();
            specProperty.setStatus(translateStatus.TRANSLATE_RETURN_NOTNEEDTRANS);
            return specProperty;
        } else if (!isCloudTranslateOnly(profileProperty.getModel())) {
            return translateEngine.propProfileToSpec(str, profileProperty);
        } else {
            SpecProperty specProperty2 = new SpecProperty();
            specProperty2.setStatus(translateStatus.TRANSLATE_RETURN_CLOUD_CODE);
            return specProperty2;
        }
    }

    public ProfileProperty propSpecToProfile(String str, SpecProperty specProperty) {
        TranslateEngine translateEngine = this.engine;
        if (isSpecNative(specProperty.getModel())) {
            ProfileProperty profileProperty = new ProfileProperty();
            profileProperty.setStatus(translateStatus.TRANSLATE_RETURN_NOTNEEDTRANS);
            return profileProperty;
        } else if (!isCloudTranslateOnly(specProperty.getModel())) {
            return translateEngine.propSpecToProfile(str, specProperty);
        } else {
            ProfileProperty profileProperty2 = new ProfileProperty();
            profileProperty2.setStatus(translateStatus.TRANSLATE_RETURN_CLOUD_CODE);
            return profileProperty2;
        }
    }

    public ProfileProperty actionSpecToProfile(String str, SpecProperty specProperty) {
        TranslateEngine translateEngine = this.engine;
        if (isSpecNative(specProperty.getModel())) {
            ProfileProperty profileProperty = new ProfileProperty();
            profileProperty.setStatus(translateStatus.TRANSLATE_RETURN_NOTNEEDTRANS);
            return profileProperty;
        } else if (!isCloudTranslateOnly(specProperty.getModel())) {
            return translateEngine.actionSpecToProfile(str, specProperty);
        } else {
            ProfileProperty profileProperty2 = new ProfileProperty();
            profileProperty2.setStatus(translateStatus.TRANSLATE_RETURN_CLOUD_CODE);
            return profileProperty2;
        }
    }

    public SpecProperty actionProfileToSpec(String str, ProfileProperty profileProperty) {
        TranslateEngine translateEngine = this.engine;
        if (isSpecNative(profileProperty.getModel())) {
            SpecProperty specProperty = new SpecProperty();
            specProperty.setStatus(translateStatus.TRANSLATE_RETURN_NOTNEEDTRANS);
            return specProperty;
        } else if (!isCloudTranslateOnly(profileProperty.getModel())) {
            return translateEngine.actionProfileToSpec(str, profileProperty);
        } else {
            SpecProperty specProperty2 = new SpecProperty();
            specProperty2.setStatus(translateStatus.TRANSLATE_RETURN_CLOUD_CODE);
            return specProperty2;
        }
    }

    public SpecProperty eventProfileToSpec(String str, ProfileProperty profileProperty) {
        TranslateEngine translateEngine = this.engine;
        if (isSpecNative(profileProperty.getModel())) {
            SpecProperty specProperty = new SpecProperty();
            specProperty.setStatus(translateStatus.TRANSLATE_RETURN_NOTNEEDTRANS);
            return specProperty;
        } else if (!isCloudTranslateOnly(profileProperty.getModel())) {
            return translateEngine.eventProfileToSpec(str, profileProperty);
        } else {
            SpecProperty specProperty2 = new SpecProperty();
            specProperty2.setStatus(translateStatus.TRANSLATE_RETURN_CLOUD_CODE);
            return specProperty2;
        }
    }

    public ProfileProperty eventSpecToProfile(String str, SpecProperty specProperty) {
        TranslateEngine translateEngine = this.engine;
        if (isSpecNative(specProperty.getModel())) {
            ProfileProperty profileProperty = new ProfileProperty();
            profileProperty.setStatus(translateStatus.TRANSLATE_RETURN_NOTNEEDTRANS);
            return profileProperty;
        } else if (!isCloudTranslateOnly(specProperty.getModel())) {
            return translateEngine.eventSpecToProfile(str, specProperty);
        } else {
            ProfileProperty profileProperty2 = new ProfileProperty();
            profileProperty2.setStatus(translateStatus.TRANSLATE_RETURN_CLOUD_CODE);
            return profileProperty2;
        }
    }

    private boolean isCloudTranslateOnly(String str) {
        boolean z;
        try {
            z = this.dataBaseExecutor.hasTranslateRule("select * from profiles where model = '" + str + "' and hasRule = 1");
        } catch (SQLException e) {
            e.printStackTrace();
            z = false;
        }
        if (!z) {
            return true;
        }
        return false;
    }

    private boolean isSpecNative(String str) {
        boolean z;
        try {
            z = this.dataBaseExecutor.hasTargetModel("select * from profiles where model = '" + str + "'");
        } catch (SQLException e) {
            e.printStackTrace();
            z = false;
        }
        if (!z) {
            return true;
        }
        return false;
    }
}

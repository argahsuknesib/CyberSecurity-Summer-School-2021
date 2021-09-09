package com.xiaomi.miot.localtranslatesrv.ruleEngines;

import com.xiaomi.miot.localtranslatesrv.core.ProfileProperty;
import com.xiaomi.miot.localtranslatesrv.core.SpecProperty;
import com.xiaomi.miot.localtranslatesrv.core.coreInterface.TranslateEngine;
import com.xiaomi.miot.localtranslatesrv.core.metaDatas.InputTranslateSource;
import com.xiaomi.miot.localtranslatesrv.core.metaDatas.MetaData;
import com.xiaomi.miot.localtranslatesrv.core.metaDatas.OutputTranslateTarget;
import com.xiaomi.miot.localtranslatesrv.core.metaDatas.TranslateConfig;
import com.xiaomi.miot.localtranslatesrv.core.metaDatas.TranslateMeta;
import com.xiaomi.miot.localtranslatesrv.core.metaDatas.translateStatus;
import com.xiaomi.miot.localtranslatesrv.database.DatabaseExecutor;
import com.xiaomi.miot.localtranslatesrv.database.DatabaseExecutorBuilder;
import com.xiaomi.miot.localtranslatesrv.ruleEngines.yaccEngine.yaccEngine;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONObject;

public class RuleEngineManager implements TranslateEngine {
    private yaccEngine engine = new yaccEngine();
    private DatabaseExecutor executor;

    public ProfileProperty encodeGetProp(String str, SpecProperty specProperty) {
        return null;
    }

    public ProfileProperty encodeRpcJson(String str, SpecProperty specProperty, TranslateEngine.RPC_TYPE rpc_type) {
        return null;
    }

    public void setDataBaseBuilder(DatabaseExecutorBuilder databaseExecutorBuilder) throws Exception {
        this.executor = databaseExecutorBuilder.createExecutor();
    }

    public SpecProperty propProfileToSpec(String str, ProfileProperty profileProperty) {
        return profileToSpec(str, "prop.", profileProperty);
    }

    public ProfileProperty propSpecToProfile(String str, SpecProperty specProperty) {
        return specToProfile(str, "prop.", specProperty);
    }

    public ProfileProperty actionSpecToProfile(String str, SpecProperty specProperty) {
        try {
            return specToProfile(str, "action.", specProperty);
        } catch (Exception unused) {
            System.out.println("spec To profile failed, action ! ");
            return null;
        }
    }

    public SpecProperty actionProfileToSpec(String str, ProfileProperty profileProperty) {
        return profileToSpec(str, "action.", profileProperty);
    }

    public ProfileProperty eventSpecToProfile(String str, SpecProperty specProperty) {
        try {
            return specToProfile(str, "event.", specProperty);
        } catch (Exception unused) {
            System.out.println("spec To profile failed, event ! ");
            return null;
        }
    }

    public SpecProperty eventProfileToSpec(String str, ProfileProperty profileProperty) {
        return profileToSpec(str, "event.", profileProperty);
    }

    private SpecProperty profileToSpec(String str, String str2, ProfileProperty profileProperty) {
        SpecProperty specProperty = new SpecProperty();
        Object value = profileProperty.getValue();
        InputTranslateSource inputTranslateSource = new InputTranslateSource();
        inputTranslateSource.setSrcKey(str2 + profileProperty.getName());
        inputTranslateSource.setSrcType(1);
        inputTranslateSource.setSrcId(profileProperty.getModel());
        inputTranslateSource.setTargetType(0);
        inputTranslateSource.setTargetKey(null);
        inputTranslateSource.setSrcValue(value);
        try {
            TranslateMeta translateInfo = getTranslateInfo(inputTranslateSource);
            if (translateInfo == null) {
                SpecProperty specProperty2 = new SpecProperty();
                specProperty2.setStatus(translateStatus.TRANSLATE_NOT_FIND_RULE);
                return specProperty2;
            }
            OutputTranslateTarget Translate = this.engine.Translate(inputTranslateSource, translateInfo);
            try {
                int[] instanceIdFromKey = getInstanceIdFromKey(Translate.getTargetKey());
                specProperty.setServiceInstanceId(instanceIdFromKey[0]);
                specProperty.setPropActionEventId(instanceIdFromKey[1]);
                specProperty.setStatus(0);
                specProperty.setModel(Translate.getTargetId());
                specProperty.setValue(Translate.getTargetValue());
                specProperty.setDeviceInstanceId(profileProperty.getDeviceInstanceId());
                return specProperty;
            } catch (Exception unused) {
                System.out.println("parse outputTranslateTarget siid piid failed \n");
                SpecProperty specProperty3 = new SpecProperty();
                specProperty3.setStatus(translateStatus.TRANSLATE_RETURN_ERROR);
                return specProperty3;
            }
        } catch (Exception e) {
            System.out.println("Rule Engine Manager Translate failed \n" + e.getMessage());
            SpecProperty specProperty4 = new SpecProperty();
            specProperty4.setStatus(translateStatus.TRANSLATE_RETURN_ERROR);
            return specProperty4;
        }
    }

    private ProfileProperty specToProfile(String str, String str2, SpecProperty specProperty) {
        String str3;
        ProfileProperty profileProperty = new ProfileProperty();
        InputTranslateSource inputTranslateSource = new InputTranslateSource();
        inputTranslateSource.setSrcType(0);
        inputTranslateSource.setSrcId(getSpecTypeByModel(specProperty.getModel()));
        inputTranslateSource.setSrcKey(str2 + specProperty.getServiceInstanceId() + "." + specProperty.getPropActionEventId());
        inputTranslateSource.setTargetType(1);
        if (specProperty.getValue() != null && String.valueOf(specProperty.getValue()).length() > 0) {
            inputTranslateSource.setSrcValue(specProperty.getValue());
        }
        try {
            TranslateMeta translateInfo = getTranslateInfo(inputTranslateSource);
            if (translateInfo == null) {
                ProfileProperty profileProperty2 = new ProfileProperty();
                profileProperty2.setStatus(translateStatus.TRANSLATE_NOT_FIND_RULE);
                return profileProperty2;
            }
            OutputTranslateTarget Translate = this.engine.Translate(inputTranslateSource, translateInfo);
            String targetKey = Translate.getTargetKey();
            if (targetKey != null) {
                String valueOf = String.valueOf(targetKey);
                String[] split = valueOf.split("\\.");
                str3 = split.length >= 2 ? String.join(".", (CharSequence[]) Arrays.copyOfRange(split, 1, split.length)) : valueOf;
            } else {
                str3 = null;
            }
            profileProperty.setName(str3);
            profileProperty.setModel(specProperty.getModel());
            profileProperty.setStatus(0);
            if (Translate.getTargetValue() == null) {
                profileProperty.setValue(null);
            } else if (Translate.getTargetValue().getClass().isArray()) {
                profileProperty.setValue(new JSONArray(Translate.getTargetValue()));
            } else {
                profileProperty.setValue(Translate.getTargetValue());
            }
            if (Translate.getAdditionalMethod() != null && Translate.getAdditionalMethod().length() > 0) {
                profileProperty.setSpecialSetMethod(Translate.getAdditionalMethod());
            }
            if (Translate.getMetaData() != null) {
                MetaData metaData = (MetaData) Translate.getMetaData();
                if (metaData.getAdditionalGetMethod() != null && metaData.getAdditionalGetMethod().length() > 0) {
                    profileProperty.setSpecialGetMethod(metaData.getAdditionalGetMethod());
                }
                if (metaData.getSubscribePropName() != null && metaData.getSubscribePropName().length() > 0) {
                    profileProperty.setSubscribePropName(metaData.getSubscribePropName().split("\\.")[1]);
                }
            }
            return profileProperty;
        } catch (Exception e) {
            System.out.println("Rule Engine Manager Translate failed \n" + e.getMessage());
            ProfileProperty profileProperty3 = new ProfileProperty();
            profileProperty3.setStatus(translateStatus.TRANSLATE_RETURN_ERROR);
            return profileProperty3;
        }
    }

    private int[] getInstanceIdFromKey(String str) throws Exception {
        String[] split = str.split("\\.");
        if (split.length >= 3) {
            return new int[]{Integer.parseInt(split[1], 10), Integer.parseInt(split[2], 10)};
        }
        throw new Exception("Key error ".concat(String.valueOf(str)));
    }

    private String warpSpecToProfileValue(String str, Object obj) {
        JSONObject jSONObject = new JSONObject();
        if (obj.getClass().isArray()) {
            jSONObject.put("method", str).put("params", new JSONArray(obj));
        } else {
            jSONObject.put("method", str).put("params", String.valueOf(obj));
        }
        return jSONObject.toString();
    }

    private String getSpecTypeByModel(String str) {
        if (str == null || str.length() == 0) {
            System.out.println("model don't exist! ");
            return null;
        }
        try {
            return this.executor.getSpecTypeByModel("select SrcId from result where TargetId = \"" + str + "\" limit 1");
        } catch (Exception unused) {
            System.out.println("Query SpecType by Model Failed !");
            return null;
        }
    }

    private TranslateMeta getTranslateInfo(InputTranslateSource inputTranslateSource) throws Exception {
        TranslateMeta translateMeta = new TranslateMeta();
        TranslateConfig translateMappingRules = getTranslateMappingRules(inputTranslateSource);
        if (translateMappingRules == null) {
            return null;
        }
        decodeTranslateConfig(translateMappingRules);
        translateMeta.setMetaData(getTranslateMappingMetaData(translateMappingRules));
        translateMeta.setConfig(translateMappingRules);
        return translateMeta;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0029, code lost:
        if (r6.length() > 0) goto L_0x002d;
     */
    private MetaData getTranslateMappingMetaData(TranslateConfig translateConfig) {
        String str;
        MetaData metaData = new MetaData();
        String str2 = null;
        if (translateConfig.getMetaData() != null) {
            JSONObject jSONObject = new JSONObject(translateConfig.getMetaData());
            if (jSONObject.has("additionalGetMethod")) {
                str = jSONObject.get("additionalGetMethod").toString();
            }
            str = null;
            if (jSONObject.has("subscribePropName")) {
                str2 = jSONObject.get("subscribePropName").toString();
            }
        } else {
            str = null;
        }
        metaData.setAdditionalGetMethod(str);
        metaData.setSubscribePropName(str2);
        return metaData;
    }

    private TranslateConfig getTranslateMappingRules(InputTranslateSource inputTranslateSource) throws Exception {
        if (inputTranslateSource != null) {
            return this.executor.queryTranslateConfig("select * from result where " + "SrcType = " + inputTranslateSource.getSrcType() + " and SrcId = \"" + inputTranslateSource.getSrcId() + "\" and SrcKey = \"" + inputTranslateSource.getSrcKey() + "\" and TargetType = " + inputTranslateSource.getTargetType());
        }
        throw new Exception("input TranslateSource is null ! ");
    }

    private void decodeTranslateConfig(TranslateConfig translateConfig) {
        if (translateConfig.getMetaData() != null) {
            JSONObject jSONObject = new JSONObject(translateConfig.getMetaData());
            if (jSONObject.has("additionalGetMethod") && jSONObject.getString("additionalGetMethod").length() > 0) {
                translateConfig.setAdditionalGetMethod(jSONObject.getString("additionalGetMethod"));
            }
            if (jSONObject.has("subscribePropName") && jSONObject.getString("subscribePropName").length() > 0) {
                translateConfig.setSubcribePropName(jSONObject.getString("subscribePropName"));
            }
            if (jSONObject.has("setMethodExpression") && jSONObject.getString("setMethodExpression").length() > 0) {
                translateConfig.setSetMethodExpression(jSONObject.getString("setMethodExpression"));
            }
        }
    }
}

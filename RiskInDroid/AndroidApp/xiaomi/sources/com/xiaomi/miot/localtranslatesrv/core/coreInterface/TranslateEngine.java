package com.xiaomi.miot.localtranslatesrv.core.coreInterface;

import com.xiaomi.miot.localtranslatesrv.core.ProfileProperty;
import com.xiaomi.miot.localtranslatesrv.core.SpecProperty;
import com.xiaomi.miot.localtranslatesrv.database.DatabaseExecutorBuilder;

public interface TranslateEngine {

    public enum RPC_TYPE {
        SET,
        ACTION
    }

    SpecProperty actionProfileToSpec(String str, ProfileProperty profileProperty);

    ProfileProperty actionSpecToProfile(String str, SpecProperty specProperty);

    ProfileProperty encodeGetProp(String str, SpecProperty specProperty) throws Exception;

    ProfileProperty encodeRpcJson(String str, SpecProperty specProperty, RPC_TYPE rpc_type) throws Exception;

    SpecProperty eventProfileToSpec(String str, ProfileProperty profileProperty);

    ProfileProperty eventSpecToProfile(String str, SpecProperty specProperty);

    SpecProperty propProfileToSpec(String str, ProfileProperty profileProperty);

    ProfileProperty propSpecToProfile(String str, SpecProperty specProperty);

    void setDataBaseBuilder(DatabaseExecutorBuilder databaseExecutorBuilder) throws Exception;
}

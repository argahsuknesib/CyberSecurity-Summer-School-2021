package com.miui.tsmclient.net.request;

import com.miui.tsmclient.common.net.request.GsonRequest;
import com.tsmclient.smartcard.model.ConfigRules;

public class ConfigRulesRequest extends GsonRequest<ConfigRules> {
    public ConfigRulesRequest(String str) {
        super(0, str, ConfigRules.class);
        setPersistence();
    }
}

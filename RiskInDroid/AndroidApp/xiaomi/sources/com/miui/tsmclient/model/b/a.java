package com.miui.tsmclient.model.b;

import com.miui.tsmclient.account.TSMAccountManager;
import com.miui.tsmclient.entity.CardInfo;
import com.miui.tsmclient.model.c;
import com.miui.tsmclient.net.TSMAuthContants;

public class a extends c {
    protected TSMAccountManager c;
    private CardInfo d = new CardInfo("DUMMY");

    public a() {
        this.b = TSMAuthContants.BusinessType.sptc.toString();
        this.c = new TSMAccountManager();
    }
}

package com.ximalaya.ting.android.opensdk.datatrasfer;

import _m_j.iit;
import java.util.HashSet;

public class CommonRequest$1 extends HashSet<String> {
    final /* synthetic */ iit this$0;

    public CommonRequest$1(iit iit) {
        this.this$0 = iit;
        add(iit.O000000o("http://adse.ximalaya.com/soundPatch"));
        add(iit.O000000o("http://api.ximalaya.com/version/get_latest_version"));
        add(iit.O000000o("https://mpay.ximalaya.com/openapi-payfacade-app/open_pay/get_obfuscated_play_info"));
    }
}

package com.ximalaya.ting.android.opensdk.datatrasfer;

import com.ximalaya.ting.android.opensdk.util.dh.DhKeyPair;
import java.util.HashMap;

public class AccessTokenBaseCall$2 extends HashMap<String, String> {
    final /* synthetic */ DhKeyPair val$dhKeyPair;

    public AccessTokenBaseCall$2(DhKeyPair dhKeyPair) {
        this.val$dhKeyPair = dhKeyPair;
        put("c_pub_key", this.val$dhKeyPair.publicKey.toString());
    }
}

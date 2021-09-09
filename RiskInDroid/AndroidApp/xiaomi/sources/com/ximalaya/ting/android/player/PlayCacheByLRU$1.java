package com.ximalaya.ting.android.player;

import _m_j.ime;
import _m_j.imf;
import java.util.LinkedHashMap;
import java.util.Map;

public class PlayCacheByLRU$1 extends LinkedHashMap<String, String> {
    final /* synthetic */ ime this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PlayCacheByLRU$1(ime ime, int i) {
        super(i, 0.75f, true);
        this.this$0 = ime;
    }

    /* access modifiers changed from: protected */
    public boolean removeEldestEntry(Map.Entry<String, String> entry) {
        if (size() <= ime.f1460O000000o) {
            return false;
        }
        imf.O000000o(entry.getKey());
        return true;
    }
}

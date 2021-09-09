package com.xiaomi.verificationsdk;

import _m_j.iar;
import _m_j.iau;
import _m_j.iba;
import java.util.concurrent.Callable;

public class VerificationManager$11 implements Callable<iau> {
    final /* synthetic */ iar this$0;
    final /* synthetic */ String val$url;

    public VerificationManager$11(iar iar, String str) {
        this.this$0 = iar;
        this.val$url = str;
    }

    public iau call() throws Exception {
        return iba.O000000o(this.val$url);
    }
}

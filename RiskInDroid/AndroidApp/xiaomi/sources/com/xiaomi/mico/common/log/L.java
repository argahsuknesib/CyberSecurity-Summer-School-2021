package com.xiaomi.mico.common.log;

import _m_j.ahg;
import _m_j.ahh;

public class L {
    public static ahg auxIn = build("MICO.auxIn");
    public static ahg bt = build("Mico.bt");
    public static ahg debug = build("MICO.debug");
    public static ahg schoolTimeTable = build("Mico.schoolTimeTable");
    public static ahg voicePrint = build("Mico.voicePrint");
    public static ahg xiaoMiVoip = build("Mico.xiaoMiVoip");

    private static ahg build(String str) {
        new ahh();
        return new ahg();
    }
}

package com.typesafe.config.impl;

import _m_j.dry;
import _m_j.dsj;
import _m_j.dss;
import _m_j.dsz;
import java.util.concurrent.Callable;

public class ConfigImpl$1 implements Callable<dry> {
    final /* synthetic */ ClassLoader val$loader;

    public ConfigImpl$1(ClassLoader classLoader) {
        this.val$loader = classLoader;
    }

    public final dry call() {
        return dss.O00000o0().O000000o(dsz.O000000o("reference.conf", dsj.O000000o().O000000o(this.val$loader)).O00000oO().O000000o()).O00000Oo();
    }
}

package com.typesafe.config;

import _m_j.dry;
import _m_j.drz;
import _m_j.dsj;
import _m_j.dsm;
import java.util.concurrent.Callable;

public class ConfigFactory$1 implements Callable<dry> {
    final /* synthetic */ dsm val$resolveOptions;
    final /* synthetic */ dsj val$withLoader;

    ConfigFactory$1(dsj dsj, dsm dsm) {
        this.val$withLoader = dsj;
        this.val$resolveOptions = dsm;
    }

    public final dry call() {
        return drz.O000000o(this.val$withLoader, this.val$resolveOptions);
    }
}

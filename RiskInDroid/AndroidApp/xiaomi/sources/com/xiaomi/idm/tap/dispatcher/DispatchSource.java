package com.xiaomi.idm.tap.dispatcher;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class DispatchSource {

    @Retention(RetentionPolicy.SOURCE)
    public @interface Source {
    }
}

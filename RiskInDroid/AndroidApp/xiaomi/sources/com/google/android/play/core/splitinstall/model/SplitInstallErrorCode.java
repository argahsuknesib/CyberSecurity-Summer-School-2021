package com.google.android.play.core.splitinstall.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.CLASS)
public @interface SplitInstallErrorCode {
    @Deprecated
    public static final int SERVICE_DIED = -9;
}

package com.google.android.play.core.install.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.CLASS)
public @interface InstallErrorCode {
    @Deprecated
    public static final int NO_ERROR_PARTIALLY_ALLOWED = 1;
}

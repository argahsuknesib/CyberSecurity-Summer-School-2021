package com.google.android.play.core.install.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.CLASS)
public @interface InstallStatus {
    @Deprecated
    public static final int REQUIRES_UI_INTENT = 10;
}

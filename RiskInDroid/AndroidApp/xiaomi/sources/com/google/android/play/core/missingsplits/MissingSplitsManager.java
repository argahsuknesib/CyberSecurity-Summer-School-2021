package com.google.android.play.core.missingsplits;

public interface MissingSplitsManager {
    boolean disableAppIfMissingRequiredSplits();

    boolean isMissingRequiredSplits();
}

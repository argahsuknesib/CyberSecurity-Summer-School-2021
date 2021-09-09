package com.facebook.places.internal;

import android.location.Location;

public interface LocationScanner {
    Location getLocation() throws ScannerException;

    void initAndCheckEligibility() throws ScannerException;
}

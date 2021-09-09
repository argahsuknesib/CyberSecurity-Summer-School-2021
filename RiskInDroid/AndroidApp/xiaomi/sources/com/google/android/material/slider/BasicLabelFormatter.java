package com.google.android.material.slider;

import java.util.Locale;

public final class BasicLabelFormatter implements LabelFormatter {
    public final String getFormattedValue(float f) {
        if (f >= 1.0E12f) {
            return String.format(Locale.US, "%.1fT", Float.valueOf(f / 1.0E12f));
        } else if (f >= 1.0E9f) {
            return String.format(Locale.US, "%.1fB", Float.valueOf(f / 1.0E9f));
        } else if (f >= 1000000.0f) {
            return String.format(Locale.US, "%.1fM", Float.valueOf(f / 1000000.0f));
        } else if (f >= 1000.0f) {
            return String.format(Locale.US, "%.1fK", Float.valueOf(f / 1000.0f));
        } else {
            return String.format(Locale.US, "%.0f", Float.valueOf(f));
        }
    }
}

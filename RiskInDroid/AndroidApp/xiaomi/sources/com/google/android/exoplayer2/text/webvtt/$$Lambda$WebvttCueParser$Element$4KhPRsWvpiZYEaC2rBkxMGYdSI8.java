package com.google.android.exoplayer2.text.webvtt;

import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.util.Comparator;

/* renamed from: com.google.android.exoplayer2.text.webvtt.-$$Lambda$WebvttCueParser$Element$4KhPRsWvpiZYEaC2rBkxMGYdSI8  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$WebvttCueParser$Element$4KhPRsWvpiZYEaC2rBkxMGYdSI8 implements Comparator {
    public static final /* synthetic */ $$Lambda$WebvttCueParser$Element$4KhPRsWvpiZYEaC2rBkxMGYdSI8 INSTANCE = new $$Lambda$WebvttCueParser$Element$4KhPRsWvpiZYEaC2rBkxMGYdSI8();

    private /* synthetic */ $$Lambda$WebvttCueParser$Element$4KhPRsWvpiZYEaC2rBkxMGYdSI8() {
    }

    public final int compare(Object obj, Object obj2) {
        return Integer.compare(((WebvttCueParser.Element) obj).startTag.position, ((WebvttCueParser.Element) obj2).startTag.position);
    }
}

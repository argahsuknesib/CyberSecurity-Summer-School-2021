package com.google.android.exoplayer2.source.dash.manifest;

import android.net.Uri;
import com.google.android.exoplayer2.util.UriUtil;

public final class RangedUri {
    private int hashCode;
    public final long length;
    private final String referenceUri;
    public final long start;

    public RangedUri(String str, long j, long j2) {
        this.referenceUri = str == null ? "" : str;
        this.start = j;
        this.length = j2;
    }

    public final Uri resolveUri(String str) {
        return UriUtil.resolveToUri(str, this.referenceUri);
    }

    public final String resolveUriString(String str) {
        return UriUtil.resolve(str, this.referenceUri);
    }

    public final RangedUri attemptMerge(RangedUri rangedUri, String str) {
        String resolveUriString = resolveUriString(str);
        if (rangedUri != null && resolveUriString.equals(rangedUri.resolveUriString(str))) {
            long j = this.length;
            long j2 = -1;
            if (j != -1) {
                long j3 = this.start;
                if (j3 + j == rangedUri.start) {
                    long j4 = rangedUri.length;
                    if (j4 != -1) {
                        j2 = j + j4;
                    }
                    return new RangedUri(resolveUriString, j3, j2);
                }
            }
            long j5 = rangedUri.length;
            if (j5 != -1) {
                long j6 = rangedUri.start;
                if (j6 + j5 == this.start) {
                    long j7 = this.length;
                    if (j7 != -1) {
                        j2 = j5 + j7;
                    }
                    return new RangedUri(resolveUriString, j6, j2);
                }
            }
        }
        return null;
    }

    public final int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = ((((((int) this.start) + 527) * 31) + ((int) this.length)) * 31) + this.referenceUri.hashCode();
        }
        return this.hashCode;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            RangedUri rangedUri = (RangedUri) obj;
            return this.start == rangedUri.start && this.length == rangedUri.length && this.referenceUri.equals(rangedUri.referenceUri);
        }
    }

    public final String toString() {
        return "RangedUri(referenceUri=" + this.referenceUri + ", start=" + this.start + ", length=" + this.length + ")";
    }
}

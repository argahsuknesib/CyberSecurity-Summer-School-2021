package com.google.android.exoplayer2;

import com.google.android.exoplayer2.util.Util;

public final class MediaMetadata {
    public final String title;

    public static final class Builder {
        private String title;

        public final Builder setTitle(String str) {
            this.title = str;
            return this;
        }

        public final MediaMetadata build() {
            return new MediaMetadata(this.title);
        }
    }

    private MediaMetadata(String str) {
        this.title = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Util.areEqual(this.title, ((MediaMetadata) obj).title);
    }

    public final int hashCode() {
        String str = this.title;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }
}

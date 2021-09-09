package com.nostra13.universalimageloader.core.download;

import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;

public interface ImageDownloader {
    InputStream getStream(String str, Object obj) throws IOException;

    public enum Scheme {
        HTTP("http"),
        HTTPS("https"),
        FILE("file"),
        CONTENT("content"),
        ASSETS("assets"),
        DRAWABLE("drawable"),
        UNKNOWN("");
        
        private String scheme;
        private String uriPrefix;

        private Scheme(String str) {
            this.scheme = str;
            this.uriPrefix = str + "://";
        }

        public static Scheme ofUri(String str) {
            if (str != null) {
                for (Scheme scheme2 : values()) {
                    if (scheme2.belongsTo(str)) {
                        return scheme2;
                    }
                }
            }
            return UNKNOWN;
        }

        private boolean belongsTo(String str) {
            return str.toLowerCase(Locale.US).startsWith(this.uriPrefix);
        }

        public final String wrap(String str) {
            return this.uriPrefix + str;
        }

        public final String crop(String str) {
            if (belongsTo(str)) {
                return str.substring(this.uriPrefix.length());
            }
            throw new IllegalArgumentException(String.format("URI [%1$s] doesn't have expected scheme [%2$s]", str, this.scheme));
        }
    }
}

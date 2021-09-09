package com.facebook.internal;

import android.content.Context;
import android.net.Uri;
import com.facebook.LoggingBehavior;
import com.facebook.internal.FileLruCache;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

class ImageResponseCache {
    static final String TAG = "ImageResponseCache";
    private static FileLruCache imageCache;

    ImageResponseCache() {
    }

    static synchronized FileLruCache getCache(Context context) throws IOException {
        FileLruCache fileLruCache;
        synchronized (ImageResponseCache.class) {
            if (imageCache == null) {
                imageCache = new FileLruCache(TAG, new FileLruCache.Limits());
            }
            fileLruCache = imageCache;
        }
        return fileLruCache;
    }

    static InputStream getCachedImageStream(Uri uri, Context context) {
        if (uri != null && isCDNURL(uri)) {
            try {
                return getCache(context).get(uri.toString());
            } catch (IOException e) {
                Logger.log(LoggingBehavior.CACHE, 5, TAG, e.toString());
            }
        }
        return null;
    }

    static InputStream interceptAndCacheImageStream(Context context, HttpURLConnection httpURLConnection) throws IOException {
        if (httpURLConnection.getResponseCode() != 200) {
            return null;
        }
        Uri parse = Uri.parse(httpURLConnection.getURL().toString());
        InputStream inputStream = httpURLConnection.getInputStream();
        try {
            return isCDNURL(parse) ? getCache(context).interceptAndPut(parse.toString(), new BufferedHttpInputStream(inputStream, httpURLConnection)) : inputStream;
        } catch (IOException unused) {
            return inputStream;
        }
    }

    private static boolean isCDNURL(Uri uri) {
        if (uri == null) {
            return false;
        }
        String host = uri.getHost();
        if (host.endsWith("fbcdn.net")) {
            return true;
        }
        if (!host.startsWith("fbcdn") || !host.endsWith("akamaihd.net")) {
            return false;
        }
        return true;
    }

    static void clearCache(Context context) {
        try {
            getCache(context).clearCache();
        } catch (IOException e) {
            LoggingBehavior loggingBehavior = LoggingBehavior.CACHE;
            String str = TAG;
            Logger.log(loggingBehavior, 5, str, "clearCache failed " + e.getMessage());
        }
    }

    static class BufferedHttpInputStream extends BufferedInputStream {
        HttpURLConnection connection;

        BufferedHttpInputStream(InputStream inputStream, HttpURLConnection httpURLConnection) {
            super(inputStream, 8192);
            this.connection = httpURLConnection;
        }

        public void close() throws IOException {
            super.close();
            Utility.disconnectQuietly(this.connection);
        }
    }
}

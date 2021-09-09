package com.google.android.exoplayer2.offline;

import android.net.Uri;
import java.lang.reflect.Constructor;
import java.util.List;

public class DefaultDownloaderFactory implements DownloaderFactory {
    private static final Constructor<? extends Downloader> DASH_DOWNLOADER_CONSTRUCTOR;
    private static final Constructor<? extends Downloader> HLS_DOWNLOADER_CONSTRUCTOR;
    private static final Constructor<? extends Downloader> SS_DOWNLOADER_CONSTRUCTOR;
    private final DownloaderConstructorHelper downloaderConstructorHelper;

    static {
        Constructor<? extends Downloader> constructor;
        Constructor<? extends Downloader> constructor2;
        Constructor<? extends Downloader> constructor3 = null;
        try {
            constructor = getDownloaderConstructor(Class.forName("com.google.android.exoplayer2.source.dash.offline.DashDownloader"));
        } catch (ClassNotFoundException unused) {
            constructor = null;
        }
        DASH_DOWNLOADER_CONSTRUCTOR = constructor;
        try {
            constructor2 = getDownloaderConstructor(Class.forName("com.google.android.exoplayer2.source.hls.offline.HlsDownloader"));
        } catch (ClassNotFoundException unused2) {
            constructor2 = null;
        }
        HLS_DOWNLOADER_CONSTRUCTOR = constructor2;
        try {
            constructor3 = getDownloaderConstructor(Class.forName("com.google.android.exoplayer2.source.smoothstreaming.offline.SsDownloader"));
        } catch (ClassNotFoundException unused3) {
        }
        SS_DOWNLOADER_CONSTRUCTOR = constructor3;
    }

    public DefaultDownloaderFactory(DownloaderConstructorHelper downloaderConstructorHelper2) {
        this.downloaderConstructorHelper = downloaderConstructorHelper2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0079  */
    public Downloader createDownloader(DownloadRequest downloadRequest) {
        char c;
        String str = downloadRequest.type;
        int hashCode = str.hashCode();
        if (hashCode != 3680) {
            if (hashCode != 103407) {
                if (hashCode != 3075986) {
                    if (hashCode == 1131547531 && str.equals("progressive")) {
                        c = 0;
                        if (c == 0) {
                            return new ProgressiveDownloader(downloadRequest.uri, downloadRequest.customCacheKey, this.downloaderConstructorHelper);
                        }
                        if (c == 1) {
                            return createDownloader(downloadRequest, DASH_DOWNLOADER_CONSTRUCTOR);
                        }
                        if (c == 2) {
                            return createDownloader(downloadRequest, HLS_DOWNLOADER_CONSTRUCTOR);
                        }
                        if (c == 3) {
                            return createDownloader(downloadRequest, SS_DOWNLOADER_CONSTRUCTOR);
                        }
                        throw new IllegalArgumentException("Unsupported type: " + downloadRequest.type);
                    }
                } else if (str.equals("dash")) {
                    c = 1;
                    if (c == 0) {
                    }
                }
            } else if (str.equals("hls")) {
                c = 2;
                if (c == 0) {
                }
            }
        } else if (str.equals("ss")) {
            c = 3;
            if (c == 0) {
            }
        }
        c = 65535;
        if (c == 0) {
        }
    }

    private Downloader createDownloader(DownloadRequest downloadRequest, Constructor<? extends Downloader> constructor) {
        if (constructor != null) {
            try {
                return (Downloader) constructor.newInstance(downloadRequest.uri, downloadRequest.streamKeys, this.downloaderConstructorHelper);
            } catch (Exception e) {
                throw new RuntimeException("Failed to instantiate downloader for: " + downloadRequest.type, e);
            }
        } else {
            throw new IllegalStateException("Module missing for: " + downloadRequest.type);
        }
    }

    private static Constructor<? extends Downloader> getDownloaderConstructor(Class<?> cls) {
        try {
            return cls.asSubclass(Downloader.class).getConstructor(Uri.class, List.class, DownloaderConstructorHelper.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("Downloader constructor missing", e);
        }
    }
}

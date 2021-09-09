package com.airbnb.lottie.network;

import _m_j.be;
import android.content.Context;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieResult;
import com.airbnb.lottie.LottieTask;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.zip.ZipInputStream;

public class NetworkFetcher {
    private final Context appContext;
    private final NetworkCache networkCache;
    private final String url;

    public static LottieTask<LottieComposition> fetch(Context context, String str) {
        return new NetworkFetcher(context, str).fetch();
    }

    public static LottieResult<LottieComposition> fetchSync(Context context, String str) {
        return new NetworkFetcher(context, str).fetchSync();
    }

    private NetworkFetcher(Context context, String str) {
        this.appContext = context.getApplicationContext();
        this.url = str;
        this.networkCache = new NetworkCache(this.appContext, str);
    }

    private LottieTask<LottieComposition> fetch() {
        return new LottieTask<>(new Callable<LottieResult<LottieComposition>>() {
            /* class com.airbnb.lottie.network.NetworkFetcher.AnonymousClass1 */

            public LottieResult<LottieComposition> call() throws Exception {
                return NetworkFetcher.this.fetchSync();
            }
        });
    }

    public LottieResult<LottieComposition> fetchSync() {
        LottieComposition fetchFromCache = fetchFromCache();
        if (fetchFromCache != null) {
            return new LottieResult<>(fetchFromCache);
        }
        L.debug("Animation for " + this.url + " not found in cache. Fetching from network.");
        return fetchFromNetwork();
    }

    private LottieComposition fetchFromCache() {
        LottieResult<LottieComposition> lottieResult;
        be<FileExtension, InputStream> fetch = this.networkCache.fetch();
        if (fetch == null) {
            return null;
        }
        FileExtension fileExtension = (FileExtension) fetch.f12896O000000o;
        InputStream inputStream = (InputStream) fetch.O00000Oo;
        if (fileExtension == FileExtension.Zip) {
            lottieResult = LottieCompositionFactory.fromZipStreamSync(new ZipInputStream(inputStream), this.url);
        } else {
            lottieResult = LottieCompositionFactory.fromJsonInputStreamSync(inputStream, this.url);
        }
        if (lottieResult.getValue() != null) {
            return (LottieComposition) lottieResult.getValue();
        }
        return null;
    }

    private LottieResult<LottieComposition> fetchFromNetwork() {
        try {
            return fetchFromNetworkInternal();
        } catch (IOException e) {
            return new LottieResult<>((Throwable) e);
        }
    }

    private LottieResult fetchFromNetworkInternal() throws IOException {
        FileExtension fileExtension;
        LottieResult<LottieComposition> lottieResult;
        L.debug("Fetching " + this.url);
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.url).openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.connect();
        if (httpURLConnection.getErrorStream() == null && httpURLConnection.getResponseCode() == 200) {
            String contentType = httpURLConnection.getContentType();
            char c = 65535;
            int hashCode = contentType.hashCode();
            boolean z = true;
            if (hashCode != -1248325150) {
                if (hashCode == -43840953 && contentType.equals("application/json")) {
                    c = 1;
                }
            } else if (contentType.equals("application/zip")) {
                c = 0;
            }
            if (c != 0) {
                L.debug("Received json response.");
                fileExtension = FileExtension.Json;
                lottieResult = LottieCompositionFactory.fromJsonInputStreamSync(new FileInputStream(new File(this.networkCache.writeTempCacheFile(httpURLConnection.getInputStream(), fileExtension).getAbsolutePath())), this.url);
            } else {
                L.debug("Handling zip response.");
                fileExtension = FileExtension.Zip;
                lottieResult = LottieCompositionFactory.fromZipStreamSync(new ZipInputStream(new FileInputStream(this.networkCache.writeTempCacheFile(httpURLConnection.getInputStream(), fileExtension))), this.url);
            }
            if (lottieResult.getValue() != null) {
                this.networkCache.renameTempFile(fileExtension);
            }
            StringBuilder sb = new StringBuilder("Completed fetch from network. Success: ");
            if (lottieResult.getValue() == null) {
                z = false;
            }
            sb.append(z);
            L.debug(sb.toString());
            return lottieResult;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
        StringBuilder sb2 = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                sb2.append(readLine);
                sb2.append(10);
            } else {
                return new LottieResult((Throwable) new IllegalArgumentException("Unable to fetch " + this.url + ". Failed with " + httpURLConnection.getResponseCode() + "\n" + ((Object) sb2)));
            }
        }
    }
}

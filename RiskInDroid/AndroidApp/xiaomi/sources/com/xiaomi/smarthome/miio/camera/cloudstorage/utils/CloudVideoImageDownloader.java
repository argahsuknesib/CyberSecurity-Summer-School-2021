package com.xiaomi.smarthome.miio.camera.cloudstorage.utils;

import _m_j.dxx;
import _m_j.goe;
import _m_j.jfr;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.exoplayer2.C;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class CloudVideoImageDownloader extends BaseImageDownloader {

    public class AjcClosure1 extends jfr {
        public AjcClosure1(Object[] objArr) {
            super(objArr);
        }

        public Object run(Object[] objArr) {
            Object[] objArr2 = this.state;
            return CloudVideoImageDownloader.openConnection_aroundBody0((CloudVideoImageDownloader) objArr2[0], (URL) objArr2[1]);
        }
    }

    public class AjcClosure3 extends jfr {
        public AjcClosure3(Object[] objArr) {
            super(objArr);
        }

        public Object run(Object[] objArr) {
            Object[] objArr2 = this.state;
            return CloudVideoImageDownloader.openConnection_aroundBody2((CloudVideoImageDownloader) objArr2[0], (URL) objArr2[1]);
        }
    }

    public class AjcClosure5 extends jfr {
        public AjcClosure5(Object[] objArr) {
            super(objArr);
        }

        public Object run(Object[] objArr) {
            Object[] objArr2 = this.state;
            return CloudVideoImageDownloader.openConnection_aroundBody4((CloudVideoImageDownloader) objArr2[0], (URL) objArr2[1]);
        }
    }

    public CloudVideoImageDownloader(Context context) {
        super(context);
    }

    public CloudVideoImageDownloader(Context context, int i, int i2) {
        super(context, i, i2);
    }

    public InputStream getStream(String str, Object obj) throws IOException {
        HttpURLConnection httpURLConnection;
        if (!str.startsWith("https")) {
            return super.getStream(str, obj);
        }
        URL url = new URL(str);
        int i = 0;
        if (goe.O00000o(this.context)) {
            HttpURLConnection.setFollowRedirects(false);
            String O000000o2 = goe.O000000o(url);
            String host = url.getHost();
            URL url2 = new URL(O000000o2);
            dxx.O000000o();
            httpURLConnection = (HttpURLConnection) dxx.O000000o(url2);
            httpURLConnection.setRequestProperty("X-Online-Host", host);
            int responseCode = httpURLConnection.getResponseCode();
            while (responseCode >= 300 && responseCode < 400) {
                String headerField = httpURLConnection.getHeaderField("location");
                if (TextUtils.isEmpty(headerField)) {
                    break;
                }
                URL url3 = new URL(headerField);
                String O000000o3 = goe.O000000o(url3);
                String host2 = url3.getHost();
                URL url4 = new URL(O000000o3);
                dxx.O000000o();
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) dxx.O000000o(url4);
                httpURLConnection2.setRequestProperty("X-Online-Host", host2);
                HttpURLConnection httpURLConnection3 = httpURLConnection2;
                responseCode = httpURLConnection2.getResponseCode();
                httpURLConnection = httpURLConnection3;
            }
        } else {
            dxx.O000000o();
            httpURLConnection = (HttpURLConnection) dxx.O000000o(url);
            HttpURLConnection.setFollowRedirects(true);
        }
        httpURLConnection.setRequestProperty("Cookie", "yetAnotherServiceToken=" + CloudVideoNetUtils.getInstance().getTokenInfo().O00000o0);
        httpURLConnection.setConnectTimeout(C.MSG_CUSTOM_BASE);
        httpURLConnection.setReadTimeout(15000);
        httpURLConnection.connect();
        InputStream inputStream = httpURLConnection.getInputStream();
        int contentLength = httpURLConnection.getContentLength();
        byte[] bArr = new byte[contentLength];
        while (i < contentLength) {
            try {
                int read = inputStream.read(bArr, i, contentLength - i);
                if (read == -1) {
                    break;
                }
                i += read;
            } catch (Exception unused) {
            }
        }
        return new ByteArrayInputStream(CloudVideoCryptoUtils.getInstance().decrypt(bArr));
    }

    static final URLConnection openConnection_aroundBody0(CloudVideoImageDownloader cloudVideoImageDownloader, URL url) {
        return url.openConnection();
    }

    static final URLConnection openConnection_aroundBody2(CloudVideoImageDownloader cloudVideoImageDownloader, URL url) {
        return url.openConnection();
    }

    static final URLConnection openConnection_aroundBody4(CloudVideoImageDownloader cloudVideoImageDownloader, URL url) {
        return url.openConnection();
    }

    public InputStream getStreamFromNetwork(String str, Object obj) throws IOException {
        return super.getStreamFromNetwork(str, obj);
    }

    public boolean shouldBeProcessed(HttpURLConnection httpURLConnection) throws IOException {
        return super.shouldBeProcessed(httpURLConnection);
    }

    public HttpURLConnection createConnection(String str, Object obj) throws IOException {
        return super.createConnection(str, obj);
    }

    public InputStream getStreamFromFile(String str, Object obj) throws IOException {
        return super.getStreamFromFile(str, obj);
    }

    public InputStream getStreamFromContent(String str, Object obj) throws FileNotFoundException {
        return super.getStreamFromContent(str, obj);
    }

    public InputStream getContactPhotoStream(Uri uri) {
        return super.getContactPhotoStream(uri);
    }

    public InputStream getStreamFromAssets(String str, Object obj) throws IOException {
        return super.getStreamFromAssets(str, obj);
    }

    public InputStream getStreamFromDrawable(String str, Object obj) {
        return super.getStreamFromDrawable(str, obj);
    }

    public InputStream getStreamFromOtherSource(String str, Object obj) throws IOException {
        return super.getStreamFromOtherSource(str, obj);
    }
}

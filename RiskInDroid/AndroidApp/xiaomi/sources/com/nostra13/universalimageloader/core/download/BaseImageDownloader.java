package com.nostra13.universalimageloader.core.download;

import _m_j.cob;
import _m_j.cot;
import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Build;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.webkit.MimeTypeMap;
import com.google.android.exoplayer2.C;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class BaseImageDownloader implements ImageDownloader {
    protected final int connectTimeout;
    protected final Context context;
    protected final int readTimeout;

    public BaseImageDownloader(Context context2) {
        this(context2, 5000, 20000);
    }

    public BaseImageDownloader(Context context2, int i, int i2) {
        this.context = context2.getApplicationContext();
        this.connectTimeout = i;
        this.readTimeout = i2;
    }

    public InputStream getStream(String str, Object obj) throws IOException {
        switch (ImageDownloader.Scheme.ofUri(str)) {
            case HTTP:
            case HTTPS:
                return getStreamFromNetwork(str, obj);
            case FILE:
                return getStreamFromFile(str, obj);
            case CONTENT:
                return getStreamFromContent(str, obj);
            case ASSETS:
                return getStreamFromAssets(str, obj);
            case DRAWABLE:
                return getStreamFromDrawable(str, obj);
            default:
                return getStreamFromOtherSource(str, obj);
        }
    }

    /* access modifiers changed from: protected */
    public InputStream getStreamFromNetwork(String str, Object obj) throws IOException {
        HttpURLConnection createConnection = createConnection(str, obj);
        int i = 0;
        while (createConnection.getResponseCode() / 100 == 3 && i < 5) {
            createConnection = createConnection(createConnection.getHeaderField("Location"), obj);
            i++;
        }
        try {
            InputStream inputStream = createConnection.getInputStream();
            if (shouldBeProcessed(createConnection)) {
                return new cob(new BufferedInputStream(inputStream, 32768), createConnection.getContentLength());
            }
            cot.O000000o(inputStream);
            throw new IOException("Image request failed with response code " + createConnection.getResponseCode());
        } catch (IOException e) {
            InputStream errorStream = createConnection.getErrorStream();
            do {
                try {
                } catch (IOException unused) {
                } catch (Throwable th) {
                    cot.O000000o(errorStream);
                    throw th;
                }
            } while (errorStream.read(new byte[32768], 0, 32768) != -1);
            cot.O000000o(errorStream);
            throw e;
        }
    }

    /* access modifiers changed from: protected */
    public boolean shouldBeProcessed(HttpURLConnection httpURLConnection) throws IOException {
        return httpURLConnection.getResponseCode() == 200;
    }

    /* access modifiers changed from: protected */
    public HttpURLConnection createConnection(String str, Object obj) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(Uri.encode(str, "@#&=*+-_.,:!?()/~'%")).openConnection();
        httpURLConnection.setConnectTimeout(this.connectTimeout);
        httpURLConnection.setReadTimeout(this.readTimeout);
        return httpURLConnection;
    }

    /* access modifiers changed from: protected */
    public InputStream getStreamFromFile(String str, Object obj) throws IOException {
        String crop = ImageDownloader.Scheme.FILE.crop(str);
        if (isVideoFileUri(str)) {
            return getVideoThumbnailStream(crop);
        }
        return new cob(new BufferedInputStream(new FileInputStream(crop), 32768), (int) new File(crop).length());
    }

    @TargetApi(C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER)
    private InputStream getVideoThumbnailStream(String str) {
        Bitmap createVideoThumbnail;
        if (Build.VERSION.SDK_INT < 8 || (createVideoThumbnail = ThumbnailUtils.createVideoThumbnail(str, 2)) == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        createVideoThumbnail.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream);
        return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
    }

    /* access modifiers changed from: protected */
    public InputStream getStreamFromContent(String str, Object obj) throws FileNotFoundException {
        ContentResolver contentResolver = this.context.getContentResolver();
        Uri parse = Uri.parse(str);
        if (isVideoContentUri(parse)) {
            Bitmap thumbnail = MediaStore.Video.Thumbnails.getThumbnail(contentResolver, Long.valueOf(parse.getLastPathSegment()).longValue(), 1, null);
            if (thumbnail != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                thumbnail.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream);
                return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            }
        } else if (str.startsWith("content://com.android.contacts/")) {
            return getContactPhotoStream(parse);
        }
        return contentResolver.openInputStream(parse);
    }

    /* access modifiers changed from: protected */
    @TargetApi(14)
    public InputStream getContactPhotoStream(Uri uri) {
        ContentResolver contentResolver = this.context.getContentResolver();
        if (Build.VERSION.SDK_INT >= 14) {
            return ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, uri, true);
        }
        return ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, uri);
    }

    /* access modifiers changed from: protected */
    public InputStream getStreamFromAssets(String str, Object obj) throws IOException {
        return this.context.getAssets().open(ImageDownloader.Scheme.ASSETS.crop(str));
    }

    /* access modifiers changed from: protected */
    public InputStream getStreamFromDrawable(String str, Object obj) {
        return this.context.getResources().openRawResource(Integer.parseInt(ImageDownloader.Scheme.DRAWABLE.crop(str)));
    }

    /* access modifiers changed from: protected */
    public InputStream getStreamFromOtherSource(String str, Object obj) throws IOException {
        throw new UnsupportedOperationException(String.format("UIL doesn't support scheme(protocol) by default [%s]. You should implement this support yourself (BaseImageDownloader.getStreamFromOtherSource(...))", str));
    }

    private boolean isVideoContentUri(Uri uri) {
        String type = this.context.getContentResolver().getType(uri);
        return type != null && type.startsWith("video/");
    }

    private boolean isVideoFileUri(String str) {
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(str));
        return mimeTypeFromExtension != null && mimeTypeFromExtension.startsWith("video/");
    }
}

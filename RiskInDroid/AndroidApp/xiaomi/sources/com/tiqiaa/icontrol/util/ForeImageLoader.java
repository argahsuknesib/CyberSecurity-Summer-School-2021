package com.tiqiaa.icontrol.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.ImageView;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ForeImageLoader {
    private static String base_cache_path = (String.valueOf(Environment.getExternalStorageDirectory().getAbsolutePath()) + "/zazaSdk/temp/cache");
    private static PooledMap<String, Bitmap> bitMapCache = null;
    private static int discCacheImgSize = 1000;
    private static int discCacheMaxSize = 2000;
    private static int discCacheMinSize = 100;
    static String[] extensions = {".jpg", ".jpeg", ".png", ".bmp", ".gif"};
    private static boolean isDiscCacheEnabled = true;
    private static boolean isMenCacheEnabled = true;
    private static int menCacheImgCount = 120;
    private static int menCacheMaxSize = 400;
    private static int menCacheminSize = 40;

    public static Bitmap loadImg(String str) {
        Bitmap bitmap;
        if (bitMapCache == null && isMenCacheEnabled) {
            bitMapCache = new PooledMap<>(menCacheImgCount);
        }
        Bitmap bitmap2 = null;
        if (isMenCacheEnabled && (bitmap2 = bitMapCache.get(str)) != null) {
            return bitmap2;
        }
        String convertImgURLToLocalCachePath = convertImgURLToLocalCachePath(str);
        if (convertImgURLToLocalCachePath != null) {
            try {
                if (isDiscCacheEnabled) {
                    bitmap = loadImgFromLocal(convertImgURLToLocalCachePath);
                    LogUtil.i("ForeImageLoader", "load_img...#########..从本地图片缓存文件夹获取到图片");
                    if (bitmap == null) {
                        LogUtil.v("ForeImageLoader", "load_img..~~~~~~~~...下载服务器上的图片并保存");
                        saveFile(convertImgURLToLocalCachePath, UrlPoster.requestUrl(str));
                        bitmap = loadImgFromLocal(convertImgURLToLocalCachePath);
                        LogUtil.v("ForeImageLoader", "load_img..@@@@@@@@@@...获取下载到的保存后的图片");
                    }
                    if (isMenCacheEnabled && bitmap != null) {
                        bitMapCache.put(str, bitmap);
                    }
                    return bitmap;
                }
            } catch (Exception e) {
                LogUtil.printException(e);
            }
        }
        LogUtil.w("ForeImageLoader", "load_img..~~~~~~~~...直接下载并使用服务器图片");
        bitmap = BitmapFactory.decodeStream(UrlPoster.requestUrl(str));
        bitMapCache.put(str, bitmap);
        return bitmap;
    }

    public static Bitmap getBitmapFromCache(String str) {
        if (bitMapCache == null && isMenCacheEnabled) {
            bitMapCache = new PooledMap<>(menCacheImgCount);
        }
        Bitmap bitmap = null;
        try {
            if (isMenCacheEnabled) {
                bitmap = bitMapCache.get(str);
            }
            if (bitmap == null && isDiscCacheEnabled && (bitmap = loadImgFromLocal(convertImgURLToLocalCachePath(str))) != null && isMenCacheEnabled) {
                bitMapCache.put(str, bitmap);
            }
        } catch (Exception e) {
            LogUtil.printException(e);
        }
        return bitmap;
    }

    public static void displayImg(final ImageView imageView, final String str) {
        final AnonymousClass1 r0 = new Handler(Looper.getMainLooper()) {
            /* class com.tiqiaa.icontrol.util.ForeImageLoader.AnonymousClass1 */

            public void handleMessage(Message message) {
                Bitmap bitmap = (Bitmap) message.obj;
                if (bitmap != null) {
                    imageView.setImageBitmap(bitmap);
                }
            }
        };
        new Thread(new Runnable() {
            /* class com.tiqiaa.icontrol.util.ForeImageLoader.AnonymousClass2 */

            public void run() {
                Bitmap loadImg = ForeImageLoader.loadImg(str);
                Message message = new Message();
                message.obj = loadImg;
                r0.sendMessage(message);
            }
        }).start();
    }

    private static String convertImgURLToLocalCachePath(String str) {
        if (str == null || str.length() == 0 || base_cache_path == null) {
            return null;
        }
        String str2 = String.valueOf(str) + "x";
        int lastIndexOf = str2.lastIndexOf("/");
        if (lastIndexOf < 0) {
            return null;
        }
        String str3 = String.valueOf(base_cache_path) + "/" + str2.substring(lastIndexOf + 1, str2.length());
        LogUtil.d("ForeImageLoader", "convertToLocalCachePath......cache_path = ".concat(String.valueOf(str3)));
        return str3;
    }

    public static void configMenCacheCount(int i) {
        if (i <= 0) {
            isMenCacheEnabled = false;
            return;
        }
        isMenCacheEnabled = true;
        if (i > menCacheminSize && i < menCacheMaxSize) {
            menCacheImgCount = i;
        }
    }

    public static void configDiscCacheCount(int i) {
        if (i <= 0) {
            isDiscCacheEnabled = false;
            return;
        }
        isDiscCacheEnabled = true;
        if (i > discCacheMinSize && i < discCacheMaxSize) {
            discCacheImgSize = i;
        }
    }

    public static void configDiscCachePath(String str) {
        base_cache_path = str;
    }

    public static Bitmap loadImgFromLocal(String str) {
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            Bitmap decodeStream = BitmapFactory.decodeStream(fileInputStream);
            fileInputStream.close();
            file.setLastModified(System.currentTimeMillis());
            return decodeStream;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static File saveFile(String str, InputStream inputStream) throws IOException {
        if (str == null) {
            return null;
        }
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        } else {
            File file2 = new File(str.substring(0, str.lastIndexOf("/")));
            if (!file2.exists()) {
                file2.mkdirs();
            }
            File[] listFiles = file2.listFiles();
            if (listFiles != null && listFiles.length >= discCacheImgSize) {
                File file3 = listFiles[0];
                File file4 = file3;
                for (File file5 : listFiles) {
                    if (file4.lastModified() > file5.lastModified()) {
                        file4 = file5;
                    }
                }
                file4.delete();
            }
        }
        file.createNewFile();
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        byte[] bArr = new byte[256];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                fileOutputStream.flush();
                fileOutputStream.close();
                inputStream.close();
                return file;
            }
            fileOutputStream.write(bArr, 0, read);
        }
    }
}

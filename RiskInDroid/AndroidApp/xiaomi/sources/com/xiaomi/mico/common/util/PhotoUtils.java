package com.xiaomi.mico.common.util;

import _m_j.ahh;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build;
import com.xiaomi.smarthome.R;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class PhotoUtils {
    public static void takePicture(Activity activity, Uri uri, int i) {
        Intent intent = new Intent();
        if (Build.VERSION.SDK_INT >= 24) {
            intent.addFlags(1);
        }
        intent.setAction("android.media.action.IMAGE_CAPTURE");
        intent.setAction("android.media.action.IMAGE_CAPTURE");
        intent.putExtra("output", uri);
        if (activity != null) {
            activity.startActivityForResult(intent, i);
        }
    }

    public static void takeVideo(Activity activity, int i, int i2, int i3) {
        Intent intent = new Intent("android.media.action.VIDEO_CAPTURE");
        intent.putExtra("android.intent.extra.videoQuality", i2);
        intent.putExtra("android.intent.extra.durationLimit", i3);
        activity.startActivityForResult(intent, i);
    }

    public static void openPic(Activity activity, int i) {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("image/*");
        activity.startActivityForResult(intent, i);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{android.content.Intent.putExtra(java.lang.String, int):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, int[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Bundle):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.io.Serializable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent} */
    public static void cropImageUri(Activity activity, Uri uri, Uri uri2, int i, int i2, int i3, int i4, int i5) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        if (Build.VERSION.SDK_INT >= 24) {
            intent.addFlags(1);
        }
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("crop", "true");
        intent.putExtra("aspectX", i);
        intent.putExtra("aspectY", i2);
        intent.putExtra("outputX", i3);
        intent.putExtra("outputY", i4);
        intent.putExtra("scale", true);
        intent.putExtra("output", uri2);
        intent.putExtra("return-data", false);
        intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
        intent.putExtra("noFaceDetection", true);
        activity.startActivityForResult(intent, i5);
    }

    public static Bitmap getBitmapFromUri(Uri uri, Context context) {
        try {
            return getBitmapFormUri(context, uri);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0042  */
    public static Bitmap getBitmapFormUri(Context context, Uri uri) throws FileNotFoundException, IOException {
        int i;
        InputStream openInputStream = context.getContentResolver().openInputStream(uri);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        options.inDither = true;
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        BitmapFactory.decodeStream(openInputStream, null, options);
        openInputStream.close();
        int i2 = options.outWidth;
        int i3 = options.outHeight;
        if (i2 == -1 || i3 == -1) {
            return null;
        }
        if (i2 > i3) {
            float f = (float) i2;
            if (f > 480.0f) {
                i = (int) (f / 480.0f);
                if (i <= 0) {
                    i = 1;
                }
                BitmapFactory.Options options2 = new BitmapFactory.Options();
                options2.inSampleSize = i;
                options2.inDither = true;
                options2.inPreferredConfig = Bitmap.Config.ARGB_8888;
                InputStream openInputStream2 = context.getContentResolver().openInputStream(uri);
                Bitmap decodeStream = BitmapFactory.decodeStream(openInputStream2, null, options2);
                openInputStream2.close();
                return compressImage(decodeStream);
            }
        }
        if (i2 < i3) {
            float f2 = (float) i3;
            if (f2 > 800.0f) {
                i = (int) (f2 / 800.0f);
                if (i <= 0) {
                }
                BitmapFactory.Options options22 = new BitmapFactory.Options();
                options22.inSampleSize = i;
                options22.inDither = true;
                options22.inPreferredConfig = Bitmap.Config.ARGB_8888;
                InputStream openInputStream22 = context.getContentResolver().openInputStream(uri);
                Bitmap decodeStream2 = BitmapFactory.decodeStream(openInputStream22, null, options22);
                openInputStream22.close();
                return compressImage(decodeStream2);
            }
        }
        i = 1;
        if (i <= 0) {
        }
        BitmapFactory.Options options222 = new BitmapFactory.Options();
        options222.inSampleSize = i;
        options222.inDither = true;
        options222.inPreferredConfig = Bitmap.Config.ARGB_8888;
        InputStream openInputStream222 = context.getContentResolver().openInputStream(uri);
        Bitmap decodeStream22 = BitmapFactory.decodeStream(openInputStream222, null, options222);
        openInputStream222.close();
        return compressImage(decodeStream22);
    }

    public static Bitmap compressImage(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        int i = 100;
        while (byteArrayOutputStream.toByteArray().length / 1024 > 100) {
            byteArrayOutputStream.reset();
            bitmap.compress(Bitmap.CompressFormat.JPEG, i, byteArrayOutputStream);
            i -= 10;
        }
        return BitmapFactory.decodeStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()), null, null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0035  */
    public static String getDataColumn(Context context, Uri uri, String str, String[] strArr) {
        Cursor cursor;
        try {
            cursor = context.getContentResolver().query(uri, new String[]{"_data"}, str, strArr, null);
            if (cursor != null) {
                try {
                    if (cursor.moveToFirst()) {
                        String string = cursor.getString(cursor.getColumnIndexOrThrow("_data"));
                        if (cursor != null) {
                            cursor.close();
                        }
                        return string;
                    }
                } catch (Throwable th) {
                    th = th;
                    if (cursor != null) {
                    }
                    throw th;
                }
            }
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    private static boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    private static boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    private static boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    public static long getDurationFromURI(Context context, Uri uri) {
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(context, uri);
            long parseLong = Long.parseLong(mediaMetadataRetriever.extractMetadata(9));
            mediaMetadataRetriever.release();
            return parseLong;
        } catch (Exception e) {
            ahh.O000000o(e);
            ToastUtil.showToast((int) R.string.upload_video_failed_invalid);
            return 0;
        }
    }
}

package com.xiaomi.smarthome.uwb.tv;

import _m_j.fno;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.uwb.lib.data.UwbScanDevice;
import com.xiaomi.smarthome.uwb.lib.mitv.data.MitvInfo;
import com.xiaomi.smarthome.uwb.lib.utils.UwbDeviceUtil;

public class Util {
    public static Bitmap roundCornerImage(Bitmap bitmap, int i) {
        int min = Math.min(bitmap.getWidth(), bitmap.getHeight());
        Bitmap createBitmap = Bitmap.createBitmap(min, min, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, min, min);
        RectF rectF = new RectF(rect);
        paint.setAntiAlias(true);
        float f = (float) i;
        canvas.drawRoundRect(rectF, f, f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, (Rect) null, rect, paint);
        bitmap.recycle();
        return createBitmap;
    }

    public static String byteArrToString(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "null";
        }
        StringBuilder sb = new StringBuilder("byteArr[");
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            sb.append(byte2Hex(bArr[i]) + " ");
        }
        return sb.toString().trim() + "]";
    }

    public static String byte2Hex(byte b) {
        int i = (b & Byte.MAX_VALUE) + (b < 0 ? (byte) 128 : 0);
        StringBuilder sb = new StringBuilder();
        sb.append(i < 16 ? "0" : "");
        sb.append(Integer.toHexString(i).toLowerCase());
        return sb.toString();
    }

    public static boolean isActivityValid(Activity activity) {
        return !activity.isDestroyed() && !activity.isFinishing();
    }

    public static boolean canGotoMitvPlugin(MitvInfo mitvInfo) {
        return (mitvInfo == null || TextUtils.isEmpty(mitvInfo.getPartnerId()) || fno.O000000o().O000000o(mitvInfo.getPartnerId()) == null) ? false : true;
    }

    public static boolean isOwner(UwbScanDevice uwbScanDevice) {
        String str;
        if (UwbDeviceUtil.isMitvDeviceTagType(uwbScanDevice)) {
            str = uwbScanDevice.getTagState().getTvAccountInfo();
        } else {
            str = uwbScanDevice.getAccountInfo();
        }
        if (!TextUtils.isEmpty(str) && TextUtils.equals(UwbDeviceUtil.getUwbHashFirst3B(CoreApi.O000000o().O0000o0()), str)) {
            return true;
        }
        return false;
    }

    public static boolean isMitvPlaying(MitvInfo mitvInfo) {
        return (mitvInfo == null || mitvInfo.getIsPlaying() == null || !mitvInfo.getIsPlaying().equalsIgnoreCase("1")) ? false : true;
    }

    public static String getPlayerDuration(long j) {
        String str;
        String str2;
        String str3;
        long j2 = (j / 60000) % 60;
        long j3 = (j / 1000) % 60;
        if (j2 > 9) {
            str = String.valueOf(j2);
        } else {
            str = "0" + String.valueOf(j2);
        }
        if (j3 > 9) {
            str2 = String.valueOf(j3);
        } else {
            str2 = "0" + String.valueOf(j3);
        }
        if (j < 3600000) {
            return str + ":" + str2;
        }
        long j4 = j / 3600000;
        if (j4 > 9) {
            str3 = String.valueOf(j4);
        } else {
            str3 = "0" + String.valueOf(j4);
        }
        return str3 + ":" + str + ":" + str2;
    }
}

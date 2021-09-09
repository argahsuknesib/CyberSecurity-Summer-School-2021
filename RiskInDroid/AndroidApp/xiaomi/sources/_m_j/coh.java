package _m_j;

import android.graphics.BitmapFactory;
import android.os.Build;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import com.nostra13.universalimageloader.core.download.ImageDownloader;

public final class coh {

    /* renamed from: O000000o  reason: collision with root package name */
    final String f14169O000000o;
    final String O00000Oo;
    final ImageScaleType O00000o;
    final cod O00000o0;
    final ViewScaleType O00000oO;
    final ImageDownloader O00000oo;
    final Object O0000O0o;
    final boolean O0000OOo;
    private final String O0000Oo;
    final BitmapFactory.Options O0000Oo0 = new BitmapFactory.Options();

    public coh(String str, String str2, String str3, cod cod, ViewScaleType viewScaleType, ImageDownloader imageDownloader, cnw cnw) {
        this.f14169O000000o = str;
        this.O00000Oo = str2;
        this.O0000Oo = str3;
        this.O00000o0 = cod;
        this.O00000o = cnw.O0000Oo;
        this.O00000oO = viewScaleType;
        this.O00000oo = imageDownloader;
        this.O0000O0o = cnw.O0000o0;
        this.O0000OOo = cnw.O0000o00;
        BitmapFactory.Options options = cnw.O0000OoO;
        BitmapFactory.Options options2 = this.O0000Oo0;
        options2.inDensity = options.inDensity;
        options2.inDither = options.inDither;
        options2.inInputShareable = options.inInputShareable;
        options2.inJustDecodeBounds = options.inJustDecodeBounds;
        options2.inPreferredConfig = options.inPreferredConfig;
        options2.inPurgeable = options.inPurgeable;
        options2.inSampleSize = options.inSampleSize;
        options2.inScaled = options.inScaled;
        options2.inScreenDensity = options.inScreenDensity;
        options2.inTargetDensity = options.inTargetDensity;
        options2.inTempStorage = options.inTempStorage;
        if (Build.VERSION.SDK_INT >= 10) {
            options2.inPreferQualityOverSpeed = options.inPreferQualityOverSpeed;
        }
        if (Build.VERSION.SDK_INT >= 11) {
            options2.inBitmap = options.inBitmap;
            options2.inMutable = options.inMutable;
        }
    }
}

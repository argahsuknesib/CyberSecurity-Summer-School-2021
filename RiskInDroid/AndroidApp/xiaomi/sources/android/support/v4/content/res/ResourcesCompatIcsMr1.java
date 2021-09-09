package android.support.v4.content.res;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.RequiresApi;
import com.google.android.gms.common.internal.GmsLogger;

@TargetApi(GmsLogger.MAX_PII_TAG_LENGTH)
@RequiresApi(GmsLogger.MAX_PII_TAG_LENGTH)
class ResourcesCompatIcsMr1 {
    ResourcesCompatIcsMr1() {
    }

    public static Drawable getDrawableForDensity(Resources resources, int i, int i2) throws Resources.NotFoundException {
        return resources.getDrawableForDensity(i, i2);
    }
}

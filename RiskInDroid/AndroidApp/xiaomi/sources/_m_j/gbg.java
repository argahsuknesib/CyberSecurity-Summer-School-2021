package _m_j;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;

public final class gbg {
    public static Bitmap O000000o(Context context, Bitmap bitmap, float f) {
        gbu.O000000o("rsBlur, origin size:" + bitmap.getWidth() + "*" + bitmap.getHeight());
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, Math.round(((float) bitmap.getWidth()) * 0.125f), Math.round(((float) bitmap.getHeight()) * 0.125f), false);
        RenderScript create = RenderScript.create(context);
        gbu.O000000o("rsBlur, scale size:" + createScaledBitmap.getWidth() + "*" + createScaledBitmap.getHeight());
        Allocation createFromBitmap = Allocation.createFromBitmap(create, createScaledBitmap);
        Allocation createTyped = Allocation.createTyped(create, createFromBitmap.getType());
        ScriptIntrinsicBlur create2 = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
        create2.setInput(createFromBitmap);
        create2.setRadius(f);
        create2.forEach(createTyped);
        createTyped.copyTo(createScaledBitmap);
        create.destroy();
        return createScaledBitmap;
    }
}

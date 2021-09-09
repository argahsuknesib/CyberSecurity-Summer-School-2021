package _m_j;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.renderscript.Allocation;
import android.renderscript.BaseObj;
import android.renderscript.RSRuntimeException;
import androidx.renderscript.Allocation;
import androidx.renderscript.RenderScript;
import androidx.renderscript.Type;

public final class hh extends Allocation {
    static BitmapFactory.Options O0000o0;
    android.renderscript.Allocation O0000o00;

    /* renamed from: _m_j.hh$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f18927O000000o = new int[Allocation.MipmapControl.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            f18927O000000o[Allocation.MipmapControl.MIPMAP_NONE.ordinal()] = 1;
            f18927O000000o[Allocation.MipmapControl.MIPMAP_FULL.ordinal()] = 2;
            try {
                f18927O000000o[Allocation.MipmapControl.MIPMAP_ON_SYNC_TO_TEXTURE.ordinal()] = 3;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    private static Allocation.MipmapControl O000000o(Allocation.MipmapControl mipmapControl) {
        int i = AnonymousClass1.f18927O000000o[mipmapControl.ordinal()];
        if (i == 1) {
            return Allocation.MipmapControl.MIPMAP_NONE;
        }
        if (i == 2) {
            return Allocation.MipmapControl.MIPMAP_FULL;
        }
        if (i != 3) {
            return null;
        }
        return Allocation.MipmapControl.MIPMAP_ON_SYNC_TO_TEXTURE;
    }

    public final Type O000000o() {
        return hs.O000000o(this.O0000o00.getType());
    }

    private hh(RenderScript renderScript, Type type, int i, android.renderscript.Allocation allocation) {
        super(0, renderScript, type, i);
        this.f2962O000000o = type;
        this.O00000o0 = i;
        this.O0000o00 = allocation;
    }

    public final void O000000o(Bitmap bitmap) {
        try {
            this.O0000o00.copyFrom(bitmap);
        } catch (RSRuntimeException e) {
            throw hk.O000000o(e);
        }
    }

    public final void O00000Oo(Bitmap bitmap) {
        try {
            this.O0000o00.copyTo(bitmap);
        } catch (RSRuntimeException e) {
            throw hk.O000000o(e);
        }
    }

    static {
        BitmapFactory.Options options = new BitmapFactory.Options();
        O0000o0 = options;
        options.inScaled = false;
    }

    public static androidx.renderscript.Allocation O000000o(RenderScript renderScript, Type type, Allocation.MipmapControl mipmapControl, int i) {
        try {
            return new hh(renderScript, type, 1, android.renderscript.Allocation.createTyped(((hm) renderScript).O0000oO, ((hs) type).O0000Oo0, O000000o(mipmapControl), 1));
        } catch (RSRuntimeException e) {
            throw hk.O000000o(e);
        }
    }

    public static androidx.renderscript.Allocation O00000Oo(RenderScript renderScript, Bitmap bitmap, Allocation.MipmapControl mipmapControl, int i) {
        try {
            android.renderscript.Allocation createFromBitmap = android.renderscript.Allocation.createFromBitmap(((hm) renderScript).O0000oO, bitmap, O000000o(mipmapControl), i);
            return new hh(renderScript, new hs(renderScript, createFromBitmap.getType()), i, createFromBitmap);
        } catch (RSRuntimeException e) {
            throw hk.O000000o(e);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ BaseObj O00000Oo() {
        return this.O0000o00;
    }
}

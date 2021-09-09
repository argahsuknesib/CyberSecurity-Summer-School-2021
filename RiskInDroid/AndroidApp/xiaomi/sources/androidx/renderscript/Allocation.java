package androidx.renderscript;

import _m_j.hh;
import _m_j.hi;
import _m_j.hm;
import _m_j.hs;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import androidx.renderscript.Element;
import androidx.renderscript.Type;

public class Allocation extends hi {
    static BitmapFactory.Options O0000Ooo;

    /* renamed from: O000000o  reason: collision with root package name */
    protected Type f2962O000000o;
    Bitmap O00000Oo;
    int O00000o;
    protected int O00000o0;
    boolean O00000oO = true;
    boolean O00000oo = true;
    Type.CubemapFace O0000O0o = Type.CubemapFace.POSITIVE_X;
    int O0000OOo;
    int O0000Oo;
    int O0000Oo0;
    int O0000OoO;

    public enum MipmapControl {
        MIPMAP_NONE(0),
        MIPMAP_FULL(1),
        MIPMAP_ON_SYNC_TO_TEXTURE(2);
        
        int mID;

        private MipmapControl(int i) {
            this.mID = i;
        }
    }

    protected Allocation(int i, RenderScript renderScript, Type type, int i2) {
        super(i, renderScript);
        if ((i2 & -228) == 0) {
            if ((i2 & 32) != 0) {
                this.O00000oo = false;
                if ((i2 & -36) != 0) {
                    throw new RSIllegalArgumentException("Invalid usage combination.");
                }
            }
            this.f2962O000000o = type;
            this.O00000o0 = i2;
            this.O00000o = this.f2962O000000o.O0000O0o * this.f2962O000000o.O0000OOo.O000000o();
            if (type != null) {
                this.O0000OOo = type.f2970O000000o;
                this.O0000Oo0 = type.O00000Oo;
                this.O0000Oo = type.O00000o0;
                this.O0000OoO = this.O0000OOo;
                int i3 = this.O0000Oo0;
                if (i3 > 1) {
                    this.O0000OoO *= i3;
                }
                int i4 = this.O0000Oo;
                if (i4 > 1) {
                    this.O0000OoO *= i4;
                }
            }
            if (RenderScript.O00000Oo) {
                try {
                    RenderScript.O00000o.invoke(RenderScript.O00000o0, Integer.valueOf(this.O00000o));
                } catch (Exception e) {
                    Log.e("RenderScript_jni", "Couldn't invoke registerNativeAllocation:".concat(String.valueOf(e)));
                    throw new RSRuntimeException("Couldn't invoke registerNativeAllocation:".concat(String.valueOf(e)));
                }
            }
        } else {
            throw new RSIllegalArgumentException("Unknown usage specified.");
        }
    }

    public void finalize() throws Throwable {
        if (RenderScript.O00000Oo) {
            RenderScript.O00000oO.invoke(RenderScript.O00000o0, Integer.valueOf(this.O00000o));
        }
        super.finalize();
    }

    public Type O000000o() {
        return this.f2962O000000o;
    }

    private void O00000o0(Bitmap bitmap) {
        Bitmap.Config config = bitmap.getConfig();
        if (config != null) {
            int i = AnonymousClass1.f2963O000000o[config.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4) {
                            if (this.f2962O000000o.O0000OOo.O00000o0 != Element.DataKind.PIXEL_RGBA || this.f2962O000000o.O0000OOo.O000000o() != 2) {
                                throw new RSIllegalArgumentException("Allocation kind is " + this.f2962O000000o.O0000OOo.O00000o0 + ", type " + this.f2962O000000o.O0000OOo.O00000Oo + " of " + this.f2962O000000o.O0000OOo.O000000o() + " bytes, passed bitmap was " + config);
                            }
                        }
                    } else if (this.f2962O000000o.O0000OOo.O00000o0 != Element.DataKind.PIXEL_RGB || this.f2962O000000o.O0000OOo.O000000o() != 2) {
                        throw new RSIllegalArgumentException("Allocation kind is " + this.f2962O000000o.O0000OOo.O00000o0 + ", type " + this.f2962O000000o.O0000OOo.O00000Oo + " of " + this.f2962O000000o.O0000OOo.O000000o() + " bytes, passed bitmap was " + config);
                    }
                } else if (this.f2962O000000o.O0000OOo.O00000o0 != Element.DataKind.PIXEL_RGBA || this.f2962O000000o.O0000OOo.O000000o() != 4) {
                    throw new RSIllegalArgumentException("Allocation kind is " + this.f2962O000000o.O0000OOo.O00000o0 + ", type " + this.f2962O000000o.O0000OOo.O00000Oo + " of " + this.f2962O000000o.O0000OOo.O000000o() + " bytes, passed bitmap was " + config);
                }
            } else if (this.f2962O000000o.O0000OOo.O00000o0 != Element.DataKind.PIXEL_A) {
                throw new RSIllegalArgumentException("Allocation kind is " + this.f2962O000000o.O0000OOo.O00000o0 + ", type " + this.f2962O000000o.O0000OOo.O00000Oo + " of " + this.f2962O000000o.O0000OOo.O000000o() + " bytes, passed bitmap was " + config);
            }
        } else {
            throw new RSIllegalArgumentException("Bitmap has an unsupported format for this operation");
        }
    }

    /* renamed from: androidx.renderscript.Allocation$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f2963O000000o = new int[Bitmap.Config.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            f2963O000000o[Bitmap.Config.ALPHA_8.ordinal()] = 1;
            f2963O000000o[Bitmap.Config.ARGB_8888.ordinal()] = 2;
            f2963O000000o[Bitmap.Config.RGB_565.ordinal()] = 3;
            try {
                f2963O000000o[Bitmap.Config.ARGB_4444.ordinal()] = 4;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    private void O00000o(Bitmap bitmap) {
        if (this.O0000OOo != bitmap.getWidth() || this.O0000Oo0 != bitmap.getHeight()) {
            throw new RSIllegalArgumentException("Cannot update allocation from bitmap, sizes mismatch");
        }
    }

    public void O000000o(Bitmap bitmap) {
        this.O0000o0o.O000000o();
        if (bitmap.getConfig() == null) {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            new Canvas(createBitmap).drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
            O000000o(createBitmap);
            return;
        }
        O00000o(bitmap);
        O00000o0(bitmap);
        this.O0000o0o.O00000Oo(O000000o(this.O0000o0o), bitmap);
    }

    public void O00000Oo(Bitmap bitmap) {
        this.O0000o0o.O000000o();
        O00000o0(bitmap);
        O00000o(bitmap);
        this.O0000o0o.O000000o(O000000o(this.O0000o0o), bitmap);
    }

    static {
        BitmapFactory.Options options = new BitmapFactory.Options();
        O0000Ooo = options;
        options.inScaled = false;
    }

    public static Allocation O000000o(RenderScript renderScript, Type type) {
        MipmapControl mipmapControl = MipmapControl.MIPMAP_NONE;
        if (RenderScript.O0000O0o) {
            return hh.O000000o((hm) renderScript, type, mipmapControl, 1);
        }
        renderScript.O000000o();
        if (type.O000000o(renderScript) != 0) {
            int O000000o2 = renderScript.O000000o(type.O000000o(renderScript), mipmapControl.mID, 1);
            if (O000000o2 != 0) {
                return new Allocation(O000000o2, renderScript, type, 1);
            }
            throw new RSRuntimeException("Allocation creation failed.");
        }
        throw new RSInvalidStateException("Bad Type");
    }

    public static Allocation O000000o(RenderScript renderScript, Bitmap bitmap, MipmapControl mipmapControl, int i) {
        Element element;
        Type type;
        while (!RenderScript.O0000O0o) {
            renderScript.O000000o();
            if (bitmap.getConfig() != null) {
                Bitmap.Config config = bitmap.getConfig();
                if (config == Bitmap.Config.ALPHA_8) {
                    if (renderScript.O0000Ooo == null) {
                        renderScript.O0000Ooo = Element.O000000o(renderScript, Element.DataType.UNSIGNED_8, Element.DataKind.PIXEL_A);
                    }
                    element = renderScript.O0000Ooo;
                } else if (config == Bitmap.Config.ARGB_4444) {
                    if (renderScript.O0000o0 == null) {
                        renderScript.O0000o0 = Element.O000000o(renderScript, Element.DataType.UNSIGNED_4_4_4_4, Element.DataKind.PIXEL_RGBA);
                    }
                    element = renderScript.O0000o0;
                } else if (config == Bitmap.Config.ARGB_8888) {
                    element = Element.O00000Oo(renderScript);
                } else if (config == Bitmap.Config.RGB_565) {
                    if (renderScript.O0000o00 == null) {
                        renderScript.O0000o00 = Element.O000000o(renderScript, Element.DataType.UNSIGNED_5_6_5, Element.DataKind.PIXEL_RGB);
                    }
                    element = renderScript.O0000o00;
                } else {
                    throw new RSInvalidStateException("Bad bitmap type: ".concat(String.valueOf(config)));
                }
                Type.O000000o o000000o = new Type.O000000o(renderScript, element);
                int width = bitmap.getWidth();
                if (width > 0) {
                    o000000o.O00000Oo = width;
                    int height = bitmap.getHeight();
                    if (height > 0) {
                        o000000o.O00000o0 = height;
                        o000000o.O00000oO = mipmapControl == MipmapControl.MIPMAP_FULL;
                        if (o000000o.O00000o > 0) {
                            if (o000000o.O00000Oo <= 0 || o000000o.O00000o0 <= 0) {
                                throw new RSInvalidStateException("Both X and Y dimension required when Z is present.");
                            } else if (o000000o.O00000oo) {
                                throw new RSInvalidStateException("Cube maps not supported with 3D types.");
                            }
                        }
                        if (o000000o.O00000o0 > 0 && o000000o.O00000Oo <= 0) {
                            throw new RSInvalidStateException("X dimension required when Y is present.");
                        } else if (o000000o.O00000oo && o000000o.O00000o0 <= 0) {
                            throw new RSInvalidStateException("Cube maps require 2D Types.");
                        } else if (o000000o.O0000O0o == 0 || (o000000o.O00000o == 0 && !o000000o.O00000oo && !o000000o.O00000oO)) {
                            if (RenderScript.O0000O0o) {
                                type = hs.O000000o((hm) o000000o.f2971O000000o, o000000o.O0000OOo, o000000o.O00000Oo, o000000o.O00000o0, o000000o.O00000o, o000000o.O00000oO, o000000o.O00000oo, o000000o.O0000O0o);
                            } else {
                                type = new Type(o000000o.f2971O000000o.O000000o(o000000o.O0000OOo.O000000o(o000000o.f2971O000000o), o000000o.O00000Oo, o000000o.O00000o0, o000000o.O00000o, o000000o.O00000oO, o000000o.O00000oo, o000000o.O0000O0o), o000000o.f2971O000000o);
                            }
                            type.O0000OOo = o000000o.O0000OOo;
                            type.f2970O000000o = o000000o.O00000Oo;
                            type.O00000Oo = o000000o.O00000o0;
                            type.O00000o0 = o000000o.O00000o;
                            type.O00000o = o000000o.O00000oO;
                            type.O00000oO = o000000o.O00000oo;
                            type.O00000oo = o000000o.O0000O0o;
                            type.O000000o();
                            if (mipmapControl == MipmapControl.MIPMAP_NONE && type.O0000OOo.O000000o(Element.O00000Oo(renderScript)) && i == 131) {
                                int O00000Oo2 = renderScript.O00000Oo(type.O000000o(renderScript), mipmapControl.mID, bitmap, i);
                                if (O00000Oo2 != 0) {
                                    Allocation allocation = new Allocation(O00000Oo2, renderScript, type, i);
                                    allocation.O00000Oo = bitmap;
                                    return allocation;
                                }
                                throw new RSRuntimeException("Load failed.");
                            }
                            int O000000o2 = renderScript.O000000o(type.O000000o(renderScript), mipmapControl.mID, bitmap, i);
                            if (O000000o2 != 0) {
                                return new Allocation(O000000o2, renderScript, type, i);
                            }
                            throw new RSRuntimeException("Load failed.");
                        } else {
                            throw new RSInvalidStateException("YUV only supports basic 2D.");
                        }
                    } else {
                        throw new RSIllegalArgumentException("Values of less than 1 for Dimension Y are not valid.");
                    }
                } else {
                    throw new RSIllegalArgumentException("Values of less than 1 for Dimension X are not valid.");
                }
            } else if ((i & NotificationCompat.FLAG_HIGH_PRIORITY) == 0) {
                Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                new Canvas(createBitmap).drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
                bitmap = createBitmap;
            } else {
                throw new RSIllegalArgumentException("USAGE_SHARED cannot be used with a Bitmap that has a null config.");
            }
        }
        return hh.O00000Oo((hm) renderScript, bitmap, mipmapControl, i);
    }

    public static Allocation O000000o(RenderScript renderScript, Bitmap bitmap) {
        return O000000o(renderScript, bitmap, MipmapControl.MIPMAP_NONE, 131);
    }
}

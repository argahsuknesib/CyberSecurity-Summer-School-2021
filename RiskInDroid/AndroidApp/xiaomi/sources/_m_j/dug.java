package _m_j;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import com.xiaomi.base.imageloader.Option;
import java.io.IOException;

public final class dug implements dui {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final vh f14946O000000o = new vh();

    public final void O000000o(String str, ImageView imageView) {
        O000000o(str, imageView, Option.f5974O000000o);
    }

    public final void O000000o(String str, ImageView imageView, Option option) {
        try {
            if (TextUtils.isEmpty(str)) {
                str = "http";
            }
            vm<ImageView, ve> vmVar = null;
            if (str.toLowerCase().endsWith(".gif")) {
                vmVar = O000000o(imageView);
            }
            if (vmVar == null) {
                uo.O000000o(imageView).O000000o(str).O00000Oo(O000000o(option, imageView.getContext())).O000000o(imageView);
            } else {
                uo.O000000o(imageView).O000000o().O000000o(str).O00000Oo(O000000o(option, imageView.getContext())).O000000o(vmVar);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private vm<ImageView, ve> O000000o(ImageView imageView) {
        return new vm<ImageView, ve>(imageView) {
            /* class _m_j.dug.AnonymousClass1 */

            /* JADX WARNING: Removed duplicated region for block: B:14:0x0024  */
            /* JADX WARNING: Removed duplicated region for block: B:17:0x002f  */
            /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
            public final /* synthetic */ void O000000o(Object obj) {
                jnw jnw;
                IOException e;
                ve veVar = (ve) obj;
                try {
                    jnw = new jnw(veVar.getBuffer());
                    try {
                        ((ImageView) this.f2549O000000o).setImageDrawable(jnw);
                    } catch (IOException e2) {
                        e = e2;
                        try {
                            e.printStackTrace();
                            if (jnw != null) {
                                ((ImageView) this.f2549O000000o).setImageDrawable(veVar);
                            }
                        } catch (Throwable th) {
                            th = th;
                            if (jnw == null) {
                                ((ImageView) this.f2549O000000o).setImageDrawable(veVar);
                            }
                            throw th;
                        }
                    }
                } catch (IOException e3) {
                    IOException iOException = e3;
                    jnw = null;
                    e = iOException;
                    e.printStackTrace();
                    if (jnw != null) {
                    }
                } catch (Throwable th2) {
                    Throwable th3 = th2;
                    jnw = null;
                    th = th3;
                    if (jnw == null) {
                    }
                    throw th;
                }
            }
        };
    }

    public final void O000000o(int i, ImageView imageView) {
        uo.O000000o(imageView).O000000o(Integer.valueOf(i)).O00000Oo(O000000o(Option.f5974O000000o, imageView.getContext())).O000000o(imageView);
    }

    @SuppressLint({"CheckResult"})
    private static vh O000000o(Option option, Context context) {
        if (option == null) {
            return f14946O000000o;
        }
        vh vhVar = new vh();
        if (option.O00000Oo != 0) {
            vhVar = (vh) vhVar.O000000o(option.O00000Oo);
        } else if (option.O00000o0 != null) {
            vhVar = (vh) vhVar.O000000o(option.O00000o0);
        }
        if (option.O00000o != 0) {
            vhVar = (vh) vhVar.O00000Oo(option.O00000o);
        } else if (option.O00000oO != null) {
            vhVar = (vh) vhVar.O00000Oo(option.O00000oO);
        }
        if (option.O0000O0o > 0) {
            if (option.O0000o00) {
                duf duf = new duf((float) option.O0000O0o);
                duf.O000000o(option.O0000Oo0, option.O0000Oo, option.O0000OoO, option.O0000Ooo);
                uu uuVar = null;
                if (option.O0000o0 == ImageView.ScaleType.CENTER_CROP) {
                    uuVar = new va();
                } else if (option.O0000o0 == ImageView.ScaleType.FIT_CENTER) {
                    uuVar = new vd();
                } else if (option.O0000o0 == ImageView.ScaleType.CENTER_INSIDE) {
                    uuVar = new vb();
                }
                if (uuVar != null) {
                    vhVar.O000000o(new us(uuVar, duf));
                } else {
                    vhVar.O000000o(duf);
                }
            } else {
                vhVar.O000000o(O00000Oo(option, context));
            }
        }
        if (option.O0000OOo) {
            vhVar.O000000o();
        }
        if (option.O00000oo == null) {
            return vhVar;
        }
        int i = AnonymousClass2.f14947O000000o[option.O00000oo.ordinal()];
        if (i == 1) {
            return (vh) vhVar.O000000o(uv.f2544O000000o);
        }
        if (i == 2) {
            return (vh) vhVar.O000000o(uv.O00000Oo);
        }
        if (i != 3) {
            return vhVar;
        }
        return (vh) vhVar.O000000o(uv.O00000oO);
    }

    /* renamed from: _m_j.dug$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f14947O000000o = new int[Option.Strategy.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            f14947O000000o[Option.Strategy.ALL.ordinal()] = 1;
            f14947O000000o[Option.Strategy.NONE.ordinal()] = 2;
            try {
                f14947O000000o[Option.Strategy.AUTOMATIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    private static due O00000Oo(Option option, Context context) {
        due due = new due((float) option.O0000O0o);
        due.O000000o(option.O0000Oo0, option.O0000Oo, option.O0000OoO, option.O0000Ooo);
        return due;
    }
}

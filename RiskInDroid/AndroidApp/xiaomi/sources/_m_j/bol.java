package _m_j;

import _m_j.bom;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;
import android.text.TextUtils;
import com.google.android.exoplayer2.C;
import com.lidroid.xutils.task.Priority;
import com.lidroid.xutils.task.PriorityAsyncTask;
import com.lidroid.xutils.task.PriorityExecutor;
import java.io.File;
import java.util.HashMap;

public final class bol {
    private static final PriorityExecutor O0000Oo = new PriorityExecutor(2);
    private static final PriorityExecutor O0000Oo0 = new PriorityExecutor(5);
    private static final HashMap<String, bol> O0000o0O = new HashMap<>(1);

    /* renamed from: O000000o  reason: collision with root package name */
    public String f13170O000000o;
    public int O00000Oo = 4194304;
    public boolean O00000o = true;
    public int O00000o0 = 52428800;
    public boolean O00000oO = true;
    bom O00000oo;
    public bop O0000O0o;
    public boj O0000OOo;
    private long O0000OoO = 2592000000L;
    private int O0000Ooo = 15000;
    private Context O0000o0;
    private int O0000o00 = 15000;

    private bol(Context context, String str) {
        if (context != null) {
            this.O0000o0 = context;
            this.f13170O000000o = str;
            new O000000o(this, (byte) 0).O00000o0(0);
            new O000000o(this, (byte) 0).O00000o0(1);
            return;
        }
        throw new IllegalArgumentException("context may not be null");
    }

    public static synchronized bol O000000o(Context context, String str) {
        File cacheDir;
        File externalCacheDir;
        synchronized (bol.class) {
            String str2 = null;
            if (TextUtils.isEmpty(null)) {
                if ("mounted".equals(Environment.getExternalStorageState()) && (externalCacheDir = context.getExternalCacheDir()) != null) {
                    str2 = externalCacheDir.getPath();
                }
                if (str2 == null && (cacheDir = context.getCacheDir()) != null && cacheDir.exists()) {
                    str2 = cacheDir.getPath();
                }
                str = String.valueOf(str2) + File.separator + "xBitmapCache";
            }
            if (O0000o0O.containsKey(str)) {
                bol bol = O0000o0O.get(str);
                return bol;
            }
            bol bol2 = new bol(context, str);
            O0000o0O.put(str, bol2);
            return bol2;
        }
    }

    class O000000o extends PriorityAsyncTask<Object, Void, Object[]> {
        public final /* synthetic */ void O000000o(Object obj) {
            Object[] objArr = (Object[]) obj;
            if (bol.this.O0000OOo != null && objArr != null && objArr.length != 0) {
                try {
                    switch (((Integer) objArr[0]).intValue()) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                            return;
                        case 7:
                            if (objArr.length == 2) {
                                String.valueOf(objArr[1]);
                                return;
                            }
                            return;
                        case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                            if (objArr.length == 2) {
                                String.valueOf(objArr[1]);
                                return;
                            }
                            return;
                        case 9:
                            if (objArr.length == 2) {
                                String.valueOf(objArr[1]);
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                } catch (Throwable th) {
                    brm.O000000o(th.getMessage(), th);
                }
            }
        }

        private O000000o() {
            this.O00000oo = Priority.UI_TOP;
        }

        /* synthetic */ O000000o(bol bol, byte b) {
            this();
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Can't wrap try/catch for region: R(4:34|(2:36|37)|38|39) */
        /* JADX WARNING: Missing exception handler attribute for start block: B:38:0x0081 */
        /* renamed from: O00000oO */
        public Object[] O000000o(Object... objArr) {
            if (!(objArr == null || objArr.length == 0)) {
                bol bol = bol.this;
                if (bol.O00000oo == null) {
                    bol.O00000oo = new bom(bol);
                }
                bom bom = bol.O00000oo;
                if (bom == null) {
                    return objArr;
                }
                try {
                    switch (((Integer) objArr[0]).intValue()) {
                        case 0:
                            if (bom.O00000Oo.O00000o) {
                                if (bom.f13172O000000o != null) {
                                    bom.O00000Oo();
                                }
                                bom.f13172O000000o = new bor<bom.O000000o, Bitmap>(bom.O00000Oo.O00000Oo) {
                                    /* class _m_j.bom.AnonymousClass1 */

                                    public final /* synthetic */ int O000000o(Object obj) {
                                        Bitmap bitmap = (Bitmap) obj;
                                        if (bitmap == null) {
                                            return 0;
                                        }
                                        return bitmap.getRowBytes() * bitmap.getHeight();
                                    }
                                };
                                break;
                            }
                            break;
                        case 1:
                            bom.O000000o();
                            break;
                        case 2:
                            bom.O00000o();
                            break;
                        case 3:
                            bom.O00000Oo();
                            bom.O00000oO();
                            break;
                        case 4:
                            bom.O00000Oo();
                            bom.O00000o0();
                            break;
                        case 5:
                            bom.O00000Oo();
                            break;
                        case 6:
                            bom.O00000o0();
                            break;
                        case 7:
                            if (objArr.length == 2) {
                                String valueOf = String.valueOf(objArr[1]);
                                bom.O000000o(valueOf);
                                bom.O00000Oo(valueOf);
                                break;
                            } else {
                                return objArr;
                            }
                        case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                            if (objArr.length == 2) {
                                bom.O000000o(String.valueOf(objArr[1]));
                                break;
                            } else {
                                return objArr;
                            }
                        case 9:
                            if (objArr.length == 2) {
                                bom.O00000Oo(String.valueOf(objArr[1]));
                                break;
                            } else {
                                return objArr;
                            }
                    }
                } catch (Throwable th) {
                    brm.O000000o(th.getMessage(), th);
                }
            }
            return objArr;
        }
    }
}

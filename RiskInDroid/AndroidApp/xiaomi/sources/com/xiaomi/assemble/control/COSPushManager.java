package com.xiaomi.assemble.control;

import _m_j.azj;
import _m_j.azv;
import _m_j.baa;
import _m_j.bae;
import _m_j.baf;
import _m_j.dzl;
import _m_j.dzm;
import _m_j.dzn;
import _m_j.gsy;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class COSPushManager implements dzl {

    /* renamed from: O000000o  reason: collision with root package name */
    O00000Oo f5968O000000o = null;
    Context O00000Oo;
    private O000000o O00000o0;

    private COSPushManager(Context context) {
        this.O00000Oo = context;
        this.O00000o0 = new O000000o(new WeakReference(this), (byte) 0);
    }

    public static COSPushManager newInstance(Context context) {
        return new COSPushManager(context);
    }

    public static boolean isSupportPush(Context context) {
        return azj.O00000o0(context);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:19|20|(2:22|26)(1:27)) */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x008c, code lost:
        if (r4.O0000O0o != null) goto L_0x008e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x008e, code lost:
        r4.O0000O0o.O000000o(-2, null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x008a */
    public final void O000000o() {
        Context context = this.O00000Oo;
        try {
            gsy.O000000o(4, "ASSEMBLE_PUSH-cpm", "cos push register");
            azj O000000o2 = azj.O000000o();
            O000000o o000000o = this.O00000o0;
            if (context != null) {
                baa baa = new baa(context.getPackageName(), "push_register");
                LinkedList linkedList = new LinkedList();
                linkedList.add(baa);
                LinkedList linkedList2 = new LinkedList();
                linkedList2.addAll(linkedList);
                bae.O000000o("isSupportStatisticByMcs:" + baf.O000000o(context) + ",list size:" + linkedList2.size());
                if (linkedList2.size() > 0 && baf.O000000o(context)) {
                    baf.O000000o(context, linkedList2);
                }
                if (azj.O00000o0(context)) {
                    O000000o2.O00000o = "87Vf3cnJD7wo0ckc0C8c4S0wK";
                    O000000o2.O00000oO = "73be687Ba2DA2f18b767773d55029707";
                    O000000o2.f12735O000000o = context.getApplicationContext();
                    O000000o2.O0000O0o = o000000o;
                    O000000o2.O000000o(12289, null);
                    return;
                }
                throw new IllegalArgumentException("the phone is not support push!");
            }
            throw new IllegalArgumentException("context is null !");
        } catch (Exception e) {
            Log.e("ASSEMBLE_PUSH-cpm", " doRegister error", e);
        }
    }

    static class O000000o implements azv {

        /* renamed from: O000000o  reason: collision with root package name */
        private WeakReference<COSPushManager> f5970O000000o;

        /* synthetic */ O000000o(WeakReference weakReference, byte b) {
            this(weakReference);
        }

        private O000000o(WeakReference<COSPushManager> weakReference) {
            this.f5970O000000o = weakReference;
        }

        public final void O000000o(int i, String str) {
            COSPushManager cOSPushManager;
            COSPushManager cOSPushManager2;
            if (i != 0 || TextUtils.isEmpty(str)) {
                gsy.O000000o(4, "ASSEMBLE_PUSH-cpm", " register fail , code == " + i + " msg == " + str);
                WeakReference<COSPushManager> weakReference = this.f5970O000000o;
                if (weakReference != null && (cOSPushManager = weakReference.get()) != null) {
                    if (dzm.O000000o(cOSPushManager.O00000Oo)) {
                        if (cOSPushManager.f5968O000000o == null) {
                            cOSPushManager.f5968O000000o = new O00000Oo(dzn.f15101O000000o, new Runnable() {
                                /* class com.xiaomi.assemble.control.COSPushManager.AnonymousClass1 */

                                public final void run() {
                                    COSPushManager.this.O000000o();
                                }
                            }, (byte) 0);
                        }
                        O00000Oo o00000Oo = cOSPushManager.f5968O000000o;
                        if (o00000Oo.O00000Oo < o00000Oo.f5971O000000o && !o00000Oo.O00000oO) {
                            o00000Oo.O00000oo.execute(new Runnable() {
                                /* class com.xiaomi.assemble.control.COSPushManager.O00000Oo.AnonymousClass1 */

                                public final void run() {
                                    gsy.O000000o(4, "ASSEMBLE_PUSH-cpm", "第" + O00000Oo.this.O00000Oo + "次　register");
                                    if (O00000Oo.this.O00000Oo >= O00000Oo.this.f5971O000000o || O00000Oo.this.O00000oO) {
                                        gsy.O000000o(4, "ASSEMBLE_PUSH-cpm", "重试未能成功，但已达到最大重试次数.");
                                        return;
                                    }
                                    try {
                                        Thread.sleep((long) O00000Oo.this.O00000o0[O00000Oo.this.O00000Oo]);
                                    } catch (InterruptedException unused) {
                                    }
                                    if (O00000Oo.this.O00000o != null && !O00000Oo.this.O00000oO) {
                                        O00000Oo.this.O00000o.run();
                                        O00000Oo.this.O00000Oo++;
                                    }
                                }
                            });
                            return;
                        }
                        return;
                    }
                    dzm.O000000o(true);
                    return;
                }
                return;
            }
            gsy.O000000o(4, "ASSEMBLE_PUSH-cpm", " register success  && registerId = ".concat(String.valueOf(str)));
            WeakReference<COSPushManager> weakReference2 = this.f5970O000000o;
            if (weakReference2 != null && (cOSPushManager2 = weakReference2.get()) != null) {
                if (cOSPushManager2.f5968O000000o != null) {
                    O00000Oo o00000Oo2 = cOSPushManager2.f5968O000000o;
                    o00000Oo2.O00000oO = true;
                    o00000Oo2.O00000Oo = 0;
                }
                dzm.O000000o(false);
                gsy.O000000o(4, "ASSEMBLE_PUSH-cpm", " registerId = ".concat(String.valueOf(str)));
                gsy.O000000o(4, "ASSEMBLE_PUSH-cpm", " begin upload cos token ");
                if (cOSPushManager2.O00000Oo != null) {
                    dzm.O000000o(cOSPushManager2.O00000Oo, str);
                }
            }
        }

        public final void O000000o(int i) {
            if (i == 0) {
                gsy.O000000o(4, "ASSEMBLE_PUSH-cpm", " UnRegister success");
            } else {
                gsy.O000000o(4, "ASSEMBLE_PUSH-cpm", " UnRegister fail");
            }
        }
    }

    static class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        public int f5971O000000o;
        public int O00000Oo;
        public Runnable O00000o;
        public int[] O00000o0;
        public volatile boolean O00000oO;
        Executor O00000oo;

        /* synthetic */ O00000Oo(int[] iArr, Runnable runnable, byte b) {
            this(iArr, runnable);
        }

        private O00000Oo(int[] iArr, Runnable runnable) {
            this.O00000Oo = 0;
            this.O00000oO = false;
            if (iArr == null || iArr.length <= 0) {
                throw new IllegalArgumentException("参数传入出错！");
            }
            this.f5971O000000o = iArr.length;
            this.O00000o0 = iArr;
            this.O00000o = runnable;
            this.O00000oo = Executors.newSingleThreadExecutor();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0019, code lost:
        if (r0.O0000O0o != null) goto L_0x001b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001b, code lost:
        r0.O0000O0o.O000000o(-2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0017 */
    public final void O00000Oo() {
        try {
            azj O000000o2 = azj.O000000o();
            if (O000000o2.f12735O000000o != null) {
                O000000o2.O000000o(12290, null);
                return;
            }
            throw new IllegalArgumentException("please call the register first!");
        } catch (Exception e) {
            Log.e("ASSEMBLE_PUSH-cpm", " doUnRegister error", e);
        }
    }
}

package _m_j;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import com.inuker.bluetooth.library.IBluetoothService;
import com.inuker.bluetooth.library.receiver.BluetoothReceiver;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;

public class bii implements bil, bld, Handler.Callback {
    private static final String O0000O0o = "bii";
    private static bil O0000Oo0;

    /* renamed from: O000000o  reason: collision with root package name */
    public IBluetoothService f12995O000000o;
    CountDownLatch O00000Oo;
    HashMap<String, List<biu>> O00000o;
    public HashMap<String, HashMap<String, List<bjs>>> O00000o0;
    List<biv> O00000oO;
    List<bkj> O00000oo;
    private Context O0000OOo;
    private HandlerThread O0000Oo;
    private Handler O0000OoO;
    private final ServiceConnection O0000Ooo = new ServiceConnection() {
        /* class _m_j.bii.AnonymousClass1 */

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            bii.this.f12995O000000o = IBluetoothService.Stub.asInterface(iBinder);
            bii bii = bii.this;
            if (bii.O00000Oo != null) {
                bii.O00000Oo.countDown();
                bii.O00000Oo = null;
            }
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            bii.this.f12995O000000o = null;
        }
    };

    private bii(Context context) {
        this.O0000OOo = context.getApplicationContext();
        bij.f13001O000000o = this.O0000OOo;
        this.O0000Oo = new HandlerThread(O0000O0o);
        this.O0000Oo.start();
        this.O0000OoO = new Handler(this.O0000Oo.getLooper(), this);
        this.O00000o0 = new HashMap<>();
        this.O00000o = new HashMap<>();
        this.O00000oO = new LinkedList();
        this.O00000oo = new LinkedList();
        this.O0000OoO.obtainMessage(2).sendToTarget();
    }

    public static bil O000000o(Context context) {
        if (O0000Oo0 == null) {
            synchronized (bii.class) {
                if (O0000Oo0 == null) {
                    bii bii = new bii(context);
                    O0000Oo0 = (bil) blf.O000000o(bii, bil.class, bii);
                }
            }
        }
        return O0000Oo0;
    }

    public final void O000000o(String str, UUID uuid, UUID uuid2, bjs bjs) {
        O00000Oo();
        HashMap hashMap = this.O00000o0.get(str);
        if (hashMap == null) {
            hashMap = new HashMap();
            this.O00000o0.put(str, hashMap);
        }
        String O000000o2 = O000000o(uuid, uuid2);
        List list = (List) hashMap.get(O000000o2);
        if (list == null) {
            list = new ArrayList();
            hashMap.put(O000000o2, list);
        }
        list.add(bjs);
    }

    public static String O000000o(UUID uuid, UUID uuid2) {
        return String.format("%s_%s", uuid, uuid2);
    }

    public final boolean O000000o(Object obj, Method method, Object[] objArr) {
        this.O0000OoO.obtainMessage(1, new blc(obj, method, objArr)).sendToTarget();
        return true;
    }

    public boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 1) {
            ((blc) message.obj).O000000o();
        } else if (i == 2) {
            O00000Oo();
            BluetoothReceiver.O000000o().O000000o(new bkn() {
                /* class _m_j.bii.AnonymousClass2 */

                public final void O000000o(int i) {
                    bii.this.O00000Oo();
                    bii bii = bii.this;
                    bii.O00000Oo();
                    if (i == 10 || i == 12) {
                        for (biv next : bii.O00000oO) {
                            boolean z = true;
                            Object[] objArr = new Object[1];
                            if (i != 12) {
                                z = false;
                            }
                            objArr[0] = Boolean.valueOf(z);
                            next.O00000Oo(objArr);
                        }
                    }
                }
            });
            BluetoothReceiver.O000000o().O000000o(new bkk() {
                /* class _m_j.bii.AnonymousClass3 */

                public final void O000000o(String str, int i) {
                    bii.this.O00000Oo();
                    bii bii = bii.this;
                    bii.O00000Oo();
                    for (bkj O00000Oo : bii.O00000oo) {
                        O00000Oo.O00000Oo(str, Integer.valueOf(i));
                    }
                }
            });
            BluetoothReceiver.O000000o().O000000o(new bki() {
                /* class _m_j.bii.AnonymousClass4 */

                public final void O000000o(String str, int i) {
                    bii.this.O00000Oo();
                    if (i == 32) {
                        bii bii = bii.this;
                        bii.O00000Oo();
                        bii.O00000o0.remove(str);
                    }
                    bii bii2 = bii.this;
                    bii2.O00000Oo();
                    List<biu> list = bii2.O00000o.get(str);
                    if (!blb.O000000o(list)) {
                        for (biu O00000Oo : list) {
                            O00000Oo.O00000Oo(str, Integer.valueOf(i));
                        }
                    }
                }
            });
            BluetoothReceiver.O000000o().O000000o(new bkh() {
                /* class _m_j.bii.AnonymousClass5 */

                public final void O000000o(String str, UUID uuid, UUID uuid2, byte[] bArr) {
                    List list;
                    bii.this.O00000Oo();
                    bii bii = bii.this;
                    bii.O00000Oo();
                    HashMap hashMap = bii.O00000o0.get(str);
                    if (hashMap != null && (list = (List) hashMap.get(bii.O000000o(uuid, uuid2))) != null) {
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            it.next();
                        }
                    }
                }
            });
        }
        return true;
    }

    public final void O00000Oo() {
        if (Looper.myLooper() != this.O0000OoO.getLooper()) {
            throw new RuntimeException();
        }
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.inuker.bluetooth.library.connect.response.BluetoothResponse, com.inuker.bluetooth.library.IResponse, android.os.Bundle] */
    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: ?
        	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
        	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
        	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
        	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
        	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
        	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
        */
    public final void O000000o() {
        /*
            r4 = this;
            r4.O00000Oo()
            com.inuker.bluetooth.library.IBluetoothService r0 = r4.f12995O000000o     // Catch:{ Throwable -> 0x0069 }
            if (r0 != 0) goto L_0x0054
            r4.O00000Oo()     // Catch:{ Throwable -> 0x0069 }
            java.util.concurrent.CountDownLatch r0 = new java.util.concurrent.CountDownLatch     // Catch:{ Throwable -> 0x0069 }
            r1 = 1
            r0.<init>(r1)     // Catch:{ Throwable -> 0x0069 }
            r4.O00000Oo = r0     // Catch:{ Throwable -> 0x0069 }
            android.content.Intent r0 = new android.content.Intent     // Catch:{ Throwable -> 0x0069 }
            r0.<init>()     // Catch:{ Throwable -> 0x0069 }
            android.content.Context r2 = r4.O0000OOo     // Catch:{ Throwable -> 0x0069 }
            java.lang.Class<com.inuker.bluetooth.library.BluetoothService> r3 = com.inuker.bluetooth.library.BluetoothService.class
            r0.setClass(r2, r3)     // Catch:{ Throwable -> 0x0069 }
            android.content.Context r2 = r4.O0000OOo     // Catch:{ Throwable -> 0x0069 }
            android.content.ServiceConnection r3 = r4.O0000Ooo     // Catch:{ Throwable -> 0x0069 }
            boolean r0 = r2.bindService(r0, r3, r1)     // Catch:{ Throwable -> 0x0069 }
            r1 = 0
            if (r0 == 0) goto L_0x0043
            java.lang.String r0 = "BluetoothService registered"
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ Throwable -> 0x0069 }
            java.lang.String r0 = java.lang.String.format(r0, r1)     // Catch:{ Throwable -> 0x0069 }
            _m_j.bky.O00000Oo(r0)     // Catch:{ Throwable -> 0x0069 }
            java.util.concurrent.CountDownLatch r0 = r4.O00000Oo     // Catch:{ InterruptedException -> 0x003e }
            if (r0 == 0) goto L_0x0054
            java.util.concurrent.CountDownLatch r0 = r4.O00000Oo     // Catch:{ InterruptedException -> 0x003e }
            r0.await()     // Catch:{ InterruptedException -> 0x003e }
            goto L_0x0054
        L_0x003e:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ Throwable -> 0x0069 }
            goto L_0x0054
        L_0x0043:
            java.lang.String r0 = "BluetoothService not registered"
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ Throwable -> 0x0069 }
            java.lang.String r0 = java.lang.String.format(r0, r1)     // Catch:{ Throwable -> 0x0069 }
            _m_j.bky.O00000Oo(r0)     // Catch:{ Throwable -> 0x0069 }
            com.inuker.bluetooth.library.BluetoothServiceImpl r0 = com.inuker.bluetooth.library.BluetoothServiceImpl.getInstance()     // Catch:{ Throwable -> 0x0069 }
            r4.f12995O000000o = r0     // Catch:{ Throwable -> 0x0069 }
        L_0x0054:
            com.inuker.bluetooth.library.IBluetoothService r0 = r4.f12995O000000o     // Catch:{ Throwable -> 0x0069 }
            r1 = 0
            if (r0 == 0) goto L_0x0064
            android.os.Bundle r2 = new android.os.Bundle     // Catch:{ Throwable -> 0x0069 }
            r2.<init>()     // Catch:{ Throwable -> 0x0069 }
            r3 = 12
            r0.callBluetoothApi(r3, r2, r1)     // Catch:{ Throwable -> 0x0069 }
            return
        L_0x0064:
            r0 = -6
            r1.onResponse(r0, r1)     // Catch:{ Throwable -> 0x0069 }
            return
        L_0x0069:
            r0 = move-exception
            _m_j.bky.O000000o(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: _m_j.bii.O000000o():void");
    }
}

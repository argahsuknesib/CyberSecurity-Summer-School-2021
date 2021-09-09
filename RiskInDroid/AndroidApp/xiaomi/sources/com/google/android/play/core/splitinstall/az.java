package com.google.android.play.core.splitinstall;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.play.core.internal.aa;
import com.google.android.play.core.internal.ak;
import com.google.android.play.core.internal.bp;
import com.google.android.play.core.internal.bt;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.Tasks;
import com.google.android.play.core.tasks.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

final class az {
    /* access modifiers changed from: private */
    public static final aa b = new aa("SplitInstallService");
    private static final Intent c = new Intent("com.google.android.play.core.splitinstall.BIND_SPLIT_INSTALL_SERVICE").setPackage("com.android.vending");

    /* renamed from: a  reason: collision with root package name */
    ak<bp> f3810a;
    /* access modifiers changed from: private */
    public final String d;

    public az(Context context) {
        this.d = context.getPackageName();
        if (bt.a(context)) {
            this.f3810a = new ak(v.a(context), b, "SplitInstallService", c, ah.f3800a);
        }
    }

    static /* synthetic */ ArrayList a(Collection collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            Bundle bundle = new Bundle();
            bundle.putString("module_name", (String) it.next());
            arrayList.add(bundle);
        }
        return arrayList;
    }

    static /* synthetic */ Bundle b() {
        Bundle bundle = new Bundle();
        bundle.putInt("playcore_version_code", 10703);
        return bundle;
    }

    /* JADX WARN: Type inference failed for: r6v0, types: [java.util.List, java.util.Collection] */
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
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:77)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:77)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
        */
    static /* synthetic */ java.util.ArrayList b(java.util.Collection r6) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r6.size()
            r0.<init>(r1)
            int r1 = r6.size()
            r2 = 0
        L_0x000e:
            if (r2 >= r1) goto L_0x0026
            java.lang.Object r3 = r6.get(r2)
            java.lang.String r3 = (java.lang.String) r3
            android.os.Bundle r4 = new android.os.Bundle
            r4.<init>()
            java.lang.String r5 = "language"
            r4.putString(r5, r3)
            r0.add(r4)
            int r2 = r2 + 1
            goto L_0x000e
        L_0x0026:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.splitinstall.az.b(java.util.Collection):java.util.ArrayList");
    }

    private static <T> Task<T> d() {
        b.b("onError(%d)", -14);
        return Tasks.a((Exception) new SplitInstallException(-14));
    }

    public final Task<List<SplitInstallSessionState>> a() {
        if (this.f3810a == null) {
            return d();
        }
        b.c("getSessionStates", new Object[0]);
        i iVar = new i();
        this.f3810a.a(new ao(this, iVar, iVar));
        return iVar.a();
    }

    public final Task<SplitInstallSessionState> a(int i) {
        if (this.f3810a == null) {
            return d();
        }
        b.c("getSessionState(%d)", Integer.valueOf(i));
        i iVar = new i();
        this.f3810a.a(new an(this, iVar, i, iVar));
        return iVar.a();
    }

    public final Task<Integer> a(Collection<String> collection, Collection<String> collection2) {
        if (this.f3810a == null) {
            return d();
        }
        b.c("startInstall(%s,%s)", collection, collection2);
        i iVar = new i();
        this.f3810a.a(new ai(this, iVar, collection, collection2, iVar));
        return iVar.a();
    }

    public final Task<Void> a(List<String> list) {
        if (this.f3810a == null) {
            return d();
        }
        b.c("deferredUninstall(%s)", list);
        i iVar = new i();
        this.f3810a.a(new aj(this, iVar, list, iVar));
        return iVar.a();
    }

    public final Task<Void> b(int i) {
        if (this.f3810a == null) {
            return d();
        }
        b.c("cancelInstall(%d)", Integer.valueOf(i));
        i iVar = new i();
        this.f3810a.a(new ap(this, iVar, i, iVar));
        return iVar.a();
    }

    public final Task<Void> b(List<String> list) {
        if (this.f3810a == null) {
            return d();
        }
        b.c("deferredInstall(%s)", list);
        i iVar = new i();
        this.f3810a.a(new ak(this, iVar, list, iVar));
        return iVar.a();
    }

    public final Task<Void> c(List<String> list) {
        if (this.f3810a == null) {
            return d();
        }
        b.c("deferredLanguageInstall(%s)", list);
        i iVar = new i();
        this.f3810a.a(new al(this, iVar, list, iVar));
        return iVar.a();
    }

    public final Task<Void> d(List<String> list) {
        if (this.f3810a == null) {
            return d();
        }
        b.c("deferredLanguageUninstall(%s)", list);
        i iVar = new i();
        this.f3810a.a(new am(this, iVar, list, iVar));
        return iVar.a();
    }
}

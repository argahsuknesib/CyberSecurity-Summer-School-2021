package _m_j;

import _m_j.ayq;
import _m_j.ays;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import java.util.UUID;

public final class ayg<V extends ays, P extends ayq<V, ?>> implements ayf {

    /* renamed from: O000000o  reason: collision with root package name */
    public static boolean f12702O000000o = false;
    private String O00000Oo;
    private Activity O00000o;
    private ayi<V, P> O00000o0;
    private boolean O00000oO;
    private P O00000oo;

    public ayg(Activity activity, ayi<V, P> ayi) {
        this(activity, ayi, (byte) 0);
    }

    private ayg(Activity activity, ayi<V, P> ayi, byte b) {
        this.O00000Oo = null;
        if (activity == null) {
            throw new NullPointerException("Activity is null");
        } else if (ayi != null) {
            this.O00000o0 = ayi;
            this.O00000o = activity;
            this.O00000oO = true;
        } else {
            throw new NullPointerException("MvpDelegateCallback is null!");
        }
    }

    public final void O000000o(Bundle bundle) {
        if (this.O00000oO && bundle != null) {
            this.O00000Oo = bundle.getString("com.hannesdorfmann.mosby3.activity.mvi.id");
        }
        if (f12702O000000o) {
            Log.d("ActivityMviDelegateImpl", "MosbyView ID = " + this.O00000Oo + " for MvpView: " + ((Object) this.O00000o0.getMvpView()));
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: P
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
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00b4  */
    public final void O00000Oo() {
        /*
            r6 = this;
            java.lang.String r0 = r6.O00000Oo
            r1 = 1
            r2 = 0
            java.lang.String r3 = "ActivityMviDelegateImpl"
            if (r0 != 0) goto L_0x0034
            _m_j.ayq r0 = r6.O00000o()
            r6.O00000oo = r0
            boolean r0 = _m_j.ayg.f12702O000000o
            if (r0 == 0) goto L_0x005f
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r4 = "new Presenter instance created: "
            r0.<init>(r4)
            P r4 = r6.O00000oo
            r0.append(r4)
            java.lang.String r4 = " for "
            r0.append(r4)
            _m_j.ayi<V, P> r4 = r6.O00000o0
            _m_j.ays r4 = r4.getMvpView()
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            android.util.Log.d(r3, r0)
            goto L_0x005f
        L_0x0034:
            android.app.Activity r4 = r6.O00000o
            java.lang.Object r0 = _m_j.ayj.O000000o(r4, r0)
            _m_j.ayq r0 = (_m_j.ayq) r0
            r6.O00000oo = r0
            P r0 = r6.O00000oo
            if (r0 != 0) goto L_0x0061
            _m_j.ayq r0 = r6.O00000o()
            r6.O00000oo = r0
            boolean r0 = _m_j.ayg.f12702O000000o
            if (r0 == 0) goto L_0x005f
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r4 = "No Presenter instance found in cache, although MosbyView ID present. This was caused by process death, therefore new Presenter instance created: "
            r0.<init>(r4)
            P r4 = r6.O00000oo
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            android.util.Log.d(r3, r0)
        L_0x005f:
            r0 = 0
            goto L_0x0079
        L_0x0061:
            boolean r0 = _m_j.ayg.f12702O000000o
            if (r0 == 0) goto L_0x0078
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r4 = "Presenter instance reused from internal cache: "
            r0.<init>(r4)
            P r4 = r6.O00000oo
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            android.util.Log.d(r3, r0)
        L_0x0078:
            r0 = 1
        L_0x0079:
            _m_j.ayi<V, P> r4 = r6.O00000o0
            _m_j.ays r4 = r4.getMvpView()
            if (r4 == 0) goto L_0x00b4
            if (r0 == 0) goto L_0x0088
            _m_j.ayi<V, P> r5 = r6.O00000o0
            r5.setRestoringViewState(r1)
        L_0x0088:
            P r1 = r6.O00000oo
            r1.O000000o(r4)
            if (r0 == 0) goto L_0x0094
            _m_j.ayi<V, P> r0 = r6.O00000o0
            r0.setRestoringViewState(r2)
        L_0x0094:
            boolean r0 = _m_j.ayg.f12702O000000o
            if (r0 == 0) goto L_0x00b3
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "MvpView attached to Presenter. MvpView: "
            r0.<init>(r1)
            r0.append(r4)
            java.lang.String r1 = "   Presenter: "
            r0.append(r1)
            P r1 = r6.O00000oo
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            android.util.Log.d(r3, r0)
        L_0x00b3:
            return
        L_0x00b4:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "MvpView returned from getMvpView() is null. Returned by "
            r1.<init>(r2)
            android.app.Activity r2 = r6.O00000o
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: _m_j.ayg.O00000Oo():void");
    }

    private P O00000o() {
        P createPresenter = this.O00000o0.createPresenter();
        if (createPresenter != null) {
            if (this.O00000oO) {
                this.O00000Oo = UUID.randomUUID().toString();
                ayj.O000000o(this.O00000o, this.O00000Oo, createPresenter);
            }
            return createPresenter;
        }
        throw new NullPointerException("Presenter returned from createPresenter() is null. Activity is " + this.O00000o);
    }

    public final void O00000Oo(Bundle bundle) {
        if (this.O00000oO && bundle != null) {
            bundle.putString("com.hannesdorfmann.mosby3.activity.mvi.id", this.O00000Oo);
            if (f12702O000000o) {
                Log.d("ActivityMviDelegateImpl", "Saving MosbyViewId into Bundle. ViewId: " + this.O00000Oo);
            }
        }
    }

    static boolean O000000o(boolean z, Activity activity) {
        if (z) {
            return activity.isChangingConfigurations() || !activity.isFinishing();
        }
        return false;
    }

    public final void O00000o0() {
        this.O00000oo.O000000o();
        if (f12702O000000o) {
            Log.d("ActivityMviDelegateImpl", "detached MvpView from Presenter. MvpView " + ((Object) this.O00000o0.getMvpView()) + "   Presenter: " + ((Object) this.O00000oo));
        }
    }

    public final void O000000o() {
        if (this.O00000oo != null && !O000000o(this.O00000oO, this.O00000o)) {
            this.O00000oo.O00000Oo();
            String str = this.O00000Oo;
            if (str != null) {
                ayj.O00000Oo(this.O00000o, str);
            }
            Log.d("ActivityMviDelegateImpl", "Destroying Presenter permanently " + ((Object) this.O00000oo));
        }
        this.O00000oo = null;
        this.O00000o = null;
        this.O00000o0 = null;
    }
}

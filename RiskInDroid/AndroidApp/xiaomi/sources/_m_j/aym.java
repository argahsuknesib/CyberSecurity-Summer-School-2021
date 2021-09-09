package _m_j;

import _m_j.ayq;
import _m_j.ays;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import com.hannesdorfmann.mosby3.MosbySavedState;
import java.util.UUID;

public final class aym<V extends ays, P extends ayq<V, ?>> implements ayk<V, P>, Application.ActivityLifecycleCallbacks {

    /* renamed from: O000000o  reason: collision with root package name */
    public static boolean f12706O000000o = false;
    private ayl<V, P> O00000Oo;
    private final boolean O00000o;
    private String O00000o0;
    private final boolean O00000oO;
    private P O00000oo;
    private final Activity O0000O0o;
    private boolean O0000OOo = false;
    private boolean O0000Oo = false;
    private boolean O0000Oo0 = false;

    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public final void onActivityPaused(Activity activity) {
    }

    public final void onActivityResumed(Activity activity) {
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }

    public aym(View view, ayl<V, P> ayl) {
        if (view == null) {
            throw new NullPointerException("View is null!");
        } else if (ayl != null) {
            this.O00000Oo = ayl;
            this.O00000o = true;
            this.O00000oO = view.isInEditMode();
            if (!this.O00000oO) {
                this.O0000O0o = ayj.O000000o(ayl.getContext());
                this.O0000O0o.getApplication().registerActivityLifecycleCallbacks(this);
                return;
            }
            this.O0000O0o = null;
        } else {
            throw new NullPointerException("MvpDelegateCallback is null!");
        }
    }

    private P O00000o() {
        P createPresenter = this.O00000Oo.createPresenter();
        if (createPresenter != null) {
            if (this.O00000o) {
                Context context = this.O00000Oo.getContext();
                this.O00000o0 = UUID.randomUUID().toString();
                ayj.O000000o(ayj.O000000o(context), this.O00000o0, createPresenter);
            }
            return createPresenter;
        }
        throw new NullPointerException("Presenter returned from createPresenter() is null.");
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
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00b5  */
    public final void O000000o() {
        /*
            r6 = this;
            boolean r0 = r6.O00000oO
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            java.lang.String r0 = r6.O00000o0
            r1 = 1
            r2 = 0
            java.lang.String r3 = "ViewGroupMviDelegateImp"
            if (r0 != 0) goto L_0x002b
            _m_j.ayq r0 = r6.O00000o()
            r6.O00000oo = r0
            boolean r0 = _m_j.aym.f12706O000000o
            if (r0 == 0) goto L_0x0060
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r4 = "new Presenter instance created: "
            r0.<init>(r4)
            P r4 = r6.O00000oo
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            android.util.Log.d(r3, r0)
            goto L_0x0060
        L_0x002b:
            _m_j.ayl<V, P> r0 = r6.O00000Oo
            android.content.Context r0 = r0.getContext()
            if (r0 == 0) goto L_0x00cb
            android.app.Activity r0 = r6.O0000O0o
            java.lang.String r4 = r6.O00000o0
            java.lang.Object r0 = _m_j.ayj.O000000o(r0, r4)
            _m_j.ayq r0 = (_m_j.ayq) r0
            r6.O00000oo = r0
            P r0 = r6.O00000oo
            if (r0 != 0) goto L_0x0062
            _m_j.ayq r0 = r6.O00000o()
            r6.O00000oo = r0
            boolean r0 = _m_j.aym.f12706O000000o
            if (r0 == 0) goto L_0x0060
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r4 = "No Presenter instance found in cache, although MosbyView ID present. This was caused by process death, therefore new Presenter instance created: "
            r0.<init>(r4)
            P r4 = r6.O00000oo
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            android.util.Log.d(r3, r0)
        L_0x0060:
            r0 = 0
            goto L_0x007a
        L_0x0062:
            boolean r0 = _m_j.aym.f12706O000000o
            if (r0 == 0) goto L_0x0079
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r4 = "Presenter instance reused from internal cache: "
            r0.<init>(r4)
            P r4 = r6.O00000oo
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            android.util.Log.d(r3, r0)
        L_0x0079:
            r0 = 1
        L_0x007a:
            _m_j.ayl<V, P> r4 = r6.O00000Oo
            _m_j.ays r4 = r4.getMvpView()
            if (r4 == 0) goto L_0x00b5
            if (r0 == 0) goto L_0x0089
            _m_j.ayl<V, P> r5 = r6.O00000Oo
            r5.setRestoringViewState(r1)
        L_0x0089:
            P r1 = r6.O00000oo
            r1.O000000o(r4)
            if (r0 == 0) goto L_0x0095
            _m_j.ayl<V, P> r0 = r6.O00000Oo
            r0.setRestoringViewState(r2)
        L_0x0095:
            boolean r0 = _m_j.aym.f12706O000000o
            if (r0 == 0) goto L_0x00b4
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
        L_0x00b4:
            return
        L_0x00b5:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "MvpView returned from getMvpView() is null. Returned by "
            r1.<init>(r2)
            _m_j.ayl<V, P> r2 = r6.O00000Oo
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x00cb:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Context returned from "
            r1.<init>(r2)
            _m_j.ayl<V, P> r2 = r6.O00000Oo
            r1.append(r2)
            java.lang.String r2 = " is null"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: _m_j.aym.O000000o():void");
    }

    public final void O00000Oo() {
        if (!this.O00000oO) {
            O00000oo();
            if (this.O0000OOo) {
                return;
            }
            if (!ayg.O000000o(this.O00000o, this.O0000O0o)) {
                O00000oO();
            } else if (!this.O0000O0o.isFinishing()) {
                O00000oO();
            }
        }
    }

    public final Parcelable O00000o0() {
        if (this.O00000oO) {
            return null;
        }
        Parcelable m_ = this.O00000Oo.m_();
        return this.O00000o ? new MosbySavedState(m_, this.O00000o0) : m_;
    }

    public final void O000000o(Parcelable parcelable) {
        if (!this.O00000oO) {
            if (!(parcelable instanceof MosbySavedState)) {
                this.O00000Oo.O000000o(parcelable);
                return;
            }
            MosbySavedState mosbySavedState = (MosbySavedState) parcelable;
            this.O00000o0 = mosbySavedState.f4332O000000o;
            this.O00000Oo.O000000o(mosbySavedState.getSuperState());
        }
    }

    public final void onActivityDestroyed(Activity activity) {
        if (activity == this.O0000O0o) {
            activity.getApplication().unregisterActivityLifecycleCallbacks(this);
            this.O0000OOo = true;
            if (!ayg.O000000o(this.O00000o, activity)) {
                O00000oo();
                O00000oO();
            }
        }
    }

    private void O00000oO() {
        if (!this.O0000Oo) {
            this.O00000oo.O00000Oo();
            this.O0000Oo = true;
            if (f12706O000000o) {
                Log.d("ViewGroupMviDelegateImp", "Presenter destroyed: " + ((Object) this.O00000oo));
            }
            String str = this.O00000o0;
            if (str != null) {
                ayj.O00000Oo(this.O0000O0o, str);
            }
            this.O00000o0 = null;
        }
    }

    private void O00000oo() {
        if (!this.O0000Oo0) {
            this.O00000oo.O000000o();
            this.O0000Oo0 = true;
            if (f12706O000000o) {
                Log.d("ViewGroupMviDelegateImp", "view " + ((Object) this.O00000Oo.getMvpView()) + " detached from Presenter " + ((Object) this.O00000oo));
            }
        }
    }
}

package _m_j;

import _m_j.fn;
import _m_j.fr;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import androidx.loader.content.Loader;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

final class fs extends fr {

    /* renamed from: O000000o  reason: collision with root package name */
    static boolean f17042O000000o = false;
    private final fa O00000Oo;
    private final O00000o0 O00000o0;

    public static class O000000o<D> extends fg<D> implements Loader.O00000o0<D> {

        /* renamed from: O000000o  reason: collision with root package name */
        final int f17043O000000o;
        final Bundle O00000Oo;
        O00000Oo<D> O00000o;
        final Loader<D> O00000o0;
        Loader<D> O00000oO = null;
        private fa O00000oo;

        O000000o(int i, Bundle bundle, Loader<D> loader, Loader<D> loader2) {
            this.f17043O000000o = i;
            this.O00000Oo = bundle;
            this.O00000o0 = loader;
            this.O00000o0.registerListener(i, this);
        }

        public final void onActive() {
            if (fs.f17042O000000o) {
                Log.v("LoaderManager", "  Starting: ".concat(String.valueOf(this)));
            }
            this.O00000o0.startLoading();
        }

        public final void onInactive() {
            if (fs.f17042O000000o) {
                Log.v("LoaderManager", "  Stopping: ".concat(String.valueOf(this)));
            }
            this.O00000o0.stopLoading();
        }

        /* access modifiers changed from: package-private */
        public final Loader<D> O000000o(fa faVar, fr.O000000o<D> o000000o) {
            O00000Oo<D> o00000Oo = new O00000Oo<>(this.O00000o0, o000000o);
            observe(faVar, o00000Oo);
            O00000Oo<D> o00000Oo2 = this.O00000o;
            if (o00000Oo2 != null) {
                removeObserver(o00000Oo2);
            }
            this.O00000oo = faVar;
            this.O00000o = o00000Oo;
            return this.O00000o0;
        }

        /* access modifiers changed from: package-private */
        public final void O000000o() {
            fa faVar = this.O00000oo;
            O00000Oo<D> o00000Oo = this.O00000o;
            if (faVar != null && o00000Oo != null) {
                super.removeObserver(o00000Oo);
                observe(faVar, o00000Oo);
            }
        }

        public final void removeObserver(fh<? super D> fhVar) {
            super.removeObserver(fhVar);
            this.O00000oo = null;
            this.O00000o = null;
        }

        public final void O000000o(D d) {
            if (fs.f17042O000000o) {
                Log.v("LoaderManager", "onLoadComplete: ".concat(String.valueOf(this)));
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                setValue(d);
                return;
            }
            if (fs.f17042O000000o) {
                Log.w("LoaderManager", "onLoadComplete was incorrectly called on a background thread");
            }
            postValue(d);
        }

        public final void setValue(D d) {
            super.setValue(d);
            Loader<D> loader = this.O00000oO;
            if (loader != null) {
                loader.reset();
                this.O00000oO = null;
            }
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.f17043O000000o);
            sb.append(" : ");
            bb.O000000o(this.O00000o0, sb);
            sb.append("}}");
            return sb.toString();
        }
    }

    static class O00000Oo<D> implements fh<D> {

        /* renamed from: O000000o  reason: collision with root package name */
        final Loader<D> f17044O000000o;
        final fr.O000000o<D> O00000Oo;
        boolean O00000o0 = false;

        O00000Oo(Loader<D> loader, fr.O000000o<D> o000000o) {
            this.f17044O000000o = loader;
            this.O00000Oo = o000000o;
        }

        public final void onChanged(D d) {
            if (fs.f17042O000000o) {
                Log.v("LoaderManager", "  onLoadFinished in " + this.f17044O000000o + ": " + this.f17044O000000o.dataToString(d));
            }
            this.O00000Oo.onLoadFinished(this.f17044O000000o, d);
            this.O00000o0 = true;
        }

        public final String toString() {
            return this.O00000Oo.toString();
        }
    }

    static class O00000o0 extends fm {
        private static final fn.O00000Oo O00000o0 = new fn.O00000Oo() {
            /* class _m_j.fs.O00000o0.AnonymousClass1 */

            public final <T extends fm> T O000000o(Class<T> cls) {
                return new O00000o0();
            }
        };

        /* renamed from: O000000o  reason: collision with root package name */
        o0OO00o0<O000000o> f17045O000000o = new o0OO00o0<>();
        boolean O00000Oo = false;

        O00000o0() {
        }

        static O00000o0 O000000o(fp fpVar) {
            return (O00000o0) new fn(fpVar, O00000o0).O000000o(O00000o0.class);
        }

        public void onCleared() {
            super.onCleared();
            int O00000Oo2 = this.f17045O000000o.O00000Oo();
            for (int i = 0; i < O00000Oo2; i++) {
                O000000o O00000o02 = this.f17045O000000o.O00000o0(i);
                if (fs.f17042O000000o) {
                    Log.v("LoaderManager", "  Destroying: ".concat(String.valueOf(O00000o02)));
                }
                O00000o02.O00000o0.cancelLoad();
                O00000o02.O00000o0.abandon();
                O00000Oo<D> o00000Oo = O00000o02.O00000o;
                if (o00000Oo != null) {
                    O00000o02.removeObserver(o00000Oo);
                    if (o00000Oo.O00000o0) {
                        if (fs.f17042O000000o) {
                            Log.v("LoaderManager", "  Resetting: " + o00000Oo.f17044O000000o);
                        }
                        o00000Oo.O00000Oo.onLoaderReset(o00000Oo.f17044O000000o);
                    }
                }
                O00000o02.O00000o0.unregisterListener(O00000o02);
                O00000o02.O00000o0.reset();
            }
            this.f17045O000000o.O00000o0();
        }
    }

    fs(fa faVar, fp fpVar) {
        this.O00000Oo = faVar;
        this.O00000o0 = O00000o0.O000000o(fpVar);
    }

    /* JADX INFO: finally extract failed */
    private <D> Loader<D> O000000o(int i, Bundle bundle, fr.O000000o<D> o000000o) {
        try {
            this.O00000o0.O00000Oo = true;
            Loader<D> onCreateLoader = o000000o.onCreateLoader(0, null);
            if (onCreateLoader != null) {
                if (onCreateLoader.getClass().isMemberClass()) {
                    if (!Modifier.isStatic(onCreateLoader.getClass().getModifiers())) {
                        throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: ".concat(String.valueOf(onCreateLoader)));
                    }
                }
                O000000o o000000o2 = new O000000o(0, null, onCreateLoader, null);
                if (f17042O000000o) {
                    Log.v("LoaderManager", "  Created new loader ".concat(String.valueOf(o000000o2)));
                }
                this.O00000o0.f17045O000000o.O00000Oo(0, o000000o2);
                this.O00000o0.O00000Oo = false;
                return o000000o2.O000000o(this.O00000Oo, o000000o);
            }
            throw new IllegalArgumentException("Object returned from onCreateLoader must not be null");
        } catch (Throwable th) {
            this.O00000o0.O00000Oo = false;
            throw th;
        }
    }

    public final <D> Loader<D> O000000o(fr.O000000o<D> o000000o) {
        if (this.O00000o0.O00000Oo) {
            throw new IllegalStateException("Called while creating a loader");
        } else if (Looper.getMainLooper() == Looper.myLooper()) {
            O000000o O000000o2 = this.O00000o0.f17045O000000o.O000000o(0, null);
            if (f17042O000000o) {
                Log.v("LoaderManager", "initLoader in " + this + ": args=" + ((Object) null));
            }
            if (O000000o2 == null) {
                return O000000o(0, null, o000000o);
            }
            if (f17042O000000o) {
                Log.v("LoaderManager", "  Re-using existing loader ".concat(String.valueOf(O000000o2)));
            }
            return O000000o2.O000000o(this.O00000Oo, o000000o);
        } else {
            throw new IllegalStateException("initLoader must be called on the main thread");
        }
    }

    public final void O000000o() {
        O00000o0 o00000o0 = this.O00000o0;
        int O00000Oo2 = o00000o0.f17045O000000o.O00000Oo();
        for (int i = 0; i < O00000Oo2; i++) {
            o00000o0.f17045O000000o.O00000o0(i).O000000o();
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder((int) NotificationCompat.FLAG_HIGH_PRIORITY);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        bb.O000000o(this.O00000Oo, sb);
        sb.append("}}");
        return sb.toString();
    }

    @Deprecated
    public final void O000000o(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        O00000o0 o00000o0 = this.O00000o0;
        if (o00000o0.f17045O000000o.O00000Oo() > 0) {
            printWriter.print(str);
            printWriter.println("Loaders:");
            String str2 = str + "    ";
            for (int i = 0; i < o00000o0.f17045O000000o.O00000Oo(); i++) {
                O000000o O00000o02 = o00000o0.f17045O000000o.O00000o0(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(o00000o0.f17045O000000o.O00000Oo(i));
                printWriter.print(": ");
                printWriter.println(O00000o02.toString());
                printWriter.print(str2);
                printWriter.print("mId=");
                printWriter.print(O00000o02.f17043O000000o);
                printWriter.print(" mArgs=");
                printWriter.println(O00000o02.O00000Oo);
                printWriter.print(str2);
                printWriter.print("mLoader=");
                printWriter.println(O00000o02.O00000o0);
                O00000o02.O00000o0.dump(str2 + "  ", fileDescriptor, printWriter, strArr);
                if (O00000o02.O00000o != null) {
                    printWriter.print(str2);
                    printWriter.print("mCallbacks=");
                    printWriter.println(O00000o02.O00000o);
                    O00000Oo<D> o00000Oo = O00000o02.O00000o;
                    printWriter.print(str2 + "  ");
                    printWriter.print("mDeliveredData=");
                    printWriter.println(o00000Oo.O00000o0);
                }
                printWriter.print(str2);
                printWriter.print("mData=");
                printWriter.println(O00000o02.O00000o0.dataToString(O00000o02.getValue()));
                printWriter.print(str2);
                printWriter.print("mStarted=");
                printWriter.println(O00000o02.hasActiveObservers());
            }
        }
    }
}

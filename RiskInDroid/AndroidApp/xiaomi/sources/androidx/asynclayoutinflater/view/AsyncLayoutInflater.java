package androidx.asynclayoutinflater.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.util.Pools;
import java.util.concurrent.ArrayBlockingQueue;

public final class AsyncLayoutInflater {

    /* renamed from: O000000o  reason: collision with root package name */
    LayoutInflater f2758O000000o;
    Handler O00000Oo;
    private Handler.Callback O00000o = new Handler.Callback() {
        /* class androidx.asynclayoutinflater.view.AsyncLayoutInflater.AnonymousClass1 */

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [int, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public final boolean handleMessage(Message message) {
            O00000Oo o00000Oo = (O00000Oo) message.obj;
            if (o00000Oo.O00000o == null) {
                o00000Oo.O00000o = AsyncLayoutInflater.this.f2758O000000o.inflate(o00000Oo.O00000o0, o00000Oo.O00000Oo, false);
            }
            O00000o0 o00000o0 = AsyncLayoutInflater.this.O00000o0;
            o00000Oo.O00000oO = null;
            o00000Oo.f2761O000000o = null;
            o00000Oo.O00000Oo = null;
            o00000Oo.O00000o0 = 0;
            o00000Oo.O00000o = null;
            o00000o0.f2762O000000o.release(o00000Oo);
            return true;
        }
    };
    O00000o0 O00000o0;

    public interface O00000o {
    }

    public AsyncLayoutInflater(Context context) {
        this.f2758O000000o = new O000000o(context);
        this.O00000Oo = new Handler(this.O00000o);
        this.O00000o0 = O00000o0.O000000o();
    }

    static class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        AsyncLayoutInflater f2761O000000o;
        ViewGroup O00000Oo;
        View O00000o;
        int O00000o0;
        O00000o O00000oO;

        O00000Oo() {
        }
    }

    static class O000000o extends LayoutInflater {

        /* renamed from: O000000o  reason: collision with root package name */
        private static final String[] f2760O000000o = {"android.widget.", "android.webkit.", "android.app."};

        O000000o(Context context) {
            super(context);
        }

        public final LayoutInflater cloneInContext(Context context) {
            return new O000000o(context);
        }

        /* access modifiers changed from: protected */
        public final View onCreateView(String str, AttributeSet attributeSet) throws ClassNotFoundException {
            String[] strArr = f2760O000000o;
            int length = strArr.length;
            int i = 0;
            while (i < length) {
                try {
                    View createView = createView(str, strArr[i], attributeSet);
                    if (createView != null) {
                        return createView;
                    }
                    i++;
                } catch (ClassNotFoundException unused) {
                }
            }
            return super.onCreateView(str, attributeSet);
        }
    }

    static class O00000o0 extends Thread {
        private static final O00000o0 O00000Oo;

        /* renamed from: O000000o  reason: collision with root package name */
        Pools.O00000Oo<O00000Oo> f2762O000000o = new Pools.O00000Oo<>(10);
        private ArrayBlockingQueue<O00000Oo> O00000o0 = new ArrayBlockingQueue<>(10);

        private O00000o0() {
        }

        static {
            O00000o0 o00000o0 = new O00000o0();
            O00000Oo = o00000o0;
            o00000o0.start();
        }

        public static O00000o0 O000000o() {
            return O00000Oo;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [int, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public final void run() {
            while (true) {
                try {
                    O00000Oo take = this.O00000o0.take();
                    try {
                        take.O00000o = take.f2761O000000o.f2758O000000o.inflate(take.O00000o0, take.O00000Oo, false);
                    } catch (RuntimeException e) {
                        Log.w("AsyncLayoutInflater", "Failed to inflate resource in the background! Retrying on the UI thread", e);
                    }
                    Message.obtain(take.f2761O000000o.O00000Oo, 0, take).sendToTarget();
                } catch (InterruptedException e2) {
                    Log.w("AsyncLayoutInflater", e2);
                }
            }
        }
    }
}

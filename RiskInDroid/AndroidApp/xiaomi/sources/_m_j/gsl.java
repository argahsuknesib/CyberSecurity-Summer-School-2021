package _m_j;

import _m_j.gsf;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Response;

public abstract class gsl<R, E extends gsf> {
    private Handler mDispatchHandler;

    public abstract void onFailure(gsf gsf, Exception exc, Response response);

    public void onProgress(long j, long j2) {
    }

    public abstract void onSuccess(R r, Response response);

    public abstract void processFailure(Call call, IOException iOException);

    public abstract void processResponse(Response response);

    public gsl() {
        Looper myLooper = Looper.myLooper();
        if (myLooper == null) {
            gsy.O000000o(6, "AsyncHandler", "Async Callback must have Looper");
            myLooper = Looper.getMainLooper();
        }
        this.mDispatchHandler = new O000000o(this, myLooper);
    }

    public void sendSuccessMessage(R r, Response response) {
        O00000o o00000o = new O00000o((byte) 0);
        o00000o.f18217O000000o = r;
        o00000o.O00000Oo = response;
        Handler handler = this.mDispatchHandler;
        handler.sendMessage(handler.obtainMessage(0, o00000o));
    }

    public void sendProgressMessage(long j, long j2) {
        O00000o0 o00000o0 = new O00000o0((byte) 0);
        o00000o0.f18218O000000o = j;
        o00000o0.O00000Oo = j2;
        Handler handler = this.mDispatchHandler;
        handler.sendMessage(handler.obtainMessage(1, o00000o0));
    }

    public final void sendFailureMessage(E e, Exception exc, Response response) {
        O00000Oo o00000Oo = new O00000Oo((byte) 0);
        o00000Oo.f18216O000000o = e;
        o00000Oo.O00000Oo = exc;
        o00000Oo.O00000o0 = response;
        Handler handler = this.mDispatchHandler;
        handler.sendMessage(handler.obtainMessage(2, o00000Oo));
    }

    static class O00000o<R> {

        /* renamed from: O000000o  reason: collision with root package name */
        R f18217O000000o;
        Response O00000Oo;

        private O00000o() {
        }

        /* synthetic */ O00000o(byte b) {
            this();
        }
    }

    static class O00000o0 {

        /* renamed from: O000000o  reason: collision with root package name */
        long f18218O000000o;
        long O00000Oo;

        private O00000o0() {
        }

        /* synthetic */ O00000o0(byte b) {
            this();
        }
    }

    static class O00000Oo<E extends gsf> {

        /* renamed from: O000000o  reason: collision with root package name */
        E f18216O000000o;
        Exception O00000Oo;
        Response O00000o0;

        private O00000Oo() {
        }

        /* synthetic */ O00000Oo(byte b) {
            this();
        }
    }

    static class O000000o<R, E extends gsf> extends Handler {

        /* renamed from: O000000o  reason: collision with root package name */
        private gsl<R, E> f18215O000000o;

        O000000o(gsl gsl, Looper looper) {
            super(looper);
            this.f18215O000000o = gsl;
        }

        public final void handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                O00000o o00000o = (O00000o) message.obj;
                this.f18215O000000o.onSuccess(o00000o.f18217O000000o, o00000o.O00000Oo);
            } else if (i == 1) {
                O00000o0 o00000o0 = (O00000o0) message.obj;
                this.f18215O000000o.onProgress(o00000o0.f18218O000000o, o00000o0.O00000Oo);
            } else if (i == 2) {
                O00000Oo o00000Oo = (O00000Oo) message.obj;
                this.f18215O000000o.onFailure(o00000Oo.f18216O000000o, o00000Oo.O00000Oo, o00000Oo.O00000o0);
            }
        }
    }
}

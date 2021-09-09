package _m_j;

import android.os.AsyncTask;

public final class chh<Result> {

    /* renamed from: O000000o  reason: collision with root package name */
    private O000000o<Result> f13823O000000o = new O000000o<>((byte) 0);

    private chh(chj<Result> chj) {
        this.f13823O000000o.f13824O000000o = chj;
    }

    public static <Result> chh<Result> O000000o(chj chj) {
        return new chh<>(chj);
    }

    public final void O000000o(chi chi) {
        O000000o<Result> o000000o = this.f13823O000000o;
        o000000o.O00000Oo = chi;
        o000000o.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public final void O000000o() {
        this.f13823O000000o.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    static class O000000o<Result> extends AsyncTask<Void, Void, chg<Result>> {

        /* renamed from: O000000o  reason: collision with root package name */
        chj<Result> f13824O000000o;
        chi<Result> O00000Oo;

        /* synthetic */ O000000o(byte b) {
            this();
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ void onPostExecute(Object obj) {
            chg chg = (chg) obj;
            if (this.O00000Oo == null) {
                return;
            }
            if (chg.O00000o0) {
                this.O00000Oo.onSuccess(chg.f13822O000000o);
            } else {
                this.O00000Oo.onError(chg.O00000Oo);
            }
        }

        private O000000o() {
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            chg chg = new chg();
            this.f13824O000000o.call(chg);
            return chg;
        }
    }
}

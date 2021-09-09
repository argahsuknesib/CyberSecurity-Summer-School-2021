package _m_j;

import android.os.AsyncTask;
import android.util.Pair;
import com.xiaomi.youpin.login.entity.Error;

public final class icd {

    public static class O000000o extends AsyncTask<Object, Object, Pair<Long, Boolean>> {

        /* renamed from: O000000o  reason: collision with root package name */
        private ibh<Long, Error> f1173O000000o;

        /* access modifiers changed from: protected */
        public final /* synthetic */ void onPostExecute(Object obj) {
            Pair pair = (Pair) obj;
            long longValue = ((Long) pair.first).longValue();
            if (((Boolean) pair.second).booleanValue()) {
                this.f1173O000000o.sendSuccessMessage(Long.valueOf(longValue));
            } else {
                this.f1173O000000o.sendFailureMessage(null);
            }
        }

        public O000000o(ibh<Long, Error> ibh) {
            this.f1173O000000o = ibh;
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            return ibm.f1156O000000o.O0000OoO.O00000Oo();
        }
    }
}

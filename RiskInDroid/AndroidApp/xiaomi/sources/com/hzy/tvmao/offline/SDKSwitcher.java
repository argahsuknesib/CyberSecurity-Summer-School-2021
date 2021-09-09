package com.hzy.tvmao.offline;

import android.os.AsyncTask;
import com.hzy.tvmao.interf.IRequestResult;
import com.hzy.tvmao.offline.e;
import com.hzy.tvmao.utils.b;

public class SDKSwitcher {
    private Mode mode = Mode.OnlineOnly;
    private BaseSDK offlineSDK;
    private BaseSDK onlineSDK;

    public enum Mode {
        OnlineFirst,
        OfflineOnly,
        OnlineOnly
    }

    public Mode getMode() {
        return this.mode;
    }

    public SDKSwitcher setMode(Mode mode2) {
        if (mode2 != null) {
            this.mode = mode2;
            return this;
        }
        throw new IllegalArgumentException("mode can not be null.");
    }

    public BaseSDK getOnLineSDK() {
        if (this.onlineSDK == null) {
            this.onlineSDK = new q();
        }
        return this.onlineSDK;
    }

    public static class a<T> extends AsyncTask<Void, Void, T> {

        /* renamed from: a  reason: collision with root package name */
        final e.a<T> f4441a;
        final IRequestResult<T> b;

        public a(e.a<T> aVar, IRequestResult<T> iRequestResult) {
            this.f4441a = aVar;
            this.b = iRequestResult;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public T doInBackground(Void... voidArr) {
            try {
                if (this.f4441a != null) {
                    return this.f4441a.b();
                }
                return null;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(T t) {
            super.onPostExecute(t);
            IRequestResult<T> iRequestResult = this.b;
            if (iRequestResult == null) {
                return;
            }
            if (t != null) {
                iRequestResult.onSuccess("", t);
            } else {
                iRequestResult.onFail(-1, "");
            }
        }
    }

    public BaseSDK getOfflineSDK() {
        if (this.offlineSDK == null) {
            this.offlineSDK = new e(new y(this));
        }
        return this.offlineSDK;
    }

    public BaseSDK getSDK() {
        boolean a2 = b.a();
        int i = z.f4463a[this.mode.ordinal()];
        if (i == 1) {
            return a2 ? getOnLineSDK() : getOfflineSDK();
        }
        if (i == 2) {
            return getOnLineSDK();
        }
        if (i != 3) {
            return null;
        }
        return getOfflineSDK();
    }
}

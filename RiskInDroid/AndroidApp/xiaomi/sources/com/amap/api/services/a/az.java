package com.amap.api.services.a;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.amap.api.services.a.ac;
import com.amap.api.services.busline.BusLineQuery;
import com.amap.api.services.busline.BusLineResult;
import com.amap.api.services.busline.BusLineSearch;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IBusLineSearch;
import java.util.ArrayList;

public class az implements IBusLineSearch {

    /* renamed from: a  reason: collision with root package name */
    private Context f3292a;
    /* access modifiers changed from: private */
    public BusLineSearch.OnBusLineSearchListener b;
    private BusLineQuery c;
    private BusLineQuery d;
    private int e;
    private ArrayList<BusLineResult> f = new ArrayList<>();
    /* access modifiers changed from: private */
    public Handler g = null;

    public az(Context context, BusLineQuery busLineQuery) {
        this.f3292a = context.getApplicationContext();
        this.c = busLineQuery;
        if (busLineQuery != null) {
            this.d = busLineQuery.clone();
        }
        this.g = ac.a();
    }

    public BusLineResult searchBusLine() throws AMapException {
        try {
            aa.a(this.f3292a);
            if (this.d == null || !a()) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            if (!this.c.weakEquals(this.d)) {
                this.d = this.c.clone();
                this.e = 0;
                if (this.f != null) {
                    this.f.clear();
                }
            }
            if (this.e == 0) {
                BusLineResult busLineResult = (BusLineResult) new m(this.f3292a, this.c.clone()).c();
                a(busLineResult);
                return busLineResult;
            }
            BusLineResult b2 = b(this.c.getPageNumber());
            if (b2 != null) {
                return b2;
            }
            BusLineResult busLineResult2 = (BusLineResult) new m(this.f3292a, this.c).c();
            this.f.set(this.c.getPageNumber(), busLineResult2);
            return busLineResult2;
        } catch (AMapException e2) {
            s.a(e2, "BusLineSearch", "searchBusLine");
            throw new AMapException(e2.getErrorMessage());
        }
    }

    private void a(BusLineResult busLineResult) {
        int i;
        this.f = new ArrayList<>();
        int i2 = 0;
        while (true) {
            i = this.e;
            if (i2 >= i) {
                break;
            }
            this.f.add(null);
            i2++;
        }
        if (i >= 0 && a(this.c.getPageNumber())) {
            this.f.set(this.c.getPageNumber(), busLineResult);
        }
    }

    private boolean a(int i) {
        return i < this.e && i >= 0;
    }

    private BusLineResult b(int i) {
        if (a(i)) {
            return this.f.get(i);
        }
        throw new IllegalArgumentException("page out of range");
    }

    public void setOnBusLineSearchListener(BusLineSearch.OnBusLineSearchListener onBusLineSearchListener) {
        this.b = onBusLineSearchListener;
    }

    public void searchBusLineAsyn() {
        try {
            as.a().a(new Runnable() {
                /* class com.amap.api.services.a.az.AnonymousClass1 */

                public void run() {
                    Message obtainMessage = ac.a().obtainMessage();
                    try {
                        obtainMessage.arg1 = 3;
                        obtainMessage.what = 1000;
                        ac.a aVar = new ac.a();
                        obtainMessage.obj = aVar;
                        aVar.b = az.this.b;
                        aVar.f3273a = az.this.searchBusLine();
                    } catch (AMapException e) {
                        obtainMessage.what = e.getErrorCode();
                    } catch (Throwable th) {
                        az.this.g.sendMessage(obtainMessage);
                        throw th;
                    }
                    az.this.g.sendMessage(obtainMessage);
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setQuery(BusLineQuery busLineQuery) {
        if (!this.c.weakEquals(busLineQuery)) {
            this.c = busLineQuery;
            this.d = busLineQuery.clone();
        }
    }

    public BusLineQuery getQuery() {
        return this.c;
    }

    private boolean a() {
        BusLineQuery busLineQuery = this.c;
        if (busLineQuery != null && !s.a(busLineQuery.getQueryString())) {
            return true;
        }
        return false;
    }
}

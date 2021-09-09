package com.amap.api.services.a;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.amap.api.services.a.ac;
import com.amap.api.services.busline.BusStationQuery;
import com.amap.api.services.busline.BusStationResult;
import com.amap.api.services.busline.BusStationSearch;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IBusStationSearch;
import java.util.ArrayList;

public class ba implements IBusStationSearch {

    /* renamed from: a  reason: collision with root package name */
    private Context f3295a;
    /* access modifiers changed from: private */
    public BusStationSearch.OnBusStationSearchListener b;
    private BusStationQuery c;
    private BusStationQuery d;
    private ArrayList<BusStationResult> e = new ArrayList<>();
    private int f;
    /* access modifiers changed from: private */
    public Handler g;

    public ba(Context context, BusStationQuery busStationQuery) {
        this.f3295a = context.getApplicationContext();
        this.c = busStationQuery;
        this.g = ac.a();
    }

    public BusStationResult searchBusStation() throws AMapException {
        try {
            aa.a(this.f3295a);
            if (a()) {
                if (!this.c.weakEquals(this.d)) {
                    this.d = this.c.clone();
                    this.f = 0;
                    if (this.e != null) {
                        this.e.clear();
                    }
                }
                if (this.f == 0) {
                    BusStationResult busStationResult = (BusStationResult) new m(this.f3295a, this.c).c();
                    this.f = busStationResult.getPageCount();
                    a(busStationResult);
                    return busStationResult;
                }
                BusStationResult b2 = b(this.c.getPageNumber());
                if (b2 != null) {
                    return b2;
                }
                BusStationResult busStationResult2 = (BusStationResult) new m(this.f3295a, this.c).c();
                this.e.set(this.c.getPageNumber(), busStationResult2);
                return busStationResult2;
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e2) {
            s.a(e2, "BusStationSearch", "searchBusStation");
            throw new AMapException(e2.getErrorMessage());
        } catch (Throwable th) {
            s.a(th, "BusStationSearch", "searchBusStation");
            return null;
        }
    }

    private void a(BusStationResult busStationResult) {
        int i;
        this.e = new ArrayList<>();
        int i2 = 0;
        while (true) {
            i = this.f;
            if (i2 > i) {
                break;
            }
            this.e.add(null);
            i2++;
        }
        if (i > 0) {
            this.e.set(this.c.getPageNumber(), busStationResult);
        }
    }

    private boolean a(int i) {
        return i <= this.f && i >= 0;
    }

    private BusStationResult b(int i) {
        if (a(i)) {
            return this.e.get(i);
        }
        throw new IllegalArgumentException("page out of range");
    }

    public void setOnBusStationSearchListener(BusStationSearch.OnBusStationSearchListener onBusStationSearchListener) {
        this.b = onBusStationSearchListener;
    }

    public void searchBusStationAsyn() {
        try {
            as.a().a(new Runnable() {
                /* class com.amap.api.services.a.ba.AnonymousClass1 */

                public void run() {
                    Message obtainMessage = ac.a().obtainMessage();
                    try {
                        obtainMessage.arg1 = 7;
                        ac.b bVar = new ac.b();
                        bVar.b = ba.this.b;
                        obtainMessage.obj = bVar;
                        BusStationResult searchBusStation = ba.this.searchBusStation();
                        obtainMessage.what = 1000;
                        bVar.f3274a = searchBusStation;
                    } catch (AMapException e) {
                        obtainMessage.what = e.getErrorCode();
                    } catch (Throwable th) {
                        ba.this.g.sendMessage(obtainMessage);
                        throw th;
                    }
                    ba.this.g.sendMessage(obtainMessage);
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setQuery(BusStationQuery busStationQuery) {
        if (!busStationQuery.weakEquals(this.c)) {
            this.c = busStationQuery;
        }
    }

    public BusStationQuery getQuery() {
        return this.c;
    }

    private boolean a() {
        BusStationQuery busStationQuery = this.c;
        if (busStationQuery != null && !s.a(busStationQuery.getQueryString())) {
            return true;
        }
        return false;
    }
}

package com.amap.api.services.a;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.services.a.ac;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IRoutePOISearch;
import com.amap.api.services.routepoisearch.RoutePOISearch;
import com.amap.api.services.routepoisearch.RoutePOISearchQuery;
import com.amap.api.services.routepoisearch.RoutePOISearchResult;

public class bi implements IRoutePOISearch {

    /* renamed from: a  reason: collision with root package name */
    private RoutePOISearchQuery f3317a;
    private Context b;
    /* access modifiers changed from: private */
    public RoutePOISearch.OnRoutePOISearchListener c;
    /* access modifiers changed from: private */
    public Handler d = null;

    public bi(Context context, RoutePOISearchQuery routePOISearchQuery) {
        this.b = context;
        this.f3317a = routePOISearchQuery;
        this.d = ac.a();
    }

    public void setRoutePOISearchListener(RoutePOISearch.OnRoutePOISearchListener onRoutePOISearchListener) {
        this.c = onRoutePOISearchListener;
    }

    public void searchRoutePOIAsyn() {
        as.a().a(new Runnable() {
            /* class com.amap.api.services.a.bi.AnonymousClass1 */

            public void run() {
                ac.j jVar;
                Message obtainMessage = bi.this.d.obtainMessage();
                obtainMessage.arg1 = 14;
                Bundle bundle = new Bundle();
                RoutePOISearchResult routePOISearchResult = null;
                try {
                    routePOISearchResult = bi.this.searchRoutePOI();
                    bundle.putInt("errorCode", 1000);
                    jVar = new ac.j();
                } catch (AMapException e) {
                    bundle.putInt("errorCode", e.getErrorCode());
                    jVar = new ac.j();
                } catch (Throwable th) {
                    ac.j jVar2 = new ac.j();
                    jVar2.b = bi.this.c;
                    jVar2.f3282a = routePOISearchResult;
                    obtainMessage.obj = jVar2;
                    obtainMessage.setData(bundle);
                    bi.this.d.sendMessage(obtainMessage);
                    throw th;
                }
                jVar.b = bi.this.c;
                jVar.f3282a = routePOISearchResult;
                obtainMessage.obj = jVar;
                obtainMessage.setData(bundle);
                bi.this.d.sendMessage(obtainMessage);
            }
        });
    }

    public void setQuery(RoutePOISearchQuery routePOISearchQuery) {
        this.f3317a = routePOISearchQuery;
    }

    public RoutePOISearchQuery getQuery() {
        return this.f3317a;
    }

    public RoutePOISearchResult searchRoutePOI() throws AMapException {
        try {
            aa.a(this.b);
            if (a()) {
                return (RoutePOISearchResult) new ap(this.b, this.f3317a.clone()).c();
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e) {
            s.a(e, "RoutePOISearchCore", "searchRoutePOI");
            throw e;
        }
    }

    private boolean a() {
        RoutePOISearchQuery routePOISearchQuery = this.f3317a;
        if (routePOISearchQuery == null || routePOISearchQuery.getSearchType() == null) {
            return false;
        }
        if (this.f3317a.getFrom() == null && this.f3317a.getTo() == null && this.f3317a.getPolylines() == null) {
            return false;
        }
        return true;
    }
}

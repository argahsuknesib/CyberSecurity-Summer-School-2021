package com.amap.api.services.a;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.services.a.ac;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.interfaces.IPoiSearch;
import com.amap.api.services.poisearch.PoiResult;
import com.amap.api.services.poisearch.PoiSearch;
import java.util.HashMap;
import java.util.List;

public class bh implements IPoiSearch {
    private static HashMap<Integer, PoiResult> i;

    /* renamed from: a  reason: collision with root package name */
    private PoiSearch.SearchBound f3314a;
    private PoiSearch.Query b;
    private Context c;
    /* access modifiers changed from: private */
    public PoiSearch.OnPoiSearchListener d;
    private String e = "zh-CN";
    private PoiSearch.Query f;
    private PoiSearch.SearchBound g;
    private int h;
    /* access modifiers changed from: private */
    public Handler j = null;

    public bh(Context context, PoiSearch.Query query) {
        this.c = context.getApplicationContext();
        setQuery(query);
        this.j = ac.a();
    }

    public void setOnPoiSearchListener(PoiSearch.OnPoiSearchListener onPoiSearchListener) {
        this.d = onPoiSearchListener;
    }

    public void setLanguage(String str) {
        if ("en".equals(str)) {
            this.e = "en";
        } else {
            this.e = "zh-CN";
        }
    }

    public String getLanguage() {
        return this.e;
    }

    private boolean a() {
        PoiSearch.Query query = this.b;
        if (query == null) {
            return false;
        }
        if (!s.a(query.getQueryString()) || !s.a(this.b.getCategory())) {
            return true;
        }
        return false;
    }

    private boolean b() {
        PoiSearch.SearchBound bound = getBound();
        if (bound != null && bound.getShape().equals("Bound")) {
            return true;
        }
        return false;
    }

    private boolean c() {
        PoiSearch.SearchBound bound = getBound();
        if (bound == null) {
            return true;
        }
        if (bound.getShape().equals("Bound")) {
            if (bound.getCenter() == null) {
                return false;
            }
            return true;
        } else if (bound.getShape().equals("Polygon")) {
            List<LatLonPoint> polyGonList = bound.getPolyGonList();
            if (polyGonList == null || polyGonList.size() == 0) {
                return false;
            }
            for (int i2 = 0; i2 < polyGonList.size(); i2++) {
                if (polyGonList.get(i2) == null) {
                    return false;
                }
            }
            return true;
        } else if (!bound.getShape().equals("Rectangle")) {
            return true;
        } else {
            LatLonPoint lowerLeft = bound.getLowerLeft();
            LatLonPoint upperRight = bound.getUpperRight();
            if (lowerLeft == null || upperRight == null || lowerLeft.getLatitude() >= upperRight.getLatitude() || lowerLeft.getLongitude() >= upperRight.getLongitude()) {
                return false;
            }
            return true;
        }
    }

    public PoiResult searchPOI() throws AMapException {
        try {
            aa.a(this.c);
            if (!b()) {
                if (!a()) {
                    throw new AMapException("无效的参数 - IllegalArgumentException");
                }
            }
            if (!c()) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            } else if (this.b != null) {
                if ((!this.b.queryEquals(this.f) && this.f3314a == null) || (!this.b.queryEquals(this.f) && !this.f3314a.equals(this.g))) {
                    this.h = 0;
                    this.f = this.b.clone();
                    if (this.f3314a != null) {
                        this.g = this.f3314a.clone();
                    }
                    if (i != null) {
                        i.clear();
                    }
                }
                PoiSearch.SearchBound searchBound = null;
                if (this.f3314a != null) {
                    searchBound = this.f3314a.clone();
                }
                if (this.h == 0) {
                    PoiResult poiResult = (PoiResult) new ai(this.c, new al(this.b.clone(), searchBound)).c();
                    a(poiResult);
                    return poiResult;
                }
                PoiResult a2 = a(this.b.getPageNum());
                if (a2 != null) {
                    return a2;
                }
                PoiResult poiResult2 = (PoiResult) new ai(this.c, new al(this.b.clone(), searchBound)).c();
                i.put(Integer.valueOf(this.b.getPageNum()), poiResult2);
                return poiResult2;
            } else {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
        } catch (AMapException e2) {
            s.a(e2, "PoiSearch", "searchPOI");
            throw new AMapException(e2.getErrorMessage());
        }
    }

    public void searchPOIAsyn() {
        try {
            as.a().a(new Runnable() {
                /* class com.amap.api.services.a.bh.AnonymousClass1 */

                public void run() {
                    ac.h hVar;
                    Message obtainMessage = bh.this.j.obtainMessage();
                    obtainMessage.arg1 = 6;
                    obtainMessage.what = 600;
                    Bundle bundle = new Bundle();
                    PoiResult poiResult = null;
                    try {
                        poiResult = bh.this.searchPOI();
                        bundle.putInt("errorCode", 1000);
                        hVar = new ac.h();
                    } catch (AMapException e) {
                        bundle.putInt("errorCode", e.getErrorCode());
                        hVar = new ac.h();
                    } catch (Throwable th) {
                        ac.h hVar2 = new ac.h();
                        hVar2.b = bh.this.d;
                        hVar2.f3280a = poiResult;
                        obtainMessage.obj = hVar2;
                        obtainMessage.setData(bundle);
                        bh.this.j.sendMessage(obtainMessage);
                        throw th;
                    }
                    hVar.b = bh.this.d;
                    hVar.f3280a = poiResult;
                    obtainMessage.obj = hVar;
                    obtainMessage.setData(bundle);
                    bh.this.j.sendMessage(obtainMessage);
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public PoiItem searchPOIId(String str) throws AMapException {
        aa.a(this.c);
        return (PoiItem) new ah(this.c, str).c();
    }

    public void searchPOIIdAsyn(final String str) {
        as.a().a(new Runnable() {
            /* class com.amap.api.services.a.bh.AnonymousClass2 */

            public void run() {
                ac.g gVar;
                Message obtainMessage = ac.a().obtainMessage();
                obtainMessage.arg1 = 6;
                obtainMessage.what = 602;
                Bundle bundle = new Bundle();
                PoiItem poiItem = null;
                try {
                    poiItem = bh.this.searchPOIId(str);
                    bundle.putInt("errorCode", 1000);
                    gVar = new ac.g();
                } catch (AMapException e) {
                    s.a(e, "PoiSearch", "searchPOIIdAsyn");
                    bundle.putInt("errorCode", e.getErrorCode());
                    gVar = new ac.g();
                } catch (Throwable th) {
                    ac.g gVar2 = new ac.g();
                    gVar2.b = bh.this.d;
                    gVar2.f3279a = poiItem;
                    obtainMessage.obj = gVar2;
                    obtainMessage.setData(bundle);
                    bh.this.j.sendMessage(obtainMessage);
                    throw th;
                }
                gVar.b = bh.this.d;
                gVar.f3279a = poiItem;
                obtainMessage.obj = gVar;
                obtainMessage.setData(bundle);
                bh.this.j.sendMessage(obtainMessage);
            }
        });
    }

    public void setQuery(PoiSearch.Query query) {
        this.b = query;
    }

    public void setBound(PoiSearch.SearchBound searchBound) {
        this.f3314a = searchBound;
    }

    public PoiSearch.Query getQuery() {
        return this.b;
    }

    public PoiSearch.SearchBound getBound() {
        return this.f3314a;
    }

    private void a(PoiResult poiResult) {
        int i2;
        i = new HashMap<>();
        PoiSearch.Query query = this.b;
        if (query != null && poiResult != null && (i2 = this.h) > 0 && i2 > query.getPageNum()) {
            i.put(Integer.valueOf(this.b.getPageNum()), poiResult);
        }
    }

    /* access modifiers changed from: protected */
    public PoiResult a(int i2) {
        if (b(i2)) {
            return i.get(Integer.valueOf(i2));
        }
        throw new IllegalArgumentException("page out of range");
    }

    private boolean b(int i2) {
        return i2 <= this.h && i2 >= 0;
    }
}

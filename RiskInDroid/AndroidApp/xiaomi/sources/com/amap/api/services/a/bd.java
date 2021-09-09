package com.amap.api.services.a;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.district.DistrictResult;
import com.amap.api.services.district.DistrictSearch;
import com.amap.api.services.district.DistrictSearchQuery;
import com.amap.api.services.interfaces.IDistrictSearch;
import java.util.HashMap;

public class bd implements IDistrictSearch {
    private static HashMap<Integer, DistrictResult> f;

    /* renamed from: a  reason: collision with root package name */
    private Context f3302a;
    /* access modifiers changed from: private */
    public DistrictSearchQuery b;
    /* access modifiers changed from: private */
    public DistrictSearch.OnDistrictSearchListener c;
    private DistrictSearchQuery d;
    private int e;
    /* access modifiers changed from: private */
    public Handler g = ac.a();

    public bd(Context context) {
        this.f3302a = context.getApplicationContext();
    }

    private void a(DistrictResult districtResult) {
        int i;
        f = new HashMap<>();
        DistrictSearchQuery districtSearchQuery = this.b;
        if (districtSearchQuery != null && districtResult != null && (i = this.e) > 0 && i > districtSearchQuery.getPageNum()) {
            f.put(Integer.valueOf(this.b.getPageNum()), districtResult);
        }
    }

    public DistrictSearchQuery getQuery() {
        return this.b;
    }

    public void setQuery(DistrictSearchQuery districtSearchQuery) {
        this.b = districtSearchQuery;
    }

    private boolean a() {
        return this.b != null;
    }

    /* access modifiers changed from: protected */
    public DistrictResult a(int i) throws AMapException {
        if (b(i)) {
            return f.get(Integer.valueOf(i));
        }
        throw new AMapException("无效的参数 - IllegalArgumentException");
    }

    private boolean b(int i) {
        return i < this.e && i >= 0;
    }

    public DistrictResult searchDistrict() throws AMapException {
        DistrictResult districtResult;
        try {
            DistrictResult districtResult2 = new DistrictResult();
            aa.a(this.f3302a);
            if (!a()) {
                this.b = new DistrictSearchQuery();
            }
            districtResult2.setQuery(this.b.clone());
            if (!this.b.weakEquals(this.d)) {
                this.e = 0;
                this.d = this.b.clone();
                if (f != null) {
                    f.clear();
                }
            }
            if (this.e == 0) {
                districtResult = (DistrictResult) new u(this.f3302a, this.b.clone()).c();
                if (districtResult == null) {
                    return districtResult;
                }
                this.e = districtResult.getPageCount();
                a(districtResult);
            } else {
                districtResult = a(this.b.getPageNum());
                if (districtResult == null) {
                    districtResult = (DistrictResult) new u(this.f3302a, this.b.clone()).c();
                    if (this.b != null) {
                        if (districtResult != null) {
                            if (this.e > 0 && this.e > this.b.getPageNum()) {
                                f.put(Integer.valueOf(this.b.getPageNum()), districtResult);
                            }
                        }
                    }
                }
            }
            return districtResult;
        } catch (AMapException e2) {
            s.a(e2, "DistrictSearch", "searchDistrict");
            throw e2;
        }
    }

    public void searchDistrictAsyn() {
        try {
            as.a().a(new Runnable() {
                /* class com.amap.api.services.a.bd.AnonymousClass1 */

                public void run() {
                    Message obtainMessage = ac.a().obtainMessage();
                    DistrictResult districtResult = new DistrictResult();
                    districtResult.setQuery(bd.this.b);
                    try {
                        DistrictResult searchDistrict = bd.this.searchDistrict();
                        if (searchDistrict != null) {
                            searchDistrict.setAMapException(new AMapException());
                        }
                        obtainMessage.arg1 = 4;
                        obtainMessage.obj = bd.this.c;
                        Bundle bundle = new Bundle();
                        bundle.putParcelable("result", searchDistrict);
                        obtainMessage.setData(bundle);
                        if (bd.this.g != null) {
                            bd.this.g.sendMessage(obtainMessage);
                        }
                    } catch (AMapException e) {
                        districtResult.setAMapException(e);
                        obtainMessage.arg1 = 4;
                        obtainMessage.obj = bd.this.c;
                        Bundle bundle2 = new Bundle();
                        bundle2.putParcelable("result", districtResult);
                        obtainMessage.setData(bundle2);
                        if (bd.this.g != null) {
                            bd.this.g.sendMessage(obtainMessage);
                        }
                    } catch (Throwable th) {
                        obtainMessage.arg1 = 4;
                        obtainMessage.obj = bd.this.c;
                        Bundle bundle3 = new Bundle();
                        bundle3.putParcelable("result", districtResult);
                        obtainMessage.setData(bundle3);
                        if (bd.this.g != null) {
                            bd.this.g.sendMessage(obtainMessage);
                        }
                        throw th;
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void searchDistrictAnsy() {
        searchDistrictAsyn();
    }

    public void setOnDistrictSearchListener(DistrictSearch.OnDistrictSearchListener onDistrictSearchListener) {
        this.c = onDistrictSearchListener;
    }
}

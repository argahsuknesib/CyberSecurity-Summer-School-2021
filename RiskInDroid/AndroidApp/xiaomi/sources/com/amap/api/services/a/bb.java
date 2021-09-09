package com.amap.api.services.a;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.amap.api.services.a.ac;
import com.amap.api.services.cloud.CloudItemDetail;
import com.amap.api.services.cloud.CloudResult;
import com.amap.api.services.cloud.CloudSearch;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.interfaces.ICloudSearch;
import java.util.HashMap;
import java.util.List;

public class bb implements ICloudSearch {

    /* renamed from: a  reason: collision with root package name */
    private Context f3297a;
    /* access modifiers changed from: private */
    public CloudSearch.OnCloudSearchListener b;
    private CloudSearch.Query c;
    private int d;
    private HashMap<Integer, CloudResult> e;
    /* access modifiers changed from: private */
    public Handler f = ac.a();

    public bb(Context context) {
        this.f3297a = context.getApplicationContext();
    }

    public void setOnCloudSearchListener(CloudSearch.OnCloudSearchListener onCloudSearchListener) {
        this.b = onCloudSearchListener;
    }

    /* access modifiers changed from: private */
    public CloudResult a(CloudSearch.Query query) throws AMapException {
        try {
            if (b(query)) {
                if (!query.queryEquals(this.c)) {
                    this.d = 0;
                    this.c = query.clone();
                    if (this.e != null) {
                        this.e.clear();
                    }
                }
                if (this.d == 0) {
                    CloudResult cloudResult = (CloudResult) new q(this.f3297a, query).c();
                    try {
                        a(cloudResult, query);
                        return cloudResult;
                    } catch (Throwable th) {
                        th = th;
                    }
                } else {
                    CloudResult a2 = a(query.getPageNum());
                    if (a2 != null) {
                        return a2;
                    }
                    CloudResult cloudResult2 = (CloudResult) new q(this.f3297a, query).c();
                    this.e.put(Integer.valueOf(query.getPageNum()), cloudResult2);
                    return cloudResult2;
                }
            } else {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
        } catch (Throwable th2) {
            th = th2;
            s.a(th, "CloudSearch", "searchCloud");
            if (!(th instanceof AMapException)) {
                th.printStackTrace();
                return null;
            }
            throw ((AMapException) th);
        }
    }

    public void searchCloudAsyn(final CloudSearch.Query query) {
        try {
            as.a().a(new Runnable() {
                /* class com.amap.api.services.a.bb.AnonymousClass1 */

                public void run() {
                    Message obtainMessage = ac.a().obtainMessage();
                    try {
                        obtainMessage.arg1 = 12;
                        obtainMessage.what = 700;
                        ac.d dVar = new ac.d();
                        dVar.b = bb.this.b;
                        obtainMessage.obj = dVar;
                        dVar.f3276a = bb.this.a(query);
                        obtainMessage.arg2 = 1000;
                    } catch (AMapException e) {
                        obtainMessage.arg2 = e.getErrorCode();
                    } catch (Throwable th) {
                        bb.this.f.sendMessage(obtainMessage);
                        throw th;
                    }
                    bb.this.f.sendMessage(obtainMessage);
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public CloudItemDetail a(String str, String str2) throws AMapException {
        if (str == null || str.trim().equals("")) {
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } else if (str2 == null || str2.trim().equals("")) {
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } else {
            try {
                return (CloudItemDetail) new p(this.f3297a, new ak(str, str2)).c();
            } catch (Throwable th) {
                s.a(th, "CloudSearch", "searchCloudDetail");
                if (!(th instanceof AMapException)) {
                    th.printStackTrace();
                    return null;
                }
                throw ((AMapException) th);
            }
        }
    }

    public void searchCloudDetailAsyn(final String str, final String str2) {
        try {
            as.a().a(new Runnable() {
                /* class com.amap.api.services.a.bb.AnonymousClass2 */

                public void run() {
                    Message obtainMessage = ac.a().obtainMessage();
                    try {
                        obtainMessage.arg1 = 12;
                        obtainMessage.what = 701;
                        ac.c cVar = new ac.c();
                        cVar.b = bb.this.b;
                        obtainMessage.obj = cVar;
                        cVar.f3275a = bb.this.a(str, str2);
                        obtainMessage.arg2 = 1000;
                    } catch (AMapException e) {
                        obtainMessage.arg2 = e.getErrorCode();
                    } catch (Throwable th) {
                        bb.this.f.sendMessage(obtainMessage);
                        throw th;
                    }
                    bb.this.f.sendMessage(obtainMessage);
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a(CloudResult cloudResult, CloudSearch.Query query) {
        this.e = new HashMap<>();
        if (this.d > 0) {
            this.e.put(Integer.valueOf(query.getPageNum()), cloudResult);
        }
    }

    /* access modifiers changed from: protected */
    public CloudResult a(int i) {
        if (b(i)) {
            return this.e.get(Integer.valueOf(i));
        }
        throw new IllegalArgumentException("page out of range");
    }

    private boolean b(int i) {
        return i <= this.d && i > 0;
    }

    private boolean b(CloudSearch.Query query) {
        if (query == null || s.a(query.getTableID()) || query.getBound() == null) {
            return false;
        }
        if (query.getBound() != null && query.getBound().getShape().equals("Bound") && query.getBound().getCenter() == null) {
            return false;
        }
        if (query.getBound() != null && query.getBound().getShape().equals("Rectangle")) {
            LatLonPoint lowerLeft = query.getBound().getLowerLeft();
            LatLonPoint upperRight = query.getBound().getUpperRight();
            if (lowerLeft == null || upperRight == null || lowerLeft.getLatitude() >= upperRight.getLatitude() || lowerLeft.getLongitude() >= upperRight.getLongitude()) {
                return false;
            }
        }
        if (query.getBound() == null || !query.getBound().getShape().equals("Polygon")) {
            return true;
        }
        List<LatLonPoint> polyGonList = query.getBound().getPolyGonList();
        for (int i = 0; i < polyGonList.size(); i++) {
            if (polyGonList.get(i) == null) {
                return false;
            }
        }
        return true;
    }
}

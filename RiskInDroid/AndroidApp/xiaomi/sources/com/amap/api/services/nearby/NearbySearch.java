package com.amap.api.services.nearby;

import android.content.Context;
import com.amap.api.services.a.bg;
import com.amap.api.services.a.s;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.interfaces.INearbySearch;
import com.google.android.exoplayer2.C;

public class NearbySearch {

    /* renamed from: a  reason: collision with root package name */
    private static NearbySearch f3467a;
    private INearbySearch b;

    public interface NearbyListener {
        void onNearbyInfoSearched(NearbySearchResult nearbySearchResult, int i);

        void onNearbyInfoUploaded(int i);

        void onUserInfoCleared(int i);
    }

    public static synchronized NearbySearch getInstance(Context context) {
        NearbySearch nearbySearch;
        synchronized (NearbySearch.class) {
            if (f3467a == null) {
                f3467a = new NearbySearch(context);
            }
            nearbySearch = f3467a;
        }
        return nearbySearch;
    }

    private NearbySearch(Context context) {
        if (this.b == null) {
            try {
                this.b = new bg(context);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void addNearbyListener(NearbyListener nearbyListener) {
        if (this.b != null) {
            this.b.addNearbyListener(nearbyListener);
        }
    }

    public synchronized void removeNearbyListener(NearbyListener nearbyListener) {
        if (this.b != null) {
            this.b.removeNearbyListener(nearbyListener);
        }
    }

    public void clearUserInfoAsyn() {
        INearbySearch iNearbySearch = this.b;
        if (iNearbySearch != null) {
            iNearbySearch.clearUserInfoAsyn();
        }
    }

    public void setUserID(String str) {
        INearbySearch iNearbySearch = this.b;
        if (iNearbySearch != null) {
            iNearbySearch.setUserID(str);
        }
    }

    public synchronized void startUploadNearbyInfoAuto(UploadInfoCallback uploadInfoCallback, int i) {
        if (this.b != null) {
            this.b.startUploadNearbyInfoAuto(uploadInfoCallback, i);
        }
    }

    public synchronized void stopUploadNearbyInfoAuto() {
        if (this.b != null) {
            this.b.stopUploadNearbyInfoAuto();
        }
    }

    public void uploadNearbyInfoAsyn(UploadInfo uploadInfo) {
        INearbySearch iNearbySearch = this.b;
        if (iNearbySearch != null) {
            iNearbySearch.uploadNearbyInfoAsyn(uploadInfo);
        }
    }

    public void searchNearbyInfoAsyn(NearbyQuery nearbyQuery) {
        INearbySearch iNearbySearch = this.b;
        if (iNearbySearch != null) {
            iNearbySearch.searchNearbyInfoAsyn(nearbyQuery);
        }
    }

    public NearbySearchResult searchNearbyInfo(NearbyQuery nearbyQuery) throws AMapException {
        INearbySearch iNearbySearch = this.b;
        if (iNearbySearch != null) {
            return iNearbySearch.searchNearbyInfo(nearbyQuery);
        }
        return null;
    }

    public static class NearbyQuery {

        /* renamed from: a  reason: collision with root package name */
        private LatLonPoint f3469a;
        private NearbySearchFunctionType b = NearbySearchFunctionType.DISTANCE_SEARCH;
        private int c = 1000;
        private int d = 1800;
        private int e = 1;

        public void setCenterPoint(LatLonPoint latLonPoint) {
            this.f3469a = latLonPoint;
        }

        public LatLonPoint getCenterPoint() {
            return this.f3469a;
        }

        public int getRadius() {
            return this.c;
        }

        public void setRadius(int i) {
            if (i > 10000) {
                i = C.MSG_CUSTOM_BASE;
            }
            this.c = i;
        }

        public void setType(NearbySearchFunctionType nearbySearchFunctionType) {
            this.b = nearbySearchFunctionType;
        }

        public int getType() {
            int i = AnonymousClass1.f3468a[this.b.ordinal()];
            return (i == 1 || i != 2) ? 0 : 1;
        }

        public void setCoordType(int i) {
            if (i == 0 || i == 1) {
                this.e = i;
            } else {
                this.e = 1;
            }
        }

        public int getCoordType() {
            return this.e;
        }

        public void setTimeRange(int i) {
            if (i < 5) {
                i = 5;
            } else if (i > 86400) {
                i = 86400;
            }
            this.d = i;
        }

        public int getTimeRange() {
            return this.d;
        }
    }

    /* renamed from: com.amap.api.services.nearby.NearbySearch$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3468a = new int[NearbySearchFunctionType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            f3468a[NearbySearchFunctionType.DISTANCE_SEARCH.ordinal()] = 1;
            f3468a[NearbySearchFunctionType.DRIVING_DISTANCE_SEARCH.ordinal()] = 2;
        }
    }

    public static synchronized void destroy() {
        synchronized (NearbySearch.class) {
            if (f3467a != null) {
                try {
                    f3467a.a();
                } catch (Throwable th) {
                    s.a(th, "NearbySearch", "destryoy");
                }
            }
            f3467a = null;
        }
    }

    private void a() {
        INearbySearch iNearbySearch = this.b;
        if (iNearbySearch != null) {
            iNearbySearch.destroy();
        }
        this.b = null;
    }
}

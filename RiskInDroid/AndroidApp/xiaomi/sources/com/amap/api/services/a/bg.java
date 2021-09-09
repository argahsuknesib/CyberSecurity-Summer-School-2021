package com.amap.api.services.a;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import com.amap.api.services.a.ac;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.interfaces.INearbySearch;
import com.amap.api.services.nearby.NearbySearch;
import com.amap.api.services.nearby.NearbySearchResult;
import com.amap.api.services.nearby.UploadInfo;
import com.amap.api.services.nearby.UploadInfoCallback;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;

public class bg implements INearbySearch {
    private static long e;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public List<NearbySearch.NearbyListener> f3309a = new ArrayList();
    private String b;
    private Context c;
    /* access modifiers changed from: private */
    public ac d;
    private ExecutorService f;
    private LatLonPoint g = null;
    private String h = null;
    private boolean i = false;
    private Timer j = new Timer();
    /* access modifiers changed from: private */
    public UploadInfoCallback k;
    private TimerTask l;

    public bg(Context context) {
        this.c = context.getApplicationContext();
        this.d = ac.a();
    }

    public synchronized void addNearbyListener(NearbySearch.NearbyListener nearbyListener) {
        try {
            this.f3309a.add(nearbyListener);
        } catch (Throwable th) {
            s.a(th, "NearbySearch", "addNearbyListener");
        }
    }

    public synchronized void removeNearbyListener(NearbySearch.NearbyListener nearbyListener) {
        if (nearbyListener != null) {
            try {
                this.f3309a.remove(nearbyListener);
            } catch (Throwable th) {
                s.a(th, "NearbySearch", "removeNearbyListener");
            }
        }
    }

    public void clearUserInfoAsyn() {
        try {
            as.a().a(new Runnable() {
                /* class com.amap.api.services.a.bg.AnonymousClass1 */

                public void run() {
                    Message obtainMessage = bg.this.d.obtainMessage();
                    obtainMessage.arg1 = 8;
                    obtainMessage.obj = bg.this.f3309a;
                    try {
                        int unused = bg.this.a();
                        obtainMessage.what = 1000;
                        if (bg.this.d == null) {
                            return;
                        }
                    } catch (AMapException e) {
                        obtainMessage.what = e.getErrorCode();
                        s.a(e, "NearbySearch", "clearUserInfoAsyn");
                        if (bg.this.d == null) {
                            return;
                        }
                    } catch (Throwable th) {
                        if (bg.this.d != null) {
                            bg.this.d.sendMessage(obtainMessage);
                        }
                        throw th;
                    }
                    bg.this.d.sendMessage(obtainMessage);
                }
            });
        } catch (Throwable th) {
            s.a(th, "NearbySearch", "clearUserInfoAsynThrowable");
        }
    }

    /* access modifiers changed from: private */
    public int a() throws AMapException {
        try {
            if (this.i) {
                throw new AMapException("已开启自动上传");
            } else if (a(this.b)) {
                aa.a(this.c);
                return ((Integer) new ad(this.c, this.b).c()).intValue();
            } else {
                throw new AMapException("USERID非法");
            }
        } catch (AMapException e2) {
            throw e2;
        } catch (Throwable unused) {
            throw new AMapException("未知错误");
        }
    }

    public void setUserID(String str) {
        this.b = str;
    }

    public synchronized void startUploadNearbyInfoAuto(UploadInfoCallback uploadInfoCallback, int i2) {
        if (i2 < 7000) {
            i2 = 7000;
        }
        try {
            this.k = uploadInfoCallback;
            if (this.i && this.l != null) {
                this.l.cancel();
            }
            this.i = true;
            this.l = new a();
            this.j.schedule(this.l, 0, (long) i2);
        } catch (Throwable th) {
            s.a(th, "NearbySearch", "startUploadNearbyInfoAuto");
        }
    }

    public synchronized void stopUploadNearbyInfoAuto() {
        try {
            if (this.l != null) {
                this.l.cancel();
            }
        } catch (Throwable th) {
            s.a(th, "NearbySearch", "stopUploadNearbyInfoAuto");
        }
        this.i = false;
        this.l = null;
    }

    /* access modifiers changed from: private */
    public int a(UploadInfo uploadInfo) {
        if (this.i) {
            return 2200;
        }
        return b(uploadInfo);
    }

    private boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.compile("^[a-z0-9A-Z_-]{1,32}$").matcher(str).find();
    }

    /* access modifiers changed from: private */
    public int b(UploadInfo uploadInfo) {
        try {
            aa.a(this.c);
            if (uploadInfo == null) {
                return 2202;
            }
            long time = new Date().getTime();
            if (time - e < 6500) {
                return 2203;
            }
            e = time;
            String userID = uploadInfo.getUserID();
            if (!a(userID)) {
                return 2201;
            }
            if (TextUtils.isEmpty(this.h)) {
                this.h = userID;
            }
            if (!userID.equals(this.h)) {
                return 2201;
            }
            LatLonPoint point = uploadInfo.getPoint();
            if (point == null) {
                return 2204;
            }
            if (point.equals(this.g)) {
                return 2204;
            }
            new af(this.c, uploadInfo).c();
            this.g = point.copy();
            return 1000;
        } catch (AMapException e2) {
            return e2.getErrorCode();
        } catch (Throwable unused) {
            return 1900;
        }
    }

    public void uploadNearbyInfoAsyn(final UploadInfo uploadInfo) {
        if (this.f == null) {
            this.f = Executors.newSingleThreadExecutor();
        }
        this.f.submit(new Runnable() {
            /* class com.amap.api.services.a.bg.AnonymousClass2 */

            public void run() {
                try {
                    Message obtainMessage = bg.this.d.obtainMessage();
                    obtainMessage.arg1 = 10;
                    obtainMessage.obj = bg.this.f3309a;
                    obtainMessage.what = bg.this.a(uploadInfo);
                    bg.this.d.sendMessage(obtainMessage);
                } catch (Throwable th) {
                    s.a(th, "NearbySearch", "uploadNearbyInfoAsyn");
                }
            }
        });
    }

    public void searchNearbyInfoAsyn(final NearbySearch.NearbyQuery nearbyQuery) {
        try {
            as.a().a(new Runnable() {
                /* class com.amap.api.services.a.bg.AnonymousClass3 */

                public void run() {
                    Message obtainMessage = bg.this.d.obtainMessage();
                    obtainMessage.arg1 = 9;
                    ac.f fVar = new ac.f();
                    fVar.f3278a = bg.this.f3309a;
                    obtainMessage.obj = fVar;
                    try {
                        fVar.b = bg.this.searchNearbyInfo(nearbyQuery);
                        obtainMessage.what = 1000;
                        if (bg.this.d == null) {
                            return;
                        }
                    } catch (AMapException e) {
                        obtainMessage.what = e.getErrorCode();
                        s.a(e, "NearbySearch", "searchNearbyInfoAsyn");
                        if (bg.this.d == null) {
                            return;
                        }
                    } catch (Throwable th) {
                        if (bg.this.d != null) {
                            bg.this.d.sendMessage(obtainMessage);
                        }
                        throw th;
                    }
                    bg.this.d.sendMessage(obtainMessage);
                }
            });
        } catch (Throwable th) {
            s.a(th, "NearbySearch", "searchNearbyInfoAsynThrowable");
        }
    }

    public NearbySearchResult searchNearbyInfo(NearbySearch.NearbyQuery nearbyQuery) throws AMapException {
        try {
            aa.a(this.c);
            if (a(nearbyQuery)) {
                return (NearbySearchResult) new ae(this.c, nearbyQuery).c();
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e2) {
            throw e2;
        } catch (Throwable th) {
            s.a(th, "NearbySearch", "searchNearbyInfo");
            throw new AMapException("未知错误");
        }
    }

    private boolean a(NearbySearch.NearbyQuery nearbyQuery) {
        return (nearbyQuery == null || nearbyQuery.getCenterPoint() == null) ? false : true;
    }

    public synchronized void destroy() {
        try {
            this.j.cancel();
        } catch (Throwable th) {
            s.a(th, "NearbySearch", "destryoy");
        }
    }

    class a extends TimerTask {
        private a() {
        }

        public void run() {
            try {
                if (bg.this.k != null) {
                    int b = bg.this.b(bg.this.k.OnUploadInfoCallback());
                    Message obtainMessage = bg.this.d.obtainMessage();
                    obtainMessage.arg1 = 10;
                    obtainMessage.obj = bg.this.f3309a;
                    obtainMessage.what = b;
                    bg.this.d.sendMessage(obtainMessage);
                }
            } catch (Throwable th) {
                s.a(th, "NearbySearch", "UpdateDataTask");
            }
        }
    }
}

package _m_j;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.tencent.bugly.crashreport.biz.UserInfoBean;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.am;
import com.tencent.bugly.proguard.ar;
import com.tencent.bugly.proguard.k;
import com.xiaomi.mico.R2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class dgp {

    /* renamed from: O000000o  reason: collision with root package name */
    long f14606O000000o;
    private Context O00000Oo;
    private boolean O00000o = true;
    private int O00000o0;

    static /* synthetic */ void O000000o(dgp dgp, UserInfoBean userInfoBean, boolean z) {
        List<UserInfoBean> O000000o2;
        if (userInfoBean == null) {
            return;
        }
        if (z || userInfoBean.O00000Oo == 1 || (O000000o2 = O000000o(dgs.O000000o(dgp.O00000Oo).O00000oo)) == null || O000000o2.size() < 20) {
            long O000000o3 = dhv.O000000o().O000000o("t_ui", O000000o(userInfoBean), (dhu) null);
            if (O000000o3 >= 0) {
                did.O00000o0("[Database] insert %s success with ID: %d", "t_ui", Long.valueOf(O000000o3));
                userInfoBean.f5810O000000o = O000000o3;
                return;
            }
            return;
        }
        did.O000000o("[UserInfo] There are too many user info in local: %d", Integer.valueOf(O000000o2.size()));
    }

    public dgp(Context context, boolean z) {
        this.O00000Oo = context;
        this.O00000o = z;
    }

    public final void O000000o(int i, boolean z) {
        dgu O000000o2 = dgu.O000000o();
        int i2 = 0;
        if (O000000o2 == null || O000000o2.O00000o0().O0000OOo || i == 1 || i == 3) {
            if (i == 1 || i == 3) {
                this.O00000o0++;
            }
            dgs O000000o3 = dgs.O000000o(this.O00000Oo);
            UserInfoBean userInfoBean = new UserInfoBean();
            userInfoBean.O00000Oo = i;
            userInfoBean.O00000o0 = O000000o3.O00000oo;
            userInfoBean.O00000o = O000000o3.O00000o();
            userInfoBean.O00000oO = System.currentTimeMillis();
            userInfoBean.O00000oo = -1;
            userInfoBean.O0000o0 = O000000o3.O0000o0;
            if (i == 1) {
                i2 = 1;
            }
            userInfoBean.O0000o0O = i2;
            userInfoBean.O0000Ooo = O000000o3.O0000oo;
            userInfoBean.O0000o00 = O000000o3.O0000ooO;
            userInfoBean.O0000O0o = O000000o3.O0000ooo;
            userInfoBean.O0000OOo = O000000o3.O00oOooO;
            userInfoBean.O0000Oo0 = O000000o3.O00oOooo;
            userInfoBean.O0000OoO = O000000o3.O000O00o;
            userInfoBean.O0000oO0 = O000000o3.O0000ooo();
            userInfoBean.O0000oO = O000000o3.O000O0Oo();
            userInfoBean.O0000o0o = O000000o3.O00oOoOo();
            userInfoBean.O0000o = O000000o3.O0000oOo;
            dic.O000000o().O000000o(new O000000o(userInfoBean, z), 0);
            return;
        }
        did.O00000oO("UserInfo is disable", new Object[0]);
    }

    public final void O000000o() {
        this.f14606O000000o = dif.O00000Oo() + 86400000;
        dic.O000000o().O000000o(new O00000Oo(), (this.f14606O000000o - System.currentTimeMillis()) + 5000);
    }

    class O000000o implements Runnable {

        /* renamed from: O000000o  reason: collision with root package name */
        private boolean f14609O000000o;
        private UserInfoBean O00000Oo;

        public O000000o(UserInfoBean userInfoBean, boolean z) {
            this.O00000Oo = userInfoBean;
            this.f14609O000000o = z;
        }

        public final void run() {
            dgs O000000o2;
            try {
                if (this.O00000Oo != null) {
                    UserInfoBean userInfoBean = this.O00000Oo;
                    if (!(userInfoBean == null || (O000000o2 = dgs.O000000o()) == null)) {
                        userInfoBean.O0000Oo = O000000o2.O00000Oo();
                    }
                    did.O00000o0("[UserInfo] Record user info.", new Object[0]);
                    dgp.O000000o(dgp.this, this.O00000Oo, false);
                }
                if (this.f14609O000000o) {
                    dgp dgp = dgp.this;
                    dic O000000o3 = dic.O000000o();
                    if (O000000o3 != null) {
                        O000000o3.O000000o(new Runnable() {
                            /* class _m_j.dgp.AnonymousClass2 */

                            public final void run() {
                                try {
                                    dgp.this.O00000Oo();
                                } catch (Throwable th) {
                                    did.O000000o(th);
                                }
                            }
                        });
                    }
                }
            } catch (Throwable th) {
                if (!did.O000000o(th)) {
                    th.printStackTrace();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00f7  */
    public final synchronized void O00000Oo() {
        boolean z;
        if (this.O00000o) {
            dia O000000o2 = dia.O000000o();
            if (O000000o2 != null) {
                dgu O000000o3 = dgu.O000000o();
                if (O000000o3 != null) {
                    if (!O000000o3.O00000Oo() || O000000o2.O00000Oo(1001)) {
                        String str = dgs.O000000o(this.O00000Oo).O00000oo;
                        ArrayList arrayList = new ArrayList();
                        final List O000000o4 = O000000o(str);
                        if (O000000o4 != null) {
                            int size = O000000o4.size() - 20;
                            if (size > 0) {
                                int i = 0;
                                while (i < O000000o4.size() - 1) {
                                    int i2 = i + 1;
                                    for (int i3 = i2; i3 < O000000o4.size(); i3++) {
                                        if (((UserInfoBean) O000000o4.get(i)).O00000oO > ((UserInfoBean) O000000o4.get(i3)).O00000oO) {
                                            O000000o4.set(i, O000000o4.get(i3));
                                            O000000o4.set(i3, (UserInfoBean) O000000o4.get(i));
                                        }
                                    }
                                    i = i2;
                                }
                                for (int i4 = 0; i4 < size; i4++) {
                                    arrayList.add(O000000o4.get(i4));
                                }
                            }
                            Iterator it = O000000o4.iterator();
                            int i5 = 0;
                            while (it.hasNext()) {
                                UserInfoBean userInfoBean = (UserInfoBean) it.next();
                                if (userInfoBean.O00000oo != -1) {
                                    it.remove();
                                    if (userInfoBean.O00000oO < dif.O00000Oo()) {
                                        arrayList.add(userInfoBean);
                                    }
                                }
                                if (userInfoBean.O00000oO > System.currentTimeMillis() - 600000 && (userInfoBean.O00000Oo == 1 || userInfoBean.O00000Oo == 4 || userInfoBean.O00000Oo == 3)) {
                                    i5++;
                                }
                            }
                            if (i5 > 15) {
                                did.O00000o("[UserInfo] Upload user info too many times in 10 min: %d", Integer.valueOf(i5));
                                z = false;
                                if (arrayList.size() > 0) {
                                    O000000o(arrayList);
                                }
                                if (z) {
                                    if (O000000o4.size() != 0) {
                                        did.O00000o0("[UserInfo] Upload user info(size: %d)", Integer.valueOf(O000000o4.size()));
                                        ar O000000o5 = dhg.O000000o(O000000o4, this.O00000o0 == 1 ? 1 : 2);
                                        if (O000000o5 == null) {
                                            did.O00000o("[UserInfo] Failed to create UserInfoPackage.", new Object[0]);
                                            return;
                                        }
                                        byte[] O000000o6 = dhg.O000000o((k) O000000o5);
                                        if (O000000o6 == null) {
                                            did.O00000o("[UserInfo] Failed to encode data.", new Object[0]);
                                            return;
                                        }
                                        am O000000o7 = dhg.O000000o(this.O00000Oo, O000000o2.O00000oo ? R2.attr.level : 640, O000000o6);
                                        if (O000000o7 == null) {
                                            did.O00000o("[UserInfo] Request package is null.", new Object[0]);
                                            return;
                                        }
                                        AnonymousClass1 r12 = new dhz() {
                                            /* class _m_j.dgp.AnonymousClass1 */

                                            public final void O000000o(boolean z) {
                                                if (z) {
                                                    did.O00000o0("[UserInfo] Successfully uploaded user info.", new Object[0]);
                                                    long currentTimeMillis = System.currentTimeMillis();
                                                    for (UserInfoBean userInfoBean : O000000o4) {
                                                        userInfoBean.O00000oo = currentTimeMillis;
                                                        dgp.O000000o(dgp.this, userInfoBean, true);
                                                    }
                                                }
                                            }
                                        };
                                        StrategyBean O00000o02 = dgu.O000000o().O00000o0();
                                        dia.O000000o().O000000o(1001, O000000o7, O000000o2.O00000oo ? O00000o02.O0000oO0 : O00000o02.O0000oOO, O000000o2.O00000oo ? StrategyBean.O00000Oo : StrategyBean.f5812O000000o, r12, this.O00000o0 == 1);
                                        return;
                                    }
                                }
                                did.O00000o0("[UserInfo] There is no user info in local database.", new Object[0]);
                            }
                        } else {
                            O000000o4 = new ArrayList();
                        }
                        z = true;
                        if (arrayList.size() > 0) {
                        }
                        if (z) {
                        }
                        did.O00000o0("[UserInfo] There is no user info in local database.", new Object[0]);
                    }
                }
            }
        }
    }

    class O00000Oo implements Runnable {
        O00000Oo() {
        }

        public final void run() {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis < dgp.this.f14606O000000o) {
                dic.O000000o().O000000o(new O00000Oo(), (dgp.this.f14606O000000o - currentTimeMillis) + 5000);
                return;
            }
            dgp.this.O000000o(3, false);
            dgp.this.O000000o();
        }
    }

    class O00000o0 implements Runnable {

        /* renamed from: O000000o  reason: collision with root package name */
        private long f14611O000000o = 21600000;

        public O00000o0(long j) {
            this.f14611O000000o = j;
        }

        public final void run() {
            dgp dgp = dgp.this;
            dic O000000o2 = dic.O000000o();
            if (O000000o2 != null) {
                O000000o2.O000000o(new Runnable() {
                    /* class _m_j.dgp.AnonymousClass2 */

                    public final void run() {
                        try {
                            dgp.this.O00000Oo();
                        } catch (Throwable th) {
                            did.O000000o(th);
                        }
                    }
                });
            }
            dgp dgp2 = dgp.this;
            long j = this.f14611O000000o;
            dic.O000000o().O000000o(new O00000o0(j), j);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x009f A[Catch:{ all -> 0x00a8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00ab  */
    public static List<UserInfoBean> O000000o(String str) {
        Cursor cursor;
        String str2;
        try {
            if (dif.O000000o(str)) {
                str2 = null;
            } else {
                str2 = "_pc = '" + str + "'";
            }
            cursor = dhv.O000000o().O000000o("t_ui", (String[]) null, str2);
            if (cursor == null) {
                if (cursor != null) {
                    cursor.close();
                }
                return null;
            }
            try {
                StringBuilder sb = new StringBuilder();
                ArrayList arrayList = new ArrayList();
                while (cursor.moveToNext()) {
                    UserInfoBean O000000o2 = O000000o(cursor);
                    if (O000000o2 != null) {
                        arrayList.add(O000000o2);
                    } else {
                        long j = cursor.getLong(cursor.getColumnIndex("_id"));
                        sb.append(" or _id = ");
                        sb.append(j);
                    }
                }
                String sb2 = sb.toString();
                if (sb2.length() > 0) {
                    did.O00000o("[Database] deleted %s error data %d", "t_ui", Integer.valueOf(dhv.O000000o().O000000o("t_ui", sb2.substring(4))));
                }
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            } catch (Throwable th) {
                th = th;
                try {
                    if (!did.O000000o(th)) {
                    }
                    if (cursor != null) {
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (cursor != null) {
                    }
                    throw th;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    private static void O000000o(List<UserInfoBean> list) {
        if (list.size() != 0) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (i < list.size() && i < 50) {
                sb.append(" or _id = ");
                sb.append(list.get(i).f5810O000000o);
                i++;
            }
            String sb2 = sb.toString();
            if (sb2.length() > 0) {
                sb2 = sb2.substring(4);
            }
            sb.setLength(0);
            try {
                did.O00000o0("[Database] deleted %s data %d", "t_ui", Integer.valueOf(dhv.O000000o().O000000o("t_ui", sb2)));
            } catch (Throwable th) {
                if (!did.O000000o(th)) {
                    th.printStackTrace();
                }
            }
        }
    }

    private static ContentValues O000000o(UserInfoBean userInfoBean) {
        if (userInfoBean == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            if (userInfoBean.f5810O000000o > 0) {
                contentValues.put("_id", Long.valueOf(userInfoBean.f5810O000000o));
            }
            contentValues.put("_tm", Long.valueOf(userInfoBean.O00000oO));
            contentValues.put("_ut", Long.valueOf(userInfoBean.O00000oo));
            contentValues.put("_tp", Integer.valueOf(userInfoBean.O00000Oo));
            contentValues.put("_pc", userInfoBean.O00000o0);
            contentValues.put("_dt", dif.O000000o(userInfoBean));
            return contentValues;
        } catch (Throwable th) {
            if (!did.O000000o(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    private static UserInfoBean O000000o(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            byte[] blob = cursor.getBlob(cursor.getColumnIndex("_dt"));
            if (blob == null) {
                return null;
            }
            long j = cursor.getLong(cursor.getColumnIndex("_id"));
            UserInfoBean userInfoBean = (UserInfoBean) dif.O000000o(blob, UserInfoBean.CREATOR);
            if (userInfoBean != null) {
                userInfoBean.f5810O000000o = j;
            }
            return userInfoBean;
        } catch (Throwable th) {
            if (!did.O000000o(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }
}

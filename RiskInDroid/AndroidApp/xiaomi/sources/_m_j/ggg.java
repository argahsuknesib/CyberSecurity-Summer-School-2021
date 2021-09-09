package _m_j;

import android.util.LongSparseArray;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.framework.api.model.UserInfo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ggg {
    private static volatile ggg O00000Oo;

    /* renamed from: O000000o  reason: collision with root package name */
    public LongSparseArray<UserInfo> f17738O000000o = new LongSparseArray<>();

    public interface O000000o {
        void O000000o();
    }

    public static ggg O000000o() {
        if (O00000Oo == null) {
            synchronized (ggg.class) {
                if (O00000Oo == null) {
                    O00000Oo = new ggg();
                }
            }
        }
        return O00000Oo;
    }

    private ggg() {
    }

    public final void O000000o(Set<Long> set, final O000000o o000000o) {
        hys.O000000o().O000000o(ServiceApplication.getAppContext(), new ArrayList(set), new fsm<List<UserInfo>, fso>() {
            /* class _m_j.ggg.AnonymousClass1 */

            public final /* synthetic */ void onSuccess(Object obj) {
                List list = (List) obj;
                int i = 0;
                while (i < list.size()) {
                    try {
                        UserInfo userInfo = (UserInfo) list.get(i);
                        if (userInfo != null) {
                            ggg.this.f17738O000000o.put(Long.parseLong(userInfo.f7549O000000o), userInfo);
                        }
                        i++;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                O000000o o000000o = o000000o;
                if (o000000o != null) {
                    o000000o.O000000o();
                }
            }

            public final void onFailure(fso fso) {
                O000000o o000000o = o000000o;
                if (o000000o != null) {
                    o000000o.O000000o();
                }
            }
        });
    }

    public final UserInfo O000000o(long j) {
        UserInfo userInfo = this.f17738O000000o.get(j);
        if (userInfo != null) {
            return userInfo;
        }
        HashSet hashSet = new HashSet();
        hashSet.add(Long.valueOf(j));
        O000000o(hashSet, null);
        return null;
    }
}

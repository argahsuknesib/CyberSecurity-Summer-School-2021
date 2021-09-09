package _m_j;

import _m_j.guh;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.xiaomi.smarthome.miio.db.record.MessageRecord;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class guf {
    private static guf O0000Oo0;

    /* renamed from: O000000o  reason: collision with root package name */
    public List<O000000o> f18276O000000o = new ArrayList();
    public boolean O00000Oo = false;
    public List<gul> O00000o = new ArrayList();
    public Map<String, gum> O00000o0 = new HashMap();
    public O00000Oo O00000oO;
    public Handler O00000oo = new Handler(Looper.getMainLooper()) {
        /* class _m_j.guf.AnonymousClass1 */

        public final void handleMessage(Message message) {
            boolean z = true;
            switch (message.what) {
                case 9:
                    List list = (List) message.obj;
                    if (list != null) {
                        guf.this.O00000o.addAll(list);
                        Collections.sort(guf.this.O00000o, new Comparator<gul>() {
                            /* class _m_j.guf.AnonymousClass1.AnonymousClass1 */

                            public final /* synthetic */ int compare(Object obj, Object obj2) {
                                return (int) (((gul) obj2).O000000o() - ((gul) obj).O000000o());
                            }
                        });
                    } else {
                        z = false;
                    }
                    if (z) {
                        for (O000000o O000000o2 : guf.this.f18276O000000o) {
                            O000000o2.O000000o(list);
                        }
                    } else {
                        for (O000000o O00000Oo : guf.this.f18276O000000o) {
                            O00000Oo.O00000Oo();
                        }
                    }
                    guf.this.O00000Oo = false;
                    return;
                case 10:
                    List list2 = (List) message.obj;
                    if (list2 != null) {
                        guf.this.O00000o.addAll(list2);
                        Collections.sort(guf.this.O00000o, new Comparator<gul>() {
                            /* class _m_j.guf.AnonymousClass1.AnonymousClass2 */

                            public final /* synthetic */ int compare(Object obj, Object obj2) {
                                return (int) (((gul) obj2).O000000o() - ((gul) obj).O000000o());
                            }
                        });
                    } else {
                        z = false;
                    }
                    if (z) {
                        for (O000000o O000000o3 : guf.this.f18276O000000o) {
                            O000000o3.O000000o();
                        }
                    } else {
                        for (O000000o O000000o4 : guf.this.f18276O000000o) {
                            O000000o4.O000000o(10);
                        }
                    }
                    guf.this.O00000Oo = false;
                    return;
                case 11:
                    List list3 = (List) message.obj;
                    gsy.O000000o(6, "AllTypeMessage", "get cache size - " + list3.size());
                    if (list3 != null) {
                        guf.this.O00000o.clear();
                        guf.this.O00000o.addAll(list3);
                        Collections.sort(guf.this.O00000o, new Comparator<gul>() {
                            /* class _m_j.guf.AnonymousClass1.AnonymousClass3 */

                            public final /* synthetic */ int compare(Object obj, Object obj2) {
                                return (int) (((gul) obj2).O000000o() - ((gul) obj).O000000o());
                            }
                        });
                    } else {
                        z = false;
                    }
                    if (z) {
                        for (O000000o O000000o5 : guf.this.f18276O000000o) {
                            O000000o5.O000000o();
                        }
                    } else {
                        for (O000000o O000000o6 : guf.this.f18276O000000o) {
                            O000000o6.O000000o(11);
                        }
                    }
                    Message obtainMessage = guf.this.O00000oo.obtainMessage();
                    obtainMessage.what = 13;
                    if (guf.this.O00000o.size() > 0) {
                        obtainMessage.obj = Long.valueOf(guf.this.O00000o.get(0).O000000o());
                    } else {
                        obtainMessage.obj = 0L;
                    }
                    guf.this.O00000oO.sendMessage(obtainMessage);
                    return;
                default:
                    return;
            }
        }
    };
    private List<gul> O0000O0o = new ArrayList();
    private gpq O0000OOo = new gpq("get_messages");

    public interface O000000o {
        void O000000o();

        void O000000o(int i);

        void O000000o(List<gul> list);

        void O00000Oo();
    }

    public static guf O000000o() {
        if (O0000Oo0 == null) {
            O0000Oo0 = new guf();
        }
        return O0000Oo0;
    }

    public guf() {
        this.O00000o0.put("1", new guv());
        this.O00000o0.put("3", new gux());
        this.O00000o0.put("6", new guh());
        this.O00000o0.put("7", new gug());
        this.O00000o0.put("8", new guk());
        this.O00000o0.put("11", new guj());
    }

    class O00000Oo extends Handler {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ guf f18281O000000o;

        public final void handleMessage(Message message) {
            if (message.what == 12) {
                List<MessageRecord> queryAll = MessageRecord.queryAll();
                Message obtainMessage = this.f18281O000000o.O00000oo.obtainMessage();
                obtainMessage.what = 11;
                guf guf = this.f18281O000000o;
                ArrayList arrayList = new ArrayList();
                for (MessageRecord next : queryAll) {
                    gum gum = guf.O00000o0.get(next.messageType);
                    if (gum != null) {
                        gul O000000o2 = gum.O000000o(next);
                        if (O000000o2 != null) {
                            if (O000000o2 instanceof guh.O000000o) {
                                guq.O000000o(O000000o2);
                            }
                            arrayList.add(O000000o2);
                        }
                    } else {
                        MessageRecord.delete(next.msgId);
                    }
                }
                obtainMessage.obj = arrayList;
                this.f18281O000000o.O00000oo.sendMessage(obtainMessage);
            }
        }
    }
}

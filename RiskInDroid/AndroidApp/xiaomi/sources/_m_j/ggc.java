package _m_j;

import _m_j.ggg;
import android.graphics.BitmapFactory;
import android.util.LongSparseArray;
import android.util.SparseArray;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.framework.api.model.UserInfo;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.homeroom.model.HomeMember;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class ggc {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final String f17719O000000o = "ggc";
    private static volatile ggc O0000O0o;
    public Map<String, LongSparseArray<HomeMember>> O00000Oo = new HashMap();
    public SparseArray<List<gha>> O00000o = new SparseArray<>();
    public Map<String, List<Long>> O00000o0 = new HashMap();
    public SparseArray<List<gha>> O00000oO = new SparseArray<>();
    public BehaviorSubject<Boolean> O00000oo = BehaviorSubject.create();

    public static ggc O000000o() {
        if (O0000O0o == null) {
            synchronized (ggc.class) {
                if (O0000O0o == null) {
                    O0000O0o = new ggc();
                }
            }
        }
        return O0000O0o;
    }

    private ggc() {
    }

    public final LongSparseArray<HomeMember> O000000o(String str) {
        return this.O00000Oo.get(str);
    }

    public final List<gha> O000000o(int i) {
        List<gha> list = this.O00000o.get(i);
        if (list != null) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        this.O00000o.put(i, arrayList);
        return arrayList;
    }

    public final void O000000o(final Home home, final fsm<LongSparseArray<HomeMember>, fso> fsm) {
        gsy.O00000Oo(f17719O000000o, "startSyncHomeMemberFromServer ");
        if (ServiceApplication.getStateNotifier().f15923O000000o != 4 || home == null) {
            fsm.onFailure(new fso(-1, "get homemember err!"));
        } else {
            Observable.create(new ObservableOnSubscribe<LongSparseArray<HomeMember>>() {
                /* class _m_j.ggc.AnonymousClass4 */

                public final void subscribe(final ObservableEmitter<LongSparseArray<HomeMember>> observableEmitter) throws Exception {
                    fru.O000000o().O00000Oo(home, new fsm<JSONObject, fso>() {
                        /* class _m_j.ggc.AnonymousClass4.AnonymousClass1 */

                        public final /* synthetic */ void onSuccess(Object obj) {
                            JSONObject jSONObject = (JSONObject) obj;
                            if (observableEmitter.isDisposed()) {
                                return;
                            }
                            if (jSONObject == null || jSONObject.optJSONArray("list").length() == 0) {
                                observableEmitter.onComplete();
                                return;
                            }
                            LongSparseArray longSparseArray = new LongSparseArray();
                            List list = ggc.this.O00000o0.get(home.getId());
                            if (list == null) {
                                list = new ArrayList();
                                ggc.this.O00000o0.put(home.getId(), list);
                            }
                            list.clear();
                            JSONArray optJSONArray = jSONObject.optJSONArray("list");
                            for (int i = 0; i < optJSONArray.length(); i++) {
                                HomeMember O000000o2 = HomeMember.O000000o(optJSONArray.optJSONObject(i));
                                longSparseArray.put(O000000o2.O00000Oo, O000000o2);
                                list.add(Long.valueOf(O000000o2.O00000Oo));
                            }
                            observableEmitter.onNext(longSparseArray);
                            observableEmitter.onComplete();
                        }

                        public final void onFailure(fso fso) {
                            observableEmitter.onComplete();
                        }
                    });
                }
            }).flatMap(new Function<LongSparseArray<HomeMember>, ObservableSource<LongSparseArray<HomeMember>>>() {
                /* class _m_j.ggc.AnonymousClass3 */

                public final /* synthetic */ Object apply(Object obj) throws Exception {
                    final LongSparseArray longSparseArray = (LongSparseArray) obj;
                    return Observable.create(new ObservableOnSubscribe<LongSparseArray<HomeMember>>() {
                        /* class _m_j.ggc.AnonymousClass3.AnonymousClass1 */

                        public final void subscribe(final ObservableEmitter<LongSparseArray<HomeMember>> observableEmitter) throws Exception {
                            ArrayList arrayList = new ArrayList();
                            for (int i = 0; i < longSparseArray.size(); i++) {
                                arrayList.add(Long.valueOf(longSparseArray.keyAt(i)));
                            }
                            hys.O000000o().O000000o(ServiceApplication.getAppContext(), arrayList, new fsm<List<UserInfo>, fso>() {
                                /* class _m_j.ggc.AnonymousClass3.AnonymousClass1.AnonymousClass1 */

                                public final /* synthetic */ void onSuccess(Object obj) {
                                    List list = (List) obj;
                                    int i = 0;
                                    while (i < list.size()) {
                                        try {
                                            UserInfo userInfo = (UserInfo) list.get(i);
                                            HomeMember homeMember = (HomeMember) longSparseArray.get(Long.parseLong(userInfo.f7549O000000o));
                                            if (homeMember != null) {
                                                homeMember.O00000o0 = userInfo;
                                            }
                                            longSparseArray.put(Long.parseLong(userInfo.f7549O000000o), homeMember);
                                            i++;
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    }
                                    if (longSparseArray.size() > 0) {
                                        observableEmitter.onNext(longSparseArray);
                                    }
                                    observableEmitter.onComplete();
                                }

                                public final void onFailure(fso fso) {
                                    observableEmitter.onComplete();
                                }
                            });
                        }
                    });
                }
            }).subscribe(new Observer<LongSparseArray<HomeMember>>() {
                /* class _m_j.ggc.AnonymousClass1 */

                /* renamed from: O000000o  reason: collision with root package name */
                boolean f17720O000000o = false;

                public final void onError(Throwable th) {
                }

                public final /* synthetic */ void onNext(Object obj) {
                    gsy.O00000Oo(ggc.f17719O000000o, "onNext: ");
                    this.f17720O000000o = true;
                    ggc.this.O00000Oo.put(home.getId(), (LongSparseArray) obj);
                }

                public final void onSubscribe(Disposable disposable) {
                    gsy.O00000Oo(ggc.f17719O000000o, "onSubscribe: ");
                }

                public final void onComplete() {
                    gsy.O00000Oo(ggc.f17719O000000o, "onComplete: ");
                    if (fsm != null) {
                        LongSparseArray longSparseArray = ggc.this.O00000Oo.get(home.getId());
                        if (!this.f17720O000000o || longSparseArray == null || longSparseArray.size() <= 0) {
                            fsm.onFailure(new fso(-1, "get homemember err!"));
                        } else {
                            fsm.onSuccess(longSparseArray);
                        }
                    }
                }
            });
        }
    }

    public final void O000000o(UserInfo userInfo, String str, fsm<JSONObject, fso> fsm) {
        gsy.O00000Oo(f17719O000000o, "homeMemberInvite");
        if (userInfo == null) {
            fsm.onFailure(new fso(-1, "userinfo == null"));
            return;
        }
        long parseLong = Long.parseLong(userInfo.f7549O000000o);
        final String str2 = str;
        final long j = parseLong;
        final UserInfo userInfo2 = userInfo;
        final fsm<JSONObject, fso> fsm2 = fsm;
        fru.O000000o().O000000o(parseLong, str, new fsm<JSONObject, fso>() {
            /* class _m_j.ggc.AnonymousClass5 */

            public final /* synthetic */ void onSuccess(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                LongSparseArray<HomeMember> O000000o2 = ggc.O000000o().O000000o(str2);
                if (O000000o2 == null) {
                    O000000o2 = new LongSparseArray<>();
                }
                HomeMember homeMember = new HomeMember();
                long j = j;
                homeMember.O00000Oo = j;
                homeMember.f8990O000000o = 0;
                homeMember.O00000o0 = userInfo2;
                O000000o2.put(j, homeMember);
                fsm fsm = fsm2;
                if (fsm != null) {
                    fsm.onSuccess(jSONObject);
                }
            }

            public final void onFailure(fso fso) {
                fsm fsm = fsm2;
                if (fsm != null) {
                    fsm.onFailure(fso);
                }
                gsy.O00000Oo(ggc.f17719O000000o, fso.toString());
            }
        });
    }

    public final void O000000o(long j, Home home, fsm<JSONObject, fso> fsm) {
        gsy.O00000Oo(f17719O000000o, "homeMemberInviteRemove");
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Long.valueOf(j));
            final Home home2 = home;
            final long j2 = j;
            final fsm<JSONObject, fso> fsm2 = fsm;
            fru.O000000o().O000000o(arrayList, home.getOwnerUid(), Long.parseLong(home.getId()), new fsm<JSONObject, fso>() {
                /* class _m_j.ggc.AnonymousClass6 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    JSONObject jSONObject = (JSONObject) obj;
                    LongSparseArray<HomeMember> O000000o2 = ggc.O000000o().O000000o(home2.getId());
                    if (O000000o2 != null) {
                        O000000o2.remove(j2);
                    }
                    if (!home2.isOwner()) {
                        List<Home> list = ggb.O00000Oo().O0000OoO.O00000Oo;
                        if (list != null) {
                            list.remove(home2);
                        }
                        ggb.O00000Oo().O00000o0();
                    }
                    fsm fsm = fsm2;
                    if (fsm != null) {
                        fsm.onSuccess(jSONObject);
                    }
                }

                public final void onFailure(fso fso) {
                    fsm fsm = fsm2;
                    if (fsm != null) {
                        fsm.onFailure(fso);
                    }
                    gsy.O00000Oo(ggc.f17719O000000o, fso.toString());
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void O000000o(final fsm<Void, fso> fsm) {
        gsy.O00000Oo(f17719O000000o, "homeMemberInviteHistory");
        fru.O000000o().O00000Oo(new fsm<JSONObject, fso>() {
            /* class _m_j.ggc.AnonymousClass7 */

            public final /* synthetic */ void onSuccess(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                ggc.this.O00000o.clear();
                ggc.this.O00000oO.clear();
                if (jSONObject == null) {
                    fsm fsm = fsm;
                    if (fsm != null) {
                        fsm.onFailure(new fso(-1, "InviteHistory == null"));
                        return;
                    }
                    return;
                }
                HashSet hashSet = new HashSet();
                if (!jSONObject.isNull("received")) {
                    ggc.this.O00000o = gha.O000000o(jSONObject.optJSONArray("received"), hashSet);
                }
                if (!jSONObject.isNull("sended")) {
                    ggc.this.O00000oO = gha.O000000o(jSONObject.optJSONArray("sended"), hashSet);
                }
                ggg.O000000o().O000000o(hashSet, new ggg.O000000o() {
                    /* class _m_j.ggc.AnonymousClass7.AnonymousClass1 */

                    public final void O000000o() {
                        if (fsm != null) {
                            fsm.onSuccess(null);
                        }
                    }
                });
            }

            public final void onFailure(fso fso) {
                fsm fsm = fsm;
                if (fsm != null) {
                    fsm.onFailure(fso);
                }
                gsy.O00000Oo(ggc.f17719O000000o, fso.toString());
            }
        });
    }

    public final void O000000o(final gha gha, final int i, final fsm<JSONObject, fso> fsm) {
        gsy.O00000Oo(f17719O000000o, "homeMemberInviteResponse");
        if (gha == null) {
            fsm.onFailure(new fso(-1, "homeInviteInfo == null"));
            return;
        }
        fru.O000000o().O000000o(gha.O00000oO, gha.O00000oo, i, new fsm<JSONObject, fso>() {
            /* class _m_j.ggc.AnonymousClass8 */

            public final /* synthetic */ void onSuccess(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                List<gha> O000000o2 = ggc.this.O000000o(gha.O0000O0o);
                if (O000000o2 != null) {
                    O000000o2.remove(gha);
                }
                int i = i == 1 ? gha.O00000Oo : gha.O00000o0;
                gha.O0000O0o = i;
                ggc.this.O000000o(i).add(gha);
                if (i == 1) {
                    ggb.O00000Oo().O00000o0();
                }
                fsm fsm = fsm;
                if (fsm != null) {
                    fsm.onSuccess(jSONObject);
                }
            }

            public final void onFailure(fso fso) {
                fsm fsm = fsm;
                if (fsm != null) {
                    fsm.onFailure(fso);
                }
                gsy.O00000Oo(ggc.f17719O000000o, fso.toString());
            }
        });
    }

    public static void O000000o(String str, String str2, String str3, String str4) {
        Home O00000o2 = ggb.O00000Oo().O00000o(str2);
        if (O00000o2 == null) {
            gqg.O00000Oo((int) R.string.share_wx_error);
            return;
        }
        int size = O00000o2.getRoomList().size();
        int size2 = O00000o2.getDids().size();
        ggb.O00000Oo();
        String O000000o2 = ggb.O000000o(O00000o2);
        IWXAPI iwxapi = ServiceApplication.getIWXAPI();
        WXMiniProgramObject wXMiniProgramObject = new WXMiniProgramObject();
        wXMiniProgramObject.miniprogramType = 0;
        wXMiniProgramObject.webpageUrl = "https://mijiayoupin.com/shop/main";
        wXMiniProgramObject.userName = "gh_b1cd5e842bf2";
        wXMiniProgramObject.path = "pages/share/share" + "?type=share_home&miId=" + fcn.O000000o().O00000Oo() + "&roomCount=" + size + "&deviceCount=" + size2 + "&userName=" + str4 + "&avatar=" + str3 + "&homeName=" + O000000o2 + "&shareKey=" + str;
        WXMediaMessage wXMediaMessage = new WXMediaMessage(wXMiniProgramObject);
        wXMediaMessage.title = ServiceApplication.getAppContext().getString(R.string.home_share_wx_title);
        wXMediaMessage.description = "";
        wXMediaMessage.setThumbImage(BitmapFactory.decodeResource(ServiceApplication.getAppContext().getResources(), R.drawable.accept_home_defualt));
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = String.valueOf(System.currentTimeMillis());
        req.message = wXMediaMessage;
        req.scene = 0;
        iwxapi.sendReq(req);
    }
}

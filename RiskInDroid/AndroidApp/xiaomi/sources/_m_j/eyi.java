package _m_j;

import _m_j.hcc;
import _m_j.hcc.O000000o;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.sankuai.waimai.router.annotation.RouterService;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.api.spec.instance.Spec;
import com.xiaomi.smarthome.device.api.spec.instance.SpecAction;
import com.xiaomi.smarthome.device.api.spec.instance.SpecProperty;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.newui.card.State;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

@RouterService
public class eyi<E extends hcc.O000000o<T>, T> implements faz<E, T> {
    private static final eyi INSTANCE = new eyi();

    @cug
    public static eyi provideInstance() {
        return INSTANCE;
    }

    private eyi() {
        gsy.O000000o(4, "mijia-card", "constructor MainPageOpManager:".concat(String.valueOf(this)));
    }

    public static eyi getInstance() {
        return INSTANCE;
    }

    public void toggleButton(Device device, int i, hcc.O000000o<T> o000000o, fsm<Void, fso> fsm) {
        if ((device == null || o000000o == null) && fsm != null) {
            fsm.onFailure(new fso(-1, "device is null"));
        }
        if (o000000o instanceof hed) {
            toggleNormal(device, (hed) o000000o, fsm);
        } else if (o000000o instanceof hej) {
            toggleSpec(device, i, (hej) o000000o, fsm);
        }
    }

    private void toggleNormal(Device device, hed hed, final fsm<Void, fso> fsm) {
        if (hcv.getInstance().getCardInfo(device.model) == null) {
            if (fsm != null) {
                fsm.onFailure(new fso(-1, "card config is null"));
            }
        } else if (hed != null && hed.O00000o != null && hed.O00000o.size() >= 2) {
            hdb O000000o2 = hdb.O000000o(hed.O00000o, hed.O000000o(hed, device, hed.O00000o0));
            if (O000000o2 != null) {
                Device device2 = device;
                hed hed2 = hed;
                hcv.getInstance().setDeviceProp(device2, hed2, O000000o2.O00000o, O000000o2.O00000oO, O000000o2.O000000o(hed.O00000o), new fsm<JSONObject, fso>() {
                    /* class _m_j.eyi.AnonymousClass1 */

                    public final void onFailure(fso fso) {
                        fsm fsm = fsm;
                        if (fsm != null) {
                            fsm.onFailure(fso);
                        }
                    }

                    public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                        fsm fsm = fsm;
                        if (fsm != null) {
                            fsm.onSuccess(null);
                        }
                    }
                });
            } else if (fsm != null) {
                fsm.onFailure(new fso(-1, "get operation null"));
            }
        } else if (fsm != null) {
            fsm.onFailure(new fso(-1, "wrong config"));
        }
    }

    private void toggleSpec(Device device, int i, hej hej, final fsm<Void, fso> fsm) {
        Spec.SpecItem specItem;
        if (hej != null) {
            hcz instance = hcz.getInstance();
            Spec.SpecItem[] gridCardProperty = instance.getGridCardProperty(device, i);
            if (gridCardProperty == null || gridCardProperty.length == 0 || (specItem = gridCardProperty[0]) == null || !(specItem instanceof SpecProperty)) {
                gsy.O00000Oo(LogType.MAIN_PAGE, "mijia-card", "toggleSpec not get prop:".concat(String.valueOf(device)));
                return;
            }
            SpecProperty specProperty = (SpecProperty) specItem;
            SpecAction O000000o2 = hfa.O000000o(hcz.getInstance().getSpecInstance(device), hdb.O000000o(hej.O00000o, hfa.O000000o(specProperty, hej.O00000o0(device, specItem))));
            if (O000000o2 != null) {
                instance.setDeviceAction(device.did, O000000o2, gridCardProperty[0], new fsm<JSONObject, fso>() {
                    /* class _m_j.eyi.AnonymousClass2 */

                    public final void onFailure(fso fso) {
                        fsm fsm = fsm;
                        if (fsm != null) {
                            fsm.onFailure(null);
                        }
                    }

                    public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                        fsm fsm = fsm;
                        if (fsm != null) {
                            fsm.onSuccess(null);
                        }
                    }
                });
            } else {
                instance.setDeviceProp(device.did, specProperty, hej.O00000Oo(device, specItem), new fsm<JSONObject, fso>() {
                    /* class _m_j.eyi.AnonymousClass3 */

                    public final void onFailure(fso fso) {
                        fsm fsm = fsm;
                        if (fsm != null) {
                            fsm.onFailure(null);
                        }
                    }

                    public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                        fsm fsm = fsm;
                        if (fsm != null) {
                            fsm.onSuccess(null);
                        }
                    }
                });
            }
        } else if (fsm != null) {
            fsm.onFailure(new fso(-1, "wrong config"));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: _m_j.hcc<E, T>} */
    /* JADX WARNING: Multi-variable type inference failed */
    public hcc<E, T> getGridCard(Device device) {
        hcc<E, T> hcc = null;
        if (device == null) {
            return null;
        }
        heb cardInfo = hcv.getInstance().getCardInfo(device.model);
        if (cardInfo != null) {
            return cardInfo;
        }
        Pair<hep, Spec.SpecItem[][]> gridCardPair = hcz.getInstance().getGridCardPair(device);
        if (gridCardPair != null) {
            hcc = gridCardPair.first;
        }
        return hcc;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: _m_j.hcc<E, T>} */
    /* JADX WARNING: Multi-variable type inference failed */
    public hcc<E, T> getActivityCard(Device device) {
        hcc<E, T> hcc = null;
        if (device == null) {
            return null;
        }
        heb cardInfo = hcv.getInstance().getCardInfo(device.model);
        if (cardInfo != null) {
            return cardInfo;
        }
        Pair<hep, Spec.SpecItem[][]> activityCardPair = hcz.getInstance().getActivityCardPair(device, false);
        if (activityCardPair != null) {
            hcc = activityCardPair.first;
        }
        return hcc;
    }

    public ArrayList<Long> getDeviceDataUpdateTime(Device device) {
        hcc gridCard = getInstance().getGridCard(device);
        if (gridCard == null) {
            return null;
        }
        List O000000o2 = gridCard.O000000o();
        ArrayList<Long> arrayList = new ArrayList<>();
        for (int i = 0; i < O000000o2.size(); i++) {
            hcc.O000000o o000000o = (hcc.O000000o) O000000o2.get(i);
            arrayList.add(Long.valueOf(o000000o.O00000oO(device, getPropKey(o000000o, i, device))));
        }
        return arrayList;
    }

    public ArrayList<Pair> getDeviceRenderData(Device device, hcc<E, T> hcc) {
        if (hcc == null) {
            gsy.O00000Oo("mijia-card", "getDeviceRenderData card is null device:".concat(String.valueOf(device)));
            return null;
        }
        List<E> O000000o2 = hcc.O000000o();
        if (O000000o2 == null || O000000o2.isEmpty()) {
            gsy.O00000Oo("mijia-card", "getDeviceRenderData gridCardItems is empty device:".concat(String.valueOf(device)));
            return null;
        } else if (hcc.O00000Oo == -1) {
            gsy.O00000Oo("mijia-card", "getDeviceRenderData layoutType is not support device:".concat(String.valueOf(device)));
            return null;
        } else {
            ArrayList<Pair> arrayList = new ArrayList<>();
            for (int i = 0; i < O000000o2.size(); i++) {
                hcc.O000000o o000000o = (hcc.O000000o) O000000o2.get(i);
                addPair(device, i, o000000o, getPropKey(o000000o, i, device), arrayList);
            }
            gsy.O00000Oo("mijia-card", "getDeviceRenderData match item device:" + device + " pair:" + arrayList);
            return arrayList;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: E
        	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
        	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
        	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
        	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
        	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
        	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
        */
    private void addPair(com.xiaomi.smarthome.device.Device r5, int r6, E r7, T r8, java.util.ArrayList<android.util.Pair> r9) {
        /*
            r4 = this;
            if (r8 != 0) goto L_0x0020
            com.xiaomi.smarthome.library.log.LogType r6 = com.xiaomi.smarthome.library.log.LogType.MAIN_PAGE
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r9 = "getDeviceRenderData configGrid but no support device:"
            r8.<init>(r9)
            r8.append(r5)
            java.lang.String r5 = " item:"
            r8.append(r5)
            r8.append(r7)
            java.lang.String r5 = r8.toString()
            java.lang.String r7 = "mijia-card"
            _m_j.gsy.O00000o0(r6, r7, r5)
            return
        L_0x0020:
            int r0 = r7.O00000Oo
            r1 = 1
            if (r0 == r1) goto L_0x00c3
            int r0 = r7.O00000Oo
            r1 = 2
            if (r0 != r1) goto L_0x002c
            goto L_0x00c3
        L_0x002c:
            int r6 = r7.O00000Oo
            r0 = 7
            java.lang.String r1 = ""
            if (r6 == r0) goto L_0x009f
            int r6 = r7.O00000Oo
            r0 = 17
            if (r6 != r0) goto L_0x003a
            goto L_0x009f
        L_0x003a:
            int r6 = r7.O00000Oo
            r0 = 8
            if (r6 != r0) goto L_0x0068
            java.lang.Object r6 = r7.O00000Oo(r5, r8)
            android.util.Pair r0 = new android.util.Pair
            boolean r2 = r7.O0000O0o
            if (r2 == 0) goto L_0x004c
            r2 = r1
            goto L_0x0050
        L_0x004c:
            java.lang.String r2 = r7.O000000o(r5, r8)
        L_0x0050:
            if (r6 == 0) goto L_0x0061
            boolean r3 = r1.equals(r6)
            if (r3 == 0) goto L_0x0059
            goto L_0x0061
        L_0x0059:
            java.lang.String r5 = r7.O000000o(r5, r8, r6)
            java.lang.String r1 = java.lang.String.valueOf(r5)
        L_0x0061:
            r0.<init>(r2, r1)
            r9.add(r0)
            return
        L_0x0068:
            int r6 = r7.O00000Oo
            r0 = 10
            if (r6 != r0) goto L_0x0084
            android.util.Pair r6 = new android.util.Pair
            boolean r0 = r7.O0000O0o
            if (r0 == 0) goto L_0x0075
            goto L_0x0079
        L_0x0075:
            java.lang.String r1 = r7.O000000o(r5, r8)
        L_0x0079:
            java.lang.String r5 = r4.getPropValueShow10(r5, r7, r8)
            r6.<init>(r1, r5)
            r9.add(r6)
            return
        L_0x0084:
            int r6 = r7.O00000Oo
            r0 = 18
            if (r6 != r0) goto L_0x009e
            android.util.Pair r6 = new android.util.Pair
            java.lang.String r0 = r4.getPropValueShow18(r5, r7, r8)
            java.lang.Object r1 = r7.O00000Oo(r5, r8)
            java.lang.String r5 = r7.O000000o(r5, r8, r1)
            r6.<init>(r0, r5)
            r9.add(r6)
        L_0x009e:
            return
        L_0x009f:
            java.lang.Object r6 = r7.O00000Oo(r5, r8)
            android.util.Pair r0 = new android.util.Pair
            boolean r2 = r7.O0000O0o
            if (r2 == 0) goto L_0x00ab
            r2 = r1
            goto L_0x00af
        L_0x00ab:
            java.lang.String r2 = r7.O000000o(r5, r8)
        L_0x00af:
            if (r6 == 0) goto L_0x00bc
            boolean r3 = r1.equals(r6)
            if (r3 == 0) goto L_0x00b8
            goto L_0x00bc
        L_0x00b8:
            java.lang.String r1 = r4.getPropValueShow7(r5, r7, r6, r8)
        L_0x00bc:
            r0.<init>(r2, r1)
            r9.add(r0)
            return
        L_0x00c3:
            r8 = 0
            android.util.Pair r5 = r4.getButtonDrawable(r5, r7, r6, r8)
            if (r5 == 0) goto L_0x00cd
            r9.add(r5)
        L_0x00cd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: _m_j.eyi.addPair(com.xiaomi.smarthome.device.Device, int, _m_j.hcc$O000000o, java.lang.Object, java.util.ArrayList):void");
    }

    public static <T, E extends hcc.O000000o<T>> T getPropKey(E e, int i, Device device) {
        if (e instanceof hed) {
            return ((hed) e).O00000o0;
        }
        return hfa.O000000o((Object[]) hcz.getInstance().getGridCardProperty(device, i));
    }

    private String getPropValueShow18(Device device, hcc.O000000o<T> o000000o, T t) {
        try {
            Pair<Object, Long> O00000o = o000000o.O00000o(device, t);
            if (O00000o == null) {
                return "";
            }
            return hhc.O000000o(((Long) O00000o.second).longValue());
        } catch (Exception e) {
            gsy.O000000o(6, "mijia-card", Log.getStackTraceString(e));
            return "";
        }
    }

    private String getPropValueShow10(Device device, hcc.O000000o<T> o000000o, T t) {
        try {
            Pair<Object, Long> O00000o = o000000o.O00000o(device, t);
            if (O00000o == null) {
                return "";
            }
            return hhc.O000000o(((Long) O00000o.second).longValue());
        } catch (Exception e) {
            gsy.O000000o(6, "mijia-card", Log.getStackTraceString(e));
            return "";
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.hcc.O000000o.O000000o(java.lang.Object, java.lang.Object, com.xiaomi.smarthome.device.Device):_m_j.hdj
     arg types: [T, java.lang.Object, com.xiaomi.smarthome.device.Device]
     candidates:
      _m_j.hcc.O000000o.O000000o(com.xiaomi.smarthome.device.Device, java.lang.Object, java.lang.Object):java.lang.String
      _m_j.hcc.O000000o.O000000o(java.lang.Object, java.lang.Object, com.xiaomi.smarthome.device.Device):_m_j.hdj */
    private String getPropValueShow7(Device device, hcc.O000000o<T> o000000o, Object obj, T t) {
        return o000000o.O000000o((Object) t, obj, device).toString();
    }

    public Pair<State, String> getButtonDrawable(Device device, int i, hcc.O000000o<T> o000000o, boolean z) {
        return getButtonDrawable(device, o000000o, i, z);
    }

    private Pair<State, String> getButtonDrawable(Device device, hcc.O000000o<T> o000000o, int i, boolean z) {
        if (o000000o == null || device == null) {
            return null;
        }
        if (o000000o instanceof hed) {
            return getNormalButtonDrawable(device, (hed) o000000o, z);
        }
        return getSpecButtonDrawable(device, (hej) o000000o, hcz.getInstance().getGridCardProperty(device, i), z);
    }

    private Pair<State, String> getNormalButtonDrawable(Device device, hed hed, boolean z) {
        State state;
        hdb hdb;
        String str;
        if (hed == null || device == null) {
            StringBuilder sb = new StringBuilder("card_items null model:");
            sb.append(device == null ? "null" : device.model);
            gsy.O000000o(6, "mijia-card", sb.toString());
            return null;
        }
        hee O000000o2 = hed.O000000o();
        if (O000000o2 == null) {
            gsy.O000000o(6, "mijia-card", "propItem null model:" + device.model);
            return null;
        }
        Object O000000o3 = hed.O000000o(hed, device, hed.O00000o0);
        List list = hed.O00000o;
        if (list == null || list.size() < 2) {
            gsy.O000000o(6, "mijia-card", "card_items.prop_key:" + hed.O00000o0 + " card_items.operations only one model:" + device.model);
            return null;
        }
        boolean z2 = true;
        if (hed.O00000Oo == 1) {
            if (O000000o2.O0000Oo0 == null) {
                gsy.O000000o(6, "mijia-card", "model:" + device.model + " prop:" + O000000o2.f18836O000000o + " switchStatus is not config");
                return null;
            }
            State state2 = null;
            for (Object valueOf : O000000o2.O0000Oo0) {
                if (String.valueOf(valueOf).equals(String.valueOf(O000000o3))) {
                    state2 = z ? State.NOR : State.SELECTED;
                }
            }
            if (state2 == null) {
                state = z ? State.SELECTED : State.NOR;
                hdb = null;
            } else {
                hdb = null;
                state = state2;
            }
        } else if (hed.O00000Oo != 2) {
            state = null;
            hdb = null;
        } else if (((hdb) list.get(0)).O000000o(String.valueOf(O000000o3))) {
            state = z ? State.NOR : State.SELECTED;
            hdb = (hdb) list.get(0);
        } else {
            state = z ? State.SELECTED : State.NOR;
            hdb = (hdb) list.get(1);
        }
        if (hdb != null && !hed.O000000o(device, hdb)) {
            z2 = false;
        }
        if (!isVacuumDevice(device) || z2) {
            if (!z2) {
                state = State.UNABLE;
            }
            if (state == State.SELECTED) {
                str = hcv.getInstance().getCardIconPath(hcv.getInstance().translateName("grid_" + ((hdb) list.get(0)).O0000Oo0));
            } else {
                str = hcv.getInstance().getCardIconPath(hcv.getInstance().translateName("grid_" + ((hdb) list.get(0)).O0000OOo));
            }
            return new Pair<>(state, str);
        }
        gsy.O000000o(6, "mijia-card", "model:" + device.model + " isVacuumDevice disable  value:" + O000000o3);
        return null;
    }

    private boolean isVacuumDevice(Device device) {
        if (device == null) {
            return false;
        }
        if (device.model.contains("rockrobo.vacuum") || device.model.contains("roborock.sweeper") || device.model.contains("roborock.vacuum")) {
            return true;
        }
        return false;
    }

    private Pair<State, String> getSpecButtonDrawable(Device device, hej hej, Spec.SpecItem[] specItemArr, boolean z) {
        Spec.SpecItem specItem;
        State state;
        String str;
        if (device == null || hej == null || specItemArr == null || specItemArr.length == 0 || (specItem = specItemArr[0]) == null || !(specItem instanceof SpecProperty)) {
            gsy.O00000Oo(LogType.MAIN_PAGE, "mijia-card", "getSpecButtonDrawable device,cardItem,pair == null" + device + hej + specItemArr);
            return null;
        } else if (TextUtils.isEmpty(hfa.O00000Oo(device))) {
            gsy.O00000Oo(LogType.MAIN_PAGE, "mijia-card", device.did + "getSpecButtonDrawable category == null");
            return null;
        } else {
            Object O00000o0 = hej.O00000o0(device, specItem);
            if (O00000o0 == null) {
                gsy.O00000Oo(LogType.MAIN_PAGE, "mijia-card", device.did + "getSpecButtonDrawable getPropValue == null");
                return null;
            }
            hdb O000000o2 = hdb.O000000o(hej.O00000o, hfa.O000000o((SpecProperty) specItem, O00000o0));
            SpecAction O000000o3 = hfa.O000000o(hcz.getInstance().getSpecInstance(device), O000000o2);
            if (!hej.O000000o(device, O000000o2)) {
                state = State.UNABLE;
            } else if (O000000o3 == null) {
                state = hfa.O000000o(O00000o0) ? z ? State.NOR : State.SELECTED : z ? State.SELECTED : State.NOR;
            } else if (hej.O00000o.indexOf(O000000o2) == 0) {
                state = z ? State.NOR : State.SELECTED;
            } else {
                state = z ? State.SELECTED : State.NOR;
            }
            if (O000000o2 == null || O000000o3 == null) {
                str = null;
            } else {
                str = hfa.O000000o("carditemspec_grid_", device, O000000o3, String.valueOf(O000000o2.O00000Oo), State.SELECTED);
                if (str == null) {
                    str = hfa.O000000o("carditemspec_grid_", device, O000000o3, String.valueOf(O000000o2.O00000Oo), State.NOR);
                }
            }
            if (str == null) {
                str = hfa.O000000o("carditemspec_grid_", device, specItem, (String) null, state);
            }
            if (str != null) {
                return new Pair<>(state, str);
            }
            gsy.O00000o0(LogType.MAIN_PAGE, "mijia-card", device.did + "getSpecButtonDrawable drawable == null");
            return null;
        }
    }

    public boolean isSameCard(Device device) {
        if (device == null) {
            return false;
        }
        heb cardInfo = hcv.getInstance().getCardInfo(device.model);
        if (cardInfo != null) {
            return isSameCardType(cardInfo.O000000o(), cardInfo.O00000Oo());
        }
        Pair<hep, Spec.SpecItem[][]> gridCardPair = hcz.getInstance().getGridCardPair(device);
        Pair<hep, Spec.SpecItem[][]> activityCardPair = hcz.getInstance().getActivityCardPair(device, false);
        if (gridCardPair == null || activityCardPair == null) {
            return false;
        }
        return isSameCardType(((hep) gridCardPair.first).O000000o(), ((hep) activityCardPair.first).O00000Oo());
    }

    private boolean isSameCardType(List<? extends hcc.O000000o> list, List<? extends hcc.O000000o> list2) {
        int size;
        if (list2 == null || list2.size() == 0) {
            return list == null || list.size() == 0;
        }
        if (list == null || (size = list2.size()) != list.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!TextUtils.equals(((hcc.O000000o) list2.get(i)).O00000o0, ((hcc.O000000o) list.get(i)).O00000o0)) {
                return false;
            }
        }
        return true;
    }
}

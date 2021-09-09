package _m_j;

import _m_j.hcc;
import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.google.android.exoplayer2.C;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.api.spec.instance.Spec;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.newui.card.BaseCardRender;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import no.nordicsemi.android.dfu.DfuSettingsConstants;
import org.json.JSONObject;

public final class hch {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final O000000o f18778O000000o = $$Lambda$hch$3wX9dKw4vVFTfv2LHgjWoU4kxd4.INSTANCE;

    public interface O000000o {
        <T, E extends hcc.O000000o<T>, C extends hcc<E, T>> hcf<C, E, T> createCardItem(C c, E e, T[] tArr);
    }

    /* JADX WARN: Failed to insert an additional move for type inference into block B:39:0x0110 */
    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v2, types: [_m_j.hbz<C, E, T>, com.xiaomi.smarthome.newui.card.BaseCardRender] */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r1v20, types: [_m_j.hci] */
    /* JADX WARN: Type inference failed for: r1v21, types: [_m_j.hcj] */
    /* JADX WARN: Type inference failed for: r1v22, types: [_m_j.hcl] */
    /* JADX WARN: Type inference failed for: r1v23, types: [_m_j.hck] */
    /* JADX WARN: Type inference failed for: r1v24, types: [_m_j.hcm] */
    /* JADX WARN: Type inference failed for: r1v25, types: [_m_j.hco] */
    /* JADX WARN: Type inference failed for: r1v26, types: [_m_j.hcp] */
    /* JADX WARN: Type inference failed for: r1v27, types: [_m_j.hcn] */
    /* JADX WARN: Type inference failed for: r1v28, types: [_m_j.hcq] */
    /* JADX WARN: Type inference failed for: r1v29, types: [_m_j.hcs] */
    /* JADX WARN: Type inference failed for: r1v30, types: [_m_j.hct] */
    /* JADX WARN: Type inference failed for: r1v31, types: [_m_j.hcr] */
    /* JADX WARNING: Multi-variable type inference failed */
    public static <C extends hcc<E, T>, E extends hcc.O000000o<T>, T> hbz<C, E, T> O000000o(C c, T[][] tArr, ViewGroup viewGroup, Context context, Device device, O000000o o000000o) {
        hcr hcr;
        if (c == null || c.O00000Oo().size() == 0) {
            return new hcr(c, new ArrayList(), viewGroup, context, device);
        }
        ArrayList O000000o2 = O000000o(c, tArr, o000000o);
        try {
            Iterator it = O000000o2.iterator();
            while (it.hasNext()) {
                if (((hcf) it.next()) instanceof hdl) {
                    return new hcr(c, O000000o2, viewGroup, context, device);
                }
            }
            if (c instanceof heb) {
                String str = ((heb) c).O00000o0;
                if (!TextUtils.isEmpty(str)) {
                    String optString = new JSONObject(device.extra).optString("fw_version");
                    if (!TextUtils.isEmpty(optString) && fml.O000000o(optString, str) < 0) {
                        return new hcr(c, O000000o2, viewGroup, context, device);
                    }
                }
            }
            int i = c.O00000Oo;
            if (i != 10001) {
                switch (i) {
                    case 0:
                        hcr = new hcj(c, O000000o2, viewGroup, context, device);
                        break;
                    case 1:
                        hcr = new hcl(c, O000000o2, viewGroup, context, device);
                        break;
                    case 2:
                        hcr = new hck(c, O000000o2, viewGroup, context, device);
                        break;
                    case 3:
                        hcr = new hcm(c, O000000o2, viewGroup, context, device);
                        break;
                    case 4:
                        hcr = new hco(c, O000000o2, viewGroup, context, device);
                        break;
                    case 5:
                        hcr = new hcp(c, O000000o2, viewGroup, context, device);
                        break;
                    case 6:
                        hcr = new hcn(c, O000000o2, viewGroup, context, device);
                        break;
                    case 7:
                        hcr = new hcq(c, O000000o2, viewGroup, context, device);
                        break;
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                        hcr = new hcs(c, O000000o2, viewGroup, context, device);
                        break;
                    case 9:
                        hcr = new hct(c, O000000o2, viewGroup, context, device);
                        break;
                    default:
                        hcr = new hcr(c, O000000o2, viewGroup, context, device);
                        break;
                }
            } else {
                hcr = new hci(c, O000000o2, viewGroup, context, device, ((hep) c).O00000o);
            }
        } catch (Exception e) {
            e.printStackTrace();
            hcr = 0;
        }
        if (hcr == 0) {
            hcr = new hcr(c, O000000o2, viewGroup, context, device);
        }
        Iterator it2 = O000000o2.iterator();
        while (it2.hasNext()) {
            ((hcf) it2.next()).O000000o((BaseCardRender) hcr);
        }
        return hcr;
    }

    private static <C extends hcc<E, T>, T, E extends hcc.O000000o<T>> ArrayList<hcf<C, E, T>> O000000o(C c, T[][] tArr, O000000o o000000o) {
        ArrayList<hcf<C, E, T>> arrayList = new ArrayList<>();
        List O00000Oo = c.O00000Oo();
        if (O00000Oo == null || tArr == null) {
            gsy.O00000Oo(LogType.CARD, "mijia-card", "createCardItem pairs null".concat(String.valueOf(O00000Oo)));
        } else if (O00000Oo.size() != tArr.length) {
            LogType logType = LogType.CARD;
            gsy.O00000Oo(logType, "mijia-card", "createCardItem pairSize:" + tArr.length + "  typeSize:" + O00000Oo.size() + "  " + O00000Oo);
        } else {
            for (int i = 0; i < O00000Oo.size(); i++) {
                arrayList.add(o000000o.createCardItem(c, (hcc.O000000o) O00000Oo.get(i), tArr[i]));
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public static <T, E extends hcc.O000000o<T>, C extends hcc<E, T>> hcf<C, E, T> O000000o(C c, E e, T[] tArr) {
        int i = e.O00000Oo;
        if (i == 6) {
            return new hcb(e, tArr);
        }
        if (i == 7) {
            return new hdm(e, tArr);
        }
        if (i == 8) {
            return new hdn(e, tArr);
        }
        switch (i) {
            case 17:
                return new hdk(e, tArr);
            case 18:
                return new hdo(e, tArr);
            case 19:
                return new hdp(e, tArr);
            case 20:
                return new hdq(e, tArr);
            default:
                if (e instanceof hed) {
                    hed hed = (hed) e;
                    String[] strArr = (String[]) tArr;
                    int i2 = hed.O00000Oo;
                    if (i2 == 1) {
                        return new heh(hed, strArr);
                    }
                    if (i2 == 2) {
                        return new hek(hed);
                    }
                    if (i2 == 3) {
                        return new hdx(hed);
                    }
                    if (i2 == 4) {
                        return new hea(hed);
                    }
                    if (i2 == 5) {
                        return new hei(hed);
                    }
                    if (i2 == 16) {
                        return new hdz(hed);
                    }
                    switch (i2) {
                        case 10:
                            return new hel(hed);
                        case 11:
                            return new hdt(hed);
                        case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT:
                            return new heg(hed);
                        case 13:
                            return new hdy(hed);
                        case 14:
                            return new hef(hed);
                        default:
                            return new hdl(hed, strArr);
                    }
                } else if (e instanceof hej) {
                    hej hej = (hej) e;
                    Spec.SpecItem[] specItemArr = (Spec.SpecItem[]) tArr;
                    int i3 = hej.O00000Oo;
                    if (i3 == 1) {
                        hey hey = new hey(hej, specItemArr);
                        hey.O0000oOO = 0;
                        return hey;
                    } else if (i3 == 2) {
                        hey hey2 = new hey(hej, specItemArr);
                        hey2.O0000oOO = 2;
                        return hey2;
                    } else if (i3 == 3) {
                        return new het(hej, specItemArr);
                    } else {
                        if (i3 == 4) {
                            return new heu(hej, specItemArr);
                        }
                        if (i3 == 5) {
                            return new hex(hej, specItemArr);
                        }
                        if (i3 == 11) {
                            return new hes(hej, specItemArr);
                        }
                        if (i3 == 12) {
                            return new hew(hej, specItemArr);
                        }
                        if (i3 == 14) {
                            return new hev(hej, specItemArr);
                        }
                        if (i3 != 101) {
                            return new hdl(hej, specItemArr);
                        }
                        hey hey3 = new hey(hej, specItemArr);
                        hey3.O0000oOO = 1;
                        return hey3;
                    }
                } else if (c.O00000Oo == 8) {
                    return new hdu((hds) e);
                } else {
                    return new hdw((hds) e);
                }
        }
    }
}

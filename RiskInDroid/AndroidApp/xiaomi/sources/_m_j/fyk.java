package _m_j;

import _m_j.fyj;
import android.util.Log;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.hzy.tvmao.KKACZipManagerV2;
import com.hzy.tvmao.ir.ac.ACModelV2;
import com.hzy.tvmao.ir.ac.ACStateV2;
import java.util.List;

public final class fyk implements fyi {

    /* renamed from: O000000o  reason: collision with root package name */
    private KKACZipManagerV2 f17409O000000o;

    public final WritableArray O0000o0o() {
        return null;
    }

    public fyk(KKACZipManagerV2 kKACZipManagerV2) {
        this.f17409O000000o = kKACZipManagerV2;
    }

    public final Object O0000o() {
        return this.f17409O000000o;
    }

    public final boolean O000000o() {
        return this.f17409O000000o.isWindSpeedCanControl();
    }

    public final boolean O00000Oo() {
        return this.f17409O000000o.getCurUDDirectType() != ACStateV2.UDWindDirectType.UDDIRECT_ONLY_SWING;
    }

    public final boolean O00000o0() {
        return this.f17409O000000o.isTempCanControl();
    }

    public final int O00000o() {
        return this.f17409O000000o.getCurModelType();
    }

    public final int O00000oO() {
        return this.f17409O000000o.getCurWindSpeed();
    }

    public final int O0000O0o() {
        return this.f17409O000000o.getCurUDDirect();
    }

    public final int O00000oo() {
        return this.f17409O000000o.getCurUDDirectType().ordinal();
    }

    public final int O0000OOo() {
        return this.f17409O000000o.getCurTemp();
    }

    public final int O0000Oo0() {
        return this.f17409O000000o.getPowerState();
    }

    public final WritableArray O0000Oo() {
        ACStateV2 aCStateV2;
        WritableArray createArray = Arguments.createArray();
        KKACZipManagerV2 kKACZipManagerV2 = this.f17409O000000o;
        if (kKACZipManagerV2 == null) {
            aCStateV2 = null;
        } else {
            aCStateV2 = new fyj.O000000o(kKACZipManagerV2, (byte) 0).O000000o();
        }
        if (aCStateV2 == null) {
            return Arguments.createArray();
        }
        for (ACModelV2 modelType : aCStateV2.getModelList()) {
            createArray.pushInt(modelType.getModelType());
        }
        return createArray;
    }

    public final WritableArray O0000OoO() {
        List<String> windSpeedList = this.f17409O000000o.getACCurModel().getWindSpeedList();
        WritableArray createArray = Arguments.createArray();
        for (String parseInt : windSpeedList) {
            try {
                createArray.pushInt(Integer.parseInt(parseInt));
            } catch (NumberFormatException e) {
                gbu.O00000o("getAllSupportWindSpeed, parse speed error:" + Log.getStackTraceString(e));
            }
        }
        return createArray;
    }

    public final WritableArray O0000Ooo() {
        List<Integer> uDWindDirectList = this.f17409O000000o.getUDWindDirectList();
        if (uDWindDirectList != null) {
            return Arguments.fromList(uDWindDirectList);
        }
        return Arguments.createArray();
    }

    public final WritableArray O0000o00() {
        return fyj.O000000o(this.f17409O000000o.getAcParams());
    }

    public final WritableArray O0000o0() {
        return fyj.O000000o(this.f17409O000000o.getACKeyIr());
    }

    public final WritableArray O0000o0O() {
        int minTemp = this.f17409O000000o.getMinTemp();
        int maxTemp = this.f17409O000000o.getMaxTemp();
        WritableArray createArray = Arguments.createArray();
        if (minTemp <= maxTemp) {
            while (minTemp <= maxTemp) {
                createArray.pushInt(minTemp);
                minTemp++;
            }
        } else {
            createArray.pushInt(minTemp);
            createArray.pushInt(maxTemp);
        }
        return createArray;
    }

    public final boolean O000000o(int i) {
        return this.f17409O000000o.changeACTargetModel(i);
    }

    public final boolean O00000Oo(int i) {
        return this.f17409O000000o.setTargetWindSpeed(i);
    }

    public final boolean O00000o0(int i) {
        return this.f17409O000000o.setTargetUDWindDirect(i);
    }

    public final boolean O00000o(int i) {
        if (i == 0) {
            this.f17409O000000o.changeUDWindDirect(ACStateV2.UDWindDirectKey.UDDIRECT_KEY_SWING);
            return true;
        } else if (i != 1) {
            gbu.O00000o("KKACZipManagerWrapper#setCurWindMode,unknown mode:".concat(String.valueOf(i)));
            return false;
        } else {
            this.f17409O000000o.changeUDWindDirect(ACStateV2.UDWindDirectKey.UDDIRECT_KEY_FIX);
            return true;
        }
    }

    public final boolean O00000oO(int i) {
        return this.f17409O000000o.setTargetTemp(i);
    }

    public final boolean O00000oo(int i) {
        if (this.f17409O000000o.getPowerState() != i) {
            this.f17409O000000o.changePowerState();
            return true;
        }
        gbu.O000000o("KKACZipManager--setCurSwitchStatus:curState = targetStatus,targetStatus:".concat(String.valueOf(i)));
        return false;
    }
}

package _m_j;

import android.util.Log;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public abstract class dnj extends dnh {
    /* access modifiers changed from: protected */
    public int O000000o(dmx dmx, float f, float f2) {
        return 2;
    }

    /* access modifiers changed from: protected */
    public int O000000o(dmx dmx, float f, int i) {
        return 2;
    }

    /* access modifiers changed from: protected */
    public int O000000o(dmx dmx, float f, String str) {
        return 2;
    }

    /* access modifiers changed from: protected */
    public int O000000o(dmx dmx, int i, float f) {
        return 2;
    }

    /* access modifiers changed from: protected */
    public int O000000o(dmx dmx, int i, int i2) {
        return 2;
    }

    /* access modifiers changed from: protected */
    public int O000000o(dmx dmx, int i, String str) {
        return 2;
    }

    /* access modifiers changed from: protected */
    public int O000000o(dmx dmx, String str, float f) {
        return 2;
    }

    /* access modifiers changed from: protected */
    public int O000000o(dmx dmx, String str, int i) {
        return 2;
    }

    /* access modifiers changed from: protected */
    public int O000000o(dmx dmx, String str, String str2) {
        return 2;
    }

    public final int O000000o(Object obj) {
        dmx dmx;
        int O000000o2 = super.O000000o(obj);
        dmx dmx2 = null;
        int i = 1;
        switch (this.O0000Oo.O000000o()) {
            case 0:
                dmx2 = O000000o(0);
                dmx = O000000o(0);
                this.O00000Oo = this.O0000Oo.O000000o();
                break;
            case 1:
                dmx2 = O000000o(0);
                dmx = O000000o(1);
                this.O00000Oo = this.O0000Oo.O000000o();
                break;
            case 2:
                dmx2 = O000000o(0);
                dmx = O000000o(2);
                this.O00000Oo = this.O0000Oo.O000000o();
                break;
            case 3:
                dmx2 = O000000o(0);
                dmx = O000000o(3);
                this.O00000Oo = this.O0000Oo.O000000o();
                break;
            case 4:
                dmx2 = O000000o(0);
                dmx = O000000o(4);
                break;
            case 5:
                dmx2 = O000000o(1);
                dmx = O000000o(0);
                this.O00000Oo = this.O0000Oo.O000000o();
                break;
            case 6:
                dmx2 = O000000o(1);
                dmx = O000000o(4);
                break;
            case 7:
                dmx2 = O000000o(2);
                dmx = O000000o(0);
                this.O00000Oo = this.O0000Oo.O000000o();
                break;
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                dmx2 = O000000o(2);
                dmx = O000000o(4);
                break;
            case 9:
                dmx2 = O000000o(3);
                dmx = O000000o(0);
                this.O00000Oo = this.O0000Oo.O000000o();
                break;
            case 10:
                dmx2 = O000000o(3);
                dmx = O000000o(4);
                break;
            case 11:
                dmx2 = O000000o(4);
                dmx = O000000o(0);
                break;
            case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                dmx2 = O000000o(4);
                dmx = O000000o(1);
                break;
            case 13:
                dmx2 = O000000o(4);
                dmx = O000000o(2);
                break;
            case 14:
                dmx2 = O000000o(4);
                dmx = O000000o(3);
                break;
            case GmsLogger.MAX_PII_TAG_LENGTH:
                dmx2 = O000000o(4);
                dmx = O000000o(4);
                break;
            default:
                dmx = null;
                break;
        }
        if (dmx2 == null || dmx == null) {
            Log.e("BinExecutor_TMTEST", "read data failed");
            return O000000o2;
        }
        dmx O000000o3 = this.O0000OoO.O000000o(this.O00000Oo);
        if (O000000o3 == null) {
            return 2;
        }
        int i2 = dmx2.O00000Oo;
        if (i2 == 1) {
            int i3 = dmx.O00000Oo;
            if (i3 == 1) {
                i = O000000o(O000000o3, dmx2.O000000o(), dmx.O000000o());
            } else if (i3 == 2) {
                i = O000000o(O000000o3, dmx2.O000000o(), dmx.O00000Oo());
            } else if (i3 != 3) {
                Log.e("BinExecutor_TMTEST", "value2 invalidate type:".concat(String.valueOf(dmx)));
            } else {
                i = O000000o(O000000o3, dmx2.O000000o(), dmx.O00000o0());
            }
        } else if (i2 == 2) {
            int i4 = dmx.O00000Oo;
            if (i4 == 1) {
                i = O000000o(O000000o3, dmx2.O00000Oo(), dmx.O000000o());
            } else if (i4 == 2) {
                i = O000000o(O000000o3, dmx2.O00000Oo(), dmx.O00000Oo());
            } else if (i4 != 3) {
                Log.e("BinExecutor_TMTEST", "value2 invalidate type:".concat(String.valueOf(dmx)));
            } else {
                i = O000000o(O000000o3, dmx2.O00000Oo(), dmx.O00000o0());
            }
        } else if (i2 != 3) {
            Log.e("BinExecutor_TMTEST", "value1 invalidate type:".concat(String.valueOf(dmx2)));
        } else {
            int i5 = dmx.O00000Oo;
            if (i5 == 1) {
                i = O000000o(O000000o3, dmx2.O00000o0(), dmx.O000000o());
            } else if (i5 == 2) {
                i = O000000o(O000000o3, dmx2.O00000o0(), dmx.O00000Oo());
            } else if (i5 != 3) {
                Log.e("BinExecutor_TMTEST", "value2 invalidate type:".concat(String.valueOf(dmx)));
            } else {
                i = O000000o(O000000o3, dmx2.O00000o0(), dmx.O00000o0());
            }
        }
        if (2 == i) {
            Log.e("BinExecutor_TMTEST", "type invalidate data1:" + dmx2 + "  data2:" + dmx);
        }
        return i;
    }
}

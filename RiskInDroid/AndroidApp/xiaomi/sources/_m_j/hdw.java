package _m_j;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.miui10.MIUI10CardActivity;
import com.xiaomi.smarthome.newui.widget.CirclePadButton;

public final class hdw extends hcf<hdr, hds, Object> {
    private CirclePadButton O0000o;
    private View O0000o0o;

    public hdw(hds hds) {
        super(hds, null);
    }

    public final void O000000o(ViewGroup viewGroup, int i, int i2) {
        super.O000000o(viewGroup, i, i2);
        this.O0000o0o = O000000o(viewGroup, (int) R.layout.card_item_mitv);
        View view = this.O0000o0o;
        if (view != null) {
            this.O0000o = (CirclePadButton) view.findViewById(R.id.circle_pad);
            CirclePadButton circlePadButton = this.O0000o;
            if (circlePadButton != null) {
                if (O00000oO().isOnline) {
                    O000000o(true);
                } else {
                    O000000o(false);
                }
                circlePadButton.setListener(new CirclePadButton.O000000o() {
                    /* class _m_j.hdw.AnonymousClass1 */

                    public final void O000000o(CirclePadButton.MODE mode) {
                        if (!hdw.this.O0000Oo0) {
                            int i = AnonymousClass3.f18826O000000o[mode.ordinal()];
                            if (i == 1) {
                                hdw.this.O00000o0("power");
                            } else if (i == 2) {
                                hdw.this.O00000o0("volumeup");
                            } else if (i == 3) {
                                hdw.this.O00000o0("volumedown");
                            }
                        }
                    }
                });
            }
        }
    }

    /* renamed from: _m_j.hdw$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f18826O000000o = new int[CirclePadButton.MODE.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            f18826O000000o[CirclePadButton.MODE.Switch.ordinal()] = 1;
            f18826O000000o[CirclePadButton.MODE.Plus.ordinal()] = 2;
            try {
                f18826O000000o[CirclePadButton.MODE.Minus.ordinal()] = 3;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public final void O00000o0() {
        super.O00000o0();
        this.O0000o0o = null;
        this.O0000o = null;
    }

    public final void O00000o0(String str) {
        O000000o(false);
        if (O00000oO().location == Device.Location.REMOTE) {
            izb.O000000o(CommonApplication.getAppContext(), (int) R.string.mitv_is_not_in_local, 0).show();
        }
        XmPluginHostApi.instance().callHttpApi("xiaomi.tv.v1", String.format("http://%s:6095/controller?action=keyevent&keycode=%s", O00000oO().ip, str), "GET", null, new Callback<Void>() {
            /* class _m_j.hdw.AnonymousClass2 */

            public final void onFailure(int i, String str) {
                if (!hdw.this.O0000Oo0) {
                    hdw.this.O00000oO().location = Device.Location.REMOTE;
                    hdw.this.O000000o(true);
                }
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                if (!hdw.this.O0000Oo0) {
                    hdw.this.O00000oO().location = Device.Location.LOCAL;
                    hdw.this.O000000o(true);
                }
            }
        }, null);
        if (!TextUtils.isEmpty(MIUI10CardActivity.sRoomName)) {
            fbq.O000000o(O00000oO().model, MIUI10CardActivity.sRoomName, fml.O000000o(O00000oO()));
        }
    }

    public final void O000000o(boolean z) {
        CirclePadButton circlePadButton = this.O0000o;
        if (circlePadButton != null) {
            circlePadButton.setTouchable(z);
            circlePadButton.O000000o(z);
        }
    }

    public final void O000000o(Object obj, Object obj2) {
        if (!this.O0000Oo0 && O00000oO() != null) {
            if (O00000oO().isOnline) {
                O000000o(true);
            } else {
                O000000o(false);
            }
        }
    }
}

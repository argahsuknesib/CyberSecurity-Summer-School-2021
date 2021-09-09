package _m_j;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.library.log.LogType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class exo extends fab {
    private static final HashMap<Integer, int[]> O00000o0;

    /* renamed from: O000000o  reason: collision with root package name */
    public volatile int f15923O000000o = 0;
    public Handler O00000Oo = new Handler() {
        /* class _m_j.exo.AnonymousClass1 */

        public final void handleMessage(Message message) {
            exo.this.O000000o(message.what);
        }
    };
    private List<O000000o> O00000o = new ArrayList();

    public interface O000000o {
        void onLoginFailed();

        void onLoginSuccess();
    }

    static {
        HashMap<Integer, int[]> hashMap = new HashMap<>();
        O00000o0 = hashMap;
        hashMap.put(1, new int[]{0, 1});
        O00000o0.put(8, new int[]{1, 2});
        O00000o0.put(5, new int[]{1, 3});
        O00000o0.put(2, new int[]{2, 4});
        O00000o0.put(7, new int[]{2, 3});
        O00000o0.put(6, new int[]{4, 3});
        O00000o0.put(4, new int[]{1, 2});
        O00000o0.put(9, new int[]{3, 2});
    }

    public final void O000000o(int i) {
        int[] iArr = O00000o0.get(Integer.valueOf(i));
        if (iArr != null && this.f15923O000000o != iArr[1]) {
            this.f15923O000000o = iArr[1];
            int i2 = this.f15923O000000o;
            if (i2 == 4 || i2 == 3) {
                gsy.O00000Oo(LogType.LOGIN, "login", "notifyLoginCallbackList state=".concat(String.valueOf(i2)));
                synchronized (this.O00000o) {
                    int i3 = 0;
                    while (i3 < this.O00000o.size()) {
                        try {
                            O000000o o000000o = this.O00000o.get(i3);
                            if (o000000o != null) {
                                if (i2 == 4) {
                                    o000000o.onLoginSuccess();
                                } else if (i2 == 3) {
                                    o000000o.onLoginFailed();
                                }
                            }
                            i3++;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    this.O00000o.clear();
                }
            }
            Intent intent = new Intent("app_state_changed");
            intent.putExtra("current_state", this.f15923O000000o);
            ft.O000000o(CommonApplication.getAppContext()).O000000o(intent);
            gsy.O000000o(6, "AppStateNotifier", "change state to " + this.f15923O000000o);
            LogType logType = LogType.LOGIN;
            gsy.O00000Oo(logType, "AppStateNotifier", "change state to " + this.f15923O000000o);
        }
    }

    public final int O000000o() {
        return this.f15923O000000o;
    }

    public final void O000000o(O000000o o000000o) {
        if (this.f15923O000000o == 4) {
            o000000o.onLoginSuccess();
        } else if (this.f15923O000000o == 3) {
            o000000o.onLoginFailed();
        } else {
            synchronized (this.O00000o) {
                if (this.f15923O000000o == 4) {
                    o000000o.onLoginSuccess();
                } else if (this.f15923O000000o == 3) {
                    o000000o.onLoginFailed();
                } else {
                    this.O00000o.add(o000000o);
                }
            }
        }
    }

    public final void O00000Oo() {
        O000000o(1);
        gsy.O00000Oo(LogType.LOGIN, "login", "AppStateNotifier onStart");
        CoreApi.O000000o().O000000o(CommonApplication.getAppContext(), new CoreApi.O0000o00() {
            /* class _m_j.exo.AnonymousClass2 */

            public final void onAccountReady(boolean z, String str) {
                if (z) {
                    if (gfr.O0000Ooo) {
                        gsy.O00000Oo(LogType.LOGIN, "login", "AppStateNotifier CoreApi isAccountReady isMiLoggedIn=".concat(String.valueOf(z)));
                    }
                    exo.this.O000000o(2);
                    return;
                }
                exo.this.O00000Oo.sendEmptyMessageDelayed(5, 500);
            }
        });
    }

    public final void O00000o0() {
        if (gfr.O0000Ooo) {
            gsy.O00000Oo(LogType.LOGIN, "login", "AppStateNotifier listenLogin MESSAGE_LOGIN_SUCCESS");
        }
        O000000o(2);
    }

    public final void O00000o() {
        O000000o(8);
        O000000o(9);
    }

    public final void O00000oO() {
        O000000o(5);
    }

    public final void O00000oo() {
        this.O00000Oo.sendEmptyMessage(7);
    }

    public final void O0000O0o() {
        O000000o(6);
    }
}

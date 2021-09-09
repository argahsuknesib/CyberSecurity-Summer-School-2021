package _m_j;

import android.content.Context;
import com.facebook.react.bridge.WritableArray;
import com.sankuai.waimai.router.annotation.RouterService;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.mitsmsdk.NfcChannelManager;

@RouterService
public class ftx implements hmn {
    private static final ftx INSTANCE = new ftx();

    @cug
    public static ftx provideInstance() {
        return INSTANCE;
    }

    public void initBandManager(Context context, String str, String str2, final Callback<Boolean> callback) {
        NfcChannelManager.getInstance().init(context, str, str2, new Callback<Boolean>() {
            /* class _m_j.ftx.AnonymousClass1 */

            public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                Boolean bool = (Boolean) obj;
                Callback callback = callback;
                if (callback != null) {
                    callback.onSuccess(bool);
                }
            }

            public final void onFailure(int i, String str) {
                Callback callback = callback;
                if (callback != null) {
                    callback.onFailure(i, str);
                }
            }
        });
    }

    public void deInitBandManager() {
        NfcChannelManager.getInstance().deInit();
    }

    public void connectBand(String str, final Callback<Integer> callback) {
        NfcChannelManager.getInstance().connectBand(str, new Callback<Integer>() {
            /* class _m_j.ftx.AnonymousClass2 */

            public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                Integer num = (Integer) obj;
                Callback callback = callback;
                if (callback != null) {
                    callback.onSuccess(num);
                }
            }

            public final void onFailure(int i, String str) {
                Callback callback = callback;
                if (callback != null) {
                    callback.onFailure(i, str);
                }
            }
        });
    }

    public void getAllNfcCards(final Callback<String> callback) {
        NfcChannelManager.getInstance().getAllCards(new Callback<String>() {
            /* class _m_j.ftx.AnonymousClass3 */

            public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                String str = (String) obj;
                Callback callback = callback;
                if (callback != null) {
                    callback.onSuccess(str);
                }
            }

            public final void onFailure(int i, String str) {
                Callback callback = callback;
                if (callback != null) {
                    callback.onFailure(i, str);
                }
            }
        });
    }

    public void issueDoorCard(final Callback<Boolean> callback) {
        NfcChannelManager.getInstance().issueDoorCard(new Callback<Boolean>() {
            /* class _m_j.ftx.AnonymousClass4 */

            public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                Boolean bool = (Boolean) obj;
                Callback callback = callback;
                if (callback != null) {
                    callback.onSuccess(bool);
                }
            }

            public final void onFailure(int i, String str) {
                Callback callback = callback;
                if (callback != null) {
                    callback.onFailure(i, str);
                }
            }
        });
    }

    public void deleteCard(String str, final Callback<Boolean> callback) {
        NfcChannelManager.getInstance().deleteCard(str, new Callback<Boolean>() {
            /* class _m_j.ftx.AnonymousClass5 */

            public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                Boolean bool = (Boolean) obj;
                Callback callback = callback;
                if (callback != null) {
                    callback.onSuccess(bool);
                }
            }

            public final void onFailure(int i, String str) {
                Callback callback = callback;
                if (callback != null) {
                    callback.onFailure(i, str);
                }
            }
        });
    }

    public void setDefaultCard(String str, final Callback<Boolean> callback) {
        NfcChannelManager.getInstance().setDefaultCard(str, new Callback<Boolean>() {
            /* class _m_j.ftx.AnonymousClass6 */

            public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                Boolean bool = (Boolean) obj;
                Callback callback = callback;
                if (callback != null) {
                    callback.onSuccess(bool);
                }
            }

            public final void onFailure(int i, String str) {
                Callback callback = callback;
                if (callback != null) {
                    callback.onFailure(i, str);
                }
            }
        });
    }

    public void updateCard(String str, final Callback<Boolean> callback) {
        NfcChannelManager.getInstance().updateCard(str, new Callback<Boolean>() {
            /* class _m_j.ftx.AnonymousClass7 */

            public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                Boolean bool = (Boolean) obj;
                Callback callback = callback;
                if (callback != null) {
                    callback.onSuccess(bool);
                }
            }

            public final void onFailure(int i, String str) {
                Callback callback = callback;
                if (callback != null) {
                    callback.onFailure(i, str);
                }
            }
        });
    }

    public void getDefaultCardAndActivateInfo(final Callback<WritableArray> callback) {
        NfcChannelManager.getInstance().getDefaultCardAndActivateInfo(new Callback<WritableArray>() {
            /* class _m_j.ftx.AnonymousClass8 */

            public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                WritableArray writableArray = (WritableArray) obj;
                Callback callback = callback;
                if (callback != null) {
                    callback.onSuccess(writableArray);
                }
            }

            public final void onFailure(int i, String str) {
                Callback callback = callback;
                if (callback != null) {
                    callback.onFailure(i, str);
                }
            }
        });
    }
}

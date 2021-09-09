package _m_j;

import _m_j.fvi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.entity.plugin.PluginDownloadTask;
import com.xiaomi.smarthome.core.entity.plugin.PluginError;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.plugin.PluginApi;
import com.xiaomi.smarthome.frame.plugin.SendMessageCallback;
import com.xiaomi.smarthome.homeroom.model.GridViewData;
import com.xiaomi.smarthome.library.log.LogType;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class frl {
    private static volatile frl O00000oo;
    private static final Object O0000O0o = new Object();

    /* renamed from: O000000o  reason: collision with root package name */
    final BroadcastReceiver f16974O000000o = new BroadcastReceiver() {
        /* class _m_j.frl.AnonymousClass1 */

        public final void onReceive(Context context, Intent intent) {
            frl.this.O00000o.removeCallbacks(frl.this.O00000Oo);
            frl.this.O00000o.postDelayed(frl.this.O00000Oo, 5000);
        }
    };
    public final Runnable O00000Oo = new Runnable() {
        /* class _m_j.frl.AnonymousClass2 */
        private String O00000Oo;
        private int O00000o0;

        public final void run() {
            String O0000OOo = ggb.O00000Oo().O0000OOo();
            int size = fno.O000000o().O00000oO().size();
            if (!TextUtils.equals(this.O00000Oo, O0000OOo) || size != this.O00000o0) {
                this.O00000Oo = O0000OOo;
                this.O00000o0 = size;
                gfx.O000000o();
                List<GridViewData> O00000o02 = gfx.O00000o0(this.O00000Oo);
                gsy.O00000o0(LogType.PLUGIN, "PluginAutoDownloadTask", "receive broadcast gridViewDataList:".concat(String.valueOf(O00000o02)));
                if (!frl.this.O00000o0.isEmpty()) {
                    gsy.O00000o0(LogType.PLUGIN, "PluginAutoDownloadTask", "waiting queue not null");
                    return;
                }
                for (GridViewData next : O00000o02) {
                    String str = null;
                    if (next.f8988O000000o == GridViewData.GridType.TYPE_IR) {
                        str = fqw.O000000o();
                    } else if (next.O00000Oo != null) {
                        str = next.O00000Oo.model;
                    }
                    if (!TextUtils.isEmpty(str) && CoreApi.O000000o().O0000Oo(str) == null) {
                        frl.this.O00000o0.offer(str);
                    }
                }
                if (frl.this.O00000o0 != null) {
                    frl.this.O00000o.sendMessage(Message.obtain(frl.this.O00000o, 1, frl.this));
                    return;
                }
                return;
            }
            LogType logType = LogType.PLUGIN;
            gsy.O00000o0(logType, "PluginAutoDownloadTask", this.O00000Oo + " receive broadcast gridViewDataList not change size" + this.O00000o0);
        }
    };
    public O000000o O00000o = new O000000o();
    public ConcurrentLinkedQueue<String> O00000o0 = new ConcurrentLinkedQueue<>();
    public boolean O00000oO = false;

    public static frl O000000o() {
        if (O00000oo == null) {
            synchronized (O0000O0o) {
                if (O00000oo == null) {
                    O00000oo = new frl();
                }
            }
        }
        return O00000oo;
    }

    private frl() {
        CoreApi.O000000o().O000000o(CommonApplication.getAppContext(), new CoreApi.O0000o0() {
            /* class _m_j.frl.AnonymousClass3 */

            public final void onCoreReady() {
                if (!frl.this.O00000oO) {
                    frl frl = frl.this;
                    ft.O000000o(CommonApplication.getAppContext()).O000000o(frl.f16974O000000o, new IntentFilter("force_update_data_completed"));
                    gsy.O00000o0(LogType.PLUGIN, "PluginAutoDownloadTask", "register broadcast");
                    fvi.O000000o().O000000o(new fvi.O00000Oo() {
                        /* class _m_j.frl.AnonymousClass5 */

                        public final void O00000Oo() {
                        }

                        public final void O000000o() {
                            if (fvi.O000000o().O00000o() && !frl.this.O00000oO) {
                                frl.this.O00000o.sendMessage(Message.obtain(frl.this.O00000o, 1, frl.this));
                            }
                        }
                    });
                }
            }
        });
    }

    public static final class O000000o extends Handler {
        O000000o() {
        }

        public final void handleMessage(Message message) {
            if (message.what == 1) {
                frl frl = (frl) message.obj;
                boolean O0000O0o = ftm.O0000O0o(CommonApplication.getAppContext());
                if (frl.O00000o0.isEmpty() || !O0000O0o || !fvi.O000000o().O00000o()) {
                    frl.O00000oO = false;
                } else {
                    String poll = frl.O00000o0.poll();
                    if (CoreApi.O000000o().O0000Oo(poll) != null) {
                        frl.O00000o.sendMessageDelayed(Message.obtain(frl.O00000o, 1, frl), 0);
                    } else {
                        PluginApi.getInstance().installPlugin(CommonApplication.getAppContext(), poll, new SendMessageCallback(poll) {
                            /* class _m_j.frl.AnonymousClass4 */

                            /* renamed from: O000000o  reason: collision with root package name */
                            final /* synthetic */ String f16978O000000o;

                            {
                                this.f16978O000000o = r2;
                            }

                            public final void onDownloadStart(String str, PluginDownloadTask pluginDownloadTask) {
                                LogType logType = LogType.PLUGIN;
                                gsy.O00000o0(logType, "PluginAutoDownloadTask", "start download - " + this.f16978O000000o);
                            }

                            public final void onDownloadFailure(PluginError pluginError) {
                                gsy.O00000o0(LogType.PLUGIN, "PluginAutoDownloadTask", "download failed error:".concat(String.valueOf(pluginError)));
                                frl.this.O00000o.sendMessageDelayed(Message.obtain(frl.this.O00000o, 1, frl.this), 1000);
                            }

                            public final void onDownloadCancel() {
                                gsy.O00000o0(LogType.PLUGIN, "PluginAutoDownloadTask", "download canceled");
                                frl.this.O00000o.sendMessageDelayed(Message.obtain(frl.this.O00000o, 1, frl.this), 1000);
                            }

                            public final void onInstallSuccess(String str) {
                                gsy.O00000o0(LogType.PLUGIN, "PluginAutoDownloadTask", "install success - ".concat(String.valueOf(str)));
                                frl.this.O00000o.sendMessageDelayed(Message.obtain(frl.this.O00000o, 1, frl.this), 1000);
                            }

                            public final void onInstallFailure(PluginError pluginError) {
                                gsy.O00000o0(LogType.PLUGIN, "PluginAutoDownloadTask", "install failed error:".concat(String.valueOf(pluginError)));
                                frl.this.O00000o.sendMessageDelayed(Message.obtain(frl.this.O00000o, 1, frl.this), 1000);
                            }
                        });
                    }
                    frl.O00000oO = true;
                }
                LogType logType = LogType.PLUGIN;
                gsy.O00000o0(logType, "PluginAutoDownloadTask", "handleMessage -  waitingDownloadQueue:" + frl.O00000o0.isEmpty() + " foreground:" + O0000O0o + " iswifi:" + fvi.O000000o().O00000o());
            }
        }
    }
}

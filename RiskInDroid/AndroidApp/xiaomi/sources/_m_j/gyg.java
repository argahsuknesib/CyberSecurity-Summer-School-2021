package _m_j;

import _m_j.fno;
import _m_j.gyd;
import _m_j.gyg;
import android.text.TextUtils;
import com.sankuai.waimai.router.annotation.RouterService;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.entity.plugin.PluginDownloadTask;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.library.log.LogType;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RouterService
public class gyg implements gyd {
    public static final String TAG = "_m_j.gyg";
    static gyg instance;
    public int mPoolSize;
    private Thread mPoolThread;
    private final LinkedList<Runnable> mTaskQueue;
    public ExecutorService mThreadPool;
    private int mType;
    List<gyf> mUpdateInfoList;

    public void isAllModelUpdateIgnoreAsync(final gyd.O00000Oo o00000Oo) {
        new Thread(new Runnable() {
            /* class _m_j.gyg.AnonymousClass1 */

            public final void run() {
                boolean isAllModelUpdateIgnore = gyg.this.isAllModelUpdateIgnore();
                gyd.O00000Oo o00000Oo = o00000Oo;
                if (o00000Oo != null) {
                    o00000Oo.onResult(isAllModelUpdateIgnore);
                }
            }
        }).start();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0046, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0048, code lost:
        return false;
     */
    public synchronized boolean isAllModelUpdateIgnore() {
        boolean z = false;
        if (this.mUpdateInfoList != null) {
            if (this.mUpdateInfoList.size() > 0) {
                int i = 0;
                while (true) {
                    if (i >= this.mUpdateInfoList.size()) {
                        z = true;
                        break;
                    }
                    gyf gyf = this.mUpdateInfoList.get(i);
                    if (!gyf.O0000OOo) {
                        try {
                            Device O000000o2 = fno.O000000o().O000000o(gyf.O00000Oo);
                            if (O000000o2 != null) {
                                if (O000000o2.isOnline) {
                                    if (!isModelUpdateIgnore(gyf.O00000Oo, gyf.O0000O0o)) {
                                        break;
                                    }
                                }
                            }
                        } catch (Exception unused) {
                            continue;
                        }
                    }
                    i++;
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0042, code lost:
        return;
     */
    public synchronized void setAllModelUpdateIgnore() {
        if (this.mUpdateInfoList != null) {
            if (this.mUpdateInfoList.size() > 0) {
                for (int i = 0; i < this.mUpdateInfoList.size(); i++) {
                    gyf gyf = this.mUpdateInfoList.get(i);
                    if (!gyf.O0000OOo) {
                        try {
                            Device O000000o2 = fno.O000000o().O000000o(gyf.O00000Oo);
                            if (O000000o2 != null) {
                                if (O000000o2.isOnline) {
                                    setModelUpdateIgnore(gyf.O00000Oo, gyf.O0000O0o);
                                }
                            }
                        } catch (Exception unused) {
                        }
                    }
                }
            }
        }
    }

    public synchronized void setAllPluginUpdateIgnore() {
        List<PluginDownloadTask> lastCheckUpdateInfos = gva.O000000o().getLastCheckUpdateInfos();
        if (lastCheckUpdateInfos != null) {
            for (PluginDownloadTask next : lastCheckUpdateInfos) {
                String str = next.f6738O000000o;
                int i = next.O00000Oo;
                if (CoreApi.O000000o().O0000Oo(str) != null) {
                    LogType logType = LogType.GENERAL;
                    String str2 = TAG;
                    gsy.O000000o(logType, str2, "setAllPluginUpdateIgnore" + str + "******" + i);
                    gpv.O00000Oo(CommonApplication.getAppContext(), "plugin_ignore_version_code_prefix_".concat(String.valueOf(str)), String.valueOf(i));
                }
            }
        }
    }

    public boolean isPluginUpdateIgnore(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String O000000o2 = gpv.O000000o(CommonApplication.getAppContext(), "plugin_ignore_version_code_prefix_".concat(String.valueOf(str)), (String) null);
        LogType logType = LogType.GENERAL;
        String str2 = TAG;
        gsy.O000000o(logType, str2, "isPluginUpdateIgnore" + str + "****** ignoreVersion   " + O000000o2 + "   currVersion" + i);
        if (TextUtils.isEmpty(O000000o2) || !O000000o2.equals(String.valueOf(i))) {
            return false;
        }
        return true;
    }

    public void setModelUpdateIgnore(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            gpv.O00000Oo(CommonApplication.getAppContext(), "model_ignore_version_code_prefix_".concat(String.valueOf(str)), str2);
        }
    }

    public boolean isModelUpdateIgnore(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String O000000o2 = gpv.O000000o(CommonApplication.getAppContext(), "model_ignore_version_code_prefix_".concat(String.valueOf(str)), (String) null);
        if (TextUtils.isEmpty(O000000o2) || !O000000o2.equals(str2)) {
            return false;
        }
        return true;
    }

    @cug
    public static gyg getInstance() {
        if (instance == null) {
            instance = new gyg(0, 1);
        }
        return instance;
    }

    gyg(int i, int i2) {
        this.mType = i == 0 ? 0 : 1;
        i2 = i2 <= 0 ? 1 : i2;
        this.mPoolSize = i2 <= 10 ? i2 : 10;
        this.mTaskQueue = new LinkedList<>();
    }

    public synchronized List<gyf> getModelUpdateInfoList() {
        return this.mUpdateInfoList;
    }

    public synchronized void batchCheckModelUpdate(final gyd.O000000o o000000o) {
        gfb.O000000o().O000000o(CommonApplication.getAppContext(), new fsm<List<gyf>, fso>() {
            /* class _m_j.gyg.AnonymousClass2 */

            public final /* synthetic */ void onSuccess(Object obj) {
                List list = (List) obj;
                gsy.O000000o(3, gyg.TAG, "onSuccess,result=".concat(String.valueOf(list)));
                if (o000000o != null) {
                    fno.O000000o().O000000o(new fno.O00000o(list, o000000o) {
                        /* class _m_j.$$Lambda$gyg$2$8K3C4nUS_6MZ84TI98csu1C77AA */
                        private final /* synthetic */ List f$1;
                        private final /* synthetic */ gyd.O000000o f$2;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                        }

                        public final void onDeviceReady(Map map) {
                            gyg.AnonymousClass2.this.O000000o(this.f$1, this.f$2, map);
                        }
                    });
                }
            }

            /* access modifiers changed from: private */
            public /* synthetic */ void O000000o(List list, gyd.O000000o o000000o, Map map) {
                gyg gyg = gyg.this;
                gyg.mUpdateInfoList = list;
                o000000o.O000000o(gyg.mUpdateInfoList);
            }

            public final void onFailure(fso fso) {
                String str = gyg.TAG;
                gsy.O000000o(3, str, "onFailure,result=" + fso.f17063O000000o);
                gyd.O000000o o000000o = o000000o;
                if (o000000o != null) {
                    o000000o.O000000o();
                }
            }
        });
    }

    public void addAsyncTask(Runnable runnable) {
        synchronized (this.mTaskQueue) {
            gsy.O000000o(3, TAG, "add task: ".concat(String.valueOf(runnable)));
            this.mTaskQueue.addLast(runnable);
        }
    }

    public Runnable getAsyncTask() {
        synchronized (this.mTaskQueue) {
            if (this.mTaskQueue.size() <= 0) {
                return null;
            }
            Runnable removeFirst = this.mType == 0 ? this.mTaskQueue.removeFirst() : this.mTaskQueue.removeLast();
            gsy.O000000o(3, TAG, "remove task: ".concat(String.valueOf(removeFirst)));
            return removeFirst;
        }
    }

    public void start() {
        if (this.mPoolThread == null) {
            this.mPoolThread = new Thread(new O000000o(this, (byte) 0));
            this.mPoolThread.start();
        }
    }

    public void stop() {
        Thread thread = this.mPoolThread;
        if (thread != null) {
            thread.interrupt();
            this.mPoolThread = null;
        }
    }

    class O000000o implements Runnable {
        private O000000o() {
        }

        /* synthetic */ O000000o(gyg gyg, byte b) {
            this();
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(6:12|13|14|15|16|26) */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0063, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0064, code lost:
            r4.f18538O000000o.mThreadPool.shutdown();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x006c, code lost:
            throw r0;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0044 */
        public final void run() {
            gsy.O000000o(3, gyg.TAG, "开始轮询");
            if (gyg.this.mThreadPool == null || gyg.this.mThreadPool.isShutdown() || gyg.this.mThreadPool.isTerminated()) {
                gyg gyg = gyg.this;
                gyg.mThreadPool = Executors.newFixedThreadPool(gyg.mPoolSize);
            }
            while (!Thread.currentThread().isInterrupted()) {
                Runnable asyncTask = gyg.this.getAsyncTask();
                if (asyncTask == null) {
                    Thread.sleep(200);
                    Thread.currentThread().interrupt();
                } else {
                    gyg.this.mThreadPool.execute(asyncTask);
                }
            }
            gyg.this.mThreadPool.shutdown();
            gsy.O000000o(3, gyg.TAG, "结束轮询");
        }
    }
}

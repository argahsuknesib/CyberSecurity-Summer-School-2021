package com.google.android.exoplayer2.offline;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.offline.DownloadManager;
import com.google.android.exoplayer2.offline.DownloadService;
import com.google.android.exoplayer2.scheduler.Requirements;
import com.google.android.exoplayer2.scheduler.Scheduler;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.NotificationUtil;
import com.google.android.exoplayer2.util.Util;
import java.util.HashMap;
import java.util.List;

public abstract class DownloadService extends Service {
    private static final HashMap<Class<? extends DownloadService>, DownloadManagerHelper> downloadManagerHelpers = new HashMap<>();
    private final int channelDescriptionResourceId;
    private final String channelId;
    private final int channelNameResourceId;
    public DownloadManager downloadManager;
    private final ForegroundNotificationUpdater foregroundNotificationUpdater;
    private boolean isDestroyed;
    private boolean isStopped;
    private int lastStartId;
    private boolean startedInForeground;
    private boolean taskRemoved;

    public static boolean needsStartedService(int i) {
        return i == 2 || i == 5 || i == 7;
    }

    /* access modifiers changed from: protected */
    public abstract DownloadManager getDownloadManager();

    /* access modifiers changed from: protected */
    public abstract Notification getForegroundNotification(List<Download> list);

    /* access modifiers changed from: protected */
    public abstract Scheduler getScheduler();

    /* access modifiers changed from: protected */
    @Deprecated
    public void onDownloadChanged(Download download) {
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public void onDownloadRemoved(Download download) {
    }

    protected DownloadService(int i) {
        this(i, 1000);
    }

    protected DownloadService(int i, long j) {
        this(i, j, null, 0, 0);
    }

    @Deprecated
    protected DownloadService(int i, long j, String str, int i2) {
        this(i, j, str, i2, 0);
    }

    protected DownloadService(int i, long j, String str, int i2, int i3) {
        if (i == 0) {
            this.foregroundNotificationUpdater = null;
            this.channelId = null;
            this.channelNameResourceId = 0;
            this.channelDescriptionResourceId = 0;
            return;
        }
        this.foregroundNotificationUpdater = new ForegroundNotificationUpdater(i, j);
        this.channelId = str;
        this.channelNameResourceId = i2;
        this.channelDescriptionResourceId = i3;
    }

    public static Intent buildAddDownloadIntent(Context context, Class<? extends DownloadService> cls, DownloadRequest downloadRequest, boolean z) {
        return buildAddDownloadIntent(context, cls, downloadRequest, 0, z);
    }

    public static Intent buildAddDownloadIntent(Context context, Class<? extends DownloadService> cls, DownloadRequest downloadRequest, int i, boolean z) {
        return getIntent(context, cls, "com.google.android.exoplayer.downloadService.action.ADD_DOWNLOAD", z).putExtra("download_request", downloadRequest).putExtra("stop_reason", i);
    }

    public static Intent buildRemoveDownloadIntent(Context context, Class<? extends DownloadService> cls, String str, boolean z) {
        return getIntent(context, cls, "com.google.android.exoplayer.downloadService.action.REMOVE_DOWNLOAD", z).putExtra("content_id", str);
    }

    public static Intent buildRemoveAllDownloadsIntent(Context context, Class<? extends DownloadService> cls, boolean z) {
        return getIntent(context, cls, "com.google.android.exoplayer.downloadService.action.REMOVE_ALL_DOWNLOADS", z);
    }

    public static Intent buildResumeDownloadsIntent(Context context, Class<? extends DownloadService> cls, boolean z) {
        return getIntent(context, cls, "com.google.android.exoplayer.downloadService.action.RESUME_DOWNLOADS", z);
    }

    public static Intent buildPauseDownloadsIntent(Context context, Class<? extends DownloadService> cls, boolean z) {
        return getIntent(context, cls, "com.google.android.exoplayer.downloadService.action.PAUSE_DOWNLOADS", z);
    }

    public static Intent buildSetStopReasonIntent(Context context, Class<? extends DownloadService> cls, String str, int i, boolean z) {
        return getIntent(context, cls, "com.google.android.exoplayer.downloadService.action.SET_STOP_REASON", z).putExtra("content_id", str).putExtra("stop_reason", i);
    }

    public static Intent buildSetRequirementsIntent(Context context, Class<? extends DownloadService> cls, Requirements requirements, boolean z) {
        return getIntent(context, cls, "com.google.android.exoplayer.downloadService.action.SET_REQUIREMENTS", z).putExtra("requirements", requirements);
    }

    public static void sendAddDownload(Context context, Class<? extends DownloadService> cls, DownloadRequest downloadRequest, boolean z) {
        startService(context, buildAddDownloadIntent(context, cls, downloadRequest, z), z);
    }

    public static void sendAddDownload(Context context, Class<? extends DownloadService> cls, DownloadRequest downloadRequest, int i, boolean z) {
        startService(context, buildAddDownloadIntent(context, cls, downloadRequest, i, z), z);
    }

    public static void sendRemoveDownload(Context context, Class<? extends DownloadService> cls, String str, boolean z) {
        startService(context, buildRemoveDownloadIntent(context, cls, str, z), z);
    }

    public static void sendRemoveAllDownloads(Context context, Class<? extends DownloadService> cls, boolean z) {
        startService(context, buildRemoveAllDownloadsIntent(context, cls, z), z);
    }

    public static void sendResumeDownloads(Context context, Class<? extends DownloadService> cls, boolean z) {
        startService(context, buildResumeDownloadsIntent(context, cls, z), z);
    }

    public static void sendPauseDownloads(Context context, Class<? extends DownloadService> cls, boolean z) {
        startService(context, buildPauseDownloadsIntent(context, cls, z), z);
    }

    public static void sendSetStopReason(Context context, Class<? extends DownloadService> cls, String str, int i, boolean z) {
        startService(context, buildSetStopReasonIntent(context, cls, str, i, z), z);
    }

    public static void sendSetRequirements(Context context, Class<? extends DownloadService> cls, Requirements requirements, boolean z) {
        startService(context, buildSetRequirementsIntent(context, cls, requirements, z), z);
    }

    public static void start(Context context, Class<? extends DownloadService> cls) {
        context.startService(getIntent(context, cls, "com.google.android.exoplayer.downloadService.action.INIT"));
    }

    public static void startForeground(Context context, Class<? extends DownloadService> cls) {
        Util.startForegroundService(context, getIntent(context, cls, "com.google.android.exoplayer.downloadService.action.INIT", true));
    }

    public void onCreate() {
        String str = this.channelId;
        if (str != null) {
            NotificationUtil.createNotificationChannel(this, str, this.channelNameResourceId, this.channelDescriptionResourceId, 2);
        }
        Class<?> cls = getClass();
        DownloadManagerHelper downloadManagerHelper = downloadManagerHelpers.get(cls);
        if (downloadManagerHelper == null) {
            boolean z = this.foregroundNotificationUpdater != null;
            Scheduler scheduler = z ? getScheduler() : null;
            this.downloadManager = getDownloadManager();
            this.downloadManager.resumeDownloads();
            downloadManagerHelper = new DownloadManagerHelper(getApplicationContext(), this.downloadManager, z, scheduler, cls);
            downloadManagerHelpers.put(cls, downloadManagerHelper);
        } else {
            this.downloadManager = downloadManagerHelper.downloadManager;
        }
        downloadManagerHelper.attachService(this);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public int onStartCommand(Intent intent, int i, int i2) {
        String str;
        char c;
        ForegroundNotificationUpdater foregroundNotificationUpdater2;
        this.lastStartId = i2;
        this.taskRemoved = false;
        String str2 = null;
        if (intent != null) {
            str2 = intent.getAction();
            str = intent.getStringExtra("content_id");
            this.startedInForeground |= intent.getBooleanExtra("foreground", false) || "com.google.android.exoplayer.downloadService.action.RESTART".equals(str2);
        } else {
            str = null;
        }
        if (str2 == null) {
            str2 = "com.google.android.exoplayer.downloadService.action.INIT";
        }
        DownloadManager downloadManager2 = (DownloadManager) Assertions.checkNotNull(this.downloadManager);
        switch (str2.hashCode()) {
            case -1931239035:
                if (str2.equals("com.google.android.exoplayer.downloadService.action.ADD_DOWNLOAD")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -932047176:
                if (str2.equals("com.google.android.exoplayer.downloadService.action.RESUME_DOWNLOADS")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case -871181424:
                if (str2.equals("com.google.android.exoplayer.downloadService.action.RESTART")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -650547439:
                if (str2.equals("com.google.android.exoplayer.downloadService.action.REMOVE_ALL_DOWNLOADS")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case -119057172:
                if (str2.equals("com.google.android.exoplayer.downloadService.action.SET_REQUIREMENTS")) {
                    c = 8;
                    break;
                }
                c = 65535;
                break;
            case 191112771:
                if (str2.equals("com.google.android.exoplayer.downloadService.action.PAUSE_DOWNLOADS")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 671523141:
                if (str2.equals("com.google.android.exoplayer.downloadService.action.SET_STOP_REASON")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case 1015676687:
                if (str2.equals("com.google.android.exoplayer.downloadService.action.INIT")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 1547520644:
                if (str2.equals("com.google.android.exoplayer.downloadService.action.REMOVE_DOWNLOAD")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
            case 1:
                break;
            case 2:
                DownloadRequest downloadRequest = (DownloadRequest) ((Intent) Assertions.checkNotNull(intent)).getParcelableExtra("download_request");
                if (downloadRequest != null) {
                    downloadManager2.addDownload(downloadRequest, intent.getIntExtra("stop_reason", 0));
                    break;
                } else {
                    Log.e("DownloadService", "Ignored ADD_DOWNLOAD: Missing download_request extra");
                    break;
                }
            case 3:
                if (str != null) {
                    downloadManager2.removeDownload(str);
                    break;
                } else {
                    Log.e("DownloadService", "Ignored REMOVE_DOWNLOAD: Missing content_id extra");
                    break;
                }
            case 4:
                downloadManager2.removeAllDownloads();
                break;
            case 5:
                downloadManager2.resumeDownloads();
                break;
            case 6:
                downloadManager2.pauseDownloads();
                break;
            case 7:
                if (((Intent) Assertions.checkNotNull(intent)).hasExtra("stop_reason")) {
                    downloadManager2.setStopReason(str, intent.getIntExtra("stop_reason", 0));
                    break;
                } else {
                    Log.e("DownloadService", "Ignored SET_STOP_REASON: Missing stop_reason extra");
                    break;
                }
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                Requirements requirements = (Requirements) ((Intent) Assertions.checkNotNull(intent)).getParcelableExtra("requirements");
                if (requirements != null) {
                    downloadManager2.setRequirements(requirements);
                    break;
                } else {
                    Log.e("DownloadService", "Ignored SET_REQUIREMENTS: Missing requirements extra");
                    break;
                }
            default:
                Log.e("DownloadService", "Ignored unrecognized action: ".concat(String.valueOf(str2)));
                break;
        }
        if (Util.SDK_INT >= 26 && this.startedInForeground && (foregroundNotificationUpdater2 = this.foregroundNotificationUpdater) != null) {
            foregroundNotificationUpdater2.showNotificationIfNotAlready();
        }
        this.isStopped = false;
        if (downloadManager2.isIdle()) {
            stop();
        }
        return 1;
    }

    public void onTaskRemoved(Intent intent) {
        this.taskRemoved = true;
    }

    public void onDestroy() {
        this.isDestroyed = true;
        ((DownloadManagerHelper) Assertions.checkNotNull(downloadManagerHelpers.get(getClass()))).detachService(this);
        ForegroundNotificationUpdater foregroundNotificationUpdater2 = this.foregroundNotificationUpdater;
        if (foregroundNotificationUpdater2 != null) {
            foregroundNotificationUpdater2.stopPeriodicUpdates();
        }
    }

    public final IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: protected */
    public final void invalidateForegroundNotification() {
        ForegroundNotificationUpdater foregroundNotificationUpdater2 = this.foregroundNotificationUpdater;
        if (foregroundNotificationUpdater2 != null && !this.isDestroyed) {
            foregroundNotificationUpdater2.invalidate();
        }
    }

    public void notifyDownloads(List<Download> list) {
        if (this.foregroundNotificationUpdater != null) {
            for (int i = 0; i < list.size(); i++) {
                if (needsStartedService(list.get(i).state)) {
                    this.foregroundNotificationUpdater.startPeriodicUpdates();
                    return;
                }
            }
        }
    }

    public void notifyDownloadChanged(Download download) {
        onDownloadChanged(download);
        if (this.foregroundNotificationUpdater == null) {
            return;
        }
        if (needsStartedService(download.state)) {
            this.foregroundNotificationUpdater.startPeriodicUpdates();
        } else {
            this.foregroundNotificationUpdater.invalidate();
        }
    }

    public void notifyDownloadRemoved(Download download) {
        onDownloadRemoved(download);
        ForegroundNotificationUpdater foregroundNotificationUpdater2 = this.foregroundNotificationUpdater;
        if (foregroundNotificationUpdater2 != null) {
            foregroundNotificationUpdater2.invalidate();
        }
    }

    public boolean isStopped() {
        return this.isStopped;
    }

    public void stop() {
        ForegroundNotificationUpdater foregroundNotificationUpdater2 = this.foregroundNotificationUpdater;
        if (foregroundNotificationUpdater2 != null) {
            foregroundNotificationUpdater2.stopPeriodicUpdates();
        }
        if (Util.SDK_INT >= 28 || !this.taskRemoved) {
            this.isStopped |= stopSelfResult(this.lastStartId);
            return;
        }
        stopSelf();
        this.isStopped = true;
    }

    private static Intent getIntent(Context context, Class<? extends DownloadService> cls, String str, boolean z) {
        return getIntent(context, cls, str).putExtra("foreground", z);
    }

    public static Intent getIntent(Context context, Class<? extends DownloadService> cls, String str) {
        return new Intent(context, cls).setAction(str);
    }

    private static void startService(Context context, Intent intent, boolean z) {
        if (z) {
            Util.startForegroundService(context, intent);
        } else {
            context.startService(intent);
        }
    }

    final class ForegroundNotificationUpdater {
        private final Handler handler = new Handler(Looper.getMainLooper());
        private boolean notificationDisplayed;
        private final int notificationId;
        private boolean periodicUpdatesStarted;
        private final long updateInterval;

        public ForegroundNotificationUpdater(int i, long j) {
            this.notificationId = i;
            this.updateInterval = j;
        }

        public final void startPeriodicUpdates() {
            this.periodicUpdatesStarted = true;
            update();
        }

        public final void stopPeriodicUpdates() {
            this.periodicUpdatesStarted = false;
            this.handler.removeCallbacksAndMessages(null);
        }

        public final void showNotificationIfNotAlready() {
            if (!this.notificationDisplayed) {
                update();
            }
        }

        public final void invalidate() {
            if (this.notificationDisplayed) {
                update();
            }
        }

        /* access modifiers changed from: private */
        public void update() {
            List<Download> currentDownloads = ((DownloadManager) Assertions.checkNotNull(DownloadService.this.downloadManager)).getCurrentDownloads();
            DownloadService downloadService = DownloadService.this;
            downloadService.startForeground(this.notificationId, downloadService.getForegroundNotification(currentDownloads));
            this.notificationDisplayed = true;
            if (this.periodicUpdatesStarted) {
                this.handler.removeCallbacksAndMessages(null);
                this.handler.postDelayed(new Runnable() {
                    /* class com.google.android.exoplayer2.offline.$$Lambda$DownloadService$ForegroundNotificationUpdater$eUq1qNHKGaEQxl_qKPR_tfIa8c */

                    public final void run() {
                        DownloadService.ForegroundNotificationUpdater.this.update();
                    }
                }, this.updateInterval);
            }
        }
    }

    static final class DownloadManagerHelper implements DownloadManager.Listener {
        private final Context context;
        public final DownloadManager downloadManager;
        private DownloadService downloadService;
        private final boolean foregroundAllowed;
        private final Scheduler scheduler;
        private final Class<? extends DownloadService> serviceClass;

        public /* synthetic */ void onDownloadsPausedChanged(DownloadManager downloadManager2, boolean z) {
            DownloadManager.Listener.CC.$default$onDownloadsPausedChanged(this, downloadManager2, z);
        }

        public /* synthetic */ void onRequirementsStateChanged(DownloadManager downloadManager2, Requirements requirements, int i) {
            DownloadManager.Listener.CC.$default$onRequirementsStateChanged(this, downloadManager2, requirements, i);
        }

        private DownloadManagerHelper(Context context2, DownloadManager downloadManager2, boolean z, Scheduler scheduler2, Class<? extends DownloadService> cls) {
            this.context = context2;
            this.downloadManager = downloadManager2;
            this.foregroundAllowed = z;
            this.scheduler = scheduler2;
            this.serviceClass = cls;
            downloadManager2.addListener(this);
            updateScheduler();
        }

        public final void attachService(DownloadService downloadService2) {
            Assertions.checkState(this.downloadService == null);
            this.downloadService = downloadService2;
            if (this.downloadManager.isInitialized()) {
                Util.createHandler().postAtFrontOfQueue(new Runnable(downloadService2) {
                    /* class com.google.android.exoplayer2.offline.$$Lambda$DownloadService$DownloadManagerHelper$Xq9wBYIDnVco2tFdAraQ883Ld78 */
                    private final /* synthetic */ DownloadService f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        DownloadService.DownloadManagerHelper.this.lambda$attachService$0$DownloadService$DownloadManagerHelper(this.f$1);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$attachService$0$DownloadService$DownloadManagerHelper(DownloadService downloadService2) {
            downloadService2.notifyDownloads(this.downloadManager.getCurrentDownloads());
        }

        public final void detachService(DownloadService downloadService2) {
            Assertions.checkState(this.downloadService == downloadService2);
            this.downloadService = null;
            if (this.scheduler != null && !this.downloadManager.isWaitingForRequirements()) {
                this.scheduler.cancel();
            }
        }

        public final void onInitialized(DownloadManager downloadManager2) {
            DownloadService downloadService2 = this.downloadService;
            if (downloadService2 != null) {
                downloadService2.notifyDownloads(downloadManager2.getCurrentDownloads());
            }
        }

        public final void onDownloadChanged(DownloadManager downloadManager2, Download download) {
            DownloadService downloadService2 = this.downloadService;
            if (downloadService2 != null) {
                downloadService2.notifyDownloadChanged(download);
            }
            if (serviceMayNeedRestart() && DownloadService.needsStartedService(download.state)) {
                Log.w("DownloadService", "DownloadService wasn't running. Restarting.");
                restartService();
            }
        }

        public final void onDownloadRemoved(DownloadManager downloadManager2, Download download) {
            DownloadService downloadService2 = this.downloadService;
            if (downloadService2 != null) {
                downloadService2.notifyDownloadRemoved(download);
            }
        }

        public final void onIdle(DownloadManager downloadManager2) {
            DownloadService downloadService2 = this.downloadService;
            if (downloadService2 != null) {
                downloadService2.stop();
            }
        }

        public final void onWaitingForRequirementsChanged(DownloadManager downloadManager2, boolean z) {
            if (!z && !downloadManager2.getDownloadsPaused() && serviceMayNeedRestart()) {
                List<Download> currentDownloads = downloadManager2.getCurrentDownloads();
                int i = 0;
                while (true) {
                    if (i >= currentDownloads.size()) {
                        break;
                    } else if (currentDownloads.get(i).state == 0) {
                        restartService();
                        break;
                    } else {
                        i++;
                    }
                }
            }
            updateScheduler();
        }

        private boolean serviceMayNeedRestart() {
            DownloadService downloadService2 = this.downloadService;
            return downloadService2 == null || downloadService2.isStopped();
        }

        private void restartService() {
            if (this.foregroundAllowed) {
                Util.startForegroundService(this.context, DownloadService.getIntent(this.context, this.serviceClass, "com.google.android.exoplayer.downloadService.action.RESTART"));
                return;
            }
            try {
                this.context.startService(DownloadService.getIntent(this.context, this.serviceClass, "com.google.android.exoplayer.downloadService.action.INIT"));
            } catch (IllegalArgumentException unused) {
                Log.w("DownloadService", "Failed to restart DownloadService (process is idle).");
            }
        }

        private void updateScheduler() {
            if (this.scheduler != null) {
                if (this.downloadManager.isWaitingForRequirements()) {
                    String packageName = this.context.getPackageName();
                    if (!this.scheduler.schedule(this.downloadManager.getRequirements(), packageName, "com.google.android.exoplayer.downloadService.action.RESTART")) {
                        Log.e("DownloadService", "Scheduling downloads failed.");
                        return;
                    }
                    return;
                }
                this.scheduler.cancel();
            }
        }
    }
}

package com.google.android.exoplayer2.ui;

import _m_j.a;
import _m_j.gh;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.media.session.MediaSessionCompat;
import androidx.core.app.NotificationCompat;
import com.google.android.exoplayer2.ControlDispatcher;
import com.google.android.exoplayer2.DefaultControlDispatcher;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.PlaybackPreparer;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.NotificationUtil;
import com.google.android.exoplayer2.util.Util;
import com.xiaomi.smarthome.R;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayerNotificationManager {
    private static int instanceIdCounter;
    private int badgeIconType;
    private NotificationCompat.Builder builder;
    private List<NotificationCompat.O000000o> builderActions;
    private final String channelId;
    private int color;
    private boolean colorized;
    private final Context context;
    public ControlDispatcher controlDispatcher;
    private int currentNotificationTag;
    public final CustomActionReceiver customActionReceiver;
    public final Map<String, NotificationCompat.O000000o> customActions;
    private int defaults;
    private final PendingIntent dismissPendingIntent;
    public final int instanceId;
    private final IntentFilter intentFilter;
    public boolean isNotificationStarted;
    private final Handler mainHandler;
    private final MediaDescriptionAdapter mediaDescriptionAdapter;
    private MediaSessionCompat.Token mediaSessionToken;
    private final NotificationBroadcastReceiver notificationBroadcastReceiver;
    private final int notificationId;
    private NotificationListener notificationListener;
    private final a notificationManager;
    private final Map<String, NotificationCompat.O000000o> playbackActions;
    public PlaybackPreparer playbackPreparer;
    public Player player;
    private final Player.EventListener playerListener;
    private int priority;
    private int smallIconResourceId;
    private boolean useChronometer;
    private boolean useNavigationActions;
    private boolean useNavigationActionsInCompactView;
    private boolean usePlayPauseActions;
    private boolean useStopAction;
    private int visibility;
    private final Timeline.Window window;

    public interface CustomActionReceiver {
        Map<String, NotificationCompat.O000000o> createCustomActions(Context context, int i);

        List<String> getCustomActions(Player player);

        void onCustomAction(Player player, String str, Intent intent);
    }

    public interface MediaDescriptionAdapter {

        /* renamed from: com.google.android.exoplayer2.ui.PlayerNotificationManager$MediaDescriptionAdapter$-CC  reason: invalid class name */
        public final /* synthetic */ class CC {
            public static CharSequence $default$getCurrentSubText(MediaDescriptionAdapter mediaDescriptionAdapter, Player player) {
                return null;
            }
        }

        PendingIntent createCurrentContentIntent(Player player);

        CharSequence getCurrentContentText(Player player);

        CharSequence getCurrentContentTitle(Player player);

        Bitmap getCurrentLargeIcon(Player player, BitmapCallback bitmapCallback);

        CharSequence getCurrentSubText(Player player);
    }

    public interface NotificationListener {

        /* renamed from: com.google.android.exoplayer2.ui.PlayerNotificationManager$NotificationListener$-CC  reason: invalid class name */
        public final /* synthetic */ class CC {
            @Deprecated
            public static void $default$onNotificationCancelled(NotificationListener notificationListener, int i) {
            }

            public static void $default$onNotificationCancelled(NotificationListener notificationListener, int i, boolean z) {
            }

            public static void $default$onNotificationPosted(NotificationListener notificationListener, int i, Notification notification, boolean z) {
            }

            @Deprecated
            public static void $default$onNotificationStarted(NotificationListener notificationListener, int i, Notification notification) {
            }
        }

        @Deprecated
        void onNotificationCancelled(int i);

        void onNotificationCancelled(int i, boolean z);

        void onNotificationPosted(int i, Notification notification, boolean z);

        @Deprecated
        void onNotificationStarted(int i, Notification notification);
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Priority {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Visibility {
    }

    public final class BitmapCallback {
        private final int notificationTag;

        private BitmapCallback(int i) {
            this.notificationTag = i;
        }

        public final void onBitmap(Bitmap bitmap) {
            if (bitmap != null) {
                PlayerNotificationManager.this.postUpdateNotificationBitmap(bitmap, this.notificationTag);
            }
        }
    }

    @Deprecated
    public static PlayerNotificationManager createWithNotificationChannel(Context context2, String str, int i, int i2, MediaDescriptionAdapter mediaDescriptionAdapter2) {
        return createWithNotificationChannel(context2, str, i, 0, i2, mediaDescriptionAdapter2);
    }

    public static PlayerNotificationManager createWithNotificationChannel(Context context2, String str, int i, int i2, int i3, MediaDescriptionAdapter mediaDescriptionAdapter2) {
        NotificationUtil.createNotificationChannel(context2, str, i, i2, 2);
        return new PlayerNotificationManager(context2, str, i3, mediaDescriptionAdapter2);
    }

    @Deprecated
    public static PlayerNotificationManager createWithNotificationChannel(Context context2, String str, int i, int i2, MediaDescriptionAdapter mediaDescriptionAdapter2, NotificationListener notificationListener2) {
        return createWithNotificationChannel(context2, str, i, 0, i2, mediaDescriptionAdapter2, notificationListener2);
    }

    public static PlayerNotificationManager createWithNotificationChannel(Context context2, String str, int i, int i2, int i3, MediaDescriptionAdapter mediaDescriptionAdapter2, NotificationListener notificationListener2) {
        NotificationUtil.createNotificationChannel(context2, str, i, i2, 2);
        return new PlayerNotificationManager(context2, str, i3, mediaDescriptionAdapter2, notificationListener2);
    }

    public PlayerNotificationManager(Context context2, String str, int i, MediaDescriptionAdapter mediaDescriptionAdapter2) {
        this(context2, str, i, mediaDescriptionAdapter2, null, null);
    }

    public PlayerNotificationManager(Context context2, String str, int i, MediaDescriptionAdapter mediaDescriptionAdapter2, NotificationListener notificationListener2) {
        this(context2, str, i, mediaDescriptionAdapter2, notificationListener2, null);
    }

    public PlayerNotificationManager(Context context2, String str, int i, MediaDescriptionAdapter mediaDescriptionAdapter2, CustomActionReceiver customActionReceiver2) {
        this(context2, str, i, mediaDescriptionAdapter2, null, customActionReceiver2);
    }

    public PlayerNotificationManager(Context context2, String str, int i, MediaDescriptionAdapter mediaDescriptionAdapter2, NotificationListener notificationListener2, CustomActionReceiver customActionReceiver2) {
        Map<String, NotificationCompat.O000000o> map;
        Context applicationContext = context2.getApplicationContext();
        this.context = applicationContext;
        this.channelId = str;
        this.notificationId = i;
        this.mediaDescriptionAdapter = mediaDescriptionAdapter2;
        this.notificationListener = notificationListener2;
        this.customActionReceiver = customActionReceiver2;
        this.controlDispatcher = new DefaultControlDispatcher();
        this.window = new Timeline.Window();
        int i2 = instanceIdCounter;
        instanceIdCounter = i2 + 1;
        this.instanceId = i2;
        this.mainHandler = Util.createHandler(Looper.getMainLooper(), new Handler.Callback() {
            /* class com.google.android.exoplayer2.ui.$$Lambda$PlayerNotificationManager$S3i9ukqX74X9NHVfovI_cIquQsY */

            public final boolean handleMessage(Message message) {
                return PlayerNotificationManager.this.lambda$new$0$PlayerNotificationManager(message);
            }
        });
        this.notificationManager = a.O000000o(applicationContext);
        this.playerListener = new PlayerListener();
        this.notificationBroadcastReceiver = new NotificationBroadcastReceiver();
        this.intentFilter = new IntentFilter();
        this.useNavigationActions = true;
        this.usePlayPauseActions = true;
        this.colorized = true;
        this.useChronometer = true;
        this.color = 0;
        this.smallIconResourceId = R.drawable.exo_notification_small_icon;
        this.defaults = 0;
        this.priority = -1;
        this.badgeIconType = 1;
        this.visibility = 1;
        this.playbackActions = createPlaybackActions(applicationContext, this.instanceId);
        for (String addAction : this.playbackActions.keySet()) {
            this.intentFilter.addAction(addAction);
        }
        if (customActionReceiver2 != null) {
            map = customActionReceiver2.createCustomActions(applicationContext, this.instanceId);
        } else {
            map = Collections.emptyMap();
        }
        this.customActions = map;
        for (String addAction2 : this.customActions.keySet()) {
            this.intentFilter.addAction(addAction2);
        }
        this.dismissPendingIntent = createBroadcastIntent("com.google.android.exoplayer.dismiss", applicationContext, this.instanceId);
        this.intentFilter.addAction("com.google.android.exoplayer.dismiss");
    }

    public final void setPlayer(Player player2) {
        boolean z = true;
        Assertions.checkState(Looper.myLooper() == Looper.getMainLooper());
        if (!(player2 == null || player2.getApplicationLooper() == Looper.getMainLooper())) {
            z = false;
        }
        Assertions.checkArgument(z);
        Player player3 = this.player;
        if (player3 != player2) {
            if (player3 != null) {
                player3.removeListener(this.playerListener);
                if (player2 == null) {
                    stopNotification(false);
                }
            }
            this.player = player2;
            if (player2 != null) {
                player2.addListener(this.playerListener);
                postStartOrUpdateNotification();
            }
        }
    }

    public void setPlaybackPreparer(PlaybackPreparer playbackPreparer2) {
        this.playbackPreparer = playbackPreparer2;
    }

    public final void setControlDispatcher(ControlDispatcher controlDispatcher2) {
        if (this.controlDispatcher != controlDispatcher2) {
            this.controlDispatcher = controlDispatcher2;
            invalidate();
        }
    }

    @Deprecated
    public final void setNotificationListener(NotificationListener notificationListener2) {
        this.notificationListener = notificationListener2;
    }

    @Deprecated
    public final void setFastForwardIncrementMs(long j) {
        ControlDispatcher controlDispatcher2 = this.controlDispatcher;
        if (controlDispatcher2 instanceof DefaultControlDispatcher) {
            ((DefaultControlDispatcher) controlDispatcher2).setFastForwardIncrementMs(j);
            invalidate();
        }
    }

    @Deprecated
    public final void setRewindIncrementMs(long j) {
        ControlDispatcher controlDispatcher2 = this.controlDispatcher;
        if (controlDispatcher2 instanceof DefaultControlDispatcher) {
            ((DefaultControlDispatcher) controlDispatcher2).setRewindIncrementMs(j);
            invalidate();
        }
    }

    public final void setUseNavigationActions(boolean z) {
        if (this.useNavigationActions != z) {
            this.useNavigationActions = z;
            invalidate();
        }
    }

    public final void setUseNavigationActionsInCompactView(boolean z) {
        if (this.useNavigationActionsInCompactView != z) {
            this.useNavigationActionsInCompactView = z;
            invalidate();
        }
    }

    public final void setUsePlayPauseActions(boolean z) {
        if (this.usePlayPauseActions != z) {
            this.usePlayPauseActions = z;
            invalidate();
        }
    }

    public final void setUseStopAction(boolean z) {
        if (this.useStopAction != z) {
            this.useStopAction = z;
            invalidate();
        }
    }

    public final void setMediaSessionToken(MediaSessionCompat.Token token) {
        if (!Util.areEqual(this.mediaSessionToken, token)) {
            this.mediaSessionToken = token;
            invalidate();
        }
    }

    public final void setBadgeIconType(int i) {
        if (this.badgeIconType != i) {
            if (i == 0 || i == 1 || i == 2) {
                this.badgeIconType = i;
                invalidate();
                return;
            }
            throw new IllegalArgumentException();
        }
    }

    public final void setColorized(boolean z) {
        if (this.colorized != z) {
            this.colorized = z;
            invalidate();
        }
    }

    public final void setDefaults(int i) {
        if (this.defaults != i) {
            this.defaults = i;
            invalidate();
        }
    }

    public final void setColor(int i) {
        if (this.color != i) {
            this.color = i;
            invalidate();
        }
    }

    public final void setPriority(int i) {
        if (this.priority != i) {
            if (i == -2 || i == -1 || i == 0 || i == 1 || i == 2) {
                this.priority = i;
                invalidate();
                return;
            }
            throw new IllegalArgumentException();
        }
    }

    public final void setSmallIcon(int i) {
        if (this.smallIconResourceId != i) {
            this.smallIconResourceId = i;
            invalidate();
        }
    }

    public final void setUseChronometer(boolean z) {
        if (this.useChronometer != z) {
            this.useChronometer = z;
            invalidate();
        }
    }

    public final void setVisibility(int i) {
        if (this.visibility != i) {
            if (i == -1 || i == 0 || i == 1) {
                this.visibility = i;
                invalidate();
                return;
            }
            throw new IllegalStateException();
        }
    }

    public void invalidate() {
        if (this.isNotificationStarted) {
            postStartOrUpdateNotification();
        }
    }

    private void startOrUpdateNotification(Player player2, Bitmap bitmap) {
        boolean ongoing = getOngoing(player2);
        this.builder = createNotification(player2, this.builder, ongoing, bitmap);
        NotificationCompat.Builder builder2 = this.builder;
        boolean z = false;
        if (builder2 == null) {
            stopNotification(false);
            return;
        }
        Notification O00000o = builder2.O00000o();
        a aVar = this.notificationManager;
        int i = this.notificationId;
        Bundle O000000o2 = NotificationCompat.O000000o(O00000o);
        if (O000000o2 != null && O000000o2.getBoolean("android.support.useSideChannel")) {
            z = true;
        }
        if (z) {
            aVar.O000000o(new a.O00000Oo(aVar.f12348O000000o.getPackageName(), i, null, O00000o));
            aVar.O00000Oo.cancel(null, i);
        } else {
            aVar.O00000Oo.notify(null, i, O00000o);
        }
        if (!this.isNotificationStarted) {
            this.isNotificationStarted = true;
            this.context.registerReceiver(this.notificationBroadcastReceiver, this.intentFilter);
            NotificationListener notificationListener2 = this.notificationListener;
            if (notificationListener2 != null) {
                notificationListener2.onNotificationStarted(this.notificationId, O00000o);
            }
        }
        NotificationListener notificationListener3 = this.notificationListener;
        if (notificationListener3 != null) {
            notificationListener3.onNotificationPosted(this.notificationId, O00000o, ongoing);
        }
    }

    public void stopNotification(boolean z) {
        if (this.isNotificationStarted) {
            this.isNotificationStarted = false;
            this.mainHandler.removeMessages(0);
            a aVar = this.notificationManager;
            int i = this.notificationId;
            aVar.O00000Oo.cancel(null, i);
            if (Build.VERSION.SDK_INT <= 19) {
                aVar.O000000o(new a.O000000o(aVar.f12348O000000o.getPackageName(), i, null));
            }
            this.context.unregisterReceiver(this.notificationBroadcastReceiver);
            NotificationListener notificationListener2 = this.notificationListener;
            if (notificationListener2 != null) {
                notificationListener2.onNotificationCancelled(this.notificationId, z);
                this.notificationListener.onNotificationCancelled(this.notificationId);
            }
        }
    }

    /* access modifiers changed from: protected */
    public NotificationCompat.Builder createNotification(Player player2, NotificationCompat.Builder builder2, boolean z, Bitmap bitmap) {
        NotificationCompat.O000000o o000000o;
        if (player2.getPlaybackState() != 1 || (!player2.getCurrentTimeline().isEmpty() && this.playbackPreparer != null)) {
            List<String> actions = getActions(player2);
            ArrayList arrayList = new ArrayList(actions.size());
            for (int i = 0; i < actions.size(); i++) {
                String str = actions.get(i);
                if (this.playbackActions.containsKey(str)) {
                    o000000o = this.playbackActions.get(str);
                } else {
                    o000000o = this.customActions.get(str);
                }
                if (o000000o != null) {
                    arrayList.add(o000000o);
                }
            }
            if (builder2 == null || !arrayList.equals(this.builderActions)) {
                builder2 = new NotificationCompat.Builder(this.context, this.channelId);
                this.builderActions = arrayList;
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    builder2.O00000Oo.add((NotificationCompat.O000000o) arrayList.get(i2));
                }
            }
            gh.O000000o o000000o2 = new gh.O000000o();
            MediaSessionCompat.Token token = this.mediaSessionToken;
            if (token != null) {
                o000000o2.O00000oo = token;
            }
            o000000o2.O00000oO = getActionIndicesForCompactView(actions, player2);
            boolean z2 = !z;
            if (Build.VERSION.SDK_INT < 21) {
                o000000o2.O0000O0o = z2;
            }
            o000000o2.O0000OOo = this.dismissPendingIntent;
            builder2.O000000o(o000000o2);
            builder2.O000000o(this.dismissPendingIntent);
            builder2.O000OO0o = this.badgeIconType;
            builder2.O000000o(2, z);
            builder2.O000O0Oo = this.color;
            builder2.O00oOooO = this.colorized;
            builder2.O00oOooo = true;
            NotificationCompat.Builder O000000o2 = builder2.O000000o(this.smallIconResourceId);
            O000000o2.O00oOoOo = this.visibility;
            O000000o2.O0000Ooo = this.priority;
            O000000o2.O00000Oo(this.defaults);
            if (Util.SDK_INT < 21 || !this.useChronometer || !player2.isPlaying() || player2.isPlayingAd() || player2.isCurrentWindowDynamic() || player2.getPlaybackParameters().speed != 1.0f) {
                builder2.O0000o00 = false;
                builder2.O0000o0 = false;
            } else {
                NotificationCompat.Builder O000000o3 = builder2.O000000o(System.currentTimeMillis() - player2.getContentPosition());
                O000000o3.O0000o00 = true;
                O000000o3.O0000o0 = true;
            }
            builder2.O000000o(this.mediaDescriptionAdapter.getCurrentContentTitle(player2));
            builder2.O00000Oo(this.mediaDescriptionAdapter.getCurrentContentText(player2));
            builder2.O00000o0(this.mediaDescriptionAdapter.getCurrentSubText(player2));
            if (bitmap == null) {
                MediaDescriptionAdapter mediaDescriptionAdapter2 = this.mediaDescriptionAdapter;
                int i3 = this.currentNotificationTag + 1;
                this.currentNotificationTag = i3;
                bitmap = mediaDescriptionAdapter2.getCurrentLargeIcon(player2, new BitmapCallback(i3));
            }
            setLargeIcon(builder2, bitmap);
            builder2.O00000oo = this.mediaDescriptionAdapter.createCurrentContentIntent(player2);
            return builder2;
        }
        this.builderActions = null;
        return null;
    }

    /* access modifiers changed from: protected */
    public List<String> getActions(Player player2) {
        boolean z;
        boolean z2;
        boolean z3;
        Timeline currentTimeline = player2.getCurrentTimeline();
        boolean z4 = false;
        if (currentTimeline.isEmpty() || player2.isPlayingAd()) {
            z3 = false;
            z2 = false;
            z = false;
        } else {
            currentTimeline.getWindow(player2.getCurrentWindowIndex(), this.window);
            z3 = this.window.isSeekable || !this.window.isDynamic || player2.hasPrevious();
            boolean isRewindEnabled = this.controlDispatcher.isRewindEnabled();
            z = this.controlDispatcher.isFastForwardEnabled();
            if (this.window.isDynamic || player2.hasNext()) {
                z4 = true;
            }
            z2 = z4;
            z4 = isRewindEnabled;
        }
        ArrayList arrayList = new ArrayList();
        if (this.useNavigationActions && z3) {
            arrayList.add("com.google.android.exoplayer.prev");
        }
        if (z4) {
            arrayList.add("com.google.android.exoplayer.rewind");
        }
        if (this.usePlayPauseActions) {
            if (shouldShowPauseButton(player2)) {
                arrayList.add("com.google.android.exoplayer.pause");
            } else {
                arrayList.add("com.google.android.exoplayer.play");
            }
        }
        if (z) {
            arrayList.add("com.google.android.exoplayer.ffwd");
        }
        if (this.useNavigationActions && z2) {
            arrayList.add("com.google.android.exoplayer.next");
        }
        CustomActionReceiver customActionReceiver2 = this.customActionReceiver;
        if (customActionReceiver2 != null) {
            arrayList.addAll(customActionReceiver2.getCustomActions(player2));
        }
        if (this.useStopAction) {
            arrayList.add("com.google.android.exoplayer.stop");
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public int[] getActionIndicesForCompactView(List<String> list, Player player2) {
        int i;
        int indexOf = list.indexOf("com.google.android.exoplayer.pause");
        int indexOf2 = list.indexOf("com.google.android.exoplayer.play");
        int indexOf3 = this.useNavigationActionsInCompactView ? list.indexOf("com.google.android.exoplayer.prev") : -1;
        int indexOf4 = this.useNavigationActionsInCompactView ? list.indexOf("com.google.android.exoplayer.next") : -1;
        int[] iArr = new int[3];
        int i2 = 0;
        if (indexOf3 != -1) {
            iArr[0] = indexOf3;
            i2 = 1;
        }
        boolean shouldShowPauseButton = shouldShowPauseButton(player2);
        if (indexOf != -1 && shouldShowPauseButton) {
            i = i2 + 1;
            iArr[i2] = indexOf;
        } else if (indexOf2 == -1 || shouldShowPauseButton) {
            i = i2;
        } else {
            i = i2 + 1;
            iArr[i2] = indexOf2;
        }
        if (indexOf4 != -1) {
            iArr[i] = indexOf4;
            i++;
        }
        return Arrays.copyOf(iArr, i);
    }

    /* access modifiers changed from: protected */
    public boolean getOngoing(Player player2) {
        int playbackState = player2.getPlaybackState();
        return (playbackState == 2 || playbackState == 3) && player2.getPlayWhenReady();
    }

    private boolean shouldShowPauseButton(Player player2) {
        if (player2.getPlaybackState() == 4 || player2.getPlaybackState() == 1 || !player2.getPlayWhenReady()) {
            return false;
        }
        return true;
    }

    public void postStartOrUpdateNotification() {
        if (!this.mainHandler.hasMessages(0)) {
            this.mainHandler.sendEmptyMessage(0);
        }
    }

    public void postUpdateNotificationBitmap(Bitmap bitmap, int i) {
        this.mainHandler.obtainMessage(1, i, -1, bitmap).sendToTarget();
    }

    /* access modifiers changed from: private */
    /* renamed from: handleMessage */
    public boolean lambda$new$0$PlayerNotificationManager(Message message) {
        int i = message.what;
        if (i == 0) {
            Player player2 = this.player;
            if (player2 != null) {
                startOrUpdateNotification(player2, null);
            }
        } else if (i != 1) {
            return false;
        } else {
            if (this.player != null && this.isNotificationStarted && this.currentNotificationTag == message.arg1) {
                startOrUpdateNotification(this.player, (Bitmap) message.obj);
            }
        }
        return true;
    }

    private static Map<String, NotificationCompat.O000000o> createPlaybackActions(Context context2, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("com.google.android.exoplayer.play", new NotificationCompat.O000000o((int) R.drawable.exo_notification_play, context2.getString(R.string.exo_controls_play_description), createBroadcastIntent("com.google.android.exoplayer.play", context2, i)));
        hashMap.put("com.google.android.exoplayer.pause", new NotificationCompat.O000000o((int) R.drawable.exo_notification_pause, context2.getString(R.string.exo_controls_pause_description), createBroadcastIntent("com.google.android.exoplayer.pause", context2, i)));
        hashMap.put("com.google.android.exoplayer.stop", new NotificationCompat.O000000o((int) R.drawable.exo_notification_stop, context2.getString(R.string.exo_controls_stop_description), createBroadcastIntent("com.google.android.exoplayer.stop", context2, i)));
        hashMap.put("com.google.android.exoplayer.rewind", new NotificationCompat.O000000o((int) R.drawable.exo_notification_rewind, context2.getString(R.string.exo_controls_rewind_description), createBroadcastIntent("com.google.android.exoplayer.rewind", context2, i)));
        hashMap.put("com.google.android.exoplayer.ffwd", new NotificationCompat.O000000o((int) R.drawable.exo_notification_fastforward, context2.getString(R.string.exo_controls_fastforward_description), createBroadcastIntent("com.google.android.exoplayer.ffwd", context2, i)));
        hashMap.put("com.google.android.exoplayer.prev", new NotificationCompat.O000000o((int) R.drawable.exo_notification_previous, context2.getString(R.string.exo_controls_previous_description), createBroadcastIntent("com.google.android.exoplayer.prev", context2, i)));
        hashMap.put("com.google.android.exoplayer.next", new NotificationCompat.O000000o((int) R.drawable.exo_notification_next, context2.getString(R.string.exo_controls_next_description), createBroadcastIntent("com.google.android.exoplayer.next", context2, i)));
        return hashMap;
    }

    private static PendingIntent createBroadcastIntent(String str, Context context2, int i) {
        Intent intent = new Intent(str).setPackage(context2.getPackageName());
        intent.putExtra("INSTANCE_ID", i);
        return PendingIntent.getBroadcast(context2, i, intent, 134217728);
    }

    private static void setLargeIcon(NotificationCompat.Builder builder2, Bitmap bitmap) {
        builder2.O000000o(bitmap);
    }

    class PlayerListener implements Player.EventListener {
        public /* synthetic */ void onIsLoadingChanged(boolean z) {
            Player.EventListener.CC.$default$onIsLoadingChanged(this, z);
        }

        @Deprecated
        public /* synthetic */ void onLoadingChanged(boolean z) {
            Player.EventListener.CC.$default$onLoadingChanged(this, z);
        }

        @Deprecated
        public /* synthetic */ void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
            Player.EventListener.CC.$default$onPlaybackParametersChanged(this, playbackParameters);
        }

        public /* synthetic */ void onPlaybackSuppressionReasonChanged(int i) {
            Player.EventListener.CC.$default$onPlaybackSuppressionReasonChanged(this, i);
        }

        public /* synthetic */ void onPlayerError(ExoPlaybackException exoPlaybackException) {
            Player.EventListener.CC.$default$onPlayerError(this, exoPlaybackException);
        }

        @Deprecated
        public /* synthetic */ void onPlayerStateChanged(boolean z, int i) {
            Player.EventListener.CC.$default$onPlayerStateChanged(this, z, i);
        }

        public /* synthetic */ void onSeekProcessed() {
            Player.EventListener.CC.$default$onSeekProcessed(this);
        }

        @Deprecated
        public /* synthetic */ void onTimelineChanged(Timeline timeline, Object obj, int i) {
            Player.EventListener.CC.$default$onTimelineChanged(this, timeline, obj, i);
        }

        public /* synthetic */ void onTracksChanged(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
            Player.EventListener.CC.$default$onTracksChanged(this, trackGroupArray, trackSelectionArray);
        }

        private PlayerListener() {
        }

        public void onPlaybackStateChanged(int i) {
            PlayerNotificationManager.this.postStartOrUpdateNotification();
        }

        public void onPlayWhenReadyChanged(boolean z, int i) {
            PlayerNotificationManager.this.postStartOrUpdateNotification();
        }

        public void onIsPlayingChanged(boolean z) {
            PlayerNotificationManager.this.postStartOrUpdateNotification();
        }

        public void onTimelineChanged(Timeline timeline, int i) {
            PlayerNotificationManager.this.postStartOrUpdateNotification();
        }

        public void onPlaybackSpeedChanged(float f) {
            PlayerNotificationManager.this.postStartOrUpdateNotification();
        }

        public void onPositionDiscontinuity(int i) {
            PlayerNotificationManager.this.postStartOrUpdateNotification();
        }

        public void onRepeatModeChanged(int i) {
            PlayerNotificationManager.this.postStartOrUpdateNotification();
        }

        public void onShuffleModeEnabledChanged(boolean z) {
            PlayerNotificationManager.this.postStartOrUpdateNotification();
        }
    }

    class NotificationBroadcastReceiver extends BroadcastReceiver {
        private NotificationBroadcastReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            Player player = PlayerNotificationManager.this.player;
            if (player != null && PlayerNotificationManager.this.isNotificationStarted && intent.getIntExtra("INSTANCE_ID", PlayerNotificationManager.this.instanceId) == PlayerNotificationManager.this.instanceId) {
                String action = intent.getAction();
                if ("com.google.android.exoplayer.play".equals(action)) {
                    if (player.getPlaybackState() == 1) {
                        if (PlayerNotificationManager.this.playbackPreparer != null) {
                            PlayerNotificationManager.this.playbackPreparer.preparePlayback();
                        }
                    } else if (player.getPlaybackState() == 4) {
                        PlayerNotificationManager.this.controlDispatcher.dispatchSeekTo(player, player.getCurrentWindowIndex(), -9223372036854775807L);
                    }
                    PlayerNotificationManager.this.controlDispatcher.dispatchSetPlayWhenReady(player, true);
                } else if ("com.google.android.exoplayer.pause".equals(action)) {
                    PlayerNotificationManager.this.controlDispatcher.dispatchSetPlayWhenReady(player, false);
                } else if ("com.google.android.exoplayer.prev".equals(action)) {
                    PlayerNotificationManager.this.controlDispatcher.dispatchPrevious(player);
                } else if ("com.google.android.exoplayer.rewind".equals(action)) {
                    PlayerNotificationManager.this.controlDispatcher.dispatchRewind(player);
                } else if ("com.google.android.exoplayer.ffwd".equals(action)) {
                    PlayerNotificationManager.this.controlDispatcher.dispatchFastForward(player);
                } else if ("com.google.android.exoplayer.next".equals(action)) {
                    PlayerNotificationManager.this.controlDispatcher.dispatchNext(player);
                } else if ("com.google.android.exoplayer.stop".equals(action)) {
                    PlayerNotificationManager.this.controlDispatcher.dispatchStop(player, true);
                } else if ("com.google.android.exoplayer.dismiss".equals(action)) {
                    PlayerNotificationManager.this.stopNotification(true);
                } else if (action != null && PlayerNotificationManager.this.customActionReceiver != null && PlayerNotificationManager.this.customActions.containsKey(action)) {
                    PlayerNotificationManager.this.customActionReceiver.onCustomAction(player, action, intent);
                }
            }
        }
    }
}

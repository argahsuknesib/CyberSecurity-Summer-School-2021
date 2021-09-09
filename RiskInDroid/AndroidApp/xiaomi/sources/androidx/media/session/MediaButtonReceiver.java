package androidx.media.session;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.RemoteException;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.util.Log;
import android.view.KeyEvent;
import java.util.List;

public class MediaButtonReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (intent == null || !"android.intent.action.MEDIA_BUTTON".equals(intent.getAction()) || !intent.hasExtra("android.intent.extra.KEY_EVENT")) {
            Log.d("MediaButtonReceiver", "Ignore unsupported intent: ".concat(String.valueOf(intent)));
            return;
        }
        ComponentName O000000o2 = O000000o(context, "android.intent.action.MEDIA_BUTTON");
        if (O000000o2 != null) {
            intent.setComponent(O000000o2);
            if (Build.VERSION.SDK_INT >= 26) {
                context.startForegroundService(intent);
            } else {
                context.startService(intent);
            }
        } else {
            ComponentName O000000o3 = O000000o(context, "android.media.browse.MediaBrowserService");
            if (O000000o3 != null) {
                BroadcastReceiver.PendingResult goAsync = goAsync();
                Context applicationContext = context.getApplicationContext();
                O000000o o000000o = new O000000o(applicationContext, intent, goAsync);
                MediaBrowserCompat mediaBrowserCompat = new MediaBrowserCompat(applicationContext, O000000o3, o000000o, null);
                o000000o.f2925O000000o = mediaBrowserCompat;
                mediaBrowserCompat.connect();
                return;
            }
            throw new IllegalStateException("Could not find any Service that handles android.intent.action.MEDIA_BUTTON or implements a media browser service.");
        }
    }

    static class O000000o extends MediaBrowserCompat.ConnectionCallback {

        /* renamed from: O000000o  reason: collision with root package name */
        MediaBrowserCompat f2925O000000o;
        private final Context O00000Oo;
        private final BroadcastReceiver.PendingResult O00000o;
        private final Intent O00000o0;

        O000000o(Context context, Intent intent, BroadcastReceiver.PendingResult pendingResult) {
            this.O00000Oo = context;
            this.O00000o0 = intent;
            this.O00000o = pendingResult;
        }

        public final void onConnected() {
            try {
                new MediaControllerCompat(this.O00000Oo, this.f2925O000000o.getSessionToken()).dispatchMediaButtonEvent((KeyEvent) this.O00000o0.getParcelableExtra("android.intent.extra.KEY_EVENT"));
            } catch (RemoteException e) {
                Log.e("MediaButtonReceiver", "Failed to create a media controller", e);
            }
            O000000o();
        }

        public final void onConnectionSuspended() {
            O000000o();
        }

        public final void onConnectionFailed() {
            O000000o();
        }

        private void O000000o() {
            this.f2925O000000o.disconnect();
            this.O00000o.finish();
        }
    }

    public static ComponentName O000000o(Context context) {
        Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 0);
        if (queryBroadcastReceivers.size() == 1) {
            ResolveInfo resolveInfo = queryBroadcastReceivers.get(0);
            return new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name);
        } else if (queryBroadcastReceivers.size() <= 1) {
            return null;
        } else {
            Log.w("MediaButtonReceiver", "More than one BroadcastReceiver that handles android.intent.action.MEDIA_BUTTON was found, returning null.");
            return null;
        }
    }

    private static ComponentName O000000o(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent(str);
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
        if (queryIntentServices.size() == 1) {
            ResolveInfo resolveInfo = queryIntentServices.get(0);
            return new ComponentName(resolveInfo.serviceInfo.packageName, resolveInfo.serviceInfo.name);
        } else if (queryIntentServices.isEmpty()) {
            return null;
        } else {
            throw new IllegalStateException("Expected 1 service that handles " + str + ", found " + queryIntentServices.size());
        }
    }
}

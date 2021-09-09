package com.ximalaya.ting.android.opensdk.player.appwidget;

import _m_j.ilj;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import android.widget.RemoteViews;
import com.ximalaya.ting.android.opensdk.model.PlayableModel;
import com.ximalaya.ting.android.opensdk.model.track.Track;
import com.ximalaya.ting.android.opensdk.player.receive.PlayerReceiver;
import com.ximalaya.ting.android.opensdk.player.service.XmPlayerService;

public class WidgetProvider extends BaseAppWidgetProvider {
    public void onReceive(Context context, Intent intent) {
        Log.w("WidgetProvider", "onReceive action " + intent.getAction());
        super.onReceive(context, intent);
        if (intent != null && "android.intent.action.WALLPAPER_CHANGED".equals(intent.getAction())) {
            try {
                RemoteViews remoteViews = new RemoteViews(context.getPackageName(), O000000o(context, "host_reflect_appwidget_layout", "layout"));
                AppWidgetManager instance = AppWidgetManager.getInstance(context);
                String str = "com.ximalaya.ting.android.ACTION_CONTROL_START_PAUSE";
                if (context.getPackageName().equals("com.ximalaya.ting.android")) {
                    str = "com.ximalaya.ting.android.ACTION_CONTROL_START_PAUSE_MAIN";
                }
                Intent intent2 = new Intent(context.getApplicationContext(), PlayerReceiver.class);
                intent2.setAction(str);
                remoteViews.setOnClickPendingIntent(O000000o(context, "appwidget_playOrPause", "id"), PendingIntent.getBroadcast(context, 0, intent2, 134217728));
                if (context.getPackageName().equals("com.ximalaya.ting.android")) {
                    Intent intent3 = new Intent(context.getApplicationContext(), PlayerReceiver.class);
                    intent3.setAction("com.ximalaya.ting.android.ACTION_CONTROL_PLAY_PRE_MAIN");
                    remoteViews.setOnClickPendingIntent(O000000o(context, "appwidget_pre", "id"), PendingIntent.getBroadcast(context, 0, intent3, 134217728));
                    Intent intent4 = new Intent(context.getApplicationContext(), PlayerReceiver.class);
                    intent4.setAction("com.ximalaya.ting.android.ACTION_CONTROL_PLAY_NEXT_MAIN");
                    remoteViews.setOnClickPendingIntent(O000000o(context, "appwidget_next", "id"), PendingIntent.getBroadcast(context, 0, intent4, 134217728));
                }
                Intent intent5 = new Intent("android.intent.action.VIEW");
                if (context.getPackageName().equals("com.ximalaya.ting.android")) {
                    intent5.setData(Uri.parse("itingwelcom://open"));
                    remoteViews.setOnClickPendingIntent(O000000o(context, "appwidget_icon_small", "id"), PendingIntent.getActivity(context, 0, intent5, 0));
                } else {
                    intent5.setData(Uri.parse("tingcar://open"));
                    remoteViews.setOnClickPendingIntent(O000000o(context, "ll_open_app", "id"), PendingIntent.getActivity(context, 0, intent5, 0));
                }
                XmPlayerService playerSrvice = XmPlayerService.getPlayerSrvice();
                ComponentName componentName = new ComponentName(context, getClass());
                if (playerSrvice == null) {
                    instance.updateAppWidget(componentName, remoteViews);
                    return;
                }
                PlayableModel playableModel = playerSrvice.getPlayableModel();
                if (playableModel instanceof Track) {
                    O000000o(context, (Track) playableModel, remoteViews);
                }
                instance.updateAppWidget(componentName, remoteViews);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final void O000000o(Context context) {
        RemoteViews remoteViews = null;
        if (context != null) {
            try {
                remoteViews = new RemoteViews(context.getPackageName(), O000000o(context, "host_reflect_appwidget_layout", "layout"));
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        if (remoteViews != null) {
            remoteViews.setImageViewResource(O000000o(context, "appwidget_playOrPause", "id"), O000000o(context, "host_reflect_widget_play", "drawable"));
            O000000o(context, remoteViews);
        }
    }

    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] iArr) {
        super.onUpdate(context, appWidgetManager, iArr);
        try {
            if (iArr.length > 0) {
                RemoteViews remoteViews = new RemoteViews(context.getPackageName(), O000000o(context, "host_reflect_appwidget_layout", "layout"));
                String str = "com.ximalaya.ting.android.ACTION_CONTROL_START_PAUSE";
                if (context.getPackageName().equals("com.ximalaya.ting.android")) {
                    str = "com.ximalaya.ting.android.ACTION_CONTROL_START_PAUSE_MAIN";
                }
                Intent intent = new Intent(context.getApplicationContext(), PlayerReceiver.class);
                intent.setAction(str);
                remoteViews.setOnClickPendingIntent(O000000o(context, "appwidget_playOrPause", "id"), PendingIntent.getBroadcast(context, 0, intent, 134217728));
                if (context.getPackageName().equals("com.ximalaya.ting.android")) {
                    Intent intent2 = new Intent(context.getApplicationContext(), PlayerReceiver.class);
                    intent2.setAction("com.ximalaya.ting.android.ACTION_CONTROL_PLAY_PRE_MAIN");
                    remoteViews.setOnClickPendingIntent(O000000o(context, "appwidget_pre", "id"), PendingIntent.getBroadcast(context, 0, intent2, 134217728));
                    Intent intent3 = new Intent(context.getApplicationContext(), PlayerReceiver.class);
                    intent3.setAction("com.ximalaya.ting.android.ACTION_CONTROL_PLAY_NEXT_MAIN");
                    remoteViews.setOnClickPendingIntent(O000000o(context, "appwidget_next", "id"), PendingIntent.getBroadcast(context, 0, intent3, 134217728));
                }
                Intent intent4 = new Intent("android.intent.action.VIEW");
                if (context.getPackageName().equals("com.ximalaya.ting.android")) {
                    intent4.setData(Uri.parse("itingwelcom://open"));
                    remoteViews.setOnClickPendingIntent(O000000o(context, "appwidget_icon_small", "id"), PendingIntent.getActivity(context, 0, intent4, 0));
                } else {
                    intent4.setData(Uri.parse("tingcar://open"));
                    remoteViews.setOnClickPendingIntent(O000000o(context, "ll_open_app", "id"), PendingIntent.getActivity(context, 0, intent4, 0));
                }
                XmPlayerService playerSrvice = XmPlayerService.getPlayerSrvice();
                if (playerSrvice == null) {
                    appWidgetManager.updateAppWidget(iArr, remoteViews);
                    return;
                }
                PlayableModel playableModel = playerSrvice.getPlayableModel();
                if (playableModel instanceof Track) {
                    O000000o(context, (Track) playableModel, remoteViews);
                }
                appWidgetManager.updateAppWidget(iArr, remoteViews);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int O000000o(Context context, String str, String str2) {
        return context.getResources().getIdentifier(str, str2, context.getPackageName());
    }

    public final void O000000o(Context context, RemoteViews remoteViews) {
        AppWidgetManager instance = AppWidgetManager.getInstance(context);
        ComponentName componentName = new ComponentName(context, getClass());
        if (instance != null && remoteViews != null) {
            instance.updateAppWidget(componentName, remoteViews);
        }
    }

    public void onDeleted(Context context, int[] iArr) {
        super.onDeleted(context, iArr);
    }

    public void onDisabled(Context context) {
        super.onDisabled(context);
    }

    public void onEnabled(Context context) {
        super.onEnabled(context);
    }

    private static int O000000o(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private static boolean O000000o() {
        return Build.VERSION.SDK_INT >= 16;
    }

    public final void O000000o(Context context, Track track) {
        O00000Oo(context, track);
    }

    private void O00000Oo(Context context, Track track) {
        RemoteViews remoteViews = null;
        if (context != null) {
            try {
                remoteViews = new RemoteViews(context.getPackageName(), O000000o(context, "host_reflect_appwidget_layout", "layout"));
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        if (remoteViews != null && track != null) {
            O000000o(context, track, remoteViews);
            O000000o(context, remoteViews);
        }
    }

    private void O000000o(Context context, Track track, RemoteViews remoteViews) {
        String str;
        if (track != null && context != null) {
            try {
                if (XmPlayerService.getPlayerSrvice() != null) {
                    if (XmPlayerService.getPlayerSrvice().isPlaying()) {
                        remoteViews.setImageViewResource(O000000o(context, "appwidget_playOrPause", "id"), O000000o(context, "host_reflect_widget_pause", "drawable"));
                    } else {
                        remoteViews.setImageViewResource(O000000o(context, "appwidget_playOrPause", "id"), O000000o(context, "host_reflect_widget_play", "drawable"));
                    }
                }
                String str2 = track.O0000Oo0;
                if (track.O000000o() == null) {
                    str = "";
                } else {
                    str = track.O000000o().O00000Oo;
                }
                remoteViews.setTextViewText(O000000o(context, "appwidget_title", "id"), str2);
                remoteViews.setTextViewText(O000000o(context, "appwidget_name", "id"), str);
                if (context.getPackageName().equals("com.ximalaya.ting.android")) {
                    O00000Oo(context, track, remoteViews);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void O00000Oo(final Context context, Track track, final RemoteViews remoteViews) {
        int O000000o2 = O000000o(context, 55.0f);
        if (!O000000o()) {
            O000000o2 = O000000o(context, 30.0f);
        }
        try {
            ilj.O000000o(context, track, O000000o2, O000000o2, new ilj.O00000Oo() {
                /* class com.ximalaya.ting.android.opensdk.player.appwidget.WidgetProvider.AnonymousClass1 */

                public final void O000000o(Bitmap bitmap) {
                    if (bitmap == null || bitmap.isRecycled()) {
                        RemoteViews remoteViews = remoteViews;
                        if (remoteViews != null) {
                            remoteViews.setInt(WidgetProvider.O000000o(context, "appwidget_icon_small", "id"), "setImageResource", WidgetProvider.O000000o(context, "notification_default", "drawable"));
                        }
                    } else {
                        RemoteViews remoteViews2 = remoteViews;
                        if (remoteViews2 != null) {
                            remoteViews2.setImageViewBitmap(WidgetProvider.O000000o(context, "appwidget_icon_small", "id"), bitmap);
                        }
                    }
                    RemoteViews remoteViews3 = remoteViews;
                    if (remoteViews3 != null) {
                        WidgetProvider.this.O000000o(context, remoteViews3);
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void O00000Oo(Context context) {
        PlayableModel playableModel;
        XmPlayerService playerSrvice = XmPlayerService.getPlayerSrvice();
        if (playerSrvice != null && (playableModel = playerSrvice.getPlayableModel()) != null) {
            O00000Oo(context, (Track) playableModel);
        }
    }
}

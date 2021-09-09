package com.ximalaya.ting.android.opensdk.player.appwidget;

import _m_j.ilp;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.gson.Gson;
import com.ximalaya.ting.android.opensdk.model.PlayableModel;
import com.ximalaya.ting.android.opensdk.model.track.Track;
import com.ximalaya.ting.android.opensdk.player.service.XmPlayerService;

public abstract class BaseAppWidgetProvider extends AppWidgetProvider {
    public abstract void O000000o(Context context);

    public abstract void O000000o(Context context, Track track);

    public abstract void O00000Oo(Context context);

    public void onReceive(Context context, Intent intent) {
        PlayableModel playableModel;
        Track track;
        Track track2;
        super.onReceive(context, intent);
        if (intent != null) {
            if (intent.getAction().equals("com.ximalaya.ting.android.ACTION_PLAY_PAUSE")) {
                O000000o(context);
            } else if (intent.getAction().equals("com.ximalaya.ting.android.ACTION_PLAY_START")) {
                O00000Oo(context);
            } else if (intent.getAction().equals("com.ximalaya.ting.android.ACTION_COMPLETE")) {
                O000000o(context);
            } else if ("android.intent.action.BOOT_COMPLETED".equals(intent.getAction())) {
                String O00000o0 = ilp.O000000o(context).O00000o0("lasttrack");
                if (O00000o0 != null) {
                    try {
                        track2 = (Track) new Gson().fromJson(O00000o0, Track.class);
                    } catch (Exception unused) {
                        track2 = null;
                    }
                    if (track2 != null) {
                        O000000o(context, track2);
                    }
                }
            } else if (intent.getAction().equals("com.ximalaya.ting.android.ACTION_INIT_UI")) {
                Bundle extras = intent.getExtras();
                if (extras != null && (track = (Track) extras.get("track")) != null) {
                    O000000o(context, track);
                }
            } else if (intent.getAction().equals("com.ximalaya.ting.android.ACTION_CONTROL_PLAY_PRE_MAIN")) {
                PlayableModel playableModel2 = XmPlayerService.getPlayerSrvice().getPlayableModel();
                if (playableModel2 != null) {
                    O000000o(context, (Track) playableModel2);
                }
            } else if (intent.getAction().equals("com.ximalaya.ting.android.ACTION_CONTROL_PLAY_NEXT_MAIN") && (playableModel = XmPlayerService.getPlayerSrvice().getPlayableModel()) != null) {
                O000000o(context, (Track) playableModel);
            }
        }
    }
}

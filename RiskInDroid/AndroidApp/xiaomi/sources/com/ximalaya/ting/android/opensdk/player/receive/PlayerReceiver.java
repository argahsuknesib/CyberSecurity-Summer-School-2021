package com.ximalaya.ting.android.opensdk.player.receive;

import _m_j.ikd;
import _m_j.ilk;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.ximalaya.ting.android.opensdk.player.service.XmPlayListControl;
import com.ximalaya.ting.android.opensdk.player.service.XmPlayerControl;
import com.ximalaya.ting.android.opensdk.player.service.XmPlayerService;

public class PlayerReceiver extends BroadcastReceiver {

    /* renamed from: O000000o  reason: collision with root package name */
    private int f12187O000000o = -1;

    public void onReceive(Context context, Intent intent) {
        XmPlayerService playerSrvice;
        if (intent == null || intent.getAction().equals("com.ximalaya.ting.android.ACTION_CONTROL_RELEASE_SERVICE")) {
            ikd.O00000o0();
            return;
        }
        XmPlayerService playerSrvice2 = XmPlayerService.getPlayerSrvice();
        if ((playerSrvice2 != null || !"com.ximalaya.ting.android.ACTION_CLOSE_MAIN".equals(intent.getAction())) && playerSrvice2 != null && (playerSrvice = XmPlayerService.getPlayerSrvice()) != null) {
            ilk.O000000o("PLAYERRECEIVER", "handleAction " + intent.getAction());
            if ("com.ximalaya.ting.android.ACTION_CLOSE_MAIN".equals(intent.getAction()) || "com.ximalaya.ting.android.ACTION_CLOSE".equals(intent.getAction())) {
                ilk.O000000o((Object) "process Main is running");
                if (playerSrvice != null) {
                    playerSrvice.closeNotification();
                }
                playerSrvice.closeApp();
            } else if (intent.getAction().equals("com.ximalaya.ting.android.ACTION_CONTROL_PLAY_PRE_MAIN") && playerSrvice != null) {
                playerSrvice.playPre();
            } else if (intent.getAction().equals("com.ximalaya.ting.android.ACTION_CONTROL_PLAY_NEXT_MAIN") && playerSrvice != null) {
                playerSrvice.playNext();
            } else if (!intent.getAction().equals("com.ximalaya.ting.android.ACTION_CONTROL_START_PAUSE_MAIN") || playerSrvice == null) {
                if (playerSrvice == null && context.getApplicationInfo().packageName.equalsIgnoreCase("com.ximalaya.ting.android.car")) {
                    ikd.O00000o();
                    Intent intent2 = new Intent("android.intent.action.VIEW");
                    intent2.setData(Uri.parse("tingcar://open"));
                    intent2.addFlags(268435456);
                    if (intent2.resolveActivity(context.getPackageManager()) != null) {
                        context.startActivity(intent2);
                    }
                } else if (playerSrvice == null) {
                } else {
                    if (intent.getAction().equals("com.ximalaya.ting.android.ACTION_CONTROL_PLAY_NEXT")) {
                        playerSrvice.playNext();
                    } else if (intent.getAction().equals("com.ximalaya.ting.android.ACTION_CONTROL_PLAY_PRE")) {
                        playerSrvice.playPre();
                    } else if (!intent.getAction().equals("com.ximalaya.ting.android.ACTION_CONTROL_START_PAUSE")) {
                    } else {
                        if (playerSrvice.getPlayListSize() == 0 && context.getApplicationInfo().packageName.equalsIgnoreCase("com.ximalaya.ting.android.car")) {
                            Intent intent3 = new Intent("android.intent.action.VIEW");
                            intent3.setData(Uri.parse("tingcar://open"));
                            intent3.addFlags(268435456);
                            if (intent3.resolveActivity(context.getPackageManager()) != null) {
                                context.startActivity(intent3);
                            }
                        } else if (playerSrvice.isPlaying()) {
                            playerSrvice.pausePlay();
                        } else {
                            playerSrvice.startPlay(false);
                        }
                    }
                }
            } else if (playerSrvice.isPlaying()) {
                playerSrvice.pausePlay();
            } else {
                XmPlayerControl playControl = playerSrvice.getPlayControl();
                XmPlayListControl playListControl = playerSrvice.getPlayListControl();
                if (playControl == null || playListControl == null || playControl.O00000oO != 4) {
                    playerSrvice.startPlay(false);
                    return;
                }
                int i = playListControl.O0000Oo;
                if (i == -1) {
                    i = this.f12187O000000o;
                }
                if (i != -1) {
                    playerSrvice.play(i);
                }
            }
        }
    }
}

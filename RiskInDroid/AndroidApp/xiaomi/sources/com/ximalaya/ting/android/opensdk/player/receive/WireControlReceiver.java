package com.ximalaya.ting.android.opensdk.player.receive;

import _m_j.ilk;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.view.KeyEvent;
import com.ximalaya.ting.android.opensdk.player.service.XmPlayerService;

public class WireControlReceiver extends BroadcastReceiver {

    /* renamed from: O000000o  reason: collision with root package name */
    public static int f12188O000000o = 0;
    public static int O00000Oo = 0;
    static Runnable O00000o = new Runnable() {
        /* class com.ximalaya.ting.android.opensdk.player.receive.WireControlReceiver.AnonymousClass1 */

        public final void run() {
            WireControlReceiver.f12188O000000o = 0;
            XmPlayerService playerSrvice = XmPlayerService.getPlayerSrvice();
            if (playerSrvice == null) {
                return;
            }
            if (playerSrvice.isPlaying()) {
                playerSrvice.pausePlay();
            } else {
                playerSrvice.startPlay();
            }
        }
    };
    public static int O00000o0 = 0;
    static Runnable O00000oO = new Runnable() {
        /* class com.ximalaya.ting.android.opensdk.player.receive.WireControlReceiver.AnonymousClass2 */

        public final void run() {
            WireControlReceiver.f12188O000000o = 0;
            XmPlayerService playerSrvice = XmPlayerService.getPlayerSrvice();
            if (playerSrvice != null) {
                playerSrvice.playNext();
            }
        }
    };
    static Runnable O00000oo = new Runnable() {
        /* class com.ximalaya.ting.android.opensdk.player.receive.WireControlReceiver.AnonymousClass3 */

        public final void run() {
            WireControlReceiver.O00000Oo = 0;
            XmPlayerService playerSrvice = XmPlayerService.getPlayerSrvice();
            if (playerSrvice != null) {
                playerSrvice.playNext();
            }
        }
    };
    static Runnable O0000O0o = new Runnable() {
        /* class com.ximalaya.ting.android.opensdk.player.receive.WireControlReceiver.AnonymousClass4 */

        public final void run() {
            WireControlReceiver.O00000o0 = 0;
            XmPlayerService playerSrvice = XmPlayerService.getPlayerSrvice();
            if (playerSrvice != null) {
                playerSrvice.playPre();
            }
        }
    };
    static Runnable O0000OOo = new Runnable() {
        /* class com.ximalaya.ting.android.opensdk.player.receive.WireControlReceiver.AnonymousClass5 */

        public final void run() {
            WireControlReceiver.O00000Oo = 0;
            XmPlayerService playerSrvice = XmPlayerService.getPlayerSrvice();
            if (playerSrvice != null) {
                playerSrvice.seekTo(playerSrvice.getPlayCurrPosition() + 15000);
            }
        }
    };
    private static final String O0000Oo = "WireControlReceiver";
    static Runnable O0000Oo0 = new Runnable() {
        /* class com.ximalaya.ting.android.opensdk.player.receive.WireControlReceiver.AnonymousClass6 */

        public final void run() {
            WireControlReceiver.O00000o0 = 0;
            XmPlayerService playerSrvice = XmPlayerService.getPlayerSrvice();
            if (playerSrvice != null) {
                playerSrvice.seekTo(playerSrvice.getPlayCurrPosition() - 15000);
            }
        }
    };
    private static int O0000OoO;
    private static Handler O0000Ooo = new Handler();

    /* JADX WARNING: Removed duplicated region for block: B:59:0x01a1 A[Catch:{ Exception -> 0x01a4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:68:? A[RETURN, SYNTHETIC] */
    public void onReceive(Context context, Intent intent) {
        KeyEvent keyEvent;
        XmPlayerService playerSrvice = XmPlayerService.getPlayerSrvice();
        if (playerSrvice != null && "android.intent.action.MEDIA_BUTTON".equals(intent.getAction()) && (keyEvent = (KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT")) != null) {
            if (keyEvent.getRepeatCount() > 0) {
                O0000OoO = keyEvent.getRepeatCount();
            }
            if (!(keyEvent.getAction() == 1)) {
                ilk.O000000o("WireControlReceiver  0  " + keyEvent + "   " + O0000OoO);
                if (keyEvent.getKeyCode() == 87) {
                    if (O0000OoO > 0) {
                        O000000o(true, true);
                    }
                } else if (keyEvent.getKeyCode() == 88 && O0000OoO > 0) {
                    O000000o(false, true);
                }
            } else {
                int keyCode = keyEvent.getKeyCode();
                if (keyCode != 79) {
                    if (keyCode != 126) {
                        if (keyCode != 127) {
                            switch (keyCode) {
                                case 87:
                                    ilk.O000000o("WireControlReceiver  4  " + O0000OoO);
                                    if (O0000OoO <= 0) {
                                        O00000Oo++;
                                        ilk.O000000o("WireControlReceiver  5  " + O00000Oo);
                                        if (O00000Oo < 2) {
                                            O0000Ooo.removeCallbacks(O00000oo);
                                            O0000Ooo.postDelayed(O00000oo, 600);
                                            break;
                                        } else {
                                            O0000Ooo.removeCallbacks(O00000oo);
                                            O0000Ooo.removeCallbacks(O0000OOo);
                                            O0000Ooo.postDelayed(O0000OOo, 600);
                                            break;
                                        }
                                    } else {
                                        O000000o(true, false);
                                        break;
                                    }
                                case 88:
                                    ilk.O000000o("WireControlReceiver  6  " + O0000OoO);
                                    if (O0000OoO <= 0) {
                                        O00000o0++;
                                        ilk.O000000o("WireControlReceiver  7  " + O00000o0);
                                        if (O00000o0 < 2) {
                                            O0000Ooo.removeCallbacks(O0000O0o);
                                            O0000Ooo.postDelayed(O0000O0o, 600);
                                            break;
                                        } else {
                                            O0000Ooo.removeCallbacks(O0000O0o);
                                            O0000Ooo.removeCallbacks(O0000Oo0);
                                            O0000Ooo.postDelayed(O0000Oo0, 600);
                                            break;
                                        }
                                    } else {
                                        O000000o(false, false);
                                        break;
                                    }
                            }
                        }
                        ilk.O000000o("WireControlReceiver  1");
                        playerSrvice.pausePlay();
                    } else {
                        ilk.O000000o("WireControlReceiver  2");
                        playerSrvice.startPlay();
                    }
                    if (!isOrderedBroadcast()) {
                        abortBroadcast();
                        return;
                    }
                    return;
                }
                f12188O000000o++;
                ilk.O000000o("WireControlReceiver  3  == " + f12188O000000o);
                O0000Ooo.removeCallbacks(O00000o);
                O0000Ooo.removeCallbacks(O00000oO);
                int i = f12188O000000o;
                if (i == 1) {
                    O0000Ooo.postDelayed(O00000o, 600);
                } else if (i == 2) {
                    O0000Ooo.postDelayed(O00000oO, 400);
                } else {
                    f12188O000000o = 0;
                    playerSrvice.playPre();
                }
                try {
                    if (!isOrderedBroadcast()) {
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    private static void O000000o(boolean z, boolean z2) {
        int duration;
        XmPlayerService playerSrvice = XmPlayerService.getPlayerSrvice();
        if (playerSrvice != null && (duration = playerSrvice.getDuration()) > 0) {
            int playCurrPosition = ((int) (((((float) (O0000OoO * duration)) * 1.0f) / 100.0f) * ((float) (z ? 1 : -1)))) + playerSrvice.getPlayCurrPosition();
            if (playCurrPosition > duration) {
                playCurrPosition = duration;
            }
            if (z2) {
                playerSrvice.notifProgress(playCurrPosition, duration);
                return;
            }
            playerSrvice.seekTo(playCurrPosition);
            O0000OoO = 0;
        }
    }
}

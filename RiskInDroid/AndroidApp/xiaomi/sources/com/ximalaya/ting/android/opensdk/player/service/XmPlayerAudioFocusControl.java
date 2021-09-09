package com.ximalaya.ting.android.opensdk.player.service;

import _m_j.ikz;
import _m_j.ilk;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import java.util.Timer;
import java.util.TimerTask;

public class XmPlayerAudioFocusControl {

    /* renamed from: O000000o  reason: collision with root package name */
    public Context f12193O000000o;
    public AudioManager O00000Oo;
    public boolean O00000o;
    public boolean O00000o0 = false;
    public AudioManager.OnAudioFocusChangeListener O00000oO = new AudioManager.OnAudioFocusChangeListener() {
        /* class com.ximalaya.ting.android.opensdk.player.service.XmPlayerAudioFocusControl.AnonymousClass4 */

        public final void onAudioFocusChange(int i) {
            ilk.O000000o((Object) "XmPlayerAudioFocusControl : onAudioFocusChange = ".concat(String.valueOf(i)));
            XmPlayerService playerSrvice = XmPlayerService.getPlayerSrvice();
            if (i == -1) {
                if (XmPlayerAudioFocusControl.this.O00000o0) {
                    XmPlayerAudioFocusControl.this.O00000o0 = false;
                    return;
                }
                if (playerSrvice != null) {
                    playerSrvice.setLossAudioFocus(true);
                    playerSrvice.pausePlay();
                }
                if (XmPlayerAudioFocusControl.this.O00000Oo != null) {
                    XmPlayerAudioFocusControl.this.O00000Oo.abandonAudioFocus(XmPlayerAudioFocusControl.this.O00000oO);
                }
            } else if (i == -2) {
                if (playerSrvice == null) {
                    return;
                }
                if (playerSrvice.isPlaying()) {
                    playerSrvice.pausePlay();
                    XmPlayerAudioFocusControl.this.O00000o = true;
                } else if (playerSrvice.getPlayControl() != null && playerSrvice.getPlayControl().O00000oO == 9) {
                    playerSrvice.setLossAudioFocus(true);
                    XmPlayerAudioFocusControl.this.O00000o = true;
                }
            } else if (i == 2) {
            } else {
                if (i == 1) {
                    if (playerSrvice != null) {
                        playerSrvice.setLossAudioFocus(false);
                        if (XmPlayerAudioFocusControl.this.O00000o) {
                            playerSrvice.startPlay();
                            XmPlayerAudioFocusControl.this.O00000o = false;
                        }
                        playerSrvice.setVolume(1.0f, 1.0f);
                    }
                } else if (i == -3) {
                    if (playerSrvice != null) {
                        playerSrvice.setVolume(ikz.O000000o(XmPlayerAudioFocusControl.this.f12193O000000o).O00000o(), ikz.O000000o(XmPlayerAudioFocusControl.this.f12193O000000o).O00000o());
                    }
                } else if (i == 3 && playerSrvice != null) {
                    playerSrvice.setVolume(ikz.O000000o(XmPlayerAudioFocusControl.this.f12193O000000o).O00000o(), ikz.O000000o(XmPlayerAudioFocusControl.this.f12193O000000o).O00000o());
                }
            }
        }
    };
    private TelephonyManager O00000oo;
    private TelephonyManager O0000O0o;
    private TelephonyManager O0000OOo;
    private PhoneStateListener O0000Oo = new PhoneStateListener() {
        /* class com.ximalaya.ting.android.opensdk.player.service.XmPlayerAudioFocusControl.AnonymousClass1 */

        public final void onCallStateChanged(int i, String str) {
            super.onCallStateChanged(i, str);
            if (i == 0) {
                XmPlayerAudioFocusControl.this.O000000o();
            } else if (i == 1) {
                XmPlayerAudioFocusControl.this.O00000Oo();
            } else if (i == 2) {
                XmPlayerAudioFocusControl.this.O00000Oo();
            }
        }
    };
    private boolean O0000Oo0 = false;
    private BroadcastReceiver O0000OoO = new BroadcastReceiver() {
        /* class com.ximalaya.ting.android.opensdk.player.service.XmPlayerAudioFocusControl.AnonymousClass2 */

        public final void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals("com.ximalaya.ting.android.action.ACTION_NOTIFICATION_EXIT")) {
                return;
            }
            if (action.equals("android.intent.action.HEADSET_PLUG") || "android.media.AUDIO_BECOMING_NOISY".equals(action)) {
                if (intent.getIntExtra("state", 0) == 1) {
                    return;
                }
                if (XmPlayerAudioFocusControl.this.O00000o0) {
                    new Timer().schedule(new TimerTask() {
                        /* class com.ximalaya.ting.android.opensdk.player.service.XmPlayerAudioFocusControl.AnonymousClass2.AnonymousClass1 */

                        public final void run() {
                            XmPlayerAudioFocusControl.this.O00000o0 = false;
                        }
                    }, 3000);
                    return;
                }
                XmPlayerService playerSrvice = XmPlayerService.getPlayerSrvice();
                if (playerSrvice != null && playerSrvice.isPlaying()) {
                    playerSrvice.pausePlay();
                }
            } else if (!action.equals("android.net.conn.CONNECTIVITY_CHANGE") && !action.equals("com.ximalaya.ting.android.action.ACTION_NOTIFICATION_SWITCH_PLAY_PAUSE") && !action.equals("com.ximalaya.ting.android.action.ACTION_NOTIFICATION_NEXT")) {
                action.equals("com.ximalaya.ting.android.action.ACTION_NOTIFICATION_PRE");
            }
        }
    };
    private BroadcastReceiver O0000Ooo = new BroadcastReceiver() {
        /* class com.ximalaya.ting.android.opensdk.player.service.XmPlayerAudioFocusControl.AnonymousClass3 */

        public final void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.intent.action.NEW_OUTGOING_CALL")) {
                XmPlayerAudioFocusControl.this.O00000Oo();
                return;
            }
            int callState = ((TelephonyManager) context.getSystemService("phone")).getCallState();
            if (callState == 0) {
                XmPlayerAudioFocusControl.this.O000000o();
            } else if (callState == 1) {
                XmPlayerAudioFocusControl.this.O00000Oo();
            } else if (callState == 2) {
                XmPlayerAudioFocusControl.this.O00000Oo();
            }
        }
    };

    /* JADX WARNING: Can't wrap try/catch for region: R(7:14|15|16|17|18|19|21) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x00ad */
    public XmPlayerAudioFocusControl(Context context) {
        this.f12193O000000o = context.getApplicationContext();
        Context context2 = this.f12193O000000o;
        if (context2 != null) {
            this.O00000Oo = (AudioManager) context2.getSystemService("audio");
            ikz O000000o2 = ikz.O000000o(this.f12193O000000o);
            if (!O000000o2.O00000o0) {
                O000000o2.O00000o0 = O000000o2.f1428O000000o.getBoolean("KEY_SDK_HANDLE_HEADSET_PLUG_AUDIO_FOCUS", true);
            }
            if (O000000o2.O00000o0) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.HEADSET_PLUG");
                intentFilter.addAction("android.media.AUDIO_BECOMING_NOISY");
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                this.f12193O000000o.registerReceiver(this.O0000OoO, intentFilter);
            }
            ikz O000000o3 = ikz.O000000o(this.f12193O000000o);
            if (!O000000o3.O00000o0) {
                O000000o3.O00000o0 = O000000o3.f1428O000000o.getBoolean("KEY_SDK_HANDLE_PHONECOME_AUDIO_FOCUS", true);
            }
            if (O000000o3.O00000Oo) {
                this.O00000oo = (TelephonyManager) this.f12193O000000o.getSystemService("phone");
                this.O00000oo.listen(this.O0000Oo, 32);
                this.O0000O0o = (TelephonyManager) this.f12193O000000o.getSystemService("phone1");
                this.O0000O0o.listen(this.O0000Oo, 32);
                this.O0000OOo = (TelephonyManager) this.f12193O000000o.getSystemService("phone2");
                this.O0000OOo.listen(this.O0000Oo, 32);
                this.f12193O000000o.registerReceiver(this.O0000Ooo, new IntentFilter());
            }
        }
    }

    public final void O000000o() {
        XmPlayerService playerSrvice = XmPlayerService.getPlayerSrvice();
        if (playerSrvice != null && this.O0000Oo0) {
            playerSrvice.startPlay();
        }
        this.O0000Oo0 = false;
    }

    public final void O00000Oo() {
        XmPlayerService playerSrvice = XmPlayerService.getPlayerSrvice();
        if (playerSrvice != null && playerSrvice.isPlaying()) {
            this.O0000Oo0 = true;
            playerSrvice.pausePlay();
        }
    }

    public final void O00000o0() {
        if (ikz.O000000o(this.f12193O000000o).O00000o0()) {
            try {
                this.O00000Oo.requestAudioFocus(this.O00000oO, 3, 1);
                XmPlayerService playerSrvice = XmPlayerService.getPlayerSrvice();
                if (playerSrvice != null) {
                    playerSrvice.setLossAudioFocus(false);
                }
            } catch (Exception unused) {
            }
        }
    }
}

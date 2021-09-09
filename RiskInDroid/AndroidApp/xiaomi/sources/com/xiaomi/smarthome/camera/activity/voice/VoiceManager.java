package com.xiaomi.smarthome.camera.activity.voice;

import _m_j.chw;
import _m_j.cin;
import _m_j.dty;
import _m_j.dvq;
import _m_j.dvr;
import com.xiaomi.mistream.XmStreamClient;
import com.xiaomi.smarthome.camera.IMISSListener;
import com.xiaomi.smarthome.camera.IStreamCmdMessageListener;

public class VoiceManager {
    public IStreamCmdMessageListener mStreamCmdMessageListener;
    private final XmStreamClient mXmStreamClient;

    public VoiceManager(dty dty, IStreamCmdMessageListener iStreamCmdMessageListener) {
        this.mXmStreamClient = dty.O00oOooO();
        this.mStreamCmdMessageListener = iStreamCmdMessageListener;
    }

    public void sendRecordVoiceSuccess(long j, IStreamCmdMessageListener iStreamCmdMessageListener) {
        this.mStreamCmdMessageListener = iStreamCmdMessageListener;
        this.mXmStreamClient.streamCmdMessage(chw.f13851O000000o, cin.O000000o(dvq.O00000Oo(j)), new IMISSListener() {
            /* class com.xiaomi.smarthome.camera.activity.voice.VoiceManager.AnonymousClass1 */

            public void onProgress(int i) {
            }

            public void onSuccess(String str, Object obj) {
            }

            public void onFailed(int i, String str) {
                if (VoiceManager.this.mStreamCmdMessageListener != null) {
                    VoiceManager.this.mStreamCmdMessageListener.onSendCmdError();
                }
            }
        });
    }

    public void getVoiceState(IStreamCmdMessageListener iStreamCmdMessageListener) {
        this.mStreamCmdMessageListener = iStreamCmdMessageListener;
        this.mXmStreamClient.streamCmdMessage(chw.f13851O000000o, cin.O000000o(dvr.O000000o(10532, 0, null)), new IMISSListener() {
            /* class com.xiaomi.smarthome.camera.activity.voice.VoiceManager.AnonymousClass2 */

            public void onProgress(int i) {
            }

            public void onSuccess(String str, Object obj) {
            }

            public void onFailed(int i, String str) {
                if (VoiceManager.this.mStreamCmdMessageListener != null) {
                    VoiceManager.this.mStreamCmdMessageListener.onSendCmdError();
                }
            }
        });
    }

    public void setVoiceState(int i, int i2, IStreamCmdMessageListener iStreamCmdMessageListener) {
        this.mStreamCmdMessageListener = iStreamCmdMessageListener;
        this.mXmStreamClient.streamCmdMessage(chw.f13851O000000o, cin.O000000o(dvr.O000000o(10534, 2, new byte[]{(byte) i, (byte) i2})), new IMISSListener() {
            /* class com.xiaomi.smarthome.camera.activity.voice.VoiceManager.AnonymousClass3 */

            public void onProgress(int i) {
            }

            public void onSuccess(String str, Object obj) {
            }

            public void onFailed(int i, String str) {
                if (VoiceManager.this.mStreamCmdMessageListener != null) {
                    VoiceManager.this.mStreamCmdMessageListener.onSendCmdError();
                }
            }
        });
    }

    public void voiceAudition(IStreamCmdMessageListener iStreamCmdMessageListener) {
        this.mStreamCmdMessageListener = iStreamCmdMessageListener;
        this.mXmStreamClient.streamCmdMessage(chw.f13851O000000o, cin.O000000o(dvr.O000000o(10536, 0, null)), new IMISSListener() {
            /* class com.xiaomi.smarthome.camera.activity.voice.VoiceManager.AnonymousClass4 */

            public void onProgress(int i) {
            }

            public void onSuccess(String str, Object obj) {
            }

            public void onFailed(int i, String str) {
                if (VoiceManager.this.mStreamCmdMessageListener != null) {
                    VoiceManager.this.mStreamCmdMessageListener.onSendCmdError();
                }
            }
        });
    }
}

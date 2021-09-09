package com.xiaomi.smarthome.camera.activity.timelapse;

import _m_j.chw;
import _m_j.cin;
import _m_j.civ;
import _m_j.dty;
import _m_j.dvp;
import _m_j.dvq;
import _m_j.dvr;
import com.xiaomi.mistream.XmStreamClient;
import com.xiaomi.smarthome.camera.IMISSListener;
import com.xiaomi.smarthome.camera.IStreamCmdMessageListener;
import java.util.ArrayList;

public class TimeLapseTaskManager {
    IStreamCmdMessageListener mStreamCmdMessageListener;
    private final XmStreamClient mXmStreamClient;

    public TimeLapseTaskManager(dty dty, IStreamCmdMessageListener iStreamCmdMessageListener) {
        this.mXmStreamClient = dty.O00oOooO();
        this.mStreamCmdMessageListener = iStreamCmdMessageListener;
    }

    public void setTimeLapseTask(TimelapseTask timelapseTask, IStreamCmdMessageListener iStreamCmdMessageListener) {
        this.mStreamCmdMessageListener = iStreamCmdMessageListener;
        this.mXmStreamClient.streamCmdMessage(chw.f13851O000000o, cin.O000000o(dvq.O000000o(timelapseTask.toProtocolByteArray())), new IMISSListener() {
            /* class com.xiaomi.smarthome.camera.activity.timelapse.TimeLapseTaskManager.AnonymousClass1 */

            public void onProgress(int i) {
            }

            public void onSuccess(String str, Object obj) {
            }

            public void onFailed(int i, String str) {
                if (TimeLapseTaskManager.this.mStreamCmdMessageListener != null) {
                    TimeLapseTaskManager.this.mStreamCmdMessageListener.onSendCmdError();
                }
            }
        });
    }

    public void closeCurrentTimeLapseTask(IStreamCmdMessageListener iStreamCmdMessageListener) {
        this.mStreamCmdMessageListener = iStreamCmdMessageListener;
        this.mXmStreamClient.streamCmdMessage(chw.f13851O000000o, cin.O000000o(dvq.O000000o(TimelapseTask.getEmpty())), new IMISSListener() {
            /* class com.xiaomi.smarthome.camera.activity.timelapse.TimeLapseTaskManager.AnonymousClass2 */

            public void onFailed(int i, String str) {
            }

            public void onProgress(int i) {
            }

            public void onSuccess(String str, Object obj) {
            }
        });
    }

    private byte[] K10142_deleteVideoClip(int i, ArrayList<TimelapseTask> arrayList) {
        byte[] bArr = new byte[((arrayList.size() * 5) + 4)];
        dvp.O000000o(bArr, 0, dvp.O000000o(i), 3);
        int i2 = 4;
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            bArr[i2] = (byte) arrayList.get(i3).getVideoType();
            int i4 = i2 + 1;
            dvp.O000000o(bArr, i4, dvp.O000000o(arrayList.get(i3).getStartTimestampInSeconds()), 3);
            i2 = i4 + 4;
        }
        return dvr.O000000o(10142, bArr.length, bArr);
    }

    public void getTimeLapseTask(IStreamCmdMessageListener iStreamCmdMessageListener) {
        this.mStreamCmdMessageListener = iStreamCmdMessageListener;
        this.mXmStreamClient.streamCmdMessage(chw.f13851O000000o, cin.O000000o(dvr.O000000o(11080, 0, null)), new IMISSListener() {
            /* class com.xiaomi.smarthome.camera.activity.timelapse.TimeLapseTaskManager.AnonymousClass3 */

            public void onProgress(int i) {
            }

            public void onSuccess(String str, Object obj) {
            }

            public void onFailed(int i, String str) {
                if (TimeLapseTaskManager.this.mStreamCmdMessageListener != null) {
                    TimeLapseTaskManager.this.mStreamCmdMessageListener.onSendCmdError();
                }
            }
        });
    }

    public void getTimelapseList(IStreamCmdMessageListener iStreamCmdMessageListener) {
        this.mStreamCmdMessageListener = iStreamCmdMessageListener;
        this.mXmStreamClient.streamCmdMessage(chw.f13851O000000o, cin.O000000o(dvr.O000000o(10134, 0, null)), new IMISSListener() {
            /* class com.xiaomi.smarthome.camera.activity.timelapse.TimeLapseTaskManager.AnonymousClass4 */

            public void onProgress(int i) {
            }

            public void onSuccess(String str, Object obj) {
            }

            public void onFailed(int i, String str) {
                if (TimeLapseTaskManager.this.mStreamCmdMessageListener != null) {
                    TimeLapseTaskManager.this.mStreamCmdMessageListener.onSendCmdError();
                }
            }
        });
    }

    public void getSDTimeLapsePhotographyFile(int i, String str, IStreamCmdMessageListener iStreamCmdMessageListener) {
        this.mStreamCmdMessageListener = iStreamCmdMessageListener;
        byte[] bArr = new byte[21];
        bArr[0] = (byte) i;
        byte[] bytes = str.getBytes();
        dvp.O000000o(bArr, 1, bytes, bytes.length);
        this.mXmStreamClient.streamCmdMessage(chw.f13851O000000o, cin.O000000o(dvr.O000000o(10136, 21, bArr)), new IMISSListener() {
            /* class com.xiaomi.smarthome.camera.activity.timelapse.TimeLapseTaskManager.AnonymousClass5 */

            public void onProgress(int i) {
            }

            public void onSuccess(String str, Object obj) {
            }

            public void onFailed(int i, String str) {
                if (TimeLapseTaskManager.this.mStreamCmdMessageListener != null) {
                    TimeLapseTaskManager.this.mStreamCmdMessageListener.onSendCmdError();
                }
            }
        });
    }

    public void closeTimeLapsePhotographySever(int i, IStreamCmdMessageListener iStreamCmdMessageListener) {
        this.mStreamCmdMessageListener = iStreamCmdMessageListener;
        byte[] bArr = new byte[2];
        dvp.O000000o(bArr, dvp.O00000o0(i));
        this.mXmStreamClient.streamCmdMessage(chw.f13851O000000o, cin.O000000o(dvr.O000000o(10138, 2, bArr)), new IMISSListener() {
            /* class com.xiaomi.smarthome.camera.activity.timelapse.TimeLapseTaskManager.AnonymousClass6 */

            public void onProgress(int i) {
            }

            public void onSuccess(String str, Object obj) {
            }

            public void onFailed(int i, String str) {
                if (TimeLapseTaskManager.this.mStreamCmdMessageListener != null) {
                    TimeLapseTaskManager.this.mStreamCmdMessageListener.onSendCmdError();
                }
            }
        });
    }

    public void deleteRecord(ArrayList<TimelapseTask> arrayList, IStreamCmdMessageListener iStreamCmdMessageListener) {
        this.mStreamCmdMessageListener = iStreamCmdMessageListener;
        this.mXmStreamClient.streamCmdMessage(chw.f13851O000000o, cin.O000000o(K10142_deleteVideoClip(3, arrayList)), new IMISSListener() {
            /* class com.xiaomi.smarthome.camera.activity.timelapse.TimeLapseTaskManager.AnonymousClass7 */

            public void onProgress(int i) {
            }

            public void onSuccess(String str, Object obj) {
                civ.O000000o("AlbumActivity", "deleteRecord onSuccess");
            }

            public void onFailed(int i, String str) {
                civ.O000000o("AlbumActivity", "deleteRecord onFailed");
                if (TimeLapseTaskManager.this.mStreamCmdMessageListener != null) {
                    TimeLapseTaskManager.this.mStreamCmdMessageListener.onSendCmdError();
                }
            }
        });
    }
}

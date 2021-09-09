package com.xiaomi.smarthome.camera.activity;

import _m_j.cid;
import _m_j.cin;
import _m_j.civ;
import _m_j.dvp;
import _m_j.dvr;
import _m_j.gsy;
import android.os.Handler;
import com.tutk.CameraClient;
import com.xiaomi.smarthome.camera.activity.timelapse.TimeLapsePhotographyActivity;
import com.xiaomi.smarthome.camera.activity.timelapse.TimelapseTask;
import java.util.ArrayList;

public class CommandTreatment {
    private static int logDataIndex;
    private static int logDataTotalLength;
    private final int DATA_SIZE = 1024;
    private int dataIndex = 0;
    private int dataLength = 0;
    private Handler handler;
    private CameraClient mCameraClient;
    private cid mCameraDevice;
    private byte[] processData;
    private byte[] tempData = new byte[1024];

    public CommandTreatment(Handler handler2, cid cid) {
        this.handler = handler2;
        this.mCameraDevice = cid;
    }

    public void processData(byte[] bArr) {
        int i = this.dataLength;
        int i2 = this.dataIndex;
        if (i <= i2) {
            this.dataIndex = 0;
            System.arraycopy(bArr, 0, this.tempData, 0, bArr.length);
            this.dataLength = bArr.length;
        } else if (1024 - i > bArr.length) {
            System.arraycopy(bArr, 0, this.tempData, i, bArr.length);
            this.dataLength += bArr.length;
        } else if ((i - i2) + bArr.length > 1024) {
            this.dataIndex = 0;
            System.arraycopy(bArr, 0, this.tempData, 0, bArr.length);
            this.dataLength = bArr.length;
            civ.O000000o("CommandTreatment ", "processData: too large, drop");
        } else {
            byte[] bArr2 = new byte[(i - i2)];
            System.arraycopy(this.tempData, i2, bArr2, 0, i - i2);
            System.arraycopy(bArr2, 0, this.tempData, 0, this.dataLength - this.dataIndex);
            this.dataLength = bArr2.length;
            this.dataIndex = 0;
            System.arraycopy(bArr, 0, this.tempData, this.dataLength, bArr.length);
            this.dataLength += bArr.length;
            civ.O000000o("CommandTreatment ", "processData: move froward！");
        }
        boolean z = false;
        do {
            int searchHead = searchHead(this.tempData, this.dataIndex, this.dataLength);
            if (searchHead != -1) {
                this.dataIndex = searchHead;
                int i3 = this.dataLength;
                int i4 = this.dataIndex;
                if (i3 - i4 >= 16) {
                    byte[] bArr3 = new byte[16];
                    System.arraycopy(this.tempData, i4, bArr3, 0, 16);
                    int O000000o2 = dvr.O000000o(bArr3, true);
                    if (O000000o2 >= 0) {
                        int i5 = this.dataLength;
                        int i6 = this.dataIndex;
                        if (O000000o2 <= (i5 - i6) - 16) {
                            int i7 = O000000o2 + 16;
                            this.processData = new byte[i7];
                            System.arraycopy(this.tempData, i6, this.processData, 0, i7);
                            byte[] bArr4 = this.processData;
                            if (bArr4 instanceof byte[]) {
                                protocolControl(bArr4);
                                this.dataIndex = this.dataIndex + 16 + O000000o2;
                                z = true;
                                continue;
                            }
                        }
                    } else {
                        continue;
                    }
                }
            }
            z = false;
            continue;
        } while (z);
    }

    /* access modifiers changed from: protected */
    public int searchHead(byte[] bArr, int i, int i2) {
        while (i < i2 - 2) {
            if (bArr[i] == 72 && bArr[i + 1] == 76) {
                return i;
            }
            i++;
        }
        return -1;
    }

    private void protocolControl(byte[] bArr) {
        dvr O000000o2 = dvr.O000000o(bArr);
        if (O000000o2 == null) {
            civ.O00000o0("CommandTreatment ", "protocolControl receive command is null");
            return;
        }
        civ.O00000Oo("CommandTreatment ", "protocolControl receive command " + O000000o2.O00000oO);
        switch (O000000o2.O00000oO) {
            case 10003:
                civ.O000000o("CommandTreatment ", "protocolControl command 10003:" + dvp.O000000o(O000000o2.O00000oo));
                return;
            case 10011:
                if (O000000o2.O00000oo != null && O000000o2.O00000oo.length >= 2) {
                    gsy.O000000o(3, "Tutk", "speek通道=" + ((int) O000000o2.O00000oo[0]) + ",结果=" + ((int) O000000o2.O00000oo[1]));
                    this.handler.obtainMessage(210013, O000000o2.O00000oo).sendToTarget();
                    return;
                }
                return;
            case 10051:
                if (O000000o2.O00000oo != null && O000000o2.O00000oo.length >= 6) {
                    this.handler.obtainMessage(21003, O000000o2.O00000oo).sendToTarget();
                    return;
                }
                return;
            case 10135:
                if (O000000o2.O00000oo != null && O000000o2.O00000oo.length > 0) {
                    ArrayList arrayList = new ArrayList();
                    byte b = O000000o2.O00000oo[0];
                    if (b != 0) {
                        int i = 0;
                        for (int i2 = 0; i2 < b; i2++) {
                            int i3 = i + 1;
                            int O00000Oo = dvp.O00000Oo(O000000o2.O00000oo, i3);
                            int i4 = i3 + 4;
                            byte b2 = O000000o2.O00000oo[i4];
                            i = i4 + 1;
                            byte b3 = O000000o2.O00000oo[i];
                            gsy.O00000Oo("AlbumActivity", "fileStatue ==".concat(String.valueOf((int) b3)));
                            gsy.O00000Oo("AlbumActivity", "timelapseStatue ==".concat(String.valueOf((int) b2)));
                            if (O00000Oo == 0 || b2 != 3) {
                                gsy.O000000o(4, "CommandTreatment ", "===================固件返回值error===timelapseStatue=".concat(String.valueOf((int) b2)));
                            } else {
                                TimelapseTask timelapseTask = new TimelapseTask(O00000Oo, b2, b3, cin.O00000o0());
                                timelapseTask.setTimelapseSaveType(1);
                                gsy.O00000Oo("AlbumActivity", "10135 tt status =" + timelapseTask.status);
                                arrayList.add(timelapseTask);
                                gsy.O000000o(3, "CommandTreatment ", "=============timelapseStatue=====".concat(String.valueOf((int) b2)));
                            }
                        }
                    }
                    this.handler.obtainMessage(21006, arrayList).sendToTarget();
                    return;
                }
                return;
            case 10137:
                if (O000000o2.O00000oo != null && O000000o2.O00000oo.length >= 3) {
                    this.handler.obtainMessage(21010, O000000o2.O00000oo).sendToTarget();
                    return;
                }
                return;
            case 10139:
                if (O000000o2.O00000oo != null && O000000o2.O00000oo.length > 0) {
                    this.handler.obtainMessage(210011, O000000o2.O00000oo).sendToTarget();
                    return;
                }
                return;
            case 10143:
                if (O000000o2.O00000oo != null && O000000o2.O00000oo.length > 0) {
                    gsy.O000000o(4, "CommandTreatment ", "====================res.getData()=" + ((int) O000000o2.O00000oo[0]));
                    this.handler.obtainMessage(21007, O000000o2.O00000oo[0], -1).sendToTarget();
                    return;
                }
                return;
            case 10531:
                if (O000000o2.O00000oo != null && O000000o2.O00000oo.length > 0) {
                    gsy.O000000o(4, "CommandTreatment ", "====================res.getData()=" + ((int) O000000o2.O00000oo[0]));
                    this.handler.obtainMessage(21008, O000000o2.O00000oo[0], -1).sendToTarget();
                    return;
                }
                return;
            case 10533:
                if (O000000o2.O00000oo != null && O000000o2.O00000oo.length >= 3) {
                    this.handler.obtainMessage(21009, O000000o2.O00000oo).sendToTarget();
                    return;
                }
                return;
            case 10535:
                if (O000000o2.O00000oo != null && O000000o2.O00000oo.length > 0) {
                    this.handler.obtainMessage(210010, O000000o2.O00000oo).sendToTarget();
                    return;
                }
                return;
            case 10537:
                if (O000000o2.O00000oo != null && O000000o2.O00000oo.length > 0) {
                    this.handler.obtainMessage(210014, O000000o2.O00000oo).sendToTarget();
                    return;
                }
                return;
            case 10541:
                if (O000000o2.O00000oo != null && O000000o2.O00000oo.length > 0) {
                    this.handler.obtainMessage(210012, O000000o2.O00000oo).sendToTarget();
                    return;
                }
                return;
            case 11081:
                if (O000000o2.O00000oo != null && O000000o2.O00000oo.length >= 20) {
                    gsy.O00000Oo(TimeLapsePhotographyActivity.TAG, "res.getData().length=" + O000000o2.O00000oo.length);
                    this.handler.obtainMessage(21005, 1, -1, O000000o2.O00000oo).sendToTarget();
                    return;
                }
                return;
            case 11083:
                if (O000000o2.O00000oo != null && O000000o2.O00000oo.length >= 5) {
                    int O00000Oo2 = dvp.O00000Oo(O000000o2.O00000oo, 0);
                    gsy.O000000o(4, "CommandTreatment ", "protocolControl command 11083 SET_TIMELAPSE_RESULT num:[" + O00000Oo2 + "]res.getData4[" + ((int) O000000o2.O00000oo[4]));
                    this.handler.obtainMessage(21004, O00000Oo2, O000000o2.O00000oo[4]).sendToTarget();
                    return;
                }
                return;
            default:
                return;
        }
    }
}

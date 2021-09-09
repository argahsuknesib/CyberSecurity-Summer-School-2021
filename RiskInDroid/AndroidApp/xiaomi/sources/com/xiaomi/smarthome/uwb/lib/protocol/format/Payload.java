package com.xiaomi.smarthome.uwb.lib.protocol.format;

import com.xiaomi.idm.uwb.IDMUwb;
import com.xiaomi.idm.uwb.constant.UwbConst;
import com.xiaomi.smarthome.uwb.lib.utils.UwbLogUtil;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class Payload {
    UwbConst.AppId appId;
    byte[] data;
    UwbConst.Target target;
    Type type;

    private static boolean checkValidity(byte[] bArr) {
        return true;
    }

    public Payload(UwbConst.AppId appId2, Type type2, byte[] bArr, UwbConst.Target target2) {
        this.appId = appId2;
        this.type = type2;
        this.data = bArr;
        this.target = target2;
    }

    public byte[] toIdmPayloadBytes() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            this.type.toByte(byteArrayOutputStream);
            if (this.data != null && this.data.length > 0) {
                byteArrayOutputStream.write(this.data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }

    public byte[] toBytes() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            if (this.data != null && this.data.length > 0) {
                byteArrayOutputStream.write(this.data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }

    public UwbConst.AppId getIdmAppId() {
        return this.appId;
    }

    public static Payload parse(byte[] bArr) {
        UwbConst.AppId appId2;
        byte[] bArr2 = null;
        if (bArr == null || bArr.length < 3) {
            StringBuilder sb = new StringBuilder("payload length invalid:");
            sb.append(bArr == null ? null : Integer.valueOf(bArr.length));
            UwbLogUtil.e("Mijia-UWB-Payload", sb.toString());
            return null;
        } else if (!checkValidity(bArr)) {
            UwbLogUtil.e("Mijia-UWB-Payload", "payload invalid:" + Arrays.toString(bArr));
            return null;
        } else if (Type.fromInteger(bArr[2]) == null) {
            UwbLogUtil.e("Mijia-UWB-Payload", "payload type invalid:" + ((int) bArr[2]));
            return null;
        } else {
            try {
                appId2 = UwbConst.AppId.valueOf(String.valueOf(String.valueOf((int) bArr[2])));
            } catch (Exception unused) {
                appId2 = UwbConst.AppId.TAG;
            }
            Type fromInteger = Type.fromInteger(bArr[3]);
            if (bArr.length > 3) {
                bArr2 = Arrays.copyOfRange(bArr, 3, bArr.length);
            }
            return new Payload(appId2, fromInteger, bArr2, UwbConst.Target.DATA_FROM_BOUND_DEVICE);
        }
    }

    public static Payload parse(IDMUwb.Payload payload) {
        UwbConst.AppId appId2;
        byte[] bArr = null;
        if (payload == null || payload.getPayload() == null || payload.getPayload().length <= 0) {
            UwbLogUtil.e("Mijia-UWB-Payload", "payload is not valid, return");
            return null;
        }
        byte[] payload2 = payload.getPayload();
        Type fromInteger = Type.fromInteger(payload2[0]);
        if (fromInteger == null) {
            UwbLogUtil.e("Mijia-UWB-Payload", "payload type invalid:" + ((int) payload.getPayload()[0]));
            return null;
        }
        try {
            appId2 = UwbConst.AppId.valueOf(String.valueOf((int) payload.getSrcId()));
        } catch (Exception unused) {
            appId2 = UwbConst.AppId.TAG;
        }
        if (payload.getPayload().length > 1) {
            bArr = Arrays.copyOfRange(payload2, 1, payload2.length);
        }
        return new Payload(appId2, fromInteger, bArr, UwbConst.Target.DATA_FROM_BOUND_DEVICE);
    }

    public Type getType() {
        return this.type;
    }

    public void setType(Type type2) {
        this.type = type2;
    }

    public byte[] getData() {
        return this.data;
    }

    public void setData(byte[] bArr) {
        this.data = bArr;
    }

    public UwbConst.Target getTarget() {
        return this.target;
    }

    public String toString() {
        return "Payload{appId=" + this.appId + ", type=" + this.type + ", data=" + Arrays.toString(this.data) + ", target=" + this.target + '}';
    }
}

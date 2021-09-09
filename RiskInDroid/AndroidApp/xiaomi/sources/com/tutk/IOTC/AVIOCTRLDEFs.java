package com.tutk.IOTC;

public class AVIOCTRLDEFs {

    public static class SMsgAVIoctrlDeviceInfoReq {
        static byte[] reserved = new byte[4];

        public static byte[] parseContent() {
            return reserved;
        }
    }

    public static class SMsgAVToctrlGetRecordListReq {
        public static byte[] parseContent(int i, int i2) {
            byte[] bArr = new byte[8];
            System.arraycopy(Packet.intToByteArray_Little(i), 0, bArr, 0, 4);
            System.arraycopy(Packet.intToByteArray_Little(i2), 0, bArr, 4, 4);
            return bArr;
        }
    }

    public static class SFrameInfo {
        byte cam_index;
        short codec_id;
        byte flags;
        byte onlineNum;
        byte[] reserved = new byte[3];
        int reserved2;
        int timestamp;

        public static byte[] parseContent(short s, byte b, byte b2, byte b3, int i, int i2) {
            byte[] bArr = new byte[16];
            System.arraycopy(Packet.shortToByteArray_Little(s), 0, bArr, 0, 2);
            bArr[2] = b;
            bArr[3] = b2;
            bArr[4] = b3;
            System.arraycopy(Packet.intToByteArray_Little(i), 0, bArr, 6, 4);
            System.arraycopy(Packet.intToByteArray_Little(i2), 0, bArr, 12, 4);
            return bArr;
        }
    }

    public static class SMsgAVIoctrlAVStream {
        int channel = 0;
        byte[] reserved = new byte[4];

        public static byte[] parseContent(int i) {
            byte[] bArr = new byte[8];
            System.arraycopy(Packet.intToByteArray_Little(i), 0, bArr, 0, 4);
            return bArr;
        }
    }

    public static class SMsgAVIoctrlSetStreamCtrlReq {
        int channel;
        byte quality;
        byte[] reserved = new byte[3];

        public static byte[] parseContent(int i, byte b) {
            byte[] bArr = new byte[8];
            System.arraycopy(Packet.intToByteArray_Little(i), 0, bArr, 0, 4);
            bArr[4] = b;
            return bArr;
        }
    }
}

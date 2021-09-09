package com.tutk.IOTC;

import java.io.PrintStream;

public class RDTAPIs {
    public static int ms_verRDTApis = 0;

    public static native int RDT_Abort(int i);

    public static native int RDT_Create(int i, int i2, int i3);

    public static native int RDT_Create_Exit(int i, int i2);

    public static native int RDT_DeInitialize();

    public static native int RDT_Destroy(int i);

    public static native int RDT_Flush(int i);

    @Deprecated
    public static native int RDT_GetRDTApiVer();

    public static native String RDT_GetRDTApiVersionString();

    public static native int RDT_Initialize();

    public static native int RDT_Read(int i, byte[] bArr, int i2, int i3);

    public static native void RDT_Set_Log_Path(String str, int i);

    public static native int RDT_Set_MaxPacketDataSize(int i);

    public static native void RDT_Set_Max_Channel_Number(int i);

    public static native int RDT_Set_Max_Pending_ACK_Number(int i, int i2);

    public static native int RDT_Set_Max_SendBuffer_Size(int i, int i2);

    public static native int RDT_Status_Check(int i, St_RDT_Status st_RDT_Status);

    public static native int RDT_Write(int i, byte[] bArr, int i2);

    static {
        System.loadLibrary("RDTAPIs");
        try {
            System.loadLibrary("RDTAPIs");
        } catch (UnsatisfiedLinkError e) {
            PrintStream printStream = System.out;
            printStream.println("loadLibrary(RDTAPIs)," + e.getMessage());
        }
    }
}

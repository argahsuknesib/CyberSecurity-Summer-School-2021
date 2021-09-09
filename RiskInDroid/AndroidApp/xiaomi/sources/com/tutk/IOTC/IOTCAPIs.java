package com.tutk.IOTC;

import java.io.PrintStream;

public class IOTCAPIs {
    private OnLineResultCBListener mListener;

    @Deprecated
    public static native int IOTC_Check_Device_On_Line(String str, int i, byte[] bArr, Object obj);

    public static native int IOTC_Check_Device_OnlineEx(String str, St_IOTCCheckDeviceInput st_IOTCCheckDeviceInput, St_IOTCCheckDeviceOutput st_IOTCCheckDeviceOutput, int i, int[] iArr);

    @Deprecated
    public static native int IOTC_Connect_ByUID(String str);

    public static native int IOTC_Connect_ByUID2(String str, String str2, int i);

    public static native int IOTC_Connect_ByUIDEx(String str, int i, St_IOTCConnectInput st_IOTCConnectInput);

    public static native int IOTC_Connect_ByUID_Parallel(String str, int i);

    public static native void IOTC_Connect_Stop();

    public static native int IOTC_Connect_Stop_BySID(int i);

    public static native int IOTC_DeInitialize();

    public static native int IOTC_DebugTool_Initialize(String str);

    public static native int IOTC_Device_Login(String str, String str2, String str3);

    public static native int IOTC_Device_LoginEx(String str, St_DeviceLoginInput st_DeviceLoginInput);

    public static native int IOTC_Device_Update_Authkey(String str);

    public static native int IOTC_Get_DebugTool_Info(String str, String str2, String[] strArr, int i);

    public static native int IOTC_Get_Login_Info(int[] iArr);

    public static native void IOTC_Get_Login_Info_ByCallBackFn(Object obj);

    public static native int IOTC_Get_Nat_Type();

    public static native int IOTC_Get_SessionID();

    @Deprecated
    public static native void IOTC_Get_Version(int[] iArr);

    public static native String IOTC_Get_Version_String();

    public static native int IOTC_GlobalLock_Lock();

    public static native int IOTC_GlobalLock_Unlock();

    @Deprecated
    public static native int IOTC_Initialize(int i, String str, String str2, String str3, String str4);

    public static native int IOTC_Initialize2(int i);

    public static native int IOTC_IsDeviceSecureMode(int i);

    @Deprecated
    public static native st_LanSearchInfo[] IOTC_Lan_Search(int[] iArr, int i);

    @Deprecated
    public static native st_LanSearchInfo2[] IOTC_Lan_Search2(int[] iArr, int i);

    @Deprecated
    public static native st_LanSearchInfo2[] IOTC_Lan_Search2_Ex(int[] iArr, int i, int i2);

    public static native int IOTC_Listen(int i);

    public static native int IOTC_Listen2(int i, String str, int i2);

    public static native void IOTC_Listen_Exit();

    public static native int IOTC_ReInitSocket(int i);

    public static native st_SearchDeviceInfo[] IOTC_Search_Device_Result(int[] iArr, int i);

    public static native int IOTC_Search_Device_Start(int i, int i2);

    public static native int IOTC_Search_Device_Stop();

    public static native int IOTC_Sessioin_Channel_Check_ON_OFF(int i, int i2);

    public static native int IOTC_Session_Channel_OFF(int i, int i2);

    public static native int IOTC_Session_Channel_ON(int i, int i2);

    @Deprecated
    public static native int IOTC_Session_Check(int i, St_SInfo st_SInfo);

    @Deprecated
    public static native int IOTC_Session_Check_ByCallBackFn(int i, Object obj);

    public static native int IOTC_Session_Check_Ex(int i, St_SInfoEx st_SInfoEx);

    public static native void IOTC_Session_Close(int i);

    public static native int IOTC_Session_Get_Free_Channel(int i);

    public static native int IOTC_Session_Read(int i, byte[] bArr, int i2, int i3, int i4);

    @Deprecated
    public static native int IOTC_Session_Read_Check_Lost(int i, byte[] bArr, int i2, int i3, int[] iArr, int[] iArr2, int i4);

    public static native int IOTC_Session_Write(int i, byte[] bArr, int i2, int i3);

    public static native int IOTC_Set_Connection_Option(st_ConnectOption st_connectoption);

    public static native void IOTC_Set_Device_Name(String str);

    public static native int IOTC_Set_LanSearchPort(int i);

    public static native int IOTC_Set_Log_Attr(St_LogAttr st_LogAttr);

    @Deprecated
    public static native void IOTC_Set_Log_Path(String str, int i);

    @Deprecated
    public static native int IOTC_Set_Master_Region(Region region);

    public static native void IOTC_Set_Max_Session_Number(int i);

    public static native int IOTC_Set_Partial_Encryption(int i, int i2);

    public static native void IOTC_Setup_LANConnection_Timeout(int i);

    public static native void IOTC_Setup_P2PConnection_Timeout(int i);

    public static native void IOTC_Setup_Session_Alive_Timeout(int i);

    public static native void IOTC_TCPRelayOnly_TurnOn();

    public static native void IOTC_WakeUp_Setup_Auto_WakeUp(int i);

    public static native int IOTC_WakeUp_WakeDevice(String str);

    static {
        System.loadLibrary("IOTCAPIs");
        try {
            System.loadLibrary("IOTCAPIs");
        } catch (UnsatisfiedLinkError e) {
            PrintStream printStream = System.out;
            printStream.println("loadLibrary(IOTCAPIsT)," + e.getMessage());
        }
    }

    public void setOnLineResultCBListener(OnLineResultCBListener onLineResultCBListener) {
        this.mListener = onLineResultCBListener;
    }

    public void onLineResultCB(int i, byte[] bArr) {
        PrintStream printStream = System.out;
        printStream.println("[parent] onLineResult Callback, result=" + i + " UID=" + new String(bArr));
        OnLineResultCBListener onLineResultCBListener = this.mListener;
        if (onLineResultCBListener != null) {
            onLineResultCBListener.onLineResultCB(i, bArr);
        }
    }

    public void loginInfoCB(int i) {
        System.out.println("[parent] LoginInfo Callback, nLogInfo=".concat(String.valueOf(i)));
    }

    public void sessionStatusCB(int i, int i2) {
        PrintStream printStream = System.out;
        printStream.println("[parent] SessionStatus Callback, nSID=" + i + ", nErrCode=" + i2);
    }

    public void ConnectModeChangeCB(int i, int i2) {
        PrintStream printStream = System.out;
        printStream.println("[parent] ConnectModeChangeCB Callback, nSID = " + i + ", nConnMode = " + i2);
    }
}

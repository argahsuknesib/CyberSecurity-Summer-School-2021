package com.tutk.IOTC;

import java.io.PrintStream;

public class TUTKGlobalAPIs {
    public static native int TUTK_SDK_Set_License_Key(String str);

    public static native int TUTK_Set_Log_Attr(St_LogAttr st_LogAttr);

    public static native int TUTK_Set_Region(Region region);

    static {
        try {
            System.loadLibrary("TUTKGlobalAPIs");
        } catch (UnsatisfiedLinkError e) {
            PrintStream printStream = System.out;
            printStream.println("loadLibrary(TUTKGlobalAPIs)" + e.getMessage());
        }
    }
}

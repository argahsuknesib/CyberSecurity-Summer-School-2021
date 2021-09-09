package com.tutk.IOTC;

import java.io.PrintStream;
import java.util.ArrayList;

public class AVAPIs {

    public interface avAbilityRequestFn {
        void ability_request(int i, String[] strArr);
    }

    public interface avChangePasswordRequestFn {
        int change_password_request(int i, String str, String str2, String str3, String str4);
    }

    public interface avIdentityArrayRequestFn {
        void identity_array_request(int i, ArrayList<St_AvIdentity> arrayList, int[] iArr);
    }

    public interface avJsonCtrlRequestFn {
        void json_request(int i, String str, String str2, String[] strArr);
    }

    public interface avPasswordAuthFn {
        int password_auth(String str, String[] strArr);
    }

    public interface avTokenAuthFn {
        int token_auth(String str, String[] strArr);
    }

    public interface avTokenDeleteFn {
        int token_delete(int i, String str);
    }

    public interface avTokenRequestFn {
        int token_request(int i, String str, String str2, String[] strArr);
    }

    public interface avVSaaSConfigChangedFn {
        void on_config_changed(String str);
    }

    public interface avVSaaSUpdateContractInfoFn {
        void on_update_contract(VSaaSContractInfo vSaaSContractInfo);
    }

    public static native int AV_Set_Log_Attr(St_LogAttr st_LogAttr);

    @Deprecated
    public static native void AV_Set_Log_Path(String str, int i);

    public static native int avCheckAudioBuf(int i);

    public static native int avClientCleanAudioBuf(int i);

    public static native int avClientCleanBuf(int i);

    public static native int avClientCleanLocalBuf(int i);

    public static native int avClientCleanLocalVideoBuf(int i);

    public static native int avClientCleanVideoBuf(int i);

    public static native int avClientCleanVideoBufNB(int i);

    public static native int avClientDeleteIdentity(int i, String str, int i2, int[] iArr, int i3);

    public static native void avClientExit(int i, int i2);

    public static native float avClientRecvBufUsageRate(int i);

    public static native int avClientRequestChangeServerPassword(int i, String str, String str2, String str3, String[] strArr, int[] iArr, int i2);

    public static native int avClientRequestIdentityArray(int i, ArrayList<St_AvIdentity>[] arrayListArr, int[] iArr, int[] iArr2, int i2);

    public static native int avClientRequestServerAbility(int i, String[] strArr, int i2);

    public static native int avClientRequestTokenWithIdentity(int i, String str, String str2, String[] strArr, int[] iArr, int i2);

    @Deprecated
    public static native void avClientSetMaxBufSize(int i);

    public static native int avClientSetRecvBufMaxSize(int i, int i2);

    @Deprecated
    public static native int avClientStart(int i, String str, String str2, int i2, int[] iArr, int i3);

    @Deprecated
    public static native int avClientStart2(int i, String str, String str2, int i2, int[] iArr, int i3, int[] iArr2);

    public static native int avClientStartEx(St_AVClientStartInConfig st_AVClientStartInConfig, St_AVClientStartOutConfig st_AVClientStartOutConfig);

    public static native void avClientStop(int i);

    public static native int avDeInitialize();

    public static native int avEnableVSaaS(String str, String str2, avVSaaSConfigChangedFn avvsaasconfigchangedfn, avVSaaSUpdateContractInfoFn avvsaasupdatecontractinfofn);

    @Deprecated
    public static native int avGetAVApiVer();

    public static native String avGetAVApiVersionString();

    public static native int avInitialize(int i);

    public static native int avRecvAudioData(int i, byte[] bArr, int i2, byte[] bArr2, int i3, int[] iArr);

    public static native int[] avRecvAudioData2(int i, byte[] bArr, int i2, byte[] bArr2, int i3, int[] iArr, byte[] bArr3, String str, boolean z);

    public static native int avRecvFrameData2(int i, byte[] bArr, int i2, int[] iArr, int[] iArr2, byte[] bArr2, int i3, int[] iArr3, int[] iArr4);

    public static native int[] avRecvFrameData3(int i, byte[] bArr, int i2, int[] iArr, int[] iArr2, byte[] bArr2, int i3, int[] iArr3, int[] iArr4, byte[] bArr3, String str, boolean z, boolean z2, int i4);

    public static native int avRecvIOCtrl(int i, int[] iArr, byte[] bArr, int i2, int i3);

    public static native float avResendBufUsageRate(int i);

    public static native int avSendAudioData(int i, byte[] bArr, int i2, byte[] bArr2, int i3);

    public static native int avSendFrameData(int i, byte[] bArr, int i2, byte[] bArr2, int i3);

    public static native int avSendIOCtrl(int i, int i2, byte[] bArr, int i3);

    public static native int avSendIOCtrlExit(int i);

    public static native int avSendJSONCtrlRequest(int i, String str, String[] strArr, int i2);

    public static native void avServExit(int i, int i2);

    public static native int avServGetVSaasContractInfo(VSaaSContractInfo vSaaSContractInfo, int i);

    public static native int avServNotifyVSaasPullStream(VSaaSPullStreamAttr vSaaSPullStreamAttr, int i);

    public static native int avServResetBuffer(int i, int i2, int i3);

    public static native int avServSetDelayInterval(int i, int i2, int i3);

    public static native void avServSetResendSize(int i, int i2);

    @Deprecated
    public static native int avServStart2(int i, String str, String str2, int i2, int i3, int i4);

    @Deprecated
    public static native int avServStart3(int i, String str, String str2, int i2, int i3, int i4, int[] iArr);

    public static native int avServStartEx(St_AVServStartInConfig st_AVServStartInConfig, St_AVServStartOutConfig st_AVServStartOutConfig);

    public static native void avServStop(int i);

    public static native int avStatusCheck(int i, St_AvStatus st_AvStatus);

    static {
        System.loadLibrary("AVAPIs");
        System.loadLibrary("miss");
        try {
            System.loadLibrary("AVAPIs");
        } catch (UnsatisfiedLinkError e) {
            PrintStream printStream = System.out;
            printStream.println("loadLibrary(AVAPIs)," + e.getMessage());
        }
    }

    public static int avClientStart(int i, byte[] bArr, byte[] bArr2, int i2, int[] iArr, int i3) {
        return avClientStart(i, new String(bArr), new String(bArr2), i2, iArr, i3);
    }
}

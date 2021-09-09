package com.xiaomi.smarthome.camera;

public interface IXmStreamClient {
    boolean getAutoAudio();

    boolean getAutoVideo();

    boolean isConnected();

    boolean isConnecting();

    boolean isPaused();

    void markCallStarted(boolean z);

    void release(IClientExListener iClientExListener);

    void sendAudioData(byte[] bArr, int i);

    void sendRdtCmd(byte[] bArr, IMISSListener iMISSListener);

    void setAutoAudio(boolean z);

    void setAutoVideo(boolean z);

    void setClientListener(IClientExListener iClientExListener);

    void setRDTCameraPositionListener(IRDTCameraPositionListener iRDTCameraPositionListener);

    void setRDTListener(IRDTListener iRDTListener);

    void setRDTPanoramaListener(IRDTPanoramaListener iRDTPanoramaListener);

    void setRDTPictureListener(IRDTPictureListener iRDTPictureListener);

    void setRDTTimelineEventListener(IRDTTimelineEventListener iRDTTimelineEventListener);

    void setRDTTimelineListener(IRDTTimelineListener iRDTTimelineListener);

    void setRdtDataListener(IRdtDataListener iRdtDataListener);

    void streamCmdMessage(int i, String str, IMISSListener iMISSListener);

    void streamDirection(int i, IMISSListener iMISSListener);

    void streamGetDeviceInfo(IMISSListener iMISSListener);

    void streamPlayback(String str, IMISSListener iMISSListener);

    void streamPlaybackSpeed(String str, IMISSListener iMISSListener);

    void streamRDTMessage(int i, int i2, byte[] bArr, P2pResponse p2pResponse, IMISSListener iMISSListener);

    void streamResolution(int i, IMISSListener iMISSListener);

    @Deprecated
    void streamSendMessage(int i, int i2, byte[] bArr, P2pResponse p2pResponse, IMISSListener iMISSListener);

    void streamStart(IMISSListener iMISSListener);

    void streamStart(MissConfig missConfig, IMISSListener iMISSListener);

    void streamStart(MissNetworkType missNetworkType, MissConfig missConfig, IMISSListener iMISSListener);

    void streamStartCall(IMISSListener iMISSListener);

    void streamStop(IMISSListener iMISSListener);

    void streamStopCall(IMISSListener iMISSListener);

    void streamToggleAudio(boolean z, IMISSListener iMISSListener);

    void streamToggleRemoteAudio(boolean z, IMISSListener iMISSListener);

    void streamToggleRemoteVideo(boolean z, IMISSListener iMISSListener);

    void updateInfo();
}

package com.xiaomi.mistream;

public interface IStreamHandler {
    boolean isAutoAudio();

    boolean isAutoVideo();

    void on_change_qos();

    void on_command(int i, byte[] bArr);

    void on_connect(int i, String str);

    void on_disconnect(int i, int i2);

    void on_error(int i, String str);

    void on_pause_video();

    void on_progress(int i);

    void on_reconnect();

    void on_start_video(int i, int i2);

    void on_stop_video(int i);

    void receive_audio_data(byte[] bArr, byte[] bArr2);

    void receive_rdt_data(byte[] bArr);

    void receive_video_data(byte[] bArr, byte[] bArr2);
}

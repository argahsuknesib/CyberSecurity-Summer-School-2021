package _m_j;

import com.mijia.generalplayer.gl.PhotoView;
import com.xiaomi.smarthome.camera.VideoFrame;
import com.xiaomi.smarthome.camera.XmMp4Player;

public final class ckf extends cjx {
    private XmMp4Player O00000Oo;

    public final void drawVideoFrame(VideoFrame videoFrame) {
    }

    public final String getDid() {
        return null;
    }

    public final boolean isBufferFull() {
        return false;
    }

    public final boolean isGPUDecoder() {
        return true;
    }

    public final void setDid(String str) {
    }

    public final void setDistort(float f, float f2) {
    }

    public final void setDistort(float f, float f2, float f3) {
    }

    public final void setDistort(int i, int i2) {
    }

    public final void setFps(int i) {
    }

    public final void setHeight(int i) {
    }

    public final void setNeedIFrame() {
    }

    public final void setWidth(int i) {
    }

    public ckf(PhotoView photoView) {
        O000000o(photoView);
    }

    public final void addMp4Player(XmMp4Player xmMp4Player) {
        this.O00000Oo = xmMp4Player;
    }

    public final XmMp4Player getMp4Player() {
        return this.O00000Oo;
    }
}

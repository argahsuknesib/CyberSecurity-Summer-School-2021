package com.xiaomi.smarthome.miio.camera.face.model;

import java.io.Serializable;
import java.util.ArrayList;

public class FaceInfoEx implements Serializable {
    public String coverFaceId;
    public String faceId;
    public ArrayList<String> faceIds = new ArrayList<>();
    public int faceLable = -1;
    public Feature feature;
    public String figureId;
    public String figureInfo;
    public String figureName;
    public boolean matched;
    public boolean selected;
    public long updateTime;

    public String toString() {
        return "FaceInfoEx{faceId='" + this.faceId + '\'' + ", faceIds='" + this.faceIds + '\'' + ", figureId='" + this.figureId + '\'' + ", figureInfo='" + this.figureInfo + '\'' + ", figureName='" + this.figureName + '\'' + ", coverFaceId='" + this.coverFaceId + '\'' + ", selected=" + this.selected + ", feature=" + this.feature + ", matched=" + this.matched + ", updateTime=" + this.updateTime + ", faceLable=" + this.faceLable + '}';
    }
}

package com.xiaomi.smarthome.miio.camera.face.model;

import java.io.Serializable;
import java.util.ArrayList;

public class FaceEventList implements Serializable {
    public String figureName;
    public ArrayList<FaceEvent> thirdPartPlayUnits;
}

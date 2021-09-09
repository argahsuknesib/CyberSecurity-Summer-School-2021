package com.xiaomi.smarthome.miio.camera.face.photopicker;

import java.io.Serializable;
import java.util.List;

public class Folder implements Serializable {
    public Image cover;
    public List<Image> images;
    public String name;
    public String path;

    public boolean equals(Object obj) {
        try {
            return this.path.equalsIgnoreCase(((Folder) obj).path);
        } catch (ClassCastException e) {
            e.printStackTrace();
            return super.equals(obj);
        }
    }
}

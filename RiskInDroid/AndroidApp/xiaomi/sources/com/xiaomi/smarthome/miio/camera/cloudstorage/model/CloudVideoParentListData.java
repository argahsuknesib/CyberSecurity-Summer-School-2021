package com.xiaomi.smarthome.miio.camera.cloudstorage.model;

import java.util.ArrayList;
import java.util.List;

public class CloudVideoParentListData {
    public List<CloudVideoChildListData> childListData = new ArrayList();
    public boolean hasChild;
    public int timeSpan;

    public CloudVideoParentListData(int i) {
        this.timeSpan = i;
    }
}

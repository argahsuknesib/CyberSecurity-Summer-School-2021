package com.xiaomi.mico.music.patchwall.micoselect.model;

import java.util.List;

public class MicoHandpickInfo {
    public List<MicoSelectInfo> appDisplayInfoList;

    public List<MicoSelectInfo> getList() {
        return this.appDisplayInfoList;
    }

    public void setList(List<MicoSelectInfo> list) {
        this.appDisplayInfoList = list;
    }
}

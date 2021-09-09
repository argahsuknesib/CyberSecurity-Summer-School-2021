package com.kookong.app.data;

import java.util.ArrayList;
import java.util.List;

public class IrDataList implements SerializableEx {
    private static final long serialVersionUID = -857251495051586423L;
    protected List<IrData> irDataList = new ArrayList();

    public List<IrData> getIrDataList() {
        return this.irDataList;
    }

    public void setIrDataList(List<IrData> list) {
        this.irDataList = list;
    }
}

package com.kookong.app.data.api;

import com.kookong.app.data.SerializableEx;
import java.util.ArrayList;
import java.util.List;

@Deprecated
public class IrDataList implements SerializableEx {
    private static final long serialVersionUID = 4398007869858149993L;
    protected List<IrData> irDataList = new ArrayList();

    public List<IrData> getIrDataList() {
        return this.irDataList;
    }

    public void setIrDataList(List<IrData> list) {
        this.irDataList = list;
    }
}

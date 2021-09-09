package com.xiaomi.idm.uwb;

import com.xiaomi.idm.uwb.proto.MiCloseRange;
import com.xiaomi.idm.uwb.proto.UwbData;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class IDMUwbDevice {
    public final UwbData.MeasurementData measurementData;
    public final String uwbAddress;

    public IDMUwbDevice(String str, UwbData.MeasurementData measurementData2) {
        this.uwbAddress = str;
        this.measurementData = measurementData2;
    }

    public String toString() {
        return "IDMUwbDevice{uwbAddress='" + this.uwbAddress + '\'' + ", measurementData=" + this.measurementData + '}';
    }

    public static IDMUwbDevice createFromProto(UwbData.MeasurementData measurementData2) {
        return new IDMUwbDevice(measurementData2.getUwbAddress(), measurementData2);
    }

    public static List<IDMUwbDevice> createFromProto(MiCloseRange.OnScanning onScanning) {
        LinkedList linkedList = new LinkedList();
        for (UwbData.MeasurementData createFromProto : onScanning.getMeasurementDataList()) {
            linkedList.add(createFromProto(createFromProto));
        }
        return Collections.unmodifiableList(linkedList);
    }
}

package com.tiqiaa.remote.entity;

import _m_j.bdk;
import com.tiqiaa.common.IJsonable;
import com.tiqiaa.icontrol.util.TiqiaaService;
import com.tiqiaa.local.LocalIrDb;
import java.util.ArrayList;
import java.util.List;

public class IrMatchPageInfo implements IJsonable {
    @bdk(O000000o = "appliance_type")
    int appliance_type;
    @bdk(O000000o = "brand_id")
    long brand_id;
    @bdk(O000000o = "langue")
    int langue;
    @bdk(O000000o = "marks")
    List<IrMatchMark> marks;

    public IrMatchPageInfo() {
    }

    public IrMatchPageInfo(IrMatchParam irMatchParam) {
        IrMatchMark irMatchMark = new IrMatchMark();
        irMatchMark.setKey_type(800);
        irMatchMark.setMark(LocalIrDb.getIrDb(TiqiaaService.getAppContext()).getIRMarkData(irMatchParam.getData(), irMatchParam.getAppliance_type()));
        ArrayList arrayList = new ArrayList();
        arrayList.add(irMatchMark);
        setMarks(arrayList);
        setBrand_id(irMatchParam.getBrand_id());
        setAppliance_type(irMatchParam.getAppliance_type());
    }

    public int getLangue() {
        return this.langue;
    }

    public void setLangue(int i) {
        this.langue = i;
    }

    public long getBrand_id() {
        return this.brand_id;
    }

    public void setBrand_id(long j) {
        this.brand_id = j;
    }

    public List<IrMatchMark> getMarks() {
        return this.marks;
    }

    public void setMarks(List<IrMatchMark> list) {
        this.marks = list;
    }

    public IrMatchPageInfo copy() {
        IrMatchPageInfo irMatchPageInfo = new IrMatchPageInfo();
        irMatchPageInfo.setLangue(this.langue);
        irMatchPageInfo.setBrand_id(this.brand_id);
        irMatchPageInfo.setAppliance_type(this.appliance_type);
        irMatchPageInfo.setMarks(this.marks);
        return irMatchPageInfo;
    }

    public int getAppliance_type() {
        return this.appliance_type;
    }

    public void setAppliance_type(int i) {
        this.appliance_type = i;
    }
}

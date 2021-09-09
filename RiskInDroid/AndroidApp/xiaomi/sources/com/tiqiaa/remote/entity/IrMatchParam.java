package com.tiqiaa.remote.entity;

import com.tiqiaa.common.IJsonable;

public class IrMatchParam implements IJsonable {
    private int appliance_type;
    private long brand_id;
    private byte[] data;

    public long getBrand_id() {
        return this.brand_id;
    }

    public void setBrand_id(long j) {
        this.brand_id = j;
    }

    public int getAppliance_type() {
        return this.appliance_type;
    }

    public void setAppliance_type(int i) {
        this.appliance_type = i;
    }

    public byte[] getData() {
        return this.data;
    }

    public void setData(byte[] bArr) {
        this.data = bArr;
    }
}

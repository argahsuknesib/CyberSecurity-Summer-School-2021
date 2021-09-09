package com.tiqiaa.remote.entity;

import _m_j.bdk;
import _m_j.bdl;
import _m_j.box;
import _m_j.bpa;
import com.imi.fastjson.serializer.SerializerFeature;
import com.tiqiaa.common.IJsonable;

@bpa(O000000o = "tb_infrared")
@bdl(O000000o = {"key_type", "freq", "func", "mark", "ir_mark", "data", "data_str"}, O00000Oo = {"key_id"})
public class Infrared implements IJsonable, Cloneable {
    @bdk(O000000o = "data", O00000oO = {SerializerFeature.BrowserCompatible, SerializerFeature.UseSingleQuotes})
    private byte[] data;
    @bdk(O000000o = "data_str")
    private String data_str;
    @bdk(O000000o = "freq")
    private int freq;
    @bdk(O000000o = "func")
    private int func;
    @box
    @bdk(O000000o = "id")
    long id;
    @bdk(O000000o = "ir_mark")
    int ir_mark;
    @bdk(O000000o = "key_id")
    private long keyId;
    @bdk(O000000o = "key_type")
    private int key_type;
    @bdk(O000000o = "mark")
    int mark;
    @bdk(O000000o = "priority")
    int priority;
    @bdk(O000000o = "quality")
    int quality;

    public long getId() {
        return this.id;
    }

    public void setId(long j) {
        this.id = j;
    }

    public long getKey_id() {
        return this.keyId;
    }

    public void setKey_id(long j) {
        this.keyId = j;
    }

    public int getKey_type() {
        return this.key_type;
    }

    public void setKey_type(int i) {
        this.key_type = i;
    }

    public int getFunc() {
        return this.func;
    }

    public void setFunc(int i) {
        this.func = i;
    }

    public byte[] getData() {
        return this.data;
    }

    public void setData(byte[] bArr) {
        this.data = bArr;
    }

    public int getFreq() {
        return this.freq;
    }

    public void setFreq(int i) {
        this.freq = i;
    }

    public int getMark() {
        return this.mark;
    }

    public void setMark(int i) {
        this.mark = i;
    }

    public int getIr_mark() {
        return this.ir_mark;
    }

    public void setIr_mark(int i) {
        this.ir_mark = i;
    }

    public int getQuality() {
        return this.quality;
    }

    public void setQuality(int i) {
        this.quality = i;
    }

    public int getPriority() {
        return this.priority;
    }

    public void setPriority(int i) {
        this.priority = i;
    }

    public String getData_str() {
        return this.data_str;
    }

    public void setData_Str(String str) {
        this.data_str = str;
    }

    public Infrared clone() {
        Infrared infrared = new Infrared();
        infrared.setFreq(this.freq);
        infrared.setFunc(this.func);
        infrared.setId(this.id);
        infrared.setIr_mark(this.ir_mark);
        infrared.setKey_id(this.keyId);
        infrared.setKey_type(this.key_type);
        infrared.setMark(this.mark);
        byte[] bArr = this.data;
        if (bArr != null && bArr.length > 0) {
            byte[] bArr2 = new byte[bArr.length];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            infrared.setData(bArr2);
        }
        infrared.setData_Str(this.data_str);
        return infrared;
    }
}

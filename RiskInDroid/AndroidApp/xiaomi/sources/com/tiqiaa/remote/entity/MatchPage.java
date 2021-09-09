package com.tiqiaa.remote.entity;

import _m_j.bdk;
import _m_j.bdl;
import com.tiqiaa.common.IJsonable;
import java.util.ArrayList;
import java.util.List;

public class MatchPage implements IJsonable, Cloneable {
    @bdk(O000000o = "appliance_type")
    int appliance_type;
    @bdk(O000000o = "brand_id")
    long brand_id;
    @bdk(O000000o = "failedKeys")
    List<Integer> failedKeys;
    @bdk(O000000o = "lang")
    int lang;
    @bdk(O000000o = "next_key")
    int next_key;
    @bdk(O000000o = "okMarks")
    List<IRMark> okMarks;
    @bdk(O000000o = "wrongMarks")
    List<IRMark> wrongMarks;

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

    public int getNext_key() {
        return this.next_key;
    }

    public void setNext_key(int i) {
        this.next_key = i;
    }

    public int getLang() {
        return this.lang;
    }

    public void setLang(int i) {
        this.lang = i;
    }

    public List<IRMark> getOkMarks() {
        return this.okMarks;
    }

    public void setOkMarks(List<IRMark> list) {
        this.okMarks = list;
    }

    public List<IRMark> getWrongMarks() {
        return this.wrongMarks;
    }

    public void setWrongMarks(List<IRMark> list) {
        this.wrongMarks = list;
    }

    public List<Integer> getFailedKeys() {
        return this.failedKeys;
    }

    public void setFailedKeys(List<Integer> list) {
        this.failedKeys = list;
    }

    @bdl(O000000o = {"key_type", "ir_mark"})
    public static class IRMark implements IJsonable, Cloneable {
        @bdk(O000000o = "ir_mark")
        int ir_mark;
        @bdk(O000000o = "key_type")
        int key_type;

        public int getKey_type() {
            return this.key_type;
        }

        public void setKey_type(int i) {
            this.key_type = i;
        }

        public int getIr_mark() {
            return this.ir_mark;
        }

        public void setIr_mark(int i) {
            this.ir_mark = i;
        }

        /* access modifiers changed from: protected */
        public IRMark clone() {
            IRMark iRMark = new IRMark();
            iRMark.setIr_mark(this.ir_mark);
            iRMark.setKey_type(this.key_type);
            return iRMark;
        }
    }

    public MatchPage clone() {
        MatchPage matchPage = new MatchPage();
        matchPage.setAppliance_type(this.appliance_type);
        matchPage.setBrand_id(this.brand_id);
        matchPage.setLang(this.lang);
        matchPage.setNext_key(this.next_key);
        if (this.okMarks != null) {
            ArrayList arrayList = new ArrayList();
            for (IRMark next : this.okMarks) {
                if (next != null) {
                    arrayList.add(next.clone());
                }
            }
            matchPage.setOkMarks(arrayList);
        }
        if (this.wrongMarks != null) {
            ArrayList arrayList2 = new ArrayList();
            for (IRMark next2 : this.wrongMarks) {
                if (next2 != null) {
                    arrayList2.add(next2.clone());
                }
            }
            matchPage.setWrongMarks(arrayList2);
        }
        if (this.failedKeys != null) {
            ArrayList arrayList3 = new ArrayList();
            for (Integer next3 : this.failedKeys) {
                if (next3 != null) {
                    arrayList3.add(next3);
                }
            }
            matchPage.setFailedKeys(arrayList3);
        }
        return matchPage;
    }
}

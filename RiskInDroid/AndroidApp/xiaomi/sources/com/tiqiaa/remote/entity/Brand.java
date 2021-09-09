package com.tiqiaa.remote.entity;

import _m_j.bdk;
import _m_j.bdl;
import _m_j.boy;
import _m_j.bpa;
import com.tiqiaa.common.IJsonable;

@bpa(O000000o = "tb_brand")
@bdl(O000000o = {"id", "brand_cn", "brand_tw", "brand_en", "brand_other", "pinyin", "py"})
public class Brand implements IJsonable, Cloneable, Comparable<Brand> {
    @bdk(O000000o = "brand_cn")
    private String brand_cn;
    @bdk(O000000o = "brand_en")
    private String brand_en;
    @bdk(O000000o = "brand_other")
    private String brand_other;
    @bdk(O000000o = "brand_tw")
    private String brand_tw;
    @boy
    @bdk(O000000o = "id")
    long id;
    @bdk(O000000o = "pinyin")
    private String pinyin;
    @bdk(O000000o = "py")
    private String py;
    @bdk(O000000o = "remarks")
    private String remarks;

    public static long getBrandIdAll() {
        return 0;
    }

    public static long getBrandIdOther() {
        return -1;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long j) {
        this.id = j;
    }

    public String getBrand_cn() {
        return this.brand_cn;
    }

    public void setBrand_cn(String str) {
        this.brand_cn = str;
    }

    public String getBrand_tw() {
        return this.brand_tw;
    }

    public void setBrand_tw(String str) {
        this.brand_tw = str;
    }

    public String getBrand_en() {
        return this.brand_en;
    }

    public void setBrand_en(String str) {
        this.brand_en = str;
    }

    public String getBrand_other() {
        return this.brand_other;
    }

    public void setBrand_other(String str) {
        this.brand_other = str;
    }

    public String getPinyin() {
        return this.pinyin;
    }

    public void setPinyin(String str) {
        this.pinyin = str;
    }

    public String getPy() {
        return this.py;
    }

    public void setPy(String str) {
        this.py = str;
    }

    public String getRemarks() {
        return this.remarks;
    }

    public void setRemarks(String str) {
        this.remarks = str;
    }

    public Brand clone() {
        Brand brand = new Brand();
        brand.setId(this.id);
        brand.setBrand_cn(this.brand_cn);
        brand.setBrand_tw(this.brand_tw);
        brand.setBrand_en(this.brand_en);
        brand.setBrand_other(this.brand_other);
        brand.setPinyin(this.pinyin);
        brand.setPy(this.py);
        return brand;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Brand) || ((Brand) obj).getId() != this.id) {
            return false;
        }
        return true;
    }

    public int compareTo(Brand brand) {
        String str = this.pinyin;
        if (str == null || str.equals("")) {
            return -1;
        }
        String str2 = brand.pinyin;
        if (str2 == null || str2.equals("")) {
            return 1;
        }
        return this.pinyin.toLowerCase().compareTo(brand.pinyin.toLowerCase());
    }
}

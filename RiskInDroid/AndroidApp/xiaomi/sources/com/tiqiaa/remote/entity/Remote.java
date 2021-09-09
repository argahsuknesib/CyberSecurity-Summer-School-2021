package com.tiqiaa.remote.entity;

import _m_j.bdk;
import _m_j.boy;
import _m_j.bpa;
import com.tiqiaa.common.IJsonable;
import com.tiqiaa.database.DataBaseManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@bpa(O000000o = "tb_remote")
public class Remote implements IJsonable, Cloneable {
    @bdk(O000000o = "app_ver")
    String app_ver;
    @bdk(O000000o = "author")
    User author;
    @bdk(O000000o = "author_id")
    long author_id;
    @bdk(O000000o = "brand")
    Brand brand;
    @bdk(O000000o = "brand_id")
    long brand_id;
    @bdk(O000000o = "create_time")
    Date create_time;
    @bdk(O000000o = "deleted")
    boolean deleted;
    @bdk(O000000o = "diy_device")
    int diy_device;
    @bdk(O000000o = "down_count")
    int down_count;
    @bdk(O000000o = "download_count")
    int download_count;
    @bdk(O000000o = "dpi")
    String dpi;
    @boy
    @bdk(O000000o = "id")
    String id;
    @bdk(O000000o = "keys")
    List<Key> keys;
    @bdk(O000000o = "lang")
    int lang;
    @bdk(O000000o = "layout_id")
    int layout_id;
    @bdk(O000000o = "model")
    String model;
    @bdk(O000000o = "modified_time")
    Date modified_time;
    @bdk(O000000o = "modifier_id")
    long modifier_id;
    @bdk(O000000o = "name")
    String name;
    @bdk(O000000o = "remarks")
    String remarks;
    @bdk(O000000o = "type")
    int type;
    @bdk(O000000o = "type_name")
    String type_name;
    @bdk(O000000o = "up_count")
    int up_count;

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public long getBrand_id() {
        return this.brand_id;
    }

    public void setBrand_id(long j) {
        this.brand_id = j;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String str) {
        this.model = str;
    }

    public long getAuthor_id() {
        return this.author_id;
    }

    public void setAuthor_id(long j) {
        this.author_id = j;
    }

    public String getApp_ver() {
        return this.app_ver;
    }

    public void setApp_ver(String str) {
        this.app_ver = str;
    }

    public int getDiy_device() {
        return this.diy_device;
    }

    public void setDiy_device(int i) {
        this.diy_device = i;
    }

    public int getLang() {
        return this.lang;
    }

    public void setLang(int i) {
        this.lang = i;
    }

    public String getDpi() {
        return this.dpi;
    }

    public void setDpi(String str) {
        this.dpi = str;
    }

    public Date getCreate_time() {
        return this.create_time;
    }

    public void setCreate_time(Date date) {
        this.create_time = date;
    }

    public Date getModified_time() {
        return this.modified_time;
    }

    public void setModified_time(Date date) {
        this.modified_time = date;
    }

    public int getDownload_count() {
        return this.download_count;
    }

    public void setDownload_count(int i) {
        this.download_count = i;
    }

    public int getUp_count() {
        return this.up_count;
    }

    public void setUp_count(int i) {
        this.up_count = i;
    }

    public int getDown_count() {
        return this.down_count;
    }

    public int getLayout_id() {
        return this.layout_id;
    }

    public void setLayout_id(int i) {
        this.layout_id = i;
    }

    public long getModifier_id() {
        return this.modifier_id;
    }

    public void setModifier_id(long j) {
        this.modifier_id = j;
    }

    public boolean isDeleted() {
        return this.deleted;
    }

    public void setDeleted(boolean z) {
        this.deleted = z;
    }

    public void setDown_count(int i) {
        this.down_count = i;
    }

    public String getRemarks() {
        return this.remarks;
    }

    public void setRemarks(String str) {
        this.remarks = str;
    }

    public List<Key> getKeys() {
        return this.keys;
    }

    public void setKeys(List<Key> list) {
        this.keys = list;
    }

    public Brand getBrand() {
        if (this.brand == null) {
            this.brand = DataBaseManager.getInstance().getBrandById(this.brand_id);
        }
        return this.brand;
    }

    public void setBrand(Brand brand2) {
        this.brand = brand2;
    }

    public String getType_name() {
        return this.type_name;
    }

    public void setType_name(String str) {
        this.type_name = str;
    }

    public User getAuthor() {
        return this.author;
    }

    public void setAuthor(User user) {
        this.author = user;
    }

    public Remote clone() {
        Remote remote = new Remote();
        remote.setBrand(this.brand.clone());
        remote.setBrand_id(this.brand_id);
        remote.setId(this.id);
        List<Key> list = this.keys;
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (Key clone : this.keys) {
                arrayList.add(clone.clone());
            }
            remote.setKeys(arrayList);
        }
        remote.setModel(this.model);
        remote.setName(this.name);
        remote.setType(this.type);
        remote.setDiy_device(this.diy_device);
        remote.setDeleted(this.deleted);
        remote.setDown_count(this.down_count);
        remote.setUp_count(this.up_count);
        remote.setDownload_count(this.download_count);
        remote.setDpi(this.dpi);
        remote.setLang(this.lang);
        remote.setLayout_id(this.layout_id);
        remote.setModified_time(this.modified_time);
        remote.setCreate_time(this.create_time);
        remote.setModifier_id(this.modifier_id);
        remote.setRemarks(this.remarks);
        return remote;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Remote)) {
            return false;
        }
        return this.id.equals(((Remote) obj).getId());
    }
}

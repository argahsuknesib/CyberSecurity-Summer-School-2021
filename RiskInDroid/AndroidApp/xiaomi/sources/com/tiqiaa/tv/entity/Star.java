package com.tiqiaa.tv.entity;

import _m_j.bdk;
import com.tiqiaa.common.IJsonable;

public class Star implements IJsonable {
    @bdk(O000000o = "birthday")
    String birthday;
    @bdk(O000000o = "file")
    String file;
    @bdk(O000000o = "id")
    int id;
    @bdk(O000000o = "name")
    String name;
    @bdk(O000000o = "photo")
    String photo;
    @bdk(O000000o = "sex")
    String sex;

    public int getId() {
        return this.id;
    }

    public void setId(int i) {
        this.id = i;
    }

    public String getName() {
        if (this.name == null) {
            this.name = "";
        }
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getFile() {
        if (this.file == null) {
            this.file = "";
        }
        return this.file;
    }

    public void setFile(String str) {
        this.file = str;
    }

    public String getPhoto() {
        if (this.photo == null) {
            this.photo = "";
        }
        return this.photo;
    }

    public void setPhoto(String str) {
        this.photo = str;
    }

    public String getSex() {
        if (this.sex == null) {
            this.sex = "";
        }
        return this.sex;
    }

    public void setSex(String str) {
        this.sex = str;
    }

    public String getBirthday() {
        if (this.birthday == null) {
            this.birthday = "";
        }
        return this.birthday;
    }

    public void setBirthday(String str) {
        this.birthday = str;
    }
}

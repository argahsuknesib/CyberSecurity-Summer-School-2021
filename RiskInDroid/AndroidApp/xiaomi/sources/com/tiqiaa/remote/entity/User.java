package com.tiqiaa.remote.entity;

import _m_j.bdk;
import com.tiqiaa.common.IJsonable;
import java.util.Date;

public class User implements IJsonable {
    @bdk(O000000o = "birthday")
    Date birthday;
    @bdk(O000000o = "email")
    String email;
    @bdk(O000000o = "id")
    long id;
    @bdk(O000000o = "name")
    String name;
    @bdk(O000000o = "new_pw")
    String new_pw;
    @bdk(O000000o = "password")
    String password;
    @bdk(O000000o = "phone")
    String phone;
    @bdk(O000000o = "sex")
    int sex;
    @bdk(O000000o = "tmp_pw")
    int tmp_pw;

    public long getId() {
        return this.id;
    }

    public void setId(long j) {
        this.id = j;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String str) {
        this.phone = str;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String str) {
        this.password = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public Date getBirthday() {
        return this.birthday;
    }

    public void setBirthday(Date date) {
        this.birthday = date;
    }

    public int getSex() {
        return this.sex;
    }

    public void setSex(int i) {
        this.sex = i;
    }

    public String getNew_pw() {
        return this.new_pw;
    }

    public void setNew_pw(String str) {
        this.new_pw = str;
    }

    public int getTmp_pw() {
        return this.tmp_pw;
    }

    public void setTmp_pw(int i) {
        this.tmp_pw = i;
    }
}

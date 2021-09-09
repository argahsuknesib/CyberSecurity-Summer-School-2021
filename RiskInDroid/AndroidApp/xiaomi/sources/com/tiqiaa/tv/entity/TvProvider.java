package com.tiqiaa.tv.entity;

import _m_j.bdk;
import _m_j.box;
import _m_j.boy;
import _m_j.bpa;
import com.tiqiaa.common.IJsonable;
import com.tiqiaa.icontrol.util.LanguageUtils;

@bpa(O000000o = "tb_tv_provider")
public class TvProvider implements IJsonable {
    @bdk(O000000o = "custom")
    boolean custom;
    @boy
    @box
    @bdk(O000000o = "id")
    int id;
    @bdk(O000000o = "name")
    String name;

    public int getId() {
        return this.id;
    }

    public void setId(int i) {
        this.id = i;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public boolean isCustom() {
        return this.custom;
    }

    public void setCustom(boolean z) {
        this.custom = z;
    }

    public static TvProvider createEmptyProvider() {
        TvProvider tvProvider = new TvProvider();
        tvProvider.setId(16777215);
        if (LanguageUtils.getLang() == 0) {
            tvProvider.setName("自定义");
        } else {
            tvProvider.setName("Custom Provider");
        }
        return tvProvider;
    }

    public static TvProvider createOttProvider() {
        TvProvider tvProvider = new TvProvider();
        tvProvider.setId(15658734);
        if (LanguageUtils.getLang() == 0) {
            tvProvider.setName("OTT盒子");
        } else {
            tvProvider.setName("OTT Box");
        }
        return tvProvider;
    }
}

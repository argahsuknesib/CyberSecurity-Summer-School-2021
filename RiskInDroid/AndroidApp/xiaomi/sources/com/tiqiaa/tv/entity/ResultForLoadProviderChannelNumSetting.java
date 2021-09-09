package com.tiqiaa.tv.entity;

import _m_j.bdk;
import com.tiqiaa.common.IJsonable;
import java.util.List;

public class ResultForLoadProviderChannelNumSetting implements IJsonable {
    @bdk(O000000o = "nums")
    List<ChannelNum> nums;
    @bdk(O000000o = "reset_provider")
    TvProvider reset_provider;

    public TvProvider getReset_provider() {
        return this.reset_provider;
    }

    public void setReset_provider(TvProvider tvProvider) {
        this.reset_provider = tvProvider;
    }

    public List<ChannelNum> getNums() {
        return this.nums;
    }

    public void setNums(List<ChannelNum> list) {
        this.nums = list;
    }
}
